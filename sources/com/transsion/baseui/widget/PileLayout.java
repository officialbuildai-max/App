package com.transsion.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.transsion.baseui.R$styleable;

/* loaded from: classes5.dex */
public class PileLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    protected float f43642a;

    /* renamed from: b, reason: collision with root package name */
    protected float f43643b;

    public PileLayout(Context context) {
        this(context, null, 0);
    }

    public PileLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PileLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PileLayout);
        this.f43642a = obtainStyledAttributes.getDimension(R$styleable.PileLayout_PileLayout_vertivalSpace, dp2px(4.0f));
        this.f43643b = obtainStyledAttributes.getDimension(R$styleable.PileLayout_PileLayout_pileWidth, dp2px(10.0f));
        obtainStyledAttributes.recycle();
    }

    public float dp2px(float f11) {
        return TypedValue.applyDimension(1, f11, getResources().getDisplayMetrics());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int i15 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = marginLayoutParams.leftMargin + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin;
                if (paddingLeft + measuredWidth + getPaddingRight() > i15) {
                    paddingLeft = getPaddingLeft();
                    paddingTop = (int) (paddingTop + i16 + this.f43642a);
                    i16 = 0;
                    i17 = 0;
                }
                int i19 = marginLayoutParams.leftMargin;
                childAt.layout(paddingLeft + i19, marginLayoutParams.topMargin + paddingTop, i19 + paddingLeft + childAt.getMeasuredWidth(), marginLayoutParams.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth;
                int measuredHeight = marginLayoutParams.topMargin + childAt.getMeasuredHeight() + marginLayoutParams.bottomMargin;
                if (i17 != childCount - 1) {
                    paddingLeft = (int) (paddingLeft - this.f43643b);
                }
                i16 = Math.max(i16, measuredHeight);
                i17++;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int i13;
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int childCount = getChildCount();
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i16 < childCount) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 8) {
                if (i16 == childCount - 1) {
                    i15 += i14;
                    i17 = Math.max(i17, i18);
                }
                i13 = size2;
            } else {
                int i20 = i14;
                i13 = size2;
                int i21 = i15;
                measureChildWithMargins(childAt, i11, 0, i12, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i22 = i18 + measuredWidth;
                float f11 = i22;
                if (f11 - (i19 > 0 ? this.f43643b : 0.0f) > (size - getPaddingLeft()) - getPaddingRight()) {
                    i17 = Math.max(i17, i18);
                    i15 = (int) (i21 + i20 + this.f43642a);
                    i18 = measuredWidth;
                    i14 = measuredHeight;
                    i19 = 0;
                } else {
                    if (i19 > 0) {
                        i22 = (int) (f11 - this.f43643b);
                    }
                    i18 = i22;
                    i14 = Math.max(i20, measuredHeight);
                    i15 = i21;
                }
                if (i16 == childCount - 1) {
                    i15 += i14;
                    i17 = Math.max(i18, i17);
                }
                i19++;
            }
            i16++;
            size2 = i13;
        }
        int i23 = size2;
        int i24 = i15;
        if (mode != 1073741824) {
            size = i17 + getPaddingLeft() + getPaddingRight();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i23 : i24 + getPaddingTop() + getPaddingBottom());
    }
}
