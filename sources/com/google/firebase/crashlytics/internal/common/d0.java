package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f31212a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.firebase.f f31213b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f31214c;

    /* renamed from: d, reason: collision with root package name */
    TaskCompletionSource f31215d;

    /* renamed from: e, reason: collision with root package name */
    boolean f31216e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f31217f;

    /* renamed from: g, reason: collision with root package name */
    private Boolean f31218g;

    /* renamed from: h, reason: collision with root package name */
    private final TaskCompletionSource f31219h;

    public d0(com.google.firebase.f fVar) {
        Object obj = new Object();
        this.f31214c = obj;
        this.f31215d = new TaskCompletionSource();
        this.f31216e = false;
        this.f31217f = false;
        this.f31219h = new TaskCompletionSource();
        Context k11 = fVar.k();
        this.f31213b = fVar;
        this.f31212a = CommonUtils.q(k11);
        Boolean b11 = b();
        this.f31218g = b11 == null ? a(k11) : b11;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f31215d.trySetResult(null);
                    this.f31216e = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private Boolean a(Context context) {
        Boolean g11 = g(context);
        if (g11 == null) {
            this.f31217f = false;
            return null;
        }
        this.f31217f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(g11));
    }

    private Boolean b() {
        if (!this.f31212a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f31217f = false;
        return Boolean.valueOf(this.f31212a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    private boolean e() {
        try {
            return this.f31213b.t();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private void f(boolean z10) {
        ob.g.f().b(String.format("Crashlytics automatic data collection %s by %s.", z10 ? "ENABLED" : "DISABLED", this.f31218g == null ? "global Firebase setting" : this.f31217f ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
    }

    private static Boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e11) {
            ob.g.f().e("Could not read data collection permission from manifest", e11);
            return null;
        }
    }

    private static void i(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (bool != null) {
            edit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            edit.remove("firebase_crashlytics_collection_enabled");
        }
        edit.apply();
    }

    public void c(boolean z10) {
        if (!z10) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f31219h.trySetResult(null);
    }

    public synchronized boolean d() {
        boolean booleanValue;
        try {
            Boolean bool = this.f31218g;
            booleanValue = bool != null ? bool.booleanValue() : e();
            f(booleanValue);
        } catch (Throwable th2) {
            throw th2;
        }
        return booleanValue;
    }

    public synchronized void h(Boolean bool) {
        if (bool != null) {
            try {
                this.f31217f = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f31218g = bool != null ? bool : a(this.f31213b.k());
        i(this.f31212a, bool);
        synchronized (this.f31214c) {
            try {
                if (d()) {
                    if (!this.f31216e) {
                        this.f31215d.trySetResult(null);
                        this.f31216e = true;
                    }
                } else if (this.f31216e) {
                    this.f31215d = new TaskCompletionSource();
                    this.f31216e = false;
                }
            } finally {
            }
        }
    }

    public Task j() {
        Task task;
        synchronized (this.f31214c) {
            task = this.f31215d.getTask();
        }
        return task;
    }

    public Task k() {
        return com.google.firebase.crashlytics.internal.concurrency.b.c(this.f31219h.getTask(), j());
    }
}
