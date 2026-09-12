package com.cloud.sdk.commonutil.util;

import android.util.Log;

/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f23287a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f23288b;

    public static boolean a() {
        if (f23288b) {
            return f23287a;
        }
        boolean z10 = true;
        f23288b = true;
        try {
            String packageName = e.a().getPackageName();
            if (packageName == null) {
                return f23287a;
            }
            c.Log().d("LauncherUtil", "isLauncherHost: packageName = " + packageName);
            if (!packageName.equals("com.transsion.launcher") && !packageName.equals("com.transsion.XOSlauncher")) {
                z10 = false;
            }
            f23287a = z10;
            return z10;
        } catch (Exception e11) {
            c.Log().e("LauncherUtil", "isLauncherHost: " + Log.getStackTraceString(e11));
            return f23287a;
        }
    }
}
