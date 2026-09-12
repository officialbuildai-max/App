package com.transsion.home.adapter.suboperate.provider;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingData;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.home.view.RankingAdapter;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class SubRankingProvider extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f44607e;

    /* renamed from: f, reason: collision with root package name */
    private t1 f44608f;

    /* renamed from: g, reason: collision with root package name */
    private OperateItem f44609g;

    /* renamed from: h, reason: collision with root package name */
    private BaseQuickAdapter f44610h;

    /* loaded from: classes5.dex */
    public static final class a extends RecyclerView.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f44611a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f44612b;

        a(int i11, int i12) {
            this.f44611a = i11;
            this.f44612b = i12;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            int i11 = this.f44611a;
            outRect.left = i11;
            outRect.right = i11;
            outRect.top = this.f44612b;
        }
    }

    public SubRankingProvider(int i11) {
        this.f44607e = i11;
    }

    private final void D() {
        t1 d11;
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.f44607e), true)) {
            d11 = kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(y0.b()), null, null, new SubRankingProvider$registerCourse$1(this, null), 3, null);
            this.f44608f = d11;
        }
    }

    private final void E(Subject subject, int i11, OperateItem operateItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_ranking");
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("tabId", String.valueOf(this.f44607e));
        if (subject != null) {
            il.b.e(subject, hashMap);
        }
        il.b.a(operateItem, hashMap);
        com.transsion.baselib.helper.a.f43316a.a(SubTabFragment.INSTANCE.a(this.f44607e), hashMap);
    }

    private final void F(Subject subject, int i11, OperateItem operateItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_ranking");
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("tabId", String.valueOf(this.f44607e));
        if (subject != null) {
            il.b.e(subject, hashMap);
        }
        il.b.a(operateItem, hashMap);
        com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44607e), hashMap);
    }

    private final void G(BaseQuickAdapter baseQuickAdapter, final OperateItem operateItem) {
        baseQuickAdapter.w1(new p6.d() { // from class: com.transsion.home.adapter.suboperate.provider.n0
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter2, View view, int i11) {
                SubRankingProvider.H(OperateItem.this, this, baseQuickAdapter2, view, i11);
            }
        });
        if (baseQuickAdapter instanceof com.transsion.home.adapter.suboperate.adapter.t) {
            ((com.transsion.home.adapter.suboperate.adapter.t) baseQuickAdapter).F1(new Function2() { // from class: com.transsion.home.adapter.suboperate.provider.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit I;
                    I = SubRankingProvider.I(SubRankingProvider.this, operateItem, ((Integer) obj).intValue(), (Subject) obj2);
                    return I;
                }
            });
        }
        this.f44610h = baseQuickAdapter;
        this.f44609g = operateItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(OperateItem operateItem, SubRankingProvider subRankingProvider, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        List<Subject> rankings = operateItem.getRankings();
        Subject subject = rankings != null ? rankings.get(i11) : null;
        rl.h.f(subject, "op_ranking");
        subRankingProvider.F(subject, i11, operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(SubRankingProvider subRankingProvider, OperateItem operateItem, int i11, Subject subject) {
        Intrinsics.h(subject, "subject");
        subRankingProvider.E(subject, i11, operateItem);
        return Unit.f67184a;
    }

    private final void J() {
        t1 t1Var = this.f44608f;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        this.f44608f = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r3v3 */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, OperateItem item) {
        BaseQuickAdapter rankingAdapter;
        List arrayList;
        RankingData rankingData;
        Integer perRow;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        helper.setText(R$id.sub_operation_ranking_title, item.getTitle());
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.sub_operation_ranking_recycler);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new a(com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(12.0f)));
        }
        List<Subject> rankings = item.getRankings();
        int i11 = 0;
        int size = rankings != null ? rankings.size() : 0;
        int i12 = 1;
        if (!HomeTabId.INSTANCE.h(Integer.valueOf(this.f44607e), true) || (rankingData = item.getRankingData()) == null || (perRow = rankingData.getPerRow()) == null || perRow.intValue() != 2) {
            recyclerView.setLayoutManager(new NpaGridLayoutManager(k(), 3));
            List<Subject> rankings2 = item.getRankings();
            r3 = rankings2 != null ? rankings2.subList(0, size - (size % 3)) : 0;
            if (r3 == 0 || (arrayList = CollectionsKt.U0((Collection) r3)) == null) {
                arrayList = new ArrayList();
            }
            rankingAdapter = new RankingAdapter(arrayList);
        } else {
            recyclerView.setLayoutManager(new NpaGridLayoutManager(k(), 2));
            rankingAdapter = new com.transsion.home.adapter.suboperate.adapter.t(i11, this.f44607e, i12, r3);
            List<Subject> rankings3 = item.getRankings();
            rankingAdapter.n1(rankings3 != null ? rankings3.subList(0, size - (size % 2)) : null);
        }
        G(rankingAdapter, item);
        recyclerView.setAdapter(rankingAdapter);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.OP_RANKING.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_sub_operation_ranking;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void t(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.t(holder);
        D();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void u(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.u(holder);
        J();
    }
}
