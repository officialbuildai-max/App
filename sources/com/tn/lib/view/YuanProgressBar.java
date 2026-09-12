package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class YuanProgressBar extends AppCompatButton {

    /* renamed from: a, reason: collision with root package name */
    private Paint f41152a;

    /* renamed from: b, reason: collision with root package name */
    private float f41153b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f41154c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f41155d;

    /* renamed from: e, reason: collision with root package name */
    private int f41156e;

    /* renamed from: f, reason: collision with root package name */
    private int f41157f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f41158g;

    /* renamed from: h, reason: collision with root package name */
    private int f41159h;

    /* renamed from: i, reason: collision with root package name */
    private int f41160i;

    /* renamed from: j, reason: collision with root package name */
    private int f41161j;

    /* renamed from: k, reason: collision with root package name */
    private int f41162k;

    /* renamed from: l, reason: collision with root package name */
    private int f41163l;

    public YuanProgressBar(Context context) {
        super(context);
        this.f41156e = 100;
        this.f41157f = 0;
        this.f41160i = Color.parseColor("#99ffffff");
        this.f41161j = Color.parseColor(IntegrationConstants.NAVIGATION_BAR_BACKGROUND_COLOR_DEFAULT);
        this.f41162k = 0;
        this.f41163l = 0;
        init(context, null);
    }

    public YuanProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41156e = 100;
        this.f41157f = 0;
        this.f41160i = Color.parseColor("#99ffffff");
        this.f41161j = Color.parseColor(IntegrationConstants.NAVIGATION_BAR_BACKGROUND_COLOR_DEFAULT);
        this.f41162k = 0;
        this.f41163l = 0;
        init(context, attributeSet);
    }

    public YuanProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41156e = 100;
        this.f41157f = 0;
        this.f41160i = Color.parseColor("#99ffffff");
        this.f41161j = Color.parseColor(IntegrationConstants.NAVIGATION_BAR_BACKGROUND_COLOR_DEFAULT);
        this.f41162k = 0;
        this.f41163l = 0;
        init(context, attributeSet);
    }

    private void a(Canvas canvas) {
        Paint paint;
        canvas.save();
        if (this.f41159h == 0) {
            this.f41159h = oh.h.f71144a.a(getContext(), 1.0f);
        }
        int i11 = this.f41157f;
        if (i11 != 0 && (paint = this.f41158g) != null) {
            paint.setColor(i11);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (getWidth() / 2.0f) - this.f41159h, this.f41158g);
        }
        this.f41152a.setColor(this.f41160i);
        if (this.f41162k <= 0) {
            this.f41162k = this.f41159h;
        }
        this.f41152a.setStrokeWidth(this.f41162k);
        canvas.drawArc(this.f41154c, -90.0f, 360.0f, false, this.f41152a);
        this.f41152a.setColor(this.f41161j);
        if (this.f41163l <= 0) {
            this.f41163l = this.f41159h * 3;
        }
        this.f41152a.setStrokeWidth(this.f41163l);
        canvas.drawArc(this.f41154c, -90.0f, (this.f41153b * 360.0f) / this.f41156e, false, this.f41152a);
        canvas.restore();
    }

    private void init(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.f41152a = paint;
        paint.setAntiAlias(true);
        this.f41152a.setColor(Color.parseColor("#2f9ceb"));
        this.f41154c = new RectF();
        this.f41155d = new RectF();
        this.f41152a.setStyle(Paint.Style.STROKE);
        this.f41152a.setStrokeWidth(oh.h.f71144a.a(getContext(), 2.0f));
        this.f41152a.setStrokeCap(Paint.Cap.ROUND);
        setBackground(null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Base_YuanProgressBar);
            this.f41157f = obtainStyledAttributes.getColor(R$styleable.Base_YuanProgressBar_base_insideColor, 0);
            this.f41160i = obtainStyledAttributes.getColor(R$styleable.Base_YuanProgressBar_base_circleColor, this.f41160i);
            this.f41161j = obtainStyledAttributes.getColor(R$styleable.Base_YuanProgressBar_base_yuan_progressColor, this.f41161j);
            this.f41162k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Base_YuanProgressBar_base_yuanCircleStrokeWidth, this.f41162k);
            this.f41163l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Base_YuanProgressBar_base_yuanProgressStrokeWidth, this.f41163l);
            Paint paint2 = new Paint();
            this.f41158g = paint2;
            paint2.setAntiAlias(true);
            obtainStyledAttributes.recycle();
        }
        setTextSize(2, 12.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        a(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        RectF rectF = this.f41154c;
        oh.h hVar = oh.h.f71144a;
        rectF.left = hVar.a(getContext(), 2.0f);
        this.f41154c.top = hVar.a(getContext(), 2.0f);
        this.f41154c.right = i11 - hVar.a(getContext(), 2.0f);
        this.f41154c.bottom = i12 - hVar.a(getContext(), 2.0f);
        this.f41155d.left = hVar.a(getContext(), 4.0f);
        this.f41155d.top = hVar.a(getContext(), 4.0f);
        this.f41155d.right = i11 - hVar.a(getContext(), 4.0f);
        this.f41155d.bottom = i12 - hVar.a(getContext(), 4.0f);
    }

    public void setColorNetDetect() {
        this.f41160i = Color.parseColor("#33000000");
        this.f41161j = Color.parseColor("#3ECAF2");
    }

    public void setProgress(float f11) {
        this.f41153b = f11;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }
}
