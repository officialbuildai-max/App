package com.cloud.tmc.miniapp.widget.pulldownrefresh.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class OooO extends OooO0o implements Animatable, ValueAnimator.AnimatorUpdateListener {
    public int OooO0O0 = 0;
    public int OooO0OO = 0;
    public int OooO0Oo = 0;
    public Path OooO0o = new Path();
    public ValueAnimator OooO0o0;

    public OooO() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, 3600);
        this.OooO0o0 = ofInt;
        ofInt.setDuration(10000L);
        this.OooO0o0.setInterpolator(null);
        this.OooO0o0.setRepeatCount(-1);
        this.OooO0o0.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float f11 = width;
        float max = Math.max(1.0f, f11 / 22.0f);
        if (this.OooO0O0 != width || this.OooO0OO != height) {
            this.OooO0o.reset();
            Path path = this.OooO0o;
            float f12 = f11 - max;
            float f13 = height / 2.0f;
            Path.Direction direction = Path.Direction.CW;
            path.addCircle(f12, f13, max, direction);
            float f14 = f11 - (5.0f * max);
            this.OooO0o.addRect(f14, f13 - max, f12, f13 + max, direction);
            this.OooO0o.addCircle(f14, f13, max, direction);
            this.OooO0O0 = width;
            this.OooO0OO = height;
        }
        canvas.save();
        float f15 = f11 / 2.0f;
        float f16 = height / 2.0f;
        canvas.rotate(this.OooO0Oo, f15, f16);
        for (int i11 = 0; i11 < 12; i11++) {
            this.OooO00o.setAlpha((i11 + 5) * 17);
            canvas.rotate(30.0f, f15, f16);
            canvas.drawPath(this.OooO0o, this.OooO00o);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.OooO0o0.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.OooO0Oo = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.OooO0o0.isRunning()) {
            return;
        }
        this.OooO0o0.addUpdateListener(this);
        this.OooO0o0.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.OooO0o0.isRunning()) {
            this.OooO0o0.removeAllListeners();
            this.OooO0o0.removeAllUpdateListeners();
            this.OooO0o0.cancel();
        }
    }
}
