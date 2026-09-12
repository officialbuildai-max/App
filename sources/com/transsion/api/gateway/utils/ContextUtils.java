package com.transsion.api.gateway.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ContextUtils {

    @SuppressLint({"StaticFieldLeak"})
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static void init(@NonNull Context context2) {
        if (context != null) {
            return;
        }
        context = context2.getApplicationContext();
    }
}
