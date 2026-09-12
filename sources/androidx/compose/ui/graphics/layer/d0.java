package androidx.compose.ui.graphics.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.layer.b;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.n1;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.w4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import z.a;

/* loaded from: classes.dex */
public final class d0 implements GraphicsLayerImpl {
    public static final b J = new b(null);
    private static final boolean K = !r0.f4677a.a();
    private static final Canvas L = new a();
    private float A;
    private float B;
    private float C;
    private float D;
    private long E;
    private long F;
    private float G;
    private float H;
    private float I;

    /* renamed from: b, reason: collision with root package name */
    private final DrawChildContainer f4616b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4617c;

    /* renamed from: d, reason: collision with root package name */
    private final n1 f4618d;

    /* renamed from: e, reason: collision with root package name */
    private final ViewLayer f4619e;

    /* renamed from: f, reason: collision with root package name */
    private final Resources f4620f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f4621g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f4622h;

    /* renamed from: i, reason: collision with root package name */
    private final Picture f4623i;

    /* renamed from: j, reason: collision with root package name */
    private final z.a f4624j;

    /* renamed from: k, reason: collision with root package name */
    private final n1 f4625k;

    /* renamed from: l, reason: collision with root package name */
    private int f4626l;

    /* renamed from: m, reason: collision with root package name */
    private int f4627m;

    /* renamed from: n, reason: collision with root package name */
    private long f4628n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4629o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4630p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f4631q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f4632r;

    /* renamed from: s, reason: collision with root package name */
    private final long f4633s;

    /* renamed from: t, reason: collision with root package name */
    private int f4634t;

    /* renamed from: u, reason: collision with root package name */
    private v1 f4635u;

    /* renamed from: v, reason: collision with root package name */
    private int f4636v;

    /* renamed from: w, reason: collision with root package name */
    private float f4637w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f4638x;

    /* renamed from: y, reason: collision with root package name */
    private long f4639y;

    /* renamed from: z, reason: collision with root package name */
    private float f4640z;

    /* loaded from: classes.dex */
    public static final class a extends Canvas {
        a() {
        }

        @Override // android.graphics.Canvas
        public boolean isHardwareAccelerated() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d0(DrawChildContainer drawChildContainer, long j11, n1 n1Var, z.a aVar) {
        this.f4616b = drawChildContainer;
        this.f4617c = j11;
        this.f4618d = n1Var;
        ViewLayer viewLayer = new ViewLayer(drawChildContainer, n1Var, aVar);
        this.f4619e = viewLayer;
        this.f4620f = drawChildContainer.getResources();
        this.f4621g = new Rect();
        boolean z10 = K;
        this.f4623i = z10 ? new Picture() : null;
        this.f4624j = z10 ? new z.a() : null;
        this.f4625k = z10 ? new n1() : null;
        drawChildContainer.addView(viewLayer);
        viewLayer.setClipBounds(null);
        this.f4628n = o0.t.f70747b.a();
        this.f4630p = true;
        this.f4633s = View.generateViewId();
        this.f4634t = c1.f4367a.B();
        this.f4636v = androidx.compose.ui.graphics.layer.b.f4587a.a();
        this.f4637w = 1.0f;
        this.f4639y = y.g.f78593b.c();
        this.f4640z = 1.0f;
        this.A = 1.0f;
        u1.a aVar2 = u1.f4733b;
        this.E = aVar2.a();
        this.F = aVar2.a();
    }

    public /* synthetic */ d0(DrawChildContainer drawChildContainer, long j11, n1 n1Var, z.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawChildContainer, j11, (i11 & 4) != 0 ? new n1() : n1Var, (i11 & 8) != 0 ? new z.a() : aVar);
    }

    private final void M(int i11) {
        ViewLayer viewLayer = this.f4619e;
        b.a aVar = androidx.compose.ui.graphics.layer.b.f4587a;
        boolean z10 = true;
        if (androidx.compose.ui.graphics.layer.b.e(i11, aVar.c())) {
            this.f4619e.setLayerType(2, this.f4622h);
        } else if (androidx.compose.ui.graphics.layer.b.e(i11, aVar.b())) {
            this.f4619e.setLayerType(0, this.f4622h);
            z10 = false;
        } else {
            this.f4619e.setLayerType(0, this.f4622h);
        }
        viewLayer.setCanUseCompositingLayer$ui_graphics_release(z10);
    }

