package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class p0 implements c {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f2556a;

    /* renamed from: b, reason: collision with root package name */
    private final s0 f2557b;

    /* renamed from: c, reason: collision with root package name */
    private Object f2558c;

    /* renamed from: d, reason: collision with root package name */
    private Object f2559d;

    /* renamed from: e, reason: collision with root package name */
    private o f2560e;

    /* renamed from: f, reason: collision with root package name */
    private o f2561f;

    /* renamed from: g, reason: collision with root package name */
    private final o f2562g;

    /* renamed from: h, reason: collision with root package name */
    private long f2563h;

    /* renamed from: i, reason: collision with root package name */
    private o f2564i;

    public p0(g gVar, s0 s0Var, Object obj, Object obj2, o oVar) {
        this(gVar.a(s0Var), s0Var, obj, obj2, oVar);
    }

    public p0(v0 v0Var, s0 s0Var, Object obj, Object obj2, o oVar) {
        o e11;
        this.f2556a = v0Var;
        this.f2557b = s0Var;
        this.f2558c = obj2;
        this.f2559d = obj;
        this.f2560e = (o) e().a().invoke(obj);
        this.f2561f = (o) e().a().invoke(obj2);
        this.f2562g = (oVar == null || (e11 = p.e(oVar)) == null) ? p.g((o) e().a().invoke(obj)) : e11;
        this.f2563h = -1L;
    }

    private final o h() {
        o oVar = this.f2564i;
        if (oVar != null) {
            return oVar;
        }
        o c11 = this.f2556a.c(this.f2560e, this.f2561f, this.f2562g);
        this.f2564i = c11;
        return c11;
    }

    @Override // androidx.compose.animation.core.c
    public boolean a() {
        return this.f2556a.a();
    }

    @Override // androidx.compose.animation.core.c
    public o b(long j11) {
        return !c(j11) ? this.f2556a.e(j11, this.f2560e, this.f2561f, this.f2562g) : h();
    }

    @Override // androidx.compose.animation.core.c
    public /* synthetic */ boolean c(long j11) {
        return b.a(this, j11);
    }

    @Override // androidx.compose.animation.core.c
    public long d() {
        if (this.f2563h < 0) {
            this.f2563h = this.f2556a.f(this.f2560e, this.f2561f, this.f2562g);
        }
        return this.f2563h;
    }

    @Override // androidx.compose.animation.core.c
    public s0 e() {
        return this.f2557b;
    }

    @Override // androidx.compose.animation.core.c
    public Object f(long j11) {
        if (c(j11)) {
            return g();
        }
        o g11 = this.f2556a.g(j11, this.f2560e, this.f2561f, this.f2562g);
        int b11 = g11.b();
        for (int i11 = 0; i11 < b11; i11++) {
            if (Float.isNaN(g11.a(i11))) {
                k0.b("AnimationVector cannot contain a NaN. " + g11 + ". Animation: " + this + ", playTimeNanos: " + j11);
            }
        }
        return e().b().invoke(g11);
    }

    @Override // androidx.compose.animation.core.c
    public Object g() {
        return this.f2558c;
    }

    public final Object i() {
        return this.f2559d;
    }

    public String toString() {
        return "TargetBasedAnimation: " + i() + " -> " + g() + ",initial velocity: " + this.f2562g + ", duration: " + d.b(this) + " ms,animationSpec: " + this.f2556a;
    }
}
