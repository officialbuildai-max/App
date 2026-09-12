package com.to.aboomy.pager2banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public class IndicatorView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    private final Interpolator f41785a;

    /* renamed from: b, reason: collision with root package name */
    private Interpolator f41786b;

    /* renamed from: c, reason: collision with root package name */
    private Path f41787c;

    /* renamed from: d, reason: collision with root package name */
    private float f41788d;

    /* renamed from: e, reason: collision with root package name */
    private int f41789e;

    /* renamed from: f, reason: collision with root package name */
    private int f41790f;

    /* renamed from: g, reason: collision with root package name */
    private int f41791g;

    /* renamed from: h, reason: collision with root package name */
    private int f41792h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f41793i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f41794j;

    /* renamed from: k, reason: collision with root package name */
    private RelativeLayout.LayoutParams f41795k;

    /* renamed from: l, reason: collision with root package name */
    private int f41796l;

    /* renamed from: m, reason: collision with root package name */
    private float f41797m;

    /* renamed from: n, reason: collision with root package name */
    private float f41798n;

    /* renamed from: o, reason: collision with root package name */
    private float f41799o;

    /* renamed from: p, reason: collision with root package name */
    private float f41800p;

    /* renamed from: q, reason: collision with root package name */
    private float f41801q;

    public IndicatorView(Context context) {
        this(context, null);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41785a = new DecelerateInterpolator();
        this.f41791g = -7829368;
        this.f41792h = -1;
        this.f41797m = a(3.5f);
        this.f41798n = 1.0f;
        this.f41799o = a(3.5f);
        this.f41800p = 1.0f;
        this.f41801q = a(10.0f);
        this.f41794j = new RectF();
        this.f41793i = new Paint(1);
    }

    private int a(float f11) {
        return (int) (f11 * getContext().getResources().getDisplayMetrics().density);
    }

    private void b(Canvas canvas, float f11) {
        g(canvas, f11);
        if (this.f41787c == null) {
            this.f41787c = new Path();
        }
        if (this.f41786b == null) {
            this.f41786b = new AccelerateInterpolator();
        }
        float h11 = h(this.f41789e);
        float h12 = h((this.f41789e + 1) % this.f41790f) - h11;
        float interpolation = (this.f41786b.getInterpolation(this.f41788d) * h12) + h11;
        float i11 = h11 + (h12 * i());
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f12 = this.f41799o * 0.57f;
        float f13 = this.f41800p * f12;
        float i12 = ((f13 - ratioSelectedRadius) * i()) + ratioSelectedRadius;
        float interpolation2 = f13 + ((ratioSelectedRadius - f13) * this.f41786b.getInterpolation(this.f41788d));
        float i13 = (this.f41799o - f12) * i();
        float interpolation3 = (this.f41799o - f12) * this.f41786b.getInterpolation(this.f41788d);
        this.f41793i.setColor(this.f41792h);
        float f14 = this.f41799o;
        this.f41794j.set(interpolation - i12, (f11 - f14) + i13, interpolation + i12, (f14 + f11) - i13);
        canvas.drawRoundRect(this.f41794j, i12, i12, this.f41793i);
        float f15 = (f11 - f12) - interpolation3;
        float f16 = f12 + f11 + interpolation3;
        this.f41794j.set(i11 - interpolation2, f15, i11 + interpolation2, f16);
        canvas.drawRoundRect(this.f41794j, interpolation2, interpolation2, this.f41793i);
        this.f41787c.reset();
        this.f41787c.moveTo(i11, f11);
        this.f41787c.lineTo(i11, f15);
        float f17 = ((interpolation - i11) / 2.0f) + i11;
        this.f41787c.quadTo(f17, f11, interpolation, (f11 - this.f41799o) + i13);
        this.f41787c.lineTo(interpolation, (this.f41799o + f11) - i13);
        this.f41787c.quadTo(f17, f11, i11, f16);
        this.f41787c.close();
        canvas.drawPath(this.f41787c, this.f41793i);
    }

    private void c(Canvas canvas, float f11) {
        g(canvas, f11);
        float i11 = i();
        float h11 = h(this.f41789e);
        float h12 = h((this.f41789e + 1) % this.f41790f);
        float ratioRadius = getRatioRadius();
        float f12 = this.f41799o;
        float f13 = this.f41800p * f12;
        float f14 = (f13 - ratioRadius) * i11;
        float f15 = f13 - f14;
        float f16 = ratioRadius + f14;
        float f17 = (f12 - this.f41797m) * i11;
        this.f41793i.setColor(this.f41792h);
        if (i11 < 0.99f) {
            RectF rectF = this.f41794j;
            rectF.set(h11 - f15, (f11 - f12) + f17, h11 + f15, (f12 + f11) - f17);
            canvas.drawRoundRect(this.f41794j, f15, f15, this.f41793i);
        }
        if (i11 > 0.1f) {
            float f18 = this.f41797m;
            float f19 = f11 + f18 + f17;
            RectF rectF2 = this.f41794j;
            rectF2.set(h12 - f16, (f11 - f18) - f17, h12 + f16, f19);
            canvas.drawRoundRect(this.f41794j, f16, f16, this.f41793i);
        }
    }

    private void d(Canvas canvas, float f11) {
        g(canvas, f11);
        float h11 = h(this.f41789e);
        float h12 = h((this.f41789e + 1) % this.f41790f);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f12 = h11 - ratioSelectedRadius;
        float f13 = h11 + ratioSelectedRadius;
        float f14 = h12 - ratioSelectedRadius;
        float i11 = f12 + ((f14 - f12) * i());
        float i12 = f13 + (((h12 + ratioSelectedRadius) - f13) * i());
        RectF rectF = this.f41794j;
        float f15 = this.f41799o;
        rectF.set(i11, f11 - f15, i12, f11 + f15);
        this.f41793i.setColor(this.f41792h);
        RectF rectF2 = this.f41794j;
        float f16 = this.f41799o;
        canvas.drawRoundRect(rectF2, f16, f16, this.f41793i);
    }

    private void e(Canvas canvas, float f11) {
        float max;
        float min;
        g(canvas, f11);
        float h11 = h(this.f41789e);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f12 = h11 - ratioSelectedRadius;
        float f13 = h11 + ratioSelectedRadius;
        float i11 = i();
        float max2 = this.f41801q + (Math.max(getRatioRadius(), ratioSelectedRadius) * 2.0f);
        if ((this.f41789e + 1) % this.f41790f == 0) {
            float f14 = max2 * (-r1);
            max = f12 + Math.max(f14 * i11 * 2.0f, f14);
            min = Math.min(f14 * (i11 - 0.5f) * 2.0f, 0.0f);
        } else {
            max = f12 + Math.max((i11 - 0.5f) * max2 * 2.0f, 0.0f);
            min = Math.min(i11 * max2 * 2.0f, max2);
        }
        float f15 = f13 + min;
        RectF rectF = this.f41794j;
        float f16 = this.f41799o;
        rectF.set(max, f11 - f16, f15, f11 + f16);
        this.f41793i.setColor(this.f41792h);
        RectF rectF2 = this.f41794j;
        float f17 = this.f41799o;
        canvas.drawRoundRect(rectF2, f17, f17, this.f41793i);
    }

    private void f(Canvas canvas, float f11) {
        float i11 = i();
        float ratioSelectedRadius = getRatioSelectedRadius();
        float ratioRadius = getRatioRadius();
        float f12 = ratioSelectedRadius - ratioRadius;
        float f13 = f12 * i11;
        int i12 = (this.f41789e + 1) % this.f41790f;
        boolean z10 = i12 == 0;
        this.f41793i.setColor(this.f41791g);
        for (int i13 = 0; i13 < this.f41790f; i13++) {
            float h11 = h(i13);
            if (z10) {
                h11 += f13;
            }
            float f14 = h11 - ratioRadius;
            float f15 = this.f41797m;
            float f16 = f11 - f15;
            float f17 = h11 + ratioRadius;
            float f18 = f11 + f15;
            if (this.f41789e + 1 <= i13) {
                this.f41794j.set(f14 + f12, f16, f17 + f12, f18);
            } else {
                this.f41794j.set(f14, f16, f17, f18);
            }
            RectF rectF = this.f41794j;
            float f19 = this.f41797m;
            canvas.drawRoundRect(rectF, f19, f19, this.f41793i);
        }
        this.f41793i.setColor(this.f41792h);
        if (i11 < 0.99f) {
            float h12 = h(this.f41789e) - ratioSelectedRadius;
            if (z10) {
                h12 += f13;
            }
            RectF rectF2 = this.f41794j;
            float f20 = this.f41799o;
            rectF2.set(h12, f11 - f20, (((ratioSelectedRadius * 2.0f) + h12) + f12) - f13, f11 + f20);
            RectF rectF3 = this.f41794j;
            float f21 = this.f41799o;
            canvas.drawRoundRect(rectF3, f21, f21, this.f41793i);
        }
        if (i11 > 0.1f) {
            float h13 = h(i12) + ratioSelectedRadius;
            if (z10) {
                f12 = f13;
            }
            float f22 = h13 + f12;
            RectF rectF4 = this.f41794j;
            float f23 = this.f41799o;
            rectF4.set((f22 - (ratioSelectedRadius * 2.0f)) - f13, f11 - f23, f22, f11 + f23);
            RectF rectF5 = this.f41794j;
            float f24 = this.f41799o;
            canvas.drawRoundRect(rectF5, f24, f24, this.f41793i);
        }
    }

    private void g(Canvas canvas, float f11) {
        this.f41793i.setColor(this.f41791g);
        for (int i11 = 0; i11 < this.f41790f; i11++) {
            float h11 = h(i11);
            float ratioRadius = getRatioRadius();
            float f12 = this.f41797m;
            this.f41794j.set(h11 - ratioRadius, f11 - f12, h11 + ratioRadius, f12 + f11);
            RectF rectF = this.f41794j;
            float f13 = this.f41797m;
            canvas.drawRoundRect(rectF, f13, f13, this.f41793i);
        }
    }

    private float getRatioRadius() {
        return this.f41797m * this.f41798n;
    }

    private float getRatioSelectedRadius() {
        return this.f41799o * this.f41800p;
    }

    private float h(int i11) {
        float ratioRadius = getRatioRadius();
        float max = Math.max(ratioRadius, getRatioSelectedRadius());
        return getPaddingLeft() + max + (((max * 2.0f) + this.f41801q) * i11) + (this.f41796l == 3 ? 0.0f : (max - ratioRadius) / 2.0f);
    }

    private float i() {
        return this.f41785a.getInterpolation(this.f41788d);
    }

    private int j(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (int) ((Math.max(getRatioSelectedRadius(), getRatioRadius()) * 2.0f) + getPaddingTop() + getPaddingBottom());
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int k(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (mode != 1073741824) {
                return 0;
            }
            return size;
        }
        float ratioSelectedRadius = getRatioSelectedRadius();
        float ratioRadius = getRatioRadius();
        return (int) ((Math.max(ratioSelectedRadius, ratioRadius) * 2.0f * this.f41790f) + ((r2 - 1) * this.f41801q) + (ratioSelectedRadius - ratioRadius) + getPaddingLeft() + getPaddingRight());
    }

    @Override // com.to.aboomy.pager2banner.a
    public RelativeLayout.LayoutParams getParams() {
        if (this.f41795k == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            this.f41795k = layoutParams;
            layoutParams.addRule(12);
            this.f41795k.addRule(14);
            this.f41795k.bottomMargin = a(10.0f);
        }
        return this.f41795k;
    }

    @Override // com.to.aboomy.pager2banner.a
    public View getView() {
        return this;
    }

    @Override // com.to.aboomy.pager2banner.a
    public void initIndicatorCount(int i11, int i12) {
        this.f41790f = i11;
        setVisibility(i11 > 1 ? 0 : 8);
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f41790f == 0) {
            return;
        }
        float height = (getHeight() / 2.0f) + 0.5f;
        int i11 = this.f41796l;
        if (i11 == 0) {
            d(canvas, height);
            return;
        }
        if (i11 == 1) {
            e(canvas, height);
            return;
        }
        if (i11 == 2) {
            b(canvas, height);
        } else if (i11 == 3) {
            f(canvas, height);
        } else if (i11 == 4) {
            c(canvas, height);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        setMeasuredDimension(k(i11), j(i12));
    }

    @Override // com.to.aboomy.pager2banner.a
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // com.to.aboomy.pager2banner.a
    public void onPageScrolled(int i11, float f11, int i12) {
        this.f41789e = i11;
        this.f41788d = f11;
        invalidate();
    }

    @Override // com.to.aboomy.pager2banner.a
    public void onPageSelected(int i11) {
    }

    public IndicatorView setIndicatorColor(int i11) {
        this.f41791g = i11;
        return this;
    }

    public IndicatorView setIndicatorRadius(float f11) {
        int a11 = a(f11);
        if (this.f41797m == this.f41799o) {
            this.f41799o = a11;
        }
        this.f41797m = a11;
        return this;
    }

    public IndicatorView setIndicatorRatio(float f11) {
        if (this.f41798n == this.f41800p) {
            this.f41800p = f11;
        }
        this.f41798n = f11;
        return this;
    }

    public IndicatorView setIndicatorSelectedRadius(float f11) {
        this.f41799o = a(f11);
        return this;
    }

    public IndicatorView setIndicatorSelectedRatio(float f11) {
        this.f41800p = f11;
        return this;
    }

    public IndicatorView setIndicatorSelectorColor(int i11) {
        this.f41792h = i11;
        return this;
    }

    public IndicatorView setIndicatorSpacing(float f11) {
        this.f41801q = a(f11);
        return this;
    }

    public IndicatorView setIndicatorStyle(int i11) {
        this.f41796l = i11;
        return this;
    }

    public IndicatorView setParams(RelativeLayout.LayoutParams layoutParams) {
        this.f41795k = layoutParams;
        return this;
    }
}
