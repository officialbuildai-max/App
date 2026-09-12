package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class i0 implements k {

    /* renamed from: a, reason: collision with root package name */
    private final k f27477a;

    /* renamed from: b, reason: collision with root package name */
    private long f27478b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f27479c = Uri.EMPTY;

    /* renamed from: d, reason: collision with root package name */
    private Map f27480d = Collections.emptyMap();

    public i0(k kVar) {
        this.f27477a = (k) com.google.android.exoplayer2.util.a.e(kVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        this.f27479c = nVar.f27491a;
        this.f27480d = Collections.emptyMap();
        long a11 = this.f27477a.a(nVar);
        this.f27479c = (Uri) com.google.android.exoplayer2.util.a.e(getUri());
        this.f27480d = getResponseHeaders();
        return a11;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f27477a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f27477a.e(k0Var);
    }

    public long f() {
        return this.f27478b;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map getResponseHeaders() {
        return this.f27477a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f27477a.getUri();
    }

    public Uri h() {
        return this.f27479c;
    }

    public Map i() {
        return this.f27480d;
    }

    public void j() {
        this.f27478b = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        int read = this.f27477a.read(bArr, i11, i12);
        if (read != -1) {
            this.f27478b += read;
        }
        return read;
    }
}
