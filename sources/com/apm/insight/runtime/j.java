package com.apm.insight.runtime;

import com.apm.insight.MonitorCrash;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static MonitorCrash f19892a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f19893b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static int f19894c;

    public static MonitorCrash a() {
        if (f19892a == null) {
            MonitorCrash initSDK = MonitorCrash.initSDK(com.apm.insight.e.g(), "239017", 20089L, "2008-20250701130429", "com.apm.insight");
            f19892a = initSDK;
            initSDK.config().setChannel("release");
        }
        return f19892a;
    }

    public static void a(Throwable th2, String str) {
        if (com.apm.insight.e.g() == null) {
            return;
        }
        if (f19893b == -1) {
            f19893b = 5;
        }
        int i11 = f19894c;
        if (i11 < f19893b) {
            f19894c = i11 + 1;
            a().reportCustomErr(str, "INNER", th2);
        }
    }
}
