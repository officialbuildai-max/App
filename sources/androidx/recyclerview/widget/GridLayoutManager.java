package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    boolean f14272a;

    /* renamed from: b, reason: collision with root package name */
    int f14273b;

    /* renamed from: c, reason: collision with root package name */
    int[] f14274c;

    /* renamed from: d, reason: collision with root package name */
    View[] f14275d;

    /* renamed from: e, reason: collision with root package name */
    final SparseIntArray f14276e;

    /* renamed from: f, reason: collision with root package name */
    final SparseIntArray f14277f;

    /* renamed from: g, reason: collision with root package name */
    c f14278g;

    /* renamed from: h, reason: collision with root package name */
    final Rect f14279h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f14280i;

    /* loaded from: classes2.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i11, int i12) {
            return i11 % i12;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            return 1;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.n {

        /* renamed from: a, reason: collision with root package name */
        int f14281a;

        /* renamed from: b, reason: collision with root package name */
        int f14282b;

        public b(int i11, int i12) {
            super(i11, i12);
            this.f14281a = -1;
            this.f14282b = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f14281a = -1;
            this.f14282b = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f14281a = -1;
            this.f14282b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f14281a = -1;
            this.f14282b = 0;
        }

        public int a() {
            return this.f14281a;
        }

        public int b() {
            return this.f14282b;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final SparseIntArray f14283a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        final SparseIntArray f14284b = new SparseIntArray();

        /* renamed from: c, reason: collision with root package name */
        private boolean f14285c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f14286d = false;

        static int a(SparseIntArray sparseIntArray, int i11) {
            int size = sparseIntArray.size() - 1;
            int i12 = 0;
            while (i12 <= size) {
                int i13 = (i12 + size) >>> 1;
                if (sparseIntArray.keyAt(i13) < i11) {
                    i12 = i13 + 1;
                } else {
                    size = i13 - 1;
                }
            }
            int i14 = i12 - 1;
            if (i14 < 0 || i14 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i14);
        }

        int b(int i11, int i12) {
            if (!this.f14286d) {
                return d(i11, i12);
            }
            int i13 = this.f14284b.get(i11, -1);
            if (i13 != -1) {
                return i13;
            }
            int d11 = d(i11, i12);
            this.f14284b.put(i11, d11);
            return d11;
        }

        int c(int i11, int i12) {
            if (!this.f14285c) {
                return e(i11, i12);
            }
            int i13 = this.f14283a.get(i11, -1);
            if (i13 != -1) {
                return i13;
            }
            int e11 = e(i11, i12);
            this.f14283a.put(i11, e11);
            return e11;
        }

        public int d(int i11, int i12) {
            int i13;
            int i14;
            int i15;
            int a11;
            if (!this.f14286d || (a11 = a(this.f14284b, i11)) == -1) {
                i13 = 0;
                i14 = 0;
                i15 = 0;
            } else {
                i13 = this.f14284b.get(a11);
                i14 = a11 + 1;
                i15 = c(a11, i12) + f(a11);
                if (i15 == i12) {
                    i13++;
                    i15 = 0;
                }
            }
            int f11 = f(i11);
            while (i14 < i11) {
                int f12 = f(i14);
                i15 += f12;
                if (i15 == i12) {
                    i13++;
                    i15 = 0;
                } else if (i15 > i12) {
                    i13++;
                    i15 = f12;
                }
                i14++;
            }
            return i15 + f11 > i12 ? i13 + 1 : i13;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:10:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f14285c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f14283a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f14283a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = r1
                r3 = r2
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = r1
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.e(int, int):int");
        }

        public abstract int f(int i11);

        public void g() {
            this.f14284b.clear();
        }

        public void h() {
            this.f14283a.clear();
        }

        public void i(boolean z10) {
            if (!z10) {
                this.f14284b.clear();
            }
            this.f14285c = z10;
        }
    }

    public GridLayoutManager(Context context, int i11) {
        super(context);
        this.f14272a = false;
        this.f14273b = -1;
        this.f14276e = new SparseIntArray();
        this.f14277f = new SparseIntArray();
        this.f14278g = new a();
        this.f14279h = new Rect();
        c0(i11);
    }

    public GridLayoutManager(Context context, int i11, int i12, boolean z10) {
        super(context, i12, z10);
        this.f14272a = false;
        this.f14273b = -1;
        this.f14276e = new SparseIntArray();
        this.f14277f = new SparseIntArray();
        this.f14278g = new a();
        this.f14279h = new Rect();
        c0(i11);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f14272a = false;
        this.f14273b = -1;
        this.f14276e = new SparseIntArray();
        this.f14277f = new SparseIntArray();
        this.f14278g = new a();
        this.f14279h = new Rect();
        c0(RecyclerView.m.getProperties(context, attributeSet, i11, i12).f14321b);
    }

    private void K(RecyclerView.t tVar, RecyclerView.y yVar, int i11, boolean z10) {
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        if (z10) {
            i14 = 1;
            i13 = i11;
            i12 = 0;
        } else {
            i12 = i11 - 1;
            i13 = -1;
            i14 = -1;
        }
        while (i12 != i13) {
            View view = this.f14275d[i12];
            b bVar = (b) view.getLayoutParams();
            int X = X(tVar, yVar, getPosition(view));
            bVar.f14282b = X;
            bVar.f14281a = i15;
            i15 += X;
            i12 += i14;
        }
    }

    private void L() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            b bVar = (b) getChildAt(i11).getLayoutParams();
            int viewLayoutPosition = bVar.getViewLayoutPosition();
            this.f14276e.put(viewLayoutPosition, bVar.b());
            this.f14277f.put(viewLayoutPosition, bVar.a());
        }
    }

    private void M(int i11) {
        this.f14274c = N(this.f14274c, this.f14273b, i11);
    }

    static int[] N(int[] iArr, int i11, int i12) {
        int i13;
        if (iArr == null || iArr.length != i11 + 1 || iArr[iArr.length - 1] != i12) {
            iArr = new int[i11 + 1];
        }
        int i14 = 0;
        iArr[0] = 0;
        int i15 = i12 / i11;
        int i16 = i12 % i11;
        int i17 = 0;
        for (int i18 = 1; i18 <= i11; i18++) {
            i14 += i16;
            if (i14 <= 0 || i11 - i14 >= i16) {
                i13 = i15;
            } else {
                i13 = i15 + 1;
                i14 -= i11;
            }
            i17 += i13;
            iArr[i18] = i17;
        }
        return iArr;
    }

    private void O() {
        this.f14276e.clear();
        this.f14277f.clear();
    }

    private int P(RecyclerView.y yVar) {
        if (getChildCount() != 0 && yVar.b() != 0) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                int b11 = this.f14278g.b(getPosition(findFirstVisibleChildClosestToStart), this.f14273b);
                int b12 = this.f14278g.b(getPosition(findFirstVisibleChildClosestToEnd), this.f14273b);
                int max = this.mShouldReverseLayout ? Math.max(0, ((this.f14278g.b(yVar.b() - 1, this.f14273b) + 1) - Math.max(b11, b12)) - 1) : Math.max(0, Math.min(b11, b12));
                if (isSmoothScrollbarEnabled) {
                    return Math.round((max * (Math.abs(this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)) / ((this.f14278g.b(getPosition(findFirstVisibleChildClosestToEnd), this.f14273b) - this.f14278g.b(getPosition(findFirstVisibleChildClosestToStart), this.f14273b)) + 1))) + (this.mOrientationHelper.m() - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)));
                }
                return max;
            }
        }
        return 0;
    }

    private int Q(RecyclerView.y yVar) {
        if (getChildCount() != 0 && yVar.b() != 0) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.f14278g.b(yVar.b() - 1, this.f14273b) + 1;
                }
                int d11 = this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart);
                int b11 = this.f14278g.b(getPosition(findFirstVisibleChildClosestToStart), this.f14273b);
                return (int) ((d11 / ((this.f14278g.b(getPosition(findFirstVisibleChildClosestToEnd), this.f14273b) - b11) + 1)) * (this.f14278g.b(yVar.b() - 1, this.f14273b) + 1));
            }
        }
        return 0;
    }

    private void R(RecyclerView.t tVar, RecyclerView.y yVar, LinearLayoutManager.a aVar, int i11) {
        boolean z10 = i11 == 1;
        int W = W(tVar, yVar, aVar.f14288b);
        if (z10) {
            while (W > 0) {
                int i12 = aVar.f14288b;
                if (i12 <= 0) {
                    return;
                }
                int i13 = i12 - 1;
                aVar.f14288b = i13;
                W = W(tVar, yVar, i13);
            }
            return;
        }
        int b11 = yVar.b() - 1;
        int i14 = aVar.f14288b;
        while (i14 < b11) {
            int i15 = i14 + 1;
            int W2 = W(tVar, yVar, i15);
            if (W2 <= W) {
                break;
            }
            i14 = i15;
            W = W2;
        }
        aVar.f14288b = i14;
    }

    private void S() {
        View[] viewArr = this.f14275d;
        if (viewArr == null || viewArr.length != this.f14273b) {
            this.f14275d = new View[this.f14273b];
        }
    }

    private int V(RecyclerView.t tVar, RecyclerView.y yVar, int i11) {
        if (!yVar.e()) {
            return this.f14278g.b(i11, this.f14273b);
        }
        int f11 = tVar.f(i11);
        if (f11 != -1) {
            return this.f14278g.b(f11, this.f14273b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i11);
        return 0;
    }

    private int W(RecyclerView.t tVar, RecyclerView.y yVar, int i11) {
        if (!yVar.e()) {
            return this.f14278g.c(i11, this.f14273b);
        }
        int i12 = this.f14277f.get(i11, -1);
        if (i12 != -1) {
            return i12;
        }
        int f11 = tVar.f(i11);
        if (f11 != -1) {
            return this.f14278g.c(f11, this.f14273b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i11);
        return 0;
    }

    private int X(RecyclerView.t tVar, RecyclerView.y yVar, int i11) {
        if (!yVar.e()) {
            return this.f14278g.f(i11);
        }
        int i12 = this.f14276e.get(i11, -1);
        if (i12 != -1) {
            return i12;
        }
        int f11 = tVar.f(i11);
        if (f11 != -1) {
            return this.f14278g.f(f11);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i11);
        return 1;
    }

    private void Z(float f11, int i11) {
        M(Math.max(Math.round(f11 * this.f14273b), i11));
    }

    private void a0(View view, int i11, boolean z10) {
        int i12;
        int i13;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.mDecorInsets;
        int i14 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i15 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int T = T(bVar.f14281a, bVar.f14282b);
        if (this.mOrientation == 1) {
            i13 = RecyclerView.m.getChildMeasureSpec(T, i11, i15, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i12 = RecyclerView.m.getChildMeasureSpec(this.mOrientationHelper.n(), getHeightMode(), i14, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int childMeasureSpec = RecyclerView.m.getChildMeasureSpec(T, i11, i14, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int childMeasureSpec2 = RecyclerView.m.getChildMeasureSpec(this.mOrientationHelper.n(), getWidthMode(), i15, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i12 = childMeasureSpec;
            i13 = childMeasureSpec2;
        }
        b0(view, i13, i12, z10);
    }

    private void b0(View view, int i11, int i12, boolean z10) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        if (z10 ? shouldReMeasureChild(view, i11, i12, nVar) : shouldMeasureChild(view, i11, i12, nVar)) {
            view.measure(i11, i12);
        }
    }

    private void e0() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        M(height - paddingTop);
    }

    int T(int i11, int i12) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f14274c;
            return iArr[i12 + i11] - iArr[i11];
        }
        int[] iArr2 = this.f14274c;
        int i13 = this.f14273b;
        return iArr2[i13 - i11] - iArr2[(i13 - i11) - i12];
    }

    public int U() {
        return this.f14273b;
    }

    public c Y() {
        return this.f14278g;
    }

    public void c0(int i11) {
        if (i11 == this.f14273b) {
            return;
        }
        this.f14272a = true;
        if (i11 >= 1) {
            this.f14273b = i11;
            this.f14278g.h();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean checkLayoutParams(RecyclerView.n nVar) {
        return nVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.y yVar, LinearLayoutManager.c cVar, RecyclerView.m.c cVar2) {
        int i11 = this.f14273b;
        for (int i12 = 0; i12 < this.f14273b && cVar.c(yVar) && i11 > 0; i12++) {
            int i13 = cVar.f14299d;
            cVar2.a(i13, Math.max(0, cVar.f14302g));
            i11 -= this.f14278g.f(i13);
            cVar.f14299d += cVar.f14300e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollOffset(RecyclerView.y yVar) {
        return this.f14280i ? P(yVar) : super.computeHorizontalScrollOffset(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollRange(RecyclerView.y yVar) {
        return this.f14280i ? Q(yVar) : super.computeHorizontalScrollRange(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        return this.f14280i ? P(yVar) : super.computeVerticalScrollOffset(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        return this.f14280i ? Q(yVar) : super.computeVerticalScrollRange(yVar);
    }

    public void d0(c cVar) {
        this.f14278g = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.t tVar, RecyclerView.y yVar, boolean z10, boolean z11) {
        int i11;
        int i12;
        int childCount = getChildCount();
        int i13 = 1;
        if (z11) {
            i12 = getChildCount() - 1;
            i11 = -1;
            i13 = -1;
        } else {
            i11 = childCount;
            i12 = 0;
        }
        int b11 = yVar.b();
        ensureLayoutState();
        int m11 = this.mOrientationHelper.m();
        int i14 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        while (i12 != i11) {
            View childAt = getChildAt(i12);
            int position = getPosition(childAt);
            if (position >= 0 && position < b11 && W(tVar, yVar, position) == 0) {
                if (((RecyclerView.n) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.g(childAt) < i14 && this.mOrientationHelper.d(childAt) >= m11) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i12 += i13;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int getColumnCountForAccessibility(RecyclerView.t tVar, RecyclerView.y yVar) {
        if (this.mOrientation == 1) {
            return this.f14273b;
        }
        if (yVar.b() < 1) {
            return 0;
        }
        return V(tVar, yVar, yVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int getRowCountForAccessibility(RecyclerView.t tVar, RecyclerView.y yVar) {
        if (this.mOrientation == 0) {
            return this.f14273b;
        }
        if (yVar.b() < 1) {
            return 0;
        }
        return V(tVar, yVar, yVar.b() - 1) + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        r21.f14293b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void layoutChunk(androidx.recyclerview.widget.RecyclerView.t r18, androidx.recyclerview.widget.RecyclerView.y r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.layoutChunk(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$y, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.t tVar, RecyclerView.y yVar, LinearLayoutManager.a aVar, int i11) {
        super.onAnchorReady(tVar, yVar, aVar, i11);
        e0();
        if (yVar.b() > 0 && !yVar.e()) {
            R(tVar, yVar, aVar, i11);
        }
        S();
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f1, code lost:
    
        if (r13 == (r2 > r7)) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.t r26, androidx.recyclerview.widget.RecyclerView.y r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$y):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onInitializeAccessibilityNodeInfo(RecyclerView.t tVar, RecyclerView.y yVar, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(tVar, yVar, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.t tVar, RecyclerView.y yVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        b bVar = (b) layoutParams;
        int V = V(tVar, yVar, bVar.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(bVar.a(), bVar.b(), V, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(V, 1, bVar.a(), bVar.b(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        this.f14278g.h();
        this.f14278g.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f14278g.h();
        this.f14278g.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        this.f14278g.h();
        this.f14278g.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        this.f14278g.h();
        this.f14278g.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        this.f14278g.h();
        this.f14278g.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.y yVar) {
        if (yVar.e()) {
            L();
        }
        super.onLayoutChildren(tVar, yVar);
        O();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutCompleted(RecyclerView.y yVar) {
        super.onLayoutCompleted(yVar);
        this.f14272a = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        e0();
        S();
        return super.scrollHorizontallyBy(i11, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        e0();
        S();
        return super.scrollVerticallyBy(i11, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void setMeasuredDimension(Rect rect, int i11, int i12) {
        int chooseSize;
        int chooseSize2;
        if (this.f14274c == null) {
            super.setMeasuredDimension(rect, i11, i12);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.m.chooseSize(i12, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f14274c;
            chooseSize = RecyclerView.m.chooseSize(i11, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.m.chooseSize(i11, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f14274c;
            chooseSize2 = RecyclerView.m.chooseSize(i12, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f14272a;
    }
}