    private final void O() {
        try {
            n1 n1Var = this.f4618d;
            Canvas canvas = L;
            Canvas v11 = n1Var.a().v();
            n1Var.a().w(canvas);
            androidx.compose.ui.graphics.g0 a11 = n1Var.a();
            DrawChildContainer drawChildContainer = this.f4616b;
            ViewLayer viewLayer = this.f4619e;
            drawChildContainer.drawChild$ui_graphics_release(a11, viewLayer, viewLayer.getDrawingTime());
            n1Var.a().w(v11);
        } catch (Throwable unused) {
        }
    }

    private final boolean P() {
        return androidx.compose.ui.graphics.layer.b.e(z(), androidx.compose.ui.graphics.layer.b.f4587a.c()) || Q();
    }

    private final boolean Q() {
        return (c1.E(l(), c1.f4367a.B()) && i() == null) ? false : true;
    }

    private final void R() {
        Rect rect;
        if (this.f4629o) {
            ViewLayer viewLayer = this.f4619e;
            if (!N() || this.f4631q) {
                rect = null;
            } else {
                rect = this.f4621g;
                rect.left = 0;
                rect.top = 0;
                rect.right = this.f4619e.getWidth();
                rect.bottom = this.f4619e.getHeight();
            }
            viewLayer.setClipBounds(rect);
        }
    }

