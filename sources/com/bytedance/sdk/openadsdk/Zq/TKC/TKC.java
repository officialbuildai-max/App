package com.bytedance.sdk.openadsdk.Zq.TKC;

import com.cloud.tmc.integration.net.UrlKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TKC {

    /* loaded from: classes2.dex */
    public static class Sj {
        public final String Sj;
        public final JSONObject sP;

        public Sj(String str, JSONObject jSONObject) {
            this.Sj = str;
            this.sP = jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("device_info");
            if (optJSONObject != null) {
                try {
                    optJSONObject.put(UrlKt.KEY_MINI_GAID, com.bytedance.sdk.openadsdk.RiZ.Sj.sP.Sj.Sj().sP());
                    jSONObject.put("device_info", optJSONObject);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static sP Sj() {
        return EjP.Sj();
    }
}
