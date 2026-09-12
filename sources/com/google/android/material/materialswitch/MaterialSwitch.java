package com.google.android.material.materialswitch;

import a1.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.drawable.d;
import z0.b;

/* loaded from: classes4.dex */
public class MaterialSwitch extends SwitchCompat {

    /* renamed from: k0, reason: collision with root package name */
    private static final int f29342k0 = R$style.Widget_Material3_CompoundButton_MaterialSwitch;

    /* renamed from: l0, reason: collision with root package name */
    private static final int[] f29343l0 = {R$attr.state_with_icon};
    private Drawable U;
    private Drawable V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private Drawable f29344a0;

    /* renamed from: b0, reason: collision with root package name */
    private Drawable f29345b0;

    /* renamed from: c0, reason: collision with root package name */
    private ColorStateList f29346c0;

    /* renamed from: d0, reason: collision with root package name */
    private ColorStateList f29347d0;

    /* renamed from: e0, reason: collision with root package name */
    private PorterDuff.Mode f29348e0;

    /* renamed from: f0, reason: collision with root package name */
    private ColorStateList f29349f0;

    /* renamed from: g0, reason: collision with root package name */
    private ColorStateList f29350g0;

    /* renamed from: h0, reason: collision with root package name */
    private PorterDuff.Mode f29351h0;

    /* renamed from: i0, reason: collision with root package name */
    private int[] f29352i0;

    /* renamed from: j0, reason: collision with root package name */
    private int[] f29353j0;

    public MaterialSwitch(@NonNull Context context) {
        this(context, null);
    }

