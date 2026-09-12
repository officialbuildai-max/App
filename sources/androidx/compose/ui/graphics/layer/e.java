package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.layer.b;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.n1;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.w4;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o0.t;

/* loaded from: classes.dex */
public final class e implements GraphicsLayerImpl {
    private static boolean G;
    private float A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;

    /* renamed from: b, reason: collision with root package name */
    private final long f4641b;

    /* renamed from: c, reason: collision with root package name */
    private final n1 f4642c;

    /* renamed from: d, reason: collision with root package name */
    private final z.a f4643d;

    /* renamed from: e, reason: collision with root package name */
    private final RenderNode f4644e;

    /* renamed from: f, reason: collision with root package name */
    private long f4645f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f4646g;

    /* renamed from: h, reason: collision with root package name */
    private Matrix f4647h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4648i;

    /* renamed from: j, reason: collision with root package name */
    private long f4649j;

    /* renamed from: k, reason: collision with root package name */
    private int f4650k;

    /* renamed from: l, reason: collision with root package name */
    private int f4651l;

    /* renamed from: m, reason: collision with root package name */
    private v1 f4652m;

    /* renamed from: n, reason: collision with root package name */
    private float f4653n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4654o;

    /* renamed from: p, reason: collision with root package name */
    private long f4655p;

    /* renamed from: q, reason: collision with root package name */
    private float f4656q;

    /* renamed from: r, reason: collision with root package name */
    private float f4657r;

    /* renamed from: s, reason: collision with root package name */
    private float f4658s;

    /* renamed from: t, reason: collision with root package name */
    private float f4659t;

    /* renamed from: u, reason: collision with root package name */
    private float f4660u;

    /* renamed from: v, reason: collision with root package name */
    private long f4661v;

    /* renamed from: w, reason: collision with root package name */
    private long f4662w;

    /* renamed from: x, reason: collision with root package name */
    private float f4663x;

    /* renamed from: y, reason: collision with root package name */
    private float f4664y;

    /* renamed from: z, reason: collision with root package name */
    private float f4665z;
    public static final a F = new a(null);
    private static final AtomicBoolean H = new AtomicBoolean(true);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(View view, long j11, n1 n1Var, z.a aVar) {
        this.f4641b = j11;
        this.f4642c = n1Var;
        this.f4643d = aVar;
        RenderNode create = RenderNode.create("Compose", view);
        this.f4644e = create;
        t.a aVar2 = o0.t.f70747b;
        this.f4645f = aVar2.a();
        this.f4649j = aVar2.a();
        if (H.getAndSet(false)) {
            create.setScaleX(create.getScaleX());
            create.setScaleY(create.getScaleY());
            create.setTranslationX(create.getTranslationX());
            create.setTranslationY(create.getTranslationY());
            create.setElevation(create.getElevation());
            create.setRotation(create.getRotation());
            create.setRotationX(create.getRotationX());
            create.setRotationY(create.getRotationY());
            create.setCameraDistance(create.getCameraDistance());
            create.setPivotX(create.getPivotX());
            create.setPivotY(create.getPivotY());
            create.setClipToOutline(create.getClipToOutline());
            create.setClipToBounds(false);
            create.setAlpha(create.getAlpha());
            create.isValid();
            create.setLeftTopRightBottom(0, 0, 0, 0);
            create.offsetLeftAndRight(0);
            create.offsetTopAndBottom(0);
            S(create);
            O();
            create.setLayerType(0);
            create.setHasOverlappingRendering(create.hasOverlappingRendering());
        }
        if (G) {
            throw new NoClassDefFoundError();
        }
        create.setClipToBounds(false);
        b.a aVar3 = b.f4587a;
        N(aVar3.a());
        this.f4650k = aVar3.a();
        this.f4651l = c1.f4367a.B();
        this.f4653n = 1.0f;
        this.f4655p = y.g.f78593b.b();
        this.f4656q = 1.0f;
        this.f4657r = 1.0f;
        u1.a aVar4 = u1.f4733b;
        this.f4661v = aVar4.a();
        this.f4662w = aVar4.a();
        this.A = 8.0f;
        this.E = true;
    }

