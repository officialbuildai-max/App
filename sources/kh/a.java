package kh;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a extends RecyclerView.r {

    /* renamed from: f, reason: collision with root package name */
    public static final C0838a f66904f = new C0838a(null);

    /* renamed from: a, reason: collision with root package name */
    private b f66905a;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f66908d;

    /* renamed from: b, reason: collision with root package name */
    private int f66906b = 10;

    /* renamed from: c, reason: collision with root package name */
    private int f66907c = 2;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray f66909e = new SparseArray();

    /* renamed from: kh.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0838a {
        private C0838a() {
        }

        public /* synthetic */ C0838a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        int a();

        void onItemViewVisible(boolean z10, int i11);
    }

    private final int[] e(int[] iArr, int[] iArr2) {
        int i11 = iArr[0];
        int i12 = iArr2[0];
        int length = iArr.length;
        for (int i13 = 1; i13 < length; i13++) {
            int i14 = iArr[i13];
            if (i11 > i14) {
                i11 = i14;
            }
        }
        int length2 = iArr2.length;
        for (int i15 = 1; i15 < length2; i15++) {
            int i16 = iArr2[i15];
            if (i12 < i16) {
                i12 = i16;
            }
        }
        return new int[]{i11, i12};
    }

    private final int[] f(GridLayoutManager gridLayoutManager) {
        return new int[]{gridLayoutManager.findFirstVisibleItemPosition(), gridLayoutManager.findLastVisibleItemPosition()};
    }

    private final int[] g(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }

    private final int[] h(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int[] iArr = new int[staggeredGridLayoutManager.Q()];
        int[] iArr2 = new int[staggeredGridLayoutManager.Q()];
        staggeredGridLayoutManager.D(iArr);
        staggeredGridLayoutManager.G(iArr2);
        return e(iArr, iArr2);
    }

    private final String i() {
        return a.class.getSimpleName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.recyclerview.widget.RecyclerView$m] */
    private final void j() {
        Object m1185constructorimpl;
        RecyclerView recyclerView = this.f66908d;
        if (recyclerView == null || recyclerView == null || recyclerView.getVisibility() != 0) {
            return;
        }
        RecyclerView recyclerView2 = this.f66908d;
        if (recyclerView2 == null || recyclerView2.isShown()) {
            RecyclerView recyclerView3 = this.f66908d;
            if (recyclerView3 == null || recyclerView3.getGlobalVisibleRect(new Rect())) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    int[] iArr = new int[2];
                    RecyclerView recyclerView4 = this.f66908d;
                    StaggeredGridLayoutManager layoutManager = recyclerView4 != null ? recyclerView4.getLayoutManager() : null;
                    if (layoutManager instanceof GridLayoutManager) {
                        iArr = f(layoutManager);
                    } else if (layoutManager instanceof LinearLayoutManager) {
                        iArr = g(layoutManager);
                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                        iArr = h(layoutManager);
                    }
                    int i11 = iArr[0];
                    int i12 = iArr[1];
                    if (i11 <= i12) {
                        while (true) {
                            b bVar = this.f66905a;
                            if (bVar == null || i11 != bVar.a()) {
                                m(layoutManager != null ? layoutManager.findViewByPosition(i11) : null, i11);
                            }
                            if (i11 == i12) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                    }
                    m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
                if (m1188exceptionOrNullimpl == null) {
                    return;
                }
                Log.e(i(), "RecyclerViewExposeUtil --> handleCurrentVisibleItems() --> " + Log.getStackTraceString(m1188exceptionOrNullimpl));
            }
        }
    }

    private final void m(View view, int i11) {
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z10 = ((double) rect.height()) * ((double) rect.width()) > ((((double) view.getMeasuredHeight()) * ((double) view.getMeasuredWidth())) * ((double) this.f66906b)) / ((double) 100);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isItemViewVisibleInLogic = ");
            sb2.append(z10);
            if (!globalVisibleRect || !z10) {
                b bVar = this.f66905a;
                if (bVar != null) {
                    bVar.onItemViewVisible(false, i11);
                }
                if (this.f66907c == 2) {
                    this.f66909e.remove(i11);
                    return;
                }
                return;
            }
            if (this.f66909e.get(i11) != null) {
                return;
            }
            this.f66909e.put(i11, Long.valueOf(System.currentTimeMillis()));
            b bVar2 = this.f66905a;
            if (bVar2 != null) {
                bVar2.onItemViewVisible(true, i11);
            }
        }
    }

    public final void d() {
        l();
        RecyclerView recyclerView = this.f66908d;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this);
        }
        this.f66905a = null;
        this.f66908d = null;
    }

    public final void k() {
        j();
    }

    public final void l() {
        this.f66909e.clear();
    }

    public final void n(RecyclerView recyclerView, b bVar) {
        RecyclerView recyclerView2;
        this.f66905a = bVar;
        this.f66908d = recyclerView;
        if (recyclerView == null || recyclerView == null || recyclerView.getVisibility() != 0 || (recyclerView2 = this.f66908d) == null) {
            return;
        }
        recyclerView2.addOnScrollListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.h(recyclerView, "recyclerView");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        j();
    }
}
