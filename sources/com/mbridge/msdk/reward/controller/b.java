package com.mbridge.msdk.reward.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.reward.controller.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final a f37212a;

    public b(a aVar) {
        super(Looper.getMainLooper());
        this.f37212a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i11 = message.what;
        Object obj = message.obj;
        com.mbridge.msdk.foundation.same.report.metrics.c a11 = this.f37212a.a(message);
        CopyOnWriteArrayList<CampaignEx> i12 = this.f37212a.i();
        List<CampaignEx> h11 = this.f37212a.h();
        com.mbridge.msdk.reward.adapter.c n11 = this.f37212a.n();
        boolean s11 = this.f37212a.s();
        String l11 = this.f37212a.l();
        String p11 = this.f37212a.p();
        a.h k11 = this.f37212a.k();
        InterVideoOutListener o11 = this.f37212a.o();
        boolean r11 = this.f37212a.r();
        MBridgeIds g11 = this.f37212a.g();
        boolean t11 = this.f37212a.t();
        switch (i11) {
            case 8:
                if (i12 == null || i12.size() <= 0) {
                    return;
                }
                boolean z10 = (h11 == null || h11.size() <= 0) ? false : !TextUtils.isEmpty(h11.get(0).getCMPTEntryUrl());
                int nscpt = i12.get(0).getNscpt();
                if (n11 != null && n11.a(i12, z10, nscpt)) {
                    if (k11 == null || !s11) {
                        return;
                    }
                    k11.c(l11, p11, a11);
                    return;
                }
                if (k11 == null || !s11) {
                    return;
                }
                com.mbridge.msdk.videocommon.a.a(p11);
                com.mbridge.msdk.videocommon.a.a();
                com.mbridge.msdk.foundation.error.b a12 = com.mbridge.msdk.foundation.error.a.a(880010, "load timeout");
                if (a11 != null) {
                    a11.a(a12);
                }
                k11.a(a12, a11);
                return;
            case 9:
                if (o11 == null || !s11) {
                    return;
                }
                if (r11) {
                    this.f37212a.a();
                }
                o11.onVideoLoadSuccess(g11);
                return;
            case 16:
            case 18:
                if (o11 == null || !s11) {
                    return;
                }
                String obj2 = obj instanceof String ? obj.toString() : "";
                if (a11 != null && a11.p() != null) {
                    obj2 = a11.p().g();
                }
                com.mbridge.msdk.videocommon.a.a(p11);
                com.mbridge.msdk.videocommon.a.a();
                if (r11) {
                    this.f37212a.a();
                }
                o11.onVideoLoadFail(g11, obj2);
                return;
            case 17:
                if (o11 == null || !s11) {
                    return;
                }
                if (r11) {
                    this.f37212a.a();
                }
                o11.onLoadSuccess(g11);
                return;
            case 1001001:
                this.f37212a.a(false, d.b().a(0, t11 ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94, p11, true, 1));
                return;
            case 1001002:
                if (n11 != null) {
                    if (n11.l()) {
                        if (k11 != null) {
                            CopyOnWriteArrayList<CampaignEx> h12 = n11.h();
                            if (h12 != null && h12.size() == 0) {
                                h12 = n11.f();
                            }
                            this.f37212a.a(h12);
                            com.mbridge.msdk.foundation.same.report.metrics.c a13 = this.f37212a.a(h12, a11);
                            if (a13 != null) {
                                a13.b(h12);
                            }
                            k11.d(l11, p11, a13);
                            return;
                        }
                        return;
                    }
                    if (!n11.g(false)) {
                        if (n11.g(true)) {
                            if (!n11.l()) {
                                n11.h(true);
                                return;
                            }
                            if (k11 != null) {
                                n11.f(true);
                                CopyOnWriteArrayList<CampaignEx> h13 = n11.h();
                                if (h13 != null && h13.size() == 0) {
                                    h13 = n11.f();
                                }
                                this.f37212a.a(h13);
                                com.mbridge.msdk.foundation.same.report.metrics.c a14 = this.f37212a.a(h13, a11);
                                if (a14 != null) {
                                    a14.b(h13);
                                }
                                k11.d(l11, p11, a14);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (n11.l()) {
                        if (k11 != null) {
                            n11.f(false);
                            CopyOnWriteArrayList<CampaignEx> h14 = n11.h();
                            if (h14 != null && h14.size() == 0) {
                                h14 = n11.f();
                            }
                            this.f37212a.a(h14);
                            com.mbridge.msdk.foundation.same.report.metrics.c a15 = this.f37212a.a(h14, a11);
                            if (a15 != null) {
                                a15.b(h14);
                            }
                            k11.d(l11, p11, a15);
                            return;
                        }
                        return;
                    }
                    n11.h(false);
                    if (n11.g(true)) {
                        if (!n11.l()) {
                            n11.h(true);
                            return;
                        }
                        if (k11 != null) {
                            n11.f(true);
                            CopyOnWriteArrayList<CampaignEx> h15 = n11.h();
                            if (h15 != null && h15.size() == 0) {
                                h15 = n11.f();
                            }
                            this.f37212a.a(h15);
                            com.mbridge.msdk.foundation.same.report.metrics.c a16 = this.f37212a.a(h15, a11);
                            if (a16 != null) {
                                a16.b(h15);
                            }
                            k11.d(l11, p11, a16);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
