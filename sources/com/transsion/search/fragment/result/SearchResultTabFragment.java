package com.transsion.search.fragment.result;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.c0;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baseui.R$string;
import com.transsion.baseui.widget.DrawableCenterTextView;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.model.PostEntity;
import com.transsion.pushapi.NoticePermissionFrom;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.HotRankItem;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.bean.TabItem;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.BaseSearchMainFragment;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsion.search.widget.d;
import com.transsion.search_pugc.widget.NoInterceptRecyclerView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b\"\u0010\u0004J\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u000fH\u0016¢\u0006\u0004\b$\u0010\u0012J\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\u0004R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00107R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00107R\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006X"}, d2 = {"Lcom/transsion/search/fragment/result/SearchResultTabFragment;", "Lcom/transsion/search/fragment/BaseSearchMainFragment;", "Lrq/h;", "<init>", "()V", "Lcom/transsion/search/fragment/result/ResultWrapData;", "it", "", RequestParameters.POSITION, "", "G0", "(Lcom/transsion/search/fragment/result/ResultWrapData;I)V", "u0", "t0", "y0", "", "showTab", "H0", "(Z)V", "Landroid/view/View;", "D0", "()Landroid/view/View;", "Landroid/view/LayoutInflater;", "inflater", "r0", "(Landroid/view/LayoutInflater;)Lrq/h;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "hidden", "onHiddenChanged", "hideLoading", "lazyLoadData", "Lcom/transsion/search/fragment/result/adapter/a;", "a", "Lcom/transsion/search/fragment/result/adapter/a;", "mainAdapter", "Lcom/transsion/search/fragment/result/SearchResultViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "s0", "()Lcom/transsion/search/fragment/result/SearchResultViewModel;", "viewModel", "Lcom/transsion/search/viewmodel/SearchViewModel;", "c", "Lcom/transsion/search/viewmodel/SearchViewModel;", "searchViewModel", "", "d", "Ljava/lang/String;", "keyword", "Lcom/transsion/search/bean/TabItem;", "e", "Lcom/transsion/search/bean/TabItem;", "tabItem", "f", "searchFrom", "Lsj/b;", be.g.f16474b, "Lsj/b;", "exposureHelper", "", "h", "J", "lastScrollTime", "i", "currentTabId", "Lcom/transsion/search/bean/SearchResultEntity;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/search/bean/SearchResultEntity;", "extraResultData", "Lcom/transsion/baseui/widget/ResourcesRequestView;", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/baseui/widget/ResourcesRequestView;", "requestView", "l", "Ljava/lang/Integer;", "requestMovieCount", "m", "Z", "isLoadMoreEnd", "n", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class SearchResultTabFragment extends BaseSearchMainFragment<rq.h> {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.transsion.search.fragment.result.adapter.a mainAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel = LazyKt.b(new Function0() { // from class: com.transsion.search.fragment.result.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SearchResultViewModel I0;
            I0 = SearchResultTabFragment.I0(SearchResultTabFragment.this);
            return I0;
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private SearchViewModel searchViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String keyword;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TabItem tabItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String searchFrom;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private sj.b exposureHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long lastScrollTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String currentTabId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private SearchResultEntity extraResultData;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ResourcesRequestView requestView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Integer requestMovieCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadMoreEnd;

    /* renamed from: com.transsion.search.fragment.result.SearchResultTabFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchResultTabFragment a(String str, TabItem tabItem, SearchResultEntity searchResultEntity, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("tabKeyword", str);
            bundle.putParcelable("tabItem", tabItem);
            if (searchResultEntity != null) {
                bundle.putParcelable("tabResult", searchResultEntity);
            }
            bundle.putString("searchFrom", str2);
            SearchResultTabFragment searchResultTabFragment = new SearchResultTabFragment();
            searchResultTabFragment.setArguments(bundle);
            return searchResultTabFragment;
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52161a;

        static {
            int[] iArr = new int[ResultType.values().length];
            try {
                iArr[ResultType.SUBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResultType.STAFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ResultType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ResultType.VERTICAL_RANK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ResultType.MORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f52161a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements sj.a {

        /* loaded from: classes6.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f52163a;

            static {
                int[] iArr = new int[ResultType.values().length];
                try {
                    iArr[ResultType.SUBJECT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ResultType.STAFF.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ResultType.GROUP.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ResultType.VERTICAL_RANK.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f52163a = iArr;
            }
        }

        c() {
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            String str;
            String s11;
            String s12;
            String s13;
            String s14;
            List<Object> data;
            List<Object> data2;
            com.transsion.search.fragment.result.adapter.a aVar = SearchResultTabFragment.this.mainAdapter;
            if (i11 >= ((aVar == null || (data2 = aVar.getData()) == null) ? 0 : data2.size())) {
                return;
            }
            com.transsion.search.fragment.result.adapter.a aVar2 = SearchResultTabFragment.this.mainAdapter;
            if (aVar2 == null || (str = aVar2.getTabId()) == null) {
                str = SearchResultTabFragment.this.currentTabId;
            }
            String str2 = str;
            com.transsion.search.fragment.result.adapter.a aVar3 = SearchResultTabFragment.this.mainAdapter;
            ResultWrapData resultWrapData = (aVar3 == null || (data = aVar3.getData()) == null) ? null : (ResultWrapData) data.get(i11);
            ResultType type = resultWrapData != null ? resultWrapData.getType() : null;
            int i12 = type == null ? -1 : a.f52163a[type.ordinal()];
            if (i12 == 1) {
                d.a aVar4 = com.transsion.search.widget.d.f52324a;
                Subject subject = resultWrapData.getSubject();
                String str3 = SearchResultTabFragment.this.keyword;
                String str4 = SearchResultTabFragment.this.searchFrom;
                SearchViewModel searchViewModel = SearchResultTabFragment.this.searchViewModel;
                aVar4.t(subject, i11, j11, str3, str4, str2, (searchViewModel == null || (s11 = searchViewModel.s()) == null) ? "mb_sug" : s11);
                return;
            }
            if (i12 == 2) {
                d.a aVar5 = com.transsion.search.widget.d.f52324a;
                Staff staff = resultWrapData.getStaff();
                String str5 = SearchResultTabFragment.this.keyword;
                String str6 = SearchResultTabFragment.this.searchFrom;
                SearchViewModel searchViewModel2 = SearchResultTabFragment.this.searchViewModel;
                aVar5.r(staff, i11, j11, str5, str6, str2, (searchViewModel2 == null || (s12 = searchViewModel2.s()) == null) ? "mb_sug" : s12);
                return;
            }
            if (i12 == 3) {
                d.a aVar6 = com.transsion.search.widget.d.f52324a;
                Group groups = resultWrapData.getGroups();
                String str7 = SearchResultTabFragment.this.keyword;
                String str8 = SearchResultTabFragment.this.searchFrom;
                SearchViewModel searchViewModel3 = SearchResultTabFragment.this.searchViewModel;
                aVar6.a(groups, i11, j11, str7, str8, str2, (searchViewModel3 == null || (s13 = searchViewModel3.s()) == null) ? "mb_sug" : s13);
                return;
            }
            if (i12 != 4) {
                return;
            }
            d.a aVar7 = com.transsion.search.widget.d.f52324a;
            VerticalRank verticalRank = resultWrapData.getVerticalRank();
            String str9 = SearchResultTabFragment.this.keyword;
            String str10 = SearchResultTabFragment.this.searchFrom;
            SearchViewModel searchViewModel4 = SearchResultTabFragment.this.searchViewModel;
            aVar7.j(verticalRank, i11, j11, str9, str10, str2, (searchViewModel4 == null || (s14 = searchViewModel4.s()) == null) ? "mb_sug" : s14);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends RecyclerView.r {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            String str;
            RecyclerView recyclerView2;
            Intrinsics.h(recyclerView, "recyclerView");
            if (i11 == 0) {
                SearchResultTabFragment.this.lastScrollTime = System.currentTimeMillis();
                return;
            }
            if (i11 != 1) {
                return;
            }
            rq.h hVar = (rq.h) SearchResultTabFragment.this.getMViewBinding();
            RecyclerView.m layoutManager = (hVar == null || (recyclerView2 = hVar.f74774b) == null) ? null : recyclerView2.getLayoutManager();
            int findLastVisibleItemPosition = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() : -1;
            d.a aVar = com.transsion.search.widget.d.f52324a;
            String str2 = SearchResultTabFragment.this.currentTabId;
            String str3 = SearchResultTabFragment.this.keyword;
            long currentTimeMillis = System.currentTimeMillis() - SearchResultTabFragment.this.lastScrollTime;
            SearchViewModel searchViewModel = SearchResultTabFragment.this.searchViewModel;
            if (searchViewModel == null || (str = searchViewModel.s()) == null) {
                str = "mb_sug";
            }
            aVar.p(str2, str3, currentTimeMillis, findLastVisibleItemPosition, str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends GridLayoutManager.c {
        e() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            ResultWrapData resultWrapData;
            com.transsion.search.fragment.result.adapter.a aVar = SearchResultTabFragment.this.mainAdapter;
            ResultType type = (aVar == null || (resultWrapData = (ResultWrapData) aVar.getItem(i11)) == null) ? null : resultWrapData.getType();
            return (type == ResultType.MORE || type == ResultType.TITLE) ? 2 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class f implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f52166a;

        f(Function1 function) {
            Intrinsics.h(function, "function");
            this.f52166a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f52166a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f52166a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(SearchResultTabFragment searchResultTabFragment, com.transsion.search.fragment.result.adapter.b bVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        String str;
        String str2;
        List<TabItem> subs;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        TabItem tabItem = searchResultTabFragment.tabItem;
        TabItem tabItem2 = (tabItem == null || (subs = tabItem.getSubs()) == null) ? null : subs.get(i11);
        if (Intrinsics.c(searchResultTabFragment.currentTabId, tabItem2 != null ? tabItem2.getTabId() : null)) {
            return;
        }
        searchResultTabFragment.currentTabId = tabItem2 != null ? tabItem2.getTabId() : null;
        if (tabItem2 == null || (str = tabItem2.getTabId()) == null) {
            str = "";
        }
        bVar.C1(str);
        searchResultTabFragment.H0(true);
        searchResultTabFragment.s0().r(1);
        SearchResultViewModel s02 = searchResultTabFragment.s0();
        String str3 = searchResultTabFragment.keyword;
        SearchResultViewModel.p(s02, str3 == null ? "" : str3, searchResultTabFragment.currentTabId, false, 4, null);
        sj.b bVar2 = searchResultTabFragment.exposureHelper;
        if (bVar2 != null) {
            bVar2.g();
        }
        d.a aVar = com.transsion.search.widget.d.f52324a;
        String str4 = searchResultTabFragment.keyword;
        String str5 = searchResultTabFragment.currentTabId;
        SearchViewModel searchViewModel = searchResultTabFragment.searchViewModel;
        if (searchViewModel == null || (str2 = searchViewModel.s()) == null) {
            str2 = "mb_sug";
        }
        aVar.x(str4, str5, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(SearchResultTabFragment searchResultTabFragment) {
        SearchResultViewModel s02 = searchResultTabFragment.s0();
        String str = searchResultTabFragment.keyword;
        if (str == null) {
            str = "";
        }
        String str2 = searchResultTabFragment.currentTabId;
        s02.o(str, str2 != null ? str2 : "", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(SearchResultTabFragment searchResultTabFragment, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        ResultWrapData resultWrapData;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        com.transsion.search.fragment.result.adapter.a aVar = searchResultTabFragment.mainAdapter;
        if (aVar == null || (resultWrapData = (ResultWrapData) aVar.getItem(i11)) == null) {
            return;
        }
        searchResultTabFragment.G0(resultWrapData, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View D0() {
        DrawableCenterTextView drawableCenterTextView;
        if (!nh.m.f70597a.e()) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i11 = R$layout.view_search_no_network;
            rq.h hVar = (rq.h) getMViewBinding();
            View inflate = layoutInflater.inflate(i11, (ViewGroup) (hVar != null ? hVar.f74774b : null), false);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_empty_tips);
            ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_tips);
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R$id.tv_retry);
            textView.setText(R$string.base_net_err);
            imageView.setImageResource(R$mipmap.ic_no_network);
            appCompatTextView.setVisibility(0);
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchResultTabFragment.F0(SearchResultTabFragment.this, view);
                }
            });
            Intrinsics.e(inflate);
            return inflate;
        }
        LayoutInflater layoutInflater2 = getLayoutInflater();
        int i12 = R$layout.view_search_empty;
        rq.h hVar2 = (rq.h) getMViewBinding();
        View inflate2 = layoutInflater2.inflate(i12, (ViewGroup) (hVar2 != null ? hVar2.f74774b : null), false);
        final ResourcesRequestView resourcesRequestView = (ResourcesRequestView) inflate2.findViewById(R$id.resources_request);
        this.requestView = resourcesRequestView;
        final String str = this.keyword;
        if (str == null) {
            str = "";
        }
        if (str.length() > 10) {
            String substring = str.substring(0, 10);
            Intrinsics.g(substring, "substring(...)");
            str = substring + "...";
        }
        String string = getString(com.transsion.search.R$string.search_value_no_result, this.keyword);
        Intrinsics.g(string, "getString(...)");
        resourcesRequestView.set(string);
        resourcesRequestView.setGray(true);
        s0().m(str, true);
        this.requestMovieCount = null;
        bk.h mViewBinding = resourcesRequestView.getMViewBinding();
        if (mViewBinding != null && (drawableCenterTextView = mViewBinding.f16697e) != null) {
            drawableCenterTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchResultTabFragment.E0(SearchResultTabFragment.this, str, resourcesRequestView, view);
                }
            });
        }
        Intrinsics.e(inflate2);
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(SearchResultTabFragment searchResultTabFragment, String str, ResourcesRequestView resourcesRequestView, View view) {
        tp.e.f76458a.e(searchResultTabFragment, NoticePermissionFrom.DETAIL_NO_RES);
        SearchResultViewModel.n(searchResultTabFragment.s0(), str, false, 2, null);
        Integer num = searchResultTabFragment.requestMovieCount;
        if (num != null) {
            Intrinsics.e(num);
            Integer valueOf = Integer.valueOf(num.intValue() + 1);
            searchResultTabFragment.requestMovieCount = valueOf;
            Intrinsics.e(valueOf);
            ResourcesRequestView.setCount$default(resourcesRequestView, valueOf.intValue(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(SearchResultTabFragment searchResultTabFragment, View view) {
        searchResultTabFragment.lazyLoadData();
    }

    private final void G0(ResultWrapData it, int position) {
        String s11;
        String s12;
        String s13;
        String s14;
        String deeplink;
        int i11 = b.f52161a[it.getType().ordinal()];
        if (i11 == 1) {
            com.transsion.search.f.c(it.getSubject(), "search_result");
            d.a aVar = com.transsion.search.widget.d.f52324a;
            Subject subject = it.getSubject();
            String str = this.keyword;
            String str2 = this.searchFrom;
            String str3 = this.currentTabId;
            SearchViewModel searchViewModel = this.searchViewModel;
            aVar.u(subject, position, str, str2, str3, (searchViewModel == null || (s11 = searchViewModel.s()) == null) ? "mb_sug" : s11);
            return;
        }
        if (i11 == 2) {
            Navigator.x(TheRouter.c("/movie/staff").J("staff", it.getStaff()), requireContext(), null, 2, null);
            d.a aVar2 = com.transsion.search.widget.d.f52324a;
            Staff staff = it.getStaff();
            String str4 = this.keyword;
            String str5 = this.searchFrom;
            String str6 = this.currentTabId;
            SearchViewModel searchViewModel2 = this.searchViewModel;
            aVar2.s(staff, position, str4, str5, str6, (searchViewModel2 == null || (s12 = searchViewModel2.s()) == null) ? "mb_sug" : s12);
            return;
        }
        if (i11 == 3) {
            Navigator c11 = TheRouter.c("/room/detail");
            Group groups = it.getGroups();
            Navigator.x(c11.K("id", groups != null ? groups.getGroupId() : null), requireContext(), null, 2, null);
            d.a aVar3 = com.transsion.search.widget.d.f52324a;
            Group groups2 = it.getGroups();
            String str7 = this.keyword;
            String str8 = this.searchFrom;
            String str9 = this.currentTabId;
            SearchViewModel searchViewModel3 = this.searchViewModel;
            aVar3.b(groups2, position, str7, str8, str9, (searchViewModel3 == null || (s13 = searchViewModel3.s()) == null) ? "mb_sug" : s13);
            return;
        }
        if (i11 != 4) {
            if (i11 == 5 && (getParentFragment() instanceof SearchResultFragment)) {
                Fragment parentFragment = getParentFragment();
                Intrinsics.f(parentFragment, "null cannot be cast to non-null type com.transsion.search.fragment.result.SearchResultFragment");
                SearchResultFragment searchResultFragment = (SearchResultFragment) parentFragment;
                String moreTabId = it.getMoreTabId();
                if (moreTabId == null) {
                    moreTabId = "";
                }
                searchResultFragment.r0(moreTabId);
                return;
            }
            return;
        }
        VerticalRank verticalRank = it.getVerticalRank();
        if (verticalRank != null && (deeplink = verticalRank.getDeeplink()) != null) {
            ak.k.h(deeplink, null, 1, null);
        }
        d.a aVar4 = com.transsion.search.widget.d.f52324a;
        VerticalRank verticalRank2 = it.getVerticalRank();
        String str10 = this.keyword;
        String str11 = this.searchFrom;
        String str12 = this.currentTabId;
        SearchViewModel searchViewModel4 = this.searchViewModel;
        aVar4.k(verticalRank2, position, str10, str11, str12, (searchViewModel4 == null || (s14 = searchViewModel4.s()) == null) ? "mb_sug" : s14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H0(boolean showTab) {
        NoInterceptRecyclerView noInterceptRecyclerView;
        RecyclerView recyclerView;
        rq.h hVar;
        NoInterceptRecyclerView noInterceptRecyclerView2;
        ProgressBar progressBar;
        rq.h hVar2 = (rq.h) getMViewBinding();
        if (hVar2 != null && (progressBar = hVar2.f74776d) != null) {
            progressBar.setVisibility(0);
        }
        if (!showTab && (hVar = (rq.h) getMViewBinding()) != null && (noInterceptRecyclerView2 = hVar.f74775c) != null) {
            noInterceptRecyclerView2.setVisibility(8);
        }
        rq.h hVar3 = (rq.h) getMViewBinding();
        if (hVar3 != null && (recyclerView = hVar3.f74774b) != null) {
            recyclerView.setVisibility(4);
        }
        rq.h hVar4 = (rq.h) getMViewBinding();
        if (hVar4 == null || (noInterceptRecyclerView = hVar4.f74775c) == null) {
            return;
        }
        noInterceptRecyclerView.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultViewModel I0(SearchResultTabFragment searchResultTabFragment) {
        return (SearchResultViewModel) new v0(searchResultTabFragment).a(SearchResultViewModel.class);
    }

    private final SearchResultViewModel s0() {
        return (SearchResultViewModel) this.viewModel.getValue();
    }

    private final void t0() {
        List<TabItem> subs;
        List<TabItem> subs2;
        TabItem tabItem;
        Bundle arguments = getArguments();
        String str = null;
        this.keyword = arguments != null ? arguments.getString("tabKeyword") : null;
        Bundle arguments2 = getArguments();
        this.tabItem = arguments2 != null ? (TabItem) arguments2.getParcelable("tabItem") : null;
        Bundle arguments3 = getArguments();
        this.extraResultData = arguments3 != null ? (SearchResultEntity) arguments3.getParcelable("tabResult") : null;
        Bundle arguments4 = getArguments();
        this.searchFrom = arguments4 != null ? arguments4.getString("searchFrom") : null;
        TabItem tabItem2 = this.tabItem;
        if (tabItem2 == null || (subs = tabItem2.getSubs()) == null || !(!subs.isEmpty())) {
            TabItem tabItem3 = this.tabItem;
            if (tabItem3 != null) {
                str = tabItem3.getTabId();
            }
        } else {
            TabItem tabItem4 = this.tabItem;
            if (tabItem4 != null && (subs2 = tabItem4.getSubs()) != null && (tabItem = subs2.get(0)) != null) {
                str = tabItem.getTabId();
            }
        }
        this.currentTabId = str;
    }

    private final void u0() {
        s0().k().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.search.fragment.result.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x02;
                x02 = SearchResultTabFragment.x0(SearchResultTabFragment.this, (SearchResultEntity) obj);
                return x02;
            }
        }));
        s0().j().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.search.fragment.result.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v02;
                v02 = SearchResultTabFragment.v0(SearchResultTabFragment.this, (SearchResultEntity) obj);
                return v02;
            }
        }));
        s0().i().j(this, new f(new Function1() { // from class: com.transsion.search.fragment.result.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w02;
                w02 = SearchResultTabFragment.w0(SearchResultTabFragment.this, (PostEntity) obj);
                return w02;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(SearchResultTabFragment searchResultTabFragment, SearchResultEntity searchResultEntity) {
        r6.f h02;
        List<ResultWrapData> convertData;
        r6.f h03;
        r6.f h04;
        if (Intrinsics.c(searchResultEntity != null ? searchResultEntity.getTabId() : null, searchResultTabFragment.currentTabId)) {
            if ((searchResultEntity != null ? searchResultEntity.getResults() : null) == null) {
                com.transsion.search.fragment.result.adapter.a aVar = searchResultTabFragment.mainAdapter;
                if (aVar != null && (h04 = aVar.h0()) != null) {
                    h04.v();
                }
            } else {
                com.transsion.search.fragment.result.adapter.a aVar2 = searchResultTabFragment.mainAdapter;
                if (aVar2 != null) {
                    List<ResultWrapData> convertData2 = searchResultEntity.getConvertData();
                    aVar2.q(convertData2 != null ? convertData2 : new ArrayList<>());
                }
                if (!searchResultEntity.getPager().getHasMore() || (convertData = searchResultEntity.getConvertData()) == null || convertData.isEmpty()) {
                    com.transsion.search.fragment.result.adapter.a aVar3 = searchResultTabFragment.mainAdapter;
                    if (aVar3 != null && (h02 = aVar3.h0()) != null) {
                        r6.f.u(h02, false, 1, null);
                    }
                } else {
                    com.transsion.search.fragment.result.adapter.a aVar4 = searchResultTabFragment.mainAdapter;
                    if (aVar4 != null && (h03 = aVar4.h0()) != null) {
                        h03.s();
                    }
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(SearchResultTabFragment searchResultTabFragment, PostEntity postEntity) {
        a.C0856a.g(lg.a.f68962a, "Post request succeed " + postEntity + ", " + (postEntity != null ? postEntity.getCount() : null), false, 2, null);
        if (postEntity != null && searchResultTabFragment.requestMovieCount == null) {
            int count = postEntity.getCount();
            if (count == null) {
                count = 0;
            }
            searchResultTabFragment.requestMovieCount = count;
            ResourcesRequestView resourcesRequestView = searchResultTabFragment.requestView;
            if (resourcesRequestView != null) {
                Integer count2 = postEntity.getCount();
                resourcesRequestView.setCount(count2 != null ? count2.intValue() : 0, false);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(SearchResultTabFragment searchResultTabFragment, SearchResultEntity searchResultEntity) {
        r6.f h02;
        List<ResultWrapData> convertData;
        r6.f h03;
        Pager pager;
        List<ResultWrapData> convertData2;
        com.transsion.search.fragment.result.adapter.a aVar = searchResultTabFragment.mainAdapter;
        if (aVar != null) {
            aVar.n1((searchResultEntity == null || (convertData2 = searchResultEntity.getConvertData()) == null) ? new ArrayList<>() : convertData2);
        }
        com.transsion.search.fragment.result.adapter.a aVar2 = searchResultTabFragment.mainAdapter;
        if (aVar2 != null) {
            String str = searchResultTabFragment.currentTabId;
            if (str == null) {
                str = "";
            }
            aVar2.S1(str);
        }
        List<ResultWrapData> convertData3 = searchResultEntity != null ? searchResultEntity.getConvertData() : null;
        if (convertData3 == null || convertData3.isEmpty()) {
            searchResultTabFragment.requestMovieCount = null;
            com.transsion.search.fragment.result.adapter.a aVar3 = searchResultTabFragment.mainAdapter;
            if (aVar3 != null) {
                aVar3.Y0(searchResultTabFragment.D0());
            }
        }
        if (searchResultEntity == null || (pager = searchResultEntity.getPager()) == null || pager.getHasMore()) {
            if (((searchResultEntity == null || (convertData = searchResultEntity.getConvertData()) == null) ? 0 : convertData.size()) >= 10) {
                com.transsion.search.fragment.result.adapter.a aVar4 = searchResultTabFragment.mainAdapter;
                if (aVar4 != null && (h02 = aVar4.h0()) != null) {
                    h02.s();
                }
                searchResultTabFragment.hideLoading();
                return Unit.f67184a;
            }
        }
        com.transsion.search.fragment.result.adapter.a aVar5 = searchResultTabFragment.mainAdapter;
        if (aVar5 != null && (h03 = aVar5.h0()) != null) {
            r6.f.u(h03, false, 1, null);
        }
        searchResultTabFragment.isLoadMoreEnd = true;
        searchResultTabFragment.hideLoading();
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y0() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        sj.b bVar = new sj.b(0.6f, new c(), false, 4, null);
        bVar.n(2);
        rq.h hVar = (rq.h) getMViewBinding();
        if (hVar != null && (recyclerView3 = hVar.f74774b) != null) {
            recyclerView3.addOnScrollListener(bVar);
        }
        this.exposureHelper = bVar;
        rq.h hVar2 = (rq.h) getMViewBinding();
        if (hVar2 != null && (recyclerView2 = hVar2.f74774b) != null) {
            recyclerView2.addOnScrollListener(new d());
        }
        rq.h hVar3 = (rq.h) getMViewBinding();
        if (hVar3 == null || (recyclerView = hVar3.f74774b) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.search.fragment.result.j
            @Override // java.lang.Runnable
            public final void run() {
                SearchResultTabFragment.z0(SearchResultTabFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(SearchResultTabFragment searchResultTabFragment) {
        if (searchResultTabFragment.lastScrollTime == 0) {
            searchResultTabFragment.lastScrollTime = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        NoInterceptRecyclerView noInterceptRecyclerView;
        RecyclerView recyclerView;
        NoInterceptRecyclerView noInterceptRecyclerView2;
        ProgressBar progressBar;
        rq.h hVar = (rq.h) getMViewBinding();
        if (hVar != null && (progressBar = hVar.f74776d) != null) {
            progressBar.setVisibility(4);
        }
        rq.h hVar2 = (rq.h) getMViewBinding();
        if (hVar2 != null && (noInterceptRecyclerView2 = hVar2.f74775c) != null) {
            noInterceptRecyclerView2.setVisibility(0);
        }
        rq.h hVar3 = (rq.h) getMViewBinding();
        if (hVar3 != null && (recyclerView = hVar3.f74774b) != null) {
            recyclerView.setVisibility(0);
        }
        rq.h hVar4 = (rq.h) getMViewBinding();
        if (hVar4 == null || (noInterceptRecyclerView = hVar4.f74775c) == null) {
            return;
        }
        noInterceptRecyclerView.setEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        String str;
        r6.f h02;
        NoInterceptRecyclerView noInterceptRecyclerView;
        List<TabItem> subs;
        Intrinsics.h(view, "view");
        t0();
        rq.h hVar = (rq.h) getMViewBinding();
        if (hVar != null && (noInterceptRecyclerView = hVar.f74775c) != null) {
            noInterceptRecyclerView.setLayoutManager(new LinearLayoutManager(noInterceptRecyclerView.getContext(), 0, false));
            final com.transsion.search.fragment.result.adapter.b bVar = new com.transsion.search.fragment.result.adapter.b(this.currentTabId);
            TabItem tabItem = this.tabItem;
            bVar.n1((tabItem == null || (subs = tabItem.getSubs()) == null) ? new ArrayList<>() : subs);
            noInterceptRecyclerView.setAdapter(bVar);
            bVar.w1(new p6.d() { // from class: com.transsion.search.fragment.result.f
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                    SearchResultTabFragment.A0(SearchResultTabFragment.this, bVar, baseQuickAdapter, view2, i11);
                }
            });
        }
        rq.h hVar2 = (rq.h) getMViewBinding();
        if (hVar2 != null && (recyclerView = hVar2.f74774b) != null) {
            Resources resources = recyclerView.getContext().getResources();
            Intrinsics.g(resources, "getResources(...)");
            if (com.transsion.search.f.e(resources)) {
                NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(recyclerView.getContext(), 2);
                npaGridLayoutManager.d0(new e());
                recyclerView.setLayoutManager(npaGridLayoutManager);
                recyclerView.addItemDecoration(new ig.b(0, a0.a(12.0f), 0, 0));
            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
                if (!Intrinsics.c(this.currentTabId, "All") && !Intrinsics.c(this.currentTabId, HotRankItem.CATE_MOVIE) && recyclerView.getItemDecorationCount() == 0) {
                    recyclerView.addItemDecoration(new ig.f(0.0f, 8.0f, 0.0f, 5, null));
                }
            }
            sj.b bVar2 = this.exposureHelper;
            String str2 = this.keyword;
            String str3 = this.searchFrom;
            String str4 = this.currentTabId;
            SearchViewModel searchViewModel = this.searchViewModel;
            if (searchViewModel == null || (str = searchViewModel.s()) == null) {
                str = "mb_sug";
            }
            com.transsion.search.fragment.result.adapter.a aVar = new com.transsion.search.fragment.result.adapter.a(bVar2, str2, str3, str4, str);
            this.mainAdapter = aVar;
            recyclerView.setAdapter(aVar);
            com.transsion.search.fragment.result.adapter.a aVar2 = this.mainAdapter;
            if (aVar2 != null && (h02 = aVar2.h0()) != null) {
                h02.D(new p6.f() { // from class: com.transsion.search.fragment.result.g
                    @Override // p6.f
                    public final void a() {
                        SearchResultTabFragment.B0(SearchResultTabFragment.this);
                    }
                });
            }
            com.transsion.search.fragment.result.adapter.a aVar3 = this.mainAdapter;
            if (aVar3 != null) {
                aVar3.w1(new p6.d() { // from class: com.transsion.search.fragment.result.h
                    @Override // p6.d
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                        SearchResultTabFragment.C0(SearchResultTabFragment.this, baseQuickAdapter, view2, i11);
                    }
                });
            }
        }
        y0();
        u0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        Pager pager;
        r6.f h02;
        List<ResultWrapData> convertData;
        SearchResultEntity searchResultEntity = this.extraResultData;
        if (searchResultEntity == null) {
            H0(false);
            SearchResultViewModel s02 = s0();
            String str = this.keyword;
            if (str == null) {
                str = "";
            }
            String str2 = this.currentTabId;
            if (str2 == null) {
                str2 = "";
            }
            SearchResultViewModel.p(s02, str, str2, false, 4, null);
            return;
        }
        com.transsion.search.fragment.result.adapter.a aVar = this.mainAdapter;
        if (aVar != null) {
            aVar.n1((searchResultEntity == null || (convertData = searchResultEntity.getConvertData()) == null) ? new ArrayList<>() : convertData);
        }
        SearchResultEntity searchResultEntity2 = this.extraResultData;
        if (searchResultEntity2 == null || (pager = searchResultEntity2.getPager()) == null || pager.getHasMore()) {
            s0().r(2);
            return;
        }
        com.transsion.search.fragment.result.adapter.a aVar2 = this.mainAdapter;
        if (aVar2 == null || (h02 = aVar2.h0()) == null) {
            return;
        }
        h02.t(true);
    }

    @Override // com.transsion.search.fragment.BaseSearchMainFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Object m1185constructorimpl;
        super.onCreate(savedInstanceState);
        try {
            Result.Companion companion = Result.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            m1185constructorimpl = Result.m1185constructorimpl((SearchViewModel) new v0(requireActivity).a(SearchViewModel.class));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        this.searchViewModel = (SearchViewModel) m1185constructorimpl;
    }

    @Override // com.transsion.search.fragment.BaseSearchMainFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        sj.b bVar;
        super.onHiddenChanged(hidden);
        if (!hidden || (bVar = this.exposureHelper) == null) {
            return;
        }
        bVar.f();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com.transsion.search.fragment.result.adapter.a aVar;
        r6.f h02;
        super.onResume();
        if (!this.isLoadMoreEnd || (aVar = this.mainAdapter) == null || (h02 = aVar.h0()) == null) {
            return;
        }
        r6.f.u(h02, false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public rq.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        rq.h c11 = rq.h.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
