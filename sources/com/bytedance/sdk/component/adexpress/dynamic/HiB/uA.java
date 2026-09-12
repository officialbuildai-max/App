package com.bytedance.sdk.component.adexpress.dynamic.HiB;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class uA {
    public static String Sj(String str) {
        JSONObject optJSONObject;
        JSONObject Ir = com.bytedance.sdk.component.adexpress.sP.Ir(str);
        if (Ir == null || (optJSONObject = Ir.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString("data");
    }

    public static String Sj(String str, String str2) {
        JSONObject optJSONObject;
        JSONObject Ir = com.bytedance.sdk.component.adexpress.sP.Ir(str);
        if (Ir == null || (optJSONObject = Ir.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString(str2);
    }

    public static JSONObject Sj(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject Ir = com.bytedance.sdk.component.adexpress.sP.Ir(str);
        if (Ir == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return Sj(jSONObject2, Ir.optJSONObject("themeValues"), jSONObject);
    }

    public static JSONObject Sj(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (optJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return optJSONObject.optJSONObject("values");
    }

    public static JSONObject Sj(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void Sj(String str, JSONObject jSONObject) {
        JSONObject Ir = com.bytedance.sdk.component.adexpress.sP.Ir(str);
        if (Ir == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = Ir.optJSONObject("values");
        if (optJSONObject == null) {
            return;
        }
        Sj(optJSONObject, jSONObject);
    }

    private static void Sj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static String sP(String str, String str2) {
        if (!com.bytedance.sdk.component.adexpress.EjP.sP()) {
            return Sj.Sj(str);
        }
        if (str.indexOf(46) < 0) {
            str = str + ".png";
        }
        return str2 + "static/images/" + str;
    }
}
