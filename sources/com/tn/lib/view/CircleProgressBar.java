package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class CircleProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f40955a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f40956b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f40957c;

    /* renamed from: d, reason: collision with root package name */
    private int f40958d;

    /* renamed from: e, reason: collision with root package name */
    private int f40959e;

    /* renamed from: f, reason: collision with root package name */
    private int f40960f;

    /* renamed from: g, reason: collision with root package name */
    private float f40961g;

    /* renamed from: h, reason: collision with root package name */
    private float f40962h;

    /* renamed from: i, reason: collision with root package name */
    private int f40963i;

    /* renamed from: j, reason: collision with root package name */
    private int f40964j;

    /* renamed from: k, reason: collision with root package name */
    private int f40965k;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40963i = 100;
        this.f40965k = 0;
        a(context, attributeSet);
        b();
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CircleProgressbar, 0, 0);
        this.f40961g = obtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_progressRadius, 80.0f);
        this.f40962h = obtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_progressStrokesWidth, 10.0f);
        this.f40958d = obtainStyledAttributes.getColor(R$styleable.CircleProgressbar_progressBgColor, 15658734);
        this.f40959e = obtainStyledAttributes.getColor(R$styleable.CircleProgressbar_progressRingsColor, 16734911);
        this.f40960f = obtainStyledAttributes.getColor(R$styleable.CircleProgressbar_progressTextsColor, 16777215);
        this.f40963i = obtainStyledAttributes.getInt(R$styleable.CircleProgressbar_progressMax, 100);
        this.f40964j = obtainStyledAttributes.getInt(R$styleable.CircleProgressbar_progressCurrent, 0);
    }

    private void b() {
        Paint paint = new Paint();
        this.f40955a = paint;
        paint.setAntiAlias(true);
        this.f40955a.setDither(true);
        this.f40955a.setColor(this.f40958d);
        Paint paint2 = this.f40955a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = this.f40955a;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        this.f40955a.setStrokeWidth(this.f40962h);
        Paint paint4 = new Paint();
        this.f40956b = paint4;
        paint4.setAntiAlias(true);
        this.f40956b.setDither(true);
        this.f40956b.setColor(this.f40959e);
        this.f40956b.setStyle(style);
        this.f40956b.setStrokeCap(cap);
        this.f40956b.setStrokeWidth(this.f40962h);
        Paint paint5 = new Paint();
        this.f40957c = paint5;
        paint5.setAntiAlias(true);
        this.f40957c.setStyle(Paint.Style.FILL);
        this.f40957c.setColor(this.f40960f);
        this.f40957c.setTextSize(this.f40961g / 2.0f);
        this.f40957c.getFontMetrics();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f40961g, this.f40955a);
        if (this.f40964j >= 0) {
            RectF rectF = new RectF((getWidth() / 2) - this.f40961g, (getHeight() / 2) - this.f40961g, (getWidth() / 2) + this.f40961g, (getHeight() / 2) + this.f40961g);
            canvas.drawArc(rectF, 0.0f, 0.0f, false, this.f40956b);
            canvas.drawArc(rectF, -90.0f, (this.f40964j / this.f40963i) * 360.0f, false, this.f40956b);
        }
    }

    public void setMax(int i11) {
        this.f40963i = i11;
        postInvalidate();
    }

    public void setProgress(int i11) {
        this.f40964j = i11;
        postInvalidate();
    }

    public void setRingColor(int i11) {
        this.f40959e = i11;
        this.f40956b.setColor(i11);
        postInvalidate();
    }
}
