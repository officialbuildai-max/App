package com.pgl.ssdk;

import android.content.Context;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: classes5.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f40140a;

    /* renamed from: b, reason: collision with root package name */
    public static int f40141b;

    /* renamed from: c, reason: collision with root package name */
    public static int f40142c;

    /* renamed from: d, reason: collision with root package name */
    private static int f40143d;

    /* renamed from: e, reason: collision with root package name */
    private static int f40144e;

    /* renamed from: f, reason: collision with root package name */
    private static int f40145f;

    private static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f40143d = (int) displayMetrics.density;
            f40142c = displayMetrics.densityDpi;
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context) {
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f40144e = (int) displayMetrics.xdpi;
            f40145f = (int) displayMetrics.ydpi;
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            f40140a = point.x;
            f40141b = point.y;
        } catch (Throwable unused) {
        }
    }

    public static String d(Context context) {
        int i11 = -1;
        if (context != null) {
            try {
                i11 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            } catch (Throwable unused) {
            }
        }
        return String.valueOf(i11);
    }

    public static String e(Context context) {
        try {
            c(context);
            a(context);
            b(context);
        } catch (Throwable unused) {
        }
        return f40142c + "[<!>]" + f40140a + "," + f40141b + "[<!>]";
    }
}
