package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import y5.b;

/* loaded from: classes3.dex */
public class uP {
    private int Dq;
    private int EjP;
    private String HiB;
    private int Jcg;
    private int Sj;
    private boolean TEQ;
    private boolean TKC;
    private int sP;
    private int uA;
    private String vS;

    public uP(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.TKC = jSONObject.optBoolean("is_playable");
        this.EjP = jSONObject.optInt("playable_type", 0);
        this.HiB = jSONObject.optString("playable_style");
        JSONObject optJSONObject = jSONObject.optJSONObject("playable");
        if (optJSONObject != null) {
            this.vS = optJSONObject.optString("playable_url", "");
            this.Jcg = optJSONObject.optInt("playable_orientation", 0);
            this.sP = optJSONObject.optInt("new_style", 0);
            this.Sj = optJSONObject.optInt("close_2_app", 0);
            int sP = sP(this.EjP);
            this.Dq = optJSONObject.optInt("playable_webview_timeout", sP);
            this.uA = optJSONObject.optInt("playable_js_timeout", sP);
            this.TEQ = optJSONObject.optInt("playable_backup_enable", 0) == 1;
        }
    }

    public static boolean Dq(sU sUVar) {
        uP sU = sUVar.sU();
        return sU != null && !sUVar.pR() && sU.TKC && sU.sP == 1;
    }

    public static boolean EjP(sU sUVar) {
        return TKC(sUVar) && !uA(sUVar);
    }

    public static String Fmk(sU sUVar) {
        if (sUVar == null) {
            return null;
        }
        uP sU = sUVar.sU();
        if (sU != null && sU.TKC) {
            String str = sU.vS;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        if (sUVar.dx() == 20) {
            return sUVar.Chv();
        }
        if (sUVar.UHs() != null) {
            return sUVar.UHs().z();
        }
        return null;
    }

    public static boolean HiB(sU sUVar) {
        uP kF = kF(sUVar);
        return kF != null && sUVar.pR() && kF.TKC && !TextUtils.isEmpty(Fmk(sUVar));
    }

    public static boolean Jcg(sU sUVar) {
        uP kF = kF(sUVar);
        return (kF == null || sUVar.pR() || !kF.TKC || TextUtils.isEmpty(Fmk(sUVar))) ? false : true;
    }

    public static boolean RiZ(sU sUVar) {
        return Jcg(sUVar) && uP(sUVar) == 0;
    }

    public static int Sj(int i11) {
        return i11 + 10;
    }

    public static int Sj(sU sUVar) {
        int i11;
        uP sU = sUVar.sU();
        if (sU != null && (i11 = sU.Sj) >= 0 && i11 <= 100) {
            return i11;
        }
        return 0;
    }

    public static boolean TEQ(sU sUVar) {
        uP sU = sUVar.sU();
        return sU != null && sUVar.pR() && sU.TKC && sU.sP == 1;
    }

    public static boolean TKC(sU sUVar) {
        return sP(sUVar) && uP(sUVar) == 1;
    }

    public static boolean TzV(sU sUVar) {
        return Jcg(sUVar) && uP(sUVar) == 1;
    }

    public static String Ym(sU sUVar) {
        uP kF = kF(sUVar);
        if (kF == null) {
            return null;
        }
        return kF.HiB;
    }

    public static boolean Zq(sU sUVar) {
        return ((sUVar == null || sUVar.UHs() == null) ? 0 : sUVar.UHs().F()) != 1;
    }

    public static String aa(sU sUVar) {
        uP kF = kF(sUVar);
        if (kF == null) {
            return null;
        }
        return kF.vS;
    }

    public static int dNu(sU sUVar) {
        uP kF = kF(sUVar);
        if (kF == null) {
            return 0;
        }
        return kF.Jcg;
    }

    public static long dx(sU sUVar) {
        if (kF(sUVar) == null) {
            return 5L;
        }
        return r2.Sj();
    }

    public static boolean ib(sU sUVar) {
        uP kF = kF(sUVar);
        return kF != null && kF.TKC();
    }

    private static uP kF(sU sUVar) {
        if (sUVar == null) {
            return null;
        }
        return sUVar.sU();
    }

    private static int sP(int i11) {
        return i11 == 1 ? 10 : 5;
    }

    public static boolean sP(sU sUVar) {
        uP kF = kF(sUVar);
        return (kF == null || !kF.TKC || TextUtils.isEmpty(Fmk(sUVar))) ? false : true;
    }

    public static long sU(sU sUVar) {
        return Math.max(dx(sUVar), zR(sUVar));
    }

    public static boolean sef(sU sUVar) {
        return true;
    }

    public static boolean uA(sU sUVar) {
        uP sU = sUVar.sU();
        return sU != null && sU.TKC && sU.sP == 1;
    }

    private static int uP(sU sUVar) {
        uP kF = kF(sUVar);
        if (kF == null) {
            return 0;
        }
        return kF.EjP;
    }

    public static boolean uvD(sU sUVar) {
        b UHs = sUVar.UHs();
        return UHs != null && UHs.F() == 1;
    }

    public static boolean vS(sU sUVar) {
        return HiB(sUVar) && uP(sUVar) == 1;
    }

    public static long zR(sU sUVar) {
        if (kF(sUVar) == null) {
            return 5L;
        }
        return r2.sP();
    }

    public int Sj() {
        return this.Dq;
    }

    public void Sj(JSONObject jSONObject) {
        try {
            jSONObject.put("is_playable", this.TKC);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.sU.sP("PlayableModel", e11.getMessage());
        }
        if (!TextUtils.isEmpty(this.vS)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("playable_url", this.vS);
                jSONObject2.put("playable_orientation", this.Jcg);
                jSONObject2.put("new_style", this.sP);
                jSONObject2.put("close_2_app", this.Sj);
                jSONObject2.put("playable_webview_timeout", this.Dq);
                jSONObject2.put("playable_js_timeout", this.uA);
                jSONObject2.put("playable_backup_enable", this.TEQ ? 1 : 0);
                jSONObject.put("playable", jSONObject2);
            } catch (Exception e12) {
                com.bytedance.sdk.component.utils.sU.sP("PlayableModel", e12.getMessage());
            }
        }
        try {
            jSONObject.put("playable_type", this.EjP);
        } catch (JSONException e13) {
            com.bytedance.sdk.component.utils.sU.sP("PlayableModel", e13.getMessage());
        }
        try {
            jSONObject.put("playable_style", this.HiB);
        } catch (JSONException e14) {
            com.bytedance.sdk.component.utils.sU.sP("PlayableModel", e14.getMessage());
        }
    }

    public boolean TKC() {
        return this.TEQ;
    }

    public int sP() {
        return this.uA;
    }
}
