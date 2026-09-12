package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.EjP.sP;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TzV {
    public static void Sj(Context context, boolean z10, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.sU sUVar, String str, int i11, WebView webView, com.bytedance.sdk.openadsdk.core.widget.HiB hiB) {
        int optInt = jSONObject.optInt("landingStyle");
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("fallback_url");
        try {
            jSONObject.put("is_activity", z10);
        } catch (JSONException unused) {
        }
        boolean z11 = true;
        com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sUVar, str, 1, jSONObject);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        if (optInt == 0) {
            if (webView != null) {
                webView.loadUrl(optString);
                com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sUVar, str, 2, (JSONObject) null);
            } else {
                com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sUVar, str, -1, (JSONObject) null);
            }
        } else if (optInt == 1 || optInt == 8) {
            com.bytedance.sdk.openadsdk.Zq.Sj.sP sPVar = new com.bytedance.sdk.openadsdk.Zq.Sj.sP();
            sPVar.Sj(sP.Sj.sP);
            sPVar.Sj(sUVar);
            sPVar.sP(str);
            sPVar.Sj(-1);
            sPVar.Sj(false);
            sPVar.sP(sUVar.sdp());
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sPVar);
            com.bytedance.sdk.openadsdk.utils.dx.Sj(context, optString, sUVar, sP.Sj.sP);
        } else if (optInt == 2) {
            if (!com.bytedance.sdk.openadsdk.utils.dx.sP(context, optString, sUVar, str)) {
                com.bytedance.sdk.openadsdk.Zq.Sj.sP sPVar2 = new com.bytedance.sdk.openadsdk.Zq.Sj.sP();
                sPVar2.Sj(sP.Sj.sP);
                sPVar2.Sj(sUVar);
                sPVar2.sP(str);
                sPVar2.Sj(-1);
                sPVar2.Sj(false);
                sPVar2.sP(sUVar.sdp());
                com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sPVar2);
                HashMap hashMap = new HashMap();
                hashMap.put("deeplink_url", optString);
                hashMap.put("fallback_url", optString2);
                hashMap.put("jsb_deeplink", 1);
                com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sUVar, str, "open_fallback_url", hashMap);
                com.bytedance.sdk.openadsdk.utils.dx.Sj(context, optString2, sUVar, sP.Sj.sP);
            }
        } else if (optInt != 3) {
            z11 = false;
        } else if (fF.sP(context, optString, sUVar, i11, str, false)) {
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sUVar, str, 3, (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sUVar, str, -2, (JSONObject) null);
        }
        if (hiB == null || !z11) {
            return;
        }
        hiB.Sj();
    }
}
