package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f35733b = new byte[32];

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f35732a = new byte[16];

    /* renamed from: com.mbridge.msdk.foundation.tools.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0495a extends Provider {
        public C0495a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    static {
        a(i0.a("HkzwDFeD4QuyLdx5igfZYcu9xTM9NN=="));
    }

    public static String a(String str, byte[] bArr, byte[] bArr2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Security.addProvider(new C0495a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 0));
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] digest = MessageDigest.getInstance("sha-384").digest(str.getBytes());
            System.arraycopy(digest, 0, f35733b, 0, 32);
            System.arraycopy(digest, 32, f35732a, 0, 16);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static String b(String str) {
        return a(str, f35733b, f35732a);
    }
}
