package com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj;

/* loaded from: classes3.dex */
public class EjP {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008e, code lost:
    
        switch(r13) {
            case 0: goto L68;
            case 1: goto L67;
            case 2: goto L66;
            default: goto L73;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0092, code lost:
    
        r9 = com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.sP(r15, "VerificationParameters");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
    
        if (com.mbridge.msdk.foundation.entity.CampaignEx.KEY_OMID.equals(r15.getAttributeValue(com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.Jcg, "apiFramework")) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a5, code lost:
    
        r8 = com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.sP(r15, "JavaScriptResource");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
    
        if ("verificationNotExecuted".equals(r15.getAttributeValue(com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.Jcg, androidx.core.app.NotificationCompat.CATEGORY_EVENT)) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ba, code lost:
    
        r10 = com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.sP(r15, "Tracking");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Set<com.bytedance.sdk.openadsdk.core.Ym.TEQ> Sj(org.xmlpull.v1.XmlPullParser r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            java.lang.String r0 = "VerificationParameters"
            java.lang.String r1 = "JavaScriptResource"
            java.lang.String r2 = "Tracking"
            r3 = 2
            if (r15 != 0) goto Lf
            java.util.HashSet r15 = new java.util.HashSet
            r15.<init>()
            return r15
        Lf:
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
        L14:
            int r5 = r15.next()
            r6 = 3
            if (r5 == r6) goto Lc5
            int r5 = r15.getEventType()
            if (r5 != r3) goto L14
            java.lang.String r5 = r15.getName()
            java.lang.String r7 = "Verification"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto Lc0
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.Jcg
            java.lang.String r8 = "vendor"
            java.lang.String r5 = r15.getAttributeValue(r5, r8)
            r8 = 0
            r9 = r8
            r10 = r9
        L38:
            int r11 = r15.getEventType()
            java.lang.String r12 = "omid"
            if (r11 != r6) goto L5b
            java.lang.String r11 = r15.getName()
            boolean r11 = r7.equals(r11)
            if (r11 != 0) goto L4b
            goto L5b
        L4b:
            boolean r6 = android.text.TextUtils.isEmpty(r8)
            if (r6 != 0) goto L14
            com.bytedance.sdk.openadsdk.core.Ym.TEQ r5 = com.bytedance.sdk.openadsdk.core.Ym.TEQ.Sj(r12, r8, r5, r9, r10)
            if (r5 == 0) goto L14
            r4.add(r5)
            goto L14
        L5b:
            r15.next()
            int r11 = r15.getEventType()
            if (r11 != r3) goto L38
            java.lang.String r11 = r15.getName()
            r11.hashCode()
            r13 = -1
            int r14 = r11.hashCode()
            switch(r14) {
                case 1335132887: goto L86;
                case 1561251035: goto L7d;
                case 1749252741: goto L74;
                default: goto L73;
            }
        L73:
            goto L8e
        L74:
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L7b
            goto L8e
        L7b:
            r13 = r3
            goto L8e
        L7d:
            boolean r11 = r11.equals(r1)
            if (r11 != 0) goto L84
            goto L8e
        L84:
            r13 = 1
            goto L8e
        L86:
            boolean r11 = r11.equals(r2)
            if (r11 != 0) goto L8d
            goto L8e
        L8d:
            r13 = 0
        L8e:
            switch(r13) {
                case 0: goto Laa;
                case 1: goto L97;
                case 2: goto L92;
                default: goto L91;
            }
        L91:
            goto L38
        L92:
            java.lang.String r9 = com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.sP(r15, r0)
            goto L38
        L97:
            java.lang.String r11 = com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.Jcg
            java.lang.String r13 = "apiFramework"
            java.lang.String r11 = r15.getAttributeValue(r11, r13)
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L38
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.sP(r15, r1)
            goto L38
        Laa:
            java.lang.String r11 = com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.Jcg
            java.lang.String r12 = "event"
            java.lang.String r11 = r15.getAttributeValue(r11, r12)
            java.lang.String r12 = "verificationNotExecuted"
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L38
            java.lang.String r10 = com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.sP(r15, r2)
            goto L38
        Lc0:
            com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB.Sj(r15)
            goto L14
        Lc5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.EjP.Sj(org.xmlpull.v1.XmlPullParser):java.util.Set");
    }
}
