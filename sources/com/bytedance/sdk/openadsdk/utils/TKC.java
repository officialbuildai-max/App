package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* loaded from: classes3.dex */
public class TKC {
    public static int Sj = -1;

    public static int Sj(Context context, int i11) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context != null) {
            try {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                Resources resources = context.getResources();
                if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null && (configuration = resources.getConfiguration()) != null) {
                    int i12 = configuration.orientation;
                    if (i11 == 0) {
                        i11 = i12;
                    }
                    return i11 == i12 ? Math.round(displayMetrics.heightPixels / displayMetrics.density) : Math.round(displayMetrics.widthPixels / displayMetrics.density);
                }
            } catch (Throwable unused) {
                return Sj;
            }
        }
        return Sj;
    }

    public static int Sj(Context context, int i11, int i12) {
        int Sj2 = Sj(context, i12);
        if (Sj2 == -1) {
            return Sj;
        }
        return Math.max(Math.min(i11 > 655 ? Math.round((i11 / 728.0f) * 90.0f) : i11 > 632 ? 81 : i11 > 526 ? Math.round((i11 / 468.0f) * 60.0f) : i11 > 432 ? 68 : Math.round((i11 / 320.0f) * 50.0f), Math.min(90, Math.round(Sj2 * 0.15f))), 50);
    }
}
