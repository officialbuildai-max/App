package com.transsion.usercenter.devicemanagement.fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.c0;
import androidx.view.m;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.transsion.base.report.athena.BrowseType;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.devicemanagement.viewmodel.DeviceManagementViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import fw.i0;
import hj.i;
import java.util.HashMap;
import java.util.List;
import jw.a;
import jw.c;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0007¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0007H\u0016¢\u0006\u0004\b*\u0010\u0004R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/transsion/usercenter/devicemanagement/fragment/DeviceManagementFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lfw/i0;", "<init>", "()V", "Ljw/b;", "model", "", "o0", "(Ljw/b;)V", "s0", "", "isSuccess", "k0", "(Z)V", "isPro", "p0", "", "moduleName", NativeComponentConstants.KEY_COMPONENT_TYPE, "q0", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/fragment/app/FragmentActivity;", "r0", "()Landroidx/fragment/app/FragmentActivity;", "Landroid/view/LayoutInflater;", "inflater", "l0", "(Landroid/view/LayoutInflater;)Lfw/i0;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "loadDefaultData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", ToolBar.REFRESH, "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "retryLoadData", "Lcom/transsion/usercenter/devicemanagement/viewmodel/DeviceManagementViewModel;", "a", "Lkotlin/Lazy;", "m0", "()Lcom/transsion/usercenter/devicemanagement/viewmodel/DeviceManagementViewModel;", "viewModel", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "J", "loadStartedAt", "c", "Z", "hasReportedFeatureExposure", "Lcom/transsion/usercenter/devicemanagement/adapter/a;", "d", "Lcom/transsion/usercenter/devicemanagement/adapter/a;", "pageAdapter", "e", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class DeviceManagementFragment extends PageStatusFragment<i0> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long loadStartedAt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasReportedFeatureExposure;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.transsion.usercenter.devicemanagement.adapter.a pageAdapter;

    /* loaded from: classes6.dex */
    static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f56801a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f56801a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f56801a;
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
            this.f56801a.invoke(obj);
        }
    }

    public DeviceManagementFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.devicemanagement.fragment.DeviceManagementFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(DeviceManagementViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.devicemanagement.fragment.DeviceManagementFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.devicemanagement.fragment.DeviceManagementFragment$special$$inlined$viewModels$default$3
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
        this.pageAdapter = new com.transsion.usercenter.devicemanagement.adapter.a();
    }

    private final void k0(boolean isSuccess) {
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

    private final DeviceManagementViewModel m0() {
        return (DeviceManagementViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(DeviceManagementFragment deviceManagementFragment, c cVar) {
        if (deviceManagementFragment.r0() == null) {
            return Unit.f67184a;
        }
        if (Intrinsics.c(cVar, c.b.f66441a)) {
            deviceManagementFragment.showLoadingView();
        } else if (Intrinsics.c(cVar, c.a.f66440a)) {
            deviceManagementFragment.k0(false);
            PageStatusFragment.showErrorView$default(deviceManagementFragment, false, 1, null);
        } else {
            if (!(cVar instanceof c.C0832c)) {
                throw new NoWhenBranchMatchedException();
            }
            c.C0832c c0832c = (c.C0832c) cVar;
            deviceManagementFragment.o0(c0832c.a());
            deviceManagementFragment.k0(true);
            deviceManagementFragment.p0(c0832c.a().i());
            deviceManagementFragment.showContentView();
        }
        return Unit.f67184a;
    }

    private final void o0(jw.b model) {
        List c11 = CollectionsKt.c();
        c11.add(new a.e(model));
        if (model.i()) {
            c11.add(a.d.f66429a);
        } else {
            c11.add(new a.C0831a(model));
        }
        c11.add(new a.c(model.d()));
        String c12 = model.c();
        if (c12 == null) {
            c12 = "";
        }
        c11.add(new a.b(c12));
        this.pageAdapter.n1(CollectionsKt.a(c11));
    }

    private final void p0(boolean isPro) {
        if (this.hasReportedFeatureExposure) {
            return;
        }
        this.hasReportedFeatureExposure = true;
        q0("link_device", isPro ? "pro" : "basic");
    }

    private final void q0(String moduleName, String type) {
        i.f64628a.E("/profile/device_management", MapsKt.j(TuplesKt.a("module_name", moduleName), TuplesKt.a(NativeComponentConstants.KEY_COMPONENT_TYPE, type)), BrowseType.FEATURE);
    }

    private final FragmentActivity r0() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    private final void s0() {
        HashMap g11;
        this.loadStartedAt = SystemClock.elapsedRealtime();
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
            return;
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View getLoadingView() {
        ConstraintLayout root = fw.y0.c(getLayoutInflater(), getFlStateView(), false).getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return root;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        String string = getString(R$string.user_center_device_management_title);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        RecyclerView recyclerView;
        i0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f62814b) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            recyclerView.setAdapter(this.pageAdapter);
            recyclerView.setOverScrollMode(2);
        }
        showLoadingView();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        m0().k().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.usercenter.devicemanagement.fragment.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n02;
                n02 = DeviceManagementFragment.n0(DeviceManagementFragment.this, (c) obj);
                return n02;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public i0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        i0 c11 = i0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        retryLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("/profile/device_management", false, 2, null);
    }

    public final void refresh() {
        retryLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        s0();
        showLoadingView();
        m0().l();
    }
}
