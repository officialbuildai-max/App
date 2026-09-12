package com.blankj.utilcode.util;

/* loaded from: classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private static int f20173a = 524288;

    /* loaded from: classes2.dex */
    public interface a {
        void onProgressUpdate(double d11);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[Catch: FileNotFoundException -> 0x0063, SYNTHETIC, TRY_LEAVE, TryCatch #4 {FileNotFoundException -> 0x0063, blocks: (B:6:0x0008, B:25:0x005f, B:27:0x0057, B:65:0x0085, B:61:0x0092, B:60:0x008f, B:45:0x007c, B:48:0x0072, B:18:0x0052, B:53:0x0080, B:38:0x006d, B:56:0x008a, B:21:0x005a, B:42:0x0077), top: B:5:0x0008, inners: #1, #3, #5, #7, #8, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.io.File r10, com.blankj.utilcode.util.m.a r11) {
        /*
            boolean r0 = com.blankj.utilcode.util.e0.y(r10)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.io.FileNotFoundException -> L63
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L63
            r2.<init>(r10)     // Catch: java.io.FileNotFoundException -> L63
            int r10 = com.blankj.utilcode.util.m.f20173a     // Catch: java.io.FileNotFoundException -> L63
            r0.<init>(r2, r10)     // Catch: java.io.FileNotFoundException -> L63
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            r10.<init>()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            int r2 = com.blankj.utilcode.util.m.f20173a     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r3 = -1
            r4 = 0
            if (r11 != 0) goto L31
        L21:
            int r11 = com.blankj.utilcode.util.m.f20173a     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            int r11 = r0.read(r2, r4, r11)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            if (r11 == r3) goto L4e
            r10.write(r2, r4, r11)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            goto L21
        L2d:
            r11 = move-exception
            goto L80
        L2f:
            r11 = move-exception
            goto L6a
        L31:
            int r5 = r0.available()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            double r5 = (double) r5     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r7 = 0
            r11.onProgressUpdate(r7)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r7 = r4
        L3c:
            int r8 = com.blankj.utilcode.util.m.f20173a     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            int r8 = r0.read(r2, r4, r8)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            if (r8 == r3) goto L4e
            r10.write(r2, r4, r8)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            int r7 = r7 + r8
            double r8 = (double) r7     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            double r8 = r8 / r5
            r11.onProgressUpdate(r8)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            goto L3c
        L4e:
            byte[] r11 = r10.toByteArray()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r0.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L63
        L5a:
            r10.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.io.FileNotFoundException -> L63
        L62:
            return r11
        L63:
            r10 = move-exception
            goto L93
        L65:
            r11 = move-exception
            r10 = r1
            goto L80
        L68:
            r11 = move-exception
            r10 = r1
        L6a:
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L2d
            r0.close()     // Catch: java.io.IOException -> L71
            goto L75
        L71:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.io.FileNotFoundException -> L63
        L75:
            if (r10 == 0) goto L7f
            r10.close()     // Catch: java.io.IOException -> L7b
            goto L7f
        L7b:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.io.FileNotFoundException -> L63
        L7f:
            return r1
        L80:
            r0.close()     // Catch: java.io.IOException -> L84
            goto L88
        L84:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L63
        L88:
            if (r10 == 0) goto L92
            r10.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L8e:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.io.FileNotFoundException -> L63
        L92:
            throw r11     // Catch: java.io.FileNotFoundException -> L63
        L93:
            r10.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.m.a(java.io.File, com.blankj.utilcode.util.m$a):byte[]");
    }

    public static byte[] b(String str) {
        return a(e0.l(str), null);
    }
}
