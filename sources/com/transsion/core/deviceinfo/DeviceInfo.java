package com.transsion.core.deviceinfo;

import android.content.Context;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.transsion.core.log.LogUtils;
import com.transsion.core.utils.c;

/* loaded from: classes.dex */
public class DeviceInfo {

    /* renamed from: a, reason: collision with root package name */
    private static String f44066a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f44067b = "";

    public static String c() {
        if (!TextUtils.isEmpty(f44067b)) {
            return f44067b;
        }
        String string = Settings.Secure.getString(qk.a.a().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            string = string.trim();
        }
        String a11 = TextUtils.isEmpty(string) ? "" : c.a(string);
        f44067b = a11;
        return a11;
    }

    public static String d() {
        String str = f44066a;
        if (str == null || str.length() == 0) {
            new Thread(new Runnable() { // from class: com.transsion.core.deviceinfo.DeviceInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String unused = DeviceInfo.f44066a = a.a(qk.a.a()).a();
                        LogUtils.g("advertisingId is " + DeviceInfo.f44066a);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            }).start();
        }
        return f44066a;
    }

    public static String e() {
        if (g()) {
            return d();
        }
        String str = f44066a;
        if (str != null && str.length() != 0) {
            return f44066a;
        }
        try {
            f44066a = a.a(qk.a.a()).a();
            LogUtils.g("advertisingId is " + f44066a);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return f44066a;
    }

    public static String f() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) qk.a.a().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean g() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean h() {
        Context a11 = qk.a.a();
        return a11.getResources() != null && (a11.getResources().getConfiguration().screenLayout & 15) >= 3;
    }
}
