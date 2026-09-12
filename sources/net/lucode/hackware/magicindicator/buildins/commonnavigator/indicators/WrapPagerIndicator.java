package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import i00.b;
import j00.c;
import java.util.List;
import k00.a;

/* loaded from: classes7.dex */
public class WrapPagerIndicator extends View implements c {

    /* renamed from: a, reason: collision with root package name */
    private int f70526a;

    /* renamed from: b, reason: collision with root package name */
    private int f70527b;

    /* renamed from: c, reason: collision with root package name */
    private int f70528c;

    /* renamed from: d, reason: collision with root package name */
    private float f70529d;

    /* renamed from: e, reason: collision with root package name */
    private Interpolator f70530e;

    /* renamed from: f, reason: collision with root package name */
    private Interpolator f70531f;

    /* renamed from: g, reason: collision with root package name */
    private List f70532g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f70533h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f70534i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f70535j;

    public WrapPagerIndicator(Context context) {
        super(context);
        this.f70530e = new LinearInterpolator();
        this.f70531f = new LinearInterpolator();
        this.f70534i = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f70533h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f70526a = b.a(context, 6.0d);
        this.f70527b = b.a(context, 10.0d);
    }

    public Interpolator getEndInterpolator() {
        return this.f70531f;
    }

    public int getFillColor() {
        return this.f70528c;
    }

    public int getHorizontalPadding() {
        return this.f70527b;
    }

    public Paint getPaint() {
        return this.f70533h;
    }

    public float getRoundRadius() {
        return this.f70529d;
    }

    public Interpolator getStartInterpolator() {
        return this.f70530e;
    }

    public int getVerticalPadding() {
        return this.f70526a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f70533h.setColor(this.f70528c);
        RectF rectF = this.f70534i;
        float f11 = this.f70529d;
        canvas.drawRoundRect(rectF, f11, f11, this.f70533h);
    }

    @Override // j00.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // j00.c
    public void onPageScrolled(int i11, float f11, int i12) {
        List list = this.f70532g;
        if (list == null || list.isEmpty()) {
            return;
        }
        a f12 = g00.a.f(this.f70532g, i11);
        a f13 = g00.a.f(this.f70532g, i11 + 1);
        RectF rectF = this.f70534i;
        int i13 = f12.f66682e;
        rectF.left = (i13 - this.f70527b) + ((f13.f66682e - i13) * this.f70531f.getInterpolation(f11));
        RectF rectF2 = this.f70534i;
        rectF2.top = f12.f66683f - this.f70526a;
        int i14 = f12.f66684g;
        rectF2.right = this.f70527b + i14 + ((f13.f66684g - i14) * this.f70530e.getInterpolation(f11));
        RectF rectF3 = this.f70534i;
        rectF3.bottom = f12.f66685h + this.f70526a;
        if (!this.f70535j) {
            this.f70529d = rectF3.height() / 2.0f;
        }
        invalidate();
    }

    @Override // j00.c
    public void onPageSelected(int i11) {
    }

    @Override // j00.c
    public void onPositionDataProvide(List<a> list) {
        this.f70532g = list;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f70531f = interpolator;
        if (interpolator == null) {
            this.f70531f = new LinearInterpolator();
        }
    }

    public void setFillColor(int i11) {
        this.f70528c = i11;
    }

    public void setHorizontalPadding(int i11) {
        this.f70527b = i11;
    }

    public void setRoundRadius(float f11) {
        this.f70529d = f11;
        this.f70535j = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f70530e = interpolator;
        if (interpolator == null) {
            this.f70530e = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i11) {
        this.f70526a = i11;
    }
}
