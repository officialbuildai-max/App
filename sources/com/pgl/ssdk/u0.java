package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes5.dex */
public class u0 {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f40268a;

    public static int a(Context context, String str, int i11) {
        SharedPreferences a11 = a(context);
        return a11 != null ? a11.getInt(str, i11) : i11;
    }

    public static SharedPreferences a(Context context) {
        if (f40268a == null) {
            f40268a = context.getSharedPreferences("ss_config", 0);
        }
        return f40268a;
    }

    public static String a(Context context, String str) {
        return a(context, str, "");
    }

    public static String a(Context context, String str, String str2) {
        SharedPreferences a11 = a(context);
        return a11 != null ? a11.getString(str, str2) : str2;
    }

    public static void b(Context context, String str, int i11) {
        SharedPreferences a11 = a(context);
        if (a11 != null) {
            a11.edit().putInt(str, i11).apply();
        }
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences a11 = a(context);
        if (a11 != null) {
            a11.edit().putString(str, str2).apply();
        }
    }
}
