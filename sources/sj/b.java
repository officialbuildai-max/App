package sj;

import ak.q;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.transsion.baselib.exposure.ExposureType;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class b extends RecyclerView.r {

    /* renamed from: j, reason: collision with root package name */
    public static final a f75485j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    private static String f75486k = "ExposureHelper";

    /* renamed from: a, reason: collision with root package name */
    private final float f75487a;

    /* renamed from: b, reason: collision with root package name */
    private final sj.a f75488b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f75489c;

    /* renamed from: d, reason: collision with root package name */
    private int f75490d;

    /* renamed from: e, reason: collision with root package name */
    private ExposureType f75491e;

    /* renamed from: f, reason: collision with root package name */
    private q f75492f;

    /* renamed from: g, reason: collision with root package name */
    private int f75493g;

    /* renamed from: h, reason: collision with root package name */
    private int f75494h;

    /* renamed from: i, reason: collision with root package name */
    private final SparseArray f75495i;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.f75486k;
        }
    }

    public b(float f11, sj.a callback, boolean z10) {
        Intrinsics.h(callback, "callback");
        this.f75487a = f11;
        this.f75488b = callback;
        this.f75489c = z10;
        this.f75491e = ExposureType.VERTICAL_FEED;
        this.f75495i = new SparseArray();
    }

    public /* synthetic */ b(float f11, sj.a aVar, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, aVar, (i11 & 4) != 0 ? false : z10);
    }

    private final boolean e(View view) {
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        int width2 = rect.width();
        int height2 = rect.height();
        int i11 = this.f75490d;
        if (i11 != 1) {
            if (i11 != 2) {
                double d11 = (width2 * 1.0d) / width;
                float f11 = this.f75487a;
                if (d11 < f11 || (height2 * 1.0d) / height < f11) {
                    return false;
                }
            } else if ((height2 * 1.0d) / height < this.f75487a) {
                return false;
            }
        } else if ((width2 * 1.0d) / width < this.f75487a) {
            return false;
        }
        return true;
    }

    private final void h(int i11, int i12, int i13) {
        if (i12 < 0 || i13 >= i11 || i12 > i13 || i12 > i13) {
            return;
        }
        while (this.f75495i.get(i12) == null) {
            int i14 = i12 + 1;
            a.C0856a.f(lg.a.f68962a, f75486k, "offer position  " + i12, false, 4, null);
            this.f75495i.put(i12, Long.valueOf(System.currentTimeMillis()));
            q qVar = this.f75492f;
            if (qVar != null) {
                qVar.a(i14);
            }
            if (i12 == i13) {
                return;
            } else {
                i12 = i14;
            }
        }
    }

    public static /* synthetic */ void j(b bVar, RecyclerView.m mVar, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            z11 = false;
        }
        bVar.i(mVar, i11, z10, z11);
    }

    private final void l(int i11) {
        if (this.f75495i.get(i11) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l11 = (Long) this.f75495i.get(i11);
        long longValue = l11 != null ? l11.longValue() : currentTimeMillis;
        this.f75495i.remove(i11);
        long j11 = currentTimeMillis - longValue;
        a.C0856a.f(lg.a.f68962a, f75486k, "out position " + i11 + " duration " + j11, false, 4, null);
        if (j11 <= 1000) {
            return;
        }
        this.f75488b.a(i11, j11, null);
    }

    private final void m(int i11, int i12, int i13) {
        if (i12 < 0 || i13 >= i11 || i12 > i13 || i12 > i13) {
            return;
        }
        while (true) {
            l(i13);
            if (i13 == i12) {
                return;
            } else {
                i13--;
            }
        }
    }

    public final void f() {
        long currentTimeMillis = System.currentTimeMillis();
        SparseArray sparseArray = this.f75495i;
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            int keyAt = sparseArray.keyAt(i11);
            Long l11 = (Long) sparseArray.valueAt(i11);
            long longValue = currentTimeMillis - (l11 != null ? l11.longValue() : currentTimeMillis);
            a.C0856a.f(lg.a.f68962a, f75486k, "clearCache out position " + keyAt + " duration " + longValue, false, 4, null);
            this.f75488b.a(keyAt, longValue, null);
        }
        this.f75495i.clear();
    }

    public final void g() {
        f();
        this.f75493g = 0;
        this.f75494h = 0;
    }

    public final void i(RecyclerView.m manager, int i11, boolean z10, boolean z11) {
        Intrinsics.h(manager, "manager");
        if (z10) {
            View findViewByPosition = manager.findViewByPosition(i11);
            if (z11) {
                h(manager.getItemCount(), i11, i11);
                return;
            }
            boolean e11 = e(findViewByPosition);
            a.C0856a.f(lg.a.f68962a, f75486k, "firstView " + findViewByPosition + " export " + e11 + " count " + manager.getItemCount(), false, 4, null);
            if (e11) {
                h(manager.getItemCount(), i11, i11);
            }
        }
    }

    public final void k(RecyclerView.m manager, boolean z10) {
        int U;
        int U2;
        Intrinsics.h(manager, "manager");
        boolean z11 = manager instanceof LinearLayoutManager;
        if (z11) {
            U = ((LinearLayoutManager) manager).findFirstVisibleItemPosition();
        } else {
            if (!(manager instanceof StaggeredGridLayoutManager)) {
                return;
            }
            int[] D = ((StaggeredGridLayoutManager) manager).D(null);
            Intrinsics.g(D, "findFirstVisibleItemPositions(...)");
            U = ArraysKt.U(D);
        }
        if (z11) {
            U2 = ((LinearLayoutManager) manager).findLastVisibleItemPosition();
        } else {
            if (!(manager instanceof StaggeredGridLayoutManager)) {
                return;
            }
            int[] G = ((StaggeredGridLayoutManager) manager).G(null);
            Intrinsics.g(G, "findLastVisibleItemPositions(...)");
            U2 = ArraysKt.U(G);
        }
        if (!e(manager.findViewByPosition(U)) && this.f75491e != ExposureType.NEST_HORIZONTAL) {
            U++;
        }
        if (!e(manager.findViewByPosition(U2)) && this.f75491e != ExposureType.NEST_HORIZONTAL) {
            U2--;
        }
        if (this.f75493g == 0 && this.f75494h == 0) {
            h(manager.getItemCount(), U, U2);
            this.f75493g = U;
            this.f75494h = U2;
            return;
        }
        if (z10) {
            m(manager.getItemCount(), this.f75493g, U - 1);
            h(manager.getItemCount(), this.f75494h + 1, U2);
        } else {
            m(manager.getItemCount(), U2 + 1, this.f75494h);
            h(manager.getItemCount(), U, this.f75493g - 1);
        }
        this.f75493g = U;
        this.f75494h = U2;
    }

    public final void n(int i11) {
        this.f75490d = i11;
    }

    public final void o(ExposureType exposureType) {
        Intrinsics.h(exposureType, "exposureType");
        this.f75491e = exposureType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.h(recyclerView, "recyclerView");
        a.C0856a.f(lg.a.f68962a, f75486k, "newState " + i11, false, 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (r6 <= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        if (((androidx.recyclerview.widget.StaggeredGridLayoutManager) r4).getOrientation() == 1) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if (((androidx.recyclerview.widget.LinearLayoutManager) r4).getOrientation() == 1) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
    
        if (r5 <= 0) goto L18;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "recyclerView"
            kotlin.jvm.internal.Intrinsics.h(r4, r0)
            super.onScrolled(r4, r5, r6)
            androidx.recyclerview.widget.RecyclerView$m r4 = r4.getLayoutManager()
            if (r4 != 0) goto Lf
            return
        Lf:
            boolean r0 = r4 instanceof androidx.recyclerview.widget.LinearLayoutManager
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1f
            r0 = r4
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r0 = r0.getOrientation()
            if (r0 != r2) goto L30
            goto L2c
        L1f:
            boolean r0 = r4 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r0 == 0) goto L36
            r0 = r4
            androidx.recyclerview.widget.StaggeredGridLayoutManager r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r0
            int r0 = r0.getOrientation()
            if (r0 != r2) goto L30
        L2c:
            if (r6 <= 0) goto L33
        L2e:
            r1 = r2
            goto L33
        L30:
            if (r5 <= 0) goto L33
            goto L2e
        L33:
            r3.k(r4, r1)
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sj.b.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void p(q qVar) {
        this.f75492f = qVar;
    }
}
