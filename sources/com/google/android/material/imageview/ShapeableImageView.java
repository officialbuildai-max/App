package com.google.android.material.imageview;

import ab.i;
import ab.n;
import ab.o;
import ab.q;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R$style;

/* loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements q {

    /* renamed from: v, reason: collision with root package name */
    private static final int f29113v = R$style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: d, reason: collision with root package name */
    private final o f29114d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f29115e;

    /* renamed from: f, reason: collision with root package name */
    private final RectF f29116f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f29117g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f29118h;

    /* renamed from: i, reason: collision with root package name */
    private final Path f29119i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f29120j;

    /* renamed from: k, reason: collision with root package name */
    private i f29121k;

    /* renamed from: l, reason: collision with root package name */
    private n f29122l;

    /* renamed from: m, reason: collision with root package name */
    private float f29123m;

    /* renamed from: n, reason: collision with root package name */
    private Path f29124n;

    /* renamed from: o, reason: collision with root package name */
    private int f29125o;

    /* renamed from: p, reason: collision with root package name */
    private int f29126p;

    /* renamed from: q, reason: collision with root package name */
    private int f29127q;

    /* renamed from: r, reason: collision with root package name */
    private int f29128r;

    /* renamed from: s, reason: collision with root package name */
    private int f29129s;

    /* renamed from: t, reason: collision with root package name */
    private int f29130t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f29131u;

    /* loaded from: classes4.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f29132a = new Rect();

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f29122l == null) {
                return;
            }
            if (ShapeableImageView.this.f29121k == null) {
                ShapeableImageView.this.f29121k = new i(ShapeableImageView.this.f29122l);
            }
            ShapeableImageView.this.f29115e.round(this.f29132a);
            ShapeableImageView.this.f29121k.setBounds(this.f29132a);
            ShapeableImageView.this.f29121k.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ShapeableImageView(android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = com.google.android.material.imageview.ShapeableImageView.f29113v
            android.content.Context r7 = bb.a.c(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            ab.o r7 = ab.o.k()
            r6.f29114d = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.f29119i = r7
            r7 = 0
            r6.f29131u = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.f29118h = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f29115e = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f29116f = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.f29124n = r2
            int[] r2 = com.google.android.material.R$styleable.ShapeableImageView
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            r4 = 2
            r5 = 0
            r6.setLayerType(r4, r5)
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_strokeColor
            android.content.res.ColorStateList r4 = xa.c.a(r1, r2, r4)
            r6.f29120j = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_strokeWidth
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.f29123m = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPadding
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f29125o = r7
            r6.f29126p = r7
            r6.f29127q = r7
            r6.f29128r = r7
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingLeft
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f29125o = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingTop
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f29126p = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingRight
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f29127q = r4
            int r4 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingBottom
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f29128r = r7
            int r7 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingStart
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f29129s = r7
            int r7 = com.google.android.material.R$styleable.ShapeableImageView_contentPaddingEnd
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f29130t = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.f29117g = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            ab.n$b r7 = ab.n.e(r1, r8, r9, r0)
            ab.n r7 = r7.m()
            r6.f29122l = r7
            com.google.android.material.imageview.ShapeableImageView$a r7 = new com.google.android.material.imageview.ShapeableImageView$a
            r7.<init>()
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void e(Canvas canvas) {
        if (this.f29120j == null) {
            return;
        }
        this.f29117g.setStrokeWidth(this.f29123m);
        int colorForState = this.f29120j.getColorForState(getDrawableState(), this.f29120j.getDefaultColor());
        if (this.f29123m <= 0.0f || colorForState == 0) {
            return;
        }
        this.f29117g.setColor(colorForState);
        canvas.drawPath(this.f29119i, this.f29117g);
    }

    private boolean f() {
        return (this.f29129s == Integer.MIN_VALUE && this.f29130t == Integer.MIN_VALUE) ? false : true;
    }

    private boolean g() {
        return getLayoutDirection() == 1;
    }

    private void h(int i11, int i12) {
        this.f29115e.set(getPaddingLeft(), getPaddingTop(), i11 - getPaddingRight(), i12 - getPaddingBottom());
        this.f29114d.e(this.f29122l, 1.0f, this.f29115e, this.f29119i);
        this.f29124n.rewind();
        this.f29124n.addPath(this.f29119i);
        this.f29116f.set(0.0f, 0.0f, i11, i12);
        this.f29124n.addRect(this.f29116f, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.f29128r;
    }

    public final int getContentPaddingEnd() {
        int i11 = this.f29130t;
        return i11 != Integer.MIN_VALUE ? i11 : g() ? this.f29125o : this.f29127q;
    }

    public int getContentPaddingLeft() {
        int i11;
        int i12;
        if (f()) {
            if (g() && (i12 = this.f29130t) != Integer.MIN_VALUE) {
                return i12;
            }
            if (!g() && (i11 = this.f29129s) != Integer.MIN_VALUE) {
                return i11;
            }
        }
        return this.f29125o;
    }

    public int getContentPaddingRight() {
        int i11;
        int i12;
        if (f()) {
            if (g() && (i12 = this.f29129s) != Integer.MIN_VALUE) {
                return i12;
            }
            if (!g() && (i11 = this.f29130t) != Integer.MIN_VALUE) {
                return i11;
            }
        }
        return this.f29127q;
    }

    public final int getContentPaddingStart() {
        int i11 = this.f29129s;
        return i11 != Integer.MIN_VALUE ? i11 : g() ? this.f29127q : this.f29125o;
    }

    public int getContentPaddingTop() {
        return this.f29126p;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @NonNull
    public n getShapeAppearanceModel() {
        return this.f29122l;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f29120j;
    }

    public float getStrokeWidth() {
        return this.f29123m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f29124n, this.f29118h);
        e(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (!this.f29131u && isLayoutDirectionResolved()) {
            this.f29131u = true;
            if (isPaddingRelative() || f()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        h(i11, i12);
    }

    public void setContentPadding(int i11, int i12, int i13, int i14) {
        this.f29129s = Integer.MIN_VALUE;
        this.f29130t = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.f29125o) + i11, (super.getPaddingTop() - this.f29126p) + i12, (super.getPaddingRight() - this.f29127q) + i13, (super.getPaddingBottom() - this.f29128r) + i14);
        this.f29125o = i11;
        this.f29126p = i12;
        this.f29127q = i13;
        this.f29128r = i14;
    }

    public void setContentPaddingRelative(int i11, int i12, int i13, int i14) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i11, (super.getPaddingTop() - this.f29126p) + i12, (super.getPaddingEnd() - getContentPaddingEnd()) + i13, (super.getPaddingBottom() - this.f29128r) + i14);
        this.f29125o = g() ? i13 : i11;
        this.f29126p = i12;
        if (!g()) {
            i11 = i13;
        }
        this.f29127q = i11;
        this.f29128r = i14;
    }

    @Override // android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
        super.setPadding(i11 + getContentPaddingLeft(), i12 + getContentPaddingTop(), i13 + getContentPaddingRight(), i14 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i11, int i12, int i13, int i14) {
        super.setPaddingRelative(i11 + getContentPaddingStart(), i12 + getContentPaddingTop(), i13 + getContentPaddingEnd(), i14 + getContentPaddingBottom());
    }

    @Override // ab.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        this.f29122l = nVar;
        i iVar = this.f29121k;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        h(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f29120j = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i11) {
        setStrokeColor(g.a.a(getContext(), i11));
    }

    public void setStrokeWidth(float f11) {
        if (this.f29123m != f11) {
            this.f29123m = f11;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i11) {
        setStrokeWidth(getResources().getDimensionPixelSize(i11));
    }
}
