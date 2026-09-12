package com.warkiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes7.dex */
public class ArrowView extends View {

    /* renamed from: a, reason: collision with root package name */
    private final int f60809a;

    /* renamed from: b, reason: collision with root package name */
    private final int f60810b;

    /* renamed from: c, reason: collision with root package name */
    private final Path f60811c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f60812d;

    public ArrowView(Context context) {
        this(context, null);
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int a11 = g.a(context, 12.0f);
        this.f60809a = a11;
        int a12 = g.a(context, 7.0f);
        this.f60810b = a12;
        Path path = new Path();
        this.f60811c = path;
        path.moveTo(0.0f, 0.0f);
        path.lineTo(a11, 0.0f);
        path.lineTo(a11 / 2.0f, a12);
        path.close();
        Paint paint = new Paint();
        this.f60812d = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(this.f60811c, this.f60812d);
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        setMeasuredDimension(this.f60809a, this.f60810b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setColor(int i11) {
        this.f60812d.setColor(i11);
        invalidate();
    }
}
