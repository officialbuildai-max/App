package com.bytedance.adsdk.Sj;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Sj implements vS {
    @Override // com.bytedance.adsdk.Sj.vS
    public Object Sj(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length != 2) {
            return null;
        }
        String valueOf = String.valueOf(objArr[0]);
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(valueOf);
            int parseInt = Integer.parseInt(String.valueOf(objArr[1]));
            for (int i11 = 0; i11 < jSONArray2.length(); i11 += parseInt) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray3 = new JSONArray();
                for (int i12 = 0; i12 < parseInt; i12++) {
                    int i13 = i11 + i12;
                    if (i13 >= jSONArray2.length()) {
                        break;
                    }
                    jSONArray3.put(jSONArray2.optJSONObject(i13));
                }
                jSONObject2.put("$chunk", jSONArray3);
                jSONArray.put(jSONObject2);
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }
}
