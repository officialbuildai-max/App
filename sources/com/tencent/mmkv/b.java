package com.tencent.mmkv;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes5.dex */
abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f40617a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f40617a)) {
            return f40617a;
        }
        String d11 = d();
        f40617a = d11;
        if (!TextUtils.isEmpty(d11)) {
            return f40617a;
        }
        String c11 = c();
        f40617a = c11;
        if (!TextUtils.isEmpty(c11)) {
            return f40617a;
        }
        String b11 = b(context);
        f40617a = b11;
        return b11;
    }

    private static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private static String c() {
        try {
            Method declaredMethod = Class.forName(ProcessUtils.ACTIVITY_THREAD).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            return invoke instanceof String ? (String) invoke : "";
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    private static String d() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return "";
        }
        processName = Application.getProcessName();
        return processName;
    }
}
