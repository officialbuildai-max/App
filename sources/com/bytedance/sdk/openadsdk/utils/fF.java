package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;

/* loaded from: classes3.dex */
public class fF {
    private static String Sj;

    public static String Sj(String str) {
        try {
            if (!Sj()) {
                return str;
            }
            String zR = com.bytedance.sdk.openadsdk.core.uA.sP().zR();
            if (TextUtils.isEmpty(zR)) {
                return str;
            }
            "AnyDoorId=".concat(String.valueOf(zR));
            return Uri.parse(str).buildUpon().appendQueryParameter(sP(), zR).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean Sj() {
        return com.bytedance.sdk.component.utils.Zq.EjP() && com.bytedance.sdk.openadsdk.core.uA.sP().RiZ() && com.bytedance.sdk.openadsdk.core.uA.sP().dx();
    }

    public static boolean TKC() {
        return false;
    }

    public static String sP() {
        if (TextUtils.isEmpty(Sj)) {
            Sj = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return Sj;
    }
}
