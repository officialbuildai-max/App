package com.bytedance.adsdk.ugeno.core;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HiB {
    private JSONObject EjP;
    private String HiB;
    private boolean Jcg;
    private JSONObject Sj;
    private String TKC;
    private JSONObject sP;
    private JSONObject vS;

    /* loaded from: classes2.dex */
    public static class Sj {
        private String Dq;
        private JSONObject EjP;
        private List<Sj> HiB;
        private String Jcg;
        private String Sj;
        private JSONObject TKC;
        private String sP;
        private Sj vS;

        public JSONObject EjP() {
            return this.TKC;
        }

        public List<Sj> HiB() {
            return this.HiB;
        }

        public String Sj() {
            return this.Sj;
        }

        public void Sj(Sj sj2) {
            if (this.HiB == null) {
                this.HiB = new ArrayList();
            }
            this.HiB.add(sj2);
        }

        public void Sj(String str) {
            this.sP = str;
        }

        public String TKC() {
            return this.sP;
        }

        public String sP() {
            return this.Jcg;
        }

        public String toString() {
            return "UGNode{id='" + this.Sj + "', name='" + this.sP + "'}";
        }

        public JSONObject vS() {
            return this.EjP;
        }
    }

    public HiB(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public HiB(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.Sj = jSONObject.optJSONObject(TtmlNode.TAG_BODY);
            } else {
                this.Sj = jSONObject.optJSONObject("main_template");
            }
            this.sP = jSONObject.optJSONObject("sub_templates");
            JSONObject optJSONObject = jSONObject.has("meta") ? jSONObject.optJSONObject("meta") : jSONObject.optJSONObject("template_info");
            if (optJSONObject != null) {
                if (jSONObject.has(TtmlNode.TAG_BODY)) {
                    this.Jcg = true;
                    String optString = optJSONObject.optString("version");
                    this.TKC = optString;
                    if (TextUtils.isEmpty(optString)) {
                        this.TKC = "3.0";
                    }
                } else {
                    this.TKC = optJSONObject.optString("sdk_version");
                }
                if (optJSONObject.has("adType")) {
                    this.HiB = optJSONObject.optString("adType");
                }
            } else if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.TKC = "3.0";
                this.Jcg = true;
            }
            this.EjP = jSONObject2;
            this.vS = jSONObject3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.adsdk.ugeno.core.HiB.Sj Sj(org.json.JSONObject r11, com.bytedance.adsdk.ugeno.core.HiB.Sj r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "type"
            boolean r2 = r11.has(r1)
            java.lang.String r3 = "name"
            if (r2 == 0) goto L13
            java.lang.String r2 = r11.optString(r1)
            goto L17
        L13:
            java.lang.String r2 = r11.optString(r3)
        L17:
            java.lang.String r4 = "id"
            java.lang.String r5 = r11.optString(r4)
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            java.util.Iterator r7 = r11.keys()
        L26:
            boolean r8 = r7.hasNext()
            java.lang.String r9 = "children"
            if (r8 == 0) goto L42
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            boolean r9 = android.text.TextUtils.equals(r8, r9)
            if (r9 != 0) goto L26
            java.lang.Object r9 = r11.opt(r8)     // Catch: org.json.JSONException -> L26
            r6.put(r8, r9)     // Catch: org.json.JSONException -> L26
            goto L26
        L42:
            com.bytedance.adsdk.ugeno.core.HiB$Sj r7 = new com.bytedance.adsdk.ugeno.core.HiB$Sj
            r7.<init>()
            com.bytedance.adsdk.ugeno.core.HiB.Sj.Sj(r7, r5)
            boolean r5 = r10.Jcg
            if (r5 == 0) goto L6b
            java.lang.String r5 = "Video"
            boolean r5 = android.text.TextUtils.equals(r5, r2)
            if (r5 == 0) goto L6b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            java.lang.String r8 = "V3"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            com.bytedance.adsdk.ugeno.core.HiB.Sj.sP(r7, r5)
            goto L6e
        L6b:
            com.bytedance.adsdk.ugeno.core.HiB.Sj.sP(r7, r2)
        L6e:
            com.bytedance.adsdk.ugeno.core.HiB.Sj.Sj(r7, r6)
            com.bytedance.adsdk.ugeno.core.HiB.Sj.Sj(r7, r12)
            java.lang.String r12 = r10.TKC
            com.bytedance.adsdk.ugeno.core.HiB.Sj.TKC(r7, r12)
            java.lang.String r12 = r10.HiB
            com.bytedance.adsdk.ugeno.core.HiB.Sj.EjP(r7, r12)
            java.lang.String r12 = "i18n"
            boolean r5 = r6.has(r12)
            if (r5 == 0) goto L8d
            org.json.JSONObject r12 = r6.optJSONObject(r12)
            com.bytedance.adsdk.ugeno.core.HiB.Sj.sP(r7, r12)
        L8d:
            java.lang.String r12 = "CustomComponent"
            boolean r12 = android.text.TextUtils.equals(r2, r12)
            if (r12 == 0) goto L9c
            org.json.JSONObject r12 = com.bytedance.adsdk.ugeno.core.HiB.Sj.sP(r7)
            r10.Sj(r11, r12)
        L9c:
            org.json.JSONArray r12 = r11.optJSONArray(r9)
            if (r12 == 0) goto Lec
            int r2 = r12.length()
            if (r2 > 0) goto La9
            goto Lec
        La9:
            r2 = 0
        Laa:
            int r5 = r12.length()
            if (r2 >= r5) goto Lec
            org.json.JSONObject r5 = r12.optJSONObject(r2)
            boolean r6 = r11.has(r1)
            if (r6 == 0) goto Lbf
            java.lang.String r6 = r11.optString(r1)
            goto Lc3
        Lbf:
            java.lang.String r6 = r11.optString(r3)
        Lc3:
            java.lang.String r8 = r5.optString(r4)
            org.json.JSONObject r9 = r10.EjP
            java.lang.String r8 = com.bytedance.adsdk.ugeno.TKC.sP.Sj(r8, r9)
            java.lang.String r9 = "Template"
            boolean r6 = android.text.TextUtils.equals(r6, r9)
            if (r6 == 0) goto Le0
            org.json.JSONObject r5 = r10.sP
            if (r5 == 0) goto Lde
            org.json.JSONObject r5 = r5.optJSONObject(r8)
            goto Le0
        Lde:
            r5 = r0
            goto Le4
        Le0:
            com.bytedance.adsdk.ugeno.core.HiB$Sj r5 = r10.Sj(r5, r7)
        Le4:
            if (r5 == 0) goto Le9
            r7.Sj(r5)
        Le9:
            int r2 = r2 + 1
            goto Laa
        Lec:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.core.HiB.Sj(org.json.JSONObject, com.bytedance.adsdk.ugeno.core.HiB$Sj):com.bytedance.adsdk.ugeno.core.HiB$Sj");
    }

    private void Sj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.vS == null || jSONObject2 == null) {
            return;
        }
        try {
            String optString = this.vS.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(optString);
            JSONObject optJSONObject = jSONObject2.optJSONObject("targetProps");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = optJSONObject.opt(next);
                    if (!TextUtils.equals(next, "events") || !jSONObject3.has("events")) {
                        jSONObject3.put(next, opt);
                    } else if (opt instanceof JSONArray) {
                        com.bytedance.adsdk.ugeno.Jcg.sP.Sj(jSONObject3.optJSONArray("events"), (JSONArray) opt);
                    }
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("children");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", optJSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean Sj(Sj sj2) {
        return (sj2 == null || sj2.TKC == null) ? false : true;
    }

    public boolean EjP() {
        return this.Jcg;
    }

    public Sj Sj() {
        return Sj(this.Sj, (Sj) null);
    }

    public List<Sj> TKC() {
        if (this.sP == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.sP.keys();
        while (keys.hasNext()) {
            Sj Sj2 = Sj(this.sP.optJSONObject(keys.next()), (Sj) null);
            if (Sj2 != null) {
                arrayList.add(Sj2);
            }
        }
        return arrayList;
    }

    public String sP() {
        return this.TKC;
    }
}
