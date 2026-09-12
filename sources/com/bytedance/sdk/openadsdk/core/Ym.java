package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.utils.wE;
import com.bytedance.sdk.openadsdk.utils.Mts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Ym {
    private static final AtomicInteger Sj = new AtomicInteger(0);
    private static final AtomicBoolean sP = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Sj implements wE.Sj {
        private static final AtomicBoolean Sj = new AtomicBoolean(false);
        private static volatile long sP = -1;

        private Sj() {
        }

        public static void Sj() {
            if (Sj.compareAndSet(false, true)) {
                sP = System.currentTimeMillis();
                com.bytedance.sdk.component.utils.wE.Sj(new Sj(), dNu.Sj());
            }
        }

        @Override // com.bytedance.sdk.component.utils.wE.Sj
        public void Sj(Context context, Intent intent, boolean z10, int i11) {
            if (System.currentTimeMillis() - sP >= 2000 && i11 != 0) {
                Ym.TKC();
                Ym.sP(aa.Sj(dNu.Sj()));
                sP();
            }
        }

        public void sP() {
            com.bytedance.sdk.component.utils.wE.Sj(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void EjP() {
        if (Sj.getAndIncrement() <= 0) {
            com.bytedance.sdk.openadsdk.utils.JcM.Sj().schedule(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ym.2
                @Override // java.lang.Runnable
                public void run() {
                    Ym.sP(aa.Sj(dNu.Sj()));
                }
            }, 10000L, TimeUnit.MILLISECONDS);
        }
    }

    public static void Sj(String str) {
        AtomicBoolean atomicBoolean = sP;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (!com.bytedance.sdk.component.utils.TzV.Dq(dNu.Sj())) {
                atomicBoolean.set(false);
            } else {
                Sj.Sj();
                sP(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void TKC() {
        Sj.set(0);
    }

    public static void sP(final String str) {
        com.bytedance.sdk.openadsdk.utils.JcM.TKC(new com.bytedance.sdk.component.Dq.Dq("ipv6") { // from class: com.bytedance.sdk.openadsdk.core.Ym.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject Sj2;
                final String sef = Mts.sef();
                com.bytedance.sdk.openadsdk.Zq.TKC.Sj(0, sef);
                if (TextUtils.isEmpty(sef)) {
                    com.bytedance.sdk.openadsdk.Zq.TKC.Sj(-1, sef, -1, "url is null");
                    return;
                }
                com.bytedance.sdk.component.Jcg.sP.EjP sP2 = com.bytedance.sdk.openadsdk.TzV.sP.Sj().sP().sP();
                try {
                    sP2.sP(sef);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("connect_type", com.bytedance.sdk.component.utils.wE.Sj(dNu.Sj(), 0L));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("device_id", Long.parseLong(str));
                    }
                    jSONObject.put("header", com.bytedance.sdk.openadsdk.EjP.Sj.TKC.Sj().sP());
                    if (com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().Sj(PangleEncryptConstant.CryptDataScene.APP_LOG)) {
                        Sj2 = PangleEncryptManager.encryptType4(jSONObject, new dx(PangleEncryptConstant.CryptDataScene.DUAL_EVENT));
                        if (Sj2 == null || Sj2.optInt("cypher") != 4) {
                            zR.sP(false);
                        } else {
                            zR.sP(true);
                            sP2.sP("x-pgli18n", "4");
                            sP2.sP(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                        }
                    } else {
                        Sj2 = com.bytedance.sdk.component.utils.Sj.Sj(jSONObject);
                        if (Ym.sP(Sj2)) {
                            sP2.sP(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                        }
                    }
                    if (Ym.sP(Sj2)) {
                        jSONObject = Sj2;
                    }
                    sP2.sP(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                    sP2.sP("User-Agent", Mts.TKC());
                    sP2.Sj(jSONObject);
                    sP2.Sj(6);
                    sP2.Sj("send_i_p_v6");
                    sP2.Sj(new com.bytedance.sdk.component.Jcg.Sj.Sj() { // from class: com.bytedance.sdk.openadsdk.core.Ym.1.1
                        @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                        public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, com.bytedance.sdk.component.Jcg.sP sPVar) {
                            if (sPVar.vS()) {
                                Ym.sP(sPVar.EjP(), sef);
                            } else {
                                com.bytedance.sdk.openadsdk.Zq.TKC.Sj(-1, sef, sPVar.Sj(), sPVar.sP());
                                Ym.EjP();
                            }
                        }

                        @Override // com.bytedance.sdk.component.Jcg.Sj.Sj
                        public void Sj(com.bytedance.sdk.component.Jcg.sP.TKC tkc, IOException iOException) {
                            if (iOException != null) {
                                com.bytedance.sdk.openadsdk.Zq.TKC.Sj(-1, sef, 1, iOException.getMessage());
                            }
                            Ym.EjP();
                        }
                    });
                } catch (Exception e11) {
                    com.bytedance.sdk.openadsdk.Zq.TKC.Sj(-1, sef, -2, e11.getMessage());
                    com.bytedance.sdk.component.utils.sU.sP("build ipv6 request failed:" + e11.getMessage(), new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096 A[Catch: JSONException -> 0x00d3, TryCatch #0 {JSONException -> 0x00d3, blocks: (B:3:0x0002, B:5:0x0011, B:8:0x0017, B:10:0x0025, B:22:0x0077, B:25:0x007e, B:27:0x0084, B:29:0x0092, B:31:0x0096, B:33:0x009c, B:35:0x00b9, B:37:0x0048, B:40:0x0052, B:43:0x005c, B:46:0x00bd), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void sP(java.lang.String r10, java.lang.String r11) {
        /*
            r0 = 2
            r1 = -1
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> Ld3
            r2.<init>(r10)     // Catch: org.json.JSONException -> Ld3
            java.lang.String r10 = "cypher"
            int r10 = r2.optInt(r10)     // Catch: org.json.JSONException -> Ld3
            r3 = 4
            r4 = 1
            if (r10 == r3) goto L17
            java.lang.String r10 = "cypher type error"
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(r1, r11, r4, r10)     // Catch: org.json.JSONException -> Ld3
            return
        L17:
            java.lang.String r10 = "message"
            java.lang.String r10 = r2.optString(r10)     // Catch: org.json.JSONException -> Ld3
            android.util.Pair r10 = com.bytedance.sdk.component.embedapplog.PangleEncryptManager.decryptType4(r10)     // Catch: org.json.JSONException -> Ld3
            java.lang.Object r2 = r10.second     // Catch: org.json.JSONException -> Ld3
            if (r2 == 0) goto Lbd
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> Ld3
            java.lang.Object r10 = r10.second     // Catch: org.json.JSONException -> Ld3
            java.lang.String r10 = (java.lang.String) r10     // Catch: org.json.JSONException -> Ld3
            r2.<init>(r10)     // Catch: org.json.JSONException -> Ld3
            java.lang.String r10 = "ip_type"
            java.lang.String r10 = r2.optString(r10)     // Catch: org.json.JSONException -> Ld3
            int r5 = r10.hashCode()     // Catch: org.json.JSONException -> Ld3
            r6 = 3239397(0x316de5, float:4.539362E-39)
            if (r5 == r6) goto L5c
            r6 = 3239399(0x316de7, float:4.539365E-39)
            if (r5 == r6) goto L52
            r6 = 1959784951(0x74cff1f7, float:1.3180091E32)
            if (r5 == r6) goto L48
            goto L66
        L48:
            java.lang.String r5 = "invalid"
            boolean r10 = r10.equals(r5)     // Catch: org.json.JSONException -> Ld3
            if (r10 == 0) goto L66
            r10 = r0
            goto L67
        L52:
            java.lang.String r5 = "ipv6"
            boolean r10 = r10.equals(r5)     // Catch: org.json.JSONException -> Ld3
            if (r10 == 0) goto L66
            r10 = 0
            goto L67
        L5c:
            java.lang.String r5 = "ipv4"
            boolean r10 = r10.equals(r5)     // Catch: org.json.JSONException -> Ld3
            if (r10 == 0) goto L66
            r10 = r4
            goto L67
        L66:
            r10 = r1
        L67:
            java.lang.String r5 = "no ip"
            java.lang.String r6 = "key_ipv4"
            java.lang.String r7 = "key_ipv6"
            java.lang.String r8 = "ttopenadsdk"
            java.lang.String r9 = "ip"
            if (r10 == 0) goto L96
            if (r10 == r4) goto L7e
            if (r10 == r0) goto L7d
            java.lang.String r10 = "no ip type "
            r2 = 3
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(r1, r11, r2, r10)     // Catch: org.json.JSONException -> Ld3
        L7d:
            return
        L7e:
            boolean r10 = r2.has(r9)     // Catch: org.json.JSONException -> Ld3
            if (r10 == 0) goto L92
            java.lang.String r10 = r2.optString(r9)     // Catch: org.json.JSONException -> Ld3
            com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(r8, r6, r10)     // Catch: org.json.JSONException -> Ld3
            com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(r8, r7)     // Catch: org.json.JSONException -> Ld3
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(r4, r11)     // Catch: org.json.JSONException -> Ld3
            return
        L92:
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(r1, r11, r3, r5)     // Catch: org.json.JSONException -> Ld3
            return
        L96:
            boolean r10 = r2.has(r9)     // Catch: org.json.JSONException -> Ld3
            if (r10 == 0) goto Lb9
            java.lang.String r10 = r2.optString(r9)     // Catch: org.json.JSONException -> Ld3
            com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(r8, r7, r10)     // Catch: org.json.JSONException -> Ld3
            com.bytedance.sdk.openadsdk.multipro.EjP.EjP.Sj(r8, r6)     // Catch: org.json.JSONException -> Ld3
            java.util.HashMap r2 = new java.util.HashMap     // Catch: org.json.JSONException -> Ld3
            r2.<init>()     // Catch: org.json.JSONException -> Ld3
            r2.put(r7, r10)     // Catch: org.json.JSONException -> Ld3
            com.bytedance.sdk.openadsdk.core.uA.sP r10 = com.bytedance.sdk.openadsdk.core.uA.sP.sP()     // Catch: org.json.JSONException -> Ld3
            r10.Sj(r2)     // Catch: org.json.JSONException -> Ld3
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(r4, r11)     // Catch: org.json.JSONException -> Ld3
            return
        Lb9:
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(r1, r11, r3, r5)     // Catch: org.json.JSONException -> Ld3
            return
        Lbd:
            java.lang.Object r10 = r10.first     // Catch: org.json.JSONException -> Ld3
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch: org.json.JSONException -> Ld3
            int r10 = r10.intValue()     // Catch: org.json.JSONException -> Ld3
            java.lang.String r2 = "decrypt failed "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: org.json.JSONException -> Ld3
            java.lang.String r10 = r2.concat(r10)     // Catch: org.json.JSONException -> Ld3
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(r1, r11, r0, r10)     // Catch: org.json.JSONException -> Ld3
            return
        Ld3:
            java.lang.String r10 = "decrypt failed, wrong data "
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(r1, r11, r0, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Ym.sP(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean sP(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }
}
