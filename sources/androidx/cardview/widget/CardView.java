package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f2291h = {R.attr.colorBackground};

    /* renamed from: i, reason: collision with root package name */
    private static final c f2292i;

    /* renamed from: a, reason: collision with root package name */
    private boolean f2293a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2294b;

    /* renamed from: c, reason: collision with root package name */
    int f2295c;

    /* renamed from: d, reason: collision with root package name */
    int f2296d;

    /* renamed from: e, reason: collision with root package name */
    final Rect f2297e;

    /* renamed from: f, reason: collision with root package name */
    final Rect f2298f;

    /* renamed from: g, reason: collision with root package name */
    private final b f2299g;

    /* loaded from: classes.dex */
    class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f2300a;

        a() {
        }

        @Override // androidx.cardview.widget.b
        public void a(int i11, int i12, int i13, int i14) {
            CardView.this.f2298f.set(i11, i12, i13, i14);
            CardView cardView = CardView.this;
            Rect rect = cardView.f2297e;
            CardView.super.setPadding(i11 + rect.left, i12 + rect.top, i13 + rect.right, i14 + rect.bottom);
        }

        @Override // androidx.cardview.widget.b
        public void b(Drawable drawable) {
            this.f2300a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.b
        public boolean c() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.b
        public Drawable d() {
            return this.f2300a;
        }

        @Override // androidx.cardview.widget.b
        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.b
        public View f() {
            return CardView.this;
        }
    }

    static {
        androidx.cardview.widget.a aVar = new androidx.cardview.widget.a();
        f2292i = aVar;
        aVar.l();
    }

    public CardView(@NonNull Context context) {
        this(context, null);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f2297e = rect;
        this.f2298f = new Rect();
        a aVar = new a();
        this.f2299g = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i11, R$style.CardView);
        if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R$styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f2291h);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            valueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(R$color.cardview_light_background) : getResources().getColor(R$color.cardview_dark_background));
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.f2293a = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.f2294b = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f11 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f2295c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f2296d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f2292i.h(aVar, context, colorStateList, dimension, dimension2, f11);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f2292i.e(this.f2299g);
    }

    public float getCardElevation() {
        return f2292i.i(this.f2299g);
    }

    public int getContentPaddingBottom() {
        return this.f2297e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f2297e.left;
    }

    public int getContentPaddingRight() {
        return this.f2297e.right;
    }

    public int getContentPaddingTop() {
        return this.f2297e.top;
    }

    public float getMaxCardElevation() {
        return f2292i.d(this.f2299g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2294b;
    }

    public float getRadius() {
        return f2292i.b(this.f2299g);
    }

    public boolean getUseCompatPadding() {
        return this.f2293a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        if (f2292i instanceof androidx.cardview.widget.a) {
            super.onMeasure(i11, i12);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.m(this.f2299g)), View.MeasureSpec.getSize(i11)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i12 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.f(this.f2299g)), View.MeasureSpec.getSize(i12)), mode2);
        }
        super.onMeasure(i11, i12);
    }

    public void setCardBackgroundColor(int i11) {
        f2292i.n(this.f2299g, ColorStateList.valueOf(i11));
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        f2292i.n(this.f2299g, colorStateList);
    }

    public void setCardElevation(float f11) {
        f2292i.c(this.f2299g, f11);
    }

    public void setContentPadding(int i11, int i12, int i13, int i14) {
        this.f2297e.set(i11, i12, i13, i14);
        f2292i.k(this.f2299g);
    }

    public void setMaxCardElevation(float f11) {
        f2292i.o(this.f2299g, f11);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i11) {
        this.f2296d = i11;
        super.setMinimumHeight(i11);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i11) {
        this.f2295c = i11;
        super.setMinimumWidth(i11);
    }

    @Override // android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i11, int i12, int i13, int i14) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f2294b) {
            this.f2294b = z10;
            f2292i.g(this.f2299g);
        }
    }

    public void setRadius(float f11) {
        f2292i.a(this.f2299g, f11);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f2293a != z10) {
            this.f2293a = z10;
            f2292i.j(this.f2299g);
        }
    }
}
