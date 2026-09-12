package sk;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes6.dex */
public class c extends rk.a {

    /* renamed from: a, reason: collision with root package name */
    private Cipher f75503a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f75504b;

    public c(String str) {
        this.f75504b = b(str);
    }

    private void e() {
        if (this.f75503a == null) {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.f75504b));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            this.f75503a = cipher;
        }
    }

    private boolean f(byte[] bArr, byte[] bArr2) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.f75504b));
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(generatePublic);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    public byte[] d(byte[] bArr) {
        e();
        return this.f75503a.doFinal(bArr);
    }

    public boolean g(byte[] bArr, byte[] bArr2) {
        return f(bArr, bArr2);
    }
}
