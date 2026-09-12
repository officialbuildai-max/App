package com.blankj.utilcode.util;

import android.os.Vibrator;

/* loaded from: classes2.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    private static Vibrator f20169a;

    private static Vibrator a() {
        if (f20169a == null) {
            f20169a = (Vibrator) Utils.a().getSystemService("vibrator");
        }
        return f20169a;
    }

    public static void b(long j11) {
        Vibrator a11 = a();
        if (a11 == null) {
            return;
        }
        a11.vibrate(j11);
    }
}
