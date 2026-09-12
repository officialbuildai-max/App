package ew;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.ZipOutputStream;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f62156a = new b();

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(java.io.File r19, java.lang.String r20, org.apache.tools.zip.ZipOutputStream r21, kotlin.jvm.functions.Function1 r22) {
        /*
            r18 = this;
            r0 = r21
            r8 = r22
            boolean r1 = r19.isDirectory()
            r9 = 0
            if (r1 == 0) goto L16
            java.io.File[] r1 = r19.listFiles()
            java.lang.String r2 = "parentFile.listFiles()"
            kotlin.jvm.internal.Intrinsics.g(r1, r2)
        L14:
            r10 = r1
            goto L1b
        L16:
            java.io.File[] r1 = new java.io.File[r9]
            r1[r9] = r19
            goto L14
        L1b:
            r11 = 1024(0x400, float:1.435E-42)
            byte[] r12 = new byte[r11]
            r1 = 0
            int r13 = r10.length     // Catch: java.io.IOException -> Lc2
            r14 = r1
            r15 = r14
            r7 = r9
        L24:
            if (r7 >= r13) goto Lba
            r2 = r10[r7]     // Catch: java.io.IOException -> L72
            boolean r1 = r2.isDirectory()     // Catch: java.io.IOException -> L72
            java.lang.String r3 = "this as java.lang.String).substring(startIndex)"
            java.lang.String r4 = "it.path"
            if (r1 == 0) goto L75
            java.lang.String r1 = r2.getPath()     // Catch: java.io.IOException -> L72
            kotlin.jvm.internal.Intrinsics.g(r1, r4)     // Catch: java.io.IOException -> L72
            int r4 = r20.length()     // Catch: java.io.IOException -> L72
            int r4 = r4 + 1
            java.lang.String r1 = r1.substring(r4)     // Catch: java.io.IOException -> L72
            kotlin.jvm.internal.Intrinsics.g(r1, r3)     // Catch: java.io.IOException -> L72
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L72
            r3.<init>()     // Catch: java.io.IOException -> L72
            r3.append(r1)     // Catch: java.io.IOException -> L72
            java.lang.String r1 = "/"
            r3.append(r1)     // Catch: java.io.IOException -> L72
            java.lang.String r1 = r3.toString()     // Catch: java.io.IOException -> L72
            org.apache.tools.zip.ZipEntry r3 = new org.apache.tools.zip.ZipEntry     // Catch: java.io.IOException -> L72
            r3.<init>(r1)     // Catch: java.io.IOException -> L72
            r0.putNextEntry(r3)     // Catch: java.io.IOException -> L72
            ew.b r1 = ew.b.f62156a     // Catch: java.io.IOException -> L72
            r6 = 8
            r16 = 0
            r5 = 0
            r3 = r20
            r4 = r21
            r17 = r7
            r7 = r16
            c(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.io.IOException -> L72
            goto Lac
        L72:
            r0 = move-exception
            r1 = r14
            goto Lc4
        L75:
            r17 = r7
            java.lang.String r1 = r2.getPath()     // Catch: java.io.IOException -> L72
            kotlin.jvm.internal.Intrinsics.g(r1, r4)     // Catch: java.io.IOException -> L72
            int r4 = r20.length()     // Catch: java.io.IOException -> L72
            int r4 = r4 + 1
            java.lang.String r1 = r1.substring(r4)     // Catch: java.io.IOException -> L72
            kotlin.jvm.internal.Intrinsics.g(r1, r3)     // Catch: java.io.IOException -> L72
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.IOException -> L72
            r3.<init>(r2)     // Catch: java.io.IOException -> L72
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.io.IOException -> Lb8
            r2.<init>(r3)     // Catch: java.io.IOException -> Lb8
            org.apache.tools.zip.ZipEntry r4 = new org.apache.tools.zip.ZipEntry     // Catch: java.io.IOException -> Lb0
            r4.<init>(r1)     // Catch: java.io.IOException -> Lb0
            r0.putNextEntry(r4)     // Catch: java.io.IOException -> Lb0
        L9d:
            int r1 = r2.read(r12, r9, r11)     // Catch: java.io.IOException -> Lb0
            r4 = -1
            if (r1 != r4) goto Lb4
            r3.close()     // Catch: java.io.IOException -> Lb0
            r2.close()     // Catch: java.io.IOException -> Lb0
            r15 = r2
            r14 = r3
        Lac:
            int r7 = r17 + 1
            goto L24
        Lb0:
            r0 = move-exception
            r15 = r2
        Lb2:
            r1 = r3
            goto Lc4
        Lb4:
            r0.write(r12, r9, r1)     // Catch: java.io.IOException -> Lb0
            goto L9d
        Lb8:
            r0 = move-exception
            goto Lb2
        Lba:
            if (r8 == 0) goto Ld8
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.io.IOException -> L72
            r8.invoke(r0)     // Catch: java.io.IOException -> L72
            goto Ld8
        Lc2:
            r0 = move-exception
            r15 = r1
        Lc4:
            if (r8 == 0) goto Lcb
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r8.invoke(r2)
        Lcb:
            r0.printStackTrace()
            if (r1 == 0) goto Ld3
            r1.close()
        Ld3:
            if (r15 == 0) goto Ld8
            r15.close()
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ew.b.b(java.io.File, java.lang.String, org.apache.tools.zip.ZipOutputStream, kotlin.jvm.functions.Function1):void");
    }

    static /* synthetic */ void c(b bVar, File file, String str, ZipOutputStream zipOutputStream, Function1 function1, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        bVar.b(file, str, zipOutputStream, function1);
    }

    public final void a(String str, String zipFilePath, Function1 function1) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        Intrinsics.h(zipFilePath, "zipFilePath");
        if (str == null) {
            return;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(zipFilePath);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    zipOutputStream = new ZipOutputStream(bufferedOutputStream);
                } catch (IOException e11) {
                    e = e11;
                }
                try {
                    zipOutputStream.setEncoding("GBK");
                    File file = new File(str);
                    String basePath = file.isDirectory() ? file.getPath() : file.getParent();
                    Intrinsics.g(basePath, "basePath");
                    b(file, basePath, zipOutputStream, function1);
                    zipOutputStream.closeEntry();
                    zipOutputStream.close();
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                } catch (IOException e12) {
                    e = e12;
                    zipOutputStream2 = zipOutputStream;
                    e.printStackTrace();
                    if (zipOutputStream2 != null) {
                        zipOutputStream2.closeEntry();
                    }
                    if (zipOutputStream2 != null) {
                        zipOutputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                    }
                }
            } catch (IOException e13) {
                e = e13;
                bufferedOutputStream = null;
            }
        } catch (IOException e14) {
            e = e14;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
    }
}
