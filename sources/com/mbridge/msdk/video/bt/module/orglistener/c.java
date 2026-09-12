package com.mbridge.msdk.video.bt.module.orglistener;

import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public class c extends b {

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.listener.b f39005c;

    /* renamed from: d, reason: collision with root package name */
    private String f39006d;

    public c(com.mbridge.msdk.video.bt.module.listener.b bVar, String str) {
        this.f39005c = bVar;
        this.f39006d = str;
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(int i11, String str, String str2) {
        if (this.f39005c != null) {
            o0.a("H5ShowRewardListener", "onAutoLoad");
            this.f39005c.a(this.f39006d, i11, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.f39005c != null) {
            o0.a("H5ShowRewardListener", "onAdShow");
            this.f39005c.a(this.f39006d);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str) {
        if (this.f39005c != null) {
            o0.a("H5ShowRewardListener", "onShowFail");
            this.f39005c.a(this.f39006d, str);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, boolean z10, com.mbridge.msdk.videocommon.entity.c cVar2) {
        if (this.f39005c != null) {
            o0.a("H5ShowRewardListener", "onAdClose");
            this.f39005c.a(this.f39006d, z10, cVar2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(String str, String str2) {
        if (this.f39005c != null) {
            o0.a("H5ShowRewardListener", "onEndcardShow");
            this.f39005c.c(this.f39006d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z10, String str, String str2) {
        if (this.f39005c != null) {
            o0.a("H5ShowRewardListener", "onVideoAdClicked");
            this.f39005c.b(this.f39006d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void b(String str, String str2) {
        if (this.f39005c != null) {
            o0.a("H5ShowRewardListener", "onVideoComplete");
            this.f39005c.a(this.f39006d, str, str2);
        }
    }
}
