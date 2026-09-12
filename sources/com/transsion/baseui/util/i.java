package com.transsion.baseui.util;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    private static long f43571b;

    /* renamed from: c, reason: collision with root package name */
    private static long f43572c;

    /* renamed from: a, reason: collision with root package name */
    public static final i f43570a = new i();

    /* renamed from: d, reason: collision with root package name */
    public static final int f43573d = 8;

    private i() {
    }

    public final String a(long j11) {
        long currentTimeMillis = (System.currentTimeMillis() - f43572c) / 1000;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 1;
        }
        f43572c = System.currentTimeMillis();
        long j12 = (j11 - f43571b) / currentTimeMillis;
        f43571b = j11;
        if (j12 <= 0) {
            return "0KB/s";
        }
        return oh.b.a(j12, 1) + "/s";
    }
}
