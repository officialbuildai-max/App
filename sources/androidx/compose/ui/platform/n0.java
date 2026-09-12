package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import androidx.compose.ui.graphics.i4;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f5920a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f5921b;

    private n0(float[] fArr) {
        this.f5920a = fArr;
        this.f5921b = new int[2];
    }

    public /* synthetic */ n0(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    private final void b(float[] fArr, Matrix matrix) {
        androidx.compose.ui.graphics.r0.b(this.f5920a, matrix);
        AndroidComposeView_androidKt.i(fArr, this.f5920a);
    }

    private final void c(float[] fArr, float f11, float f12) {
        AndroidComposeView_androidKt.j(fArr, f11, f12, this.f5920a);
    }

    private final void d(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            d((View) parent, fArr);
            c(fArr, -view.getScrollX(), -view.getScrollY());
            c(fArr, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.f5921b);
            c(fArr, -view.getScrollX(), -view.getScrollY());
            c(fArr, r0[0], r0[1]);
        }
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        b(fArr, matrix);
    }

    @Override // androidx.compose.ui.platform.m0
    public void a(View view, float[] fArr) {
        i4.h(fArr);
        d(view, fArr);
    }
}
