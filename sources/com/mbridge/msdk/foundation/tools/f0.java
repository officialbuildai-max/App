package com.mbridge.msdk.foundation.tools;

import android.net.ConnectivityManager;

/* loaded from: classes5.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f35791a;

    public static synchronized ConnectivityManager a() {
        ConnectivityManager connectivityManager;
        synchronized (f0.class) {
            try {
                if (f35791a == null && com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    f35791a = (ConnectivityManager) com.mbridge.msdk.foundation.controller.c.m().d().getSystemService("connectivity");
                }
            } catch (Exception e11) {
                o0.b("NetManager", e11.getMessage());
            }
            connectivityManager = f35791a;
        }
        return connectivityManager;
    }
}
