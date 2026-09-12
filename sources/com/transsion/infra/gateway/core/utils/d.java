package com.transsion.infra.gateway.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static d f46081c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f46082a;

    /* renamed from: b, reason: collision with root package name */
    private Context f46083b;

    private d(Context context) {
        this.f46083b = context.getApplicationContext();
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            try {
                if (f46081c == null) {
                    f46081c = new d(context);
                }
                dVar = f46081c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVar;
    }

    private SharedPreferences c(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("gateway_core", 0);
                this.f46082a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception unused) {
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.f46082a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.f46082a = context.getSharedPreferences("gateway_core", 0);
        } catch (Exception unused2) {
        }
        return this.f46082a;
    }

    public long b(String str) {
        Context context = this.f46083b;
        if (context == null) {
            return -1L;
        }
        if (this.f46082a == null) {
            this.f46082a = c(context);
        }
        SharedPreferences sharedPreferences = this.f46082a;
        if (sharedPreferences == null) {
            return -1L;
        }
        try {
            return sharedPreferences.getLong(str, 0L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public void d(String str, long j11) {
        Context context = this.f46083b;
        if (context == null) {
            return;
        }
        if (this.f46082a == null) {
            this.f46082a = c(context);
        }
        SharedPreferences sharedPreferences = this.f46082a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putLong(str, j11).apply();
        } catch (Exception unused) {
        }
    }
}
