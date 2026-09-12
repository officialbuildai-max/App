package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.k0;
import java.util.Map;

/* loaded from: classes3.dex */
final class k implements com.google.android.exoplayer2.upstream.k {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.k f26268a;

    /* renamed from: b, reason: collision with root package name */
    private final int f26269b;

    /* renamed from: c, reason: collision with root package name */
    private final a f26270c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f26271d;

    /* renamed from: e, reason: collision with root package name */
    private int f26272e;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.google.android.exoplayer2.util.d0 d0Var);
    }

    public k(com.google.android.exoplayer2.upstream.k kVar, int i11, a aVar) {
        com.google.android.exoplayer2.util.a.a(i11 > 0);
        this.f26268a = kVar;
        this.f26269b = i11;
        this.f26270c = aVar;
        this.f26271d = new byte[1];
        this.f26272e = i11;
    }

    private boolean f() {
        if (this.f26268a.read(this.f26271d, 0, 1) == -1) {
            return false;
        }
        int i11 = (this.f26271d[0] & 255) << 4;
        if (i11 == 0) {
            return true;
        }
        byte[] bArr = new byte[i11];
        int i12 = i11;
        int i13 = 0;
        while (i12 > 0) {
            int read = this.f26268a.read(bArr, i13, i12);
            if (read == -1) {
                return false;
            }
            i13 += read;
            i12 -= read;
        }
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        if (i11 > 0) {
            this.f26270c.a(new com.google.android.exoplayer2.util.d0(bArr, i11));
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(com.google.android.exoplayer2.upstream.n nVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f26268a.e(k0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map getResponseHeaders() {
        return this.f26268a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f26268a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (this.f26272e == 0) {
            if (!f()) {
                return -1;
            }
            this.f26272e = this.f26269b;
        }
        int read = this.f26268a.read(bArr, i11, Math.min(this.f26272e, i12));
        if (read != -1) {
            this.f26272e -= read;
        }
        return read;
    }
}
