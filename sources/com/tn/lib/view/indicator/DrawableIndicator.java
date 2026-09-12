package com.tn.lib.view.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class DrawableIndicator extends BaseIndicator {

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f41392d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f41393e;

    public DrawableIndicator(Context context) {
        this(context, null);
    }

    public DrawableIndicator(Context context, int i11, int i12) {
        super(context);
        this.f41392d = BitmapFactory.decodeResource(getResources(), i11);
        this.f41393e = BitmapFactory.decodeResource(getResources(), i12);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DrawableIndicator);
        if (obtainStyledAttributes != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) obtainStyledAttributes.getDrawable(R$styleable.DrawableIndicator_normal_drawable);
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) obtainStyledAttributes.getDrawable(R$styleable.DrawableIndicator_selected_drawable);
            this.f41392d = bitmapDrawable.getBitmap();
            this.f41393e = bitmapDrawable2.getBitmap();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d11 = this.f41386a.d();
        if (d11 <= 1 || this.f41392d == null || this.f41393e == null) {
            return;
        }
        int i11 = 0;
        float f11 = 0.0f;
        while (i11 < d11) {
            canvas.drawBitmap(this.f41386a.a() == i11 ? this.f41393e : this.f41392d, f11, 0.0f, this.f41387b);
            f11 += this.f41392d.getWidth() + this.f41386a.e();
            i11++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int d11 = this.f41386a.d();
        if (d11 <= 1) {
            return;
        }
        int i13 = d11 - 1;
        setMeasuredDimension((this.f41393e.getWidth() * i13) + this.f41393e.getWidth() + (this.f41386a.e() * i13), Math.max(this.f41392d.getHeight(), this.f41393e.getHeight()));
    }
}
