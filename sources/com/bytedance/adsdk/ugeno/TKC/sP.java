package com.bytedance.adsdk.ugeno.TKC;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.HiB;
import com.bytedance.adsdk.ugeno.TKC.Sj;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class sP {
    public static String Sj(String str, JSONObject jSONObject) {
        Sj TKC;
        Sj.InterfaceC0210Sj Sj;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith("}") || (TKC = HiB.Sj().TKC()) == null || (Sj = TKC.Sj(str.substring(2, str.length() + (-1)))) == null) ? str : (String) Sj.Sj(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return str;
    }
}
