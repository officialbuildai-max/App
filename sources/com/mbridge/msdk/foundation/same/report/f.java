package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.tools.o0;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static volatile f f35615b;

    /* renamed from: a, reason: collision with root package name */
    private volatile com.mbridge.msdk.tracker.m f35616a;

    public static f a() {
        if (f35615b == null) {
            synchronized (f.class) {
                try {
                    if (f35615b == null) {
                        f35615b = new f();
                    }
                } finally {
                }
            }
        }
        return f35615b;
    }

    public void a(Context context, String str, String str2, String str3, String str4, int i11) {
        com.mbridge.msdk.tracker.m b11 = a().b();
        if (b11 == null) {
            return;
        }
        if (!b11.a("2000105")) {
            o0.a("MetricsReportUtil", "reportClickImpException can not track");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put("url", "");
            } else {
                jSONObject.put("url", URLEncoder.encode(str2, "utf-8"));
            }
            jSONObject.put(NativeComponentConstants.KEY_COMPONENT_TYPE, i11);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("rid", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("rid_n", str4);
            }
            try {
                long[] e11 = b11.e();
                jSONObject.put("track_time", e11[0]);
                jSONObject.put("track_count", e11[1]);
                jSONObject.put("session_id", b11.d());
            } catch (Exception unused) {
            }
            jSONObject.put("reason", URLEncoder.encode(str, "utf-8"));
            com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e("2000105");
            eVar.a(jSONObject);
            eVar.a(0);
            eVar.b(0);
            eVar.a(c.d());
            b11.d(eVar);
        } catch (Exception e12) {
            o0.b("MetricsReportUtil", e12.getMessage());
        }
    }

    public com.mbridge.msdk.tracker.m b() {
        if (this.f35616a == null) {
            this.f35616a = com.mbridge.msdk.foundation.same.report.metrics.d.b().d();
        }
        return this.f35616a;
    }

    public void c() {
        b().a();
    }
}
