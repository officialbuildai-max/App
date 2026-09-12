package com.bytedance.sdk.openadsdk.core.uA;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.HiB;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.cloud.tmc.ad.Constants;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.hisavana.common.tracking.TrackingKey;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TKC {
    private static boolean Sj;

    public static long EjP() {
        if (dNu.EjP().HpB()) {
            return sP.sP().vS();
        }
        return 0L;
    }

    public static int HiB() {
        if (dNu.EjP().HpB()) {
            return sP.sP().Jcg();
        }
        return 6;
    }

    public static Map<String, String> Sj(String str, String str2) {
        if (dNu.EjP().HpB()) {
            return sP.sP().Sj(str, str2 != null ? str2.getBytes() : new byte[0]);
        }
        return new HashMap();
    }

    public static void Sj() {
        if (!Sj && dNu.EjP().HpB()) {
            sP.sP();
            Sj = sP.sP().TKC();
        }
    }

    public static void Sj(MotionEvent motionEvent) {
        if (dNu.EjP().HpB()) {
            sP.sP().Sj(motionEvent);
        }
    }

    public static void Sj(sU sUVar, String str) {
        long j11;
        long j12;
        long j13;
        Object obj;
        if (dNu.EjP().HpB()) {
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.AD_FRAMEWORK_VERSION, BuildConfig.VERSION_NAME);
            hashMap.put("au_show", str);
            if (sUVar != null) {
                String cKW = sUVar.cKW();
                boolean isEmpty = TextUtils.isEmpty(cKW);
                String str2 = TmcConstants.COLD_OPEN_TYPE;
                if (isEmpty) {
                    hashMap.put(TrackingKey.REQUEST_ID, TmcConstants.COLD_OPEN_TYPE);
                } else {
                    hashMap.put(TrackingKey.REQUEST_ID, cKW);
                }
                try {
                    long j14 = -1;
                    if (sUVar.DhB() != null) {
                        j11 = sUVar.DhB().optLong("ad_id", -1L);
                        j12 = sUVar.DhB().optLong("rit", -1L);
                        j13 = sUVar.DhB().optLong("ad_slot_type", -1L);
                        str2 = sUVar.DhB().optString("ad_type", TmcConstants.COLD_OPEN_TYPE);
                    } else {
                        j11 = -1;
                        j12 = -1;
                        j13 = -1;
                    }
                    hashMap.put("ad_id", Long.valueOf(j11));
                    hashMap.put("rit", Long.valueOf(j12));
                    hashMap.put("ad_slot_type", Long.valueOf(j13));
                    hashMap.put("ad_type", str2);
                    Map<String, Object> QZ = sUVar.QZ();
                    if (QZ != null && (obj = QZ.get(TTAdConstant.SDK_BIDDING_TYPE)) != null) {
                        j14 = Long.parseLong(obj.toString());
                    }
                    hashMap.put(TTAdConstant.SDK_BIDDING_TYPE, Long.valueOf(j14));
                    sP.sP().Sj(PglSSManager.REPORT_SCENE_ADSHOW, hashMap);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void Sj(String str) {
        if (dNu.EjP().HpB()) {
            sP.sP().Sj(str);
        }
    }

    public static void Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (!dNu.EjP().HpB()) {
                jSONObject.put("pglx", PrepareException.ERROR_NO_URL);
                return;
            }
            Sj();
            if (HiB() != 0) {
                jSONObject.put("pglx", String.valueOf(HiB()));
                return;
            }
            jSONObject.put("sec_did", sP.sP().EjP());
            String Sj2 = HiB.Sj(jSONObject.toString());
            Map<String, String> Sj3 = sP.sP().Sj("https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250", Sj2 != null ? Sj2.getBytes() : new byte[0]);
            if (Sj3 == null || Sj3.size() <= 0) {
                jSONObject.put("pglx", PrepareException.ERROR_MANIFEST_INFO);
            } else {
                for (String str : Sj3.keySet()) {
                    jSONObject.put(str, Sj3.get(str));
                }
                jSONObject.put("url", "https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250");
                jSONObject.put("pangle_m", Sj2);
            }
            jSONObject.put("ec", sP.sP().vS());
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("SecSdkHelperUtil", th2.getMessage());
            try {
                jSONObject.put("pglx", "7");
            } catch (JSONException unused) {
            }
        }
    }

    public static String TKC() {
        return dNu.EjP().HpB() ? sP.sP().HiB() : "";
    }

    public static void sP() {
        if (dNu.EjP().HpB()) {
            sP.sP().Sj();
        }
    }

    public static void sP(String str) {
        if (TextUtils.isEmpty(str) || !dNu.EjP().HpB()) {
            return;
        }
        sP.sP().sP(str);
    }

    public static String vS() {
        if (dNu.EjP().HpB()) {
            return sP.sP().EjP();
        }
        return null;
    }
}
