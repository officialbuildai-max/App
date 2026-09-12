package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
import androidx.view.v0;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.ad.view.ScrollDetectFrameLayout;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.wrapperad.view.BiddingFloatingIrregularAnimationView;
import com.transsion.wrapperad.view.DownloadTopIrregularView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.activity.DownloadPanelActivity;
import com.transsnet.downloader.api.DownloadPageType;
import com.transsnet.downloader.lottery.LotteryTipView;
import com.transsnet.downloader.ugc.fragment.UGCDownloadManagerFragment;
import com.transsnet.downloader.viewmodel.LocalFileViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001*B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J!\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0005J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\u0005R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082D¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020-8\u0002X\u0082D¢\u0006\u0006\n\u0004\b1\u0010/R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010/R.\u0010@\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020- =*\n\u0012\u0004\u0012\u00020-\u0018\u00010<0<0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadMainFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lpy/w;", "Lzm/e;", "<init>", "()V", "", "A0", "x0", "w0", "", "t0", "()Z", "v0", "i0", "l0", "m0", "u0", "z0", "Landroid/view/LayoutInflater;", "inflater", "o0", "(Landroid/view/LayoutInflater;)Lpy/w;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "initData", "onMemberStateChange", "onResume", "hidden", "onHiddenChanged", "(Z)V", "onDestroy", "logResume", "logPause", "Landroidx/fragment/app/Fragment;", "a", "Landroidx/fragment/app/Fragment;", "contentFragment", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "TAG", "c", "FRAGMENT_TAG", "Lcom/transsnet/downloader/viewmodel/LocalFileViewModel;", "d", "Lkotlin/Lazy;", "n0", "()Lcom/transsnet/downloader/viewmodel/LocalFileViewModel;", "mLocalFileViewModel", "e", "speedUpTipTraceId", "Landroidx/activity/result/b;", "", "kotlin.jvm.PlatformType", "f", "Landroidx/activity/result/b;", "requestMultiplePermission", "", be.g.f16474b, "J", "resumeTimeStamp", "h", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadMainFragment extends BaseFragment<py.w> implements zm.e {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Fragment contentFragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "DownloadMain";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String FRAGMENT_TAG = "DownloadPanel";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLocalFileViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(LocalFileViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.fragment.DownloadMainFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadMainFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String speedUpTipTraceId = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final androidx.activity.result.b requestMultiplePermission;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: com.transsnet.downloader.fragment.DownloadMainFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadMainFragment a(int i11) {
            DownloadMainFragment downloadMainFragment = new DownloadMainFragment();
            downloadMainFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_page_index", Integer.valueOf(i11))));
            return downloadMainFragment;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements zm.f {
        b() {
        }

        @Override // zm.f
        public void a(Integer num, String str) {
        }

        @Override // zm.f
        public void b() {
            DownloadMainFragment.this.A0();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements ScrollDetectFrameLayout.a {
        c() {
        }

        @Override // com.transsion.ad.view.ScrollDetectFrameLayout.a
        public void a() {
            BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView;
            py.w mViewBinding = DownloadMainFragment.this.getMViewBinding();
            if (mViewBinding == null || (biddingFloatingIrregularAnimationView = mViewBinding.f73073b) == null) {
                return;
            }
            biddingFloatingIrregularAnimationView.changeState(false);
        }

        @Override // com.transsion.ad.view.ScrollDetectFrameLayout.a
        public void b() {
            BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView;
            py.w mViewBinding = DownloadMainFragment.this.getMViewBinding();
            if (mViewBinding == null || (biddingFloatingIrregularAnimationView = mViewBinding.f73073b) == null) {
                return;
            }
            biddingFloatingIrregularAnimationView.changeState(true);
        }

        @Override // com.transsion.ad.view.ScrollDetectFrameLayout.a
        public void c(float f11, float f12, ScrollDetectFrameLayout.ScrollDirection direction) {
            DownloadTopIrregularView downloadTopIrregularView;
            Intrinsics.h(direction, "direction");
            py.w mViewBinding = DownloadMainFragment.this.getMViewBinding();
            if (mViewBinding == null || (downloadTopIrregularView = mViewBinding.f73080i) == null) {
                return;
            }
            downloadTopIrregularView.onScroll(f11, f12, direction);
        }
    }

    public DownloadMainFragment() {
        androidx.activity.result.b registerForActivityResult = registerForActivityResult(new f.h(), new androidx.activity.result.a() { // from class: com.transsnet.downloader.fragment.f0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                DownloadMainFragment.y0(DownloadMainFragment.this, (Map) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.requestMultiplePermission = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        BLTextView bLTextView;
        boolean t02 = t0();
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        boolean f11 = iMemberApi != null ? iMemberApi.f() : false;
        py.w mViewBinding = getMViewBinding();
        if (mViewBinding != null && (bLTextView = mViewBinding.f73079h) != null) {
            bLTextView.setVisibility(!t02 && f11 ? 0 : 8);
        }
        if (t02 || !f11) {
            return;
        }
        x0();
    }

    private final void i0() {
        ScrollDetectFrameLayout root;
        py.w mViewBinding = getMViewBinding();
        if (mViewBinding == null || (root = mViewBinding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsnet.downloader.fragment.e0
            @Override // java.lang.Runnable
            public final void run() {
                DownloadMainFragment.j0(DownloadMainFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(final DownloadMainFragment downloadMainFragment) {
        FragmentActivity activity = downloadMainFragment.getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        com.transsnet.downloader.util.d.f60047a.e(activity, DownloadPageType.DOWNLOAD.getPageName(), new Function0() { // from class: com.transsnet.downloader.fragment.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit k02;
                k02 = DownloadMainFragment.k0(DownloadMainFragment.this);
                return k02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(DownloadMainFragment downloadMainFragment) {
        downloadMainFragment.l0();
        return Unit.f67184a;
    }

    private final void l0() {
        if (com.transsnet.downloader.viewmodel.a0.f60208a.a()) {
            Context context = getContext();
            if (context != null) {
                bf.c.f16548a.c(context);
            }
            m0();
            return;
        }
        if (com.transsnet.downloader.util.k.f60070a.a()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.requestMultiplePermission.a(com.transsion.baselib.helper.e.f43321a.a());
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    private final void m0() {
        a.C0856a.f(lg.a.f68962a, this.TAG, "getOutsidePlayHistoricalList", false, 4, null);
        if (isAdded()) {
            LocalFileViewModel.k(n0(), false, 1, null);
        }
    }

    private final LocalFileViewModel n0() {
        return (LocalFileViewModel) this.mLocalFileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(DownloadMainFragment downloadMainFragment, ak.n value) {
        GradientTextView gradientTextView;
        LotteryTipView lotteryTipView;
        DownloadTopIrregularView downloadTopIrregularView;
        BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView;
        Intrinsics.h(value, "value");
        String a11 = value.a();
        if (a11 == null || a11.length() == 0) {
            downloadMainFragment.u0();
        } else {
            py.w mViewBinding = downloadMainFragment.getMViewBinding();
            if (mViewBinding != null && (biddingFloatingIrregularAnimationView = mViewBinding.f73073b) != null) {
                jg.c.g(biddingFloatingIrregularAnimationView);
            }
            py.w mViewBinding2 = downloadMainFragment.getMViewBinding();
            if (mViewBinding2 != null && (downloadTopIrregularView = mViewBinding2.f73080i) != null) {
                jg.c.g(downloadTopIrregularView);
            }
            py.w mViewBinding3 = downloadMainFragment.getMViewBinding();
            if (mViewBinding3 != null && (lotteryTipView = mViewBinding3.f73078g) != null) {
                jg.c.g(lotteryTipView);
            }
        }
        downloadMainFragment.v0();
        py.w mViewBinding4 = downloadMainFragment.getMViewBinding();
        if (mViewBinding4 != null && (gradientTextView = mViewBinding4.f73082k) != null) {
            gradientTextView.setVisibility(ak.o.f721a.i() ? 8 : 0);
        }
        downloadMainFragment.A0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(DownloadMainFragment downloadMainFragment, View view) {
        Navigator.x(TheRouter.c("/download/transfer"), downloadMainFragment.getContext(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(DownloadMainFragment downloadMainFragment, View view) {
        IPremiumApi iPremiumApi;
        downloadMainFragment.w0();
        Context context = downloadMainFragment.getContext();
        if (context == null || (iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0])) == null) {
            return;
        }
        IPremiumApi.a.b(iPremiumApi, context, new b(), null, "downloadpage", downloadMainFragment.speedUpTipTraceId, "downloads/vip_icon", "", 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(DownloadMainFragment downloadMainFragment, View view) {
        FragmentActivity activity = downloadMainFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final boolean t0() {
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi != null) {
            return iPremiumApi.u();
        }
        return false;
    }

    private final void u0() {
        LotteryTipView lotteryTipView;
        DownloadTopIrregularView downloadTopIrregularView;
        BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView;
        if (ak.o.f721a.g()) {
            return;
        }
        py.w mViewBinding = getMViewBinding();
        if (mViewBinding != null && (biddingFloatingIrregularAnimationView = mViewBinding.f73073b) != null) {
            biddingFloatingIrregularAnimationView.loadAd();
        }
        py.w mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (downloadTopIrregularView = mViewBinding2.f73080i) != null) {
            downloadTopIrregularView.loadAd();
        }
        py.w mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (lotteryTipView = mViewBinding3.f73078g) == null) {
            return;
        }
        lotteryTipView.onFragmentResume();
    }

    private final void v0() {
        boolean z10 = ak.g.f714a.b() || ak.o.f721a.i();
        if (z10 && (this.contentFragment instanceof UGCDownloadManagerFragment)) {
            return;
        }
        if (z10 || !(this.contentFragment instanceof FileManagerFragment)) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            androidx.fragment.app.w p11 = childFragmentManager.p();
            Intrinsics.g(p11, "beginTransaction()");
            Bundle arguments = getArguments();
            Fragment uGCDownloadManagerFragment = z10 ? new UGCDownloadManagerFragment() : FileManagerFragment.INSTANCE.a(arguments != null ? arguments.getInt("extra_page_index", 0) : 0);
            this.contentFragment = uGCDownloadManagerFragment;
            if (uGCDownloadManagerFragment != null) {
                p11.s(R$id.fl_container, uGCDownloadManagerFragment);
            }
            p11.j();
        }
    }

    private final void w0() {
        com.transsion.baselib.helper.f.f43323a.f("downloadpage", "downloads/vip_icon", this.speedUpTipTraceId, "", 2);
    }

    private final void x0() {
        String b11 = ti.n.f76387a.b();
        this.speedUpTipTraceId = b11;
        com.transsion.baselib.helper.f.f43323a.h("downloadpage", "downloads/vip_icon", b11, "", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(DownloadMainFragment downloadMainFragment, Map result) {
        Intrinsics.h(result, "result");
        if (com.transsion.baselib.helper.e.f43321a.c(downloadMainFragment.requireContext())) {
            downloadMainFragment.m0();
        }
        Context context = downloadMainFragment.getContext();
        if (context != null) {
            bf.c.f16548a.c(context);
        }
    }

    private final void z0() {
        DownloadTopIrregularView downloadTopIrregularView;
        ScrollDetectFrameLayout scrollDetectFrameLayout;
        py.w mViewBinding = getMViewBinding();
        if (mViewBinding != null && (scrollDetectFrameLayout = mViewBinding.f73075d) != null) {
            scrollDetectFrameLayout.setOnScrollListener(new c());
        }
        py.w mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (downloadTopIrregularView = mViewBinding2.f73080i) == null) {
            return;
        }
        py.w mViewBinding3 = getMViewBinding();
        downloadTopIrregularView.setViewGroup(mViewBinding3 != null ? mViewBinding3.f73074c : null, androidx.view.v.a(this));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        Function1 function1 = new Function1() { // from class: com.transsnet.downloader.fragment.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p02;
                p02 = DownloadMainFragment.p0(DownloadMainFragment.this, (ak.n) obj);
                return p02;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = ak.n.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        py.w mViewBinding;
        AppCompatImageView appCompatImageView;
        BLTextView bLTextView;
        GradientTextView gradientTextView;
        GradientTextView gradientTextView2;
        Intrinsics.h(view, "view");
        py.w mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (gradientTextView2 = mViewBinding2.f73082k) != null) {
            gradientTextView2.setVisibility(!ak.o.f721a.i() ? 0 : 8);
        }
        py.w mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (gradientTextView = mViewBinding3.f73082k) != null) {
            gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DownloadMainFragment.q0(DownloadMainFragment.this, view2);
                }
            });
        }
        py.w mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (bLTextView = mViewBinding4.f73079h) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DownloadMainFragment.r0(DownloadMainFragment.this, view2);
                }
            });
        }
        A0();
        if ((getActivity() instanceof DownloadPanelActivity) && (mViewBinding = getMViewBinding()) != null && (appCompatImageView = mViewBinding.f73077f) != null) {
            jg.c.k(appCompatImageView);
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DownloadMainFragment.s0(DownloadMainFragment.this, view2);
                }
            });
        }
        z0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        i0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.resumeTimeStamp;
            a.C0856a.r(lg.a.f68962a, "Report", new String[]{"Subscription fb log duration:" + elapsedRealtime}, false, 4, null);
            com.transsion.baselib.report.e.f43398a.n("Subscription", Long.valueOf(elapsedRealtime), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public py.w getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.w c11 = py.w.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this).statusBarDarkFont(!ak.x.f733a.a()).init();
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.E(this);
        }
        v0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.t(this);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        u0();
        A0();
    }

    @Override // zm.e
    public void onMemberStateChange() {
        A0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        u0();
        A0();
    }
}
