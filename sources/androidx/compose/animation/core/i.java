package androidx.compose.animation.core;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class i implements a3 {

    /* renamed from: a, reason: collision with root package name */
    private final s0 f2525a;

    /* renamed from: b, reason: collision with root package name */
    private final i1 f2526b;

    /* renamed from: c, reason: collision with root package name */
    private o f2527c;

    /* renamed from: d, reason: collision with root package name */
    private long f2528d;

    /* renamed from: e, reason: collision with root package name */
    private long f2529e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2530f;

    public i(s0 s0Var, Object obj, o oVar, long j11, long j12, boolean z10) {
        i1 c11;
        o e11;
        this.f2525a = s0Var;
        c11 = u2.c(obj, null, 2, null);
        this.f2526b = c11;
        this.f2527c = (oVar == null || (e11 = p.e(oVar)) == null) ? j.i(s0Var, obj) : e11;
        this.f2528d = j11;
        this.f2529e = j12;
        this.f2530f = z10;
    }

    public /* synthetic */ i(s0 s0Var, Object obj, o oVar, long j11, long j12, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(s0Var, obj, (i11 & 4) != 0 ? null : oVar, (i11 & 8) != 0 ? Long.MIN_VALUE : j11, (i11 & 16) != 0 ? Long.MIN_VALUE : j12, (i11 & 32) != 0 ? false : z10);
    }

    public final long c() {
        return this.f2529e;
    }

    public final long d() {
        return this.f2528d;
    }

    public final s0 e() {
        return this.f2525a;
    }

    public final Object f() {
        return this.f2525a.b().invoke(this.f2527c);
    }

    public final o g() {
        return this.f2527c;
    }

    @Override // androidx.compose.runtime.a3
    public Object getValue() {
        return this.f2526b.getValue();
    }

    public final boolean h() {
        return this.f2530f;
    }

    public final void i(long j11) {
        this.f2529e = j11;
    }

    public final void j(long j11) {
        this.f2528d = j11;
    }

    public final void k(boolean z10) {
        this.f2530f = z10;
    }

    public void l(Object obj) {
        this.f2526b.setValue(obj);
    }

    public final void m(o oVar) {
        this.f2527c = oVar;
    }

    public String toString() {
        return "AnimationState(value=" + getValue() + ", velocity=" + f() + ", isRunning=" + this.f2530f + ", lastFrameTimeNanos=" + this.f2528d + ", finishedTimeNanos=" + this.f2529e + ')';
    }
}
