package com.bytedance.adsdk.Sj.sP.sP.Sj;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class zR implements com.bytedance.adsdk.Sj.sP.sP.Sj {
    private final String Sj;

    public zR(String str) {
        this.Sj = str;
    }

    private Object Sj(String[] strArr, int i11, JSONObject jSONObject) {
        Object opt;
        if (strArr != null && strArr.length > 0 && i11 < strArr.length && jSONObject != null) {
            String str = strArr[i11];
            int indexOf = str.indexOf("[");
            int indexOf2 = str.indexOf("]");
            if (indexOf < 0 || indexOf2 < 0 || indexOf > indexOf2) {
                opt = jSONObject.opt(str);
            } else {
                String substring = str.substring(0, indexOf);
                try {
                    int parseInt = Integer.parseInt(str.substring(indexOf + 1, indexOf2));
                    Object opt2 = jSONObject.opt(substring);
                    opt = opt2 instanceof JSONArray ? ((JSONArray) opt2).opt(parseInt) : null;
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            if (i11 == strArr.length - 1) {
                return opt;
            }
            if (opt instanceof String) {
                try {
                    return Sj(strArr, i11 + 1, new JSONObject((String) opt));
                } catch (JSONException unused2) {
                    return opt;
                }
            }
            if (opt instanceof JSONObject) {
                return Sj(strArr, i11 + 1, (JSONObject) opt);
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public com.bytedance.adsdk.Sj.sP.EjP.HiB Sj() {
        return com.bytedance.adsdk.Sj.sP.EjP.vS.VARIABLE;
    }

    public Object Sj(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Sj(str.split("\\."), 0, jSONObject);
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public Object Sj(Map<String, JSONObject> map) {
        Object Sj;
        if (map == null || map.size() <= 0 || (Sj = Sj(this.Sj, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return Sj;
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public String sP() {
        return this.Sj;
    }

    public String toString() {
        return "VariableNode [literals=" + this.Sj + "]";
    }
}
