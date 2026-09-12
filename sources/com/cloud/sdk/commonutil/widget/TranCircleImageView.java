package com.cloud.sdk.commonutil.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.cloud.sdk.commonutil.R$styleable;
import com.cloud.sdk.commonutil.util.c;

/* loaded from: classes3.dex */
public class TranCircleImageView extends ImageView {
    public static final int BOTTOM = 2;
    public static final int CENTER = 1;
    public static final int FITXY = 3;
    public static final int TOP = 0;

    /* renamed from: a, reason: collision with root package name */
    private Context f23300a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f23301b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f23302c;

    /* renamed from: d, reason: collision with root package name */
    private float f23303d;

    /* renamed from: e, reason: collision with root package name */
    private float f23304e;

    /* renamed from: f, reason: collision with root package name */
    private float f23305f;

    /* renamed from: g, reason: collision with root package name */
    private float f23306g;

    /* renamed from: h, reason: collision with root package name */
    private float f23307h;

    /* renamed from: i, reason: collision with root package name */
    private float f23308i;

    /* renamed from: j, reason: collision with root package name */
    private float f23309j;

    /* renamed from: k, reason: collision with root package name */
    private float f23310k;

    /* renamed from: l, reason: collision with root package name */
    private float f23311l;

    /* renamed from: m, reason: collision with root package name */
    private float f23312m;

    /* renamed from: n, reason: collision with root package name */
    private float f23313n;

    /* renamed from: o, reason: collision with root package name */
    private float f23314o;

    /* renamed from: p, reason: collision with root package name */
    private float f23315p;

    /* renamed from: q, reason: collision with root package name */
    private float f23316q;

    /* renamed from: r, reason: collision with root package name */
    private float f23317r;

    /* renamed from: s, reason: collision with root package name */
    private int f23318s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f23319t;

    /* renamed from: u, reason: collision with root package name */
    private int f23320u;

    public TranCircleImageView(Context context) {
        super(context);
        initData();
    }

