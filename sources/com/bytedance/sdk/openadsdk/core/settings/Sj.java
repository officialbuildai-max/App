package com.bytedance.sdk.openadsdk.core.settings;

import com.bytedance.sdk.openadsdk.core.settings.HiB;
import com.bytedance.sdk.openadsdk.core.settings.aa;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Sj extends aa {
    public Sj() {
        super("tt_set_apm.prop", new aa.Sj() { // from class: com.bytedance.sdk.openadsdk.core.settings.Sj.1
            @Override // com.bytedance.sdk.openadsdk.core.settings.aa.Sj
            public void Sj() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.aa.Sj
            public void sP() {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.HiB
    public void Sj(JSONObject jSONObject) {
        HiB.Sj Sj = Sj();
        if (jSONObject.has("apm_url")) {
            Sj.Sj("apm_url", jSONObject.optString("apm_url"));
        }
        if (jSONObject.has("perf_con")) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("perf_con");
                if (optJSONObject != null && optJSONObject.has("perf_con_apm")) {
                    Sj.Sj("perf_con_apm", optJSONObject.optInt("perf_con_apm"));
                }
            } catch (Exception unused) {
            }
        }
        Sj.Sj();
        EjP();
    }
}
