package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.layer.b;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.n1;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.w4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class c0 implements GraphicsLayerImpl {
    private boolean A;
    private int B;
    private boolean C;

    /* renamed from: b, reason: collision with root package name */
    private final long f4591b;

    /* renamed from: c, reason: collision with root package name */
    private final n1 f4592c;

    /* renamed from: d, reason: collision with root package name */
    private final z.a f4593d;

    /* renamed from: e, reason: collision with root package name */
    private final RenderNode f4594e;

    /* renamed from: f, reason: collision with root package name */
    private long f4595f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f4596g;

    /* renamed from: h, reason: collision with root package name */
    private Matrix f4597h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4598i;

    /* renamed from: j, reason: collision with root package name */
    private float f4599j;

    /* renamed from: k, reason: collision with root package name */
    private int f4600k;

    /* renamed from: l, reason: collision with root package name */
    private v1 f4601l;

    /* renamed from: m, reason: collision with root package name */
    private long f4602m;

    /* renamed from: n, reason: collision with root package name */
    private float f4603n;

    /* renamed from: o, reason: collision with root package name */
    private float f4604o;

    /* renamed from: p, reason: collision with root package name */
    private float f4605p;

    /* renamed from: q, reason: collision with root package name */
    private float f4606q;

    /* renamed from: r, reason: collision with root package name */
    private float f4607r;

    /* renamed from: s, reason: collision with root package name */
    private long f4608s;

    /* renamed from: t, reason: collision with root package name */
    private long f4609t;

    /* renamed from: u, reason: collision with root package name */
    private float f4610u;

    /* renamed from: v, reason: collision with root package name */
    private float f4611v;

    /* renamed from: w, reason: collision with root package name */
    private float f4612w;

    /* renamed from: x, reason: collision with root package name */
    private float f4613x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f4614y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f4615z;

    public c0(long j11, n1 n1Var, z.a aVar) {
        this.f4591b = j11;
        this.f4592c = n1Var;
        this.f4593d = aVar;
        RenderNode a11 = androidx.compose.foundation.i.a("graphicsLayer");
        this.f4594e = a11;
        this.f4595f = y.m.f78614b.b();
        a11.setClipToBounds(false);
        b.a aVar2 = b.f4587a;
        N(a11, aVar2.a());
        this.f4599j = 1.0f;
        this.f4600k = c1.f4367a.B();
        this.f4602m = y.g.f78593b.b();
        this.f4603n = 1.0f;
        this.f4604o = 1.0f;
        u1.a aVar3 = u1.f4733b;
        this.f4608s = aVar3.a();
        this.f4609t = aVar3.a();
        this.f4613x = 8.0f;
        this.B = aVar2.a();
        this.C = true;
    }

    public /* synthetic */ c0(long j11, n1 n1Var, z.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, (i11 & 2) != 0 ? new n1() : n1Var, (i11 & 4) != 0 ? new z.a() : aVar);
    }

    private final void M() {
        boolean z10 = false;
        boolean z11 = O() && !this.f4598i;
        if (O() && this.f4598i) {
            z10 = true;
        }
        if (z11 != this.f4615z) {
            this.f4615z = z11;
            this.f4594e.setClipToBounds(z11);
        }
        if (z10 != this.A) {
            this.A = z10;
            this.f4594e.setClipToOutline(z10);
        }
    }

    private final void N(RenderNode renderNode, int i11) {
        b.a aVar = b.f4587a;
        if (b.e(i11, aVar.c())) {
            renderNode.setUseCompositingLayer(true, this.f4596g);
            renderNode.setHasOverlappingRendering(true);
        } else if (b.e(i11, aVar.b())) {
            renderNode.setUseCompositingLayer(false, this.f4596g);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, this.f4596g);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final boolean P() {
        if (b.e(z(), b.f4587a.c()) || Q()) {
            return true;
        }
        v();
        return false;
    }

    private final boolean Q() {
        return (c1.E(l(), c1.f4367a.B()) && i() == null) ? false : true;
    }

    private final void R() {
        if (P()) {
            N(this.f4594e, b.f4587a.c());
        } else {
            N(this.f4594e, z());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float A() {
        return this.f4604o;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void B(int i11, int i12, long j11) {
        this.f4594e.setPosition(i11, i12, o0.t.g(j11) + i11, o0.t.f(j11) + i12);
        this.f4595f = o0.u.d(j11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long C() {
        return this.f4608s;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long D() {
        return this.f4609t;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix E() {
        Matrix matrix = this.f4597h;
        if (matrix == null) {
            matrix = new Matrix();
            this.f4597h = matrix;
        }
        this.f4594e.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void F(boolean z10) {
        this.C = z10;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void G(Outline outline, long j11) {
        this.f4594e.setOutline(outline);
        this.f4598i = outline != null;
        M();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void H(long j11) {
        this.f4602m = j11;
        if (y.h.d(j11)) {
            this.f4594e.resetPivot();
        } else {
            this.f4594e.setPivotX(y.g.m(j11));
            this.f4594e.setPivotY(y.g.n(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void I(o0.e eVar, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1 function1) {
        RecordingCanvas beginRecording;
        beginRecording = this.f4594e.beginRecording();
        try {
            n1 n1Var = this.f4592c;
            Canvas v11 = n1Var.a().v();
            n1Var.a().w(beginRecording);
            androidx.compose.ui.graphics.g0 a11 = n1Var.a();
            z.d H0 = this.f4593d.H0();
            H0.b(eVar);
            H0.a(layoutDirection);
            H0.d(graphicsLayer);
            H0.f(this.f4595f);
            H0.h(a11);
            function1.invoke(this.f4593d);
            n1Var.a().w(v11);
            this.f4594e.endRecording();
            F(false);
        } catch (Throwable th2) {
            this.f4594e.endRecording();
            throw th2;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void J(int i11) {
        this.B = i11;
        R();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float K() {
        return this.f4607r;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void L(m1 m1Var) {
        androidx.compose.ui.graphics.h0.d(m1Var).drawRenderNode(this.f4594e);
    }

    public boolean O() {
        return this.f4614y;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void a(float f11) {
        this.f4606q = f11;
        this.f4594e.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void b(float f11) {
        this.f4603n = f11;
        this.f4594e.setScaleX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void c(w4 w4Var) {
        if (Build.VERSION.SDK_INT >= 31) {
            q0.f4676a.a(this.f4594e, w4Var);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void d(float f11) {
        this.f4613x = f11;
        this.f4594e.setCameraDistance(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void e(float f11) {
        this.f4610u = f11;
        this.f4594e.setRotationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void f(float f11) {
        this.f4611v = f11;
        this.f4594e.setRotationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void g(float f11) {
        this.f4612w = f11;
        this.f4594e.setRotationZ(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.f4599j;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void h(float f11) {
        this.f4604o = f11;
        this.f4594e.setScaleY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public v1 i() {
        return this.f4601l;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void j(float f11) {
        this.f4605p = f11;
        this.f4594e.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void k() {
        this.f4594e.discardDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int l() {
        return this.f4600k;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float m() {
        return this.f4611v;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean n() {
        boolean hasDisplayList;
        hasDisplayList = this.f4594e.hasDisplayList();
        return hasDisplayList;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float o() {
        return this.f4612w;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void p(long j11) {
        this.f4608s = j11;
        this.f4594e.setAmbientShadowColor(w1.j(j11));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float q() {
        return this.f4613x;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void r(boolean z10) {
        this.f4614y = z10;
        M();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void s(long j11) {
        this.f4609t = j11;
        this.f4594e.setSpotShadowColor(w1.j(j11));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f11) {
        this.f4599j = f11;
        this.f4594e.setAlpha(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float t() {
        return this.f4603n;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void u(float f11) {
        this.f4607r = f11;
        this.f4594e.setElevation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public w4 v() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float w() {
        return this.f4606q;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float x() {
        return this.f4605p;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float y() {
        return this.f4610u;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int z() {
        return this.B;
    }
}
