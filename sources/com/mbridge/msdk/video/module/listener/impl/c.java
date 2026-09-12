package com.mbridge.msdk.video.module.listener.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.signal.factory.IJSFactory;

/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: n, reason: collision with root package name */
    private IJSFactory f39505n;

    public c(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i11, boolean z10) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i11, z10);
        this.f39505n = iJSFactory;
        if (iJSFactory == null) {
            this.f39514a = false;
        }
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.d, com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i11, Object obj) {
        if (this.f39514a) {
            if (i11 != 8) {
                if (i11 == 105) {
                    this.f39505n.getJSNotifyProxy().a(3, obj.toString());
                    i11 = -1;
                } else if (i11 == 107) {
                    this.f39505n.getJSContainerModule().showVideoClickView(-1);
                    this.f39505n.getJSVideoModule().setCover(false);
                    this.f39505n.getJSVideoModule().setMiniEndCardState(false);
                    this.f39505n.getJSVideoModule().videoOperate(1);
                } else if (i11 == 112) {
                    this.f39505n.getJSVideoModule().setCover(true);
                    this.f39505n.getJSVideoModule().setMiniEndCardState(true);
                    this.f39505n.getJSVideoModule().videoOperate(2);
                } else if (i11 == 115) {
                    com.mbridge.msdk.video.signal.j jSVideoModule = this.f39505n.getJSVideoModule();
                    this.f39505n.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                }
            } else if (this.f39505n.getJSContainerModule().showAlertWebView()) {
                this.f39505n.getJSVideoModule().alertWebViewShowed();
            } else {
                this.f39505n.getJSVideoModule().showAlertView();
            }
        }
        super.a(i11, obj);
    }
}
