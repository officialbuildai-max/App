package com.google.android.exoplayer2.util;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static Method f27612a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f27613b;

    public static IBinder a(Bundle bundle, String str) {
        return p0.f27680a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    private static IBinder b(Bundle bundle, String str) {
        Method method = f27612a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f27612a = method2;
                method2.setAccessible(true);
                method = f27612a;
            } catch (NoSuchMethodException e11) {
                s.g("BundleUtil", "Failed to retrieve getIBinder method", e11);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e12) {
            s.g("BundleUtil", "Failed to invoke getIBinder via reflection", e12);
            return null;
        }
    }

    public static void c(Bundle bundle, String str, IBinder iBinder) {
        if (p0.f27680a >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            d(bundle, str, iBinder);
        }
    }

    private static void d(Bundle bundle, String str, IBinder iBinder) {
        Method method = f27613b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                f27613b = method2;
                method2.setAccessible(true);
                method = f27613b;
            } catch (NoSuchMethodException e11) {
                s.g("BundleUtil", "Failed to retrieve putIBinder method", e11);
                return;
            }
        }
        try {
            method.invoke(bundle, str, iBinder);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e12) {
            s.g("BundleUtil", "Failed to invoke putIBinder via reflection", e12);
        }
    }
}
