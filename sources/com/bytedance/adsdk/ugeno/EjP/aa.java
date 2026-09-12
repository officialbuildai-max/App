package com.bytedance.adsdk.ugeno.EjP;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.EjP.vS;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class aa {
    public static vS.Sj Sj(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        vS.Sj sj2 = new vS.Sj();
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        sj2.TKC(str);
        if (!TextUtils.isEmpty(parse.getScheme())) {
            sj2.Sj(parse.getScheme());
        }
        String authority = parse.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = parse.getPath();
        }
        sj2.sP(authority);
        sj2.EjP(sj2.Sj() + "://" + sj2.sP());
        HashMap hashMap = new HashMap();
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                hashMap.put(str2, com.bytedance.adsdk.ugeno.TKC.sP.Sj(parse.getQueryParameter(str2), jSONObject));
            }
        }
        sj2.Sj(hashMap);
        return sj2;
    }
}
