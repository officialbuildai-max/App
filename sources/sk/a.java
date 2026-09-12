package sk;

import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class a extends rk.a {

    /* renamed from: a, reason: collision with root package name */
    private Cipher f75496a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f75497b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f75498c;

    public a(byte[] bArr, byte[] bArr2) {
        this.f75498c = bArr;
        this.f75497b = bArr2;
        if (bArr.length != 16 && bArr.length != 24 && bArr.length != 32) {
            throw new IOException();
        }
        if (bArr2.length != 16) {
            throw new IOException();
        }
    }

    private void e() {
        if (this.f75496a == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.f75498c, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f75497b);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            this.f75496a = cipher;
        }
    }

    public byte[] d(byte[] bArr) {
        e();
        return this.f75496a.doFinal(bArr);
    }
}
