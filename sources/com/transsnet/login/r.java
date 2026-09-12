package com.transsnet.login;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import az.a;
import bh.a;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.JsonObject;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.tn.lib.net.bean.BaseDto;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.Country;
import com.transsnet.loginapi.bean.UserInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.mvel2.ast.ASTNode;
import uh.b;

/* loaded from: classes.dex */
public final class r implements ILoginApi {

    /* renamed from: g, reason: collision with root package name */
    public static final a f60676g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f60677h = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.login.o
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi H;
            H = r.H();
            return H;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private Context f60678a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f60679b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private volatile UserInfo f60680c = I("create");

    /* renamed from: d, reason: collision with root package name */
    private final List f60681d = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f60682e = LazyKt.b(new Function0() { // from class: com.transsnet.login.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            az.a F;
            F = r.F();
            return F;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final String f60683f;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ILoginApi a() {
            return (ILoginApi) r.f60677h.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements lz.h {
        b() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BaseDto apply(BaseDto response) {
            String userId;
            Intrinsics.h(response, "response");
            UserInfo D = r.this.D("fetchUserInfo");
            UserInfo userInfo = (UserInfo) response.getData();
            if (userInfo != null) {
                userInfo.setToken(D != null ? D.getToken() : null);
                if (D != null && ((userId = userInfo.getUserId()) == null || userId.length() == 0 || Intrinsics.c(userInfo.getUserId(), D.getUserId()))) {
                    String userId2 = userInfo.getUserId();
                    if (userId2 == null) {
                        userId2 = D.getUserId();
                    }
                    userInfo.setUserId(userId2);
                    userInfo.setUserType(D.getUserType());
                }
            }
            return response;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f60685d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ r f60686e;

        c(String str, r rVar) {
            this.f60685d = str;
            this.f60686e = rVar;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            lg.a.f68962a.i("LoginProvider", "fetchUserInfo failed code=" + str + ", message=" + str2 + ", requestUserId=" + this.f60685d + ", instance=" + this.f60686e.G(), true);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            if (userInfo != null) {
                this.f60686e.T(userInfo);
                return;
            }
            lg.a.f68962a.x("LoginProvider", "fetchUserInfo returned null, keep current user, requestUserId=" + this.f60685d + ", instance=" + this.f60686e.G(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        public static final d f60687a = new d();

        d() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(String it) {
            Intrinsics.h(it, "it");
            JsonObject jsonObject = new JsonObject();
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            return companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class e implements lz.h {
        e() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(RequestBody it) {
            Intrinsics.h(it, "it");
            return r.this.E().h(vg.a.f77447a.a(), it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends sg.a {
        f() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            r.this.M("logout_request_failed code=" + str);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            r.this.M("logout_request_success");
            if (userInfo != null) {
                r.this.O(userInfo);
            }
        }
    }

    public r() {
        S(this.f60680c);
        K(this, "created", null, 2, null);
        this.f60683f = "X-User";
    }

    private final WeakReference C(dz.a aVar) {
        for (WeakReference weakReference : this.f60681d) {
            dz.a aVar2 = (dz.a) weakReference.get();
            if (aVar2 != null && aVar2 == aVar) {
                return weakReference;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserInfo D(String str) {
        UserInfo userInfo;
        UserInfo userInfo2 = this.f60680c;
        if (userInfo2 != null) {
            return userInfo2;
        }
        synchronized (this.f60679b) {
            userInfo = this.f60680c;
            if (userInfo == null) {
                userInfo = I(str);
                if (userInfo != null) {
                    this.f60680c = userInfo;
                    S(userInfo);
                    lg.a.f68962a.x("LoginProvider", "restore memory from MMKV source=" + str + ", instance=" + G() + ", user=" + V(userInfo) + ", thread=" + Thread.currentThread().getName(), true);
                } else {
                    userInfo = null;
                }
            }
        }
        return userInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final az.a E() {
        return (az.a) this.f60682e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final az.a F() {
        return (az.a) zg.c.f79537e.a().h(az.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int G() {
        return System.identityHashCode(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi H() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.transsnet.loginapi.bean.UserInfo I(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r1 = 0
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2d
            vy.d r2 = vy.d.f77603a     // Catch: java.lang.Throwable -> L2d
            com.tencent.mmkv.MMKV r2 = r2.b()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r3 = "login_user"
            java.lang.String r2 = r2.getString(r3, r0)     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L14
            goto L15
        L14:
            r0 = r2
        L15:
            boolean r2 = kotlin.text.StringsKt.q0(r0)     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L2f
            java.lang.String r2 = "null"
            boolean r2 = kotlin.jvm.internal.Intrinsics.c(r0, r2)     // Catch: java.lang.Throwable -> L2d
            if (r2 == 0) goto L24
            goto L2f
        L24:
            java.lang.Class<com.transsnet.loginapi.bean.UserInfo> r2 = com.transsnet.loginapi.bean.UserInfo.class
            java.lang.Object r0 = com.blankj.utilcode.util.o.d(r0, r2)     // Catch: java.lang.Throwable -> L2d
            com.transsnet.loginapi.bean.UserInfo r0 = (com.transsnet.loginapi.bean.UserInfo) r0     // Catch: java.lang.Throwable -> L2d
            goto L30
        L2d:
            r0 = move-exception
            goto L35
        L2f:
            r0 = r1
        L30:
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L2d
            goto L3f
        L35:
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        L3f:
            java.lang.Throwable r2 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r2 == 0) goto L7a
            lg.a$a r3 = lg.a.f68962a
            int r4 = r8.G()
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.String r5 = r5.getName()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "loadUserInfo failed source="
            r6.append(r7)
            r6.append(r9)
            java.lang.String r9 = ", instance="
            r6.append(r9)
            r6.append(r4)
            java.lang.String r9 = ", thread="
            r6.append(r9)
            r6.append(r5)
            java.lang.String r9 = r6.toString()
            r4 = 1
            java.lang.String r5 = "LoginProvider"
            r3.h(r5, r9, r2, r4)
        L7a:
            boolean r9 = kotlin.Result.m1191isFailureimpl(r0)
            if (r9 == 0) goto L81
            goto L82
        L81:
            r1 = r0
        L82:
            com.transsnet.loginapi.bean.UserInfo r1 = (com.transsnet.loginapi.bean.UserInfo) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.login.r.I(java.lang.String):com.transsnet.loginapi.bean.UserInfo");
    }

    private final void J(String str, UserInfo userInfo) {
        lg.a.f68962a.c("LoginProvider", str + " instance=" + G() + ", user=" + V(userInfo) + ", thread=" + Thread.currentThread().getName(), true);
    }

    static /* synthetic */ void K(r rVar, String str, UserInfo userInfo, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            userInfo = rVar.f60680c;
        }
        rVar.J(str, userInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(String str) {
        UserInfo userInfo = this.f60680c;
        synchronized (this.f60679b) {
            vy.d.f77603a.b().putString("login_user", "");
            this.f60680c = null;
            S(null);
            Unit unit = Unit.f67184a;
        }
        lg.a.f68962a.x("LoginProvider", "resetData reason=" + str + ", instance=" + G() + ", previous=" + V(userInfo) + ", thread=" + Thread.currentThread().getName(), true);
        ThreadUtils.k(new Runnable() { // from class: com.transsnet.login.p
            @Override // java.lang.Runnable
            public final void run() {
                r.N(r.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(r rVar) {
        Iterator it = rVar.f60681d.iterator();
        while (it.hasNext()) {
            dz.a aVar = (dz.a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.onLogout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(final UserInfo userInfo) {
        c(userInfo);
        ThreadUtils.k(new Runnable() { // from class: com.transsnet.login.n
            @Override // java.lang.Runnable
            public final void run() {
                r.P(r.this, userInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(r rVar, UserInfo userInfo) {
        Iterator it = rVar.f60681d.iterator();
        while (it.hasNext()) {
            dz.a aVar = (dz.a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.onLogin(userInfo);
            }
        }
    }

    private final void Q() {
        b.a aVar = uh.b.f76876a;
        int i11 = com.transsion.baseui.R$layout.base_layout_new_warn_toast;
        String string = Utils.a().getString(R$string.login_signed_out_toast);
        Intrinsics.g(string, "getString(...)");
        aVar.g(i11, string, (r13 & 4) != 0 ? 0 : 17, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
        com.transsion.baselib.helper.a.f43316a.c("toast", "signed_out");
    }

    private final void S(UserInfo userInfo) {
        a.C0156a c0156a = bh.a.f16551a;
        String userId = userInfo != null ? userInfo.getUserId() : null;
        if (userId == null) {
            userId = "";
        }
        c0156a.h(userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(final UserInfo userInfo) {
        c(userInfo);
        ThreadUtils.k(new Runnable() { // from class: com.transsnet.login.q
            @Override // java.lang.Runnable
            public final void run() {
                r.U(r.this, userInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(r rVar, UserInfo userInfo) {
        Iterator it = rVar.f60681d.iterator();
        while (it.hasNext()) {
            dz.a aVar = (dz.a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.onUpdateUserInfo(userInfo);
            }
        }
    }

    private final String V(UserInfo userInfo) {
        if (userInfo == null) {
            return "null";
        }
        String userId = userInfo.getUserId();
        int userType = userInfo.getUserType();
        String token = userInfo.getToken();
        boolean z10 = token == null || token.length() == 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append(userId);
        sb2.append(", type=");
        sb2.append(userType);
        sb2.append(", hasToken=");
        sb2.append(!z10);
        return sb2.toString();
    }

    public final void L() {
        io.reactivex.rxjava3.core.j.t("").u(d.f60687a).n(new e()).f(sg.d.f75472a.c()).subscribe(new f());
    }

    public void R() {
        M("token_expired");
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public boolean a() {
        UserInfo D = D("isLogin");
        return D != null && D.getUserType() == 1;
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public String b() {
        String string = Utils.a().getString(R$string.login_success);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void c(UserInfo userInfo) {
        synchronized (this.f60679b) {
            try {
                this.f60680c = userInfo;
                S(userInfo);
                MMKV b11 = vy.d.f77603a.b();
                String j11 = userInfo != null ? com.blankj.utilcode.util.o.j(userInfo) : null;
                if (j11 == null) {
                    j11 = "";
                }
                b11.putString("login_user", j11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        J("saveUserInfo", userInfo);
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void d() {
        if (nh.m.f70597a.e()) {
            L();
        } else {
            M("logout_without_network");
        }
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public Country e() {
        return yy.a.f79217a.b();
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void f(String str) {
        if (str == null) {
            str = "";
        }
        K(this, "fetchUserInfo start requestUserId=" + str, null, 2, null);
        a.C0148a.c(E(), str, null, 2, null).v(qz.a.c()).u(new b()).f(sg.d.f75472a.c()).subscribe(new c(str, this));
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void g(dz.a listener) {
        Intrinsics.h(listener, "listener");
        if (C(listener) == null) {
            this.f60681d.add(new WeakReference(listener));
        }
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void h(Response response) {
        Intrinsics.h(response, "response");
        try {
            if (response.code() == 200) {
                String str = response.headers().get(this.f60683f);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                UserInfo userInfo = (UserInfo) com.blankj.utilcode.util.o.d(str, UserInfo.class);
                if (this.f60680c == null) {
                    Intrinsics.e(userInfo);
                    O(userInfo);
                    return;
                }
                UserInfo userInfo2 = this.f60680c;
                if (TextUtils.equals(userInfo2 != null ? userInfo2.getToken() : null, userInfo.getToken())) {
                    return;
                }
                UserInfo userInfo3 = this.f60680c;
                if (userInfo3 != null) {
                    userInfo3.setToken(userInfo.getToken());
                }
                c(this.f60680c);
                return;
            }
            if (response.code() == 401) {
                lg.a.f68962a.x("LoginProvider", "HTTP 401 force logout, instance=" + G() + ", request=" + response.request().method() + " " + response.request().url().host() + response.request().url().encodedPath() + ", user=" + V(this.f60680c) + ", thread=" + Thread.currentThread().getName(), true);
                R();
                Q();
            }
        } catch (Exception e11) {
            lg.a.f68962a.h("LoginProvider", "checkTokenExpired failed code=" + response.code() + ", instance=" + G(), e11, true);
        }
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public UserInfo i() {
        return D("getUserInfo");
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void j(Context context) {
        Intrinsics.h(context, "context");
        Intent intent = new Intent(context, (Class<?>) LoginLikeActivity.class);
        intent.setFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void k(Context context) {
        Intrinsics.h(context, "context");
        this.f60678a = context.getApplicationContext();
        UserInfo D = D("initialize");
        S(D);
        J("initialized", D);
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public Object l(UserInfo userInfo, Continuation continuation) {
        O(userInfo);
        f(userInfo.getUserId());
        return Unit.f67184a;
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void m(long j11) {
        vy.d.f77603a.b().putLong("login_launch_first_state", j11);
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public long n() {
        return vy.d.f77603a.b().getLong("login_launch_first_state", 0L);
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public Intent o(Context context) {
        Intrinsics.h(context, "context");
        return new Intent(context, (Class<?>) LoginLikeActivity.class);
    }

    @Override // com.transsnet.loginapi.ILoginApi
    public void p(dz.a listener) {
        Intrinsics.h(listener, "listener");
        List list = this.f60681d;
        TypeIntrinsics.a(list).remove(C(listener));
    }
}
