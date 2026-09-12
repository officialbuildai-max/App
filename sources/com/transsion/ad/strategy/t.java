package com.transsion.ad.strategy;

/* loaded from: classes5.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f42302a = new t();

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f42303b;

    private t() {
    }

    public final boolean a() {
        if (f42303b == null) {
            f42303b = Boolean.valueOf(f.f42286a.c().getBoolean("mmkv_key_teen_mode", false));
        }
        Boolean bool = f42303b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void b(boolean z10) {
        f.f42286a.c().putBoolean("mmkv_key_teen_mode", z10);
        f42303b = Boolean.valueOf(z10);
    }
}
