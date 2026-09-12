package com.transsion.search.fragment.result;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.c0;
import androidx.view.v0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baseui.R$string;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.baseui.widget.DrawableCenterTextView;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.publish.model.PostEntity;
import com.transsion.pushapi.NoticePermissionFrom;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SearchList;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.bean.TabItem;
import com.transsion.search.fragment.BaseSearchMainFragment;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsion.search.widget.d;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.Iterator;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J!\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010%H\u0017¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0004J\u001f\u00101\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0019¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108R\u0018\u0010/\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u00100\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010:¨\u0006R"}, d2 = {"Lcom/transsion/search/fragment/result/SearchResultFragment;", "Lcom/transsion/search/fragment/BaseSearchMainFragment;", "Lrq/g;", "<init>", "()V", "", "initViewPager", "Lcom/transsion/search/bean/TabItem;", "tabItem", "Landroidx/fragment/app/Fragment;", "m0", "(Lcom/transsion/search/bean/TabItem;)Landroidx/fragment/app/Fragment;", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "magicIndicator", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "l0", "(Lnet/lucode/hackware/magicindicator/MagicIndicator;Landroidx/viewpager2/widget/ViewPager2;)V", "Landroid/view/View;", "s0", "()Landroid/view/View;", "Landroid/content/Context;", "context", "", "index", "", "textStr", "Lj00/d;", "getIndicatorText", "(Landroid/content/Context;ILjava/lang/String;)Lj00/d;", "Lj00/c;", "getIndicatorView", "(Landroid/content/Context;)Lj00/c;", "Landroid/view/LayoutInflater;", "inflater", "n0", "(Landroid/view/LayoutInflater;)Lrq/g;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "startLoading", "hideLoading", "lazyLoadData", "keyword", "searchFrom", "v0", "(Ljava/lang/String;Ljava/lang/String;)V", "id", "r0", "(Ljava/lang/String;)V", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "a", "Ljava/lang/String;", "Lcom/transsion/search/fragment/result/SearchResultViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "o0", "()Lcom/transsion/search/fragment/result/SearchResultViewModel;", "viewModel", "Lcom/transsion/search/viewmodel/SearchViewModel;", "c", "Lcom/transsion/search/viewmodel/SearchViewModel;", "searchViewModel", "Lcom/transsion/search/bean/SearchResultEntity;", "d", "Lcom/transsion/search/bean/SearchResultEntity;", "searchResultData", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "e", "Lcom/transsion/baseui/widget/ResourcesRequestView;", "requestView", "f", "Ljava/lang/Integer;", "requestMovieCount", be.g.f16474b, "h", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SearchResultFragment extends BaseSearchMainFragment<rq.g> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String keyword;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel = LazyKt.b(new Function0() { // from class: com.transsion.search.fragment.result.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SearchResultViewModel w02;
            w02 = SearchResultFragment.w0(SearchResultFragment.this);
            return w02;
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private SearchViewModel searchViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SearchResultEntity searchResultData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ResourcesRequestView requestView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Integer requestMovieCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String searchFrom;

    /* loaded from: classes6.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MagicIndicator f52140a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SearchResultFragment f52141b;

        b(MagicIndicator magicIndicator, SearchResultFragment searchResultFragment) {
            this.f52140a = magicIndicator;
            this.f52141b = searchResultFragment;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            this.f52140a.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            this.f52140a.onPageScrolled(i11, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            String str;
            List<TabItem> tabs;
            TabItem tabItem;
            this.f52140a.onPageSelected(i11);
            d.a aVar = com.transsion.search.widget.d.f52324a;
            String str2 = this.f52141b.keyword;
            SearchResultEntity searchResultEntity = this.f52141b.searchResultData;
            String tabId = (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null || (tabItem = tabs.get(i11)) == null) ? null : tabItem.getTabId();
            SearchViewModel searchViewModel = this.f52141b.searchViewModel;
            if (searchViewModel == null || (str = searchViewModel.s()) == null) {
                str = "mb_sug";
            }
            aVar.x(str2, tabId, str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends com.transsion.baseui.util.f {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f52143f;

        c(int i11) {
            this.f52143f = i11;
        }

        @Override // com.transsion.baseui.util.f
        public void c(View view) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.baseui.util.f
        public void d(View view) {
            ViewPager2 viewPager2;
            rq.g gVar = (rq.g) SearchResultFragment.this.getMViewBinding();
            if (gVar == null || (viewPager2 = gVar.f74772f) == null) {
                return;
            }
            viewPager2.setCurrentItem(this.f52143f, false);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends j00.a {
        d() {
        }

        @Override // j00.a
        public int a() {
            List<TabItem> tabs;
            SearchResultEntity searchResultEntity = SearchResultFragment.this.searchResultData;
            if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) {
                return 0;
            }
            return tabs.size();
        }

        @Override // j00.a
        public j00.c b(Context context) {
            Intrinsics.h(context, "context");
            return SearchResultFragment.this.getIndicatorView(context);
        }

        @Override // j00.a
        public j00.d c(Context context, int i11) {
            List<TabItem> tabs;
            TabItem tabItem;
            Intrinsics.h(context, "context");
            SearchResultFragment searchResultFragment = SearchResultFragment.this;
            SearchResultEntity searchResultEntity = searchResultFragment.searchResultData;
            return searchResultFragment.getIndicatorText(context, i11, (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null || (tabItem = tabs.get(i11)) == null) ? null : tabItem.getName());
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends FragmentStateAdapter {
        e() {
            super(SearchResultFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            List<TabItem> tabs;
            SearchResultFragment searchResultFragment = SearchResultFragment.this;
            SearchResultEntity searchResultEntity = searchResultFragment.searchResultData;
            return searchResultFragment.m0((searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) ? null : tabs.get(i11));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<TabItem> tabs;
            SearchResultEntity searchResultEntity = SearchResultFragment.this.searchResultData;
            if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) {
                return 0;
            }
            return tabs.size();
        }
    }

    /* loaded from: classes6.dex */
    static final class f implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f52146a;

        f(Function1 function) {
            Intrinsics.h(function, "function");
            this.f52146a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f52146a;
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
            this.f52146a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j00.d getIndicatorText(Context context, int index, String textStr) {
        CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context, 17, a0.a(12.0f));
        customPagerTitleView.setSelectTextSize(16.0f);
        customPagerTitleView.setText(textStr);
        customPagerTitleView.setOnClickListener(new c(index));
        return customPagerTitleView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j00.c getIndicatorView(Context context) {
        GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context);
        gradientLinePagerIndicator.setMode(1);
        gradientLinePagerIndicator.setLineHeight(a0.a(2.0f));
        gradientLinePagerIndicator.setLineWidth(a0.a(24.0f));
        gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        int color = androidx.core.content.b.getColor(context, R$color.white);
        gradientLinePagerIndicator.setColors(color, color, color);
        return gradientLinePagerIndicator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initViewPager() {
        ViewPager2 viewPager2;
        MagicIndicator magicIndicator;
        rq.g gVar = (rq.g) getMViewBinding();
        if (gVar != null && (magicIndicator = gVar.f74769c) != null) {
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            commonNavigator.setAdapter(new d());
            magicIndicator.setNavigator(commonNavigator);
        }
        rq.g gVar2 = (rq.g) getMViewBinding();
        if (gVar2 == null || (viewPager2 = gVar2.f74772f) == null) {
            return;
        }
        viewPager2.setAdapter(new e());
    }

    private final void l0(MagicIndicator magicIndicator, ViewPager2 viewPager) {
        viewPager.registerOnPageChangeCallback(new b(magicIndicator, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment m0(TabItem tabItem) {
        String tabId = tabItem != null ? tabItem.getTabId() : null;
        SearchResultEntity searchResultEntity = this.searchResultData;
        return SearchResultTabFragment.INSTANCE.a(this.keyword, tabItem, Intrinsics.c(tabId, searchResultEntity != null ? searchResultEntity.getTabId() : null) ? this.searchResultData : null, this.searchFrom);
    }

    private final SearchResultViewModel o0() {
        return (SearchResultViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit p0(SearchResultFragment searchResultFragment, SearchResultEntity searchResultEntity) {
        List<SearchList> results;
        String str;
        FrameLayout frameLayout;
        View view;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        List<TabItem> tabs;
        List<SearchList> results2;
        ViewPager2 viewPager2;
        RecyclerView.Adapter adapter;
        MagicIndicator magicIndicator;
        h00.a navigator;
        searchResultFragment.hideLoading();
        if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null || tabs.isEmpty() || (results2 = searchResultEntity.getResults()) == null || results2.isEmpty()) {
            rq.g gVar = (rq.g) searchResultFragment.getMViewBinding();
            if (gVar != null && (frameLayout3 = gVar.f74768b) != null) {
                frameLayout3.removeAllViews();
            }
            rq.g gVar2 = (rq.g) searchResultFragment.getMViewBinding();
            if (gVar2 != null && (frameLayout2 = gVar2.f74768b) != null) {
                frameLayout2.addView(searchResultFragment.s0());
            }
            rq.g gVar3 = (rq.g) searchResultFragment.getMViewBinding();
            if (gVar3 != null && (view = gVar3.f74770d) != null) {
                view.setVisibility(4);
            }
            rq.g gVar4 = (rq.g) searchResultFragment.getMViewBinding();
            if (gVar4 != null && (frameLayout = gVar4.f74768b) != null) {
                frameLayout.setVisibility(0);
            }
            if ((searchResultEntity != null ? searchResultEntity.getPager() : null) != null && ((results = searchResultEntity.getResults()) == null || results.isEmpty())) {
                d.a aVar = com.transsion.search.widget.d.f52324a;
                String str2 = searchResultFragment.keyword;
                String str3 = searchResultFragment.searchFrom;
                SearchViewModel searchViewModel = searchResultFragment.searchViewModel;
                if (searchViewModel == null || (str = searchViewModel.s()) == null) {
                    str = "mb_sug";
                }
                aVar.i(str2, str3, str);
            }
        } else {
            searchResultFragment.searchResultData = searchResultEntity;
            rq.g gVar5 = (rq.g) searchResultFragment.getMViewBinding();
            if (gVar5 != null && (magicIndicator = gVar5.f74769c) != null && (navigator = magicIndicator.getNavigator()) != null) {
                navigator.notifyDataSetChanged();
            }
            rq.g gVar6 = (rq.g) searchResultFragment.getMViewBinding();
            if (gVar6 != null && (viewPager2 = gVar6.f74772f) != null && (adapter = viewPager2.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(SearchResultFragment searchResultFragment, PostEntity postEntity) {
        a.C0856a.g(lg.a.f68962a, "Post request succeed " + postEntity + ", " + (postEntity != null ? postEntity.getCount() : null), false, 2, null);
        if (postEntity != null && searchResultFragment.requestMovieCount == null) {
            int count = postEntity.getCount();
            if (count == null) {
                count = 0;
            }
            searchResultFragment.requestMovieCount = count;
            ResourcesRequestView resourcesRequestView = searchResultFragment.requestView;
            if (resourcesRequestView != null) {
                Integer count2 = postEntity.getCount();
                resourcesRequestView.setCount(count2 != null ? count2.intValue() : 0, false);
            }
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View s0() {
        DrawableCenterTextView drawableCenterTextView;
        if (!nh.m.f70597a.e()) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i11 = R$layout.view_search_no_network;
            rq.g gVar = (rq.g) getMViewBinding();
            View inflate = layoutInflater.inflate(i11, (ViewGroup) (gVar != null ? gVar.f74768b : null), false);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_empty_tips);
            ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_tips);
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R$id.tv_retry);
            textView.setText(R$string.base_net_err);
            imageView.setImageResource(R$mipmap.ic_no_network);
            appCompatTextView.setVisibility(0);
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchResultFragment.u0(SearchResultFragment.this, view);
                }
            });
            Intrinsics.e(inflate);
            return inflate;
        }
        LayoutInflater layoutInflater2 = getLayoutInflater();
        int i12 = R$layout.view_search_empty;
        rq.g gVar2 = (rq.g) getMViewBinding();
        View inflate2 = layoutInflater2.inflate(i12, (ViewGroup) (gVar2 != null ? gVar2.f74768b : null), false);
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
        o0().m(str, true);
        this.requestMovieCount = null;
        bk.h mViewBinding = resourcesRequestView.getMViewBinding();
        if (mViewBinding != null && (drawableCenterTextView = mViewBinding.f16697e) != null) {
            drawableCenterTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchResultFragment.t0(SearchResultFragment.this, str, resourcesRequestView, view);
                }
            });
        }
        Intrinsics.e(inflate2);
        return inflate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(SearchResultFragment searchResultFragment, String str, ResourcesRequestView resourcesRequestView, View view) {
        tp.e.f76458a.e(searchResultFragment, NoticePermissionFrom.DETAIL_NO_RES);
        SearchResultViewModel.n(searchResultFragment.o0(), str, false, 2, null);
        Integer num = searchResultFragment.requestMovieCount;
        if (num != null) {
            Intrinsics.e(num);
            Integer valueOf = Integer.valueOf(num.intValue() + 1);
            searchResultFragment.requestMovieCount = valueOf;
            Intrinsics.e(valueOf);
            ResourcesRequestView.setCount$default(resourcesRequestView, valueOf.intValue(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(SearchResultFragment searchResultFragment, View view) {
        String str = searchResultFragment.keyword;
        if (str == null) {
            str = "";
        }
        searchResultFragment.v0(str, searchResultFragment.searchFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultViewModel w0(SearchResultFragment searchResultFragment) {
        FragmentActivity requireActivity = searchResultFragment.requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        return (SearchResultViewModel) new v0(requireActivity).a(SearchResultViewModel.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        View view;
        MagicIndicator magicIndicator;
        ViewPager2 viewPager2;
        ProgressBar progressBar;
        rq.g gVar = (rq.g) getMViewBinding();
        if (gVar != null && (progressBar = gVar.f74771e) != null) {
            progressBar.setVisibility(4);
        }
        rq.g gVar2 = (rq.g) getMViewBinding();
        if (gVar2 != null && (viewPager2 = gVar2.f74772f) != null) {
            viewPager2.setVisibility(0);
        }
        rq.g gVar3 = (rq.g) getMViewBinding();
        if (gVar3 != null && (magicIndicator = gVar3.f74769c) != null) {
            magicIndicator.setVisibility(0);
        }
        rq.g gVar4 = (rq.g) getMViewBinding();
        if (gVar4 == null || (view = gVar4.f74770d) == null) {
            return;
        }
        view.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        initViewPager();
        o0().k().j(getViewLifecycleOwner(), new f(new Function1() { // from class: com.transsion.search.fragment.result.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p02;
                p02 = SearchResultFragment.p0(SearchResultFragment.this, (SearchResultEntity) obj);
                return p02;
            }
        }));
        o0().i().j(this, new f(new Function1() { // from class: com.transsion.search.fragment.result.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q02;
                q02 = SearchResultFragment.q0(SearchResultFragment.this, (PostEntity) obj);
                return q02;
            }
        }));
        rq.g gVar = (rq.g) getMViewBinding();
        if (gVar != null) {
            MagicIndicator searchResultMagicIndicator = gVar.f74769c;
            Intrinsics.g(searchResultMagicIndicator, "searchResultMagicIndicator");
            ViewPager2 searchResultViewPager = gVar.f74772f;
            Intrinsics.g(searchResultViewPager, "searchResultViewPager");
            l0(searchResultMagicIndicator, searchResultViewPager);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public rq.g getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        rq.g c11 = rq.g.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        String str;
        hj.b bVar = new hj.b("searchresult", false, 2, null);
        bVar.l(true);
        bVar.g().put("search_id", BaseSearchMainFragment.INSTANCE.a());
        HashMap g11 = bVar.g();
        SearchViewModel searchViewModel = this.searchViewModel;
        if (searchViewModel == null || (str = searchViewModel.s()) == null) {
            str = "mb_sug";
        }
        g11.put("sug_source", str);
        return bVar;
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void r0(String id2) {
        Integer num;
        ViewPager2 viewPager2;
        List<TabItem> tabs;
        Intrinsics.h(id2, "id");
        SearchResultEntity searchResultEntity = this.searchResultData;
        if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) {
            num = null;
        } else {
            Iterator<TabItem> it = tabs.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                } else if (Intrinsics.c(it.next().getTabId(), id2)) {
                    break;
                } else {
                    i11++;
                }
            }
            num = Integer.valueOf(i11);
        }
        rq.g gVar = (rq.g) getMViewBinding();
        if (gVar == null || (viewPager2 = gVar.f74772f) == null) {
            return;
        }
        viewPager2.setCurrentItem(num != null ? num.intValue() : 0, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        FrameLayout frameLayout;
        View view;
        MagicIndicator magicIndicator;
        ViewPager2 viewPager2;
        ProgressBar progressBar;
        rq.g gVar = (rq.g) getMViewBinding();
        if (gVar != null && (progressBar = gVar.f74771e) != null) {
            progressBar.setVisibility(0);
        }
        rq.g gVar2 = (rq.g) getMViewBinding();
        if (gVar2 != null && (viewPager2 = gVar2.f74772f) != null) {
            viewPager2.setVisibility(4);
        }
        rq.g gVar3 = (rq.g) getMViewBinding();
        if (gVar3 != null && (magicIndicator = gVar3.f74769c) != null) {
            magicIndicator.setVisibility(4);
        }
        rq.g gVar4 = (rq.g) getMViewBinding();
        if (gVar4 != null && (view = gVar4.f74770d) != null) {
            view.setVisibility(4);
        }
        rq.g gVar5 = (rq.g) getMViewBinding();
        if (gVar5 == null || (frameLayout = gVar5.f74768b) == null) {
            return;
        }
        frameLayout.setVisibility(4);
    }

    public final void v0(String keyword, String searchFrom) {
        String str;
        HashMap g11;
        Intrinsics.h(keyword, "keyword");
        this.keyword = keyword;
        startLoading();
        this.searchResultData = null;
        initViewPager();
        this.searchFrom = searchFrom;
        o0().r(1);
        SearchResultViewModel.p(o0(), keyword, null, false, 6, null);
        d.a aVar = com.transsion.search.widget.d.f52324a;
        SearchViewModel searchViewModel = this.searchViewModel;
        if (searchViewModel == null || (str = searchViewModel.s()) == null) {
            str = "mb_sug";
        }
        aVar.q(keyword, searchFrom, str);
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
            return;
        }
    }
}
