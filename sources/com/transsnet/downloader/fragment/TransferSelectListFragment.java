package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.viewmodel.LocalFileViewModel;
import com.transsnet.downloader.viewmodel.TransferReceivedViewModel;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
import lg.a;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 ^2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0019\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0015H\u0002¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010 J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u001cH\u0016¢\u0006\u0004\b(\u0010\u001eJ\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020)H\u0016¢\u0006\u0004\b,\u0010+J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u001cH\u0016¢\u0006\u0004\b.\u0010\u001eJ\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u0010\u0004J\u000f\u00101\u001a\u00020\u0005H\u0016¢\u0006\u0004\b1\u0010\u0004J\u0017\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020)H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0005H\u0016¢\u0006\u0004\b5\u0010\u0004J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u001c8\u0002X\u0082D¢\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010>\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010>\u001a\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010:R\u0016\u0010S\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR.\u0010]\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001c Z*\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010Y0Y0X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006_"}, d2 = {"Lcom/transsnet/downloader/fragment/TransferSelectListFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lpy/m0;", "<init>", "()V", "", "F0", "I0", "L0", "K0", "u0", "", "Lcom/transsion/baselib/db/download/DownloadBean;", "list", "V0", "(Ljava/util/List;)V", "C0", "(Ljava/util/List;)Ljava/util/List;", "data", "S0", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", RequestParameters.POSITION, "R0", "(Lcom/transsion/baselib/db/download/DownloadBean;Landroid/view/View;I)V", "U0", "", "getPageName", "()Ljava/lang/String;", "y0", "()Landroid/view/View;", "D0", "w0", "Landroid/view/LayoutInflater;", "inflater", "E0", "(Landroid/view/LayoutInflater;)Lpy/m0;", "receiveArguments", "getPageStateLayoutTitle", "", "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "initViewData", "getEmptyDescText", "initViewModel", "initListener", "retryLoadData", "hidden", "onHiddenChanged", "(Z)V", "loadDefaultData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "a", "Ljava/lang/String;", "TAG", "Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "v0", "()Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "downloadViewModel", "Lcom/transsnet/downloader/viewmodel/LocalFileViewModel;", "c", "A0", "()Lcom/transsnet/downloader/viewmodel/LocalFileViewModel;", "mLocalFileViewModel", "Lcom/transsnet/downloader/viewmodel/TransferReceivedViewModel;", "d", "B0", "()Lcom/transsnet/downloader/viewmodel/TransferReceivedViewModel;", "mTransferViewModel", "e", "Landroid/view/View;", "mEmptyView", "f", "tabName", be.g.f16474b, "I", "tabIndex", "Lcom/transsnet/downloader/adapter/x0;", "h", "Lcom/transsnet/downloader/adapter/x0;", "transferSelectAdapter", "Landroidx/activity/result/b;", "", "kotlin.jvm.PlatformType", "i", "Landroidx/activity/result/b;", "requestMultiplePermission", com.mbridge.msdk.foundation.same.report.j.f35620b, "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class TransferSelectListFragment extends PageStatusFragment<py.m0> {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mEmptyView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int tabIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.transsnet.downloader.adapter.x0 transferSelectAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final androidx.activity.result.b requestMultiplePermission;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = TransferBottomToolsView.TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(DownloadViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$2
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
    private final Lazy mLocalFileViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(LocalFileViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$4
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

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy mTransferViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(TransferReceivedViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$5
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$6
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

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String tabName = "";

    /* renamed from: com.transsnet.downloader.fragment.TransferSelectListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransferSelectListFragment a(int i11, String tabName) {
            Intrinsics.h(tabName, "tabName");
            TransferSelectListFragment transferSelectListFragment = new TransferSelectListFragment();
            transferSelectListFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_download_out_file_tab_name", tabName), TuplesKt.a("extra_page_index", Integer.valueOf(i11))));
            return transferSelectListFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59239a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59239a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59239a;
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
            this.f59239a.invoke(obj);
        }
    }

    public TransferSelectListFragment() {
        androidx.activity.result.b registerForActivityResult = registerForActivityResult(new f.h(), new androidx.activity.result.a() { // from class: com.transsnet.downloader.fragment.b8
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                TransferSelectListFragment.T0(TransferSelectListFragment.this, (Map) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.requestMultiplePermission = registerForActivityResult;
    }

    private final LocalFileViewModel A0() {
        return (LocalFileViewModel) this.mLocalFileViewModel.getValue();
    }

    private final TransferReceivedViewModel B0() {
        return (TransferReceivedViewModel) this.mTransferViewModel.getValue();
    }

    private final List C0(List list) {
        List<Object> data;
        Object obj;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it.next();
            com.transsnet.downloader.adapter.x0 x0Var = this.transferSelectAdapter;
            if (x0Var != null && (data = x0Var.getData()) != null) {
                Iterator<T> it2 = data.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    DownloadBean downloadBean2 = (DownloadBean) obj;
                    if (!downloadBean2.isInnerRes()) {
                        if (Intrinsics.c(downloadBean2.getPath(), downloadBean.getPath()) && Intrinsics.c(downloadBean2.getResourceId(), downloadBean.getResourceId())) {
                            break;
                        }
                    } else if (Intrinsics.c(downloadBean2.getSubjectId(), downloadBean.getSubjectId()) && downloadBean2.getResolution() == downloadBean.getResolution() && downloadBean2.getEp() == downloadBean.getEp() && downloadBean2.getSe() == downloadBean.getSe()) {
                        break;
                    }
                }
                DownloadBean downloadBean3 = (DownloadBean) obj;
                if (downloadBean3 != null) {
                    arrayList.add(downloadBean3);
                }
            }
            arrayList.add(downloadBean);
        }
        return arrayList;
    }

    private final View D0() {
        if (this.mEmptyView == null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            StateView stateView = new StateView(requireContext);
            String string = Utils.a().getString(R$string.download_transfer_received_empty_tips);
            Intrinsics.g(string, "getString(...)");
            stateView.showData(2, 2, false, "", string);
            this.mEmptyView = stateView;
        }
        View view = this.mEmptyView;
        Intrinsics.e(view);
        return view;
    }

    private final void F0() {
        v0().O().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.d8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G0;
                G0 = TransferSelectListFragment.G0(TransferSelectListFragment.this, (List) obj);
                return G0;
            }
        }));
        v0().i0().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.e8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = TransferSelectListFragment.H0(TransferSelectListFragment.this, (DownloadBean) obj);
                return H0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(TransferSelectListFragment transferSelectListFragment, List list) {
        SwipeRefreshLayout swipeRefreshLayout;
        py.m0 mViewBinding;
        SwipeRefreshLayout swipeRefreshLayout2;
        py.m0 mViewBinding2 = transferSelectListFragment.getMViewBinding();
        if (mViewBinding2 != null && (swipeRefreshLayout = mViewBinding2.f72971c) != null && swipeRefreshLayout.isRefreshing() && (mViewBinding = transferSelectListFragment.getMViewBinding()) != null && (swipeRefreshLayout2 = mViewBinding.f72971c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            com.transsnet.downloader.adapter.x0 x0Var = transferSelectListFragment.transferSelectAdapter;
            if (x0Var != null) {
                x0Var.Y0(transferSelectListFragment.w0());
            }
        } else {
            transferSelectListFragment.V0(CollectionsKt.U0(list2));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(TransferSelectListFragment transferSelectListFragment, DownloadBean downloadBean) {
        List<Object> data;
        com.transsnet.downloader.adapter.x0 x0Var = transferSelectListFragment.transferSelectAdapter;
        if (x0Var != null && (data = x0Var.getData()) != null) {
            Iterator<Object> it = data.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                }
                DownloadBean downloadBean2 = (DownloadBean) it.next();
                boolean z10 = true;
                if (downloadBean2.isInnerRes()) {
                    if (!Intrinsics.c(downloadBean2.getSubjectId(), downloadBean != null ? downloadBean.getSubjectId() : null) || downloadBean == null || downloadBean2.getResolution() != downloadBean.getResolution() || downloadBean == null || downloadBean2.getEp() != downloadBean.getEp() || downloadBean == null || downloadBean2.getSe() != downloadBean.getSe()) {
                        z10 = false;
                    }
                } else {
                    z10 = Intrinsics.c(downloadBean2.getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null);
                }
                if (z10) {
                    break;
                }
                i11++;
            }
            if (i11 >= 0) {
                a.C0856a.f(lg.a.f68962a, transferSelectListFragment.TAG, "外部列表，刷新index:" + i11, false, 4, null);
                com.transsnet.downloader.adapter.x0 x0Var2 = transferSelectListFragment.transferSelectAdapter;
                if (x0Var2 != null) {
                    x0Var2.notifyItemChanged(i11, downloadBean);
                }
            }
        }
        return Unit.f67184a;
    }

    private final void I0() {
        A0().i().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.g8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit J0;
                J0 = TransferSelectListFragment.J0(TransferSelectListFragment.this, (List) obj);
                return J0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(TransferSelectListFragment transferSelectListFragment, List list) {
        SwipeRefreshLayout swipeRefreshLayout;
        py.m0 mViewBinding;
        SwipeRefreshLayout swipeRefreshLayout2;
        py.m0 mViewBinding2 = transferSelectListFragment.getMViewBinding();
        if (mViewBinding2 != null && (swipeRefreshLayout = mViewBinding2.f72971c) != null && swipeRefreshLayout.isRefreshing() && (mViewBinding = transferSelectListFragment.getMViewBinding()) != null && (swipeRefreshLayout2 = mViewBinding.f72971c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        a.C0856a.f(lg.a.f68962a, transferSelectListFragment.TAG, "获取到外部数据all:" + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        transferSelectListFragment.showContentView();
        if (!com.transsnet.downloader.viewmodel.a0.f60208a.a()) {
            transferSelectListFragment.U0();
            return Unit.f67184a;
        }
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            transferSelectListFragment.V0(list);
            return Unit.f67184a;
        }
        com.transsnet.downloader.adapter.x0 x0Var = transferSelectListFragment.transferSelectAdapter;
        if (x0Var != null) {
            x0Var.Y0(transferSelectListFragment.y0());
        }
        return Unit.f67184a;
    }

    private final void K0() {
    }

    private final void L0() {
        B0().j().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.f8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit M0;
                M0 = TransferSelectListFragment.M0(TransferSelectListFragment.this, (List) obj);
                return M0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(TransferSelectListFragment transferSelectListFragment, List list) {
        SwipeRefreshLayout swipeRefreshLayout;
        py.m0 mViewBinding;
        SwipeRefreshLayout swipeRefreshLayout2;
        py.m0 mViewBinding2 = transferSelectListFragment.getMViewBinding();
        if (mViewBinding2 != null && (swipeRefreshLayout = mViewBinding2.f72971c) != null && swipeRefreshLayout.isRefreshing() && (mViewBinding = transferSelectListFragment.getMViewBinding()) != null && (swipeRefreshLayout2 = mViewBinding.f72971c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        transferSelectListFragment.showContentView();
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            com.transsnet.downloader.adapter.x0 x0Var = transferSelectListFragment.transferSelectAdapter;
            if (x0Var != null) {
                x0Var.Y0(transferSelectListFragment.D0());
            }
        } else {
            transferSelectListFragment.V0(list);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(TransferSelectListFragment transferSelectListFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = adapter.getItem(i11);
        DownloadBean downloadBean = item instanceof DownloadBean ? (DownloadBean) item : null;
        if (downloadBean == null || !downloadBean.isSeriesCollection()) {
            transferSelectListFragment.R0(downloadBean, view, i11);
        } else {
            transferSelectListFragment.S0(downloadBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(TransferSelectListFragment transferSelectListFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (view.getId() == R$id.v_more) {
            Object item = adapter.getItem(i11);
            transferSelectListFragment.R0(item instanceof DownloadBean ? (DownloadBean) item : null, view, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(TransferSelectListFragment transferSelectListFragment) {
        transferSelectListFragment.u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(TransferSelectListFragment transferSelectListFragment, Boolean bool) {
        List<Object> data;
        com.transsnet.downloader.adapter.x0 x0Var = transferSelectListFragment.transferSelectAdapter;
        if (x0Var != null && (data = x0Var.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                if (downloadBean.isSeriesCollection()) {
                    Iterator<T> it2 = downloadBean.getSeriesList().iterator();
                    while (it2.hasNext()) {
                        ((DownloadBean) it2.next()).setCheck(false);
                    }
                }
                downloadBean.setCheck(false);
            }
        }
        com.transsnet.downloader.adapter.x0 x0Var2 = transferSelectListFragment.transferSelectAdapter;
        if (x0Var2 != null) {
            x0Var2.notifyDataSetChanged();
        }
        return Unit.f67184a;
    }

    private final void R0(DownloadBean data, View view, int position) {
        List<DownloadBean> arrayList;
        Object obj;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        v0().a0().q(TransferBottomToolsView.STATUS_SEND);
        androidx.view.b0 f02 = v0().f0(this.tabIndex);
        if (f02 == null || (arrayList = (List) f02.f()) == null) {
            arrayList = new ArrayList();
        }
        if (data == null || !data.getIsCheck()) {
            if (data != null) {
                data.setCheck(true);
            }
            if (data != null) {
                arrayList.add(data);
                DownloadUtil.f60023a.I(true, data);
                androidx.view.b0 f03 = v0().f0(this.tabIndex);
                if (f03 != null) {
                    f03.q(arrayList);
                }
            }
        } else if (DownloadUtil.f60023a.C(data)) {
            data.setCheck(false);
            int i11 = 0;
            try {
                for (DownloadBean downloadBean : arrayList) {
                    if (!(downloadBean.isSeries() ? Intrinsics.c(downloadBean.getSubjectId(), data.getSubjectId()) && downloadBean.getResolution() == data.getResolution() && downloadBean.getEp() == data.getEp() && downloadBean.getSe() == data.getSe() : Intrinsics.c(downloadBean.getResourceId(), data.getResourceId()))) {
                        i11++;
                    }
                }
                Result.Companion companion = Result.INSTANCE;
                if (i11 >= 0) {
                    arrayList.remove(i11);
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
            i11 = -1;
            DownloadUtil.f60023a.I(false, data);
            androidx.view.b0 f04 = v0().f0(this.tabIndex);
            if (f04 != null) {
                f04.q(arrayList);
            }
        } else {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.c((DownloadBean) obj, data)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj == null) {
                arrayList.add(data);
            }
            DownloadUtil.f60023a.I(true, data);
            androidx.view.b0 f05 = v0().f0(this.tabIndex);
            if (f05 != null) {
                f05.q(arrayList);
            }
        }
        v0().h0().q(Integer.valueOf(DownloadUtil.f60023a.w(arrayList)));
        a.C0856a.f(lg.a.f68962a, this.TAG, "onItemCheckClick selectedList size:" + arrayList.size(), false, 4, null);
        com.transsnet.downloader.adapter.x0 x0Var = this.transferSelectAdapter;
        if (x0Var != null) {
            x0Var.notifyItemChanged(position, data);
        }
    }

    private final void S0(DownloadBean data) {
        v0().c0().q(Boolean.TRUE);
        v0().b0().q(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(TransferSelectListFragment transferSelectListFragment, Map result) {
        Intrinsics.h(result, "result");
        if (!com.transsion.baselib.helper.e.f43321a.c(transferSelectListFragment.requireContext())) {
            transferSelectListFragment.U0();
        } else {
            transferSelectListFragment.showLoadingView();
            transferSelectListFragment.A0().j(true);
        }
    }

    private final void U0() {
        com.transsnet.downloader.adapter.x0 x0Var = this.transferSelectAdapter;
        if (x0Var != null) {
            x0Var.Y0(y0());
        }
    }

    private final void V0(List list) {
        List<Object> data;
        SwipeRefreshLayout swipeRefreshLayout;
        py.m0 mViewBinding;
        SwipeRefreshLayout swipeRefreshLayout2;
        py.m0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (swipeRefreshLayout = mViewBinding2.f72971c) != null && swipeRefreshLayout.isRefreshing() && (mViewBinding = getMViewBinding()) != null && (swipeRefreshLayout2 = mViewBinding.f72971c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        a.C0856a c0856a = lg.a.f68962a;
        String str = this.TAG;
        int i11 = this.tabIndex;
        int size = list.size();
        com.transsnet.downloader.adapter.x0 x0Var = this.transferSelectAdapter;
        a.C0856a.f(c0856a, str, "updateList tabIndex:" + i11 + ", size:" + size + ", curSize:" + ((x0Var == null || (data = x0Var.getData()) == null) ? null : Integer.valueOf(data.size())), false, 4, null);
        com.transsnet.downloader.adapter.x0 x0Var2 = this.transferSelectAdapter;
        if (x0Var2 != null) {
            x0Var2.n1(C0(list));
        }
    }

    private final String getPageName() {
        String str;
        int i11 = this.tabIndex;
        if (i11 == 0) {
            str = "mb";
        } else if (i11 == 1) {
            str = IntegrationConstants.NAVIGATION_BAR_ALL_ACTION;
        } else if (i11 != 2) {
            str = this.tabName.toLowerCase(Locale.ROOT);
            Intrinsics.g(str, "toLowerCase(...)");
        } else {
            str = "received";
        }
        return "transfer_tab_" + str;
    }

    private final void u0() {
        loadDefaultData();
    }

    private final DownloadViewModel v0() {
        return (DownloadViewModel) this.downloadViewModel.getValue();
    }

    private final View w0() {
        if (this.mEmptyView == null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            StateView stateView = new StateView(requireContext);
            String string = stateView.getContext().getString(R$string.download_no_historical_tips);
            Intrinsics.g(string, "getString(...)");
            stateView.showData(4, 2, false, "", string);
            String string2 = stateView.getContext().getString(R$string.download_empty_find_free_source);
            Intrinsics.g(string2, "getString(...)");
            stateView.setReTryTxt(string2);
            stateView.retry(new Function0() { // from class: com.transsnet.downloader.fragment.y7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit x02;
                    x02 = TransferSelectListFragment.x0(TransferSelectListFragment.this);
                    return x02;
                }
            });
            this.mEmptyView = stateView;
        }
        View view = this.mEmptyView;
        Intrinsics.e(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(TransferSelectListFragment transferSelectListFragment) {
        Navigator.x(TheRouter.c("/home/movieFilter").F("tabId", 2), transferSelectListFragment.requireContext(), null, 2, null);
        return Unit.f67184a;
    }

    private final View y0() {
        View view;
        if (this.mEmptyView == null) {
            if (com.transsnet.downloader.viewmodel.a0.f60208a.a()) {
                view = super.getEmptyView(false);
            } else {
                Context requireContext = requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                StateView stateView = new StateView(requireContext);
                stateView.updateNoContentResId(R$mipmap.ic_no_permission);
                String string = Utils.a().getString(R$string.download_file_permission_tips);
                Intrinsics.g(string, "getString(...)");
                stateView.showData(4, 2, false, "", string);
                String string2 = Utils.a().getString(R$string.download_no_permission_btn);
                Intrinsics.g(string2, "getString(...)");
                stateView.setReTryTxt(string2);
                stateView.retry(new Function0() { // from class: com.transsnet.downloader.fragment.h8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit z02;
                        z02 = TransferSelectListFragment.z0(TransferSelectListFragment.this);
                        return z02;
                    }
                });
                view = stateView;
            }
            this.mEmptyView = view;
        }
        View view2 = this.mEmptyView;
        Intrinsics.e(view2);
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(TransferSelectListFragment transferSelectListFragment) {
        FragmentActivity activity = transferSelectListFragment.getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return Unit.f67184a;
        }
        com.transsnet.downloader.viewmodel.a0 a0Var = com.transsnet.downloader.viewmodel.a0.f60208a;
        if (a0Var.p(activity)) {
            a0Var.x();
        } else {
            transferSelectListFragment.requestMultiplePermission.a(com.transsion.baselib.helper.e.f43321a.a());
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public py.m0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.m0 c11 = py.m0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getEmptyDescText() {
        int i11 = this.tabIndex;
        if (i11 == 0) {
            String string = getString(R$string.newcomer_guide_download_tips);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (i11 == 1) {
            String string2 = getString(R$string.download_no_local_file_tips_2);
            Intrinsics.g(string2, "getString(...)");
            return string2;
        }
        if (i11 != 2) {
            String string3 = getString(R$string.download_no_local_file_tips_2);
            Intrinsics.g(string3, "getString(...)");
            return string3;
        }
        String string4 = getString(R$string.download_transfer_received_empty_tips);
        Intrinsics.g(string4, "getString(...)");
        return string4;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        int i11 = this.tabIndex;
        if (i11 != 0 && i11 != 2 && !com.transsnet.downloader.viewmodel.a0.f60208a.a()) {
            U0();
        }
        py.m0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f72970b) != null) {
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
            com.transsnet.downloader.adapter.x0 x0Var = new com.transsnet.downloader.adapter.x0(new ArrayList());
            this.transferSelectAdapter = x0Var;
            x0Var.w1(new p6.d() { // from class: com.transsnet.downloader.fragment.x7
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    TransferSelectListFragment.N0(TransferSelectListFragment.this, baseQuickAdapter, view, i12);
                }
            });
            x0Var.l(R$id.v_more);
            x0Var.s1(new p6.b() { // from class: com.transsnet.downloader.fragment.z7
                @Override // p6.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    TransferSelectListFragment.O0(TransferSelectListFragment.this, baseQuickAdapter, view, i12);
                }
            });
            recyclerView.setAdapter(x0Var);
        }
        py.m0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (swipeRefreshLayout = mViewBinding2.f72971c) == null) {
            return;
        }
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R$color.bg_01));
        swipeRefreshLayout.setColorSchemeColors(androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_center), androidx.core.content.b.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_start));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsnet.downloader.fragment.a8
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                TransferSelectListFragment.P0(TransferSelectListFragment.this);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        int i11 = this.tabIndex;
        if (i11 == 0) {
            F0();
        } else if (i11 == 1) {
            I0();
        } else if (i11 != 2) {
            K0();
        } else {
            L0();
        }
        v0().e0().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.c8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = TransferSelectListFragment.Q0(TransferSelectListFragment.this, (Boolean) obj);
                return Q0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        super.loadDefaultData();
        int i11 = this.tabIndex;
        if (i11 == 0) {
            v0().M(true);
        } else if (i11 == 1) {
            A0().j(true);
        } else {
            if (i11 != 2) {
                return;
            }
            B0().h(true);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b(getPageName(), false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            loadDefaultData();
        }
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        String str;
        super.receiveArguments();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("extra_download_out_file_tab_name")) == null) {
            str = "";
        }
        this.tabName = str;
        Bundle arguments2 = getArguments();
        this.tabIndex = arguments2 != null ? arguments2.getInt("extra_page_index") : 0;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }
}
