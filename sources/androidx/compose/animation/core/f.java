package androidx.compose.animation.core;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final s0 f2501a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f2502b;

    /* renamed from: c, reason: collision with root package name */
    private final long f2503c;

    /* renamed from: d, reason: collision with root package name */
    private final Function0 f2504d;

    /* renamed from: e, reason: collision with root package name */
    private final i1 f2505e;

    /* renamed from: f, reason: collision with root package name */
    private o f2506f;

    /* renamed from: g, reason: collision with root package name */
    private long f2507g;

    /* renamed from: h, reason: collision with root package name */
    private long f2508h;

    /* renamed from: i, reason: collision with root package name */
    private final i1 f2509i;

    public f(Object obj, s0 s0Var, o oVar, long j11, Object obj2, long j12, boolean z10, Function0 function0) {
        i1 c11;
        i1 c12;
        this.f2501a = s0Var;
        this.f2502b = obj2;
        this.f2503c = j12;
        this.f2504d = function0;
        c11 = u2.c(obj, null, 2, null);
        this.f2505e = c11;
        this.f2506f = p.e(oVar);
        this.f2507g = j11;
        this.f2508h = Long.MIN_VALUE;
        c12 = u2.c(Boolean.valueOf(z10), null, 2, null);
        this.f2509i = c12;
    }

    public final void a() {
        k(false);
        this.f2504d.invoke();
    }

    public final long b() {
        return this.f2508h;
    }

    public final long c() {
        return this.f2507g;
    }

    public final long d() {
        return this.f2503c;
    }

    public final Object e() {
        return this.f2505e.getValue();
    }

    public final Object f() {
        return this.f2501a.b().invoke(this.f2506f);
    }

    public final o g() {
        return this.f2506f;
    }

    public final boolean h() {
        return ((Boolean) this.f2509i.getValue()).booleanValue();
    }

    public final void i(long j11) {
        this.f2508h = j11;
    }

    public final void j(long j11) {
        this.f2507g = j11;
    }

    public final void k(boolean z10) {
        this.f2509i.setValue(Boolean.valueOf(z10));
    }

    public final void l(Object obj) {
        this.f2505e.setValue(obj);
    }

    public final void m(o oVar) {
        this.f2506f = oVar;
    }
}
