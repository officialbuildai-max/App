package com.bytedance.sdk.component.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class dx {
    private static String Sj;

    private static String Sj() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            processName = Application.getProcessName();
            return processName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean Sj(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return false;
        }
        return TextUtils.equals(context.getApplicationContext().getPackageName(), sP(context));
    }

    private static String sP() {
        try {
            Method declaredMethod = Class.forName(ProcessUtils.ACTIVITY_THREAD, false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String sP(Context context) {
        if (!TextUtils.isEmpty(Sj)) {
            return Sj;
        }
        String Sj2 = Sj();
        Sj = Sj2;
        if (!TextUtils.isEmpty(Sj2)) {
            return Sj;
        }
        String sP = sP();
        Sj = sP;
        return !TextUtils.isEmpty(sP) ? Sj : Sj;
    }
}
