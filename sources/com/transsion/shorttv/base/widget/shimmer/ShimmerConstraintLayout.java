package com.transsion.shorttv.base.widget.shimmer;

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
import com.transsion.shorttv.R$styleable;
import com.transsion.shorttv.base.widget.shimmer.a;

/* loaded from: classes6.dex */
public class ShimmerConstraintLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f52979a;

    /* renamed from: b, reason: collision with root package name */
    private final b f52980b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f52981c;

    public ShimmerConstraintLayout(Context context) {
        super(context);
        this.f52979a = new Paint();
        this.f52980b = new b();
        this.f52981c = true;
        init(context, null);
    }

    public ShimmerConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f52979a = new Paint();
        this.f52980b = new b();
        this.f52981c = true;
        init(context, attributeSet);
    }

    public ShimmerConstraintLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f52979a = new Paint();
        this.f52980b = new b();
        this.f52981c = true;
        init(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerConstraintLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f52979a = new Paint();
        this.f52980b = new b();
        this.f52981c = true;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setLayerType(1, null);
        setWillNotDraw(false);
        this.f52980b.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new a.C0654a().a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShortTvShimmerConstraintLayout, 0, 0);
        try {
            setShimmer(((obtainStyledAttributes.hasValue(R$styleable.ShortTvShimmerConstraintLayout_short_tv_shimmer_colored) && obtainStyledAttributes.getBoolean(R$styleable.ShortTvShimmerConstraintLayout_short_tv_shimmer_colored, false)) ? new a.c() : new a.C0654a()).c(obtainStyledAttributes).a());
            obtainStyledAttributes.recycle();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f52981c) {
            this.f52980b.draw(canvas);
        }
    }

    public void hideShimmer() {
        stopShimmer();
        this.f52981c = false;
        invalidate();
    }

    public boolean isShimmerStarted() {
        return this.f52980b.a();
    }

    public boolean isShimmerVisible() {
        return this.f52981c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f52981c && getVisibility() == 0) {
            this.f52980b.b();
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
        this.f52980b.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            stopShimmer();
        } else if (this.f52981c && isAttachedToWindow()) {
            this.f52980b.b();
        }
    }

    public ShimmerConstraintLayout setShimmer(@Nullable a aVar) {
        this.f52980b.d(aVar);
        if (aVar == null || !aVar.f53002o) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.f52979a);
        }
        return this;
    }

    public void setShimmerListener(Animator.AnimatorListener animatorListener) {
        this.f52980b.e(animatorListener);
    }

    public void showShimmer(boolean z10) {
        this.f52981c = true;
        if (z10) {
            startShimmer();
        }
        invalidate();
    }

    public void startShimmer() {
        this.f52980b.f();
    }

    public void startShimmer(int i11, AnimatorListenerAdapter animatorListenerAdapter) {
        this.f52980b.g(i11, animatorListenerAdapter);
    }

    public void stopShimmer() {
        this.f52980b.h();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f52980b;
    }
}
