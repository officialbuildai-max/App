package com.transsion.home.adapter.operateUGC.provider;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListData;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f44456e;

    /* renamed from: f, reason: collision with root package name */
    private OperateItem f44457f;

    /* renamed from: g, reason: collision with root package name */
    private com.transsion.home.adapter.operateUGC.adapter.d f44458g;

    /* renamed from: h, reason: collision with root package name */
    private com.transsion.home.adapter.operateUGC.adapter.e f44459h;

    /* renamed from: i, reason: collision with root package name */
    private int f44460i;

    /* loaded from: classes5.dex */
    public static final class a extends RecyclerView.r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.transsion.home.view.d f44461a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f44462b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecyclerView f44463c;

        a(com.transsion.home.view.d dVar, w wVar, RecyclerView recyclerView) {
            this.f44461a = dVar;
            this.f44462b = wVar;
            this.f44463c = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            View findSnapView;
            List<Object> data;
            Intrinsics.h(recyclerView, "recyclerView");
            if (i11 != 0 || (findSnapView = this.f44461a.findSnapView(recyclerView.getLayoutManager())) == null) {
                return;
            }
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int position = layoutManager != null ? layoutManager.getPosition(findSnapView) : 0;
            com.transsion.home.adapter.operateUGC.adapter.e eVar = this.f44462b.f44459h;
            if (eVar != null) {
                eVar.C1(position);
            }
            this.f44462b.f44460i = position;
            if (position != 0) {
                com.transsion.home.adapter.operateUGC.adapter.e eVar2 = this.f44462b.f44459h;
                if (position != ((eVar2 == null || (data = eVar2.getData()) == null) ? -1 : data.size()) - 1) {
                    this.f44462b.K(this.f44463c, position);
                    return;
                }
            }
            this.f44463c.scrollToPosition(position);
        }
    }

    public w(int i11) {
        this.f44456e = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(OperateItem operateItem, w wVar, View view) {
        String deepLink = operateItem.getDeepLink();
        if (deepLink != null) {
            ak.k.h(deepLink, null, 1, null);
        }
        wVar.J(operateItem);
    }

    private final void F(RecyclerView recyclerView, RecyclerView recyclerView2, OperateItem operateItem) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.f(8.0f, 0.0f, 12.0f, 2, null));
        }
        com.transsion.home.adapter.operateUGC.adapter.d dVar = new com.transsion.home.adapter.operateUGC.adapter.d(0, operateItem, this.f44456e, 1, null);
        this.f44458g = dVar;
        RankingListData rankingListData = operateItem.getRankingListData();
        dVar.n1(rankingListData != null ? rankingListData.getItems() : null);
        recyclerView.setAdapter(this.f44458g);
        recyclerView.scrollToPosition(this.f44460i);
        recyclerView.setOnFlingListener(null);
        com.transsion.home.view.d dVar2 = new com.transsion.home.view.d(com.blankj.utilcode.util.a0.a(12.0f));
        dVar2.attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new a(dVar2, this, recyclerView2));
    }

    private final void G(final RecyclerView recyclerView, final RecyclerView recyclerView2, OperateItem operateItem) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.f(8.0f, 0.0f, 12.0f, 2, null));
        }
        com.transsion.home.adapter.operateUGC.adapter.e eVar = new com.transsion.home.adapter.operateUGC.adapter.e(0, 1, null);
        this.f44459h = eVar;
        eVar.C1(this.f44460i);
        com.transsion.home.adapter.operateUGC.adapter.e eVar2 = this.f44459h;
        if (eVar2 != null) {
            RankingListData rankingListData = operateItem.getRankingListData();
            eVar2.n1(rankingListData != null ? rankingListData.getItems() : null);
        }
        com.transsion.home.adapter.operateUGC.adapter.e eVar3 = this.f44459h;
        if (eVar3 != null) {
            eVar3.w1(new p6.d() { // from class: com.transsion.home.adapter.operateUGC.provider.v
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    w.H(w.this, recyclerView2, recyclerView, baseQuickAdapter, view, i11);
                }
            });
        }
        recyclerView.setAdapter(this.f44459h);
        recyclerView.scrollToPosition(this.f44460i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void H(com.transsion.home.adapter.operateUGC.provider.w r1, androidx.recyclerview.widget.RecyclerView r2, androidx.recyclerview.widget.RecyclerView r3, com.chad.library.adapter.base.BaseQuickAdapter r4, android.view.View r5, int r6) {
        /*
            java.lang.String r0 = "<unused var>"
            kotlin.jvm.internal.Intrinsics.h(r4, r0)
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            r1.f44460i = r6
            if (r6 == 0) goto L25
            com.transsion.home.adapter.operateUGC.adapter.d r4 = r1.f44458g
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
            r1.K(r2, r6)
            goto L28
        L25:
            r2.scrollToPosition(r6)
        L28:
            com.transsion.home.adapter.operateUGC.adapter.e r2 = r1.f44459h
            if (r2 == 0) goto L31
            int r1 = r1.f44460i
            r2.C1(r1)
        L31:
            r3.scrollToPosition(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.operateUGC.provider.w.H(com.transsion.home.adapter.operateUGC.provider.w, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView, com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    private final void I(OperateItem operateItem) {
        List<Object> data;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", IntegrationConstants.NAVIGATION_BAR_ALL_ACTION);
        BaseProviderMultiAdapter g11 = g();
        hashMap.put(RequestParameters.POSITION, String.valueOf((g11 == null || (data = g11.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        String title = operateItem.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put(CampaignEx.JSON_KEY_TITLE, title);
        hashMap.put("tabId", String.valueOf(this.f44456e));
        il.b.a(operateItem, hashMap);
        hj.i.f64628a.D(SubTabFragment.INSTANCE.a(this.f44456e), hashMap);
    }

    private final void J(OperateItem operateItem) {
        List<Object> data;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", IntegrationConstants.NAVIGATION_BAR_ALL_ACTION);
        BaseProviderMultiAdapter g11 = g();
        hashMap.put(RequestParameters.POSITION, String.valueOf((g11 == null || (data = g11.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        String title = operateItem.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put(CampaignEx.JSON_KEY_TITLE, title);
        hashMap.put("tabId", String.valueOf(this.f44456e));
        il.b.a(operateItem, hashMap);
        hj.i.f64628a.p(SubTabFragment.INSTANCE.a(this.f44456e), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(RecyclerView recyclerView, int i11) {
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(i11) : null;
        if (findViewByPosition == null) {
            recyclerView.scrollToPosition(i11);
        } else {
            recyclerView.scrollBy(findViewByPosition.getLeft() - ((recyclerView.getWidth() / 2) - (findViewByPosition.getWidth() / 2)), 0);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        this.f44457f = item;
        helper.setText(R$id.sub_operation_ranklist_title_text, item.getTitle());
        helper.getView(R$id.sub_operation_ranklist_title_linear).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.E(OperateItem.this, this, view);
            }
        });
        View view = helper.getView(R$id.sub_operation_ranklist_all);
        String deepLink = item.getDeepLink();
        view.setVisibility((deepLink == null || deepLink.length() == 0) ? 4 : 0);
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.sub_operation_ranklist_recycler);
        RecyclerView recyclerView2 = (RecyclerView) helper.getView(R$id.sub_operation_ranklist_title_tab_recycler);
        F(recyclerView, recyclerView2, item);
        G(recyclerView2, recyclerView, item);
        I(item);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.UGC_RANKING_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_sub_operation_rank_list;
    }
}
