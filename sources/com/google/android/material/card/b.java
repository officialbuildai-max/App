package com.google.android.material.card;

import ab.e;
import ab.f;
import ab.i;
import ab.m;
import ab.n;
import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import wa.j;
import xa.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b {
    private static final Drawable A;

    /* renamed from: z, reason: collision with root package name */
    private static final double f28600z = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a, reason: collision with root package name */
    private final MaterialCardView f28601a;

    /* renamed from: c, reason: collision with root package name */
    private final i f28603c;

    /* renamed from: d, reason: collision with root package name */
    private final i f28604d;

    /* renamed from: e, reason: collision with root package name */
    private int f28605e;

    /* renamed from: f, reason: collision with root package name */
    private int f28606f;

    /* renamed from: g, reason: collision with root package name */
    private int f28607g;

    /* renamed from: h, reason: collision with root package name */
    private int f28608h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f28609i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f28610j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f28611k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f28612l;

    /* renamed from: m, reason: collision with root package name */
    private n f28613m;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f28614n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f28615o;

    /* renamed from: p, reason: collision with root package name */
    private LayerDrawable f28616p;

    /* renamed from: q, reason: collision with root package name */
    private i f28617q;

    /* renamed from: r, reason: collision with root package name */
    private i f28618r;

    /* renamed from: t, reason: collision with root package name */
    private boolean f28620t;

    /* renamed from: u, reason: collision with root package name */
    private ValueAnimator f28621u;

    /* renamed from: v, reason: collision with root package name */
    private final TimeInterpolator f28622v;

    /* renamed from: w, reason: collision with root package name */
    private final int f28623w;

    /* renamed from: x, reason: collision with root package name */
    private final int f28624x;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f28602b = new Rect();

    /* renamed from: s, reason: collision with root package name */
    private boolean f28619s = false;

    /* renamed from: y, reason: collision with root package name */
    private float f28625y = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends InsetDrawable {
        a(Drawable drawable, int i11, int i12, int i13, int i14) {
            super(drawable, i11, i12, i13, i14);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        A = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public b(MaterialCardView materialCardView, AttributeSet attributeSet, int i11, int i12) {
        this.f28601a = materialCardView;
        i iVar = new i(materialCardView.getContext(), attributeSet, i11, i12);
        this.f28603c = iVar;
        iVar.S(materialCardView.getContext());
        iVar.j0(-12303292);
        n.b v11 = iVar.G().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i11, R$style.CardView);
        if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardCornerRadius)) {
            v11.o(obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f28604d = new i();
        Z(v11.m());
        this.f28622v = j.g(materialCardView.getContext(), R$attr.motionEasingLinearInterpolator, oa.a.f71041a);
        this.f28623w = j.f(materialCardView.getContext(), R$attr.motionDurationShort2, 300);
        this.f28624x = j.f(materialCardView.getContext(), R$attr.motionDurationShort1, 300);
        obtainStyledAttributes.recycle();
    }

    private Drawable D(Drawable drawable) {
        int i11;
        int i12;
        if (this.f28601a.getUseCompatPadding()) {
            i12 = (int) Math.ceil(f());
            i11 = (int) Math.ceil(e());
        } else {
            i11 = 0;
            i12 = 0;
        }
        return new a(drawable, i11, i12, i11, i12);
    }

    private boolean G() {
        return (this.f28607g & 80) == 80;
    }

    private boolean H() {
        return (this.f28607g & GravityCompat.END) == 8388613;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f28610j.setAlpha((int) (255.0f * floatValue));
        this.f28625y = floatValue;
    }

    private float c() {
        return Math.max(Math.max(d(this.f28613m.q(), this.f28603c.L()), d(this.f28613m.s(), this.f28603c.M())), Math.max(d(this.f28613m.k(), this.f28603c.v()), d(this.f28613m.i(), this.f28603c.u())));
    }

    private float d(e eVar, float f11) {
        if (eVar instanceof m) {
            return (float) ((1.0d - f28600z) * f11);
        }
        if (eVar instanceof f) {
            return f11 / 2.0f;
        }
        return 0.0f;
    }

    private boolean d0() {
        return this.f28601a.getPreventCornerOverlap() && !g();
    }

    private float e() {
        return this.f28601a.getMaxCardElevation() + (e0() ? c() : 0.0f);
    }

    private boolean e0() {
        return this.f28601a.getPreventCornerOverlap() && g() && this.f28601a.getUseCompatPadding();
    }

    private float f() {
        return (this.f28601a.getMaxCardElevation() * 1.5f) + (e0() ? c() : 0.0f);
    }

    private boolean f0() {
        if (this.f28601a.isClickable()) {
            return true;
        }
        View view = this.f28601a;
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    private boolean g() {
        return this.f28603c.V();
    }

    private Drawable h() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        i j11 = j();
        this.f28617q = j11;
        j11.d0(this.f28611k);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.f28617q);
        return stateListDrawable;
    }

    private Drawable i() {
        if (!ya.b.f79079a) {
            return h();
        }
        this.f28618r = j();
        return new RippleDrawable(this.f28611k, null, this.f28618r);
    }

    private i j() {
        return new i(this.f28613m);
    }

    private void j0(Drawable drawable) {
        if (this.f28601a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.f28601a.getForeground()).setDrawable(drawable);
        } else {
            this.f28601a.setForeground(D(drawable));
        }
    }

    private void l0() {
        Drawable drawable;
        if (ya.b.f79079a && (drawable = this.f28615o) != null) {
            ((RippleDrawable) drawable).setColor(this.f28611k);
            return;
        }
        i iVar = this.f28617q;
        if (iVar != null) {
            iVar.d0(this.f28611k);
        }
    }

    private Drawable t() {
        if (this.f28615o == null) {
            this.f28615o = i();
        }
        if (this.f28616p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f28615o, this.f28604d, this.f28610j});
            this.f28616p = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.f28616p;
    }

    private float v() {
        if (this.f28601a.getPreventCornerOverlap() && this.f28601a.getUseCompatPadding()) {
            return (float) ((1.0d - f28600z) * this.f28601a.getCardViewRadius());
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList A() {
        return this.f28614n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int B() {
        return this.f28608h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rect C() {
        return this.f28602b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        return this.f28619s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F() {
        return this.f28620t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(TypedArray typedArray) {
        ColorStateList a11 = c.a(this.f28601a.getContext(), typedArray, R$styleable.MaterialCardView_strokeColor);
        this.f28614n = a11;
        if (a11 == null) {
            this.f28614n = ColorStateList.valueOf(-1);
        }
        this.f28608h = typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z10 = typedArray.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        this.f28620t = z10;
        this.f28601a.setLongClickable(z10);
        this.f28612l = c.a(this.f28601a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIconTint);
        R(c.e(this.f28601a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIcon));
        U(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0));
        T(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0));
        this.f28607g = typedArray.getInteger(R$styleable.MaterialCardView_checkedIconGravity, MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END);
        ColorStateList a12 = c.a(this.f28601a.getContext(), typedArray, R$styleable.MaterialCardView_rippleColor);
        this.f28611k = a12;
        if (a12 == null) {
            this.f28611k = ColorStateList.valueOf(com.google.android.material.color.b.d(this.f28601a, R$attr.colorControlHighlight));
        }
        N(c.a(this.f28601a.getContext(), typedArray, R$styleable.MaterialCardView_cardForegroundColor));
        l0();
        i0();
        m0();
        this.f28601a.setBackgroundInternal(D(this.f28603c));
        Drawable t11 = f0() ? t() : this.f28604d;
        this.f28609i = t11;
        this.f28601a.setForeground(D(t11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        if (this.f28616p != null) {
            if (this.f28601a.getUseCompatPadding()) {
                i13 = (int) Math.ceil(f() * 2.0f);
                i14 = (int) Math.ceil(e() * 2.0f);
            } else {
                i13 = 0;
                i14 = 0;
            }
            int i17 = H() ? ((i11 - this.f28605e) - this.f28606f) - i14 : this.f28605e;
            int i18 = G() ? this.f28605e : ((i12 - this.f28605e) - this.f28606f) - i13;
            int i19 = H() ? this.f28605e : ((i11 - this.f28605e) - this.f28606f) - i14;
            int i20 = G() ? ((i12 - this.f28605e) - this.f28606f) - i13 : this.f28605e;
            if (ViewCompat.getLayoutDirection(this.f28601a) == 1) {
                i16 = i19;
                i15 = i17;
            } else {
                i15 = i19;
                i16 = i17;
            }
            this.f28616p.setLayerInset(2, i16, i20, i15, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(boolean z10) {
        this.f28619s = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(ColorStateList colorStateList) {
        this.f28603c.d0(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(ColorStateList colorStateList) {
        i iVar = this.f28604d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        iVar.d0(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(boolean z10) {
        this.f28620t = z10;
    }

    public void P(boolean z10) {
        Q(z10, false);
    }

    public void Q(boolean z10, boolean z11) {
        Drawable drawable = this.f28610j;
        if (drawable != null) {
            if (z11) {
                b(z10);
            } else {
                drawable.setAlpha(z10 ? 255 : 0);
                this.f28625y = z10 ? 1.0f : 0.0f;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = a1.a.r(drawable).mutate();
            this.f28610j = mutate;
            a1.a.o(mutate, this.f28612l);
            P(this.f28601a.isChecked());
        } else {
            this.f28610j = A;
        }
        LayerDrawable layerDrawable = this.f28616p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, this.f28610j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(int i11) {
        this.f28607g = i11;
        K(this.f28601a.getMeasuredWidth(), this.f28601a.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i11) {
        this.f28605e = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i11) {
        this.f28606f = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(ColorStateList colorStateList) {
        this.f28612l = colorStateList;
        Drawable drawable = this.f28610j;
        if (drawable != null) {
            a1.a.o(drawable, colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(float f11) {
        Z(this.f28613m.w(f11));
        this.f28609i.invalidateSelf();
        if (e0() || d0()) {
            h0();
        }
        if (e0()) {
            k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(float f11) {
        this.f28603c.e0(f11);
        i iVar = this.f28604d;
        if (iVar != null) {
            iVar.e0(f11);
        }
        i iVar2 = this.f28618r;
        if (iVar2 != null) {
            iVar2.e0(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(ColorStateList colorStateList) {
        this.f28611k = colorStateList;
        l0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(n nVar) {
        this.f28613m = nVar;
        this.f28603c.setShapeAppearanceModel(nVar);
        this.f28603c.i0(!r0.V());
        i iVar = this.f28604d;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        i iVar2 = this.f28618r;
        if (iVar2 != null) {
            iVar2.setShapeAppearanceModel(nVar);
        }
        i iVar3 = this.f28617q;
        if (iVar3 != null) {
            iVar3.setShapeAppearanceModel(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(ColorStateList colorStateList) {
        if (this.f28614n == colorStateList) {
            return;
        }
        this.f28614n = colorStateList;
        m0();
    }

    public void b(boolean z10) {
        float f11 = z10 ? 1.0f : 0.0f;
        float f12 = z10 ? 1.0f - this.f28625y : this.f28625y;
        ValueAnimator valueAnimator = this.f28621u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f28621u = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f28625y, f11);
        this.f28621u = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.card.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                b.this.I(valueAnimator2);
            }
        });
        this.f28621u.setInterpolator(this.f28622v);
        this.f28621u.setDuration((z10 ? this.f28623w : this.f28624x) * f12);
        this.f28621u.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(int i11) {
        if (i11 == this.f28608h) {
            return;
        }
        this.f28608h = i11;
        m0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(int i11, int i12, int i13, int i14) {
        this.f28602b.set(i11, i12, i13, i14);
        h0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0() {
        Drawable drawable = this.f28609i;
        Drawable t11 = f0() ? t() : this.f28604d;
        this.f28609i = t11;
        if (drawable != t11) {
            j0(t11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0() {
        int c11 = (int) (((d0() || e0()) ? c() : 0.0f) - v());
        MaterialCardView materialCardView = this.f28601a;
        Rect rect = this.f28602b;
        materialCardView.d(rect.left + c11, rect.top + c11, rect.right + c11, rect.bottom + c11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0() {
        this.f28603c.c0(this.f28601a.getCardElevation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        Drawable drawable = this.f28615o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i11 = bounds.bottom;
            this.f28615o.setBounds(bounds.left, bounds.top, bounds.right, i11 - 1);
            this.f28615o.setBounds(bounds.left, bounds.top, bounds.right, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0() {
        if (!E()) {
            this.f28601a.setBackgroundInternal(D(this.f28603c));
        }
        this.f28601a.setForeground(D(this.f28609i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i l() {
        return this.f28603c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList m() {
        return this.f28603c.z();
    }

    void m0() {
        this.f28604d.m0(this.f28608h, this.f28614n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList n() {
        return this.f28604d.z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable o() {
        return this.f28610j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f28607g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.f28605e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.f28606f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList s() {
        return this.f28612l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float u() {
        return this.f28603c.L();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float w() {
        return this.f28603c.A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList x() {
        return this.f28611k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n y() {
        return this.f28613m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        ColorStateList colorStateList = this.f28614n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }
}
