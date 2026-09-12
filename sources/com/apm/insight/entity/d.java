package com.apm.insight.entity;

import android.os.Environment;
import com.apm.insight.e;
import com.apm.insight.l.f;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f19572a;

    /* renamed from: b, reason: collision with root package name */
    private static JSONObject f19573b;

    private static void a() {
        if (f19572a == null) {
            f19572a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + e.g().getPackageName() + "/AutomationTestInfo.json";
        }
        if (f19573b == null) {
            try {
                f19573b = new JSONObject(f.a(f19572a, "\n"));
            } catch (IOException unused) {
                f19573b = new JSONObject();
            } catch (JSONException unused2) {
                f19573b = new JSONObject();
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        Object opt;
        if (jSONObject == null) {
            return;
        }
        try {
            a();
            JSONObject jSONObject2 = f19573b;
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!"slardar_filter".equals(next) && (opt = f19573b.opt(next)) != null) {
                        try {
                            jSONObject.put(next, opt);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            a();
            JSONObject jSONObject2 = f19573b;
            if (jSONObject2 != null) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("slardar_filter");
                if (com.apm.insight.a.a(optJSONObject)) {
                    return;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("filters");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                    try {
                        jSONObject.put("filters", optJSONObject2);
                    } catch (JSONException unused) {
                    }
                }
                a.b(optJSONObject2, optJSONObject);
            }
        } catch (Throwable unused2) {
        }
    }
}
