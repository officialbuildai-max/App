package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class c extends Drawable {

    /* renamed from: m, reason: collision with root package name */
    private static final float f1318m = (float) Math.toRadians(45.0d);

    /* renamed from: a, reason: collision with root package name */
    private final Paint f1319a;

    /* renamed from: b, reason: collision with root package name */
    private float f1320b;

    /* renamed from: c, reason: collision with root package name */
    private float f1321c;

    /* renamed from: d, reason: collision with root package name */
    private float f1322d;

    /* renamed from: e, reason: collision with root package name */
    private float f1323e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1324f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f1325g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1326h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1327i;

    /* renamed from: j, reason: collision with root package name */
    private float f1328j;

    /* renamed from: k, reason: collision with root package name */
    private float f1329k;

    /* renamed from: l, reason: collision with root package name */
    private int f1330l;

    public c(Context context) {
        Paint paint = new Paint();
        this.f1319a = paint;
        this.f1325g = new Path();
        this.f1327i = false;
        this.f1330l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R$styleable.DrawerArrowToggle, R$attr.drawerArrowStyle, R$style.Base_Widget_AppCompat_DrawerArrowToggle);
        c(obtainStyledAttributes.getColor(R$styleable.DrawerArrowToggle_color, 0));
        b(obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_thickness, 0.0f));
        e(obtainStyledAttributes.getBoolean(R$styleable.DrawerArrowToggle_spinBars, true));
        d(Math.round(obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f1326h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DrawerArrowToggle_drawableSize, 0);
        this.f1321c = Math.round(obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f1320b = Math.round(obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f1322d = obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float a(float f11, float f12, float f13) {
        return f11 + ((f12 - f11) * f13);
    }

    public void b(float f11) {
        if (this.f1319a.getStrokeWidth() != f11) {
            this.f1319a.setStrokeWidth(f11);
            this.f1329k = (float) ((f11 / 2.0f) * Math.cos(f1318m));
            invalidateSelf();
        }
    }

    public void c(int i11) {
        if (i11 != this.f1319a.getColor()) {
            this.f1319a.setColor(i11);
            invalidateSelf();
        }
    }

    public void d(float f11) {
        if (f11 != this.f1323e) {
            this.f1323e = f11;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i11 = this.f1330l;
        boolean z10 = false;
        if (i11 != 0 && (i11 == 1 || (i11 == 3 ? a1.a.f(this) == 0 : a1.a.f(this) == 1))) {
            z10 = true;
        }
        float f11 = this.f1320b;
        float a11 = a(this.f1321c, (float) Math.sqrt(f11 * f11 * 2.0f), this.f1328j);
        float a12 = a(this.f1321c, this.f1322d, this.f1328j);
        float round = Math.round(a(0.0f, this.f1329k, this.f1328j));
        float a13 = a(0.0f, f1318m, this.f1328j);
        float a14 = a(z10 ? 0.0f : -180.0f, z10 ? 180.0f : 0.0f, this.f1328j);
        double d11 = a11;
        double d12 = a13;
        boolean z11 = z10;
        float round2 = (float) Math.round(Math.cos(d12) * d11);
        float round3 = (float) Math.round(d11 * Math.sin(d12));
        this.f1325g.rewind();
        float a15 = a(this.f1323e + this.f1319a.getStrokeWidth(), -this.f1329k, this.f1328j);
        float f12 = (-a12) / 2.0f;
        this.f1325g.moveTo(f12 + round, 0.0f);
        this.f1325g.rLineTo(a12 - (round * 2.0f), 0.0f);
        this.f1325g.moveTo(f12, a15);
        this.f1325g.rLineTo(round2, round3);
        this.f1325g.moveTo(f12, -a15);
        this.f1325g.rLineTo(round2, -round3);
        this.f1325g.close();
        canvas.save();
        float strokeWidth = this.f1319a.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.f1323e);
        if (this.f1324f) {
            canvas.rotate(a14 * (this.f1327i ^ z11 ? -1 : 1));
        } else if (z11) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f1325g, this.f1319a);
        canvas.restore();
    }

    public void e(boolean z10) {
        if (this.f1324f != z10) {
            this.f1324f = z10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1326h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1326h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        if (i11 != this.f1319a.getAlpha()) {
            this.f1319a.setAlpha(i11);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1319a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f11) {
        if (this.f1328j != f11) {
            this.f1328j = f11;
            invalidateSelf();
        }
    }
}
