package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.color.b;
import com.google.android.material.internal.f0;
import ta.a;

/* loaded from: classes4.dex */
public class SwitchMaterial extends SwitchCompat {

    /* renamed from: b0, reason: collision with root package name */
    private static final int f29863b0 = R$style.Widget_MaterialComponents_CompoundButton_Switch;

    /* renamed from: c0, reason: collision with root package name */
    private static final int[][] f29864c0 = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private final a U;
    private ColorStateList V;
    private ColorStateList W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f29865a0;

    public SwitchMaterial(@NonNull Context context) {
        this(context, null);
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SwitchMaterial(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.switchmaterial.SwitchMaterial.f29863b0
            android.content.Context r7 = bb.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            ta.a r7 = new ta.a
            r7.<init>(r0)
            r6.U = r7
            int[] r2 = com.google.android.material.R$styleable.SwitchMaterial
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.b0.i(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.SwitchMaterial_useMaterialThemeColors
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f29865a0 = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.switchmaterial.SwitchMaterial.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.V == null) {
            int d11 = b.d(this, R$attr.colorSurface);
            int d12 = b.d(this, R$attr.colorControlActivated);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            if (this.U.e()) {
                dimension += f0.n(this);
            }
            int c11 = this.U.c(d11, dimension);
            int[][] iArr = f29864c0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = b.j(d11, d12, 1.0f);
            iArr2[1] = c11;
            iArr2[2] = b.j(d11, d12, 0.38f);
            iArr2[3] = c11;
            this.V = new ColorStateList(iArr, iArr2);
        }
        return this.V;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.W == null) {
            int[][] iArr = f29864c0;
            int[] iArr2 = new int[iArr.length];
            int d11 = b.d(this, R$attr.colorSurface);
            int d12 = b.d(this, R$attr.colorControlActivated);
            int d13 = b.d(this, R$attr.colorOnSurface);
            iArr2[0] = b.j(d11, d12, 0.54f);
            iArr2[1] = b.j(d11, d13, 0.32f);
            iArr2[2] = b.j(d11, d12, 0.12f);
            iArr2[3] = b.j(d11, d13, 0.12f);
            this.W = new ColorStateList(iArr, iArr2);
        }
        return this.W;
    }

    public boolean isUseMaterialThemeColors() {
        return this.f29865a0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f29865a0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f29865a0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f29865a0 = z10;
        if (z10) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }
}
