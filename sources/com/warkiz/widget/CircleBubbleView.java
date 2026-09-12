package com.warkiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes7.dex */
public class CircleBubbleView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f60813a;

    /* renamed from: b, reason: collision with root package name */
    private int f60814b;

    /* renamed from: c, reason: collision with root package name */
    private float f60815c;

    /* renamed from: d, reason: collision with root package name */
    private Context f60816d;

    /* renamed from: e, reason: collision with root package name */
    private Path f60817e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f60818f;

    /* renamed from: g, reason: collision with root package name */
    private float f60819g;

    /* renamed from: h, reason: collision with root package name */
    private float f60820h;

    /* renamed from: i, reason: collision with root package name */
    private float f60821i;

    /* renamed from: j, reason: collision with root package name */
    private String f60822j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleBubbleView(Context context, float f11, int i11, int i12, String str) {
        super(context, null, 0);
        this.f60816d = context;
        this.f60815c = f11;
        this.f60813a = i11;
        this.f60814b = i12;
        a(str);
    }

    private void a(String str) {
        Paint paint = new Paint();
        this.f60818f = paint;
        paint.setAntiAlias(true);
        this.f60818f.setStrokeWidth(1.0f);
        this.f60818f.setTextAlign(Paint.Align.CENTER);
        this.f60818f.setTextSize(this.f60815c);
        this.f60818f.getTextBounds(str, 0, str.length(), new Rect());
        this.f60819g = r0.width() + g.a(this.f60816d, 4.0f);
        float a11 = g.a(this.f60816d, 36.0f);
        if (this.f60819g < a11) {
            this.f60819g = a11;
        }
        this.f60821i = r0.height();
        this.f60820h = this.f60819g * 1.2f;
        b();
    }

    private void b() {
        this.f60817e = new Path();
        float f11 = this.f60819g;
        this.f60817e.arcTo(new RectF(0.0f, 0.0f, f11, f11), 135.0f, 270.0f);
        this.f60817e.lineTo(this.f60819g / 2.0f, this.f60820h);
        this.f60817e.close();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f60818f.setColor(this.f60814b);
        canvas.drawPath(this.f60817e, this.f60818f);
        this.f60818f.setColor(this.f60813a);
        canvas.drawText(this.f60822j, this.f60819g / 2.0f, (this.f60820h / 2.0f) + (this.f60821i / 4.0f), this.f60818f);
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        setMeasuredDimension((int) this.f60819g, (int) this.f60820h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(String str) {
        this.f60822j = str;
        invalidate();
    }
}
