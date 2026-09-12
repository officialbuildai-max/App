package com.avery.subtitle.widget;

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

/* loaded from: classes2.dex */
public class BgBubbleDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private RectF f19966a;

    /* renamed from: b, reason: collision with root package name */
    private Path f19967b;

    /* renamed from: c, reason: collision with root package name */
    private Path f19968c;

    /* renamed from: d, reason: collision with root package name */
    private BitmapShader f19969d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f19970e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f19971f;

    /* renamed from: g, reason: collision with root package name */
    private float f19972g;

    /* renamed from: h, reason: collision with root package name */
    private int f19973h;

    /* renamed from: i, reason: collision with root package name */
    private float f19974i;

    /* renamed from: j, reason: collision with root package name */
    private float f19975j;

    /* renamed from: k, reason: collision with root package name */
    private float f19976k;

    /* renamed from: l, reason: collision with root package name */
    private float f19977l;

    /* renamed from: m, reason: collision with root package name */
    private float f19978m;

    /* renamed from: n, reason: collision with root package name */
    private float f19979n;

    /* renamed from: o, reason: collision with root package name */
    private int f19980o;

    /* renamed from: p, reason: collision with root package name */
    private Bitmap f19981p;

    /* renamed from: q, reason: collision with root package name */
    private ArrowLocation f19982q;

    /* renamed from: r, reason: collision with root package name */
    private BubbleType f19983r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f19984s;

    /* renamed from: t, reason: collision with root package name */
    private int f19985t;

    /* renamed from: u, reason: collision with root package name */
    float f19986u;

    /* renamed from: v, reason: collision with root package name */
    float f19987v;

    /* renamed from: w, reason: collision with root package name */
    float f19988w;

    /* renamed from: x, reason: collision with root package name */
    float f19989x;

    /* renamed from: y, reason: collision with root package name */
    int[] f19990y;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public enum BubbleType {
        COLOR,
        BITMAP,
        SHADER
    }

    /* loaded from: classes2.dex */
    public enum GradientDirection {
        HORIZONTAL(1),
        VERTICAL(0);

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
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19991a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f19992b;

        static {
            int[] iArr = new int[BubbleType.values().length];
            f19992b = iArr;
            try {
                iArr[BubbleType.SHADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19992b[BubbleType.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19992b[BubbleType.BITMAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ArrowLocation.values().length];
            f19991a = iArr2;
            try {
                iArr2[ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19991a[ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19991a[ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19991a[ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19991a[ArrowLocation.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static float A = 0.0f;
        public static int B = -1291845632;
        public static float C = 0.0f;

        /* renamed from: u, reason: collision with root package name */
        public static float f19993u = 25.0f;

        /* renamed from: v, reason: collision with root package name */
        public static float f19994v = 25.0f;

        /* renamed from: w, reason: collision with root package name */
        public static float f19995w = 20.0f;

        /* renamed from: x, reason: collision with root package name */
        public static float f19996x = 50.0f;

        /* renamed from: y, reason: collision with root package name */
        public static int f19997y = -65536;

        /* renamed from: z, reason: collision with root package name */
        public static int f19998z = 255;

        /* renamed from: a, reason: collision with root package name */
        private RectF f19999a;

        /* renamed from: b, reason: collision with root package name */
        private float f20000b = A;

        /* renamed from: c, reason: collision with root package name */
        private int f20001c = B;

        /* renamed from: d, reason: collision with root package name */
        private float f20002d;

        /* renamed from: e, reason: collision with root package name */
        private float f20003e;

        /* renamed from: f, reason: collision with root package name */
        private float f20004f;

        /* renamed from: g, reason: collision with root package name */
        private float f20005g;

        /* renamed from: h, reason: collision with root package name */
        private float f20006h;

        /* renamed from: i, reason: collision with root package name */
        private float f20007i;

        /* renamed from: j, reason: collision with root package name */
        private int f20008j;

        /* renamed from: k, reason: collision with root package name */
        private int f20009k;

        /* renamed from: l, reason: collision with root package name */
        private Bitmap f20010l;

        /* renamed from: m, reason: collision with root package name */
        private BubbleType f20011m;

        /* renamed from: n, reason: collision with root package name */
        private ArrowLocation f20012n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f20013o;

        /* renamed from: p, reason: collision with root package name */
        float f20014p;

        /* renamed from: q, reason: collision with root package name */
        float f20015q;

        /* renamed from: r, reason: collision with root package name */
        float f20016r;

        /* renamed from: s, reason: collision with root package name */
        float f20017s;

        /* renamed from: t, reason: collision with root package name */
        int[] f20018t;

        public b() {
            float f11 = C;
            this.f20002d = f11;
            this.f20003e = f11;
            this.f20004f = f19993u;
            this.f20005g = f19995w;
            this.f20006h = f19994v;
            this.f20007i = f19996x;
            this.f20008j = f19997y;
            this.f20009k = f19998z;
            this.f20011m = BubbleType.COLOR;
            this.f20012n = ArrowLocation.LEFT;
        }

        public b p(float f11) {
            this.f20005g = f11 * 2.0f;
            return this;
        }

        public b q(ArrowLocation arrowLocation) {
            this.f20012n = arrowLocation;
            return this;
        }

        public b r(int i11) {
            this.f20008j = i11;
            s(BubbleType.COLOR);
            return this;
        }

        public b s(BubbleType bubbleType) {
            this.f20011m = bubbleType;
            return this;
        }

        public BgBubbleDrawable t() {
            if (this.f19999a != null) {
                return new BgBubbleDrawable(this);
            }
            throw new IllegalArgumentException("BubbleDrawable Rect can not be null");
        }

        public b u(RectF rectF) {
            this.f19999a = rectF;
            return this;
        }
    }

    private BgBubbleDrawable(b bVar) {
        this.f19967b = new Path();
        this.f19968c = new Path();
        this.f19970e = new Paint(1);
        this.f19971f = new Paint();
        this.f19985t = 255;
        this.f19972g = bVar.f20000b;
        this.f19973h = bVar.f20001c;
        this.f19974i = bVar.f20002d;
        this.f19975j = bVar.f20003e;
        this.f19966a = bVar.f19999a;
        this.f19977l = bVar.f20005g;
        this.f19985t = bVar.f20009k;
        this.f19978m = bVar.f20006h;
        this.f19976k = bVar.f20004f;
        this.f19979n = bVar.f20007i;
        this.f19980o = bVar.f20008j;
        this.f19981p = bVar.f20010l;
        this.f19982q = bVar.f20012n;
        this.f19983r = bVar.f20011m;
        this.f19984s = bVar.f20013o;
        this.f19986u = bVar.f20014p;
        this.f19987v = bVar.f20015q;
        this.f19988w = bVar.f20016r;
        this.f19989x = bVar.f20017s;
        this.f19990y = bVar.f20018t;
    }

    private void a(Canvas canvas) {
        int i11 = a.f19992b[this.f19983r.ordinal()];
        if (i11 == 1) {
            this.f19970e.setShader(new LinearGradient(this.f19986u, this.f19987v, this.f19988w, this.f19989x, this.f19990y, (float[]) null, Shader.TileMode.CLAMP));
        } else if (i11 == 2) {
            this.f19970e.setColor(this.f19980o);
        } else if (i11 == 3) {
            if (this.f19981p == null) {
                return;
            }
            if (this.f19969d == null) {
                Bitmap bitmap = this.f19981p;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f19969d = new BitmapShader(bitmap, tileMode, tileMode);
            }
            this.f19970e.setShader(this.f19969d);
            g();
        }
        e(this.f19982q, this.f19967b);
        this.f19970e.setAlpha(Math.abs(this.f19985t));
        if (this.f19972g > 0.0f) {
            this.f19971f.setColor(0);
            this.f19971f.setAlpha(Math.abs(this.f19985t));
            this.f19971f.setAntiAlias(true);
            this.f19971f.setShadowLayer(this.f19972g, this.f19974i, this.f19975j, this.f19973h);
            this.f19971f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
            canvas.drawPath(this.f19967b, this.f19971f);
        }
        canvas.drawPath(this.f19967b, this.f19970e);
    }

    private void b(RectF rectF, Path path) {
        if (this.f19984s) {
            this.f19979n = ((rectF.right - rectF.left) / 2.0f) - (this.f19976k / 2.0f);
        }
        path.moveTo(rectF.left + this.f19977l, rectF.top);
        path.lineTo(rectF.width() - this.f19977l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f19977l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, (rectF.bottom - this.f19978m) - this.f19977l);
        float f14 = rectF.right;
        float f15 = this.f19977l;
        float f16 = rectF.bottom;
        float f17 = this.f19978m;
        path.arcTo(new RectF(f14 - f15, (f16 - f15) - f17, f14, f16 - f17), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f19976k + this.f19979n, rectF.bottom - this.f19978m);
        path.lineTo(rectF.left + this.f19979n + (this.f19976k / 2.0f), rectF.bottom);
        path.lineTo(rectF.left + this.f19979n, rectF.bottom - this.f19978m);
        path.lineTo(rectF.left + Math.min(this.f19977l, this.f19979n), rectF.bottom - this.f19978m);
        float f18 = rectF.left;
        float f19 = rectF.bottom;
        float f20 = this.f19977l;
        float f21 = this.f19978m;
        path.arcTo(new RectF(f18, (f19 - f20) - f21, f20 + f18, f19 - f21), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f19977l);
        float f22 = rectF.left;
        float f23 = rectF.top;
        float f24 = this.f19977l;
        path.arcTo(new RectF(f22, f23, f24 + f22, f24 + f23), 180.0f, 90.0f);
        path.close();
    }

    private void c(RectF rectF, Path path) {
        if (this.f19984s) {
            this.f19979n = ((rectF.bottom - rectF.top) / 2.0f) - (this.f19976k / 2.0f);
        }
        path.moveTo(this.f19976k + rectF.left + this.f19977l, rectF.top);
        path.lineTo(rectF.width() - this.f19977l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f19977l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f19977l);
        float f14 = rectF.right;
        float f15 = this.f19977l;
        float f16 = rectF.bottom;
        path.arcTo(new RectF(f14 - f15, f16 - f15, f14, f16), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f19976k + this.f19977l, rectF.bottom);
        float f17 = rectF.left;
        float f18 = this.f19976k;
        float f19 = rectF.bottom;
        float f20 = this.f19977l;
        path.arcTo(new RectF(f17 + f18, f19 - f20, f20 + f17 + f18, f19), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.f19976k, this.f19978m + this.f19979n);
        path.lineTo(rectF.left, this.f19979n + (this.f19978m / 2.0f));
        path.lineTo(rectF.left + this.f19976k, this.f19979n);
        path.lineTo(rectF.left + this.f19976k, rectF.top + this.f19977l);
        float f21 = rectF.left;
        float f22 = this.f19976k;
        float f23 = rectF.top;
        float f24 = this.f19977l;
        path.arcTo(new RectF(f21 + f22, f23, f21 + f24 + f22, f24 + f23), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path) {
        if (this.f19984s) {
            this.f19979n = ((rectF.right - rectF.left) / 2.0f) - (this.f19976k / 2.0f);
        }
        path.moveTo(rectF.left + this.f19977l, rectF.top);
        path.lineTo(rectF.width() - this.f19977l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f19977l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f19977l);
        float f14 = rectF.right;
        float f15 = this.f19977l;
        float f16 = rectF.bottom;
        path.arcTo(new RectF(f14 - f15, f16 - f15, f14, f16), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f19977l, rectF.bottom);
        float f17 = rectF.left;
        float f18 = rectF.bottom;
        float f19 = this.f19977l;
        path.arcTo(new RectF(f17, f18 - f19, f19 + f17, f18), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f19977l);
        float f20 = rectF.left;
        float f21 = rectF.top;
        float f22 = this.f19977l;
        path.arcTo(new RectF(f20, f21, f22 + f20, f22 + f21), 180.0f, 90.0f);
        path.close();
    }

    private void e(ArrowLocation arrowLocation, Path path) {
        int i11 = a.f19991a[arrowLocation.ordinal()];
        if (i11 == 1) {
            c(this.f19966a, path);
            return;
        }
        if (i11 == 2) {
            f(this.f19966a, path);
            return;
        }
        if (i11 == 3) {
            h(this.f19966a, path);
        } else if (i11 == 4) {
            b(this.f19966a, path);
        } else {
            if (i11 != 5) {
                return;
            }
            d(this.f19966a, path);
        }
    }

    private void f(RectF rectF, Path path) {
        if (this.f19984s) {
            this.f19979n = ((rectF.bottom - rectF.top) / 2.0f) - (this.f19976k / 2.0f);
        }
        path.moveTo(rectF.left + this.f19977l, rectF.top);
        path.lineTo((rectF.width() - this.f19977l) - this.f19976k, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f19977l;
        float f13 = this.f19976k;
        float f14 = rectF.top;
        path.arcTo(new RectF((f11 - f12) - f13, f14, f11 - f13, f12 + f14), 270.0f, 90.0f);
        path.lineTo(rectF.right - this.f19976k, this.f19979n);
        path.lineTo(rectF.right, this.f19979n + (this.f19978m / 2.0f));
        path.lineTo(rectF.right - this.f19976k, this.f19979n + this.f19978m);
        path.lineTo(rectF.right - this.f19976k, rectF.bottom - this.f19977l);
        float f15 = rectF.right;
        float f16 = this.f19977l;
        float f17 = this.f19976k;
        float f18 = rectF.bottom;
        path.arcTo(new RectF((f15 - f16) - f17, f18 - f16, f15 - f17, f18), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f19976k, rectF.bottom);
        float f19 = rectF.left;
        float f20 = rectF.bottom;
        float f21 = this.f19977l;
        path.arcTo(new RectF(f19, f20 - f21, f21 + f19, f20), 90.0f, 90.0f);
        float f22 = rectF.left;
        float f23 = rectF.top;
        float f24 = this.f19977l;
        path.arcTo(new RectF(f22, f23, f24 + f22, f24 + f23), 180.0f, 90.0f);
        path.close();
    }

    private void g() {
        Matrix matrix = new Matrix();
        matrix.set(null);
        matrix.postScale(getIntrinsicWidth() / this.f19981p.getWidth(), getIntrinsicHeight() / this.f19981p.getHeight());
        RectF rectF = this.f19966a;
        matrix.postTranslate(rectF.left, rectF.top);
        this.f19969d.setLocalMatrix(matrix);
    }

    private void h(RectF rectF, Path path) {
        if (this.f19984s) {
            this.f19979n = ((rectF.right - rectF.left) / 2.0f) - (this.f19976k / 2.0f);
        }
        path.moveTo(rectF.left + Math.min(this.f19979n, this.f19977l), rectF.top + this.f19978m);
        path.lineTo(rectF.left + this.f19979n, rectF.top + this.f19978m);
        path.lineTo(rectF.left + (this.f19976k / 2.0f) + this.f19979n, rectF.top);
        path.lineTo(rectF.left + this.f19976k + this.f19979n, rectF.top + this.f19978m);
        path.lineTo(rectF.right - this.f19977l, rectF.top + this.f19978m);
        float f11 = rectF.right;
        float f12 = this.f19977l;
        float f13 = rectF.top;
        float f14 = this.f19978m;
        path.arcTo(new RectF(f11 - f12, f13 + f14, f11, f12 + f13 + f14), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f19977l);
        float f15 = rectF.right;
        float f16 = this.f19977l;
        float f17 = rectF.bottom;
        path.arcTo(new RectF(f15 - f16, f17 - f16, f15, f17), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f19977l, rectF.bottom);
        float f18 = rectF.left;
        float f19 = rectF.bottom;
        float f20 = this.f19977l;
        path.arcTo(new RectF(f18, f19 - f20, f20 + f18, f19), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f19978m + this.f19977l);
        float f21 = rectF.left;
        float f22 = rectF.top;
        float f23 = this.f19978m;
        float f24 = this.f19977l;
        path.arcTo(new RectF(f21, f22 + f23, f24 + f21, f24 + f22 + f23), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f19966a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f19966a.width();
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
        this.f19985t = i11;
        this.f19970e.setAlpha(i11);
        this.f19971f.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f19970e.setColorFilter(colorFilter);
        this.f19971f.setColorFilter(colorFilter);
    }
}
