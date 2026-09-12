package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import i00.a;
import i00.b;
import j00.c;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class LinePagerIndicator extends View implements c {
    public static final int MODE_EXACTLY = 2;
    public static final int MODE_MATCH_EDGE = 0;
    public static final int MODE_WRAP_CONTENT = 1;

    /* renamed from: a, reason: collision with root package name */
    private int f70497a;

    /* renamed from: b, reason: collision with root package name */
    private Interpolator f70498b;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f70499c;

    /* renamed from: d, reason: collision with root package name */
    private float f70500d;

    /* renamed from: e, reason: collision with root package name */
    private float f70501e;

    /* renamed from: f, reason: collision with root package name */
    private float f70502f;

    /* renamed from: g, reason: collision with root package name */
    private float f70503g;

    /* renamed from: h, reason: collision with root package name */
    private float f70504h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f70505i;

    /* renamed from: j, reason: collision with root package name */
    private List f70506j;

    /* renamed from: k, reason: collision with root package name */
    private List f70507k;

    /* renamed from: l, reason: collision with root package name */
    private RectF f70508l;

    public LinePagerIndicator(Context context) {
        super(context);
        this.f70498b = new LinearInterpolator();
        this.f70499c = new LinearInterpolator();
        this.f70508l = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f70505i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f70501e = b.a(context, 3.0d);
        this.f70503g = b.a(context, 10.0d);
    }

    public List<Integer> getColors() {
        return this.f70507k;
    }

    public Interpolator getEndInterpolator() {
        return this.f70499c;
    }

    public float getLineHeight() {
        return this.f70501e;
    }

    public float getLineWidth() {
        return this.f70503g;
    }

    public int getMode() {
        return this.f70497a;
    }

    public Paint getPaint() {
        return this.f70505i;
    }

    public float getRoundRadius() {
        return this.f70504h;
    }

    public Interpolator getStartInterpolator() {
        return this.f70498b;
    }

    public float getXOffset() {
        return this.f70502f;
    }

    public float getYOffset() {
        return this.f70500d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f70508l;
        float f11 = this.f70504h;
        canvas.drawRoundRect(rectF, f11, f11, this.f70505i);
    }

    @Override // j00.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // j00.c
    public void onPageScrolled(int i11, float f11, int i12) {
        float b11;
        float b12;
        float b13;
        float f12;
        float f13;
        int i13;
        List list = this.f70506j;
        if (list == null || list.isEmpty()) {
            return;
        }
        List list2 = this.f70507k;
        if (list2 != null && list2.size() > 0) {
            this.f70505i.setColor(a.a(f11, ((Integer) this.f70507k.get(Math.abs(i11) % this.f70507k.size())).intValue(), ((Integer) this.f70507k.get(Math.abs(i11 + 1) % this.f70507k.size())).intValue()));
        }
        k00.a f14 = g00.a.f(this.f70506j, i11);
        k00.a f15 = g00.a.f(this.f70506j, i11 + 1);
        int i14 = this.f70497a;
        if (i14 == 0) {
            float f16 = f14.f66678a;
            f13 = this.f70502f;
            b11 = f16 + f13;
            f12 = f15.f66678a + f13;
            b12 = f14.f66680c - f13;
            i13 = f15.f66680c;
        } else {
            if (i14 != 1) {
                b11 = f14.f66678a + ((f14.b() - this.f70503g) / 2.0f);
                float b14 = f15.f66678a + ((f15.b() - this.f70503g) / 2.0f);
                b12 = ((f14.b() + this.f70503g) / 2.0f) + f14.f66678a;
                b13 = ((f15.b() + this.f70503g) / 2.0f) + f15.f66678a;
                f12 = b14;
                this.f70508l.left = b11 + ((f12 - b11) * this.f70498b.getInterpolation(f11));
                this.f70508l.right = b12 + ((b13 - b12) * this.f70499c.getInterpolation(f11));
                this.f70508l.top = (getHeight() - this.f70501e) - this.f70500d;
                this.f70508l.bottom = getHeight() - this.f70500d;
                invalidate();
            }
            float f17 = f14.f66682e;
            f13 = this.f70502f;
            b11 = f17 + f13;
            f12 = f15.f66682e + f13;
            b12 = f14.f66684g - f13;
            i13 = f15.f66684g;
        }
        b13 = i13 - f13;
        this.f70508l.left = b11 + ((f12 - b11) * this.f70498b.getInterpolation(f11));
        this.f70508l.right = b12 + ((b13 - b12) * this.f70499c.getInterpolation(f11));
        this.f70508l.top = (getHeight() - this.f70501e) - this.f70500d;
        this.f70508l.bottom = getHeight() - this.f70500d;
        invalidate();
    }

    @Override // j00.c
    public void onPageSelected(int i11) {
    }

    @Override // j00.c
    public void onPositionDataProvide(List<k00.a> list) {
        this.f70506j = list;
    }

    public void setColors(Integer... numArr) {
        this.f70507k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f70499c = interpolator;
        if (interpolator == null) {
            this.f70499c = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f11) {
        this.f70501e = f11;
    }

    public void setLineWidth(float f11) {
        this.f70503g = f11;
    }

    public void setMode(int i11) {
        if (i11 == 2 || i11 == 0 || i11 == 1) {
            this.f70497a = i11;
            return;
        }
        throw new IllegalArgumentException("mode " + i11 + " not supported.");
    }

    public void setRoundRadius(float f11) {
        this.f70504h = f11;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f70498b = interpolator;
        if (interpolator == null) {
            this.f70498b = new LinearInterpolator();
        }
    }

    public void setXOffset(float f11) {
        this.f70502f = f11;
    }

    public void setYOffset(float f11) {
        this.f70500d = f11;
    }
}