    public MaterialSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialSwitchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialSwitch(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.materialswitch.MaterialSwitch.f29342k0
            android.content.Context r8 = bb.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            r8 = -1
            r7.W = r8
            android.content.Context r0 = r7.getContext()
            android.graphics.drawable.Drawable r1 = super.getThumbDrawable()
            r7.U = r1
            android.content.res.ColorStateList r1 = super.getThumbTintList()
            r7.f29346c0 = r1
            r1 = 0
            super.setThumbTintList(r1)
            android.graphics.drawable.Drawable r2 = super.getTrackDrawable()
            r7.f29344a0 = r2
            android.content.res.ColorStateList r2 = super.getTrackTintList()
            r7.f29349f0 = r2
            super.setTrackTintList(r1)
            int[] r2 = com.google.android.material.R$styleable.MaterialSwitch
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            androidx.appcompat.widget.j0 r9 = com.google.android.material.internal.b0.j(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R$styleable.MaterialSwitch_thumbIcon
            android.graphics.drawable.Drawable r10 = r9.g(r10)
            r7.V = r10
            int r10 = com.google.android.material.R$styleable.MaterialSwitch_thumbIconSize
            int r10 = r9.f(r10, r8)
            r7.W = r10
            int r10 = com.google.android.material.R$styleable.MaterialSwitch_thumbIconTint
            android.content.res.ColorStateList r10 = r9.c(r10)
            r7.f29347d0 = r10
            int r10 = com.google.android.material.R$styleable.MaterialSwitch_thumbIconTintMode
            int r10 = r9.k(r10, r8)
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r10 = com.google.android.material.internal.f0.r(r10, r0)
            r7.f29348e0 = r10
            int r10 = com.google.android.material.R$styleable.MaterialSwitch_trackDecoration
            android.graphics.drawable.Drawable r10 = r9.g(r10)
            r7.f29345b0 = r10
            int r10 = com.google.android.material.R$styleable.MaterialSwitch_trackDecorationTint
            android.content.res.ColorStateList r10 = r9.c(r10)
            r7.f29350g0 = r10
            int r10 = com.google.android.material.R$styleable.MaterialSwitch_trackDecorationTintMode
            int r8 = r9.k(r10, r8)
            android.graphics.PorterDuff$Mode r8 = com.google.android.material.internal.f0.r(r8, r0)
            r7.f29351h0 = r8
            r9.x()
            r7.setEnforceSwitchWidth(r6)
            r7.p()
            r7.q()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.materialswitch.MaterialSwitch.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void p() {
        this.U = d.c(this.U, this.f29346c0, getThumbTintMode());
        this.V = d.c(this.V, this.f29347d0, this.f29348e0);
        s();
        Drawable drawable = this.U;
        Drawable drawable2 = this.V;
        int i11 = this.W;
        super.setThumbDrawable(d.b(drawable, drawable2, i11, i11));
        refreshDrawableState();
    }

    private void q() {
        this.f29344a0 = d.c(this.f29344a0, this.f29349f0, getTrackTintMode());
        this.f29345b0 = d.c(this.f29345b0, this.f29350g0, this.f29351h0);
        s();
        Drawable drawable = this.f29344a0;
        if (drawable != null && this.f29345b0 != null) {
            drawable = new LayerDrawable(new Drawable[]{this.f29344a0, this.f29345b0});
        } else if (drawable == null) {
            drawable = this.f29345b0;
        }
        if (drawable != null) {
            setSwitchMinWidth(drawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(drawable);
    }

    private static void r(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f11) {
        if (drawable == null || colorStateList == null) {
            return;
        }
        a.n(drawable, b.d(colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0), f11));
    }

    private void s() {
        if (this.f29346c0 == null && this.f29347d0 == null && this.f29349f0 == null && this.f29350g0 == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.f29346c0;
        if (colorStateList != null) {
            r(this.U, colorStateList, this.f29352i0, this.f29353j0, thumbPosition);
        }
        ColorStateList colorStateList2 = this.f29347d0;
        if (colorStateList2 != null) {
            r(this.V, colorStateList2, this.f29352i0, this.f29353j0, thumbPosition);
        }
        ColorStateList colorStateList3 = this.f29349f0;
        if (colorStateList3 != null) {
            r(this.f29344a0, colorStateList3, this.f29352i0, this.f29353j0, thumbPosition);
        }
        ColorStateList colorStateList4 = this.f29350g0;
        if (colorStateList4 != null) {
            r(this.f29345b0, colorStateList4, this.f29352i0, this.f29353j0, thumbPosition);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getThumbDrawable() {
        return this.U;
    }

    @Nullable
    public Drawable getThumbIconDrawable() {
        return this.V;
    }

    public int getThumbIconSize() {
        return this.W;
    }

    @Nullable
    public ColorStateList getThumbIconTintList() {
        return this.f29347d0;
    }

    @NonNull
    public PorterDuff.Mode getThumbIconTintMode() {
        return this.f29348e0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f29346c0;
    }

    @Nullable
    public Drawable getTrackDecorationDrawable() {
        return this.f29345b0;
    }

    @Nullable
    public ColorStateList getTrackDecorationTintList() {
        return this.f29350g0;
    }

    @NonNull
    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.f29351h0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getTrackDrawable() {
        return this.f29344a0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f29349f0;
    }

    @Override // android.view.View
    public void invalidate() {
        s();
        super.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 1);
        if (this.V != null) {
            View.mergeDrawableStates(onCreateDrawableState, f29343l0);
        }
        this.f29352i0 = d.j(onCreateDrawableState);
        this.f29353j0 = d.f(onCreateDrawableState);
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(@Nullable Drawable drawable) {
        this.U = drawable;
        p();
    }

    public void setThumbIconDrawable(@Nullable Drawable drawable) {
        this.V = drawable;
        p();
    }

    public void setThumbIconResource(int i11) {
        setThumbIconDrawable(g.a.b(getContext(), i11));
    }

    public void setThumbIconSize(int i11) {
        if (this.W != i11) {
            this.W = i11;
            p();
        }
    }

    public void setThumbIconTintList(@Nullable ColorStateList colorStateList) {
        this.f29347d0 = colorStateList;
        p();
    }

    public void setThumbIconTintMode(@NonNull PorterDuff.Mode mode) {
        this.f29348e0 = mode;
        p();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f29346c0 = colorStateList;
        p();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        p();
    }

    public void setTrackDecorationDrawable(@Nullable Drawable drawable) {
        this.f29345b0 = drawable;
        q();
    }

    public void setTrackDecorationResource(int i11) {
        setTrackDecorationDrawable(g.a.b(getContext(), i11));
    }

    public void setTrackDecorationTintList(@Nullable ColorStateList colorStateList) {
        this.f29350g0 = colorStateList;
        q();
    }

    public void setTrackDecorationTintMode(@NonNull PorterDuff.Mode mode) {
        this.f29351h0 = mode;
        q();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(@Nullable Drawable drawable) {
        this.f29344a0 = drawable;
        q();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f29349f0 = colorStateList;
        q();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        q();
    }
}
