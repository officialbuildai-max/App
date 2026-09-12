package com.bytedance.adsdk.Sj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class EjP implements vS {
    @Override // com.bytedance.adsdk.Sj.vS
    /* renamed from: sP, reason: merged with bridge method [inline-methods] */
    public String Sj(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length != 3) {
            return null;
        }
        String valueOf = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(valueOf)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(valueOf);
            String valueOf2 = String.valueOf(objArr[1]);
            if (TextUtils.isEmpty(valueOf2)) {
                return null;
            }
            Object Sj = com.bytedance.adsdk.Sj.sP.Sj.Sj(valueOf2).Sj(jSONObject2);
            return TextUtils.isEmpty(String.valueOf(Sj)) ? String.valueOf(objArr[2]) : String.valueOf(Sj);
        } catch (JSONException unused) {
            return null;
        }
    }
}
