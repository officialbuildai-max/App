package com.cloud.hisavana.sdk.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.e4;
import java.io.FileInputStream;

/* loaded from: classes3.dex */
public class s0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ef A[Catch: all -> 0x0074, IOException -> 0x0077, TryCatch #14 {IOException -> 0x0077, all -> 0x0074, blocks: (B:10:0x0028, B:12:0x002e, B:14:0x0038, B:16:0x0040, B:67:0x0046, B:70:0x0069, B:73:0x0070, B:19:0x007a, B:22:0x009d, B:25:0x00a4, B:27:0x00aa, B:37:0x00cf, B:54:0x00ef, B:55:0x00f2, B:46:0x00e5, B:88:0x0104, B:90:0x0114, B:92:0x011a, B:93:0x011d), top: B:9:0x0028 }] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.io.InputStream r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.util.s0.a(java.io.InputStream, java.lang.String):boolean");
    }

    public static boolean b(String str, String str2) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                boolean a11 = a(fileInputStream, str2);
                try {
                    fileInputStream.close();
                } catch (Exception e11) {
                    e4.b().e("ZIP", "decompressZipFolder: " + Log.getStackTraceString(e11));
                }
                return a11;
            } catch (Throwable th2) {
                th = th2;
                try {
                    e4.b().e("ZIP", "decompressZipFolder: " + Log.getStackTraceString(th));
                    return false;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e12) {
                            e4.b().e("ZIP", "decompressZipFolder: " + Log.getStackTraceString(e12));
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
