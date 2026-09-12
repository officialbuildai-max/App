package com.transsion.baseui.widget.shimmer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f43766a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final Paint f43767b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f43768c;

    /* renamed from: d, reason: collision with root package name */
    private final Matrix f43769d;

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f43770e;

    /* renamed from: f, reason: collision with root package name */
    private com.transsion.baseui.widget.shimmer.a f43771f;

    /* loaded from: classes5.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.invalidateSelf();
        }
    }

    public b() {
        Paint paint = new Paint();
        this.f43767b = paint;
        this.f43768c = new Rect();
        this.f43769d = new Matrix();
        paint.setAntiAlias(true);
    }

    private float c(float f11, float f12, float f13) {
        return f11 + ((f12 - f11) * f13);
    }

    private void i() {
        com.transsion.baseui.widget.shimmer.a aVar;
        Shader radialGradient;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width == 0 || height == 0 || (aVar = this.f43771f) == null) {
            return;
        }
        int d11 = aVar.d(width);
        int a11 = this.f43771f.a(height);
        com.transsion.baseui.widget.shimmer.a aVar2 = this.f43771f;
        boolean z10 = true;
        if (aVar2.f43750g != 1) {
            int i11 = aVar2.f43747d;
            if (i11 != 1 && i11 != 3) {
                z10 = false;
            }
            if (z10) {
                d11 = 0;
            }
            if (!z10) {
                a11 = 0;
            }
            float f11 = a11;
            com.transsion.baseui.widget.shimmer.a aVar3 = this.f43771f;
            radialGradient = new LinearGradient(0.0f, 0.0f, d11, f11, aVar3.f43745b, aVar3.f43744a, Shader.TileMode.CLAMP);
        } else {
            float f12 = a11 / 2.0f;
            float max = (float) (Math.max(d11, a11) / Math.sqrt(2.0d));
            com.transsion.baseui.widget.shimmer.a aVar4 = this.f43771f;
            radialGradient = new RadialGradient(d11 / 2.0f, f12, max, aVar4.f43745b, aVar4.f43744a, Shader.TileMode.CLAMP);
        }
        this.f43767b.setShader(radialGradient);
    }

    private void j() {
        boolean z10;
        if (this.f43771f == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f43770e;
        if (valueAnimator != null) {
            z10 = valueAnimator.isStarted();
            this.f43770e.cancel();
            this.f43770e.removeAllUpdateListeners();
        } else {
            z10 = false;
        }
        com.transsion.baseui.widget.shimmer.a aVar = this.f43771f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ((float) (aVar.f43764u / aVar.f43763t)) + 1.0f);
        this.f43770e = ofFloat;
        ofFloat.setRepeatMode(this.f43771f.f43762s);
        this.f43770e.setRepeatCount(this.f43771f.f43761r);
        ValueAnimator valueAnimator2 = this.f43770e;
        com.transsion.baseui.widget.shimmer.a aVar2 = this.f43771f;
        valueAnimator2.setDuration(aVar2.f43763t + aVar2.f43764u);
        this.f43770e.addUpdateListener(this.f43766a);
        if (z10) {
            this.f43770e.start();
        }
    }

    public boolean a() {
        ValueAnimator valueAnimator = this.f43770e;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        com.transsion.baseui.widget.shimmer.a aVar;
        ValueAnimator valueAnimator = this.f43770e;
        if (valueAnimator == null || valueAnimator.isStarted() || (aVar = this.f43771f) == null || !aVar.f43759p || getCallback() == null) {
            return;
        }
        this.f43770e.start();
    }

    public void d(com.transsion.baseui.widget.shimmer.a aVar) {
        this.f43771f = aVar;
        if (aVar != null) {
            this.f43767b.setXfermode(new PorterDuffXfermode(this.f43771f.f43760q ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        i();
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float c11;
        float c12;
        if (this.f43771f == null || this.f43767b.getShader() == null) {
            return;
        }
        float tan = (float) Math.tan(Math.toRadians(this.f43771f.f43757n));
        float height = this.f43768c.height() + (this.f43768c.width() * tan);
        float width = this.f43768c.width() + (tan * this.f43768c.height());
        ValueAnimator valueAnimator = this.f43770e;
        float f11 = 0.0f;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i11 = this.f43771f.f43747d;
        if (i11 != 1) {
            if (i11 == 2) {
                c12 = c(width, -width, animatedFraction);
            } else if (i11 != 3) {
                c12 = c(-width, width, animatedFraction);
            } else {
                c11 = c(height, -height, animatedFraction);
            }
            f11 = c12;
            c11 = 0.0f;
        } else {
            c11 = c(-height, height, animatedFraction);
        }
        this.f43769d.reset();
        this.f43769d.setRotate(this.f43771f.f43757n, this.f43768c.width() / 2.0f, this.f43768c.height() / 2.0f);
        this.f43769d.postTranslate(f11, c11);
        this.f43767b.getShader().setLocalMatrix(this.f43769d);
        canvas.drawRect(this.f43768c, this.f43767b);
    }

    public void e(Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimator = this.f43770e;
        if (valueAnimator != null) {
            ArrayList<Animator.AnimatorListener> listeners = valueAnimator.getListeners();
            if (listeners != null && listeners.size() > 0) {
                listeners.clear();
            }
            this.f43770e.addListener(animatorListener);
        }
    }

    public void f() {
        if (this.f43770e == null || a() || getCallback() == null) {
            return;
        }
        this.f43770e.start();
    }

    public void g(int i11, AnimatorListenerAdapter animatorListenerAdapter) {
        com.transsion.baseui.widget.shimmer.a aVar;
        if (a() || getCallback() == null || (aVar = this.f43771f) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f43770e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        } else {
            this.f43770e = ValueAnimator.ofFloat(0.0f, ((float) (aVar.f43764u / aVar.f43763t)) + 1.0f);
        }
        this.f43770e.setRepeatMode(this.f43771f.f43762s);
        this.f43770e.setRepeatCount(i11);
        ValueAnimator valueAnimator2 = this.f43770e;
        com.transsion.baseui.widget.shimmer.a aVar2 = this.f43771f;
        valueAnimator2.setDuration(aVar2.f43763t + aVar2.f43764u);
        this.f43770e.addUpdateListener(this.f43766a);
        if (animatorListenerAdapter != null) {
            this.f43770e.addListener(animatorListenerAdapter);
        }
        this.f43770e.start();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        com.transsion.baseui.widget.shimmer.a aVar = this.f43771f;
        return (aVar == null || !(aVar.f43758o || aVar.f43760q)) ? -1 : -3;
    }

    public void h() {
        if (this.f43770e == null || !a()) {
            return;
        }
        this.f43770e.end();
        this.f43770e.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f43768c.set(0, 0, rect.width(), rect.height());
        i();
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
