package com.transsnet.login.phone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.KeyboardUtils;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.login.R$color;
import com.transsnet.login.R$string;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.login.widget.LoginProgressBar;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u0005H\u0014¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0004R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010P\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010\u001d\"\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010I¨\u0006S"}, d2 = {"Lcom/transsnet/login/phone/LoginPhoneCodeActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lzy/f;", "<init>", "()V", "", "initView", "C0", "", NotificationCompat.CATEGORY_MESSAGE, "J0", "(Ljava/lang/String;)V", "v0", "", "t0", "()J", "r0", "I0", "q0", "showLoading", "s0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "u0", "()Lzy/f;", "", "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "onDestroy", "getPageName", "()Ljava/lang/String;", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "onResume", "onPause", "Lcom/transsnet/login/phone/bean/LoginSmsCodeRequest;", "a", "Lcom/transsnet/login/phone/bean/LoginSmsCodeRequest;", "requestData", "Lcom/transsnet/login/phone/bean/LoginCheckPhoneExistResult;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsnet/login/phone/bean/LoginCheckPhoneExistResult;", "checkPhoneExistResult", "Lcom/transsnet/login/phone/LoginPhoneViewModel;", "c", "Lcom/transsnet/login/phone/LoginPhoneViewModel;", "mLoginPhoneViewModel", "Lck/h;", "d", "Lck/h;", "mBaseLoadingDialog", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "e", "Landroidx/activity/result/b;", "loginLaunch", "f", "Ljava/lang/String;", EventConstants.KEY_SOURCE, be.g.f16474b, "J", "mCountDownTime", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "mHandler", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "mCountDownRunnable", com.mbridge.msdk.foundation.same.report.j.f35620b, "Z", "getEnable", "setEnable", "(Z)V", OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, CampaignEx.JSON_KEY_AD_K, "mRunnable", "Login_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class LoginPhoneCodeActivity extends BaseActivity<zy.f> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private LoginSmsCodeRequest requestData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private LoginCheckPhoneExistResult checkPhoneExistResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private LoginPhoneViewModel mLoginPhoneViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ck.h mBaseLoadingDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String source;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean enable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long mCountDownTime = 60;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Runnable mCountDownRunnable = new Runnable() { // from class: com.transsnet.login.phone.g
        @Override // java.lang.Runnable
        public final void run() {
            LoginPhoneCodeActivity.G0(LoginPhoneCodeActivity.this);
        }
    };

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Runnable mRunnable = new Runnable() { // from class: com.transsnet.login.phone.h
        @Override // java.lang.Runnable
        public final void run() {
            LoginPhoneCodeActivity.H0(LoginPhoneCodeActivity.this);
        }
    };

    /* loaded from: classes7.dex */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LoginPhoneCodeActivity.this.q0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f60527a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f60527a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f60527a;
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
            this.f60527a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A0(LoginPhoneCodeActivity loginPhoneCodeActivity) {
        ((zy.f) loginPhoneCodeActivity.getMViewBinding()).f79676d.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(LoginPhoneCodeActivity loginPhoneCodeActivity, View view) {
        KeyboardUtils.d(loginPhoneCodeActivity);
    }

    private final void C0() {
        LoginPhoneViewModel loginPhoneViewModel = (LoginPhoneViewModel) new androidx.view.v0(this).a(LoginPhoneViewModel.class);
        loginPhoneViewModel.v().j(this, new b(new Function1() { // from class: com.transsnet.login.phone.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = LoginPhoneCodeActivity.F0(LoginPhoneCodeActivity.this, (Boolean) obj);
                return F0;
            }
        }));
        loginPhoneViewModel.G().j(this, new b(new Function1() { // from class: com.transsnet.login.phone.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D0;
                D0 = LoginPhoneCodeActivity.D0(LoginPhoneCodeActivity.this, (LoginSmsCodeRequest) obj);
                return D0;
            }
        }));
        loginPhoneViewModel.A().j(this, new b(new Function1() { // from class: com.transsnet.login.phone.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E0;
                E0 = LoginPhoneCodeActivity.E0(LoginPhoneCodeActivity.this, (String) obj);
                return E0;
            }
        }));
        this.mLoginPhoneViewModel = loginPhoneViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(LoginPhoneCodeActivity loginPhoneCodeActivity, LoginSmsCodeRequest loginSmsCodeRequest) {
        loginPhoneCodeActivity.s0();
        if (loginSmsCodeRequest != null) {
            loginPhoneCodeActivity.mCountDownTime = loginPhoneCodeActivity.t0();
            loginPhoneCodeActivity.mHandler.post(loginPhoneCodeActivity.mCountDownRunnable);
            HashMap hashMap = new HashMap();
            hashMap.put("is_login", "true");
            String str = loginPhoneCodeActivity.source;
            if (str != null) {
                hashMap.put(EventConstants.KEY_SOURCE, str);
            }
            hj.i.f64628a.p(loginPhoneCodeActivity.getPageName(), hashMap);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(LoginPhoneCodeActivity loginPhoneCodeActivity, String str) {
        loginPhoneCodeActivity.J0(str);
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", String.valueOf(str));
        String str2 = loginPhoneCodeActivity.source;
        if (str2 != null) {
            hashMap.put(EventConstants.KEY_SOURCE, str2);
        }
        hj.i.f64628a.p(loginPhoneCodeActivity.getPageName(), hashMap);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(LoginPhoneCodeActivity loginPhoneCodeActivity, Boolean bool) {
        loginPhoneCodeActivity.s0();
        if (bool.booleanValue()) {
            Intent intent = new Intent(loginPhoneCodeActivity, (Class<?>) LoginSetPwdActivity.class);
            intent.putExtra("requestData", loginPhoneCodeActivity.requestData);
            intent.putExtra("checkPhoneData", loginPhoneCodeActivity.checkPhoneExistResult);
            intent.putExtra(EventConstants.KEY_SOURCE, loginPhoneCodeActivity.source);
            androidx.activity.result.b bVar = loginPhoneCodeActivity.loginLaunch;
            if (bVar != null) {
                bVar.a(intent);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G0(LoginPhoneCodeActivity loginPhoneCodeActivity) {
        long j11 = loginPhoneCodeActivity.mCountDownTime - 1;
        loginPhoneCodeActivity.mCountDownTime = j11;
        if (j11 <= 0) {
            loginPhoneCodeActivity.I0();
            return;
        }
        ((zy.f) loginPhoneCodeActivity.getMViewBinding()).f79675c.setEnabled(false);
        ((zy.f) loginPhoneCodeActivity.getMViewBinding()).f79675c.setText(loginPhoneCodeActivity.getString(R$string.login_seconds, Long.valueOf(loginPhoneCodeActivity.mCountDownTime)));
        loginPhoneCodeActivity.r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void H0(LoginPhoneCodeActivity loginPhoneCodeActivity) {
        AppCompatEditText appCompatEditText = ((zy.f) loginPhoneCodeActivity.getMViewBinding()).f79676d;
        appCompatEditText.clearFocus();
        appCompatEditText.requestFocus();
        KeyboardUtils.i(appCompatEditText);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void I0() {
        ((zy.f) getMViewBinding()).f79675c.setText(R$string.login_phone_code_resend);
        ((zy.f) getMViewBinding()).f79675c.setEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J0(String msg) {
        if (msg == null || msg.length() == 0) {
            AppCompatTextView tvTips = ((zy.f) getMViewBinding()).f79680h;
            Intrinsics.g(tvTips, "tvTips");
            jg.c.g(tvTips);
        } else {
            AppCompatTextView tvTips2 = ((zy.f) getMViewBinding()).f79680h;
            Intrinsics.g(tvTips2, "tvTips");
            jg.c.k(tvTips2);
            ((zy.f) getMViewBinding()).f79680h.setText(msg);
        }
    }

    private final void initView() {
        String mail;
        String str;
        String phone;
        LoginCheckPhoneExistResult loginCheckPhoneExistResult;
        LoginCheckPhoneExistResult loginCheckPhoneExistResult2 = this.checkPhoneExistResult;
        if (loginCheckPhoneExistResult2 == null || loginCheckPhoneExistResult2.getExists() || ((loginCheckPhoneExistResult = this.checkPhoneExistResult) != null && loginCheckPhoneExistResult.getReset())) {
            AppCompatTextView tvProgress = ((zy.f) getMViewBinding()).f79678f.f79728d;
            Intrinsics.g(tvProgress, "tvProgress");
            jg.c.g(tvProgress);
            LoginProgressBar progress = ((zy.f) getMViewBinding()).f79678f.f79727c;
            Intrinsics.g(progress, "progress");
            jg.c.g(progress);
            LoginCheckPhoneExistResult loginCheckPhoneExistResult3 = this.checkPhoneExistResult;
            if (loginCheckPhoneExistResult3 != null && loginCheckPhoneExistResult3.getReset()) {
                ((zy.f) getMViewBinding()).f79678f.f79729e.setText(R$string.login_pwd_find);
            }
        } else {
            AppCompatTextView tvProgress2 = ((zy.f) getMViewBinding()).f79678f.f79728d;
            Intrinsics.g(tvProgress2, "tvProgress");
            jg.c.k(tvProgress2);
            LoginProgressBar progress2 = ((zy.f) getMViewBinding()).f79678f.f79727c;
            Intrinsics.g(progress2, "progress");
            jg.c.k(progress2);
            ((zy.f) getMViewBinding()).f79678f.f79727c.setProgress(2);
            ((zy.f) getMViewBinding()).f79678f.f79728d.setText("2/3");
            ((zy.f) getMViewBinding()).f79678f.f79727c.setProgress(300, 600);
        }
        ((zy.f) getMViewBinding()).f79674b.setSelected(true);
        ((zy.f) getMViewBinding()).f79678f.f79726b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPhoneCodeActivity.x0(LoginPhoneCodeActivity.this, view);
            }
        });
        ((zy.f) getMViewBinding()).f79674b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPhoneCodeActivity.y0(LoginPhoneCodeActivity.this, view);
            }
        });
        ((zy.f) getMViewBinding()).f79675c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPhoneCodeActivity.z0(LoginPhoneCodeActivity.this, view);
            }
        });
        AppCompatEditText etCode = ((zy.f) getMViewBinding()).f79676d;
        Intrinsics.g(etCode, "etCode");
        etCode.addTextChangedListener(new a());
        ((zy.f) getMViewBinding()).f79676d.post(new Runnable() { // from class: com.transsnet.login.phone.e
            @Override // java.lang.Runnable
            public final void run() {
                LoginPhoneCodeActivity.A0(LoginPhoneCodeActivity.this);
            }
        });
        ((zy.f) getMViewBinding()).getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPhoneCodeActivity.B0(LoginPhoneCodeActivity.this, view);
            }
        });
        LoginSmsCodeRequest loginSmsCodeRequest = this.requestData;
        String str2 = "";
        if (loginSmsCodeRequest == null || loginSmsCodeRequest.getAuthType() != 0) {
            LoginSmsCodeRequest loginSmsCodeRequest2 = this.requestData;
            if (loginSmsCodeRequest2 != null && (mail = loginSmsCodeRequest2.getMail()) != null) {
                str2 = mail;
            }
        } else {
            LoginSmsCodeRequest loginSmsCodeRequest3 = this.requestData;
            if (loginSmsCodeRequest3 == null || (str = loginSmsCodeRequest3.getCc()) == null) {
                str = "";
            }
            LoginSmsCodeRequest loginSmsCodeRequest4 = this.requestData;
            if (loginSmsCodeRequest4 != null && (phone = loginSmsCodeRequest4.getPhone()) != null) {
                str2 = phone;
            }
            str2 = "+" + str + " " + str2;
        }
        LoginCheckPhoneExistResult loginCheckPhoneExistResult4 = this.checkPhoneExistResult;
        if (loginCheckPhoneExistResult4 == null || !loginCheckPhoneExistResult4.getReset()) {
            LoginSmsCodeRequest loginSmsCodeRequest5 = this.requestData;
            if (loginSmsCodeRequest5 == null || loginSmsCodeRequest5.getAuthType() != 0) {
                ((zy.f) getMViewBinding()).f79679g.setText(getString(R$string.login_email_code_tips, str2));
            } else {
                ((zy.f) getMViewBinding()).f79679g.setText(getString(R$string.login_phone_code_tips, str2));
            }
        } else {
            ((zy.f) getMViewBinding()).f79679g.setText(getString(R$string.login_verify_code_tips, str2));
        }
        ((zy.f) getMViewBinding()).f79679g.setTextColor(androidx.core.content.b.getColor(this, R$color.base_color_999999));
        this.mHandler.post(this.mCountDownRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void q0() {
        Editable text = ((zy.f) getMViewBinding()).f79676d.getText();
        boolean z10 = false;
        if (text != null && text.length() == 6) {
            z10 = true;
        }
        this.enable = z10;
        if (z10) {
            J0(null);
        }
    }

    private final void r0() {
        this.mHandler.postDelayed(this.mCountDownRunnable, 1000L);
    }

    private final void s0() {
        ck.h hVar = this.mBaseLoadingDialog;
        if (hVar != null) {
            hVar.dismiss();
        }
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

    private final long t0() {
        String str;
        LoginSmsCodeRequest loginSmsCodeRequest = this.requestData;
        if (loginSmsCodeRequest == null || (str = loginSmsCodeRequest.account()) == null) {
            str = "";
        }
        return 60 - ((SystemClock.elapsedRealtime() - vy.f.f77605a.b().getLong(str, SystemClock.elapsedRealtime())) / 1000);
    }

    private final void v0() {
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsnet.login.phone.b
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                LoginPhoneCodeActivity.w0(LoginPhoneCodeActivity.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(LoginPhoneCodeActivity loginPhoneCodeActivity, ActivityResult it) {
        Intrinsics.h(it, "it");
        if (it.getResultCode() == -1) {
            loginPhoneCodeActivity.setResult(-1);
            loginPhoneCodeActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(LoginPhoneCodeActivity loginPhoneCodeActivity, View view) {
        loginPhoneCodeActivity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void y0(LoginPhoneCodeActivity loginPhoneCodeActivity, View view) {
        if (!loginPhoneCodeActivity.enable || loginPhoneCodeActivity.requestData == null) {
            loginPhoneCodeActivity.J0(loginPhoneCodeActivity.getString(R$string.login_verifcation_err));
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.login_net_err);
            return;
        }
        loginPhoneCodeActivity.showLoading();
        LoginSmsCodeRequest loginSmsCodeRequest = loginPhoneCodeActivity.requestData;
        if (loginSmsCodeRequest != null) {
            loginSmsCodeRequest.setVerificationCode(String.valueOf(((zy.f) loginPhoneCodeActivity.getMViewBinding()).f79676d.getText()));
        }
        LoginPhoneViewModel loginPhoneViewModel = loginPhoneCodeActivity.mLoginPhoneViewModel;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.M(loginPhoneCodeActivity.requestData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void z0(LoginPhoneCodeActivity loginPhoneCodeActivity, View view) {
        LoginCheckPhoneExistResult loginCheckPhoneExistResult;
        if (loginPhoneCodeActivity.mCountDownTime > 0) {
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.login_net_err);
            return;
        }
        loginPhoneCodeActivity.showLoading();
        LoginSmsCodeRequest loginSmsCodeRequest = loginPhoneCodeActivity.requestData;
        if (loginSmsCodeRequest != null) {
            loginSmsCodeRequest.setVerificationCode(String.valueOf(((zy.f) loginPhoneCodeActivity.getMViewBinding()).f79676d.getText()));
        }
        LoginPhoneViewModel loginPhoneViewModel = loginPhoneCodeActivity.mLoginPhoneViewModel;
        if (loginPhoneViewModel != null) {
            LoginSmsCodeRequest loginSmsCodeRequest2 = loginPhoneCodeActivity.requestData;
            LoginCheckPhoneExistResult loginCheckPhoneExistResult2 = loginPhoneCodeActivity.checkPhoneExistResult;
            int i11 = 1;
            if ((loginCheckPhoneExistResult2 != null && loginCheckPhoneExistResult2.getExists()) || ((loginCheckPhoneExistResult = loginPhoneCodeActivity.checkPhoneExistResult) != null && loginCheckPhoneExistResult.getReset())) {
                i11 = 2;
            }
            loginPhoneViewModel.E(loginSmsCodeRequest2, i11);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_login", "true");
        String str = loginPhoneCodeActivity.source;
        if (str == null) {
            str = "";
        }
        hashMap.put(EventConstants.KEY_SOURCE, str);
        hj.i.f64628a.p(loginPhoneCodeActivity.getPageName(), hashMap);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "code_enter";
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !ak.x.f733a.a();
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
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String str;
        HashMap g11;
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra(EventConstants.KEY_SOURCE)) == null) {
            str = null;
        } else {
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
            }
        }
        this.source = str;
        this.requestData = (LoginSmsCodeRequest) getIntent().getSerializableExtra("requestData");
        this.checkPhoneExistResult = (LoginCheckPhoneExistResult) getIntent().getSerializableExtra("checkPhoneData");
        this.mCountDownTime = t0();
        initView();
        C0();
        v0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        s0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((zy.f) getMViewBinding()).f79676d.removeCallbacks(this.mRunnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((zy.f) getMViewBinding()).f79676d.postDelayed(this.mRunnable, 500L);
        LoginProgressBar loginProgressBar = ((zy.f) getMViewBinding()).f79678f.f79727c;
        Intrinsics.e(loginProgressBar);
        if (!jg.c.i(loginProgressBar) || loginProgressBar.getProgress() > loginProgressBar.getStartProgress()) {
            return;
        }
        loginProgressBar.startProgressIncrease();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public zy.f getViewBinding() {
        zy.f c11 = zy.f.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
