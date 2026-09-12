package com.pgl.ssdk;

import android.os.Handler;

/* loaded from: classes5.dex */
public class o0 {
    public static Handler a() {
        return x0.a().b();
    }

    public static void a(Runnable runnable) {
        Handler a11;
        if (runnable == null || (a11 = a()) == null) {
            return;
        }
        a11.post(runnable);
    }

    public static Handler b() {
        return x0.a().c();
    }

    public static void b(Runnable runnable) {
        Handler b11;
        if (runnable == null || (b11 = b()) == null) {
            return;
        }
        b11.post(runnable);
    }
}
