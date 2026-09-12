package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import e0.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import o0.a0;
import o0.z;
import y.g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final VelocityTracker1D.Strategy f5125a;

    /* renamed from: b, reason: collision with root package name */
    private final VelocityTracker1D f5126b;

    /* renamed from: c, reason: collision with root package name */
    private final VelocityTracker1D f5127c;

    /* renamed from: d, reason: collision with root package name */
    private long f5128d;

    /* renamed from: e, reason: collision with root package name */
    private long f5129e;

    public a() {
        VelocityTracker1D.Strategy strategy = c.h() ? VelocityTracker1D.Strategy.Impulse : VelocityTracker1D.Strategy.Lsq2;
        this.f5125a = strategy;
        boolean z10 = false;
        int i11 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.f5126b = new VelocityTracker1D(z10, strategy, i11, defaultConstructorMarker);
        this.f5127c = new VelocityTracker1D(z10, strategy, i11, defaultConstructorMarker);
        this.f5128d = g.f78593b.c();
    }

    public final void a(long j11, long j12) {
        this.f5126b.a(j11, g.m(j12));
        this.f5127c.a(j11, g.n(j12));
    }

    public final long b(long j11) {
        if (!(z.h(j11) > 0.0f && z.i(j11) > 0.0f)) {
            g0.a.b("maximumVelocity should be a positive value. You specified=" + ((Object) z.m(j11)));
        }
        return a0.a(this.f5126b.d(z.h(j11)), this.f5127c.d(z.i(j11)));
    }

    public final long c() {
        return this.f5128d;
    }

    public final long d() {
        return this.f5129e;
    }

    public final void e() {
        this.f5126b.e();
        this.f5127c.e();
        this.f5129e = 0L;
    }

    public final void f(long j11) {
        this.f5128d = j11;
    }

    public final void g(long j11) {
        this.f5129e = j11;
    }
}
