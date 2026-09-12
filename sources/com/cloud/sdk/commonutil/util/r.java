package com.cloud.sdk.commonutil.util;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.aliyun.player.BuildConfig;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private static String f23298a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f23299b = "";

    private static String a() {
        try {
            if (!e.h()) {
                return "";
            }
            long currentTimeMillis = System.currentTimeMillis() - e.c();
            if (currentTimeMillis >= 5000) {
                return WebSettings.getDefaultUserAgent(e.a());
            }
            c.Log().w("UserAgentUtil", "createNewUserAgent intervalTime is " + currentTimeMillis);
            return "";
        } catch (Throwable th2) {
            c.Log().e("createNewUserAgent is error , error infor is :=" + th2.getMessage());
            return "";
        }
    }

    private static String b() {
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String replace = Build.VERSION.RELEASE.replace(";", "");
        if (replace.length() > 0) {
            stringBuffer.append(replace);
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
            String str = Build.MODEL;
            if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str2);
        }
        return String.format("Mozilla/5.0 (Linux; Android %s;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36", stringBuffer);
    }

    public static String c() {
        try {
            if (d(f23298a)) {
                return f23298a;
            }
            String j11 = j7.a.e().j("user_agent");
            f23298a = j11;
            if (d(j11)) {
                return f23298a;
            }
            String a11 = a();
            f23298a = a11;
            if (d(a11)) {
                j7.a.e().r("user_agent", f23298a);
                return f23298a;
            }
            if (TextUtils.isEmpty(f23299b)) {
                f23299b = b();
            }
            return d(f23299b) ? f23299b : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean d(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 10 || str.contains("windows NT") || str.contains("Macintosh") || str.contains("Dalvik")) ? false : true;
    }
}
