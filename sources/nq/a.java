package nq;

import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes6.dex */
public class a extends n00.a {

    /* renamed from: a, reason: collision with root package name */
    private Cipher f70658a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f70659b;

    public a(String str) {
        this.f70659b = b(str);
    }

    private void f() {
        if (this.f70658a == null) {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.f70659b));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            this.f70658a = cipher;
        }
    }

    public byte[] d(String str) {
        return e(str.getBytes(Charset.forName("UTF-8")));
    }

    public byte[] e(byte[] bArr) {
        f();
        return this.f70658a.doFinal(bArr);
    }
}
