package xr;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.base.exposure.ExposureType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class b extends RecyclerView.r {

    /* renamed from: i, reason: collision with root package name */
    public static final a f78539i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static String f78540j = "ExposureHelper";

    /* renamed from: a, reason: collision with root package name */
    private final float f78541a;

    /* renamed from: b, reason: collision with root package name */
    private final xr.a f78542b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f78543c;

    /* renamed from: d, reason: collision with root package name */
    private int f78544d;

    /* renamed from: e, reason: collision with root package name */
    private ExposureType f78545e;

    /* renamed from: f, reason: collision with root package name */
    private int f78546f;

    /* renamed from: g, reason: collision with root package name */
    private int f78547g;

    /* renamed from: h, reason: collision with root package name */
    private final SparseArray f78548h;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(float f11, xr.a callback, boolean z10) {
        Intrinsics.h(callback, "callback");
        this.f78541a = f11;
        this.f78542b = callback;
        this.f78543c = z10;
        this.f78545e = ExposureType.VERTICAL_FEED;
        this.f78548h = new SparseArray();
    }

    public /* synthetic */ b(float f11, xr.a aVar, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
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
        int width2 = rect.width();
        int height2 = rect.height();
        int i11 = this.f78544d;
        if (i11 != 1) {
            if (i11 != 2) {
                double d11 = (width2 * 1.0d) / width;
                float f11 = this.f78541a;
                if (d11 < f11 || (height2 * 1.0d) / height < f11) {
                    return false;
                }
            } else if ((height2 * 1.0d) / height < this.f78541a) {
                return false;
            }
        } else if ((width2 * 1.0d) / width < this.f78541a) {
            return false;
        }
        return true;
    }

    private final void f(int i11, int i12, int i13) {
        if (i12 < 0 || i13 >= i11 || i12 > i13 || i12 > i13) {
            return;
        }
        while (this.f78548h.get(i12) == null) {
            a.C0856a.f(lg.a.f68962a, f78540j, "offer position  " + i12, false, 4, null);
            this.f78548h.put(i12, Long.valueOf(System.currentTimeMillis()));
            if (i12 == i13) {
                return;
            } else {
                i12++;
            }
        }
    }

    public static /* synthetic */ void h(b bVar, LinearLayoutManager linearLayoutManager, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            z11 = false;
        }
        bVar.g(linearLayoutManager, i11, z10, z11);
    }

    private final void j(int i11) {
        if (this.f78548h.get(i11) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l11 = (Long) this.f78548h.get(i11);
        long longValue = l11 != null ? l11.longValue() : currentTimeMillis;
        this.f78548h.remove(i11);
        long j11 = currentTimeMillis - longValue;
        a.C0856a.f(lg.a.f68962a, f78540j, "out position " + i11 + " duration " + j11, false, 4, null);
        if (j11 <= 1000) {
            return;
        }
        this.f78542b.a(i11, j11, null);
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
        SparseArray sparseArray = this.f78548h;
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            int keyAt = sparseArray.keyAt(i11);
            Long l11 = (Long) sparseArray.valueAt(i11);
            long longValue = currentTimeMillis - (l11 != null ? l11.longValue() : currentTimeMillis);
            a.C0856a.f(lg.a.f68962a, f78540j, "clearCache out position " + keyAt + " duration " + longValue, false, 4, null);
            this.f78542b.a(keyAt, longValue, null);
        }
        this.f78548h.clear();
    }

    public final void g(LinearLayoutManager manager, int i11, boolean z10, boolean z11) {
        Intrinsics.h(manager, "manager");
        if (z10) {
            View findViewByPosition = manager.findViewByPosition(i11);
            if (z11) {
                f(manager.getItemCount(), i11, i11);
                return;
            }
            boolean d11 = d(findViewByPosition);
            a.C0856a.f(lg.a.f68962a, f78540j, "firstView " + findViewByPosition + " export " + d11 + " count " + manager.getItemCount(), false, 4, null);
            if (d11) {
                f(manager.getItemCount(), i11, i11);
            }
        }
    }

    public final void i(LinearLayoutManager manager, boolean z10) {
        Intrinsics.h(manager, "manager");
        int findFirstVisibleItemPosition = manager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = manager.findLastVisibleItemPosition();
        if (!d(manager.findViewByPosition(findFirstVisibleItemPosition)) && this.f78545e != ExposureType.NEST_HORIZONTAL) {
            findFirstVisibleItemPosition++;
        }
        if (!d(manager.findViewByPosition(findLastVisibleItemPosition)) && this.f78545e != ExposureType.NEST_HORIZONTAL) {
            findLastVisibleItemPosition--;
        }
        if (this.f78546f == 0 && this.f78547g == 0) {
            f(manager.getItemCount(), findFirstVisibleItemPosition, findLastVisibleItemPosition);
            this.f78546f = findFirstVisibleItemPosition;
            this.f78547g = findLastVisibleItemPosition;
            return;
        }
        if (z10) {
            k(manager.getItemCount(), this.f78546f, findFirstVisibleItemPosition - 1);
            f(manager.getItemCount(), this.f78547g + 1, findLastVisibleItemPosition);
        } else {
            k(manager.getItemCount(), findLastVisibleItemPosition + 1, this.f78547g);
            f(manager.getItemCount(), findFirstVisibleItemPosition, this.f78546f - 1);
        }
        this.f78546f = findFirstVisibleItemPosition;
        this.f78547g = findLastVisibleItemPosition;
    }

    public final void l(int i11) {
        this.f78544d = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.h(recyclerView, "recyclerView");
        a.C0856a.f(lg.a.f68962a, f78540j, "newState " + i11, false, 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            boolean z10 = false;
            if (linearLayoutManager.getOrientation() != 1 ? i11 > 0 : i12 > 0) {
                z10 = true;
            }
            i(linearLayoutManager, z10);
        }
    }
}
