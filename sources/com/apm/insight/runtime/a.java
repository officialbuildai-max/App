package com.apm.insight.runtime;

import androidx.annotation.Nullable;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    static {
        new ConcurrentLinkedQueue();
    }

    public static int a(int i11, String... strArr) {
        return com.apm.insight.a.a(i(), i11, strArr);
    }

    public static int a(String... strArr) {
        return com.apm.insight.a.a(i(), -1, strArr);
    }

    @Nullable
    public static String a(@Nullable JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("exception_modules")) == null) {
            return null;
        }
        return optJSONObject.optString("npth");
    }

    @Nullable
    private static JSONObject a(JSONArray jSONArray, String str) {
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i11).optJSONObject(str);
                if (optJSONObject != null) {
                    return optJSONObject;
                }
            }
        }
        return null;
    }

    public static void a(JSONArray jSONArray, boolean z10) {
        if (jSONArray == null) {
            return;
        }
        com.apm.insight.a.a("apmconfig", "fromnet " + z10 + " : " + jSONArray);
        if (z10) {
            com.apm.insight.k.j.f();
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                String next = optJSONObject.keys().next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                com.apm.insight.a.a((Object) ("update config " + next + " : " + optJSONObject2));
                d.a(next, optJSONObject2);
                if (z10) {
                    com.apm.insight.k.j.a(next);
                }
            } catch (Throwable unused) {
            }
        }
        k.a(a(jSONArray, String.valueOf(com.apm.insight.e.a().e())));
        if (z10) {
            com.apm.insight.k.j.a(jSONArray);
        }
    }

    public static boolean a() {
        return l.e();
    }

    public static boolean a(Object obj) {
        String b11 = com.apm.insight.entity.b.b(obj);
        if (b11 != null) {
            return d.a(b11);
        }
        return false;
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            com.apm.insight.k.a.b();
        }
        return d.e(str);
    }

    @Nullable
    public static JSONArray b() {
        String[] strArr = {"custom_event_settings", "npth_simple_setting", "max_utm_thread_ignore"};
        JSONObject b11 = com.apm.insight.a.b(i(), strArr);
        if (b11 == null) {
            return null;
        }
        JSONArray optJSONArray = b11.optJSONArray(strArr[2]);
        com.apm.insight.a.a("ApmConfig", "normal get configArray: " + strArr[2] + " : " + optJSONArray);
        return optJSONArray;
    }

    public static boolean b(Object obj) {
        d c11;
        String b11 = com.apm.insight.entity.b.b(obj);
        if (b11 == null || (c11 = d.c(b11)) == null) {
            return false;
        }
        return c11.a();
    }

    public static boolean b(String str) {
        if (!d.a(str)) {
            com.apm.insight.k.a.b();
        }
        return d.g(str);
    }

    public static boolean c() {
        return a("custom_event_settings", "npth_simple_setting", "disable_looper_monitor") == 1;
    }

    public static boolean c(String str) {
        if (!d.a(str)) {
            com.apm.insight.k.a.b();
        }
        return d.f(str);
    }

    public static boolean d() {
        return a("custom_event_settings", "npth_simple_setting", "enable_all_thread_stack_native") == 1;
    }

    public static boolean e() {
        return a("custom_event_settings", "npth_simple_setting", "anr_with_traces_txt") == 1;
    }

    public static boolean f() {
        return a("custom_event_settings", "npth_simple_setting", "upload_crash_crash") == 1;
    }

    public static boolean g() {
        return a("custom_event_settings", "npth_simple_setting", "force_apm_crash") == 1;
    }

    public static boolean h() {
        return a("custom_event_settings", "npth_simple_setting", "enable_anr_all_process_trace") == 1;
    }

    @Nullable
    private static JSONObject i() {
        return d.b(com.apm.insight.e.a().e());
    }
}
