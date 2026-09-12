package com.transsion.baseui.widget.shimmer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.R$styleable;
import com.transsion.baseui.widget.shimmer.a;

/* loaded from: classes5.dex */
public class ShimmerConstraintLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f43735a;

    /* renamed from: b, reason: collision with root package name */
    private final b f43736b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f43737c;

    public ShimmerConstraintLayout(Context context) {
        super(context);
        this.f43735a = new Paint();
        this.f43736b = new b();
        this.f43737c = true;
        init(context, null);
    }

    public ShimmerConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43735a = new Paint();
        this.f43736b = new b();
        this.f43737c = true;
        init(context, attributeSet);
    }

    public ShimmerConstraintLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43735a = new Paint();
        this.f43736b = new b();
        this.f43737c = true;
        init(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerConstraintLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f43735a = new Paint();
        this.f43736b = new b();
        this.f43737c = true;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setLayerType(1, null);
        setWillNotDraw(false);
        this.f43736b.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new a.C0612a().a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShimmerConstraintLayout, 0, 0);
        try {
            setShimmer(((obtainStyledAttributes.hasValue(R$styleable.ShimmerConstraintLayout_shimmer_colored) && obtainStyledAttributes.getBoolean(R$styleable.ShimmerConstraintLayout_shimmer_colored, false)) ? new a.c() : new a.C0612a()).c(obtainStyledAttributes).a());
            obtainStyledAttributes.recycle();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f43737c) {
            this.f43736b.draw(canvas);
        }
    }

    public void hideShimmer() {
        stopShimmer();
        this.f43737c = false;
        invalidate();
    }

    public boolean isShimmerStarted() {
        return this.f43736b.a();
    }

    public boolean isShimmerVisible() {
        return this.f43737c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f43737c && getVisibility() == 0) {
            this.f43736b.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        this.f43736b.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            stopShimmer();
        } else if (this.f43737c && isAttachedToWindow()) {
            this.f43736b.b();
        }
    }

    public ShimmerConstraintLayout setShimmer(@Nullable a aVar) {
        this.f43736b.d(aVar);
        if (aVar == null || !aVar.f43758o) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.f43735a);
        }
        return this;
    }

    public void setShimmerListener(Animator.AnimatorListener animatorListener) {
        this.f43736b.e(animatorListener);
    }

    public void showShimmer(boolean z10) {
        this.f43737c = true;
        if (z10) {
            startShimmer();
        }
        invalidate();
    }

    public void startShimmer() {
        this.f43736b.f();
    }

    public void startShimmer(int i11, AnimatorListenerAdapter animatorListenerAdapter) {
        this.f43736b.g(i11, animatorListenerAdapter);
    }

    public void stopShimmer() {
        this.f43736b.h();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f43736b;
    }
}
