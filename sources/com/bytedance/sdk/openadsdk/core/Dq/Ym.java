package com.bytedance.sdk.openadsdk.core.Dq;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.sU;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Ym {
    private static int Sj(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1263194568:
                if (str.equals("open_ad")) {
                    c11 = 2;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 1;
            case 1:
                return 7;
            case 2:
                return 3;
            case 3:
                return 8;
            case 4:
                return 2;
            default:
                return 5;
        }
    }

    public static void Sj(String str, int i11, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.core.Dq.Sj(i11);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_source", str);
            sU.Sj xhi = sUVar.xhi();
            if (xhi != null) {
                jSONObject.put("tpl_id", xhi.vS());
                if ("Web".equals(str)) {
                    if (xhi.sef()) {
                        jSONObject.put("engine_version", "v3");
                    } else {
                        jSONObject.put("engine_version", "v1");
                    }
                }
            } else if (sUVar.ndK() != null) {
                jSONObject.put("tpl_id", sUVar.ndK().Sj());
                if ("Web".equals(str)) {
                    jSONObject.put("engine_version", "v3");
                }
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.Zq.TKC.Sj().Sj(com.bytedance.sdk.openadsdk.Zq.Sj.EjP.sP().Sj(Sj(str3)).TKC(str4).HiB(sUVar != null ? sUVar.cKW() : "").sP(i11).sP(jSONObject.toString()).vS(str2));
    }
}
