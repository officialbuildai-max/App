package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.t1;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.w4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y.g;

/* loaded from: classes.dex */
public final class GraphicsLayer {

    /* renamed from: x, reason: collision with root package name */
    public static final a f4543x = new a(null);

    /* renamed from: y, reason: collision with root package name */
    private static final f0 f4544y;

    /* renamed from: a, reason: collision with root package name */
    private final GraphicsLayerImpl f4545a;

    /* renamed from: f, reason: collision with root package name */
    private Outline f4550f;

    /* renamed from: h, reason: collision with root package name */
    private long f4552h;

    /* renamed from: i, reason: collision with root package name */
    private long f4553i;

    /* renamed from: j, reason: collision with root package name */
    private float f4554j;

    /* renamed from: k, reason: collision with root package name */
    private k4 f4555k;

    /* renamed from: l, reason: collision with root package name */
    private Path f4556l;

    /* renamed from: m, reason: collision with root package name */
    private Path f4557m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4558n;

    /* renamed from: o, reason: collision with root package name */
    private m4 f4559o;

    /* renamed from: p, reason: collision with root package name */
    private int f4560p;

    /* renamed from: q, reason: collision with root package name */
    private final androidx.compose.ui.graphics.layer.a f4561q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f4562r;

    /* renamed from: s, reason: collision with root package name */
    private long f4563s;

    /* renamed from: t, reason: collision with root package name */
    private long f4564t;

    /* renamed from: u, reason: collision with root package name */
    private long f4565u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f4566v;

    /* renamed from: w, reason: collision with root package name */
    private RectF f4567w;

    /* renamed from: b, reason: collision with root package name */
    private o0.e f4546b = z.e.a();

    /* renamed from: c, reason: collision with root package name */
    private LayoutDirection f4547c = LayoutDirection.Ltr;

