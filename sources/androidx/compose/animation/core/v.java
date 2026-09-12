package androidx.compose.animation.core;

import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class v implements c {

    /* renamed from: a, reason: collision with root package name */
    private final x0 f2578a;

    /* renamed from: b, reason: collision with root package name */
    private final s0 f2579b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f2580c;

    /* renamed from: d, reason: collision with root package name */
    private final o f2581d;

    /* renamed from: e, reason: collision with root package name */
    private final o f2582e;

    /* renamed from: f, reason: collision with root package name */
    private final o f2583f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f2584g;

    /* renamed from: h, reason: collision with root package name */
    private final long f2585h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f2586i;

    public v(w wVar, s0 s0Var, Object obj, o oVar) {
        this(wVar.a(s0Var), s0Var, obj, oVar);
    }

    public v(x0 x0Var, s0 s0Var, Object obj, o oVar) {
        this.f2578a = x0Var;
        this.f2579b = s0Var;
        this.f2580c = obj;
        o oVar2 = (o) e().a().invoke(obj);
        this.f2581d = oVar2;
        this.f2582e = p.e(oVar);
        this.f2584g = e().b().invoke(x0Var.d(oVar2, oVar));
        this.f2585h = x0Var.c(oVar2, oVar);
        o e11 = p.e(x0Var.b(d(), oVar2, oVar));
        this.f2583f = e11;
        int b11 = e11.b();
        for (int i11 = 0; i11 < b11; i11++) {
            o oVar3 = this.f2583f;
            oVar3.e(i11, RangesKt.l(oVar3.a(i11), -this.f2578a.a(), this.f2578a.a()));
        }
    }

    @Override // androidx.compose.animation.core.c
    public boolean a() {
        return this.f2586i;
    }

    @Override // androidx.compose.animation.core.c
    public o b(long j11) {
        return !c(j11) ? this.f2578a.b(j11, this.f2581d, this.f2582e) : this.f2583f;
    }

    @Override // androidx.compose.animation.core.c
    public /* synthetic */ boolean c(long j11) {
        return b.a(this, j11);
    }

    @Override // androidx.compose.animation.core.c
    public long d() {
        return this.f2585h;
    }

    @Override // androidx.compose.animation.core.c
    public s0 e() {
        return this.f2579b;
    }

    @Override // androidx.compose.animation.core.c
    public Object f(long j11) {
        return !c(j11) ? e().b().invoke(this.f2578a.e(j11, this.f2581d, this.f2582e)) : g();
    }

    @Override // androidx.compose.animation.core.c
    public Object g() {
        return this.f2584g;
    }
}
