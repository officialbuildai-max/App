package com.bytedance.sdk.openadsdk.core.TEQ;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.uA;
import com.cloud.tmc.ad.utils.CommonLogUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.common.internal.ImagesContract;
import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class EjP {
    private static String Sj = "";

    public static String Sj() {
        return Sj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public static JSONObject Sj(sU sUVar, com.bytedance.sdk.openadsdk.core.TEQ.vS.TKC tkc) {
        sU.Sj xhi;
        JSONObject jSONObject;
        tkc.Sj(CommonLogUtil.TAG_AD);
        String str = "";
        Sj = "";
        ?? r42 = 0;
        try {
            xhi = sUVar.xhi();
            if (xhi != null) {
                str = xhi.dNu();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(xhi.uvD()) && !TextUtils.isEmpty(xhi.vS())) {
                    str = com.bytedance.sdk.openadsdk.core.TEQ.Sj.sP.Sj().Sj(CommonLogUtil.TAG_AD, xhi.vS(), xhi.uvD());
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                String str2 = "local data is null id is " + xhi.vS() + " md5 is " + xhi.uvD();
                Sj = str2;
                tkc.Sj(3, str2, "net");
                return null;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
            try {
                Sj = "getTemplate success";
                tkc.sP(ImagesContract.LOCAL);
                return jSONObject;
            } catch (JSONException unused2) {
                String concat = "parse json exception data is ".concat(String.valueOf(str));
                Sj = concat;
                tkc.Sj(2, concat, ImagesContract.LOCAL);
                return null;
            }
        } catch (Throwable th3) {
            r42 = xhi;
            th = th3;
            String str3 = "get template error " + th.getMessage();
            Sj = str3;
            tkc.Sj(2, str3, ImagesContract.LOCAL);
            return r42;
        }
    }

    public static JSONObject Sj(sU sUVar, String str) {
        JSONObject SP = sUVar.SP();
        try {
            SP.put("show_dislike", sUVar.RrR());
            SP.put(TmcConstants.KEY_LANGUAGE, aa.sP());
            if ("open_ad".equals(str)) {
                JSONObject jSONObject = new JSONObject();
                String Dq = uA.sP().Dq();
                int uA = uA.sP().uA();
                jSONObject.put("app_name", Dq);
                jSONObject.put("app_icon_id", "@".concat(String.valueOf(uA)));
                SP.put("open_app_info", jSONObject);
            }
            SP.put("os", "Android");
            JSONArray TKC = TKC(sUVar);
            if (TKC != null) {
                SP.put("dpa_data", TKC);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("UgenUtils", "parseUGenDataInfo exception", th2.getMessage());
        }
        return SP;
    }

    public static boolean Sj(int i11) {
        return i11 == 10 || i11 == 9;
    }

    public static boolean Sj(sU sUVar) {
        return sUVar != null && sUVar.fF() == 7;
    }

    private static JSONArray TKC(sU sUVar) {
        try {
            sU.Sj xhi = sUVar.xhi();
            if (xhi == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(xhi.Ym());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("original_price", Double.valueOf(jSONObject.optDouble("original_price", 0.0d)));
            jSONObject2.putOpt("price_unit", jSONObject.optString("price_unit"));
            jSONObject2.putOpt("discount", Double.valueOf(jSONObject.optDouble("discount", 0.0d)));
            jSONObject2.putOpt("product_name", jSONObject.optString("dpa_product_name"));
            jSONObject2.putOpt(TrackingKey.DESCRIPTION, jSONObject.optString("dpa_description"));
            JSONArray optJSONArray = jSONObject.optJSONArray("dpa_images");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                jSONObject2.putOpt("image", optJSONArray.get(0));
            }
            jSONObject2.putOpt("brand_name", jSONObject.optString("dpa_brand_name"));
            jSONObject2.putOpt("sale_price_i18n", Integer.valueOf(jSONObject.optInt("sale_price_i18n")));
            jSONObject2.putOpt("real_price", Double.valueOf(jSONObject.optDouble("real_price", 0.0d)));
            jSONObject2.put("button_text", sUVar.Ir());
            JSONArray jSONArray = new JSONArray();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("dpa_related_products");
            if (optJSONArray2 != null) {
                jSONArray.put(jSONObject2);
                for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                    try {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i11);
                        jSONObject3.put("button_text", sUVar.Ir());
                        jSONArray.put(jSONObject3);
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean sP(sU sUVar) {
        return sUVar != null && sUVar.fF() == 10;
    }
}
