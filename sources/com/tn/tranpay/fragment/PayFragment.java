package com.tn.tranpay.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.Lifecycle;
import androidx.view.Transformations;
import androidx.view.c0;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.blankj.utilcode.util.a0;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.gson.Gson;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tencent.mmkv.MMKV;
import com.tn.lib.tranpay.R$id;
import com.tn.lib.tranpay.R$layout;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.activity.TranPayWebActivity;
import com.tn.tranpay.bean.CreateOrderResultContent;
import com.tn.tranpay.bean.HandleResultType;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.bean.QueryStatus;
import com.tn.tranpay.event.AppScopeVMlProvider;
import com.tn.tranpay.event.FlowEventBus;
import com.tn.tranpay.fragment.PayFragment;
import com.tn.tranpay.helper.PayUtils;
import com.tn.tranpay.helper.PaymentMMKV;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.t1;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \\2\u00020\u0001:\u00028@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0003J+\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u0010\u0003J-\u00101\u001a\u0004\u0018\u0001002\u0006\u0010-\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b1\u00102J!\u00104\u001a\u00020\n2\u0006\u00103\u001a\u0002002\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\n¢\u0006\u0004\b6\u0010\u0003R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006]"}, d2 = {"Lcom/tn/tranpay/fragment/PayFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "", "Lcom/tn/tranpay/bean/MediumInputBean;", "list", "", "k0", "(Ljava/util/List;)Z", "", "p0", "s0", "t0", "", "responseCode", "", "message", "serverCode", "i0", "(ILjava/lang/String;Ljava/lang/String;)V", "x0", "Lcom/tn/tranpay/bean/CreateOrderResultContent;", "result", "Lcom/tn/tranpay/bean/HandleResultType;", "q0", "(Lcom/tn/tranpay/bean/CreateOrderResultContent;)Lcom/tn/tranpay/bean/HandleResultType;", "webUrl", "r0", "(Ljava/lang/String;)V", "appLink", "packageName", "n0", "(Ljava/lang/String;Ljava/lang/String;)Z", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", TmcConstants.NAVIGATION_ON_START, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "o0", "Lcom/tn/tranpay/fragment/PayFragment$b;", "a", "Lcom/tn/tranpay/fragment/PayFragment$b;", "l0", "()Lcom/tn/tranpay/fragment/PayFragment$b;", "w0", "(Lcom/tn/tranpay/fragment/PayFragment$b;)V", "onDismissListener", "Lkotlinx/coroutines/t1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlinx/coroutines/t1;", "paymentEventJob", "Lcom/tn/tranpay/BillingParams;", "c", "Lcom/tn/tranpay/BillingParams;", "paymentParams", "Lcom/tn/tranpay/d;", "d", "Lcom/tn/tranpay/d;", "mCallback", "Lcom/tn/tranpay/bean/LoadConfigContent;", "e", "Lcom/tn/tranpay/bean/LoadConfigContent;", "configBean", "Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "f", "Lkotlin/Lazy;", "m0", "()Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "viewModel", "Landroid/widget/FrameLayout;", be.g.f16474b, "Landroid/widget/FrameLayout;", "loadingLayout", "h", "Z", "canHandleFirstPayMethod", "i", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class PayFragment extends DialogFragment {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private b onDismissListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private t1 paymentEventJob;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private BillingParams paymentParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tn.tranpay.d mCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LoadConfigContent configBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private FrameLayout loadingLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean canHandleFirstPayMethod;

    /* renamed from: com.tn.tranpay.fragment.PayFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayFragment a(BillingParams params, LoadConfigContent loadConfigContent, com.tn.tranpay.d dVar) {
            Intrinsics.h(params, "params");
            PayFragment payFragment = new PayFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", params);
            bundle.putParcelable("configBean", loadConfigContent);
            payFragment.setArguments(bundle);
            payFragment.paymentParams = params;
            payFragment.configBean = loadConfigContent;
            payFragment.mCallback = dVar;
            return payFragment;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f41616a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f41616a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f41616a;
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
            this.f41616a.invoke(obj);
        }
    }

    public PayFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tn.tranpay.fragment.PayFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(PaymentViewModel.class), new Function0<x0>() { // from class: com.tn.tranpay.fragment.PayFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.tn.tranpay.fragment.PayFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object invoke = Function0.this.invoke();
                androidx.view.m mVar = invoke instanceof androidx.view.m ? (androidx.view.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(int responseCode, String message, String serverCode) {
        BillingParams billingParams;
        com.tn.tranpay.c cVar = (m0().A() == null || (billingParams = this.paymentParams) == null) ? null : new com.tn.tranpay.c(billingParams.getOrderId(), billingParams.getOrderDesc(), billingParams.getAmount(), m0().A(), billingParams.getPayByLocalCurrency());
        if (com.tn.tranpay.a.f41559a.a(responseCode)) {
            com.tn.tranpay.report.h.f(com.tn.tranpay.report.h.f41739a, 1, null, 2, null);
        } else if (responseCode == 1) {
            com.tn.tranpay.report.h.f41739a.e(0, Boolean.TRUE);
        } else {
            com.tn.tranpay.report.h.f41739a.e(0, Boolean.FALSE);
        }
        com.tn.tranpay.b a11 = com.tn.tranpay.b.f41576c.a(responseCode, message, serverCode);
        com.tn.tranpay.d o11 = m0().o();
        if (o11 != null) {
            o11.a(a11, cVar);
        }
        m0().K(null);
        m0().i();
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j0(PayFragment payFragment, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str2 = null;
        }
        payFragment.i0(i11, str, str2);
    }

    private final boolean k0(List list) {
        if (list == null || list.size() != 1) {
            return false;
        }
        List<InputInfoBean> inputs = ((MediumInputBean) list.get(0)).getInputs();
        return inputs == null || inputs.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentViewModel m0() {
        return (PaymentViewModel) this.viewModel.getValue();
    }

    private final boolean n0(String appLink, String packageName) {
        if (packageName != null && packageName.length() != 0) {
            PayUtils payUtils = PayUtils.f41690a;
            if (!PayUtils.e(payUtils, packageName, null, 2, null)) {
                ai.a.g(ai.a.f694a, "handleAppLink: " + packageName + " not installed", null, 2, null);
                return false;
            }
            if (appLink != null && appLink.length() != 0) {
                return payUtils.g(appLink);
            }
        }
        return false;
    }

    private final void p0() {
        this.canHandleFirstPayMethod = false;
        LoadConfigContent loadConfigContent = this.configBean;
        if (!k0(loadConfigContent != null ? loadConfigContent.getMedium() : null) || m0().t()) {
            return;
        }
        this.canHandleFirstPayMethod = true;
        m0().L(true);
        LoadConfigContent loadConfigContent2 = this.configBean;
        List<MediumInputBean> medium = loadConfigContent2 != null ? loadConfigContent2.getMedium() : null;
        Intrinsics.e(medium);
        String code = medium.get(0).getCode();
        if (code == null) {
            code = "";
        }
        String str = code;
        com.tn.tranpay.report.h.f41739a.a(str, false, false, true);
        PaymentViewModel.k(m0(), str, null, null, true, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandleResultType q0(CreateOrderResultContent result) {
        String rnUrl = result.getRnUrl();
        yh.a payInstruction = result.getPayInstruction();
        String a11 = payInstruction != null ? payInstruction.a() : null;
        String webUrl = result.getWebUrl();
        try {
            Result.Companion companion = Result.INSTANCE;
            if (n0(rnUrl, a11)) {
                ai.a.g(ai.a.f694a, "handleAppLink: " + a11 + " installed", null, 2, null);
                com.tn.tranpay.report.h.f41739a.d(1, webUrl, rnUrl, a11, m0().n());
                return HandleResultType.APP_LINK;
            }
            if (webUrl == null) {
                ai.a.g(ai.a.f694a, "rnUrl and webUrl is null that don't need to handle anything", null, 2, null);
                com.tn.tranpay.report.h.f41739a.d(2, null, rnUrl, a11, m0().n());
                return HandleResultType.OPERATOR;
            }
            ai.a.g(ai.a.f694a, "handleWebUrl: " + webUrl, null, 2, null);
            r0(webUrl);
            com.tn.tranpay.report.h.f41739a.d(0, webUrl, rnUrl, a11, m0().n());
            return HandleResultType.WEB;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(Result.m1185constructorimpl(ResultKt.a(th2)));
            if (m1188exceptionOrNullimpl == null) {
                return HandleResultType.EXCEPTION;
            }
            ai.a.e(ai.a.f694a, "handleResult: " + m1188exceptionOrNullimpl, null, 2, null);
            com.tn.tranpay.report.h.f41739a.d(-1, webUrl, rnUrl, a11, m0().n());
            return HandleResultType.EXCEPTION;
        }
    }

    private final void r0(String webUrl) {
        try {
            Application d11 = TranPay.f41540a.d();
            Intent intent = new Intent();
            intent.putExtra("url", webUrl);
            BillingParams billingParams = this.paymentParams;
            intent.putExtra("cpFrontPage", billingParams != null ? billingParams.getCpFrontPage() : null);
            BillingParams billingParams2 = this.paymentParams;
            intent.putExtra("shouldOpenCpFrontPage", billingParams2 != null ? Boolean.valueOf(billingParams2.getShouldOpenCpFrontPage()) : null);
            intent.setClass(d11, TranPayWebActivity.class);
            intent.addFlags(ASTNode.DEOP);
            d11.startActivity(intent);
        } catch (Exception e11) {
            ai.a.e(ai.a.f694a, "Failed to handle web URL: " + e11.getMessage(), null, 2, null);
        }
    }

    private final void s0() {
        final Gson gson = new Gson();
        Transformations.a(m0().s()).j(getViewLifecycleOwner(), new c(new Function1<CreateOrderResultContent, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observeLiveData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CreateOrderResultContent) obj);
                return Unit.f67184a;
            }

            public final void invoke(CreateOrderResultContent createOrderResultContent) {
                PaymentViewModel m02;
                PaymentViewModel m03;
                PaymentViewModel m04;
                PaymentViewModel m05;
                PaymentViewModel m06;
                PaymentViewModel m07;
                PaymentViewModel m08;
                PaymentViewModel m09;
                PaymentViewModel m010;
                PaymentViewModel m011;
                PaymentViewModel m012;
                PaymentViewModel m013;
                PaymentViewModel m014;
                HandleResultType q02;
                PaymentViewModel m015;
                PaymentViewModel m016;
                ai.a aVar = ai.a.f694a;
                ai.a.g(aVar, "resultContent is " + Gson.this.toJson(createOrderResultContent) + ", " + (createOrderResultContent != null ? createOrderResultContent.getStatus() : null), null, 2, null);
                PayFragment.b onDismissListener = this.getOnDismissListener();
                if (onDismissListener != null) {
                    onDismissListener.a();
                }
                m02 = this.m0();
                if (m02.u()) {
                    return;
                }
                if (createOrderResultContent == null) {
                    m03 = this.m0();
                    m03.w().n(Boolean.FALSE);
                    com.tn.tranpay.report.h hVar = com.tn.tranpay.report.h.f41739a;
                    m04 = this.m0();
                    String y10 = m04.y();
                    m05 = this.m0();
                    String p11 = m05.p();
                    m06 = this.m0();
                    hVar.k(false, y10, p11, m06.n());
                    PayFragment.j0(this, 5, "Create order failed", null, 4, null);
                    return;
                }
                if (!Intrinsics.c(createOrderResultContent.getCode(), "0000") || Intrinsics.c(createOrderResultContent.getStatus(), "0") || createOrderResultContent.getTxnId() == null) {
                    m07 = this.m0();
                    m07.w().n(Boolean.FALSE);
                    com.tn.tranpay.report.h hVar2 = com.tn.tranpay.report.h.f41739a;
                    m08 = this.m0();
                    String y11 = m08.y();
                    m09 = this.m0();
                    String p12 = m09.p();
                    m010 = this.m0();
                    hVar2.k(false, y11, p12, m010.n());
                    this.i0(5, createOrderResultContent.getMessage(), createOrderResultContent.getCode());
                    return;
                }
                m011 = this.m0();
                m011.M(true);
                ai.a.g(aVar, "createOrderResultLiveData: " + Gson.this.toJson(createOrderResultContent), null, 2, null);
                com.tn.tranpay.report.h hVar3 = com.tn.tranpay.report.h.f41739a;
                m012 = this.m0();
                String y12 = m012.y();
                m013 = this.m0();
                String p13 = m013.p();
                m014 = this.m0();
                hVar3.k(true, y12, p13, m014.n());
                q02 = this.q0(createOrderResultContent);
                if (q02 != HandleResultType.APP_LINK && q02 != HandleResultType.OPERATOR) {
                    m016 = this.m0();
                    m016.w().n(Boolean.FALSE);
                } else {
                    m015 = this.m0();
                    String txnId = createOrderResultContent.getTxnId();
                    Intrinsics.e(txnId);
                    PaymentViewModel.H(m015, txnId, 0L, 0L, 6, null);
                }
            }
        }));
        m0().z().j(getViewLifecycleOwner(), new c(new Function1<yh.b, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observeLiveData$2

            /* loaded from: classes4.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f41617a;

                static {
                    int[] iArr = new int[QueryStatus.values().length];
                    try {
                        iArr[QueryStatus.FAILURE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[QueryStatus.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[QueryStatus.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[QueryStatus.PROCESSING.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[QueryStatus.CANCELLED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f41617a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((yh.b) obj);
                return Unit.f67184a;
            }

            public final void invoke(yh.b bVar) {
                String str;
                PaymentViewModel m02;
                String str2;
                ai.a aVar = ai.a.f694a;
                ai.a.g(aVar, "resultContent is " + Gson.this.toJson(bVar) + ", " + (bVar != null ? bVar.b() : null), null, 2, null);
                if (bVar != null) {
                    PayFragment payFragment = this;
                    QueryOrderResultContent a11 = bVar.a();
                    int i11 = a.f41617a[bVar.b().ordinal()];
                    if (i11 == 1) {
                        ai.a.g(aVar, "支付失败", null, 2, null);
                        if (a11 == null || (str = a11.getMessage()) == null) {
                            str = "Payment failed";
                        }
                        Intrinsics.e(a11);
                        payFragment.i0(6, str, a11.getCode());
                        return;
                    }
                    if (i11 == 2) {
                        ai.a.g(aVar, "支付成功", null, 2, null);
                        MMKV h11 = PaymentMMKV.f41698a.h();
                        m02 = payFragment.m0();
                        h11.putString("k_pay_method_code", m02.x());
                        if (a11 == null || (str2 = a11.getMessage()) == null) {
                            str2 = "Payment success";
                        }
                        PayFragment.j0(payFragment, 0, str2, null, 4, null);
                        return;
                    }
                    if (i11 == 3) {
                        ai.a.g(aVar, "支付异常", null, 2, null);
                        PayFragment.j0(payFragment, 2, "Payment error", null, 4, null);
                    } else if (i11 == 4) {
                        ai.a.g(aVar, "支付处理中", null, 2, null);
                        PayFragment.j0(payFragment, 4, "Payment processing", null, 4, null);
                    } else {
                        if (i11 != 5) {
                            return;
                        }
                        ai.a.g(aVar, "取消轮询", null, 2, null);
                    }
                }
            }
        }));
        Transformations.a(m0().w()).j(getViewLifecycleOwner(), new c(new Function1<Boolean, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observeLiveData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.f67184a;
            }

            public final void invoke(Boolean it) {
                FrameLayout frameLayout;
                boolean z10;
                FrameLayout frameLayout2;
                Intrinsics.g(it, "it");
                if (it.booleanValue()) {
                    z10 = PayFragment.this.canHandleFirstPayMethod;
                    if (!z10) {
                        frameLayout2 = PayFragment.this.loadingLayout;
                        if (frameLayout2 == null) {
                            return;
                        }
                        frameLayout2.setVisibility(0);
                        return;
                    }
                }
                frameLayout = PayFragment.this.loadingLayout;
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setVisibility(8);
            }
        }));
    }

    private final void t0() {
        t1 observeEvent;
        Function1<com.tn.tranpay.event.b, Unit> function1 = new Function1<com.tn.tranpay.event.b, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observerEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((com.tn.tranpay.event.b) obj);
                return Unit.f67184a;
            }

            public final void invoke(com.tn.tranpay.event.b event) {
                PaymentViewModel m02;
                t1 t1Var;
                PaymentViewModel m03;
                PaymentViewModel m04;
                Intrinsics.h(event, "event");
                ai.a aVar = ai.a.f694a;
                ai.a.c(aVar, "PaymentEvent: " + event, null, 2, null);
                if (event.a() < 0) {
                    ai.a.g(aVar, "支付取消", null, 2, null);
                    m03 = PayFragment.this.m0();
                    String A = m03.A();
                    if (A != null) {
                        m04 = PayFragment.this.m0();
                        PaymentViewModel.h(m04, A, "USER CANCEL", null, 4, null);
                    }
                    PayFragment.j0(PayFragment.this, 1, "Payment cancelled", null, 4, null);
                } else {
                    ai.a.g(aVar, "三方收银台页面关闭或完成，调整轮询时间继续查询", null, 2, null);
                    m02 = PayFragment.this.m0();
                    m02.J();
                }
                t1Var = PayFragment.this.paymentEventJob;
                if (t1Var != null) {
                    t1.a.b(t1Var, null, 1, null);
                }
            }
        };
        if (com.tn.tranpay.event.a.f41601a.c()) {
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = com.tn.tranpay.event.b.class.getName();
            Intrinsics.g(name, "T::class.java.name");
            observeEvent = flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
        } else {
            observeEvent = null;
            ai.a.e(ai.a.f694a, "TranPay SDK not initialized, cannot observe event. Please call TranPay.configure() in Application.onCreate()", null, 2, null);
        }
        this.paymentEventJob = observeEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u0(PayFragment this$0, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.h(this$0, "this$0");
        if (i11 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this$0.o0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(PayFragment this$0) {
        Intrinsics.h(this$0, "this$0");
        this$0.o0();
    }

    private final void x0() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.g(attributes, "it.attributes");
        attributes.gravity = 80;
        attributes.width = -1;
        if (getResources().getConfiguration().orientation == 2) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i11 = displayMetrics.widthPixels;
            int i12 = displayMetrics.heightPixels;
            attributes.width = (int) (i11 * 0.75d);
            attributes.height = (int) (i12 * 0.75d);
            attributes.gravity = 17;
        } else {
            attributes.height = a0.a(533.0f);
        }
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    /* renamed from: l0, reason: from getter */
    public final b getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void o0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            PayUtils.f41690a.n(activity, new Function0<Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$handleDismiss$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m864invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m864invoke() {
                    PaymentViewModel m02;
                    PaymentViewModel m03;
                    ai.a.c(ai.a.f694a, "用户点击了支付后的留存提示", null, 2, null);
                    com.tn.tranpay.report.h.f41739a.i();
                    m02 = PayFragment.this.m0();
                    String A = m02.A();
                    if (A != null) {
                        m03 = PayFragment.this.m0();
                        PaymentViewModel.h(m03, A, "USER CANCEL", null, 4, null);
                    }
                    PayFragment.j0(PayFragment.this, 1, "User cancelled", null, 4, null);
                }
            }, new Function0<Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$handleDismiss$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m865invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m865invoke() {
                    com.tn.tranpay.report.h.f41739a.g();
                    ai.a.c(ai.a.f694a, "用户拒绝了支付后的留存提示", null, 2, null);
                }
            });
            com.tn.tranpay.report.h.f41739a.h();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (getActivity() == null) {
            throw new IllegalStateException("Activity cannot be null");
        }
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setCanceledOnTouchOutside(false);
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tn.tranpay.fragment.b
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                boolean u02;
                u02 = PayFragment.u0(PayFragment.this, dialogInterface, i11, keyEvent);
                return u02;
            }
        });
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = onCreateDialog.getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.registerOnBackInvokedCallback(0, new OnBackInvokedCallback() { // from class: com.tn.tranpay.fragment.c
                public final void onBackInvoked() {
                    PayFragment.v0(PayFragment.this);
                }
            });
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        View inflate = inflater.inflate(R$layout.tran_fragment_payment_layout, container, false);
        if (savedInstanceState == null) {
            LoadConfigContent loadConfigContent = this.configBean;
            if (k0(loadConfigContent != null ? loadConfigContent.getMedium() : null)) {
                com.tn.tranpay.report.h.f41739a.l("main_tab_page");
                return inflate;
            }
            BillingParams billingParams = this.paymentParams;
            if (billingParams != null) {
                getChildFragmentManager().p().s(R$id.fragment_container, PayMainFragment.INSTANCE.a(billingParams, this.configBean)).i();
                b bVar = this.onDismissListener;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        b bVar = this.onDismissListener;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        x0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        BillingParams billingParams;
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (billingParams = (BillingParams) arguments.getParcelable("paymentParams")) == null) {
            return;
        }
        this.paymentParams = billingParams;
        Bundle arguments2 = getArguments();
        this.configBean = arguments2 != null ? (LoadConfigContent) arguments2.getParcelable("configBean") : null;
        PaymentViewModel m02 = m0();
        BillingParams billingParams2 = this.paymentParams;
        m02.N(billingParams2 != null ? billingParams2.getOrderId() : null);
        PaymentViewModel m03 = m0();
        BillingParams billingParams3 = this.paymentParams;
        m03.P(billingParams3 != null ? billingParams3.getTxnId() : null);
        if (m0().o() == null) {
            m0().K(this.mCallback);
        }
        this.loadingLayout = (FrameLayout) view.findViewById(R$id.loading_layout);
        ((ProgressBar) view.findViewById(R$id.loading_progress)).setIndeterminateTintList(ColorStateList.valueOf(com.tn.tranpay.e.f41591c.b().d()));
        t0();
        s0();
        p0();
    }

    public final void w0(b bVar) {
        this.onDismissListener = bVar;
    }
}
