package com.bytedance.sdk.component.adexpress.EjP;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.ib;
import java.util.Locale;

/* loaded from: classes2.dex */
public class Jcg {
    private static boolean Sj;

    private static float EjP(Context context) {
        try {
            if (Sj) {
                context.getClassLoader().loadClass("android.util.DisplayMetrics").getDeclaredMethod("getDeviceDensity", null).setAccessible(true);
                return ((Integer) r1.invoke(r0, null)).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static float Sj(Context context, float f11) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        return (f11 * EjP(context)) + 0.5f;
    }

    public static int Sj(float f11, float f12, float f13, float f14) {
        return (((int) ((f11 * 255.0f) + 0.5f)) << 24) | (((int) ((f12 * 255.0f) + 0.5f)) << 16) | (((int) ((f13 * 255.0f) + 0.5f)) << 8) | ((int) ((f14 * 255.0f) + 0.5f));
    }

    public static int Sj(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static String Sj(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 3121:
                if (str.equals("ar")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3383:
                if (str.equals("ja")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3428:
                if (str.equals("ko")) {
                    c11 = 2;
                    break;
                }
                break;
            case 3494:
                if (str.equals("ms")) {
                    c11 = 3;
                    break;
                }
                break;
            case 3886:
                if (str.equals("zh")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return "aa";
            case 1:
                return "japan";
            case 2:
                return "korea";
            case 3:
                return "my";
            case 4:
                return "cn";
            default:
                return str;
        }
    }

    public static float TKC(Context context, float f11) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        return f11 * EjP(context);
    }

    public static String TKC(@NonNull Context context) {
        String str;
        Locale locale;
        LocaleList locales;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locales = ib.sP(context).getConfiguration().getLocales();
                locale = locales.get(0);
            } else {
                locale = Locale.getDefault();
            }
            str = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    str = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return Sj(str);
    }

    public static int sP(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int sP(Context context, float f11) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP();
        }
        float EjP = EjP(context);
        if (EjP <= 0.0f) {
            EjP = 1.0f;
        }
        return (int) ((f11 / EjP) + 0.5f);
    }
}
