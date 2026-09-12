package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class FlexboxLayout extends ViewGroup implements a {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;

    /* renamed from: a, reason: collision with root package name */
    private int f28128a;

    /* renamed from: b, reason: collision with root package name */
    private int f28129b;

    /* renamed from: c, reason: collision with root package name */
    private int f28130c;

    /* renamed from: d, reason: collision with root package name */
    private int f28131d;

    /* renamed from: e, reason: collision with root package name */
    private int f28132e;

    /* renamed from: f, reason: collision with root package name */
    private int f28133f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f28134g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f28135h;

    /* renamed from: i, reason: collision with root package name */
    private int f28136i;

    /* renamed from: j, reason: collision with root package name */
    private int f28137j;

    /* renamed from: k, reason: collision with root package name */
    private int f28138k;

    /* renamed from: l, reason: collision with root package name */
    private int f28139l;

    /* renamed from: m, reason: collision with root package name */
    private int[] f28140m;

    /* renamed from: n, reason: collision with root package name */
    private SparseIntArray f28141n;

    /* renamed from: o, reason: collision with root package name */
    private c f28142o;

    /* renamed from: p, reason: collision with root package name */
    private List f28143p;

    /* renamed from: q, reason: collision with root package name */
    private c.b f28144q;

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private int mOrder;
        private boolean mWrapBefore;

        /* loaded from: classes3.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i11) {
                return new LayoutParams[i11];
            }
        }

        public LayoutParams(int i11, int i12) {
            super(new ViewGroup.LayoutParams(i11, i12));
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout_Layout);
            this.mOrder = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = obtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = obtainStyledAttributes.getFloat(R$styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = obtainStyledAttributes.getFraction(R$styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = obtainStyledAttributes.getBoolean(R$styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = layoutParams.mOrder;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.mOrder;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        public void setAlignSelf(int i11) {
            this.mAlignSelf = i11;
        }

        public void setFlexBasisPercent(float f11) {
            this.mFlexBasisPercent = f11;
        }

        public void setFlexGrow(float f11) {
            this.mFlexGrow = f11;
        }

        public void setFlexShrink(float f11) {
            this.mFlexShrink = f11;
        }

        public void setHeight(int i11) {
            ((ViewGroup.MarginLayoutParams) this).height = i11;
        }

        public void setMaxHeight(int i11) {
            this.mMaxHeight = i11;
        }

        public void setMaxWidth(int i11) {
            this.mMaxWidth = i11;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i11) {
            this.mMinHeight = i11;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i11) {
            this.mMinWidth = i11;
        }

        public void setOrder(int i11) {
            this.mOrder = i11;
        }

        public void setWidth(int i11) {
            ((ViewGroup.MarginLayoutParams) this).width = i11;
        }

        public void setWrapBefore(boolean z10) {
            this.mWrapBefore = z10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mOrder);
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f28133f = -1;
        this.f28142o = new c(this);
        this.f28143p = new ArrayList();
        this.f28144q = new c.b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlexboxLayout, i11, 0);
        this.f28128a = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexDirection, 0);
        this.f28129b = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_flexWrap, 0);
        this.f28130c = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_justifyContent, 0);
        this.f28131d = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignItems, 0);
        this.f28132e = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_alignContent, 0);
        this.f28133f = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R$styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i12 = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDivider, 0);
        if (i12 != 0) {
            this.f28137j = i12;
            this.f28136i = i12;
        }
        int i13 = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerVertical, 0);
        if (i13 != 0) {
            this.f28137j = i13;
        }
        int i14 = obtainStyledAttributes.getInt(R$styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i14 != 0) {
            this.f28136i = i14;
        }
        obtainStyledAttributes.recycle();
    }

    private boolean a(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (((b) this.f28143p.get(i12)).c() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean b(int i11, int i12) {
        for (int i13 = 1; i13 <= i12; i13++) {
            View reorderedChildAt = getReorderedChildAt(i11 - i13);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void c(Canvas canvas, boolean z10, boolean z11) {
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f28143p.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f28143p.get(i11);
            for (int i12 = 0; i12 < bVar.f28196h; i12++) {
                int i13 = bVar.f28203o + i12;
                View reorderedChildAt = getReorderedChildAt(i13);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i13, i12)) {
                        f(canvas, z10 ? reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f28139l, bVar.f28190b, bVar.f28195g);
                    }
                    if (i12 == bVar.f28196h - 1 && (this.f28137j & 4) > 0) {
                        f(canvas, z10 ? (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f28139l : reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, bVar.f28190b, bVar.f28195g);
                    }
                }
            }
            if (h(i11)) {
                e(canvas, paddingLeft, z11 ? bVar.f28192d : bVar.f28190b - this.f28138k, max);
            }
            if (i(i11) && (this.f28136i & 4) > 0) {
                e(canvas, paddingLeft, z11 ? bVar.f28190b - this.f28138k : bVar.f28192d, max);
            }
        }
    }

    private void d(Canvas canvas, boolean z10, boolean z11) {
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f28143p.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f28143p.get(i11);
            for (int i12 = 0; i12 < bVar.f28196h; i12++) {
                int i13 = bVar.f28203o + i12;
                View reorderedChildAt = getReorderedChildAt(i13);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i13, i12)) {
                        e(canvas, bVar.f28189a, z11 ? reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f28138k, bVar.f28195g);
                    }
                    if (i12 == bVar.f28196h - 1 && (this.f28136i & 4) > 0) {
                        e(canvas, bVar.f28189a, z11 ? (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f28138k : reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, bVar.f28195g);
                    }
                }
            }
            if (h(i11)) {
                f(canvas, z10 ? bVar.f28191c : bVar.f28189a - this.f28139l, paddingTop, max);
            }
            if (i(i11) && (this.f28137j & 4) > 0) {
                f(canvas, z10 ? bVar.f28189a - this.f28139l : bVar.f28191c, paddingTop, max);
            }
        }
    }

    private void e(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.f28134g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i11, i12, i13 + i11, this.f28138k + i12);
        this.f28134g.draw(canvas);
    }

    private void f(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.f28135h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i11, i12, this.f28139l + i11, i13 + i12);
        this.f28135h.draw(canvas);
    }

    private boolean g(int i11, int i12) {
        return b(i11, i12) ? isMainAxisDirectionHorizontal() ? (this.f28137j & 1) != 0 : (this.f28136i & 1) != 0 : isMainAxisDirectionHorizontal() ? (this.f28137j & 2) != 0 : (this.f28136i & 2) != 0;
    }

    private boolean h(int i11) {
        if (i11 < 0 || i11 >= this.f28143p.size()) {
            return false;
        }
        return a(i11) ? isMainAxisDirectionHorizontal() ? (this.f28136i & 1) != 0 : (this.f28137j & 1) != 0 : isMainAxisDirectionHorizontal() ? (this.f28136i & 2) != 0 : (this.f28137j & 2) != 0;
    }

    private boolean i(int i11) {
        if (i11 < 0 || i11 >= this.f28143p.size()) {
            return false;
        }
        for (int i12 = i11 + 1; i12 < this.f28143p.size(); i12++) {
            if (((b) this.f28143p.get(i12)).c() > 0) {
                return false;
            }
        }
        return isMainAxisDirectionHorizontal() ? (this.f28136i & 4) != 0 : (this.f28137j & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.j(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void k(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.k(boolean, boolean, int, int, int, int):void");
    }

    private void l(int i11, int i12) {
        this.f28143p.clear();
        this.f28144q.a();
        this.f28142o.c(this.f28144q, i11, i12);
        this.f28143p = this.f28144q.f28212a;
        this.f28142o.p(i11, i12);
        if (this.f28131d == 3) {
            for (b bVar : this.f28143p) {
                int i13 = Integer.MIN_VALUE;
                for (int i14 = 0; i14 < bVar.f28196h; i14++) {
                    View reorderedChildAt = getReorderedChildAt(bVar.f28203o + i14);
                    if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        i13 = this.f28129b != 2 ? Math.max(i13, reorderedChildAt.getMeasuredHeight() + Math.max(bVar.f28200l - reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(i13, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((bVar.f28200l - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                bVar.f28195g = i13;
            }
        }
        this.f28142o.o(i11, i12, getPaddingTop() + getPaddingBottom());
        this.f28142o.X();
        n(this.f28128a, i11, i12, this.f28144q.f28213b);
    }

    private void m(int i11, int i12) {
        this.f28143p.clear();
        this.f28144q.a();
        this.f28142o.f(this.f28144q, i11, i12);
        this.f28143p = this.f28144q.f28212a;
        this.f28142o.p(i11, i12);
        this.f28142o.o(i11, i12, getPaddingLeft() + getPaddingRight());
        this.f28142o.X();
        n(this.f28128a, i11, i12, this.f28144q.f28213b);
    }

    private void n(int i11, int i12, int i13, int i14) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i13);
        int size2 = View.MeasureSpec.getSize(i13);
        if (i11 == 0 || i11 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i11 != 2 && i11 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i11);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i12, i14);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i12, i14);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i12, i14);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i14 = View.combineMeasuredStates(i14, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i13, i14);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i13, i14);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                i14 = View.combineMeasuredStates(i14, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i13, i14);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    private void o() {
        if (this.f28134g == null && this.f28135h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (this.f28141n == null) {
            this.f28141n = new SparseIntArray(getChildCount());
        }
        this.f28140m = this.f28142o.n(view, i11, layoutParams, this.f28141n);
        super.addView(view, i11, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.f28132e;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f28131d;
    }

    @Override // com.google.android.flexbox.a
    public int getChildHeightMeasureSpec(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    @Override // com.google.android.flexbox.a
    public int getChildWidthMeasureSpec(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthMainAxis(View view, int i11, int i12) {
        int i13;
        int i14;
        if (isMainAxisDirectionHorizontal()) {
            i13 = g(i11, i12) ? this.f28139l : 0;
            if ((this.f28137j & 4) <= 0) {
                return i13;
            }
            i14 = this.f28139l;
        } else {
            i13 = g(i11, i12) ? this.f28138k : 0;
            if ((this.f28136i & 4) <= 0) {
                return i13;
            }
            i14 = this.f28138k;
        }
        return i13 + i14;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f28134g;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f28135h;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f28128a;
    }

    @Override // com.google.android.flexbox.a
    public View getFlexItemAt(int i11) {
        return getChildAt(i11);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f28143p.size());
        for (b bVar : this.f28143p) {
            if (bVar.c() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.f28143p;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.f28129b;
    }

    public int getJustifyContent() {
        return this.f28130c;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        Iterator it = this.f28143p.iterator();
        int i11 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            i11 = Math.max(i11, ((b) it.next()).f28193e);
        }
        return i11;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f28133f;
    }

    public View getReorderedChildAt(int i11) {
        if (i11 < 0) {
            return null;
        }
        int[] iArr = this.f28140m;
        if (i11 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i11]);
    }

    @Override // com.google.android.flexbox.a
    public View getReorderedFlexItemAt(int i11) {
        return getReorderedChildAt(i11);
    }

    public int getShowDividerHorizontal() {
        return this.f28136i;
    }

    public int getShowDividerVertical() {
        return this.f28137j;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.f28143p.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = (b) this.f28143p.get(i12);
            if (h(i12)) {
                i11 += isMainAxisDirectionHorizontal() ? this.f28138k : this.f28139l;
            }
            if (i(i12)) {
                i11 += isMainAxisDirectionHorizontal() ? this.f28138k : this.f28139l;
            }
            i11 += bVar.f28195g;
        }
        return i11;
    }

    @Override // com.google.android.flexbox.a
    public boolean isMainAxisDirectionHorizontal() {
        int i11 = this.f28128a;
        return i11 == 0 || i11 == 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f28135h == null && this.f28134g == null) {
            return;
        }
        if (this.f28136i == 0 && this.f28137j == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i11 = this.f28128a;
        if (i11 == 0) {
            c(canvas, layoutDirection == 1, this.f28129b == 2);
            return;
        }
        if (i11 == 1) {
            c(canvas, layoutDirection != 1, this.f28129b == 2);
            return;
        }
        if (i11 == 2) {
            boolean z10 = layoutDirection == 1;
            if (this.f28129b == 2) {
                z10 = !z10;
            }
            d(canvas, z10, false);
            return;
        }
        if (i11 != 3) {
            return;
        }
        boolean z11 = layoutDirection == 1;
        if (this.f28129b == 2) {
            z11 = !z11;
        }
        d(canvas, z11, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        boolean z11;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i15 = this.f28128a;
        if (i15 == 0) {
            j(layoutDirection == 1, i11, i12, i13, i14);
            return;
        }
        if (i15 == 1) {
            j(layoutDirection != 1, i11, i12, i13, i14);
            return;
        }
        if (i15 == 2) {
            z11 = layoutDirection == 1;
            k(this.f28129b == 2 ? !z11 : z11, false, i11, i12, i13, i14);
        } else if (i15 == 3) {
            z11 = layoutDirection == 1;
            k(this.f28129b == 2 ? !z11 : z11, true, i11, i12, i13, i14);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.f28128a);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        if (this.f28141n == null) {
            this.f28141n = new SparseIntArray(getChildCount());
        }
        if (this.f28142o.O(this.f28141n)) {
            this.f28140m = this.f28142o.m(this.f28141n);
        }
        int i13 = this.f28128a;
        if (i13 == 0 || i13 == 1) {
            l(i11, i12);
            return;
        }
        if (i13 == 2 || i13 == 3) {
            m(i11, i12);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f28128a);
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexItemAdded(View view, int i11, int i12, b bVar) {
        if (g(i11, i12)) {
            if (isMainAxisDirectionHorizontal()) {
                int i13 = bVar.f28193e;
                int i14 = this.f28139l;
                bVar.f28193e = i13 + i14;
                bVar.f28194f += i14;
                return;
            }
            int i15 = bVar.f28193e;
            int i16 = this.f28138k;
            bVar.f28193e = i15 + i16;
            bVar.f28194f += i16;
        }
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexLineAdded(b bVar) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.f28137j & 4) > 0) {
                int i11 = bVar.f28193e;
                int i12 = this.f28139l;
                bVar.f28193e = i11 + i12;
                bVar.f28194f += i12;
                return;
            }
            return;
        }
        if ((this.f28136i & 4) > 0) {
            int i13 = bVar.f28193e;
            int i14 = this.f28138k;
            bVar.f28193e = i13 + i14;
            bVar.f28194f += i14;
        }
    }

    public void setAlignContent(int i11) {
        if (this.f28132e != i11) {
            this.f28132e = i11;
            requestLayout();
        }
    }

    public void setAlignItems(int i11) {
        if (this.f28131d != i11) {
            this.f28131d = i11;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.f28134g) {
            return;
        }
        this.f28134g = drawable;
        if (drawable != null) {
            this.f28138k = drawable.getIntrinsicHeight();
        } else {
            this.f28138k = 0;
        }
        o();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.f28135h) {
            return;
        }
        this.f28135h = drawable;
        if (drawable != null) {
            this.f28139l = drawable.getIntrinsicWidth();
        } else {
            this.f28139l = 0;
        }
        o();
        requestLayout();
    }

    public void setFlexDirection(int i11) {
        if (this.f28128a != i11) {
            this.f28128a = i11;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.f28143p = list;
    }

    public void setFlexWrap(int i11) {
        if (this.f28129b != i11) {
            this.f28129b = i11;
            requestLayout();
        }
    }

    public void setJustifyContent(int i11) {
        if (this.f28130c != i11) {
            this.f28130c = i11;
            requestLayout();
        }
    }

    public void setMaxLine(int i11) {
        if (this.f28133f != i11) {
            this.f28133f = i11;
            requestLayout();
        }
    }

    public void setShowDivider(int i11) {
        setShowDividerVertical(i11);
        setShowDividerHorizontal(i11);
    }

    public void setShowDividerHorizontal(int i11) {
        if (i11 != this.f28136i) {
            this.f28136i = i11;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i11) {
        if (i11 != this.f28137j) {
            this.f28137j = i11;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void updateViewCache(int i11, View view) {
    }
}
