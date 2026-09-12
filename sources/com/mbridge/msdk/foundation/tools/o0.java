package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

/* loaded from: classes5.dex */
public class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f35827a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f35828b = true;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f35829c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f35830d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f35831e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f35832f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f35833g = true;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f35834h = true;

    static {
        if (MBridgeConstans.DEBUG) {
            return;
        }
        f35833g = false;
        f35827a = false;
        f35829c = false;
        f35834h = false;
        f35828b = false;
        f35832f = false;
        f35831e = false;
        f35830d = false;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "MBRIDGE_" + str;
    }

    public static void a(String str, String str2) {
        if (!f35827a || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void a(String str, String str2, Throwable th2) {
        if (!f35827a || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void a(String str, Throwable th2) {
        if (!f35834h || th2 == null) {
            return;
        }
        Log.w(a(str), th2);
    }

    public static void b(String str, String str2) {
        if (!f35828b || str2 == null) {
            return;
        }
        Log.e(a(str), str2);
    }

    public static void b(String str, String str2, Throwable th2) {
        if (!f35828b || str2 == null || th2 == null) {
            return;
        }
        Log.e(a(str), str2, th2);
    }

    public static void c(String str, String str2) {
        if (!f35829c || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void c(String str, String str2, Throwable th2) {
        if (!f35834h || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2, th2);
    }

    public static void d(String str, String str2) {
        if (!f35834h || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2);
    }
}
