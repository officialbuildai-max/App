package com.mbridge.msdk.video.bt.module.orglistener;

import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public class b implements h {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f39003a = null;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f39004b = null;

    public void a() {
        this.f39004b = Boolean.TRUE;
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(int i11, String str, String str2) {
        o0.a("ShowRewardListener", "onAutoLoad: " + str2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        o0.a("ShowRewardListener", "onAdShow");
        this.f39003a = Boolean.TRUE;
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str) {
        o0.a("ShowRewardListener", "onShowFail:" + str);
        this.f39004b = Boolean.TRUE;
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, boolean z10, com.mbridge.msdk.videocommon.entity.c cVar2) {
        o0.a("ShowRewardListener", "onAdClose:isCompleteView:" + z10 + ",reward:" + cVar2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(String str, String str2) {
        o0.a("ShowRewardListener", "onEndcardShow: " + str2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z10, int i11) {
        o0.a("ShowRewardListener", "onAdCloseWithIVReward: " + z10 + "  " + i11);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z10, String str, String str2) {
        o0.a("ShowRewardListener", "onVideoAdClicked:" + str2);
    }

    public void b() {
        this.f39003a = Boolean.TRUE;
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.h
    public void b(String str, String str2) {
        o0.a("ShowRewardListener", "onVideoComplete: " + str2);
    }

    public Boolean c() {
        return this.f39004b;
    }

    public Boolean d() {
        return this.f39003a;
    }
}
