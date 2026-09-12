package com.transsion.home.adapter.trending.provider;

import android.util.LruCache;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.therouter.TheRouter;
import com.transsion.baselib.exposure.ExposureType;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.NewStyleRankContentAdapter;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListData;
import com.transsion.home.bean.RankingListItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lg.a;

/* loaded from: classes5.dex */
public final class l0 extends BaseItemProvider {

    /* renamed from: i, reason: collision with root package name */
    public static final a f44839i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final int f44840j = 8;

    /* renamed from: e, reason: collision with root package name */
    private final int f44841e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f44842f;

    /* renamed from: g, reason: collision with root package name */
    private sj.b f44843g;

    /* renamed from: h, reason: collision with root package name */
    private final e f44844h = new e();

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements sj.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NewStyleRankContentAdapter f44845a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l0 f44846b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ OperateItem f44847c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rl.j f44848d;

        b(NewStyleRankContentAdapter newStyleRankContentAdapter, l0 l0Var, OperateItem operateItem, rl.j jVar) {
            this.f44845a = newStyleRankContentAdapter;
            this.f44846b = l0Var;
            this.f44847c = operateItem;
            this.f44848d = jVar;
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            String num;
            NewStyleRankContentAdapter newStyleRankContentAdapter = this.f44845a;
            l0 l0Var = this.f44846b;
            OperateItem operateItem = this.f44847c;
            rl.j jVar = this.f44848d;
            try {
                Result.Companion companion = Result.INSTANCE;
                a.C0856a.r(lg.a.f68962a, "StateAwareRankListProvider", new String[]{"content item exposure, position:" + i11 + ", duration:" + j11}, false, 4, null);
                Subject subject = (Subject) newStyleRankContentAdapter.f0(i11);
                if (subject != null) {
                    HashMap I = l0Var.I(operateItem);
                    if (newStyleRankContentAdapter.getItemViewType(i11) == 100) {
                        I.put("sequence", String.valueOf(i11));
                        I.put("deepkLink", l0Var.J(operateItem, jVar));
                        I.put("module_name", "more");
                    } else {
                        String subjectId = subject.getSubjectId();
                        String str = "";
                        if (subjectId == null) {
                            subjectId = "";
                        }
                        I.put("subject_id", subjectId);
                        I.put("sequence", String.valueOf(i11));
                        Integer subjectType = subject.getSubjectType();
                        if (subjectType != null && (num = subjectType.toString()) != null) {
                            str = num;
                        }
                        I.put("subject_type", str);
                        I.put("has_resource", String.valueOf(subject.getHasResource()));
                    }
                    hj.i.f64628a.D(SubTabFragment.INSTANCE.a(l0Var.f44841e), I);
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends RecyclerView.r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rl.j f44849a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView f44850b;

        c(rl.j jVar, RecyclerView recyclerView) {
            this.f44849a = jVar;
            this.f44850b = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.h(recyclerView, "recyclerView");
            if (i11 == 0) {
                rl.j jVar = this.f44849a;
                jVar.d(jVar.a(), this.f44850b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends RecyclerView.r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rl.j f44851a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView f44852b;

        d(rl.j jVar, RecyclerView recyclerView) {
            this.f44851a = jVar;
            this.f44852b = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.h(recyclerView, "recyclerView");
            if (i11 == 0) {
                this.f44851a.e(this.f44852b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends LruCache {
        e() {
            super(20);
        }
    }

    public l0(int i11, boolean z10) {
        this.f44841e = i11;
        this.f44842f = z10;
    }

    private final String E(String str, String str2) {
        if (str == null) {
            str = "";
        }
        String p11 = TheRouter.c("/rank/all").K("category", str).F("tabId", this.f44841e).K("defaultCategory", str).K("rankingListId", str2).p();
        String e11 = com.blankj.utilcode.util.c.e();
        Intrinsics.g(e11, "getAppPackageName(...)");
        return GifImagePreviewActivity.PICTURE_SAVE + "://" + e11 + "?type=" + p11;
    }

    private final String F(int i11, String str, int i12) {
        if (str == null) {
            str = "pos_" + i12;
        }
        return "rank_" + i11 + "_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(l0 l0Var, OperateItem operateItem, View view) {
        l0Var.M(operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap I(OperateItem operateItem) {
        String opId = operateItem.getOpId();
        if (opId == null) {
            opId = "";
        }
        Pair a11 = TuplesKt.a("opt_id", opId);
        String type = operateItem.getType();
        return MapsKt.j(a11, TuplesKt.a("opt_type", type != null ? type : ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String J(OperateItem operateItem, rl.j jVar) {
        List<RankingListItem> l11;
        RankingListData rankingListData = operateItem.getRankingListData();
        if (rankingListData == null || (l11 = rankingListData.getItems()) == null) {
            l11 = CollectionsKt.l();
        }
        RankingListData rankingListData2 = operateItem.getRankingListData();
        String rankingListId = rankingListData2 != null ? rankingListData2.getRankingListId() : null;
        int a11 = jVar.a();
        if (l11.isEmpty() || a11 < 0 || a11 >= l11.size()) {
            a11 = 0;
        }
        return (a11 < 0 || a11 >= l11.size()) ? "" : E(l11.get(a11).getCategoryId(), rankingListId);
    }

    private final rl.j K(OperateItem operateItem, BaseViewHolder baseViewHolder) {
        String F = F(this.f44841e, operateItem.getOpId(), baseViewHolder.getBindingAdapterPosition());
        rl.j jVar = (rl.j) this.f44844h.get(F);
        if (jVar != null) {
            return jVar;
        }
        rl.j jVar2 = new rl.j();
        this.f44844h.put(F, jVar2);
        return jVar2;
    }

    private final void L(RecyclerView recyclerView, NewStyleRankContentAdapter newStyleRankContentAdapter, OperateItem operateItem, rl.j jVar) {
        sj.b bVar = new sj.b(0.6f, new b(newStyleRankContentAdapter, this, operateItem, jVar), false, 4, null);
        bVar.n(1);
        bVar.o(ExposureType.NEST_HORIZONTAL);
        recyclerView.addOnScrollListener(bVar);
        this.f44843g = bVar;
    }

    private final void N(rl.j jVar, OperateItem operateItem) {
        List<RankingListItem> l11;
        RankingListData rankingListData = operateItem.getRankingListData();
        if (rankingListData == null || (l11 = rankingListData.getItems()) == null) {
            l11 = CollectionsKt.l();
        }
        RankingListData rankingListData2 = operateItem.getRankingListData();
        String rankingListId = rankingListData2 != null ? rankingListData2.getRankingListId() : null;
        int a11 = jVar.a();
        if (l11.isEmpty() || a11 < 0 || a11 >= l11.size()) {
            a11 = 0;
        }
        if (a11 < 0 || a11 >= l11.size()) {
            return;
        }
        String categoryId = l11.get(a11).getCategoryId();
        ak.k.p(TheRouter.c("/rank/all").K("category", categoryId).F("tabId", this.f44841e).K("defaultCategory", categoryId).K("rankingListId", rankingListId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.transsion.home.adapter.suboperate.adapter.NewStyleRankContentAdapter, T] */
    private final void O(RecyclerView recyclerView, final OperateItem operateItem, final rl.j jVar) {
        List<RankingListItem> l11;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.f(8.0f, 0.0f, 0.0f, 6, null));
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        T t11 = adapter instanceof NewStyleRankContentAdapter ? (NewStyleRankContentAdapter) adapter : 0;
        objectRef.element = t11;
        final boolean z10 = false;
        if (t11 == 0) {
            ?? newStyleRankContentAdapter = new NewStyleRankContentAdapter(0, operateItem, this.f44841e, z10, this.f44842f, 1, null);
            objectRef.element = newStyleRankContentAdapter;
            recyclerView.setAdapter((RecyclerView.Adapter) newStyleRankContentAdapter);
        }
        ((NewStyleRankContentAdapter) objectRef.element).w1(new p6.d() { // from class: com.transsion.home.adapter.trending.provider.k0
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                l0.P(Ref.ObjectRef.this, this, operateItem, jVar, z10, baseQuickAdapter, view, i11);
            }
        });
        int a11 = jVar.a();
        RankingListData rankingListData = operateItem.getRankingListData();
        if (rankingListData == null || (l11 = rankingListData.getItems()) == null) {
            l11 = CollectionsKt.l();
        }
        List<RankingListItem> list = l11;
        if (!list.isEmpty() && a11 >= 0 && a11 < list.size()) {
            List<Subject> subjects = l11.get(a11).getSubjects();
            if (subjects == null) {
                subjects = CollectionsKt.l();
            }
            ((NewStyleRankContentAdapter) objectRef.element).n1(subjects);
            jVar.b(a11, recyclerView);
        }
        recyclerView.clearOnScrollListeners();
        recyclerView.addOnScrollListener(new c(jVar, recyclerView));
        L(recyclerView, (NewStyleRankContentAdapter) objectRef.element, operateItem, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void P(Ref.ObjectRef objectRef, l0 l0Var, OperateItem operateItem, rl.j jVar, boolean z10, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Subject subject;
        String str;
        List<Object> data;
        List<Object> data2;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        List<Object> data3 = ((NewStyleRankContentAdapter) objectRef.element).getData();
        if (data3 == null || i11 >= data3.size() || (subject = (Subject) CollectionsKt.l0(data3, i11)) == null) {
            return;
        }
        HashMap I = l0Var.I(operateItem);
        BaseProviderMultiAdapter g11 = l0Var.g();
        Integer num = null;
        I.put("sequence", String.valueOf((g11 == null || (data2 = g11.getData()) == null) ? null : Integer.valueOf(data2.indexOf(operateItem))));
        String J = l0Var.J(operateItem, jVar);
        if (((NewStyleRankContentAdapter) objectRef.element).getItemViewType(i11) == 100) {
            I.put("deepkLink", J);
            I.put("module_name", "more");
            hj.i.f64628a.p(SubTabFragment.INSTANCE.a(l0Var.f44841e), I);
            l0Var.N(jVar, operateItem);
        } else {
            String subjectId = subject.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            I.put("subject_id", subjectId);
            I.put("sequence", String.valueOf(i11));
            Integer subjectType = subject.getSubjectType();
            if (subjectType == null || (str = subjectType.toString()) == null) {
                str = "";
            }
            I.put("subject_type", str);
            I.put("has_resource", String.valueOf(subject.getHasResource()));
            hj.i.f64628a.p(SubTabFragment.INSTANCE.a(l0Var.f44841e), I);
            l0Var.S(subject, i11, operateItem, z10);
        }
        HashMap I2 = l0Var.I(operateItem);
        BaseProviderMultiAdapter g12 = l0Var.g();
        if (g12 != null && (data = g12.getData()) != null) {
            num = Integer.valueOf(data.indexOf(operateItem));
        }
        I2.put("sequence", String.valueOf(num));
        if (((NewStyleRankContentAdapter) objectRef.element).getItemViewType(i11) == 100 && (J = (String) I.get("deepkLink")) == null) {
            J = "";
        }
        I2.put("deepkLink", J);
        hj.i.f64628a.p(SubTabFragment.INSTANCE.a(l0Var.f44841e), I2);
    }

    private final void Q(final RecyclerView recyclerView, final RecyclerView recyclerView2, final OperateItem operateItem, final rl.j jVar) {
        List<RankingListItem> l11;
        List<Object> data;
        int i11 = 0;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        com.transsion.home.adapter.suboperate.adapter.a aVar = adapter instanceof com.transsion.home.adapter.suboperate.adapter.a ? (com.transsion.home.adapter.suboperate.adapter.a) adapter : null;
        if (aVar == null) {
            aVar = new com.transsion.home.adapter.suboperate.adapter.a(this.f44841e);
            recyclerView.setAdapter(aVar);
        }
        com.transsion.home.adapter.suboperate.adapter.a aVar2 = aVar;
        RankingListData rankingListData = operateItem.getRankingListData();
        if (rankingListData == null || (l11 = rankingListData.getItems()) == null) {
            l11 = CollectionsKt.l();
        }
        final List<RankingListItem> list = l11;
        int a11 = jVar.a();
        if (list.isEmpty() || a11 < 0 || a11 >= list.size()) {
            jVar.f(0);
        } else {
            i11 = a11;
        }
        BaseProviderMultiAdapter g11 = g();
        final String valueOf = String.valueOf((g11 == null || (data = g11.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem)));
        RankingListData rankingListData2 = operateItem.getRankingListData();
        String rankingListId = rankingListData2 != null ? rankingListData2.getRankingListId() : null;
        for (RankingListItem rankingListItem : list) {
            String categoryId = rankingListItem.getCategoryId();
            HashMap I = I(operateItem);
            I.put("sequence", valueOf);
            I.put("deepkLink", E(categoryId, rankingListId));
            String title = rankingListItem.getTitle();
            if (title == null) {
                title = "";
            }
            I.put("module_name", title);
            I.put("tabId", String.valueOf(this.f44841e));
            hj.i.f64628a.D(SubTabFragment.INSTANCE.a(this.f44841e), I);
        }
        aVar2.n1(list);
        aVar2.D1(i11);
        final String str = rankingListId;
        aVar2.w1(new p6.d() { // from class: com.transsion.home.adapter.trending.provider.j0
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                l0.R(RecyclerView.this, list, this, str, operateItem, jVar, recyclerView2, valueOf, baseQuickAdapter, view, i12);
            }
        });
        jVar.c(recyclerView);
        recyclerView.clearOnScrollListeners();
        recyclerView.addOnScrollListener(new d(jVar, recyclerView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(RecyclerView recyclerView, List list, l0 l0Var, String str, OperateItem operateItem, rl.j jVar, RecyclerView recyclerView2, String str2, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        com.transsion.home.adapter.suboperate.adapter.a aVar = adapter instanceof com.transsion.home.adapter.suboperate.adapter.a ? (com.transsion.home.adapter.suboperate.adapter.a) adapter : null;
        if (aVar == null) {
            return;
        }
        int currentSelectIndex = aVar.getCurrentSelectIndex();
        if (i11 >= 0 && i11 < list.size()) {
            RankingListItem rankingListItem = (RankingListItem) list.get(i11);
            String E = l0Var.E(rankingListItem.getCategoryId(), str);
            HashMap I = l0Var.I(operateItem);
            I.put("sequence", str2);
            I.put("deepkLink", E);
            String title = rankingListItem.getTitle();
            if (title == null) {
                title = "";
            }
            I.put("module_name", title);
            I.put("tabId", String.valueOf(l0Var.f44841e));
            hj.i iVar = hj.i.f64628a;
            SubTabFragment.Companion companion = SubTabFragment.INSTANCE;
            iVar.p(companion.a(l0Var.f44841e), I);
            HashMap I2 = l0Var.I(operateItem);
            I2.put("sequence", str2);
            I2.put("deepkLink", E);
            iVar.p(companion.a(l0Var.f44841e), I2);
        }
        if (i11 == currentSelectIndex) {
            return;
        }
        jVar.d(currentSelectIndex, recyclerView2);
        jVar.f(i11);
        aVar.D1(i11);
        if (i11 < 0 || i11 >= list.size()) {
            return;
        }
        List<Subject> subjects = ((RankingListItem) list.get(i11)).getSubjects();
        if (subjects == null) {
            subjects = CollectionsKt.l();
        }
        RecyclerView.Adapter adapter2 = recyclerView2.getAdapter();
        NewStyleRankContentAdapter newStyleRankContentAdapter = adapter2 instanceof NewStyleRankContentAdapter ? (NewStyleRankContentAdapter) adapter2 : null;
        if (newStyleRankContentAdapter != null) {
            newStyleRankContentAdapter.n1(subjects);
        }
        jVar.b(i11, recyclerView2);
    }

    private final void S(Subject subject, int i11, OperateItem operateItem, boolean z10) {
        rl.h.f(subject, "ranking_list_multi_tab");
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        List<Object> data;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        TextView textView = (TextView) helper.getView(R$id.tvModuleTitle);
        textView.setText(item.getTitle());
        TextView textView2 = (TextView) helper.getView(R$id.tvRankMore);
        String deepLink = item.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            jg.c.h(textView2);
        } else {
            jg.c.k(textView2);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l0.H(l0.this, item, view);
                }
            };
            textView.setOnClickListener(onClickListener);
            textView2.setOnClickListener(onClickListener);
        }
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.rvTabList);
        RecyclerView recyclerView2 = (RecyclerView) helper.getView(R$id.rvContentList);
        rl.j K = K(item, helper);
        Q(recyclerView, recyclerView2, item, K);
        O(recyclerView2, item, K);
        HashMap I = I(item);
        BaseProviderMultiAdapter g11 = g();
        I.put("sequence", String.valueOf((g11 == null || (data = g11.getData()) == null) ? null : Integer.valueOf(data.indexOf(item))));
        String deepLink2 = item.getDeepLink();
        if (deepLink2 == null) {
            deepLink2 = "";
        }
        I.put("deepkLink", deepLink2);
        hj.i.f64628a.D(SubTabFragment.INSTANCE.a(this.f44841e), I);
    }

    public final void M(OperateItem item) {
        List<Object> data;
        Intrinsics.h(item, "item");
        String deepLink = item.getDeepLink();
        Integer num = null;
        if (deepLink != null) {
            ak.k.h(deepLink, null, 1, null);
        }
        HashMap I = I(item);
        BaseProviderMultiAdapter g11 = g();
        if (g11 != null && (data = g11.getData()) != null) {
            num = Integer.valueOf(data.indexOf(item));
        }
        I.put("sequence", String.valueOf(num));
        String deepLink2 = item.getDeepLink();
        if (deepLink2 == null) {
            deepLink2 = "";
        }
        I.put("deepkLink", deepLink2);
        I.put("module_name", IntegrationConstants.NAVIGATION_BAR_ALL_ACTION);
        hj.i iVar = hj.i.f64628a;
        SubTabFragment.Companion companion = SubTabFragment.INSTANCE;
        iVar.p(companion.a(this.f44841e), I);
        I.remove("module_name");
        iVar.p(companion.a(this.f44841e), I);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.RANKING_LIST_MULTI_TAB.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.home_item_new_style_ranking;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void t(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.t(holder);
        a.C0856a.v(lg.a.f68962a, "StateAwareRankListProvider", "onViewAttachedToWindow", false, 4, null);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void u(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.u(holder);
        a.C0856a.v(lg.a.f68962a, "StateAwareRankListProvider", "onViewDetachedFromWindow", false, 4, null);
        sj.b bVar = this.f44843g;
        if (bVar != null) {
            bVar.f();
        }
    }
}
