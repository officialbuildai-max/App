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

/* loaded from: classes5.dex */
public class MBBidNewInterstitialHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a, reason: collision with root package name */
    private String f36792a;

    /* renamed from: b, reason: collision with root package name */
    private String f36793b;

    /* renamed from: c, reason: collision with root package name */
    private String f36794c;

    /* renamed from: d, reason: collision with root package name */
    private String f36795d;

    /* renamed from: e, reason: collision with root package name */
    private String f36796e;

    /* renamed from: f, reason: collision with root package name */
    private a f36797f;

    /* renamed from: g, reason: collision with root package name */
    private String f36798g;

    /* renamed from: h, reason: collision with root package name */
    private NewInterstitialListener f36799h;

    /* renamed from: i, reason: collision with root package name */
    private int f36800i = 2;

    /* renamed from: j, reason: collision with root package name */
    private boolean f36801j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36802k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f36803l = false;

    /* renamed from: m, reason: collision with root package name */
    private int f36804m;

    /* renamed from: n, reason: collision with root package name */
    private int f36805n;

    /* renamed from: o, reason: collision with root package name */
    private int f36806o;

    public MBBidNewInterstitialHandler(Context context, String str, String str2) {
        if (c.m().d() == null && context != null) {
            c.m().b(context);
        }
        a(str, str2);
    }

    public MBBidNewInterstitialHandler(String str, String str2) {
        a(str, str2);
    }

    private void a() {
        a aVar;
        if (this.f36797f == null) {
            b(this.f36792a, this.f36798g);
        }
        if (this.f36801j) {
            a aVar2 = this.f36797f;
            if (aVar2 != null) {
                aVar2.a(new com.mbridge.msdk.newinterstitial.listener.a(this.f36799h, this.f36798g, true));
            }
            this.f36801j = false;
        }
        if (this.f36802k) {
            a aVar3 = this.f36797f;
            if (aVar3 != null) {
                aVar3.a(this.f36794c, this.f36793b, this.f36795d, this.f36796e);
            }
            this.f36802k = false;
        }
        if (!this.f36803l || (aVar = this.f36797f) == null) {
            return;
        }
        aVar.a(this.f36804m, this.f36806o, this.f36805n);
        this.f36803l = false;
    }

    private void a(String str, String str2) {
        String e11 = t0.e(str2);
        if (!TextUtils.isEmpty(e11)) {
            t0.b(str2, e11);
        }
        this.f36792a = str;
        this.f36798g = str2;
        a();
    }

    private void b() {
        a aVar = this.f36797f;
        if (aVar != null) {
            aVar.a(this.f36804m, this.f36806o, this.f36805n);
        }
    }

    private void b(String str, String str2) {
        try {
            if (this.f36797f == null) {
                a aVar = new a();
                this.f36797f = aVar;
                aVar.d(true);
                this.f36797f.e(true);
                this.f36797f.c(str, str2);
            }
        } catch (Throwable th2) {
            o0.b("MBBidNewInterstitialHandler", th2.getMessage(), th2);
        }
    }

    public void clearVideoCache() {
        try {
            a aVar = this.f36797f;
            if (aVar != null) {
                aVar.e();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.f36797f;
        return aVar != null ? aVar.j() : "";
    }

    public String getRequestId() {
        a aVar = this.f36797f;
        return aVar != null ? aVar.m() : "";
    }

    public boolean isBidReady() {
        a();
        a aVar = this.f36797f;
        if (aVar != null) {
            return aVar.c(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        a();
        if (this.f36797f != null) {
            this.f36797f.a(false, d.b().a(1, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36798g, true, 1));
        }
    }

    public void loadFromBid(String str) {
        a();
        if (this.f36797f != null) {
            this.f36797f.a(true, str, d.b().a(1, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36798g, true, 2));
        }
    }

    public void playVideoMute(int i11) {
        this.f36800i = i11;
        a aVar = this.f36797f;
        if (aVar != null) {
            aVar.a(i11);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f36794c = str;
        this.f36793b = str2;
        this.f36795d = str3;
        this.f36796e = str4;
        this.f36802k = true;
        MBridgeGlobalCommon.setAlertDialogText(this.f36798g, str, str2, str3, str4);
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.f36798g, jSONObject);
    }

    public void setIVRewardEnable(int i11, double d11) {
        this.f36804m = i11;
        this.f36805n = (int) (d11 * 100.0d);
        this.f36806o = com.mbridge.msdk.foundation.same.a.J;
        this.f36803l = true;
        b();
    }

    public void setIVRewardEnable(int i11, int i12) {
        this.f36804m = i11;
        this.f36805n = i12;
        this.f36806o = com.mbridge.msdk.foundation.same.a.K;
        this.f36803l = true;
        b();
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f36799h = newInterstitialListener;
        this.f36801j = true;
        a aVar = this.f36797f;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36797f.a(new com.mbridge.msdk.newinterstitial.listener.a(newInterstitialListener, this.f36798g, true));
        this.f36801j = false;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f36799h = newInterstitialListener;
        this.f36801j = true;
        a aVar = this.f36797f;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36797f.a(new com.mbridge.msdk.newinterstitial.listener.a(newInterstitialListener, this.f36798g, true));
        this.f36801j = false;
    }

    public void showFromBid() {
        a();
        if (this.f36797f != null) {
            this.f36797f.a((String) null, (String) null, (String) null, d.b().a(1, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36798g, false, -1));
        }
    }
}
