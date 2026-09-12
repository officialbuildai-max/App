package androidx.media3.exoplayer.hls;

import android.net.Uri;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
class a implements androidx.media3.datasource.a {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.datasource.a f11772a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f11773b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f11774c;

    /* renamed from: d, reason: collision with root package name */
    private CipherInputStream f11775d;

    public a(androidx.media3.datasource.a aVar, byte[] bArr, byte[] bArr2) {
        this.f11772a = aVar;
        this.f11773b = bArr;
        this.f11774c = bArr2;
    }

    @Override // androidx.media3.datasource.a
    public final long a(w1.h hVar) {
        try {
            Cipher d11 = d();
            try {
                d11.init(2, new SecretKeySpec(this.f11773b, "AES"), new IvParameterSpec(this.f11774c));
                w1.f fVar = new w1.f(this.f11772a, hVar);
                this.f11775d = new CipherInputStream(fVar, d11);
                fVar.h();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e11) {
                throw new RuntimeException(e11);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e12) {
            throw new RuntimeException(e12);
        }
    }

    @Override // androidx.media3.datasource.a
    public final void c(w1.n nVar) {
        androidx.media3.common.util.a.e(nVar);
        this.f11772a.c(nVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        if (this.f11775d != null) {
            this.f11775d = null;
            this.f11772a.close();
        }
    }

    protected Cipher d() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // androidx.media3.datasource.a
    public final Map getResponseHeaders() {
        return this.f11772a.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    public final Uri getUri() {
        return this.f11772a.getUri();
    }

    @Override // androidx.media3.common.j
    public final int read(byte[] bArr, int i11, int i12) {
        androidx.media3.common.util.a.e(this.f11775d);
        int read = this.f11775d.read(bArr, i11, i12);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
