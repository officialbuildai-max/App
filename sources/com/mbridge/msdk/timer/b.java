package com.mbridge.msdk.timer;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: com.mbridge.msdk.timer.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static class C0555b {

        /* renamed from: a, reason: collision with root package name */
        static b f38549a = new b();
    }

    private b() {
    }

    public static b getInstance() {
        return C0555b.f38549a;
    }

    public void addInterstitialList(String str, String str2) {
        try {
            com.mbridge.msdk.timer.a.a().a(str, str2);
        } catch (Exception e11) {
            o0.b("TimerController", "addInterstitialList error:" + e11.getMessage());
        }
    }

    public void addRewardList(String str, String str2) {
        try {
            com.mbridge.msdk.timer.a.a().b(str, str2);
        } catch (Exception e11) {
            o0.b("TimerController", "addRewardList error:" + e11.getMessage());
        }
    }

    public void start() {
        g d11 = h.b().d(c.m().b());
        if (d11 == null) {
            d11 = h.b().a();
        }
        if (d11.h() > 0) {
            com.mbridge.msdk.timer.a.a().b(r0 * 1000);
        }
    }
}
