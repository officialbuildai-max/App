package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.util.Map;

/* loaded from: classes3.dex */
public final class e0 implements k {

    /* renamed from: a, reason: collision with root package name */
    private final k f27454a;

    /* renamed from: b, reason: collision with root package name */
    private final PriorityTaskManager f27455b;

    /* renamed from: c, reason: collision with root package name */
    private final int f27456c;

    public e0(k kVar, PriorityTaskManager priorityTaskManager, int i11) {
        this.f27454a = (k) com.google.android.exoplayer2.util.a.e(kVar);
        this.f27455b = (PriorityTaskManager) com.google.android.exoplayer2.util.a.e(priorityTaskManager);
        this.f27456c = i11;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        this.f27455b.c(this.f27456c);
        return this.f27454a.a(nVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f27454a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f27454a.e(k0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map getResponseHeaders() {
        return this.f27454a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f27454a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        this.f27455b.c(this.f27456c);
        return this.f27454a.read(bArr, i11, i12);
    }
}
