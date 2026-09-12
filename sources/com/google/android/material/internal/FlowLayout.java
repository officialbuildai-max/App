package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;

/* loaded from: classes4.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private int f29143a;

    /* renamed from: b, reason: collision with root package name */
    private int f29144b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f29145c;

    /* renamed from: d, reason: collision with root package name */
    private int f29146d;

    public FlowLayout(@NonNull Context context) {
        this(context, null);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29145c = false;
        b(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f29145c = false;
        b(context, attributeSet);
    }

    private static int a(int i11, int i12, int i13) {
        return i12 != Integer.MIN_VALUE ? i12 != 1073741824 ? i13 : i11 : Math.min(i13, i11);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        this.f29143a = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_lineSpacing, 0);
        this.f29144b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    protected int getItemSpacing() {
        return this.f29144b;
    }

    protected int getLineSpacing() {
        return this.f29143a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRowCount() {
        return this.f29146d;
    }

    public int getRowIndex(@NonNull View view) {
        Object tag = view.getTag(R$id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean isSingleLine() {
        return this.f29145c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        if (getChildCount() == 0) {
            this.f29146d = 0;
            return;
        }
        this.f29146d = 1;
        boolean z11 = ViewCompat.getLayoutDirection(this) == 1;
        int paddingRight = z11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i17 = (i13 - i11) - paddingLeft;
        int i18 = paddingRight;
        int i19 = paddingTop;
        for (int i20 = 0; i20 < getChildCount(); i20++) {
            View childAt = getChildAt(i20);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R$id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i16 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    i15 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    i15 = 0;
                    i16 = 0;
                }
                int measuredWidth = i18 + i16 + childAt.getMeasuredWidth();
                if (!this.f29145c && measuredWidth > i17) {
                    i19 = this.f29143a + paddingTop;
                    this.f29146d++;
                    i18 = paddingRight;
                }
                childAt.setTag(R$id.row_index_key, Integer.valueOf(this.f29146d - 1));
                int i21 = i18 + i16;
                int measuredWidth2 = childAt.getMeasuredWidth() + i21;
                int measuredHeight = childAt.getMeasuredHeight() + i19;
                if (z11) {
                    childAt.layout(i17 - measuredWidth2, i19, (i17 - i18) - i16, measuredHeight);
                } else {
                    childAt.layout(i21, i19, measuredWidth2, measuredHeight);
                }
                i18 += i16 + i15 + childAt.getMeasuredWidth() + this.f29144b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int size = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i12);
        int i16 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i16 - getPaddingRight();
        int i17 = paddingTop;
        int i18 = 0;
        for (int i19 = 0; i19 < getChildCount(); i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i11, i12);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = marginLayoutParams.leftMargin;
                    i14 = marginLayoutParams.rightMargin;
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                int i20 = paddingLeft;
                if (paddingLeft + i13 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                    i15 = i20;
                } else {
                    i15 = getPaddingLeft();
                    i17 = this.f29143a + paddingTop;
                }
                int measuredWidth = i15 + i13 + childAt.getMeasuredWidth();
                int measuredHeight = i17 + childAt.getMeasuredHeight();
                if (measuredWidth > i18) {
                    i18 = measuredWidth;
                }
                paddingLeft = i15 + i13 + i14 + childAt.getMeasuredWidth() + this.f29144b;
                if (i19 == getChildCount() - 1) {
                    i18 += i14;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i18 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemSpacing(int i11) {
        this.f29144b = i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineSpacing(int i11) {
        this.f29143a = i11;
    }

    public void setSingleLine(boolean z10) {
        this.f29145c = z10;
    }
}
