package tf;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes5.dex */
public class d extends c {

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList f76326a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f76327b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static HashMap f76328c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static boolean f76329d = ShareTinkerInternals.isVmArt();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements TinkerDexOptimizer.ResultCallback {

        /* renamed from: a, reason: collision with root package name */
        long f76330a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean[] f76331b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f76332c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Throwable[] f76333d;

        a(boolean[] zArr, List list, Throwable[] thArr) {
            this.f76331b = zArr;
            this.f76332c = list;
            this.f76333d = thArr;
        }

        @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
        public void onFailed(File file, File file2, Throwable th2) {
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", file.getPath(), Long.valueOf(System.currentTimeMillis() - this.f76330a));
            this.f76332c.add(file);
            this.f76333d[0] = th2;
        }

        @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
        public void onStart(File file, File file2) {
            this.f76330a = System.currentTimeMillis();
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", file.getPath(), Long.valueOf(file.length()));
        }

        @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
        public void onSuccess(File file, File file2, File file3) {
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", file.getPath(), file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - this.f76330a));
            if (file3.exists()) {
                return;
            }
            synchronized (this.f76331b) {
                this.f76331b[0] = true;
            }
        }
    }

    private static boolean c(ArrayList arrayList, int i11) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!SharePatchFileUtil.isLegalFile(file) && !SharePatchFileUtil.shouldAcceptEvenIfIllegal(file)) {
                ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", file.getName(), Integer.valueOf(i11));
                return false;
            }
        }
        return true;
    }

    private static boolean d(String str) {
        boolean z10 = true;
        f76328c.clear();
        boolean z11 = false;
        if (!f76327b.isEmpty() && f76329d) {
            Iterator it = f76327b.iterator();
            ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
            File file = null;
            while (it.hasNext()) {
                ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = (ShareDexDiffPatchInfo) it.next();
                File file2 = new File(str + shareDexDiffPatchInfo2.realName);
                if (ShareConstants.CLASS_N_PATTERN.matcher(file2.getName()).matches()) {
                    f76328c.put(shareDexDiffPatchInfo2, file2);
                }
                if (shareDexDiffPatchInfo2.rawName.startsWith("test.dex")) {
                    shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                    file = file2;
                }
            }
            if (shareDexDiffPatchInfo != null) {
                HashMap hashMap = f76328c;
                hashMap.put(ShareTinkerInternals.changeTestDexToClassN(shareDexDiffPatchInfo, hashMap.size() + 1), file);
            }
            File file3 = new File(str, "tinker_classN.apk");
            if (file3.exists()) {
                Iterator it2 = f76328c.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ShareDexDiffPatchInfo shareDexDiffPatchInfo3 = (ShareDexDiffPatchInfo) it2.next();
                    if (!SharePatchFileUtil.verifyDexFileMd5(file3, shareDexDiffPatchInfo3.rawName, shareDexDiffPatchInfo3.destMd5InArt)) {
                        ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", shareDexDiffPatchInfo3.rawName, Long.valueOf(file3.length()));
                        z10 = false;
                        break;
                    }
                }
                if (!z10) {
                    SharePatchFileUtil.safeDeleteFile(file3);
                }
                z11 = z10;
            }
            if (z11) {
                Iterator it3 = f76328c.values().iterator();
                while (it3.hasNext()) {
                    SharePatchFileUtil.safeDeleteFile((File) it3.next());
                }
            }
        }
        return z11;
    }

    private static boolean e(Context context, List list, String str, File file, boolean z10, PatchResult patchResult) {
        vf.a x10 = vf.a.x(context);
        f76326a.clear();
        if (list != null) {
            File file2 = new File(str);
            if (!file2.exists() && !file2.mkdirs()) {
                ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
                return false;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                f76326a.add(new File(SharePatchFileUtil.optimizedPathFor((File) it.next(), file2)));
            }
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", Integer.valueOf(list.size()), str);
            Vector vector = new Vector();
            Throwable[] thArr = new Throwable[1];
            if (patchResult != null) {
                patchResult.dexoptTriggerTime = System.currentTimeMillis();
            }
            boolean[] zArr = {false};
            TinkerDexOptimizer.optimizeAll(context, list, file2, TinkerApplication.getInstance().isUseDelegateLastClassLoader(), z10, new a(zArr, vector, thArr));
            if (patchResult != null) {
                synchronized (zArr) {
                    patchResult.isOatGenerated = !zArr[0];
                }
            }
            if (!vector.isEmpty()) {
                x10.k().f(file, vector, thArr[0]);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0343, code lost:
    
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.closeZip(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean f(android.content.Context r23, java.lang.String r24, java.lang.String r25, java.io.File r26, int r27) {
        /*
            Method dump skipped, instructions count: 965
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: tf.d.f(android.content.Context, java.lang.String, java.lang.String, java.io.File, int):boolean");
    }

    private static boolean g(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        String str = f76329d ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
        return (SharePatchFileUtil.isRawDexFile(shareDexDiffPatchInfo.rawName) && shareDexDiffPatchInfo.isJarMode) ? h(zipFile, zipEntry, file, str) : c.a(zipFile, zipEntry, file, str, true);
    }

    private static boolean h(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream;
        int i11 = 0;
        boolean z10 = false;
        while (i11 < 2 && !z10) {
            i11++;
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            BufferedInputStream bufferedInputStream2 = null;
            try {
                if (file.exists()) {
                    file.delete();
                }
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                try {
                    if (ShareTinkerInternals.isNewerOrEqualThanVersion(33, true)) {
                        file.setReadOnly();
                    }
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                pf.b.a(bufferedInputStream);
                pf.b.a(zipOutputStream);
                z10 = SharePatchFileUtil.verifyDexFileMd5(file, str);
                ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", Boolean.valueOf(z10));
                if (!z10 && (!file.delete() || file.exists())) {
                    ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream2 = bufferedInputStream;
                pf.b.a(bufferedInputStream2);
                pf.b.a(zipOutputStream);
                throw th;
            }
        }
        return z10;
    }

    private static ZipEntry i(ZipEntry zipEntry, String str) {
        ZipEntry zipEntry2 = new ZipEntry(str);
        zipEntry2.setMethod(0);
        zipEntry2.setCompressedSize(zipEntry.getSize());
        zipEntry2.setSize(zipEntry.getSize());
        zipEntry2.setCrc(zipEntry.getCrc());
        return zipEntry2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016b  */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.io.BufferedInputStream, java.lang.Object, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean j(android.content.Context r15, java.io.File r16, java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: tf.d.j(android.content.Context, java.io.File, java.lang.String):boolean");
    }

    private static boolean k(Context context, String str, String str2, File file, boolean z10, PatchResult patchResult) {
        String str3 = str + "/dex/";
        if (!f(context, str3, str2, file, 3)) {
            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
            return false;
        }
        File[] listFiles = new File(str3).listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isFile() && (name.endsWith(".dex") || name.endsWith(".jar") || name.endsWith(".apk"))) {
                    arrayList.add(file2);
                }
            }
        }
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "legal files to do dexopt: " + arrayList, new Object[0]);
        return e(context, arrayList, str + "/odex/", file, z10, patchResult);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:7|8|(1:10)|11|(8:(3:16|17|18)|26|27|(4:32|33|(3:35|36|(1:38)(1:48))|(2:43|44)(2:45|46))(1:29)|30|31|17|18)|20|21|(1:23)|24) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0053, code lost:
    
        r5 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void l(java.util.zip.ZipFile r4, java.util.zip.ZipFile r5, java.util.zip.ZipEntry r6, java.util.zip.ZipEntry r7, com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo r8, java.io.File r9) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: tf.d.l(java.util.zip.ZipFile, java.util.zip.ZipFile, java.util.zip.ZipEntry, java.util.zip.ZipEntry, com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo, java.io.File):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean m(vf.a aVar, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file, boolean z10, PatchResult patchResult) {
        if (!aVar.o()) {
            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
            return true;
        }
        String str2 = shareSecurityCheck.getMetaContentMap().get("assets/dex_meta.txt");
        if (str2 == null) {
            ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean k11 = k(context, str, str2, file, z10, patchResult);
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        patchResult.dexCostTime = elapsedRealtime2;
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", Boolean.valueOf(k11), Long.valueOf(elapsedRealtime2));
        return k11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean n(File file, vf.a aVar) {
        if (f76326a.isEmpty()) {
            return true;
        }
        int size = f76327b.size() * 30;
        if (size > 120) {
            size = 120;
        }
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", Integer.valueOf(f76327b.size()), Integer.valueOf(f76326a.size()), Integer.valueOf(size));
        int i11 = 0;
        while (i11 < size) {
            i11++;
            if (!c(f76326a, i11)) {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e11) {
                    ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:" + e11, new Object[0]);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f76326a.iterator();
        while (it.hasNext()) {
            File file2 = (File) it.next();
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", file2.getPath(), Long.valueOf(file2.length()));
            if (!SharePatchFileUtil.isLegalFile(file2) && !SharePatchFileUtil.shouldAcceptEvenIfIllegal(file2)) {
                ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", file2.getName());
                arrayList.add(file2);
            }
        }
        if (!arrayList.isEmpty()) {
            aVar.k().f(file, arrayList, new TinkerRuntimeException("checkDexOptExist failed"));
            return false;
        }
        Iterator it2 = f76326a.iterator();
        Throwable th2 = null;
        while (it2.hasNext()) {
            File file3 = (File) it2.next();
            if (!SharePatchFileUtil.shouldAcceptEvenIfIllegal(file3)) {
                ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", file3.getName(), Long.valueOf(file3.length()));
                try {
                    if (ShareElfFile.getFileTypeByMagic(file3) == 1) {
                        try {
                            pf.b.a(new ShareElfFile(file3));
                        } finally {
                            th2 = th;
                            try {
                            } finally {
                            }
                        }
                    } else {
                        continue;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        aVar.k().f(file, arrayList, th2 == null ? new TinkerRuntimeException("checkDexOptFormat failed") : new TinkerRuntimeException("checkDexOptFormat failed", th2));
        return false;
    }
}
