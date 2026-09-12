package com.mbridge.msdk.splash.middle;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private MBSplashLoadListener f37586a;

    /* renamed from: b, reason: collision with root package name */
    private c f37587b;

    /* renamed from: c, reason: collision with root package name */
    private String f37588c;

    /* renamed from: d, reason: collision with root package name */
    private String f37589d;

    /* renamed from: e, reason: collision with root package name */
    private MBridgeIds f37590e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.f37587b = cVar;
        this.f37590e = mBridgeIds;
        if (mBridgeIds != null) {
            this.f37588c = mBridgeIds.getUnitId();
        }
    }

    public void a(CampaignEx campaignEx, int i11) {
        c cVar;
        c cVar2 = this.f37587b;
        if (cVar2 == null || !cVar2.g() || campaignEx == null) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.f37586a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadSuccessed(this.f37590e, i11);
            this.f37586a.isSupportZoomOut(this.f37590e, campaignEx.getFlb() == 1);
        }
        this.f37587b.b(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        j.a(com.mbridge.msdk.foundation.controller.c.m().d(), arrayList, this.f37588c, campaignEx.isBidCampaign());
        if (i11 != 2 || (cVar = this.f37587b) == null) {
            return;
        }
        cVar.b(campaignEx, 0, true);
    }

    public void a(com.mbridge.msdk.foundation.error.b bVar, int i11) {
        c cVar = this.f37587b;
        if (cVar == null || !cVar.g()) {
            return;
        }
        String str = "";
        if (bVar != null) {
            String g11 = bVar.g();
            if (!TextUtils.isEmpty(g11)) {
                str = g11;
            }
        }
        MBSplashLoadListener mBSplashLoadListener = this.f37586a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadFailed(this.f37590e, str, i11);
        }
        this.f37587b.b(false);
        j.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, this.f37588c, !TextUtils.isEmpty(this.f37589d), bVar != null ? bVar.a() : null);
    }

    public void a(MBSplashLoadListener mBSplashLoadListener) {
        this.f37586a = mBSplashLoadListener;
    }

    public void a(String str) {
        this.f37589d = str;
    }
}
