package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cloud.tmc.integration.event.EventConstants;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aa {
    private static boolean EjP;
    private static String Sj;
    private static String TKC;
    private static String sP;

    private static Context EjP(Context context) {
        return context == null ? dNu.Sj() : context;
    }

    @SuppressLint({"HardwareIds"})
    private static void HiB(Context context) {
        Context EjP2;
        if (EjP || (EjP2 = EjP(context)) == null) {
            return;
        }
        sP = String.valueOf(Build.TIME);
        TKC = TKC.Sj(EjP2).sP("uuid", (String) null);
        EjP = true;
    }

    public static String Sj(Context context) {
        if (!TextUtils.isEmpty(Sj)) {
            return Sj;
        }
        vS(context);
        return Sj;
    }

    public static void Sj() {
        if (TextUtils.isEmpty(Sj)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.JcM.sP(new com.bytedance.sdk.component.Dq.Dq("update_did") { // from class: com.bytedance.sdk.openadsdk.core.aa.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EventConstants.KEY_TIME, SystemClock.elapsedRealtime());
                    jSONObject.put("abcd", aa.Sj);
                    TKC.Sj(dNu.Sj()).Sj("abcd", com.bytedance.sdk.component.utils.Sj.Sj(jSONObject).toString());
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void Sj(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(Sj)) {
                Sj = str;
            }
            Sj();
        }
        if (TextUtils.isEmpty(Sj)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.uA.TKC.sP(Sj);
        Ym.Sj(Sj);
    }

    public static String TKC(Context context) {
        if (TextUtils.isEmpty(TKC) && !EjP) {
            synchronized (aa.class) {
                try {
                    if (!EjP) {
                        HiB(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return TKC;
    }

    public static String sP() {
        Locale locale;
        LocaleList localeList;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                localeList = LocaleList.getDefault();
                locale = localeList.get(0);
            } else {
                locale = Locale.getDefault();
            }
            String language = locale != null ? locale.getLanguage() : "";
            if (locale == null || !"zh".equals(language)) {
                return language;
            }
            String locale2 = locale.toString();
            if (locale.toString().length() >= 5) {
                locale2 = locale2.substring(0, 5);
            }
            return Locale.SIMPLIFIED_CHINESE.toString().equals(locale2) ? "zh" : "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String sP(Context context) {
        if (sP == null && !EjP) {
            synchronized (aa.class) {
                try {
                    if (!EjP) {
                        HiB(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return sP;
    }

    private static void vS(Context context) {
        Context EjP2 = EjP(context);
        if (EjP2 == null) {
            return;
        }
        String sP2 = TKC.Sj(EjP2).sP("abcd", (String) null);
        if (TextUtils.isEmpty(sP2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(sP2);
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString("message");
            if (optInt == 3) {
                String TKC2 = com.bytedance.sdk.component.utils.Sj.TKC(optString);
                if (TextUtils.isEmpty(TKC2)) {
                    return;
                }
                Sj = new JSONObject(TKC2).optString("abcd");
                Sj();
            }
        } catch (Throwable unused) {
        }
    }
}