    public /* synthetic */ e(View view, long j11, n1 n1Var, z.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, j11, (i11 & 4) != 0 ? new n1() : n1Var, (i11 & 8) != 0 ? new z.a() : aVar);
    }

    private final void M() {
        boolean z10 = false;
        boolean z11 = P() && !this.f4648i;
        if (P() && this.f4648i) {
            z10 = true;
        }
        if (z11 != this.C) {
            this.C = z11;
            this.f4644e.setClipToBounds(z11);
        }
        if (z10 != this.D) {
            this.D = z10;
            this.f4644e.setClipToOutline(z10);
        }
    }

    private final void N(int i11) {
        RenderNode renderNode = this.f4644e;
        b.a aVar = b.f4587a;
        if (b.e(i11, aVar.c())) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.f4646g);
            renderNode.setHasOverlappingRendering(true);
        } else if (b.e(i11, aVar.b())) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.f4646g);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.f4646g);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final boolean Q() {
        return (!b.e(z(), b.f4587a.c()) && c1.E(l(), c1.f4367a.B()) && i() == null) ? false : true;
    }

    private final void R() {
        if (Q()) {
            N(b.f4587a.c());
        } else {
            N(z());
        }
    }

    private final void S(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            p0 p0Var = p0.f4675a;
            p0Var.c(renderNode, p0Var.a(renderNode));
            p0Var.d(renderNode, p0Var.b(renderNode));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float A() {
        return this.f4657r;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void B(int i11, int i12, long j11) {
        this.f4644e.setLeftTopRightBottom(i11, i12, o0.t.g(j11) + i11, o0.t.f(j11) + i12);
        if (o0.t.e(this.f4645f, j11)) {
            return;
        }
        if (this.f4654o) {
            this.f4644e.setPivotX(o0.t.g(j11) / 2.0f);
            this.f4644e.setPivotY(o0.t.f(j11) / 2.0f);
        }
        this.f4645f = j11;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long C() {
        return this.f4661v;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long D() {
        return this.f4662w;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix E() {
        Matrix matrix = this.f4647h;
        if (matrix == null) {
            matrix = new Matrix();
            this.f4647h = matrix;
        }
        this.f4644e.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void F(boolean z10) {
        this.E = z10;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void G(Outline outline, long j11) {
        this.f4649j = j11;
        this.f4644e.setOutline(outline);
        this.f4648i = outline != null;
        M();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void H(long j11) {
        this.f4655p = j11;
        if (y.h.d(j11)) {
            this.f4654o = true;
            this.f4644e.setPivotX(o0.t.g(this.f4645f) / 2.0f);
            this.f4644e.setPivotY(o0.t.f(this.f4645f) / 2.0f);
        } else {
            this.f4654o = false;
            this.f4644e.setPivotX(y.g.m(j11));
            this.f4644e.setPivotY(y.g.n(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void I(o0.e eVar, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1 function1) {
        Canvas start = this.f4644e.start(Math.max(o0.t.g(this.f4645f), o0.t.g(this.f4649j)), Math.max(o0.t.f(this.f4645f), o0.t.f(this.f4649j)));
        try {
            n1 n1Var = this.f4642c;
            Canvas v11 = n1Var.a().v();
            n1Var.a().w(start);
            androidx.compose.ui.graphics.g0 a11 = n1Var.a();
            z.a aVar = this.f4643d;
            long d11 = o0.u.d(this.f4645f);
            o0.e density = aVar.H0().getDensity();
            LayoutDirection layoutDirection2 = aVar.H0().getLayoutDirection();
            m1 e11 = aVar.H0().e();
            long i11 = aVar.H0().i();
            GraphicsLayer g11 = aVar.H0().g();
            z.d H0 = aVar.H0();
            H0.b(eVar);
            H0.a(layoutDirection);
            H0.h(a11);
            H0.f(d11);
            H0.d(graphicsLayer);
            a11.n();
            try {
                function1.invoke(aVar);
                a11.j();
                z.d H02 = aVar.H0();
                H02.b(density);
                H02.a(layoutDirection2);
                H02.h(e11);
                H02.f(i11);
                H02.d(g11);
                n1Var.a().w(v11);
                this.f4644e.end(start);
                F(false);
            } catch (Throwable th2) {
                a11.j();
                z.d H03 = aVar.H0();
                H03.b(density);
                H03.a(layoutDirection2);
                H03.h(e11);
                H03.f(i11);
                H03.d(g11);
                throw th2;
            }
        } catch (Throwable th3) {
            this.f4644e.end(start);
            throw th3;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void J(int i11) {
        this.f4650k = i11;
        R();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float K() {
        return this.f4660u;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void L(m1 m1Var) {
        DisplayListCanvas d11 = androidx.compose.ui.graphics.h0.d(m1Var);
        Intrinsics.f(d11, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        d11.drawRenderNode(this.f4644e);
    }

    public final void O() {
        if (Build.VERSION.SDK_INT >= 24) {
            o0.f4674a.a(this.f4644e);
        } else {
            n0.f4673a.a(this.f4644e);
        }
    }

    public boolean P() {
        return this.B;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void a(float f11) {
        this.f4659t = f11;
        this.f4644e.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void b(float f11) {
        this.f4656q = f11;
        this.f4644e.setScaleX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void c(w4 w4Var) {
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void d(float f11) {
        this.A = f11;
        this.f4644e.setCameraDistance(-f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void e(float f11) {
        this.f4663x = f11;
        this.f4644e.setRotationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void f(float f11) {
        this.f4664y = f11;
        this.f4644e.setRotationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void g(float f11) {
        this.f4665z = f11;
        this.f4644e.setRotation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.f4653n;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void h(float f11) {
        this.f4657r = f11;
        this.f4644e.setScaleY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public v1 i() {
        return this.f4652m;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void j(float f11) {
        this.f4658s = f11;
        this.f4644e.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void k() {
        O();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int l() {
        return this.f4651l;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float m() {
        return this.f4664y;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean n() {
        return this.f4644e.isValid();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float o() {
        return this.f4665z;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void p(long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4661v = j11;
            p0.f4675a.c(this.f4644e, w1.j(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float q() {
        return this.A;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void r(boolean z10) {
        this.B = z10;
        M();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void s(long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4662w = j11;
            p0.f4675a.d(this.f4644e, w1.j(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f11) {
        this.f4653n = f11;
        this.f4644e.setAlpha(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float t() {
        return this.f4656q;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void u(float f11) {
        this.f4660u = f11;
        this.f4644e.setElevation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public w4 v() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float w() {
        return this.f4659t;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float x() {
        return this.f4658s;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float y() {
        return this.f4663x;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int z() {
        return this.f4650k;
    }
}
