package com.transsnet.downloader.ugc.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.view.v0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.StateView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.home.p004enum.BottomTabType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCContentList;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.ugc.adapter.UGCDownloadStaggeredAdapter;
import com.transsnet.downloader.ugc.adapter.c;
import com.transsnet.downloader.ugc.fragment.UGCDownloadedAppFragment;
import com.transsnet.downloader.ugc.viewmodel.UGCForYouViewModel;
import com.transsnet.downloader.ugc.widget.UGCForyouLoadMoreView;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.widget.UGCSecondTabTitleView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00027;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J1\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\u0004J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J!\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\u00052\u0006\u00101\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b4\u00103J\u000f\u00105\u001a\u00020\u0005H\u0016¢\u0006\u0004\b5\u0010\u0004J\u000f\u00106\u001a\u00020\u0005H\u0016¢\u0006\u0004\b6\u0010\u0004R\u0014\u00109\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010?\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010<\u001a\u0004\bG\u0010HR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u00108R\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010`R\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006k"}, d2 = {"Lcom/transsnet/downloader/ugc/fragment/UGCDownloadedAppFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lpy/p0;", "<init>", "()V", "", "t0", "initViewModel", "E0", "m0", "D0", "C0", "", "p0", "()Ljava/lang/String;", "B0", "", "hasMore", "", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "videos", "isFromCache", "F0", "(ZLjava/util/List;Z)V", "video", "", RequestParameters.POSITION, "A0", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;I)V", "Landroidx/recyclerview/widget/RecyclerView$l;", "l0", "()Landroidx/recyclerview/widget/RecyclerView$l;", "newTabs", "I0", "(Ljava/util/List;)V", "J0", "x0", "isShowTitleLayout", "Landroid/view/View;", "getEmptyView", "(Z)Landroid/view/View;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "s0", "(Landroid/view/LayoutInflater;)Lpy/p0;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "initListener", "lazyLoadData", "a", "Ljava/lang/String;", "TAG", "Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "n0", "()Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "downloadViewModel", "Lcom/transsnet/downloader/ugc/viewmodel/UGCForYouViewModel;", "c", "r0", "()Lcom/transsnet/downloader/ugc/viewmodel/UGCForYouViewModel;", "forYouViewModel", "Lcom/transsnet/downloader/ugc/viewmodel/b;", "d", "q0", "()Lcom/transsnet/downloader/ugc/viewmodel/b;", "forYouCacheViewModel", "", "e", "Ljava/util/List;", "subTabList", "f", "I", "selectTabIndex", be.g.f16474b, "subTabTitleArg", "Lcom/transsion/baseui/widget/magicindicator/ORCommonNavigator;", "h", "Lcom/transsion/baseui/widget/magicindicator/ORCommonNavigator;", "commonNavigator", "Lcom/transsnet/downloader/ugc/fragment/UGCDownloadedAppFragment$b;", "i", "Lcom/transsnet/downloader/ugc/fragment/UGCDownloadedAppFragment$b;", "commonNavigatorAdapter", "Lcom/transsnet/downloader/ugc/adapter/UGCDownloadStaggeredAdapter;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsnet/downloader/ugc/adapter/UGCDownloadStaggeredAdapter;", "emptyForYouAdapter", CampaignEx.JSON_KEY_AD_K, "Z", "forYouRequested", "l", "isLoadingForYou", "m", "isShowingEmpty", "Lcom/transsnet/downloader/ugc/fragment/UGCDownloadedListFragment;", "n", "Lcom/transsnet/downloader/ugc/fragment/UGCDownloadedListFragment;", "allOnlyFragment", "o", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class UGCDownloadedAppFragment extends BaseFragment<py.p0> {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "UGCDownloadedAppFragment";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(DownloadViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.ugc.fragment.UGCDownloadedAppFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.ugc.fragment.UGCDownloadedAppFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy forYouViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy forYouCacheViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List subTabList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int selectTabIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String subTabTitleArg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ORCommonNavigator commonNavigator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b commonNavigatorAdapter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private UGCDownloadStaggeredAdapter emptyForYouAdapter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean forYouRequested;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadingForYou;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isShowingEmpty;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private UGCDownloadedListFragment allOnlyFragment;

    /* renamed from: com.transsnet.downloader.ugc.fragment.UGCDownloadedAppFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCDownloadedAppFragment a(String str) {
            UGCDownloadedAppFragment uGCDownloadedAppFragment = new UGCDownloadedAppFragment();
            uGCDownloadedAppFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("arg_sub_tab_title", str)));
            return uGCDownloadedAppFragment;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends ik.a {

        /* renamed from: b, reason: collision with root package name */
        private final ViewPager2 f59839b;

        /* renamed from: c, reason: collision with root package name */
        private final List f59840c;

        public b(ViewPager2 viewPager2, List tabList) {
            Intrinsics.h(tabList, "tabList");
            this.f59839b = viewPager2;
            this.f59840c = tabList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(b bVar, int i11, View view) {
            ViewPager2 viewPager2 = bVar.f59839b;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i11, true);
            }
        }

        @Override // j00.a
        public int a() {
            return this.f59840c.size();
        }

        @Override // j00.a
        public j00.c b(Context context) {
            Intrinsics.h(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(0, 0, 0);
            return linePagerIndicator;
        }

        @Override // j00.a
        public j00.d c(Context context, final int i11) {
            Intrinsics.h(context, "context");
            UGCSecondTabTitleView uGCSecondTabTitleView = new UGCSecondTabTitleView(context);
            uGCSecondTabTitleView.setTitle((String) this.f59840c.get(i11));
            uGCSecondTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.ugc.fragment.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UGCDownloadedAppFragment.b.j(UGCDownloadedAppFragment.b.this, i11, view);
                }
            });
            return uGCSecondTabTitleView;
        }

        @Override // ik.a
        public LinearLayout.LayoutParams h(Context context, int i11) {
            int i12;
            Intrinsics.h(context, "context");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int b11 = dk.a.b(4);
            int i13 = 0;
            if (i11 == 0) {
                i13 = b11 * 3;
                i12 = 0;
            } else {
                i12 = i11 == this.f59840c.size() + (-1) ? b11 * 3 : 0;
            }
            layoutParams.setMarginStart(i13);
            layoutParams.setMarginEnd(i12);
            return layoutParams;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends RecyclerView.l {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter;
            com.transsnet.downloader.ugc.adapter.c cVar;
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == -1 || (uGCDownloadStaggeredAdapter = UGCDownloadedAppFragment.this.emptyForYouAdapter) == null || (cVar = (com.transsnet.downloader.ugc.adapter.c) uGCDownloadStaggeredAdapter.f0(childAdapterPosition)) == null || !(cVar instanceof c.e)) {
                return;
            }
            RecyclerView.m layoutManager = parent.getLayoutManager();
            if ((layoutManager instanceof StaggeredGridLayoutManager ? (StaggeredGridLayoutManager) layoutManager : null) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            StaggeredGridLayoutManager.b bVar = layoutParams instanceof StaggeredGridLayoutManager.b ? (StaggeredGridLayoutManager.b) layoutParams : null;
            if (bVar == null) {
                return;
            }
            int a11 = bVar.a();
            int b11 = dk.a.b(12);
            int b12 = dk.a.b(8);
            if (a11 == 0) {
                outRect.left = b11;
                outRect.right = b12 / 2;
            } else if (a11 == 1) {
                outRect.left = b12 / 2;
                outRect.right = b11;
            }
            outRect.bottom = dk.a.b(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59842a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59842a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59842a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59842a.invoke(obj);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends ViewPager2.OnPageChangeCallback {
        e() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i11);
            py.p0 mViewBinding = UGCDownloadedAppFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f73003d) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            py.p0 mViewBinding = UGCDownloadedAppFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f73003d) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            MagicIndicator magicIndicator;
            super.onPageSelected(i11);
            py.p0 mViewBinding = UGCDownloadedAppFragment.this.getMViewBinding();
            if (mViewBinding != null && (magicIndicator = mViewBinding.f73003d) != null) {
                magicIndicator.onPageSelected(i11);
            }
            UGCDownloadedAppFragment.this.selectTabIndex = i11;
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends FragmentStateAdapter {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f59845b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(UGCDownloadedAppFragment.this);
            this.f59845b = str;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            String str = (String) CollectionsKt.l0(UGCDownloadedAppFragment.this.subTabList, i11);
            if (str == null) {
                str = "";
            }
            if (Intrinsics.c(str, this.f59845b)) {
                str = "TAB_ALL";
            }
            return UGCDownloadedListFragment.INSTANCE.a(str);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UGCDownloadedAppFragment.this.subTabList.size();
        }
    }

    public UGCDownloadedAppFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsnet.downloader.ugc.fragment.UGCDownloadedAppFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.forYouViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(UGCForYouViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.ugc.fragment.UGCDownloadedAppFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsnet.downloader.ugc.fragment.UGCDownloadedAppFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object invoke = Function0.this.invoke();
                androidx.view.m mVar = invoke instanceof androidx.view.m ? (androidx.view.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.forYouCacheViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsnet.downloader.ugc.viewmodel.b.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.ugc.fragment.UGCDownloadedAppFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
                Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsnet.downloader.ugc.fragment.UGCDownloadedAppFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.subTabList = new ArrayList();
    }

    private final void A0(UGCVideo video, int position) {
        String ugcVideoId = video.getUgcVideoId();
        if (ugcVideoId == null || ugcVideoId.length() == 0) {
            return;
        }
        pv.b.b(video, null, 1, null);
        com.transsnet.downloader.ugc.util.e.f59970a.b("ugc_downloaded_app", video, position);
    }

    private final void B0() {
        String p02 = p0();
        if (!q0().d(p02)) {
            if (!this.forYouRequested && r0().h().f() == null && nh.m.f70597a.e()) {
                this.forYouRequested = true;
                this.isLoadingForYou = true;
                r0().g(true);
                return;
            }
            return;
        }
        a.C0856a.f(lg.a.f68962a, this.TAG, "requestForYouIfNeeded: use cached data, cacheKey=" + p02 + ", size=" + q0().c(p02).size(), false, 4, null);
        F0(q0().e(p02), q0().c(p02), true);
        this.forYouRequested = true;
    }

    private final void C0() {
        RecyclerView recyclerView;
        FrameLayout frameLayout;
        CoordinatorLayout coordinatorLayout;
        a.C0856a.f(lg.a.f68962a, this.TAG, "showAllOnly", false, 4, null);
        this.isShowingEmpty = false;
        py.p0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (coordinatorLayout = mViewBinding.f73002c) != null) {
            jg.c.g(coordinatorLayout);
        }
        py.p0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (frameLayout = mViewBinding2.f73001b) != null) {
            jg.c.k(frameLayout);
        }
        py.p0 mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (recyclerView = mViewBinding3.f73004e) != null) {
            jg.c.g(recyclerView);
        }
        if (this.allOnlyFragment == null) {
            this.allOnlyFragment = UGCDownloadedListFragment.INSTANCE.a("TAB_ALL");
            androidx.fragment.app.w p11 = getChildFragmentManager().p();
            int i11 = R$id.fl_all_only;
            UGCDownloadedListFragment uGCDownloadedListFragment = this.allOnlyFragment;
            Intrinsics.e(uGCDownloadedListFragment);
            p11.s(i11, uGCDownloadedListFragment).j();
        }
    }

    private final void D0() {
        RecyclerView recyclerView;
        FrameLayout frameLayout;
        CoordinatorLayout coordinatorLayout;
        this.isShowingEmpty = false;
        py.p0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (coordinatorLayout = mViewBinding.f73002c) != null) {
            jg.c.k(coordinatorLayout);
        }
        py.p0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (frameLayout = mViewBinding2.f73001b) != null) {
            jg.c.g(frameLayout);
        }
        py.p0 mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (recyclerView = mViewBinding3.f73004e) == null) {
            return;
        }
        jg.c.g(recyclerView);
    }

    private final void E0() {
        RecyclerView recyclerView;
        FrameLayout frameLayout;
        CoordinatorLayout coordinatorLayout;
        a.C0856a.f(lg.a.f68962a, this.TAG, "showEmptyState, isShowingEmpty:" + this.isShowingEmpty, false, 4, null);
        this.isShowingEmpty = true;
        py.p0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (coordinatorLayout = mViewBinding.f73002c) != null) {
            jg.c.g(coordinatorLayout);
        }
        py.p0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (frameLayout = mViewBinding2.f73001b) != null) {
            jg.c.g(frameLayout);
        }
        py.p0 mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (recyclerView = mViewBinding3.f73004e) != null) {
            jg.c.k(recyclerView);
        }
        m0();
        B0();
    }

    private final void F0(boolean hasMore, List videos, boolean isFromCache) {
        List arrayList;
        boolean z10;
        r6.f h02;
        r6.f h03;
        r6.f h04;
        r6.f h05;
        List<Object> data;
        this.isLoadingForYou = false;
        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter = this.emptyForYouAdapter;
        if (uGCDownloadStaggeredAdapter == null || (data = uGCDownloadStaggeredAdapter.getData()) == null || (arrayList = CollectionsKt.U0(data)) == null) {
            arrayList = new ArrayList();
        }
        if (isFromCache) {
            CollectionsKt.I(arrayList, new Function1() { // from class: com.transsnet.downloader.ugc.fragment.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean H0;
                    H0 = UGCDownloadedAppFragment.H0((com.transsnet.downloader.ugc.adapter.c) obj);
                    return Boolean.valueOf(H0);
                }
            });
        }
        List<com.transsnet.downloader.ugc.adapter.c> list = arrayList;
        boolean z11 = list instanceof Collection;
        if (!z11 || !list.isEmpty()) {
            for (com.transsnet.downloader.ugc.adapter.c cVar : list) {
                if ((cVar instanceof c.e) || (cVar instanceof c.f)) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.TAG, "updateForYouList: hasExistingForYou：" + z10 + "， size:" + (videos != null ? Integer.valueOf(videos.size()) : null) + ", isFromCache:" + isFromCache, false, 4, null);
        List list2 = videos;
        if (list2 == null || list2.isEmpty()) {
            a.C0856a.z(c0856a, this.TAG, "foryou list is empty, hasExistingForYou:" + z10 + ", hasMore:" + hasMore, false, 4, null);
            if (hasMore) {
                UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter2 = this.emptyForYouAdapter;
                if (uGCDownloadStaggeredAdapter2 == null || (h03 = uGCDownloadStaggeredAdapter2.h0()) == null) {
                    return;
                }
                h03.v();
                return;
            }
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter3 = this.emptyForYouAdapter;
            if (uGCDownloadStaggeredAdapter3 == null || (h02 = uGCDownloadStaggeredAdapter3.h0()) == null) {
                return;
            }
            r6.f.u(h02, false, 1, null);
            return;
        }
        if (z10) {
            if (!z11 || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((com.transsnet.downloader.ugc.adapter.c) it.next()) instanceof c.d) {
                        break;
                    }
                }
            }
            arrayList.add(0, c.d.f59740a);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof c.e) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String ugcVideoId = ((c.e) it2.next()).a().getUgcVideoId();
                if (ugcVideoId != null) {
                    arrayList3.add(ugcVideoId);
                }
            }
            Set W0 = CollectionsKt.W0(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : videos) {
                UGCVideo uGCVideo = (UGCVideo) obj2;
                String ugcVideoId2 = uGCVideo.getUgcVideoId();
                if (ugcVideoId2 != null && ugcVideoId2.length() != 0 && !CollectionsKt.b0(W0, uGCVideo.getUgcVideoId())) {
                    arrayList4.add(obj2);
                }
            }
            if (arrayList4.isEmpty()) {
                a.C0856a.z(lg.a.f68962a, this.TAG, "updateForYouList: 所有视频都已存在，跳过添加", false, 4, null);
            } else {
                a.C0856a.f(lg.a.f68962a, this.TAG, "updateForYouList: 过滤后新增 " + arrayList4.size() + " 个视频（原始 " + videos.size() + " 个）", false, 4, null);
                Iterator it3 = arrayList4.iterator();
                while (it3.hasNext()) {
                    arrayList.add(new c.e((UGCVideo) it3.next()));
                }
            }
        } else {
            if (!z11 || !list.isEmpty()) {
                Iterator it4 = list.iterator();
                while (it4.hasNext()) {
                    if (((com.transsnet.downloader.ugc.adapter.c) it4.next()) instanceof c.d) {
                        break;
                    }
                }
            }
            arrayList.add(0, c.d.f59740a);
            arrayList.add(c.f.f59742a);
            Iterator it5 = videos.iterator();
            while (it5.hasNext()) {
                arrayList.add(new c.e((UGCVideo) it5.next()));
            }
        }
        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter4 = this.emptyForYouAdapter;
        if (uGCDownloadStaggeredAdapter4 != null) {
            uGCDownloadStaggeredAdapter4.n1(arrayList);
        }
        if (hasMore) {
            UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter5 = this.emptyForYouAdapter;
            if (uGCDownloadStaggeredAdapter5 == null || (h05 = uGCDownloadStaggeredAdapter5.h0()) == null) {
                return;
            }
            h05.s();
            return;
        }
        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter6 = this.emptyForYouAdapter;
        if (uGCDownloadStaggeredAdapter6 == null || (h04 = uGCDownloadStaggeredAdapter6.h0()) == null) {
            return;
        }
        r6.f.u(h04, false, 1, null);
    }

    static /* synthetic */ void G0(UGCDownloadedAppFragment uGCDownloadedAppFragment, boolean z10, List list, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        uGCDownloadedAppFragment.F0(z10, list, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H0(com.transsnet.downloader.ugc.adapter.c it) {
        Intrinsics.h(it, "it");
        return (it instanceof c.e) || (it instanceof c.f);
    }

    private final void I0(List newTabs) {
        int i11;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.TAG, "updateSubTabs: newTabs=" + newTabs + ", current subTabList=" + this.subTabList + ", subTabTitleArg=" + this.subTabTitleArg, false, 4, null);
        if (Intrinsics.c(this.subTabList, newTabs)) {
            a.C0856a.f(c0856a, this.TAG, "updateSubTabs: tabs unchanged, skip update", false, 4, null);
            return;
        }
        this.subTabList.clear();
        this.subTabList.addAll(newTabs);
        String str = this.subTabTitleArg;
        if (str != null && str.length() != 0) {
            Iterator it = newTabs.iterator();
            int i12 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i12 = -1;
                    break;
                } else if (Intrinsics.c((String) it.next(), this.subTabTitleArg)) {
                    break;
                } else {
                    i12++;
                }
            }
            Integer valueOf = Integer.valueOf(i12);
            if (valueOf.intValue() < 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                i11 = valueOf.intValue();
                this.selectTabIndex = RangesKt.m(i11, 0, RangesKt.f(this.subTabList.size() - 1, 0));
                J0();
            }
        }
        i11 = 0;
        this.selectTabIndex = RangesKt.m(i11, 0, RangesKt.f(this.subTabList.size() - 1, 0));
        J0();
    }

    private final void J0() {
        MagicIndicator magicIndicator;
        ViewPager2 viewPager2;
        a.C0856a.f(lg.a.f68962a, this.TAG, "updateViewPagerAndIndicator: selectTabIndex=" + this.selectTabIndex + ", subTabList=" + this.subTabList, false, 4, null);
        String string = Utils.a().getString(R$string.ugc_all);
        Intrinsics.g(string, "getString(...)");
        f fVar = new f(string);
        py.p0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (viewPager2 = mViewBinding.f73006g) != null) {
            viewPager2.setAdapter(fVar);
            int m11 = RangesKt.m(this.selectTabIndex, 0, this.subTabList.size() - 1);
            if (m11 != this.selectTabIndex) {
                this.selectTabIndex = m11;
            }
            viewPager2.registerOnPageChangeCallback(new e());
            viewPager2.setCurrentItem(this.selectTabIndex, false);
        }
        py.p0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (magicIndicator = mViewBinding2.f73003d) != null) {
            magicIndicator.post(new Runnable() { // from class: com.transsnet.downloader.ugc.fragment.s
                @Override // java.lang.Runnable
                public final void run() {
                    UGCDownloadedAppFragment.K0(UGCDownloadedAppFragment.this);
                }
            });
        }
        x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(UGCDownloadedAppFragment uGCDownloadedAppFragment) {
        MagicIndicator magicIndicator;
        py.p0 mViewBinding = uGCDownloadedAppFragment.getMViewBinding();
        if (mViewBinding == null || (magicIndicator = mViewBinding.f73003d) == null) {
            return;
        }
        magicIndicator.onPageSelected(uGCDownloadedAppFragment.selectTabIndex);
    }

    private final View getEmptyView(boolean isShowTitleLayout) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        String string = Utils.a().getString(R$string.download_no_historical_tips);
        Intrinsics.g(string, "getString(...)");
        stateView.showData(4, 6, false, "", string);
        String string2 = Utils.a().getString(R$string.download_empty_find_free_source);
        Intrinsics.g(string2, "getString(...)");
        stateView.setReTryTxt(string2);
        stateView.retry(new Function0() { // from class: com.transsnet.downloader.ugc.fragment.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit o02;
                o02 = UGCDownloadedAppFragment.o0(UGCDownloadedAppFragment.this);
                return o02;
            }
        });
        return stateView;
    }

    private final void initViewModel() {
        n0().L().j(this, new d(new Function1() { // from class: com.transsnet.downloader.ugc.fragment.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z02;
                z02 = UGCDownloadedAppFragment.z0(UGCDownloadedAppFragment.this, (Map) obj);
                return z02;
            }
        }));
        r0().h().j(this, new d(new Function1() { // from class: com.transsnet.downloader.ugc.fragment.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y02;
                y02 = UGCDownloadedAppFragment.y0(UGCDownloadedAppFragment.this, (UGCContentList) obj);
                return y02;
            }
        }));
    }

    private final RecyclerView.l l0() {
        return new c();
    }

    private final void m0() {
        List arrayList;
        boolean z10;
        List<Object> data;
        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter = this.emptyForYouAdapter;
        if (uGCDownloadStaggeredAdapter == null || (data = uGCDownloadStaggeredAdapter.getData()) == null || (arrayList = CollectionsKt.U0(data)) == null) {
            arrayList = new ArrayList();
        }
        List list = arrayList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((com.transsnet.downloader.ugc.adapter.c) it.next()) instanceof c.d) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        a.C0856a.f(lg.a.f68962a, this.TAG, "ensureEmptyItemExists: hasEmptyItem=" + z10 + ", currentListSize=" + arrayList.size(), false, 4, null);
        if (z10) {
            return;
        }
        arrayList.add(0, c.d.f59740a);
        UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter2 = this.emptyForYouAdapter;
        if (uGCDownloadStaggeredAdapter2 != null) {
            uGCDownloadStaggeredAdapter2.n1(arrayList);
        }
    }

    private final DownloadViewModel n0() {
        return (DownloadViewModel) this.downloadViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(UGCDownloadedAppFragment uGCDownloadedAppFragment) {
        Navigator.x(TheRouter.c("/main/tab").K("bottomTab", BottomTabType.TAB_CODE_HOME), uGCDownloadedAppFragment.requireContext(), null, 2, null);
        return Unit.f67184a;
    }

    private final String p0() {
        return "UGCDownloadedAppFragment";
    }

    private final com.transsnet.downloader.ugc.viewmodel.b q0() {
        return (com.transsnet.downloader.ugc.viewmodel.b) this.forYouCacheViewModel.getValue();
    }

    private final UGCForYouViewModel r0() {
        return (UGCForYouViewModel) this.forYouViewModel.getValue();
    }

    private final void t0() {
        RecyclerView recyclerView;
        final UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter = new UGCDownloadStaggeredAdapter(new Function0() { // from class: com.transsnet.downloader.ugc.fragment.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View u02;
                u02 = UGCDownloadedAppFragment.u0(UGCDownloadedAppFragment.this);
                return u02;
            }
        });
        uGCDownloadStaggeredAdapter.w1(new p6.d() { // from class: com.transsnet.downloader.ugc.fragment.m
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCDownloadedAppFragment.v0(UGCDownloadedAppFragment.this, baseQuickAdapter, view, i11);
            }
        });
        uGCDownloadStaggeredAdapter.h0().z(true);
        uGCDownloadStaggeredAdapter.h0().y(true);
        uGCDownloadStaggeredAdapter.h0().E(3);
        uGCDownloadStaggeredAdapter.h0().C(new UGCForyouLoadMoreView());
        uGCDownloadStaggeredAdapter.h0().D(new p6.f() { // from class: com.transsnet.downloader.ugc.fragment.n
            @Override // p6.f
            public final void a() {
                UGCDownloadedAppFragment.w0(UGCDownloadedAppFragment.this, uGCDownloadStaggeredAdapter);
            }
        });
        this.emptyForYouAdapter = uGCDownloadStaggeredAdapter;
        py.p0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f73004e) == null) {
            return;
        }
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        recyclerView.setAdapter(this.emptyForYouAdapter);
        recyclerView.addItemDecoration(l0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View u0(UGCDownloadedAppFragment uGCDownloadedAppFragment) {
        return uGCDownloadedAppFragment.getEmptyView(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(UGCDownloadedAppFragment uGCDownloadedAppFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = adapter.getItem(i11);
        com.transsnet.downloader.ugc.adapter.c cVar = item instanceof com.transsnet.downloader.ugc.adapter.c ? (com.transsnet.downloader.ugc.adapter.c) item : null;
        if (cVar != null && (cVar instanceof c.e)) {
            uGCDownloadedAppFragment.A0(((c.e) cVar).a(), i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(UGCDownloadedAppFragment uGCDownloadedAppFragment, UGCDownloadStaggeredAdapter uGCDownloadStaggeredAdapter) {
        String i11;
        if (uGCDownloadedAppFragment.isLoadingForYou) {
            a.C0856a.f(lg.a.f68962a, uGCDownloadedAppFragment.TAG, "foryou loadmore--- isLoadingForYou, skip", false, 4, null);
            return;
        }
        if (!nh.m.f70597a.e()) {
            r6.f.u(uGCDownloadStaggeredAdapter.h0(), false, 1, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, uGCDownloadedAppFragment.TAG, "foryou loadmore---", false, 4, null);
        uGCDownloadedAppFragment.isLoadingForYou = true;
        String b11 = uGCDownloadedAppFragment.q0().b(uGCDownloadedAppFragment.p0());
        if (b11 != null && b11.length() > 0 && ((i11 = uGCDownloadedAppFragment.r0().i()) == null || i11.length() == 0)) {
            uGCDownloadedAppFragment.r0().k(b11);
        }
        uGCDownloadedAppFragment.r0().g(false);
    }

    private final void x0() {
        MagicIndicator magicIndicator;
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(requireContext());
        oRCommonNavigator.setFollowTouch(true);
        a.C0856a.f(lg.a.f68962a, this.TAG, "initNavigator: subTabList=" + this.subTabList, false, 4, null);
        py.p0 mViewBinding = getMViewBinding();
        b bVar = new b(mViewBinding != null ? mViewBinding.f73006g : null, this.subTabList);
        this.commonNavigatorAdapter = bVar;
        oRCommonNavigator.setAdapter(bVar);
        this.commonNavigator = oRCommonNavigator;
        py.p0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (magicIndicator = mViewBinding2.f73003d) == null) {
            return;
        }
        magicIndicator.setNavigator(this.commonNavigator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(UGCDownloadedAppFragment uGCDownloadedAppFragment, UGCContentList uGCContentList) {
        List l11;
        Pager pager;
        Pager pager2;
        Boolean hasMore;
        List<UGCContent> items;
        if (!uGCDownloadedAppFragment.isShowingEmpty) {
            return Unit.f67184a;
        }
        if (uGCContentList == null || (items = uGCContentList.getItems()) == null) {
            l11 = CollectionsKt.l();
        } else {
            l11 = new ArrayList();
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                UGCVideo video = ((UGCContent) it.next()).getVideo();
                if (video != null) {
                    l11.add(video);
                }
            }
        }
        List list = l11;
        boolean booleanValue = (uGCContentList == null || (pager2 = uGCContentList.getPager()) == null || (hasMore = pager2.getHasMore()) == null) ? true : hasMore.booleanValue();
        String nextPage = (uGCContentList == null || (pager = uGCContentList.getPager()) == null) ? null : pager.getNextPage();
        String p02 = uGCDownloadedAppFragment.p0();
        if (uGCDownloadedAppFragment.forYouRequested && uGCContentList != null) {
            if (uGCDownloadedAppFragment.q0().d(p02)) {
                uGCDownloadedAppFragment.q0().f(p02, list, nextPage, booleanValue);
            } else {
                uGCDownloadedAppFragment.q0().g(p02, list, nextPage, booleanValue);
            }
        }
        G0(uGCDownloadedAppFragment, booleanValue, list, false, 4, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(UGCDownloadedAppFragment uGCDownloadedAppFragment, Map map) {
        if (map == null || map.isEmpty()) {
            uGCDownloadedAppFragment.E0();
            return Unit.f67184a;
        }
        List U0 = CollectionsKt.U0(map.keySet());
        if (U0.isEmpty()) {
            uGCDownloadedAppFragment.E0();
            return Unit.f67184a;
        }
        String string = Utils.a().getString(R$string.ugc_all);
        Intrinsics.g(string, "getString(...)");
        List q11 = CollectionsKt.q(string);
        q11.addAll(U0);
        a.C0856a.f(lg.a.f68962a, uGCDownloadedAppFragment.TAG, "initViewModel: fullTabs=" + q11 + ", size=" + q11.size(), false, 4, null);
        if (q11.size() <= 2) {
            uGCDownloadedAppFragment.C0();
        } else {
            uGCDownloadedAppFragment.D0();
            uGCDownloadedAppFragment.I0(q11);
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        initViewModel();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        t0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.subTabTitleArg = arguments.getString("arg_sub_tab_title");
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public py.p0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.p0 c11 = py.p0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
