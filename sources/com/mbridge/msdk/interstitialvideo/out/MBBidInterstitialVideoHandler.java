package com.mbridge.msdk.interstitialvideo.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.reward.controller.a;

@Deprecated
/* loaded from: classes5.dex */
public class MBBidInterstitialVideoHandler {

    /* renamed from: a, reason: collision with root package name */
    private a f36037a;

    /* renamed from: b, reason: collision with root package name */
    private String f36038b;

    /* renamed from: c, reason: collision with root package name */
    private String f36039c;

    /* renamed from: d, reason: collision with root package name */
    private String f36040d;

    /* renamed from: e, reason: collision with root package name */
    private String f36041e;

    /* renamed from: f, reason: collision with root package name */
    private String f36042f;

    /* renamed from: g, reason: collision with root package name */
    private String f36043g;

    /* renamed from: h, reason: collision with root package name */
    private InterstitialVideoListener f36044h;

    /* renamed from: i, reason: collision with root package name */
    private int f36045i = 2;

    /* renamed from: j, reason: collision with root package name */
    private boolean f36046j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36047k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f36048l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f36049m = false;

    /* renamed from: n, reason: collision with root package name */
    private int f36050n;

    /* renamed from: o, reason: collision with root package name */
    private int f36051o;

    /* renamed from: p, reason: collision with root package name */
    private int f36052p;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().d() == null && context != null) {
            c.m().b(context);
        }
        a(str, str2);
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        a(str, str2);
    }

    private void a() {
        a aVar;
        if (this.f36037a == null) {
            b(this.f36039c, this.f36038b);
        }
        if (this.f36046j) {
            a aVar2 = this.f36037a;
            if (aVar2 != null) {
                aVar2.a(new com.mbridge.msdk.interstitialvideo.listener.a(this.f36044h, this.f36038b, true));
            }
            this.f36046j = false;
        }
        if (this.f36047k) {
            a aVar3 = this.f36037a;
            if (aVar3 != null) {
                aVar3.a(this.f36040d, this.f36041e, this.f36042f, this.f36043g);
            }
            this.f36047k = false;
        }
        if (!this.f36049m || (aVar = this.f36037a) == null) {
            return;
        }
        aVar.a(this.f36050n, this.f36052p, this.f36051o);
        this.f36049m = false;
    }

    private void a(String str, String str2) {
        String e11 = t0.e(str2);
        if (!TextUtils.isEmpty(e11)) {
            t0.b(str2, e11);
        }
        this.f36038b = str2;
        this.f36039c = str;
        a();
    }

    private void b() {
        a aVar = this.f36037a;
        if (aVar != null) {
            aVar.a(this.f36050n, this.f36052p, this.f36051o);
        }
    }

    private void b(String str, String str2) {
        try {
            if (this.f36037a == null) {
                a aVar = new a();
                this.f36037a = aVar;
                aVar.d(true);
                this.f36037a.e(true);
                this.f36037a.c(str, str2);
            }
        } catch (Throwable th2) {
            o0.b("MBBidRewardVideoHandler", th2.getMessage(), th2);
        }
    }

    public void clearVideoCache() {
        try {
            a aVar = this.f36037a;
            if (aVar != null) {
                aVar.e();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.f36037a;
        return aVar != null ? aVar.j() : "";
    }

    public String getRequestId() {
        a aVar = this.f36037a;
        return aVar != null ? aVar.m() : "";
    }

    public boolean isBidReady() {
        a();
        a aVar = this.f36037a;
        if (aVar != null) {
            return aVar.c(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        a();
        if (this.f36037a != null) {
            this.f36037a.a(false, d.b().a(1, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36038b, true, 1));
        }
    }

    public void loadFromBid(String str) {
        a();
        if (this.f36037a != null) {
            this.f36037a.a(true, str, d.b().a(1, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36038b, true, 2));
        }
    }

    public void playVideoMute(int i11) {
        this.f36045i = i11;
        a aVar = this.f36037a;
        if (aVar != null) {
            aVar.a(i11);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f36040d = str;
        this.f36041e = str2;
        this.f36042f = str3;
        this.f36043g = str4;
        this.f36047k = true;
        this.f36048l = true;
        MBridgeGlobalCommon.setAlertDialogText(this.f36038b, str, str2, str3, str4);
    }

    public void setIVRewardEnable(int i11, double d11) {
        this.f36050n = i11;
        this.f36051o = (int) (d11 * 100.0d);
        this.f36052p = com.mbridge.msdk.foundation.same.a.J;
        this.f36049m = true;
        b();
    }

    public void setIVRewardEnable(int i11, int i12) {
        this.f36050n = i11;
        this.f36051o = i12;
        this.f36052p = com.mbridge.msdk.foundation.same.a.K;
        this.f36049m = true;
        b();
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f36044h = interstitialVideoListener;
        this.f36046j = true;
        a aVar = this.f36037a;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36037a.a(new com.mbridge.msdk.interstitialvideo.listener.a(interstitialVideoListener, this.f36038b, true));
        this.f36046j = false;
    }

    @Deprecated
    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f36044h = interstitialVideoListener;
        this.f36046j = true;
        a aVar = this.f36037a;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36037a.a(new com.mbridge.msdk.interstitialvideo.listener.a(interstitialVideoListener, this.f36038b, true));
        this.f36046j = false;
    }

    public void showFromBid() {
        a();
        if (this.f36037a != null) {
            this.f36037a.a((String) null, (String) null, (String) null, d.b().a(1, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36038b, false, -1));
        }
    }
}
