package com.transsion.home.fragment.tab;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.home.activity.OperateActivity;
import com.transsion.home.adapter.suboperate.SubTabAdapter;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.SubOperateData;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.fragment.bottom.BottomOpFragment;
import com.transsion.home.fragment.home.HomeFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.home.viewmodel.HomePreferencesViewModel;
import com.transsion.home.viewmodel.SubTabViewModel;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberRemindData;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lg.a;
import nh.n;

@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\b\u0007*\u0001m\b\u0007\u0018\u0000 q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J!\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\u0004J!\u0010*\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b*\u0010(J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\u0004J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\r\u00104\u001a\u000203¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u000203H\u0016¢\u0006\u0004\b6\u00105J\u000f\u00107\u001a\u00020\u0005H\u0016¢\u0006\u0004\b7\u0010\u0004J\u0011\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010>\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001b\u0010M\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR$\u0010X\u001a\u0010\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u0005\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR$\u0010]\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002030Z\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010PR\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010PR\u0016\u0010j\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010PR,\u0010l\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00050U\u0012\u0004\u0012\u00020\u00050U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010WR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006s"}, d2 = {"Lcom/transsion/home/fragment/tab/SubTabFragment;", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "Lgl/y;", "<init>", "()V", "", "m0", "", "Y0", "()I", "v1", "j1", "U0", "", "alpha", "A1", "(F)V", "X0", "()F", "t1", "B1", "Landroid/view/View;", "getNoNetworkView", "()Landroid/view/View;", "V0", "p1", "Lcom/transsion/memberapi/MemberRemindData;", "remindData", "s1", "(Lcom/transsion/memberapi/MemberRemindData;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "c1", "(Landroid/view/LayoutInflater;)Lgl/y;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "p0", "initData", "onResume", "onDestroyView", "startLoading", "hideLoading", "lazyLoadData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "", "getPageName", "()Ljava/lang/String;", "g0", "c0", "Landroidx/recyclerview/widget/RecyclerView;", "f0", "()Landroidx/recyclerview/widget/RecyclerView;", "lastAdPosition", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "wrapperNativeManager", "l0", "(ILcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "Lcom/transsion/home/viewmodel/SubTabViewModel;", be.g.f16474b, "Lcom/transsion/home/viewmodel/SubTabViewModel;", "mViewModel", "Lcom/transsion/home/adapter/suboperate/SubTabAdapter;", "h", "Lcom/transsion/home/adapter/suboperate/SubTabAdapter;", "mMainAdapter", "Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "i", "Lkotlin/Lazy;", "Z0", "()Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "homePreferencesViewModel", "", com.mbridge.msdk.foundation.same.report.j.f35620b, "Z", "mHasTranslateWindow", CampaignEx.JSON_KEY_AD_K, "I", "mHeaderBgHeight", "Lkotlin/Function1;", "l", "Lkotlin/jvm/functions/Function1;", "mPermissionCallback", "Landroidx/activity/result/b;", "", "m", "Landroidx/activity/result/b;", "mLauncher", "n", "mIsFirstRender", "", "o", "J", "loadStartTime", TtmlNode.TAG_P, "Landroid/view/View;", "mNoNetworkView", CampaignEx.JSON_KEY_AD_Q, "isUGCMode", CampaignEx.JSON_KEY_AD_R, "isViewInitialized", "s", "mOnAppointmentClick", "com/transsion/home/fragment/tab/SubTabFragment$d", "t", "Lcom/transsion/home/fragment/tab/SubTabFragment$d;", "mRecycleScrollListener", TmcStartParams.KEY_URL_SHORT, "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class SubTabFragment extends BaseHomeSubFragment<gl.y> {

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: v, reason: collision with root package name */
    public static final int f45370v = 8;

    /* renamed from: w, reason: collision with root package name */
    private static final Map f45371w;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private SubTabViewModel mViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SubTabAdapter mMainAdapter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean mHasTranslateWindow;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int mHeaderBgHeight;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Function1 mPermissionCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private androidx.activity.result.b mLauncher;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private View mNoNetworkView;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean isViewInitialized;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy homePreferencesViewModel = LazyKt.b(new Function0() { // from class: com.transsion.home.fragment.tab.p0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HomePreferencesViewModel d12;
            d12 = SubTabFragment.d1(SubTabFragment.this);
            return d12;
        }
    });

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFirstRender = true;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long loadStartTime = -1;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final boolean isUGCMode = ak.g.f714a.b();

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Function1 mOnAppointmentClick = new Function1() { // from class: com.transsion.home.fragment.tab.q0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit u12;
            u12 = SubTabFragment.u1(SubTabFragment.this, (Function1) obj);
            return u12;
        }
    };

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final d mRecycleScrollListener = new d();

    /* renamed from: com.transsion.home.fragment.tab.SubTabFragment$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int i11) {
            String str = (String) SubTabFragment.f45371w.get(Integer.valueOf(i11));
            return str == null ? "home_sub_operate" : str;
        }

        public final SubTabFragment b(int i11, String str) {
            if (!SubTabFragment.f45371w.containsKey(Integer.valueOf(i11)) && str != null) {
                SubTabFragment.f45371w.put(Integer.valueOf(i11), str);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i11);
            bundle.putString(WebConstants.TAB_CODE, str);
            SubTabFragment subTabFragment = new SubTabFragment();
            subTabFragment.setArguments(bundle);
            return subTabFragment;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends DiffUtil.e {
        b() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(OperateItem oldItem, OperateItem newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            Subject feedsSubject = oldItem.getFeedsSubject();
            String subjectId = feedsSubject != null ? feedsSubject.getSubjectId() : null;
            Subject feedsSubject2 = newItem.getFeedsSubject();
            return Intrinsics.c(subjectId, feedsSubject2 != null ? feedsSubject2.getSubjectId() : null);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(OperateItem oldItem, OperateItem newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            Subject feedsSubject = oldItem.getFeedsSubject();
            Integer subjectType = feedsSubject != null ? feedsSubject.getSubjectType() : null;
            Subject feedsSubject2 = newItem.getFeedsSubject();
            return Intrinsics.c(subjectType, feedsSubject2 != null ? feedsSubject2.getSubjectType() : null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends GridLayoutManager.c {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f45387f;

        c(int i11) {
            this.f45387f = i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            SubTabAdapter subTabAdapter = SubTabFragment.this.mMainAdapter;
            Integer valueOf = subTabAdapter != null ? Integer.valueOf(subTabAdapter.getItemViewType(i11)) : null;
            int ordinal = PostItemType.PREFERENCES.ordinal();
            if (valueOf != null && valueOf.intValue() == ordinal) {
                return this.f45387f;
            }
            int ordinal2 = PostItemType.SUBJECT.ordinal();
            if (valueOf == null || valueOf.intValue() != ordinal2) {
                int ordinal3 = PostItemType.SINGLE_SUBJECT.ordinal();
                if (valueOf == null || valueOf.intValue() != ordinal3) {
                    int ordinal4 = PostItemType.TRENDING_FEES_GRID.ordinal();
                    if (valueOf == null || valueOf.intValue() != ordinal4) {
                        return this.f45387f;
                    }
                }
            }
            return 1;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends RecyclerView.r {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.h(recyclerView, "recyclerView");
            if (SubTabFragment.this.mHasTranslateWindow) {
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                SubTabFragment.this.A1(RangesKt.h((computeVerticalScrollOffset * 1.0f) / r3.mHeaderBgHeight, 1.0f));
                if (!SubTabFragment.this.getMIsWhite() && SubTabFragment.this.X0() < 0.7f) {
                    SubTabFragment.this.b0(true);
                } else {
                    if (!SubTabFragment.this.getMIsWhite() || SubTabFragment.this.X0() < 0.7f) {
                        return;
                    }
                    SubTabFragment.this.b0(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements nh.n {
        e() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            SubTabAdapter subTabAdapter;
            List<Object> data;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (SubTabFragment.this.isResumed() && (subTabAdapter = SubTabFragment.this.mMainAdapter) != null && (data = subTabAdapter.getData()) != null && data.isEmpty()) {
                SubTabFragment.this.t1();
            }
        }

        @Override // nh.n
        public void onDisconnected() {
        }
    }

    /* loaded from: classes5.dex */
    static final class f implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f45390a;

        f(Function1 function) {
            Intrinsics.h(function, "function");
            this.f45390a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f45390a;
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
            this.f45390a.invoke(obj);
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(HomeTabId.Trending.getValue()), "Trending");
        linkedHashMap.put(Integer.valueOf(HomeTabId.UGC_Trending.getValue()), "UgcTrending");
        f45371w = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void A1(float alpha) {
        View view;
        gl.y yVar = (gl.y) getMViewBinding();
        if (yVar == null || (view = yVar.f63988b) == null) {
            return;
        }
        view.setAlpha(alpha);
    }

    private final void B1() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.e0
            @Override // java.lang.Runnable
            public final void run() {
                SubTabFragment.C1(SubTabFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void C1(SubTabFragment subTabFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (subTabFragment.isDetached() || !subTabFragment.isAdded() || subTabFragment.getContext() == null) {
            return;
        }
        View V0 = nh.m.f70597a.e() ? subTabFragment.V0() : subTabFragment.getNoNetworkView();
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter != null) {
            subTabAdapter.Y0(V0);
        }
        subTabFragment.U0();
        gl.y yVar = (gl.y) subTabFragment.getMViewBinding();
        if (yVar == null || (swipeRefreshLayout = yVar.f63992f) == null) {
            return;
        }
        swipeRefreshLayout.setEnabled(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U0() {
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout2;
        Guideline guideline;
        View view;
        SwipeRefreshLayout swipeRefreshLayout3;
        RecyclerView recyclerView2;
        SwipeRefreshLayout swipeRefreshLayout4;
        Guideline guideline2;
        Guideline guideline3;
        gl.y yVar = (gl.y) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (yVar == null || (guideline3 = yVar.f63990d) == null) ? null : guideline3.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        if (this.mHasTranslateWindow) {
            bVar.f7737a = 0;
            gl.y yVar2 = (gl.y) getMViewBinding();
            if (yVar2 != null && (guideline2 = yVar2.f63990d) != null) {
                guideline2.setLayoutParams(bVar);
            }
            gl.y yVar3 = (gl.y) getMViewBinding();
            if (yVar3 != null && (swipeRefreshLayout4 = yVar3.f63992f) != null) {
                swipeRefreshLayout4.invalidate();
            }
            A1(0.0f);
            b0(true);
            gl.y yVar4 = (gl.y) getMViewBinding();
            if (yVar4 != null && (recyclerView2 = yVar4.f63991e) != null) {
                recyclerView2.addOnScrollListener(this.mRecycleScrollListener);
            }
            gl.y yVar5 = (gl.y) getMViewBinding();
            if (yVar5 == null || (swipeRefreshLayout3 = yVar5.f63992f) == null) {
                return;
            }
            int i11 = this.mHeaderBgHeight;
            swipeRefreshLayout3.setProgressViewOffset(false, i11, com.blankj.utilcode.util.a0.a(50.0f) + i11);
            return;
        }
        gl.y yVar6 = (gl.y) getMViewBinding();
        int height = (yVar6 == null || (view = yVar6.f63988b) == null) ? 0 : view.getHeight();
        if (height <= 0) {
            height = this.mHeaderBgHeight;
        }
        bVar.f7737a = height;
        gl.y yVar7 = (gl.y) getMViewBinding();
        if (yVar7 != null && (guideline = yVar7.f63990d) != null) {
            guideline.setLayoutParams(bVar);
        }
        gl.y yVar8 = (gl.y) getMViewBinding();
        if (yVar8 != null && (swipeRefreshLayout2 = yVar8.f63992f) != null) {
            swipeRefreshLayout2.invalidate();
        }
        A1(1.0f);
        b0(false);
        gl.y yVar9 = (gl.y) getMViewBinding();
        if (yVar9 != null && (recyclerView = yVar9.f63991e) != null) {
            recyclerView.removeOnScrollListener(this.mRecycleScrollListener);
        }
        gl.y yVar10 = (gl.y) getMViewBinding();
        if (yVar10 == null || (swipeRefreshLayout = yVar10.f63992f) == null) {
            return;
        }
        swipeRefreshLayout.setProgressViewOffset(false, 0, com.blankj.utilcode.util.a0.a(50.0f));
    }

    private final View V0() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.showData(3, 1, false, "", "");
        stateView.retry(new Function0() { // from class: com.transsion.home.fragment.tab.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit W0;
                W0 = SubTabFragment.W0(SubTabFragment.this);
                return W0;
            }
        });
        return stateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(SubTabFragment subTabFragment) {
        subTabFragment.t1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float X0() {
        View view;
        gl.y yVar = (gl.y) getMViewBinding();
        if (yVar == null || (view = yVar.f63988b) == null) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int Y0() {
        View view;
        View view2;
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof HomeFragment) {
            return h0();
        }
        if (parentFragment instanceof BottomOpFragment) {
            Fragment parentFragment2 = getParentFragment();
            Intrinsics.f(parentFragment2, "null cannot be cast to non-null type com.transsion.home.fragment.bottom.BottomOpFragment");
            return ((BottomOpFragment) parentFragment2).c0();
        }
        if (!(getActivity() instanceof OperateActivity)) {
            gl.y yVar = (gl.y) getMViewBinding();
            if (yVar != null && (view = yVar.f63988b) != null) {
                jg.c.h(view);
            }
            return 1;
        }
        int color = androidx.core.content.b.getColor(requireContext(), R$color.bg_02);
        gl.y yVar2 = (gl.y) getMViewBinding();
        if (yVar2 != null && (view2 = yVar2.f63988b) != null) {
            view2.setBackgroundColor(color);
        }
        FragmentActivity activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type com.transsion.home.activity.OperateActivity");
        return ((OperateActivity) activity).e0();
    }

    private final HomePreferencesViewModel Z0() {
        return (HomePreferencesViewModel) this.homePreferencesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(NoNetworkBigView noNetworkBigView, SubTabFragment subTabFragment) {
        jg.c.g(noNetworkBigView);
        subTabFragment.t1();
        com.tn.lib.view.r.b(subTabFragment.getPageName());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(SubTabFragment subTabFragment) {
        com.tn.lib.view.r.c(subTabFragment.getPageName());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomePreferencesViewModel d1(SubTabFragment subTabFragment) {
        Fragment requireParentFragment = subTabFragment.requireParentFragment();
        Intrinsics.g(requireParentFragment, "requireParentFragment(...)");
        return (HomePreferencesViewModel) new androidx.view.v0(requireParentFragment).a(HomePreferencesViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit e1(SubTabFragment subTabFragment, SubOperateData subOperateData) {
        List arrayList;
        List<OperateItem> items;
        r6.f h02;
        SwipeRefreshLayout swipeRefreshLayout;
        gl.y yVar = (gl.y) subTabFragment.getMViewBinding();
        if (yVar != null && (swipeRefreshLayout = yVar.f63992f) != null) {
            swipeRefreshLayout.setEnabled(true);
        }
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter != null && (h02 = subTabAdapter.h0()) != null) {
            h02.z(true);
        }
        if (subOperateData == null || (items = subOperateData.getItems()) == null || (arrayList = CollectionsKt.U0(items)) == null) {
            arrayList = new ArrayList();
        }
        rl.h.c(arrayList, subOperateData != null ? subOperateData.getOps() : null);
        HomePreferencesUiHelperKt.f(subTabFragment.getMTabCode(), subTabFragment.Z0(), arrayList);
        SubTabAdapter subTabAdapter2 = subTabFragment.mMainAdapter;
        if (subTabAdapter2 != null) {
            subTabAdapter2.n1(arrayList);
        }
        subTabFragment.p1();
        String value = PostItemType.BANNER.getValue();
        OperateItem operateItem = (OperateItem) CollectionsKt.l0(arrayList, 0);
        subTabFragment.mHasTranslateWindow = Intrinsics.c(value, operateItem != null ? operateItem.getType() : null);
        if (subTabFragment.mIsFirstRender) {
            subTabFragment.U0();
            subTabFragment.mIsFirstRender = false;
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(SubTabFragment subTabFragment, Function1 function1, SubOperateData subOperateData) {
        HashMap g11;
        List<OperateItem> items;
        subTabFragment.hideLoading();
        boolean z10 = false;
        if (((subOperateData == null || (items = subOperateData.getItems()) == null) ? 0 : items.size()) <= 0) {
            subTabFragment.B1();
            return Unit.f67184a;
        }
        hj.b logViewConfig = subTabFragment.getLogViewConfig();
        if (logViewConfig != null && !logViewConfig.i()) {
            z10 = true;
        }
        if (z10) {
            hj.b logViewConfig2 = subTabFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.k(true);
            }
            hj.b logViewConfig3 = subTabFragment.getLogViewConfig();
            if (logViewConfig3 != null && (g11 = logViewConfig3.g()) != null) {
            }
        }
        function1.invoke(subOperateData);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(SubTabFragment subTabFragment, Function1 function1, SubOperateData subOperateData) {
        List<OperateItem> items;
        subTabFragment.hideLoading();
        if (((subOperateData == null || (items = subOperateData.getItems()) == null) ? 0 : items.size()) > 0) {
            subTabFragment.n0();
            function1.invoke(subOperateData);
        }
        return Unit.f67184a;
    }

    private final View getNoNetworkView() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        final NoNetworkBigView noNetworkBigView = new NoNetworkBigView(requireContext);
        noNetworkBigView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        NoNetworkBigView.showTitle$default(noNetworkBigView, false, null, 2, null);
        noNetworkBigView.retry(new Function0() { // from class: com.transsion.home.fragment.tab.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit a12;
                a12 = SubTabFragment.a1(NoNetworkBigView.this, this);
                return a12;
            }
        });
        noNetworkBigView.goToSetting(new Function0() { // from class: com.transsion.home.fragment.tab.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit b12;
                b12 = SubTabFragment.b1(SubTabFragment.this);
                return b12;
            }
        });
        com.tn.lib.view.r.a(getPageName());
        this.mNoNetworkView = noNetworkBigView;
        Intrinsics.e(noNetworkBigView);
        return noNetworkBigView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit h1(final SubTabFragment subTabFragment, TrendingRespData trendingRespData) {
        r6.f h02;
        r6.f h03;
        Pager pager;
        ConstraintLayout root;
        List<OperateItem> transferData;
        List<TrendingRespItem> items;
        if (((trendingRespData == null || (items = trendingRespData.getItems()) == null) ? 0 : items.size()) > 0) {
            SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
            if (subTabAdapter != null) {
                subTabAdapter.q((trendingRespData == null || (transferData = trendingRespData.getTransferData()) == null) ? new ArrayList<>() : transferData);
            }
            gl.y yVar = (gl.y) subTabFragment.getMViewBinding();
            if (yVar != null && (root = yVar.getRoot()) != null) {
                root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SubTabFragment.i1(SubTabFragment.this);
                    }
                }, 300L);
            }
        } else {
            if ((trendingRespData == null || (pager = trendingRespData.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.FALSE)) {
                SubTabAdapter subTabAdapter2 = subTabFragment.mMainAdapter;
                if (subTabAdapter2 != null && (h03 = subTabAdapter2.h0()) != null) {
                    r6.f.u(h03, false, 1, null);
                }
            } else {
                SubTabAdapter subTabAdapter3 = subTabFragment.mMainAdapter;
                if (subTabAdapter3 != null && (h02 = subTabAdapter3.h0()) != null) {
                    h02.v();
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(SubTabFragment subTabFragment) {
        r6.f h02;
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter == null || (h02 = subTabAdapter.h0()) == null) {
            return;
        }
        h02.s();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j1() {
        LinearLayoutManager linearLayoutManager;
        RecyclerView recyclerView;
        com.transsion.home.adapter.trending.provider.e preferencesProvider;
        RecyclerView recyclerView2;
        FragmentActivity activity;
        Function1 function1 = new Function1() { // from class: com.transsion.home.fragment.tab.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n12;
                n12 = SubTabFragment.n1(SubTabFragment.this, ((Integer) obj).intValue());
                return n12;
            }
        };
        FragmentActivity activity2 = getActivity();
        int i11 = (activity2 == null || !com.transsion.baseui.util.b.a(activity2)) ? 2 : com.blankj.utilcode.util.y.e() > com.blankj.utilcode.util.y.c() ? 4 : 3;
        ArrayList arrayList = new ArrayList();
        Function1 function12 = this.mOnAppointmentClick;
        int mTabId = getMTabId();
        KeyEventDispatcher.Component activity3 = getActivity();
        Intrinsics.f(activity3, "null cannot be cast to non-null type com.transsion.home.preload.MainXMLPreload");
        com.transsion.home.preload.b d11 = ((com.transsion.home.preload.a) activity3).d();
        FragmentActivity activity4 = getActivity();
        this.mMainAdapter = new SubTabAdapter(arrayList, function12, this, mTabId, d11, function1, activity4 != null && com.transsion.baseui.util.b.a(activity4), i11, this.isUGCMode);
        if (this.isUGCMode || ((activity = getActivity()) != null && com.transsion.baseui.util.b.a(activity))) {
            NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(requireContext(), i11);
            c cVar = new c(i11);
            cVar.i(true);
            npaGridLayoutManager.d0(cVar);
            linearLayoutManager = npaGridLayoutManager;
        } else {
            linearLayoutManager = new NpaLinearLayoutManager(requireContext(), 1, false);
        }
        gl.y yVar = (gl.y) getMViewBinding();
        if (yVar != null && (recyclerView2 = yVar.f63991e) != null) {
            recyclerView2.setAdapter(this.mMainAdapter);
            recyclerView2.setLayoutManager(linearLayoutManager);
            linearLayoutManager.setInitialPrefetchItemCount(6);
            recyclerView2.setItemAnimator(null);
            if (this.isUGCMode) {
                ig.h hVar = new ig.h(com.blankj.utilcode.util.a0.a(16.0f), i11);
                hVar.d(com.blankj.utilcode.util.a0.a(8.0f));
                recyclerView2.addItemDecoration(hVar);
            } else {
                ig.h hVar2 = new ig.h(com.blankj.utilcode.util.a0.a(12.0f), 1);
                hVar2.d(com.blankj.utilcode.util.a0.a(6.0f));
                recyclerView2.addItemDecoration(hVar2);
            }
        }
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        if (subTabAdapter != null && (preferencesProvider = subTabAdapter.getPreferencesProvider()) != null) {
            HomePreferencesViewModel Z0 = Z0();
            SubTabAdapter subTabAdapter2 = this.mMainAdapter;
            Intrinsics.e(subTabAdapter2);
            int mTabId2 = getMTabId();
            String mTabCode = getMTabCode();
            if (mTabCode == null) {
                mTabCode = "";
            }
            HomePreferencesUiHelperKt.j(preferencesProvider, Z0, subTabAdapter2, mTabId2, mTabCode);
        }
        gl.y yVar2 = (gl.y) getMViewBinding();
        if (yVar2 != null && (recyclerView = yVar2.f63991e) != null) {
            HomePreferencesUiHelperKt.h(this, recyclerView, linearLayoutManager, Z0(), new Function0() { // from class: com.transsion.home.fragment.tab.s0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int k12;
                    k12 = SubTabFragment.k1(SubTabFragment.this);
                    return Integer.valueOf(k12);
                }
            });
        }
        SubTabAdapter subTabAdapter3 = this.mMainAdapter;
        if (subTabAdapter3 != null) {
            subTabAdapter3.h0().z(true);
            subTabAdapter3.h0().z(true);
            subTabAdapter3.h0().y(true);
            subTabAdapter3.h0().D(new p6.f() { // from class: com.transsion.home.fragment.tab.t0
                @Override // p6.f
                public final void a() {
                    SubTabFragment.l1(SubTabFragment.this);
                }
            });
            subTabAdapter3.R0(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k1(SubTabFragment subTabFragment) {
        List<Object> data;
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter == null || (data = subTabAdapter.getData()) == null) {
            return 0;
        }
        return data.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void l1(final SubTabFragment subTabFragment) {
        RecyclerView recyclerView;
        if (nh.m.f70597a.e()) {
            SubTabViewModel subTabViewModel = subTabFragment.mViewModel;
            if (subTabViewModel != null) {
                subTabViewModel.t(subTabFragment.getMTabId(), subTabFragment.getMTabCode(), false);
                return;
            }
            return;
        }
        uh.b.f76876a.d(R$string.no_network_toast);
        gl.y yVar = (gl.y) subTabFragment.getMViewBinding();
        if (yVar == null || (recyclerView = yVar.f63991e) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.d0
            @Override // java.lang.Runnable
            public final void run() {
                SubTabFragment.m1(SubTabFragment.this);
            }
        }, 500L);
    }

    private final void m0() {
        String mTabCode;
        Fragment parentFragment = getParentFragment();
        HomeFragment homeFragment = parentFragment instanceof HomeFragment ? (HomeFragment) parentFragment : null;
        if ((homeFragment == null || (mTabCode = homeFragment.J0()) == null) && (mTabCode = getMTabCode()) == null) {
            mTabCode = "";
        }
        if (homeFragment != null) {
            homeFragment.b1(mTabCode, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(SubTabFragment subTabFragment) {
        r6.f h02;
        SubTabAdapter subTabAdapter = subTabFragment.mMainAdapter;
        if (subTabAdapter == null || (h02 = subTabAdapter.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(SubTabFragment subTabFragment, int i11) {
        HashMap g11;
        HashMap g12;
        String str;
        Integer v11;
        hj.b logViewConfig = subTabFragment.getLogViewConfig();
        int intValue = (logViewConfig == null || (g12 = logViewConfig.g()) == null || (str = (String) g12.get("scrollPosition")) == null || (v11 = StringsKt.v(str)) == null) ? 0 : v11.intValue();
        hj.b logViewConfig2 = subTabFragment.getLogViewConfig();
        if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
            g11.put("scrollPosition", String.valueOf(RangesKt.f(intValue, i11)));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(SubTabFragment subTabFragment) {
        subTabFragment.c0();
    }

    private final void p1() {
        final IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (Intrinsics.c(iMemberApi != null ? Boolean.valueOf(iMemberApi.c()) : null, Boolean.FALSE)) {
            s1(null);
        } else if (iMemberApi != null) {
            iMemberApi.m(new Function1() { // from class: com.transsion.home.fragment.tab.c0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit q12;
                    q12 = SubTabFragment.q1(IMemberApi.this, this, (MemberRemindData) obj);
                    return q12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit q1(IMemberApi iMemberApi, final SubTabFragment subTabFragment, final MemberRemindData memberRemindData) {
        gl.y yVar;
        RecyclerView recyclerView;
        if (iMemberApi.F(memberRemindData) && (yVar = (gl.y) subTabFragment.getMViewBinding()) != null && (recyclerView = yVar.f63991e) != null) {
            recyclerView.post(new Runnable() { // from class: com.transsion.home.fragment.tab.l0
                @Override // java.lang.Runnable
                public final void run() {
                    SubTabFragment.r1(SubTabFragment.this, memberRemindData);
                }
            });
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(SubTabFragment subTabFragment, MemberRemindData memberRemindData) {
        FragmentActivity activity = subTabFragment.getActivity();
        if (activity != null) {
            if (activity.isDestroyed() || activity.isFinishing()) {
                activity = null;
            }
            if (activity == null) {
                return;
            }
            subTabFragment.s1(memberRemindData);
        }
    }

    private final void s1(MemberRemindData remindData) {
        SubTabAdapter subTabAdapter;
        OperateItem operateItem = new OperateItem(null, PostItemType.MEMBER_BANNER.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, remindData, null, null, null, null, null, null, 2130706429, null);
        SubTabAdapter subTabAdapter2 = this.mMainAdapter;
        List<Object> data = subTabAdapter2 != null ? subTabAdapter2.getData() : null;
        if (data != null && data.size() >= 6) {
            SubTabAdapter subTabAdapter3 = this.mMainAdapter;
            if (subTabAdapter3 != null) {
                subTabAdapter3.n(5, operateItem);
                return;
            }
            return;
        }
        if (data == null || data.isEmpty() || (subTabAdapter = this.mMainAdapter) == null) {
            return;
        }
        subTabAdapter.n(data.size(), operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        startLoading();
        String e11 = ak.o.f721a.e();
        SubTabViewModel subTabViewModel = this.mViewModel;
        if (subTabViewModel != null) {
            subTabViewModel.n(getMTabId(), false, e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(SubTabFragment subTabFragment, Function1 callback) {
        Intrinsics.h(callback, "callback");
        subTabFragment.mPermissionCallback = callback;
        androidx.activity.result.b bVar = subTabFragment.mLauncher;
        if (bVar != null) {
            bVar.a(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"});
        }
        return Unit.f67184a;
    }

    private final void v1() {
        setNetListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void w1(final SubTabFragment subTabFragment, Map permissions) {
        RecyclerView recyclerView;
        Intrinsics.h(permissions, "permissions");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        Iterator it = permissions.entrySet().iterator();
        while (it.hasNext()) {
            if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                booleanRef.element = false;
            }
        }
        gl.y yVar = (gl.y) subTabFragment.getMViewBinding();
        if (yVar == null || (recyclerView = yVar.f63991e) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.home.fragment.tab.g0
            @Override // java.lang.Runnable
            public final void run() {
                SubTabFragment.x1(SubTabFragment.this, booleanRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(SubTabFragment subTabFragment, Ref.BooleanRef booleanRef) {
        Function1 function1 = subTabFragment.mPermissionCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(booleanRef.element));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1() {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1() {
        return Unit.f67184a;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void c0() {
        String e11 = ak.o.f721a.e();
        SubTabViewModel subTabViewModel = this.mViewModel;
        if (subTabViewModel != null) {
            subTabViewModel.n(getMTabId(), true, e11);
        }
        m0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public gl.y getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        gl.y c11 = gl.y.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView f0() {
        gl.y yVar = (gl.y) getMViewBinding();
        if (yVar != null) {
            return yVar.f63991e;
        }
        return null;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public String g0() {
        return this.isUGCMode ? "HomeFragmentListGrid2TemplateAd" : "HomeFragmentListLinearTemplateAd";
    }

    public final String getPageName() {
        return INSTANCE.a(getMTabId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        gl.m0 m0Var;
        ConstraintLayout constraintLayout;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        gl.y yVar = (gl.y) getMViewBinding();
        if (yVar != null && (swipeRefreshLayout = yVar.f63992f) != null && swipeRefreshLayout.isRefreshing()) {
            gl.y yVar2 = (gl.y) getMViewBinding();
            if (yVar2 == null || (swipeRefreshLayout2 = yVar2.f63992f) == null) {
                return;
            }
            swipeRefreshLayout2.setRefreshing(false);
            return;
        }
        gl.y yVar3 = (gl.y) getMViewBinding();
        if (yVar3 == null || (m0Var = yVar3.f63989c) == null || (constraintLayout = m0Var.f63907h) == null) {
            return;
        }
        jg.c.g(constraintLayout);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        androidx.view.b0 s11;
        androidx.view.b0 q11;
        androidx.view.b0 p11;
        Intrinsics.h(view, "view");
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        if (subTabAdapter != null) {
            HomePreferencesUiHelperKt.o(this, Z0(), subTabAdapter);
        }
        final Function1 function1 = new Function1() { // from class: com.transsion.home.fragment.tab.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e12;
                e12 = SubTabFragment.e1(SubTabFragment.this, (SubOperateData) obj);
                return e12;
            }
        };
        SubTabViewModel subTabViewModel = this.mViewModel;
        if (subTabViewModel != null && (p11 = subTabViewModel.p()) != null) {
            p11.j(this, new f(new Function1() { // from class: com.transsion.home.fragment.tab.j0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit f12;
                    f12 = SubTabFragment.f1(SubTabFragment.this, function1, (SubOperateData) obj);
                    return f12;
                }
            }));
        }
        SubTabViewModel subTabViewModel2 = this.mViewModel;
        if (subTabViewModel2 != null && (q11 = subTabViewModel2.q()) != null) {
            q11.j(this, new f(new Function1() { // from class: com.transsion.home.fragment.tab.m0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit g12;
                    g12 = SubTabFragment.g1(SubTabFragment.this, function1, (SubOperateData) obj);
                    return g12;
                }
            }));
        }
        SubTabViewModel subTabViewModel3 = this.mViewModel;
        if (subTabViewModel3 == null || (s11 = subTabViewModel3.s()) == null) {
            return;
        }
        s11.j(this, new f(new Function1() { // from class: com.transsion.home.fragment.tab.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h12;
                h12 = SubTabFragment.h1(SubTabFragment.this, (TrendingRespData) obj);
                return h12;
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        SwipeRefreshLayout swipeRefreshLayout;
        View view2;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.h(view, "view");
        super.initView(view, savedInstanceState);
        SubTabViewModel subTabViewModel = (SubTabViewModel) new androidx.view.v0(this).a(SubTabViewModel.class);
        this.mViewModel = subTabViewModel;
        if (subTabViewModel != null) {
            subTabViewModel.w(this.isUGCMode);
        }
        this.mHeaderBgHeight = Y0();
        gl.y yVar = (gl.y) getMViewBinding();
        if (yVar != null && (view2 = yVar.f63988b) != null && (layoutParams = view2.getLayoutParams()) != null) {
            layoutParams.height = this.mHeaderBgHeight;
        }
        gl.y yVar2 = (gl.y) getMViewBinding();
        if (yVar2 == null || (swipeRefreshLayout = yVar2.f63992f) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.tab.o0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                SubTabFragment.o1(SubTabFragment.this);
            }
        });
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void l0(int lastAdPosition, BiddingNativeManager wrapperNativeManager) {
        List<Object> data;
        Intrinsics.h(wrapperNativeManager, "wrapperNativeManager");
        if (wrapperNativeManager == null || lastAdPosition < 0) {
            return;
        }
        OperateItem operateItem = new OperateItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, null);
        operateItem.setNonAdDelegate(wrapperNativeManager);
        operateItem.setType(PostItemType.TRENDING_NATIVE_AD.getValue());
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        int size = (subTabAdapter == null || (data = subTabAdapter.getData()) == null) ? 0 : data.size();
        if (lastAdPosition < 0 || lastAdPosition > size) {
            SubTabAdapter subTabAdapter2 = this.mMainAdapter;
            if (subTabAdapter2 != null) {
                subTabAdapter2.p(operateItem);
                return;
            }
            return;
        }
        SubTabAdapter subTabAdapter3 = this.mMainAdapter;
        if (subTabAdapter3 != null) {
            subTabAdapter3.n(lastAdPosition, operateItem);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        List<Object> data;
        if (!this.isViewInitialized) {
            this.isViewInitialized = true;
            j1();
            v1();
            a.C0856a.f(lg.a.f68962a, "SubTabFragment", "lazyLoadData() --> View延迟初始化完成", false, 4, null);
        }
        this.loadStartTime = System.currentTimeMillis();
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        if (((subTabAdapter == null || (data = subTabAdapter.getData()) == null) ? 0 : data.size()) <= 0) {
            t1();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        return new hj.b(getPageName(), false, 2, null);
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        this.mLauncher = registerForActivityResult(new f.h(), new androidx.activity.result.a() { // from class: com.transsion.home.fragment.tab.b0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                SubTabFragment.w1(SubTabFragment.this, (Map) obj);
            }
        });
        super.onCreate(savedInstanceState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        SwipeRefreshLayout swipeRefreshLayout;
        gl.y yVar = (gl.y) getMViewBinding();
        if (yVar != null && (swipeRefreshLayout = yVar.f63992f) != null) {
            swipeRefreshLayout.setOnRefreshListener(null);
        }
        gl.y yVar2 = (gl.y) getMViewBinding();
        if (yVar2 != null && (recyclerView2 = yVar2.f63991e) != null) {
            recyclerView2.removeOnScrollListener(this.mRecycleScrollListener);
        }
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        if (subTabAdapter != null) {
            subTabAdapter.V1(null);
        }
        gl.y yVar3 = (gl.y) getMViewBinding();
        if (yVar3 != null && (recyclerView = yVar3.f63991e) != null) {
            recyclerView.setAdapter(null);
        }
        View view = this.mNoNetworkView;
        NoNetworkBigView noNetworkBigView = view instanceof NoNetworkBigView ? (NoNetworkBigView) view : null;
        if (noNetworkBigView != null) {
            noNetworkBigView.retry(new Function0() { // from class: com.transsion.home.fragment.tab.z
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit y12;
                    y12 = SubTabFragment.y1();
                    return y12;
                }
            });
            noNetworkBigView.goToSetting(new Function0() { // from class: com.transsion.home.fragment.tab.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit z12;
                    z12 = SubTabFragment.z1();
                    return z12;
                }
            });
        }
        this.mNoNetworkView = null;
        super.onDestroyView();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        HashMap g11;
        List<Object> data;
        super.onResume();
        SubTabAdapter subTabAdapter = this.mMainAdapter;
        boolean z10 = false;
        if (((subTabAdapter == null || (data = subTabAdapter.getData()) == null) ? 0 : data.size()) <= 0) {
            View view = this.mNoNetworkView;
            if (view != null && view.getVisibility() == 0) {
                z10 = true;
            }
            if (z10 && nh.m.f70597a.e()) {
                a.C0856a c0856a = lg.a.f68962a;
                View view2 = this.mNoNetworkView;
                a.C0856a.f(c0856a, "SubTabFragment", "loaddata on resume = " + (view2 != null ? Integer.valueOf(view2.getVisibility()) : null) + "  " + this, false, 4, null);
                t1();
            }
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
            return;
        }
        g11.put("scrollPosition", "0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void p0() {
        RecyclerView recyclerView;
        gl.y yVar = (gl.y) getMViewBinding();
        if (yVar == null || (recyclerView = yVar.f63991e) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        gl.m0 m0Var;
        ConstraintLayout constraintLayout;
        gl.y yVar = (gl.y) getMViewBinding();
        if (yVar == null || (m0Var = yVar.f63989c) == null || (constraintLayout = m0Var.f63907h) == null) {
            return;
        }
        jg.c.k(constraintLayout);
    }
}
