package com.apm.insight.runtime;

import androidx.annotation.Nullable;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, d> f19872a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f19873b = null;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f19874c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f19875d = false;

    /* renamed from: e, reason: collision with root package name */
    private String f19876e;

    private d(JSONObject jSONObject, String str) {
        this.f19876e = str;
        a(jSONObject);
        f19872a.put(this.f19876e, this);
        com.apm.insight.a.a((Object) "after update aid ".concat(String.valueOf(str)));
    }

    public static void a(String str, JSONObject jSONObject) {
        d dVar = f19872a.get(str);
        if (dVar != null) {
            dVar.a(jSONObject);
        } else {
            new d(jSONObject, str);
        }
    }

    private void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f19873b = jSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("error_module")) == null) {
            return;
        }
        this.f19875d = optJSONObject.optInt("switcher") == 1 && optJSONObject.optInt("err_sampling_rate") == 1;
    }

    public static boolean a(String str) {
        return f19872a.get(str) != null;
    }

    @Nullable
    public static JSONObject b(String str) {
        d dVar = f19872a.get(str);
        if (dVar != null) {
            return dVar.f19873b;
        }
        return null;
    }

    public static d c(String str) {
        return f19872a.get(str);
    }

    public static long d(String str) {
        d dVar = f19872a.get(str);
        if (dVar == null) {
            return 3600000L;
        }
        try {
            return Long.decode(com.apm.insight.a.a(dVar.f19873b, "over_all", "get_settings_interval")).longValue() * 1000;
        } catch (Throwable unused) {
            return 3600000L;
        }
    }

    public static boolean e(String str) {
        JSONObject jSONObject;
        d dVar = f19872a.get(str);
        return (dVar == null || (jSONObject = dVar.f19873b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public static boolean f(String str) {
        JSONObject jSONObject;
        d dVar = f19872a.get(str);
        return (dVar == null || (jSONObject = dVar.f19873b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public static boolean g(String str) {
        JSONObject jSONObject;
        d dVar = f19872a.get(str);
        return (dVar == null || (jSONObject = dVar.f19873b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public final boolean a() {
        if (this.f19873b == null) {
            return false;
        }
        return this.f19875d;
    }
}
