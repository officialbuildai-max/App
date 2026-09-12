package com.transsnet.login.phone;

import android.app.Application;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import androidx.view.LiveData;
import az.a;
import com.cloud.tmc.miniutils.constant.PermissionConstants;
import com.google.gson.JsonObject;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.loginapi.bean.Country;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes7.dex */
public final class LoginPhoneViewModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final androidx.view.b0 f60541b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f60542c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.view.b0 f60543d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.view.b0 f60544e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.view.b0 f60545f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.view.b0 f60546g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.view.b0 f60547h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.view.b0 f60548i;

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f60549j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.view.b0 f60550k;

    /* renamed from: l, reason: collision with root package name */
    private final HashMap f60551l;

    /* loaded from: classes7.dex */
    static final class a implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginSmsCodeRequest f60552a;

        a(LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f60552a = loginSmsCodeRequest;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(LoginSmsCodeRequest it) {
            Intrinsics.h(it, "it");
            JsonObject jsonObject = new JsonObject();
            if (this.f60552a.getAuthType() == 0) {
                jsonObject.addProperty("phone", it.getPhone());
                jsonObject.addProperty("cc", it.getCc());
            } else {
                jsonObject.addProperty("mail", it.getMail());
            }
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            return companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginSmsCodeRequest f60553a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoginPhoneViewModel f60554b;

        b(LoginSmsCodeRequest loginSmsCodeRequest, LoginPhoneViewModel loginPhoneViewModel) {
            this.f60553a = loginSmsCodeRequest;
            this.f60554b = loginPhoneViewModel;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(RequestBody it) {
            Intrinsics.h(it, "it");
            return this.f60553a.getAuthType() == 0 ? this.f60554b.z().k(vg.a.f77447a.a(), it) : a.C0148a.a(this.f60554b.z(), it, null, 2, null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f60556e;

        c(String str) {
            this.f60556e = str;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            if (str2 != null && str != null && Integer.parseInt(str) >= 200000) {
                LoginPhoneViewModel.this.f60551l.put(this.f60556e, str2);
            }
            if (str2 != null) {
                LoginPhoneViewModel.this.f60550k.q(str2);
            }
            LoginPhoneViewModel.this.f60544e.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(LoginCheckPhoneExistResult loginCheckPhoneExistResult) {
            LoginPhoneViewModel.this.f60544e.q(loginCheckPhoneExistResult);
        }
    }

    /* loaded from: classes7.dex */
    static final class d implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        public static final d f60557a = new d();

        d() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(LoginSmsCodeRequest it) {
            Intrinsics.h(it, "it");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("mail", it.getMail());
            jsonObject.addProperty("verificationCode", it.getVerificationCode());
            jsonObject.addProperty("password", it.getPassword());
            jsonObject.addProperty("inviteCode", it.getInviteCode());
            jsonObject.addProperty("authType", (Number) 1);
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            return companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
        }
    }

    /* loaded from: classes7.dex */
    static final class e implements lz.h {
        e() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(RequestBody it) {
            Intrinsics.h(it, "it");
            return LoginPhoneViewModel.this.z().b(vg.a.f77447a.a(), it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f60560e;

        f(String str) {
            this.f60560e = str;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f60546g.q(str2);
            LoginPhoneViewModel.this.f60545f.q(null);
            if (str2 == null || str == null || Integer.parseInt(str) < 200000) {
                return;
            }
            LoginPhoneViewModel.this.f60551l.put(this.f60560e, str2);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            vy.d.f77603a.b().putString("login_last_login_type", "EMAIL");
            LoginPhoneViewModel loginPhoneViewModel = LoginPhoneViewModel.this;
            loginPhoneViewModel.H(userInfo, loginPhoneViewModel.f60545f);
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f60562e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LoginSmsCodeRequest f60563f;

        g(String str, LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f60562e = str;
            this.f60563f = loginSmsCodeRequest;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            if (str2 != null) {
                uh.b.f76876a.e(str2);
            }
            LoginPhoneViewModel.this.f60543d.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            vy.f.f77605a.b().putLong(this.f60562e, SystemClock.elapsedRealtime());
            LoginPhoneViewModel.this.f60543d.q(this.f60563f);
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f60565e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LoginSmsCodeRequest f60566f;

        h(String str, LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f60565e = str;
            this.f60566f = loginSmsCodeRequest;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f60546g.q(str2);
            LoginPhoneViewModel.this.f60545f.q(null);
            if (str2 == null || str == null || Integer.parseInt(str) < 200000) {
                return;
            }
            LoginPhoneViewModel.this.f60551l.put(this.f60565e, str2);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            vy.d.f77603a.b().putString("login_last_login_type", this.f60566f.getAuthType() == 1 ? "EMAIL" : PermissionConstants.PHONE);
            LoginPhoneViewModel loginPhoneViewModel = LoginPhoneViewModel.this;
            loginPhoneViewModel.H(userInfo, loginPhoneViewModel.f60545f);
        }
    }

    /* loaded from: classes7.dex */
    static final class i implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        public static final i f60567a = new i();

        i() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(LoginSmsCodeRequest it) {
            Intrinsics.h(it, "it");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("phone", it.getPhone());
            jsonObject.addProperty("cc", it.getCc());
            jsonObject.addProperty("verificationCode", it.getVerificationCode());
            jsonObject.addProperty("password", it.getPassword());
            jsonObject.addProperty("inviteCode", it.getInviteCode());
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            return companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
        }
    }

    /* loaded from: classes7.dex */
    static final class j implements lz.h {
        j() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(RequestBody it) {
            Intrinsics.h(it, "it");
            return LoginPhoneViewModel.this.z().b(vg.a.f77447a.a(), it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f60570e;

        k(String str) {
            this.f60570e = str;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f60546g.q(str2);
            LoginPhoneViewModel.this.f60545f.q(null);
            if (str2 == null || str == null || str.length() == 0) {
                return;
            }
            Integer v11 = StringsKt.v(str);
            if ((v11 != null ? v11.intValue() : 0) >= 200000) {
                LoginPhoneViewModel.this.f60551l.put(this.f60570e, str2);
            }
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            vy.d.f77603a.b().putString("login_last_login_type", PermissionConstants.PHONE);
            LoginPhoneViewModel loginPhoneViewModel = LoginPhoneViewModel.this;
            loginPhoneViewModel.H(userInfo, loginPhoneViewModel.f60545f);
        }
    }

    /* loaded from: classes7.dex */
    static final class l implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginSmsCodeRequest f60571a;

        l(LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f60571a = loginSmsCodeRequest;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(LoginSmsCodeRequest it) {
            Intrinsics.h(it, "it");
            JsonObject jsonObject = new JsonObject();
            if (this.f60571a.getAuthType() == 1) {
                jsonObject.addProperty("mail", it.getMail());
                jsonObject.addProperty("verificationCode", it.getVerificationCode());
                jsonObject.addProperty("inviteCode", it.getInviteCode());
                jsonObject.addProperty("authType", (Number) 1);
            } else {
                jsonObject.addProperty("phone", it.getPhone());
                jsonObject.addProperty("cc", it.getCc());
                jsonObject.addProperty("verification_code", it.getVerificationCode());
            }
            jsonObject.addProperty("password", it.getPassword());
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            return companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
        }
    }

    /* loaded from: classes7.dex */
    static final class m implements lz.h {
        m() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(RequestBody it) {
            Intrinsics.h(it, "it");
            return LoginPhoneViewModel.this.z().j(vg.a.f77447a.a(), it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class n extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LoginSmsCodeRequest f60574e;

        n(LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f60574e = loginSmsCodeRequest;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f60546g.q(str2);
            LoginPhoneViewModel.this.f60548i.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            vy.d.f77603a.b().putString("login_last_login_type", this.f60574e.getAuthType() == 1 ? "EMAIL" : PermissionConstants.PHONE);
            LoginPhoneViewModel loginPhoneViewModel = LoginPhoneViewModel.this;
            loginPhoneViewModel.H(userInfo, loginPhoneViewModel.f60548i);
        }
    }

    /* loaded from: classes7.dex */
    public static final class o extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f60576e;

        o(String str) {
            this.f60576e = str;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f60546g.q(str2);
            LoginPhoneViewModel.this.f60547h.q(Boolean.FALSE);
            if (str2 == null || str == null || Integer.parseInt(str) < 200000) {
                return;
            }
            LoginPhoneViewModel.this.f60551l.put(this.f60576e, str2);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            LoginPhoneViewModel.this.f60547h.q(Boolean.TRUE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPhoneViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f60541b = new androidx.view.b0();
        this.f60542c = new androidx.view.b0();
        this.f60543d = new androidx.view.b0();
        this.f60544e = new androidx.view.b0();
        this.f60545f = new androidx.view.b0();
        this.f60546g = new androidx.view.b0();
        this.f60547h = new androidx.view.b0();
        this.f60548i = new androidx.view.b0();
        this.f60549j = LazyKt.b(new Function0() { // from class: com.transsnet.login.phone.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                az.a I;
                I = LoginPhoneViewModel.I();
                return I;
            }
        });
        this.f60550k = new androidx.view.b0();
        this.f60551l = new HashMap();
    }

    public static /* synthetic */ void F(LoginPhoneViewModel loginPhoneViewModel, LoginSmsCodeRequest loginSmsCodeRequest, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        loginPhoneViewModel.E(loginSmsCodeRequest, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(UserInfo userInfo, androidx.view.b0 b0Var) {
        kotlinx.coroutines.k.d(androidx.view.u0.a(this), null, null, new LoginPhoneViewModel$handleLoginSuccess$1(userInfo, b0Var, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final az.a I() {
        return (az.a) zg.c.f79537e.a().h(az.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Country x(String str) {
        Object obj = null;
        if (str == null || str.length() < 3) {
            return null;
        }
        String substring = str.substring(0, 3);
        Intrinsics.g(substring, "substring(...)");
        ArrayList a11 = yy.b.b().a(b());
        if (a11 == null || a11.isEmpty()) {
            return null;
        }
        ListIterator listIterator = a11.listIterator(a11.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            if (Intrinsics.c(substring, ((Country) previous).getMcc())) {
                obj = previous;
                break;
            }
        }
        return (Country) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final az.a z() {
        return (az.a) this.f60549j.getValue();
    }

    public final LiveData A() {
        return this.f60546g;
    }

    public final LiveData B() {
        return this.f60545f;
    }

    public final LiveData C() {
        return this.f60542c;
    }

    public final LiveData D() {
        return this.f60548i;
    }

    public final void E(LoginSmsCodeRequest loginSmsCodeRequest, int i11) {
        if (loginSmsCodeRequest == null) {
            this.f60543d.q(null);
            return;
        }
        loginSmsCodeRequest.setType(i11);
        loginSmsCodeRequest.setPackage_name(b().getPackageName());
        String account = loginSmsCodeRequest.account();
        long elapsedRealtime = SystemClock.elapsedRealtime() - vy.f.f77605a.b().getLong(account, 0L);
        if (0 > elapsedRealtime || elapsedRealtime >= 60000) {
            z().d(vg.a.f77447a.a(), loginSmsCodeRequest).f(sg.d.f75472a.c()).subscribe(new g(account, loginSmsCodeRequest));
        } else {
            this.f60543d.q(loginSmsCodeRequest);
        }
    }

    public final LiveData G() {
        return this.f60543d;
    }

    public final void J(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f60545f.q(null);
            return;
        }
        String dataKey = loginSmsCodeRequest.dataKey();
        String str = (String) this.f60551l.get(dataKey);
        if (str == null) {
            z().i(vg.a.f77447a.a(), loginSmsCodeRequest).f(sg.d.f75472a.c()).subscribe(new h(dataKey, loginSmsCodeRequest));
        } else {
            this.f60546g.q(str);
            this.f60545f.q(null);
        }
    }

    public final void K(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f60545f.q(null);
            return;
        }
        String dataKey = loginSmsCodeRequest.dataKey();
        String str = (String) this.f60551l.get(dataKey);
        if (str == null) {
            io.reactivex.rxjava3.core.j.t(loginSmsCodeRequest).u(i.f60567a).n(new j()).f(sg.d.f75472a.c()).subscribe(new k(dataKey));
        } else {
            this.f60546g.q(str);
            this.f60545f.q(null);
        }
    }

    public final void L(LoginSmsCodeRequest loginSmsCodeRequest, boolean z10) {
        if (loginSmsCodeRequest == null) {
            this.f60545f.q(null);
        } else {
            io.reactivex.rxjava3.core.j.t(loginSmsCodeRequest).u(new l(loginSmsCodeRequest)).n(new m()).f(sg.d.f75472a.c()).subscribe(new n(loginSmsCodeRequest));
        }
    }

    public final void M(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f60545f.q(null);
            return;
        }
        String dataKey = loginSmsCodeRequest.dataKey();
        String str = (String) this.f60551l.get(dataKey);
        if (str == null) {
            (loginSmsCodeRequest.getAuthType() == 0 ? z().g(vg.a.f77447a.a(), loginSmsCodeRequest) : a.C0148a.b(z(), loginSmsCodeRequest, null, 2, null)).f(sg.d.f75472a.c()).subscribe(new o(dataKey));
        } else {
            this.f60546g.q(str);
            this.f60547h.q(Boolean.FALSE);
        }
    }

    public final void q(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f60543d.q(null);
            return;
        }
        String dataKey = loginSmsCodeRequest.dataKey();
        String str = (String) this.f60551l.get(dataKey);
        if (str == null) {
            io.reactivex.rxjava3.core.j.t(loginSmsCodeRequest).u(new a(loginSmsCodeRequest)).n(new b(loginSmsCodeRequest, this)).f(sg.d.f75472a.c()).subscribe(new c(dataKey));
        } else {
            this.f60550k.q(str);
            this.f60544e.q(null);
        }
    }

    public final void r(String phoneNum) {
        Intrinsics.h(phoneNum, "phoneNum");
        kotlinx.coroutines.k.d(androidx.view.u0.a(this), kotlinx.coroutines.y0.b(), null, new LoginPhoneViewModel$checkPhoneNum$1(this, phoneNum, null), 2, null);
    }

    public final void s(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f60545f.q(null);
            return;
        }
        String dataKey = loginSmsCodeRequest.dataKey();
        String str = (String) this.f60551l.get(dataKey);
        if (str == null) {
            io.reactivex.rxjava3.core.j.t(loginSmsCodeRequest).u(d.f60557a).n(new e()).f(sg.d.f75472a.c()).subscribe(new f(dataKey));
        } else {
            this.f60546g.q(str);
            this.f60545f.q(null);
        }
    }

    public final LiveData t() {
        return this.f60550k;
    }

    public final LiveData u() {
        return this.f60544e;
    }

    public final LiveData v() {
        return this.f60547h;
    }

    public final void w() {
        Object systemService = b().getSystemService("phone");
        if (!(systemService instanceof TelephonyManager)) {
            this.f60541b.q(null);
        } else {
            kotlinx.coroutines.k.d(androidx.view.u0.a(this), kotlinx.coroutines.y0.b(), null, new LoginPhoneViewModel$getCountry$1(this, ((TelephonyManager) systemService).getSimOperator(), null), 2, null);
        }
    }

    public final LiveData y() {
        return this.f60541b;
    }
}
