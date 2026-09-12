package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.w3;
import androidx.compose.ui.graphics.w4;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class j1 implements t0 {

    /* renamed from: k, reason: collision with root package name */
    private static boolean f5902k;

    /* renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f5904a;

    /* renamed from: b, reason: collision with root package name */
    private final RenderNode f5905b;

    /* renamed from: c, reason: collision with root package name */
    private int f5906c;

    /* renamed from: d, reason: collision with root package name */
    private int f5907d;

    /* renamed from: e, reason: collision with root package name */
    private int f5908e;

    /* renamed from: f, reason: collision with root package name */
    private int f5909f;

    /* renamed from: g, reason: collision with root package name */
    private int f5910g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5911h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f5900i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final int f5901j = 8;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f5903l = true;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j1(AndroidComposeView androidComposeView) {
        this.f5904a = androidComposeView;
        RenderNode create = RenderNode.create("Compose", androidComposeView);
        this.f5905b = create;
        this.f5906c = w3.f4949a.a();
        if (f5903l) {
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
            N(create);
            I();
            create.setLayerType(0);
            create.setHasOverlappingRendering(create.hasOverlappingRendering());
            f5903l = false;
        }
        if (f5902k) {
            throw new NoClassDefFoundError();
        }
    }

    private final void I() {
        if (Build.VERSION.SDK_INT >= 24) {
            z1.f5966a.a(this.f5905b);
        } else {
            y1.f5958a.a(this.f5905b);
        }
    }

    private final void N(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            a2 a2Var = a2.f5805a;
            a2Var.c(renderNode, a2Var.a(renderNode));
            a2Var.d(renderNode, a2Var.b(renderNode));
        }
    }

    @Override // androidx.compose.ui.platform.t0
    public void A(float f11) {
        this.f5905b.setPivotX(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void B(float f11) {
        this.f5905b.setPivotY(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void C(Outline outline) {
        this.f5905b.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.t0
    public void D(int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            a2.f5805a.c(this.f5905b, i11);
        }
    }

    @Override // androidx.compose.ui.platform.t0
    public void E(boolean z10) {
        this.f5905b.setClipToOutline(z10);
    }

    @Override // androidx.compose.ui.platform.t0
    public void F(androidx.compose.ui.graphics.n1 n1Var, Path path, Function1 function1) {
        DisplayListCanvas start = this.f5905b.start(getWidth(), getHeight());
        Canvas v11 = n1Var.a().v();
        n1Var.a().w((Canvas) start);
        androidx.compose.ui.graphics.g0 a11 = n1Var.a();
        if (path != null) {
            a11.n();
            androidx.compose.ui.graphics.l1.c(a11, path, 0, 2, null);
        }
        function1.invoke(a11);
        if (path != null) {
            a11.j();
        }
        n1Var.a().w(v11);
        this.f5905b.end(start);
    }

    @Override // androidx.compose.ui.platform.t0
    public void G(int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            a2.f5805a.d(this.f5905b, i11);
        }
    }

    @Override // androidx.compose.ui.platform.t0
    public float H() {
        return this.f5905b.getElevation();
    }

    public void J(int i11) {
        this.f5910g = i11;
    }

    public void K(int i11) {
        this.f5907d = i11;
    }

    public void L(int i11) {
        this.f5909f = i11;
    }

    public void M(int i11) {
        this.f5908e = i11;
    }

    @Override // androidx.compose.ui.platform.t0
    public void a(float f11) {
        this.f5905b.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void b(float f11) {
        this.f5905b.setScaleX(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void c(w4 w4Var) {
    }

    @Override // androidx.compose.ui.platform.t0
    public void d(float f11) {
        this.f5905b.setCameraDistance(-f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void e(float f11) {
        this.f5905b.setRotationX(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void f(float f11) {
        this.f5905b.setRotationY(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void g(float f11) {
        this.f5905b.setRotation(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public float getAlpha() {
        return this.f5905b.getAlpha();
    }

    @Override // androidx.compose.ui.platform.t0
    public int getHeight() {
        return z() - u();
    }

    @Override // androidx.compose.ui.platform.t0
    public int getWidth() {
        return m() - i();
    }

    @Override // androidx.compose.ui.platform.t0
    public void h(float f11) {
        this.f5905b.setScaleY(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public int i() {
        return this.f5907d;
    }

    @Override // androidx.compose.ui.platform.t0
    public void j(float f11) {
        this.f5905b.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void k() {
        I();
    }

    @Override // androidx.compose.ui.platform.t0
    public void l(int i11) {
        w3.a aVar = w3.f4949a;
        if (w3.e(i11, aVar.c())) {
            this.f5905b.setLayerType(2);
            this.f5905b.setHasOverlappingRendering(true);
        } else if (w3.e(i11, aVar.b())) {
            this.f5905b.setLayerType(0);
            this.f5905b.setHasOverlappingRendering(false);
        } else {
            this.f5905b.setLayerType(0);
            this.f5905b.setHasOverlappingRendering(true);
        }
        this.f5906c = i11;
    }

    @Override // androidx.compose.ui.platform.t0
    public int m() {
        return this.f5909f;
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean n() {
        return this.f5905b.isValid();
    }

    @Override // androidx.compose.ui.platform.t0
    public void o(Canvas canvas) {
        Intrinsics.f(canvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.f5905b);
    }

    @Override // androidx.compose.ui.platform.t0
    public void p(boolean z10) {
        this.f5911h = z10;
        this.f5905b.setClipToBounds(z10);
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean q(int i11, int i12, int i13, int i14) {
        K(i11);
        M(i12);
        L(i13);
        J(i14);
        return this.f5905b.setLeftTopRightBottom(i11, i12, i13, i14);
    }

    @Override // androidx.compose.ui.platform.t0
    public void r(float f11) {
        this.f5905b.setElevation(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void s(int i11) {
        M(u() + i11);
        J(z() + i11);
        this.f5905b.offsetTopAndBottom(i11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void setAlpha(float f11) {
        this.f5905b.setAlpha(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean t() {
        return this.f5911h;
    }

    @Override // androidx.compose.ui.platform.t0
    public int u() {
        return this.f5908e;
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean v() {
        return this.f5905b.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean w(boolean z10) {
        return this.f5905b.setHasOverlappingRendering(z10);
    }

    @Override // androidx.compose.ui.platform.t0
    public void x(Matrix matrix) {
        this.f5905b.getMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.t0
    public void y(int i11) {
        K(i() + i11);
        L(m() + i11);
        this.f5905b.offsetLeftAndRight(i11);
    }

    @Override // androidx.compose.ui.platform.t0
    public int z() {
        return this.f5910g;
    }
}
