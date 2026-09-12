package com.transsion.rewardscenter.utils;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    private static Context f51366b;

    /* renamed from: a, reason: collision with root package name */
    public static final o f51365a = new o();

    /* renamed from: c, reason: collision with root package name */
    public static final int f51367c = 8;

    private o() {
    }

    public final boolean a(Context context, String packageName) {
        Intrinsics.h(context, "context");
        Intrinsics.h(packageName, "packageName");
        if (f51366b == null) {
            b(context);
        }
        try {
            Context context2 = f51366b;
            if (context2 == null) {
                Intrinsics.z("applicationContext");
                context2 = null;
            }
            return context2.getPackageManager().getApplicationInfo(packageName, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void b(Context context) {
        Intrinsics.h(context, "context");
        f51366b = context.getApplicationContext();
    }
}
