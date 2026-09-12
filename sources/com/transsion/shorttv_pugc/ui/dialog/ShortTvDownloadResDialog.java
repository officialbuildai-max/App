package com.transsion.shorttv_pugc.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.c0;
import androidx.view.v0;
import be.g;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.transsion.push.PushConstants;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.R$style;
import com.transsion.shorttv_pugc.base.dialog.BaseDialog;
import com.transsion.shorttv_pugc.bean.Subject;
import com.transsion.shorttv_pugc.ui.fragment.download.ShortTVDownloadReFragment;
import com.transsion.shorttv_pugc.ui.fragment.download.ShortTVDownloadReWatchADFragment;
import com.transsion.shorttv_pugc.viewmodel.ShortTvDownloadViewModel;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadDialogShowEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
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

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010*R\u0018\u00107\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010*R\u0018\u00109\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010*R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/transsion/shorttv_pugc/ui/dialog/ShortTvDownloadResDialog;", "Lcom/transsion/shorttv_pugc/base/dialog/BaseDialog;", "<init>", "()V", "", "initViewModel", "", "fragmentTag", "o0", "(Ljava/lang/String;)V", "l0", NativeComponentConstants.KEY_COMPONENT_TYPE, "Landroidx/fragment/app/Fragment;", "k0", "(Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDestroy", "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "Landroidx/fragment/app/FragmentManager;", "manager", "tag", PushConstants.PUSH_SERVICE_TYPE_SHOW, "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "basePageType", "c", "curPageType", "Lcom/transsion/shorttv_pugc/bean/Subject;", "d", "Lcom/transsion/shorttv_pugc/bean/Subject;", "subject", "e", "pageFrom", "f", "lastPageFrom", g.f16474b, "ops", "h", "moduleName", "", "i", "Z", "scroll2Download", "Lcom/transsion/shorttv_pugc/viewmodel/ShortTvDownloadViewModel;", j.f35620b, "Lcom/transsion/shorttv_pugc/viewmodel/ShortTvDownloadViewModel;", "viewModel", CampaignEx.JSON_KEY_AD_K, "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTvDownloadResDialog extends BaseDialog {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String basePageType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String curPageType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Subject subject;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String pageFrom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean scroll2Download;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ShortTvDownloadViewModel viewModel;

    /* renamed from: com.transsion.shorttv_pugc.ui.dialog.ShortTvDownloadResDialog$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvDownloadResDialog a(String str, String str2, Subject subject, String str3, String str4, boolean z10) {
            ShortTvDownloadResDialog shortTvDownloadResDialog = new ShortTvDownloadResDialog();
            shortTvDownloadResDialog.setArguments(androidx.core.os.d.b(TuplesKt.a("download_page_type", "download_short_tv"), TuplesKt.a(WebConstants.PAGE_FROM, str), TuplesKt.a("last_page_from", str2), TuplesKt.a("subject", subject), TuplesKt.a("ops", str3), TuplesKt.a("module_name", str4), TuplesKt.a("download_scroll_to_download", Boolean.valueOf(z10))));
            return shortTvDownloadResDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f54158a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f54158a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f54158a;
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
            this.f54158a.invoke(obj);
        }
    }

    public ShortTvDownloadResDialog() {
        super(R$layout.short_tv_dialog_download_res_main);
        this.basePageType = "download_short_tv";
        this.curPageType = "download_short_tv";
        this.pageFrom = "";
        this.lastPageFrom = "";
    }

    private final void initViewModel() {
        ShortTvDownloadViewModel shortTvDownloadViewModel = (ShortTvDownloadViewModel) new v0(this).a(ShortTvDownloadViewModel.class);
        shortTvDownloadViewModel.e().j(this, new b(new Function1() { // from class: com.transsion.shorttv_pugc.ui.dialog.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m02;
                m02 = ShortTvDownloadResDialog.m0(ShortTvDownloadResDialog.this, (String) obj);
                return m02;
            }
        }));
        this.viewModel = shortTvDownloadViewModel;
    }

    private final Fragment k0(String type) {
        return Intrinsics.c(type, "download_short_tv_ad") ? ShortTVDownloadReWatchADFragment.INSTANCE.a() : ShortTVDownloadReFragment.INSTANCE.a(this.pageFrom, this.lastPageFrom, this.subject, this.ops, this.moduleName, this.scroll2Download);
    }

    private final void l0() {
        List y02 = getChildFragmentManager().y0();
        Intrinsics.g(y02, "getFragments(...)");
        Iterator it = y02.iterator();
        while (it.hasNext()) {
            getChildFragmentManager().p().p((Fragment) it.next()).l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(ShortTvDownloadResDialog shortTvDownloadResDialog, String str) {
        Intrinsics.e(str);
        shortTvDownloadResDialog.o0(str);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n0(ShortTvDownloadResDialog shortTvDownloadResDialog, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        if (i11 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        if (Intrinsics.c(shortTvDownloadResDialog.curPageType, shortTvDownloadResDialog.basePageType)) {
            a.C0856a.f(lg.a.f68962a, "DownloadReDetectorMainDialog", "back click~ dismiss", false, 4, null);
            shortTvDownloadResDialog.dismissAllowingStateLoss();
        } else {
            a.C0856a.f(lg.a.f68962a, "DownloadReDetectorMainDialog", "back click~ show base", false, 4, null);
            shortTvDownloadResDialog.o0(shortTvDownloadResDialog.basePageType);
        }
        return true;
    }

    private final void o0(String fragmentTag) {
        a.C0856a.f(lg.a.f68962a, "DownloadReDetectorMainDialog", "showFragment tag = " + fragmentTag, false, 4, null);
        this.curPageType = fragmentTag;
        setCancelable(Intrinsics.c(fragmentTag, "download_short_tv_ad") ^ true);
        l0();
        Fragment k02 = getChildFragmentManager().k0(fragmentTag);
        if (k02 == null) {
            k02 = k0(fragmentTag);
        }
        if (k02.isAdded()) {
            getChildFragmentManager().p().y(k02).l();
        } else {
            getChildFragmentManager().p().c(R$id.fl_container, k02, fragmentTag).l();
        }
    }

    @Override // com.transsion.shorttv_pugc.base.dialog.BaseDialog
    public hj.b newLogViewConfig() {
        return new hj.b("download_main_dialog", false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        String str4;
        String string;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null ? savedInstanceState.getBoolean("key_download_save_instance") : false) {
            dismissAllowingStateLoss();
            return;
        }
        setStyle(0, R$style.ShortTvBottomDialogTheme);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("download_page_type")) == null) {
            str = "download_short_tv";
        }
        this.basePageType = str;
        Bundle arguments2 = getArguments();
        String str5 = "";
        if (arguments2 == null || (str2 = arguments2.getString(WebConstants.PAGE_FROM)) == null) {
            str2 = "";
        }
        this.pageFrom = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str3 = arguments3.getString("last_page_from")) == null) {
            str3 = "";
        }
        this.lastPageFrom = str3;
        Bundle arguments4 = getArguments();
        Serializable serializable = arguments4 != null ? arguments4.getSerializable("subject") : null;
        this.subject = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str4 = arguments5.getString("ops")) == null) {
            str4 = "";
        }
        this.ops = str4;
        Bundle arguments6 = getArguments();
        if (arguments6 != null && (string = arguments6.getString("module_name")) != null) {
            str5 = string;
        }
        this.moduleName = str5;
        Bundle arguments7 = getArguments();
        this.scroll2Download = arguments7 != null ? arguments7.getBoolean("download_scroll_to_download", false) : false;
        initViewModel();
        o0(this.basePageType);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.ShortTvBottomDialogAnimation);
            window.setGravity(80);
            window.setDimAmount(0.5f);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = -1;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.transsion.shorttv_pugc.ui.dialog.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                boolean n02;
                n02 = ShortTvDownloadResDialog.n0(ShortTvDownloadResDialog.this, dialogInterface, i11, keyEvent);
                return n02;
            }
        });
        return onCreateDialog;
    }

    @Override // com.transsion.shorttv_pugc.base.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        DownloadDialogShowEvent downloadDialogShowEvent = new DownloadDialogShowEvent(false);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadDialogShowEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, downloadDialogShowEvent, 0L);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("key_download_save_instance", true);
    }

    @Override // com.transsion.shorttv_pugc.base.dialog.BaseDialog, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        Intrinsics.h(manager, "manager");
        super.show(manager, tag);
        DownloadDialogShowEvent downloadDialogShowEvent = new DownloadDialogShowEvent(true);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadDialogShowEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, downloadDialogShowEvent, 0L);
    }
}
