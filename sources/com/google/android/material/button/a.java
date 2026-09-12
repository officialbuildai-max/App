package com.google.android.material.button;

import ab.i;
import ab.n;
import ab.q;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.color.b;
import com.google.android.material.internal.f0;
import xa.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: u, reason: collision with root package name */
    private static final boolean f28569u = true;

    /* renamed from: v, reason: collision with root package name */
    private static final boolean f28570v = false;

    /* renamed from: a, reason: collision with root package name */
    private final MaterialButton f28571a;

    /* renamed from: b, reason: collision with root package name */
    private n f28572b;

    /* renamed from: c, reason: collision with root package name */
    private int f28573c;

    /* renamed from: d, reason: collision with root package name */
    private int f28574d;

    /* renamed from: e, reason: collision with root package name */
    private int f28575e;

    /* renamed from: f, reason: collision with root package name */
    private int f28576f;

    /* renamed from: g, reason: collision with root package name */
    private int f28577g;

    /* renamed from: h, reason: collision with root package name */
    private int f28578h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuff.Mode f28579i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f28580j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f28581k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f28582l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f28583m;

    /* renamed from: q, reason: collision with root package name */
    private boolean f28587q;

    /* renamed from: s, reason: collision with root package name */
    private LayerDrawable f28589s;

    /* renamed from: t, reason: collision with root package name */
    private int f28590t;

    /* renamed from: n, reason: collision with root package name */
    private boolean f28584n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f28585o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f28586p = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f28588r = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MaterialButton materialButton, n nVar) {
        this.f28571a = materialButton;
        this.f28572b = nVar;
    }

    private void G(int i11, int i12) {
        int paddingStart = ViewCompat.getPaddingStart(this.f28571a);
        int paddingTop = this.f28571a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f28571a);
        int paddingBottom = this.f28571a.getPaddingBottom();
        int i13 = this.f28575e;
        int i14 = this.f28576f;
        this.f28576f = i12;
        this.f28575e = i11;
        if (!this.f28585o) {
            H();
        }
        ViewCompat.setPaddingRelative(this.f28571a, paddingStart, (paddingTop + i11) - i13, paddingEnd, (paddingBottom + i12) - i14);
    }

    private void H() {
        this.f28571a.setInternalBackground(a());
        i f11 = f();
        if (f11 != null) {
            f11.c0(this.f28590t);
            f11.setState(this.f28571a.getDrawableState());
        }
    }

    private void I(n nVar) {
        if (f28570v && !this.f28585o) {
            int paddingStart = ViewCompat.getPaddingStart(this.f28571a);
            int paddingTop = this.f28571a.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(this.f28571a);
            int paddingBottom = this.f28571a.getPaddingBottom();
            H();
            ViewCompat.setPaddingRelative(this.f28571a, paddingStart, paddingTop, paddingEnd, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(nVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(nVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(nVar);
        }
    }

    private void J() {
        i f11 = f();
        i n11 = n();
        if (f11 != null) {
            f11.m0(this.f28578h, this.f28581k);
            if (n11 != null) {
                n11.l0(this.f28578h, this.f28584n ? b.d(this.f28571a, R$attr.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable K(Drawable drawable) {
        return new InsetDrawable(drawable, this.f28573c, this.f28575e, this.f28574d, this.f28576f);
    }

    private Drawable a() {
        i iVar = new i(this.f28572b);
        iVar.S(this.f28571a.getContext());
        a1.a.o(iVar, this.f28580j);
        PorterDuff.Mode mode = this.f28579i;
        if (mode != null) {
            a1.a.p(iVar, mode);
        }
        iVar.m0(this.f28578h, this.f28581k);
        i iVar2 = new i(this.f28572b);
        iVar2.setTint(0);
        iVar2.l0(this.f28578h, this.f28584n ? b.d(this.f28571a, R$attr.colorSurface) : 0);
        if (f28569u) {
            i iVar3 = new i(this.f28572b);
            this.f28583m = iVar3;
            a1.a.n(iVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(ya.b.d(this.f28582l), K(new LayerDrawable(new Drawable[]{iVar2, iVar})), this.f28583m);
            this.f28589s = rippleDrawable;
            return rippleDrawable;
        }
        ya.a aVar = new ya.a(this.f28572b);
        this.f28583m = aVar;
        a1.a.o(aVar, ya.b.d(this.f28582l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{iVar2, iVar, this.f28583m});
        this.f28589s = layerDrawable;
        return K(layerDrawable);
    }

    private i g(boolean z10) {
        LayerDrawable layerDrawable = this.f28589s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f28569u ? (i) ((LayerDrawable) ((InsetDrawable) this.f28589s.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0) : (i) this.f28589s.getDrawable(!z10 ? 1 : 0);
    }

    private i n() {
        return g(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(boolean z10) {
        this.f28584n = z10;
        J();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(ColorStateList colorStateList) {
        if (this.f28581k != colorStateList) {
            this.f28581k = colorStateList;
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i11) {
        if (this.f28578h != i11) {
            this.f28578h = i11;
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(ColorStateList colorStateList) {
        if (this.f28580j != colorStateList) {
            this.f28580j = colorStateList;
            if (f() != null) {
                a1.a.o(f(), this.f28580j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(PorterDuff.Mode mode) {
        if (this.f28579i != mode) {
            this.f28579i = mode;
            if (f() == null || this.f28579i == null) {
                return;
            }
            a1.a.p(f(), this.f28579i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(boolean z10) {
        this.f28588r = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f28577g;
    }

    public int c() {
        return this.f28576f;
    }

    public int d() {
        return this.f28575e;
    }

    public q e() {
        LayerDrawable layerDrawable = this.f28589s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f28589s.getNumberOfLayers() > 2 ? (q) this.f28589s.getDrawable(2) : (q) this.f28589s.getDrawable(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i f() {
        return g(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f28582l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n i() {
        return this.f28572b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.f28581k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f28578h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f28580j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f28579i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f28585o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f28587q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.f28588r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(TypedArray typedArray) {
        this.f28573c = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.f28574d = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.f28575e = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f28576f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R$styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, -1);
            this.f28577g = dimensionPixelSize;
            z(this.f28572b.w(dimensionPixelSize));
            this.f28586p = true;
        }
        this.f28578h = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.f28579i = f0.r(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f28580j = c.a(this.f28571a.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.f28581k = c.a(this.f28571a.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.f28582l = c.a(this.f28571a.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.f28587q = typedArray.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        this.f28590t = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        this.f28588r = typedArray.getBoolean(R$styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int paddingStart = ViewCompat.getPaddingStart(this.f28571a);
        int paddingTop = this.f28571a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f28571a);
        int paddingBottom = this.f28571a.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.MaterialButton_android_background)) {
            t();
        } else {
            H();
        }
        ViewCompat.setPaddingRelative(this.f28571a, paddingStart + this.f28573c, paddingTop + this.f28575e, paddingEnd + this.f28574d, paddingBottom + this.f28576f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i11) {
        if (f() != null) {
            f().setTint(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.f28585o = true;
        this.f28571a.setSupportBackgroundTintList(this.f28580j);
        this.f28571a.setSupportBackgroundTintMode(this.f28579i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(boolean z10) {
        this.f28587q = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i11) {
        if (this.f28586p && this.f28577g == i11) {
            return;
        }
        this.f28577g = i11;
        this.f28586p = true;
        z(this.f28572b.w(i11));
    }

    public void w(int i11) {
        G(this.f28575e, i11);
    }

    public void x(int i11) {
        G(i11, this.f28576f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList) {
        if (this.f28582l != colorStateList) {
            this.f28582l = colorStateList;
            boolean z10 = f28569u;
            if (z10 && (this.f28571a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f28571a.getBackground()).setColor(ya.b.d(colorStateList));
            } else {
                if (z10 || !(this.f28571a.getBackground() instanceof ya.a)) {
                    return;
                }
                ((ya.a) this.f28571a.getBackground()).setTintList(ya.b.d(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(n nVar) {
        this.f28572b = nVar;
        I(nVar);
    }
}