    /* renamed from: d, reason: collision with root package name */
    private Function1 f4548d = new Function1<z.g, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((z.g) obj);
            return Unit.f67184a;
        }

        public final void invoke(z.g gVar) {
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private final Function1 f4549e = new Function1<z.g, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$clipDrawBlock$1
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
            Path path;
            boolean z10;
            Function1 function1;
            Function1 function12;
            path = GraphicsLayer.this.f4556l;
            z10 = GraphicsLayer.this.f4558n;
            if (!z10 || !GraphicsLayer.this.k() || path == null) {
                function1 = GraphicsLayer.this.f4548d;
                function1.invoke(gVar);
                return;
            }
            function12 = GraphicsLayer.this.f4548d;
            int b11 = t1.f4722a.b();
            z.d H0 = gVar.H0();
            long i11 = H0.i();
            H0.e().n();
            try {
                H0.c().b(path, b11);
                function12.invoke(gVar);
            } finally {
                H0.e().j();
                H0.f(i11);
            }
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private boolean f4551g = true;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f4544y = e0.f4666a.a() ? g0.f4668a : Build.VERSION.SDK_INT >= 28 ? i0.f4670a : r0.f4677a.a() ? h0.f4669a : g0.f4668a;
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl, e0 e0Var) {
        this.f4545a = graphicsLayerImpl;
        g.a aVar = y.g.f78593b;
        this.f4552h = aVar.c();
        this.f4553i = y.m.f78614b.a();
        this.f4561q = new androidx.compose.ui.graphics.layer.a();
        graphicsLayerImpl.r(false);
        this.f4563s = o0.p.f70738b.a();
        this.f4564t = o0.t.f70747b.a();
        this.f4565u = aVar.b();
    }

    private final Outline A() {
        Outline outline = this.f4550f;
        if (outline != null) {
            return outline;
        }
        Outline outline2 = new Outline();
        this.f4550f = outline2;
        return outline2;
    }

    private final RectF B() {
        RectF rectF = this.f4567w;
        if (rectF != null) {
            return rectF;
        }
        RectF rectF2 = new RectF();
        this.f4567w = rectF2;
        return rectF2;
    }

    private final void C() {
        this.f4560p++;
    }

    private final void D() {
        this.f4560p--;
        f();
    }

    private final void F() {
        androidx.compose.ui.graphics.layer.a aVar = this.f4561q;
        androidx.compose.ui.graphics.layer.a.g(aVar, androidx.compose.ui.graphics.layer.a.b(aVar));
        MutableScatterSet a11 = androidx.compose.ui.graphics.layer.a.a(aVar);
        if (a11 != null && a11.e()) {
            MutableScatterSet c11 = androidx.compose.ui.graphics.layer.a.c(aVar);
            if (c11 == null) {
                c11 = androidx.collection.w0.a();
                androidx.compose.ui.graphics.layer.a.f(aVar, c11);
            }
            c11.i(a11);
            a11.m();
        }
        androidx.compose.ui.graphics.layer.a.h(aVar, true);
        this.f4545a.I(this.f4546b, this.f4547c, this, this.f4549e);
        androidx.compose.ui.graphics.layer.a.h(aVar, false);
        GraphicsLayer d11 = androidx.compose.ui.graphics.layer.a.d(aVar);
        if (d11 != null) {
            d11.D();
        }
        MutableScatterSet c12 = androidx.compose.ui.graphics.layer.a.c(aVar);
        if (c12 == null || !c12.e()) {
            return;
        }
        Object[] objArr = c12.f2322b;
        long[] jArr = c12.f2321a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            ((GraphicsLayer) objArr[(i11 << 3) + i13]).D();
                        }
                        j11 >>= 8;
                    }
                    if (i12 != 8) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        c12.m();
    }

    private final void G() {
        if (this.f4545a.n()) {
            return;
        }
        try {
            F();
        } catch (Throwable unused) {
        }
    }

    private final void I() {
        this.f4555k = null;
        this.f4556l = null;
        this.f4553i = y.m.f78614b.a();
        this.f4552h = y.g.f78593b.c();
        this.f4554j = 0.0f;
        this.f4551g = true;
        this.f4558n = false;
    }

    private final void Q(long j11, long j12) {
        this.f4545a.B(o0.p.h(j11), o0.p.i(j11), j12);
    }

    private final void a0(long j11) {
        if (o0.t.e(this.f4564t, j11)) {
            return;
        }
        this.f4564t = j11;
        Q(this.f4563s, j11);
        if (this.f4553i == 9205357640488583168L) {
            this.f4551g = true;
            e();
        }
    }

    private final void d(GraphicsLayer graphicsLayer) {
        if (this.f4561q.i(graphicsLayer)) {
            graphicsLayer.C();
        }
    }

    private final void e() {
        if (this.f4551g) {
            Outline outline = null;
            if (this.f4566v || u() > 0.0f) {
                Path path = this.f4556l;
                if (path != null) {
                    RectF B = B();
                    if (!(path instanceof androidx.compose.ui.graphics.u0)) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    ((androidx.compose.ui.graphics.u0) path).p().computeBounds(B, false);
                    Outline g02 = g0(path);
                    if (g02 != null) {
                        g02.setAlpha(i());
                        outline = g02;
                    }
                    this.f4545a.G(outline, o0.u.a(Math.round(B.width()), Math.round(B.height())));
                    if (this.f4558n && this.f4566v) {
                        this.f4545a.r(false);
                        this.f4545a.k();
                    } else {
                        this.f4545a.r(this.f4566v);
                    }
                } else {
                    this.f4545a.r(this.f4566v);
                    y.m.f78614b.b();
                    Outline A = A();
                    long d11 = o0.u.d(this.f4564t);
                    long j11 = this.f4552h;
                    long j12 = this.f4553i;
                    long j13 = j12 == 9205357640488583168L ? d11 : j12;
                    A.setRoundRect(Math.round(y.g.m(j11)), Math.round(y.g.n(j11)), Math.round(y.g.m(j11) + y.m.i(j13)), Math.round(y.g.n(j11) + y.m.g(j13)), this.f4554j);
                    A.setAlpha(i());
                    this.f4545a.G(A, o0.u.c(j13));
                }
            } else {
                this.f4545a.r(false);
                this.f4545a.G(null, o0.t.f70747b.a());
            }
        }
        this.f4551g = false;
    }

    private final void f() {
        if (this.f4562r && this.f4560p == 0) {
            g();
        }
    }

    private final void f0(Canvas canvas) {
        float h11 = o0.p.h(this.f4563s);
        float i11 = o0.p.i(this.f4563s);
        float h12 = o0.p.h(this.f4563s) + o0.t.g(this.f4564t);
        float i12 = o0.p.i(this.f4563s) + o0.t.f(this.f4564t);
        float i13 = i();
        v1 l11 = l();
        int j11 = j();
        if (i13 < 1.0f || !c1.E(j11, c1.f4367a.B()) || l11 != null || b.e(m(), b.f4587a.c())) {
            m4 m4Var = this.f4559o;
            if (m4Var == null) {
                m4Var = androidx.compose.ui.graphics.t0.a();
                this.f4559o = m4Var;
            }
            m4Var.setAlpha(i13);
            m4Var.n(j11);
            m4Var.z(l11);
            canvas.saveLayer(h11, i11, h12, i12, m4Var.w());
        } else {
            canvas.save();
        }
        canvas.translate(h11, i11);
        canvas.concat(this.f4545a.E());
    }

    private final Outline g0(Path path) {
        Outline outline;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 28 || path.a()) {
            Outline A = A();
            if (i11 >= 30) {
                l0.f4672a.a(A, path);
            } else {
                if (!(path instanceof androidx.compose.ui.graphics.u0)) {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
                A.setConvexPath(((androidx.compose.ui.graphics.u0) path).p());
            }
            this.f4558n = !A.canClip();
            outline = A;
        } else {
            Outline outline2 = this.f4550f;
            if (outline2 != null) {
                outline2.setEmpty();
            }
            this.f4558n = true;
            this.f4545a.F(true);
            outline = null;
        }
        this.f4556l = path;
        return outline;
    }

    public final void E(o0.e eVar, LayoutDirection layoutDirection, long j11, Function1 function1) {
        a0(j11);
        this.f4546b = eVar;
        this.f4547c = layoutDirection;
        this.f4548d = function1;
        this.f4545a.F(true);
        F();
    }

    public final void H() {
        if (this.f4562r) {
            return;
        }
        this.f4562r = true;
        f();
    }

    public final void J(float f11) {
        if (this.f4545a.getAlpha() == f11) {
            return;
        }
        this.f4545a.setAlpha(f11);
    }

    public final void K(long j11) {
        if (u1.m(j11, this.f4545a.C())) {
            return;
        }
        this.f4545a.p(j11);
    }

    public final void L(float f11) {
        if (this.f4545a.q() == f11) {
            return;
        }
        this.f4545a.d(f11);
    }

    public final void M(boolean z10) {
        if (this.f4566v != z10) {
            this.f4566v = z10;
            this.f4551g = true;
            e();
        }
    }

    public final void N(int i11) {
        if (b.e(this.f4545a.z(), i11)) {
            return;
        }
        this.f4545a.J(i11);
    }

    public final void O(Path path) {
        I();
        this.f4556l = path;
        e();
    }

    public final void P(long j11) {
        if (y.g.j(this.f4565u, j11)) {
            return;
        }
        this.f4565u = j11;
        this.f4545a.H(j11);
    }

    public final void R(long j11, long j12) {
        W(j11, j12, 0.0f);
    }

    public final void S(w4 w4Var) {
        this.f4545a.v();
        if (Intrinsics.c(null, w4Var)) {
            return;
        }
        this.f4545a.c(w4Var);
    }

    public final void T(float f11) {
        if (this.f4545a.y() == f11) {
            return;
        }
        this.f4545a.e(f11);
    }

    public final void U(float f11) {
        if (this.f4545a.m() == f11) {
            return;
        }
        this.f4545a.f(f11);
    }

    public final void V(float f11) {
        if (this.f4545a.o() == f11) {
            return;
        }
        this.f4545a.g(f11);
    }

    public final void W(long j11, long j12, float f11) {
        if (y.g.j(this.f4552h, j11) && y.m.f(this.f4553i, j12) && this.f4554j == f11 && this.f4556l == null) {
            return;
        }
        I();
        this.f4552h = j11;
        this.f4553i = j12;
        this.f4554j = f11;
        e();
    }

    public final void X(float f11) {
        if (this.f4545a.t() == f11) {
            return;
        }
        this.f4545a.b(f11);
    }

    public final void Y(float f11) {
        if (this.f4545a.A() == f11) {
            return;
        }
        this.f4545a.h(f11);
    }

    public final void Z(float f11) {
        if (this.f4545a.K() == f11) {
            return;
        }
        this.f4545a.u(f11);
        this.f4551g = true;
        e();
    }

    public final void b0(long j11) {
        if (u1.m(j11, this.f4545a.D())) {
            return;
        }
        this.f4545a.s(j11);
    }

    public final void c0(long j11) {
        if (o0.p.g(this.f4563s, j11)) {
            return;
        }
        this.f4563s = j11;
        Q(j11, this.f4564t);
    }

    public final void d0(float f11) {
        if (this.f4545a.x() == f11) {
            return;
        }
        this.f4545a.j(f11);
    }

    public final void e0(float f11) {
        if (this.f4545a.w() == f11) {
            return;
        }
        this.f4545a.a(f11);
    }

    public final void g() {
        androidx.compose.ui.graphics.layer.a aVar = this.f4561q;
        GraphicsLayer b11 = androidx.compose.ui.graphics.layer.a.b(aVar);
        if (b11 != null) {
            b11.D();
            androidx.compose.ui.graphics.layer.a.e(aVar, null);
        }
        MutableScatterSet a11 = androidx.compose.ui.graphics.layer.a.a(aVar);
        if (a11 != null) {
            Object[] objArr = a11.f2322b;
            long[] jArr = a11.f2321a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                ((GraphicsLayer) objArr[(i11 << 3) + i13]).D();
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            break;
                        }
                    }
                    if (i11 == length) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            a11.m();
        }
        this.f4545a.k();
    }

    public final void h(m1 m1Var, GraphicsLayer graphicsLayer) {
        if (this.f4562r) {
            return;
        }
        e();
        G();
        boolean z10 = u() > 0.0f;
        if (z10) {
            m1Var.k();
        }
        Canvas d11 = androidx.compose.ui.graphics.h0.d(m1Var);
        boolean isHardwareAccelerated = d11.isHardwareAccelerated();
        if (!isHardwareAccelerated) {
            d11.save();
            f0(d11);
        }
        boolean z11 = !isHardwareAccelerated && this.f4566v;
        if (z11) {
            m1Var.n();
            k4 n11 = n();
            if (n11 instanceof k4.b) {
                l1.e(m1Var, n11.a(), 0, 2, null);
            } else if (n11 instanceof k4.c) {
                Path path = this.f4557m;
                if (path != null) {
                    path.b();
                } else {
                    path = androidx.compose.ui.graphics.x0.a();
                    this.f4557m = path;
                }
                o4.b(path, ((k4.c) n11).b(), null, 2, null);
                l1.c(m1Var, path, 0, 2, null);
            } else if (n11 instanceof k4.a) {
                l1.c(m1Var, ((k4.a) n11).b(), 0, 2, null);
            }
        }
        if (graphicsLayer != null) {
            graphicsLayer.d(this);
        }
        this.f4545a.L(m1Var);
        if (z11) {
            m1Var.j();
        }
        if (z10) {
            m1Var.o();
        }
        if (isHardwareAccelerated) {
            return;
        }
        d11.restore();
    }

    public final float i() {
        return this.f4545a.getAlpha();
    }

    public final int j() {
        return this.f4545a.l();
    }

    public final boolean k() {
        return this.f4566v;
    }

    public final v1 l() {
        return this.f4545a.i();
    }

    public final int m() {
        return this.f4545a.z();
    }

    public final k4 n() {
        k4 k4Var = this.f4555k;
        Path path = this.f4556l;
        if (k4Var != null) {
            return k4Var;
        }
        if (path != null) {
            k4.a aVar = new k4.a(path);
            this.f4555k = aVar;
            return aVar;
        }
        long d11 = o0.u.d(this.f4564t);
        long j11 = this.f4552h;
        long j12 = this.f4553i;
        if (j12 != 9205357640488583168L) {
            d11 = j12;
        }
        float m11 = y.g.m(j11);
        float n11 = y.g.n(j11);
        float i11 = m11 + y.m.i(d11);
        float g11 = n11 + y.m.g(d11);
        float f11 = this.f4554j;
        k4 cVar = f11 > 0.0f ? new k4.c(y.l.c(m11, n11, i11, g11, y.b.b(f11, 0.0f, 2, null))) : new k4.b(new y.i(m11, n11, i11, g11));
        this.f4555k = cVar;
        return cVar;
    }

    public final long o() {
        return this.f4565u;
    }

    public final float p() {
        return this.f4545a.y();
    }

    public final float q() {
        return this.f4545a.m();
    }

    public final float r() {
        return this.f4545a.o();
    }

    public final float s() {
        return this.f4545a.t();
    }

    public final float t() {
        return this.f4545a.A();
    }

    public final float u() {
        return this.f4545a.K();
    }

    public final long v() {
        return this.f4564t;
    }

    public final long w() {
        return this.f4563s;
    }

    public final float x() {
        return this.f4545a.x();
    }

    public final float y() {
        return this.f4545a.w();
    }

    public final boolean z() {
        return this.f4562r;
    }
}
