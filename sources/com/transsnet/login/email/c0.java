package com.transsnet.login.email;

import android.os.SystemClock;
import androidx.view.LiveData;
import androidx.view.t0;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsnet.login.email.a;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class c0 extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f60455a = LazyKt.b(new Function0() { // from class: com.transsnet.login.email.b0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a l11;
            l11 = c0.l();
            return l11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final androidx.view.b0 f60456b = new androidx.view.b0();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f60457c = new androidx.view.b0();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.view.b0 f60458d = new androidx.view.b0();

    /* loaded from: classes7.dex */
    static final class a implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f60459a;

        a(String str) {
            this.f60459a = str;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(String it) {
            Intrinsics.h(it, "it");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mail", this.f60459a);
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.g(jSONObject2, "toString(...)");
            return companion.create(jSONObject2, MediaType.INSTANCE.parse("application/json"));
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements lz.h {
        b() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(RequestBody it) {
            Intrinsics.h(it, "it");
            return a.C0719a.a(c0.this.k(), it, null, 2, null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends sg.a {
        c() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            if (str2 != null) {
                uh.b.f76876a.e(str2);
            }
            c0.this.f60456b.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(LoginCheckPhoneExistResult loginCheckPhoneExistResult) {
            super.c(loginCheckPhoneExistResult);
            c0.this.f60456b.q(loginCheckPhoneExistResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f60462a;

        d(JSONObject jSONObject) {
            this.f60462a = jSONObject;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(JSONObject it) {
            Intrinsics.h(it, "it");
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String jSONObject = this.f60462a.toString();
            Intrinsics.g(jSONObject, "toString(...)");
            return companion.create(jSONObject, MediaType.INSTANCE.parse("application/json"));
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
            return a.C0719a.b(c0.this.k(), it, null, 2, null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f60465e;

        f(String str) {
            this.f60465e = str;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            if (str2 != null) {
                uh.b.f76876a.e(str2);
            }
            c0.this.f60457c.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            vy.f.f77605a.b().putLong(this.f60465e, SystemClock.elapsedRealtime());
            c0.this.f60457c.q(this.f60465e);
        }
    }

    public static /* synthetic */ void i(c0 c0Var, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        c0Var.h(str, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.login.email.a k() {
        return (com.transsnet.login.email.a) this.f60455a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.login.email.a l() {
        return (com.transsnet.login.email.a) zg.c.f79537e.a().h(com.transsnet.login.email.a.class);
    }

    public final void f(String email) {
        Intrinsics.h(email, "email");
        io.reactivex.rxjava3.core.j.t(email).u(new a(email)).n(new b()).f(sg.d.f75472a.c()).subscribe(new c());
    }

    public final LiveData g() {
        return this.f60456b;
    }

    public final void h(String email, int i11) {
        Intrinsics.h(email, "email");
        long elapsedRealtime = SystemClock.elapsedRealtime() - vy.f.f77605a.b().getLong(email, 0L);
        if (0 <= elapsedRealtime && elapsedRealtime < 60000) {
            this.f60457c.q(email);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mail", email);
        jSONObject.put(NativeComponentConstants.KEY_COMPONENT_TYPE, i11);
        jSONObject.put("authType", 1);
        io.reactivex.rxjava3.core.j.t(jSONObject).u(new d(jSONObject)).n(new e()).f(sg.d.f75472a.c()).subscribe(new f(email));
    }

    public final LiveData j() {
        return this.f60457c;
    }
}
