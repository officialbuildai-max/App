package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.os.Build;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.a4;
import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.i4;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.w3;
import androidx.compose.ui.graphics.x4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class GraphicsLayerOwnerLayer implements androidx.compose.ui.node.w0 {

    /* renamed from: a, reason: collision with root package name */
    private GraphicsLayer f5718a;

    /* renamed from: b, reason: collision with root package name */
    private final a4 f5719b;

    /* renamed from: c, reason: collision with root package name */
    private final AndroidComposeView f5720c;

    /* renamed from: d, reason: collision with root package name */
    private Function2 f5721d;

    /* renamed from: e, reason: collision with root package name */
    private Function0 f5722e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5724g;

    /* renamed from: i, reason: collision with root package name */
    private float[] f5726i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5727j;

    /* renamed from: n, reason: collision with root package name */
    private int f5731n;

    /* renamed from: p, reason: collision with root package name */
    private k4 f5733p;

    /* renamed from: q, reason: collision with root package name */
    private Path f5734q;

    /* renamed from: r, reason: collision with root package name */
    private m4 f5735r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f5736s;

    /* renamed from: f, reason: collision with root package name */
    private long f5723f = o0.u.a(Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: h, reason: collision with root package name */
    private final float[] f5725h = i4.c(null, 1, null);

    /* renamed from: k, reason: collision with root package name */
    private o0.e f5728k = o0.g.b(1.0f, 0.0f, 2, null);

    /* renamed from: l, reason: collision with root package name */
    private LayoutDirection f5729l = LayoutDirection.Ltr;

    /* renamed from: m, reason: collision with root package name */
    private final z.a f5730m = new z.a();

    /* renamed from: o, reason: collision with root package name */
    private long f5732o = e5.f4511a.a();

    /* renamed from: t, reason: collision with root package name */
    private final Function1 f5737t = new Function1<z.g, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((z.g) obj);
            return Unit.f67184a;
        }

        public final void invoke(z.g gVar) {
            Function2 function2;
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = GraphicsLayerOwnerLayer.this;
            androidx.compose.ui.graphics.m1 e11 = gVar.H0().e();
            function2 = graphicsLayerOwnerLayer.f5721d;
            if (function2 != null) {
                function2.invoke(e11, gVar.H0().g());
            }
        }
    };

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, a4 a4Var, AndroidComposeView androidComposeView, Function2 function2, Function0 function0) {
        this.f5718a = graphicsLayer;
        this.f5719b = a4Var;
        this.f5720c = androidComposeView;
        this.f5721d = function2;
        this.f5722e = function0;
    }

    private final void b(androidx.compose.ui.graphics.m1 m1Var) {
        if (this.f5718a.k()) {
            k4 n11 = this.f5718a.n();
            if (n11 instanceof k4.b) {
                androidx.compose.ui.graphics.l1.e(m1Var, ((k4.b) n11).b(), 0, 2, null);
                return;
            }
            if (!(n11 instanceof k4.c)) {
                if (n11 instanceof k4.a) {
                    androidx.compose.ui.graphics.l1.c(m1Var, ((k4.a) n11).b(), 0, 2, null);
                    return;
                }
                return;
            }
            Path path = this.f5734q;
            if (path == null) {
                path = androidx.compose.ui.graphics.x0.a();
                this.f5734q = path;
            }
            path.reset();
            o4.b(path, ((k4.c) n11).b(), null, 2, null);
            androidx.compose.ui.graphics.l1.c(m1Var, path, 0, 2, null);
        }
    }

    private final float[] c() {
        float[] d11 = d();
        float[] fArr = this.f5726i;
        if (fArr == null) {
            fArr = i4.c(null, 1, null);
            this.f5726i = fArr;
        }
        if (b1.a(d11, fArr)) {
            return fArr;
        }
        return null;
    }

    private final float[] d() {
        g();
        return this.f5725h;
    }

    private final void e(boolean z10) {
        if (z10 != this.f5727j) {
            this.f5727j = z10;
            this.f5720c.notifyLayerIsDirty$ui_release(this, z10);
        }
    }

    private final void f() {
        if (Build.VERSION.SDK_INT >= 26) {
            a3.f5806a.a(this.f5720c);
        } else {
            this.f5720c.invalidate();
        }
    }

    private final void g() {
        GraphicsLayer graphicsLayer = this.f5718a;
        long b11 = y.h.d(graphicsLayer.o()) ? y.n.b(o0.u.d(this.f5723f)) : graphicsLayer.o();
        i4.h(this.f5725h);
        float[] fArr = this.f5725h;
        float[] c11 = i4.c(null, 1, null);
        i4.q(c11, -y.g.m(b11), -y.g.n(b11), 0.0f, 4, null);
        i4.n(fArr, c11);
        float[] fArr2 = this.f5725h;
        float[] c12 = i4.c(null, 1, null);
        i4.q(c12, graphicsLayer.x(), graphicsLayer.y(), 0.0f, 4, null);
        i4.i(c12, graphicsLayer.p());
        i4.j(c12, graphicsLayer.q());
        i4.k(c12, graphicsLayer.r());
        i4.m(c12, graphicsLayer.s(), graphicsLayer.t(), 0.0f, 4, null);
        i4.n(fArr2, c12);
        float[] fArr3 = this.f5725h;
        float[] c13 = i4.c(null, 1, null);
        i4.q(c13, y.g.m(b11), y.g.n(b11), 0.0f, 4, null);
        i4.n(fArr3, c13);
    }

    private final void h() {
        Function0 function0;
        k4 k4Var = this.f5733p;
        if (k4Var == null) {
            return;
        }
        androidx.compose.ui.graphics.layer.d.b(this.f5718a, k4Var);
        if (!(k4Var instanceof k4.a) || Build.VERSION.SDK_INT >= 33 || (function0 = this.f5722e) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.compose.ui.node.w0
    public void destroy() {
        this.f5721d = null;
        this.f5722e = null;
        this.f5724g = true;
        e(false);
        a4 a4Var = this.f5719b;
        if (a4Var != null) {
            a4Var.b(this.f5718a);
            this.f5720c.recycle$ui_release(this);
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void drawLayer(androidx.compose.ui.graphics.m1 m1Var, GraphicsLayer graphicsLayer) {
        Canvas d11 = androidx.compose.ui.graphics.h0.d(m1Var);
        if (d11.isHardwareAccelerated()) {
            updateDisplayList();
            this.f5736s = this.f5718a.u() > 0.0f;
            z.d H0 = this.f5730m.H0();
            H0.h(m1Var);
            H0.d(graphicsLayer);
            androidx.compose.ui.graphics.layer.d.a(this.f5730m, this.f5718a);
            return;
        }
        float h11 = o0.p.h(this.f5718a.w());
        float i11 = o0.p.i(this.f5718a.w());
        float g11 = h11 + o0.t.g(this.f5723f);
        float f11 = i11 + o0.t.f(this.f5723f);
        if (this.f5718a.i() < 1.0f) {
            m4 m4Var = this.f5735r;
            if (m4Var == null) {
                m4Var = androidx.compose.ui.graphics.t0.a();
                this.f5735r = m4Var;
            }
            m4Var.setAlpha(this.f5718a.i());
            d11.saveLayer(h11, i11, g11, f11, m4Var.w());
        } else {
            m1Var.n();
        }
        m1Var.c(h11, i11);
        m1Var.p(d());
        if (this.f5718a.k()) {
            b(m1Var);
        }
        Function2 function2 = this.f5721d;
        if (function2 != null) {
            function2.invoke(m1Var, null);
        }
        m1Var.j();
    }

    @Override // androidx.compose.ui.node.w0
    public void invalidate() {
        if (this.f5727j || this.f5724g) {
            return;
        }
        this.f5720c.invalidate();
        e(true);
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo138isInLayerk4lQ0M(long j11) {
        float m11 = y.g.m(j11);
        float n11 = y.g.n(j11);
        if (this.f5718a.k()) {
            return f2.c(this.f5718a.n(), m11, n11, null, null, 24, null);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.w0
    public void mapBounds(y.e eVar, boolean z10) {
        if (!z10) {
            i4.g(d(), eVar);
            return;
        }
        float[] c11 = c();
        if (c11 == null) {
            eVar.g(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            i4.g(c11, eVar);
        }
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: mapOffset-8S9VItk */
    public long mo139mapOffset8S9VItk(long j11, boolean z10) {
        if (!z10) {
            return i4.f(d(), j11);
        }
        float[] c11 = c();
        return c11 != null ? i4.f(c11, j11) : y.g.f78593b.a();
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: move--gyyYBs */
    public void mo140movegyyYBs(long j11) {
        this.f5718a.c0(j11);
        f();
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: resize-ozmzZPI */
    public void mo141resizeozmzZPI(long j11) {
        if (o0.t.e(j11, this.f5723f)) {
            return;
        }
        this.f5723f = j11;
        invalidate();
    }

    @Override // androidx.compose.ui.node.w0
    public void reuseLayer(Function2 function2, Function0 function0) {
        a4 a4Var = this.f5719b;
        if (a4Var == null) {
            throw new IllegalArgumentException("currently reuse is only supported when we manage the layer lifecycle");
        }
        if (!this.f5718a.z()) {
            throw new IllegalArgumentException("layer should have been released before reuse");
        }
        this.f5718a = a4Var.a();
        this.f5724g = false;
        this.f5721d = function2;
        this.f5722e = function0;
        this.f5732o = e5.f4511a.a();
        this.f5736s = false;
        this.f5723f = o0.u.a(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.f5733p = null;
        this.f5731n = 0;
    }

    @Override // androidx.compose.ui.node.w0
    public void updateDisplayList() {
        if (this.f5727j) {
            if (!e5.c(this.f5732o, e5.f4511a.a()) && !o0.t.e(this.f5718a.v(), this.f5723f)) {
                this.f5718a.P(y.h.a(e5.d(this.f5732o) * o0.t.g(this.f5723f), e5.e(this.f5732o) * o0.t.f(this.f5723f)));
            }
            this.f5718a.E(this.f5728k, this.f5729l, this.f5723f, this.f5737t);
            e(false);
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void updateLayerProperties(x4 x4Var) {
        boolean z10;
        int b11;
        Function0 function0;
        int F = x4Var.F() | this.f5731n;
        this.f5729l = x4Var.D();
        this.f5728k = x4Var.C();
        int i11 = F & 4096;
        if (i11 != 0) {
            this.f5732o = x4Var.b0();
        }
        if ((F & 1) != 0) {
            this.f5718a.X(x4Var.t());
        }
        if ((F & 2) != 0) {
            this.f5718a.Y(x4Var.A());
        }
        if ((F & 4) != 0) {
            this.f5718a.J(x4Var.n());
        }
        if ((F & 8) != 0) {
            this.f5718a.d0(x4Var.x());
        }
        if ((F & 16) != 0) {
            this.f5718a.e0(x4Var.w());
        }
        if ((F & 32) != 0) {
            this.f5718a.Z(x4Var.L());
            if (x4Var.L() > 0.0f && !this.f5736s && (function0 = this.f5722e) != null) {
                function0.invoke();
            }
        }
        if ((F & 64) != 0) {
            this.f5718a.K(x4Var.v());
        }
        if ((F & 128) != 0) {
            this.f5718a.b0(x4Var.O());
        }
        if ((F & 1024) != 0) {
            this.f5718a.V(x4Var.o());
        }
        if ((F & 256) != 0) {
            this.f5718a.T(x4Var.y());
        }
        if ((F & 512) != 0) {
            this.f5718a.U(x4Var.m());
        }
        if ((F & 2048) != 0) {
            this.f5718a.L(x4Var.q());
        }
        if (i11 != 0) {
            if (e5.c(this.f5732o, e5.f4511a.a())) {
                this.f5718a.P(y.g.f78593b.b());
            } else {
                this.f5718a.P(y.h.a(e5.d(this.f5732o) * o0.t.g(this.f5723f), e5.e(this.f5732o) * o0.t.f(this.f5723f)));
            }
        }
        if ((F & 16384) != 0) {
            this.f5718a.M(x4Var.z());
        }
        if ((131072 & F) != 0) {
            GraphicsLayer graphicsLayer = this.f5718a;
            x4Var.I();
            graphicsLayer.S(null);
        }
        if ((32768 & F) != 0) {
            GraphicsLayer graphicsLayer2 = this.f5718a;
            int B = x4Var.B();
            w3.a aVar = w3.f4949a;
            if (w3.e(B, aVar.a())) {
                b11 = androidx.compose.ui.graphics.layer.b.f4587a.a();
            } else if (w3.e(B, aVar.c())) {
                b11 = androidx.compose.ui.graphics.layer.b.f4587a.c();
            } else {
                if (!w3.e(B, aVar.b())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                b11 = androidx.compose.ui.graphics.layer.b.f4587a.b();
            }
            graphicsLayer2.N(b11);
        }
        if (Intrinsics.c(this.f5733p, x4Var.G())) {
            z10 = false;
        } else {
            this.f5733p = x4Var.G();
            h();
            z10 = true;
        }
        this.f5731n = x4Var.F();
        if (F != 0 || z10) {
            f();
        }
    }
}