    private final void S() {
        if (P()) {
            M(androidx.compose.ui.graphics.layer.b.f4587a.c());
        } else {
            M(z());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float A() {
        return this.A;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void B(int i11, int i12, long j11) {
        if (o0.t.e(this.f4628n, j11)) {
            int i13 = this.f4626l;
            if (i13 != i11) {
                this.f4619e.offsetLeftAndRight(i11 - i13);
            }
            int i14 = this.f4627m;
            if (i14 != i12) {
                this.f4619e.offsetTopAndBottom(i12 - i14);
            }
        } else {
            if (N()) {
                this.f4629o = true;
            }
            this.f4619e.layout(i11, i12, o0.t.g(j11) + i11, o0.t.f(j11) + i12);
            this.f4628n = j11;
            if (this.f4638x) {
                this.f4619e.setPivotX(o0.t.g(j11) / 2.0f);
                this.f4619e.setPivotY(o0.t.f(j11) / 2.0f);
            }
        }
        this.f4626l = i11;
        this.f4627m = i12;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long C() {
        return this.E;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long D() {
        return this.F;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix E() {
        return this.f4619e.getMatrix();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void F(boolean z10) {
        this.f4630p = z10;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void G(Outline outline, long j11) {
        boolean layerOutline = this.f4619e.setLayerOutline(outline);
        if (N() && outline != null) {
            this.f4619e.setClipToOutline(true);
            if (this.f4632r) {
                this.f4632r = false;
                this.f4629o = true;
            }
        }
        this.f4631q = outline != null;
        if (layerOutline) {
            return;
        }
        this.f4619e.invalidate();
        O();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void H(long j11) {
        this.f4639y = j11;
        if (!y.h.d(j11)) {
            this.f4638x = false;
            this.f4619e.setPivotX(y.g.m(j11));
            this.f4619e.setPivotY(y.g.n(j11));
        } else {
            if (Build.VERSION.SDK_INT >= 28) {
                v0.f4678a.a(this.f4619e);
                return;
            }
            this.f4638x = true;
            this.f4619e.setPivotX(o0.t.g(this.f4628n) / 2.0f);
            this.f4619e.setPivotY(o0.t.f(this.f4628n) / 2.0f);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void I(o0.e eVar, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1 function1) {
        n1 n1Var;
        Canvas canvas;
        if (this.f4619e.getParent() == null) {
            this.f4616b.addView(this.f4619e);
        }
        this.f4619e.setDrawParams(eVar, layoutDirection, graphicsLayer, function1);
        if (this.f4619e.isAttachedToWindow()) {
            this.f4619e.setVisibility(4);
            this.f4619e.setVisibility(0);
            O();
            Picture picture = this.f4623i;
            if (picture != null) {
                Canvas beginRecording = picture.beginRecording(o0.t.g(this.f4628n), o0.t.f(this.f4628n));
                try {
                    n1 n1Var2 = this.f4625k;
                    if (n1Var2 != null) {
                        Canvas v11 = n1Var2.a().v();
                        n1Var2.a().w(beginRecording);
                        androidx.compose.ui.graphics.g0 a11 = n1Var2.a();
                        z.a aVar = this.f4624j;
                        if (aVar != null) {
                            long d11 = o0.u.d(this.f4628n);
                            a.C1001a F = aVar.F();
                            o0.e a12 = F.a();
                            LayoutDirection b11 = F.b();
                            m1 c11 = F.c();
                            n1Var = n1Var2;
                            canvas = v11;
                            long d12 = F.d();
                            a.C1001a F2 = aVar.F();
                            F2.j(eVar);
                            F2.k(layoutDirection);
                            F2.i(a11);
                            F2.l(d11);
                            a11.n();
                            function1.invoke(aVar);
                            a11.j();
                            a.C1001a F3 = aVar.F();
                            F3.j(a12);
                            F3.k(b11);
                            F3.i(c11);
                            F3.l(d12);
                        } else {
                            n1Var = n1Var2;
                            canvas = v11;
                        }
                        n1Var.a().w(canvas);
                        Unit unit = Unit.f67184a;
                    }
                    picture.endRecording();
                } catch (Throwable th2) {
                    picture.endRecording();
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void J(int i11) {
        this.f4636v = i11;
        S();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float K() {
        return this.D;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void L(m1 m1Var) {
        R();
        Canvas d11 = androidx.compose.ui.graphics.h0.d(m1Var);
        if (d11.isHardwareAccelerated()) {
            DrawChildContainer drawChildContainer = this.f4616b;
            ViewLayer viewLayer = this.f4619e;
            drawChildContainer.drawChild$ui_graphics_release(m1Var, viewLayer, viewLayer.getDrawingTime());
        } else {
            Picture picture = this.f4623i;
            if (picture != null) {
                d11.drawPicture(picture);
            }
        }
    }

    public boolean N() {
        return this.f4632r || this.f4619e.getClipToOutline();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void a(float f11) {
        this.C = f11;
        this.f4619e.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void b(float f11) {
        this.f4640z = f11;
        this.f4619e.setScaleX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void c(w4 w4Var) {
        if (Build.VERSION.SDK_INT >= 31) {
            x0.f4680a.a(this.f4619e, w4Var);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void d(float f11) {
        this.f4619e.setCameraDistance(f11 * this.f4620f.getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void e(float f11) {
        this.G = f11;
        this.f4619e.setRotationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void f(float f11) {
        this.H = f11;
        this.f4619e.setRotationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void g(float f11) {
        this.I = f11;
        this.f4619e.setRotation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.f4637w;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void h(float f11) {
        this.A = f11;
        this.f4619e.setScaleY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public v1 i() {
        return this.f4635u;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void j(float f11) {
        this.B = f11;
        this.f4619e.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void k() {
        this.f4616b.removeViewInLayout(this.f4619e);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int l() {
        return this.f4634t;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float m() {
        return this.H;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public /* synthetic */ boolean n() {
        return c.a(this);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float o() {
        return this.I;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void p(long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.E = j11;
            v0.f4678a.b(this.f4619e, w1.j(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float q() {
        return this.f4619e.getCameraDistance() / this.f4620f.getDisplayMetrics().densityDpi;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void r(boolean z10) {
        boolean z11 = false;
        this.f4632r = z10 && !this.f4631q;
        this.f4629o = true;
        ViewLayer viewLayer = this.f4619e;
        if (z10 && this.f4631q) {
            z11 = true;
        }
        viewLayer.setClipToOutline(z11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void s(long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.F = j11;
            v0.f4678a.c(this.f4619e, w1.j(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f11) {
        this.f4637w = f11;
        this.f4619e.setAlpha(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float t() {
        return this.f4640z;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void u(float f11) {
        this.D = f11;
        this.f4619e.setElevation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public w4 v() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float w() {
        return this.C;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float x() {
        return this.B;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float y() {
        return this.G;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int z() {
        return this.f4636v;
    }
}
