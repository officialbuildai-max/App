package com.facebook.biddingkit.logging;

import android.content.Context;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f24190a;

    public static void a(Context context, String str, String str2, String str3) {
        try {
            a.b(context, str, str2);
            EventLogDispatcher.j(new i(str3));
            f.f(context);
            c.b();
        } catch (Exception e11) {
            b.d("Logging", "Failed to initialize", e11);
        }
    }

    public static synchronized boolean b() {
        boolean z10;
        synchronized (h.class) {
            z10 = f24190a;
        }
        return z10;
    }
}
