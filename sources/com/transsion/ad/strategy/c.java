package com.transsion.ad.strategy;

import android.os.SystemClock;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f42284a = new c();

    private c() {
    }

    public final boolean a() {
        int a11 = com.transsion.ad.scene.b.f42256a.a();
        if (a11 <= 0) {
            return true;
        }
        long j11 = f.f42286a.c().getLong("ad_config_last_request_time", -1L);
        return j11 <= 0 || SystemClock.elapsedRealtime() - j11 >= ((long) a11) * 1000;
    }

    public final void b() {
        f.f42286a.c().putLong("ad_config_last_request_time", SystemClock.elapsedRealtime());
    }
}
