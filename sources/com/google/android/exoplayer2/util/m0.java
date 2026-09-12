package com.google.android.exoplayer2.util;

import android.os.Trace;

/* loaded from: classes3.dex */
public abstract class m0 {
    public static void a(String str) {
        if (p0.f27680a >= 18) {
            b(str);
        }
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (p0.f27680a >= 18) {
            d();
        }
    }

    private static void d() {
        Trace.endSection();
    }
}
