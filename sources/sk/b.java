package sk;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class b extends rk.a {

    /* renamed from: a, reason: collision with root package name */
    private Cipher f75499a;

    /* renamed from: b, reason: collision with root package name */
    private Cipher f75500b;

    /* renamed from: c, reason: collision with root package name */
    private SecretKeySpec f75501c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f75502d;

    private void g() {
        if (this.f75501c == null || this.f75502d == null) {
            throw new Exception("please call encrypt method first");
        }
        if (this.f75499a == null) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f75502d);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, this.f75501c, ivParameterSpec);
            this.f75499a = cipher;
        }
    }

    private void h() {
        if (this.f75500b == null) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey generateKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, generateKey);
            this.f75501c = new SecretKeySpec(generateKey.getEncoded(), "AES");
            this.f75502d = cipher.getIV();
            this.f75500b = cipher;
        }
    }

    public byte[] d(byte[] bArr) {
        g();
        return this.f75499a.doFinal(bArr);
    }

    public byte[] e(String str) {
        return f(str.getBytes("UTF-8"));
    }

    public byte[] f(byte[] bArr) {
        h();
        return this.f75500b.doFinal(bArr);
    }

    public byte[] i() {
        SecretKeySpec secretKeySpec;
        if (this.f75502d == null || (secretKeySpec = this.f75501c) == null || secretKeySpec.getEncoded() == null) {
            throw new Exception("no valid key info");
        }
        byte[] encoded = this.f75501c.getEncoded();
        byte[] bArr = this.f75502d;
        if (encoded.length != 32 || bArr.length != 16) {
            throw new Exception("key length is not valid");
        }
        byte[] bArr2 = new byte[48];
        System.arraycopy(encoded, 0, bArr2, 0, 32);
        System.arraycopy(bArr, 0, bArr2, 32, 16);
        return bArr2;
    }
}
