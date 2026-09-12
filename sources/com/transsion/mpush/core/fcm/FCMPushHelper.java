package com.transsion.mpush.core.fcm;

import android.app.Application;
import android.os.Build;
import androidx.core.app.t;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.transsion.mpush.core.net.PushNetworkApi;
import com.transsion.mpush.core.utils.PushPreference;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class FCMPushHelper {

    /* renamed from: h, reason: collision with root package name */
    private Application f47547h;

    /* renamed from: i, reason: collision with root package name */
    private t1 f47548i;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f47550k;

    /* renamed from: a, reason: collision with root package name */
    private final String f47540a = "PushRegisterManager";

    /* renamed from: b, reason: collision with root package name */
    private final String f47541b = "topic_appid_";

    /* renamed from: c, reason: collision with root package name */
    private final String f47542c = "topic_zone_";

    /* renamed from: d, reason: collision with root package name */
    private final String f47543d = "topic_country_";

    /* renamed from: e, reason: collision with root package name */
    private final String f47544e = "topic_language_";

    /* renamed from: f, reason: collision with root package name */
    private final String f47545f = "_test";

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f47546g = LazyKt.b(new Function0() { // from class: com.transsion.mpush.core.fcm.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PushNetworkApi u11;
            u11 = FCMPushHelper.u();
            return u11;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final n0 f47549j = o0.a(l2.b(null, 1, null).plus(y0.b()));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Application application, String str, boolean z10) {
        if (z10) {
            PushPreference.f47662a.v(application, str);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Application application, String str, boolean z10) {
        if (z10) {
            PushPreference.f47662a.t(application, str);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        if (this.f47550k) {
            return;
        }
        this.f47550k = true;
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(FCMPushHelper fCMPushHelper, JSONObject jSONObject, String regHash) {
        t1 d11;
        Intrinsics.h(regHash, "regHash");
        t1 t1Var = fCMPushHelper.f47548i;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        d11 = kotlinx.coroutines.k.d(fCMPushHelper.f47549j, null, null, new FCMPushHelper$sendToServer$1$1(fCMPushHelper, jSONObject, regHash, null), 3, null);
        fCMPushHelper.f47548i = d11;
        return Unit.f67184a;
    }

    private final boolean n() {
        try {
            return t.d(Utils.a()).a();
        } catch (Exception unused) {
            return true;
        }
    }

    private final void o(Function1 function1) {
        String g11;
        String id2 = TimeZone.getDefault().getID();
        m mVar = m.f47565a;
        Function0 p11 = mVar.p();
        String str = p11 != null ? (String) p11.invoke() : null;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String a11 = cm.e.a(str + "|" + id2 + "|" + com.blankj.utilcode.util.c.f() + "|" + Locale.getDefault().getCountry() + "|" + Locale.getDefault().getLanguage() + "|" + Build.VERSION.RELEASE + "|" + mVar.o() + "|" + mVar.l());
        Application application = this.f47547h;
        if (application != null && (g11 = PushPreference.f47662a.g(application)) != null) {
            str2 = g11;
        }
        if (Intrinsics.c(a11, str2)) {
            return;
        }
        Intrinsics.e(a11);
        function1.invoke(a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(FCMPushHelper fCMPushHelper, String it) {
        Intrinsics.h(it, "it");
        fCMPushHelper.D();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PushNetworkApi r() {
        return (PushNetworkApi) this.f47546g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestBody s(String str) {
        return RequestBody.INSTANCE.create(str, MediaType.INSTANCE.parse("application/json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PushNetworkApi u() {
        return (PushNetworkApi) zg.c.f79537e.a().h(PushNetworkApi.class);
    }

    private final void x() {
        final Application application = this.f47547h;
        if (application == null) {
            return;
        }
        boolean c11 = Intrinsics.c(CacheIpPool.f40879a.l(), "test-mse-api.aoneroom.com");
        PushPreference pushPreference = PushPreference.f47662a;
        String j11 = pushPreference.j(application);
        String l11 = pushPreference.l(application);
        String k11 = pushPreference.k(application);
        String i11 = pushPreference.i(application);
        final String str = this.f47543d + Locale.getDefault().getCountry() + (c11 ? this.f47545f : "");
        String str2 = this.f47542c;
        String id2 = TimeZone.getDefault().getID();
        Intrinsics.g(id2, "getID(...)");
        final String str3 = str2 + StringsKt.P(id2, '/', '_', false, 4, null) + (c11 ? this.f47545f : "");
        final String str4 = this.f47544e + Locale.getDefault().getLanguage() + (c11 ? this.f47545f : "");
        final String str5 = this.f47541b + Utils.a().getPackageName() + (c11 ? this.f47545f : "");
        if (!Intrinsics.c(j11, str)) {
            if (j11.length() > 0) {
                m.f47565a.x(j11);
            }
            m.f47565a.s(str, new Function1() { // from class: com.transsion.mpush.core.fcm.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit y10;
                    y10 = FCMPushHelper.y(application, str, ((Boolean) obj).booleanValue());
                    return y10;
                }
            });
        }
        if (!Intrinsics.c(l11, str3)) {
            if (l11.length() > 0) {
                m.f47565a.x(l11);
            }
            m.f47565a.s(str3, new Function1() { // from class: com.transsion.mpush.core.fcm.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit z10;
                    z10 = FCMPushHelper.z(application, str3, ((Boolean) obj).booleanValue());
                    return z10;
                }
            });
        }
        if (!Intrinsics.c(k11, str4)) {
            if (k11.length() > 0) {
                m.f47565a.x(k11);
            }
            m.f47565a.s(str4, new Function1() { // from class: com.transsion.mpush.core.fcm.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A;
                    A = FCMPushHelper.A(application, str4, ((Boolean) obj).booleanValue());
                    return A;
                }
            });
        }
        if (Intrinsics.c(i11, str5)) {
            return;
        }
        if (i11.length() > 0) {
            m.f47565a.x(i11);
        }
        m.f47565a.s(str5, new Function1() { // from class: com.transsion.mpush.core.fcm.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit B;
                B = FCMPushHelper.B(application, str5, ((Boolean) obj).booleanValue());
                return B;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Application application, String str, boolean z10) {
        if (z10) {
            PushPreference.f47662a.u(application, str);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Application application, String str, boolean z10) {
        if (z10) {
            PushPreference.f47662a.w(application, str);
        }
        return Unit.f67184a;
    }

    public final void D() {
        m mVar = m.f47565a;
        if (mVar.o().length() == 0 || mVar.l().length() == 0) {
            return;
        }
        boolean n11 = n();
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("firebaseToken", mVar.o());
        jSONObject.put("twibidaClientId", mVar.l());
        jSONObject.put("notifySwitchOff", !n11);
        o(new Function1() { // from class: com.transsion.mpush.core.fcm.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E;
                E = FCMPushHelper.E(FCMPushHelper.this, jSONObject, (String) obj);
                return E;
            }
        });
    }

    public final void p() {
        o(new Function1() { // from class: com.transsion.mpush.core.fcm.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q11;
                q11 = FCMPushHelper.q(FCMPushHelper.this, (String) obj);
                return q11;
            }
        });
    }

    public final void t(Application context) {
        Intrinsics.h(context, "context");
        this.f47547h = context;
    }

    public final void v(String token) {
        Intrinsics.h(token, "token");
        this.f47550k = false;
        x();
        D();
    }

    public final void w(String str, String str2) {
        this.f47550k = false;
        x();
        D();
    }
}
