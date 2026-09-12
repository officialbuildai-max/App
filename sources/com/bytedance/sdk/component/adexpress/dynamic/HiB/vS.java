package com.bytedance.sdk.component.adexpress.dynamic.HiB;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.HiB.HiB;
import com.bytedance.sdk.component.adexpress.sP.Fmk;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class vS {
    private static HashMap<String, String> Jcg;
    private Sj EjP;
    private TKC HiB;
    private JSONObject Sj;
    private com.bytedance.sdk.component.adexpress.dynamic.EjP.TKC TKC;
    private JSONObject sP;
    private com.bytedance.sdk.component.adexpress.dynamic.EjP.EjP vS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Sj {
        float Sj;
        boolean TKC;
        float sP;

        public static Sj Sj(JSONObject jSONObject) {
            Sj sj2 = new Sj();
            if (jSONObject != null) {
                sj2.Sj = (float) jSONObject.optDouble("width");
                sj2.sP = (float) jSONObject.optDouble("height");
                sj2.TKC = jSONObject.optBoolean("isLandscape");
            }
            return sj2;
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        Jcg = hashMap;
        hashMap.put("subtitle", TrackingKey.DESCRIPTION);
        Jcg.put(EventConstants.KEY_SOURCE, "source|app.app_name");
        Jcg.put("screenshot", "dynamic_creative.screenshot");
    }

    public vS(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.Sj = jSONObject;
        this.sP = jSONObject2;
        this.TKC = new com.bytedance.sdk.component.adexpress.dynamic.EjP.TKC(jSONObject2);
        this.EjP = Sj.Sj(jSONObject3);
        this.vS = com.bytedance.sdk.component.adexpress.dynamic.EjP.EjP.Sj(jSONObject4);
    }

    private String Sj() {
        Object Sj2;
        com.bytedance.sdk.component.adexpress.dynamic.EjP.TKC tkc = this.TKC;
        return (tkc == null || (Sj2 = tkc.Sj("adx_name")) == null) ? "" : String.valueOf(Sj2);
    }

    private String Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.TKC.sP(str2)) {
                String valueOf = String.valueOf(this.TKC.Sj(str2));
                if (!TextUtils.isEmpty(valueOf)) {
                    return valueOf;
                }
            }
        }
        return "";
    }

    private void Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        if (dq2 == null) {
            return;
        }
        int sP = com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj(), com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC() != null ? com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().Zq() : com.bytedance.sdk.component.adexpress.EjP.Jcg.Sj(com.bytedance.sdk.component.adexpress.EjP.Sj()));
        Sj sj2 = this.EjP;
        float min = sj2.TKC ? sj2.Sj : Math.min(sj2.Sj, sP);
        if (this.EjP.sP == 0.0f) {
            dq2.HiB(min);
            dq2.TEQ().HiB().TEQ("auto");
            dq2.vS(0.0f);
        } else {
            dq2.HiB(min);
            int sP2 = com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj(), com.bytedance.sdk.component.adexpress.EjP.Jcg.sP(com.bytedance.sdk.component.adexpress.EjP.Sj()));
            Sj sj3 = this.EjP;
            dq2.vS(sj3.TKC ? sj3.sP : Math.min(sj3.sP, sP2));
            dq2.TEQ().HiB().TEQ("fixed");
        }
    }

    private void Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB hiB, int i11) {
        int lastIndexOf;
        if (i11 == 5 || i11 == 15 || i11 == 50 || i11 == 154) {
            hiB.Sj("video");
            String Sj2 = uA.Sj("video");
            hiB.HiB().sU(Sj2);
            String Sj3 = uA.Sj("video", "clickArea");
            if (!TextUtils.isEmpty(Sj3)) {
                hiB.HiB().Zq(Sj3);
                hiB.Jcg().Zq(Sj3);
            }
            hiB.Jcg().sU(Sj2);
            hiB.sP(Sj2);
            hiB.HiB().WxP();
            return;
        }
        hiB.Sj("image");
        String Sj4 = uA.Sj("image");
        com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = hiB.HiB();
        HiB.sU(Sj4);
        hiB.Jcg().sU(Sj4);
        String Sj5 = uA.Sj("image", "clickArea");
        if (!TextUtils.isEmpty(Sj5)) {
            HiB.Zq(Sj5);
            hiB.Jcg().Zq(Sj5);
        }
        JSONObject Ov = HiB.Ov();
        if (Ov != null) {
            HiB.ib(Ov.optString("imageLottieTosPath"));
            HiB.aa(Ov.optBoolean("animationsLoop"));
            HiB.wE(Ov.optInt("lottieAppNameMaxLength"));
            HiB.LqL(Ov.optInt("lottieAdDescMaxLength"));
            HiB.ley(Ov.optInt("lottieAdTitleMaxLength"));
        }
        hiB.sP(Sj4);
        if (Sj4 != null && (lastIndexOf = Sj4.lastIndexOf(".")) > 0) {
            String substring = Sj4.substring(0, lastIndexOf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", Sj(substring + ".width"));
                jSONObject.put("height", Sj(substring + ".height"));
            } catch (JSONException unused) {
            }
            hiB.TKC(jSONObject.toString());
        }
        HiB.dU();
    }

    private void Sj(com.bytedance.sdk.component.adexpress.dynamic.EjP.vS vSVar) {
        if (vSVar == null) {
            return;
        }
        String Yf = vSVar.Yf();
        if (com.bytedance.sdk.component.adexpress.EjP.sP()) {
            String TKC = com.bytedance.sdk.component.adexpress.EjP.Jcg.TKC(com.bytedance.sdk.component.adexpress.EjP.Sj());
            if ("zh".equals(TKC)) {
                TKC = "cn";
            }
            if (!TextUtils.isEmpty(TKC) && vSVar.vS() != null) {
                String optString = vSVar.vS().optString(TKC);
                if (!TextUtils.isEmpty(optString)) {
                    Yf = optString;
                }
            }
        }
        if (TextUtils.isEmpty(Yf)) {
            return;
        }
        int indexOf = Yf.indexOf("{{");
        int indexOf2 = Yf.indexOf("}}");
        if (indexOf < 0 || indexOf2 < 0 || indexOf2 < indexOf) {
            vSVar.aa(Yf);
            return;
        }
        String Sj2 = Sj(Yf.substring(indexOf + 2, indexOf2));
        StringBuilder sb2 = new StringBuilder(Yf.substring(0, indexOf));
        if (!TextUtils.isEmpty(Sj2)) {
            sb2.append(Sj2);
        }
        sb2.append(Yf.substring(indexOf2 + 2));
        vSVar.aa(sb2.toString());
    }

    private void sP(com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        com.bytedance.sdk.component.adexpress.dynamic.EjP.TKC tkc;
        Object Sj2;
        Object Sj3;
        Object Sj4;
        Object Sj5;
        if (dq2 == null || (tkc = this.TKC) == null || (Sj2 = tkc.Sj("image.0.url")) == null) {
            return;
        }
        String valueOf = String.valueOf(Sj2);
        if (TextUtils.isEmpty(valueOf) || (Sj3 = this.TKC.Sj(CampaignEx.JSON_KEY_TITLE)) == null) {
            return;
        }
        String valueOf2 = String.valueOf(Sj3);
        if (TextUtils.isEmpty(valueOf2) || (Sj4 = this.TKC.Sj(TrackingKey.DESCRIPTION)) == null) {
            return;
        }
        String valueOf3 = String.valueOf(Sj4);
        if (TextUtils.isEmpty(valueOf3) || (Sj5 = this.TKC.Sj(RewardPlus.ICON)) == null) {
            return;
        }
        String valueOf4 = String.valueOf(Sj5);
        if (TextUtils.isEmpty(valueOf4)) {
            return;
        }
        Object Sj6 = this.TKC.Sj("app.app_name");
        Object Sj7 = this.TKC.Sj(EventConstants.KEY_SOURCE);
        if (Sj6 == null && Sj7 == null) {
            return;
        }
        if (Sj6 == null) {
            Sj6 = Sj7;
        }
        String valueOf5 = String.valueOf(Sj6);
        if (TextUtils.isEmpty(valueOf5)) {
            return;
        }
        dq2.Sj("imageUrl", valueOf);
        dq2.Sj(CampaignEx.JSON_KEY_TITLE, valueOf2);
        dq2.Sj(TrackingKey.DESCRIPTION, valueOf3);
        dq2.Sj(RewardPlus.ICON, valueOf4);
        dq2.Sj("app_name", valueOf5);
        dq2.Sj(true);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq Sj(double d11, int i11, double d12, String str, Fmk fmk) {
        JSONObject jSONObject;
        this.TKC.Sj();
        try {
            jSONObject = new JSONObject(this.vS.sP);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq Sj2 = Sj(EjP.Sj(this.Sj, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq) null);
        Sj(Sj2);
        HiB hiB = new HiB(d11, i11, d12, str, fmk);
        HiB.Sj sj2 = new HiB.Sj();
        Sj sj3 = this.EjP;
        sj2.Sj = sj3.Sj;
        sj2.sP = sj3.sP;
        sj2.TKC = 0.0f;
        hiB.Sj(sj2);
        hiB.Sj(Sj2, 0.0f, 0.0f);
        hiB.Sj();
        com.bytedance.sdk.component.adexpress.dynamic.EjP.sP sPVar = hiB.Sj;
        if (sPVar.EjP == 65536.0f) {
            return null;
        }
        return sPVar.vS;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq Sj(JSONObject jSONObject) {
        JSONObject jSONObject2;
        String optString = jSONObject.optString(NativeComponentConstants.KEY_COMPONENT_TYPE);
        String optString2 = jSONObject.optString("id");
        JSONObject optJSONObject = jSONObject.optJSONObject("values");
        uA.Sj(optString, optJSONObject);
        JSONObject Sj2 = uA.Sj(optString, uA.Sj(jSONObject.optJSONArray("sceneValues")), optJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2 = new com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq();
        if (TextUtils.isEmpty(optString2)) {
            dq2.sP(String.valueOf(dq2.hashCode()));
        } else {
            dq2.sP(optString2);
        }
        if (optJSONObject != null) {
            sP(dq2);
            dq2.TKC((float) optJSONObject.optDouble("x"));
            dq2.EjP((float) optJSONObject.optDouble("y"));
            dq2.HiB((float) optJSONObject.optDouble("width"));
            dq2.vS((float) optJSONObject.optDouble("height"));
            dq2.Jcg(optJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB hiB = new com.bytedance.sdk.component.adexpress.dynamic.EjP.HiB();
            hiB.Sj(optString);
            hiB.sP(optJSONObject.optString("data"));
            hiB.TKC(optJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS Sj3 = com.bytedance.sdk.component.adexpress.dynamic.EjP.vS.Sj(optJSONObject);
            hiB.Sj(Sj3);
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS Sj4 = com.bytedance.sdk.component.adexpress.dynamic.EjP.vS.Sj(Sj2);
            if (Sj4 == null) {
                hiB.sP(Sj3);
            } else {
                hiB.sP(Sj4);
            }
            Sj(Sj3);
            Sj(Sj4);
            if (TextUtils.equals(optString, "video-image-budget") && (jSONObject2 = this.sP) != null) {
                Sj(hiB, jSONObject2.optInt("image_mode"));
            }
            String sP = hiB.sP();
            com.bytedance.sdk.component.adexpress.dynamic.EjP.vS HiB = hiB.HiB();
            if (Jcg.containsKey(sP) && !HiB.MuB()) {
                HiB.sU(Jcg.get(sP));
            }
            String TKC = HiB.MuB() ? hiB.TKC() : Sj(hiB.TKC());
            if (com.bytedance.sdk.component.adexpress.EjP.sP()) {
                if (TextUtils.equals(sP, "star") || TextUtils.equals(sP, "text_star")) {
                    TKC = Sj("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(sP, "score-count") || TextUtils.equals(sP, "score-count-type-1") || TextUtils.equals(sP, "score-count-type-2")) {
                    TKC = Sj("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(sP) && Sj3.GMp()) {
                    TKC = Sj("image.0.url");
                }
            }
            if (TextUtils.isEmpty(Sj()) || !(TextUtils.equals("logo-union", optString) || TextUtils.equals("logo", optString))) {
                hiB.sP(TKC);
            } else {
                hiB.sP(TKC + "adx:" + Sj());
            }
            dq2.Sj(hiB);
        }
        return dq2;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq Sj(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq dq2) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(NativeComponentConstants.KEY_COMPONENT_TYPE);
        if (TextUtils.equals(optString, "custom-component-vessel")) {
            int optInt = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_ID);
            if (this.vS != null) {
                TKC tkc = new TKC();
                this.HiB = tkc;
                JSONObject Sj2 = tkc.Sj(this.vS.Sj, optInt, jSONObject);
                if (Sj2 != null) {
                    jSONObject = Sj2;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq Sj3 = Sj(jSONObject);
        Sj3.Sj(dq2);
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null) {
            Sj3.Sj((List<com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq>) null);
            return Sj3;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            JSONArray optJSONArray2 = optJSONArray.optJSONArray(i11);
            if (optJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                int xu2 = TextUtils.equals(optString, "tag-group") ? Sj3.TEQ().HiB().xu() : optJSONArray2.length();
                for (int i12 = 0; i12 < xu2; i12++) {
                    com.bytedance.sdk.component.adexpress.dynamic.EjP.Dq Sj4 = Sj(optJSONArray2.optJSONObject(i12), Sj3);
                    if (com.bytedance.sdk.component.adexpress.EjP.sP() && "skip-with-time".equals(Sj3.TEQ().sP()) && !TmcStartParams.KEY_TRANSPARENT.equals(Sj3.ib()) && !TextUtils.isEmpty(Sj3.ib())) {
                        Sj4.TKC(Sj3.ib());
                    }
                    arrayList.add(Sj4);
                    arrayList3.add(Sj4);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            Sj3.Sj(arrayList);
        }
        if (arrayList2.size() > 0) {
            Sj3.sP(arrayList2);
        }
        return Sj3;
    }
}
