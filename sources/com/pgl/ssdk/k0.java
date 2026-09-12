package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes5.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f40224a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f40225b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f40226c = "api16-access-ttp.tiktokpangle.us";

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f40227d = {"api16-access-ttp.tiktokpangle.us", "api16-access-ttp-b.tiktokpangle.us", "api16-access-ttp.tiktokpangle-b.us", "api16-access-ttp-b.tiktokpangle-b.us"};

    /* renamed from: e, reason: collision with root package name */
    private static int f40228e = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public static String f40229f = "";

    public static String a() {
        return f40224a == 1 ? "VA" : "SG";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f40225b)) {
            return f40225b;
        }
        try {
            if (f40228e == Integer.MIN_VALUE) {
                f40228e = u0.a(context, "domain_index", 0);
            }
            String[] strArr = f40227d;
            return strArr[f40228e % strArr.length];
        } catch (Throwable unused) {
            return f40226c;
        }
    }

    public static void a(int i11) {
        f40224a = i11;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f40225b = str;
    }

    public static String b() {
        return f40229f;
    }

    public static void b(Context context) {
        if (TextUtils.isEmpty(f40225b)) {
            r0.a("updateIndex");
            int i11 = f40228e;
            if (i11 >= Integer.MAX_VALUE) {
                f40228e = 0;
                return;
            }
            int i12 = i11 + 1;
            f40228e = i12;
            u0.b(context, "domain_index", i12);
        }
    }

    public static void b(String str) {
        f40229f = str;
    }
}
