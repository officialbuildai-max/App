package com.mbridge.msdk.reward.report.metrics;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.c;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.videocommon.setting.b;
import java.util.List;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f37247a;

    private a() {
    }

    public static a a() {
        if (f37247a == null) {
            synchronized (a.class) {
                try {
                    if (f37247a == null) {
                        f37247a = new a();
                    }
                } finally {
                }
            }
        }
        return f37247a;
    }

    private void a(c cVar) {
        if (cVar == null) {
            try {
                cVar = new c();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        com.mbridge.msdk.videocommon.setting.a c11 = b.b().c();
        if (c11 != null) {
            cVar.k(c11.a());
            cVar.j(c11.f());
        }
    }

    private void b(c cVar) {
        List<CampaignEx> j11;
        if (cVar == null) {
            return;
        }
        try {
            int a11 = cVar.a();
            String w11 = cVar.w();
            if (TextUtils.isEmpty(w11) && (j11 = cVar.j()) != null && j11.size() > 0 && j11.get(0) != null) {
                w11 = j11.get(0).getCampaignUnitId();
                a11 = j11.get(0).getAdType();
                cVar.a(a11);
                cVar.m(w11);
            }
            com.mbridge.msdk.videocommon.setting.c a12 = b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), w11, a11 == 287);
            if (a12 != null) {
                cVar.l(a12.x());
                cVar.n(a12.a());
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public void a(String str, c cVar) {
        try {
            a(cVar);
            b(cVar);
            d.b().b(cVar);
            d.b().b(str, cVar, null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
