package com.tn.lib.view.bubbleview;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public class BubbleDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private RectF f41168a;

    /* renamed from: b, reason: collision with root package name */
    private Path f41169b;

    /* renamed from: c, reason: collision with root package name */
    private Path f41170c;

    /* renamed from: d, reason: collision with root package name */
    private BitmapShader f41171d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f41172e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f41173f;

    /* renamed from: g, reason: collision with root package name */
    private float f41174g;

    /* renamed from: h, reason: collision with root package name */
    private int f41175h;

    /* renamed from: i, reason: collision with root package name */
    private float f41176i;

    /* renamed from: j, reason: collision with root package name */
    private float f41177j;

    /* renamed from: k, reason: collision with root package name */
    private float f41178k;

    /* renamed from: l, reason: collision with root package name */
    private float f41179l;

    /* renamed from: m, reason: collision with root package name */
    private float f41180m;

    /* renamed from: n, reason: collision with root package name */
    private float f41181n;

    /* renamed from: o, reason: collision with root package name */
    private int f41182o;

    /* renamed from: p, reason: collision with root package name */
    private Bitmap f41183p;

    /* renamed from: q, reason: collision with root package name */
    private ArrowLocation f41184q;

    /* renamed from: r, reason: collision with root package name */
    private BubbleType f41185r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f41186s;

    /* renamed from: t, reason: collision with root package name */
    private int f41187t;

    /* renamed from: u, reason: collision with root package name */
    float f41188u;

    /* renamed from: v, reason: collision with root package name */
    float f41189v;

    /* renamed from: w, reason: collision with root package name */
    float f41190w;

    /* renamed from: x, reason: collision with root package name */
    float f41191x;

    /* renamed from: y, reason: collision with root package name */
    int[] f41192y;

    /* loaded from: classes4.dex */
    public enum ArrowLocation {
        LEFT(0),
        RIGHT(1),
        TOP(2),
        BOTTOM(3),
        NONE(4);

        private int mValue;

        ArrowLocation(int i11) {
            this.mValue = i11;
        }

        public static ArrowLocation getDefault() {
            return LEFT;
        }

        public static ArrowLocation mapIntToValue(int i11) {
            for (ArrowLocation arrowLocation : values()) {
                if (i11 == arrowLocation.getIntValue()) {
                    return arrowLocation;
                }
            }
            return getDefault();
        }

        public int getIntValue() {
            return this.mValue;
        }
    }

    /* loaded from: classes4.dex */
    public enum BubbleType {
        COLOR,
        BITMAP,
        SHADER
    }

    /* loaded from: classes4.dex */
    public enum GradientDirection {
        VERTICAL(0),
        HORIZONTAL(1),
        TOP_LEFT_BOTTOM_RIGHT(2),
        TOP_RIGHT_BOTTOM_LEFT(3),
        BOTTOM_LEFT_TOP_RIGHT(4),
        BOTTOM_RIGHT_TOP_LEFT(5);

        private int mValue;

        GradientDirection(int i11) {
            this.mValue = i11;
        }

        public static GradientDirection getDefault() {
            return VERTICAL;
        }

        public static GradientDirection mapIntToValue(int i11) {
            for (GradientDirection gradientDirection : values()) {
                if (i11 == gradientDirection.getIntValue()) {
                    return gradientDirection;
                }
            }
            return getDefault();
        }

        public int getIntValue() {
            return this.mValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f41193a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f41194b;

        static {
            int[] iArr = new int[BubbleType.values().length];
            f41194b = iArr;
            try {
                iArr[BubbleType.SHADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41194b[BubbleType.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41194b[BubbleType.BITMAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ArrowLocation.values().length];
            f41193a = iArr2;
            try {
                iArr2[ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41193a[ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41193a[ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41193a[ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41193a[ArrowLocation.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static float A = 0.0f;
        public static int B = -1291845632;
        public static float C = 0.0f;

        /* renamed from: u, reason: collision with root package name */
        public static float f41195u = 25.0f;

        /* renamed from: v, reason: collision with root package name */
        public static float f41196v = 25.0f;

        /* renamed from: w, reason: collision with root package name */
        public static float f41197w = 20.0f;

        /* renamed from: x, reason: collision with root package name */
        public static float f41198x = 50.0f;

        /* renamed from: y, reason: collision with root package name */
        public static int f41199y = -65536;

        /* renamed from: z, reason: collision with root package name */
        public static int f41200z = 255;

        /* renamed from: a, reason: collision with root package name */
        private RectF f41201a;

        /* renamed from: b, reason: collision with root package name */
        private float f41202b = A;

        /* renamed from: c, reason: collision with root package name */
        private int f41203c = B;

        /* renamed from: d, reason: collision with root package name */
        private float f41204d;

        /* renamed from: e, reason: collision with root package name */
        private float f41205e;

        /* renamed from: f, reason: collision with root package name */
        private float f41206f;

        /* renamed from: g, reason: collision with root package name */
        private float f41207g;

        /* renamed from: h, reason: collision with root package name */
        private float f41208h;

        /* renamed from: i, reason: collision with root package name */
        private float f41209i;

        /* renamed from: j, reason: collision with root package name */
        private int f41210j;

        /* renamed from: k, reason: collision with root package name */
        private int f41211k;

        /* renamed from: l, reason: collision with root package name */
        private Bitmap f41212l;

        /* renamed from: m, reason: collision with root package name */
        private BubbleType f41213m;

        /* renamed from: n, reason: collision with root package name */
        private ArrowLocation f41214n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f41215o;

        /* renamed from: p, reason: collision with root package name */
        float f41216p;

        /* renamed from: q, reason: collision with root package name */
        float f41217q;

        /* renamed from: r, reason: collision with root package name */
        float f41218r;

        /* renamed from: s, reason: collision with root package name */
        float f41219s;

        /* renamed from: t, reason: collision with root package name */
        int[] f41220t;

        public b() {
            float f11 = C;
            this.f41204d = f11;
            this.f41205e = f11;
            this.f41206f = f41195u;
            this.f41207g = f41197w;
            this.f41208h = f41196v;
            this.f41209i = f41198x;
            this.f41210j = f41199y;
            this.f41211k = f41200z;
            this.f41213m = BubbleType.COLOR;
            this.f41214n = ArrowLocation.LEFT;
        }

        public BubbleDrawable A() {
            if (this.f41201a != null) {
                return new BubbleDrawable(this);
            }
            throw new IllegalArgumentException("BubbleDrawable Rect can not be null");
        }

        public b B(RectF rectF) {
            this.f41201a = rectF;
            return this;
        }

        public b C(int i11) {
            this.f41203c = i11;
            return this;
        }

        public b D(float f11) {
            this.f41204d = f11;
            return this;
        }

        public b E(float f11) {
            this.f41205e = f11;
            return this;
        }

        public b F(float f11) {
            this.f41202b = f11;
            return this;
        }

        public b p(int i11) {
            this.f41211k = i11;
            return this;
        }

        public b q(float f11) {
            this.f41207g = f11 * 2.0f;
            return this;
        }

        public b r(boolean z10) {
            this.f41215o = z10;
            return this;
        }

        public b s(float f11) {
            this.f41208h = f11;
            return this;
        }

        public b t(ArrowLocation arrowLocation) {
            this.f41214n = arrowLocation;
            return this;
        }

        public b u(float f11) {
            this.f41209i = f11;
            return this;
        }

        public b v(float f11) {
            this.f41206f = f11;
            return this;
        }

        public b w(Bitmap bitmap) {
            this.f41212l = bitmap;
            z(BubbleType.BITMAP);
            return this;
        }

        public b x(int i11) {
            this.f41210j = i11;
            z(BubbleType.COLOR);
            return this;
        }

        public b y(float f11, float f12, float f13, float f14, int[] iArr) {
            this.f41216p = f11;
            this.f41217q = f12;
            this.f41218r = f13;
            this.f41219s = f14;
            this.f41220t = iArr;
            z(BubbleType.SHADER);
            return this;
        }

        public b z(BubbleType bubbleType) {
            this.f41213m = bubbleType;
            return this;
        }
    }

    private BubbleDrawable(b bVar) {
        this.f41169b = new Path();
        this.f41170c = new Path();
        this.f41172e = new Paint(1);
        this.f41173f = new Paint();
        this.f41187t = 255;
        this.f41174g = bVar.f41202b;
        this.f41175h = bVar.f41203c;
        this.f41176i = bVar.f41204d;
        this.f41177j = bVar.f41205e;
        this.f41168a = bVar.f41201a;
        this.f41179l = bVar.f41207g;
        this.f41187t = bVar.f41211k;
        this.f41180m = bVar.f41208h;
        this.f41178k = bVar.f41206f;
        this.f41181n = bVar.f41209i;
        this.f41182o = bVar.f41210j;
        this.f41183p = bVar.f41212l;
        this.f41184q = bVar.f41214n;
        this.f41185r = bVar.f41213m;
        this.f41186s = bVar.f41215o;
        this.f41188u = bVar.f41216p;
        this.f41189v = bVar.f41217q;
        this.f41190w = bVar.f41218r;
        this.f41191x = bVar.f41219s;
        this.f41192y = bVar.f41220t;
    }

    private void a(Canvas canvas) {
        int i11 = a.f41194b[this.f41185r.ordinal()];
        if (i11 == 1) {
            this.f41172e.setShader(new LinearGradient(this.f41188u, this.f41189v, this.f41190w, this.f41191x, this.f41192y, (float[]) null, Shader.TileMode.CLAMP));
        } else if (i11 == 2) {
            this.f41172e.setColor(this.f41182o);
        } else if (i11 == 3) {
            if (this.f41183p == null) {
                return;
            }
            if (this.f41171d == null) {
                Bitmap bitmap = this.f41183p;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f41171d = new BitmapShader(bitmap, tileMode, tileMode);
            }
            this.f41172e.setShader(this.f41171d);
            g();
        }
        e(this.f41184q, this.f41169b);
        if (this.f41174g > 0.0f) {
            this.f41173f.setColor(0);
            this.f41173f.setAlpha(Math.abs(this.f41187t));
            this.f41173f.setAntiAlias(true);
            this.f41173f.setShadowLayer(this.f41174g, this.f41176i, this.f41177j, this.f41175h);
            this.f41173f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
            canvas.drawPath(this.f41169b, this.f41173f);
        }
        canvas.drawPath(this.f41169b, this.f41172e);
    }

    private void b(RectF rectF, Path path) {
        if (this.f41186s) {
            this.f41181n = ((rectF.right - rectF.left) / 2.0f) - (this.f41178k / 2.0f);
        }
        path.moveTo(rectF.left + this.f41179l, rectF.top);
        path.lineTo(rectF.width() - this.f41179l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f41179l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, (rectF.bottom - this.f41180m) - this.f41179l);
        float f14 = rectF.right;
        float f15 = this.f41179l;
        float f16 = rectF.bottom;
        float f17 = this.f41180m;
        path.arcTo(new RectF(f14 - f15, (f16 - f15) - f17, f14, f16 - f17), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f41178k + this.f41181n, rectF.bottom - this.f41180m);
        path.lineTo(rectF.left + this.f41181n + (this.f41178k / 2.0f), rectF.bottom);
        path.lineTo(rectF.left + this.f41181n, rectF.bottom - this.f41180m);
        path.lineTo(rectF.left + Math.min(this.f41179l, this.f41181n), rectF.bottom - this.f41180m);
        float f18 = rectF.left;
        float f19 = rectF.bottom;
        float f20 = this.f41179l;
        float f21 = this.f41180m;
        path.arcTo(new RectF(f18, (f19 - f20) - f21, f20 + f18, f19 - f21), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f41179l);
        float f22 = rectF.left;
        float f23 = rectF.top;
        float f24 = this.f41179l;
        path.arcTo(new RectF(f22, f23, f24 + f22, f24 + f23), 180.0f, 90.0f);
        path.close();
    }

    private void c(RectF rectF, Path path) {
        if (this.f41186s) {
            this.f41181n = ((rectF.bottom - rectF.top) / 2.0f) - (this.f41178k / 2.0f);
        }
        path.moveTo(this.f41178k + rectF.left + this.f41179l, rectF.top);
        path.lineTo(rectF.width() - this.f41179l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f41179l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f41179l);
        float f14 = rectF.right;
        float f15 = this.f41179l;
        float f16 = rectF.bottom;
        path.arcTo(new RectF(f14 - f15, f16 - f15, f14, f16), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f41178k + this.f41179l, rectF.bottom);
        float f17 = rectF.left;
        float f18 = this.f41178k;
        float f19 = rectF.bottom;
        float f20 = this.f41179l;
        path.arcTo(new RectF(f17 + f18, f19 - f20, f20 + f17 + f18, f19), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.f41178k, this.f41180m + this.f41181n);
        path.lineTo(rectF.left, this.f41181n + (this.f41180m / 2.0f));
        path.lineTo(rectF.left + this.f41178k, this.f41181n);
        path.lineTo(rectF.left + this.f41178k, rectF.top + this.f41179l);
        float f21 = rectF.left;
        float f22 = this.f41178k;
        float f23 = rectF.top;
        float f24 = this.f41179l;
        path.arcTo(new RectF(f21 + f22, f23, f21 + f24 + f22, f24 + f23), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path) {
        if (this.f41186s) {
            this.f41181n = ((rectF.right - rectF.left) / 2.0f) - (this.f41178k / 2.0f);
        }
        path.moveTo(rectF.left + this.f41179l, rectF.top);
        path.lineTo(rectF.width() - this.f41179l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f41179l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f41179l);
        float f14 = rectF.right;
        float f15 = this.f41179l;
        float f16 = rectF.bottom;
        path.arcTo(new RectF(f14 - f15, f16 - f15, f14, f16), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f41179l, rectF.bottom);
        float f17 = rectF.left;
        float f18 = rectF.bottom;
        float f19 = this.f41179l;
        path.arcTo(new RectF(f17, f18 - f19, f19 + f17, f18), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f41179l);
        float f20 = rectF.left;
        float f21 = rectF.top;
        float f22 = this.f41179l;
        path.arcTo(new RectF(f20, f21, f22 + f20, f22 + f21), 180.0f, 90.0f);
        path.close();
    }

    private void e(ArrowLocation arrowLocation, Path path) {
        int i11 = a.f41193a[arrowLocation.ordinal()];
        if (i11 == 1) {
            c(this.f41168a, path);
            return;
        }
        if (i11 == 2) {
            f(this.f41168a, path);
            return;
        }
        if (i11 == 3) {
            h(this.f41168a, path);
        } else if (i11 == 4) {
            b(this.f41168a, path);
        } else {
            if (i11 != 5) {
                return;
            }
            d(this.f41168a, path);
        }
    }

    private void f(RectF rectF, Path path) {
        if (this.f41186s) {
            this.f41181n = ((rectF.bottom - rectF.top) / 2.0f) - (this.f41178k / 2.0f);
        }
        path.moveTo(rectF.left + this.f41179l, rectF.top);
        path.lineTo((rectF.width() - this.f41179l) - this.f41178k, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f41179l;
        float f13 = this.f41178k;
        float f14 = rectF.top;
        path.arcTo(new RectF((f11 - f12) - f13, f14, f11 - f13, f12 + f14), 270.0f, 90.0f);
        path.lineTo(rectF.right - this.f41178k, this.f41181n);
        path.lineTo(rectF.right, this.f41181n + (this.f41180m / 2.0f));
        path.lineTo(rectF.right - this.f41178k, this.f41181n + this.f41180m);
        path.lineTo(rectF.right - this.f41178k, rectF.bottom - this.f41179l);
        float f15 = rectF.right;
        float f16 = this.f41179l;
        float f17 = this.f41178k;
        float f18 = rectF.bottom;
        path.arcTo(new RectF((f15 - f16) - f17, f18 - f16, f15 - f17, f18), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f41178k, rectF.bottom);
        float f19 = rectF.left;
        float f20 = rectF.bottom;
        float f21 = this.f41179l;
        path.arcTo(new RectF(f19, f20 - f21, f21 + f19, f20), 90.0f, 90.0f);
        float f22 = rectF.left;
        float f23 = rectF.top;
        float f24 = this.f41179l;
        path.arcTo(new RectF(f22, f23, f24 + f22, f24 + f23), 180.0f, 90.0f);
        path.close();
    }

    private void g() {
        Matrix matrix = new Matrix();
        matrix.set(null);
        matrix.postScale(getIntrinsicWidth() / this.f41183p.getWidth(), getIntrinsicHeight() / this.f41183p.getHeight());
        RectF rectF = this.f41168a;
        matrix.postTranslate(rectF.left, rectF.top);
        this.f41171d.setLocalMatrix(matrix);
    }

    private void h(RectF rectF, Path path) {
        if (this.f41186s) {
            this.f41181n = ((rectF.right - rectF.left) / 2.0f) - (this.f41178k / 2.0f);
        }
        path.moveTo(rectF.left + Math.min(this.f41181n, this.f41179l), rectF.top + this.f41180m);
        path.lineTo(rectF.left + this.f41181n, rectF.top + this.f41180m);
        path.lineTo(rectF.left + (this.f41178k / 2.0f) + this.f41181n, rectF.top);
        path.lineTo(rectF.left + this.f41178k + this.f41181n, rectF.top + this.f41180m);
        path.lineTo(rectF.right - this.f41179l, rectF.top + this.f41180m);
        float f11 = rectF.right;
        float f12 = this.f41179l;
        float f13 = rectF.top;
        float f14 = this.f41180m;
        path.arcTo(new RectF(f11 - f12, f13 + f14, f11, f12 + f13 + f14), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f41179l);
        float f15 = rectF.right;
        float f16 = this.f41179l;
        float f17 = rectF.bottom;
        path.arcTo(new RectF(f15 - f16, f17 - f16, f15, f17), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f41179l, rectF.bottom);
        float f18 = rectF.left;
        float f19 = rectF.bottom;
        float f20 = this.f41179l;
        path.arcTo(new RectF(f18, f19 - f20, f20 + f18, f19), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f41180m + this.f41179l);
        float f21 = rectF.left;
        float f22 = rectF.top;
        float f23 = this.f41180m;
        float f24 = this.f41179l;
        path.arcTo(new RectF(f21, f22 + f23, f24 + f21, f24 + f22 + f23), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f41168a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f41168a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f41187t = i11;
        this.f41172e.setAlpha(i11);
        this.f41173f.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f41172e.setColorFilter(colorFilter);
        this.f41173f.setColorFilter(colorFilter);
    }
}
