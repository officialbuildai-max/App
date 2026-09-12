package sk;

import android.content.Context;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

/* loaded from: classes6.dex */
public class d extends rk.a {

    /* renamed from: a, reason: collision with root package name */
    private Cipher f75505a;

    /* renamed from: b, reason: collision with root package name */
    private Cipher f75506b;

    public d(Context context) {
        e.b().a(context);
    }

    private void f() {
        if (h() == null) {
            throw new Exception("key not created, please try later");
        }
        if (this.f75505a == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, h());
            this.f75505a = cipher;
        }
    }

    private void g() {
        if (i() == null) {
            throw new Exception("key not created, please try later");
        }
        if (this.f75506b == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, i());
            this.f75506b = cipher;
        }
    }

    private static PrivateKey h() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return (PrivateKey) keyStore.getKey("crypto", null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static PublicKey i() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getCertificate("crypto").getPublicKey();
        } catch (Exception unused) {
            return null;
        }
    }

    public byte[] d(byte[] bArr) {
        f();
        return this.f75505a.doFinal(bArr);
    }

    public byte[] e(byte[] bArr) {
        g();
        return this.f75506b.doFinal(bArr);
    }
}
