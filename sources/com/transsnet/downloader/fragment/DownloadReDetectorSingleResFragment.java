package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.memberapi.IMemberApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.downloader.widget.DownloadPathEntranceView;
import com.transsnet.downloader.widget.DownloadView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import ok.b;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadReDetectorSingleResFragment;", "Lcom/transsnet/downloader/fragment/DownloadReDetectorSingleResBaseFragment;", "Lpy/g0;", "<init>", "()V", "", "Z0", "h1", "initViewData", "onResume", "v0", "x0", "w0", "y0", "Landroid/view/LayoutInflater;", "inflater", "a1", "(Landroid/view/LayoutInflater;)Lpy/g0;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "", "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "initViewModel", "initListener", "retryLoadData", "Lcom/transsion/baselib/db/download/DownloadBean;", WebConstants.FIELD_ITEM, "Q0", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", TtmlNode.TAG_P, "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadReDetectorSingleResFragment extends DownloadReDetectorSingleResBaseFragment<py.g0> {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorSingleResFragment a(String str) {
            DownloadReDetectorSingleResFragment downloadReDetectorSingleResFragment = new DownloadReDetectorSingleResFragment();
            downloadReDetectorSingleResFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_module_name", str)));
            return downloadReDetectorSingleResFragment;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements ok.b {
        b() {
        }

        @Override // ok.b
        public void a(boolean z10) {
            b.a.a(this, z10);
        }

        @Override // ok.b
        public void onFail() {
            ok.c.f71157a.a(DownloadReDetectorSingleResFragment.this.getClassTag() + " --> interception() --> onFail() --> 失败了");
        }

        @Override // ok.b
        public void onSuccess() {
            DownloadReDetectorSingleResFragment.this.R0();
        }
    }

    /* loaded from: classes7.dex */
    static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59130a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59130a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59130a;
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
            this.f59130a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Z0() {
        DownloadPathEntranceView downloadPathEntranceView;
        DownloadPathEntranceView downloadPathEntranceView2;
        if (G0()) {
            py.g0 g0Var = (py.g0) getMViewBinding();
            if (g0Var == null || (downloadPathEntranceView2 = g0Var.f72857i) == null) {
                return;
            }
            downloadPathEntranceView2.onPermissionDenied();
            return;
        }
        py.g0 g0Var2 = (py.g0) getMViewBinding();
        if (g0Var2 == null || (downloadPathEntranceView = g0Var2.f72857i) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(DownloadReDetectorSingleResFragment downloadReDetectorSingleResFragment, View view) {
        downloadReDetectorSingleResFragment.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (r3.isMultiresolution() == true) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c1(com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment r8, android.view.View r9) {
        /*
            nh.m r9 = nh.m.f70597a
            boolean r9 = r9.e()
            if (r9 != 0) goto L10
            uh.b$a r8 = uh.b.f76876a
            int r9 = com.tn.lib.widget.R$string.no_network_toast
            r8.d(r9)
            return
        L10:
            com.transsnet.downloader.DownloadManagerApi$a r9 = com.transsnet.downloader.DownloadManagerApi.f58521j
            com.transsnet.downloader.DownloadManagerApi r0 = r9.a()
            com.transsion.baselib.db.download.DownloadBean r1 = r8.getDownloadBean()
            r2 = 0
            if (r1 == 0) goto L22
            java.lang.String r1 = r1.getResourceId()
            goto L23
        L22:
            r1 = r2
        L23:
            com.transsion.baselib.db.download.DownloadBean r3 = r8.getDownloadBean()
            r4 = 0
            if (r3 == 0) goto L32
            boolean r3 = r3.isMultiresolution()
            r5 = 1
            if (r3 != r5) goto L32
            goto L33
        L32:
            r5 = r4
        L33:
            boolean r0 = r0.w0(r2, r1, r4, r5)
            if (r0 == 0) goto L5a
            com.transsion.baselib.db.download.DownloadBean r0 = r8.getDownloadBean()
            if (r0 == 0) goto L59
            java.lang.String r2 = r0.getSubjectId()
            if (r2 == 0) goto L59
            com.transsnet.downloader.DownloadManagerApi r1 = r9.a()
            android.content.Context r3 = r8.getContext()
            kotlin.jvm.internal.Intrinsics.e(r3)
            r6 = 8
            r7 = 0
            java.lang.String r4 = "Download_Dialog"
            r5 = 0
            com.transsnet.downloader.DownloadManagerApi.z0(r1, r2, r3, r4, r5, r6, r7)
        L59:
            return
        L5a:
            java.lang.Class<com.transsion.commercializationapi.ITaskCenterApi> r9 = com.transsion.commercializationapi.ITaskCenterApi.class
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.Object r9 = com.therouter.TheRouter.d(r9, r0)
            com.transsion.commercializationapi.ITaskCenterApi r9 = (com.transsion.commercializationapi.ITaskCenterApi) r9
            if (r9 == 0) goto L8a
            com.transsion.baselib.db.download.DownloadBean r0 = r8.getDownloadBean()
            if (r0 == 0) goto L75
            int r0 = r0.getResolution()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L76
        L75:
            r0 = r2
        L76:
            com.transsion.baselib.db.download.DownloadBean r1 = r8.getDownloadBean()
            if (r1 == 0) goto L80
            java.lang.String r2 = r1.getGenre()
        L80:
            com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment$b r1 = new com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment$b
            r1.<init>()
            com.transsion.memberapi.MemberSceneType r8 = com.transsion.memberapi.MemberSceneType.SCENE_HDDL
            r9.f(r0, r2, r1, r8)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment.c1(com.transsnet.downloader.fragment.DownloadReDetectorSingleResFragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(DownloadReDetectorSingleResFragment downloadReDetectorSingleResFragment, View it) {
        androidx.view.b0 p11;
        Intrinsics.h(it, "it");
        DownloadResourcesDetectorViewModel viewModel = downloadReDetectorSingleResFragment.getViewModel();
        if (viewModel != null && (p11 = viewModel.p()) != null) {
            p11.q(4);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(DownloadReDetectorSingleResFragment downloadReDetectorSingleResFragment, View it) {
        Intrinsics.h(it, "it");
        DownloadUtil downloadUtil = DownloadUtil.f60023a;
        if (downloadUtil.D()) {
            if (downloadReDetectorSingleResFragment.G0()) {
                downloadReDetectorSingleResFragment.F0();
            }
            return Unit.f67184a;
        }
        if (downloadReDetectorSingleResFragment.getIsRequestPermissionFirst()) {
            downloadReDetectorSingleResFragment.C0(false);
            com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("download_root_path_permission_first", false);
            downloadReDetectorSingleResFragment.getRequestStoragePermission().a(downloadUtil.v());
            return Unit.f67184a;
        }
        if (downloadUtil.F(downloadReDetectorSingleResFragment)) {
            downloadReDetectorSingleResFragment.D0(true);
            com.transsnet.downloader.viewmodel.a0.f60208a.x();
        } else {
            downloadReDetectorSingleResFragment.getRequestStoragePermission().a(downloadUtil.v());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit f1(DownloadReDetectorSingleResFragment downloadReDetectorSingleResFragment, my.b bVar) {
        DownloadPathEntranceView downloadPathEntranceView;
        if (bVar == null) {
            return Unit.f67184a;
        }
        downloadReDetectorSingleResFragment.B0(bVar);
        a.C0856a c0856a = lg.a.f68962a;
        String tag = downloadReDetectorSingleResFragment.getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "path select path = " + bVar.d() + " ", false, 4, null);
        py.g0 g0Var = (py.g0) downloadReDetectorSingleResFragment.getMViewBinding();
        if (g0Var != null && (downloadPathEntranceView = g0Var.f72857i) != null) {
            downloadPathEntranceView.updatePathName(bVar.d(), bVar.a());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit g1(DownloadReDetectorSingleResFragment downloadReDetectorSingleResFragment, List list) {
        DownloadPathEntranceView downloadPathEntranceView;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            my.b bVar = (my.b) it.next();
            if (bVar.f()) {
                downloadReDetectorSingleResFragment.B0(bVar);
                a.C0856a c0856a = lg.a.f68962a;
                String tag = downloadReDetectorSingleResFragment.getTAG();
                Intrinsics.g(tag, "<get-TAG>(...)");
                a.C0856a.f(c0856a, tag, "cur download path = " + bVar.d() + " ", false, 4, null);
                com.transsion.baselib.report.launch.b bVar2 = com.transsion.baselib.report.launch.b.f43424a;
                bVar2.b().putString("download_root_path", bVar.b());
                bVar2.b().putString("download_root_path_name", bVar.d());
                bVar2.b().putInt("download_root_path_type", bVar.e());
                py.g0 g0Var = (py.g0) downloadReDetectorSingleResFragment.getMViewBinding();
                if (g0Var != null && (downloadPathEntranceView = g0Var.f72857i) != null) {
                    downloadPathEntranceView.updatePathName(bVar.d(), bVar.a());
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h1() {
        DownloadView downloadView;
        py.g0 g0Var = (py.g0) getMViewBinding();
        if (g0Var == null || (downloadView = g0Var.f72854f) == null) {
            return;
        }
        DownloadBean downloadBean = getDownloadBean();
        DownloadView.setShowType$default(downloadView, null, downloadBean != null ? downloadBean.getResourceId() : null, Boolean.FALSE, false, 0, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment
    public void Q0(DownloadBean item) {
        String sizeFormat;
        py.s0 s0Var;
        AppCompatImageView appCompatImageView;
        Integer requireMemberType;
        py.s0 s0Var2;
        AppCompatImageView appCompatImageView2;
        py.s0 s0Var3;
        AppCompatImageView appCompatImageView3;
        py.s0 s0Var4;
        AppCompatTextView appCompatTextView;
        py.s0 s0Var5;
        AppCompatTextView appCompatTextView2;
        py.s0 s0Var6;
        AppCompatTextView appCompatTextView3;
        Intrinsics.h(item, "item");
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        py.g0 g0Var = (py.g0) getMViewBinding();
        if (g0Var != null && (s0Var6 = g0Var.f72850b) != null && (appCompatTextView3 = s0Var6.f73039g) != null) {
            appCompatTextView3.setText(item.getTotalTitleName());
        }
        py.g0 g0Var2 = (py.g0) getMViewBinding();
        if (g0Var2 != null && (s0Var5 = g0Var2.f72850b) != null && (appCompatTextView2 = s0Var5.f73036d) != null) {
            jg.c.g(appCompatTextView2);
        }
        if (TextUtils.isEmpty(item.getSizeFormat())) {
            Long size = item.getSize();
            sizeFormat = size != null ? oh.b.a(size.longValue(), 1) : null;
        } else {
            sizeFormat = item.getSizeFormat();
        }
        Long duration = item.getDuration();
        String str = sizeFormat + " · " + TimeUtilKt.n((duration != null ? duration.longValue() : 0L) * 1000);
        py.g0 g0Var3 = (py.g0) getMViewBinding();
        if (g0Var3 != null && (s0Var4 = g0Var3.f72850b) != null && (appCompatTextView = s0Var4.f73037e) != null) {
            appCompatTextView.setText(str);
        }
        py.g0 g0Var4 = (py.g0) getMViewBinding();
        if (g0Var4 != null && (s0Var3 = g0Var4.f72850b) != null && (appCompatImageView3 = s0Var3.f73034b) != null) {
            appCompatImageView3.setSelected(true);
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if ((iMemberApi != null ? iMemberApi.B() : false) && (requireMemberType = item.getRequireMemberType()) != null && requireMemberType.intValue() == 1) {
            py.g0 g0Var5 = (py.g0) getMViewBinding();
            if (g0Var5 != null && (s0Var2 = g0Var5.f72850b) != null && (appCompatImageView2 = s0Var2.f73035c) != null) {
                jg.c.k(appCompatImageView2);
            }
        } else {
            py.g0 g0Var6 = (py.g0) getMViewBinding();
            if (g0Var6 != null && (s0Var = g0Var6.f72850b) != null && (appCompatImageView = s0Var.f73035c) != null) {
                jg.c.g(appCompatImageView);
            }
        }
        h1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public py.g0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.g0 c11 = py.g0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        DownloadView downloadView;
        ImageView imageView;
        py.g0 g0Var = (py.g0) getMViewBinding();
        if (g0Var != null && (imageView = g0Var.f72851c) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.v4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorSingleResFragment.b1(DownloadReDetectorSingleResFragment.this, view);
                }
            });
        }
        py.g0 g0Var2 = (py.g0) getMViewBinding();
        if (g0Var2 == null || (downloadView = g0Var2.f72854f) == null) {
            return;
        }
        downloadView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.w4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorSingleResFragment.c1(DownloadReDetectorSingleResFragment.this, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        String str;
        DownloadPathEntranceView downloadPathEntranceView;
        LinearLayoutCompat linearLayoutCompat;
        ViewGroup.LayoutParams layoutParams;
        HashMap g11;
        a.C0856a.f(lg.a.f68962a, "premium_d", "DownloadReDetectorSingleResFragment --> initViewData()", false, 4, null);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("extra_module_name")) == null) {
            str = "";
        }
        P0(str);
        O0(true);
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
            g11.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "1");
        }
        py.g0 g0Var = (py.g0) getMViewBinding();
        if (g0Var != null && (linearLayoutCompat = g0Var.f72853e) != null && (layoutParams = linearLayoutCompat.getLayoutParams()) != null) {
            layoutParams.height = q0();
        }
        py.g0 g0Var2 = (py.g0) getMViewBinding();
        if (g0Var2 != null && (downloadPathEntranceView = g0Var2.f72857i) != null) {
            downloadPathEntranceView.setChangeClickCallback(new Function1() { // from class: com.transsnet.downloader.fragment.x4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit d12;
                    d12 = DownloadReDetectorSingleResFragment.d1(DownloadReDetectorSingleResFragment.this, (View) obj);
                    return d12;
                }
            });
            downloadPathEntranceView.setPermissionClickCallback(new Function1() { // from class: com.transsnet.downloader.fragment.y4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit e12;
                    e12 = DownloadReDetectorSingleResFragment.e1(DownloadReDetectorSingleResFragment.this, (View) obj);
                    return e12;
                }
            });
        }
        Z0();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.view.b0 r11;
        androidx.view.b0 B;
        super.initViewModel();
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "single， initViewModel  ", false, 4, null);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            DownloadResourcesDetectorViewModel viewModel = getViewModel();
            if (viewModel != null && (B = viewModel.B()) != null) {
                B.j(parentFragment, new c(new Function1() { // from class: com.transsnet.downloader.fragment.t4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit f12;
                        f12 = DownloadReDetectorSingleResFragment.f1(DownloadReDetectorSingleResFragment.this, (my.b) obj);
                        return f12;
                    }
                }));
            }
            DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
            if (viewModel2 != null && (r11 = viewModel2.r()) != null) {
                r11.j(parentFragment, new c(new Function1() { // from class: com.transsnet.downloader.fragment.u4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit g12;
                        g12 = DownloadReDetectorSingleResFragment.g1(DownloadReDetectorSingleResFragment.this, (List) obj);
                        return g12;
                    }
                }));
            }
        }
        DownloadResourcesDetectorViewModel viewModel3 = getViewModel();
        if (viewModel3 != null) {
            viewModel3.v();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Z0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void v0() {
        DownloadPathEntranceView downloadPathEntranceView;
        super.v0();
        py.g0 g0Var = (py.g0) getMViewBinding();
        if (g0Var == null || (downloadPathEntranceView = g0Var.f72857i) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionGranted();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void w0() {
        DownloadPathEntranceView downloadPathEntranceView;
        super.w0();
        py.g0 g0Var = (py.g0) getMViewBinding();
        if (g0Var == null || (downloadPathEntranceView = g0Var.f72857i) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionDenied();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void x0() {
        DownloadPathEntranceView downloadPathEntranceView;
        super.x0();
        if (G0()) {
            F0();
            return;
        }
        py.g0 g0Var = (py.g0) getMViewBinding();
        if (g0Var == null || (downloadPathEntranceView = g0Var.f72857i) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionGranted();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void y0() {
        DownloadPathEntranceView downloadPathEntranceView;
        super.y0();
        py.g0 g0Var = (py.g0) getMViewBinding();
        if (g0Var == null || (downloadPathEntranceView = g0Var.f72857i) == null) {
            return;
        }
        downloadPathEntranceView.onPermissionRefresh();
    }
}
