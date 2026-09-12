package com.transsion.publish.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.transsion.publish.R$styleable;

/* loaded from: classes6.dex */
public class CircleProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f50682a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f50683b;

    /* renamed from: c, reason: collision with root package name */
    private int f50684c;

    /* renamed from: d, reason: collision with root package name */
    private int f50685d;

    /* renamed from: e, reason: collision with root package name */
    private float f50686e;

    /* renamed from: f, reason: collision with root package name */
    private float f50687f;

    /* renamed from: g, reason: collision with root package name */
    private int f50688g;

    /* renamed from: h, reason: collision with root package name */
    private int f50689h;

    /* renamed from: i, reason: collision with root package name */
    private int f50690i;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50688g = 100;
        this.f50690i = 0;
        a(context, attributeSet);
        b();
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CircleProgressbar, 0, 0);
        this.f50686e = obtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_ra, 80.0f);
        this.f50687f = obtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_strokesWidth, 10.0f);
        this.f50684c = obtainStyledAttributes.getColor(R$styleable.CircleProgressbar_ringsColor, 16711680);
        this.f50685d = obtainStyledAttributes.getColor(R$styleable.CircleProgressbar_textsColor, 16777215);
    }

    private void b() {
        Paint paint = new Paint();
        this.f50682a = paint;
        paint.setAntiAlias(true);
        this.f50682a.setDither(true);
        this.f50682a.setColor(this.f50684c);
        this.f50682a.setStyle(Paint.Style.STROKE);
        this.f50682a.setStrokeCap(Paint.Cap.ROUND);
        this.f50682a.setStrokeWidth(this.f50687f);
        Paint paint2 = new Paint();
        this.f50683b = paint2;
        paint2.setAntiAlias(true);
        this.f50683b.setStyle(Paint.Style.FILL);
        this.f50683b.setColor(this.f50685d);
        this.f50683b.setTextSize(this.f50686e / 2.0f);
        this.f50683b.getFontMetrics();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f50689h >= 0) {
            RectF rectF = new RectF((getWidth() / 2) - this.f50686e, (getHeight() / 2) - this.f50686e, (getWidth() / 2) + this.f50686e, (getHeight() / 2) + this.f50686e);
            canvas.drawArc(rectF, 0.0f, 0.0f, false, this.f50682a);
            canvas.drawArc(rectF, -90.0f, (this.f50689h / this.f50688g) * 360.0f, false, this.f50682a);
        }
    }

    public void setProgress(int i11) {
        this.f50689h = i11;
        postInvalidate();
    }

    public void setRingColor(int i11) {
        this.f50684c = i11;
        this.f50682a.setColor(i11);
        postInvalidate();
    }
}
