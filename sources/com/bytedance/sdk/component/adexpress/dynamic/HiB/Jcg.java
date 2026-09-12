package com.bytedance.sdk.component.adexpress.dynamic.HiB;

import com.bytedance.sdk.component.adexpress.sP.Fmk;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Jcg implements Dq {
    private com.bytedance.sdk.component.adexpress.dynamic.vS.sP Sj;

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(Fmk fmk) {
        try {
            JSONObject TKC = fmk.TKC();
            JSONObject jSONObject = new JSONObject(TKC.optString("template_Plugin"));
            JSONObject optJSONObject = TKC.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq Sj = new vS(jSONObject, optJSONObject, TKC.optJSONObject("AdSize"), new JSONObject(TKC.optString("diff_template_Plugin"))).Sj(fmk.sP(), fmk.TEQ(), optJSONObject.optDouble("score_exact_i18n"), optJSONObject.optString("comment_num_i18n"), fmk);
            try {
                JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("dynamic_creative"));
                Sj.Sj(jSONObject2.optString(TtmlNode.ATTR_TTS_COLOR));
                Sj.Sj(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.Sj.Sj(Sj);
        } catch (Exception unused2) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.HiB.Dq
    public void Sj(com.bytedance.sdk.component.adexpress.dynamic.vS.sP sPVar) {
        this.Sj = sPVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.HiB.Dq
    public void Sj(final Fmk fmk) {
        if (fmk.aa() == 1) {
            sP(fmk);
        } else {
            com.bytedance.sdk.component.adexpress.EjP.EjP.Sj(new com.bytedance.sdk.component.Dq.Dq("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.HiB.Jcg.1
                @Override // java.lang.Runnable
                public void run() {
                    Jcg.this.sP(fmk);
                }
            }, 5);
        }
    }
}
