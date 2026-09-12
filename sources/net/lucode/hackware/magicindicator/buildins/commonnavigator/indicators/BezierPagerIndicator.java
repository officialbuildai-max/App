package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import i00.a;
import i00.b;
import j00.c;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class BezierPagerIndicator extends View implements c {

    /* renamed from: a, reason: collision with root package name */
    private List f70484a;

    /* renamed from: b, reason: collision with root package name */
    private float f70485b;

    /* renamed from: c, reason: collision with root package name */
    private float f70486c;

    /* renamed from: d, reason: collision with root package name */
    private float f70487d;

    /* renamed from: e, reason: collision with root package name */
    private float f70488e;

    /* renamed from: f, reason: collision with root package name */
    private float f70489f;

    /* renamed from: g, reason: collision with root package name */
    private float f70490g;

    /* renamed from: h, reason: collision with root package name */
    private float f70491h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f70492i;

    /* renamed from: j, reason: collision with root package name */
    private Path f70493j;

    /* renamed from: k, reason: collision with root package name */
    private List f70494k;

    /* renamed from: l, reason: collision with root package name */
    private Interpolator f70495l;

    /* renamed from: m, reason: collision with root package name */
    private Interpolator f70496m;

    public BezierPagerIndicator(Context context) {
        super(context);
        this.f70493j = new Path();
        this.f70495l = new AccelerateInterpolator();
        this.f70496m = new DecelerateInterpolator();
        b(context);
    }

    private void a(Canvas canvas) {
        this.f70493j.reset();
        float height = (getHeight() - this.f70489f) - this.f70490g;
        this.f70493j.moveTo(this.f70488e, height);
        this.f70493j.lineTo(this.f70488e, height - this.f70487d);
        Path path = this.f70493j;
        float f11 = this.f70488e;
        float f12 = this.f70486c;
        path.quadTo(f11 + ((f12 - f11) / 2.0f), height, f12, height - this.f70485b);
        this.f70493j.lineTo(this.f70486c, this.f70485b + height);
        Path path2 = this.f70493j;
        float f13 = this.f70488e;
        path2.quadTo(((this.f70486c - f13) / 2.0f) + f13, height, f13, this.f70487d + height);
        this.f70493j.close();
        canvas.drawPath(this.f70493j, this.f70492i);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.f70492i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f70490g = b.a(context, 3.5d);
        this.f70491h = b.a(context, 2.0d);
        this.f70489f = b.a(context, 1.5d);
    }

    public float getMaxCircleRadius() {
        return this.f70490g;
    }

    public float getMinCircleRadius() {
        return this.f70491h;
    }

    public float getYOffset() {
        return this.f70489f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f70486c, (getHeight() - this.f70489f) - this.f70490g, this.f70485b, this.f70492i);
        canvas.drawCircle(this.f70488e, (getHeight() - this.f70489f) - this.f70490g, this.f70487d, this.f70492i);
        a(canvas);
    }

    @Override // j00.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // j00.c
    public void onPageScrolled(int i11, float f11, int i12) {
        List list = this.f70484a;
        if (list == null || list.isEmpty()) {
            return;
        }
        List list2 = this.f70494k;
        if (list2 != null && list2.size() > 0) {
            this.f70492i.setColor(a.a(f11, ((Integer) this.f70494k.get(Math.abs(i11) % this.f70494k.size())).intValue(), ((Integer) this.f70494k.get(Math.abs(i11 + 1) % this.f70494k.size())).intValue()));
        }
        k00.a f12 = g00.a.f(this.f70484a, i11);
        k00.a f13 = g00.a.f(this.f70484a, i11 + 1);
        int i13 = f12.f66678a;
        float f14 = i13 + ((f12.f66680c - i13) / 2);
        int i14 = f13.f66678a;
        float f15 = (i14 + ((f13.f66680c - i14) / 2)) - f14;
        this.f70486c = (this.f70495l.getInterpolation(f11) * f15) + f14;
        this.f70488e = f14 + (f15 * this.f70496m.getInterpolation(f11));
        float f16 = this.f70490g;
        this.f70485b = f16 + ((this.f70491h - f16) * this.f70496m.getInterpolation(f11));
        float f17 = this.f70491h;
        this.f70487d = f17 + ((this.f70490g - f17) * this.f70495l.getInterpolation(f11));
        invalidate();
    }

    @Override // j00.c
    public void onPageSelected(int i11) {
    }

    @Override // j00.c
    public void onPositionDataProvide(List<k00.a> list) {
        this.f70484a = list;
    }

    public void setColors(Integer... numArr) {
        this.f70494k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f70496m = interpolator;
        if (interpolator == null) {
            this.f70496m = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f11) {
        this.f70490g = f11;
    }

    public void setMinCircleRadius(float f11) {
        this.f70491h = f11;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f70495l = interpolator;
        if (interpolator == null) {
            this.f70495l = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f11) {
        this.f70489f = f11;
    }
}
