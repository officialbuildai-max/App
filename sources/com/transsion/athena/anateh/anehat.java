package com.transsion.athena.anateh;

import android.util.Base64;
import android.util.Log;
import com.transsion.athena.config.data.model.ehanat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes5.dex */
public class anehat {
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.File r5, byte[] r6) throws java.lang.Exception {
        /*
            boolean r0 = r5.exists()
            java.lang.String r1 = ""
            if (r0 == 0) goto Lab
            boolean r0 = r5.isFile()
            if (r0 != 0) goto L10
            goto Lab
        L10:
            r0 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78
            r5.<init>()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L78
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
        L1f:
            int r3 = r2.read(r0)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            r4 = -1
            if (r3 == r4) goto L2f
            r4 = 0
            r5.write(r0, r4, r3)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            goto L1f
        L2b:
            r6 = move-exception
            goto L71
        L2d:
            r6 = move-exception
            goto L73
        L2f:
            byte[] r0 = r5.toByteArray()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            int r3 = r0.length     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            if (r3 != 0) goto L4f
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L42
        L3a:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.transsion.athena.taaneh.aethna.b(r6)
        L42:
            r5.close()     // Catch: java.io.IOException -> L46
            goto L4e
        L46:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.transsion.athena.taaneh.aethna.b(r5)
        L4e:
            return r1
        L4f:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            byte[] r6 = a(r6, r0)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            r2.close()     // Catch: java.io.IOException -> L5c
            goto L64
        L5c:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.transsion.athena.taaneh.aethna.b(r6)
        L64:
            r5.close()     // Catch: java.io.IOException -> L68
            goto L70
        L68:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.transsion.athena.taaneh.aethna.b(r5)
        L70:
            return r1
        L71:
            r0 = r2
            goto L8e
        L73:
            r0 = r5
            goto L86
        L75:
            r5 = move-exception
            r6 = r5
            goto L7b
        L78:
            r5 = move-exception
            r6 = r5
            goto L86
        L7b:
            r5 = r0
            goto L71
        L7d:
            r5 = move-exception
            r6 = r5
            goto L83
        L80:
            r5 = move-exception
            r6 = r5
            goto L85
        L83:
            r5 = r0
            goto L8e
        L85:
            r2 = r0
        L86:
            java.lang.String r5 = android.util.Log.getStackTraceString(r6)     // Catch: java.lang.Throwable -> L75
            com.transsion.athena.taaneh.aethna.b(r5)     // Catch: java.lang.Throwable -> L75
            throw r6     // Catch: java.lang.Throwable -> L75
        L8e:
            if (r0 == 0) goto L9c
            r0.close()     // Catch: java.io.IOException -> L94
            goto L9c
        L94:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.transsion.athena.taaneh.aethna.b(r0)
        L9c:
            if (r5 == 0) goto Laa
            r5.close()     // Catch: java.io.IOException -> La2
            goto Laa
        La2:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.transsion.athena.taaneh.aethna.b(r5)
        Laa:
            throw r6
        Lab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.anateh.anehat.a(java.io.File, byte[]):java.lang.String");
    }

    public static String a(String str, byte[] bArr) {
        try {
            if (bArr != null) {
                return new String(Base64.encode(a(bArr, str), 2));
            }
            com.transsion.athena.taaneh.aethna.b("encryptEventData password is null");
            return null;
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public static String a(String str, byte[] bArr, int i11) {
        try {
            if (bArr != null) {
                return new String(a(bArr, Base64.decode(str, 2)));
            }
            com.transsion.athena.taaneh.aethna.b("decryptEventData password is null");
            return null;
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public static void a(File file, String str, byte[] bArr) throws Exception {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                byte[] a11 = a(bArr, str);
                if (a11 == null || a11.length == 0) {
                    throw new Exception("encode failed p = " + com.transsion.athena.config.data.model.anehat.c(bArr) + ", m = " + str.length());
                }
                if (file.exists()) {
                    fileOutputStream = new FileOutputStream(file);
                } else {
                    if (!file.createNewFile()) {
                        throw new IOException("createNewFile failed");
                    }
                    fileOutputStream = new FileOutputStream(file);
                }
                FileOutputStream fileOutputStream3 = fileOutputStream;
                fileOutputStream3.write(a11);
                fileOutputStream3.flush();
                try {
                    fileOutputStream3.close();
                } catch (IOException unused) {
                }
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
                throw e11;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th2;
        }
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(ehanat.f42668o));
        try {
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception e11) {
            e11.printStackTrace();
            throw e11;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(ehanat.f42668o));
        try {
            return cipher.doFinal(bArr2);
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            throw e11;
        }
    }
}
