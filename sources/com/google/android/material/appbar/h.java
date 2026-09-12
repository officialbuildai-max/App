package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class h extends i {

    /* renamed from: d, reason: collision with root package name */
    final Rect f28319d;

    /* renamed from: e, reason: collision with root package name */
    final Rect f28320e;

    /* renamed from: f, reason: collision with root package name */
    private int f28321f;

    /* renamed from: g, reason: collision with root package name */
    private int f28322g;

    public h() {
        this.f28319d = new Rect();
        this.f28320e = new Rect();
        this.f28321f = 0;
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28319d = new Rect();
        this.f28320e = new Rect();
        this.f28321f = 0;
    }

    private static int N(int i11) {
        return i11 == 0 ? MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START : i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.i
    public void F(CoordinatorLayout coordinatorLayout, View view, int i11) {
        View H = H(coordinatorLayout.getDependencies(view));
        if (H == null) {
            super.F(coordinatorLayout, view, i11);
            this.f28321f = 0;
            return;
        }
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        Rect rect = this.f28319d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, H.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left += lastWindowInsets.getSystemWindowInsetLeft();
            rect.right -= lastWindowInsets.getSystemWindowInsetRight();
        }
        Rect rect2 = this.f28320e;
        GravityCompat.apply(N(fVar.f7984c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i11);
        int I = I(H);
        view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
        this.f28321f = rect2.top - H.getBottom();
    }

    abstract View H(List list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int I(View view) {
        if (this.f28322g == 0) {
            return 0;
        }
        float J = J(view);
        int i11 = this.f28322g;
        return d1.a.b((int) (J * i11), 0, i11);
    }

    float J(View view) {
        return 1.0f;
    }

    public final int K() {
        return this.f28322g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int L(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int M() {
        return this.f28321f;
    }

    public final void O(int i11) {
        this.f28322g = i11;
    }

    protected boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i11, int i12, int i13, int i14) {
        View H;
        WindowInsetsCompat lastWindowInsets;
        int i15 = view.getLayoutParams().height;
        if ((i15 != -1 && i15 != -2) || (H = H(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i13);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.getFitsSystemWindows(H) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
        }
        int L = size + L(H);
        int measuredHeight = H.getMeasuredHeight();
        if (P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            L -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i11, i12, View.MeasureSpec.makeMeasureSpec(L, i15 == -1 ? 1073741824 : Integer.MIN_VALUE), i14);
        return true;
    }
}
