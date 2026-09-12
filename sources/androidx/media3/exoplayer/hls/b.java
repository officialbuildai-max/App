package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.p0;
import i3.s;
import l2.l0;
import s3.k0;

/* loaded from: classes2.dex */
public final class b implements j {

    /* renamed from: f, reason: collision with root package name */
    private static final l0 f11776f = new l0();

    /* renamed from: a, reason: collision with root package name */
    final l2.r f11777a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.r f11778b;

    /* renamed from: c, reason: collision with root package name */
    private final p0 f11779c;

    /* renamed from: d, reason: collision with root package name */
    private final s.a f11780d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f11781e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(l2.r rVar, androidx.media3.common.r rVar2, p0 p0Var, s.a aVar, boolean z10) {
        this.f11777a = rVar;
        this.f11778b = rVar2;
        this.f11779c = p0Var;
        this.f11780d = aVar;
        this.f11781e = z10;
    }

    @Override // androidx.media3.exoplayer.hls.j
    public boolean a(l2.s sVar) {
        return this.f11777a.c(sVar, f11776f) == 0;
    }

    @Override // androidx.media3.exoplayer.hls.j
    public void b(l2.t tVar) {
        this.f11777a.b(tVar);
    }

    @Override // androidx.media3.exoplayer.hls.j
    public void c() {
        this.f11777a.seek(0L, 0L);
    }

    @Override // androidx.media3.exoplayer.hls.j
    public boolean d() {
        l2.r e11 = this.f11777a.e();
        return (e11 instanceof k0) || (e11 instanceof f3.h);
    }

    @Override // androidx.media3.exoplayer.hls.j
    public boolean e() {
        l2.r e11 = this.f11777a.e();
        return (e11 instanceof s3.h) || (e11 instanceof s3.b) || (e11 instanceof s3.e) || (e11 instanceof e3.f);
    }

    @Override // androidx.media3.exoplayer.hls.j
    public j f() {
        l2.r fVar;
        androidx.media3.common.util.a.g(!d());
        androidx.media3.common.util.a.h(this.f11777a.e() == this.f11777a, "Can't recreate wrapped extractors. Outer type: " + this.f11777a.getClass());
        l2.r rVar = this.f11777a;
        if (rVar instanceof u) {
            fVar = new u(this.f11778b.f10232d, this.f11779c, this.f11780d, this.f11781e);
        } else if (rVar instanceof s3.h) {
            fVar = new s3.h();
        } else if (rVar instanceof s3.b) {
            fVar = new s3.b();
        } else if (rVar instanceof s3.e) {
            fVar = new s3.e();
        } else {
            if (!(rVar instanceof e3.f)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f11777a.getClass().getSimpleName());
            }
            fVar = new e3.f();
        }
        return new b(fVar, this.f11778b, this.f11779c, this.f11780d, this.f11781e);
    }
}
