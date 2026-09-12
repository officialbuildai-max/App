package com.transsion.player.longvideo.intercept;

import com.therouter.TheRouter;
import com.transsion.memberapi.IPremiumApi;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f48177a = new e();

    private e() {
    }

    public final void a() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        bVar.b().putString("Nxib7sg2tb5K4j6W", ti.p.f76389a.c());
        bVar.b().putInt("wq7I447J58315o5d", bVar.b().getInt("wq7I447J58315o5d", 0) + 1);
    }

    public final int b() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        if (Intrinsics.c(bVar.b().getString("Nxib7sg2tb5K4j6W", ""), ti.p.f76389a.c())) {
            return bVar.b().getInt("wq7I447J58315o5d", 0);
        }
        bVar.b().putInt("wq7I447J58315o5d", 0);
        return 0;
    }

    public final boolean c() {
        int b11 = b();
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        int x10 = iPremiumApi != null ? iPremiumApi.x() : 0;
        a.C0856a.f(lg.a.f68962a, "premium_p", "PlaybackFreeTimesManager --> hasFreePlaybackTimes() --> freeTimesCount = " + b11 + " --> freePlaybackTimes = " + x10, false, 4, null);
        return x10 > b11;
    }
}
