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
import com.mbridge.msdk.setting.h;

@Deprecated
/* loaded from: classes5.dex */
public class MBInterstitialVideoHandler {

    /* renamed from: a, reason: collision with root package name */
    private String f36053a;

    /* renamed from: b, reason: collision with root package name */
    private a f36054b;

    /* renamed from: c, reason: collision with root package name */
    private String f36055c;

    /* renamed from: d, reason: collision with root package name */
    private String f36056d;

    /* renamed from: e, reason: collision with root package name */
    private String f36057e;

    /* renamed from: f, reason: collision with root package name */
    private String f36058f;

    /* renamed from: g, reason: collision with root package name */
    private String f36059g;

    /* renamed from: h, reason: collision with root package name */
    private InterstitialVideoListener f36060h;

    /* renamed from: i, reason: collision with root package name */
    private int f36061i = 2;

    /* renamed from: j, reason: collision with root package name */
    private boolean f36062j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36063k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f36064l = false;

    /* renamed from: m, reason: collision with root package name */
    private int f36065m;

    /* renamed from: n, reason: collision with root package name */
    private int f36066n;

    /* renamed from: o, reason: collision with root package name */
    private int f36067o;

    public MBInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().d() == null && context != null) {
            c.m().b(context);
        }
        a(str, str2);
    }

    public MBInterstitialVideoHandler(String str, String str2) {
        a(str, str2);
    }

    private void a() {
        a aVar;
        if (this.f36054b == null) {
            b(this.f36053a, this.f36055c);
        }
        if (this.f36062j) {
            this.f36054b.a(new com.mbridge.msdk.interstitialvideo.listener.a(this.f36060h, this.f36055c, false));
            this.f36062j = false;
        }
        if (this.f36063k) {
            this.f36054b.a(this.f36056d, this.f36057e, this.f36058f, this.f36059g);
            this.f36063k = false;
        }
        if (!this.f36064l || (aVar = this.f36054b) == null) {
            return;
        }
        aVar.a(this.f36065m, this.f36067o, this.f36066n);
        this.f36064l = false;
    }

    private void a(String str, String str2) {
        String e11 = t0.e(str2);
        if (!TextUtils.isEmpty(e11)) {
            t0.b(str2, e11);
        }
        this.f36055c = str2;
        this.f36053a = str;
        a();
    }

    private void b() {
        a aVar = this.f36054b;
        if (aVar != null) {
            aVar.a(this.f36065m, this.f36067o, this.f36066n);
        }
    }

    private void b(String str, String str2) {
        try {
            if (this.f36054b == null) {
                a aVar = new a();
                this.f36054b = aVar;
                aVar.d(true);
                this.f36054b.c(str, str2);
                h.b().g(str2);
            }
        } catch (Throwable th2) {
            o0.b("MBRewardVideoHandler", th2.getMessage(), th2);
        }
    }

    public void clearVideoCache() {
        try {
            a aVar = this.f36054b;
            if (aVar != null) {
                aVar.e();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.f36054b;
        return aVar != null ? aVar.j() : "";
    }

    public String getRequestId() {
        a aVar = this.f36054b;
        return aVar != null ? aVar.m() : "";
    }

    public boolean isReady() {
        a();
        a aVar = this.f36054b;
        if (aVar != null) {
            return aVar.c(true);
        }
        return false;
    }

    public void load() {
        a();
        if (this.f36054b != null) {
            this.f36054b.a(true, d.b().a(0, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36055c, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        a();
        if (this.f36054b != null) {
            this.f36054b.a(false, d.b().a(0, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36055c, true, 1));
        }
    }

    public void playVideoMute(int i11) {
        this.f36061i = i11;
        a aVar = this.f36054b;
        if (aVar != null) {
            aVar.a(i11);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f36056d = str;
        this.f36057e = str2;
        this.f36058f = str3;
        this.f36059g = str4;
        this.f36063k = true;
        MBridgeGlobalCommon.setAlertDialogText(this.f36055c, str, str2, str3, str4);
    }

    public void setIVRewardEnable(int i11, double d11) {
        this.f36065m = i11;
        this.f36066n = (int) (d11 * 100.0d);
        this.f36067o = com.mbridge.msdk.foundation.same.a.J;
        this.f36064l = true;
        b();
    }

    public void setIVRewardEnable(int i11, int i12) {
        this.f36065m = i11;
        this.f36066n = i12;
        this.f36067o = com.mbridge.msdk.foundation.same.a.K;
        this.f36064l = true;
        b();
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f36060h = interstitialVideoListener;
        this.f36062j = true;
        a aVar = this.f36054b;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36054b.a(new com.mbridge.msdk.interstitialvideo.listener.a(interstitialVideoListener));
        this.f36062j = false;
    }

    @Deprecated
    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f36060h = interstitialVideoListener;
        this.f36062j = true;
        a aVar = this.f36054b;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f36054b.a(new com.mbridge.msdk.interstitialvideo.listener.a(interstitialVideoListener));
        this.f36062j = false;
    }

    public void show() {
        a();
        if (this.f36054b != null) {
            this.f36054b.a((String) null, (String) null, (String) null, d.b().a(0, MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36055c, false, -1));
        }
    }
}
