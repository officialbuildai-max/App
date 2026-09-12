package com.transsion.al.ka;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SystemApiUtil {
    private static final String GET_AUTO_METHOD = "get_auto_method";
    private static final String GET_LINK_METHOD = "get_Link_method";
    private static final String GET_TYPE = "get";
    private static final String KEY_EMUI_API_LEVEL = "ro.build.hw_emui_api_level";
    private static final String KEY_EMUI_CONFIG_HW_SYS_VERSION = "ro.confg.hw_systemversion";
    private static final String KEY_EMUI_VERSION = "ro.build.version.emui";
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String SET_AUTO_METHOD = "set_auto_method";
    private static final String SET_LINK_METHOD = "set_Link_method";
    private static final String SET_TYPE = "set";
    private static final String SP_AUTO_START = "auto_start";
    private static final String SP_LINK_START = "link_start";
    public static final String SYS_EMUI = "sys_emui";
    public static final String SYS_FLYME = "sys_flyme";
    public static final String SYS_MIUI = "sys_miui";
    private static String sysName;

    public static List<String> getAutoStartList(ActivityManager activityManager) {
        List<String> list = null;
        try {
            list = (List) activityManager.getClass().getMethod("getAutoStartList", null).invoke(activityManager, null);
        } catch (Throwable unused) {
        }
        return list == null ? new ArrayList() : list;
    }

    public static List<String> getForbiddenAutoRunPackages(Context context) {
        ArrayList arrayList = new ArrayList();
        Method forceStopMethod = getForceStopMethod(context, GET_AUTO_METHOD, GET_TYPE);
        if (forceStopMethod != null) {
            try {
                return (ArrayList) forceStopMethod.invoke((ActivityManager) context.getSystemService("activity"), null);
            } catch (Throwable unused) {
                return arrayList;
            }
        }
        Map<String, ?> all = context.getSharedPreferences(SP_AUTO_START, 0).getAll();
        if (all == null || all.isEmpty()) {
            return arrayList;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry != null && ((Boolean) entry.getValue()).booleanValue()) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public static List<String> getForbiddenLinkRunPackages(Context context) {
        ArrayList arrayList = new ArrayList();
        Method forceStopMethod = getForceStopMethod(context, GET_LINK_METHOD, GET_TYPE);
        if (forceStopMethod != null) {
            try {
                return (ArrayList) forceStopMethod.invoke((ActivityManager) context.getSystemService("activity"), null);
            } catch (Throwable unused) {
                return arrayList;
            }
        }
        Map<String, ?> all = context.getSharedPreferences(SP_LINK_START, 0).getAll();
        if (all == null || all.isEmpty()) {
            return arrayList;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry != null && ((Boolean) entry.getValue()).booleanValue()) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    private static Method getForceStopMethod(Context context, String str, String str2) {
        ActivityManager activityManager;
        char c11;
        synchronized (SystemApiUtil.class) {
            try {
                activityManager = (ActivityManager) context.getSystemService("activity");
            } catch (Throwable unused) {
            }
            if (activityManager == null) {
                return null;
            }
            switch (str.hashCode()) {
                case -584672760:
                    if (str.equals(GET_AUTO_METHOD)) {
                        c11 = 1;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 326079764:
                    if (str.equals(SET_AUTO_METHOD)) {
                        c11 = 0;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 433280317:
                    if (str.equals(GET_LINK_METHOD)) {
                        c11 = 3;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 1344032841:
                    if (str.equals(SET_LINK_METHOD)) {
                        c11 = 2;
                        break;
                    }
                    c11 = 65535;
                    break;
                default:
                    c11 = 65535;
                    break;
            }
            String str3 = c11 != 0 ? c11 != 1 ? c11 != 2 ? c11 != 3 ? null : "getForbiddenLinkRunPackages" : "setForbiddenLinkRunPackages" : "getForbiddenAutoRunPackages" : "setForbiddenAutoRunPackages";
            if (str3 != null) {
                if (SET_TYPE.equals(str2)) {
                    return activityManager.getClass().getMethod(str3, String.class, Boolean.TYPE);
                }
                return activityManager.getClass().getMethod(str3, null);
            }
            return null;
        }
    }

    public static String getMeizuFlymeOSFlag() {
        return getSystemProperty("ro.build.display.id", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getMiuiVersionName() {
        /*
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            r3 = 0
            if (r1 >= r2) goto L2e
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L28
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L28
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = "build.prop"
            r2.<init>(r4, r5)     // Catch: java.lang.Throwable -> L28
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L28
            r0.load(r1)     // Catch: java.lang.Throwable -> L29
            r1.close()     // Catch: java.lang.Throwable -> L23
            goto L2e
        L23:
            r1 = move-exception
            r1.printStackTrace()
            goto L2e
        L28:
            r1 = r3
        L29:
            if (r1 == 0) goto L2e
            r1.close()     // Catch: java.lang.Throwable -> L23
        L2e:
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r0 = r0.getProperty(r1, r3)
            if (r0 != 0) goto L3a
            java.lang.String r0 = getSystemProperty(r1, r3)
        L3a:
            if (r0 == 0) goto L40
            java.lang.String r0 = r0.toLowerCase()
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.al.ka.SystemApiUtil.getMiuiVersionName():java.lang.String");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:13|14|(7:21|(6:28|(1:34)|35|36|37|38)|41|35|36|37|38)|42|35|36|37|38) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getSystem() {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r2 = com.transsion.al.ka.SystemApiUtil.sysName
            if (r2 == 0) goto L9
            return r2
        L9:
            r2 = 0
            java.lang.String r3 = getSystemProperty(r1, r0)     // Catch: java.lang.Throwable -> L93
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = "sys_miui"
            if (r0 != 0) goto L17
            return r3
        L17:
            java.util.Properties r0 = new java.util.Properties     // Catch: java.lang.Throwable -> L93
            r0.<init>()     // Catch: java.lang.Throwable -> L93
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L93
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L93
            java.io.File r6 = android.os.Environment.getRootDirectory()     // Catch: java.lang.Throwable -> L93
            java.lang.String r7 = "build.prop"
            r5.<init>(r6, r7)     // Catch: java.lang.Throwable -> L93
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L93
            r0.load(r4)     // Catch: java.lang.Throwable -> L84
            java.lang.String r5 = "ro.miui.ui.version.code"
            java.lang.String r5 = r0.getProperty(r5, r2)     // Catch: java.lang.Throwable -> L84
            if (r5 != 0) goto L8b
            java.lang.String r1 = r0.getProperty(r1, r2)     // Catch: java.lang.Throwable -> L84
            if (r1 != 0) goto L8b
            java.lang.String r1 = "ro.miui.internal.storage"
            java.lang.String r1 = r0.getProperty(r1, r2)     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L46
            goto L8b
        L46:
            java.lang.String r1 = "ro.build.hw_emui_api_level"
            java.lang.String r1 = r0.getProperty(r1, r2)     // Catch: java.lang.Throwable -> L84
            if (r1 != 0) goto L86
            java.lang.String r1 = "ro.build.version.emui"
            java.lang.String r1 = r0.getProperty(r1, r2)     // Catch: java.lang.Throwable -> L84
            if (r1 != 0) goto L86
            java.lang.String r1 = "ro.confg.hw_systemversion"
            java.lang.String r0 = r0.getProperty(r1, r2)     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L5f
            goto L86
        L5f:
            java.lang.String r0 = getMeizuFlymeOSFlag()     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L8d
            java.lang.String r0 = getMeizuFlymeOSFlag()     // Catch: java.lang.Throwable -> L84
            java.lang.String r0 = r0.toLowerCase()     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L8d
            java.lang.String r0 = getMeizuFlymeOSFlag()     // Catch: java.lang.Throwable -> L84
            java.lang.String r0 = r0.toLowerCase()     // Catch: java.lang.Throwable -> L84
            java.lang.String r1 = "flyme"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L8d
            java.lang.String r0 = "sys_flyme"
            com.transsion.al.ka.SystemApiUtil.sysName = r0     // Catch: java.lang.Throwable -> L84
            goto L8d
        L84:
            r2 = r4
            goto L93
        L86:
            java.lang.String r0 = "sys_emui"
            com.transsion.al.ka.SystemApiUtil.sysName = r0     // Catch: java.lang.Throwable -> L84
            goto L8d
        L8b:
            com.transsion.al.ka.SystemApiUtil.sysName = r3     // Catch: java.lang.Throwable -> L84
        L8d:
            r4.close()     // Catch: java.lang.Throwable -> L90
        L90:
            java.lang.String r0 = com.transsion.al.ka.SystemApiUtil.sysName
            return r0
        L93:
            java.lang.String r0 = com.transsion.al.ka.SystemApiUtil.sysName     // Catch: java.lang.Throwable -> L9b
            if (r2 == 0) goto L9a
            r2.close()     // Catch: java.lang.Throwable -> L9a
        L9a:
            return r0
        L9b:
            r0 = move-exception
            if (r2 == 0) goto La1
            r2.close()     // Catch: java.lang.Throwable -> La1
        La1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.al.ka.SystemApiUtil.getSystem():java.lang.String");
    }

    private static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(GET_TYPE, String.class, String.class).invoke(cls, str, str2);
        } catch (Throwable th2) {
            c.c(KaManager.TAG, th2, "");
            return str2;
        }
    }

    public static boolean isItel() {
        return "itel".equalsIgnoreCase(Build.MANUFACTURER) || "itel".equalsIgnoreCase(getSystemProperty("ro.tranos.type", ""));
    }

    public static List<String> resetAutoStartList(ActivityManager activityManager) {
        List<String> list = null;
        try {
            list = (List) activityManager.getClass().getMethod("resetAutoStartList", null).invoke(activityManager, null);
        } catch (Throwable unused) {
        }
        return list == null ? new ArrayList() : list;
    }

    public static boolean setAutoStartEnable(ActivityManager activityManager, String str, boolean z10) {
        try {
            activityManager.getClass().getMethod("setAutoStartEnable", String.class, Boolean.TYPE).invoke(activityManager, str, Boolean.valueOf(z10));
            c.a(KaManager.TAG, "hook setAutoStartEnable live success");
            return true;
        } catch (Throwable th2) {
            c.c(KaManager.TAG, th2, "setAutoStartEnable");
            return false;
        }
    }

    public static boolean setCleanProtect(ActivityManager activityManager, String str, boolean z10) {
        try {
            activityManager.getClass().getMethod("setCleanProtect", String.class, Boolean.TYPE).invoke(activityManager, str, Boolean.valueOf(z10));
            c.a(KaManager.TAG, "hook setCleanProtect live success");
            return true;
        } catch (Throwable th2) {
            c.c(KaManager.TAG, th2, "setCleanProtect");
            return false;
        }
    }

    public static void setForbiddenAutoRunPackages(Context context, String str, boolean z10) {
        Method forceStopMethod = getForceStopMethod(context, SET_AUTO_METHOD, SET_TYPE);
        if (forceStopMethod == null) {
            context.getSharedPreferences(SP_AUTO_START, 0).edit().putBoolean(str, z10).apply();
            return;
        }
        try {
            forceStopMethod.invoke((ActivityManager) context.getSystemService("activity"), str, Boolean.valueOf(z10));
            c.a(KaManager.TAG, "hook setForbiddenAutoRunPackages live success");
        } catch (Throwable th2) {
            c.c(KaManager.TAG, th2, "setForbiddenAutoRunPackages");
        }
    }

    public static void setForbiddenLinkRunPackages(Context context, String str, boolean z10) {
        Method forceStopMethod = getForceStopMethod(context, SET_LINK_METHOD, SET_TYPE);
        if (forceStopMethod == null) {
            context.getSharedPreferences(SP_LINK_START, 0).edit().putBoolean(str, z10).apply();
            return;
        }
        try {
            forceStopMethod.invoke((ActivityManager) context.getSystemService("activity"), str, Boolean.valueOf(z10));
        } catch (Throwable th2) {
            c.c(KaManager.TAG, th2, "setForbiddenLinkRunPackages");
        }
    }
}
