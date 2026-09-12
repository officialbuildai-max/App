package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.c;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.color.b;

/* loaded from: classes4.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: c, reason: collision with root package name */
    private static final int f29565c = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f29566d = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: a, reason: collision with root package name */
    private ColorStateList f29567a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f29568b;

    public MaterialRadioButton(@NonNull Context context) {
        this(context, null);
    }

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialRadioButton(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.radiobutton.MaterialRadioButton.f29565c
            android.content.Context r8 = bb.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialRadioButton
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.b0.i(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R$styleable.MaterialRadioButton_buttonTint
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L2a
            int r10 = com.google.android.material.R$styleable.MaterialRadioButton_buttonTint
            android.content.res.ColorStateList r8 = xa.c.a(r8, r9, r10)
            androidx.core.widget.c.d(r7, r8)
        L2a:
            int r8 = com.google.android.material.R$styleable.MaterialRadioButton_useMaterialThemeColors
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f29568b = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.radiobutton.MaterialRadioButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f29567a == null) {
            int d11 = b.d(this, R$attr.colorControlActivated);
            int d12 = b.d(this, R$attr.colorOnSurface);
            int d13 = b.d(this, R$attr.colorSurface);
            int[][] iArr = f29566d;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = b.j(d13, d11, 1.0f);
            iArr2[1] = b.j(d13, d12, 0.54f);
            iArr2[2] = b.j(d13, d12, 0.38f);
            iArr2[3] = b.j(d13, d12, 0.38f);
            this.f29567a = new ColorStateList(iArr, iArr2);
        }
        return this.f29567a;
    }

    public boolean isUseMaterialThemeColors() {
        return this.f29568b;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f29568b && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f29568b = z10;
        if (z10) {
            c.d(this, getMaterialThemeColorsTintList());
        } else {
            c.d(this, null);
        }
    }
}
