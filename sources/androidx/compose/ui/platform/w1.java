package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.w3;
import androidx.compose.ui.graphics.w4;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class w1 implements t0 {

    /* renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f5945a;

    /* renamed from: b, reason: collision with root package name */
    private final RenderNode f5946b = androidx.compose.foundation.i.a("Compose");

    /* renamed from: c, reason: collision with root package name */
    private int f5947c = w3.f4949a.a();

    public w1(AndroidComposeView androidComposeView) {
        this.f5945a = androidComposeView;
    }

    @Override // androidx.compose.ui.platform.t0
    public void A(float f11) {
        this.f5946b.setPivotX(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void B(float f11) {
        this.f5946b.setPivotY(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void C(Outline outline) {
        this.f5946b.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.t0
    public void D(int i11) {
        this.f5946b.setAmbientShadowColor(i11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void E(boolean z10) {
        this.f5946b.setClipToOutline(z10);
    }

    @Override // androidx.compose.ui.platform.t0
    public void F(androidx.compose.ui.graphics.n1 n1Var, Path path, Function1 function1) {
        RecordingCanvas beginRecording;
        beginRecording = this.f5946b.beginRecording();
        Canvas v11 = n1Var.a().v();
        n1Var.a().w(beginRecording);
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
        this.f5946b.endRecording();
    }

    @Override // androidx.compose.ui.platform.t0
    public void G(int i11) {
        this.f5946b.setSpotShadowColor(i11);
    }

    @Override // androidx.compose.ui.platform.t0
    public float H() {
        float elevation;
        elevation = this.f5946b.getElevation();
        return elevation;
    }

    @Override // androidx.compose.ui.platform.t0
    public void a(float f11) {
        this.f5946b.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void b(float f11) {
        this.f5946b.setScaleX(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void c(w4 w4Var) {
        if (Build.VERSION.SDK_INT >= 31) {
            x1.f5954a.a(this.f5946b, w4Var);
        }
    }

    @Override // androidx.compose.ui.platform.t0
    public void d(float f11) {
        this.f5946b.setCameraDistance(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void e(float f11) {
        this.f5946b.setRotationX(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void f(float f11) {
        this.f5946b.setRotationY(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void g(float f11) {
        this.f5946b.setRotationZ(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public float getAlpha() {
        float alpha;
        alpha = this.f5946b.getAlpha();
        return alpha;
    }

    @Override // androidx.compose.ui.platform.t0
    public int getHeight() {
        int height;
        height = this.f5946b.getHeight();
        return height;
    }

    @Override // androidx.compose.ui.platform.t0
    public int getWidth() {
        int width;
        width = this.f5946b.getWidth();
        return width;
    }

    @Override // androidx.compose.ui.platform.t0
    public void h(float f11) {
        this.f5946b.setScaleY(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public int i() {
        int left;
        left = this.f5946b.getLeft();
        return left;
    }

    @Override // androidx.compose.ui.platform.t0
    public void j(float f11) {
        this.f5946b.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void k() {
        this.f5946b.discardDisplayList();
    }

    @Override // androidx.compose.ui.platform.t0
    public void l(int i11) {
        RenderNode renderNode = this.f5946b;
        w3.a aVar = w3.f4949a;
        if (w3.e(i11, aVar.c())) {
            renderNode.setUseCompositingLayer(true, null);
            renderNode.setHasOverlappingRendering(true);
        } else if (w3.e(i11, aVar.b())) {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(true);
        }
        this.f5947c = i11;
    }

    @Override // androidx.compose.ui.platform.t0
    public int m() {
        int right;
        right = this.f5946b.getRight();
        return right;
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean n() {
        boolean hasDisplayList;
        hasDisplayList = this.f5946b.hasDisplayList();
        return hasDisplayList;
    }

    @Override // androidx.compose.ui.platform.t0
    public void o(Canvas canvas) {
        canvas.drawRenderNode(this.f5946b);
    }

    @Override // androidx.compose.ui.platform.t0
    public void p(boolean z10) {
        this.f5946b.setClipToBounds(z10);
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean q(int i11, int i12, int i13, int i14) {
        boolean position;
        position = this.f5946b.setPosition(i11, i12, i13, i14);
        return position;
    }

    @Override // androidx.compose.ui.platform.t0
    public void r(float f11) {
        this.f5946b.setElevation(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void s(int i11) {
        this.f5946b.offsetTopAndBottom(i11);
    }

    @Override // androidx.compose.ui.platform.t0
    public void setAlpha(float f11) {
        this.f5946b.setAlpha(f11);
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean t() {
        boolean clipToBounds;
        clipToBounds = this.f5946b.getClipToBounds();
        return clipToBounds;
    }

    @Override // androidx.compose.ui.platform.t0
    public int u() {
        int top;
        top = this.f5946b.getTop();
        return top;
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean v() {
        boolean clipToOutline;
        clipToOutline = this.f5946b.getClipToOutline();
        return clipToOutline;
    }

    @Override // androidx.compose.ui.platform.t0
    public boolean w(boolean z10) {
        boolean hasOverlappingRendering;
        hasOverlappingRendering = this.f5946b.setHasOverlappingRendering(z10);
        return hasOverlappingRendering;
    }

    @Override // androidx.compose.ui.platform.t0
    public void x(Matrix matrix) {
        this.f5946b.getMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.t0
    public void y(int i11) {
        this.f5946b.offsetLeftAndRight(i11);
    }

    @Override // androidx.compose.ui.platform.t0
    public int z() {
        int bottom;
        bottom = this.f5946b.getBottom();
        return bottom;
    }
}
