package com.mbridge.msdk.video.bt.module.orglistener;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes5.dex */
public class d extends b {

    /* renamed from: c, reason: collision with root package name */
    private h f39007c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.setting.c f39008d;

    /* renamed from: e, reason: collision with root package name */
    private String f39009e;

    /* renamed from: f, reason: collision with root package name */
    private String f39010f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f39011g;

    /* renamed from: h, reason: collision with root package name */
    private Context f39012h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f39013i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39014j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39015k = false;

    public d(Context context, boolean z10, com.mbridge.msdk.videocommon.setting.c cVar, CampaignEx campaignEx, h hVar, String str, String str2) {
        this.f39007c = hVar;
        this.f39008d = cVar;
        this.f39009e = str2;
        this.f39010f = str;
        this.f39011g = z10;
        this.f39012h = context;
        a(cVar, campaignEx);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037 A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:2:0x0000, B:4:0x0010, B:6:0x001a, B:8:0x0024, B:9:0x002d, B:11:0x0037, B:13:0x003d, B:15:0x0044, B:17:0x004e, B:20:0x0052, B:22:0x0056), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:2:0x0000, B:4:0x0010, B:6:0x001a, B:8:0x0024, B:9:0x002d, B:11:0x0037, B:13:0x003d, B:15:0x0044, B:17:0x004e, B:20:0x0052, B:22:0x0056), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.mbridge.msdk.videocommon.setting.c r7, com.mbridge.msdk.foundation.entity.CampaignEx r8) {
        /*
            r6 = this;
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L5c
            java.lang.String r0 = r0.b()     // Catch: java.lang.Exception -> L5c
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L5c
            r2 = 0
            if (r1 != 0) goto L2c
            com.mbridge.msdk.setting.h r1 = com.mbridge.msdk.setting.h.b()     // Catch: java.lang.Exception -> L5c
            com.mbridge.msdk.setting.g r0 = r1.d(r0)     // Catch: java.lang.Exception -> L5c
            if (r0 != 0) goto L22
            com.mbridge.msdk.setting.h r0 = com.mbridge.msdk.setting.h.b()     // Catch: java.lang.Exception -> L5c
            com.mbridge.msdk.setting.g r0 = r0.a()     // Catch: java.lang.Exception -> L5c
        L22:
            if (r0 == 0) goto L2c
            long r0 = r0.a0()     // Catch: java.lang.Exception -> L5c
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r4
            goto L2d
        L2c:
            r0 = r2
        L2d:
            com.mbridge.msdk.videocommon.setting.b r4 = com.mbridge.msdk.videocommon.setting.b.b()     // Catch: java.lang.Exception -> L5c
            com.mbridge.msdk.videocommon.setting.a r4 = r4.c()     // Catch: java.lang.Exception -> L5c
            if (r4 == 0) goto L3b
            long r2 = r4.e()     // Catch: java.lang.Exception -> L5c
        L3b:
            if (r8 == 0) goto L5c
            boolean r0 = r8.isSpareOffer(r2, r0)     // Catch: java.lang.Exception -> L5c
            r1 = 0
            if (r0 == 0) goto L56
            r0 = 1
            r8.setSpareOfferFlag(r0)     // Catch: java.lang.Exception -> L5c
            int r7 = r7.A()     // Catch: java.lang.Exception -> L5c
            if (r7 != r0) goto L52
            r8.setCbt(r0)     // Catch: java.lang.Exception -> L5c
            goto L5c
        L52:
            r8.setCbt(r1)     // Catch: java.lang.Exception -> L5c
            goto L5c
        L56:
            r8.setSpareOfferFlag(r1)     // Catch: java.lang.Exception -> L5c
            r8.setCbt(r1)     // Catch: java.lang.Exception -> L5c
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.orglistener.d.a(com.mbridge.msdk.videocommon.setting.c, com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        super.a(cVar);
        if (this.f39007c == null || this.f39013i) {
            return;
        }
        this.f39013i = true;
        b();
        this.f39007c.a(cVar);
        this.f39007c.a(2, this.f39010f, this.f39009e);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str) {
        super.a(cVar, str);
        if (this.f39007c == null || this.f39014j) {
            return;
        }
        this.f39014j = true;
        a();
        this.f39007c.a(cVar, str);
        this.f39007c.a(4, this.f39010f, this.f39009e);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, boolean z10, com.mbridge.msdk.videocommon.entity.c cVar2) {
        super.a(cVar, z10, cVar2);
        h hVar = this.f39007c;
        if (hVar == null || this.f39015k) {
            return;
        }
        this.f39015k = true;
        hVar.a(7, this.f39010f, this.f39009e);
        this.f39007c.a(cVar, z10, cVar2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(String str, String str2) {
        super.a(str, str2);
        h hVar = this.f39007c;
        if (hVar != null) {
            hVar.a(str, str2);
            this.f39007c.a(6, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z10, int i11) {
        super.a(z10, i11);
        h hVar = this.f39007c;
        if (hVar == null || this.f39015k) {
            return;
        }
        hVar.a(z10, i11);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z10, String str, String str2) {
        super.a(z10, str, str2);
        h hVar = this.f39007c;
        if (hVar != null) {
            hVar.a(z10, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void b(String str, String str2) {
        super.b(str, str2);
        h hVar = this.f39007c;
        if (hVar != null) {
            hVar.b(str, str2);
            this.f39007c.a(5, str, str2);
        }
    }
}
