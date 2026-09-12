package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class Jcg {

    /* renamed from: com.bytedance.sdk.component.utils.Jcg$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File file, File file2) {
            throw null;
        }
    }

    /* loaded from: classes2.dex */
    private static final class Sj implements Comparator<File> {
        private Sj() {
        }

        /* synthetic */ Sj(AnonymousClass1 anonymousClass1) {
            this();
        }

        private int Sj(long j11, long j12) {
            if (j11 < j12) {
                return -1;
            }
            return j11 == j12 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return Sj(file.lastModified(), file2.lastModified());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0044, code lost:
    
        if (r4 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] EjP(java.io.File r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L47
            boolean r1 = r7.isFile()
            if (r1 == 0) goto L47
            boolean r1 = r7.exists()
            if (r1 == 0) goto L47
            boolean r1 = r7.canRead()
            if (r1 == 0) goto L47
            long r1 = r7.length()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L47
            long r1 = r7.length()     // Catch: java.lang.Throwable -> L43
            java.lang.Long r3 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L43
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L43
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L43
            int r7 = r3.intValue()     // Catch: java.lang.Throwable -> L44
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L44
            int r3 = r4.read(r7)     // Catch: java.lang.Throwable -> L44
            long r5 = (long) r3
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L3f
            r4.close()     // Catch: java.lang.Throwable -> L3e
        L3e:
            return r7
        L3f:
            r4.close()     // Catch: java.lang.Throwable -> L47
            goto L47
        L43:
            r4 = r0
        L44:
            if (r4 == 0) goto L47
            goto L3f
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.Jcg.EjP(java.io.File):byte[]");
    }

    private static void HiB(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long j11;
        long length = file.length();
        if (length == 0) {
            vS(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            j11 = length - 1;
        } catch (Throwable unused) {
            randomAccessFile = null;
        }
        try {
            randomAccessFile.seek(j11);
            byte readByte = randomAccessFile.readByte();
            randomAccessFile.seek(j11);
            randomAccessFile.write(readByte);
            randomAccessFile.close();
        } catch (Throwable unused2) {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    public static File Sj(Context context, boolean z10, String str) {
        String absolutePath = context.getCacheDir().getAbsolutePath();
        if (z10) {
            str = Sj(context) + "-" + str;
        }
        if (absolutePath != null) {
            String str2 = File.separator;
            if (!absolutePath.endsWith(str2)) {
                absolutePath = absolutePath + str2;
            }
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File Sj(Context context, boolean z10, String str, String str2) {
        String sP = sP(context);
        if (z10) {
            str = Sj(context) + "-" + str;
        }
        if (sP != null) {
            String str3 = File.separator;
            if (!sP.endsWith(str3)) {
                sP = sP + str3;
            }
        }
        String str4 = sP + str;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str4, str2);
    }

    public static String Sj(Context context) {
        String Sj2 = zR.Sj(context);
        return (TextUtils.isEmpty(Sj2) || !Sj2.contains(":")) ? Sj2 : Sj2.replace(":", "-");
    }

    public static List<File> Sj(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new Sj(null));
        return asList;
    }

    public static void TKC(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            try {
                file.delete();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    TKC(file2);
                } else {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        try {
            file.delete();
        } catch (Throwable unused3) {
        }
    }

    private static String sP(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    public static void sP(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            HiB(file);
            if (file.lastModified() < currentTimeMillis) {
                new Date(file.lastModified()).toString();
                file.getAbsolutePath();
            }
        }
    }

    private static void vS(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }
}
