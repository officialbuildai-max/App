package com.google.android.material.floatingactionbutton;

import ab.i;
import ab.n;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.R$color;
import java.util.ArrayList;

/* loaded from: classes4.dex */
class e extends d {
    private StateListAnimator O;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends i {
        a(n nVar) {
            super(nVar);
        }

        @Override // ab.i, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FloatingActionButton floatingActionButton, za.b bVar) {
        super(floatingActionButton, bVar);
    }

    private StateListAnimator m0(float f11, float f12, float f13) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(d.I, n0(f11, f13));
        stateListAnimator.addState(d.J, n0(f11, f12));
        stateListAnimator.addState(d.K, n0(f11, f12));
        stateListAnimator.addState(d.L, n0(f11, f12));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f29081w, "elevation", f11).setDuration(0L));
        if (Build.VERSION.SDK_INT <= 24) {
            FloatingActionButton floatingActionButton = this.f29081w;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f29081w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(d.D);
        stateListAnimator.addState(d.M, animatorSet);
        stateListAnimator.addState(d.N, n0(0.0f, 0.0f));
        return stateListAnimator;
    }

    private Animator n0(float f11, float f12) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f29081w, "elevation", f11).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f29081w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f12).setDuration(100L));
        animatorSet.setInterpolator(d.D);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void A() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void C() {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void E(int[] iArr) {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void F(float f11, float f12, float f13) {
        if (this.f29081w.getStateListAnimator() == this.O) {
            StateListAnimator m02 = m0(f11, f12, f13);
            this.O = m02;
            this.f29081w.setStateListAnimator(m02);
        }
        if (c0()) {
            i0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean N() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void Y(ColorStateList colorStateList) {
        Drawable drawable = this.f29061c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(ya.b.d(colorStateList));
        } else {
            super.Y(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean c0() {
        return this.f29082x.c() || !e0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void g0() {
    }

    c l0(int i11, ColorStateList colorStateList) {
        Context context = this.f29081w.getContext();
        c cVar = new c((n) androidx.core.util.i.g(this.f29059a));
        cVar.e(androidx.core.content.b.getColor(context, R$color.design_fab_stroke_top_outer_color), androidx.core.content.b.getColor(context, R$color.design_fab_stroke_top_inner_color), androidx.core.content.b.getColor(context, R$color.design_fab_stroke_end_inner_color), androidx.core.content.b.getColor(context, R$color.design_fab_stroke_end_outer_color));
        cVar.d(i11);
        cVar.c(colorStateList);
        return cVar;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float m() {
        return this.f29081w.getElevation();
    }

    i o0() {
        return new a((n) androidx.core.util.i.g(this.f29059a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void r(Rect rect) {
        if (this.f29082x.c()) {
            super.r(rect);
        } else if (e0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f29069k - this.f29081w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i11) {
        Drawable drawable;
        i o02 = o0();
        this.f29060b = o02;
        o02.setTintList(colorStateList);
        if (mode != null) {
            this.f29060b.setTintMode(mode);
        }
        this.f29060b.S(this.f29081w.getContext());
        if (i11 > 0) {
            this.f29062d = l0(i11, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) androidx.core.util.i.g(this.f29062d), (Drawable) androidx.core.util.i.g(this.f29060b)});
        } else {
            this.f29062d = null;
            drawable = this.f29060b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(ya.b.d(colorStateList2), drawable, null);
        this.f29061c = rippleDrawable;
        this.f29063e = rippleDrawable;
    }
}
