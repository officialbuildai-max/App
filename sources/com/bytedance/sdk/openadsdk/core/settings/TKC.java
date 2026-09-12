package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.utils.LD;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TKC {
    private static final ConcurrentHashMap<String, sP> Sj = new ConcurrentHashMap<>();

    @NonNull
    public static sP Sj(String str) {
        sP sPVar = Sj.get(str);
        return sPVar == null ? sP(str) : sPVar;
    }

    private static sP Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new sP(jSONObject);
    }

    public static void Sj() {
        File sP = sP();
        if (sP.exists()) {
            sP.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void Sj(org.json.JSONArray r5) {
        /*
            if (r5 != 0) goto L3
            return
        L3:
            java.io.File r0 = sP()
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r0.getParent()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.getName()
            r3.append(r4)
            java.lang.String r4 = ".tmp"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3)
            r2 = 0
            boolean r3 = r1.exists()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            if (r3 == 0) goto L35
            r1.delete()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            goto L35
        L30:
            r5 = move-exception
            goto La9
        L33:
            r0 = move-exception
            goto L65
        L35:
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r3.write(r2)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r1.renameTo(r0)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r0 = "tt_sdk_settings"
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.dNu.Sj()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            com.bytedance.sdk.openadsdk.utils.LD r0 = com.bytedance.sdk.openadsdk.utils.LD.Sj(r0, r2)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r2 = "ad_slot_conf"
            r0.Sj(r2)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            boolean r0 = r1.exists()
            if (r0 == 0) goto L5c
            r1.delete()
        L5c:
            com.bytedance.sdk.openadsdk.utils.aa.Sj(r3)
            goto L78
        L60:
            r5 = move-exception
            r2 = r3
            goto La9
        L63:
            r0 = move-exception
            r2 = r3
        L65:
            java.lang.String r3 = "SdkSettings.AdSlot"
            java.lang.String r4 = "saveAdSlotToLocal: "
            android.util.Log.e(r3, r4, r0)     // Catch: java.lang.Throwable -> L30
            boolean r0 = r1.exists()
            if (r0 == 0) goto L75
            r1.delete()
        L75:
            com.bytedance.sdk.openadsdk.utils.aa.Sj(r2)
        L78:
            java.util.HashMap r5 = sP(r5)
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto La8
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L8a:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto La8
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            com.bytedance.sdk.openadsdk.core.settings.sP r0 = (com.bytedance.sdk.openadsdk.core.settings.sP) r0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bytedance.sdk.openadsdk.core.settings.sP> r2 = com.bytedance.sdk.openadsdk.core.settings.TKC.Sj
            r2.put(r1, r0)
            goto L8a
        La8:
            return
        La9:
            boolean r0 = r1.exists()
            if (r0 == 0) goto Lb2
            r1.delete()
        Lb2:
            com.bytedance.sdk.openadsdk.utils.aa.Sj(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.TKC.Sj(org.json.JSONArray):void");
    }

    public static void Sj(boolean z10) {
        File sP = sP();
        if (sP.exists()) {
            try {
                HashMap<String, sP> sP2 = sP(new JSONArray(new String(com.bytedance.sdk.component.utils.Jcg.EjP(sP))));
                if (sP2.isEmpty()) {
                    return;
                }
                for (Map.Entry<String, sP> entry : sP2.entrySet()) {
                    Sj.put(entry.getKey(), entry.getValue());
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        String sP3 = com.bytedance.sdk.openadsdk.multipro.sP.TKC() ? com.bytedance.sdk.openadsdk.multipro.EjP.Sj.sP("tt_sdk_settings", "ad_slot_conf", null) : LD.Sj("tt_sdk_settings", dNu.Sj()).Sj("ad_slot_conf", (String) null);
        if (TextUtils.isEmpty(sP3)) {
            return;
        }
        try {
            HashMap<String, sP> sP4 = sP(new JSONArray(sP3));
            if (sP4.isEmpty()) {
                return;
            }
            ConcurrentHashMap<String, sP> concurrentHashMap = Sj;
            concurrentHashMap.clear();
            concurrentHashMap.putAll(sP4);
        } catch (Exception unused2) {
        }
    }

    private static sP sP(String str) {
        return new sP(str, 1);
    }

    @NonNull
    private static File sP() {
        return new File(dNu.Sj().getFilesDir(), "tt_ads_conf_sr");
    }

    @NonNull
    private static HashMap<String, sP> sP(JSONArray jSONArray) {
        HashMap<String, sP> hashMap = new HashMap<>();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                sP Sj2 = Sj(jSONArray.getJSONObject(i11));
                if (Sj2 != null) {
                    hashMap.put(Sj2.Sj, Sj2);
                }
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }
}
