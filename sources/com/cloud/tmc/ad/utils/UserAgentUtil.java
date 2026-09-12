package com.cloud.tmc.ad.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.player.BuildConfig;
import com.cloud.tmc.kernel.utils.TraceLog;
import java.util.Locale;

/* loaded from: classes3.dex */
public class UserAgentUtil {

    /* renamed from: ua, reason: collision with root package name */
    private static String f23332ua = "";

    private static boolean checkAgent() {
        try {
            if (TextUtils.isEmpty(f23332ua)) {
                init();
            }
            if (f23332ua.contains("windows NT") || f23332ua.contains("Macintosh")) {
                return false;
            }
            return !f23332ua.contains("Dalvik");
        } catch (Throwable th2) {
            TraceLog.e(CommonLogUtil.TAG_AD, "checkAgent is error , error msg is :=" + Log.getStackTraceString(th2));
            return false;
        }
    }

    private static String getDefaultUserAgent() {
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(BuildConfig.VERSION_NAME);
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            if (str2.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str2);
            }
        }
        String str3 = Build.ID;
        if (str3.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str3);
        }
        return String.format("Mozilla/5.0 (Linux; Android %s;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36", stringBuffer);
    }

    public static String getUserAgent() {
        try {
            return checkAgent() ? f23332ua : "";
        } catch (Throwable th2) {
            TraceLog.e(CommonLogUtil.TAG_AD, "UserAgentUtil getUserAgent is error , error infor is :=" + Log.getStackTraceString(th2));
            return "";
        }
    }

    public static void init() {
        try {
            if (TextUtils.isEmpty(f23332ua)) {
                f23332ua = getDefaultUserAgent();
            }
        } catch (Throwable th2) {
            TraceLog.e(CommonLogUtil.TAG_AD, "init is error , error infor is :=" + Log.getStackTraceString(th2));
        }
    }
}
