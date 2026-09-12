package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.m implements RecyclerView.x.b {

    /* renamed from: b, reason: collision with root package name */
    c[] f14374b;

    /* renamed from: c, reason: collision with root package name */
    m f14375c;

    /* renamed from: d, reason: collision with root package name */
    m f14376d;

    /* renamed from: e, reason: collision with root package name */
    private int f14377e;

    /* renamed from: f, reason: collision with root package name */
    private int f14378f;

    /* renamed from: g, reason: collision with root package name */
    private final g f14379g;

    /* renamed from: j, reason: collision with root package name */
    private BitSet f14382j;

    /* renamed from: o, reason: collision with root package name */
    private boolean f14387o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f14388p;

    /* renamed from: q, reason: collision with root package name */
    private SavedState f14389q;

    /* renamed from: r, reason: collision with root package name */
    private int f14390r;

    /* renamed from: w, reason: collision with root package name */
    private int[] f14395w;

    /* renamed from: a, reason: collision with root package name */
    private int f14373a = -1;

    /* renamed from: h, reason: collision with root package name */
    boolean f14380h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f14381i = false;

    /* renamed from: k, reason: collision with root package name */
    int f14383k = -1;

    /* renamed from: l, reason: collision with root package name */
    int f14384l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    LazySpanLookup f14385m = new LazySpanLookup();

    /* renamed from: n, reason: collision with root package name */
    private int f14386n = 2;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f14391s = new Rect();

    /* renamed from: t, reason: collision with root package name */
    private final a f14392t = new a();

    /* renamed from: u, reason: collision with root package name */
    private boolean f14393u = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f14394v = true;

    /* renamed from: x, reason: collision with root package name */
    private final Runnable f14396x = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.q();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class LazySpanLookup {

        /* renamed from: a, reason: collision with root package name */
        int[] f14397a;

        /* renamed from: b, reason: collision with root package name */
        List f14398b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes2.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            int f14399a;

            /* renamed from: b, reason: collision with root package name */
            int f14400b;

            /* renamed from: c, reason: collision with root package name */
            int[] f14401c;

            /* renamed from: d, reason: collision with root package name */
            boolean f14402d;

            /* loaded from: classes2.dex */
            class a implements Parcelable.Creator {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i11) {
                    return new FullSpanItem[i11];
                }
            }

            FullSpanItem() {
            }

            FullSpanItem(Parcel parcel) {
                this.f14399a = parcel.readInt();
                this.f14400b = parcel.readInt();
                this.f14402d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f14401c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i11) {
                int[] iArr = this.f14401c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i11];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f14399a + ", mGapDir=" + this.f14400b + ", mHasUnwantedGapAfter=" + this.f14402d + ", mGapPerSpan=" + Arrays.toString(this.f14401c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(this.f14399a);
                parcel.writeInt(this.f14400b);
                parcel.writeInt(this.f14402d ? 1 : 0);
                int[] iArr = this.f14401c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f14401c);
                }
            }
        }

        LazySpanLookup() {
        }

        private int i(int i11) {
            if (this.f14398b == null) {
                return -1;
            }
            FullSpanItem f11 = f(i11);
            if (f11 != null) {
                this.f14398b.remove(f11);
            }
            int size = this.f14398b.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    i12 = -1;
                    break;
                }
                if (((FullSpanItem) this.f14398b.get(i12)).f14399a >= i11) {
                    break;
                }
                i12++;
            }
            if (i12 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = (FullSpanItem) this.f14398b.get(i12);
            this.f14398b.remove(i12);
            return fullSpanItem.f14399a;
        }

        private void l(int i11, int i12) {
            List list = this.f14398b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f14398b.get(size);
                int i13 = fullSpanItem.f14399a;
                if (i13 >= i11) {
                    fullSpanItem.f14399a = i13 + i12;
                }
            }
        }

        private void m(int i11, int i12) {
            List list = this.f14398b;
            if (list == null) {
                return;
            }
            int i13 = i11 + i12;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f14398b.get(size);
                int i14 = fullSpanItem.f14399a;
                if (i14 >= i11) {
                    if (i14 < i13) {
                        this.f14398b.remove(size);
                    } else {
                        fullSpanItem.f14399a = i14 - i12;
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f14398b == null) {
                this.f14398b = new ArrayList();
            }
            int size = this.f14398b.size();
            for (int i11 = 0; i11 < size; i11++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f14398b.get(i11);
                if (fullSpanItem2.f14399a == fullSpanItem.f14399a) {
                    this.f14398b.remove(i11);
                }
                if (fullSpanItem2.f14399a >= fullSpanItem.f14399a) {
                    this.f14398b.add(i11, fullSpanItem);
                    return;
                }
            }
            this.f14398b.add(fullSpanItem);
        }

        void b() {
            int[] iArr = this.f14397a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f14398b = null;
        }

        void c(int i11) {
            int[] iArr = this.f14397a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i11, 10) + 1];
                this.f14397a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i11 >= iArr.length) {
                int[] iArr3 = new int[o(i11)];
                this.f14397a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f14397a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i11) {
            List list = this.f14398b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f14398b.get(size)).f14399a >= i11) {
                        this.f14398b.remove(size);
                    }
                }
            }
            return h(i11);
        }

        public FullSpanItem e(int i11, int i12, int i13, boolean z10) {
            List list = this.f14398b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i14 = 0; i14 < size; i14++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f14398b.get(i14);
                int i15 = fullSpanItem.f14399a;
                if (i15 >= i12) {
                    return null;
                }
                if (i15 >= i11 && (i13 == 0 || fullSpanItem.f14400b == i13 || (z10 && fullSpanItem.f14402d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i11) {
            List list = this.f14398b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f14398b.get(size);
                if (fullSpanItem.f14399a == i11) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        int g(int i11) {
            int[] iArr = this.f14397a;
            if (iArr == null || i11 >= iArr.length) {
                return -1;
            }
            return iArr[i11];
        }

        int h(int i11) {
            int[] iArr = this.f14397a;
            if (iArr == null || i11 >= iArr.length) {
                return -1;
            }
            int i12 = i(i11);
            if (i12 == -1) {
                int[] iArr2 = this.f14397a;
                Arrays.fill(iArr2, i11, iArr2.length, -1);
                return this.f14397a.length;
            }
            int min = Math.min(i12 + 1, this.f14397a.length);
            Arrays.fill(this.f14397a, i11, min, -1);
            return min;
        }

        void j(int i11, int i12) {
            int[] iArr = this.f14397a;
            if (iArr == null || i11 >= iArr.length) {
                return;
            }
            int i13 = i11 + i12;
            c(i13);
            int[] iArr2 = this.f14397a;
            System.arraycopy(iArr2, i11, iArr2, i13, (iArr2.length - i11) - i12);
            Arrays.fill(this.f14397a, i11, i13, -1);
            l(i11, i12);
        }

        void k(int i11, int i12) {
            int[] iArr = this.f14397a;
            if (iArr == null || i11 >= iArr.length) {
                return;
            }
            int i13 = i11 + i12;
            c(i13);
            int[] iArr2 = this.f14397a;
            System.arraycopy(iArr2, i13, iArr2, i11, (iArr2.length - i11) - i12);
            int[] iArr3 = this.f14397a;
            Arrays.fill(iArr3, iArr3.length - i12, iArr3.length, -1);
            m(i11, i12);
        }

        void n(int i11, c cVar) {
            c(i11);
            this.f14397a[i11] = cVar.f14416e;
        }

        int o(int i11) {
            int length = this.f14397a.length;
            while (length <= i11) {
                length *= 2;
            }
            return length;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes2.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        /* loaded from: classes2.dex */
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

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f14403a;

        /* renamed from: b, reason: collision with root package name */
        int f14404b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14405c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14406d;

        /* renamed from: e, reason: collision with root package name */
        boolean f14407e;

        /* renamed from: f, reason: collision with root package name */
        int[] f14408f;

        a() {
            c();
        }

        void a() {
            this.f14404b = this.f14405c ? StaggeredGridLayoutManager.this.f14375c.i() : StaggeredGridLayoutManager.this.f14375c.m();
        }

        void b(int i11) {
            if (this.f14405c) {
                this.f14404b = StaggeredGridLayoutManager.this.f14375c.i() - i11;
            } else {
                this.f14404b = StaggeredGridLayoutManager.this.f14375c.m() + i11;
            }
        }

        void c() {
            this.f14403a = -1;
            this.f14404b = Integer.MIN_VALUE;
            this.f14405c = false;
            this.f14406d = false;
            this.f14407e = false;
            int[] iArr = this.f14408f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f14408f;
            if (iArr == null || iArr.length < length) {
                this.f14408f = new int[StaggeredGridLayoutManager.this.f14374b.length];
            }
            for (int i11 = 0; i11 < length; i11++) {
                this.f14408f[i11] = cVarArr[i11].t(Integer.MIN_VALUE);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.n {

        /* renamed from: a, reason: collision with root package name */
        c f14410a;

        /* renamed from: b, reason: collision with root package name */
        boolean f14411b;

        public b(int i11, int i12) {
            super(i11, i12);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int a() {
            c cVar = this.f14410a;
            if (cVar == null) {
                return -1;
            }
            return cVar.f14416e;
        }

        public boolean b() {
            return this.f14411b;
        }

        public void c(boolean z10) {
            this.f14411b = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        ArrayList f14412a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        int f14413b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        int f14414c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        int f14415d = 0;

        /* renamed from: e, reason: collision with root package name */
        final int f14416e;

        c(int i11) {
            this.f14416e = i11;
        }

        void a(View view) {
            b r11 = r(view);
            r11.f14410a = this;
            this.f14412a.add(view);
            this.f14414c = Integer.MIN_VALUE;
            if (this.f14412a.size() == 1) {
                this.f14413b = Integer.MIN_VALUE;
            }
            if (r11.isItemRemoved() || r11.isItemChanged()) {
                this.f14415d += StaggeredGridLayoutManager.this.f14375c.e(view);
            }
        }

        void b(boolean z10, int i11) {
            int p11 = z10 ? p(Integer.MIN_VALUE) : t(Integer.MIN_VALUE);
            e();
            if (p11 == Integer.MIN_VALUE) {
                return;
            }
            if (!z10 || p11 >= StaggeredGridLayoutManager.this.f14375c.i()) {
                if (z10 || p11 <= StaggeredGridLayoutManager.this.f14375c.m()) {
                    if (i11 != Integer.MIN_VALUE) {
                        p11 += i11;
                    }
                    this.f14414c = p11;
                    this.f14413b = p11;
                }
            }
        }

        void c() {
            LazySpanLookup.FullSpanItem f11;
            ArrayList arrayList = this.f14412a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            b r11 = r(view);
            this.f14414c = StaggeredGridLayoutManager.this.f14375c.d(view);
            if (r11.f14411b && (f11 = StaggeredGridLayoutManager.this.f14385m.f(r11.getViewLayoutPosition())) != null && f11.f14400b == 1) {
                this.f14414c += f11.a(this.f14416e);
            }
        }

        void d() {
            LazySpanLookup.FullSpanItem f11;
            View view = (View) this.f14412a.get(0);
            b r11 = r(view);
            this.f14413b = StaggeredGridLayoutManager.this.f14375c.g(view);
            if (r11.f14411b && (f11 = StaggeredGridLayoutManager.this.f14385m.f(r11.getViewLayoutPosition())) != null && f11.f14400b == -1) {
                this.f14413b -= f11.a(this.f14416e);
            }
        }

        void e() {
            this.f14412a.clear();
            u();
            this.f14415d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f14380h ? l(this.f14412a.size() - 1, -1, true) : l(0, this.f14412a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f14380h ? m(this.f14412a.size() - 1, -1, false) : m(0, this.f14412a.size(), false);
        }

        public int h() {
            return StaggeredGridLayoutManager.this.f14380h ? m(0, this.f14412a.size(), true) : m(this.f14412a.size() - 1, -1, true);
        }

        public int i() {
            return StaggeredGridLayoutManager.this.f14380h ? l(0, this.f14412a.size(), true) : l(this.f14412a.size() - 1, -1, true);
        }

        public int j() {
            return StaggeredGridLayoutManager.this.f14380h ? m(0, this.f14412a.size(), false) : m(this.f14412a.size() - 1, -1, false);
        }

        int k(int i11, int i12, boolean z10, boolean z11, boolean z12) {
            int m11 = StaggeredGridLayoutManager.this.f14375c.m();
            int i13 = StaggeredGridLayoutManager.this.f14375c.i();
            int i14 = i12 > i11 ? 1 : -1;
            while (i11 != i12) {
                View view = (View) this.f14412a.get(i11);
                int g11 = StaggeredGridLayoutManager.this.f14375c.g(view);
                int d11 = StaggeredGridLayoutManager.this.f14375c.d(view);
                boolean z13 = false;
                boolean z14 = !z12 ? g11 >= i13 : g11 > i13;
                if (!z12 ? d11 > m11 : d11 >= m11) {
                    z13 = true;
                }
                if (z14 && z13) {
                    if (z10 && z11) {
                        if (g11 >= m11 && d11 <= i13) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (g11 < m11 || d11 > i13) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i11 += i14;
            }
            return -1;
        }

        int l(int i11, int i12, boolean z10) {
            return k(i11, i12, false, false, z10);
        }

        int m(int i11, int i12, boolean z10) {
            return k(i11, i12, z10, true, false);
        }

        public int n() {
            return this.f14415d;
        }

        int o() {
            int i11 = this.f14414c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            c();
            return this.f14414c;
        }

        int p(int i11) {
            int i12 = this.f14414c;
            if (i12 != Integer.MIN_VALUE) {
                return i12;
            }
            if (this.f14412a.size() == 0) {
                return i11;
            }
            c();
            return this.f14414c;
        }

        public View q(int i11, int i12) {
            View view = null;
            if (i12 != -1) {
                int size = this.f14412a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f14412a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f14380h && staggeredGridLayoutManager.getPosition(view2) >= i11) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f14380h && staggeredGridLayoutManager2.getPosition(view2) <= i11) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f14412a.size();
                int i13 = 0;
                while (i13 < size2) {
                    View view3 = (View) this.f14412a.get(i13);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f14380h && staggeredGridLayoutManager3.getPosition(view3) <= i11) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f14380h && staggeredGridLayoutManager4.getPosition(view3) >= i11) || !view3.hasFocusable()) {
                        break;
                    }
                    i13++;
                    view = view3;
                }
            }
            return view;
        }

        b r(View view) {
            return (b) view.getLayoutParams();
        }

        int s() {
            int i11 = this.f14413b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            d();
            return this.f14413b;
        }

        int t(int i11) {
            int i12 = this.f14413b;
            if (i12 != Integer.MIN_VALUE) {
                return i12;
            }
            if (this.f14412a.size() == 0) {
                return i11;
            }
            d();
            return this.f14413b;
        }

        void u() {
            this.f14413b = Integer.MIN_VALUE;
            this.f14414c = Integer.MIN_VALUE;
        }

        void v(int i11) {
            int i12 = this.f14413b;
            if (i12 != Integer.MIN_VALUE) {
                this.f14413b = i12 + i11;
            }
            int i13 = this.f14414c;
            if (i13 != Integer.MIN_VALUE) {
                this.f14414c = i13 + i11;
            }
        }

        void w() {
            int size = this.f14412a.size();
            View view = (View) this.f14412a.remove(size - 1);
            b r11 = r(view);
            r11.f14410a = null;
            if (r11.isItemRemoved() || r11.isItemChanged()) {
                this.f14415d -= StaggeredGridLayoutManager.this.f14375c.e(view);
            }
            if (size == 1) {
                this.f14413b = Integer.MIN_VALUE;
            }
            this.f14414c = Integer.MIN_VALUE;
        }

        void x() {
            View view = (View) this.f14412a.remove(0);
            b r11 = r(view);
            r11.f14410a = null;
            if (this.f14412a.size() == 0) {
                this.f14414c = Integer.MIN_VALUE;
            }
            if (r11.isItemRemoved() || r11.isItemChanged()) {
                this.f14415d -= StaggeredGridLayoutManager.this.f14375c.e(view);
            }
            this.f14413b = Integer.MIN_VALUE;
        }

        void y(View view) {
            b r11 = r(view);
            r11.f14410a = this;
            this.f14412a.add(0, view);
            this.f14413b = Integer.MIN_VALUE;
            if (this.f14412a.size() == 1) {
                this.f14414c = Integer.MIN_VALUE;
            }
            if (r11.isItemRemoved() || r11.isItemChanged()) {
                this.f14415d += StaggeredGridLayoutManager.this.f14375c.e(view);
            }
        }

        void z(int i11) {
            this.f14413b = i11;
            this.f14414c = i11;
        }
    }

    public StaggeredGridLayoutManager(int i11, int i12) {
        this.f14377e = i12;
        h0(i11);
        this.f14379g = new g();
        x();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        RecyclerView.m.d properties = RecyclerView.m.getProperties(context, attributeSet, i11, i12);
        setOrientation(properties.f14320a);
        h0(properties.f14321b);
        setReverseLayout(properties.f14322c);
        this.f14379g = new g();
        x();
    }

    private int F(int i11) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i11) {
                return position;
            }
        }
        return 0;
    }

    private void H(RecyclerView.t tVar, RecyclerView.y yVar, boolean z10) {
        int i11;
        int L = L(Integer.MIN_VALUE);
        if (L != Integer.MIN_VALUE && (i11 = this.f14375c.i() - L) > 0) {
            int i12 = i11 - (-scrollBy(-i11, tVar, yVar));
            if (!z10 || i12 <= 0) {
                return;
            }
            this.f14375c.r(i12);
        }
    }

    private void I(RecyclerView.t tVar, RecyclerView.y yVar, boolean z10) {
        int m11;
        int O = O(Integer.MAX_VALUE);
        if (O != Integer.MAX_VALUE && (m11 = O - this.f14375c.m()) > 0) {
            int scrollBy = m11 - scrollBy(m11, tVar, yVar);
            if (!z10 || scrollBy <= 0) {
                return;
            }
            this.f14375c.r(-scrollBy);
        }
    }

    private int L(int i11) {
        int p11 = this.f14374b[0].p(i11);
        for (int i12 = 1; i12 < this.f14373a; i12++) {
            int p12 = this.f14374b[i12].p(i11);
            if (p12 > p11) {
                p11 = p12;
            }
        }
        return p11;
    }

    private int M(int i11) {
        int t11 = this.f14374b[0].t(i11);
        for (int i12 = 1; i12 < this.f14373a; i12++) {
            int t12 = this.f14374b[i12].t(i11);
            if (t12 > t11) {
                t11 = t12;
            }
        }
        return t11;
    }

    private int N(int i11) {
        int p11 = this.f14374b[0].p(i11);
        for (int i12 = 1; i12 < this.f14373a; i12++) {
            int p12 = this.f14374b[i12].p(i11);
            if (p12 < p11) {
                p11 = p12;
            }
        }
        return p11;
    }

    private int O(int i11) {
        int t11 = this.f14374b[0].t(i11);
        for (int i12 = 1; i12 < this.f14373a; i12++) {
            int t12 = this.f14374b[i12].t(i11);
            if (t12 < t11) {
                t11 = t12;
            }
        }
        return t11;
    }

    private c P(g gVar) {
        int i11;
        int i12;
        int i13;
        if (X(gVar.f14464e)) {
            i12 = this.f14373a - 1;
            i11 = -1;
            i13 = -1;
        } else {
            i11 = this.f14373a;
            i12 = 0;
            i13 = 1;
        }
        c cVar = null;
        if (gVar.f14464e == 1) {
            int m11 = this.f14375c.m();
            int i14 = Integer.MAX_VALUE;
            while (i12 != i11) {
                c cVar2 = this.f14374b[i12];
                int p11 = cVar2.p(m11);
                if (p11 < i14) {
                    cVar = cVar2;
                    i14 = p11;
                }
                i12 += i13;
            }
            return cVar;
        }
        int i15 = this.f14375c.i();
        int i16 = Integer.MIN_VALUE;
        while (i12 != i11) {
            c cVar3 = this.f14374b[i12];
            int t11 = cVar3.t(i15);
            if (t11 > i16) {
                cVar = cVar3;
                i16 = t11;
            }
            i12 += i13;
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void R(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f14381i
            if (r0 == 0) goto L9
            int r0 = r6.K()
            goto Ld
        L9:
            int r0 = r6.J()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f14385m
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f14385m
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f14385m
            r7.j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f14385m
            r9.k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f14385m
            r9.j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.f14381i
            if (r7 == 0) goto L4e
            int r7 = r6.J()
            goto L52
        L4e:
            int r7 = r6.K()
        L52:
            if (r3 > r7) goto L57
            r6.requestLayout()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.R(int, int, int):void");
    }

    private void U(View view, int i11, int i12, boolean z10) {
        calculateItemDecorationsForChild(view, this.f14391s);
        b bVar = (b) view.getLayoutParams();
        int i13 = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
        Rect rect = this.f14391s;
        int p02 = p0(i11, i13 + rect.left, ((ViewGroup.MarginLayoutParams) bVar).rightMargin + rect.right);
        int i14 = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
        Rect rect2 = this.f14391s;
        int p03 = p0(i12, i14 + rect2.top, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin + rect2.bottom);
        if (z10 ? shouldReMeasureChild(view, p02, p03, bVar) : shouldMeasureChild(view, p02, p03, bVar)) {
            view.measure(p02, p03);
        }
    }

    private void V(View view, b bVar, boolean z10) {
        if (bVar.f14411b) {
            if (this.f14377e == 1) {
                U(view, this.f14390r, RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) bVar).height, true), z10);
                return;
            } else {
                U(view, RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) bVar).width, true), this.f14390r, z10);
                return;
            }
        }
        if (this.f14377e == 1) {
            U(view, RecyclerView.m.getChildMeasureSpec(this.f14378f, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) bVar).width, false), RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) bVar).height, true), z10);
        } else {
            U(view, RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) bVar).width, true), RecyclerView.m.getChildMeasureSpec(this.f14378f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) bVar).height, false), z10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0152, code lost:
    
        if (q() != false) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void W(androidx.recyclerview.widget.RecyclerView.t r9, androidx.recyclerview.widget.RecyclerView.y r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.W(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$y, boolean):void");
    }

    private boolean X(int i11) {
        if (this.f14377e == 0) {
            return (i11 == -1) != this.f14381i;
        }
        return ((i11 == -1) == this.f14381i) == isLayoutRTL();
    }

    private void Z(View view) {
        for (int i11 = this.f14373a - 1; i11 >= 0; i11--) {
            this.f14374b[i11].y(view);
        }
    }

    private void a0(RecyclerView.t tVar, g gVar) {
        if (!gVar.f14460a || gVar.f14468i) {
            return;
        }
        if (gVar.f14461b == 0) {
            if (gVar.f14464e == -1) {
                b0(tVar, gVar.f14466g);
                return;
            } else {
                c0(tVar, gVar.f14465f);
                return;
            }
        }
        if (gVar.f14464e != -1) {
            int N = N(gVar.f14466g) - gVar.f14466g;
            c0(tVar, N < 0 ? gVar.f14465f : Math.min(N, gVar.f14461b) + gVar.f14465f);
        } else {
            int i11 = gVar.f14465f;
            int M = i11 - M(i11);
            b0(tVar, M < 0 ? gVar.f14466g : gVar.f14466g - Math.min(M, gVar.f14461b));
        }
    }

    private void b0(RecyclerView.t tVar, int i11) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f14375c.g(childAt) < i11 || this.f14375c.q(childAt) < i11) {
                return;
            }
            b bVar = (b) childAt.getLayoutParams();
            if (bVar.f14411b) {
                for (int i12 = 0; i12 < this.f14373a; i12++) {
                    if (this.f14374b[i12].f14412a.size() == 1) {
                        return;
                    }
                }
                for (int i13 = 0; i13 < this.f14373a; i13++) {
                    this.f14374b[i13].w();
                }
            } else if (bVar.f14410a.f14412a.size() == 1) {
                return;
            } else {
                bVar.f14410a.w();
            }
            removeAndRecycleView(childAt, tVar);
        }
    }

    private void c0(RecyclerView.t tVar, int i11) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f14375c.d(childAt) > i11 || this.f14375c.p(childAt) > i11) {
                return;
            }
            b bVar = (b) childAt.getLayoutParams();
            if (bVar.f14411b) {
                for (int i12 = 0; i12 < this.f14373a; i12++) {
                    if (this.f14374b[i12].f14412a.size() == 1) {
                        return;
                    }
                }
                for (int i13 = 0; i13 < this.f14373a; i13++) {
                    this.f14374b[i13].x();
                }
            } else if (bVar.f14410a.f14412a.size() == 1) {
                return;
            } else {
                bVar.f14410a.x();
            }
            removeAndRecycleView(childAt, tVar);
        }
    }

    private int convertFocusDirectionToLayoutDirection(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 17 ? i11 != 33 ? i11 != 66 ? (i11 == 130 && this.f14377e == 1) ? 1 : Integer.MIN_VALUE : this.f14377e == 0 ? 1 : Integer.MIN_VALUE : this.f14377e == 1 ? -1 : Integer.MIN_VALUE : this.f14377e == 0 ? -1 : Integer.MIN_VALUE : (this.f14377e != 1 && isLayoutRTL()) ? -1 : 1 : (this.f14377e != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private void d0() {
        if (this.f14376d.k() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            float e11 = this.f14376d.e(childAt);
            if (e11 >= f11) {
                if (((b) childAt.getLayoutParams()).b()) {
                    e11 = (e11 * 1.0f) / this.f14373a;
                }
                f11 = Math.max(f11, e11);
            }
        }
        int i12 = this.f14378f;
        int round = Math.round(f11 * this.f14373a);
        if (this.f14376d.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f14376d.n());
        }
        n0(round);
        if (this.f14378f == i12) {
            return;
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            b bVar = (b) childAt2.getLayoutParams();
            if (!bVar.f14411b) {
                if (isLayoutRTL() && this.f14377e == 1) {
                    int i14 = this.f14373a;
                    int i15 = bVar.f14410a.f14416e;
                    childAt2.offsetLeftAndRight(((-((i14 - 1) - i15)) * this.f14378f) - ((-((i14 - 1) - i15)) * i12));
                } else {
                    int i16 = bVar.f14410a.f14416e;
                    int i17 = this.f14378f * i16;
                    int i18 = i16 * i12;
                    if (this.f14377e == 1) {
                        childAt2.offsetLeftAndRight(i17 - i18);
                    } else {
                        childAt2.offsetTopAndBottom(i17 - i18);
                    }
                }
            }
        }
    }

    private void e0() {
        if (this.f14377e == 1 || !isLayoutRTL()) {
            this.f14381i = this.f14380h;
        } else {
            this.f14381i = !this.f14380h;
        }
    }

    private void g0(int i11) {
        g gVar = this.f14379g;
        gVar.f14464e = i11;
        gVar.f14463d = this.f14381i != (i11 == -1) ? -1 : 1;
    }

    private void i0(int i11, int i12) {
        for (int i13 = 0; i13 < this.f14373a; i13++) {
            if (!this.f14374b[i13].f14412a.isEmpty()) {
                o0(this.f14374b[i13], i11, i12);
            }
        }
    }

    private boolean j0(RecyclerView.y yVar, a aVar) {
        aVar.f14403a = this.f14387o ? F(yVar.b()) : z(yVar.b());
        aVar.f14404b = Integer.MIN_VALUE;
        return true;
    }

    private void k(View view) {
        for (int i11 = this.f14373a - 1; i11 >= 0; i11--) {
            this.f14374b[i11].a(view);
        }
    }

    private void l(a aVar) {
        SavedState savedState = this.f14389q;
        int i11 = savedState.mSpanOffsetsSize;
        if (i11 > 0) {
            if (i11 == this.f14373a) {
                for (int i12 = 0; i12 < this.f14373a; i12++) {
                    this.f14374b[i12].e();
                    SavedState savedState2 = this.f14389q;
                    int i13 = savedState2.mSpanOffsets[i12];
                    if (i13 != Integer.MIN_VALUE) {
                        i13 += savedState2.mAnchorLayoutFromEnd ? this.f14375c.i() : this.f14375c.m();
                    }
                    this.f14374b[i12].z(i13);
                }
            } else {
                savedState.invalidateSpanInfo();
                SavedState savedState3 = this.f14389q;
                savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
            }
        }
        SavedState savedState4 = this.f14389q;
        this.f14388p = savedState4.mLastLayoutRTL;
        setReverseLayout(savedState4.mReverseLayout);
        e0();
        SavedState savedState5 = this.f14389q;
        int i14 = savedState5.mAnchorPosition;
        if (i14 != -1) {
            this.f14383k = i14;
            aVar.f14405c = savedState5.mAnchorLayoutFromEnd;
        } else {
            aVar.f14405c = this.f14381i;
        }
        if (savedState5.mSpanLookupSize > 1) {
            LazySpanLookup lazySpanLookup = this.f14385m;
            lazySpanLookup.f14397a = savedState5.mSpanLookup;
            lazySpanLookup.f14398b = savedState5.mFullSpanItems;
        }
    }

    private void m0(int i11, RecyclerView.y yVar) {
        int i12;
        int i13;
        int c11;
        g gVar = this.f14379g;
        boolean z10 = false;
        gVar.f14461b = 0;
        gVar.f14462c = i11;
        if (!isSmoothScrolling() || (c11 = yVar.c()) == -1) {
            i12 = 0;
            i13 = 0;
        } else {
            if (this.f14381i == (c11 < i11)) {
                i12 = this.f14375c.n();
                i13 = 0;
            } else {
                i13 = this.f14375c.n();
                i12 = 0;
            }
        }
        if (getClipToPadding()) {
            this.f14379g.f14465f = this.f14375c.m() - i13;
            this.f14379g.f14466g = this.f14375c.i() + i12;
        } else {
            this.f14379g.f14466g = this.f14375c.h() + i12;
            this.f14379g.f14465f = -i13;
        }
        g gVar2 = this.f14379g;
        gVar2.f14467h = false;
        gVar2.f14460a = true;
        if (this.f14375c.k() == 0 && this.f14375c.h() == 0) {
            z10 = true;
        }
        gVar2.f14468i = z10;
    }

    private void o(View view, b bVar, g gVar) {
        if (gVar.f14464e == 1) {
            if (bVar.f14411b) {
                k(view);
                return;
            } else {
                bVar.f14410a.a(view);
                return;
            }
        }
        if (bVar.f14411b) {
            Z(view);
        } else {
            bVar.f14410a.y(view);
        }
    }

    private void o0(c cVar, int i11, int i12) {
        int n11 = cVar.n();
        if (i11 == -1) {
            if (cVar.s() + n11 <= i12) {
                this.f14382j.set(cVar.f14416e, false);
            }
        } else if (cVar.o() - n11 >= i12) {
            this.f14382j.set(cVar.f14416e, false);
        }
    }

    private int p(int i11) {
        if (getChildCount() == 0) {
            return this.f14381i ? 1 : -1;
        }
        return (i11 < J()) != this.f14381i ? -1 : 1;
    }

    private int p0(int i11, int i12, int i13) {
        if (i12 == 0 && i13 == 0) {
            return i11;
        }
        int mode = View.MeasureSpec.getMode(i11);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i11) - i12) - i13), mode) : i11;
    }

    private boolean r(c cVar) {
        if (this.f14381i) {
            if (cVar.o() < this.f14375c.i()) {
                ArrayList arrayList = cVar.f14412a;
                return !cVar.r((View) arrayList.get(arrayList.size() - 1)).f14411b;
            }
        } else if (cVar.s() > this.f14375c.m()) {
            return !cVar.r((View) cVar.f14412a.get(0)).f14411b;
        }
        return false;
    }

    private int s(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.a(yVar, this.f14375c, B(!this.f14394v), A(!this.f14394v), this, this.f14394v);
    }

    private int t(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.b(yVar, this.f14375c, B(!this.f14394v), A(!this.f14394v), this, this.f14394v, this.f14381i);
    }

    private int u(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.c(yVar, this.f14375c, B(!this.f14394v), A(!this.f14394v), this, this.f14394v);
    }

    private LazySpanLookup.FullSpanItem v(int i11) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f14401c = new int[this.f14373a];
        for (int i12 = 0; i12 < this.f14373a; i12++) {
            fullSpanItem.f14401c[i12] = i11 - this.f14374b[i12].p(i11);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem w(int i11) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f14401c = new int[this.f14373a];
        for (int i12 = 0; i12 < this.f14373a; i12++) {
            fullSpanItem.f14401c[i12] = this.f14374b[i12].t(i11) - i11;
        }
        return fullSpanItem;
    }

    private void x() {
        this.f14375c = m.b(this, this.f14377e);
        this.f14376d = m.b(this, 1 - this.f14377e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int y(RecyclerView.t tVar, g gVar, RecyclerView.y yVar) {
        c cVar;
        int e11;
        int i11;
        int i12;
        int e12;
        boolean z10;
        ?? r92 = 0;
        this.f14382j.set(0, this.f14373a, true);
        int i13 = this.f14379g.f14468i ? gVar.f14464e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : gVar.f14464e == 1 ? gVar.f14466g + gVar.f14461b : gVar.f14465f - gVar.f14461b;
        i0(gVar.f14464e, i13);
        int i14 = this.f14381i ? this.f14375c.i() : this.f14375c.m();
        boolean z11 = false;
        while (gVar.a(yVar) && (this.f14379g.f14468i || !this.f14382j.isEmpty())) {
            View b11 = gVar.b(tVar);
            b bVar = (b) b11.getLayoutParams();
            int viewLayoutPosition = bVar.getViewLayoutPosition();
            int g11 = this.f14385m.g(viewLayoutPosition);
            boolean z12 = g11 == -1 ? true : r92;
            if (z12) {
                cVar = bVar.f14411b ? this.f14374b[r92] : P(gVar);
                this.f14385m.n(viewLayoutPosition, cVar);
            } else {
                cVar = this.f14374b[g11];
            }
            c cVar2 = cVar;
            bVar.f14410a = cVar2;
            if (gVar.f14464e == 1) {
                addView(b11);
            } else {
                addView(b11, r92);
            }
            V(b11, bVar, r92);
            if (gVar.f14464e == 1) {
                int L = bVar.f14411b ? L(i14) : cVar2.p(i14);
                int e13 = this.f14375c.e(b11) + L;
                if (z12 && bVar.f14411b) {
                    LazySpanLookup.FullSpanItem v11 = v(L);
                    v11.f14400b = -1;
                    v11.f14399a = viewLayoutPosition;
                    this.f14385m.a(v11);
                }
                i11 = e13;
                e11 = L;
            } else {
                int O = bVar.f14411b ? O(i14) : cVar2.t(i14);
                e11 = O - this.f14375c.e(b11);
                if (z12 && bVar.f14411b) {
                    LazySpanLookup.FullSpanItem w11 = w(O);
                    w11.f14400b = 1;
                    w11.f14399a = viewLayoutPosition;
                    this.f14385m.a(w11);
                }
                i11 = O;
            }
            if (bVar.f14411b && gVar.f14463d == -1) {
                if (z12) {
                    this.f14393u = true;
                } else {
                    if (!(gVar.f14464e == 1 ? m() : n())) {
                        LazySpanLookup.FullSpanItem f11 = this.f14385m.f(viewLayoutPosition);
                        if (f11 != null) {
                            f11.f14402d = true;
                        }
                        this.f14393u = true;
                    }
                }
            }
            o(b11, bVar, gVar);
            if (isLayoutRTL() && this.f14377e == 1) {
                int i15 = bVar.f14411b ? this.f14376d.i() : this.f14376d.i() - (((this.f14373a - 1) - cVar2.f14416e) * this.f14378f);
                e12 = i15;
                i12 = i15 - this.f14376d.e(b11);
            } else {
                int m11 = bVar.f14411b ? this.f14376d.m() : (cVar2.f14416e * this.f14378f) + this.f14376d.m();
                i12 = m11;
                e12 = this.f14376d.e(b11) + m11;
            }
            if (this.f14377e == 1) {
                layoutDecoratedWithMargins(b11, i12, e11, e12, i11);
            } else {
                layoutDecoratedWithMargins(b11, e11, i12, i11, e12);
            }
            if (bVar.f14411b) {
                i0(this.f14379g.f14464e, i13);
            } else {
                o0(cVar2, this.f14379g.f14464e, i13);
            }
            a0(tVar, this.f14379g);
            if (this.f14379g.f14467h && b11.hasFocusable()) {
                if (bVar.f14411b) {
                    this.f14382j.clear();
                } else {
                    z10 = false;
                    this.f14382j.set(cVar2.f14416e, false);
                    r92 = z10;
                    z11 = true;
                }
            }
            z10 = false;
            r92 = z10;
            z11 = true;
        }
        int i16 = r92;
        if (!z11) {
            a0(tVar, this.f14379g);
        }
        int m12 = this.f14379g.f14464e == -1 ? this.f14375c.m() - O(this.f14375c.m()) : L(this.f14375c.i()) - this.f14375c.i();
        return m12 > 0 ? Math.min(gVar.f14461b, m12) : i16;
    }

    private int z(int i11) {
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            int position = getPosition(getChildAt(i12));
            if (position >= 0 && position < i11) {
                return position;
            }
        }
        return 0;
    }

    View A(boolean z10) {
        int m11 = this.f14375c.m();
        int i11 = this.f14375c.i();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int g11 = this.f14375c.g(childAt);
            int d11 = this.f14375c.d(childAt);
            if (d11 > m11 && g11 < i11) {
                if (d11 <= i11 || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    View B(boolean z10) {
        int m11 = this.f14375c.m();
        int i11 = this.f14375c.i();
        int childCount = getChildCount();
        View view = null;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            int g11 = this.f14375c.g(childAt);
            if (this.f14375c.d(childAt) > m11 && g11 < i11) {
                if (g11 >= m11 || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    int C() {
        View A = this.f14381i ? A(true) : B(true);
        if (A == null) {
            return -1;
        }
        return getPosition(A);
    }

    public int[] D(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f14373a];
        } else if (iArr.length < this.f14373a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f14373a + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.f14373a; i11++) {
            iArr[i11] = this.f14374b[i11].g();
        }
        return iArr;
    }

    public int[] E(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f14373a];
        } else if (iArr.length < this.f14373a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f14373a + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.f14373a; i11++) {
            iArr[i11] = this.f14374b[i11].h();
        }
        return iArr;
    }

    public int[] G(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f14373a];
        } else if (iArr.length < this.f14373a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f14373a + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.f14373a; i11++) {
            iArr[i11] = this.f14374b[i11].j();
        }
        return iArr;
    }

    int J() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    int K() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public int Q() {
        return this.f14373a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View S() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f14373a
            r2.<init>(r3)
            int r3 = r12.f14373a
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f14377e
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.f14381i
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f14410a
            int r9 = r9.f14416e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f14410a
            boolean r9 = r12.r(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f14410a
            int r9 = r9.f14416e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f14411b
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f14381i
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.m r10 = r12.f14375c
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.m r11 = r12.f14375c
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.m r10 = r12.f14375c
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.m r11 = r12.f14375c
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.f14410a
            int r8 = r8.f14416e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.f14410a
            int r9 = r9.f14416e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = r5
            goto L9a
        L99:
            r8 = r4
        L9a:
            if (r3 >= 0) goto L9e
            r9 = r5
            goto L9f
        L9e:
            r9 = r4
        L9f:
            if (r8 == r9) goto La2
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.S():android.view.View");
    }

    public void T() {
        this.f14385m.b();
        requestLayout();
    }

    void Y(int i11, RecyclerView.y yVar) {
        int J;
        int i12;
        if (i11 > 0) {
            J = K();
            i12 = 1;
        } else {
            J = J();
            i12 = -1;
        }
        this.f14379g.f14460a = true;
        m0(J, yVar);
        g0(i12);
        g gVar = this.f14379g;
        gVar.f14462c = J + gVar.f14463d;
        gVar.f14461b = Math.abs(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f14389q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollHorizontally() {
        return this.f14377e == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollVertically() {
        return this.f14377e == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean checkLayoutParams(RecyclerView.n nVar) {
        return nVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void collectAdjacentPrefetchPositions(int i11, int i12, RecyclerView.y yVar, RecyclerView.m.c cVar) {
        int p11;
        int i13;
        if (this.f14377e != 0) {
            i11 = i12;
        }
        if (getChildCount() == 0 || i11 == 0) {
            return;
        }
        Y(i11, yVar);
        int[] iArr = this.f14395w;
        if (iArr == null || iArr.length < this.f14373a) {
            this.f14395w = new int[this.f14373a];
        }
        int i14 = 0;
        for (int i15 = 0; i15 < this.f14373a; i15++) {
            g gVar = this.f14379g;
            if (gVar.f14463d == -1) {
                p11 = gVar.f14465f;
                i13 = this.f14374b[i15].t(p11);
            } else {
                p11 = this.f14374b[i15].p(gVar.f14466g);
                i13 = this.f14379g.f14466g;
            }
            int i16 = p11 - i13;
            if (i16 >= 0) {
                this.f14395w[i14] = i16;
                i14++;
            }
        }
        Arrays.sort(this.f14395w, 0, i14);
        for (int i17 = 0; i17 < i14 && this.f14379g.a(yVar); i17++) {
            cVar.a(this.f14379g.f14462c, this.f14395w[i17]);
            g gVar2 = this.f14379g;
            gVar2.f14462c += gVar2.f14463d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollExtent(RecyclerView.y yVar) {
        return s(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollOffset(RecyclerView.y yVar) {
        return t(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollRange(RecyclerView.y yVar) {
        return u(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF computeScrollVectorForPosition(int i11) {
        int p11 = p(i11);
        PointF pointF = new PointF();
        if (p11 == 0) {
            return null;
        }
        if (this.f14377e == 0) {
            pointF.x = p11;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = p11;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollExtent(RecyclerView.y yVar) {
        return s(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        return t(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        return u(yVar);
    }

    public void f0(int i11) {
        assertNotInLayoutOrScroll(null);
        if (i11 == this.f14386n) {
            return;
        }
        if (i11 != 0 && i11 != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.f14386n = i11;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateDefaultLayoutParams() {
        return this.f14377e == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public int getOrientation() {
        return this.f14377e;
    }

    public void h0(int i11) {
        assertNotInLayoutOrScroll(null);
        if (i11 != this.f14373a) {
            T();
            this.f14373a = i11;
            this.f14382j = new BitSet(this.f14373a);
            this.f14374b = new c[this.f14373a];
            for (int i12 = 0; i12 < this.f14373a; i12++) {
                this.f14374b[i12] = new c(i12);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean isAutoMeasureEnabled() {
        return this.f14386n != 0;
    }

    boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    boolean k0(RecyclerView.y yVar, a aVar) {
        int i11;
        if (!yVar.e() && (i11 = this.f14383k) != -1) {
            if (i11 >= 0 && i11 < yVar.b()) {
                SavedState savedState = this.f14389q;
                if (savedState == null || savedState.mAnchorPosition == -1 || savedState.mSpanOffsetsSize < 1) {
                    View findViewByPosition = findViewByPosition(this.f14383k);
                    if (findViewByPosition != null) {
                        aVar.f14403a = this.f14381i ? K() : J();
                        if (this.f14384l != Integer.MIN_VALUE) {
                            if (aVar.f14405c) {
                                aVar.f14404b = (this.f14375c.i() - this.f14384l) - this.f14375c.d(findViewByPosition);
                            } else {
                                aVar.f14404b = (this.f14375c.m() + this.f14384l) - this.f14375c.g(findViewByPosition);
                            }
                            return true;
                        }
                        if (this.f14375c.e(findViewByPosition) > this.f14375c.n()) {
                            aVar.f14404b = aVar.f14405c ? this.f14375c.i() : this.f14375c.m();
                            return true;
                        }
                        int g11 = this.f14375c.g(findViewByPosition) - this.f14375c.m();
                        if (g11 < 0) {
                            aVar.f14404b = -g11;
                            return true;
                        }
                        int i12 = this.f14375c.i() - this.f14375c.d(findViewByPosition);
                        if (i12 < 0) {
                            aVar.f14404b = i12;
                            return true;
                        }
                        aVar.f14404b = Integer.MIN_VALUE;
                    } else {
                        int i13 = this.f14383k;
                        aVar.f14403a = i13;
                        int i14 = this.f14384l;
                        if (i14 == Integer.MIN_VALUE) {
                            aVar.f14405c = p(i13) == 1;
                            aVar.a();
                        } else {
                            aVar.b(i14);
                        }
                        aVar.f14406d = true;
                    }
                } else {
                    aVar.f14404b = Integer.MIN_VALUE;
                    aVar.f14403a = this.f14383k;
                }
                return true;
            }
            this.f14383k = -1;
            this.f14384l = Integer.MIN_VALUE;
        }
        return false;
    }

    void l0(RecyclerView.y yVar, a aVar) {
        if (k0(yVar, aVar) || j0(yVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f14403a = 0;
    }

    boolean m() {
        int p11 = this.f14374b[0].p(Integer.MIN_VALUE);
        for (int i11 = 1; i11 < this.f14373a; i11++) {
            if (this.f14374b[i11].p(Integer.MIN_VALUE) != p11) {
                return false;
            }
        }
        return true;
    }

    boolean n() {
        int t11 = this.f14374b[0].t(Integer.MIN_VALUE);
        for (int i11 = 1; i11 < this.f14373a; i11++) {
            if (this.f14374b[i11].t(Integer.MIN_VALUE) != t11) {
                return false;
            }
        }
        return true;
    }

    void n0(int i11) {
        this.f14378f = i11 / this.f14373a;
        this.f14390r = View.MeasureSpec.makeMeasureSpec(i11, this.f14376d.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void offsetChildrenHorizontal(int i11) {
        super.offsetChildrenHorizontal(i11);
        for (int i12 = 0; i12 < this.f14373a; i12++) {
            this.f14374b[i12].v(i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void offsetChildrenVertical(int i11) {
        super.offsetChildrenVertical(i11);
        for (int i12 = 0; i12 < this.f14373a; i12++) {
            this.f14374b[i12].v(i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.f14385m.b();
        for (int i11 = 0; i11 < this.f14373a; i11++) {
            this.f14374b[i11].e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        removeCallbacks(this.f14396x);
        for (int i11 = 0; i11 < this.f14373a; i11++) {
            this.f14374b[i11].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public View onFocusSearchFailed(View view, int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        View findContainingItemView;
        View q11;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        e0();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) findContainingItemView.getLayoutParams();
        boolean z10 = bVar.f14411b;
        c cVar = bVar.f14410a;
        int K = convertFocusDirectionToLayoutDirection == 1 ? K() : J();
        m0(K, yVar);
        g0(convertFocusDirectionToLayoutDirection);
        g gVar = this.f14379g;
        gVar.f14462c = gVar.f14463d + K;
        gVar.f14461b = (int) (this.f14375c.n() * 0.33333334f);
        g gVar2 = this.f14379g;
        gVar2.f14467h = true;
        gVar2.f14460a = false;
        y(tVar, gVar2, yVar);
        this.f14387o = this.f14381i;
        if (!z10 && (q11 = cVar.q(K, convertFocusDirectionToLayoutDirection)) != null && q11 != findContainingItemView) {
            return q11;
        }
        if (X(convertFocusDirectionToLayoutDirection)) {
            for (int i12 = this.f14373a - 1; i12 >= 0; i12--) {
                View q12 = this.f14374b[i12].q(K, convertFocusDirectionToLayoutDirection);
                if (q12 != null && q12 != findContainingItemView) {
                    return q12;
                }
            }
        } else {
            for (int i13 = 0; i13 < this.f14373a; i13++) {
                View q13 = this.f14374b[i13].q(K, convertFocusDirectionToLayoutDirection);
                if (q13 != null && q13 != findContainingItemView) {
                    return q13;
                }
            }
        }
        boolean z11 = (this.f14380h ^ true) == (convertFocusDirectionToLayoutDirection == -1);
        if (!z10) {
            View findViewByPosition = findViewByPosition(z11 ? cVar.f() : cVar.i());
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (X(convertFocusDirectionToLayoutDirection)) {
            for (int i14 = this.f14373a - 1; i14 >= 0; i14--) {
                if (i14 != cVar.f14416e) {
                    View findViewByPosition2 = findViewByPosition(z11 ? this.f14374b[i14].f() : this.f14374b[i14].i());
                    if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i15 = 0; i15 < this.f14373a; i15++) {
                View findViewByPosition3 = findViewByPosition(z11 ? this.f14374b[i15].f() : this.f14374b[i15].i());
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View B = B(false);
            View A = A(false);
            if (B == null || A == null) {
                return;
            }
            int position = getPosition(B);
            int position2 = getPosition(A);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        R(i11, i12, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f14385m.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        R(i11, i12, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        R(i11, i12, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        R(i11, i12, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.y yVar) {
        W(tVar, yVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutCompleted(RecyclerView.y yVar) {
        super.onLayoutCompleted(yVar);
        this.f14383k = -1;
        this.f14384l = Integer.MIN_VALUE;
        this.f14389q = null;
        this.f14392t.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f14389q = savedState;
            if (this.f14383k != -1) {
                savedState.invalidateAnchorPositionInfo();
                this.f14389q.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable onSaveInstanceState() {
        int t11;
        int m11;
        int[] iArr;
        if (this.f14389q != null) {
            return new SavedState(this.f14389q);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.f14380h;
        savedState.mAnchorLayoutFromEnd = this.f14387o;
        savedState.mLastLayoutRTL = this.f14388p;
        LazySpanLookup lazySpanLookup = this.f14385m;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f14397a) == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = iArr;
            savedState.mSpanLookupSize = iArr.length;
            savedState.mFullSpanItems = lazySpanLookup.f14398b;
        }
        if (getChildCount() > 0) {
            savedState.mAnchorPosition = this.f14387o ? K() : J();
            savedState.mVisibleAnchorPosition = C();
            int i11 = this.f14373a;
            savedState.mSpanOffsetsSize = i11;
            savedState.mSpanOffsets = new int[i11];
            for (int i12 = 0; i12 < this.f14373a; i12++) {
                if (this.f14387o) {
                    t11 = this.f14374b[i12].p(Integer.MIN_VALUE);
                    if (t11 != Integer.MIN_VALUE) {
                        m11 = this.f14375c.i();
                        t11 -= m11;
                        savedState.mSpanOffsets[i12] = t11;
                    } else {
                        savedState.mSpanOffsets[i12] = t11;
                    }
                } else {
                    t11 = this.f14374b[i12].t(Integer.MIN_VALUE);
                    if (t11 != Integer.MIN_VALUE) {
                        m11 = this.f14375c.m();
                        t11 -= m11;
                        savedState.mSpanOffsets[i12] = t11;
                    } else {
                        savedState.mSpanOffsets[i12] = t11;
                    }
                }
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrollStateChanged(int i11) {
        if (i11 == 0) {
            q();
        }
    }

    boolean q() {
        int J;
        int K;
        if (getChildCount() == 0 || this.f14386n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f14381i) {
            J = K();
            K = J();
        } else {
            J = J();
            K = K();
        }
        if (J == 0 && S() != null) {
            this.f14385m.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.f14393u) {
            return false;
        }
        int i11 = this.f14381i ? -1 : 1;
        int i12 = K + 1;
        LazySpanLookup.FullSpanItem e11 = this.f14385m.e(J, i12, i11, true);
        if (e11 == null) {
            this.f14393u = false;
            this.f14385m.d(i12);
            return false;
        }
        LazySpanLookup.FullSpanItem e12 = this.f14385m.e(J, e11.f14399a, i11 * (-1), true);
        if (e12 == null) {
            this.f14385m.d(e11.f14399a);
        } else {
            this.f14385m.d(e12.f14399a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    int scrollBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        Y(i11, yVar);
        int y10 = y(tVar, this.f14379g, yVar);
        if (this.f14379g.f14461b >= y10) {
            i11 = i11 < 0 ? -y10 : y10;
        }
        this.f14375c.r(-i11);
        this.f14387o = this.f14381i;
        g gVar = this.f14379g;
        gVar.f14461b = 0;
        a0(tVar, gVar);
        return i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        return scrollBy(i11, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void scrollToPosition(int i11) {
        SavedState savedState = this.f14389q;
        if (savedState != null && savedState.mAnchorPosition != i11) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.f14383k = i11;
        this.f14384l = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        return scrollBy(i11, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void setMeasuredDimension(Rect rect, int i11, int i12) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f14377e == 1) {
            chooseSize2 = RecyclerView.m.chooseSize(i12, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = RecyclerView.m.chooseSize(i11, (this.f14378f * this.f14373a) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.m.chooseSize(i11, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = RecyclerView.m.chooseSize(i12, (this.f14378f * this.f14373a) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i11) {
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i11 == this.f14377e) {
            return;
        }
        this.f14377e = i11;
        m mVar = this.f14375c;
        this.f14375c = this.f14376d;
        this.f14376d = mVar;
        requestLayout();
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.f14389q;
        if (savedState != null && savedState.mReverseLayout != z10) {
            savedState.mReverseLayout = z10;
        }
        this.f14380h = z10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.y yVar, int i11) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i11);
        startSmoothScroll(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean supportsPredictiveItemAnimations() {
        return this.f14389q == null;
    }
}
