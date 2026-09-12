package com.bytedance.sdk.openadsdk.core.Jcg;

import com.bytedance.sdk.component.Jcg.sP.EjP;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.utils.sU;
import com.cloud.tmc.ad.Constants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TKC {
    public static void Sj(String str, long j11) {
        JSONObject sP = sP(str, j11);
        EjP sP2 = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
        sP2.sP(Mts.EjP("/api/ad/union/sdk/stats/"));
        sP2.EjP(sP.toString());
        sP2.Sj(6);
        sP2.Sj("uploadFrequentEvent");
        sP2.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.core.Jcg.TKC.1
            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar) {
            }

            @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
            public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
                iOException.getMessage();
                if (tkc != null) {
                    sU.Sj(tkc.EjP());
                }
            }
        });
    }

    private static JSONObject sP(String str, long j11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put(Constants.AD_FRAMEWORK_VERSION, BuildConfig.VERSION_NAME);
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, j11);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
