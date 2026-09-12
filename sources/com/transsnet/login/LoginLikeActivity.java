package com.transsnet.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.view.c0;
import androidx.view.v0;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.miniutils.constant.PermissionConstants;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.Task;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.login.email.LoginEmailPwdActivity;
import com.transsnet.login.phone.LoginPwdActivity;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u001d\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\nJ\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010\nJ\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\nJ\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J)\u0010-\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0004\b-\u0010.R\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00104R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010A\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00104R\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010>\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010>\u001a\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lcom/transsnet/login/LoginLikeActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lzy/e;", "<init>", "()V", "", "y0", "initView", "", "G0", "()Z", "J0", "o0", "u0", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "completedTask", "x0", "(Lcom/google/android/gms/tasks/Task;)V", "account", "v0", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;)V", "E0", "showLoading", "p0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "t0", "()Lzy/e;", "isTranslucent", "isStatusDark", "isChangeStatusBar", "", "getPageName", "()Ljava/lang/String;", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroidx/activity/result/b;", "a", "Landroidx/activity/result/b;", "loginLaunch", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", EventConstants.KEY_SOURCE, "c", "titleName", "Lcom/transsnet/login/LoginViewModel;", "d", "Lcom/transsnet/login/LoginViewModel;", "loginViewModel", "Lcom/transsnet/loginapi/ILoginApi;", "e", "Lkotlin/Lazy;", "s0", "()Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi", "f", "oldUid", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", be.g.f16474b, "q0", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "gso", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "h", "r0", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "mGoogleSignInClient", "Lck/h;", "i", "Lck/h;", "mBaseLoadingDialog", com.mbridge.msdk.foundation.same.report.j.f35620b, "Login_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class LoginLikeActivity extends BaseActivity<zy.e> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String titleName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LoginViewModel loginViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String oldUid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ck.h mBaseLoadingDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsnet.login.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi I0;
            I0 = LoginLikeActivity.I0();
            return I0;
        }
    });

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy gso = LazyKt.b(new Function0() { // from class: com.transsnet.login.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            GoogleSignInOptions w02;
            w02 = LoginLikeActivity.w0(LoginLikeActivity.this);
            return w02;
        }
    });

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy mGoogleSignInClient = LazyKt.b(new Function0() { // from class: com.transsnet.login.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            GoogleSignInClient H0;
            H0 = LoginLikeActivity.H0(LoginLikeActivity.this);
            return H0;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f60394a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f60394a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f60394a;
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
            this.f60394a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(LoginLikeActivity loginLikeActivity, View view) {
        String string = vy.d.f77603a.b().getString("login_last_login_type", null);
        HashMap hashMap = new HashMap();
        if (Intrinsics.c(string, PermissionConstants.PHONE)) {
            androidx.activity.result.b bVar = loginLikeActivity.loginLaunch;
            if (bVar != null) {
                Intent intent = new Intent(loginLikeActivity, (Class<?>) LoginPwdActivity.class);
                intent.putExtra(EventConstants.KEY_SOURCE, loginLikeActivity.source);
                bVar.a(intent);
            }
            hashMap.put("module_name", "sign up with phone number");
        } else {
            androidx.activity.result.b bVar2 = loginLikeActivity.loginLaunch;
            if (bVar2 != null) {
                Intent intent2 = new Intent(loginLikeActivity, (Class<?>) LoginEmailPwdActivity.class);
                intent2.putExtra(EventConstants.KEY_SOURCE, loginLikeActivity.source);
                bVar2.a(intent2);
            }
            hashMap.put("module_name", "sign_up_email");
        }
        String str = loginLikeActivity.source;
        if (str != null) {
            hashMap.put(EventConstants.KEY_SOURCE, str);
        }
        hj.i.f64628a.p("sign_up_dialog", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(LoginLikeActivity loginLikeActivity, View view) {
        loginLikeActivity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(LoginLikeActivity loginLikeActivity, View view) {
        loginLikeActivity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void D0(LoginLikeActivity loginLikeActivity, View view) {
        androidx.activity.result.b bVar;
        if (com.transsion.baseui.util.c.f43558a.a(((zy.e) loginLikeActivity.getMViewBinding()).f79664b.getId(), 2000L) || (bVar = loginLikeActivity.loginLaunch) == null) {
            return;
        }
        Intent intent = new Intent(loginLikeActivity, (Class<?>) LoginActivity.class);
        intent.putExtra(EventConstants.KEY_SOURCE, loginLikeActivity.source);
        bVar.a(intent);
    }

    private final void E0() {
        LoginViewModel loginViewModel = (LoginViewModel) new v0(this).a(LoginViewModel.class);
        loginViewModel.j().j(this, new b(new Function1() { // from class: com.transsnet.login.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = LoginLikeActivity.F0(LoginLikeActivity.this, (UserInfo) obj);
                return F0;
            }
        }));
        this.loginViewModel = loginViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(LoginLikeActivity loginLikeActivity, UserInfo userInfo) {
        loginLikeActivity.p0();
        if (userInfo != null) {
            loginLikeActivity.finish();
        }
        return Unit.f67184a;
    }

    private final boolean G0() {
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this) == 0;
        } catch (Throwable th2) {
            lg.a.f68962a.h("LoginLikeActivity", "isGooglePlayServicesAvailable error: " + th2.getMessage(), th2, true);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GoogleSignInClient H0(LoginLikeActivity loginLikeActivity) {
        GoogleSignInClient client = GoogleSignIn.getClient((Activity) loginLikeActivity, loginLikeActivity.q0());
        Intrinsics.g(client, "getClient(...)");
        return client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi I0() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J0() {
        if (G0()) {
            ((zy.e) getMViewBinding()).f79665c.setVisibility(0);
            ((zy.e) getMViewBinding()).f79665c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginLikeActivity.K0(LoginLikeActivity.this, view);
                }
            });
        } else {
            ((zy.e) getMViewBinding()).f79665c.setVisibility(8);
            lg.a.f68962a.c("LoginLikeActivity", "Google login hidden: Play services not available", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(LoginLikeActivity loginLikeActivity, View view) {
        loginLikeActivity.o0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str = this.titleName;
        if (str != null && str.length() != 0) {
            ((zy.e) getMViewBinding()).f79671i.setText(this.titleName);
        }
        ((zy.e) getMViewBinding()).f79672j.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginLikeActivity.B0(LoginLikeActivity.this, view);
            }
        });
        ((zy.e) getMViewBinding()).f79666d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginLikeActivity.C0(LoginLikeActivity.this, view);
            }
        });
        if (vy.b.f77602a.b()) {
            ((zy.e) getMViewBinding()).f79668f.setText(getString(R$string.login_continue_with_phone_or_email));
            ((zy.e) getMViewBinding()).f79668f.setCompoundDrawablesRelativeWithIntrinsicBounds(R$mipmap.login_phone_email_icon, 0, 0, 0);
        }
        ((zy.e) getMViewBinding()).f79664b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginLikeActivity.D0(LoginLikeActivity.this, view);
            }
        });
        AppCompatTextView tvLogIn = ((zy.e) getMViewBinding()).f79669g;
        Intrinsics.g(tvLogIn, "tvLogIn");
        com.transsion.baseui.util.q.c(tvLogIn, com.blankj.utilcode.util.i.e(8.0f));
        ((zy.e) getMViewBinding()).f79669g.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginLikeActivity.A0(LoginLikeActivity.this, view);
            }
        });
        w wVar = w.f60691a;
        AppCompatTextView tvPrivacy = ((zy.e) getMViewBinding()).f79670h;
        Intrinsics.g(tvPrivacy, "tvPrivacy");
        wVar.a(this, tvPrivacy);
        J0();
    }

    private final void o0() {
        if (G0()) {
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "google");
            String str = this.source;
            if (str != null) {
                hashMap.put(EventConstants.KEY_SOURCE, str);
            }
            hj.i.f64628a.p("sign_up_dialog", hashMap);
            GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(this);
            if (lastSignedInAccount != null) {
                Scope[] scopeArray = q0().getScopeArray();
                if (GoogleSignIn.hasPermissions(lastSignedInAccount, (Scope[]) Arrays.copyOf(scopeArray, scopeArray.length)) && !lastSignedInAccount.isExpired()) {
                    v0(lastSignedInAccount);
                    return;
                }
            }
            u0();
        }
    }

    private final void p0() {
        ck.h hVar = this.mBaseLoadingDialog;
        if (hVar != null) {
            hVar.dismiss();
        }
    }

    private final GoogleSignInOptions q0() {
        return (GoogleSignInOptions) this.gso.getValue();
    }

    private final GoogleSignInClient r0() {
        return (GoogleSignInClient) this.mGoogleSignInClient.getValue();
    }

    private final ILoginApi s0() {
        return (ILoginApi) this.mLoginApi.getValue();
    }

    private final void showLoading() {
        if (this.mBaseLoadingDialog == null) {
            this.mBaseLoadingDialog = new ck.h(this);
        }
        ck.h hVar = this.mBaseLoadingDialog;
        if (hVar != null) {
            hVar.show();
        }
    }

    private final void u0() {
        Intent signInIntent = r0().getSignInIntent();
        Intrinsics.g(signInIntent, "getSignInIntent(...)");
        startActivityForResult(signInIntent, 10010);
    }

    private final void v0(GoogleSignInAccount account) {
        String idToken;
        if (account == null || (idToken = account.getIdToken()) == null) {
            return;
        }
        showLoading();
        LoginViewModel loginViewModel = this.loginViewModel;
        if (loginViewModel != null) {
            loginViewModel.k(idToken, this.oldUid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GoogleSignInOptions w0(LoginLikeActivity loginLikeActivity) {
        GoogleSignInOptions build = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(loginLikeActivity.getString(R$string.google_client_token)).requestEmail().requestProfile().build();
        Intrinsics.g(build, "build(...)");
        return build;
    }

    private final void x0(Task completedTask) {
        try {
            v0((GoogleSignInAccount) completedTask.getResult(ApiException.class));
        } catch (ApiException e11) {
            lg.a.f68962a.x("LoginLikeActivity", "signInResult failed code=" + e11.getStatusCode(), true);
        }
    }

    private final void y0() {
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsnet.login.j
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                LoginLikeActivity.z0(LoginLikeActivity.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(LoginLikeActivity loginLikeActivity, ActivityResult it) {
        Intrinsics.h(it, "it");
        if (it.getResultCode() == -1) {
            loginLikeActivity.setResult(-1);
            loginLikeActivity.finish();
            return;
        }
        if (it.getResultCode() == 10086) {
            Intent data = it.getData();
            if (Intrinsics.c(data != null ? data.getStringExtra("KEY_LOGIN_TYPE") : null, PermissionConstants.PHONE)) {
                androidx.activity.result.b bVar = loginLikeActivity.loginLaunch;
                if (bVar != null) {
                    Intent intent = new Intent(loginLikeActivity, (Class<?>) LoginPwdActivity.class);
                    intent.putExtra(EventConstants.KEY_SOURCE, loginLikeActivity.source);
                    bVar.a(intent);
                    return;
                }
                return;
            }
            androidx.activity.result.b bVar2 = loginLikeActivity.loginLaunch;
            if (bVar2 != null) {
                Intent intent2 = new Intent(loginLikeActivity, (Class<?>) LoginEmailPwdActivity.class);
                intent2.putExtra(EventConstants.KEY_SOURCE, loginLikeActivity.source);
                bVar2.a(intent2);
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "sign_up_dialog";
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public hj.b newLogViewConfig() {
        return new hj.b(getPageName(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10010 && G0()) {
            Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(data);
            Intrinsics.g(signedInAccountFromIntent, "getSignedInAccountFromIntent(...)");
            x0(signedInAccountFromIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        UserInfo i11;
        HashMap g11;
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra(EventConstants.KEY_SOURCE);
        String str = null;
        if (stringExtra != null) {
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
            }
        } else {
            stringExtra = null;
        }
        this.source = stringExtra;
        this.titleName = getIntent().getStringExtra("title_name");
        ILoginApi s02 = s0();
        if (s02 != null && (i11 = s02.i()) != null) {
            str = i11.getUserId();
        }
        this.oldUid = str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LoginLikeActivity: oldUid -> ");
        sb2.append(str);
        E0();
        initView();
        y0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public zy.e getViewBinding() {
        zy.e c11 = zy.e.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
