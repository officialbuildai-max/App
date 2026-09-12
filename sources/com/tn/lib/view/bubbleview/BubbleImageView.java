package com.tn.lib.view.bubbleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class BubbleImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private BubbleDrawable f41288a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f41289b;

    /* renamed from: c, reason: collision with root package name */
    private float f41290c;

    /* renamed from: d, reason: collision with root package name */
    private float f41291d;

    /* renamed from: e, reason: collision with root package name */
    private float f41292e;

    /* renamed from: f, reason: collision with root package name */
    private float f41293f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f41294g;

    /* renamed from: h, reason: collision with root package name */
    private BubbleDrawable.ArrowLocation f41295h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f41296i;

    public BubbleImageView(Context context) {
        super(context);
        c(null);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(attributeSet);
    }

    private Bitmap a(Drawable drawable) {
        return getBitmapFromDrawable(getContext(), drawable, getWidth(), getWidth(), 25);
    }

    private Drawable b(int i11) {
        if (i11 != 0) {
            return getContext().getResources().getDrawable(i11);
        }
        throw new IllegalArgumentException("getDrawable res can not be zero");
    }

    private void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleView);
            this.f41290c = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowWidth, BubbleDrawable.b.f41195u);
            this.f41292e = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowHeight, BubbleDrawable.b.f41196v);
            this.f41291d = obtainStyledAttributes.getDimension(R$styleable.BubbleView_angle, BubbleDrawable.b.f41197w);
            this.f41293f = obtainStyledAttributes.getDimension(R$styleable.BubbleView_arrowPosition, BubbleDrawable.b.f41198x);
            this.f41295h = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R$styleable.BubbleView_arrowLocation, 0));
            this.f41296i = obtainStyledAttributes.getBoolean(R$styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
        }
    }

    private void d() {
        Drawable drawable;
        Drawable drawable2;
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height <= 0 && (drawable2 = this.f41289b) != null && drawable2.getIntrinsicWidth() >= 0) {
            height = (width / this.f41289b.getIntrinsicWidth()) * this.f41289b.getIntrinsicHeight();
        }
        if (height > 0 && width <= 0 && (drawable = this.f41289b) != null && drawable.getIntrinsicHeight() >= 0) {
            width = (height / this.f41289b.getIntrinsicHeight()) * this.f41289b.getIntrinsicWidth();
        }
        e(width, height);
    }

    public static int dp2px(Context context, int i11) {
        return (int) TypedValue.applyDimension(1, i11, context.getResources().getDisplayMetrics());
    }

    private void e(int i11, int i12) {
        f(getPaddingLeft(), i11 - getPaddingRight(), getPaddingTop(), i12 - getPaddingBottom());
    }

    private void f(int i11, int i12, int i13, int i14) {
        if (i12 <= i11 || i14 <= i13) {
            return;
        }
        RectF rectF = new RectF(i11, i13, i12, i14);
        Drawable drawable = this.f41289b;
        if (drawable != null) {
            this.f41294g = a(drawable);
        }
        this.f41288a = new BubbleDrawable.b().B(rectF).t(this.f41295h).q(this.f41291d).s(this.f41292e).v(this.f41290c).z(BubbleDrawable.BubbleType.BITMAP).u(this.f41293f).w(this.f41294g).r(this.f41296i).A();
    }

    public static Bitmap getBitmapFromDrawable(Context context, Drawable drawable, int i11, int i12, int i13) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = (i11 <= 0 || i12 <= 0) ? Bitmap.createBitmap(dp2px(context, i13), dp2px(context, i13), Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        BubbleDrawable bubbleDrawable = this.f41288a;
        if (bubbleDrawable != null) {
            bubbleDrawable.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        d();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 && measuredHeight > 0) {
            setMeasuredDimension(measuredHeight, measuredHeight);
        }
        if (measuredHeight > 0 || measuredWidth <= 0) {
            return;
        }
        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        e(i11, i12);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.f41294g = bitmap;
        this.f41289b = new BitmapDrawable(getResources(), bitmap);
        d();
        super.setImageDrawable(this.f41288a);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.f41289b = drawable;
        d();
        super.setImageDrawable(this.f41288a);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i11) {
        setImageDrawable(b(i11));
    }
}
