package com.bytedance.sdk.openadsdk.EjP.Sj;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Fmk implements com.bytedance.sdk.openadsdk.Zq.sP {
    private final com.bytedance.sdk.component.vS.Sj.vS.EjP Sj;
    private final boolean sP;

    public Fmk(boolean z10, com.bytedance.sdk.component.vS.Sj.vS.EjP ejP) {
        this.Sj = ejP;
        this.sP = z10;
    }

    @Override // com.bytedance.sdk.openadsdk.Zq.sP
    @Nullable
    public com.bytedance.sdk.openadsdk.Zq.Sj.TKC getLogStats() throws Exception {
        if (this.Sj == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, this.sP);
        jSONObject.put("url", this.Sj.sP());
        int EjP = this.Sj.EjP();
        if (EjP <= 0) {
            EjP = 0;
        }
        jSONObject.put("retry_times", EjP);
        jSONObject.put("ad_id", this.Sj.vS());
        jSONObject.put("track_type", this.Sj.HiB());
        jSONObject.put("upload_scene", this.sP ? this.Sj.TEQ() ? 3 : this.Sj.EjP() <= 0 ? 1 : 2 : 4);
        String Jcg = this.Sj.Jcg();
        if (!TextUtils.isEmpty(Jcg)) {
            JSONArray jSONArray = new JSONArray();
            for (String str : Jcg.split(",")) {
                jSONArray.put(str);
            }
            jSONObject.put("error_code", jSONArray);
        }
        String uA = this.Sj.uA();
        if (!TextUtils.isEmpty(uA)) {
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : uA.split(",")) {
                jSONArray2.put(str2);
            }
            jSONObject.put(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG, jSONArray2);
        }
        return com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj("track_link_result").sP(jSONObject.toString());
    }
}
