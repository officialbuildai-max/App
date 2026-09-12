package com.bytedance.adsdk.ugeno.Sj;

import android.text.TextUtils;
import android.util.Pair;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.Sj.sP;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TKC {
    public static sP.Sj EjP(String str) {
        JSONArray Sj;
        if (TextUtils.isEmpty(str) || (Sj = com.bytedance.adsdk.ugeno.Jcg.sP.Sj(str, (JSONArray) null)) == null || Sj.length() != 2) {
            return null;
        }
        sP.Sj sj2 = new sP.Sj();
        sj2.Sj = Sj.optString(0);
        sj2.sP = Sj.optString(1);
        return sj2;
    }

    public static int Sj(int i11) {
        if (i11 < 0) {
            return -1;
        }
        if (i11 == 0) {
            return 1;
        }
        return i11 - 1;
    }

    public static int Sj(String str) {
        int hashCode = str.hashCode();
        if (hashCode == -1408024454) {
            return str.equals("alternate") ? 2 : 1;
        }
        if (hashCode != -1039745817) {
            return 1;
        }
        str.equals("normal");
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0035, code lost:
    
        if (r6.equals(com.cloud.tmc.integration.constants.IntegrationConstants.TAB_BAR_POSITION_TOP) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int Sj(java.lang.String r6, int r7) {
        /*
            r0 = 1
            r1 = 0
            r2 = 2
            int r3 = r7 / 2
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 == 0) goto Lc
            return r3
        Lc:
            r6.hashCode()
            r4 = -1
            int r5 = r6.hashCode()
            switch(r5) {
                case -1383228885: goto L43;
                case -1364013995: goto L38;
                case 115029: goto L2f;
                case 3317767: goto L24;
                case 108511772: goto L19;
                default: goto L17;
            }
        L17:
            r2 = r4
            goto L4d
        L19:
            java.lang.String r2 = "right"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L22
            goto L17
        L22:
            r2 = 4
            goto L4d
        L24:
            java.lang.String r2 = "left"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L2d
            goto L17
        L2d:
            r2 = 3
            goto L4d
        L2f:
            java.lang.String r5 = "top"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L4d
            goto L17
        L38:
            java.lang.String r2 = "center"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L41
            goto L17
        L41:
            r2 = r0
            goto L4d
        L43:
            java.lang.String r2 = "bottom"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L4c
            goto L17
        L4c:
            r2 = r1
        L4d:
            switch(r2) {
                case 0: goto L75;
                case 1: goto L74;
                case 2: goto L73;
                case 3: goto L73;
                case 4: goto L75;
                default: goto L50;
            }
        L50:
            java.lang.String r2 = "%"
            boolean r2 = r6.endsWith(r2)
            if (r2 == 0) goto L6d
            int r2 = r6.length()     // Catch: java.lang.NumberFormatException -> L6c
            int r2 = r2 - r0
            java.lang.String r6 = r6.substring(r1, r2)     // Catch: java.lang.NumberFormatException -> L6c
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.NumberFormatException -> L6c
            float r7 = (float) r7
            float r7 = r7 * r6
            r6 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 / r6
            int r6 = (int) r7
            return r6
        L6c:
            return r3
        L6d:
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.NumberFormatException -> L72
            return r6
        L72:
            return r3
        L73:
            return r1
        L74:
            return r3
        L75:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.Sj.TKC.Sj(java.lang.String, int):int");
    }

    public static sP Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        sP sPVar = new sP();
        sPVar.sP(jSONObject.optLong("delay"));
        sPVar.Sj(jSONObject.optLong("duration"));
        sPVar.Sj(jSONObject.optInt("playCount", 1));
        sPVar.Sj(jSONObject.optString("playDirection"));
        sPVar.Sj(EjP(jSONObject.optString("transformOrigin")));
        sPVar.sP(jSONObject.optString("timingFunction", "linear"));
        sPVar.Sj(jSONObject.optJSONObject("effect"));
        sPVar.Sj(Sj(jSONObject.optJSONArray("keyframes")));
        return sPVar;
    }

    public static Map<String, TreeMap<Float, String>> Sj(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
            if (optJSONObject != null) {
                float optDouble = (float) optJSONObject.optDouble("offset");
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    TreeMap treeMap = (TreeMap) hashMap.get(next);
                    if (!TextUtils.equals(next, "offset")) {
                        if (!hashMap.containsKey(next) || treeMap == null) {
                            TreeMap treeMap2 = new TreeMap();
                            new Pair(Float.valueOf(optDouble), optJSONObject.optString(next));
                            treeMap2.put(Float.valueOf(optDouble), optJSONObject.optString(next));
                            hashMap.put(next, treeMap2);
                        } else {
                            treeMap.put(Float.valueOf(optDouble), optJSONObject.optString(next));
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static float[] TKC(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray Sj = com.bytedance.adsdk.ugeno.Jcg.sP.Sj(str, (JSONArray) null);
        if (Sj != null && Sj.length() == 2) {
            fArr[0] = (float) Sj.optDouble(0);
            fArr[1] = (float) Sj.optDouble(1);
        }
        return fArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Interpolator sP(String str) {
        char c11;
        switch (str.hashCode()) {
            case -1965072618:
                if (str.equals("ease_in")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case -787702915:
                if (str.equals("ease_out")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case 1065009829:
                if (str.equals("ease_in_out")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        return c11 != 0 ? c11 != 1 ? c11 != 2 ? new LinearInterpolator() : new DecelerateInterpolator() : new AccelerateDecelerateInterpolator() : new AccelerateInterpolator();
    }
}
