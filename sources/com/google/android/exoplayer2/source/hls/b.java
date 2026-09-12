package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.l0;
import g9.a0;
import q9.h0;

/* loaded from: classes3.dex */
public final class b implements j {

    /* renamed from: d, reason: collision with root package name */
    private static final a0 f25993d = new a0();

    /* renamed from: a, reason: collision with root package name */
    final g9.l f25994a;

    /* renamed from: b, reason: collision with root package name */
    private final o1 f25995b;

    /* renamed from: c, reason: collision with root package name */
    private final l0 f25996c;

    public b(g9.l lVar, o1 o1Var, l0 l0Var) {
        this.f25994a = lVar;
        this.f25995b = o1Var;
        this.f25996c = l0Var;
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public boolean a(g9.m mVar) {
        return this.f25994a.c(mVar, f25993d) == 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public void b(g9.n nVar) {
        this.f25994a.b(nVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public void c() {
        this.f25994a.seek(0L, 0L);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public boolean d() {
        g9.l lVar = this.f25994a;
        return (lVar instanceof h0) || (lVar instanceof o9.g);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public boolean e() {
        g9.l lVar = this.f25994a;
        return (lVar instanceof q9.h) || (lVar instanceof q9.b) || (lVar instanceof q9.e) || (lVar instanceof n9.f);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public j f() {
        g9.l fVar;
        com.google.android.exoplayer2.util.a.g(!d());
        g9.l lVar = this.f25994a;
        if (lVar instanceof r) {
            fVar = new r(this.f25995b.f25541c, this.f25996c);
        } else if (lVar instanceof q9.h) {
            fVar = new q9.h();
        } else if (lVar instanceof q9.b) {
            fVar = new q9.b();
        } else if (lVar instanceof q9.e) {
            fVar = new q9.e();
        } else {
            if (!(lVar instanceof n9.f)) {
                String simpleName = this.f25994a.getClass().getSimpleName();
                throw new IllegalStateException(simpleName.length() != 0 ? "Unexpected extractor type for recreation: ".concat(simpleName) : new String("Unexpected extractor type for recreation: "));
            }
            fVar = new n9.f();
        }
        return new b(fVar, this.f25995b, this.f25996c);
    }
}
