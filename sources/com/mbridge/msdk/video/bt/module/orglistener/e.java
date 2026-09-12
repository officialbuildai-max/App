package com.mbridge.msdk.video.bt.module.orglistener;

import com.mbridge.msdk.video.bt.module.MBTempContainer;

/* loaded from: classes5.dex */
public class e extends MBTempContainer.k.a {

    /* renamed from: b, reason: collision with root package name */
    private h f39016b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.metrics.c f39017c;

    public e(com.mbridge.msdk.foundation.same.report.metrics.c cVar, h hVar) {
        this.f39016b = hVar;
        this.f39017c = cVar;
    }

    @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.k.a, com.mbridge.msdk.video.bt.module.MBTempContainer.k
    public void onError(String str) {
        super.onError(str);
        h hVar = this.f39016b;
        if (hVar != null) {
            hVar.a(this.f39017c, str);
        }
    }
}
