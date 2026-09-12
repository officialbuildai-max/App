package com.transsion.search_pugc.fragment.hot;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.c0;
import androidx.view.v;
import androidx.view.v0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.postdetail.shorttv.widget.ShortTVHistoryView;
import com.transsion.search.R$id;
import com.transsion.search.R$string;
import com.transsion.search_pugc.SearchManager;
import com.transsion.search_pugc.ad.SearchHotAdHelper;
import com.transsion.search_pugc.bean.HotRank;
import com.transsion.search_pugc.bean.HotWord;
import com.transsion.search_pugc.bean.UGCEveryoneSearchData;
import com.transsion.search_pugc.bean.UGCRankSearchData;
import com.transsion.search_pugc.bean.UGCSearchResultData;
import com.transsion.search_pugc.fragment.BaseSearchMainFragment;
import com.transsion.search_pugc.fragment.SearchSubjectFragment;
import com.transsion.search_pugc.fragment.hot.SearchHotFragment;
import com.transsion.search_pugc.fragment.result.SearchResultViewModel;
import com.transsion.search_pugc.widget.LinesFlexBoxLayoutManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import dk.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import np.o;
import rq.n;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ]2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002^_B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u001d\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u001d\u0010\u0017\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J'\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0005J\u0017\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J!\u0010.\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0005J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\u0005J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u0006¢\u0006\u0004\b5\u0010\u0005J\u0015\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u001d¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\nH\u0016¢\u0006\u0004\b:\u0010\rJ\u0017\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b?\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001d0J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010LR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[¨\u0006`"}, d2 = {"Lcom/transsion/search_pugc/fragment/hot/SearchHotFragment;", "Lcom/transsion/search_pugc/fragment/BaseSearchMainFragment;", "Lrq/n;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", "", "initViewModel", "initHistory", "loadHistoryData", "", "isExpand", "expandHistoryLine", "(Z)V", "showHistoryList", "", "Lcom/transsion/search_pugc/bean/HotWord;", "hotWords", "initHotWordWithData", "(Ljava/util/List;)V", "initEveryoneSearch", "Lcom/transsion/search_pugc/bean/HotRank;", "rankRanks", "initRankWithData", "initViewPager", "Landroid/content/Context;", "context", "", "index", "", "textStr", "Lj00/d;", "getIndicatorText", "(Landroid/content/Context;ILjava/lang/String;)Lj00/d;", "Lj00/c;", "getIndicatorView", "(Landroid/content/Context;)Lj00/c;", "clearTipsDialog", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)Lrq/n;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "lazyLoadData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "onConnected", "keyword", "addHistoryWord", "(Ljava/lang/String;)V", "hidden", "onHiddenChanged", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", "Lcom/transsion/search_pugc/fragment/hot/adapter/c;", "mSearchHistoryAdapter", "Lcom/transsion/search_pugc/fragment/hot/adapter/c;", "expand", "Z", "historyExpandLine", "I", "historyCollapseLine", "hotSearchWord", "Ljava/lang/String;", "", "mHistoryList", "Ljava/util/List;", "Lcom/transsion/search_pugc/fragment/hot/adapter/e;", "everyOneSearchAdapter", "Lcom/transsion/search_pugc/fragment/hot/adapter/e;", "rankList", "Lgr/c;", "mSearchViewModel", "Lgr/c;", "Lcom/transsion/search_pugc/ad/SearchHotAdHelper;", "adHelper", "Lcom/transsion/search_pugc/ad/SearchHotAdHelper;", "Lcom/transsion/search_pugc/g;", "searchReporter$delegate", "Lkotlin/Lazy;", "getSearchReporter", "()Lcom/transsion/search_pugc/g;", "searchReporter", "Companion", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SearchHotFragment extends BaseSearchMainFragment<n> implements TRDialogListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PAGE_NAME = "/ugc_search/search_manager";
    private com.transsion.search_pugc.fragment.hot.adapter.e everyOneSearchAdapter;
    private boolean expand;
    private String hotSearchWord;
    private com.transsion.search_pugc.fragment.hot.adapter.c mSearchHistoryAdapter;
    private gr.c mSearchViewModel;
    private int historyExpandLine = 2;
    private int historyCollapseLine = 1;
    private List<String> mHistoryList = new ArrayList();
    private List<HotRank> rankList = CollectionsKt.l();
    private SearchHotAdHelper adHelper = new SearchHotAdHelper(v.a(this));

    /* renamed from: searchReporter$delegate, reason: from kotlin metadata */
    private final Lazy searchReporter = LazyKt.b(new Function0() { // from class: dr.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.search_pugc.g searchReporter_delegate$lambda$0;
            searchReporter_delegate$lambda$0 = SearchHotFragment.searchReporter_delegate$lambda$0(SearchHotFragment.this);
            return searchReporter_delegate$lambda$0;
        }
    });

    /* renamed from: com.transsion.search_pugc.fragment.hot.SearchHotFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchHotFragment a(String str) {
            SearchHotFragment searchHotFragment = new SearchHotFragment();
            searchHotFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("hot_search_word", str)));
            return searchHotFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements ViewPager2.PageTransformer {

        /* renamed from: a, reason: collision with root package name */
        private final int f52400a;

        public b() {
            this(0, 1, null);
        }

        public b(int i11) {
            this.f52400a = i11;
        }

        public /* synthetic */ b(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? a.b(38) : i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
        public void transformPage(View page, float f11) {
            Intrinsics.h(page, "page");
            if (f11 < -1.0f) {
                page.setTranslationX(0.0f);
                return;
            }
            if (f11 <= 0.0f) {
                page.setTranslationX(0.0f);
            } else if (f11 <= 1.0f) {
                page.setTranslationX(-(this.f52400a * f11));
            } else {
                page.setTranslationX(-(this.f52400a * (f11 - 1)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends com.transsion.baseui.util.f {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f52402f;

        c(int i11) {
            this.f52402f = i11;
        }

        @Override // com.transsion.baseui.util.f
        public void c(View view) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.baseui.util.f
        public void d(View view) {
            MagicIndicator magicIndicator;
            ViewPager2 viewPager2;
            n nVar = (n) SearchHotFragment.this.getMViewBinding();
            if (nVar != null && (viewPager2 = nVar.f74824r) != null) {
                viewPager2.setCurrentItem(this.f52402f, false);
            }
            n nVar2 = (n) SearchHotFragment.this.getMViewBinding();
            if (nVar2 == null || (magicIndicator = nVar2.f74821o) == null) {
                return;
            }
            magicIndicator.onPageScrolled(this.f52402f, 0.0f, 0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends j00.a {
        d() {
        }

        @Override // j00.a
        public int a() {
            return SearchHotFragment.this.rankList.size();
        }

        @Override // j00.a
        public j00.c b(Context context) {
            Intrinsics.h(context, "context");
            return SearchHotFragment.this.getIndicatorView(context);
        }

        @Override // j00.a
        public j00.d c(Context context, int i11) {
            String str;
            Intrinsics.h(context, "context");
            HotRank hotRank = (HotRank) CollectionsKt.l0(SearchHotFragment.this.rankList, i11);
            if (hotRank == null || (str = hotRank.getName()) == null) {
                str = "";
            }
            return SearchHotFragment.this.getIndicatorText(context, i11, str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends FragmentStateAdapter {
        e() {
            super(SearchHotFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            return SearchRankPagerFragment.INSTANCE.a((HotRank) SearchHotFragment.this.rankList.get(i11), i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SearchHotFragment.this.rankList.size();
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends ViewPager2.OnPageChangeCallback {
        f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i11);
            n nVar = (n) SearchHotFragment.this.getMViewBinding();
            if (nVar == null || (magicIndicator = nVar.f74821o) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            n nVar = (n) SearchHotFragment.this.getMViewBinding();
            if (nVar == null || (magicIndicator = nVar.f74821o) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            MagicIndicator magicIndicator;
            super.onPageSelected(i11);
            Fragment k02 = SearchHotFragment.this.getChildFragmentManager().k0("f" + i11);
            if (k02 instanceof SearchRankPagerFragment) {
                ((SearchRankPagerFragment) k02).b0();
            }
            n nVar = (n) SearchHotFragment.this.getMViewBinding();
            if (nVar == null || (magicIndicator = nVar.f74821o) == null) {
                return;
            }
            magicIndicator.onPageSelected(i11);
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements com.transsion.search_pugc.a {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void c(SearchHotFragment searchHotFragment, List list) {
            ConstraintLayout constraintLayout;
            searchHotFragment.mHistoryList = CollectionsKt.U0(CollectionsKt.D0(list));
            searchHotFragment.showHistoryList();
            n nVar = (n) searchHotFragment.getMViewBinding();
            if (nVar == null || (constraintLayout = nVar.f74815i) == null) {
                return;
            }
            constraintLayout.setVisibility(!list.isEmpty() ? 0 : 8);
        }

        @Override // com.transsion.search_pugc.a
        public void a(final List list) {
            Intrinsics.h(list, "list");
            FragmentActivity activity = SearchHotFragment.this.getActivity();
            if (activity != null) {
                final SearchHotFragment searchHotFragment = SearchHotFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: dr.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchHotFragment.g.c(SearchHotFragment.this, list);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class h implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f52407a;

        h(Function1 function) {
            Intrinsics.h(function, "function");
            this.f52407a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f52407a;
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
            this.f52407a.invoke(obj);
        }
    }

    private final void clearTipsDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.search_clear_title);
            Intrinsics.g(string, "getString(...)");
            TRDialog.a k11 = aVar.k(string);
            String string2 = getString(R$string.search_clear_des);
            Intrinsics.g(string2, "getString(...)");
            TRDialog.a g11 = k11.g(string2);
            String string3 = getString(R$string.search_clear_cancel);
            Intrinsics.g(string3, "getString(...)");
            TRDialog.a e11 = g11.e(string3);
            String string4 = getString(R$string.search_clear_clear);
            Intrinsics.g(string4, "getString(...)");
            e11.j(string4).h(R$drawable.libui_sub_btn2_normal).f(this).a().d0(this, "clear_tips");
        } catch (Exception e12) {
            a.C0856a.g(lg.a.f68962a, "e " + e12.getLocalizedMessage(), false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NotifyDataSetChanged"})
    private final void expandHistoryLine(final boolean isExpand) {
        RecyclerView recyclerView;
        n nVar = (n) getMViewBinding();
        if (nVar == null || (recyclerView = nVar.f74816j) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: dr.n
            @Override // java.lang.Runnable
            public final void run() {
                SearchHotFragment.expandHistoryLine$lambda$12(SearchHotFragment.this, isExpand);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void expandHistoryLine$lambda$12(final SearchHotFragment searchHotFragment, final boolean z10) {
        int n02;
        n nVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        n nVar2 = (n) searchHotFragment.getMViewBinding();
        Object layoutManager = (nVar2 == null || (recyclerView2 = nVar2.f74816j) == null) ? null : recyclerView2.getLayoutManager();
        final LinesFlexBoxLayoutManager linesFlexBoxLayoutManager = layoutManager instanceof LinesFlexBoxLayoutManager ? (LinesFlexBoxLayoutManager) layoutManager : null;
        if (linesFlexBoxLayoutManager != null && (n02 = linesFlexBoxLayoutManager.n0()) > 0) {
            linesFlexBoxLayoutManager.q0(z10 ? searchHotFragment.historyExpandLine : searchHotFragment.historyCollapseLine);
            boolean z11 = z10 || n02 > searchHotFragment.historyCollapseLine;
            final int o02 = linesFlexBoxLayoutManager.o0() - 1;
            com.transsion.search_pugc.fragment.hot.adapter.c cVar = searchHotFragment.mSearchHistoryAdapter;
            if (cVar != null) {
                cVar.Z1(z11, z10, o02);
            }
            com.transsion.search_pugc.fragment.hot.adapter.c cVar2 = searchHotFragment.mSearchHistoryAdapter;
            if (cVar2 != null) {
                cVar2.notifyDataSetChanged();
            }
            if (!z11 || (nVar = (n) searchHotFragment.getMViewBinding()) == null || (recyclerView = nVar.f74816j) == null) {
                return;
            }
            recyclerView.post(new Runnable() { // from class: dr.l
                @Override // java.lang.Runnable
                public final void run() {
                    SearchHotFragment.expandHistoryLine$lambda$12$lambda$11(LinesFlexBoxLayoutManager.this, o02, searchHotFragment, z10);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void expandHistoryLine$lambda$12$lambda$11(LinesFlexBoxLayoutManager linesFlexBoxLayoutManager, int i11, SearchHotFragment searchHotFragment, boolean z10) {
        com.transsion.search_pugc.fragment.hot.adapter.c cVar;
        if (linesFlexBoxLayoutManager.getChildCount() <= i11 && (cVar = searchHotFragment.mSearchHistoryAdapter) != null) {
            cVar.Z1(true, z10, i11 - 1);
        }
        com.transsion.search_pugc.fragment.hot.adapter.c cVar2 = searchHotFragment.mSearchHistoryAdapter;
        if (cVar2 != null) {
            cVar2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j00.d getIndicatorText(Context context, int index, String textStr) {
        CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context, 17, a0.a(10.0f));
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
        gradientLinePagerIndicator.setLineWidth(a0.a(30.0f));
        gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        int color = androidx.core.content.b.getColor(context, R$color.white);
        gradientLinePagerIndicator.setColors(color, color, color);
        return gradientLinePagerIndicator;
    }

    private final com.transsion.search_pugc.g getSearchReporter() {
        return (com.transsion.search_pugc.g) this.searchReporter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initEveryoneSearch() {
        RecyclerView recyclerView;
        Bundle arguments = getArguments();
        this.hotSearchWord = arguments != null ? arguments.getString("hot_search_word") : null;
        com.transsion.search_pugc.fragment.hot.adapter.e eVar = new com.transsion.search_pugc.fragment.hot.adapter.e(0, 1, null);
        eVar.l(R$id.tv_keyword);
        eVar.s1(new p6.b() { // from class: dr.h
            @Override // p6.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SearchHotFragment.initEveryoneSearch$lambda$23$lambda$22(SearchHotFragment.this, baseQuickAdapter, view, i11);
            }
        });
        this.everyOneSearchAdapter = eVar;
        n nVar = (n) getMViewBinding();
        if (nVar == null || (recyclerView = nVar.f74810d) == null) {
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        LinesFlexBoxLayoutManager linesFlexBoxLayoutManager = new LinesFlexBoxLayoutManager(requireContext);
        linesFlexBoxLayoutManager.c0(0);
        linesFlexBoxLayoutManager.d0(1);
        linesFlexBoxLayoutManager.e0(0);
        linesFlexBoxLayoutManager.q0(this.historyExpandLine);
        recyclerView.setLayoutManager(linesFlexBoxLayoutManager);
        recyclerView.setAdapter(this.everyOneSearchAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEveryoneSearch$lambda$23$lambda$22(final SearchHotFragment searchHotFragment, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        com.transsion.search_pugc.fragment.hot.adapter.e eVar;
        HotWord hotWord;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        Fragment parentFragment = searchHotFragment.getParentFragment();
        if (!(parentFragment instanceof SearchSubjectFragment) || (eVar = searchHotFragment.everyOneSearchAdapter) == null || (hotWord = (HotWord) eVar.getItem(i11)) == null) {
            return;
        }
        ((SearchSubjectFragment) parentFragment).A0(hotWord.getWord(), "hot", new Function1() { // from class: dr.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initEveryoneSearch$lambda$23$lambda$22$lambda$21$lambda$20;
                initEveryoneSearch$lambda$23$lambda$22$lambda$21$lambda$20 = SearchHotFragment.initEveryoneSearch$lambda$23$lambda$22$lambda$21$lambda$20(SearchHotFragment.this, (String) obj);
                return initEveryoneSearch$lambda$23$lambda$22$lambda$21$lambda$20;
            }
        });
        searchHotFragment.getSearchReporter().E("hot", hotWord.getWord());
        searchHotFragment.getSearchReporter().r(hotWord.getWord(), i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initEveryoneSearch$lambda$23$lambda$22$lambda$21$lambda$20(SearchHotFragment searchHotFragment, String it) {
        Intrinsics.h(it, "it");
        com.transsion.search_pugc.fragment.hot.adapter.c cVar = searchHotFragment.mSearchHistoryAdapter;
        if (cVar != null) {
            cVar.p(new com.transsion.search_pugc.fragment.hot.adapter.a(1, it));
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initHistory() {
        TextView textView;
        n nVar = (n) getMViewBinding();
        if (nVar != null && (textView = nVar.f74826t) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: dr.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHotFragment.initHistory$lambda$8(SearchHotFragment.this, view);
                }
            });
        }
        com.transsion.search_pugc.fragment.hot.adapter.c cVar = new com.transsion.search_pugc.fragment.hot.adapter.c();
        this.mSearchHistoryAdapter = cVar;
        cVar.l(R$id.search_history_text);
        com.transsion.search_pugc.fragment.hot.adapter.c cVar2 = this.mSearchHistoryAdapter;
        if (cVar2 != null) {
            cVar2.s1(new p6.b() { // from class: dr.k
                @Override // p6.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    SearchHotFragment.initHistory$lambda$10(SearchHotFragment.this, baseQuickAdapter, view, i11);
                }
            });
        }
        loadHistoryData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHistory$lambda$10(final SearchHotFragment searchHotFragment, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        com.transsion.search_pugc.fragment.hot.adapter.c cVar;
        com.transsion.search_pugc.fragment.hot.adapter.a aVar;
        String a11;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        Fragment parentFragment = searchHotFragment.getParentFragment();
        if (!(parentFragment instanceof SearchSubjectFragment) || (cVar = searchHotFragment.mSearchHistoryAdapter) == null || (aVar = (com.transsion.search_pugc.fragment.hot.adapter.a) cVar.getItem(i11)) == null || (a11 = aVar.a()) == null) {
            return;
        }
        ((SearchSubjectFragment) parentFragment).A0(a11, ShortTVHistoryView.TYPE_HISTORY, new Function1() { // from class: dr.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initHistory$lambda$10$lambda$9;
                initHistory$lambda$10$lambda$9 = SearchHotFragment.initHistory$lambda$10$lambda$9(SearchHotFragment.this, (String) obj);
                return initHistory$lambda$10$lambda$9;
            }
        });
        searchHotFragment.getSearchReporter().p(a11, i11);
        searchHotFragment.getSearchReporter().E(ShortTVHistoryView.TYPE_HISTORY, a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initHistory$lambda$10$lambda$9(SearchHotFragment searchHotFragment, String it) {
        Intrinsics.h(it, "it");
        com.transsion.search_pugc.fragment.hot.adapter.c cVar = searchHotFragment.mSearchHistoryAdapter;
        if (cVar != null) {
            cVar.p(new com.transsion.search_pugc.fragment.hot.adapter.a(1, it));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHistory$lambda$8(SearchHotFragment searchHotFragment, View view) {
        searchHotFragment.clearTipsDialog();
        Context context = view.getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        if (KeyboardUtils.g((Activity) context)) {
            Context context2 = view.getContext();
            Intrinsics.f(context2, "null cannot be cast to non-null type android.app.Activity");
            KeyboardUtils.d((Activity) context2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initHotWordWithData(List<HotWord> hotWords) {
        ConstraintLayout constraintLayout;
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout2;
        TextView textView;
        n nVar = (n) getMViewBinding();
        if (nVar != null && (textView = nVar.f74827u) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: dr.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHotFragment.initHotWordWithData$lambda$17(view);
                }
            });
        }
        if (hotWords.isEmpty()) {
            n nVar2 = (n) getMViewBinding();
            if (nVar2 == null || (constraintLayout = nVar2.f74817k) == null) {
                return;
            }
            jg.c.g(constraintLayout);
            return;
        }
        n nVar3 = (n) getMViewBinding();
        if (nVar3 != null && (constraintLayout2 = nVar3.f74817k) != null) {
            jg.c.k(constraintLayout2);
        }
        final ArrayList arrayList = new ArrayList();
        for (Object obj : hotWords) {
            if (!Intrinsics.c(((HotWord) obj).getWord(), this.hotSearchWord)) {
                arrayList.add(obj);
            }
        }
        com.transsion.search_pugc.fragment.hot.adapter.e eVar = this.everyOneSearchAdapter;
        if (eVar != null) {
            eVar.n1(arrayList);
        }
        n nVar4 = (n) getMViewBinding();
        if (nVar4 == null || (recyclerView = nVar4.f74810d) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: dr.p
            @Override // java.lang.Runnable
            public final void run() {
                SearchHotFragment.initHotWordWithData$lambda$19(SearchHotFragment.this, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHotWordWithData$lambda$17(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initHotWordWithData$lambda$19(SearchHotFragment searchHotFragment, List list) {
        RecyclerView recyclerView;
        n nVar = (n) searchHotFragment.getMViewBinding();
        RecyclerView.m layoutManager = (nVar == null || (recyclerView = nVar.f74810d) == null) ? null : recyclerView.getLayoutManager();
        if (layoutManager instanceof LinesFlexBoxLayoutManager) {
            int o02 = ((LinesFlexBoxLayoutManager) layoutManager).o0();
            for (int i11 = 0; i11 < o02; i11++) {
                if (i11 < list.size()) {
                    searchHotFragment.getSearchReporter().q(((HotWord) list.get(i11)).getWord(), i11);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initRankWithData(List<HotRank> rankRanks) {
        ViewPager2 viewPager2;
        RecyclerView.Adapter adapter;
        MagicIndicator magicIndicator;
        h00.a navigator;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        if (rankRanks.isEmpty()) {
            n nVar = (n) getMViewBinding();
            if (nVar == null || (relativeLayout2 = nVar.f74823q) == null) {
                return;
            }
            jg.c.h(relativeLayout2);
            return;
        }
        n nVar2 = (n) getMViewBinding();
        if (nVar2 != null && (relativeLayout = nVar2.f74823q) != null) {
            jg.c.k(relativeLayout);
        }
        n nVar3 = (n) getMViewBinding();
        if (nVar3 != null && (magicIndicator = nVar3.f74821o) != null && (navigator = magicIndicator.getNavigator()) != null) {
            navigator.notifyDataSetChanged();
        }
        n nVar4 = (n) getMViewBinding();
        if (nVar4 == null || (viewPager2 = nVar4.f74824r) == null || (adapter = viewPager2.getAdapter()) == null) {
            return;
        }
        adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(SearchHotFragment searchHotFragment, NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        Intrinsics.h(nestedScrollView, "<unused var>");
        FragmentActivity activity = searchHotFragment.getActivity();
        if (activity == null || !KeyboardUtils.g(activity)) {
            return;
        }
        n nVar = (n) searchHotFragment.getMViewBinding();
        o.a(nVar != null ? nVar.f74825s : null);
    }

    private final void initViewModel() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        gr.c cVar = (gr.c) new v0(requireActivity).a(gr.c.class);
        getSearchReporter().F(cVar.g());
        cVar.k().j(this, new h(new Function1() { // from class: dr.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$5$lambda$3;
                initViewModel$lambda$5$lambda$3 = SearchHotFragment.initViewModel$lambda$5$lambda$3(SearchHotFragment.this, (UGCEveryoneSearchData) obj);
                return initViewModel$lambda$5$lambda$3;
            }
        }));
        cVar.l().j(this, new h(new Function1() { // from class: dr.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$5$lambda$4;
                initViewModel$lambda$5$lambda$4 = SearchHotFragment.initViewModel$lambda$5$lambda$4(SearchHotFragment.this, (UGCRankSearchData) obj);
                return initViewModel$lambda$5$lambda$4;
            }
        }));
        this.mSearchViewModel = cVar;
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.g(requireActivity2, "requireActivity(...)");
        ((SearchResultViewModel) new v0(requireActivity2).a(SearchResultViewModel.class)).l().j(getViewLifecycleOwner(), new h(new Function1() { // from class: dr.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initViewModel$lambda$7$lambda$6;
                initViewModel$lambda$7$lambda$6 = SearchHotFragment.initViewModel$lambda$7$lambda$6(SearchHotFragment.this, (UGCSearchResultData) obj);
                return initViewModel$lambda$7$lambda$6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initViewModel$lambda$5$lambda$3(SearchHotFragment searchHotFragment, UGCEveryoneSearchData uGCEveryoneSearchData) {
        List<HotWord> l11;
        View view;
        ProgressBar progressBar;
        n nVar = (n) searchHotFragment.getMViewBinding();
        if (nVar != null && (progressBar = nVar.f74814h) != null) {
            progressBar.setVisibility(8);
        }
        n nVar2 = (n) searchHotFragment.getMViewBinding();
        if (nVar2 != null && (view = nVar2.f74820n) != null) {
            view.setVisibility(0);
        }
        if (uGCEveryoneSearchData == null || (l11 = uGCEveryoneSearchData.getHotWords()) == null) {
            l11 = CollectionsKt.l();
        }
        searchHotFragment.initHotWordWithData(l11);
        hj.b logViewConfig = searchHotFragment.getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(uGCEveryoneSearchData != null);
        }
        searchHotFragment.getSearchReporter().i(searchHotFragment.getLogViewConfig());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewModel$lambda$5$lambda$4(SearchHotFragment searchHotFragment, UGCRankSearchData uGCRankSearchData) {
        List<HotRank> l11;
        if (uGCRankSearchData == null || (l11 = uGCRankSearchData.getHotRanks()) == null) {
            l11 = CollectionsKt.l();
        }
        searchHotFragment.rankList = l11;
        searchHotFragment.initRankWithData(l11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initViewModel$lambda$7$lambda$6(SearchHotFragment searchHotFragment, UGCSearchResultData uGCSearchResultData) {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        ConstraintLayout constraintLayout3;
        ConstraintLayout constraintLayout4;
        if (uGCSearchResultData == null || !(uGCSearchResultData.getTabs().isEmpty() || uGCSearchResultData.getItems().isEmpty())) {
            n nVar = (n) searchHotFragment.getMViewBinding();
            if (nVar != null && (constraintLayout2 = nVar.f74809c) != null) {
                jg.c.g(constraintLayout2);
            }
            n nVar2 = (n) searchHotFragment.getMViewBinding();
            if (nVar2 != null && (constraintLayout = nVar2.f74812f) != null) {
                jg.c.k(constraintLayout);
            }
        } else {
            n nVar3 = (n) searchHotFragment.getMViewBinding();
            if (nVar3 != null && (constraintLayout4 = nVar3.f74809c) != null) {
                jg.c.k(constraintLayout4);
            }
            n nVar4 = (n) searchHotFragment.getMViewBinding();
            if (nVar4 != null && (constraintLayout3 = nVar4.f74812f) != null) {
                jg.c.g(constraintLayout3);
            }
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initViewPager() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        ViewPager2 viewPager23;
        ViewPager2 viewPager24;
        ViewPager2 viewPager25;
        MagicIndicator magicIndicator;
        n nVar = (n) getMViewBinding();
        if (nVar != null && (magicIndicator = nVar.f74821o) != null) {
            CommonNavigator commonNavigator = new CommonNavigator(requireContext());
            commonNavigator.setAdapter(new d());
            magicIndicator.setNavigator(commonNavigator);
        }
        n nVar2 = (n) getMViewBinding();
        if (nVar2 != null && (viewPager25 = nVar2.f74824r) != null) {
            viewPager25.setAdapter(new e());
        }
        n nVar3 = (n) getMViewBinding();
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (nVar3 != null && (viewPager24 = nVar3.f74824r) != null) {
            viewPager24.setLayerType(2, null);
        }
        n nVar4 = (n) getMViewBinding();
        int i11 = 1;
        if (nVar4 != null && (viewPager23 = nVar4.f74824r) != null) {
            viewPager23.setPageTransformer(new b(0, i11, defaultConstructorMarker));
        }
        n nVar5 = (n) getMViewBinding();
        if (nVar5 != null && (viewPager22 = nVar5.f74824r) != null) {
            viewPager22.setOffscreenPageLimit(1);
        }
        n nVar6 = (n) getMViewBinding();
        if (nVar6 == null || (viewPager2 = nVar6.f74824r) == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new f());
    }

    private final void loadHistoryData() {
        SearchManager.f52325f.a().p(3, new g());
        if (getParentFragment() instanceof SearchSubjectFragment) {
            Fragment parentFragment = getParentFragment();
            Intrinsics.f(parentFragment, "null cannot be cast to non-null type com.transsion.search_pugc.fragment.SearchSubjectFragment");
            ((SearchSubjectFragment) parentFragment).V0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.search_pugc.g searchReporter_delegate$lambda$0(SearchHotFragment searchHotFragment) {
        return com.transsion.search_pugc.g.f52532h.a(searchHotFragment.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showHistoryList() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        String value;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        ConfigBean c11 = sm.f.f75530c.a().c("sa_history_lines_double", false);
        if (Intrinsics.c((c11 == null || (value = c11.getValue()) == null) ? null : StringsKt.m1(value), Boolean.TRUE)) {
            this.historyExpandLine = 4;
            this.historyCollapseLine = 2;
        }
        com.transsion.search_pugc.fragment.hot.adapter.c cVar = this.mSearchHistoryAdapter;
        if (cVar != null) {
            cVar.Y1(new Function0() { // from class: dr.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit showHistoryList$lambda$13;
                    showHistoryList$lambda$13 = SearchHotFragment.showHistoryList$lambda$13(SearchHotFragment.this);
                    return showHistoryList$lambda$13;
                }
            });
        }
        n nVar = (n) getMViewBinding();
        if (nVar != null && (recyclerView4 = nVar.f74816j) != null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            LinesFlexBoxLayoutManager linesFlexBoxLayoutManager = new LinesFlexBoxLayoutManager(requireContext);
            linesFlexBoxLayoutManager.c0(0);
            linesFlexBoxLayoutManager.d0(1);
            linesFlexBoxLayoutManager.e0(0);
            linesFlexBoxLayoutManager.q0(this.expand ? this.historyExpandLine : this.historyCollapseLine);
            recyclerView4.setLayoutManager(linesFlexBoxLayoutManager);
        }
        n nVar2 = (n) getMViewBinding();
        if (nVar2 != null && (recyclerView3 = nVar2.f74816j) != null) {
            recyclerView3.setAdapter(this.mSearchHistoryAdapter);
        }
        n nVar3 = (n) getMViewBinding();
        if (nVar3 != null && (recyclerView2 = nVar3.f74816j) != null) {
            recyclerView2.setItemAnimator(null);
        }
        List<String> list = this.mHistoryList;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.transsion.search_pugc.fragment.hot.adapter.a(1, (String) it.next()));
        }
        List<Object> U0 = CollectionsKt.U0(arrayList);
        com.transsion.search_pugc.fragment.hot.adapter.c cVar2 = this.mSearchHistoryAdapter;
        if (cVar2 != null) {
            cVar2.q1(U0);
        }
        n nVar4 = (n) getMViewBinding();
        if (nVar4 == null || (recyclerView = nVar4.f74816j) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: dr.f
            @Override // java.lang.Runnable
            public final void run() {
                SearchHotFragment.showHistoryList$lambda$16(SearchHotFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showHistoryList$lambda$13(SearchHotFragment searchHotFragment) {
        boolean z10 = !searchHotFragment.expand;
        searchHotFragment.expand = z10;
        searchHotFragment.expandHistoryLine(z10);
        n nVar = (n) searchHotFragment.getMViewBinding();
        o.a(nVar != null ? nVar.f74816j : null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHistoryList$lambda$16(SearchHotFragment searchHotFragment) {
        searchHotFragment.expandHistoryLine(searchHotFragment.expand);
    }

    public final void addHistoryWord(String keyword) {
        Intrinsics.h(keyword, "keyword");
        if (this.mHistoryList.contains(keyword)) {
            return;
        }
        SearchManager.f52325f.a().g(keyword);
        this.mHistoryList.add(0, keyword);
        if (this.mHistoryList.size() > 30) {
            this.mHistoryList.remove(r3.size() - 1);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public n getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        n c11 = n.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        NestedScrollView nestedScrollView;
        Intrinsics.h(view, "view");
        initViewModel();
        initHistory();
        initEveryoneSearch();
        initViewPager();
        SearchHotAdHelper searchHotAdHelper = this.adHelper;
        n nVar = (n) getMViewBinding();
        searchHotAdHelper.m(nVar != null ? nVar.f74808b : null);
        n nVar2 = (n) getMViewBinding();
        if (nVar2 != null && (nestedScrollView = nVar2.f74825s) != null) {
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.e() { // from class: dr.a
                @Override // androidx.core.widget.NestedScrollView.e
                public final void a(NestedScrollView nestedScrollView2, int i11, int i12, int i13, int i14) {
                    SearchHotFragment.initView$lambda$2(SearchHotFragment.this, nestedScrollView2, i11, i12, i13, i14);
                }
            });
        }
        getSearchReporter().j(getLogViewConfig());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        View view;
        ProgressBar progressBar;
        gr.c cVar = this.mSearchViewModel;
        if (cVar != null) {
            cVar.h(getSearchReporter().f());
        }
        gr.c cVar2 = this.mSearchViewModel;
        if (cVar2 != null) {
            cVar2.i(getSearchReporter().f());
        }
        n nVar = (n) getMViewBinding();
        if (nVar != null && (progressBar = nVar.f74814h) != null) {
            progressBar.setVisibility(0);
        }
        n nVar2 = (n) getMViewBinding();
        if (nVar2 == null || (view = nVar2.f74820n) == null) {
            return;
        }
        view.setVisibility(4);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        return com.transsion.search_pugc.g.f52532h.a(getContext()).g(PAGE_NAME);
    }

    public final void onConnected() {
        com.transsion.search_pugc.fragment.hot.adapter.e eVar = this.everyOneSearchAdapter;
        List<Object> data = eVar != null ? eVar.getData() : null;
        if (data == null || data.isEmpty() || this.rankList.isEmpty()) {
            lazyLoadData();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.adHelper.p();
    }

    @Override // com.transsion.search_pugc.fragment.BaseSearchMainFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        loadHistoryData();
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        Intrinsics.h(dialog, "dialog");
        if (TextUtils.equals(dialog.getTag(), "clear_tips")) {
            SearchManager.f52325f.a().j();
            this.mHistoryList.clear();
            n nVar = (n) getMViewBinding();
            if (nVar != null && (constraintLayout = nVar.f74815i) != null) {
                constraintLayout.setVisibility(8);
            }
            com.transsion.search_pugc.fragment.hot.adapter.c cVar = this.mSearchHistoryAdapter;
            if (cVar != null) {
                cVar.q1(new ArrayList());
            }
            n nVar2 = (n) getMViewBinding();
            RecyclerView.m layoutManager = (nVar2 == null || (recyclerView = nVar2.f74816j) == null) ? null : recyclerView.getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type com.transsion.search_pugc.widget.LinesFlexBoxLayoutManager");
            ((LinesFlexBoxLayoutManager) layoutManager).p0();
            this.expand = false;
            expandHistoryLine(false);
            getSearchReporter().m();
        }
    }
}
