package com.blankj.utilcode.util;

import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Locale;

/* loaded from: classes2.dex */
public class g0 {
    public static boolean a() {
        Locale locale;
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = Utils.a().getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = Utils.a().getResources().getConfiguration().locale;
        }
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1;
    }

    public static View b(int i11) {
        return ((LayoutInflater) Utils.a().getSystemService("layout_inflater")).inflate(i11, (ViewGroup) null);
    }
}
