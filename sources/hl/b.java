package hl;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R$id;
import com.transsion.home.view.OpRankingView;
import java.util.SortedSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class b extends RecyclerView.r {

    /* renamed from: i, reason: collision with root package name */
    public static final a f64635i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final int f64636j = 8;

    /* renamed from: k, reason: collision with root package name */
    private static String f64637k = "ExposureHelper";

    /* renamed from: a, reason: collision with root package name */
    private final float f64638a;

    /* renamed from: b, reason: collision with root package name */
    private final hl.a f64639b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f64640c;

    /* renamed from: d, reason: collision with root package name */
    private int f64641d;

    /* renamed from: e, reason: collision with root package name */
    private int f64642e;

    /* renamed from: f, reason: collision with root package name */
    private int f64643f;

    /* renamed from: g, reason: collision with root package name */
    private final SparseArray f64644g;

    /* renamed from: h, reason: collision with root package name */
    private SortedSet f64645h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(float f11, hl.a callback, boolean z10) {
        Intrinsics.h(callback, "callback");
        this.f64638a = f11;
        this.f64639b = callback;
        this.f64640c = z10;
        this.f64644g = new SparseArray();
    }

    public /* synthetic */ b(float f11, hl.a aVar, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, aVar, (i11 & 4) != 0 ? false : z10);
    }

    private final boolean d(View view) {
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        if (f(view)) {
            return true;
        }
        int width2 = rect.width();
        int height2 = rect.height();
        int i11 = this.f64641d;
        if (i11 != 1) {
            if (i11 != 2) {
                double d11 = (width2 * 1.0d) / width;
                float f11 = this.f64638a;
                if (d11 < f11 || (height2 * 1.0d) / height < f11) {
                    return false;
                }
            } else if ((height2 * 1.0d) / height < this.f64638a) {
                return false;
            }
        } else if ((width2 * 1.0d) / width < this.f64638a) {
            return false;
        }
        return true;
    }

    private final boolean f(View view) {
        OpRankingView opRankingView;
        if (view == null || (opRankingView = (OpRankingView) view.findViewById(R$id.ranking_view)) == null) {
            opRankingView = null;
        } else {
            RecyclerView.m layoutManager = ((RecyclerView) opRankingView.findViewById(R$id.recycler_view)).getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            this.f64645h = opRankingView.calcExposureLines((GridLayoutManager) layoutManager);
        }
        return opRankingView != null;
    }

    private final void g(int i11, int i12, int i13) {
        if (i12 < 0 || i13 >= i11 || i12 > i13 || i12 > i13) {
            return;
        }
        while (true) {
            if (this.f64644g.get(i12) == null) {
                a.C0856a.f(lg.a.f68962a, f64637k, "offer position  " + i12, false, 4, null);
                this.f64644g.put(i12, Long.valueOf(System.currentTimeMillis()));
            }
            if (i12 == i13) {
                return;
            } else {
                i12++;
            }
        }
    }

    private final void j(int i11) {
        if (this.f64644g.get(i11) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l11 = (Long) this.f64644g.get(i11);
        long longValue = l11 != null ? l11.longValue() : currentTimeMillis;
        this.f64644g.remove(i11);
        long j11 = currentTimeMillis - longValue;
        a.C0856a.f(lg.a.f68962a, f64637k, "out position " + i11 + " duration " + j11, false, 4, null);
        if (j11 <= 1000) {
            return;
        }
        this.f64639b.a(i11, j11, null);
    }

    private final void k(int i11, int i12, int i13) {
        if (i12 < 0 || i13 >= i11 || i12 > i13 || i12 > i13) {
            return;
        }
        while (true) {
            j(i13);
            if (i13 == i12) {
                return;
            } else {
                i13--;
            }
        }
    }

    public final void e() {
        long currentTimeMillis = System.currentTimeMillis();
        SparseArray sparseArray = this.f64644g;
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            int keyAt = sparseArray.keyAt(i11);
            Long l11 = (Long) sparseArray.valueAt(i11);
            long longValue = currentTimeMillis - (l11 != null ? l11.longValue() : currentTimeMillis);
            a.C0856a.f(lg.a.f68962a, f64637k, "clearCache out position " + keyAt + " duration " + longValue, false, 4, null);
            if (longValue <= 1000) {
                return;
            }
            this.f64639b.a(keyAt, longValue, null);
        }
        this.f64644g.clear();
    }

    public final void h(LinearLayoutManager manager, int i11, boolean z10) {
        Intrinsics.h(manager, "manager");
        if (z10) {
            g(manager.getItemCount(), i11, i11);
        }
    }

    public final void i(LinearLayoutManager manager, boolean z10) {
        Intrinsics.h(manager, "manager");
        int findFirstVisibleItemPosition = manager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = manager.findLastVisibleItemPosition();
        if (!d(manager.findViewByPosition(findFirstVisibleItemPosition))) {
            findFirstVisibleItemPosition++;
        }
        if (!d(manager.findViewByPosition(findLastVisibleItemPosition))) {
            findLastVisibleItemPosition--;
        }
        if (this.f64642e == 0 && this.f64643f == 0) {
            g(manager.getItemCount(), findFirstVisibleItemPosition, findLastVisibleItemPosition);
            this.f64642e = findFirstVisibleItemPosition;
            this.f64643f = findLastVisibleItemPosition;
            return;
        }
        if (z10) {
            k(manager.getItemCount(), this.f64642e, findFirstVisibleItemPosition - 1);
            g(manager.getItemCount(), this.f64643f + 1, findLastVisibleItemPosition);
        } else {
            k(manager.getItemCount(), findLastVisibleItemPosition + 1, this.f64643f);
            g(manager.getItemCount(), findFirstVisibleItemPosition, this.f64642e - 1);
        }
        this.f64642e = findFirstVisibleItemPosition;
        this.f64643f = findLastVisibleItemPosition;
    }

    public final void l(int i11) {
        this.f64641d = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.h(recyclerView, "recyclerView");
        a.C0856a.f(lg.a.f68962a, f64637k, "newState " + i11, false, 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        i((LinearLayoutManager) layoutManager, i12 >= 0);
    }
}
