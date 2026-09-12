package com.bytedance.sdk.openadsdk.RiZ.Sj.Sj;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.EjP.aa;
import com.bytedance.sdk.openadsdk.utils.Mts;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* loaded from: classes2.dex */
public class sP {
    private static Intent Sj(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(ASTNode.DEOP);
            }
            return intent;
        } catch (Throwable th2) {
            sU.sP("DeepLinkUtils", th2.getMessage());
            return null;
        }
    }

    private static void Sj(Context context, com.bytedance.sdk.openadsdk.core.model.sU sUVar, Map<String, Object> map) {
        if (sUVar != null && sUVar.AE() == 0) {
            map.put("auto_click", Boolean.valueOf(!sUVar.Dq()));
        }
        map.put("can_query_install", Integer.valueOf(Mts.Dq(context) ? 1 : 0));
    }

    public static boolean Sj(Context context, String str, com.bytedance.sdk.openadsdk.core.model.sU sUVar) {
        String Sj = Mts.Sj(sUVar);
        com.bytedance.sdk.openadsdk.core.EjP.Sj(sUVar, Sj, 1, null);
        Intent Sj2 = Sj(context, str);
        if (TextUtils.isEmpty(str) || Sj2 == null) {
            com.bytedance.sdk.openadsdk.core.EjP.Sj(sUVar, Sj, -2, sUVar.TFd().EjP());
            return false;
        }
        boolean Dq = Mts.Dq(context);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        if (Dq) {
            Mts.sP Sj3 = Mts.Sj(context, Sj2);
            if (Sj3.sP <= 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("intent", Sj2.toString());
                    jSONObject.put("can_query_install", 1);
                } catch (Exception unused) {
                }
                com.bytedance.sdk.openadsdk.core.EjP.Sj(sUVar, Sj, -3, jSONObject);
                return false;
            }
            try {
                Sj(context, sUVar, hashMap);
                hashMap.put("matched_count", Integer.valueOf(Sj3.sP));
                ComponentName componentName = Sj3.Sj;
                if (componentName != null) {
                    Sj2.setComponent(componentName);
                }
            } catch (Throwable th2) {
                sU.sP("DeepLinkUtils", th2.getMessage());
            }
        }
        try {
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(sUVar, Sj, "open_url_app", hashMap);
            context.startActivity(Sj2);
            aa.Sj().Sj(hashMap).Sj(sUVar, Sj);
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj("dp_start_act_success", sUVar, Sj, hashMap);
            return true;
        } catch (Throwable th3) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("exception", th3.getMessage());
                jSONObject2.put("intent", Sj2.toString());
                jSONObject2.put("can_query_install", Dq ? 1 : 0);
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.EjP.Sj(sUVar, Sj, -4, jSONObject2);
            return false;
        }
    }
}
