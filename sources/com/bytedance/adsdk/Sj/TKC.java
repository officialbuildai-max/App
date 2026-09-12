package com.bytedance.adsdk.Sj;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TKC implements vS {
    @Override // com.bytedance.adsdk.Sj.vS
    public Object Sj(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                String valueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.equals(valueOf, "null")) {
                    return valueOf;
                }
            }
        }
        return null;
    }
}
