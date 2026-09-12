package com.cloud.hisavana.sdk.common.util;

import kotlin.Unit;

/* loaded from: classes3.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f22238a = new e0();

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f22239b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f22240c;

    private e0() {
    }

    public final String a() {
        return f22239b;
    }

    public final boolean b() {
        return f22240c;
    }

    public final void c(String str) {
        if (f22240c) {
            return;
        }
        synchronized (this) {
            if (f22240c) {
                return;
            }
            f22239b = str;
            f22240c = true;
            Unit unit = Unit.f67184a;
        }
    }
}
