package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.r;

/* loaded from: classes2.dex */
public abstract class l0 extends c {

    /* renamed from: l, reason: collision with root package name */
    private static final Void f12936l = null;

    /* renamed from: k, reason: collision with root package name */
    protected final r f12937k;

    /* JADX INFO: Access modifiers changed from: protected */
    public l0(r rVar) {
        this.f12937k = rVar;
    }

    protected r.b J(r.b bVar) {
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final r.b D(Void r12, r.b bVar) {
        return J(bVar);
    }

    protected long L(long j11, r.b bVar) {
        return j11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public final long E(Void r12, long j11, r.b bVar) {
        return L(j11, bVar);
    }

    protected int N(int i11) {
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public final int F(Void r12, int i11) {
        return N(i11);
    }

    protected abstract void P(androidx.media3.common.e0 e0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final void G(Void r12, r rVar, androidx.media3.common.e0 e0Var) {
        P(e0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R() {
        I(f12936l, this.f12937k);
    }

    protected void S() {
        R();
    }

    @Override // androidx.media3.exoplayer.source.r
    public androidx.media3.common.t a() {
        return this.f12937k.a();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public boolean b() {
        return this.f12937k.b();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public androidx.media3.common.e0 c() {
        return this.f12937k.c();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public void l(androidx.media3.common.t tVar) {
        this.f12937k.l(tVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public final void z(w1.n nVar) {
        super.z(nVar);
        S();
    }
}
