package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.i4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.v4;
import androidx.compose.ui.graphics.x4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class RenderNodeLayer implements androidx.compose.ui.node.w0 {

    /* renamed from: n, reason: collision with root package name */
    public static final a f5740n = new a(null);

    /* renamed from: o, reason: collision with root package name */
    public static final int f5741o = 8;

    /* renamed from: p, reason: collision with root package name */
    private static final Function2 f5742p = new Function2<t0, Matrix, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((t0) obj, (Matrix) obj2);
            return Unit.f67184a;
        }

        public final void invoke(t0 t0Var, Matrix matrix) {
            t0Var.x(matrix);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f5743a;

    /* renamed from: b, reason: collision with root package name */
    private Function2 f5744b;

    /* renamed from: c, reason: collision with root package name */
    private Function0 f5745c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5746d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5748f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5749g;

    /* renamed from: h, reason: collision with root package name */
    private m4 f5750h;

    /* renamed from: l, reason: collision with root package name */
    private final t0 f5754l;

    /* renamed from: m, reason: collision with root package name */
    private int f5755m;

    /* renamed from: e, reason: collision with root package name */
    private final i1 f5747e = new i1();

    /* renamed from: i, reason: collision with root package name */
    private final d1 f5751i = new d1(f5742p);

    /* renamed from: j, reason: collision with root package name */
    private final androidx.compose.ui.graphics.n1 f5752j = new androidx.compose.ui.graphics.n1();

    /* renamed from: k, reason: collision with root package name */
    private long f5753k = e5.f4511a.a();

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RenderNodeLayer(AndroidComposeView androidComposeView, Function2 function2, Function0 function0) {
        this.f5743a = androidComposeView;
        this.f5744b = function2;
        this.f5745c = function0;
        t0 w1Var = Build.VERSION.SDK_INT >= 29 ? new w1(androidComposeView) : new j1(androidComposeView);
        w1Var.w(true);
        w1Var.p(false);
        this.f5754l = w1Var;
    }

    private final void a(androidx.compose.ui.graphics.m1 m1Var) {
        if (this.f5754l.v() || this.f5754l.t()) {
            this.f5747e.a(m1Var);
        }
    }

    private final void b(boolean z10) {
        if (z10 != this.f5746d) {
            this.f5746d = z10;
            this.f5743a.notifyLayerIsDirty$ui_release(this, z10);
        }
    }

    private final void c() {
        if (Build.VERSION.SDK_INT >= 26) {
            a3.f5806a.a(this.f5743a);
        } else {
            this.f5743a.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void destroy() {
        if (this.f5754l.n()) {
            this.f5754l.k();
        }
        this.f5744b = null;
        this.f5745c = null;
        this.f5748f = true;
        b(false);
        this.f5743a.requestClearInvalidObservations();
        this.f5743a.recycle$ui_release(this);
    }

    @Override // androidx.compose.ui.node.w0
    public void drawLayer(androidx.compose.ui.graphics.m1 m1Var, GraphicsLayer graphicsLayer) {
        Canvas d11 = androidx.compose.ui.graphics.h0.d(m1Var);
        if (d11.isHardwareAccelerated()) {
            updateDisplayList();
            boolean z10 = this.f5754l.H() > 0.0f;
            this.f5749g = z10;
            if (z10) {
                m1Var.k();
            }
            this.f5754l.o(d11);
            if (this.f5749g) {
                m1Var.o();
                return;
            }
            return;
        }
        float i11 = this.f5754l.i();
        float u11 = this.f5754l.u();
        float m11 = this.f5754l.m();
        float z11 = this.f5754l.z();
        if (this.f5754l.getAlpha() < 1.0f) {
            m4 m4Var = this.f5750h;
            if (m4Var == null) {
                m4Var = androidx.compose.ui.graphics.t0.a();
                this.f5750h = m4Var;
            }
            m4Var.setAlpha(this.f5754l.getAlpha());
            d11.saveLayer(i11, u11, m11, z11, m4Var.w());
        } else {
            m1Var.n();
        }
        m1Var.c(i11, u11);
        m1Var.p(this.f5751i.b(this.f5754l));
        a(m1Var);
        Function2 function2 = this.f5744b;
        if (function2 != null) {
            function2.invoke(m1Var, null);
        }
        m1Var.j();
        b(false);
    }

    @Override // androidx.compose.ui.node.w0
    public void invalidate() {
        if (this.f5746d || this.f5748f) {
            return;
        }
        this.f5743a.invalidate();
        b(true);
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo138isInLayerk4lQ0M(long j11) {
        float m11 = y.g.m(j11);
        float n11 = y.g.n(j11);
        if (this.f5754l.t()) {
            return 0.0f <= m11 && m11 < ((float) this.f5754l.getWidth()) && 0.0f <= n11 && n11 < ((float) this.f5754l.getHeight());
        }
        if (this.f5754l.v()) {
            return this.f5747e.f(j11);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.w0
    public void mapBounds(y.e eVar, boolean z10) {
        if (!z10) {
            i4.g(this.f5751i.b(this.f5754l), eVar);
            return;
        }
        float[] a11 = this.f5751i.a(this.f5754l);
        if (a11 == null) {
            eVar.g(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            i4.g(a11, eVar);
        }
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: mapOffset-8S9VItk */
    public long mo139mapOffset8S9VItk(long j11, boolean z10) {
        if (!z10) {
            return i4.f(this.f5751i.b(this.f5754l), j11);
        }
        float[] a11 = this.f5751i.a(this.f5754l);
        return a11 != null ? i4.f(a11, j11) : y.g.f78593b.a();
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: move--gyyYBs */
    public void mo140movegyyYBs(long j11) {
        int i11 = this.f5754l.i();
        int u11 = this.f5754l.u();
        int h11 = o0.p.h(j11);
        int i12 = o0.p.i(j11);
        if (i11 == h11 && u11 == i12) {
            return;
        }
        if (i11 != h11) {
            this.f5754l.y(h11 - i11);
        }
        if (u11 != i12) {
            this.f5754l.s(i12 - u11);
        }
        c();
        this.f5751i.c();
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: resize-ozmzZPI */
    public void mo141resizeozmzZPI(long j11) {
        int g11 = o0.t.g(j11);
        int f11 = o0.t.f(j11);
        this.f5754l.A(e5.d(this.f5753k) * g11);
        this.f5754l.B(e5.e(this.f5753k) * f11);
        t0 t0Var = this.f5754l;
        if (t0Var.q(t0Var.i(), this.f5754l.u(), this.f5754l.i() + g11, this.f5754l.u() + f11)) {
            this.f5754l.C(this.f5747e.b());
            invalidate();
            this.f5751i.c();
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void reuseLayer(Function2 function2, Function0 function0) {
        b(false);
        this.f5748f = false;
        this.f5749g = false;
        this.f5753k = e5.f4511a.a();
        this.f5744b = function2;
        this.f5745c = function0;
    }

    @Override // androidx.compose.ui.node.w0
    public void updateDisplayList() {
        if (this.f5746d || !this.f5754l.n()) {
            Path d11 = (!this.f5754l.v() || this.f5747e.e()) ? null : this.f5747e.d();
            final Function2 function2 = this.f5744b;
            if (function2 != null) {
                this.f5754l.F(this.f5752j, d11, new Function1<androidx.compose.ui.graphics.m1, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$updateDisplayList$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((androidx.compose.ui.graphics.m1) obj);
                        return Unit.f67184a;
                    }

                    public final void invoke(androidx.compose.ui.graphics.m1 m1Var) {
                        function2.invoke(m1Var, null);
                    }
                });
            }
            b(false);
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void updateLayerProperties(x4 x4Var) {
        Function0 function0;
        int F = x4Var.F() | this.f5755m;
        int i11 = F & 4096;
        if (i11 != 0) {
            this.f5753k = x4Var.b0();
        }
        boolean z10 = false;
        boolean z11 = this.f5754l.v() && !this.f5747e.e();
        if ((F & 1) != 0) {
            this.f5754l.b(x4Var.t());
        }
        if ((F & 2) != 0) {
            this.f5754l.h(x4Var.A());
        }
        if ((F & 4) != 0) {
            this.f5754l.setAlpha(x4Var.n());
        }
        if ((F & 8) != 0) {
            this.f5754l.j(x4Var.x());
        }
        if ((F & 16) != 0) {
            this.f5754l.a(x4Var.w());
        }
        if ((F & 32) != 0) {
            this.f5754l.r(x4Var.L());
        }
        if ((F & 64) != 0) {
            this.f5754l.D(androidx.compose.ui.graphics.w1.j(x4Var.v()));
        }
        if ((F & 128) != 0) {
            this.f5754l.G(androidx.compose.ui.graphics.w1.j(x4Var.O()));
        }
        if ((F & 1024) != 0) {
            this.f5754l.g(x4Var.o());
        }
        if ((F & 256) != 0) {
            this.f5754l.e(x4Var.y());
        }
        if ((F & 512) != 0) {
            this.f5754l.f(x4Var.m());
        }
        if ((F & 2048) != 0) {
            this.f5754l.d(x4Var.q());
        }
        if (i11 != 0) {
            this.f5754l.A(e5.d(this.f5753k) * this.f5754l.getWidth());
            this.f5754l.B(e5.e(this.f5753k) * this.f5754l.getHeight());
        }
        boolean z12 = x4Var.z() && x4Var.M() != v4.a();
        if ((F & 24576) != 0) {
            this.f5754l.E(z12);
            this.f5754l.p(x4Var.z() && x4Var.M() == v4.a());
        }
        if ((131072 & F) != 0) {
            t0 t0Var = this.f5754l;
            x4Var.I();
            t0Var.c(null);
        }
        if ((32768 & F) != 0) {
            this.f5754l.l(x4Var.B());
        }
        boolean h11 = this.f5747e.h(x4Var.G(), x4Var.n(), z12, x4Var.L(), x4Var.i());
        if (this.f5747e.c()) {
            this.f5754l.C(this.f5747e.b());
        }
        if (z12 && !this.f5747e.e()) {
            z10 = true;
        }
        if (z11 != z10 || (z10 && h11)) {
            invalidate();
        } else {
            c();
        }
        if (!this.f5749g && this.f5754l.H() > 0.0f && (function0 = this.f5745c) != null) {
            function0.invoke();
        }
        if ((F & 7963) != 0) {
            this.f5751i.c();
        }
        this.f5755m = x4Var.F();
    }
}
