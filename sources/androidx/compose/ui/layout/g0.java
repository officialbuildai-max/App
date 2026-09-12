package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public abstract class g0 implements z {

    /* renamed from: a, reason: collision with root package name */
    private int f5262a;

    /* renamed from: b, reason: collision with root package name */
    private int f5263b;

    /* renamed from: c, reason: collision with root package name */
    private long f5264c = o0.u.a(0, 0);

    /* renamed from: d, reason: collision with root package name */
    private long f5265d = PlaceableKt.c();

    /* renamed from: e, reason: collision with root package name */
    private long f5266e = o0.p.f70738b.a();

    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f5267a;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void f(g0 g0Var) {
            if (g0Var instanceof androidx.compose.ui.node.m0) {
                ((androidx.compose.ui.node.m0) g0Var).V(this.f5267a);
            }
        }

        public static /* synthetic */ void h(a aVar, g0 g0Var, int i11, int i12, float f11, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i13 & 4) != 0) {
                f11 = 0.0f;
            }
            aVar.g(g0Var, i11, i12, f11);
        }

        public static /* synthetic */ void j(a aVar, g0 g0Var, long j11, float f11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i11 & 2) != 0) {
                f11 = 0.0f;
            }
            aVar.i(g0Var, j11, f11);
        }

        public static /* synthetic */ void l(a aVar, g0 g0Var, int i11, int i12, float f11, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i13 & 4) != 0) {
                f11 = 0.0f;
            }
            aVar.k(g0Var, i11, i12, f11);
        }

        public static /* synthetic */ void n(a aVar, g0 g0Var, int i11, int i12, float f11, Function1 function1, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i13 & 4) != 0) {
                f11 = 0.0f;
            }
            float f12 = f11;
            if ((i13 & 8) != 0) {
                function1 = PlaceableKt.d();
            }
            aVar.m(g0Var, i11, i12, f12, function1);
        }

        public static /* synthetic */ void q(a aVar, g0 g0Var, long j11, float f11, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i11 & 2) != 0) {
                f11 = 0.0f;
            }
            float f12 = f11;
            if ((i11 & 4) != 0) {
                function1 = PlaceableKt.d();
            }
            aVar.o(g0Var, j11, f12, function1);
        }

        public static /* synthetic */ void r(a aVar, g0 g0Var, long j11, GraphicsLayer graphicsLayer, float f11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i11 & 4) != 0) {
                f11 = 0.0f;
            }
            aVar.p(g0Var, j11, graphicsLayer, f11);
        }

        public static /* synthetic */ void t(a aVar, g0 g0Var, int i11, int i12, float f11, Function1 function1, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i13 & 4) != 0) {
                f11 = 0.0f;
            }
            float f12 = f11;
            if ((i13 & 8) != 0) {
                function1 = PlaceableKt.d();
            }
            aVar.s(g0Var, i11, i12, f12, function1);
        }

        public static /* synthetic */ void w(a aVar, g0 g0Var, long j11, float f11, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i11 & 2) != 0) {
                f11 = 0.0f;
            }
            float f12 = f11;
            if ((i11 & 4) != 0) {
                function1 = PlaceableKt.d();
            }
            aVar.u(g0Var, j11, f12, function1);
        }

        public static /* synthetic */ void x(a aVar, g0 g0Var, long j11, GraphicsLayer graphicsLayer, float f11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i11 & 4) != 0) {
                f11 = 0.0f;
            }
            aVar.v(g0Var, j11, graphicsLayer, f11);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract LayoutDirection d();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int e();

        public final void g(g0 g0Var, int i11, int i12, float f11) {
            long a11 = o0.q.a(i11, i12);
            f(g0Var);
            g0Var.z0(o0.p.l(a11, g0Var.f5266e), f11, null);
        }

        public final void i(g0 g0Var, long j11, float f11) {
            f(g0Var);
            g0Var.z0(o0.p.l(j11, g0Var.f5266e), f11, null);
        }

        public final void k(g0 g0Var, int i11, int i12, float f11) {
            long a11 = o0.q.a(i11, i12);
            if (d() == LayoutDirection.Ltr || e() == 0) {
                f(g0Var);
                g0Var.z0(o0.p.l(a11, g0Var.f5266e), f11, null);
            } else {
                long a12 = o0.q.a((e() - g0Var.u0()) - o0.p.h(a11), o0.p.i(a11));
                f(g0Var);
                g0Var.z0(o0.p.l(a12, g0Var.f5266e), f11, null);
            }
        }

        public final void m(g0 g0Var, int i11, int i12, float f11, Function1 function1) {
            long a11 = o0.q.a(i11, i12);
            if (d() == LayoutDirection.Ltr || e() == 0) {
                f(g0Var);
                g0Var.z0(o0.p.l(a11, g0Var.f5266e), f11, function1);
            } else {
                long a12 = o0.q.a((e() - g0Var.u0()) - o0.p.h(a11), o0.p.i(a11));
                f(g0Var);
                g0Var.z0(o0.p.l(a12, g0Var.f5266e), f11, function1);
            }
        }

        public final void o(g0 g0Var, long j11, float f11, Function1 function1) {
            if (d() == LayoutDirection.Ltr || e() == 0) {
                f(g0Var);
                g0Var.z0(o0.p.l(j11, g0Var.f5266e), f11, function1);
            } else {
                long a11 = o0.q.a((e() - g0Var.u0()) - o0.p.h(j11), o0.p.i(j11));
                f(g0Var);
                g0Var.z0(o0.p.l(a11, g0Var.f5266e), f11, function1);
            }
        }

        public final void p(g0 g0Var, long j11, GraphicsLayer graphicsLayer, float f11) {
            if (d() == LayoutDirection.Ltr || e() == 0) {
                f(g0Var);
                g0Var.w0(o0.p.l(j11, g0Var.f5266e), f11, graphicsLayer);
            } else {
                long a11 = o0.q.a((e() - g0Var.u0()) - o0.p.h(j11), o0.p.i(j11));
                f(g0Var);
                g0Var.w0(o0.p.l(a11, g0Var.f5266e), f11, graphicsLayer);
            }
        }

        public final void s(g0 g0Var, int i11, int i12, float f11, Function1 function1) {
            long a11 = o0.q.a(i11, i12);
            f(g0Var);
            g0Var.z0(o0.p.l(a11, g0Var.f5266e), f11, function1);
        }

        public final void u(g0 g0Var, long j11, float f11, Function1 function1) {
            f(g0Var);
            g0Var.z0(o0.p.l(j11, g0Var.f5266e), f11, function1);
        }

        public final void v(g0 g0Var, long j11, GraphicsLayer graphicsLayer, float f11) {
            f(g0Var);
            g0Var.w0(o0.p.l(j11, g0Var.f5266e), f11, graphicsLayer);
        }
    }

    private final void v0() {
        this.f5262a = RangesKt.m(o0.t.g(this.f5264c), o0.b.n(this.f5265d), o0.b.l(this.f5265d));
        this.f5263b = RangesKt.m(o0.t.f(this.f5264c), o0.b.m(this.f5265d), o0.b.k(this.f5265d));
        this.f5266e = o0.q.a((this.f5262a - o0.t.g(this.f5264c)) / 2, (this.f5263b - o0.t.f(this.f5264c)) / 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B0(long j11) {
        if (o0.t.e(this.f5264c, j11)) {
            return;
        }
        this.f5264c = j11;
        v0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F0(long j11) {
        if (o0.b.f(this.f5265d, j11)) {
            return;
        }
        this.f5265d = j11;
        v0();
    }

    public /* synthetic */ Object G() {
        return y.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long k0() {
        return this.f5266e;
    }

    public final int l0() {
        return this.f5263b;
    }

    public int o0() {
        return o0.t.f(this.f5264c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long r0() {
        return this.f5264c;
    }

    public int s0() {
        return o0.t.g(this.f5264c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long t0() {
        return this.f5265d;
    }

    public final int u0() {
        return this.f5262a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w0(long j11, float f11, GraphicsLayer graphicsLayer) {
        z0(j11, f11, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void z0(long j11, float f11, Function1 function1);
}
