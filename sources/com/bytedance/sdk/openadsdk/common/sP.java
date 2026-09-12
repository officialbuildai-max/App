package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.cloud.tmc.kernel.constants.TmcConstants;

/* loaded from: classes2.dex */
public class sP {
    private static String Sj;

    public static String EjP() {
        return Mts.Jcg();
    }

    public static String HiB() {
        return com.bytedance.sdk.openadsdk.core.uA.sP().Dq();
    }

    public static String Jcg() {
        try {
            if (!TextUtils.isEmpty(Sj)) {
                return Sj;
            }
            String Sj2 = com.bytedance.sdk.openadsdk.core.uA.Sj("sdk_app_sha1", TmcConstants.MINIAPP_TIME_DIFF);
            Sj = Sj2;
            if (Sj(Sj2)) {
                return Sj;
            }
            String Sj3 = com.bytedance.sdk.component.utils.TKC.Sj(com.bytedance.sdk.openadsdk.core.dNu.Sj());
            Sj = Sj3;
            if (!Sj(Sj3)) {
                return "";
            }
            String upperCase = Sj.toUpperCase();
            Sj = upperCase;
            com.bytedance.sdk.openadsdk.core.uA.Sj("sdk_app_sha1", upperCase);
            return Sj;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String Sj() {
        return "open_news";
    }

    public static String Sj(Context context) {
        return com.bytedance.sdk.openadsdk.core.aa.Sj(context);
    }

    private static boolean Sj(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length < 20) {
            return false;
        }
        for (String str2 : split) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String TKC() {
        return BuildConfig.VERSION_NAME;
    }

    public static String sP() {
        return "1371";
    }

    public static String vS() {
        return com.bytedance.sdk.component.utils.TzV.Jcg(com.bytedance.sdk.openadsdk.core.dNu.Sj());
    }
}
