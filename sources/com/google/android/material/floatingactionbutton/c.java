package com.google.android.material.floatingactionbutton;

import ab.n;
import ab.o;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    private final Paint f29043b;

    /* renamed from: h, reason: collision with root package name */
    float f29049h;

    /* renamed from: i, reason: collision with root package name */
    private int f29050i;

    /* renamed from: j, reason: collision with root package name */
    private int f29051j;

    /* renamed from: k, reason: collision with root package name */
    private int f29052k;

    /* renamed from: l, reason: collision with root package name */
    private int f29053l;

    /* renamed from: m, reason: collision with root package name */
    private int f29054m;

    /* renamed from: o, reason: collision with root package name */
    private n f29056o;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f29057p;

    /* renamed from: a, reason: collision with root package name */
    private final o f29042a = o.k();

    /* renamed from: c, reason: collision with root package name */
    private final Path f29044c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final Rect f29045d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private final RectF f29046e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    private final RectF f29047f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final b f29048g = new b();

    /* renamed from: n, reason: collision with root package name */
    private boolean f29055n = true;

    /* loaded from: classes4.dex */
    private class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return c.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(n nVar) {
        this.f29056o = nVar;
        Paint paint = new Paint(1);
        this.f29043b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        copyBounds(this.f29045d);
        float height = this.f29049h / r1.height();
        return new LinearGradient(0.0f, r1.top, 0.0f, r1.bottom, new int[]{z0.b.k(this.f29050i, this.f29054m), z0.b.k(this.f29051j, this.f29054m), z0.b.k(z0.b.p(this.f29051j, 0), this.f29054m), z0.b.k(z0.b.p(this.f29053l, 0), this.f29054m), z0.b.k(this.f29053l, this.f29054m), z0.b.k(this.f29052k, this.f29054m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    protected RectF b() {
        this.f29047f.set(getBounds());
        return this.f29047f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f29054m = colorStateList.getColorForState(getState(), this.f29054m);
        }
        this.f29057p = colorStateList;
        this.f29055n = true;
        invalidateSelf();
    }

    public void d(float f11) {
        if (this.f29049h != f11) {
            this.f29049h = f11;
            this.f29043b.setStrokeWidth(f11 * 1.3333f);
            this.f29055n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f29055n) {
            this.f29043b.setShader(a());
            this.f29055n = false;
        }
        float strokeWidth = this.f29043b.getStrokeWidth() / 2.0f;
        copyBounds(this.f29045d);
        this.f29046e.set(this.f29045d);
        float min = Math.min(this.f29056o.r().a(b()), this.f29046e.width() / 2.0f);
        if (this.f29056o.u(b())) {
            this.f29046e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f29046e, min, min, this.f29043b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i11, int i12, int i13, int i14) {
        this.f29050i = i11;
        this.f29051j = i12;
        this.f29052k = i13;
        this.f29053l = i14;
    }

    public void f(n nVar) {
        this.f29056o = nVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f29048g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f29049h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f29056o.u(b())) {
            outline.setRoundRect(getBounds(), this.f29056o.r().a(b()));
        } else {
            copyBounds(this.f29045d);
            this.f29046e.set(this.f29045d);
            this.f29042a.e(this.f29056o, 1.0f, this.f29046e, this.f29044c);
            com.google.android.material.drawable.d.l(outline, this.f29044c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.f29056o.u(b())) {
            return true;
        }
        int round = Math.round(this.f29049h);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f29057p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f29055n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f29057p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f29054m)) != this.f29054m) {
            this.f29055n = true;
            this.f29054m = colorForState;
        }
        if (this.f29055n) {
            invalidateSelf();
        }
        return this.f29055n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f29043b.setAlpha(i11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f29043b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
