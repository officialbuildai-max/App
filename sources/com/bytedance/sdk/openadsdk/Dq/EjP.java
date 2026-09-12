package com.bytedance.sdk.openadsdk.Dq;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.fF;
import java.util.Map;

/* loaded from: classes2.dex */
public final class EjP extends Sj {
    public static TKC Sj;

    public static String Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, String str) {
        TKC Sj2;
        Map map;
        if (!fF.TKC() || (Sj2 = sP.Sj("net")) == null || (map = (Map) Sj2.Sj(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                tkc.sP(str3, (String) map2.get(str3));
            }
        }
        return str;
    }
}
