package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes4.dex */
public class i implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f29279a;

    /* renamed from: b, reason: collision with root package name */
    private final View f29280b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f29281c = new float[2];

    public i(View view, View view2) {
        this.f29279a = view;
        this.f29280b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        j.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f29281c);
        View view = this.f29279a;
        if (view != null) {
            view.setAlpha(this.f29281c[0]);
        }
        View view2 = this.f29280b;
        if (view2 != null) {
            view2.setAlpha(this.f29281c[1]);
        }
    }
}
