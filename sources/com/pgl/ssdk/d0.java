package com.pgl.ssdk;

import java.io.BufferedInputStream;

/* loaded from: classes5.dex */
public class d0 {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00dd, code lost:
    
        if (r9.length() == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.String a(android.content.Context r9) {
        /*
            r0 = 0
            java.lang.Class<com.pgl.ssdk.d0> r1 = com.pgl.ssdk.d0.class
            monitor-enter(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            r2.<init>()     // Catch: java.lang.Throwable -> Ld5
            java.io.File r3 = r9.getFilesDir()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> Ld5
            r2.append(r3)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "/dic"
            r2.append(r3)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Ld5
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> Ld5
            r3.<init>(r2)     // Catch: java.lang.Throwable -> Ld5
            boolean r3 = r3.exists()     // Catch: java.lang.Throwable -> Ld5
            if (r3 == 0) goto L50
            java.lang.String r3 = "chmod 777 "
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = r3.concat(r4)     // Catch: java.lang.Throwable -> Ld5
            a(r3)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = a(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "chmod 600 "
            java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = r4.concat(r5)     // Catch: java.lang.Throwable -> Ld5
            a(r4)     // Catch: java.lang.Throwable -> Ld5
            if (r3 == 0) goto L50
            int r4 = r3.length()     // Catch: java.lang.Throwable -> Ld5
            if (r4 <= 0) goto L50
            monitor-exit(r1)
            return r3
        L50:
            android.content.res.Resources r9 = r9.getResources()     // Catch: java.lang.Throwable -> Ld5
            android.content.res.AssetManager r9 = r9.getAssets()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "dic"
            java.io.InputStream r9 = r9.open(r3)     // Catch: java.lang.Throwable -> Ld5
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> Ld5
            r3.<init>()     // Catch: java.lang.Throwable -> Ld5
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r4]     // Catch: java.lang.Throwable -> Ld5
        L67:
            int r6 = r9.read(r5, r0, r4)     // Catch: java.lang.Throwable -> Ld5
            r7 = -1
            if (r6 == r7) goto L83
            java.lang.String r7 = "dic"
            java.lang.String r8 = "UTF-8"
            java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r8)     // Catch: java.lang.Throwable -> Ld5
            byte[] r7 = r7.getBytes(r8)     // Catch: java.lang.Throwable -> Ld5
            a(r5, r6, r7)     // Catch: java.lang.Throwable -> Ld5
            r3.write(r5, r0, r6)     // Catch: java.lang.Throwable -> Ld5
            goto L67
        L81:
            r9 = move-exception
            goto Le3
        L83:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Ld5
            r9.<init>(r2)     // Catch: java.lang.Throwable -> Ld5
            byte[] r3 = r3.toByteArray()     // Catch: java.lang.Throwable -> Ld5
            r9.write(r3)     // Catch: java.lang.Throwable -> Ld5
            r9.close()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r9 = "chmod 777 "
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r9 = r9.concat(r3)     // Catch: java.lang.Throwable -> Ld5
            a(r9)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r9 = a(r2)     // Catch: java.lang.Throwable -> Ld5
            if (r9 == 0) goto Lab
            int r3 = r9.length()     // Catch: java.lang.Throwable -> Ld5
            if (r3 != 0) goto Lc7
        Lab:
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "rw"
            r9.<init>(r2, r3)     // Catch: java.lang.Throwable -> Ld5
            r3 = 1
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> Ld5
            r4 = 2
            r3[r0] = r4     // Catch: java.lang.Throwable -> Ld5
            r4 = 16
            r9.seek(r4)     // Catch: java.lang.Throwable -> Ld5
            r9.write(r3)     // Catch: java.lang.Throwable -> Ld5
            r9.close()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r9 = a(r2)     // Catch: java.lang.Throwable -> Ld5
        Lc7:
            java.lang.String r0 = "chmod 600 "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r0 = r0.concat(r2)     // Catch: java.lang.Throwable -> Ld5
            a(r0)     // Catch: java.lang.Throwable -> Ld5
            goto Ld7
        Ld5:
            java.lang.String r9 = "0[<!>]EXCEPTION[<!>]"
        Ld7:
            if (r9 == 0) goto Ldf
            int r0 = r9.length()     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto Le1
        Ldf:
            java.lang.String r9 = "0[<!>]ERROR[<!>]"
        Le1:
            monitor-exit(r1)
            return r9
        Le3:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L81
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.d0.a(android.content.Context):java.lang.String");
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[4096];
        StringBuilder sb2 = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb2.append(new String(bArr, 0, read));
                }
            } catch (Exception unused) {
            }
        } while (read >= 4096);
        return sb2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L5a
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L5a
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L5b
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L5b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L5b
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            byte[] r5 = r5.getBytes()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r2.write(r5)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r5 = 10
            r2.write(r5)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r2.flush()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r2.close()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r1.waitFor()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            java.lang.String r0 = a(r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L5d
            r2.close()     // Catch: java.io.IOException -> L39
        L39:
            r3.close()     // Catch: java.io.IOException -> L6a
            goto L6a
        L3d:
            r5 = move-exception
        L3e:
            r0 = r2
            goto L4a
        L40:
            r5 = move-exception
            r3 = r0
            goto L3e
        L43:
            r3 = r0
            goto L5d
        L45:
            r5 = move-exception
            goto L49
        L47:
            r5 = move-exception
            r1 = r0
        L49:
            r3 = r0
        L4a:
            if (r0 == 0) goto L4f
            r0.close()     // Catch: java.io.IOException -> L4f
        L4f:
            if (r3 == 0) goto L54
            r3.close()     // Catch: java.io.IOException -> L54
        L54:
            if (r1 == 0) goto L59
            r1.destroy()
        L59:
            throw r5
        L5a:
            r1 = r0
        L5b:
            r2 = r0
            r3 = r2
        L5d:
            if (r2 == 0) goto L62
            r2.close()     // Catch: java.io.IOException -> L62
        L62:
            if (r3 == 0) goto L67
            r3.close()     // Catch: java.io.IOException -> L67
        L67:
            if (r1 != 0) goto L6a
            goto L6d
        L6a:
            r1.destroy()
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.d0.a(java.lang.String):java.lang.String");
    }

    private static void a(byte[] bArr, int i11, byte[] bArr2) {
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i12] = (byte) (bArr[i12] ^ bArr2[i12 % bArr2.length]);
        }
    }
}
