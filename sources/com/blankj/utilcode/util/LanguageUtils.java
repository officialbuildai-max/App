package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class LanguageUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Activity activity) {
        String c11 = e0.r().c("KEY_LOCALE");
        if (TextUtils.isEmpty(c11)) {
            return;
        }
        Locale b11 = "VALUE_FOLLOW_SYSTEM".equals(c11) ? b(Resources.getSystem().getConfiguration()) : g(c11);
        if (b11 == null) {
            return;
        }
        i(activity, b11);
        i(Utils.a(), b11);
    }

    private static Locale b(Configuration configuration) {
        LocaleList locales;
        Locale locale;
        if (Build.VERSION.SDK_INT < 24) {
            return configuration.locale;
        }
        locales = configuration.getLocales();
        locale = locales.get(0);
        return locale;
    }

    private static boolean c(String str) {
        int i11 = 0;
        for (char c11 : str.toCharArray()) {
            if (c11 == '$') {
                if (i11 >= 1) {
                    return false;
                }
                i11++;
            }
        }
        return i11 == 1;
    }

    private static boolean d(Locale locale, Locale locale2) {
        return e0.e(locale2.getLanguage(), locale.getLanguage()) && e0.e(locale2.getCountry(), locale.getCountry());
    }

    static void e(final Locale locale, final int i11, final Utils.b bVar) {
        Resources resources = Utils.a().getResources();
        Configuration configuration = resources.getConfiguration();
        Locale b11 = b(configuration);
        f(configuration, locale);
        Utils.a().getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        if (bVar == null) {
            return;
        }
        if (d(b11, locale)) {
            bVar.accept(Boolean.TRUE);
        } else if (i11 < 20) {
            e0.K(new Runnable() { // from class: com.blankj.utilcode.util.LanguageUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    LanguageUtils.e(locale, i11 + 1, bVar);
                }
            }, 16L);
        } else {
            Log.e("LanguageUtils", "appLocal didn't update.");
            bVar.accept(Boolean.FALSE);
        }
    }

    private static void f(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }

    private static Locale g(String str) {
        Locale h11 = h(str);
        if (h11 == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            e0.r().f("KEY_LOCALE");
        }
        return h11;
    }

    private static Locale h(String str) {
        if (!c(str)) {
            return null;
        }
        try {
            int indexOf = str.indexOf("$");
            return new Locale(str.substring(0, indexOf), str.substring(indexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    private static void i(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        f(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
