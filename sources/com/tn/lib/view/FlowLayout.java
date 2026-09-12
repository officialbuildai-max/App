package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.tn.lib.widget.R$styleable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FlowLayout extends ViewGroup {
    public static final int SPACING_ALIGN = -65537;
    public static final int SPACING_AUTO = -65536;

    /* renamed from: a, reason: collision with root package name */
    private boolean f40975a;

    /* renamed from: b, reason: collision with root package name */
    private int f40976b;

    /* renamed from: c, reason: collision with root package name */
    private int f40977c;

    /* renamed from: d, reason: collision with root package name */
    private int f40978d;

    /* renamed from: e, reason: collision with root package name */
    private float f40979e;

    /* renamed from: f, reason: collision with root package name */
    private float f40980f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f40981g;

    /* renamed from: h, reason: collision with root package name */
    private int f40982h;

    /* renamed from: i, reason: collision with root package name */
    private int f40983i;

    /* renamed from: j, reason: collision with root package name */
    private int f40984j;

    /* renamed from: k, reason: collision with root package name */
    private int f40985k;

    /* renamed from: l, reason: collision with root package name */
    private List f40986l;

    /* renamed from: m, reason: collision with root package name */
    private List f40987m;

    /* renamed from: n, reason: collision with root package name */
    private List f40988n;

    /* renamed from: o, reason: collision with root package name */
    private List f40989o;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40975a = true;
        this.f40976b = 0;
        this.f40977c = 0;
        this.f40978d = -65538;
        this.f40979e = 0.0f;
        this.f40980f = 0.0f;
        this.f40981g = false;
        this.f40982h = Integer.MAX_VALUE;
        this.f40983i = -1;
        this.f40984j = SPACING_AUTO;
        this.f40986l = new ArrayList();
        this.f40987m = new ArrayList();
        this.f40988n = new ArrayList();
        this.f40989o = new ArrayList();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        try {
            this.f40975a = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_flFlow, true);
            this.f40976b = b(obtainStyledAttributes, R$styleable.FlowLayout_flChildSpacing, (int) a(0.0f));
            this.f40977c = b(obtainStyledAttributes, R$styleable.FlowLayout_flMinChildSpacing, (int) a(0.0f));
            this.f40978d = b(obtainStyledAttributes, R$styleable.FlowLayout_flChildSpacingForLastRow, -65538);
            this.f40979e = b(obtainStyledAttributes, R$styleable.FlowLayout_flRowSpacing, (int) a(0.0f));
            this.f40982h = obtainStyledAttributes.getInt(R$styleable.FlowLayout_flMaxRows, Integer.MAX_VALUE);
            this.f40981g = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_flRtl, false);
            this.f40983i = obtainStyledAttributes.getInt(R$styleable.FlowLayout_android_gravity, -1);
            this.f40984j = obtainStyledAttributes.getInt(R$styleable.FlowLayout_flRowVerticalGravity, SPACING_AUTO);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private float a(float f11) {
        return TypedValue.applyDimension(1, f11, getResources().getDisplayMetrics());
    }

    private int b(TypedArray typedArray, int i11, int i12) {
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i11, typedValue);
        return typedValue.type == 5 ? typedArray.getDimensionPixelSize(i11, i12) : typedArray.getInt(i11, i12);
    }

    private int c(int i11, int i12, int i13, int i14) {
        if (this.f40976b == -65536 || i14 >= this.f40988n.size() || i14 >= this.f40989o.size() || ((Integer) this.f40989o.get(i14)).intValue() <= 0) {
            return 0;
        }
        if (i11 == 1) {
            return ((i12 - i13) - ((Integer) this.f40988n.get(i14)).intValue()) / 2;
        }
        if (i11 != 5) {
            return 0;
        }
        return (i12 - i13) - ((Integer) this.f40988n.get(i14)).intValue();
    }

    private float d(int i11, int i12, int i13, int i14) {
        if (i11 != -65536) {
            return i11;
        }
        if (i14 > 1) {
            return (i12 - i13) / (i14 - 1);
        }
        return 0.0f;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildSpacing() {
        return this.f40976b;
    }

    public int getChildSpacingForLastRow() {
        return this.f40978d;
    }

    public int getCountInRow(int i11) {
        return ((Integer) this.f40989o.get(i11)).intValue();
    }

    public int getMaxRows() {
        return this.f40982h;
    }

    public int getMinChildSpacing() {
        return this.f40977c;
    }

    public float getRowSpacing() {
        return this.f40979e;
    }

    public int getRowsCount() {
        return this.f40989o.size();
    }

    public boolean isFlow() {
        return this.f40975a;
    }

    public boolean isRtl() {
        return this.f40981g;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0174  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.lib.view.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int i13;
        int min;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        float f11;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        View view;
        int i25;
        int i26;
        int measuredWidth;
        int i27;
        int i28;
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i12);
        this.f40986l.clear();
        this.f40987m.clear();
        this.f40988n.clear();
        this.f40989o.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z10 = mode != 0 && this.f40975a;
        int i29 = this.f40976b;
        int i30 = SPACING_AUTO;
        int i31 = (i29 == -65536 && mode == 0) ? 0 : i29;
        float f12 = i31 == -65536 ? this.f40977c : i31;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        while (i34 < childCount) {
            float f13 = f12;
            View childAt = getChildAt(i34);
            int i39 = i32;
            if (childAt.getVisibility() == 8) {
                i15 = i34;
                i27 = i31;
                i17 = mode;
                i18 = mode2;
                i19 = childCount;
                f11 = f13;
                i28 = i39;
                i21 = SPACING_AUTO;
                measuredWidth = i33;
                i22 = size;
                i23 = size2;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i19 = childCount;
                    i20 = i39;
                    i23 = size2;
                    i24 = i33;
                    i15 = i34;
                    i18 = mode2;
                    f11 = f13;
                    i22 = size;
                    view = childAt;
                    i16 = i31;
                    i17 = mode;
                    i21 = SPACING_AUTO;
                    measureChildWithMargins(childAt, i11, 0, i12, i37);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i25 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i26 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    i15 = i34;
                    i16 = i31;
                    i17 = mode;
                    i18 = mode2;
                    i19 = childCount;
                    f11 = f13;
                    i20 = i39;
                    i21 = SPACING_AUTO;
                    i22 = size;
                    i23 = size2;
                    i24 = i33;
                    view = childAt;
                    measureChild(view, i11, i12);
                    i25 = 0;
                    i26 = 0;
                }
                measuredWidth = i25 + view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight() + i26;
                if (!z10 || i36 + measuredWidth <= paddingLeft) {
                    i27 = i16;
                    i28 = i20 + 1;
                    i36 = (int) (i36 + measuredWidth + f11);
                    measuredWidth += i24;
                    i38 = Math.max(i38, measuredHeight);
                } else {
                    i27 = i16;
                    this.f40986l.add(Float.valueOf(d(i27, paddingLeft, i24, i20)));
                    this.f40989o.add(Integer.valueOf(i20));
                    this.f40987m.add(Integer.valueOf(i38));
                    int i40 = (int) f11;
                    this.f40988n.add(Integer.valueOf(i36 - i40));
                    if (this.f40986l.size() <= this.f40982h) {
                        i37 += i38;
                    }
                    i35 = Math.max(i35, i36);
                    i36 = measuredWidth + i40;
                    i38 = measuredHeight;
                    i28 = 1;
                }
            }
            i33 = measuredWidth;
            i32 = i28;
            i34 = i15 + 1;
            i31 = i27;
            i30 = i21;
            f12 = f11;
            size = i22;
            size2 = i23;
            mode = i17;
            childCount = i19;
            mode2 = i18;
        }
        int i41 = i32;
        int i42 = size;
        int i43 = mode;
        int i44 = size2;
        int i45 = mode2;
        int i46 = i38;
        int i47 = i33;
        float f14 = f12;
        int i48 = i30;
        int i49 = i31;
        int i50 = this.f40978d;
        if (i50 == -65537) {
            if (this.f40986l.size() >= 1) {
                List list = this.f40986l;
                list.add((Float) list.get(list.size() - 1));
            } else {
                this.f40986l.add(Float.valueOf(d(i49, paddingLeft, i47, i41)));
            }
        } else if (i50 != -65538) {
            this.f40986l.add(Float.valueOf(d(i50, paddingLeft, i47, i41)));
        } else {
            this.f40986l.add(Float.valueOf(d(i49, paddingLeft, i47, i41)));
        }
        this.f40989o.add(Integer.valueOf(i41));
        this.f40987m.add(Integer.valueOf(i46));
        this.f40988n.add(Integer.valueOf(i36 - ((int) f14)));
        if (this.f40986l.size() <= this.f40982h) {
            i37 += i46;
        }
        int max = Math.max(i35, i36);
        if (i49 == i48) {
            min = i42;
            i13 = min;
        } else if (i43 == 0) {
            min = max + getPaddingLeft() + getPaddingRight();
            i13 = i42;
        } else {
            i13 = i42;
            min = Math.min(max + getPaddingLeft() + getPaddingRight(), i13);
        }
        int paddingTop = i37 + getPaddingTop() + getPaddingBottom();
        int min2 = Math.min(this.f40986l.size(), this.f40982h);
        float f15 = this.f40979e;
        if (f15 == -65536.0f && i45 == 0) {
            f15 = 0.0f;
        }
        if (f15 == -65536.0f) {
            if (min2 > 1) {
                this.f40980f = (i44 - paddingTop) / (min2 - 1);
            } else {
                this.f40980f = 0.0f;
            }
            paddingTop = i44;
            i14 = paddingTop;
        } else {
            this.f40980f = f15;
            if (min2 > 1) {
                if (i45 == 0) {
                    paddingTop = (int) (paddingTop + (f15 * (min2 - 1)));
                } else {
                    int i51 = (int) (paddingTop + (f15 * (min2 - 1)));
                    i14 = i44;
                    paddingTop = Math.min(i51, i14);
                }
            }
            i14 = i44;
        }
        this.f40985k = paddingTop;
        setMeasuredDimension(i43 == 1073741824 ? i13 : min, i45 == 1073741824 ? i14 : paddingTop);
    }

    public void setChildSpacing(int i11) {
        this.f40976b = i11;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int i11) {
        this.f40978d = i11;
        requestLayout();
    }

    public void setFlow(boolean z10) {
        this.f40975a = z10;
        requestLayout();
    }

    public void setGravity(int i11) {
        if (this.f40983i != i11) {
            this.f40983i = i11;
            requestLayout();
        }
    }

    public void setMaxRows(int i11) {
        this.f40982h = i11;
        requestLayout();
    }

    public void setMinChildSpacing(int i11) {
        this.f40977c = i11;
        requestLayout();
    }

    public void setRowSpacing(float f11) {
        this.f40979e = f11;
        requestLayout();
    }

    public void setRowVerticalGravity(int i11) {
        if (this.f40984j != i11) {
            this.f40984j = i11;
            requestLayout();
        }
    }

    public void setRtl(boolean z10) {
        this.f40981g = z10;
        requestLayout();
    }
}
