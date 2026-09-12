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
import com.mbridge.msdk.setting.h;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBNewInterstitialHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a, reason: collision with root package name */
    private String f36807a;

    /* renamed from: b, reason: collision with root package name */
    private String f36808b;

    /* renamed from: c, reason: collision with root package name */
    private String f36809c;

    /* renamed from: d, reason: collision with root package name */
    private String f36810d;

    /* renamed from: e, reason: collision with root package name */
    private String f36811e;

    /* renamed from: f, reason: collision with root package name */
    private a f36812f;

    /* renamed from: g, reason: collision with root package name */
    private String f36813g;

    /* renamed from: h, reason: collision with root package name */
    private NewInterstitialListener f36814h;

    /* renamed from: i, reason: collision with root package name */
    private int f36815i = 2;

    /* renamed from: j, reason: collision with root package name */
    private boolean f36816j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36817k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f36818l = false;

    /* renamed from: m, reason: collision with root package name */
    private int f36819m;

    /* renamed from: n, reason: collision with root package name */
    private int f36820n;

    /* renamed from: o, reason: collision with root package name */
    private int f36821o;

    public MBNewInterstitialHandler(Context context, String str, String str2) {
        if (c.m().d() == null && context != null) {
            c.m().b(context);
        }
        a(str, str2);
    }

    public MBNewInterstitialHandler(String str, String str2) {
        a(str, str2);
    }

    private void a() {
        a aVar;
        if (this.f36812f == null) {
            b(this.f36807a, this.f36813g);
        }
        if (this.f36816j) {
            a aVar2 = this.f36812f;
            if (aVar2 != null) {
                aVar2.a(new com.mbridge.msdk.newinterstitial.listener.a(this.f36814h, this.f36813g, false));
            }
            this.f36816j = false;
        }
        if (this.f36817k) {
            a aVar3 = this.f36812f;
            if (aVar3 != null) {
                aVar3.a(this.f36808b, this.f36809c, this.f36810d, this.f36811e);
            }
            this.f36817k = false;
        }
        if (!this.f36818l || (aVar = this.f36812f) == null) {
            return;
        }
        aVar.a(this.f36819m, this.f36821o, this.f36820n);
        this.f36818l = false;
    }

    private void a(String str, String str2) {
        String e11 = t0.e(str2);
        if (!TextUtils.isEmpty(e11)) {
            t0.b(str2, e11);
        }
        this.f36807a = str;
        this.f36813g = str2;
        a();
    }

    private void b() {
        a aVar = this.f36812f;
        if (aVar != null) {
            aVar.a(this.f36819m, this.f36821o, this.f36820n);
        }
    }

    private void b(String str, String str2) {
        try {
            if (this.f36812f == null) {
                a aVar = new a();
                this.f36812f = aVar;
                aVar.d(true);
                this.f36812f.c(str, str2);
                h.b().g(str2);
            }
        } catch (Throwable th2) {
            o0.b("MBRewardVideoHandler", th2.getMessage(), th2);
        }
    }

    public void clearVideoCache() {
        try {
            a aVar = this.f36812f;
            if (aVar != null) {
                aVar.e();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.f36812f;
        return aVar != null ? aVar.j() : "";
    }

    public String getRequestId() {
        a aVar = this.f36812f;
        return aVar != null ? aVar.m() : "";
    }

    public boolean isReady() {
        a();
        a aVar = this.f36812f;
        if (aVar != null) {
            return aVar.c(true);
        }
        return false;
    }

    public void load() {
        a();
        if (this.f36812f != null) {
            this.f36812f.a(true, d.b().a(0, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36813g, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        a();
        if (this.f36812f != null) {
            this.f36812f.a(false, d.b().a(0, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36813g, true, 1));
        }
    }

    public void playVideoMute(int i11) {
        this.f36815i = i11;
        a aVar = this.f36812f;
        if (aVar != null) {
            aVar.a(i11);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f36808b = str;
        this.f36809c = str2;
        this.f36810d = str3;
        this.f36811e = str4;
        this.f36817k = true;
        MBridgeGlobalCommon.setAlertDialogText(this.f36813g, str, str2, str3, str4);
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.f36813g, jSONObject);
    }

    public void setIVRewardEnable(int i11, double d11) {
        this.f36819m = i11;
        this.f36820n = (int) (d11 * 100.0d);
        this.f36821o = com.mbridge.msdk.foundation.same.a.J;
        this.f36818l = true;
        b();
    }

    public void setIVRewardEnable(int i11, int i12) {
        this.f36819m = i11;
        this.f36820n = i12;
        this.f36821o = com.mbridge.msdk.foundation.same.a.K;
        this.f36818l = true;
        b();
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f36814h = newInterstitialListener;
        this.f36816j = true;
        a aVar = this.f36812f;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36812f.a(new com.mbridge.msdk.newinterstitial.listener.a(newInterstitialListener, this.f36813g, false));
        this.f36816j = false;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f36814h = newInterstitialListener;
        this.f36816j = true;
        a aVar = this.f36812f;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36812f.a(new com.mbridge.msdk.newinterstitial.listener.a(newInterstitialListener, this.f36813g, false));
        this.f36816j = false;
    }

    public void show() {
        a();
        if (this.f36812f != null) {
            this.f36812f.a((String) null, (String) null, (String) null, d.b().a(0, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36813g, false, -1));
        }
    }
}
