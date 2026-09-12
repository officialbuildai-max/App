package com.tn.tranpay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tn.lib.tranpay.R$layout;
import com.tn.lib.tranpay.R$string;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlinx.coroutines.o0;

@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0016\u0018\u0000 n2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J1\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J-\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b)\u0010*J!\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\"\u0010>\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010G\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010M\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u00103\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010Q\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u00103\u001a\u0004\bO\u0010J\"\u0004\bP\u0010LR$\u0010U\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u00103\u001a\u0004\bS\u0010J\"\u0004\bT\u0010LR$\u0010Y\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u00103\u001a\u0004\bW\u0010J\"\u0004\bX\u0010LR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b[\u0010\\R\u001b\u0010c\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR*\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u00109¨\u0006o"}, d2 = {"Lcom/tn/tranpay/fragment/PaySubFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "t0", "", "inputType", "Landroidx/appcompat/widget/AppCompatEditText;", "inputView", "Landroidx/appcompat/widget/AppCompatTextView;", "errorView", AppMeasurementSdk.ConditionalUserProperty.VALUE, "j0", "(Ljava/lang/String;Landroidx/appcompat/widget/AppCompatEditText;Landroidx/appcompat/widget/AppCompatTextView;Ljava/lang/String;)V", "s0", "n0", "q0", "k0", "Landroidx/appcompat/widget/AppCompatImageView;", "clearButton", "regex", "com/tn/tranpay/fragment/PaySubFragment$b", "g0", "(Landroidx/appcompat/widget/AppCompatImageView;Landroidx/appcompat/widget/AppCompatTextView;Ljava/lang/String;)Lcom/tn/tranpay/fragment/PaySubFragment$b;", MimeTypes.BASE_TYPE_TEXT, "", "x0", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/tn/tranpay/bean/LoadConfigContent;", "info", "l0", "(Lcom/tn/tranpay/bean/LoadConfigContent;)V", "w0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/tn/tranpay/BillingParams;", "a", "Lcom/tn/tranpay/BillingParams;", "paymentParams", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "mobileCode", "c", "Lcom/tn/tranpay/bean/LoadConfigContent;", "configBean", "d", "Z", "getNeedCnic", "()Z", "setNeedCnic", "(Z)V", "needCnic", "", "Lcom/tn/tranpay/bean/InputInfoBean;", "e", "Ljava/util/List;", "getInputs", "()Ljava/util/List;", "setInputs", "(Ljava/util/List;)V", "inputs", "f", "getPayMethod", "()Ljava/lang/String;", "setPayMethod", "(Ljava/lang/String;)V", "payMethod", be.g.f16474b, "h0", "setPayMethodCode", "payMethodCode", "h", "getPhone", "setPhone", "phone", "i", "getCnic", "setCnic", "cnic", "Lgh/b;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lgh/b;", "viewBinding", "Lcom/tn/tranpay/viewmodel/PaymentViewModel;", CampaignEx.JSON_KEY_AD_K, "Lkotlin/Lazy;", "i0", "()Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "viewModel", "Lkotlin/Function0;", "l", "Lkotlin/jvm/functions/Function0;", "getOnFragmentPopped", "()Lkotlin/jvm/functions/Function0;", "m0", "(Lkotlin/jvm/functions/Function0;)V", "onFragmentPopped", "m", "isPayable", "n", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class PaySubFragment extends Fragment {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private BillingParams paymentParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String mobileCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private LoadConfigContent configBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needCnic;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List inputs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String payMethod;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String payMethodCode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String phone;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String cnic;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private gh.b viewBinding;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Function0 onFragmentPopped;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isPayable;

    /* renamed from: com.tn.tranpay.fragment.PaySubFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaySubFragment a(BillingParams params, LoadConfigContent loadConfigContent, boolean z10, List inputs, String payMethod, String payMethodCode, String str, String str2) {
            Intrinsics.h(params, "params");
            Intrinsics.h(inputs, "inputs");
            Intrinsics.h(payMethod, "payMethod");
            Intrinsics.h(payMethodCode, "payMethodCode");
            PaySubFragment paySubFragment = new PaySubFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", params);
            bundle.putParcelable("configBean", loadConfigContent);
            bundle.putBoolean("needCnic", z10);
            bundle.putParcelableArrayList("inputs", new ArrayList<>(inputs));
            bundle.putString("payMethod", payMethod);
            bundle.putString("payMethodCode", payMethodCode);
            bundle.putString("phone", str);
            bundle.putString("cnic", str2);
            paySubFragment.setArguments(bundle);
            return paySubFragment;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatImageView f41649a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PaySubFragment f41650b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f41651c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppCompatTextView f41652d;

        b(AppCompatImageView appCompatImageView, PaySubFragment paySubFragment, String str, AppCompatTextView appCompatTextView) {
            this.f41649a = appCompatImageView;
            this.f41650b = paySubFragment;
            this.f41651c = str;
            this.f41652d = appCompatTextView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f41652d.setVisibility(this.f41650b.x0(this.f41651c, String.valueOf(editable)) ? 8 : 0);
            this.f41650b.w0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f41649a.setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
        }
    }

    public PaySubFragment() {
        super(R$layout.tran_fragment_sub_layout);
        this.inputs = CollectionsKt.l();
        this.payMethod = "";
        this.payMethodCode = "";
        final Function0<y0> function0 = new Function0<y0>() { // from class: com.tn.tranpay.fragment.PaySubFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final y0 invoke() {
                Fragment requireParentFragment = PaySubFragment.this.requireParentFragment();
                Intrinsics.g(requireParentFragment, "requireParentFragment()");
                return requireParentFragment;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(PaymentViewModel.class), new Function0<x0>() { // from class: com.tn.tranpay.fragment.PaySubFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.tn.tranpay.fragment.PaySubFragment$special$$inlined$viewModels$default$2
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
        this.isPayable = true;
    }

    private final b g0(AppCompatImageView clearButton, AppCompatTextView errorView, String regex) {
        return new b(clearButton, this, regex, errorView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentViewModel i0() {
        return (PaymentViewModel) this.viewModel.getValue();
    }

    private final void j0(String inputType, AppCompatEditText inputView, AppCompatTextView errorView, String value) {
        Object obj;
        Iterator it = this.inputs.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((InputInfoBean) obj).getType(), inputType)) {
                    break;
                }
            }
        }
        InputInfoBean inputInfoBean = (InputInfoBean) obj;
        if (inputInfoBean != null) {
            if (x0(inputInfoBean.getReg(), value)) {
                if (value == null) {
                    value = "";
                }
                inputView.setText(value);
            }
            inputView.setHint(inputInfoBean.getRealHint());
            errorView.setText(inputInfoBean.getRealTips());
        }
    }

    private final void k0() {
        Function0 function0 = this.onFragmentPopped;
        if (function0 != null) {
            function0.invoke();
        }
        getParentFragmentManager().g1();
    }

    private final void l0(LoadConfigContent info) {
        if (info != null) {
            gh.b bVar = this.viewBinding;
            if (bVar == null) {
                Intrinsics.z("viewBinding");
                bVar = null;
            }
            bVar.f63712k.setText(info.getCpName());
            AppCompatTextView appCompatTextView = bVar.f63707f;
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R$string.tranpay_amount, info.getSymbol()) : null);
            String orderDescription = info.getOrderDescription();
            if (orderDescription == null || orderDescription.length() == 0) {
                bVar.f63714m.setVisibility(8);
            } else {
                bVar.f63714m.setVisibility(0);
                bVar.f63714m.setText(orderDescription);
            }
            String cpName = info.getCpName();
            if (cpName == null || cpName.length() == 0) {
                bVar.f63713l.setVisibility(8);
            } else {
                bVar.f63713l.setVisibility(0);
                bVar.f63713l.setText(info.getCpName());
            }
            AppCompatTextView appCompatTextView2 = bVar.f63717p;
            Context context2 = getContext();
            appCompatTextView2.setText(context2 != null ? context2.getString(R$string.tranpay_order, info.getOrderId()) : null);
        }
    }

    private final void n0() {
        final gh.b bVar = this.viewBinding;
        if (bVar == null) {
            Intrinsics.z("viewBinding");
            bVar = null;
        }
        bVar.f63704c.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.o0(gh.b.this, view);
            }
        });
        bVar.f63703b.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.p0(gh.b.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(gh.b this_apply, View view) {
        Intrinsics.h(this_apply, "$this_apply");
        Editable text = this_apply.f63706e.getText();
        if (text != null) {
            text.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(gh.b this_apply, View view) {
        Intrinsics.h(this_apply, "$this_apply");
        Editable text = this_apply.f63705d.getText();
        if (text != null) {
            text.clear();
        }
    }

    private final void q0() {
        gh.b bVar = this.viewBinding;
        if (bVar == null) {
            Intrinsics.z("viewBinding");
            bVar = null;
        }
        bVar.f63718q.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.r0(PaySubFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(PaySubFragment this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        kotlinx.coroutines.k.d(o0.a(kotlinx.coroutines.y0.c()), null, null, new PaySubFragment$setupPayButtonListener$1$1(this$0, null), 3, null);
    }

    private final void s0() {
        Object obj;
        Object obj2;
        gh.b bVar = this.viewBinding;
        if (bVar == null) {
            Intrinsics.z("viewBinding");
            bVar = null;
        }
        AppCompatEditText appCompatEditText = bVar.f63706e;
        AppCompatImageView clearPhoneButton = bVar.f63704c;
        Intrinsics.g(clearPhoneButton, "clearPhoneButton");
        AppCompatTextView ivInputPhoneError = bVar.f63716o;
        Intrinsics.g(ivInputPhoneError, "ivInputPhoneError");
        Iterator it = this.inputs.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((InputInfoBean) obj).getType(), "Phone")) {
                    break;
                }
            }
        }
        InputInfoBean inputInfoBean = (InputInfoBean) obj;
        appCompatEditText.addTextChangedListener(g0(clearPhoneButton, ivInputPhoneError, inputInfoBean != null ? inputInfoBean.getReg() : null));
        AppCompatEditText appCompatEditText2 = bVar.f63705d;
        AppCompatImageView clearCnicButton = bVar.f63703b;
        Intrinsics.g(clearCnicButton, "clearCnicButton");
        AppCompatTextView ivInputCnicError = bVar.f63715n;
        Intrinsics.g(ivInputCnicError, "ivInputCnicError");
        Iterator it2 = this.inputs.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it2.next();
                if (Intrinsics.c(((InputInfoBean) obj2).getType(), "CNIC")) {
                    break;
                }
            }
        }
        InputInfoBean inputInfoBean2 = (InputInfoBean) obj2;
        appCompatEditText2.addTextChangedListener(g0(clearCnicButton, ivInputCnicError, inputInfoBean2 != null ? inputInfoBean2.getReg() : null));
    }

    private final void t0() {
        gh.b bVar = this.viewBinding;
        if (bVar == null) {
            Intrinsics.z("viewBinding");
            bVar = null;
        }
        bVar.f63709h.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.u0(PaySubFragment.this, view);
            }
        });
        bVar.f63708g.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaySubFragment.v0(PaySubFragment.this, view);
            }
        });
        bVar.f63710i.setVisibility(this.needCnic ? 0 : 8);
        AppCompatTextView appCompatTextView = bVar.f63720s;
        Context context = getContext();
        appCompatTextView.setText(context != null ? context.getString(R$string.tranpay_phone_code, this.mobileCode) : null);
        AppCompatTextView appCompatTextView2 = bVar.f63719r;
        Context context2 = getContext();
        appCompatTextView2.setText(context2 != null ? context2.getString(R$string.tranpay_method, this.payMethod) : null);
        AppCompatEditText inputPhone = bVar.f63706e;
        Intrinsics.g(inputPhone, "inputPhone");
        AppCompatTextView ivInputPhoneError = bVar.f63716o;
        Intrinsics.g(ivInputPhoneError, "ivInputPhoneError");
        j0("Phone", inputPhone, ivInputPhoneError, this.phone);
        AppCompatEditText inputCnic = bVar.f63705d;
        Intrinsics.g(inputCnic, "inputCnic");
        AppCompatTextView ivInputCnicError = bVar.f63715n;
        Intrinsics.g(ivInputCnicError, "ivInputCnicError");
        j0("CNIC", inputCnic, ivInputCnicError, this.cnic);
        w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(PaySubFragment this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        Fragment parentFragment = this$0.getParentFragment();
        PayFragment payFragment = parentFragment instanceof PayFragment ? (PayFragment) parentFragment : null;
        if (payFragment != null) {
            payFragment.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(PaySubFragment this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        this$0.k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        if (r5.f63715n.getVisibility() != 0) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w0() {
        /*
            r7 = this;
            gh.b r0 = r7.viewBinding
            r1 = 0
            java.lang.String r2 = "viewBinding"
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.z(r2)
            r0 = r1
        Lb:
            androidx.appcompat.widget.AppCompatEditText r0 = r0.f63706e
            android.text.Editable r0 = r0.getText()
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L2e
            int r0 = r0.length()
            if (r0 != 0) goto L1c
            goto L2e
        L1c:
            gh.b r0 = r7.viewBinding
            if (r0 != 0) goto L24
            kotlin.jvm.internal.Intrinsics.z(r2)
            r0 = r1
        L24:
            androidx.appcompat.widget.AppCompatTextView r0 = r0.f63716o
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L2e
            r0 = r4
            goto L2f
        L2e:
            r0 = r3
        L2f:
            boolean r5 = r7.needCnic
            if (r5 == 0) goto L5a
            gh.b r5 = r7.viewBinding
            if (r5 != 0) goto L3b
            kotlin.jvm.internal.Intrinsics.z(r2)
            r5 = r1
        L3b:
            androidx.appcompat.widget.AppCompatEditText r5 = r5.f63705d
            android.text.Editable r5 = r5.getText()
            if (r5 == 0) goto L5c
            int r5 = r5.length()
            if (r5 != 0) goto L4a
            goto L5c
        L4a:
            gh.b r5 = r7.viewBinding
            if (r5 != 0) goto L52
            kotlin.jvm.internal.Intrinsics.z(r2)
            r5 = r1
        L52:
            androidx.appcompat.widget.AppCompatTextView r5 = r5.f63715n
            int r5 = r5.getVisibility()
            if (r5 == 0) goto L5c
        L5a:
            r5 = r4
            goto L5d
        L5c:
            r5 = r3
        L5d:
            gh.b r6 = r7.viewBinding
            if (r6 != 0) goto L65
            kotlin.jvm.internal.Intrinsics.z(r2)
            goto L66
        L65:
            r1 = r6
        L66:
            androidx.appcompat.widget.AppCompatTextView r1 = r1.f63718q
            if (r0 == 0) goto L6d
            if (r5 == 0) goto L6d
            r3 = r4
        L6d:
            r1.setEnabled(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.fragment.PaySubFragment.w0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x0(String regex, String text) {
        return (regex != null && new Regex(regex).matches(String.valueOf(text))) || text == null || text.length() == 0;
    }

    /* renamed from: h0, reason: from getter */
    public final String getPayMethodCode() {
        return this.payMethodCode;
    }

    public final void m0(Function0 function0) {
        this.onFragmentPopped = function0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        return inflater.inflate(R$layout.tran_fragment_sub_layout, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        gh.b a11 = gh.b.a(view);
        Intrinsics.g(a11, "bind(view)");
        this.viewBinding = a11;
        Bundle arguments = getArguments();
        BillingParams billingParams = arguments != null ? (BillingParams) arguments.getParcelable("paymentParams") : null;
        if (billingParams == null) {
            return;
        }
        this.paymentParams = billingParams;
        Bundle arguments2 = getArguments();
        this.configBean = arguments2 != null ? (LoadConfigContent) arguments2.getParcelable("configBean") : null;
        Bundle arguments3 = getArguments();
        this.needCnic = arguments3 != null ? arguments3.getBoolean("needCnic") : false;
        Bundle arguments4 = getArguments();
        List parcelableArrayList = arguments4 != null ? arguments4.getParcelableArrayList("inputs") : null;
        if (parcelableArrayList == null) {
            parcelableArrayList = CollectionsKt.l();
        }
        this.inputs = parcelableArrayList;
        Bundle arguments5 = getArguments();
        String string = arguments5 != null ? arguments5.getString("payMethod") : null;
        if (string == null) {
            string = "";
        }
        this.payMethod = string;
        Bundle arguments6 = getArguments();
        String string2 = arguments6 != null ? arguments6.getString("payMethodCode") : null;
        this.payMethodCode = string2 != null ? string2 : "";
        Bundle arguments7 = getArguments();
        this.phone = arguments7 != null ? arguments7.getString("phone") : null;
        Bundle arguments8 = getArguments();
        this.cnic = arguments8 != null ? arguments8.getString("cnic") : null;
        this.mobileCode = i0().m();
        t0();
        s0();
        n0();
        q0();
        if (isAdded()) {
            l0(this.configBean);
        }
        com.tn.tranpay.report.h.f41739a.l("sub_tab_page");
    }
}
