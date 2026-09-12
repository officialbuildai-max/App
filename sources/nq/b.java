package nq;

import android.os.Build;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.Cipher;

/* loaded from: classes6.dex */
public class b extends n00.a {

    /* renamed from: a, reason: collision with root package name */
    private Cipher f70660a;

    /* renamed from: b, reason: collision with root package name */
    private Cipher f70661b;

    /* renamed from: c, reason: collision with root package name */
    private Key f70662c;

    /* renamed from: d, reason: collision with root package name */
    private Key f70663d;

    private void g() {
        try {
            i();
            if (this.f70660a == null) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.f70662c);
                this.f70660a = cipher;
            }
        } catch (NoClassDefFoundError unused) {
            throw new Exception("NoClassDefFound...");
        }
    }

    private void h() {
        i();
        if (this.f70661b == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f70663d);
            this.f70661b = cipher;
        }
    }

    private void i() {
        if (this.f70662c == null || this.f70663d == null) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (Build.VERSION.SDK_INT >= 28) {
                this.f70662c = keyStore.getKey("crypto", null);
                this.f70663d = keyStore.getCertificate("crypto").getPublicKey();
            } else {
                KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("crypto", null);
                this.f70662c = privateKeyEntry.getPrivateKey();
                this.f70663d = privateKeyEntry.getCertificate().getPublicKey();
            }
        }
    }

    public byte[] d(byte[] bArr) {
        g();
        return this.f70660a.doFinal(bArr);
    }

    public byte[] e(String str) {
        return f(str.getBytes(StandardCharsets.UTF_8));
    }

    public byte[] f(byte[] bArr) {
        h();
        return this.f70661b.doFinal(bArr);
    }
}
