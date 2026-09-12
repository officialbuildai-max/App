package com.transsion.baseui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.google.zxing.k;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.ViewfinderView;
import com.transsion.baseui.R$styleable;
import java.util.List;
import xe.q;

/* loaded from: classes5.dex */
public class ORQrCodeViewfinderView extends ViewfinderView {
    public static final long INT_ANIMATION_DELAY = 12;
    public Paint mBitmapPaint;
    public int mLineColor;
    public float mLineDepth;
    public float mLineRate;
    public LinearGradient mLinearGradient;
    public float[] mPositions;
    public float mScanFrameHeight;
    public float mScanFrameWidth;
    public int[] mScanLineColor;
    public float mScanLineDepth;
    public float mScanLineDy;
    public int mScanLinePosition;

    public ORQrCodeViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLineRate = 0.1f;
        this.mLineDepth = b(4);
        this.mScanLinePosition = 0;
        this.mScanLineDepth = b(4);
        this.mScanLineDy = b(3);
        this.mPositions = new float[]{0.0f, 0.5f, 1.0f};
        this.mScanLineColor = new int[]{0, InputDeviceCompat.SOURCE_ANY, 0};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ORQrCodeViewfinderView);
        this.mLineColor = obtainStyledAttributes.getColor(R$styleable.ORQrCodeViewfinderView_lineColor, InputDeviceCompat.SOURCE_ANY);
        this.mScanLineColor[1] = obtainStyledAttributes.getColor(R$styleable.ORQrCodeViewfinderView_cornerColor, InputDeviceCompat.SOURCE_ANY);
        this.mScanFrameWidth = obtainStyledAttributes.getDimension(R$styleable.ORQrCodeViewfinderView_scanFrameWidth, b(160));
        this.mScanFrameHeight = obtainStyledAttributes.getDimension(R$styleable.ORQrCodeViewfinderView_scanFrameHeight, b(160));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mBitmapPaint = paint;
        paint.setAntiAlias(true);
    }

    private int b(int i11) {
        return (int) ((i11 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.journeyapps.barcodescanner.ViewfinderView
    protected void a() {
        CameraPreview cameraPreview = this.f33981k;
        if (cameraPreview == null) {
            return;
        }
        cameraPreview.setFramingRectSize(new q((int) this.mScanFrameWidth, (int) this.mScanFrameHeight));
        Rect framingRect = this.f33981k.getFramingRect();
        q previewSize = this.f33981k.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.f33982l = framingRect;
        this.f33983m = previewSize;
    }

    @Override // com.journeyapps.barcodescanner.ViewfinderView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        a();
        Rect rect = this.f33982l;
        if (rect == null || this.f33983m == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f33971a.setColor(this.f33972b != null ? this.f33974d : this.f33973c);
        float f11 = width;
        canvas.drawRect(0.0f, 0.0f, f11, rect.top, this.f33971a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f33971a);
        canvas.drawRect(rect.right + 1, rect.top, f11, rect.bottom + 1, this.f33971a);
        canvas.drawRect(0.0f, rect.bottom + 1, f11, height, this.f33971a);
        this.f33971a.setColor(this.mLineColor);
        int i11 = rect.left;
        canvas.drawRect(i11, rect.top, i11 + (rect.width() * this.mLineRate), rect.top + this.mLineDepth, this.f33971a);
        int i12 = rect.left;
        int i13 = rect.top;
        canvas.drawRect(i12, i13, this.mLineDepth + i12, i13 + (rect.height() * this.mLineRate), this.f33971a);
        float width2 = rect.right - (rect.width() * this.mLineRate);
        int i14 = rect.top;
        canvas.drawRect(width2, i14, rect.right, i14 + this.mLineDepth, this.f33971a);
        int i15 = rect.right;
        float f12 = i15 - this.mLineDepth;
        int i16 = rect.top;
        canvas.drawRect(f12, i16, i15, i16 + (rect.height() * this.mLineRate), this.f33971a);
        int i17 = rect.left;
        canvas.drawRect(i17, rect.bottom - this.mLineDepth, i17 + (rect.width() * this.mLineRate), rect.bottom, this.f33971a);
        canvas.drawRect(rect.left, rect.bottom - (rect.height() * this.mLineRate), rect.left + this.mLineDepth, rect.bottom, this.f33971a);
        float width3 = rect.right - (rect.width() * this.mLineRate);
        int i18 = rect.bottom;
        canvas.drawRect(width3, i18 - this.mLineDepth, rect.right, i18, this.f33971a);
        canvas.drawRect(rect.right - this.mLineDepth, rect.bottom - (rect.height() * this.mLineRate), rect.right, rect.bottom, this.f33971a);
        if (this.f33972b != null) {
            this.f33971a.setAlpha(160);
            canvas.drawBitmap(this.f33972b, (Rect) null, rect, this.f33971a);
        } else {
            int i19 = (int) (this.mScanLinePosition + this.mScanLineDy);
            this.mScanLinePosition = i19;
            if (i19 >= rect.height()) {
                this.mScanLinePosition = 0;
            }
            float f13 = rect.left;
            int i20 = rect.top;
            int i21 = this.mScanLinePosition;
            LinearGradient linearGradient = new LinearGradient(f13, i20 + i21, rect.right, i20 + i21, this.mScanLineColor, this.mPositions, Shader.TileMode.CLAMP);
            this.mLinearGradient = linearGradient;
            this.f33971a.setShader(linearGradient);
            float f14 = rect.left;
            int i22 = rect.top;
            int i23 = this.mScanLinePosition;
            canvas.drawRect(f14, i22 + i23, rect.right, i22 + i23 + this.mScanLineDepth, this.f33971a);
            this.f33971a.setShader(null);
            float width4 = getWidth() / this.f33983m.f78357a;
            float height2 = getHeight() / this.f33983m.f78358b;
            if (!this.f33980j.isEmpty()) {
                this.f33971a.setAlpha(80);
                this.f33971a.setColor(this.f33976f);
                for (k kVar : this.f33980j) {
                    canvas.drawCircle((int) (kVar.c() * width4), (int) (kVar.d() * height2), 3.0f, this.f33971a);
                }
                this.f33980j.clear();
            }
            if (!this.f33979i.isEmpty()) {
                this.f33971a.setAlpha(160);
                this.f33971a.setColor(this.f33976f);
                for (k kVar2 : this.f33979i) {
                    canvas.drawCircle((int) (kVar2.c() * width4), (int) (kVar2.d() * height2), 6.0f, this.f33971a);
                }
                List list = this.f33979i;
                List list2 = this.f33980j;
                this.f33979i = list2;
                this.f33980j = list;
                list2.clear();
            }
        }
        postInvalidateDelayed(12L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
    }
}