    public TranCircleImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23300a = context;
        e(attributeSet);
    }

    private void a(Canvas canvas, RectF rectF, Paint paint, float f11) {
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{g(this.f23308i, f11), g(this.f23309j, f11), g(this.f23310k, f11), g(this.f23311l, f11), g(this.f23314o, f11), g(this.f23315p, f11), g(this.f23312m, f11), g(this.f23313n, f11)}, Path.Direction.CW);
        path.close();
        canvas.drawPath(path, paint);
    }

    private boolean b(Drawable drawable) {
        return drawable != null && drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0;
    }

    private Bitmap c(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th2) {
            c.Log().e("TranCircleImageView", Log.getStackTraceString(th2));
            return null;
        }
    }

    private Rect d(Bitmap bitmap, int i11, int i12) {
        int i13;
        int i14;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i15 = width * i12;
        int i16 = i11 * height;
        int i17 = 0;
        int[] iArr = {width, height};
        if (i15 == i16) {
            return new Rect(0, 0, width, height);
        }
        if (i15 > i16) {
            iArr[0] = i16 / i12;
        } else if (i15 < i16) {
            iArr[1] = i15 / i11;
        }
        boolean z10 = width > iArr[0];
        int i18 = this.f23320u;
        if (i18 != 0) {
            if (i18 == 1) {
                i14 = z10 ? (width - iArr[0]) / 2 : 0;
                i13 = z10 ? 0 : (height - iArr[1]) / 2;
                width = z10 ? (width + iArr[0]) / 2 : iArr[0];
                height = z10 ? iArr[1] : (height + iArr[1]) / 2;
            } else if (i18 == 2) {
                i14 = z10 ? (width - iArr[0]) / 2 : 0;
                i13 = z10 ? 0 : height - iArr[1];
                width = z10 ? (width + iArr[0]) / 2 : iArr[0];
                if (z10) {
                    height = iArr[1];
                }
            } else if (i18 != 3) {
                height = 0;
                width = 0;
                i13 = 0;
            } else {
                i13 = 0;
            }
            i17 = i14;
        } else {
            int i19 = z10 ? (width - iArr[0]) / 2 : 0;
            width = z10 ? (width + iArr[0]) / 2 : iArr[0];
            i13 = 0;
            i17 = i19;
            height = iArr[1];
        }
        return new Rect(i17, i13, width, height);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f23300a.obtainStyledAttributes(attributeSet, R$styleable.TranCircleImageView);
        this.f23303d = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_radiusYL, 0.0f);
        this.f23304e = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topLeftRadiusYL, 0.0f);
        this.f23305f = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topRightRadiusYL, 0.0f);
        this.f23306g = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomLeftRadiusYL, 0.0f);
        this.f23307h = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomRightRadiusYL, 0.0f);
        this.f23320u = obtainStyledAttributes.getInt(R$styleable.TranCircleImageView_scaleTypeYL, 0);
        this.f23316q = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_borderWidthYL, 0.0f);
        this.f23317r = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_borderSpaceYL, 0.0f);
        this.f23318s = obtainStyledAttributes.getColor(R$styleable.TranCircleImageView_borderColorYL, -1);
        this.f23308i = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topLeftRadius_xYL, 0.0f);
        this.f23309j = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topLeftRadius_yYL, 0.0f);
        this.f23310k = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topRightRadius_xYL, 0.0f);
        this.f23311l = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topRightRadius_yYL, 0.0f);
        this.f23312m = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomLeftRadius_xYL, 0.0f);
        this.f23313n = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomLeftRadius_yYL, 0.0f);
        this.f23314o = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomRightRadius_xYL, 0.0f);
        this.f23315p = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomRightRadius_yYL, 0.0f);
        obtainStyledAttributes.recycle();
        initData();
    }

    private void f() {
        float f11 = this.f23303d;
        if (f11 != 0.0f) {
            float f12 = this.f23304e;
            if (f12 == 0.0f) {
                f12 = f11;
            }
            this.f23304e = f12;
            float f13 = this.f23305f;
            if (f13 == 0.0f) {
                f13 = f11;
            }
            this.f23305f = f13;
            float f14 = this.f23306g;
            if (f14 == 0.0f) {
                f14 = f11;
            }
            this.f23306g = f14;
            float f15 = this.f23307h;
            if (f15 != 0.0f) {
                f11 = f15;
            }
            this.f23307h = f11;
        }
        float f16 = this.f23308i;
        if (f16 == 0.0f) {
            f16 = this.f23304e;
        }
        this.f23308i = f16;
        float f17 = this.f23309j;
        if (f17 == 0.0f) {
            f17 = this.f23304e;
        }
        this.f23309j = f17;
        float f18 = this.f23310k;
        if (f18 == 0.0f) {
            f18 = this.f23305f;
        }
        this.f23310k = f18;
        float f19 = this.f23311l;
        if (f19 == 0.0f) {
            f19 = this.f23305f;
        }
        this.f23311l = f19;
        float f20 = this.f23312m;
        if (f20 == 0.0f) {
            f20 = this.f23306g;
        }
        this.f23312m = f20;
        float f21 = this.f23313n;
        if (f21 == 0.0f) {
            f21 = this.f23306g;
        }
        this.f23313n = f21;
        float f22 = this.f23314o;
        if (f22 == 0.0f) {
            f22 = this.f23307h;
        }
        this.f23314o = f22;
        float f23 = this.f23315p;
        if (f23 == 0.0f) {
            f23 = this.f23307h;
        }
        this.f23315p = f23;
    }

    private float g(float f11, float f12) {
        return Math.max(f11 - f12, 0.0f);
    }

    public Paint getBorderPaint() {
        return this.f23302c;
    }

    public Paint getPaint() {
        return this.f23301b;
    }

    public void initData() {
        f();
        this.f23319t = (this.f23316q == 0.0f && this.f23317r == 0.0f && this.f23308i == 0.0f && this.f23309j == 0.0f && this.f23310k == 0.0f && this.f23311l == 0.0f && this.f23312m == 0.0f && this.f23313n == 0.0f && this.f23314o == 0.0f && this.f23315p == 0.0f) ? false : true;
        this.f23301b = new Paint(1);
        Paint paint = new Paint(1);
        this.f23302c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f23302c.setStrokeWidth(this.f23316q);
        this.f23302c.setColor(this.f23318s);
        if (this.f23319t) {
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            if (this.f23316q != 0.0f) {
                RectF rectF = new RectF(paddingLeft, paddingTop, measuredWidth - paddingRight, measuredHeight - paddingBottom);
                float f11 = this.f23316q / 2.0f;
                rectF.inset(f11, f11);
                a(canvas, rectF, this.f23302c, f11);
            }
            if (!b(drawable) || !this.f23319t) {
                super.onDraw(canvas);
                return;
            }
            RectF rectF2 = new RectF(paddingLeft, paddingTop, measuredWidth - paddingRight, measuredHeight - paddingBottom);
            float f12 = this.f23316q + this.f23317r;
            float f13 = f12 > 1.0f ? f12 - 1.0f : 0.0f;
            rectF2.inset(f13, f13);
            int saveLayer = canvas.saveLayer(rectF2, null, 31);
            a(canvas, rectF2, this.f23301b, f13);
            Paint paint = this.f23301b;
            if (paint != null) {
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            Bitmap c11 = c(drawable);
            canvas.drawBitmap(c11, d(c11, (int) rectF2.width(), (int) rectF2.height()), rectF2, this.f23301b);
            Paint paint2 = this.f23301b;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restoreToCount(saveLayer);
        } catch (Throwable th2) {
            c.Log().e("TranCircleImageView", Log.getStackTraceString(th2));
        }
    }

    public void setBorderColor(int i11) {
        this.f23318s = i11;
        Paint paint = this.f23302c;
        if (paint != null) {
            paint.setColor(i11);
        }
    }

    public void setBorderSpace(float f11) {
        this.f23317r = f11;
    }

    public void setBorderWidth(float f11) {
        this.f23316q = f11;
        Paint paint = this.f23302c;
        if (paint != null) {
            paint.setStrokeWidth(f11);
        }
    }

    public void setBottomLeftRadius(float f11) {
        setBottomLeftRadius_x(f11);
        setBottomLeftRadius_y(f11);
    }

    public void setBottomLeftRadius_x(float f11) {
        this.f23312m = f11;
    }

    public void setBottomLeftRadius_y(float f11) {
        this.f23313n = f11;
    }

    public void setBottomRightRadius(float f11) {
        setBottomRightRadius_x(f11);
        setBottomRightRadius_y(f11);
    }

    public void setBottomRightRadius_x(float f11) {
        this.f23314o = f11;
    }

    public void setBottomRightRadius_y(float f11) {
        this.f23315p = f11;
    }

    public void setCircle(boolean z10) {
        this.f23319t = z10;
    }

    public void setRadius(float f11) {
        setTopLeftRadius(f11);
        setTopRightRadius(f11);
        setBottomLeftRadius(f11);
        setBottomRightRadius(f11);
    }

    public void setStyleType(int i11) {
        this.f23320u = i11;
    }

    public void setTopLeftRadius(float f11) {
        setTopLeftRadius_x(f11);
        setTopLeftRadius_y(f11);
    }

    public void setTopLeftRadius_x(float f11) {
        this.f23308i = f11;
    }

    public void setTopLeftRadius_y(float f11) {
        this.f23309j = f11;
    }

    public void setTopRightRadius(float f11) {
        setTopRightRadius_x(f11);
        setTopRightRadius_y(f11);
    }

    public void setTopRightRadius_x(float f11) {
        this.f23310k = f11;
    }

    public void setTopRightRadius_y(float f11) {
        this.f23311l = f11;
    }
}
