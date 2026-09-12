package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
import android.content.Context;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.transsion.gslb.Utils;
import java.io.File;
import java.security.cert.Certificate;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class ShareSecurityCheck {
    private static String mPublicKeyMd5;
    private final Context mContext;
    private final HashMap<String, String> metaContentMap = new HashMap<>();
    private final HashMap<String, String> packageProperties = new HashMap<>();

    public ShareSecurityCheck(Context context) {
        this.mContext = context;
        if (mPublicKeyMd5 == null) {
            init(context);
        }
    }

    private boolean check(File file, Certificate[] certificateArr) {
        if (certificateArr.length > 0) {
            for (int length = certificateArr.length - 1; length >= 0; length--) {
                try {
                } catch (Exception e11) {
                    ShareTinkerLog.e("Tinker.SecurityCheck", file.getAbsolutePath(), e11);
                }
                if (mPublicKeyMd5.equals(SharePatchFileUtil.getMD5(certificateArr[length].getEncoded()))) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private void init(Context context) {
        try {
            try {
                String md5 = SharePatchFileUtil.getMD5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
                mPublicKeyMd5 = md5;
                if (md5 != null) {
                } else {
                    throw new TinkerRuntimeException("get public key md5 is null");
                }
            } catch (Exception e11) {
                throw new TinkerRuntimeException("ShareSecurityCheck init public key fail", e11);
            }
        } finally {
            SharePatchFileUtil.closeQuietly(null);
        }
    }

    public HashMap<String, String> getMetaContentMap() {
        return this.metaContentMap;
    }

    public HashMap<String, String> getPackagePropertiesIfPresent() {
        String[] split;
        if (!this.packageProperties.isEmpty()) {
            return this.packageProperties;
        }
        String str = this.metaContentMap.get("assets/package_meta.txt");
        if (str == null) {
            return null;
        }
        for (String str2 : str.split("\n")) {
            if (str2 != null && str2.length() > 0 && !str2.startsWith(Utils.SEPARATOR) && (split = str2.split(UrlUtils.EQUAL_MARK, 2)) != null && split.length >= 2) {
                this.packageProperties.put(split[0].trim(), split[1].trim());
            }
        }
        return this.packageProperties;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean verifyPatchMetaSignature(java.io.File r12) {
        /*
            r11 = this;
            r0 = 1
            java.lang.String r1 = "Tinker.SecurityCheck"
            boolean r2 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.isLegalFile(r12)
            r3 = 0
            if (r2 != 0) goto Lb
            return r3
        Lb:
            r2 = 0
            java.util.jar.JarFile r4 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            r4.<init>(r12)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7b
            java.util.Enumeration r2 = r4.entries()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
        L15:
            boolean r5 = r2.hasMoreElements()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r5 == 0) goto L65
            java.lang.Object r5 = r2.nextElement()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.util.jar.JarEntry r5 = (java.util.jar.JarEntry) r5     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r5 != 0) goto L24
            goto L15
        L24:
            java.lang.String r6 = r5.getName()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.String r7 = "META-INF/"
            boolean r7 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r7 == 0) goto L31
            goto L15
        L31:
            java.lang.String r7 = "meta.txt"
            boolean r7 = r6.endsWith(r7)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r7 != 0) goto L3a
            goto L15
        L3a:
            java.util.HashMap<java.lang.String, java.lang.String> r7 = r11.metaContentMap     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.String r8 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.loadDigestes(r4, r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r7.put(r6, r8)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.security.cert.Certificate[] r5 = r5.getCertificates()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r5 == 0) goto L54
            boolean r5 = r11.check(r12, r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r5 != 0) goto L15
            goto L54
        L50:
            r2 = move-exception
            goto L9e
        L52:
            r2 = move-exception
            goto L7f
        L54:
            r4.close()     // Catch: java.io.IOException -> L58
            goto L64
        L58:
            r2 = move-exception
            java.lang.String r12 = r12.getAbsolutePath()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r3] = r2
            com.tencent.tinker.loader.shareutil.ShareTinkerLog.e(r1, r12, r0)
        L64:
            return r3
        L65:
            r4.close()     // Catch: java.io.IOException -> L69
            goto L75
        L69:
            r2 = move-exception
            java.lang.String r12 = r12.getAbsolutePath()
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r3] = r2
            com.tencent.tinker.loader.shareutil.ShareTinkerLog.e(r1, r12, r4)
        L75:
            return r0
        L76:
            r4 = move-exception
            r10 = r4
            r4 = r2
            r2 = r10
            goto L9e
        L7b:
            r4 = move-exception
            r10 = r4
            r4 = r2
            r2 = r10
        L7f:
            com.tencent.tinker.loader.TinkerRuntimeException r5 = new com.tencent.tinker.loader.TinkerRuntimeException     // Catch: java.lang.Throwable -> L50
            java.lang.String r6 = "ShareSecurityCheck file %s, size %d verifyPatchMetaSignature fail"
            java.lang.String r7 = r12.getAbsolutePath()     // Catch: java.lang.Throwable -> L50
            long r8 = r12.length()     // Catch: java.lang.Throwable -> L50
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L50
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L50
            r9[r3] = r7     // Catch: java.lang.Throwable -> L50
            r9[r0] = r8     // Catch: java.lang.Throwable -> L50
            java.lang.String r6 = java.lang.String.format(r6, r9)     // Catch: java.lang.Throwable -> L50
            r5.<init>(r6, r2)     // Catch: java.lang.Throwable -> L50
            throw r5     // Catch: java.lang.Throwable -> L50
        L9e:
            if (r4 == 0) goto Lb0
            r4.close()     // Catch: java.io.IOException -> La4
            goto Lb0
        La4:
            r4 = move-exception
            java.lang.String r12 = r12.getAbsolutePath()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r3] = r4
            com.tencent.tinker.loader.shareutil.ShareTinkerLog.e(r1, r12, r0)
        Lb0:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareSecurityCheck.verifyPatchMetaSignature(java.io.File):boolean");
    }
}
