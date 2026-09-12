package tf;

import android.content.Context;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareArkHotDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipFile;

/* loaded from: classes5.dex */
public class b extends c {

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList f76325a = new ArrayList();

    private static boolean c(Context context, String str, File file, int i11) {
        ZipFile zipFile;
        String str2;
        vf.a x10 = vf.a.x(context);
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file);
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Iterator it = f76325a.iterator();
            while (it.hasNext()) {
                ShareArkHotDiffPatchInfo shareArkHotDiffPatchInfo = (ShareArkHotDiffPatchInfo) it.next();
                String str3 = shareArkHotDiffPatchInfo.path;
                if (str3.equals("")) {
                    str2 = shareArkHotDiffPatchInfo.name;
                } else {
                    str2 = str3 + "/" + shareArkHotDiffPatchInfo.name;
                }
                String str4 = shareArkHotDiffPatchInfo.patchMd5;
                if (!SharePatchFileUtil.checkIfMd5Valid(str4)) {
                    x10.k().b(file, c.b(i11));
                    SharePatchFileUtil.closeZip(zipFile);
                    return false;
                }
                File file2 = new File(str + shareArkHotDiffPatchInfo.name);
                if (!file2.exists()) {
                    file2.getParentFile().mkdirs();
                } else if (!str4.equals(SharePatchFileUtil.getMD5(file2))) {
                    file2.delete();
                }
                if (!c.a(zipFile, zipFile.getEntry(str2), file2, str4, false)) {
                    x10.k().a(file, file2, shareArkHotDiffPatchInfo.name, i11);
                    SharePatchFileUtil.closeZip(zipFile);
                    return false;
                }
            }
            SharePatchFileUtil.closeZip(zipFile);
            return true;
        } catch (IOException e12) {
            e = e12;
            zipFile2 = zipFile;
            throw new TinkerRuntimeException("patch " + ShareTinkerInternals.getTypeString(i11) + " extract failed (" + e.getMessage() + ").", e);
        } catch (Throwable th3) {
            th = th3;
            zipFile2 = zipFile;
            SharePatchFileUtil.closeZip(zipFile2);
            throw th;
        }
    }

    private static boolean d(Context context, String str, String str2, File file) {
        String str3 = str + "/arkHot/";
        f76325a.clear();
        ShareArkHotDiffPatchInfo.parseDiffPatchInfo(str2, f76325a);
        return c(context, str3, file, 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean e(vf.a aVar, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        String str2 = shareSecurityCheck.getMetaContentMap().get("assets/arkHot_meta.txt");
        if (str2 == null) {
            return true;
        }
        d(context, str, str2, file);
        return true;
    }
}
