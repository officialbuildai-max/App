package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import i00.b;
import j00.c;
import java.util.List;
import k00.a;

/* loaded from: classes7.dex */
public class TriangularPagerIndicator extends View implements c {

    /* renamed from: a, reason: collision with root package name */
    private List f70515a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f70516b;

    /* renamed from: c, reason: collision with root package name */
    private int f70517c;

    /* renamed from: d, reason: collision with root package name */
    private int f70518d;

    /* renamed from: e, reason: collision with root package name */
    private int f70519e;

    /* renamed from: f, reason: collision with root package name */
    private int f70520f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f70521g;

    /* renamed from: h, reason: collision with root package name */
    private float f70522h;

    /* renamed from: i, reason: collision with root package name */
    private Path f70523i;

    /* renamed from: j, reason: collision with root package name */
    private Interpolator f70524j;

    /* renamed from: k, reason: collision with root package name */
    private float f70525k;

    public TriangularPagerIndicator(Context context) {
        super(context);
        this.f70523i = new Path();
        this.f70524j = new LinearInterpolator();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f70516b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f70517c = b.a(context, 3.0d);
        this.f70520f = b.a(context, 14.0d);
        this.f70519e = b.a(context, 8.0d);
    }

    public int getLineColor() {
        return this.f70518d;
    }

    public int getLineHeight() {
        return this.f70517c;
    }

    public Interpolator getStartInterpolator() {
        return this.f70524j;
    }

    public int getTriangleHeight() {
        return this.f70519e;
    }

    public int getTriangleWidth() {
        return this.f70520f;
    }

    public float getYOffset() {
        return this.f70522h;
    }

    public boolean isReverse() {
        return this.f70521g;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f70516b.setColor(this.f70518d);
        if (this.f70521g) {
            canvas.drawRect(0.0f, (getHeight() - this.f70522h) - this.f70519e, getWidth(), ((getHeight() - this.f70522h) - this.f70519e) + this.f70517c, this.f70516b);
        } else {
            canvas.drawRect(0.0f, (getHeight() - this.f70517c) - this.f70522h, getWidth(), getHeight() - this.f70522h, this.f70516b);
        }
        this.f70523i.reset();
        if (this.f70521g) {
            this.f70523i.moveTo(this.f70525k - (this.f70520f / 2), (getHeight() - this.f70522h) - this.f70519e);
            this.f70523i.lineTo(this.f70525k, getHeight() - this.f70522h);
            this.f70523i.lineTo(this.f70525k + (this.f70520f / 2), (getHeight() - this.f70522h) - this.f70519e);
        } else {
            this.f70523i.moveTo(this.f70525k - (this.f70520f / 2), getHeight() - this.f70522h);
            this.f70523i.lineTo(this.f70525k, (getHeight() - this.f70519e) - this.f70522h);
            this.f70523i.lineTo(this.f70525k + (this.f70520f / 2), getHeight() - this.f70522h);
        }
        this.f70523i.close();
        canvas.drawPath(this.f70523i, this.f70516b);
    }

    @Override // j00.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // j00.c
    public void onPageScrolled(int i11, float f11, int i12) {
        List list = this.f70515a;
        if (list == null || list.isEmpty()) {
            return;
        }
        a f12 = g00.a.f(this.f70515a, i11);
        a f13 = g00.a.f(this.f70515a, i11 + 1);
        int i13 = f12.f66678a;
        float f14 = i13 + ((f12.f66680c - i13) / 2);
        int i14 = f13.f66678a;
        this.f70525k = f14 + (((i14 + ((f13.f66680c - i14) / 2)) - f14) * this.f70524j.getInterpolation(f11));
        invalidate();
    }

    @Override // j00.c
    public void onPageSelected(int i11) {
    }

    @Override // j00.c
    public void onPositionDataProvide(List<a> list) {
        this.f70515a = list;
    }

    public void setLineColor(int i11) {
        this.f70518d = i11;
    }

    public void setLineHeight(int i11) {
        this.f70517c = i11;
    }

    public void setReverse(boolean z10) {
        this.f70521g = z10;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f70524j = interpolator;
        if (interpolator == null) {
            this.f70524j = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i11) {
        this.f70519e = i11;
    }

    public void setTriangleWidth(int i11) {
        this.f70520f = i11;
    }

    public void setYOffset(float f11) {
        this.f70522h = f11;
    }
}
