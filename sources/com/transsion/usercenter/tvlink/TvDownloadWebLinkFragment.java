package com.transsion.usercenter.tvlink;

import android.content.Context;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.fragment.app.w;
import androidx.view.c0;
import androidx.view.m;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$style;
import com.tn.lib.widget.TnTextView;
import com.transsion.base.report.athena.ClickType;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.tvlink.d;
import com.transsion.web.api.WebConstants;
import com.transsion.web.fragment.WebFragmentV2;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import fw.p0;
import hj.i;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 Z2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010\u0004J\u001f\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b+\u0010,J'\u00103\u001a\u0002022\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0002¢\u0006\u0004\b3\u00104J\u0011\u00106\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\rH\u0002¢\u0006\u0004\b<\u0010\u0004J\u0017\u0010>\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u0019H\u0002¢\u0006\u0004\b>\u0010?J\u001f\u0010B\u001a\u00020\r2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020/H\u0002¢\u0006\u0004\bB\u0010CJ\u0011\u0010E\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006["}, d2 = {"Lcom/transsion/usercenter/tvlink/TvDownloadWebLinkFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lfw/p0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "k0", "(Landroid/view/LayoutInflater;)Lfw/p0;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "initListener", "lazyLoadData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "", "m0", "()Z", "w0", "Lcom/transsion/usercenter/tvlink/d$b;", "urls", "t0", "(Lcom/transsion/usercenter/tvlink/d$b;)V", "u0", "s0", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "selected", "x0", "(Lcom/google/android/material/tabs/TabLayout$Tab;Z)V", "", "textRes", "Lcom/tn/lib/widget/TnTextView;", "g0", "(I)Lcom/tn/lib/widget/TnTextView;", "Landroidx/fragment/app/w;", "transaction", "", "tag", "url", "Landroidx/fragment/app/Fragment;", "i0", "(Landroidx/fragment/app/w;Ljava/lang/String;Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "Lcom/transsion/web/fragment/WebFragmentV2;", "h0", "()Lcom/transsion/web/fragment/WebFragmentV2;", "r0", "(Lcom/transsion/usercenter/tvlink/d$b;)Ljava/lang/String;", "f0", "(Ljava/lang/String;)Ljava/lang/String;", "v0", "isSuccess", "j0", "(Z)V", "moduleName", NativeComponentConstants.KEY_COMPONENT_TYPE, "p0", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/fragment/app/FragmentActivity;", "q0", "()Landroidx/fragment/app/FragmentActivity;", "Lcom/transsion/usercenter/tvlink/d;", "a", "Lkotlin/Lazy;", "l0", "()Lcom/transsion/usercenter/tvlink/d;", "viewModel", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "selectedTab", "", "c", "J", "loadStartedAt", "d", "Z", "isInitializingTabs", "e", "Lcom/transsion/usercenter/tvlink/d$b;", "currentUrls", "f", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class TvDownloadWebLinkFragment extends BaseFragment<p0> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int selectedTab;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long loadStartedAt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isInitializingTabs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private d.b currentUrls;

    /* renamed from: com.transsion.usercenter.tvlink.TvDownloadWebLinkFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TvDownloadWebLinkFragment a(int i11) {
            TvDownloadWebLinkFragment tvDownloadWebLinkFragment = new TvDownloadWebLinkFragment();
            tvDownloadWebLinkFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("arg_initial_tab_index", Integer.valueOf(i11))));
            return tvDownloadWebLinkFragment;
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57619a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57619a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57619a;
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
            this.f57619a.invoke(obj);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements TabLayout.OnTabSelectedListener {
        c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Intrinsics.h(tab, "tab");
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Intrinsics.h(tab, "tab");
            TvDownloadWebLinkFragment.this.selectedTab = tab.getPosition();
            TvDownloadWebLinkFragment.this.x0(tab, true);
            TvDownloadWebLinkFragment.this.u0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Intrinsics.h(tab, "tab");
            TvDownloadWebLinkFragment.this.x0(tab, false);
        }
    }

    public TvDownloadWebLinkFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.tvlink.TvDownloadWebLinkFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(d.class), new Function0<x0>() { // from class: com.transsion.usercenter.tvlink.TvDownloadWebLinkFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.tvlink.TvDownloadWebLinkFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object invoke = Function0.this.invoke();
                m mVar = invoke instanceof m ? (m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    private final String f0(String url) {
        String obj = StringsKt.n1(url).toString();
        if (StringsKt.q0(obj)) {
            return "";
        }
        String uri = Uri.parse(obj).buildUpon().appendQueryParameter("pageFrom", "/profile/tv_download_web_link").build().toString();
        Intrinsics.g(uri, "toString(...)");
        return uri;
    }

    private final TnTextView g0(int textRes) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        TnTextView tnTextView = new TnTextView(requireContext);
        tnTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        tnTextView.setGravity(17);
        tnTextView.setText(textRes);
        return tnTextView;
    }

    private final WebFragmentV2 h0() {
        d.b bVar = this.currentUrls;
        if (bVar == null || StringsKt.q0(r0(bVar))) {
            return null;
        }
        Fragment k02 = getChildFragmentManager().k0(this.selectedTab == 0 ? "tag_tv_download_web" : "tag_web_link_web");
        if (k02 instanceof WebFragmentV2) {
            return (WebFragmentV2) k02;
        }
        return null;
    }

    private final Fragment i0(w transaction, String tag, String url) {
        Fragment fragment;
        Fragment k02 = getChildFragmentManager().k0(tag);
        if ((StringsKt.q0(url) ? k02 instanceof TvDownloadWebEmptyFragment : k02 instanceof WebFragmentV2) && k02 != null) {
            return k02;
        }
        if (k02 != null) {
            transaction.r(k02);
        }
        if (StringsKt.q0(url)) {
            fragment = new TvDownloadWebEmptyFragment();
        } else {
            WebFragmentV2 b11 = WebFragmentV2.INSTANCE.b();
            Pair a11 = TuplesKt.a("url", url);
            Boolean bool = Boolean.TRUE;
            b11.setArguments(androidx.core.os.d.b(a11, TuplesKt.a(WebConstants.FIELD_TOOL_BAR_HIDDEN, bool), TuplesKt.a(WebConstants.FIELD_STATUS_BAR_HIDDEN, bool)));
            fragment = b11;
        }
        transaction.c(R$id.webFragmentContainer, fragment, tag);
        return fragment;
    }

    private final void j0(boolean isSuccess) {
        HashMap g11;
        hj.b logViewConfig;
        long elapsedRealtime = this.loadStartedAt > 0 ? SystemClock.elapsedRealtime() - this.loadStartedAt : 0L;
        if (isSuccess && (logViewConfig = getLogViewConfig()) != null) {
            logViewConfig.k(true);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
        }
        this.loadStartedAt = 0L;
    }

    private final d l0() {
        return (d) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(TvDownloadWebLinkFragment tvDownloadWebLinkFragment, d.b bVar) {
        if (tvDownloadWebLinkFragment.q0() == null || tvDownloadWebLinkFragment.getChildFragmentManager().T0()) {
            return Unit.f67184a;
        }
        d.b a11 = bVar.a(tvDownloadWebLinkFragment.f0(bVar.b()), tvDownloadWebLinkFragment.f0(bVar.c()));
        tvDownloadWebLinkFragment.currentUrls = a11;
        if (a11 != null) {
            tvDownloadWebLinkFragment.t0(a11);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(TvDownloadWebLinkFragment tvDownloadWebLinkFragment, View view) {
        tvDownloadWebLinkFragment.p0("scan_code", "banner");
        Navigator.x(TheRouter.c("/profile/qr_code"), tvDownloadWebLinkFragment.requireContext(), null, 2, null);
    }

    private final void p0(String moduleName, String type) {
        i.f64628a.q("/profile/tv_download_web_link", MapsKt.j(TuplesKt.a("module_name", moduleName), TuplesKt.a(NativeComponentConstants.KEY_COMPONENT_TYPE, type)), ClickType.FEATURE);
    }

    private final FragmentActivity q0() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    private final String r0(d.b urls) {
        return this.selectedTab == 0 ? urls.b() : urls.c();
    }

    private final void s0() {
        TabLayout tabLayout;
        p0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (tabLayout = mViewBinding.f62971i) == null) {
            return;
        }
        this.isInitializingTabs = true;
        tabLayout.removeAllTabs();
        tabLayout.addTab(tabLayout.newTab().setCustomView(g0(R$string.user_center_tv_download_web_link_tv_download)), false);
        tabLayout.addTab(tabLayout.newTab().setCustomView(g0(R$string.user_center_tv_download_web_link_web_link)), false);
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c());
        int m11 = RangesKt.m(this.selectedTab, 0, 1);
        this.selectedTab = m11;
        TabLayout.Tab tabAt = tabLayout.getTabAt(m11);
        if (tabAt != null) {
            tabAt.select();
        }
        for (int i11 = 0; i11 < 2; i11++) {
            TabLayout.Tab tabAt2 = tabLayout.getTabAt(i11);
            if (tabAt2 != null) {
                x0(tabAt2, tabAt2.getPosition() == this.selectedTab);
            }
        }
        this.isInitializingTabs = false;
    }

    private final void t0(d.b urls) {
        w p11 = getChildFragmentManager().p();
        Intrinsics.g(p11, "beginTransaction(...)");
        Fragment i02 = i0(p11, "tag_tv_download_web", urls.b());
        Fragment i03 = i0(p11, "tag_web_link_web", urls.c());
        if (this.selectedTab == 0) {
            p11.y(i02);
            p11.p(i03);
        } else {
            p11.p(i02);
            p11.y(i03);
        }
        p11.i();
        j0((StringsKt.q0(urls.b()) || StringsKt.q0(urls.c())) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        if (this.currentUrls == null) {
            return;
        }
        Fragment k02 = getChildFragmentManager().k0("tag_tv_download_web");
        Fragment k03 = getChildFragmentManager().k0("tag_web_link_web");
        if (getChildFragmentManager().T0()) {
            return;
        }
        w p11 = getChildFragmentManager().p();
        if (k02 != null) {
            Fragment fragment = k02.isAdded() ? k02 : null;
            if (fragment != null) {
                p11.p(fragment);
            }
        }
        if (k03 != null) {
            Fragment fragment2 = k03.isAdded() ? k03 : null;
            if (fragment2 != null) {
                p11.p(fragment2);
            }
        }
        if (this.selectedTab == 0) {
            if (k02 != null) {
                if (!k02.isAdded()) {
                    k02 = null;
                }
                if (k02 != null) {
                    p11.y(k02);
                }
            }
        } else if (k03 != null) {
            if (!k03.isAdded()) {
                k03 = null;
            }
            if (k03 != null) {
                p11.y(k03);
            }
        }
        p11.i();
    }

    private final void v0() {
        HashMap g11;
        this.loadStartedAt = SystemClock.elapsedRealtime();
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r1.u() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void w0() {
        /*
            r3 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Class<com.transsion.memberapi.IPremiumApi> r2 = com.transsion.memberapi.IPremiumApi.class
            java.lang.Object r1 = com.therouter.TheRouter.d(r2, r1)
            com.transsion.memberapi.IPremiumApi r1 = (com.transsion.memberapi.IPremiumApi) r1
            if (r1 == 0) goto L15
            boolean r1 = r1.u()
            r2 = 1
            if (r1 != r2) goto L15
            goto L16
        L15:
            r2 = r0
        L16:
            g4.a r1 = r3.getMViewBinding()
            fw.p0 r1 = (fw.p0) r1
            if (r1 == 0) goto L2a
            androidx.constraintlayout.widget.Group r1 = r1.f62969g
            if (r1 == 0) goto L2a
            if (r2 == 0) goto L25
            goto L27
        L25:
            r0 = 8
        L27:
            r1.setVisibility(r0)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.tvlink.TvDownloadWebLinkFragment.w0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(TabLayout.Tab tab, boolean selected) {
        View customView = tab.getCustomView();
        TnTextView tnTextView = customView instanceof TnTextView ? (TnTextView) customView : null;
        if (tnTextView == null) {
            return;
        }
        int i11 = selected ? R$style.style_import_text : R$style.style_regular_text;
        float f11 = selected ? 16.0f : 14.0f;
        int i12 = selected ? R$color.white_100 : R$color.white_80;
        androidx.core.widget.m.q(tnTextView, i11);
        tnTextView.setTextSize(2, f11);
        tnTextView.setTextColor(androidx.core.content.b.getColor(requireContext(), i12));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        l0().b().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.usercenter.tvlink.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n02;
                n02 = TvDownloadWebLinkFragment.n0(TvDownloadWebLinkFragment.this, (d.b) obj);
                return n02;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initListener() {
        p0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f62964b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.tvlink.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TvDownloadWebLinkFragment.o0(TvDownloadWebLinkFragment.this, view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        int i11 = 0;
        if (savedInstanceState != null) {
            i11 = savedInstanceState.getInt("state_selected_tab", 0);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                i11 = arguments.getInt("arg_initial_tab_index", 0);
            }
        }
        this.selectedTab = i11;
        ImageView imageView = (ImageView) view.findViewById(com.tn.lib.widget.R$id.iv_back);
        if (imageView != null) {
            imageView.setImageTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(requireContext(), R$color.white_100)));
        }
        w0();
        s0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public p0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        p0 c11 = p0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        v0();
        l0().c();
    }

    public final boolean m0() {
        WebFragmentV2 h02 = h0();
        return h02 != null && h02.u1();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        return new hj.b("/profile/tv_download_web_link", false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        outState.putInt("state_selected_tab", this.selectedTab);
        super.onSaveInstanceState(outState);
    }
}
