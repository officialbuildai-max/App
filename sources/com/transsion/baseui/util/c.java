package com.transsion.baseui.util;

import android.os.SystemClock;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static long f43559b;

    /* renamed from: c, reason: collision with root package name */
    private static int f43560c;

    /* renamed from: a, reason: collision with root package name */
    public static final c f43558a = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final int f43561d = 8;

    private c() {
    }

    public final boolean a(int i11, long j11) {
        if (f43560c != i11) {
            f43560c = i11;
            f43559b = SystemClock.elapsedRealtime();
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f43559b <= j11) {
            return true;
        }
        f43560c = i11;
        f43559b = elapsedRealtime;
        return false;
    }
}
