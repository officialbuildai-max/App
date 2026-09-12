package com.bytedance.sdk.openadsdk.EjP.Sj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.ib;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.utils.ley;
import com.bytedance.sdk.openadsdk.utils.uP;
import com.bytedance.sdk.openadsdk.utils.zR;
import com.cloud.config.utils.CommonUtils;
import com.cloud.tmc.ad.Constants;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.miniutils.constant.TimeConstants;
import com.hisavana.common.tracking.TrackingKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TKC {
    private final boolean EjP;
    private final String HiB;
    private long Sj;
    private final Context TKC;
    private int sP;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Sj {
        private static final TKC Sj = new TKC();
    }

    private TKC() {
        this.EjP = TKC();
        this.TKC = dNu.Sj().getApplicationContext();
        this.HiB = HiB();
    }

    private int EjP() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / TimeConstants.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String HiB() {
        return DeviceUtils.TKC(this.TKC) ? "tv" : DeviceUtils.sP(this.TKC) ? "android_pad" : "android";
    }

    public static TKC Sj() {
        return Sj.Sj;
    }

    private String Sj(int i11) {
        return i11 != 120 ? i11 != 160 ? i11 != 240 ? i11 != 320 ? i11 != 480 ? i11 != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    private String Sj(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private void Sj(com.bytedance.sdk.openadsdk.EjP.Sj sj2, boolean z10) {
        if (sj2 == null) {
            return;
        }
        try {
            String optString = z10 ? sj2.TKC().optJSONObject("params").optString("log_extra", "") : sj2.TKC().optString("log_extra", "");
            long Sj2 = sU.Sj(optString);
            int EjP = sU.EjP(optString);
            if (Sj2 == 0) {
                Sj2 = this.Sj;
            }
            this.Sj = Sj2;
            if (EjP == 0) {
                EjP = this.sP;
            }
            this.sP = EjP;
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.sU.sP("AdLogParamsGenerate", "getInfoFromLogExtra exception", e11.getMessage());
        }
    }

    private boolean TKC() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private String vS() {
        StringBuilder sb2 = new StringBuilder();
        try {
            if (uP.HiB()) {
                sb2.append("MIUI-");
            } else if (uP.sP()) {
                sb2.append("FLYME-");
            } else {
                String sef = uP.sef();
                if (uP.Sj(sef)) {
                    sb2.append("EMUI-");
                }
                if (!TextUtils.isEmpty(sef)) {
                    sb2.append(sef);
                    sb2.append("-");
                }
            }
            sb2.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb2.toString();
    }

    public String Sj(List<com.bytedance.sdk.openadsdk.EjP.Sj> list) {
        return Mts.HiB((list.size() <= 0 || list.get(0) == null || list.get(0).TKC() == null) ? "" : list.get(0).TKC().optString("app_log_url"));
    }

    public List<com.bytedance.sdk.openadsdk.EjP.Sj> Sj(List<com.bytedance.sdk.openadsdk.EjP.Sj> list, boolean z10) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.EjP.Sj sj2 : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject TKC = sj2.TKC();
                jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, TKC.optString("label"));
                long optLong = TKC.optLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(optLong));
                jSONObject.putOpt("datetime", com.bytedance.sdk.openadsdk.EjP.vS.TKC.format(new Date(optLong)));
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = TKC.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.equals(next, "label")) {
                        jSONObject2.putOpt(next, TKC.opt(next));
                    }
                }
                if (z10) {
                    jSONObject2.putOpt("_ad_staging_flag", 3);
                }
                jSONObject.putOpt("params", jSONObject2);
                arrayList.add(new com.bytedance.sdk.openadsdk.EjP.vS(sj2.Sj, jSONObject));
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.sP("AdLogParamsGenerate", e11.getMessage());
            }
        }
        return arrayList;
    }

    public JSONObject Sj(List<com.bytedance.sdk.openadsdk.EjP.Sj> list, long j11, JSONObject jSONObject, boolean z10) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Sj(list.get(0), z10);
            jSONObject2.put("header", jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.EjP.Sj> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().Sj(z10));
            }
            if (z10) {
                jSONObject2.put("event_v3", jSONArray);
                jSONObject2.put("magic_tag", "ss_app_log");
            } else {
                jSONObject2.put(NotificationCompat.CATEGORY_EVENT, jSONArray);
            }
            jSONObject2.put("_gen_time", j11);
            jSONObject2.put("local_time", j11 / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public List<com.bytedance.sdk.openadsdk.EjP.Sj> sP(List<com.bytedance.sdk.openadsdk.EjP.Sj> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.EjP.Sj sj2 : list) {
            try {
                JSONObject TKC = sj2.TKC();
                TKC.putOpt("_ad_staging_flag", 1);
                arrayList.add(new com.bytedance.sdk.openadsdk.EjP.Sj(sj2.Sj, TKC));
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.sP("AdLogParamsGenerate", e11.getMessage());
            }
        }
        return arrayList;
    }

    @SuppressLint({"HardwareIds"})
    public JSONObject sP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", Mts.TKC());
            jSONObject.put(Constants.AD_FRAMEWORK_VERSION, BuildConfig.VERSION_NAME);
            jSONObject.put("app_version", Mts.Jcg());
            jSONObject.put("sim_op", Sj(this.TKC));
            jSONObject.put("root", this.EjP ? 1 : 0);
            jSONObject.put("timezone", EjP());
            jSONObject.put("access", zR.Sj(this.TKC));
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_type", this.HiB);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put(TmcConstants.KEY_LANGUAGE, Locale.getDefault().getLanguage());
            jSONObject.put("resolution", FPG.HiB(this.TKC) + "x" + FPG.TKC(this.TKC));
            jSONObject.put("display_density", Sj(FPG.uA(this.TKC)));
            jSONObject.put("density_dpi", FPG.uA(this.TKC));
            jSONObject.put("aid", "1371");
            jSONObject.put("device_id", com.bytedance.sdk.openadsdk.core.aa.Sj(this.TKC));
            jSONObject.put("rom", vS());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("ut", this.sP);
            jSONObject.put(CommonUtils.PARAM_UID, this.Sj);
            jSONObject.put("google_aid", com.bytedance.sdk.openadsdk.RiZ.Sj.sP.Sj.Sj().sP());
            jSONObject.put("locale_language", DeviceUtils.EjP());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.HiB() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", !DeviceUtils.sP() ? 1 : 0);
            com.bytedance.sdk.openadsdk.core.settings.vS EjP = dNu.EjP();
            jSONObject.put("force_language", ib.Sj(this.TKC, "tt_choose_language"));
            if (EjP.LqL("mnc")) {
                jSONObject.put("mnc", ley.TKC());
            }
            if (EjP.LqL("mcc")) {
                jSONObject.put("mcc", ley.sP());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
