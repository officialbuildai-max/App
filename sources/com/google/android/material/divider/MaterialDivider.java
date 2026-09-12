package com.google.android.material.divider;

import ab.i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.b;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes4.dex */
public class MaterialDivider extends View {

    /* renamed from: f, reason: collision with root package name */
    private static final int f28972f = R$style.Widget_MaterialComponents_MaterialDivider;

    /* renamed from: a, reason: collision with root package name */
    private final i f28973a;

    /* renamed from: b, reason: collision with root package name */
    private int f28974b;

    /* renamed from: c, reason: collision with root package name */
    private int f28975c;

    /* renamed from: d, reason: collision with root package name */
    private int f28976d;

    /* renamed from: e, reason: collision with root package name */
    private int f28977e;

    public MaterialDivider(@NonNull Context context) {
        this(context, null);
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialDividerStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialDivider(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.divider.MaterialDivider.f28972f
            android.content.Context r8 = bb.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            ab.i r0 = new ab.i
            r0.<init>()
            r7.f28973a = r0
            int[] r2 = com.google.android.material.R$styleable.MaterialDivider
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.b0.i(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R$styleable.MaterialDivider_dividerThickness
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R$dimen.material_divider_thickness
            int r0 = r0.getDimensionPixelSize(r1)
            int r10 = r9.getDimensionPixelSize(r10, r0)
            r7.f28974b = r10
            int r10 = com.google.android.material.R$styleable.MaterialDivider_dividerInsetStart
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.f28976d = r10
            int r10 = com.google.android.material.R$styleable.MaterialDivider_dividerInsetEnd
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.f28977e = r10
            int r10 = com.google.android.material.R$styleable.MaterialDivider_dividerColor
            android.content.res.ColorStateList r8 = xa.c.a(r8, r9, r10)
            int r8 = r8.getDefaultColor()
            r7.setDividerColor(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.divider.MaterialDivider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public int getDividerColor() {
        return this.f28975c;
    }

    public int getDividerInsetEnd() {
        return this.f28977e;
    }

    public int getDividerInsetStart() {
        return this.f28976d;
    }

    public int getDividerThickness() {
        return this.f28974b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int i11;
        super.onDraw(canvas);
        boolean z10 = ViewCompat.getLayoutDirection(this) == 1;
        int i12 = z10 ? this.f28977e : this.f28976d;
        if (z10) {
            width = getWidth();
            i11 = this.f28976d;
        } else {
            width = getWidth();
            i11 = this.f28977e;
        }
        this.f28973a.setBounds(i12, 0, width - i11, getBottom() - getTop());
        this.f28973a.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i12);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i13 = this.f28974b;
            if (i13 > 0 && measuredHeight != i13) {
                measuredHeight = i13;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i11) {
        if (this.f28975c != i11) {
            this.f28975c = i11;
            this.f28973a.d0(ColorStateList.valueOf(i11));
            invalidate();
        }
    }

    public void setDividerColorResource(int i11) {
        setDividerColor(b.getColor(getContext(), i11));
    }

    public void setDividerInsetEnd(int i11) {
        this.f28977e = i11;
    }

    public void setDividerInsetEndResource(int i11) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i11));
    }

    public void setDividerInsetStart(int i11) {
        this.f28976d = i11;
    }

    public void setDividerInsetStartResource(int i11) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i11));
    }

    public void setDividerThickness(int i11) {
        if (this.f28974b != i11) {
            this.f28974b = i11;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i11) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i11));
    }
}
