package r6;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a */
    private final BaseQuickAdapter f74275a;

    /* renamed from: b */
    private p6.f f74276b;

    /* renamed from: c */
    private boolean f74277c;

    /* renamed from: d */
    private LoadMoreStatus f74278d;

    /* renamed from: e */
    private boolean f74279e;

    /* renamed from: f */
    private q6.a f74280f;

    /* renamed from: g */
    private boolean f74281g;

    /* renamed from: h */
    private boolean f74282h;

    /* renamed from: i */
    private boolean f74283i;

    /* renamed from: j */
    private int f74284j;

    /* renamed from: k */
    private boolean f74285k;

    public f(BaseQuickAdapter baseQuickAdapter) {
        Intrinsics.h(baseQuickAdapter, "baseQuickAdapter");
        this.f74275a = baseQuickAdapter;
        this.f74277c = true;
        this.f74278d = LoadMoreStatus.Complete;
        this.f74280f = j.a();
        this.f74282h = true;
        this.f74283i = true;
        this.f74284j = 1;
    }

    public static final void G(f this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        LoadMoreStatus loadMoreStatus = this$0.f74278d;
        if (loadMoreStatus == LoadMoreStatus.Fail) {
            this$0.w();
            return;
        }
        if (loadMoreStatus == LoadMoreStatus.Complete) {
            this$0.w();
        } else if (this$0.f74281g && loadMoreStatus == LoadMoreStatus.End) {
            this$0.w();
        }
    }

    public static final void g(f this$0, RecyclerView.m manager) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(manager, "$manager");
        if (this$0.q((LinearLayoutManager) manager)) {
            this$0.f74277c = true;
        }
    }

    public static final void h(RecyclerView.m manager, f this$0) {
        Intrinsics.h(manager, "$manager");
        Intrinsics.h(this$0, "this$0");
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) manager;
        int[] iArr = new int[staggeredGridLayoutManager.Q()];
        staggeredGridLayoutManager.E(iArr);
        if (this$0.l(iArr) + 1 != this$0.f74275a.getItemCount()) {
            this$0.f74277c = true;
        }
    }

    private final int l(int[] iArr) {
        int i11 = -1;
        if (iArr != null && iArr.length != 0) {
            for (int i12 : iArr) {
                if (i12 > i11) {
                    i11 = i12;
                }
            }
        }
        return i11;
    }

    private final void n() {
        this.f74278d = LoadMoreStatus.Loading;
        RecyclerView n02 = this.f74275a.n0();
        if (n02 != null) {
            n02.post(new Runnable() { // from class: r6.b
                @Override // java.lang.Runnable
                public final void run() {
                    f.o(f.this);
                }
            });
            return;
        }
        p6.f fVar = this.f74276b;
        if (fVar != null) {
            fVar.a();
        }
    }

    public static final void o(f this$0) {
        Intrinsics.h(this$0, "this$0");
        p6.f fVar = this$0.f74276b;
        if (fVar != null) {
            fVar.a();
        }
    }

    private final boolean q(LinearLayoutManager linearLayoutManager) {
        return (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == this.f74275a.getItemCount() && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) ? false : true;
    }

    public static /* synthetic */ void u(f fVar, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
        }
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        fVar.t(z10);
    }

    public final void A(boolean z10) {
        this.f74281g = z10;
    }

    public final void B(boolean z10) {
        this.f74283i = z10;
    }

    public final void C(q6.a aVar) {
        Intrinsics.h(aVar, "<set-?>");
        this.f74280f = aVar;
    }

    public void D(p6.f fVar) {
        this.f74276b = fVar;
        z(true);
    }

    public final void E(int i11) {
        if (i11 > 1) {
            this.f74284j = i11;
        }
    }

    public final void F(BaseViewHolder viewHolder) {
        Intrinsics.h(viewHolder, "viewHolder");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: r6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.G(f.this, view);
            }
        });
    }

    public final void e(int i11) {
        LoadMoreStatus loadMoreStatus;
        if (this.f74282h && m() && i11 >= this.f74275a.getItemCount() - this.f74284j && (loadMoreStatus = this.f74278d) == LoadMoreStatus.Complete && loadMoreStatus != LoadMoreStatus.Loading && this.f74277c) {
            n();
        }
    }

    public final void f() {
        final RecyclerView.m layoutManager;
        if (this.f74283i) {
            return;
        }
        this.f74277c = false;
        RecyclerView n02 = this.f74275a.n0();
        if (n02 == null || (layoutManager = n02.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            n02.postDelayed(new Runnable() { // from class: r6.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.g(f.this, layoutManager);
                }
            }, 50L);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            n02.postDelayed(new Runnable() { // from class: r6.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.h(RecyclerView.m.this, this);
                }
            }, 50L);
        }
    }

    public final LoadMoreStatus i() {
        return this.f74278d;
    }

    public final q6.a j() {
        return this.f74280f;
    }

    public final int k() {
        if (this.f74275a.q0()) {
            return -1;
        }
        BaseQuickAdapter baseQuickAdapter = this.f74275a;
        return baseQuickAdapter.a0() + baseQuickAdapter.getData().size() + baseQuickAdapter.V();
    }

    public final boolean m() {
        if (this.f74276b == null || !this.f74285k) {
            return false;
        }
        if (this.f74278d == LoadMoreStatus.End && this.f74279e) {
            return false;
        }
        return !this.f74275a.getData().isEmpty();
    }

    public final boolean p() {
        return this.f74285k;
    }

    public final boolean r() {
        return this.f74278d == LoadMoreStatus.Loading;
    }

    public final void s() {
        if (m()) {
            this.f74278d = LoadMoreStatus.Complete;
            this.f74275a.notifyItemChanged(k());
            f();
        }
    }

    public final void t(boolean z10) {
        if (m()) {
            this.f74279e = z10;
            this.f74278d = LoadMoreStatus.End;
            if (z10) {
                this.f74275a.notifyItemRemoved(k());
            } else {
                this.f74275a.notifyItemChanged(k());
            }
        }
    }

    public final void v() {
        if (m()) {
            this.f74278d = LoadMoreStatus.Fail;
            this.f74275a.notifyItemChanged(k());
        }
    }

    public final void w() {
        LoadMoreStatus loadMoreStatus = this.f74278d;
        LoadMoreStatus loadMoreStatus2 = LoadMoreStatus.Loading;
        if (loadMoreStatus == loadMoreStatus2) {
            return;
        }
        this.f74278d = loadMoreStatus2;
        this.f74275a.notifyItemChanged(k());
        n();
    }

    public final void x() {
        if (this.f74276b != null) {
            z(true);
            this.f74278d = LoadMoreStatus.Complete;
        }
    }

    public final void y(boolean z10) {
        this.f74282h = z10;
    }

    public final void z(boolean z10) {
        boolean m11 = m();
        this.f74285k = z10;
        boolean m12 = m();
        if (m11) {
            if (m12) {
                return;
            }
            this.f74275a.notifyItemRemoved(k());
        } else if (m12) {
            this.f74278d = LoadMoreStatus.Complete;
            this.f74275a.notifyItemInserted(k());
        }
    }
}
