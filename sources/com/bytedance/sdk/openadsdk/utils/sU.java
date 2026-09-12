package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class sU {
    public static int Sj = Integer.MIN_VALUE;
    public static final String[] TKC = {"api16-access-ttp.tiktokpangle.us", "api16-access-ttp-b.tiktokpangle.us", "api16-access-ttp.tiktokpangle-b.us", "api16-access-ttp-b.tiktokpangle-b.us"};
    public static int sP = Integer.MIN_VALUE;

    public static String Sj() {
        if (Sj == Integer.MIN_VALUE) {
            Sj = com.bytedance.sdk.openadsdk.core.uA.HiB();
        }
        if (Sj < 0) {
            Sj = 0;
        }
        String[] strArr = TKC;
        try {
            return strArr[Sj % strArr.length];
        } catch (Throwable unused) {
            return strArr[0];
        }
    }

    public static void Sj(com.bytedance.sdk.component.uA.vS vSVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", TTAdConstant.REQUEST_HEAD_REFERER);
        vSVar.Sj(str, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0016, code lost:
    
        r2 = com.bytedance.sdk.openadsdk.utils.sU.Sj + 1;
        com.bytedance.sdk.openadsdk.utils.sU.Sj = r2;
        com.bytedance.sdk.openadsdk.core.uA.Sj(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void Sj(java.lang.String r5) {
        /*
            java.lang.Class<com.bytedance.sdk.openadsdk.utils.sU> r0 = com.bytedance.sdk.openadsdk.utils.sU.class
            monitor-enter(r0)
            if (r5 != 0) goto L7
            monitor-exit(r0)
            return
        L7:
            r1 = 0
            r2 = r1
        L9:
            java.lang.String[] r3 = com.bytedance.sdk.openadsdk.utils.sU.TKC     // Catch: java.lang.Throwable -> L20
            int r4 = r3.length     // Catch: java.lang.Throwable -> L20
            if (r2 >= r4) goto L28
            r3 = r3[r2]     // Catch: java.lang.Throwable -> L20
            boolean r3 = r5.contains(r3)     // Catch: java.lang.Throwable -> L20
            if (r3 == 0) goto L22
            int r2 = com.bytedance.sdk.openadsdk.utils.sU.Sj     // Catch: java.lang.Throwable -> L20
            int r2 = r2 + 1
            com.bytedance.sdk.openadsdk.utils.sU.Sj = r2     // Catch: java.lang.Throwable -> L20
            com.bytedance.sdk.openadsdk.core.uA.Sj(r2)     // Catch: java.lang.Throwable -> L20
            goto L28
        L20:
            r2 = move-exception
            goto L25
        L22:
            int r2 = r2 + 1
            goto L9
        L25:
            r2.getMessage()     // Catch: java.lang.Throwable -> L39
        L28:
            java.lang.String r2 = "/api/ad/union/sdk/settings/"
            boolean r2 = r5.contains(r2)     // Catch: java.lang.Throwable -> L39
            if (r2 != 0) goto L3b
            java.lang.String r2 = "/api/ad/union/sdk/strategies/adn"
            boolean r5 = r5.contains(r2)     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto L75
            goto L3b
        L39:
            r5 = move-exception
            goto L77
        L3b:
            int r5 = com.bytedance.sdk.openadsdk.utils.sU.sP     // Catch: java.lang.Throwable -> L39
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 != r2) goto L47
            int r5 = com.bytedance.sdk.openadsdk.core.uA.vS()     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.utils.sU.sP = r5     // Catch: java.lang.Throwable -> L39
        L47:
            int r5 = com.bytedance.sdk.openadsdk.utils.sU.sP     // Catch: java.lang.Throwable -> L39
            int r5 = r5 + 1
            com.bytedance.sdk.openadsdk.utils.sU.sP = r5     // Catch: java.lang.Throwable -> L39
            r2 = 3
            if (r5 < r2) goto L70
            com.bytedance.sdk.openadsdk.core.settings.vS r5 = com.bytedance.sdk.openadsdk.core.settings.Fmk.gq()     // Catch: java.lang.Throwable -> L39
            java.lang.String r5 = r5.LD()     // Catch: java.lang.Throwable -> L39
            int r2 = com.bytedance.sdk.openadsdk.utils.sU.sP     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.core.settings.vS r3 = com.bytedance.sdk.openadsdk.core.settings.Fmk.gq()     // Catch: java.lang.Throwable -> L39
            r3.SP()     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.utils.sU.sP = r1     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj()     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = "clear_domain"
            com.bytedance.sdk.openadsdk.utils.sU$1 r4 = new com.bytedance.sdk.openadsdk.utils.sU$1     // Catch: java.lang.Throwable -> L39
            r4.<init>()     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.Zq.TKC.Sj(r3, r1, r4)     // Catch: java.lang.Throwable -> L39
        L70:
            int r5 = com.bytedance.sdk.openadsdk.utils.sU.sP     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.core.uA.sP(r5)     // Catch: java.lang.Throwable -> L39
        L75:
            monitor-exit(r0)
            return
        L77:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.sU.Sj(java.lang.String):void");
    }

    public static synchronized void sP() {
        synchronized (sU.class) {
            if (sP == 0) {
                return;
            }
            sP = 0;
            com.bytedance.sdk.openadsdk.core.uA.sP(0);
        }
    }
}
