package com.mbridge.msdk.video.signal.impl;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class l extends d {

    /* renamed from: s, reason: collision with root package name */
    public boolean f39904s = true;

    private com.mbridge.msdk.click.a q() {
        if (this.f39877l == null) {
            this.f39877l = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39875j);
        }
        return this.f39877l;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.mbridge.msdk.foundation.entity.CampaignEx r4, android.content.Context r5) {
        /*
            r3 = this;
            java.lang.String r5 = r4.getNoticeUrl()
            r0 = 0
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.f35395m     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = r5.getQueryParameter(r1)     // Catch: java.lang.Throwable -> L1a
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L1a
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Throwable -> L1a
            goto L1b
        L1a:
            r5 = r0
        L1b:
            com.mbridge.msdk.video.signal.a$a r1 = r3.f39878m
            r2 = 2
            if (r5 != r2) goto L21
            r0 = 1
        L21:
            r1.a(r0)
            com.mbridge.msdk.click.a r5 = r3.q()
            com.mbridge.msdk.video.signal.a$a r0 = r3.f39878m
            r5.a(r0)
            com.mbridge.msdk.click.a r5 = r3.q()
            r5.a(r4)
            com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r5 = r5.d()
            com.mbridge.msdk.video.module.report.b.a(r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.impl.l.a(com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context):void");
    }

    public void a(JSONObject jSONObject) {
        try {
            jSONObject.put("device", new com.mbridge.msdk.foundation.tools.r(com.mbridge.msdk.foundation.controller.c.m().d()).a());
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }

    public void b(JSONObject jSONObject) {
    }
}
