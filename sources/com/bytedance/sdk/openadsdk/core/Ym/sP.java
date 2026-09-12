package com.bytedance.sdk.openadsdk.core.Ym;

import com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class sP extends TKC {
    private long TEQ;
    private long Ym;

    public sP(int i11, int i12, long j11, long j12, Sj.EnumC0275Sj enumC0275Sj, Sj.sP sPVar, String str, List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list, List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list2, String str2) {
        super(i11, i12, enumC0275Sj, sPVar, str, list, list2, str2);
        this.TEQ = j11;
        this.Ym = j12;
        this.uA = "icon_click";
    }

    public static sP Sj(JSONObject jSONObject) {
        TKC sP = TKC.sP(jSONObject);
        if (sP == null) {
            return null;
        }
        return new sP(sP.Sj, sP.sP, jSONObject.optLong("offset", -1L), jSONObject.optLong("duration", -1L), sP.TKC, sP.EjP, sP.HiB, sP.vS, sP.Jcg, sP.Dq);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ym.TKC
    public JSONObject Sj() throws JSONException {
        JSONObject Sj = super.Sj();
        if (Sj != null) {
            Sj.put("offset", this.TEQ);
            Sj.put("duration", this.Ym);
        }
        return Sj;
    }
}
