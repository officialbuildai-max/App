package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.constraintlayout.motion.widget.c;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.view.GravityCompat;
import com.google.android.material.card.MaterialCardView;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public class MotionLabel extends View implements c {
    static String V = "MotionLabel";
    private float A;
    private float B;
    private float C;
    private Drawable D;
    Matrix E;
    private Bitmap F;
    private BitmapShader G;
    private Matrix H;
    private float I;
    private float J;
    private float K;
    private float L;
    Paint M;
    private int N;
    Rect O;
    Paint P;
    float Q;
    float R;
    float S;
    float T;
    float U;

    /* renamed from: a, reason: collision with root package name */
    TextPaint f7680a;

    /* renamed from: b, reason: collision with root package name */
    Path f7681b;

    /* renamed from: c, reason: collision with root package name */
    private int f7682c;

    /* renamed from: d, reason: collision with root package name */
    private int f7683d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7684e;

    /* renamed from: f, reason: collision with root package name */
    private float f7685f;

    /* renamed from: g, reason: collision with root package name */
    private float f7686g;

    /* renamed from: h, reason: collision with root package name */
    ViewOutlineProvider f7687h;

    /* renamed from: i, reason: collision with root package name */
    RectF f7688i;

    /* renamed from: j, reason: collision with root package name */
    private float f7689j;

    /* renamed from: k, reason: collision with root package name */
    private float f7690k;

    /* renamed from: l, reason: collision with root package name */
    private int f7691l;

    /* renamed from: m, reason: collision with root package name */
    private int f7692m;

    /* renamed from: n, reason: collision with root package name */
    private float f7693n;

    /* renamed from: o, reason: collision with root package name */
    private String f7694o;

    /* renamed from: p, reason: collision with root package name */
    boolean f7695p;

    /* renamed from: q, reason: collision with root package name */
    private Rect f7696q;

    /* renamed from: r, reason: collision with root package name */
    private int f7697r;

    /* renamed from: s, reason: collision with root package name */
    private int f7698s;

    /* renamed from: t, reason: collision with root package name */
    private int f7699t;

    /* renamed from: u, reason: collision with root package name */
    private int f7700u;

    /* renamed from: v, reason: collision with root package name */
    private String f7701v;

    /* renamed from: w, reason: collision with root package name */
    private Layout f7702w;

    /* renamed from: x, reason: collision with root package name */
    private int f7703x;

    /* renamed from: y, reason: collision with root package name */
    private int f7704y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7705z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), (Math.min(r3, r4) * MotionLabel.this.f7685f) / 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.f7686g);
        }
    }

    public MotionLabel(Context context) {
        super(context);
        this.f7680a = new TextPaint();
        this.f7681b = new Path();
        this.f7682c = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7683d = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7684e = false;
        this.f7685f = 0.0f;
        this.f7686g = Float.NaN;
        this.f7689j = 48.0f;
        this.f7690k = Float.NaN;
        this.f7693n = 0.0f;
        this.f7694o = "Hello World";
        this.f7695p = true;
        this.f7696q = new Rect();
        this.f7697r = 1;
        this.f7698s = 1;
        this.f7699t = 1;
        this.f7700u = 1;
        this.f7703x = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.f7704y = 0;
        this.f7705z = false;
        this.I = Float.NaN;
        this.J = Float.NaN;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        f(context, null);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7680a = new TextPaint();
        this.f7681b = new Path();
        this.f7682c = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7683d = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7684e = false;
        this.f7685f = 0.0f;
        this.f7686g = Float.NaN;
        this.f7689j = 48.0f;
        this.f7690k = Float.NaN;
        this.f7693n = 0.0f;
        this.f7694o = "Hello World";
        this.f7695p = true;
        this.f7696q = new Rect();
        this.f7697r = 1;
        this.f7698s = 1;
        this.f7699t = 1;
        this.f7700u = 1;
        this.f7703x = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.f7704y = 0;
        this.f7705z = false;
        this.I = Float.NaN;
        this.J = Float.NaN;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        f(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7680a = new TextPaint();
        this.f7681b = new Path();
        this.f7682c = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7683d = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7684e = false;
        this.f7685f = 0.0f;
        this.f7686g = Float.NaN;
        this.f7689j = 48.0f;
        this.f7690k = Float.NaN;
        this.f7693n = 0.0f;
        this.f7694o = "Hello World";
        this.f7695p = true;
        this.f7696q = new Rect();
        this.f7697r = 1;
        this.f7698s = 1;
        this.f7699t = 1;
        this.f7700u = 1;
        this.f7703x = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.f7704y = 0;
        this.f7705z = false;
        this.I = Float.NaN;
        this.J = Float.NaN;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        f(context, attributeSet);
    }

    private void c(float f11, float f12, float f13, float f14) {
        if (this.H == null) {
            return;
        }
        this.B = f13 - f11;
        this.C = f14 - f12;
        k();
    }

    private void f(Context context, AttributeSet attributeSet) {
        h(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R$styleable.MotionLabel_android_fontFamily) {
                    this.f7701v = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MotionLabel_scaleFromTextSize) {
                    this.f7690k = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f7690k);
                } else if (index == R$styleable.MotionLabel_android_textSize) {
                    this.f7689j = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f7689j);
                } else if (index == R$styleable.MotionLabel_android_textStyle) {
                    this.f7691l = obtainStyledAttributes.getInt(index, this.f7691l);
                } else if (index == R$styleable.MotionLabel_android_typeface) {
                    this.f7692m = obtainStyledAttributes.getInt(index, this.f7692m);
                } else if (index == R$styleable.MotionLabel_android_textColor) {
                    this.f7682c = obtainStyledAttributes.getColor(index, this.f7682c);
                } else if (index == R$styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.f7686g);
                    this.f7686g = dimension;
                    setRound(dimension);
                } else if (index == R$styleable.MotionLabel_borderRoundPercent) {
                    float f11 = obtainStyledAttributes.getFloat(index, this.f7685f);
                    this.f7685f = f11;
                    setRoundPercent(f11);
                } else if (index == R$styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R$styleable.MotionLabel_android_autoSizeTextType) {
                    this.f7704y = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.MotionLabel_textOutlineColor) {
                    this.f7683d = obtainStyledAttributes.getInt(index, this.f7683d);
                    this.f7684e = true;
                } else if (index == R$styleable.MotionLabel_textOutlineThickness) {
                    this.f7693n = obtainStyledAttributes.getDimension(index, this.f7693n);
                    this.f7684e = true;
                } else if (index == R$styleable.MotionLabel_textBackground) {
                    this.D = obtainStyledAttributes.getDrawable(index);
                    this.f7684e = true;
                } else if (index == R$styleable.MotionLabel_textBackgroundPanX) {
                    this.R = obtainStyledAttributes.getFloat(index, this.R);
                } else if (index == R$styleable.MotionLabel_textBackgroundPanY) {
                    this.S = obtainStyledAttributes.getFloat(index, this.S);
                } else if (index == R$styleable.MotionLabel_textPanX) {
                    this.K = obtainStyledAttributes.getFloat(index, this.K);
                } else if (index == R$styleable.MotionLabel_textPanY) {
                    this.L = obtainStyledAttributes.getFloat(index, this.L);
                } else if (index == R$styleable.MotionLabel_textBackgroundRotate) {
                    this.U = obtainStyledAttributes.getFloat(index, this.U);
                } else if (index == R$styleable.MotionLabel_textBackgroundZoom) {
                    this.T = obtainStyledAttributes.getFloat(index, this.T);
                } else if (index == R$styleable.MotionLabel_textureHeight) {
                    this.I = obtainStyledAttributes.getDimension(index, this.I);
                } else if (index == R$styleable.MotionLabel_textureWidth) {
                    this.J = obtainStyledAttributes.getDimension(index, this.J);
                } else if (index == R$styleable.MotionLabel_textureEffect) {
                    this.N = obtainStyledAttributes.getInt(index, this.N);
                }
            }
            obtainStyledAttributes.recycle();
        }
        j();
        i();
    }

    private void g(String str, int i11, int i12) {
        Typeface typeface;
        if (str != null) {
            typeface = Typeface.create(str, i12);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        if (i11 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i11 == 2) {
            typeface = Typeface.SERIF;
        } else if (i11 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        if (i12 <= 0) {
            this.f7680a.setFakeBoldText(false);
            this.f7680a.setTextSkewX(0.0f);
            setTypeface(typeface);
        } else {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i12) : Typeface.create(typeface, i12);
            setTypeface(defaultFromStyle);
            int i13 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i12;
            this.f7680a.setFakeBoldText((i13 & 1) != 0);
            this.f7680a.setTextSkewX((i13 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    private float getHorizontalOffset() {
        float f11 = Float.isNaN(this.f7690k) ? 1.0f : this.f7689j / this.f7690k;
        TextPaint textPaint = this.f7680a;
        String str = this.f7694o;
        return (((((Float.isNaN(this.B) ? getMeasuredWidth() : this.B) - getPaddingLeft()) - getPaddingRight()) - (f11 * textPaint.measureText(str, 0, str.length()))) * (this.K + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f11 = Float.isNaN(this.f7690k) ? 1.0f : this.f7689j / this.f7690k;
        Paint.FontMetrics fontMetrics = this.f7680a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.C) ? getMeasuredHeight() : this.C) - getPaddingTop()) - getPaddingBottom();
        float f12 = fontMetrics.descent;
        float f13 = fontMetrics.ascent;
        return (((measuredHeight - ((f12 - f13) * f11)) * (1.0f - this.L)) / 2.0f) - (f11 * f13);
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f7680a;
        int i11 = typedValue.data;
        this.f7682c = i11;
        textPaint.setColor(i11);
    }

    private void j() {
        if (this.D != null) {
            this.H = new Matrix();
            int intrinsicWidth = this.D.getIntrinsicWidth();
            int intrinsicHeight = this.D.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.J) ? 128 : (int) this.J;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.I) ? 128 : (int) this.I;
            }
            if (this.N != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.F = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.F);
            this.D.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.D.setFilterBitmap(true);
            this.D.draw(canvas);
            if (this.N != 0) {
                this.F = d(this.F, 4);
            }
            Bitmap bitmap = this.F;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.G = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void k() {
        float f11 = Float.isNaN(this.R) ? 0.0f : this.R;
        float f12 = Float.isNaN(this.S) ? 0.0f : this.S;
        float f13 = Float.isNaN(this.T) ? 1.0f : this.T;
        float f14 = Float.isNaN(this.U) ? 0.0f : this.U;
        this.H.reset();
        float width = this.F.getWidth();
        float height = this.F.getHeight();
        float f15 = Float.isNaN(this.J) ? this.B : this.J;
        float f16 = Float.isNaN(this.I) ? this.C : this.I;
        float f17 = f13 * (width * f16 < height * f15 ? f15 / width : f16 / height);
        this.H.postScale(f17, f17);
        float f18 = width * f17;
        float f19 = f15 - f18;
        float f20 = f17 * height;
        float f21 = f16 - f20;
        if (!Float.isNaN(this.I)) {
            f21 = this.I / 2.0f;
        }
        if (!Float.isNaN(this.J)) {
            f19 = this.J / 2.0f;
        }
        this.H.postTranslate((((f11 * f19) + f15) - f18) * 0.5f, (((f12 * f21) + f16) - f20) * 0.5f);
        this.H.postRotate(f14, f15 / 2.0f, f16 / 2.0f);
        this.G.setLocalMatrix(this.H);
    }

    Bitmap d(Bitmap bitmap, int i11) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i12 = 0; i12 < i11 && width >= 32 && height >= 32; i12++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    void e(float f11) {
        if (this.f7684e || f11 != 1.0f) {
            this.f7681b.reset();
            String str = this.f7694o;
            int length = str.length();
            this.f7680a.getTextBounds(str, 0, length, this.f7696q);
            this.f7680a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f7681b);
            if (f11 != 1.0f) {
                Log.v(V, androidx.constraintlayout.motion.widget.a.a() + " scale " + f11);
                Matrix matrix = new Matrix();
                matrix.postScale(f11, f11);
                this.f7681b.transform(matrix);
            }
            Rect rect = this.f7696q;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.f7695p = false;
        }
    }

    public float getRound() {
        return this.f7686g;
    }

    public float getRoundPercent() {
        return this.f7685f;
    }

    public float getScaleFromTextSize() {
        return this.f7690k;
    }

    public float getTextBackgroundPanX() {
        return this.R;
    }

    public float getTextBackgroundPanY() {
        return this.S;
    }

    public float getTextBackgroundRotate() {
        return this.U;
    }

    public float getTextBackgroundZoom() {
        return this.T;
    }

    public int getTextOutlineColor() {
        return this.f7683d;
    }

    public float getTextPanX() {
        return this.K;
    }

    public float getTextPanY() {
        return this.L;
    }

    public float getTextureHeight() {
        return this.I;
    }

    public float getTextureWidth() {
        return this.J;
    }

    public Typeface getTypeface() {
        return this.f7680a.getTypeface();
    }

    void i() {
        this.f7697r = getPaddingLeft();
        this.f7698s = getPaddingRight();
        this.f7699t = getPaddingTop();
        this.f7700u = getPaddingBottom();
        g(this.f7701v, this.f7692m, this.f7691l);
        this.f7680a.setColor(this.f7682c);
        this.f7680a.setStrokeWidth(this.f7693n);
        this.f7680a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f7680a.setFlags(128);
        setTextSize(this.f7689j);
        this.f7680a.setAntiAlias(true);
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void layout(float f11, float f12, float f13, float f14) {
        int i11 = (int) (f11 + 0.5f);
        this.A = f11 - i11;
        int i12 = (int) (f13 + 0.5f);
        int i13 = i12 - i11;
        int i14 = (int) (f14 + 0.5f);
        int i15 = (int) (0.5f + f12);
        int i16 = i14 - i15;
        float f15 = f13 - f11;
        this.B = f15;
        float f16 = f14 - f12;
        this.C = f16;
        c(f11, f12, f13, f14);
        if (getMeasuredHeight() == i16 && getMeasuredWidth() == i13) {
            super.layout(i11, i15, i12, i14);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
            super.layout(i11, i15, i12, i14);
        }
        if (this.f7705z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f7680a);
                this.Q = this.P.getTextSize();
            }
            this.B = f15;
            this.C = f16;
            Paint paint = this.P;
            String str = this.f7694o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            float height = this.O.height() * 1.3f;
            float f17 = (f15 - this.f7698s) - this.f7697r;
            float f18 = (f16 - this.f7700u) - this.f7699t;
            float width = this.O.width();
            if (width * f18 > height * f17) {
                this.f7680a.setTextSize((this.Q * f17) / width);
            } else {
                this.f7680a.setTextSize((this.Q * f18) / height);
            }
            if (this.f7684e || !Float.isNaN(this.f7690k)) {
                e(Float.isNaN(this.f7690k) ? 1.0f : this.f7689j / this.f7690k);
            }
        }
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        boolean isNaN = Float.isNaN(this.f7690k);
        float f11 = isNaN ? 1.0f : this.f7689j / this.f7690k;
        this.B = i13 - i11;
        this.C = i14 - i12;
        if (this.f7705z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f7680a);
                this.Q = this.P.getTextSize();
            }
            Paint paint = this.P;
            String str = this.f7694o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            int width = this.O.width();
            int height = (int) (this.O.height() * 1.3f);
            float f12 = (this.B - this.f7698s) - this.f7697r;
            float f13 = (this.C - this.f7700u) - this.f7699t;
            if (isNaN) {
                float f14 = width;
                float f15 = height;
                if (f14 * f13 > f15 * f12) {
                    this.f7680a.setTextSize((this.Q * f12) / f14);
                } else {
                    this.f7680a.setTextSize((this.Q * f13) / f15);
                }
            } else {
                float f16 = width;
                float f17 = height;
                f11 = f16 * f13 > f17 * f12 ? f12 / f16 : f13 / f17;
            }
        }
        if (this.f7684e || !isNaN) {
            c(i11, i12, i13, i14);
            e(f11);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f11 = Float.isNaN(this.f7690k) ? 1.0f : this.f7689j / this.f7690k;
        super.onDraw(canvas);
        if (!this.f7684e && f11 == 1.0f) {
            canvas.drawText(this.f7694o, this.A + this.f7697r + getHorizontalOffset(), this.f7699t + getVerticalOffset(), this.f7680a);
            return;
        }
        if (this.f7695p) {
            e(f11);
        }
        if (this.E == null) {
            this.E = new Matrix();
        }
        if (!this.f7684e) {
            float horizontalOffset = this.f7697r + getHorizontalOffset();
            float verticalOffset = this.f7699t + getVerticalOffset();
            this.E.reset();
            this.E.preTranslate(horizontalOffset, verticalOffset);
            this.f7681b.transform(this.E);
            this.f7680a.setColor(this.f7682c);
            this.f7680a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f7680a.setStrokeWidth(this.f7693n);
            canvas.drawPath(this.f7681b, this.f7680a);
            this.E.reset();
            this.E.preTranslate(-horizontalOffset, -verticalOffset);
            this.f7681b.transform(this.E);
            return;
        }
        this.M.set(this.f7680a);
        this.E.reset();
        float horizontalOffset2 = this.f7697r + getHorizontalOffset();
        float verticalOffset2 = this.f7699t + getVerticalOffset();
        this.E.postTranslate(horizontalOffset2, verticalOffset2);
        this.E.preScale(f11, f11);
        this.f7681b.transform(this.E);
        if (this.G != null) {
            this.f7680a.setFilterBitmap(true);
            this.f7680a.setShader(this.G);
        } else {
            this.f7680a.setColor(this.f7682c);
        }
        this.f7680a.setStyle(Paint.Style.FILL);
        this.f7680a.setStrokeWidth(this.f7693n);
        canvas.drawPath(this.f7681b, this.f7680a);
        if (this.G != null) {
            this.f7680a.setShader(null);
        }
        this.f7680a.setColor(this.f7683d);
        this.f7680a.setStyle(Paint.Style.STROKE);
        this.f7680a.setStrokeWidth(this.f7693n);
        canvas.drawPath(this.f7681b, this.f7680a);
        this.E.reset();
        this.E.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f7681b.transform(this.E);
        this.f7680a.set(this.M);
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        this.f7705z = false;
        this.f7697r = getPaddingLeft();
        this.f7698s = getPaddingRight();
        this.f7699t = getPaddingTop();
        this.f7700u = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f7680a;
            String str = this.f7694o;
            textPaint.getTextBounds(str, 0, str.length(), this.f7696q);
            if (mode != 1073741824) {
                size = (int) (this.f7696q.width() + 0.99999f);
            }
            size += this.f7697r + this.f7698s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.f7680a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f7699t + this.f7700u + fontMetricsInt;
            }
        } else if (this.f7704y != 0) {
            this.f7705z = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i11) {
        if ((i11 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
            i11 |= GravityCompat.START;
        }
        if ((i11 & 112) == 0) {
            i11 |= 48;
        }
        if (i11 != this.f7703x) {
            invalidate();
        }
        this.f7703x = i11;
        int i12 = i11 & 112;
        if (i12 == 48) {
            this.L = -1.0f;
        } else if (i12 != 80) {
            this.L = 0.0f;
        } else {
            this.L = 1.0f;
        }
        int i13 = i11 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i13 != 3) {
            if (i13 != 5) {
                if (i13 != 8388611) {
                    if (i13 != 8388613) {
                        this.K = 0.0f;
                        return;
                    }
                }
            }
            this.K = 1.0f;
            return;
        }
        this.K = -1.0f;
    }

    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7686g = f11;
            float f12 = this.f7685f;
            this.f7685f = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z10 = this.f7686g != f11;
        this.f7686g = f11;
        if (f11 != 0.0f) {
            if (this.f7681b == null) {
                this.f7681b = new Path();
            }
            if (this.f7688i == null) {
                this.f7688i = new RectF();
            }
            if (this.f7687h == null) {
                b bVar = new b();
                this.f7687h = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f7688i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f7681b.reset();
            Path path = this.f7681b;
            RectF rectF = this.f7688i;
            float f13 = this.f7686g;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f11) {
        boolean z10 = this.f7685f != f11;
        this.f7685f = f11;
        if (f11 != 0.0f) {
            if (this.f7681b == null) {
                this.f7681b = new Path();
            }
            if (this.f7688i == null) {
                this.f7688i = new RectF();
            }
            if (this.f7687h == null) {
                a aVar = new a();
                this.f7687h = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f7685f) / 2.0f;
            this.f7688i.set(0.0f, 0.0f, width, height);
            this.f7681b.reset();
            this.f7681b.addRoundRect(this.f7688i, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f11) {
        this.f7690k = f11;
    }

    public void setText(CharSequence charSequence) {
        this.f7694o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f11) {
        this.R = f11;
        k();
        invalidate();
    }

    public void setTextBackgroundPanY(float f11) {
        this.S = f11;
        k();
        invalidate();
    }

    public void setTextBackgroundRotate(float f11) {
        this.U = f11;
        k();
        invalidate();
    }

    public void setTextBackgroundZoom(float f11) {
        this.T = f11;
        k();
        invalidate();
    }

    public void setTextFillColor(int i11) {
        this.f7682c = i11;
        invalidate();
    }

    public void setTextOutlineColor(int i11) {
        this.f7683d = i11;
        this.f7684e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f11) {
        this.f7693n = f11;
        this.f7684e = true;
        if (Float.isNaN(f11)) {
            this.f7693n = 1.0f;
            this.f7684e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f11) {
        this.K = f11;
        invalidate();
    }

    public void setTextPanY(float f11) {
        this.L = f11;
        invalidate();
    }

    public void setTextSize(float f11) {
        this.f7689j = f11;
        Log.v(V, androidx.constraintlayout.motion.widget.a.a() + "  " + f11 + " / " + this.f7690k);
        TextPaint textPaint = this.f7680a;
        if (!Float.isNaN(this.f7690k)) {
            f11 = this.f7690k;
        }
        textPaint.setTextSize(f11);
        e(Float.isNaN(this.f7690k) ? 1.0f : this.f7689j / this.f7690k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f11) {
        this.I = f11;
        k();
        invalidate();
    }

    public void setTextureWidth(float f11) {
        this.J = f11;
        k();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.f7680a.getTypeface() != typeface) {
            this.f7680a.setTypeface(typeface);
            if (this.f7702w != null) {
                this.f7702w = null;
                requestLayout();
                invalidate();
            }
        }
    }
}
