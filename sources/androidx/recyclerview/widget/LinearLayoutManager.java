package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.m implements RecyclerView.x.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    m mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

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
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        m f14287a;

        /* renamed from: b, reason: collision with root package name */
        int f14288b;

        /* renamed from: c, reason: collision with root package name */
        int f14289c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14290d;

        /* renamed from: e, reason: collision with root package name */
        boolean f14291e;

        a() {
            e();
        }

        void a() {
            this.f14289c = this.f14290d ? this.f14287a.i() : this.f14287a.m();
        }

        public void b(View view, int i11) {
            if (this.f14290d) {
                this.f14289c = this.f14287a.d(view) + this.f14287a.o();
            } else {
                this.f14289c = this.f14287a.g(view);
            }
            this.f14288b = i11;
        }

        public void c(View view, int i11) {
            int o11 = this.f14287a.o();
            if (o11 >= 0) {
                b(view, i11);
                return;
            }
            this.f14288b = i11;
            if (this.f14290d) {
                int i12 = (this.f14287a.i() - o11) - this.f14287a.d(view);
                this.f14289c = this.f14287a.i() - i12;
                if (i12 > 0) {
                    int e11 = this.f14289c - this.f14287a.e(view);
                    int m11 = this.f14287a.m();
                    int min = e11 - (m11 + Math.min(this.f14287a.g(view) - m11, 0));
                    if (min < 0) {
                        this.f14289c += Math.min(i12, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g11 = this.f14287a.g(view);
            int m12 = g11 - this.f14287a.m();
            this.f14289c = g11;
            if (m12 > 0) {
                int i13 = (this.f14287a.i() - Math.min(0, (this.f14287a.i() - o11) - this.f14287a.d(view))) - (g11 + this.f14287a.e(view));
                if (i13 < 0) {
                    this.f14289c -= Math.min(m12, -i13);
                }
            }
        }

        boolean d(View view, RecyclerView.y yVar) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return !nVar.isItemRemoved() && nVar.getViewLayoutPosition() >= 0 && nVar.getViewLayoutPosition() < yVar.b();
        }

        void e() {
            this.f14288b = -1;
            this.f14289c = Integer.MIN_VALUE;
            this.f14290d = false;
            this.f14291e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f14288b + ", mCoordinate=" + this.f14289c + ", mLayoutFromEnd=" + this.f14290d + ", mValid=" + this.f14291e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f14292a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f14293b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f14294c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f14295d;

        protected b() {
        }

        void a() {
            this.f14292a = 0;
            this.f14293b = false;
            this.f14294c = false;
            this.f14295d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        int f14297b;

        /* renamed from: c, reason: collision with root package name */
        int f14298c;

        /* renamed from: d, reason: collision with root package name */
        int f14299d;

        /* renamed from: e, reason: collision with root package name */
        int f14300e;

        /* renamed from: f, reason: collision with root package name */
        int f14301f;

        /* renamed from: g, reason: collision with root package name */
        int f14302g;

        /* renamed from: k, reason: collision with root package name */
        int f14306k;

        /* renamed from: m, reason: collision with root package name */
        boolean f14308m;

        /* renamed from: a, reason: collision with root package name */
        boolean f14296a = true;

        /* renamed from: h, reason: collision with root package name */
        int f14303h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f14304i = 0;

        /* renamed from: j, reason: collision with root package name */
        boolean f14305j = false;

        /* renamed from: l, reason: collision with root package name */
        List f14307l = null;

        c() {
        }

        private View e() {
            int size = this.f14307l.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = ((RecyclerView.b0) this.f14307l.get(i11)).itemView;
                RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
                if (!nVar.isItemRemoved() && this.f14299d == nVar.getViewLayoutPosition()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f11 = f(view);
            if (f11 == null) {
                this.f14299d = -1;
            } else {
                this.f14299d = ((RecyclerView.n) f11.getLayoutParams()).getViewLayoutPosition();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.y yVar) {
            int i11 = this.f14299d;
            return i11 >= 0 && i11 < yVar.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.t tVar) {
            if (this.f14307l != null) {
                return e();
            }
            View o11 = tVar.o(this.f14299d);
            this.f14299d += this.f14300e;
            return o11;
        }

        public View f(View view) {
            int viewLayoutPosition;
            int size = this.f14307l.size();
            View view2 = null;
            int i11 = Integer.MAX_VALUE;
            for (int i12 = 0; i12 < size; i12++) {
                View view3 = ((RecyclerView.b0) this.f14307l.get(i12)).itemView;
                RecyclerView.n nVar = (RecyclerView.n) view3.getLayoutParams();
                if (view3 != view && !nVar.isItemRemoved() && (viewLayoutPosition = (nVar.getViewLayoutPosition() - this.f14299d) * this.f14300e) >= 0 && viewLayoutPosition < i11) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i11 = viewLayoutPosition;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i11, boolean z10) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i11);
        setReverseLayout(z10);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.m.d properties = RecyclerView.m.getProperties(context, attributeSet, i11, i12);
        setOrientation(properties.f14320a);
        setReverseLayout(properties.f14322c);
        setStackFromEnd(properties.f14323d);
    }

    private void A(RecyclerView.t tVar, int i11, int i12) {
        if (i11 < 0) {
            return;
        }
        int i13 = i11 - i12;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (this.mOrientationHelper.d(childAt) > i13 || this.mOrientationHelper.p(childAt) > i13) {
                    y(tVar, 0, i14);
                    return;
                }
            }
            return;
        }
        int i15 = childCount - 1;
        for (int i16 = i15; i16 >= 0; i16--) {
            View childAt2 = getChildAt(i16);
            if (this.mOrientationHelper.d(childAt2) > i13 || this.mOrientationHelper.p(childAt2) > i13) {
                y(tVar, i15, i16);
                return;
            }
        }
    }

    private void B() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean C(RecyclerView.t tVar, RecyclerView.y yVar, a aVar) {
        View findReferenceChild;
        boolean z10 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.d(focusedChild, yVar)) {
            aVar.c(focusedChild, getPosition(focusedChild));
            return true;
        }
        boolean z11 = this.mLastStackFromEnd;
        boolean z12 = this.mStackFromEnd;
        if (z11 != z12 || (findReferenceChild = findReferenceChild(tVar, yVar, aVar.f14290d, z12)) == null) {
            return false;
        }
        aVar.b(findReferenceChild, getPosition(findReferenceChild));
        if (!yVar.e() && supportsPredictiveItemAnimations()) {
            int g11 = this.mOrientationHelper.g(findReferenceChild);
            int d11 = this.mOrientationHelper.d(findReferenceChild);
            int m11 = this.mOrientationHelper.m();
            int i11 = this.mOrientationHelper.i();
            boolean z13 = d11 <= m11 && g11 < m11;
            if (g11 >= i11 && d11 > i11) {
                z10 = true;
            }
            if (z13 || z10) {
                if (aVar.f14290d) {
                    m11 = i11;
                }
                aVar.f14289c = m11;
            }
        }
        return true;
    }

    private boolean D(RecyclerView.y yVar, a aVar) {
        int i11;
        if (!yVar.e() && (i11 = this.mPendingScrollPosition) != -1) {
            if (i11 >= 0 && i11 < yVar.b()) {
                aVar.f14288b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    boolean z10 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    aVar.f14290d = z10;
                    if (z10) {
                        aVar.f14289c = this.mOrientationHelper.i() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        aVar.f14289c = this.mOrientationHelper.m() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z11 = this.mShouldReverseLayout;
                    aVar.f14290d = z11;
                    if (z11) {
                        aVar.f14289c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f14289c = this.mOrientationHelper.m() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (findViewByPosition == null) {
                    if (getChildCount() > 0) {
                        aVar.f14290d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    aVar.a();
                } else {
                    if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m() < 0) {
                        aVar.f14289c = this.mOrientationHelper.m();
                        aVar.f14290d = false;
                        return true;
                    }
                    if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                        aVar.f14289c = this.mOrientationHelper.i();
                        aVar.f14290d = true;
                        return true;
                    }
                    aVar.f14289c = aVar.f14290d ? this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.o() : this.mOrientationHelper.g(findViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void E(RecyclerView.t tVar, RecyclerView.y yVar, a aVar) {
        if (D(yVar, aVar) || C(tVar, yVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f14288b = this.mStackFromEnd ? yVar.b() - 1 : 0;
    }

    private void F(int i11, int i12, boolean z10, RecyclerView.y yVar) {
        int m11;
        this.mLayoutState.f14308m = resolveIsInfinite();
        this.mLayoutState.f14301f = i11;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(yVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z11 = i11 == 1;
        c cVar = this.mLayoutState;
        int i13 = z11 ? max2 : max;
        cVar.f14303h = i13;
        if (!z11) {
            max = max2;
        }
        cVar.f14304i = max;
        if (z11) {
            cVar.f14303h = i13 + this.mOrientationHelper.j();
            View t11 = t();
            c cVar2 = this.mLayoutState;
            cVar2.f14300e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(t11);
            c cVar3 = this.mLayoutState;
            cVar2.f14299d = position + cVar3.f14300e;
            cVar3.f14297b = this.mOrientationHelper.d(t11);
            m11 = this.mOrientationHelper.d(t11) - this.mOrientationHelper.i();
        } else {
            View u11 = u();
            this.mLayoutState.f14303h += this.mOrientationHelper.m();
            c cVar4 = this.mLayoutState;
            cVar4.f14300e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(u11);
            c cVar5 = this.mLayoutState;
            cVar4.f14299d = position2 + cVar5.f14300e;
            cVar5.f14297b = this.mOrientationHelper.g(u11);
            m11 = (-this.mOrientationHelper.g(u11)) + this.mOrientationHelper.m();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f14298c = i12;
        if (z10) {
            cVar6.f14298c = i12 - m11;
        }
        cVar6.f14302g = m11;
    }

    private void G(int i11, int i12) {
        this.mLayoutState.f14298c = this.mOrientationHelper.i() - i12;
        c cVar = this.mLayoutState;
        cVar.f14300e = this.mShouldReverseLayout ? -1 : 1;
        cVar.f14299d = i11;
        cVar.f14301f = 1;
        cVar.f14297b = i12;
        cVar.f14302g = Integer.MIN_VALUE;
    }

    private void H(a aVar) {
        G(aVar.f14288b, aVar.f14289c);
    }

    private void I(int i11, int i12) {
        this.mLayoutState.f14298c = i12 - this.mOrientationHelper.m();
        c cVar = this.mLayoutState;
        cVar.f14299d = i11;
        cVar.f14300e = this.mShouldReverseLayout ? 1 : -1;
        cVar.f14301f = -1;
        cVar.f14297b = i12;
        cVar.f14302g = Integer.MIN_VALUE;
    }

    private void J(a aVar) {
        I(aVar.f14288b, aVar.f14289c);
    }

    private int k(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.a(yVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int l(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.b(yVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int m(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.c(yVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View n() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View o() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View p() {
        return this.mShouldReverseLayout ? n() : o();
    }

    private View q() {
        return this.mShouldReverseLayout ? o() : n();
    }

    private int r(int i11, RecyclerView.t tVar, RecyclerView.y yVar, boolean z10) {
        int i12;
        int i13 = this.mOrientationHelper.i() - i11;
        if (i13 <= 0) {
            return 0;
        }
        int i14 = -scrollBy(-i13, tVar, yVar);
        int i15 = i11 + i14;
        if (!z10 || (i12 = this.mOrientationHelper.i() - i15) <= 0) {
            return i14;
        }
        this.mOrientationHelper.r(i12);
        return i12 + i14;
    }

    private int s(int i11, RecyclerView.t tVar, RecyclerView.y yVar, boolean z10) {
        int m11;
        int m12 = i11 - this.mOrientationHelper.m();
        if (m12 <= 0) {
            return 0;
        }
        int i12 = -scrollBy(m12, tVar, yVar);
        int i13 = i11 + i12;
        if (!z10 || (m11 = i13 - this.mOrientationHelper.m()) <= 0) {
            return i12;
        }
        this.mOrientationHelper.r(-m11);
        return i12 - m11;
    }

    private View t() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View u() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void v(RecyclerView.t tVar, RecyclerView.y yVar, int i11, int i12) {
        if (!yVar.g() || getChildCount() == 0 || yVar.e() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List k11 = tVar.k();
        int size = k11.size();
        int position = getPosition(getChildAt(0));
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < size; i15++) {
            RecyclerView.b0 b0Var = (RecyclerView.b0) k11.get(i15);
            if (!b0Var.isRemoved()) {
                if ((b0Var.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                    i13 += this.mOrientationHelper.e(b0Var.itemView);
                } else {
                    i14 += this.mOrientationHelper.e(b0Var.itemView);
                }
            }
        }
        this.mLayoutState.f14307l = k11;
        if (i13 > 0) {
            I(getPosition(u()), i11);
            c cVar = this.mLayoutState;
            cVar.f14303h = i13;
            cVar.f14298c = 0;
            cVar.a();
            fill(tVar, this.mLayoutState, yVar, false);
        }
        if (i14 > 0) {
            G(getPosition(t()), i12);
            c cVar2 = this.mLayoutState;
            cVar2.f14303h = i14;
            cVar2.f14298c = 0;
            cVar2.a();
            fill(tVar, this.mLayoutState, yVar, false);
        }
        this.mLayoutState.f14307l = null;
    }

    private void w() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("item ");
            sb2.append(getPosition(childAt));
            sb2.append(", coord:");
            sb2.append(this.mOrientationHelper.g(childAt));
        }
    }

    private void x(RecyclerView.t tVar, c cVar) {
        if (!cVar.f14296a || cVar.f14308m) {
            return;
        }
        int i11 = cVar.f14302g;
        int i12 = cVar.f14304i;
        if (cVar.f14301f == -1) {
            z(tVar, i11, i12);
        } else {
            A(tVar, i11, i12);
        }
    }

    private void y(RecyclerView.t tVar, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        if (i12 <= i11) {
            while (i11 > i12) {
                removeAndRecycleViewAt(i11, tVar);
                i11--;
            }
        } else {
            for (int i13 = i12 - 1; i13 >= i11; i13--) {
                removeAndRecycleViewAt(i13, tVar);
            }
        }
    }

    private void z(RecyclerView.t tVar, int i11, int i12) {
        int childCount = getChildCount();
        if (i11 < 0) {
            return;
        }
        int h11 = (this.mOrientationHelper.h() - i11) + i12;
        if (this.mShouldReverseLayout) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (this.mOrientationHelper.g(childAt) < h11 || this.mOrientationHelper.q(childAt) < h11) {
                    y(tVar, 0, i13);
                    return;
                }
            }
            return;
        }
        int i14 = childCount - 1;
        for (int i15 = i14; i15 >= 0; i15--) {
            View childAt2 = getChildAt(i15);
            if (this.mOrientationHelper.g(childAt2) < h11 || this.mOrientationHelper.q(childAt2) < h11) {
                y(tVar, i14, i15);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(RecyclerView.y yVar, int[] iArr) {
        int i11;
        int extraLayoutSpace = getExtraLayoutSpace(yVar);
        if (this.mLayoutState.f14301f == -1) {
            i11 = 0;
        } else {
            i11 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i11, int i12, RecyclerView.y yVar, RecyclerView.m.c cVar) {
        if (this.mOrientation != 0) {
            i11 = i12;
        }
        if (getChildCount() == 0 || i11 == 0) {
            return;
        }
        ensureLayoutState();
        F(i11 > 0 ? 1 : -1, Math.abs(i11), true, yVar);
        collectPrefetchPositionsForLayoutState(yVar, this.mLayoutState, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i11, RecyclerView.m.c cVar) {
        boolean z10;
        int i12;
        SavedState savedState = this.mPendingSavedState;
        if (savedState == null || !savedState.hasValidAnchor()) {
            B();
            z10 = this.mShouldReverseLayout;
            i12 = this.mPendingScrollPosition;
            if (i12 == -1) {
                i12 = z10 ? i11 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z10 = savedState2.mAnchorLayoutFromEnd;
            i12 = savedState2.mAnchorPosition;
        }
        int i13 = z10 ? -1 : 1;
        for (int i14 = 0; i14 < this.mInitialPrefetchItemCount && i12 >= 0 && i12 < i11; i14++) {
            cVar.a(i12, 0);
            i12 += i13;
        }
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.y yVar, c cVar, RecyclerView.m.c cVar2) {
        int i11 = cVar.f14299d;
        if (i11 < 0 || i11 >= yVar.b()) {
            return;
        }
        cVar2.a(i11, Math.max(0, cVar.f14302g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.y yVar) {
        return k(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.y yVar) {
        return l(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.y yVar) {
        return m(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i11) {
        if (getChildCount() == 0) {
            return null;
        }
        int i12 = (i11 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i12, 0.0f) : new PointF(0.0f, i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.y yVar) {
        return k(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        return l(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        return m(yVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 17 ? i11 != 33 ? i11 != 66 ? (i11 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    c createLayoutState() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    int fill(RecyclerView.t tVar, c cVar, RecyclerView.y yVar, boolean z10) {
        int i11 = cVar.f14298c;
        int i12 = cVar.f14302g;
        if (i12 != Integer.MIN_VALUE) {
            if (i11 < 0) {
                cVar.f14302g = i12 + i11;
            }
            x(tVar, cVar);
        }
        int i13 = cVar.f14298c + cVar.f14303h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.f14308m && i13 <= 0) || !cVar.c(yVar)) {
                break;
            }
            bVar.a();
            layoutChunk(tVar, yVar, cVar, bVar);
            if (!bVar.f14293b) {
                cVar.f14297b += bVar.f14292a * cVar.f14301f;
                if (!bVar.f14294c || cVar.f14307l != null || !yVar.e()) {
                    int i14 = cVar.f14298c;
                    int i15 = bVar.f14292a;
                    cVar.f14298c = i14 - i15;
                    i13 -= i15;
                }
                int i16 = cVar.f14302g;
                if (i16 != Integer.MIN_VALUE) {
                    int i17 = i16 + bVar.f14292a;
                    cVar.f14302g = i17;
                    int i18 = cVar.f14298c;
                    if (i18 < 0) {
                        cVar.f14302g = i17 + i18;
                    }
                    x(tVar, cVar);
                }
                if (z10 && bVar.f14295d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i11 - cVar.f14298c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z10, boolean z11) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z10, z11) : findOneVisibleChild(getChildCount() - 1, -1, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z10, boolean z11) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z10, z11) : findOneVisibleChild(0, getChildCount(), z10, z11);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i11, int i12) {
        int i13;
        int i14;
        ensureLayoutState();
        if (i12 <= i11 && i12 >= i11) {
            return getChildAt(i11);
        }
        if (this.mOrientationHelper.g(getChildAt(i11)) < this.mOrientationHelper.m()) {
            i13 = 16644;
            i14 = 16388;
        } else {
            i13 = 4161;
            i14 = 4097;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i11, i12, i13, i14) : this.mVerticalBoundCheck.a(i11, i12, i13, i14);
    }

    View findOneVisibleChild(int i11, int i12, boolean z10, boolean z11) {
        ensureLayoutState();
        int i13 = Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE;
        int i14 = z10 ? 24579 : 320;
        if (!z11) {
            i13 = 0;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i11, i12, i14, i13) : this.mVerticalBoundCheck.a(i11, i12, i14, i13);
    }

    View findReferenceChild(RecyclerView.t tVar, RecyclerView.y yVar, boolean z10, boolean z11) {
        int i11;
        int i12;
        int i13;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z11) {
            i12 = getChildCount() - 1;
            i11 = -1;
            i13 = -1;
        } else {
            i11 = childCount;
            i12 = 0;
            i13 = 1;
        }
        int b11 = yVar.b();
        int m11 = this.mOrientationHelper.m();
        int i14 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i12 != i11) {
            View childAt = getChildAt(i12);
            int position = getPosition(childAt);
            int g11 = this.mOrientationHelper.g(childAt);
            int d11 = this.mOrientationHelper.d(childAt);
            if (position >= 0 && position < b11) {
                if (!((RecyclerView.n) childAt.getLayoutParams()).isItemRemoved()) {
                    boolean z12 = d11 <= m11 && g11 < m11;
                    boolean z13 = g11 >= i14 && d11 > i14;
                    if (!z12 && !z13) {
                        return childAt;
                    }
                    if (z10) {
                        if (!z13) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    } else {
                        if (!z12) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    }
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i12 += i13;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i11) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i11 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i11) {
                return childAt;
            }
        }
        return super.findViewByPosition(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public RecyclerView.n generateDefaultLayoutParams() {
        return new RecyclerView.n(-2, -2);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.y yVar) {
        if (yVar.d()) {
            return this.mOrientationHelper.n();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(RecyclerView.t tVar, RecyclerView.y yVar, c cVar, b bVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int f11;
        View d11 = cVar.d(tVar);
        if (d11 == null) {
            bVar.f14293b = true;
            return;
        }
        RecyclerView.n nVar = (RecyclerView.n) d11.getLayoutParams();
        if (cVar.f14307l == null) {
            if (this.mShouldReverseLayout == (cVar.f14301f == -1)) {
                addView(d11);
            } else {
                addView(d11, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f14301f == -1)) {
                addDisappearingView(d11);
            } else {
                addDisappearingView(d11, 0);
            }
        }
        measureChildWithMargins(d11, 0, 0);
        bVar.f14292a = this.mOrientationHelper.e(d11);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                f11 = getWidth() - getPaddingRight();
                i14 = f11 - this.mOrientationHelper.f(d11);
            } else {
                i14 = getPaddingLeft();
                f11 = this.mOrientationHelper.f(d11) + i14;
            }
            if (cVar.f14301f == -1) {
                int i15 = cVar.f14297b;
                i13 = i15;
                i12 = f11;
                i11 = i15 - bVar.f14292a;
            } else {
                int i16 = cVar.f14297b;
                i11 = i16;
                i12 = f11;
                i13 = bVar.f14292a + i16;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f12 = this.mOrientationHelper.f(d11) + paddingTop;
            if (cVar.f14301f == -1) {
                int i17 = cVar.f14297b;
                i12 = i17;
                i11 = paddingTop;
                i13 = f12;
                i14 = i17 - bVar.f14292a;
            } else {
                int i18 = cVar.f14297b;
                i11 = paddingTop;
                i12 = bVar.f14292a + i18;
                i13 = f12;
                i14 = i18;
            }
        }
        layoutDecoratedWithMargins(d11, i14, i11, i12, i13);
        if (nVar.isItemRemoved() || nVar.isItemChanged()) {
            bVar.f14294c = true;
        }
        bVar.f14295d = d11.hasFocusable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.t tVar, RecyclerView.y yVar, a aVar, int i11) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(tVar);
            tVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        int convertFocusDirectionToLayoutDirection;
        B();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        F(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.n() * MAX_SCROLL_FACTOR), false, yVar);
        c cVar = this.mLayoutState;
        cVar.f14302g = Integer.MIN_VALUE;
        cVar.f14296a = false;
        fill(tVar, cVar, yVar, true);
        View q11 = convertFocusDirectionToLayoutDirection == -1 ? q() : p();
        View u11 = convertFocusDirectionToLayoutDirection == -1 ? u() : t();
        if (!u11.hasFocusable()) {
            return q11;
        }
        if (q11 == null) {
            return null;
        }
        return u11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.y yVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int r11;
        int i15;
        View findViewByPosition;
        int g11;
        int i16;
        int i17 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && yVar.b() == 0) {
            removeAndRecycleAllViews(tVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.f14296a = false;
        B();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (!aVar.f14291e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.f14290d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            E(tVar, yVar, aVar2);
            this.mAnchorInfo.f14291e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.g(focusedChild) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(focusedChild) <= this.mOrientationHelper.m())) {
            this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f14301f = cVar.f14306k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(yVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.m();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (yVar.e() && (i15 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i15)) != null) {
            if (this.mShouldReverseLayout) {
                i16 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                g11 = this.mPendingScrollPositionOffset;
            } else {
                g11 = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m();
                i16 = this.mPendingScrollPositionOffset;
            }
            int i18 = i16 - g11;
            if (i18 > 0) {
                max += i18;
            } else {
                max2 -= i18;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.f14290d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i17 = 1;
        }
        onAnchorReady(tVar, yVar, aVar3, i17);
        detachAndScrapAttachedViews(tVar);
        this.mLayoutState.f14308m = resolveIsInfinite();
        this.mLayoutState.f14305j = yVar.e();
        this.mLayoutState.f14304i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.f14290d) {
            J(aVar4);
            c cVar2 = this.mLayoutState;
            cVar2.f14303h = max;
            fill(tVar, cVar2, yVar, false);
            c cVar3 = this.mLayoutState;
            i12 = cVar3.f14297b;
            int i19 = cVar3.f14299d;
            int i20 = cVar3.f14298c;
            if (i20 > 0) {
                max2 += i20;
            }
            H(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.f14303h = max2;
            cVar4.f14299d += cVar4.f14300e;
            fill(tVar, cVar4, yVar, false);
            c cVar5 = this.mLayoutState;
            i11 = cVar5.f14297b;
            int i21 = cVar5.f14298c;
            if (i21 > 0) {
                I(i19, i12);
                c cVar6 = this.mLayoutState;
                cVar6.f14303h = i21;
                fill(tVar, cVar6, yVar, false);
                i12 = this.mLayoutState.f14297b;
            }
        } else {
            H(aVar4);
            c cVar7 = this.mLayoutState;
            cVar7.f14303h = max2;
            fill(tVar, cVar7, yVar, false);
            c cVar8 = this.mLayoutState;
            i11 = cVar8.f14297b;
            int i22 = cVar8.f14299d;
            int i23 = cVar8.f14298c;
            if (i23 > 0) {
                max += i23;
            }
            J(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.f14303h = max;
            cVar9.f14299d += cVar9.f14300e;
            fill(tVar, cVar9, yVar, false);
            c cVar10 = this.mLayoutState;
            i12 = cVar10.f14297b;
            int i24 = cVar10.f14298c;
            if (i24 > 0) {
                G(i22, i11);
                c cVar11 = this.mLayoutState;
                cVar11.f14303h = i24;
                fill(tVar, cVar11, yVar, false);
                i11 = this.mLayoutState.f14297b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int r12 = r(i11, tVar, yVar, true);
                i13 = i12 + r12;
                i14 = i11 + r12;
                r11 = s(i13, tVar, yVar, false);
            } else {
                int s11 = s(i12, tVar, yVar, true);
                i13 = i12 + s11;
                i14 = i11 + s11;
                r11 = r(i14, tVar, yVar, false);
            }
            i12 = i13 + r11;
            i11 = i14 + r11;
        }
        v(tVar, yVar, i12, i11);
        if (yVar.e()) {
            this.mAnchorInfo.e();
        } else {
            this.mOrientationHelper.s();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.y yVar) {
        super.onLayoutCompleted(yVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z10 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z10;
            if (z10) {
                View t11 = t();
                savedState.mAnchorOffset = this.mOrientationHelper.i() - this.mOrientationHelper.d(t11);
                savedState.mAnchorPosition = getPosition(t11);
            } else {
                View u11 = u();
                savedState.mAnchorPosition = getPosition(u11);
                savedState.mAnchorOffset = this.mOrientationHelper.g(u11) - this.mOrientationHelper.m();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i11, int i12) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        B();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c11 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c11 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - (this.mOrientationHelper.g(view2) + this.mOrientationHelper.e(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - this.mOrientationHelper.d(view2));
                return;
            }
        }
        if (c11 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2) - this.mOrientationHelper.e(view));
        }
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.k() == 0 && this.mOrientationHelper.h() == 0;
    }

    int scrollBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f14296a = true;
        int i12 = i11 > 0 ? 1 : -1;
        int abs = Math.abs(i11);
        F(i12, abs, true, yVar);
        c cVar = this.mLayoutState;
        int fill = cVar.f14302g + fill(tVar, cVar, yVar, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i11 = i12 * fill;
        }
        this.mOrientationHelper.r(-i11);
        this.mLayoutState.f14306k = i11;
        return i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i11, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void scrollToPosition(int i11) {
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i11, int i12) {
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = i12;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i11, tVar, yVar);
    }

    public void setInitialPrefetchItemCount(int i11) {
        this.mInitialPrefetchItemCount = i11;
    }

    public void setOrientation(int i11) {
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i11);
        }
        assertNotInLayoutOrScroll(null);
        if (i11 != this.mOrientation || this.mOrientationHelper == null) {
            m b11 = m.b(this, i11);
            this.mOrientationHelper = b11;
            this.mAnchorInfo.f14287a = b11;
            this.mOrientation = i11;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z10) {
        this.mRecycleChildrenOnDetach = z10;
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z10;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z10) {
        this.mSmoothScrollbarEnabled = z10;
    }

    public void setStackFromEnd(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z10) {
            return;
        }
        this.mStackFromEnd = z10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.y yVar, int i11) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i11);
        startSmoothScroll(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    void validateChildOrder() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("validating child count ");
        sb2.append(getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int g11 = this.mOrientationHelper.g(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i11 = 1; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                int position2 = getPosition(childAt);
                int g12 = this.mOrientationHelper.g(childAt);
                if (position2 < position) {
                    w();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("detected invalid position. loc invalid? ");
                    sb3.append(g12 < g11);
                    throw new RuntimeException(sb3.toString());
                }
                if (g12 > g11) {
                    w();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i12 = 1; i12 < getChildCount(); i12++) {
            View childAt2 = getChildAt(i12);
            int position3 = getPosition(childAt2);
            int g13 = this.mOrientationHelper.g(childAt2);
            if (position3 < position) {
                w();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("detected invalid position. loc invalid? ");
                sb4.append(g13 < g11);
                throw new RuntimeException(sb4.toString());
            }
            if (g13 < g11) {
                w();
                throw new RuntimeException("detected invalid location");
            }
        }
    }
}
