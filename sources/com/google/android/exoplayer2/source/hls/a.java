package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.k0;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
class a implements com.google.android.exoplayer2.upstream.k {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.k f25989a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f25990b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f25991c;

    /* renamed from: d, reason: collision with root package name */
    private CipherInputStream f25992d;

    public a(com.google.android.exoplayer2.upstream.k kVar, byte[] bArr, byte[] bArr2) {
        this.f25989a = kVar;
        this.f25990b = bArr;
        this.f25991c = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public final long a(com.google.android.exoplayer2.upstream.n nVar) {
        try {
            Cipher f11 = f();
            try {
                f11.init(2, new SecretKeySpec(this.f25990b, "AES"), new IvParameterSpec(this.f25991c));
                com.google.android.exoplayer2.upstream.l lVar = new com.google.android.exoplayer2.upstream.l(this.f25989a, nVar);
                this.f25992d = new CipherInputStream(lVar, f11);
                lVar.h();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e11) {
                throw new RuntimeException(e11);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e12) {
            throw new RuntimeException(e12);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        if (this.f25992d != null) {
            this.f25992d = null;
            this.f25989a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public final void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f25989a.e(k0Var);
    }

    protected Cipher f() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public final Map getResponseHeaders() {
        return this.f25989a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public final Uri getUri() {
        return this.f25989a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public final int read(byte[] bArr, int i11, int i12) {
        com.google.android.exoplayer2.util.a.e(this.f25992d);
        int read = this.f25992d.read(bArr, i11, i12);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
