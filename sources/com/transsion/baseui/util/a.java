package com.transsion.baseui.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f43556a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final int f43557b = 8;

    private a() {
    }

    public final float a(Context context, float f11) {
        Intrinsics.h(context, "context");
        return TypedValue.applyDimension(1, f11, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public final int b(Context context) {
        Intrinsics.h(context, "context");
        return oh.h.f71144a.e(context);
    }

    public final boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            Intrinsics.e(str);
            return packageManager.getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
