package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f2302a;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f2304c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f2305d;

    /* renamed from: e, reason: collision with root package name */
    private float f2306e;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f2309h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f2310i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f2311j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2307f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2308g = true;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f2312k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f2303b = new Paint(5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ColorStateList colorStateList, float f11) {
        this.f2302a = f11;
        e(colorStateList);
        this.f2304c = new RectF();
        this.f2305d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2309h = colorStateList;
        this.f2303b.setColor(colorStateList.getColorForState(getState(), this.f2309h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2304c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f2305d.set(rect);
        if (this.f2307f) {
            this.f2305d.inset((int) Math.ceil(e.a(this.f2306e, this.f2302a, this.f2308g)), (int) Math.ceil(e.b(this.f2306e, this.f2302a, this.f2308g)));
            this.f2304c.set(this.f2305d);
        }
    }

    public ColorStateList b() {
        return this.f2309h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f2306e;
    }

    public float d() {
        return this.f2302a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f2303b;
        if (this.f2310i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f2310i);
            z10 = true;
        }
        RectF rectF = this.f2304c;
        float f11 = this.f2302a;
        canvas.drawRoundRect(rectF, f11, f11, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f11, boolean z10, boolean z11) {
        if (f11 == this.f2306e && this.f2307f == z10 && this.f2308g == z11) {
            return;
        }
        this.f2306e = f11;
        this.f2307f = z10;
        this.f2308g = z11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2305d, this.f2302a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f11) {
        if (f11 == this.f2302a) {
            return;
        }
        this.f2302a = f11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f2311j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f2309h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f2309h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f2303b.getColor();
        if (z10) {
            this.f2303b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f2311j;
        if (colorStateList2 == null || (mode = this.f2312k) == null) {
            return z10;
        }
        this.f2310i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f2303b.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2303b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2311j = colorStateList;
        this.f2310i = a(colorStateList, this.f2312k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2312k = mode;
        this.f2310i = a(this.f2311j, mode);
        invalidateSelf();
    }
}
