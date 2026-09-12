package com.apm.insight.runtime;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.io.File;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static JSONObject f19895a = new JSONObject();

    public static void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String a11 = a.a(jSONObject);
            File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configNative");
            if (a11 == null) {
                f19895a = new JSONObject();
                return;
            }
            JSONObject jSONObject2 = new JSONObject(a11);
            f19895a = jSONObject2;
            com.apm.insight.l.f.a(file, b(jSONObject2));
        } catch (JSONException unused) {
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
        }
    }

    public static boolean a(String str, e eVar) {
        JSONObject optJSONObject;
        JSONObject jSONObject = f19895a;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null || a(optJSONObject.optJSONArray("disable"), eVar)) {
            return false;
        }
        return a(optJSONObject.optJSONArray(OfflineConstantsKt.OFFLINE_CONFIG_ENABLE), eVar);
    }

    private static boolean a(JSONArray jSONArray, e eVar) {
        if (com.apm.insight.a.a(jSONArray)) {
            return false;
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
            if (optJSONObject == null) {
                com.apm.insight.c.a();
                j.a(new IllegalArgumentException("err config: ".concat(String.valueOf(jSONArray))), "NPTH_CATCH");
            } else if (a(optJSONObject, eVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(JSONObject jSONObject, e eVar) {
        Iterator<String> keys = jSONObject.keys();
        boolean z10 = false;
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                if (next.startsWith("header_")) {
                    if (!a(jSONObject.optJSONObject(next), eVar.b(next.substring(7)))) {
                        com.apm.insight.a.a((Object) "not match ".concat(next));
                        return false;
                    }
                } else if (!next.startsWith("java_")) {
                    com.apm.insight.a.a((Object) "no rules match ".concat(next));
                } else if (!a(jSONObject.optJSONObject(next), eVar.a(next.substring(5)))) {
                    com.apm.insight.a.a((Object) "not match ".concat(next));
                    return false;
                }
                z10 = true;
            }
        }
        return z10;
    }

    private static boolean a(JSONObject jSONObject, Object obj) {
        JSONArray optJSONArray = jSONObject.optJSONArray("values");
        if (optJSONArray.length() == 0) {
            return false;
        }
        String optString = jSONObject.optString("op");
        String valueOf = String.valueOf(obj);
        if (optString.equals(UrlUtils.EQUAL_MARK)) {
            return valueOf.equals(String.valueOf(optJSONArray.opt(0)));
        }
        if (optString.equals("in")) {
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                if (String.valueOf(optJSONArray.opt(i11)).equals(valueOf)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static JSONArray b(JSONArray jSONArray, e eVar) {
        JSONArray jSONArray2 = new JSONArray();
        if (com.apm.insight.a.a(jSONArray)) {
            return jSONArray2;
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
            if (optJSONObject == null) {
                com.apm.insight.c.a();
                j.a(new IllegalArgumentException("err config: ".concat(String.valueOf(jSONArray))), "NPTH_CATCH");
            } else if (a(optJSONObject, eVar)) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    private static JSONObject b(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        e eVar = new e();
        JSONObject jSONObject2 = new JSONObject();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!"configType".equals(next)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject == null) {
                    com.apm.insight.c.a();
                    j.a(new IllegalArgumentException("err config with key: ".concat(String.valueOf(next))), "NPTH_CATCH");
                } else if (a(optJSONObject.optJSONArray("disable"), eVar)) {
                    com.apm.insight.a.a((Object) "match diable ".concat(String.valueOf(next)));
                } else {
                    JSONArray b11 = b(optJSONObject.optJSONArray(OfflineConstantsKt.OFFLINE_CONFIG_ENABLE), eVar);
                    if (com.apm.insight.a.a(b11)) {
                        com.apm.insight.a.a((Object) "not match ".concat(String.valueOf(next)));
                    } else {
                        try {
                            jSONObject2.put(next, new JSONObject().put(OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, b11));
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        }
        return jSONObject2;
    }
}
