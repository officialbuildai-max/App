package com.google.android.libraries.places.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class zznd {
    private static final Object zza;
    private static final Method zzb;
    private static final Method zzc;

    static {
        Object zzb2 = zzb();
        zza = zzb2;
        zzb = zzb2 == null ? null : zzc("getStackTraceElement", Throwable.class, Integer.TYPE);
        zzc = zzb2 != null ? zzd(zzb2) : null;
    }

    public static void zza(Throwable th2) {
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
    }

    private static Object zzb() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzc(String str, Class... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzd(Object obj) {
        try {
            Method zzc2 = zzc("getStackTraceDepth", Throwable.class);
            if (zzc2 == null) {
                return null;
            }
            zzc2.invoke(obj, new Throwable());
            return zzc2;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }
}
