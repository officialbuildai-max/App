package com.transsion.ninegridview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: classes6.dex */
public class NineGridViewWrapper extends ShapeableImageView {
    private TextPaint A;
    private String B;

    /* renamed from: w, reason: collision with root package name */
    private int f47718w;

    /* renamed from: x, reason: collision with root package name */
    private int f47719x;

    /* renamed from: y, reason: collision with root package name */
    private float f47720y;

    /* renamed from: z, reason: collision with root package name */
    private int f47721z;

    public NineGridViewWrapper(Context context) {
        this(context, null);
    }

    public NineGridViewWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridViewWrapper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f47718w = 0;
        this.f47719x = -2013265920;
        this.f47720y = 35.0f;
        this.f47721z = -1;
        this.B = "";
        this.f47720y = TypedValue.applyDimension(2, 35.0f, getContext().getResources().getDisplayMetrics());
        TextPaint textPaint = new TextPaint();
        this.A = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.A.setAntiAlias(true);
        this.A.setTextSize(this.f47720y);
        this.A.setColor(this.f47721z);
    }

    public int getMaskColor() {
        return this.f47719x;
    }

    public int getMoreNum() {
        return this.f47718w;
    }

    public int getTextColor() {
        return this.f47721z;
    }

    public float getTextSize() {
        return this.f47720y;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.imageview.ShapeableImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f47718w > 0) {
            canvas.drawColor(this.f47719x);
            canvas.drawText(this.B, getWidth() / 2, (getHeight() / 2) - ((this.A.ascent() + this.A.descent()) / 2.0f), this.A);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setMaskColor(int i11) {
        this.f47719x = i11;
        invalidate();
    }

    public void setMoreNum(int i11) {
        this.f47718w = i11;
        this.B = "+" + i11;
        invalidate();
    }

    public void setTextColor(int i11) {
        this.f47721z = i11;
        this.A.setColor(i11);
        invalidate();
    }

    public void setTextSize(float f11) {
        this.f47720y = f11;
        this.A.setTextSize(f11);
        invalidate();
    }
}
