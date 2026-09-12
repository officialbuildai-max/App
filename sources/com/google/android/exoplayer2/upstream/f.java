package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class f implements k {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f27457a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f27458b = new ArrayList(1);

    /* renamed from: c, reason: collision with root package name */
    private int f27459c;

    /* renamed from: d, reason: collision with root package name */
    private n f27460d;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(boolean z10) {
        this.f27457a = z10;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public final void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        if (this.f27458b.contains(k0Var)) {
            return;
        }
        this.f27458b.add(k0Var);
        this.f27459c++;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public /* synthetic */ Map getResponseHeaders() {
        return j.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(int i11) {
        n nVar = (n) p0.j(this.f27460d);
        for (int i12 = 0; i12 < this.f27459c; i12++) {
            ((k0) this.f27458b.get(i12)).e(this, nVar, this.f27457a, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        n nVar = (n) p0.j(this.f27460d);
        for (int i11 = 0; i11 < this.f27459c; i11++) {
            ((k0) this.f27458b.get(i11)).c(this, nVar, this.f27457a);
        }
        this.f27460d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(n nVar) {
        for (int i11 = 0; i11 < this.f27459c; i11++) {
            ((k0) this.f27458b.get(i11)).h(this, nVar, this.f27457a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(n nVar) {
        this.f27460d = nVar;
        for (int i11 = 0; i11 < this.f27459c; i11++) {
            ((k0) this.f27458b.get(i11)).g(this, nVar, this.f27457a);
        }
    }
}
