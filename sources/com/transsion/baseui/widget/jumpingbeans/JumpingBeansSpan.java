package com.transsion.baseui.widget.jumpingbeans;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.TextPaint;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class JumpingBeansSpan extends SuperscriptSpan implements ValueAnimator.AnimatorUpdateListener {
    private final float animatedRange;
    private final int delay;
    private ValueAnimator jumpAnimator;
    private final int loopDuration;
    private int shift;
    private final WeakReference<TextView> textView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        private final float f43705a;

        public a(float f11) {
            this.f43705a = Math.abs(f11);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            if (f11 > this.f43705a) {
                return 0.0f;
            }
            return (float) Math.sin((f11 / r0) * 3.141592653589793d);
        }
    }

    public JumpingBeansSpan(TextView textView, int i11, int i12, int i13, float f11) {
        this.textView = new WeakReference<>(textView);
        this.delay = i13 * i12;
        this.loopDuration = i11;
        this.animatedRange = f11;
    }

    private void a() {
        d();
        Log.w("JumpingBeans", "!!! Remember to call JumpingBeans.stopJumping() when appropriate !!!");
    }

    private void b(float f11) {
        if (this.jumpAnimator != null) {
            return;
        }
        this.shift = 0;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, ((int) f11) / 2);
        this.jumpAnimator = ofInt;
        ofInt.setDuration(this.loopDuration).setStartDelay(this.delay);
        this.jumpAnimator.setInterpolator(new a(this.animatedRange));
        this.jumpAnimator.setRepeatCount(-1);
        this.jumpAnimator.setRepeatMode(1);
        this.jumpAnimator.addUpdateListener(this);
        this.jumpAnimator.start();
    }

    private static boolean c(View view) {
        return view.isAttachedToWindow();
    }

    private void e(ValueAnimator valueAnimator, TextView textView) {
        if (c(textView)) {
            this.shift = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            textView.invalidate();
        }
    }

    public void d() {
        ValueAnimator valueAnimator = this.jumpAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.jumpAnimator.removeAllListeners();
        }
        if (this.textView.get() != null) {
            this.textView.clear();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        TextView textView = this.textView.get();
        if (textView != null) {
            e(valueAnimator, textView);
        } else {
            a();
        }
    }

    @Override // android.text.style.SuperscriptSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        b(textPaint.ascent());
        textPaint.baselineShift = this.shift;
    }

    @Override // android.text.style.SuperscriptSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        b(textPaint.ascent());
        textPaint.baselineShift = this.shift;
    }
}
