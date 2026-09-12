package com.bytedance.sdk.openadsdk.activity;

/* loaded from: classes2.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void HiB() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.aa.EjP.sP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean Sj(long r10, boolean r12) {
        /*
            r9 = this;
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r9.sP
            com.bytedance.sdk.openadsdk.component.reward.view.Dq r0 = r0.wE
            if (r0 == 0) goto L19
            com.bytedance.sdk.openadsdk.component.reward.view.sP r0 = r0.Sj()
            if (r0 == 0) goto L19
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r9.sP
            com.bytedance.sdk.openadsdk.component.reward.view.Dq r0 = r0.wE
            com.bytedance.sdk.openadsdk.component.reward.view.sP r0 = r0.Sj()
            com.bytedance.sdk.openadsdk.EjP.Jcg r0 = r0.getAdShowTime()
            goto L1e
        L19:
            com.bytedance.sdk.openadsdk.EjP.Jcg r0 = new com.bytedance.sdk.openadsdk.EjP.Jcg
            r0.<init>()
        L1e:
            com.bytedance.sdk.openadsdk.component.reward.sP.sP r1 = r9.TKC
            if (r1 == 0) goto L38
            boolean r2 = r1 instanceof com.bytedance.sdk.openadsdk.component.reward.sP.uA
            if (r2 == 0) goto L38
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r2 = r9.sP
            boolean r3 = r2.dwU
            if (r3 != 0) goto L38
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r2 = r2.f21074ib
            com.bytedance.sdk.openadsdk.component.reward.sP.uA r1 = (com.bytedance.sdk.openadsdk.component.reward.sP.uA) r1
            android.widget.FrameLayout r1 = r1.Yf()
            r2.Sj(r1, r0)
            goto L45
        L38:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r1 = r9.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r2 = r1.f21074ib
            com.bytedance.sdk.openadsdk.component.reward.view.Dq r1 = r1.wE
            android.widget.FrameLayout r1 = r1.sP()
            r2.Sj(r1, r0)
        L45:
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r9.sP
            com.bytedance.sdk.openadsdk.component.reward.view.Dq r0 = r0.wE
            if (r0 == 0) goto L80
            int r0 = r0.uA()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "dynamic_show_type"
            r7.put(r1, r0)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r9.sP
            com.bytedance.sdk.openadsdk.component.reward.view.Dq r0 = r0.wE
            r1 = 0
            org.json.JSONObject r0 = r0.Sj(r1)
            if (r0 == 0) goto L80
            java.util.Iterator r1 = r0.keys()
        L6c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L80
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.get(r2)     // Catch: org.json.JSONException -> L6c
            r7.put(r2, r3)     // Catch: org.json.JSONException -> L6c
            goto L6c
        L80:
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r9.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r0 = r0.f21074ib
            com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity$1 r1 = new com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity$1
            r1.<init>()
            r0.Sj(r1)
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj r0 = r9.sP
            com.bytedance.sdk.openadsdk.component.reward.Sj.dNu r3 = r0.f21074ib
            com.bytedance.sdk.openadsdk.component.reward.sP.sP r8 = r9.TKC
            r4 = r10
            r6 = r12
            boolean r10 = r3.Sj(r4, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.Sj(long, boolean):boolean");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean sU() {
        return true;
    }
}
