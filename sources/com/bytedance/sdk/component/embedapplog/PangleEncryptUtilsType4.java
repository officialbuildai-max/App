package com.bytedance.sdk.component.embedapplog;

import android.util.Log;
import android.util.Pair;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class PangleEncryptUtilsType4 {
    PangleEncryptUtilsType4() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<Integer, String> decrypt(String str) {
        try {
            Pair<Integer, String> cypher4Decrypt = PglCryptUtils.getInstance().cypher4Decrypt(str);
            return new Pair<>(Integer.valueOf(getCryptFailedReason(((Integer) cypher4Decrypt.first).intValue())), cypher4Decrypt.second);
        } catch (Throwable th2) {
            Log.e("pangle-encrypt", "decrypt exception " + th2.getMessage());
            return new Pair<>(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject encrypt(JSONObject jSONObject, IDefaultEncrypt iDefaultEncrypt) {
        Pair<Integer, JSONObject> pair;
        Object obj;
        try {
            pair = PglCryptUtils.getInstance().cypher4Encrypt(jSONObject);
        } catch (Throwable th2) {
            Log.e("pangle-encrypt", "encrypt exception " + th2.getMessage());
            pair = null;
        }
        if (pair != null && ((Integer) pair.first).intValue() == 0 && (obj = pair.second) != null) {
            return (JSONObject) obj;
        }
        if (iDefaultEncrypt == null) {
            return null;
        }
        try {
            return iDefaultEncrypt.encrypt(jSONObject, pair == null ? 0 : getCryptFailedReason(((Integer) pair.first).intValue()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject encryptType4WithNoWrapBase64(org.json.JSONObject r5, com.bytedance.sdk.component.embedapplog.IDefaultEncrypt r6) {
        /*
            java.lang.String r0 = "pangle-encrypt"
            r1 = 0
            if (r5 == 0) goto L28
            com.bytedance.sdk.component.pglcrypt.PglCryptUtils r2 = com.bytedance.sdk.component.pglcrypt.PglCryptUtils.getInstance()     // Catch: java.lang.Throwable -> L12
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L12
            android.util.Pair r2 = r2.cypher4EncryptWithNoWrapBase64(r3)     // Catch: java.lang.Throwable -> L12
            goto L29
        L12:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "encrypt exception "
            r3.<init>(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.e(r0, r2)
        L28:
            r2 = r1
        L29:
            if (r2 == 0) goto L67
            java.lang.Object r3 = r2.first
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != 0) goto L67
            java.lang.Object r3 = r2.second
            if (r3 == 0) goto L67
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L50
            r5.<init>()     // Catch: java.lang.Throwable -> L50
            java.lang.String r6 = "message"
            java.lang.Object r1 = r2.second     // Catch: java.lang.Throwable -> L4d
            r5.put(r6, r1)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = "cypher"
            r1 = 4
            r5.put(r6, r1)     // Catch: java.lang.Throwable -> L4d
            r1 = r5
            goto L7d
        L4d:
            r6 = move-exception
            r1 = r5
            goto L51
        L50:
            r6 = move-exception
        L51:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r2 = "encrypt json exception "
            r5.<init>(r2)
            java.lang.String r6 = r6.getMessage()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
            goto L7d
        L67:
            if (r6 == 0) goto L7d
            if (r2 != 0) goto L6d
            r0 = 0
            goto L79
        L6d:
            java.lang.Object r0 = r2.first
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = getCryptFailedReason(r0)
        L79:
            org.json.JSONObject r1 = r6.encrypt(r5, r0)     // Catch: java.lang.Exception -> L7d
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.embedapplog.PangleEncryptUtilsType4.encryptType4WithNoWrapBase64(org.json.JSONObject, com.bytedance.sdk.component.embedapplog.IDefaultEncrypt):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<Integer, byte[]> encryptWithoutBase64(byte[] bArr) {
        Pair<Integer, byte[]> pair;
        Object obj;
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            pair = PglCryptUtils.getInstance().cypher4Encrypt(bArr);
        } catch (Throwable th2) {
            Log.e("pangle-encrypt", "encrypt exception " + th2.getMessage());
            pair = null;
        }
        int i11 = 0;
        if (pair != null && ((Integer) pair.first).intValue() == 0 && (obj = pair.second) != null && ((byte[]) obj).length > 0) {
            bArr2 = (byte[]) obj;
        } else if (pair != null) {
            i11 = getCryptFailedReason(((Integer) pair.first).intValue());
        }
        return new Pair<>(Integer.valueOf(i11), bArr2);
    }

    private static int getCryptFailedReason(int i11) {
        switch (i11) {
            case 501:
                return 6;
            case 502:
                return 4;
            case 503:
                return 1;
            case 504:
                return 3;
            case 505:
            case 506:
                return 2;
            default:
                return 0;
        }
    }
}
