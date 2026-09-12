package com.transsion.baseui.widget.shimmer;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.transsion.baseui.R$styleable;
import com.transsion.baseui.widget.shimmer.a;

/* loaded from: classes5.dex */
public class ShimmerLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f43741a;

    /* renamed from: b, reason: collision with root package name */
    private final b f43742b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f43743c;

    public ShimmerLinearLayout(Context context) {
        super(context);
        this.f43741a = new Paint();
        this.f43742b = new b();
        this.f43743c = true;
        a(context, null);
    }

    public ShimmerLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43741a = new Paint();
        this.f43742b = new b();
        this.f43743c = true;
        a(context, attributeSet);
    }

    public ShimmerLinearLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43741a = new Paint();
        this.f43742b = new b();
        this.f43743c = true;
        a(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerLinearLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f43741a = new Paint();
        this.f43742b = new b();
        this.f43743c = true;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setLayerType(1, null);
        setWillNotDraw(false);
        this.f43742b.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new a.C0612a().a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShimmerFrameLayout, 0, 0);
        try {
            setShimmer(((obtainStyledAttributes.hasValue(R$styleable.ShimmerFrameLayout_shimmer_colored) && obtainStyledAttributes.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_colored, false)) ? new a.c() : new a.C0612a()).c(obtainStyledAttributes).a());
            obtainStyledAttributes.recycle();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f43743c) {
            this.f43742b.draw(canvas);
        }
    }

    public void hideShimmer() {
        stopShimmer();
        this.f43743c = false;
        invalidate();
    }

    public boolean isShimmerStarted() {
        return this.f43742b.a();
    }

    public boolean isShimmerVisible() {
        return this.f43743c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f43743c && getVisibility() == 0) {
            this.f43742b.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        this.f43742b.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            stopShimmer();
        } else if (this.f43743c && isAttachedToWindow()) {
            this.f43742b.b();
        }
    }

    public ShimmerLinearLayout setShimmer(@Nullable a aVar) {
        this.f43742b.d(aVar);
        if (aVar == null || !aVar.f43758o) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.f43741a);
        }
        return this;
    }

    public void setShimmerListener(Animator.AnimatorListener animatorListener) {
        this.f43742b.e(animatorListener);
    }

    public void showShimmer(boolean z10) {
        this.f43743c = true;
        if (z10) {
            startShimmer();
        }
        invalidate();
    }

    public void startShimmer() {
        this.f43742b.f();
    }

    public void stopShimmer() {
        this.f43742b.h();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f43742b;
    }
}
