package com.cloud.sdk.commonutil.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Context f23269a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f23270b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f23271c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile long f23272d;

    public static Context a() {
        if (f23269a == null) {
            c.Log().e("u should init first");
        }
        return f23269a;
    }

    public static File b(Context context) {
        boolean z10 = true;
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            z10 = declaredField.getBoolean(new Environment());
        } catch (Exception unused) {
        }
        if (z10) {
            return null;
        }
        try {
            return context.getExternalCacheDir();
        } catch (Exception e11) {
            c.Log().e("ssp", "getExternalCacheDir error: " + Log.getStackTraceString(e11));
            return null;
        }
    }

    public static long c() {
        return f23272d;
    }

    public static String d() {
        return f23269a == null ? "" : a().getPackageName();
    }

    public static int e() {
        Context a11 = a();
        if (a11 == null) {
            return -1;
        }
        try {
            PackageInfo packageInfo = a11.getPackageManager().getPackageInfo(a11.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception e11) {
            c.Log().e("ssp", "getVersionCode error: " + Log.getStackTraceString(e11));
            return -1;
        }
    }

    public static String f() {
        Context a11 = a();
        if (a11 == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = a11.getPackageManager().getPackageInfo(a11.getPackageName(), 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception e11) {
            c.Log().e("ssp", "getVersionCode error: " + Log.getStackTraceString(e11));
            return "";
        }
    }

    public static synchronized void g(Context context) {
        synchronized (e.class) {
            if (!h()) {
                f23271c = true;
                f23269a = context.getApplicationContext();
                i.a(a());
                f23272d = System.currentTimeMillis();
                c.Log().d("HSCoreUtil", "init time is " + f23272d);
            }
        }
    }

    public static boolean h() {
        return f23271c && f23269a != null;
    }

    public static void i(Context context) {
        try {
            f23269a = context.getApplicationContext();
        } catch (Throwable unused) {
            c.Log().e("context is null, please check it");
        }
    }

    public static void j(boolean z10) {
        f23270b = z10;
    }
}
