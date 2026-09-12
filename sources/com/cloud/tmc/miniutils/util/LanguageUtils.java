package com.cloud.tmc.miniutils.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes3.dex */
public class LanguageUtils {
    private LanguageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Locale getAppContextLanguage() {
        return getContextLanguage(Utils.getApp());
    }

    public static Locale getContextLanguage(Context context) {
        return getLocal(context.getResources().getConfiguration());
    }

    private static Locale getLocal(Configuration configuration) {
        LocaleList locales;
        Locale locale;
        if (Build.VERSION.SDK_INT < 24) {
            return configuration.locale;
        }
        locales = configuration.getLocales();
        locale = locales.get(0);
        return locale;
    }

    public static Locale getSystemLanguage() {
        return getLocal(Resources.getSystem().getConfiguration());
    }
}
