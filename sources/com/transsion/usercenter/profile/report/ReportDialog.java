package com.transsion.usercenter.profile.report;

import android.R;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.c0;
import androidx.view.m;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/transsion/usercenter/profile/report/ReportDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "w0", "(Landroid/view/View;)V", "", "pos", "s0", "(Ljava/lang/Integer;)V", "", "u0", "()Ljava/lang/String;", "initLiveData", "", "Lcom/transsion/usercenter/profile/report/c;", "r0", "()Ljava/util/List;", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/transsion/usercenter/profile/report/ReportViewModel;", "c", "Lkotlin/Lazy;", "t0", "()Lcom/transsion/usercenter/profile/report/ReportViewModel;", "mViewModel", "Lcom/transsion/usercenter/profile/report/a;", "d", "Lcom/transsion/usercenter/profile/report/a;", "mAdapter", "e", "Ljava/lang/String;", "reportType", "f", "id", "Lcom/transsion/share/share/a;", be.g.f16474b, "Lcom/transsion/share/share/a;", "getShareItemCallback", "()Lcom/transsion/share/share/a;", "A0", "(Lcom/transsion/share/share/a;)V", "shareItemCallback", "h", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ReportDialog extends BaseDialog {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy mViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a mAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String reportType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String id;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.transsion.share.share.a shareItemCallback;

    /* renamed from: com.transsion.usercenter.profile.report.ReportDialog$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReportDialog a(String str, String id2) {
            Intrinsics.h(id2, "id");
            ReportDialog reportDialog = new ReportDialog();
            reportDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("report_type", str), TuplesKt.a("id", id2)));
            return reportDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57367a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57367a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57367a;
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
            this.f57367a.invoke(obj);
        }
    }

    public ReportDialog() {
        super(R$layout.layout_report);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.profile.report.ReportDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(ReportViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.profile.report.ReportDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.profile.report.ReportDialog$special$$inlined$viewModels$default$3
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

    private final void initLiveData() {
        t0().j().j(getViewLifecycleOwner(), new b(new Function1() { // from class: com.transsion.usercenter.profile.report.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v02;
                v02 = ReportDialog.v0(ReportDialog.this, (BaseDto) obj);
                return v02;
            }
        }));
    }

    private final List r0() {
        String[] strArr = {getString(R$string.report_0), getString(R$string.report_1), getString(R$string.report_2), getString(R$string.report_3), getString(R$string.report_4), getString(R$string.report_5), getString(R$string.report_6), getString(R$string.report_7), getString(R$string.report_8)};
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 9; i11++) {
            String str = strArr[i11];
            Intrinsics.g(str, "get(...)");
            arrayList.add(new c(str, false));
        }
        return arrayList;
    }

    private final void s0(Integer pos) {
        List<Object> data;
        a aVar = this.mAdapter;
        if (aVar != null && (data = aVar.getData()) != null) {
            int i11 = 0;
            for (Object obj : data) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.u();
                }
                ((c) obj).c(pos != null && i11 == pos.intValue());
                i11 = i12;
            }
        }
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.notifyDataSetChanged();
        }
    }

    private final ReportViewModel t0() {
        return (ReportViewModel) this.mViewModel.getValue();
    }

    private final String u0() {
        List<Object> data;
        a aVar = this.mAdapter;
        if (aVar == null || (data = aVar.getData()) == null) {
            return null;
        }
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.b()) {
                return cVar.a();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(ReportDialog reportDialog, BaseDto baseDto) {
        uh.b.f76876a.d(R$string.reported);
        reportDialog.dismissAllowingStateLoss();
        com.transsion.share.share.a aVar = reportDialog.shareItemCallback;
        if (aVar != null) {
            aVar.b(reportDialog.id);
        }
        return Unit.f67184a;
    }

    private final void w0(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.report_list);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            a aVar = new a(r0());
            aVar.w1(new p6.d() { // from class: com.transsion.usercenter.profile.report.e
                @Override // p6.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                    ReportDialog.x0(ReportDialog.this, baseQuickAdapter, view2, i11);
                }
            });
            this.mAdapter = aVar;
            recyclerView.setAdapter(aVar);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.iv_close);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.report.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReportDialog.y0(ReportDialog.this, view2);
                }
            });
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R$id.btn_submit);
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.report.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReportDialog.z0(ReportDialog.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(ReportDialog reportDialog, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        reportDialog.s0(Integer.valueOf(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(ReportDialog reportDialog, View view) {
        reportDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(ReportDialog reportDialog, View view) {
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_tips);
            return;
        }
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L)) {
            return;
        }
        String u02 = reportDialog.u0();
        if (u02 == null) {
            uh.b.f76876a.d(R$string.tip_blank);
        } else {
            reportDialog.t0().l(reportDialog.reportType, reportDialog.id, u02);
        }
    }

    public final void A0(com.transsion.share.share.a aVar) {
        this.shareItemCallback = aVar;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        com.google.android.material.bottomsheet.c cVar = new com.google.android.material.bottomsheet.c(requireContext(), R$style.BottomDialogTheme);
        cVar.k().U0(3);
        cVar.k().T0(true);
        return cVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.getAttributes().gravity = 80;
        window.getAttributes().height = -2;
        View findViewById = window.findViewById(com.google.android.material.R$id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.color.transparent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.reportType = arguments != null ? arguments.getString("report_type") : null;
        Bundle arguments2 = getArguments();
        this.id = arguments2 != null ? arguments2.getString("id") : null;
        w0(view);
        initLiveData();
    }
}
