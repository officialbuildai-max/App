package pn;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.video.NineGridVideoView;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class c extends RecyclerView.r {

    /* renamed from: i, reason: collision with root package name */
    public static final a f72604i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private BaseQuickAdapter f72605a;

    /* renamed from: b, reason: collision with root package name */
    private qn.a f72606b;

    /* renamed from: c, reason: collision with root package name */
    private d f72607c;

    /* renamed from: d, reason: collision with root package name */
    private int f72608d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f72609e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f72610f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f72611g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f72612h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void d(RecyclerView recyclerView) {
        List<Object> data;
        int position;
        d dVar;
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        if ((layoutManager instanceof LinearLayoutManager) && g()) {
            if (this.f72606b == null && (dVar = this.f72607c) != null) {
                dVar.a();
            }
            qn.a aVar = this.f72606b;
            int b11 = aVar != null ? aVar.b() : -1;
            qn.a aVar2 = this.f72606b;
            int f11 = aVar2 != null ? aVar2.f() : -1;
            qn.a aVar3 = this.f72606b;
            if (aVar3 != null && aVar3.n() && h((LinearLayoutManager) layoutManager, b11, f11)) {
                return;
            }
            qn.a aVar4 = this.f72606b;
            if (aVar4 != null) {
                aVar4.r();
            }
            BaseQuickAdapter baseQuickAdapter = this.f72605a;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int f12 = f(baseQuickAdapter != null ? baseQuickAdapter.getData() : null, linearLayoutManager);
            if (f12 < 0) {
                return;
            }
            a.C0856a.f(lg.a.f68962a, "ItemChangeListener", "curPos=" + b11 + " next=" + f12 + ", dy=" + this.f72612h + ", firstVisible=" + this.f72610f + " lastVisible=" + this.f72611g, false, 4, null);
            BaseQuickAdapter baseQuickAdapter2 = this.f72605a;
            if (baseQuickAdapter2 == null || (data = baseQuickAdapter2.getData()) == null) {
                return;
            }
            int childCount = linearLayoutManager.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = linearLayoutManager.getChildAt(i11);
                if (childAt != null && (position = linearLayoutManager.getPosition(childAt)) == f12 && position < data.size() && b11 != f12) {
                    PostSubjectItem postSubjectItem = (PostSubjectItem) data.get(f12);
                    qn.a aVar5 = this.f72606b;
                    if (aVar5 != null) {
                        aVar5.s(postSubjectItem, childAt, f12);
                    }
                    qn.a aVar6 = this.f72606b;
                    if (aVar6 != null && aVar6.e(postSubjectItem.getMedia()) == 1) {
                        i(f12);
                    }
                }
            }
        }
    }

    private final int f(List list, LinearLayoutManager linearLayoutManager) {
        NineGridVideoView nineGridVideoView;
        int position;
        int i11 = -1;
        if (list == null) {
            return -1;
        }
        int childCount = linearLayoutManager.getChildCount();
        float f11 = 0.0f;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = linearLayoutManager.getChildAt(i12);
            if (childAt != null && (nineGridVideoView = (NineGridVideoView) childAt.findViewById(R$id.nine_grid)) != null && (position = linearLayoutManager.getPosition(childAt)) >= 0 && position < list.size()) {
                PostSubjectItem postSubjectItem = (PostSubjectItem) list.get(position);
                if (qn.b.a(postSubjectItem.getMedia())) {
                    qn.a aVar = this.f72606b;
                    float h11 = aVar != null ? aVar.h(nineGridVideoView, postSubjectItem.getMedia()) : 0.0f;
                    if (f11 < h11) {
                        if (h11 > 0.5f) {
                            i11 = position;
                        }
                        f11 = h11;
                    }
                }
            }
        }
        return i11;
    }

    private final boolean g() {
        List<Object> data;
        BaseQuickAdapter baseQuickAdapter = this.f72605a;
        if (baseQuickAdapter == null || (data = baseQuickAdapter.getData()) == null) {
            return false;
        }
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            if (qn.b.a(((PostSubjectItem) it.next()).getMedia())) {
                return true;
            }
        }
        return false;
    }

    private final boolean h(LinearLayoutManager linearLayoutManager, int i11, int i12) {
        int childCount = linearLayoutManager.getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = linearLayoutManager.getChildAt(i13);
            if (childAt != null) {
                NineGridVideoView nineGridVideoView = (NineGridVideoView) childAt.findViewById(R$id.nine_grid);
                int position = linearLayoutManager.getPosition(childAt);
                if (position == i11) {
                    Boolean valueOf = nineGridVideoView != null ? Boolean.valueOf(nineGridVideoView.currentGifVisible(i12)) : null;
                    if (Intrinsics.c(valueOf, Boolean.TRUE)) {
                        a.C0856a.f(lg.a.f68962a, "ItemChangeListener", "childPos=" + position + " currentGifVisible=" + valueOf, false, 4, null);
                        return true;
                    }
                    boolean hasGifVisible = nineGridVideoView != null ? nineGridVideoView.hasGifVisible() : false;
                    a.C0856a.f(lg.a.f68962a, "ItemChangeListener", "childPos=" + position + " gifVisible=" + hasGifVisible, false, 4, null);
                    qn.a aVar = this.f72606b;
                    if (aVar != null) {
                        aVar.q();
                    }
                    return hasGifVisible;
                }
            }
        }
        return false;
    }

    private final void i(int i11) {
        List<Object> data;
        List<Object> data2;
        BaseQuickAdapter baseQuickAdapter = this.f72605a;
        int size = (baseQuickAdapter == null || (data2 = baseQuickAdapter.getData()) == null) ? 0 : data2.size();
        for (int i12 = i11; i12 < size; i12++) {
            if (i12 > i11) {
                BaseQuickAdapter baseQuickAdapter2 = this.f72605a;
                PostSubjectItem postSubjectItem = (baseQuickAdapter2 == null || (data = baseQuickAdapter2.getData()) == null) ? null : (PostSubjectItem) data.get(i12);
                if (qn.b.a(postSubjectItem != null ? postSubjectItem.getMedia() : null)) {
                    qn.a aVar = this.f72606b;
                    if (aVar != null) {
                        aVar.v(postSubjectItem != null ? postSubjectItem.getMedia() : null);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void e() {
        this.f72605a = null;
        this.f72606b = null;
        this.f72609e = -1;
        this.f72608d = -1;
        this.f72610f = -1;
        this.f72611g = -1;
        this.f72612h = 0;
        this.f72607c = null;
    }

    public final void j(BaseQuickAdapter baseQuickAdapter) {
        this.f72605a = baseQuickAdapter;
    }

    public final void k(qn.a aVar) {
        this.f72606b = aVar;
    }

    public final void l(d dVar) {
        this.f72607c = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.h(recyclerView, "recyclerView");
        if (recyclerView.getScrollState() == 0) {
            d(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.h(recyclerView, "recyclerView");
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            throw new RuntimeException("Unsupported layoutManager.");
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        this.f72608d = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        this.f72609e = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        this.f72610f = linearLayoutManager.findFirstVisibleItemPosition();
        this.f72611g = linearLayoutManager.findLastVisibleItemPosition();
        this.f72612h = i12;
        if (recyclerView.getScrollState() == 0) {
            d(recyclerView);
        }
    }
}
