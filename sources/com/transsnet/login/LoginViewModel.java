package com.transsnet.login;

import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import az.a;
import com.google.gson.JsonObject;
import com.meituan.android.walle.ChannelReader;
import com.therouter.TheRouter;
import com.transsion.memberapi.IPremiumApi;
import com.transsnet.login.bean.LoginThirdUserInfo;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes7.dex */
public final class LoginViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f60395a;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f60396b;

    /* renamed from: c, reason: collision with root package name */
    private final LiveData f60397c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f60398d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        public static final a f60399a = new a();

        a() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(JsonObject it) {
            Intrinsics.h(it, "it");
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String jsonElement = it.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            return companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements lz.h {
        b() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(RequestBody it) {
            Intrinsics.h(it, "it");
            return a.C0148a.d(LoginViewModel.this.h(), it, null, 2, null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f60402e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f60403f;

        c(String str, String str2) {
            this.f60402e = str;
            this.f60403f = str2;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            LoginViewModel.this.f60395a.q(null);
            if (str2 != null) {
                uh.b.f76876a.e(str2);
            }
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(LoginThirdUserInfo loginThirdUserInfo) {
            IPremiumApi i11;
            super.c(loginThirdUserInfo);
            String str = this.f60402e;
            if (str != null && str.length() != 0 && (i11 = LoginViewModel.this.i()) != null) {
                i11.p(this.f60402e);
            }
            LoginViewModel loginViewModel = LoginViewModel.this;
            loginViewModel.l(loginThirdUserInfo, loginViewModel.f60395a);
            if (loginThirdUserInfo == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", this.f60403f);
            hashMap.put("sign_up", loginThirdUserInfo.getReg() ? "1" : "0");
            hj.i.f64628a.s("sign_up_dialog", "login", hashMap);
            if (loginThirdUserInfo.getReg()) {
                com.transsnet.login.b.f60406a.b(R$string.login_sign_up_success);
            } else {
                com.transsnet.login.b.f60406a.b(R$string.login_success);
            }
        }
    }

    public LoginViewModel() {
        b0 b0Var = new b0();
        this.f60395a = b0Var;
        this.f60396b = LazyKt.b(new Function0() { // from class: com.transsnet.login.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                az.a m11;
                m11 = LoginViewModel.m();
                return m11;
            }
        });
        this.f60397c = b0Var;
        this.f60398d = LazyKt.b(new Function0() { // from class: com.transsnet.login.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IPremiumApi n11;
                n11 = LoginViewModel.n();
                return n11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final az.a h() {
        return (az.a) this.f60396b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPremiumApi i() {
        return (IPremiumApi) this.f60398d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(UserInfo userInfo, b0 b0Var) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new LoginViewModel$handleLoginSuccess$1(userInfo, b0Var, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final az.a m() {
        return (az.a) zg.c.f79537e.a().h(az.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPremiumApi n() {
        return (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
    }

    private final void o(JsonObject jsonObject, String str, String str2) {
        io.reactivex.rxjava3.core.j.t(jsonObject).u(a.f60399a).n(new b()).f(sg.d.f75472a.c()).subscribe(new c(str2, str));
    }

    public final LiveData j() {
        return this.f60397c;
    }

    public final void k(String idToken, String str) {
        Intrinsics.h(idToken, "idToken");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(ChannelReader.CHANNEL_KEY, "GOOGLE");
        jsonObject.addProperty("idToken", idToken);
        o(jsonObject, "GOOGLE", str);
    }
}
