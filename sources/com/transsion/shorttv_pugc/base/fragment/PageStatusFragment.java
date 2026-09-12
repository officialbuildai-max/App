package com.transsion.shorttv_pugc.base.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.view.v;
import be.g;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv_pugc.base.util.DeviceKeyMonitor;
import com.transsion.shorttv_pugc.base.widget.NoNetworkBigView;
import com.transsion.shorttv_pugc.base.widget.StateView;
import com.transsion.shorttv_pugc.base.widget.j;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import g4.a;
import ht.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nh.m;
import nh.n;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 o*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001HB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\bJ\u001f\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010\bJ\u000f\u0010$\u001a\u00020\u000bH\u0016¢\u0006\u0004\b$\u0010\bJ\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020%H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020%H\u0016¢\u0006\u0004\b)\u0010'J\u000f\u0010*\u001a\u00020%H\u0016¢\u0006\u0004\b*\u0010'J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020%H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0012H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u0011\u00106\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b6\u00102J\r\u00107\u001a\u00020\u000b¢\u0006\u0004\b7\u0010\bJ\u0017\u00108\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020%¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u000b¢\u0006\u0004\b:\u0010\bJ\u0017\u0010;\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020%¢\u0006\u0004\b;\u00109J\u000f\u0010<\u001a\u00020\u000bH\u0016¢\u0006\u0004\b<\u0010\bJ\u000f\u0010=\u001a\u00020\u000bH\u0016¢\u0006\u0004\b=\u0010\bJ\u000f\u0010>\u001a\u00020\u000bH\u0016¢\u0006\u0004\b>\u0010\bJ\u0017\u0010?\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020+H&¢\u0006\u0004\bA\u0010-J!\u0010B\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bB\u0010\u0017J\u000f\u0010B\u001a\u00020\u000bH&¢\u0006\u0004\bB\u0010\bJ\u000f\u0010C\u001a\u00020\u000bH&¢\u0006\u0004\bC\u0010\bJ\u000f\u0010D\u001a\u00020\u000bH&¢\u0006\u0004\bD\u0010\bJ\u000f\u0010E\u001a\u00020\u000bH\u0016¢\u0006\u0004\bE\u0010\bJ\u000f\u0010F\u001a\u00020\u000bH&¢\u0006\u0004\bF\u0010\bR$\u0010N\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010U\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010]\u001a\u0004\u0018\u00010V8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u001d\u0010j\u001a\u0004\u0018\u00010e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010m¨\u0006p"}, d2 = {"Lcom/transsion/shorttv_pugc/base/fragment/PageStatusFragment;", "Lg4/a;", "T", "Landroidx/fragment/app/Fragment;", "Lht/d;", "Lnh/n;", "Lcom/transsion/shorttv_pugc/base/util/DeviceKeyMonitor$b;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "logResume", "logPause", "onDestroy", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "onDisconnected", "receiveArguments", "", "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "isShowPageStateLayoutTitle", "isRegisteDeviceKeyMonitor", "", "getEmptyDescText", "()Ljava/lang/String;", "isShowTitleLayout", "getEmptyView", "(Z)Landroid/view/View;", "getNoNetworkView", "()Landroid/view/View;", "", "getScreenType", "()I", "getLoadingView", "showContentView", "showEmptyView", "(Z)V", "showLoadingView", "showNoNetworkView", "onDestroyView", "onHomeClick", "onRecentClick", "getViewBinding", "(Landroid/view/LayoutInflater;)Lg4/a;", "getPageStateLayoutTitle", "initViewData", "initViewModel", "initListener", "loadDefaultData", "retryLoadData", "Landroid/widget/ProgressBar;", "a", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "progressBar", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lg4/a;", "getMViewBinding", "()Lg4/a;", "setMViewBinding", "(Lg4/a;)V", "mViewBinding", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "getFlStateView", "()Landroid/widget/FrameLayout;", "setFlStateView", "(Landroid/widget/FrameLayout;)V", "flStateView", "d", "Landroid/view/View;", "loadingView", "Lcom/transsion/shorttv_pugc/base/util/DeviceKeyMonitor;", "e", "Lcom/transsion/shorttv_pugc/base/util/DeviceKeyMonitor;", "deviceKeyMonitor", "Lhj/b;", "f", "Lkotlin/Lazy;", "getLogViewConfig", "()Lhj/b;", "logViewConfig", "Ljava/lang/Runnable;", g.f16474b, "Ljava/lang/Runnable;", "showNoNetworkViewRunnable", "h", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public abstract class PageStatusFragment<T extends g4.a> extends Fragment implements ht.d, n, DeviceKeyMonitor.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ProgressBar progressBar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private g4.a mViewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private FrameLayout flStateView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View loadingView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private DeviceKeyMonitor deviceKeyMonitor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.base.fragment.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            hj.b b02;
            b02 = PageStatusFragment.b0(PageStatusFragment.this);
            return b02;
        }
    });

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Runnable showNoNetworkViewRunnable = new Runnable() { // from class: com.transsion.shorttv_pugc.base.fragment.f
        @Override // java.lang.Runnable
        public final void run() {
            PageStatusFragment.e0(PageStatusFragment.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(PageStatusFragment pageStatusFragment) {
        String f11;
        hj.b logViewConfig = pageStatusFragment.getLogViewConfig();
        if (logViewConfig != null && (f11 = logViewConfig.f()) != null) {
            j.c(f11);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(PageStatusFragment pageStatusFragment) {
        String f11;
        pageStatusFragment.retryLoadData();
        hj.b logViewConfig = pageStatusFragment.getLogViewConfig();
        if (logViewConfig != null && (f11 = logViewConfig.f()) != null) {
            j.b(f11);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final hj.b b0(PageStatusFragment pageStatusFragment) {
        return pageStatusFragment.newLogViewConfig();
    }

    public static /* synthetic */ void c0(PageStatusFragment pageStatusFragment, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showEmptyView");
        }
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        pageStatusFragment.showEmptyView(z10);
    }

    public static /* synthetic */ void d0(PageStatusFragment pageStatusFragment, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNoNetworkView");
        }
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        pageStatusFragment.showNoNetworkView(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(PageStatusFragment pageStatusFragment) {
        d0(pageStatusFragment, false, 1, null);
    }

    public String getEmptyDescText() {
        return "";
    }

    public View getEmptyView(boolean isShowTitleLayout) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.showData(2, getScreenType(), isShowTitleLayout, getPageStateLayoutTitle(), getEmptyDescText());
        return stateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FrameLayout getFlStateView() {
        return this.flStateView;
    }

    public View getLoadingView() {
        return this.loadingView;
    }

    @Override // ht.d
    public hj.b getLogViewConfig() {
        return (hj.b) this.logViewConfig.getValue();
    }

    public final g4.a getMViewBinding() {
        return this.mViewBinding;
    }

    public View getNoNetworkView() {
        String f11;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        NoNetworkBigView noNetworkBigView = new NoNetworkBigView(requireContext, isShowPageStateLayoutTitle());
        noNetworkBigView.retry(new Function0() { // from class: com.transsion.shorttv_pugc.base.fragment.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit a02;
                a02 = PageStatusFragment.a0(PageStatusFragment.this);
                return a02;
            }
        });
        noNetworkBigView.goToSetting(new Function0() { // from class: com.transsion.shorttv_pugc.base.fragment.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Z;
                Z = PageStatusFragment.Z(PageStatusFragment.this);
                return Z;
            }
        });
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (f11 = logViewConfig.f()) != null) {
            j.a(f11);
        }
        return noNetworkBigView;
    }

    public abstract String getPageStateLayoutTitle();

    public int getScreenType() {
        return 1;
    }

    public abstract g4.a getViewBinding(LayoutInflater inflater);

    public abstract void initListener();

    public abstract void initViewData();

    public void initViewData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    public abstract void initViewModel();

    public boolean isAudioShowNoNetworkLayout() {
        return true;
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    public boolean isRegisteDeviceKeyMonitor() {
        return false;
    }

    public boolean isShowPageStateLayoutTitle() {
        return true;
    }

    public void loadDefaultData() {
    }

    public void logPause() {
        d.a.b(this);
    }

    public void logResume() {
        d.a.c(this);
    }

    public hj.b newLogViewConfig() {
        return d.a.a(this);
    }

    @Override // nh.n
    public void onConnected() {
        n.a.a(this);
    }

    @Override // nh.n
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        v.a(this).b(new PageStatusFragment$onConnected$1(this, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Context context;
        super.onCreate(savedInstanceState);
        receiveArguments();
        if (isMonitorNetworkState()) {
            m.f70597a.l(this);
        }
        if (!isRegisteDeviceKeyMonitor() || (context = getContext()) == null) {
            return;
        }
        this.deviceKeyMonitor = new DeviceKeyMonitor(context, this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        Intrinsics.h(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R$layout.short_tv_fragment_default_base_layout, container, false);
        this.mViewBinding = getViewBinding(inflater);
        if (inflate != null && (frameLayout2 = (FrameLayout) inflate.findViewById(R$id.flContent)) != null) {
            g4.a aVar = this.mViewBinding;
            frameLayout2.addView(aVar != null ? aVar.getRoot() : null);
        }
        if (inflate == null || (frameLayout = (FrameLayout) inflate.findViewById(R$id.flStateView)) == null) {
            frameLayout = null;
        } else if (isAudioShowNoNetworkLayout() && !m.f70597a.e()) {
            frameLayout.setVisibility(0);
            frameLayout.addView(getNoNetworkView());
        }
        this.flStateView = frameLayout;
        this.progressBar = inflate != null ? (ProgressBar) inflate.findViewById(R$id.progressBar) : null;
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (isMonitorNetworkState()) {
            m.f70597a.m(this);
        }
        DeviceKeyMonitor deviceKeyMonitor = this.deviceKeyMonitor;
        if (deviceKeyMonitor != null) {
            deviceKeyMonitor.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        View root;
        super.onDestroyView();
        g4.a aVar = this.mViewBinding;
        if (aVar != null && (root = aVar.getRoot()) != null) {
            root.removeCallbacks(this.showNoNetworkViewRunnable);
        }
        this.showNoNetworkViewRunnable = null;
    }

    @Override // nh.n
    public void onDisconnected() {
    }

    @Override // com.transsion.shorttv_pugc.base.util.DeviceKeyMonitor.b
    public void onHomeClick() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isHidden()) {
            return;
        }
        logPause();
    }

    @Override // com.transsion.shorttv_pugc.base.util.DeviceKeyMonitor.b
    public void onRecentClick() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        logResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViewData();
        initViewData(view, savedInstanceState);
        initViewModel();
        initListener();
        loadDefaultData();
    }

    public void receiveArguments() {
    }

    public abstract void retryLoadData();

    public final void showContentView() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final void showEmptyView(boolean isShowTitleLayout) {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(getEmptyView(isShowTitleLayout));
        }
    }

    public final void showLoadingView() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            View loadingView = getLoadingView();
            if (loadingView != null) {
                frameLayout.addView(loadingView);
            }
        }
    }

    public final void showNoNetworkView(boolean isShowTitleLayout) {
        FrameLayout frameLayout;
        if (getContext() == null || (frameLayout = this.flStateView) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        View noNetworkView = getNoNetworkView();
        if (noNetworkView instanceof NoNetworkBigView) {
            NoNetworkBigView.showTitle$default((NoNetworkBigView) noNetworkView, isShowTitleLayout, null, 2, null);
        }
        frameLayout.addView(noNetworkView);
    }
}
