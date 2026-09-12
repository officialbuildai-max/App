package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes3.dex */
public final class j0 implements k {

    /* renamed from: a, reason: collision with root package name */
    private final k f27481a;

    /* renamed from: b, reason: collision with root package name */
    private final i f27482b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f27483c;

    /* renamed from: d, reason: collision with root package name */
    private long f27484d;

    public j0(k kVar, i iVar) {
        this.f27481a = (k) com.google.android.exoplayer2.util.a.e(kVar);
        this.f27482b = (i) com.google.android.exoplayer2.util.a.e(iVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        long a11 = this.f27481a.a(nVar);
        this.f27484d = a11;
        if (a11 == 0) {
            return 0L;
        }
        if (nVar.f27498h == -1 && a11 != -1) {
            nVar = nVar.f(0L, a11);
        }
        this.f27483c = true;
        this.f27482b.a(nVar);
        return this.f27484d;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        try {
            this.f27481a.close();
        } finally {
            if (this.f27483c) {
                this.f27483c = false;
                this.f27482b.close();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f27481a.e(k0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map getResponseHeaders() {
        return this.f27481a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f27481a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (this.f27484d == 0) {
            return -1;
        }
        int read = this.f27481a.read(bArr, i11, i12);
        if (read > 0) {
            this.f27482b.write(bArr, i11, read);
            long j11 = this.f27484d;
            if (j11 != -1) {
                this.f27484d = j11 - read;
            }
        }
        return read;
    }
}
