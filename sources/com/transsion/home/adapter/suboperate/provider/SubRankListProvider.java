package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListData;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class SubRankListProvider extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f44597e;

    /* renamed from: f, reason: collision with root package name */
    private t1 f44598f;

    /* renamed from: g, reason: collision with root package name */
    private OperateItem f44599g;

    /* renamed from: h, reason: collision with root package name */
    private com.transsion.home.adapter.suboperate.adapter.q f44600h;

    /* renamed from: i, reason: collision with root package name */
    private com.transsion.home.adapter.suboperate.adapter.r f44601i;

    /* renamed from: j, reason: collision with root package name */
    private int f44602j;

    /* loaded from: classes5.dex */
    public static final class a extends RecyclerView.r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.recyclerview.widget.n f44603a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SubRankListProvider f44604b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecyclerView f44605c;

        a(androidx.recyclerview.widget.n nVar, SubRankListProvider subRankListProvider, RecyclerView recyclerView) {
            this.f44603a = nVar;
            this.f44604b = subRankListProvider;
            this.f44605c = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            View findSnapView;
            List<Object> data;
            Intrinsics.h(recyclerView, "recyclerView");
            if (i11 != 0 || (findSnapView = this.f44603a.findSnapView(recyclerView.getLayoutManager())) == null) {
                return;
            }
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int position = layoutManager != null ? layoutManager.getPosition(findSnapView) : 0;
            com.transsion.home.adapter.suboperate.adapter.r rVar = this.f44604b.f44601i;
            if (rVar != null) {
                rVar.C1(position);
            }
            this.f44604b.f44602j = position;
            if (position != 0) {
                com.transsion.home.adapter.suboperate.adapter.r rVar2 = this.f44604b.f44601i;
                if (position != ((rVar2 == null || (data = rVar2.getData()) == null) ? -1 : data.size()) - 1) {
                    this.f44604b.L(this.f44605c, position);
                    return;
                }
            }
            this.f44605c.scrollToPosition(position);
        }
    }

    public SubRankListProvider(int i11) {
        this.f44597e = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(OperateItem operateItem, View view) {
        String deepLink = operateItem.getDeepLink();
        if (deepLink != null) {
            ak.k.h(deepLink, null, 1, null);
        }
    }

    private final void H(RecyclerView recyclerView, RecyclerView recyclerView2, OperateItem operateItem) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.f(8.0f, 0.0f, 12.0f, 2, null));
        }
        com.transsion.home.adapter.suboperate.adapter.q qVar = new com.transsion.home.adapter.suboperate.adapter.q(0, operateItem, this.f44597e, 1, null);
        this.f44600h = qVar;
        RankingListData rankingListData = operateItem.getRankingListData();
        qVar.n1(rankingListData != null ? rankingListData.getItems() : null);
        recyclerView.setAdapter(this.f44600h);
        recyclerView.scrollToPosition(this.f44602j);
        recyclerView.setOnFlingListener(null);
        androidx.recyclerview.widget.n nVar = new androidx.recyclerview.widget.n();
        nVar.attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new a(nVar, this, recyclerView2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void I(final RecyclerView recyclerView, final RecyclerView recyclerView2, OperateItem operateItem) {
        int i11 = 0;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        int i12 = 1;
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.f(8.0f, 0.0f, 12.0f, 2, null));
        }
        com.transsion.home.adapter.suboperate.adapter.r rVar = new com.transsion.home.adapter.suboperate.adapter.r(i11, i12, 0 == true ? 1 : 0);
        this.f44601i = rVar;
        rVar.C1(this.f44602j);
        com.transsion.home.adapter.suboperate.adapter.r rVar2 = this.f44601i;
        if (rVar2 != null) {
            RankingListData rankingListData = operateItem.getRankingListData();
            rVar2.n1(rankingListData != null ? rankingListData.getItems() : null);
        }
        com.transsion.home.adapter.suboperate.adapter.r rVar3 = this.f44601i;
        if (rVar3 != null) {
            rVar3.w1(new p6.d() { // from class: com.transsion.home.adapter.suboperate.provider.m0
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i13) {
                    SubRankListProvider.J(SubRankListProvider.this, recyclerView2, recyclerView, baseQuickAdapter, view, i13);
                }
            });
        }
        recyclerView.setAdapter(this.f44601i);
        recyclerView.scrollToPosition(this.f44602j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void J(com.transsion.home.adapter.suboperate.provider.SubRankListProvider r1, androidx.recyclerview.widget.RecyclerView r2, androidx.recyclerview.widget.RecyclerView r3, com.chad.library.adapter.base.BaseQuickAdapter r4, android.view.View r5, int r6) {
        /*
            java.lang.String r0 = "<unused var>"
            kotlin.jvm.internal.Intrinsics.h(r4, r0)
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            r1.f44602j = r6
            if (r6 == 0) goto L25
            com.transsion.home.adapter.suboperate.adapter.q r4 = r1.f44600h
            if (r4 == 0) goto L1b
            java.util.List r4 = r4.getData()
            if (r4 == 0) goto L1b
            int r4 = r4.size()
            goto L1c
        L1b:
            r4 = -1
        L1c:
            int r4 = r4 + (-1)
            if (r6 != r4) goto L21
            goto L25
        L21:
            r1.L(r2, r6)
            goto L28
        L25:
            r2.scrollToPosition(r6)
        L28:
            com.transsion.home.adapter.suboperate.adapter.r r2 = r1.f44601i
            if (r2 == 0) goto L31
            int r1 = r1.f44602j
            r2.C1(r1)
        L31:
            r3.scrollToPosition(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.suboperate.provider.SubRankListProvider.J(com.transsion.home.adapter.suboperate.provider.SubRankListProvider, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView, com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    private final void K() {
        t1 d11;
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.f44597e), true)) {
            d11 = kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(y0.b()), null, null, new SubRankListProvider$registerCourse$1(this, null), 3, null);
            this.f44598f = d11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(RecyclerView recyclerView, int i11) {
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(i11) : null;
        if (findViewByPosition == null) {
            recyclerView.scrollToPosition(i11);
        } else {
            recyclerView.scrollBy(findViewByPosition.getLeft() - ((recyclerView.getWidth() / 2) - (findViewByPosition.getWidth() / 2)), 0);
        }
    }

    private final void M() {
        t1 t1Var = this.f44598f;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        this.f44598f = null;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        this.f44599g = item;
        helper.setText(R$id.sub_operation_ranklist_title_text, item.getTitle());
        helper.getView(R$id.sub_operation_ranklist_title_linear).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubRankListProvider.G(OperateItem.this, view);
            }
        });
        View view = helper.getView(R$id.sub_operation_ranklist_all);
        String deepLink = item.getDeepLink();
        view.setVisibility((deepLink == null || deepLink.length() == 0) ? 4 : 0);
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.sub_operation_ranklist_recycler);
        RecyclerView recyclerView2 = (RecyclerView) helper.getView(R$id.sub_operation_ranklist_title_tab_recycler);
        H(recyclerView, recyclerView2, item);
        I(recyclerView2, recyclerView, item);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.RANKING_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_sub_operation_rank_list;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void t(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.t(holder);
        K();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void u(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.u(holder);
        M();
    }
}
