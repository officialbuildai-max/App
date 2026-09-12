package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f35621a;

    /* renamed from: b, reason: collision with root package name */
    private final String f35622b;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, String> f35623a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final String f35624b;

        public b(String str) {
            this.f35624b = str;
        }

        public l a() {
            return new l(this);
        }
    }

    private l(b bVar) {
        this.f35622b = bVar.f35624b;
        this.f35621a = bVar.f35623a;
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    private void a(Map<String, String> map, JSONObject jSONObject) {
        if (map == null || map.isEmpty() || jSONObject == null) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, a(map.get(str)));
            }
        } catch (Exception e11) {
            o0.b("SameCommonReporter", e11.getMessage());
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(this.f35622b)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", this.f35622b);
            a(this.f35621a, jSONObject);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
        } catch (Throwable th2) {
            o0.b("SameCommonReporter", th2.getMessage());
        }
    }
}
