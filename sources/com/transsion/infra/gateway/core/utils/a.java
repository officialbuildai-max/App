package com.transsion.infra.gateway.core.utils;

import android.content.Context;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f46079a;

    public static Context a() {
        Context context = f46079a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }

    public static void b(Context context) {
        if (f46079a != null) {
            return;
        }
        f46079a = context.getApplicationContext();
    }
}
