package com.tn.tranpay.helper;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f41702a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static long f41703b;

    /* renamed from: c, reason: collision with root package name */
    private static int f41704c;

    private a() {
    }

    public final boolean a(int i11, long j11) {
        if (f41704c != i11) {
            f41704c = i11;
            f41703b = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - f41703b <= j11) {
            return true;
        }
        f41704c = i11;
        f41703b = System.currentTimeMillis();
        return false;
    }
}
