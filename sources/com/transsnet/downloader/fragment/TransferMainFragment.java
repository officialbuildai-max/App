package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsnet.downloader.dialog.TransferGuideDialog;
import com.transsnet.downloader.fragment.DownloadTabBaseFragment;
import com.transsnet.downloader.fragment.TransferSelectListFragment;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import com.transsnet.downloader.widget.TransferSelectSeriesListView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u00052\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010%\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J!\u0010'\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0004¨\u00061"}, d2 = {"Lcom/transsnet/downloader/fragment/TransferMainFragment;", "Lcom/transsnet/downloader/fragment/DownloadTabBaseFragment;", "Lpy/l0;", "<init>", "()V", "", "initViewModel", "Landroid/view/LayoutInflater;", "inflater", "E0", "(Landroid/view/LayoutInflater;)Lpy/l0;", "Landroidx/viewpager2/widget/ViewPager2;", "z0", "()Landroidx/viewpager2/widget/ViewPager2;", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "r0", "()Lnet/lucode/hackware/magicindicator/MagicIndicator;", "", RequestParameters.POSITION, "t0", "(I)V", "state", "s0", "Landroidx/fragment/app/Fragment;", "d0", "(I)Landroidx/fragment/app/Fragment;", "", "", "f0", "()Ljava/util/List;", "list", "u0", "(Ljava/util/List;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "", "hidden", "onHiddenChanged", "(Z)V", "onStop", "onDestroy", CampaignEx.JSON_KEY_AD_K, "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public class TransferMainFragment extends DownloadTabBaseFragment<py.l0> {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.transsnet.downloader.fragment.TransferMainFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransferMainFragment a() {
            TransferMainFragment transferMainFragment = new TransferMainFragment();
            transferMainFragment.setArguments(androidx.core.os.d.a());
            return transferMainFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59223a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59223a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59223a;
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
            this.f59223a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0() {
        TransferGuideDialog.Companion companion = TransferGuideDialog.INSTANCE;
        if (companion.a()) {
            return;
        }
        companion.b().k0(com.blankj.utilcode.util.a.b(), "TransferGuideDialog");
        companion.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit G0(TransferMainFragment transferMainFragment, String str) {
        TransferBottomToolsView transferBottomToolsView;
        py.l0 l0Var = (py.l0) transferMainFragment.getMViewBinding();
        if (l0Var != null && (transferBottomToolsView = l0Var.f72954d) != null) {
            Intrinsics.e(str);
            transferBottomToolsView.changeStatus(str);
        }
        if (Intrinsics.c(str, TransferBottomToolsView.STATUS_DEFAULT)) {
            transferMainFragment.j0().h0().q(0);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(TransferMainFragment transferMainFragment, Integer num) {
        ViewPager2 z02;
        RecyclerView.Adapter adapter;
        ViewPager2 z03 = transferMainFragment.z0();
        if (((z03 == null || (adapter = z03.getAdapter()) == null) ? 0 : adapter.getItemCount()) > num.intValue() && num.intValue() >= 0 && (z02 = transferMainFragment.z0()) != null) {
            Intrinsics.e(num);
            z02.setCurrentItem(num.intValue());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit I0(TransferMainFragment transferMainFragment, Boolean bool) {
        TransferSelectSeriesListView transferSelectSeriesListView;
        py.l0 l0Var = (py.l0) transferMainFragment.getMViewBinding();
        if (l0Var != null && (transferSelectSeriesListView = l0Var.f72955e) != null) {
            Intrinsics.e(bool);
            transferSelectSeriesListView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
        return Unit.f67184a;
    }

    private final void initViewModel() {
        j0().a0().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.k7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G0;
                G0 = TransferMainFragment.G0(TransferMainFragment.this, (String) obj);
                return G0;
            }
        }));
        j0().j0().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.l7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = TransferMainFragment.H0(TransferMainFragment.this, (Integer) obj);
                return H0;
            }
        }));
        j0().c0().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.m7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I0;
                I0 = TransferMainFragment.I0(TransferMainFragment.this, (Boolean) obj);
                return I0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public py.l0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.l0 c11 = py.l0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public Fragment d0(int position) {
        String str;
        List k11;
        TransferSelectListFragment.Companion companion = TransferSelectListFragment.INSTANCE;
        DownloadTabBaseFragment.a commonNavigatorAdapter = getCommonNavigatorAdapter();
        if (commonNavigatorAdapter == null || (k11 = commonNavigatorAdapter.k()) == null || (str = (String) k11.get(position)) == null) {
            str = "";
        }
        return companion.a(position, str);
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public List f0() {
        return (List) j0().l0().f();
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        initViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        TransferBottomToolsView transferBottomToolsView;
        TransferBottomToolsView transferBottomToolsView2;
        ConstraintLayout root;
        TransferBottomToolsView transferBottomToolsView3;
        TransferBottomToolsView transferBottomToolsView4;
        Intrinsics.h(view, "view");
        super.initView(view, savedInstanceState);
        py.l0 l0Var = (py.l0) getMViewBinding();
        if (l0Var != null && (transferBottomToolsView4 = l0Var.f72954d) != null) {
            transferBottomToolsView4.setPageStatus(true);
        }
        py.l0 l0Var2 = (py.l0) getMViewBinding();
        if (l0Var2 != null && (transferBottomToolsView3 = l0Var2.f72954d) != null) {
            transferBottomToolsView3.setParentFragment(this);
        }
        py.l0 l0Var3 = (py.l0) getMViewBinding();
        if (l0Var3 != null && (root = l0Var3.getRoot()) != null) {
            root.post(new Runnable() { // from class: com.transsnet.downloader.fragment.n7
                @Override // java.lang.Runnable
                public final void run() {
                    TransferMainFragment.F0();
                }
            });
        }
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof vl.b) {
            py.l0 l0Var4 = (py.l0) getMViewBinding();
            ViewGroup.LayoutParams layoutParams = (l0Var4 == null || (transferBottomToolsView2 = l0Var4.f72954d) == null) ? null : transferBottomToolsView2.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = dk.a.b(((vl.b) activity).i() ? 80 : 56);
            py.l0 l0Var5 = (py.l0) getMViewBinding();
            if (l0Var5 == null || (transferBottomToolsView = l0Var5.f72954d) == null) {
                return;
            }
            transferBottomToolsView.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        TransferBottomToolsView transferBottomToolsView;
        super.onHiddenChanged(hidden);
        py.l0 l0Var = (py.l0) getMViewBinding();
        if (l0Var == null || (transferBottomToolsView = l0Var.f72954d) == null) {
            return;
        }
        transferBottomToolsView.onPageNotVisible();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        TransferBottomToolsView transferBottomToolsView;
        super.onStop();
        py.l0 l0Var = (py.l0) getMViewBinding();
        if (l0Var == null || (transferBottomToolsView = l0Var.f72954d) == null) {
            return;
        }
        transferBottomToolsView.onPageNotVisible();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public MagicIndicator r0() {
        py.l0 l0Var = (py.l0) getMViewBinding();
        if (l0Var != null) {
            return l0Var.f72952b;
        }
        return null;
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void s0(int state) {
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void t0(int position) {
        j0().k0().q(Integer.valueOf(position));
        androidx.view.b0 f02 = j0().f0(position);
        j0().h0().q(Integer.valueOf(DownloadUtil.f60023a.w(f02 != null ? (List) f02.f() : null)));
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void u0(List list) {
        j0().l0().q(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public ViewPager2 z0() {
        py.l0 l0Var = (py.l0) getMViewBinding();
        if (l0Var != null) {
            return l0Var.f72957g;
        }
        return null;
    }
}
