package hj;

import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.transsion.base.report.athena.BrowseType;
import com.transsion.base.report.athena.ClickType;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.PushConstants;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    private static j f64630c;

    /* renamed from: a, reason: collision with root package name */
    public static final i f64628a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static String f64629b = "";

    /* renamed from: d, reason: collision with root package name */
    private static final ExecutorService f64631d = Executors.newSingleThreadExecutor();

    /* loaded from: classes6.dex */
    public static final class a implements GslbSdk.InitListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f64632a;

        a(String str) {
            this.f64632a = str;
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map map) {
            Intrinsics.h(map, "map");
            a.C0856a.f(lg.a.f68962a, "Report", "gslbSdk success did 11 " + this.f64632a + " map " + map, false, 4, null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements GslbSdk.InitListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f64633a;

        b(String str) {
            this.f64633a = str;
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map map) {
            Intrinsics.h(map, "map");
            a.C0856a.f(lg.a.f68962a, "Report", "gslbSdk success did 22 " + this.f64633a + " map " + map, false, 4, null);
        }
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Map map, String str, String str2) {
        Bundle bundle = new Bundle();
        i iVar = f64628a;
        bundle.putString("ext", iVar.o(map));
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("page_name", str);
        }
        if (J(iVar, str2, bundle, null, null, 12, null)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                a.C0856a.f(lg.a.f68962a, "Report_ad", "reportEventV2() --> event = " + str2 + " --> bundle = " + bundle, false, 4, null);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(String str, Map map, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("page_name", str);
        i iVar = f64628a;
        bundle.putString("ext", iVar.o(map));
        if (J(iVar, str2, bundle, null, null, 12, null)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                a.C0856a.f(lg.a.f68962a, "Report", "reportUIEvent() --> event=" + str2 + "  pageName=" + str + " map=" + map, false, 4, null);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        f64628a.g(str, str2, map);
    }

    private final boolean I(String str, Bundle bundle, Integer num, String str2) {
        Pair account;
        com.transsion.base.report.athena.sampler.c cVar = com.transsion.base.report.athena.sampler.c.f43064a;
        String G = AthenaAnalytics.G(Utils.a());
        Intrinsics.g(G, "getAppVAID(...)");
        if (cVar.b(str, bundle, G)) {
            return false;
        }
        try {
            bundle.putString(PushConstants.PROVIDER_VAID, AthenaAnalytics.G(Utils.a()));
            j jVar = f64630c;
            Bundle a11 = jVar != null ? jVar.a(str, bundle) : null;
            j jVar2 = f64630c;
            if (jVar2 != null && (account = jVar2.getAccount()) != null) {
                AthenaAnalytics.Z(((Number) account.getFirst()).shortValue(), (String) account.getSecond());
            }
            if (num != null) {
                if (!TextUtils.isEmpty(str2)) {
                    if (a11 == null) {
                        a11 = new Bundle();
                    }
                    a11.putString("biz_line", str2);
                }
                new yi.a(str, num.intValue()).c(a11, null).b();
            } else {
                new yi.a(str).c(a11, null).b();
            }
            return true;
        } catch (Exception e11) {
            lg.a.f68962a.i("report", "event " + str + " exception " + e11, true);
            return false;
        }
    }

    static /* synthetic */ boolean J(i iVar, String str, Bundle bundle, Integer num, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            num = null;
        }
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        return iVar.I(str, bundle, num, str2);
    }

    private final void g(String str, String str2, Map map) {
        j jVar = f64630c;
        if (jVar != null) {
            jVar.b(str, str2, map);
        }
    }

    private final String[] j() {
        return new String[]{"dsu-a.shalltry.com"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(int i11, String str) {
        a.C0856a.f(lg.a.f68962a, "Report", "loginActive:userType" + i11 + ",userid:" + str, false, 4, null);
        HashMap hashMap = new HashMap();
        hashMap.put("userType", String.valueOf(i11));
        if (str == null) {
            str = "0";
        }
        hashMap.put("userId", str);
        i iVar = f64628a;
        String o11 = iVar.o(hashMap);
        Bundle bundle = new Bundle();
        bundle.putString(NotificationCompat.CATEGORY_EVENT, "login_active");
        bundle.putString("ext", o11);
        J(iVar, "login_active", bundle, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Map map, String str) {
        try {
            Result.Companion companion = Result.INSTANCE;
            a.C0856a.f(lg.a.f68962a, "Report", "reportEvent event=" + str + " map=" + map + ' ', false, 4, null);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Bundle bundle = new Bundle();
        i iVar = f64628a;
        bundle.putString("ext", iVar.o(map));
        J(iVar, str, bundle, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Map map, String str, String str2, int i11, String str3) {
        Bundle bundle = new Bundle();
        String jSONObject = new JSONObject(map).toString();
        Intrinsics.g(jSONObject, "toString(...)");
        bundle.putString("ext", jSONObject);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("page_name", str);
        }
        if (f64628a.I(str2, bundle, Integer.valueOf(i11), str3)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                a.C0856a.f(lg.a.f68962a, "Report_ad", "reportEventAd() --> appId = " + i11 + " -- bizLine = " + str3 + " -- event = " + str2 + " -- pageName = " + str + " -- bundle = " + bundle, false, 4, null);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(String str, Map map, int i11) {
        a.C0856a.f(lg.a.f68962a, "Report", "reportEventByAppId event=" + str + " map=" + map + ' ', false, 4, null);
        Bundle bundle = new Bundle();
        i iVar = f64628a;
        bundle.putString("ext", iVar.o(map));
        iVar.h(str, bundle, i11);
    }

    public final void B(hj.b logConfig) {
        Intrinsics.h(logConfig, "logConfig");
        HashMap g11 = logConfig.g();
        String a11 = logConfig.a();
        if (a11 == null) {
            a11 = f64629b;
        }
        g11.put(WebConstants.PAGE_FROM, a11);
        logConfig.g().put("duration", String.valueOf(SystemClock.elapsedRealtime() - logConfig.h()));
        logConfig.g().put("is_load_success", String.valueOf(logConfig.i()));
        String e11 = logConfig.e();
        if (e11 != null) {
            logConfig.g().put("ops", e11);
        }
        F(logConfig.f(), "pt", logConfig.g());
        if (TextUtils.equals(f64629b, logConfig.f()) || !logConfig.b()) {
            return;
        }
        f64629b = logConfig.f();
    }

    public final void C(hj.b logConfig) {
        Intrinsics.h(logConfig, "logConfig");
        HashMap g11 = logConfig.g();
        String a11 = logConfig.a();
        if (a11 == null) {
            a11 = f64629b;
        }
        g11.put(WebConstants.PAGE_FROM, a11);
        String e11 = logConfig.e();
        if (e11 != null) {
            logConfig.g().put("ops", e11);
        }
        F(logConfig.f(), "pv", logConfig.g());
    }

    public final void D(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        F(pageName, BrowseType.DEFAULT.getType(), map);
    }

    public final void E(String pageName, Map map, BrowseType browseType) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        Intrinsics.h(browseType, "browseType");
        F(pageName, browseType.getType(), map);
    }

    public final void F(final String pageName, final String event, final Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
        try {
            map = MapsKt.u(map);
        } catch (Exception unused) {
        }
        f64631d.execute(new Runnable() { // from class: hj.f
            @Override // java.lang.Runnable
            public final void run() {
                i.G(pageName, map, event);
            }
        });
    }

    public final void H(String pageName, String event, long j11, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
        map.put("duration", String.valueOf(j11));
        F(pageName, event, map);
    }

    public final boolean h(String event, Bundle bundle, int i11) {
        Intrinsics.h(event, "event");
        Intrinsics.h(bundle, "bundle");
        return J(this, event, bundle, Integer.valueOf(i11), null, 8, null);
    }

    public final String i() {
        return f64629b;
    }

    public final void k(Application context, boolean z10, j api, String channelId, int i11, boolean z11, String str, boolean z12) {
        String str2;
        String str3;
        Intrinsics.h(context, "context");
        Intrinsics.h(api, "api");
        Intrinsics.h(channelId, "channelId");
        String h11 = ih.b.f65364a.h();
        if ((str != null ? str.length() : 0) >= 3) {
            if (str != null) {
                str3 = str.substring(0, 3);
                Intrinsics.g(str3, "substring(...)");
            } else {
                str3 = null;
            }
            str2 = String.valueOf(str3);
        } else {
            str2 = "";
        }
        if (z12) {
            GslbSdk.init(context, "404", h11, j(), new a(h11));
        } else if (TextUtils.equals("250", str2)) {
            GslbSdk.init(context, "621", h11, j(), new b(h11));
        }
        AthenaAnalytics.e0(1);
        AthenaAnalytics.Q(context, channelId, i11, true, z11);
        AthenaAnalytics.d0(z10);
        AthenaAnalytics.D(true);
        AthenaAnalytics.c0(2000);
        AthenaAnalytics.f0();
        f64630c = api;
        a.C0856a.f(lg.a.f68962a, "Report", "initSDK debug " + z10, false, 4, null);
    }

    public final void m(final int i11, final String str) {
        f64631d.execute(new Runnable() { // from class: hj.h
            @Override // java.lang.Runnable
            public final void run() {
                i.n(i11, str);
            }
        });
    }

    public final String o(Map map) {
        Intrinsics.h(map, "map");
        String jSONObject = new JSONObject(map).toString();
        Intrinsics.g(jSONObject, "toString(...)");
        return jSONObject;
    }

    public final void p(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        F(pageName, ClickType.DEFAULT.getType(), map);
    }

    public final void q(String pageName, Map map, ClickType clickType) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        Intrinsics.h(clickType, "clickType");
        F(pageName, clickType.getType(), map);
    }

    public final void r(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        F(pageName, "dialog_show", map);
    }

    public final void s(String pageName, String event, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
        F(pageName, event, map);
    }

    public final void t(final String event, final Map map) {
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
        try {
            map = MapsKt.u(map);
        } catch (Exception unused) {
        }
        f64631d.execute(new Runnable() { // from class: hj.e
            @Override // java.lang.Runnable
            public final void run() {
                i.u(map, event);
            }
        });
    }

    public final void v(final String event, Map map, final String pageName, final int i11, final String bizLine) {
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(bizLine, "bizLine");
        try {
            map = MapsKt.u(map);
        } catch (Exception unused) {
        }
        final Map map2 = map;
        f64631d.execute(new Runnable() { // from class: hj.d
            @Override // java.lang.Runnable
            public final void run() {
                i.w(map2, pageName, event, i11, bizLine);
            }
        });
    }

    public final void x(final String event, final Map map, final int i11) {
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
        f64631d.execute(new Runnable() { // from class: hj.c
            @Override // java.lang.Runnable
            public final void run() {
                i.y(event, map, i11);
            }
        });
    }

    public final void z(final String event, final Map map, final String pageName) {
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
        Intrinsics.h(pageName, "pageName");
        try {
            map = MapsKt.u(map);
        } catch (Exception unused) {
        }
        f64631d.execute(new Runnable() { // from class: hj.g
            @Override // java.lang.Runnable
            public final void run() {
                i.A(map, pageName, event);
            }
        });
    }
}
