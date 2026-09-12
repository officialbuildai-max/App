package com.tn.tranpay.report;

import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tn.tranpay.TranPay;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.push.PushConstants;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f41734a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static String f41735b = "";

    /* renamed from: c, reason: collision with root package name */
    private static int f41736c = 3560;

    /* renamed from: d, reason: collision with root package name */
    private static f f41737d;

    private e() {
    }

    private final void b(String str, String str2, Map map) {
        f fVar = f41737d;
        if (fVar != null) {
            fVar.b(str, str2, map);
        }
    }

    private final String d(Map map) {
        String jSONObject = new JSONObject(map).toString();
        Intrinsics.g(jSONObject, "JSONObject(map).toString()");
        return jSONObject;
    }

    private final void h(final String str, final String str2, final String str3, final Map map) {
        ThreadSingleExecutor.f41713b.a().b(new Runnable() { // from class: com.tn.tranpay.report.d
            @Override // java.lang.Runnable
            public final void run() {
                e.i(str, str3, str2, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String category, String event, String pageName, Map map) {
        Intrinsics.h(category, "$category");
        Intrinsics.h(event, "$event");
        Intrinsics.h(pageName, "$pageName");
        Intrinsics.h(map, "$map");
        ai.a.f694a.b(category + " event=" + event + "  pageName=" + pageName + " map=" + map, "Report");
        Bundle bundle = new Bundle();
        bundle.putString("page_name", pageName);
        e eVar = f41734a;
        bundle.putString("ext", eVar.d(map));
        eVar.j(event, bundle);
        eVar.b(pageName, event, map);
    }

    private final void j(String str, Bundle bundle) {
        Bundle a11;
        try {
            bundle.putString(PushConstants.PROVIDER_VAID, AthenaAnalytics.G(TranPay.f41540a.d()));
            f fVar = f41737d;
            if (fVar != null && (a11 = fVar.a(str, bundle)) != null) {
                bundle = a11;
            }
            new yi.a(str, f41736c).c(bundle, null).b();
        } catch (Exception e11) {
            ai.a.f694a.d("event " + str + " exception " + e11, "Report");
        }
    }

    public final void c(Application context, String channel, boolean z10, boolean z11, f fVar) {
        Intrinsics.h(context, "context");
        Intrinsics.h(channel, "channel");
        AthenaAnalytics.Q(context, channel, f41736c, true, z11);
        AthenaAnalytics.d0(z10);
        f41737d = fVar;
        ai.a.f694a.f("init athena debug " + z10, "Report");
    }

    public final void e(String pageName, String event, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(event, "event");
        Intrinsics.h(map, "map");
        h("reportClick", pageName, event, map);
    }

    public final void f(c logConfig) {
        Intrinsics.h(logConfig, "logConfig");
        HashMap g11 = logConfig.g();
        String a11 = logConfig.a();
        if (a11 == null) {
            a11 = f41735b;
        }
        g11.put(WebConstants.PAGE_FROM, a11);
        logConfig.g().put("duration", String.valueOf(SystemClock.elapsedRealtime() - logConfig.h()));
        logConfig.g().put("is_load_success", String.valueOf(logConfig.i()));
        String e11 = logConfig.e();
        if (e11 != null) {
            logConfig.g().put("ops", e11);
        }
        h("reportPT", logConfig.f(), "pt", logConfig.g());
        if (TextUtils.equals(f41735b, logConfig.f()) || !logConfig.b()) {
            return;
        }
        f41735b = logConfig.f();
    }

    public final void g(c logConfig) {
        Intrinsics.h(logConfig, "logConfig");
        HashMap g11 = logConfig.g();
        String a11 = logConfig.a();
        if (a11 == null) {
            a11 = f41735b;
        }
        g11.put(WebConstants.PAGE_FROM, a11);
        String e11 = logConfig.e();
        if (e11 != null) {
            logConfig.g().put("ops", e11);
        }
        h("reportPV", logConfig.f(), "pv", logConfig.g());
    }
}
