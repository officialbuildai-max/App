package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
import androidx.view.v0;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.memberapi.IMemberApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.fragment.ad.AppDownloadAdFragment;
import com.transsnet.downloader.fragment.ad.TopCardAdFragment;
import com.transsnet.downloader.manager.p;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import com.transsnet.downloader.viewmodel.LocalFileViewModel;
import com.transsnet.downloader.viewmodel.TransferReceivedViewModel;
import com.transsnet.downloader.widget.FileManagerTabTitleView;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import net.lucode.hackware.magicindicator.MagicIndicator;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 h2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001iB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u00062\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0016¢\u0006\u0004\b,\u0010-J!\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b0\u00101J!\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b2\u00101J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010\u0005J\r\u00104\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u0005J\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0005J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\u0005J\u0017\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0006H\u0016¢\u0006\u0004\b=\u0010\u0005J\u000f\u0010>\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u0010\u0005J\u000f\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010\u0005R\u0016\u0010B\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010OR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010E\u001a\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR \u0010_\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020X0\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010g\u001a\u00020`8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006j"}, d2 = {"Lcom/transsnet/downloader/fragment/FileManagerFragment;", "Lcom/transsnet/downloader/fragment/DownloadTabBaseFragment;", "Lpy/h0;", "Lzm/e;", "<init>", "()V", "", "initViewModel", "", RequestParameters.POSITION, "count", "c1", "(II)V", "N0", "L0", "O0", "S0", "initAd", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "R0", "(Landroid/view/LayoutInflater;)Lpy/h0;", "Landroidx/viewpager2/widget/ViewPager2;", "z0", "()Landroidx/viewpager2/widget/ViewPager2;", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "r0", "()Lnet/lucode/hackware/magicindicator/MagicIndicator;", "t0", "(I)V", "state", "s0", "Landroidx/fragment/app/Fragment;", "d0", "(I)Landroidx/fragment/app/Fragment;", "", "", "f0", "()Ljava/util/List;", "list", "u0", "(Ljava/util/List;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "b1", "onDestroy", TmcConstants.NAVIGATION_ON_START, "onResume", "", "hidden", "onHiddenChanged", "(Z)V", "onPause", "logPause", "logResume", "onMemberStateChange", CampaignEx.JSON_KEY_AD_K, "Z", "isFirstStart", "Lcom/transsnet/downloader/viewmodel/TransferReceivedViewModel;", "l", "Lkotlin/Lazy;", "Q0", "()Lcom/transsnet/downloader/viewmodel/TransferReceivedViewModel;", "mTransferViewModel", "Lcom/transsnet/downloader/viewmodel/LocalFileViewModel;", "m", "P0", "()Lcom/transsnet/downloader/viewmodel/LocalFileViewModel;", "mLocalFileViewModel", "n", "Landroidx/fragment/app/Fragment;", "topCardAdFragment", "o", "appDownloadAdFragment", "Lcom/transsnet/downloader/manager/g;", TtmlNode.TAG_P, "M0", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "Lcom/transsnet/downloader/fragment/DownloadListBaseFragment;", CampaignEx.JSON_KEY_AD_Q, "Lcom/transsnet/downloader/fragment/DownloadListBaseFragment;", "currentFragment", "", CampaignEx.JSON_KEY_AD_R, "Ljava/util/Map;", "fragmentMap", "", "s", "J", "getResumeTimeStamp", "()J", "setResumeTimeStamp", "(J)V", "resumeTimeStamp", "t", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FileManagerFragment extends DownloadTabBaseFragment<py.h0> implements zm.e {

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private Fragment topCardAdFragment;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Fragment appDownloadAdFragment;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private DownloadListBaseFragment currentFragment;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstStart = true;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy mTransferViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(TransferReceivedViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLocalFileViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(LocalFileViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$special$$inlined$activityViewModels$default$4
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

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadManager = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.b6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g K0;
            K0 = FileManagerFragment.K0();
            return K0;
        }
    });

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Map fragmentMap = new LinkedHashMap();

    /* renamed from: com.transsnet.downloader.fragment.FileManagerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FileManagerFragment a(int i11) {
            FileManagerFragment fileManagerFragment = new FileManagerFragment();
            fileManagerFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_page_index", Integer.valueOf(i11))));
            return fileManagerFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59186a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59186a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59186a;
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
            this.f59186a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g K0() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    private final void L0() {
        j0().H();
        TransferReceivedViewModel.i(Q0(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.g M0() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    private final void N0() {
        j0().P();
    }

    private final void O0() {
        LocalFileViewModel.k(P0(), false, 1, null);
    }

    private final LocalFileViewModel P0() {
        return (LocalFileViewModel) this.mLocalFileViewModel.getValue();
    }

    private final TransferReceivedViewModel Q0() {
        return (TransferReceivedViewModel) this.mTransferViewModel.getValue();
    }

    private final void S0() {
        Function1 function1 = new Function1() { // from class: com.transsnet.downloader.fragment.g6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = FileManagerFragment.T0(FileManagerFragment.this, (DownloadRefreshEvent) obj);
                return T0;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadRefreshEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.y0.c().q(), false, function1);
        Function1 function12 = new Function1() { // from class: com.transsnet.downloader.fragment.h6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit U0;
                U0 = FileManagerFragment.U0(FileManagerFragment.this, (AddToDownloadEvent) obj);
                return U0;
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = AddToDownloadEvent.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.y0.c().q(), false, function12);
        Function1 function13 = new Function1() { // from class: com.transsnet.downloader.fragment.i6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit V0;
                V0 = FileManagerFragment.V0(FileManagerFragment.this, (jv.e) obj);
                return V0;
            }
        };
        FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name3 = jv.e.class.getName();
        Intrinsics.g(name3, "getName(...)");
        flowEventBus3.observeEvent(this, name3, state, kotlinx.coroutines.y0.c().q(), false, function13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(FileManagerFragment fileManagerFragment, DownloadRefreshEvent value) {
        Intrinsics.h(value, "value");
        String resourceId = value.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            fileManagerFragment.j0().H();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit U0(FileManagerFragment fileManagerFragment, AddToDownloadEvent value) {
        FrameLayout frameLayout;
        Intrinsics.h(value, "value");
        py.h0 h0Var = (py.h0) fileManagerFragment.getMViewBinding();
        if (h0Var != null && (frameLayout = h0Var.f72867d) != null && frameLayout.getVisibility() != 0 && fileManagerFragment.isVisible() && value.getAdd()) {
            fileManagerFragment.N0();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(final FileManagerFragment fileManagerFragment, jv.e value) {
        Intrinsics.h(value, "value");
        lg.a.f68962a.c(TransferBottomToolsView.TAG, "TransferFinishEvent， 有传输完成，刷新页面", true);
        fileManagerFragment.j0().r0(value.a(), new Function0() { // from class: com.transsnet.downloader.fragment.j6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit W0;
                W0 = FileManagerFragment.W0(FileManagerFragment.this);
                return W0;
            }
        });
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(FileManagerFragment fileManagerFragment) {
        TransferReceivedViewModel.i(fileManagerFragment.Q0(), false, 1, null);
        fileManagerFragment.j0().d0().q(Boolean.TRUE);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(FileManagerFragment fileManagerFragment, List list) {
        fileManagerFragment.c1(0, list != null ? list.size() : 0);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(FileManagerFragment fileManagerFragment, List list) {
        fileManagerFragment.c1(1, list != null ? list.size() : 0);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(FileManagerFragment fileManagerFragment, List list) {
        fileManagerFragment.c1(2, list != null ? list.size() : 0);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a1(FileManagerFragment fileManagerFragment, List list) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            a.C0856a.z(lg.a.f68962a, fileManagerFragment.getTAG(), "downloading null- hide fragment", false, 4, null);
            py.h0 h0Var = (py.h0) fileManagerFragment.getMViewBinding();
            if (h0Var != null && (frameLayout = h0Var.f72867d) != null) {
                jg.c.g(frameLayout);
            }
        } else {
            py.h0 h0Var2 = (py.h0) fileManagerFragment.getMViewBinding();
            if (h0Var2 == null || (frameLayout3 = h0Var2.f72867d) == null || frameLayout3.getVisibility() != 0) {
                py.h0 h0Var3 = (py.h0) fileManagerFragment.getMViewBinding();
                if (h0Var3 != null && (frameLayout2 = h0Var3.f72867d) != null) {
                    jg.c.k(frameLayout2);
                }
                a.C0856a c0856a = lg.a.f68962a;
                a.C0856a.f(c0856a, fileManagerFragment.getTAG(), "downloading have data, show fragment", false, 4, null);
                Fragment k02 = fileManagerFragment.getChildFragmentManager().k0("DownloadingListFragment");
                if (k02 == null) {
                    k02 = new DownloadingListFragment();
                }
                Fragment fragment = k02;
                if (fragment.isAdded()) {
                    a.C0856a.f(c0856a, fileManagerFragment.getTAG(), "downloading have data, isAdded, show", false, 4, null);
                    fileManagerFragment.getChildFragmentManager().p().y(fragment).l();
                } else {
                    a.C0856a.f(c0856a, fileManagerFragment.getTAG(), "downloading have data, add", false, 4, null);
                    fileManagerFragment.getChildFragmentManager().p().c(R$id.flDownloadingContainer, fragment, "DownloadingListFragment").l();
                }
            } else {
                a.C0856a.f(lg.a.f68962a, fileManagerFragment.getTAG(), "downloading have data, fragment is shown", false, 4, null);
            }
        }
        return Unit.f67184a;
    }

    private final void c1(int position, int count) {
        String str;
        a.C0856a.z(lg.a.f68962a, getTAG(), "updateTabTitle - position:" + position + ",count:" + count, false, 4, null);
        if (position >= i0().size()) {
            return;
        }
        Object obj = i0().get(position);
        if (count > 0) {
            str = " " + count;
        } else {
            str = "";
        }
        String str2 = obj + str;
        ORCommonNavigator commonNavigator = getCommonNavigator();
        j00.d pagerTitleView = commonNavigator != null ? commonNavigator.getPagerTitleView(position) : null;
        FileManagerTabTitleView fileManagerTabTitleView = pagerTitleView instanceof FileManagerTabTitleView ? (FileManagerTabTitleView) pagerTitleView : null;
        if (fileManagerTabTitleView != null) {
            fileManagerTabTitleView.setTitle(str2, count, position);
        }
    }

    private final void initAd() {
        Fragment k02 = getChildFragmentManager().k0("TopCardAdFragment");
        this.topCardAdFragment = k02;
        if (k02 == null) {
            this.topCardAdFragment = new TopCardAdFragment();
        }
        Fragment fragment = this.topCardAdFragment;
        if (fragment != null) {
            ak.m mVar = ak.m.f719a;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            ak.m.b(mVar, childFragmentManager, R$id.flTopCardAd, fragment, false, null, 24, null);
        }
        Fragment k03 = getChildFragmentManager().k0("AppDownloadAdFragment");
        this.appDownloadAdFragment = k03;
        if (k03 == null) {
            this.appDownloadAdFragment = new AppDownloadAdFragment();
        }
        Fragment fragment2 = this.appDownloadAdFragment;
        if (fragment2 != null) {
            ak.m mVar2 = ak.m.f719a;
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.g(childFragmentManager2, "getChildFragmentManager(...)");
            ak.m.b(mVar2, childFragmentManager2, R$id.flAppDownloadAd, fragment2, false, null, 24, null);
        }
    }

    private final void initViewModel() {
        j0().O().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.c6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit X0;
                X0 = FileManagerFragment.X0(FileManagerFragment.this, (List) obj);
                return X0;
            }
        }));
        P0().i().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.d6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Y0;
                Y0 = FileManagerFragment.Y0(FileManagerFragment.this, (List) obj);
                return Y0;
            }
        }));
        Q0().j().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.e6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Z0;
                Z0 = FileManagerFragment.Z0(FileManagerFragment.this, (List) obj);
                return Z0;
            }
        }));
        j0().Q().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.f6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit a12;
                a12 = FileManagerFragment.a1(FileManagerFragment.this, (List) obj);
                return a12;
            }
        }));
        L0();
        O0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public py.h0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.h0 c11 = py.h0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b1() {
        AppCompatTextView appCompatTextView;
        long a11 = com.blankj.utilcode.util.w.a();
        if (a11 > 0) {
            String a12 = oh.b.a(a11, 1);
            py.h0 h0Var = (py.h0) getMViewBinding();
            if (h0Var == null || (appCompatTextView = h0Var.f72870g) == null) {
                return;
            }
            appCompatTextView.setText(a12);
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public Fragment d0(int position) {
        Fragment a11;
        if (position == 0) {
            a11 = DownloadedListFragment.INSTANCE.a();
            this.fragmentMap.put(Integer.valueOf(position), a11);
        } else if (position == 1) {
            a11 = LocalFileListFragment.INSTANCE.a();
            this.fragmentMap.put(Integer.valueOf(position), a11);
        } else {
            if (position != 2) {
                return DownloadedListFragment.INSTANCE.a();
            }
            a11 = TransferReceivedFragment.INSTANCE.a();
            this.fragmentMap.put(Integer.valueOf(position), a11);
        }
        return a11;
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public List f0() {
        return (List) j0().K().f();
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        b1();
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new FileManagerFragment$initData$1(this, null), 3, null);
        DownloadSDCardUtil.f60017a.b();
        initViewModel();
        S0();
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initView(view, savedInstanceState);
        initAd();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            com.transsion.baselib.report.e.f43398a.n("downloadpage", Long.valueOf(SystemClock.elapsedRealtime() - this.resumeTimeStamp), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        y0(arguments != null ? arguments.getInt("extra_page_index") : 0);
        if (com.transsnet.downloader.manager.p.f59623a.a(Utils.a()).i()) {
            y0(0);
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.E(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.t(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        Fragment fragment = this.topCardAdFragment;
        TopCardAdFragment topCardAdFragment = fragment instanceof TopCardAdFragment ? (TopCardAdFragment) fragment : null;
        if (topCardAdFragment != null) {
            topCardAdFragment.k0();
        }
        Fragment fragment2 = this.appDownloadAdFragment;
        AppDownloadAdFragment appDownloadAdFragment = fragment2 instanceof AppDownloadAdFragment ? (AppDownloadAdFragment) fragment2 : null;
        if (appDownloadAdFragment != null) {
            appDownloadAdFragment.o0();
        }
        L0();
    }

    @Override // zm.e
    public void onMemberStateChange() {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        boolean g11 = iMemberApi != null ? iMemberApi.g() : false;
        a.C0856a.f(lg.a.f68962a, "co_mem", "下载管理页面收到回调 --> skipShowAd = " + g11, false, 4, null);
        oy.c cVar = new oy.c();
        ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        UserInfo i11 = iLoginApi != null ? iLoginApi.i() : null;
        if (i11 == null || i11.getUserType() != 0) {
            IMemberApi iMemberApi2 = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
            cVar.m(iMemberApi2 != null ? iMemberApi2.D() : 1);
        } else {
            cVar.m(1);
        }
        p.a aVar = com.transsnet.downloader.manager.p.f59623a;
        p.a.b(aVar, null, 1, null).r(cVar);
        p.a.b(aVar, null, 1, null).w();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.k.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.k.p(null, this, "visible=" + isVisible(), 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (isVisible()) {
            if (this.isFirstStart) {
                this.isFirstStart = false;
            } else {
                L0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public MagicIndicator r0() {
        py.h0 h0Var = (py.h0) getMViewBinding();
        if (h0Var != null) {
            return h0Var.f72869f;
        }
        return null;
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void s0(int state) {
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void t0(int position) {
        this.currentFragment = (DownloadListBaseFragment) this.fragmentMap.get(Integer.valueOf(position));
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void u0(List list) {
        j0().K().q(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public ViewPager2 z0() {
        py.h0 h0Var = (py.h0) getMViewBinding();
        if (h0Var != null) {
            return h0Var.f72871h;
        }
        return null;
    }
}
