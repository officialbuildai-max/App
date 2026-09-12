package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.k0;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class k {
    public static JSONObject a(Context context, com.mbridge.msdk.setting.g gVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            String p11 = k0.p();
            if (!TextUtils.isEmpty(p11)) {
                jSONObject.put("manufacturer", p11);
            }
            int m11 = k0.m();
            if (m11 != -1) {
                jSONObject.put("sdkint", m11);
            }
            String x10 = k0.x(context);
            if (!TextUtils.isEmpty(x10)) {
                jSONObject.put("is24H", x10);
            }
            String x11 = k0.x();
            if (!TextUtils.isEmpty(x11)) {
                jSONObject.put("totalram", x11);
            }
            String y10 = k0.y(context);
            if (!TextUtils.isEmpty(y10)) {
                jSONObject.put("totalmemory", y10);
            }
            jSONObject.put("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
            jSONObject.put("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? "1" : "0");
        }
        if (gVar.s0() == 1 && !TextUtils.isEmpty(com.mbridge.msdk.foundation.tools.f.e()) && com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            jSONObject.put("az_aid_info", com.mbridge.msdk.foundation.tools.f.e());
        }
        return jSONObject;
    }

    public static void a(com.mbridge.msdk.foundation.same.net.wrapper.e eVar, Context context) {
    }
}
