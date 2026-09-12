package com.mbridge.msdk.newinterstitial.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.BaseExtraInterfaceForHandler;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.reward.controller.a;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes5.dex */
public class MBBidInterstitialVideoHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a, reason: collision with root package name */
    private String f36778a;

    /* renamed from: b, reason: collision with root package name */
    private String f36779b;

    /* renamed from: c, reason: collision with root package name */
    private String f36780c;

    /* renamed from: d, reason: collision with root package name */
    private String f36781d;

    /* renamed from: e, reason: collision with root package name */
    private String f36782e;

    /* renamed from: f, reason: collision with root package name */
    private a f36783f;

    /* renamed from: g, reason: collision with root package name */
    private NewInterstitialListener f36784g;

    /* renamed from: h, reason: collision with root package name */
    private int f36785h = 2;

    /* renamed from: i, reason: collision with root package name */
    private boolean f36786i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f36787j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36788k = false;

    /* renamed from: l, reason: collision with root package name */
    private int f36789l;

    /* renamed from: m, reason: collision with root package name */
    private int f36790m;
    public String mUnitId;

    /* renamed from: n, reason: collision with root package name */
    private int f36791n;

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
        if (this.f36783f == null) {
            b(this.f36778a, this.mUnitId);
        }
        b();
    }

    private void a(String str, String str2) {
        String e11 = t0.e(str2);
        if (!TextUtils.isEmpty(e11)) {
            t0.b(str2, e11);
        }
        this.mUnitId = str2;
        this.f36778a = str;
        a();
    }

    private void b() {
        a aVar;
        if (this.f36786i) {
            a aVar2 = this.f36783f;
            if (aVar2 != null) {
                aVar2.a(new com.mbridge.msdk.newinterstitial.listener.a(this.f36784g));
            }
            this.f36786i = false;
        }
        if (this.f36787j) {
            a aVar3 = this.f36783f;
            if (aVar3 != null) {
                aVar3.a(this.f36780c, this.f36779b, this.f36781d, this.f36782e);
            }
            this.f36787j = false;
        }
        if (!this.f36788k || (aVar = this.f36783f) == null) {
            return;
        }
        aVar.a(this.f36789l, this.f36791n, this.f36790m);
        this.f36788k = false;
    }

    private void b(String str, String str2) {
        try {
            if (this.f36783f == null) {
                a aVar = new a();
                this.f36783f = aVar;
                aVar.d(true);
                this.f36783f.e(true);
                this.f36783f.c(str, str2);
            }
        } catch (Throwable th2) {
            o0.b("MBBidInterstitialVideoHandler", th2.getMessage(), th2);
        }
    }

    private void c() {
        a aVar = this.f36783f;
        if (aVar != null) {
            aVar.a(this.f36789l, this.f36791n, this.f36790m);
        }
    }

    public void clearVideoCache() {
        try {
            a aVar = this.f36783f;
            if (aVar != null) {
                aVar.e();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.f36783f;
        return aVar != null ? aVar.j() : "";
    }

    public String getRequestId() {
        a aVar = this.f36783f;
        return aVar != null ? aVar.m() : "";
    }

    public boolean isBidReady() {
        a();
        a aVar = this.f36783f;
        if (aVar != null) {
            return aVar.c(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        a();
        if (this.f36783f != null) {
            this.f36783f.a(false, d.b().a(1, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.mUnitId, true, 1));
        }
    }

    public void loadFromBid(String str) {
        a();
        if (this.f36783f != null) {
            this.f36783f.a(true, str, d.b().a(1, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.mUnitId, true, 2));
        }
    }

    public void playVideoMute(int i11) {
        this.f36785h = i11;
        a aVar = this.f36783f;
        if (aVar != null) {
            aVar.a(i11);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f36780c = str;
        this.f36779b = str2;
        this.f36781d = str3;
        this.f36782e = str4;
        this.f36787j = true;
        MBridgeGlobalCommon.setAlertDialogText(this.mUnitId, str, str2, str3, str4);
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.mUnitId, jSONObject);
    }

    public void setIVRewardEnable(int i11, double d11) {
        this.f36789l = i11;
        this.f36790m = (int) (d11 * 100.0d);
        this.f36791n = com.mbridge.msdk.foundation.same.a.J;
        this.f36788k = true;
        c();
    }

    public void setIVRewardEnable(int i11, int i12) {
        this.f36789l = i11;
        this.f36790m = i12;
        this.f36791n = com.mbridge.msdk.foundation.same.a.K;
        this.f36788k = true;
        c();
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f36784g = newInterstitialListener;
        this.f36786i = true;
        a aVar = this.f36783f;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36783f.a(new com.mbridge.msdk.newinterstitial.listener.a(newInterstitialListener));
        this.f36786i = false;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f36784g = newInterstitialListener;
        this.f36786i = true;
        a aVar = this.f36783f;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36783f.a(new com.mbridge.msdk.newinterstitial.listener.a(newInterstitialListener));
        this.f36786i = false;
    }

    public void showFromBid() {
        a();
        if (this.f36783f != null) {
            this.f36783f.a((String) null, (String) null, (String) null, d.b().a(1, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.mUnitId, false, -1));
        }
    }
}
