package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.widget.MBImageView;

/* loaded from: classes5.dex */
public class RoundImageView extends MBImageView {

    /* renamed from: c, reason: collision with root package name */
    private int f40069c;

    /* renamed from: d, reason: collision with root package name */
    private int f40070d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f40071e;

    /* renamed from: f, reason: collision with root package name */
    private int f40072f;

    /* renamed from: g, reason: collision with root package name */
    private Matrix f40073g;

    /* renamed from: h, reason: collision with root package name */
    private BitmapShader f40074h;

    /* renamed from: i, reason: collision with root package name */
    private int f40075i;

    /* renamed from: j, reason: collision with root package name */
    private RectF f40076j;

    public RoundImageView(Context context) {
        super(context);
        this.f40073g = new Matrix();
        Paint paint = new Paint();
        this.f40071e = paint;
        paint.setAntiAlias(true);
        this.f40070d = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f40069c = 1;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40073g = new Matrix();
        Paint paint = new Paint();
        this.f40071e = paint;
        paint.setAntiAlias(true);
        this.f40070d = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f40069c = 1;
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f40073g = new Matrix();
        Paint paint = new Paint();
        this.f40071e = paint;
        paint.setAntiAlias(true);
        this.f40070d = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f40069c = 1;
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th2) {
            o0.b("View", th2.getMessage());
            return null;
        }
    }

    private void b() {
        Bitmap a11;
        try {
            Drawable drawable = getDrawable();
            if (drawable == null || (a11 = a(drawable)) == null || a11.isRecycled()) {
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f40074h = new BitmapShader(a11, tileMode, tileMode);
            int i11 = this.f40069c;
            float f11 = 1.0f;
            if (i11 == 0) {
                f11 = (this.f40075i * 1.0f) / Math.min(a11.getWidth(), a11.getHeight());
            } else if (i11 == 1) {
                f11 = Math.max((getWidth() * 1.0f) / a11.getWidth(), (getHeight() * 1.0f) / a11.getHeight());
            }
            this.f40073g.setScale(f11, f11);
            this.f40074h.setLocalMatrix(this.f40073g);
            this.f40071e.setShader(this.f40074h);
        } catch (Throwable th2) {
            o0.b("RoundImageView", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.widget.MBImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (getDrawable() == null) {
                return;
            }
            b();
            if (this.f40069c == 1) {
                RectF rectF = this.f40076j;
                float f11 = this.f40070d;
                canvas.drawRoundRect(rectF, f11, f11, this.f40071e);
            } else {
                float f12 = this.f40072f;
                canvas.drawCircle(f12, f12, f12, this.f40071e);
            }
        } catch (Throwable th2) {
            o0.b("RoundImageView", th2.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.f40069c == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.f40075i = min;
            this.f40072f = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
        this.f40069c = bundle.getInt("state_type");
        this.f40070d = bundle.getInt("state_border_radius");
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f40069c);
        bundle.putInt("state_border_radius", this.f40070d);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (this.f40069c == 1) {
            this.f40076j = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    public void setBorderRadius(int i11) {
        int a11 = t0.a(getContext(), i11);
        if (this.f40070d != a11) {
            this.f40070d = a11;
            invalidate();
        }
    }

    public void setType(int i11) {
        if (this.f40069c != i11) {
            this.f40069c = i11;
            if (i11 != 1 && i11 != 0) {
                this.f40069c = 0;
            }
            requestLayout();
        }
    }
}
