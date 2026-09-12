package com.mbridge.msdk.tracker.network;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes5.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static String f38618a = "TrackManager_Volley";

    /* renamed from: b, reason: collision with root package name */
    private static final String f38619b = "com.mbridge.msdk.tracker.network.c0";

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i11 = 2;
        while (true) {
            if (i11 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i11].getClassName().equals(f38619b)) {
                String className = stackTrace[i11].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i11].getMethodName();
                break;
            }
            i11++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void a(Throwable th2, String str, Object... objArr) {
        Log.e(f38618a, a(str, objArr), th2);
    }

    public static void b(String str, Object... objArr) {
        a(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        Log.e(f38618a, a(str, objArr));
    }

    public static void d(String str, Object... objArr) {
    }
}
