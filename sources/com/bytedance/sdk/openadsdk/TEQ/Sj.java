package com.bytedance.sdk.openadsdk.TEQ;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.RiZ.Sj.Sj.Jcg;
import com.bytedance.sdk.openadsdk.RiZ.Sj.Sj.vS;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Sj implements TKC {
    private final sU Sj;
    private final Map<String, vS> TKC = new HashMap();
    private final sP sP;

    private Sj(sP sPVar, sU sUVar) {
        this.sP = sPVar;
        this.Sj = sUVar;
    }

    private vS Sj(@NonNull Context context, @NonNull sU sUVar, @NonNull JSONObject jSONObject, @NonNull String str, boolean z10) {
        vS Sj = Jcg.Sj(context, sUVar, str);
        Sj.Sj(true);
        return Sj;
    }

    public static Sj Sj(sP sPVar, sU sUVar) {
        return new Sj(sPVar, sUVar);
    }

    private sU Sj(JSONObject jSONObject, String str) {
        String Sj;
        if (jSONObject == null) {
            return null;
        }
        sU vS = sU.vS();
        vS.EjP(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            vS.sU(str);
        }
        if (this.Sj == null) {
            return vS;
        }
        String Sj2 = vS.tz() != null ? vS.tz().Sj() : null;
        if (TextUtils.isEmpty(Sj2)) {
            return this.Sj;
        }
        com.bytedance.sdk.openadsdk.core.model.EjP tz2 = this.Sj.tz();
        if (tz2 != null && Sj2.equals(tz2.Sj())) {
            return this.Sj;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (tz2 != null) {
            try {
                Sj = tz2.Sj();
            } catch (JSONException unused) {
            }
        } else {
            Sj = "null";
        }
        jSONObject2.put("lu", Sj);
        jSONObject2.put("ju", Sj2);
        sU sUVar = this.Sj;
        com.bytedance.sdk.openadsdk.core.EjP.Sj(sUVar, Mts.Sj(sUVar), -5, jSONObject2);
        if (tz2 != null && Sj2.contains("play.google.com/store") && !Sj2.contains("referrer")) {
            vS.tz().Sj(tz2.Sj());
        }
        return vS;
    }

    private void Sj(Context context, sU sUVar, JSONObject jSONObject, int i11, boolean z10) {
        if (context == null || sUVar == null || sUVar.tz() == null || jSONObject == null || this.sP == null || this.TKC.get(sUVar.tz().Sj()) != null) {
            return;
        }
        String sP = Mts.sP(i11);
        if (TextUtils.isEmpty(sP)) {
            return;
        }
        this.TKC.put(sUVar.tz().Sj(), Sj(context, sUVar, jSONObject, sP, z10));
    }

    private void Sj(sU sUVar, JSONObject jSONObject) {
        if (this.sP == null || sUVar == null || sUVar.tz() == null) {
            return;
        }
        String Sj = sUVar.tz().Sj();
        if (this.TKC.containsKey(Sj)) {
            this.TKC.remove(Sj);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS);
                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.sP.Sj("app_ad_event", jSONObject2);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.sP("JsAppAdDownloadManager", e11.getMessage());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TEQ.TKC
    public void Sj() {
        this.TKC.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.TEQ.TKC
    public void Sj(Context context, JSONObject jSONObject, String str) {
        sU sUVar;
        if (context == null || (sUVar = this.Sj) == null) {
            return;
        }
        Jcg.Sj(context, sUVar, str).EjP();
    }

    @Override // com.bytedance.sdk.openadsdk.TEQ.TKC
    public void Sj(Context context, JSONObject jSONObject, String str, int i11, boolean z10) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        Sj(context, Sj(optJSONObject, str), optJSONObject, i11, z10);
    }

    @Override // com.bytedance.sdk.openadsdk.TEQ.TKC
    public void Sj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        Sj(Sj(optJSONObject, (String) null), optJSONObject);
    }
}
