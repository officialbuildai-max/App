package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Sj {
    private long Dq;
    private C0284Sj EjP;
    private String Fmk;
    private boolean HiB;
    private String Jcg;
    private String Sj;
    private String TKC;

    /* renamed from: aa, reason: collision with root package name */
    private int f21144aa;
    private int sP;
    private boolean uA;
    private List<sU> vS = new ArrayList();
    private JSONObject TEQ = new JSONObject();
    private volatile boolean Ym = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.model.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0284Sj extends sU.Sj {
        private int Sj;

        public static C0284Sj Sj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0284Sj c0284Sj = new C0284Sj();
            c0284Sj.TKC(jSONObject.optString("id"));
            c0284Sj.EjP(jSONObject.optString("md5"));
            c0284Sj.HiB(jSONObject.optString("url"));
            c0284Sj.vS(jSONObject.optString("data"));
            c0284Sj.Jcg(jSONObject.optString("diff_data"));
            c0284Sj.sP(jSONObject.optString("version"));
            c0284Sj.Dq(jSONObject.optString("dynamic_creative"));
            c0284Sj.Sj(jSONObject.optInt("count_down_time"));
            if (Sj(c0284Sj)) {
                return c0284Sj;
            }
            return null;
        }

        private static boolean Sj(C0284Sj c0284Sj) {
            return (c0284Sj == null || TextUtils.isEmpty(c0284Sj.vS()) || TextUtils.isEmpty(c0284Sj.Dq())) ? false : true;
        }

        public int Sj() {
            return this.Sj;
        }

        public void Sj(int i11) {
            this.Sj = i11;
        }

        public JSONObject sP() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", vS());
                jSONObject.put("md5", Jcg());
                jSONObject.put("url", Dq());
                jSONObject.put("data", uA());
                jSONObject.put("diff_data", TEQ());
                jSONObject.put("version", HiB());
                jSONObject.put("dynamic_creative", Ym());
                jSONObject.put("count_down_time", Sj());
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static Map<String, sU> Sj(Sj sj2) {
        if (sj2 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (sU sUVar : sj2.EjP()) {
            if (!TextUtils.isEmpty(sUVar.eMB())) {
                hashMap.put(sUVar.eMB(), sUVar);
            }
        }
        if (hashMap.size() != 0) {
            return hashMap;
        }
        return null;
    }

    public static Sj TKC(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Sj sj2 = new Sj();
            JSONObject optJSONObject = jSONObject.optJSONObject("choose_ui_data");
            if (optJSONObject != null) {
                sj2.sP(optJSONObject);
            }
            sj2.sP(jSONObject.optInt("multi_ad_style", 0));
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    sU Sj = com.bytedance.sdk.openadsdk.core.sP.Sj(optJSONArray.optJSONObject(i11));
                    if (Sj != null) {
                        Sj.uA(sj2.aa());
                        arrayList.add(Sj);
                    }
                }
                sj2.Sj(arrayList);
            }
            sj2.Sj(jSONObject.optBoolean("is_choose_ad_original", false));
            sj2.Sj(jSONObject.optString(TrackingKey.REQUEST_ID, ""));
            return sj2;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj("AdInfo", "fromJson: ", th2);
            return null;
        }
    }

    public boolean Dq() {
        return this.uA;
    }

    public List<sU> EjP() {
        return this.vS;
    }

    public void EjP(String str) {
        this.Fmk = str;
    }

    @Nullable
    public JSONObject Fmk() {
        try {
            JSONObject jSONObject = new JSONObject();
            C0284Sj uA = uA();
            if (uA != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject sP = uA.sP();
                if (sP != null) {
                    jSONObject2.put("tpl_info", sP);
                    jSONObject.put("choose_ui_data", jSONObject2);
                }
            }
            List<sU> list = this.vS;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i11 = 0; i11 < this.vS.size(); i11++) {
                    jSONArray.put(this.vS.get(i11).SP());
                }
                jSONObject.put("creatives", jSONArray);
            }
            jSONObject.put("is_choose_ad_original", this.uA);
            jSONObject.put("multi_ad_style", this.f21144aa);
            jSONObject.put(TrackingKey.REQUEST_ID, this.Sj);
            return jSONObject;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj("AdInfo", "toJsonObj: ", th2);
            return null;
        }
    }

    public boolean HiB() {
        List<sU> list = this.vS;
        return list != null && list.size() > 0;
    }

    public boolean Jcg() {
        if (uA() == null || EjP() == null || EjP().size() <= 1) {
            this.HiB = false;
            Sj((C0284Sj) null);
        } else {
            this.HiB = true;
        }
        return this.HiB;
    }

    public JSONObject Sj() {
        return this.TEQ;
    }

    public void Sj(int i11) {
        this.sP = i11;
    }

    public void Sj(long j11) {
        this.Dq = j11;
    }

    public void Sj(C0284Sj c0284Sj) {
        this.EjP = c0284Sj;
        if (c0284Sj == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.Sj.sP.sP.Sj(sU.Sj.Sj(c0284Sj, ""));
    }

    public void Sj(sU sUVar) {
        this.vS.add(sUVar);
    }

    public void Sj(String str) {
        this.Sj = str;
    }

    public void Sj(List<sU> list) {
        this.vS = list;
    }

    public void Sj(JSONObject jSONObject) {
        this.TEQ = jSONObject;
    }

    public void Sj(boolean z10) {
        this.uA = z10;
    }

    public boolean TEQ() {
        return this.Ym;
    }

    public int TKC() {
        return this.sP;
    }

    public void TKC(String str) {
        this.Jcg = str;
    }

    public void Ym() {
        this.Ym = false;
    }

    public boolean aa() {
        return this.f21144aa == 1;
    }

    public String sP() {
        sU vS = vS();
        return vS != null ? vS.cKW() : "";
    }

    public void sP(int i11) {
        this.f21144aa = i11;
    }

    public void sP(String str) {
        this.TKC = str;
    }

    public void sP(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Sj(C0284Sj.Sj(jSONObject.optJSONObject("tpl_info")));
    }

    public String sef() {
        return this.Fmk;
    }

    public C0284Sj uA() {
        return this.EjP;
    }

    public sU vS() {
        if (this.vS.size() > 0) {
            return this.vS.get(0);
        }
        return null;
    }
}
