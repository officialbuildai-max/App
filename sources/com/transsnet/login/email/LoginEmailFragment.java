package com.transsnet.login.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.cloud.tmc.integration.event.EventConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsnet.login.LoginActivity;
import com.transsnet.login.R$string;
import com.transsnet.login.constant.LoginType;
import com.transsnet.login.phone.LoginPhoneCodeActivity;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.login.widget.LoginProgressBar;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/transsnet/login/email/LoginEmailFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lzy/b;", "<init>", "()V", "", "showLoading", "i0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "k0", "(Landroid/view/LayoutInflater;)Lzy/b;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "onResume", "onDestroy", "Lcom/transsnet/login/email/c0;", "a", "Lkotlin/Lazy;", "j0", "()Lcom/transsnet/login/email/c0;", "mLoginEmailViewModel", "Landroidx/activity/result/b;", "Landroid/content/Intent;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroidx/activity/result/b;", "mLoginLaunch", "Lck/h;", "c", "Lck/h;", "mBaseLoadingDialog", "Lcom/transsnet/login/phone/bean/LoginSmsCodeRequest;", "d", "Lcom/transsnet/login/phone/bean/LoginSmsCodeRequest;", "mRequestBody", "", "e", "Ljava/lang/String;", EventConstants.KEY_SOURCE, "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "mRunnable", "Login_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class LoginEmailFragment extends BaseFragment<zy.b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLoginEmailViewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private androidx.activity.result.b mLoginLaunch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ck.h mBaseLoadingDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LoginSmsCodeRequest mRequestBody;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String source;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Runnable mRunnable;

    /* loaded from: classes7.dex */
    public static final class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ zy.b f60437a;

        public a(zy.b bVar) {
            this.f60437a = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str;
            if (editable == null || (str = editable.toString()) == null) {
                str = "";
            }
            if (com.blankj.utilcode.util.u.b(str)) {
                AppCompatTextView tvTips = this.f60437a.f79646i;
                Intrinsics.g(tvTips, "tvTips");
                jg.c.g(tvTips);
            }
            if (editable == null || editable.length() == 0) {
                AppCompatImageButton btnClear = this.f60437a.f79639b;
                Intrinsics.g(btnClear, "btnClear");
                jg.c.g(btnClear);
            } else {
                AppCompatImageButton btnClear2 = this.f60437a.f79639b;
                Intrinsics.g(btnClear2, "btnClear");
                jg.c.k(btnClear2);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f60438a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f60438a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f60438a;
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
            this.f60438a.invoke(obj);
        }
    }

    public LoginEmailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsnet.login.email.LoginEmailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.mLoginEmailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(c0.class), new Function0<x0>() { // from class: com.transsnet.login.email.LoginEmailFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsnet.login.email.LoginEmailFragment$special$$inlined$viewModels$default$3
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
        this.mRequestBody = new LoginSmsCodeRequest();
        this.mRunnable = new Runnable() { // from class: com.transsnet.login.email.e
            @Override // java.lang.Runnable
            public final void run() {
                LoginEmailFragment.r0(LoginEmailFragment.this);
            }
        };
    }

    private final void i0() {
        ck.h hVar = this.mBaseLoadingDialog;
        if (hVar != null) {
            hVar.dismiss();
        }
    }

    private final c0 j0() {
        return (c0) this.mLoginEmailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(LoginEmailFragment loginEmailFragment, LoginCheckPhoneExistResult loginCheckPhoneExistResult) {
        if (loginCheckPhoneExistResult == null) {
            loginEmailFragment.i0();
            return Unit.f67184a;
        }
        String mail = loginEmailFragment.mRequestBody.getMail();
        if (mail == null || mail.length() == 0) {
            return Unit.f67184a;
        }
        if (!loginCheckPhoneExistResult.getExists() || !loginCheckPhoneExistResult.getHasPassword()) {
            c0.i(loginEmailFragment.j0(), mail, 0, 2, null);
            return Unit.f67184a;
        }
        loginEmailFragment.i0();
        Intent intent = new Intent(loginEmailFragment.requireContext(), (Class<?>) LoginEmailPwdActivity.class);
        intent.putExtra("requestData", loginEmailFragment.mRequestBody);
        intent.putExtra("checkPhoneData", loginCheckPhoneExistResult);
        intent.putExtra(EventConstants.KEY_SOURCE, loginEmailFragment.source);
        androidx.activity.result.b bVar = loginEmailFragment.mLoginLaunch;
        if (bVar != null) {
            bVar.a(intent);
        }
        com.tn.lib.widget.toast.core.h.f41533a.k(R$string.login_existed);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(LoginEmailFragment loginEmailFragment, String str) {
        if (str != null) {
            Intent intent = new Intent(loginEmailFragment.requireContext(), (Class<?>) LoginPhoneCodeActivity.class);
            loginEmailFragment.mRequestBody.setType(1);
            intent.putExtra(EventConstants.KEY_SOURCE, loginEmailFragment.source);
            intent.putExtra("requestData", loginEmailFragment.mRequestBody);
            intent.putExtra("checkPhoneData", (Serializable) loginEmailFragment.j0().g().f());
            androidx.activity.result.b bVar = loginEmailFragment.mLoginLaunch;
            if (bVar != null) {
                bVar.a(intent);
            }
        }
        loginEmailFragment.i0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(zy.b bVar, View view) {
        bVar.f79642e.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(LoginEmailFragment loginEmailFragment, View view) {
        FragmentActivity activity = loginEmailFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(zy.b bVar, LoginEmailFragment loginEmailFragment, View view) {
        oh.g gVar = oh.g.f71143a;
        Context context = view.getContext();
        Intrinsics.g(context, "getContext(...)");
        if (!gVar.a(context)) {
            com.tn.lib.widget.toast.core.h.f41533a.k(com.tn.lib.widget.R$string.no_network_tips);
            return;
        }
        Editable text = bVar.f79642e.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null || obj.length() == 0 || !com.blankj.utilcode.util.u.b(obj)) {
            AppCompatTextView tvTips = bVar.f79646i;
            Intrinsics.g(tvTips, "tvTips");
            jg.c.k(tvTips);
            return;
        }
        AppCompatTextView tvTips2 = bVar.f79646i;
        Intrinsics.g(tvTips2, "tvTips");
        jg.c.g(tvTips2);
        loginEmailFragment.showLoading();
        LoginSmsCodeRequest loginSmsCodeRequest = loginEmailFragment.mRequestBody;
        String obj2 = StringsKt.n1(obj).toString();
        loginEmailFragment.j0().f(obj2);
        loginSmsCodeRequest.setMail(obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(LoginEmailFragment loginEmailFragment, View view) {
        FragmentActivity activity = loginEmailFragment.getActivity();
        LoginActivity loginActivity = activity instanceof LoginActivity ? (LoginActivity) activity : null;
        if (loginActivity != null) {
            loginActivity.e0(LoginType.PHONE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LoginEmailFragment loginEmailFragment) {
        AppCompatEditText appCompatEditText;
        zy.b mViewBinding = loginEmailFragment.getMViewBinding();
        if (mViewBinding == null || (appCompatEditText = mViewBinding.f79642e) == null) {
            return;
        }
        appCompatEditText.clearFocus();
        appCompatEditText.requestFocus();
        KeyboardUtils.i(appCompatEditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LoginEmailFragment loginEmailFragment, ActivityResult it) {
        FragmentActivity activity;
        Intrinsics.h(it, "it");
        if (it.getResultCode() != -1 || (activity = loginEmailFragment.getActivity()) == null) {
            return;
        }
        activity.setResult(-1);
        activity.finish();
    }

    private final void showLoading() {
        if (this.mBaseLoadingDialog == null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            this.mBaseLoadingDialog = new ck.h(requireContext);
        }
        ck.h hVar = this.mBaseLoadingDialog;
        if (hVar != null) {
            hVar.show();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        j0().g().j(this, new b(new Function1() { // from class: com.transsnet.login.email.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l02;
                l02 = LoginEmailFragment.l0(LoginEmailFragment.this, (LoginCheckPhoneExistResult) obj);
                return l02;
            }
        }));
        j0().j().j(this, new b(new Function1() { // from class: com.transsnet.login.email.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m02;
                m02 = LoginEmailFragment.m0(LoginEmailFragment.this, (String) obj);
                return m02;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        final zy.b mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f79640c.setSelected(true);
            AppCompatEditText etEmail = mViewBinding.f79642e;
            Intrinsics.g(etEmail, "etEmail");
            etEmail.addTextChangedListener(new a(mViewBinding));
            mViewBinding.f79639b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginEmailFragment.n0(zy.b.this, view2);
                }
            });
            mViewBinding.f79644g.f79726b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginEmailFragment.o0(LoginEmailFragment.this, view2);
                }
            });
            mViewBinding.f79644g.f79727c.setProgress(0, 300);
            mViewBinding.f79640c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginEmailFragment.p0(zy.b.this, this, view2);
                }
            });
            com.transsnet.login.w wVar = com.transsnet.login.w.f60691a;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            AppCompatTextView tvPrivacy = mViewBinding.f79645h;
            Intrinsics.g(tvPrivacy, "tvPrivacy");
            wVar.a(requireContext, tvPrivacy);
            if (vy.b.f77602a.b()) {
                LinearLayout llPhoneLoginEntry = mViewBinding.f79643f;
                Intrinsics.g(llPhoneLoginEntry, "llPhoneLoginEntry");
                jg.c.k(llPhoneLoginEntry);
                mViewBinding.f79641d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        LoginEmailFragment.q0(LoginEmailFragment.this, view2);
                    }
                });
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public zy.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        zy.b c11 = zy.b.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        HashMap g11;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(EventConstants.KEY_SOURCE)) == null) {
            str = null;
        } else {
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
            }
        }
        this.source = str;
        this.mLoginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsnet.login.email.d
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                LoginEmailFragment.s0(LoginEmailFragment.this, (ActivityResult) obj);
            }
        });
        this.mRequestBody.setAuthType(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        androidx.activity.result.b bVar = this.mLoginLaunch;
        if (bVar != null) {
            bVar.c();
        }
        i0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        zy.l lVar;
        LoginProgressBar loginProgressBar;
        AppCompatEditText appCompatEditText;
        super.onResume();
        zy.b mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatEditText = mViewBinding.f79642e) != null) {
            appCompatEditText.postDelayed(this.mRunnable, 500L);
        }
        zy.b mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (lVar = mViewBinding2.f79644g) == null || (loginProgressBar = lVar.f79727c) == null || loginProgressBar.getProgress() > 0) {
            return;
        }
        loginProgressBar.startProgressIncrease();
    }
}
