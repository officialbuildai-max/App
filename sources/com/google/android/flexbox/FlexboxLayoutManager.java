package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.m;
import com.google.android.flexbox.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FlexboxLayoutManager extends RecyclerView.m implements com.google.android.flexbox.a, RecyclerView.x.b {
    private static final Rect A = new Rect();

    /* renamed from: a, reason: collision with root package name */
    private int f28145a;

    /* renamed from: b, reason: collision with root package name */
    private int f28146b;

    /* renamed from: c, reason: collision with root package name */
    private int f28147c;

    /* renamed from: d, reason: collision with root package name */
    private int f28148d;

    /* renamed from: e, reason: collision with root package name */
    private int f28149e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28150f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28151g;

    /* renamed from: h, reason: collision with root package name */
    private List f28152h;

    /* renamed from: i, reason: collision with root package name */
    private final com.google.android.flexbox.c f28153i;

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView.t f28154j;

    /* renamed from: k, reason: collision with root package name */
    private RecyclerView.y f28155k;

    /* renamed from: l, reason: collision with root package name */
    private c f28156l;

    /* renamed from: m, reason: collision with root package name */
    private b f28157m;

    /* renamed from: n, reason: collision with root package name */
    private m f28158n;

    /* renamed from: o, reason: collision with root package name */
    private m f28159o;

    /* renamed from: p, reason: collision with root package name */
    private SavedState f28160p;

    /* renamed from: q, reason: collision with root package name */
    private int f28161q;

    /* renamed from: r, reason: collision with root package name */
    private int f28162r;

    /* renamed from: s, reason: collision with root package name */
    private int f28163s;

    /* renamed from: t, reason: collision with root package name */
    private int f28164t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f28165u;

    /* renamed from: v, reason: collision with root package name */
    private SparseArray f28166v;

    /* renamed from: w, reason: collision with root package name */
    private final Context f28167w;

    /* renamed from: x, reason: collision with root package name */
    private View f28168x;

    /* renamed from: y, reason: collision with root package name */
    private int f28169y;

    /* renamed from: z, reason: collision with root package name */
    private c.b f28170z;

    /* loaded from: classes3.dex */
    public static class LayoutParams extends RecyclerView.n implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
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
            super(i11, i12);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
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
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(RecyclerView.n nVar) {
            super(nVar);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.n) layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
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
            return 1;
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
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        public void setWidth(int i11) {
            ((ViewGroup.MarginLayoutParams) this).width = i11;
        }

        public void setWrapBefore(boolean z10) {
            this.mWrapBefore = z10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int mAnchorOffset;
        private int mAnchorPosition;

        /* loaded from: classes3.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g(int i11) {
            int i12 = this.mAnchorPosition;
            return i12 >= 0 && i12 < i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private int f28171a;

        /* renamed from: b, reason: collision with root package name */
        private int f28172b;

        /* renamed from: c, reason: collision with root package name */
        private int f28173c;

        /* renamed from: d, reason: collision with root package name */
        private int f28174d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f28175e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f28176f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f28177g;

        private b() {
            this.f28174d = 0;
        }

        static /* synthetic */ int l(b bVar, int i11) {
            int i12 = bVar.f28174d + i11;
            bVar.f28174d = i12;
            return i12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f28150f) {
                this.f28173c = this.f28175e ? FlexboxLayoutManager.this.f28158n.i() : FlexboxLayoutManager.this.f28158n.m();
            } else {
                this.f28173c = this.f28175e ? FlexboxLayoutManager.this.f28158n.i() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.f28158n.m();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(View view) {
            m mVar = FlexboxLayoutManager.this.f28146b == 0 ? FlexboxLayoutManager.this.f28159o : FlexboxLayoutManager.this.f28158n;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f28150f) {
                if (this.f28175e) {
                    this.f28173c = mVar.d(view) + mVar.o();
                } else {
                    this.f28173c = mVar.g(view);
                }
            } else if (this.f28175e) {
                this.f28173c = mVar.g(view) + mVar.o();
            } else {
                this.f28173c = mVar.d(view);
            }
            this.f28171a = FlexboxLayoutManager.this.getPosition(view);
            this.f28177g = false;
            int[] iArr = FlexboxLayoutManager.this.f28153i.f28209c;
            int i11 = this.f28171a;
            if (i11 == -1) {
                i11 = 0;
            }
            int i12 = iArr[i11];
            this.f28172b = i12 != -1 ? i12 : 0;
            if (FlexboxLayoutManager.this.f28152h.size() > this.f28172b) {
                this.f28171a = ((com.google.android.flexbox.b) FlexboxLayoutManager.this.f28152h.get(this.f28172b)).f28203o;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t() {
            this.f28171a = -1;
            this.f28172b = -1;
            this.f28173c = Integer.MIN_VALUE;
            this.f28176f = false;
            this.f28177g = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.f28146b == 0) {
                    this.f28175e = FlexboxLayoutManager.this.f28145a == 1;
                    return;
                } else {
                    this.f28175e = FlexboxLayoutManager.this.f28146b == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f28146b == 0) {
                this.f28175e = FlexboxLayoutManager.this.f28145a == 3;
            } else {
                this.f28175e = FlexboxLayoutManager.this.f28146b == 2;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f28171a + ", mFlexLinePosition=" + this.f28172b + ", mCoordinate=" + this.f28173c + ", mPerpendicularCoordinate=" + this.f28174d + ", mLayoutFromEnd=" + this.f28175e + ", mValid=" + this.f28176f + ", mAssignedFromSavedState=" + this.f28177g + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f28179a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f28180b;

        /* renamed from: c, reason: collision with root package name */
        private int f28181c;

        /* renamed from: d, reason: collision with root package name */
        private int f28182d;

        /* renamed from: e, reason: collision with root package name */
        private int f28183e;

        /* renamed from: f, reason: collision with root package name */
        private int f28184f;

        /* renamed from: g, reason: collision with root package name */
        private int f28185g;

        /* renamed from: h, reason: collision with root package name */
        private int f28186h;

        /* renamed from: i, reason: collision with root package name */
        private int f28187i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f28188j;

        private c() {
            this.f28186h = 1;
            this.f28187i = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean D(RecyclerView.y yVar, List list) {
            int i11;
            int i12 = this.f28182d;
            return i12 >= 0 && i12 < yVar.b() && (i11 = this.f28181c) >= 0 && i11 < list.size();
        }

        static /* synthetic */ int c(c cVar, int i11) {
            int i12 = cVar.f28183e + i11;
            cVar.f28183e = i12;
            return i12;
        }

        static /* synthetic */ int d(c cVar, int i11) {
            int i12 = cVar.f28183e - i11;
            cVar.f28183e = i12;
            return i12;
        }

        static /* synthetic */ int i(c cVar, int i11) {
            int i12 = cVar.f28179a - i11;
            cVar.f28179a = i12;
            return i12;
        }

        static /* synthetic */ int l(c cVar) {
            int i11 = cVar.f28181c;
            cVar.f28181c = i11 + 1;
            return i11;
        }

        static /* synthetic */ int m(c cVar) {
            int i11 = cVar.f28181c;
            cVar.f28181c = i11 - 1;
            return i11;
        }

        static /* synthetic */ int n(c cVar, int i11) {
            int i12 = cVar.f28181c + i11;
            cVar.f28181c = i12;
            return i12;
        }

        static /* synthetic */ int q(c cVar, int i11) {
            int i12 = cVar.f28184f + i11;
            cVar.f28184f = i12;
            return i12;
        }

        static /* synthetic */ int u(c cVar, int i11) {
            int i12 = cVar.f28182d + i11;
            cVar.f28182d = i12;
            return i12;
        }

        static /* synthetic */ int v(c cVar, int i11) {
            int i12 = cVar.f28182d - i11;
            cVar.f28182d = i12;
            return i12;
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.f28179a + ", mFlexLinePosition=" + this.f28181c + ", mPosition=" + this.f28182d + ", mOffset=" + this.f28183e + ", mScrollingOffset=" + this.f28184f + ", mLastScrollDelta=" + this.f28185g + ", mItemDirection=" + this.f28186h + ", mLayoutDirection=" + this.f28187i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public FlexboxLayoutManager(Context context, int i11, int i12) {
        this.f28149e = -1;
        this.f28152h = new ArrayList();
        this.f28153i = new com.google.android.flexbox.c(this);
        this.f28157m = new b();
        this.f28161q = -1;
        this.f28162r = Integer.MIN_VALUE;
        this.f28163s = Integer.MIN_VALUE;
        this.f28164t = Integer.MIN_VALUE;
        this.f28166v = new SparseArray();
        this.f28169y = -1;
        this.f28170z = new c.b();
        c0(i11);
        d0(i12);
        b0(4);
        this.f28167w = context;
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.f28149e = -1;
        this.f28152h = new ArrayList();
        this.f28153i = new com.google.android.flexbox.c(this);
        this.f28157m = new b();
        this.f28161q = -1;
        this.f28162r = Integer.MIN_VALUE;
        this.f28163s = Integer.MIN_VALUE;
        this.f28164t = Integer.MIN_VALUE;
        this.f28166v = new SparseArray();
        this.f28169y = -1;
        this.f28170z = new c.b();
        RecyclerView.m.d properties = RecyclerView.m.getProperties(context, attributeSet, i11, i12);
        int i13 = properties.f14320a;
        if (i13 != 0) {
            if (i13 == 1) {
                if (properties.f14322c) {
                    c0(3);
                } else {
                    c0(2);
                }
            }
        } else if (properties.f14322c) {
            c0(1);
        } else {
            c0(0);
        }
        d0(1);
        b0(4);
        this.f28167w = context;
    }

    private View A(View view, com.google.android.flexbox.b bVar) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i11 = bVar.f28196h;
        for (int i12 = 1; i12 < i11; i12++) {
            View childAt = getChildAt(i12);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f28150f || isMainAxisDirectionHorizontal) {
                    if (this.f28158n.g(view) <= this.f28158n.g(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.f28158n.d(view) >= this.f28158n.d(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View B(int i11) {
        View E = E(getChildCount() - 1, -1, i11);
        if (E == null) {
            return null;
        }
        return C(E, (com.google.android.flexbox.b) this.f28152h.get(this.f28153i.f28209c[getPosition(E)]));
    }

    private View C(View view, com.google.android.flexbox.b bVar) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - bVar.f28196h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f28150f || isMainAxisDirectionHorizontal) {
                    if (this.f28158n.d(view) >= this.f28158n.d(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.f28158n.g(view) <= this.f28158n.g(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View D(int i11, int i12, boolean z10) {
        int i13 = i12 > i11 ? 1 : -1;
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (R(childAt, z10)) {
                return childAt;
            }
            i11 += i13;
        }
        return null;
    }

    private View E(int i11, int i12, int i13) {
        int position;
        x();
        ensureLayoutState();
        int m11 = this.f28158n.m();
        int i14 = this.f28158n.i();
        int i15 = i12 > i11 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < i13) {
                if (((RecyclerView.n) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f28158n.g(childAt) >= m11 && this.f28158n.d(childAt) <= i14) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i11 += i15;
        }
        return view != null ? view : view2;
    }

    private int F(int i11, RecyclerView.t tVar, RecyclerView.y yVar, boolean z10) {
        int i12;
        int i13;
        if (isMainAxisDirectionHorizontal() || !this.f28150f) {
            int i14 = this.f28158n.i() - i11;
            if (i14 <= 0) {
                return 0;
            }
            i12 = -O(-i14, tVar, yVar);
        } else {
            int m11 = i11 - this.f28158n.m();
            if (m11 <= 0) {
                return 0;
            }
            i12 = O(m11, tVar, yVar);
        }
        int i15 = i11 + i12;
        if (!z10 || (i13 = this.f28158n.i() - i15) <= 0) {
            return i12;
        }
        this.f28158n.r(i13);
        return i13 + i12;
    }

    private int G(int i11, RecyclerView.t tVar, RecyclerView.y yVar, boolean z10) {
        int i12;
        int m11;
        if (isMainAxisDirectionHorizontal() || !this.f28150f) {
            int m12 = i11 - this.f28158n.m();
            if (m12 <= 0) {
                return 0;
            }
            i12 = -O(m12, tVar, yVar);
        } else {
            int i13 = this.f28158n.i() - i11;
            if (i13 <= 0) {
                return 0;
            }
            i12 = O(-i13, tVar, yVar);
        }
        int i14 = i11 + i12;
        if (!z10 || (m11 = i14 - this.f28158n.m()) <= 0) {
            return i12;
        }
        this.f28158n.r(-m11);
        return i12 - m11;
    }

    private int H(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).bottomMargin;
    }

    private View I() {
        return getChildAt(0);
    }

    private int J(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).leftMargin;
    }

    private int K(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).rightMargin;
    }

    private int L(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) view.getLayoutParams())).topMargin;
    }

    private int O(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        x();
        int i12 = 1;
        this.f28156l.f28188j = true;
        boolean z10 = !isMainAxisDirectionHorizontal() && this.f28150f;
        if (!z10 ? i11 <= 0 : i11 >= 0) {
            i12 = -1;
        }
        int abs = Math.abs(i11);
        k0(i12, abs);
        int y10 = this.f28156l.f28184f + y(tVar, yVar, this.f28156l);
        if (y10 < 0) {
            return 0;
        }
        if (z10) {
            if (abs > y10) {
                i11 = (-i12) * y10;
            }
        } else if (abs > y10) {
            i11 = i12 * y10;
        }
        this.f28158n.r(-i11);
        this.f28156l.f28185g = i11;
        return i11;
    }

    private int P(int i11) {
        int i12;
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        x();
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.f28168x;
        int width = isMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = isMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i11);
            if (i11 < 0) {
                i12 = Math.min((width2 + this.f28157m.f28174d) - width, abs);
            } else {
                if (this.f28157m.f28174d + i11 <= 0) {
                    return i11;
                }
                i12 = this.f28157m.f28174d;
            }
        } else {
            if (i11 > 0) {
                return Math.min((width2 - this.f28157m.f28174d) - width, i11);
            }
            if (this.f28157m.f28174d + i11 >= 0) {
                return i11;
            }
            i12 = this.f28157m.f28174d;
        }
        return -i12;
    }

    private boolean R(View view, boolean z10) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int J = J(view);
        int L = L(view);
        int K = K(view);
        int H = H(view);
        return z10 ? (paddingLeft <= J && width >= K) && (paddingTop <= L && height >= H) : (J >= width || K >= paddingLeft) && (L >= height || H >= paddingTop);
    }

    private int S(com.google.android.flexbox.b bVar, c cVar) {
        return isMainAxisDirectionHorizontal() ? T(bVar, cVar) : U(bVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int T(com.google.android.flexbox.b r22, com.google.android.flexbox.FlexboxLayoutManager.c r23) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.T(com.google.android.flexbox.b, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int U(com.google.android.flexbox.b r26, com.google.android.flexbox.FlexboxLayoutManager.c r27) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.U(com.google.android.flexbox.b, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    private void V(RecyclerView.t tVar, c cVar) {
        if (cVar.f28188j) {
            if (cVar.f28187i == -1) {
                X(tVar, cVar);
            } else {
                Y(tVar, cVar);
            }
        }
    }

    private void W(RecyclerView.t tVar, int i11, int i12) {
        while (i12 >= i11) {
            removeAndRecycleViewAt(i12, tVar);
            i12--;
        }
    }

    private void X(RecyclerView.t tVar, c cVar) {
        int childCount;
        int i11;
        View childAt;
        int i12;
        if (cVar.f28184f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(childCount - 1)) == null || (i12 = this.f28153i.f28209c[getPosition(childAt)]) == -1) {
            return;
        }
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) this.f28152h.get(i12);
        int i13 = i11;
        while (true) {
            if (i13 < 0) {
                break;
            }
            View childAt2 = getChildAt(i13);
            if (childAt2 != null) {
                if (!r(childAt2, cVar.f28184f)) {
                    break;
                }
                if (bVar.f28203o != getPosition(childAt2)) {
                    continue;
                } else if (i12 <= 0) {
                    childCount = i13;
                    break;
                } else {
                    i12 += cVar.f28187i;
                    bVar = (com.google.android.flexbox.b) this.f28152h.get(i12);
                    childCount = i13;
                }
            }
            i13--;
        }
        W(tVar, childCount, i11);
    }

    private void Y(RecyclerView.t tVar, c cVar) {
        int childCount;
        View childAt;
        if (cVar.f28184f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i11 = this.f28153i.f28209c[getPosition(childAt)];
        int i12 = -1;
        if (i11 == -1) {
            return;
        }
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) this.f28152h.get(i11);
        int i13 = 0;
        while (true) {
            if (i13 >= childCount) {
                break;
            }
            View childAt2 = getChildAt(i13);
            if (childAt2 != null) {
                if (!s(childAt2, cVar.f28184f)) {
                    break;
                }
                if (bVar.f28204p != getPosition(childAt2)) {
                    continue;
                } else if (i11 >= this.f28152h.size() - 1) {
                    i12 = i13;
                    break;
                } else {
                    i11 += cVar.f28187i;
                    bVar = (com.google.android.flexbox.b) this.f28152h.get(i11);
                    i12 = i13;
                }
            }
            i13++;
        }
        W(tVar, 0, i12);
    }

    private void Z() {
        int heightMode = isMainAxisDirectionHorizontal() ? getHeightMode() : getWidthMode();
        this.f28156l.f28180b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    private void a0() {
        int layoutDirection = getLayoutDirection();
        int i11 = this.f28145a;
        if (i11 == 0) {
            this.f28150f = layoutDirection == 1;
            this.f28151g = this.f28146b == 2;
            return;
        }
        if (i11 == 1) {
            this.f28150f = layoutDirection != 1;
            this.f28151g = this.f28146b == 2;
            return;
        }
        if (i11 == 2) {
            boolean z10 = layoutDirection == 1;
            this.f28150f = z10;
            if (this.f28146b == 2) {
                this.f28150f = !z10;
            }
            this.f28151g = false;
            return;
        }
        if (i11 != 3) {
            this.f28150f = false;
            this.f28151g = false;
            return;
        }
        boolean z11 = layoutDirection == 1;
        this.f28150f = z11;
        if (this.f28146b == 2) {
            this.f28150f = !z11;
        }
        this.f28151g = true;
    }

    private void ensureLayoutState() {
        if (this.f28156l == null) {
            this.f28156l = new c();
        }
    }

    private boolean f0(RecyclerView.y yVar, b bVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View B = bVar.f28175e ? B(yVar.b()) : z(yVar.b());
        if (B == null) {
            return false;
        }
        bVar.s(B);
        if (yVar.e() || !supportsPredictiveItemAnimations()) {
            return true;
        }
        if (this.f28158n.g(B) < this.f28158n.i() && this.f28158n.d(B) >= this.f28158n.m()) {
            return true;
        }
        bVar.f28173c = bVar.f28175e ? this.f28158n.i() : this.f28158n.m();
        return true;
    }

    private boolean g0(RecyclerView.y yVar, b bVar, SavedState savedState) {
        int i11;
        View childAt;
        if (!yVar.e() && (i11 = this.f28161q) != -1) {
            if (i11 >= 0 && i11 < yVar.b()) {
                bVar.f28171a = this.f28161q;
                bVar.f28172b = this.f28153i.f28209c[bVar.f28171a];
                SavedState savedState2 = this.f28160p;
                if (savedState2 != null && savedState2.g(yVar.b())) {
                    bVar.f28173c = this.f28158n.m() + savedState.mAnchorOffset;
                    bVar.f28177g = true;
                    bVar.f28172b = -1;
                    return true;
                }
                if (this.f28162r != Integer.MIN_VALUE) {
                    if (isMainAxisDirectionHorizontal() || !this.f28150f) {
                        bVar.f28173c = this.f28158n.m() + this.f28162r;
                    } else {
                        bVar.f28173c = this.f28162r - this.f28158n.j();
                    }
                    return true;
                }
                View findViewByPosition = findViewByPosition(this.f28161q);
                if (findViewByPosition == null) {
                    if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                        bVar.f28175e = this.f28161q < getPosition(childAt);
                    }
                    bVar.r();
                } else {
                    if (this.f28158n.e(findViewByPosition) > this.f28158n.n()) {
                        bVar.r();
                        return true;
                    }
                    if (this.f28158n.g(findViewByPosition) - this.f28158n.m() < 0) {
                        bVar.f28173c = this.f28158n.m();
                        bVar.f28175e = false;
                        return true;
                    }
                    if (this.f28158n.i() - this.f28158n.d(findViewByPosition) < 0) {
                        bVar.f28173c = this.f28158n.i();
                        bVar.f28175e = true;
                        return true;
                    }
                    bVar.f28173c = bVar.f28175e ? this.f28158n.d(findViewByPosition) + this.f28158n.o() : this.f28158n.g(findViewByPosition);
                }
                return true;
            }
            this.f28161q = -1;
            this.f28162r = Integer.MIN_VALUE;
        }
        return false;
    }

    private void h0(RecyclerView.y yVar, b bVar) {
        if (g0(yVar, bVar, this.f28160p) || f0(yVar, bVar)) {
            return;
        }
        bVar.r();
        bVar.f28171a = 0;
        bVar.f28172b = 0;
    }

    private static boolean i(int i11, int i12, int i13) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        if (i13 > 0 && i11 != i13) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i11;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i11;
        }
        return true;
    }

    private void i0(int i11) {
        if (i11 >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.f28153i.t(childCount);
        this.f28153i.u(childCount);
        this.f28153i.s(childCount);
        if (i11 >= this.f28153i.f28209c.length) {
            return;
        }
        this.f28169y = i11;
        View I = I();
        if (I == null) {
            return;
        }
        this.f28161q = getPosition(I);
        if (isMainAxisDirectionHorizontal() || !this.f28150f) {
            this.f28162r = this.f28158n.g(I) - this.f28158n.m();
        } else {
            this.f28162r = this.f28158n.d(I) + this.f28158n.j();
        }
    }

    private void j0(int i11) {
        int i12;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z10 = false;
        if (isMainAxisDirectionHorizontal()) {
            int i13 = this.f28163s;
            if (i13 != Integer.MIN_VALUE && i13 != width) {
                z10 = true;
            }
            i12 = this.f28156l.f28180b ? this.f28167w.getResources().getDisplayMetrics().heightPixels : this.f28156l.f28179a;
        } else {
            int i14 = this.f28164t;
            if (i14 != Integer.MIN_VALUE && i14 != height) {
                z10 = true;
            }
            i12 = this.f28156l.f28180b ? this.f28167w.getResources().getDisplayMetrics().widthPixels : this.f28156l.f28179a;
        }
        int i15 = i12;
        this.f28163s = width;
        this.f28164t = height;
        int i16 = this.f28169y;
        if (i16 == -1 && (this.f28161q != -1 || z10)) {
            if (this.f28157m.f28175e) {
                return;
            }
            this.f28152h.clear();
            this.f28170z.a();
            if (isMainAxisDirectionHorizontal()) {
                this.f28153i.e(this.f28170z, makeMeasureSpec, makeMeasureSpec2, i15, this.f28157m.f28171a, this.f28152h);
            } else {
                this.f28153i.h(this.f28170z, makeMeasureSpec, makeMeasureSpec2, i15, this.f28157m.f28171a, this.f28152h);
            }
            this.f28152h = this.f28170z.f28212a;
            this.f28153i.p(makeMeasureSpec, makeMeasureSpec2);
            this.f28153i.X();
            b bVar = this.f28157m;
            bVar.f28172b = this.f28153i.f28209c[bVar.f28171a];
            this.f28156l.f28181c = this.f28157m.f28172b;
            return;
        }
        int min = i16 != -1 ? Math.min(i16, this.f28157m.f28171a) : this.f28157m.f28171a;
        this.f28170z.a();
        if (isMainAxisDirectionHorizontal()) {
            if (this.f28152h.size() > 0) {
                this.f28153i.j(this.f28152h, min);
                this.f28153i.b(this.f28170z, makeMeasureSpec, makeMeasureSpec2, i15, min, this.f28157m.f28171a, this.f28152h);
            } else {
                this.f28153i.s(i11);
                this.f28153i.d(this.f28170z, makeMeasureSpec, makeMeasureSpec2, i15, 0, this.f28152h);
            }
        } else if (this.f28152h.size() > 0) {
            this.f28153i.j(this.f28152h, min);
            this.f28153i.b(this.f28170z, makeMeasureSpec2, makeMeasureSpec, i15, min, this.f28157m.f28171a, this.f28152h);
        } else {
            this.f28153i.s(i11);
            this.f28153i.g(this.f28170z, makeMeasureSpec, makeMeasureSpec2, i15, 0, this.f28152h);
        }
        this.f28152h = this.f28170z.f28212a;
        this.f28153i.q(makeMeasureSpec, makeMeasureSpec2, min);
        this.f28153i.Y(min);
    }

    private void k0(int i11, int i12) {
        this.f28156l.f28187i = i11;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z10 = !isMainAxisDirectionHorizontal && this.f28150f;
        if (i11 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.f28156l.f28183e = this.f28158n.d(childAt);
            int position = getPosition(childAt);
            View C = C(childAt, (com.google.android.flexbox.b) this.f28152h.get(this.f28153i.f28209c[position]));
            this.f28156l.f28186h = 1;
            c cVar = this.f28156l;
            cVar.f28182d = position + cVar.f28186h;
            if (this.f28153i.f28209c.length <= this.f28156l.f28182d) {
                this.f28156l.f28181c = -1;
            } else {
                c cVar2 = this.f28156l;
                cVar2.f28181c = this.f28153i.f28209c[cVar2.f28182d];
            }
            if (z10) {
                this.f28156l.f28183e = this.f28158n.g(C);
                this.f28156l.f28184f = (-this.f28158n.g(C)) + this.f28158n.m();
                c cVar3 = this.f28156l;
                cVar3.f28184f = Math.max(cVar3.f28184f, 0);
            } else {
                this.f28156l.f28183e = this.f28158n.d(C);
                this.f28156l.f28184f = this.f28158n.d(C) - this.f28158n.i();
            }
            if ((this.f28156l.f28181c == -1 || this.f28156l.f28181c > this.f28152h.size() - 1) && this.f28156l.f28182d <= getFlexItemCount()) {
                int i13 = i12 - this.f28156l.f28184f;
                this.f28170z.a();
                if (i13 > 0) {
                    if (isMainAxisDirectionHorizontal) {
                        this.f28153i.d(this.f28170z, makeMeasureSpec, makeMeasureSpec2, i13, this.f28156l.f28182d, this.f28152h);
                    } else {
                        this.f28153i.g(this.f28170z, makeMeasureSpec, makeMeasureSpec2, i13, this.f28156l.f28182d, this.f28152h);
                    }
                    this.f28153i.q(makeMeasureSpec, makeMeasureSpec2, this.f28156l.f28182d);
                    this.f28153i.Y(this.f28156l.f28182d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.f28156l.f28183e = this.f28158n.g(childAt2);
            int position2 = getPosition(childAt2);
            View A2 = A(childAt2, (com.google.android.flexbox.b) this.f28152h.get(this.f28153i.f28209c[position2]));
            this.f28156l.f28186h = 1;
            int i14 = this.f28153i.f28209c[position2];
            if (i14 == -1) {
                i14 = 0;
            }
            if (i14 > 0) {
                this.f28156l.f28182d = position2 - ((com.google.android.flexbox.b) this.f28152h.get(i14 - 1)).b();
            } else {
                this.f28156l.f28182d = -1;
            }
            this.f28156l.f28181c = i14 > 0 ? i14 - 1 : 0;
            if (z10) {
                this.f28156l.f28183e = this.f28158n.d(A2);
                this.f28156l.f28184f = this.f28158n.d(A2) - this.f28158n.i();
                c cVar4 = this.f28156l;
                cVar4.f28184f = Math.max(cVar4.f28184f, 0);
            } else {
                this.f28156l.f28183e = this.f28158n.g(A2);
                this.f28156l.f28184f = (-this.f28158n.g(A2)) + this.f28158n.m();
            }
        }
        c cVar5 = this.f28156l;
        cVar5.f28179a = i12 - cVar5.f28184f;
    }

    private void l0(b bVar, boolean z10, boolean z11) {
        if (z11) {
            Z();
        } else {
            this.f28156l.f28180b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f28150f) {
            this.f28156l.f28179a = this.f28158n.i() - bVar.f28173c;
        } else {
            this.f28156l.f28179a = bVar.f28173c - getPaddingRight();
        }
        this.f28156l.f28182d = bVar.f28171a;
        this.f28156l.f28186h = 1;
        this.f28156l.f28187i = 1;
        this.f28156l.f28183e = bVar.f28173c;
        this.f28156l.f28184f = Integer.MIN_VALUE;
        this.f28156l.f28181c = bVar.f28172b;
        if (!z10 || this.f28152h.size() <= 1 || bVar.f28172b < 0 || bVar.f28172b >= this.f28152h.size() - 1) {
            return;
        }
        com.google.android.flexbox.b bVar2 = (com.google.android.flexbox.b) this.f28152h.get(bVar.f28172b);
        c.l(this.f28156l);
        c.u(this.f28156l, bVar2.b());
    }

    private void m0(b bVar, boolean z10, boolean z11) {
        if (z11) {
            Z();
        } else {
            this.f28156l.f28180b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f28150f) {
            this.f28156l.f28179a = bVar.f28173c - this.f28158n.m();
        } else {
            this.f28156l.f28179a = (this.f28168x.getWidth() - bVar.f28173c) - this.f28158n.m();
        }
        this.f28156l.f28182d = bVar.f28171a;
        this.f28156l.f28186h = 1;
        this.f28156l.f28187i = -1;
        this.f28156l.f28183e = bVar.f28173c;
        this.f28156l.f28184f = Integer.MIN_VALUE;
        this.f28156l.f28181c = bVar.f28172b;
        if (!z10 || bVar.f28172b <= 0 || this.f28152h.size() <= bVar.f28172b) {
            return;
        }
        com.google.android.flexbox.b bVar2 = (com.google.android.flexbox.b) this.f28152h.get(bVar.f28172b);
        c.m(this.f28156l);
        c.v(this.f28156l, bVar2.b());
    }

    private boolean r(View view, int i11) {
        return (isMainAxisDirectionHorizontal() || !this.f28150f) ? this.f28158n.g(view) >= this.f28158n.h() - i11 : this.f28158n.d(view) <= i11;
    }

    private boolean s(View view, int i11) {
        return (isMainAxisDirectionHorizontal() || !this.f28150f) ? this.f28158n.d(view) <= i11 : this.f28158n.h() - this.f28158n.g(view) <= i11;
    }

    private boolean shouldMeasureChild(View view, int i11, int i12, RecyclerView.n nVar) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && i(view.getWidth(), i11, ((ViewGroup.MarginLayoutParams) nVar).width) && i(view.getHeight(), i12, ((ViewGroup.MarginLayoutParams) nVar).height)) ? false : true;
    }

    private void t() {
        this.f28152h.clear();
        this.f28157m.t();
        this.f28157m.f28174d = 0;
    }

    private int u(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int b11 = yVar.b();
        x();
        View z10 = z(b11);
        View B = B(b11);
        if (yVar.b() == 0 || z10 == null || B == null) {
            return 0;
        }
        return Math.min(this.f28158n.n(), this.f28158n.d(B) - this.f28158n.g(z10));
    }

    private int v(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int b11 = yVar.b();
        View z10 = z(b11);
        View B = B(b11);
        if (yVar.b() != 0 && z10 != null && B != null) {
            int position = getPosition(z10);
            int position2 = getPosition(B);
            int abs = Math.abs(this.f28158n.d(B) - this.f28158n.g(z10));
            int i11 = this.f28153i.f28209c[position];
            if (i11 != 0 && i11 != -1) {
                return Math.round((i11 * (abs / ((r4[position2] - i11) + 1))) + (this.f28158n.m() - this.f28158n.g(z10)));
            }
        }
        return 0;
    }

    private int w(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int b11 = yVar.b();
        View z10 = z(b11);
        View B = B(b11);
        if (yVar.b() == 0 || z10 == null || B == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.f28158n.d(B) - this.f28158n.g(z10)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * yVar.b());
    }

    private void x() {
        if (this.f28158n != null) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            if (this.f28146b == 0) {
                this.f28158n = m.a(this);
                this.f28159o = m.c(this);
                return;
            } else {
                this.f28158n = m.c(this);
                this.f28159o = m.a(this);
                return;
            }
        }
        if (this.f28146b == 0) {
            this.f28158n = m.c(this);
            this.f28159o = m.a(this);
        } else {
            this.f28158n = m.a(this);
            this.f28159o = m.c(this);
        }
    }

    private int y(RecyclerView.t tVar, RecyclerView.y yVar, c cVar) {
        if (cVar.f28184f != Integer.MIN_VALUE) {
            if (cVar.f28179a < 0) {
                c.q(cVar, cVar.f28179a);
            }
            V(tVar, cVar);
        }
        int i11 = cVar.f28179a;
        int i12 = cVar.f28179a;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i13 = 0;
        while (true) {
            if ((i12 > 0 || this.f28156l.f28180b) && cVar.D(yVar, this.f28152h)) {
                com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) this.f28152h.get(cVar.f28181c);
                cVar.f28182d = bVar.f28203o;
                i13 += S(bVar, cVar);
                if (isMainAxisDirectionHorizontal || !this.f28150f) {
                    c.c(cVar, bVar.a() * cVar.f28187i);
                } else {
                    c.d(cVar, bVar.a() * cVar.f28187i);
                }
                i12 -= bVar.a();
            }
        }
        c.i(cVar, i13);
        if (cVar.f28184f != Integer.MIN_VALUE) {
            c.q(cVar, i13);
            if (cVar.f28179a < 0) {
                c.q(cVar, cVar.f28179a);
            }
            V(tVar, cVar);
        }
        return i11 - cVar.f28179a;
    }

    private View z(int i11) {
        View E = E(0, getChildCount(), i11);
        if (E == null) {
            return null;
        }
        int i12 = this.f28153i.f28209c[getPosition(E)];
        if (i12 == -1) {
            return null;
        }
        return A(E, (com.google.android.flexbox.b) this.f28152h.get(i12));
    }

    public List M() {
        ArrayList arrayList = new ArrayList(this.f28152h.size());
        int size = this.f28152h.size();
        for (int i11 = 0; i11 < size; i11++) {
            com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) this.f28152h.get(i11);
            if (bVar.b() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int N(int i11) {
        return this.f28153i.f28209c[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Q() {
        return this.f28150f;
    }

    public void b0(int i11) {
        int i12 = this.f28148d;
        if (i12 != i11) {
            if (i12 == 4 || i11 == 4) {
                removeAllViews();
                t();
            }
            this.f28148d = i11;
            requestLayout();
        }
    }

    public void c0(int i11) {
        if (this.f28145a != i11) {
            removeAllViews();
            this.f28145a = i11;
            this.f28158n = null;
            this.f28159o = null;
            t();
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollHorizontally() {
        if (this.f28146b == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.f28168x;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollVertically() {
        if (this.f28146b == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.f28168x;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean checkLayoutParams(RecyclerView.n nVar) {
        return nVar instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollExtent(RecyclerView.y yVar) {
        return u(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollOffset(RecyclerView.y yVar) {
        return v(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollRange(RecyclerView.y yVar) {
        return w(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF computeScrollVectorForPosition(int i11) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i12 = i11 < getPosition(childAt) ? -1 : 1;
        return isMainAxisDirectionHorizontal() ? new PointF(0.0f, i12) : new PointF(i12, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollExtent(RecyclerView.y yVar) {
        return u(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        return v(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        return w(yVar);
    }

    public void d0(int i11) {
        if (i11 == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i12 = this.f28146b;
        if (i12 != i11) {
            if (i12 == 0 || i11 == 0) {
                removeAllViews();
                t();
            }
            this.f28146b = i11;
            this.f28158n = null;
            this.f28159o = null;
            requestLayout();
        }
    }

    public void e0(int i11) {
        if (this.f28147c != i11) {
            this.f28147c = i11;
            requestLayout();
        }
    }

    public int findFirstVisibleItemPosition() {
        View D = D(0, getChildCount(), false);
        if (D == null) {
            return -1;
        }
        return getPosition(D);
    }

    public int findLastVisibleItemPosition() {
        View D = D(getChildCount() - 1, -1, false);
        if (D == null) {
            return -1;
        }
        return getPosition(D);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f28148d;
    }

    @Override // com.google.android.flexbox.a
    public int getChildHeightMeasureSpec(int i11, int i12, int i13) {
        return RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), i12, i13, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public int getChildWidthMeasureSpec(int i11, int i12, int i13) {
        return RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), i12, i13, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.a
    public int getDecorationLengthMainAxis(View view, int i11, int i12) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f28145a;
    }

    @Override // com.google.android.flexbox.a
    public View getFlexItemAt(int i11) {
        View view = (View) this.f28166v.get(i11);
        return view != null ? view : this.f28154j.o(i11);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.f28155k.b();
    }

    @Override // com.google.android.flexbox.a
    public List getFlexLinesInternal() {
        return this.f28152h;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.f28146b;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        if (this.f28152h.size() == 0) {
            return 0;
        }
        int size = this.f28152h.size();
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = Math.max(i11, ((com.google.android.flexbox.b) this.f28152h.get(i12)).f28193e);
        }
        return i11;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f28149e;
    }

    @Override // com.google.android.flexbox.a
    public View getReorderedFlexItemAt(int i11) {
        return getFlexItemAt(i11);
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int size = this.f28152h.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += ((com.google.android.flexbox.b) this.f28152h.get(i12)).f28195g;
        }
        return i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.google.android.flexbox.a
    public boolean isMainAxisDirectionHorizontal() {
        int i11 = this.f28145a;
        return i11 == 0 || i11 == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f28168x = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        if (this.f28165u) {
            removeAndRecycleAllViews(tVar);
            tVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        super.onItemsAdded(recyclerView, i11, i12);
        i0(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        super.onItemsMoved(recyclerView, i11, i12, i13);
        i0(Math.min(i11, i12));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        super.onItemsRemoved(recyclerView, i11, i12);
        i0(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12) {
        super.onItemsUpdated(recyclerView, i11, i12);
        i0(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        super.onItemsUpdated(recyclerView, i11, i12, obj);
        i0(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.y yVar) {
        int i11;
        int i12;
        this.f28154j = tVar;
        this.f28155k = yVar;
        int b11 = yVar.b();
        if (b11 == 0 && yVar.e()) {
            return;
        }
        a0();
        x();
        ensureLayoutState();
        this.f28153i.t(b11);
        this.f28153i.u(b11);
        this.f28153i.s(b11);
        this.f28156l.f28188j = false;
        SavedState savedState = this.f28160p;
        if (savedState != null && savedState.g(b11)) {
            this.f28161q = this.f28160p.mAnchorPosition;
        }
        if (!this.f28157m.f28176f || this.f28161q != -1 || this.f28160p != null) {
            this.f28157m.t();
            h0(yVar, this.f28157m);
            this.f28157m.f28176f = true;
        }
        detachAndScrapAttachedViews(tVar);
        if (this.f28157m.f28175e) {
            m0(this.f28157m, false, true);
        } else {
            l0(this.f28157m, false, true);
        }
        j0(b11);
        y(tVar, yVar, this.f28156l);
        if (this.f28157m.f28175e) {
            i12 = this.f28156l.f28183e;
            l0(this.f28157m, true, false);
            y(tVar, yVar, this.f28156l);
            i11 = this.f28156l.f28183e;
        } else {
            i11 = this.f28156l.f28183e;
            m0(this.f28157m, true, false);
            y(tVar, yVar, this.f28156l);
            i12 = this.f28156l.f28183e;
        }
        if (getChildCount() > 0) {
            if (this.f28157m.f28175e) {
                G(i12 + F(i11, tVar, yVar, true), tVar, yVar, false);
            } else {
                F(i11 + G(i12, tVar, yVar, true), tVar, yVar, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutCompleted(RecyclerView.y yVar) {
        super.onLayoutCompleted(yVar);
        this.f28160p = null;
        this.f28161q = -1;
        this.f28162r = Integer.MIN_VALUE;
        this.f28169y = -1;
        this.f28157m.t();
        this.f28166v.clear();
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexItemAdded(View view, int i11, int i12, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, A);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.f28193e += leftDecorationWidth;
            bVar.f28194f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            bVar.f28193e += topDecorationHeight;
            bVar.f28194f += topDecorationHeight;
        }
    }

    @Override // com.google.android.flexbox.a
    public void onNewFlexLineAdded(com.google.android.flexbox.b bVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f28160p = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable onSaveInstanceState() {
        if (this.f28160p != null) {
            return new SavedState(this.f28160p);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View I = I();
            savedState.mAnchorPosition = getPosition(I);
            savedState.mAnchorOffset = this.f28158n.g(I) - this.f28158n.m();
        } else {
            savedState.h();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (!isMainAxisDirectionHorizontal() || this.f28146b == 0) {
            int O = O(i11, tVar, yVar);
            this.f28166v.clear();
            return O;
        }
        int P = P(i11);
        b.l(this.f28157m, P);
        this.f28159o.r(-P);
        return P;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void scrollToPosition(int i11) {
        this.f28161q = i11;
        this.f28162r = Integer.MIN_VALUE;
        SavedState savedState = this.f28160p;
        if (savedState != null) {
            savedState.h();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (isMainAxisDirectionHorizontal() || (this.f28146b == 0 && !isMainAxisDirectionHorizontal())) {
            int O = O(i11, tVar, yVar);
            this.f28166v.clear();
            return O;
        }
        int P = P(i11);
        b.l(this.f28157m, P);
        this.f28159o.r(-P);
        return P;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List list) {
        this.f28152h = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.y yVar, int i11) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i11);
        startSmoothScroll(hVar);
    }

    @Override // com.google.android.flexbox.a
    public void updateViewCache(int i11, View view) {
        this.f28166v.put(i11, view);
    }
}
