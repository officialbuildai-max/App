package com.transsion.home.adapter.trending.provider;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.trending.adapter.OpMovieRankAdapter;
import com.transsion.home.bean.AppointSubject;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingData;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class p extends BaseItemProvider {

    /* renamed from: i, reason: collision with root package name */
    public static final a f44867i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final int f44868j = 8;

    /* renamed from: e, reason: collision with root package name */
    private final int f44869e;

    /* renamed from: f, reason: collision with root package name */
    private final com.transsion.home.preload.b f44870f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f44871g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f44872h;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public p(int i11, com.transsion.home.preload.b bVar, boolean z10, boolean z11) {
        this.f44869e = i11;
        this.f44870f = bVar;
        this.f44871g = z10;
        this.f44872h = z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(p pVar, OperateItem operateItem, boolean z10, View view) {
        pVar.F(operateItem, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(p pVar, OperateItem operateItem, boolean z10, View view) {
        pVar.F(operateItem, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(OperateItem operateItem, OpMovieRankAdapter opMovieRankAdapter, p pVar, boolean z10, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<AppointSubject> subjects;
        AppointSubject appointSubject;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        List<AppointSubject> subjects2 = operateItem.getSubjects();
        if (i11 >= (subjects2 != null ? subjects2.size() : 0) || (subjects = operateItem.getSubjects()) == null || (appointSubject = subjects.get(i11)) == null) {
            return;
        }
        if (opMovieRankAdapter.getItemViewType(i11) == 100) {
            pVar.F(operateItem, z10);
        } else {
            pVar.G(appointSubject, i11, operateItem, z10);
        }
    }

    private final void F(OperateItem operateItem, boolean z10) {
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
        if (!this.f44871g) {
            rl.c.f74670a.i(operateItem, num);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", z10 ? "click_rank_horiz_more" : "click_rank_more");
        hashMap.put("sequence", String.valueOf(num));
        String deepLink2 = operateItem.getDeepLink();
        if (deepLink2 == null) {
            deepLink2 = "";
        }
        hashMap.put("deepLink", deepLink2);
        String title = operateItem.getTitle();
        hashMap.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        hashMap.put("tabId", String.valueOf(this.f44869e));
        il.b.a(operateItem, hashMap);
        hashMap.put("opt_type", operateItem.getType() + "_RANK_MORE");
        com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44869e), hashMap);
    }

    private final void G(Subject subject, int i11, OperateItem operateItem, boolean z10) {
        rl.h.f(subject, "opt_movie_rank");
        if (!this.f44871g) {
            rl.c.f74670a.h(subject, i11, operateItem);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", z10 ? "click_rank_horiz_item" : "click_rank_item");
        hashMap.put("sequence", String.valueOf(i11));
        hashMap.put("tabId", String.valueOf(this.f44869e));
        if (operateItem != null) {
            il.b.a(operateItem, hashMap);
        }
        il.b.e(subject, hashMap);
        com.transsion.baselib.helper.a.f43316a.f(SubTabFragment.INSTANCE.a(this.f44869e), hashMap);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        List<Object> data;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        RankingData rankingData = item.getRankingData();
        final boolean z10 = rankingData != null && rankingData.getRankingHorizontal();
        TextView textView = (TextView) helper.getView(R$id.main_operation_movie_rank_title);
        textView.setText(item.getTitle());
        TextView textView2 = (TextView) helper.getView(R$id.main_operation_movie_more_text);
        String deepLink = item.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            jg.c.h(textView2);
        } else {
            jg.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.C(p.this, item, z10, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.D(p.this, item, z10, view);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.main_operation_movie_rank_recycler);
        final OpMovieRankAdapter opMovieRankAdapter = new OpMovieRankAdapter(0, item, this.f44871g, this.f44869e, z10, this.f44872h, 1, null);
        recyclerView.setAdapter(opMovieRankAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.f(8.0f, 0.0f, 12.0f, 2, null));
        }
        List<AppointSubject> subjects = item.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        if (subjects.size() > 30) {
            subjects = subjects.subList(0, 31);
        }
        opMovieRankAdapter.n1(subjects);
        opMovieRankAdapter.w1(new p6.d() { // from class: com.transsion.home.adapter.trending.provider.o
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                p.E(OperateItem.this, opMovieRankAdapter, this, z10, baseQuickAdapter, view, i11);
            }
        });
        if (this.f44871g) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", z10 ? "browse_rank_horiz_more" : "browse_rank_more");
            BaseProviderMultiAdapter g11 = g();
            hashMap.put("sequence", String.valueOf((g11 == null || (data = g11.getData()) == null) ? null : Integer.valueOf(data.indexOf(item))));
            String deepLink2 = item.getDeepLink();
            if (deepLink2 == null) {
                deepLink2 = "";
            }
            hashMap.put("deepLink", deepLink2);
            String title = item.getTitle();
            hashMap.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
            hashMap.put("tabId", String.valueOf(this.f44869e));
            il.b.a(item, hashMap);
            hashMap.put("opt_type", item.getType() + "_RANK_MORE");
            com.transsion.baselib.helper.a.f43316a.e(SubTabFragment.INSTANCE.a(this.f44869e), hashMap);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.OP_SUBJECTS_MOVIE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.post_list_item_op_movie_rank;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder r(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        com.transsion.home.preload.b bVar = this.f44870f;
        if (bVar == null || bVar.a() || this.f44870f.c() == null) {
            return super.r(parent, i11);
        }
        a.C0856a.f(lg.a.f68962a, "MainXMLPreload", "subjectOpView", false, 4, null);
        View c11 = this.f44870f.c();
        if (c11 == null) {
            return super.r(parent, i11);
        }
        c11.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new BaseViewHolder(c11);
    }
}
