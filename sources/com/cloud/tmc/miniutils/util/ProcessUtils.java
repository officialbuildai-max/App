package com.cloud.tmc.miniutils.util;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ProcessUtils {
    private ProcessUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getCurrentProcessName() {
        String currentProcessNameByFile = getCurrentProcessNameByFile();
        if (!TextUtils.isEmpty(currentProcessNameByFile)) {
            return currentProcessNameByFile;
        }
        String currentProcessNameByAms = getCurrentProcessNameByAms();
        return !TextUtils.isEmpty(currentProcessNameByAms) ? currentProcessNameByAms : getCurrentProcessNameByReflect();
    }

    private static String getCurrentProcessNameByAms() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) Utils.getApp().getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid && (str = runningAppProcessInfo.processName) != null) {
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getCurrentProcessNameByFile() {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            r2.<init>()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            java.lang.String r3 = "/proc/"
            r2.append(r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            int r3 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            r2.append(r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            java.lang.String r3 = "/cmdline"
            r2.append(r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r2.close()     // Catch: java.io.IOException -> L36
            goto L3a
        L36:
            r1 = move-exception
            r1.printStackTrace()
        L3a:
            return r0
        L3b:
            r0 = move-exception
            goto L56
        L3d:
            r0 = move-exception
            goto L46
        L3f:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L56
        L43:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L46:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = ""
            if (r2 == 0) goto L55
            r2.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r1 = move-exception
            r1.printStackTrace()
        L55:
            return r0
        L56:
            if (r2 == 0) goto L60
            r2.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r1 = move-exception
            r1.printStackTrace()
        L60:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniutils.util.ProcessUtils.getCurrentProcessNameByFile():java.lang.String");
    }

    private static String getCurrentProcessNameByReflect() {
        try {
            Application app = Utils.getApp();
            Field field = app.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(app);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod(com.cloud.tmc.kernel.utils.ProcessUtils.GET_PROCESS_NAME, null).invoke(obj2, null);
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static boolean isMainProcess() {
        return Utils.getApp().getPackageName().equals(getCurrentProcessName());
    }

    public static boolean isMiniProcess() {
        try {
            String currentProcessName = getCurrentProcessName();
            if (currentProcessName == null || TextUtils.isEmpty(currentProcessName)) {
                return false;
            }
            return currentProcessName.contains(":mini");
        } catch (Throwable th2) {
            Log.e("isMiniProcess", "isMiniProcess: ", th2);
            return false;
        }
    }
}
