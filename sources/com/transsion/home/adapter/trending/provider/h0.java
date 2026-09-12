package com.transsion.home.adapter.trending.provider;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.trending.adapter.SportLiveAdapter;
import com.transsion.home.adapter.trending.provider.h0;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h0 extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f44819e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f44820f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f44821g = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.trending.provider.g0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            h0.b I;
            I = h0.I();
            return I;
        }
    });

    /* loaded from: classes5.dex */
    public static final class a extends DiffUtil.e {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(LiveListItem oldItem, LiveListItem newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getMatchId(), newItem.getMatchId()) && Intrinsics.c(oldItem.getStatus(), newItem.getStatus());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(LiveListItem oldItem, LiveListItem newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getMatchId(), newItem.getMatchId());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends RecyclerView.s {
        b() {
            m(0, 8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void k(RecyclerView.b0 b0Var) {
            super.k(b0Var);
        }
    }

    public h0(int i11, boolean z10) {
        this.f44819e = i11;
        this.f44820f = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(h0 h0Var, OperateItem operateItem, View view) {
        h0Var.L(operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(h0 h0Var, OperateItem operateItem, View view) {
        h0Var.L(operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(SportLiveAdapter sportLiveAdapter, List list) {
        sportLiveAdapter.n1(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(List list, h0 h0Var, OperateItem operateItem, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        LiveListItem liveListItem;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        if (list == null || (liveListItem = (LiveListItem) list.get(i11)) == null) {
            return;
        }
        h0Var.K(liveListItem, operateItem, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b I() {
        return new b();
    }

    private final b J() {
        return (b) this.f44821g.getValue();
    }

    private final void K(LiveListItem liveListItem, OperateItem operateItem, int i11) {
        String deepLink = liveListItem.getDeepLink();
        if (deepLink != null) {
            ak.k.h(deepLink, null, 1, null);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_sport_live_item");
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("tabId", String.valueOf(this.f44819e));
        il.b.a(operateItem, hashMap);
        String type = operateItem.getType();
        if (type == null) {
            type = "";
        }
        hashMap.put("opt_type", type);
        String matchId = liveListItem.getMatchId();
        if (matchId == null) {
            matchId = "";
        }
        hashMap.put("match_id", matchId);
        String status = liveListItem.getStatus();
        if (status == null) {
            status = "";
        }
        hashMap.put("match_status", status);
        String ops = liveListItem.getOps();
        hashMap.put("ops", ops != null ? ops : "");
        com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44819e), hashMap);
    }

    private final void L(OperateItem operateItem) {
        List<Object> data;
        String deepLink = operateItem.getDeepLink();
        Integer num = null;
        if (deepLink != null) {
            ak.k.h(deepLink, null, 1, null);
        }
        BaseProviderMultiAdapter g11 = g();
        if (g11 != null && (data = g11.getData()) != null) {
            num = Integer.valueOf(data.indexOf(operateItem));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_sport_live_more");
        hashMap.put("sequence", String.valueOf(num));
        String deepLink2 = operateItem.getDeepLink();
        if (deepLink2 == null) {
            deepLink2 = "";
        }
        hashMap.put("deepLink", deepLink2);
        hashMap.put("tabId", String.valueOf(this.f44819e));
        il.b.a(operateItem, hashMap);
        hashMap.put("opt_type", operateItem.getType() + "_MORE");
        com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44819e), hashMap);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        final ArrayList arrayList;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        TextView textView = (TextView) helper.getView(R$id.main_operation_sport_live_title);
        textView.setText(item.getTitle());
        TextView textView2 = (TextView) helper.getView(R$id.main_operation_sport_more_text);
        String deepLink = item.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            jg.c.h(textView2);
        } else {
            jg.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h0.E(h0.this, item, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h0.F(h0.this, item, view);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.main_operation_sport_live_recycler);
        final SportLiveAdapter sportLiveAdapter = new SportLiveAdapter(0, item, this.f44819e, this.f44820f, 1, null);
        sportLiveAdapter.R0(new a());
        recyclerView.setAdapter(sportLiveAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.f(8.0f, 0.0f, 12.0f, 2, null));
        }
        if (!Intrinsics.c(recyclerView.getRecycledViewPool(), J())) {
            recyclerView.setRecycledViewPool(J());
        }
        List<LiveListItem> liveList = item.getLiveList();
        if (liveList != null) {
            arrayList = new ArrayList();
            for (Object obj : liveList) {
                if (!Intrinsics.c(((LiveListItem) obj).getStatus(), SportLiveAdapter.P)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.home.adapter.trending.provider.e0
            @Override // java.lang.Runnable
            public final void run() {
                h0.G(SportLiveAdapter.this, arrayList);
            }
        });
        sportLiveAdapter.w1(new p6.d() { // from class: com.transsion.home.adapter.trending.provider.f0
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                h0.H(arrayList, this, item, baseQuickAdapter, view, i11);
            }
        });
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.SPORT_LIVE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.post_list_item_sport_live;
    }
}
