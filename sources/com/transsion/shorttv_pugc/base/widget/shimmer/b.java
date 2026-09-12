package com.transsion.shorttv_pugc.base.widget.shimmer;

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

/* loaded from: classes6.dex */
public final class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f53990a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final Paint f53991b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f53992c;

    /* renamed from: d, reason: collision with root package name */
    private final Matrix f53993d;

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f53994e;

    /* renamed from: f, reason: collision with root package name */
    private com.transsion.shorttv_pugc.base.widget.shimmer.a f53995f;

    /* loaded from: classes6.dex */
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
        this.f53991b = paint;
        this.f53992c = new Rect();
        this.f53993d = new Matrix();
        paint.setAntiAlias(true);
    }

    private float c(float f11, float f12, float f13) {
        return f11 + ((f12 - f11) * f13);
    }

    private void i() {
        com.transsion.shorttv_pugc.base.widget.shimmer.a aVar;
        Shader radialGradient;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width == 0 || height == 0 || (aVar = this.f53995f) == null) {
            return;
        }
        int d11 = aVar.d(width);
        int a11 = this.f53995f.a(height);
        com.transsion.shorttv_pugc.base.widget.shimmer.a aVar2 = this.f53995f;
        boolean z10 = true;
        if (aVar2.f53974g != 1) {
            int i11 = aVar2.f53971d;
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
            com.transsion.shorttv_pugc.base.widget.shimmer.a aVar3 = this.f53995f;
            radialGradient = new LinearGradient(0.0f, 0.0f, d11, f11, aVar3.f53969b, aVar3.f53968a, Shader.TileMode.CLAMP);
        } else {
            float f12 = a11 / 2.0f;
            float max = (float) (Math.max(d11, a11) / Math.sqrt(2.0d));
            com.transsion.shorttv_pugc.base.widget.shimmer.a aVar4 = this.f53995f;
            radialGradient = new RadialGradient(d11 / 2.0f, f12, max, aVar4.f53969b, aVar4.f53968a, Shader.TileMode.CLAMP);
        }
        this.f53991b.setShader(radialGradient);
    }

    private void j() {
        boolean z10;
        if (this.f53995f == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f53994e;
        if (valueAnimator != null) {
            z10 = valueAnimator.isStarted();
            this.f53994e.cancel();
            this.f53994e.removeAllUpdateListeners();
        } else {
            z10 = false;
        }
        com.transsion.shorttv_pugc.base.widget.shimmer.a aVar = this.f53995f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ((float) (aVar.f53988u / aVar.f53987t)) + 1.0f);
        this.f53994e = ofFloat;
        ofFloat.setRepeatMode(this.f53995f.f53986s);
        this.f53994e.setRepeatCount(this.f53995f.f53985r);
        ValueAnimator valueAnimator2 = this.f53994e;
        com.transsion.shorttv_pugc.base.widget.shimmer.a aVar2 = this.f53995f;
        valueAnimator2.setDuration(aVar2.f53987t + aVar2.f53988u);
        this.f53994e.addUpdateListener(this.f53990a);
        if (z10) {
            this.f53994e.start();
        }
    }

    public boolean a() {
        ValueAnimator valueAnimator = this.f53994e;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        com.transsion.shorttv_pugc.base.widget.shimmer.a aVar;
        ValueAnimator valueAnimator = this.f53994e;
        if (valueAnimator == null || valueAnimator.isStarted() || (aVar = this.f53995f) == null || !aVar.f53983p || getCallback() == null) {
            return;
        }
        this.f53994e.start();
    }

    public void d(com.transsion.shorttv_pugc.base.widget.shimmer.a aVar) {
        this.f53995f = aVar;
        if (aVar != null) {
            this.f53991b.setXfermode(new PorterDuffXfermode(this.f53995f.f53984q ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        i();
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float c11;
        float c12;
        if (this.f53995f == null || this.f53991b.getShader() == null) {
            return;
        }
        float tan = (float) Math.tan(Math.toRadians(this.f53995f.f53981n));
        float height = this.f53992c.height() + (this.f53992c.width() * tan);
        float width = this.f53992c.width() + (tan * this.f53992c.height());
        ValueAnimator valueAnimator = this.f53994e;
        float f11 = 0.0f;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i11 = this.f53995f.f53971d;
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
        this.f53993d.reset();
        this.f53993d.setRotate(this.f53995f.f53981n, this.f53992c.width() / 2.0f, this.f53992c.height() / 2.0f);
        this.f53993d.postTranslate(f11, c11);
        this.f53991b.getShader().setLocalMatrix(this.f53993d);
        canvas.drawRect(this.f53992c, this.f53991b);
    }

    public void e(Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimator = this.f53994e;
        if (valueAnimator != null) {
            ArrayList<Animator.AnimatorListener> listeners = valueAnimator.getListeners();
            if (listeners != null && listeners.size() > 0) {
                listeners.clear();
            }
            this.f53994e.addListener(animatorListener);
        }
    }

    public void f() {
        if (this.f53994e == null || a() || getCallback() == null) {
            return;
        }
        this.f53994e.start();
    }

    public void g(int i11, AnimatorListenerAdapter animatorListenerAdapter) {
        com.transsion.shorttv_pugc.base.widget.shimmer.a aVar;
        if (a() || getCallback() == null || (aVar = this.f53995f) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f53994e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        } else {
            this.f53994e = ValueAnimator.ofFloat(0.0f, ((float) (aVar.f53988u / aVar.f53987t)) + 1.0f);
        }
        this.f53994e.setRepeatMode(this.f53995f.f53986s);
        this.f53994e.setRepeatCount(i11);
        ValueAnimator valueAnimator2 = this.f53994e;
        com.transsion.shorttv_pugc.base.widget.shimmer.a aVar2 = this.f53995f;
        valueAnimator2.setDuration(aVar2.f53987t + aVar2.f53988u);
        this.f53994e.addUpdateListener(this.f53990a);
        if (animatorListenerAdapter != null) {
            this.f53994e.addListener(animatorListenerAdapter);
        }
        this.f53994e.start();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        com.transsion.shorttv_pugc.base.widget.shimmer.a aVar = this.f53995f;
        return (aVar == null || !(aVar.f53982o || aVar.f53984q)) ? -1 : -3;
    }

    public void h() {
        if (this.f53994e == null || !a()) {
            return;
        }
        this.f53994e.end();
        this.f53994e.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f53992c.set(0, 0, rect.width(), rect.height());
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
