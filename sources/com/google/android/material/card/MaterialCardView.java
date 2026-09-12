package com.google.android.material.card;

import ab.j;
import ab.n;
import ab.q;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes4.dex */
public class MaterialCardView extends CardView implements Checkable, q {
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_END = 8388693;
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_START = 8388691;
    public static final int CHECKED_ICON_GRAVITY_TOP_END = 8388661;
    public static final int CHECKED_ICON_GRAVITY_TOP_START = 8388659;

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f28591n = {R.attr.state_checkable};

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f28592o = {R.attr.state_checked};

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f28593p = {R$attr.state_dragged};

    /* renamed from: q, reason: collision with root package name */
    private static final int f28594q = R$style.Widget_MaterialComponents_CardView;

    /* renamed from: j, reason: collision with root package name */
    private final b f28595j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f28596k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f28597l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f28598m;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = com.google.android.material.card.MaterialCardView.f28594q
            android.content.Context r8 = bb.a.c(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.f28597l = r8
            r7.f28598m = r8
            r0 = 1
            r7.f28596k = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialCardView
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.b0.i(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.b r0 = new com.google.android.material.card.b
            r0.<init>(r7, r9, r10, r6)
            r7.f28595j = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.M(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.c0(r9, r10, r1, r2)
            r0.J(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void c() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f28595j.k();
        }
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f28595j.l().getBounds());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i11, int i12, int i13, int i14) {
        super.setContentPadding(i11, i12, i13, i14);
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f28595j.m();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f28595j.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f28595j.o();
    }

    public int getCheckedIconGravity() {
        return this.f28595j.p();
    }

    public int getCheckedIconMargin() {
        return this.f28595j.q();
    }

    public int getCheckedIconSize() {
        return this.f28595j.r();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f28595j.s();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f28595j.C().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f28595j.C().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f28595j.C().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f28595j.C().top;
    }

    public float getProgress() {
        return this.f28595j.w();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f28595j.u();
    }

    public ColorStateList getRippleColor() {
        return this.f28595j.x();
    }

    @NonNull
    public n getShapeAppearanceModel() {
        return this.f28595j.y();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f28595j.z();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f28595j.A();
    }

    public int getStrokeWidth() {
        return this.f28595j.B();
    }

    public boolean isCheckable() {
        b bVar = this.f28595j;
        return bVar != null && bVar.F();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f28597l;
    }

    public boolean isDragged() {
        return this.f28598m;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f28595j.g0();
        j.f(this, this.f28595j.l());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 3);
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, f28591n);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f28592o);
        }
        if (isDragged()) {
            View.mergeDrawableStates(onCreateDrawableState, f28593p);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f28595j.K(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f28596k) {
            if (!this.f28595j.E()) {
                this.f28595j.L(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i11) {
        this.f28595j.M(ColorStateList.valueOf(i11));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f28595j.M(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f11) {
        super.setCardElevation(f11);
        this.f28595j.i0();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.f28595j.N(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.f28595j.O(z10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f28597l != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f28595j.R(drawable);
    }

    public void setCheckedIconGravity(int i11) {
        if (this.f28595j.p() != i11) {
            this.f28595j.S(i11);
        }
    }

    public void setCheckedIconMargin(int i11) {
        this.f28595j.T(i11);
    }

    public void setCheckedIconMarginResource(int i11) {
        if (i11 != -1) {
            this.f28595j.T(getResources().getDimensionPixelSize(i11));
        }
    }

    public void setCheckedIconResource(int i11) {
        this.f28595j.R(g.a.b(getContext(), i11));
    }

    public void setCheckedIconSize(int i11) {
        this.f28595j.U(i11);
    }

    public void setCheckedIconSizeResource(int i11) {
        if (i11 != 0) {
            this.f28595j.U(getResources().getDimensionPixelSize(i11));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.f28595j.V(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
        b bVar = this.f28595j;
        if (bVar != null) {
            bVar.g0();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i11, int i12, int i13, int i14) {
        this.f28595j.c0(i11, i12, i13, i14);
    }

    public void setDragged(boolean z10) {
        if (this.f28598m != z10) {
            this.f28598m = z10;
            refreshDrawableState();
            c();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f11) {
        super.setMaxCardElevation(f11);
        this.f28595j.k0();
    }

    public void setOnCheckedChangeListener(@Nullable a aVar) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        this.f28595j.k0();
        this.f28595j.h0();
    }

    public void setProgress(float f11) {
        this.f28595j.X(f11);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f11) {
        super.setRadius(f11);
        this.f28595j.W(f11);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.f28595j.Y(colorStateList);
    }

    public void setRippleColorResource(int i11) {
        this.f28595j.Y(g.a.a(getContext(), i11));
    }

    @Override // ab.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        setClipToOutline(nVar.u(getBoundsAsRectF()));
        this.f28595j.Z(nVar);
    }

    public void setStrokeColor(int i11) {
        setStrokeColor(ColorStateList.valueOf(i11));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f28595j.a0(colorStateList);
        invalidate();
    }

    public void setStrokeWidth(int i11) {
        this.f28595j.b0(i11);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        this.f28595j.k0();
        this.f28595j.h0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.f28597l = !this.f28597l;
            refreshDrawableState();
            c();
            this.f28595j.Q(this.f28597l, true);
        }
    }
}
