package f4;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f62459a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f62460b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f62461c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f62462d;

    public static void a(String str, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.a(j(str), i11);
        } else {
            b(j(str), i11);
        }
    }

    private static void b(String str, int i11) {
        try {
            if (f62461c == null) {
                f62461c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f62461c.invoke(null, Long.valueOf(f62459a), str, Integer.valueOf(i11));
        } catch (Exception e11) {
            g("asyncTraceBegin", e11);
        }
    }

    public static void c(String str) {
        b.a(j(str));
    }

    public static void d(String str, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.b(j(str), i11);
        } else {
            e(j(str), i11);
        }
    }

    private static void e(String str, int i11) {
        try {
            if (f62462d == null) {
                f62462d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f62462d.invoke(null, Long.valueOf(f62459a), str, Integer.valueOf(i11));
        } catch (Exception e11) {
            g("asyncTraceEnd", e11);
        }
    }

    public static void f() {
        b.b();
    }

    private static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 29 ? c.c() : i();
    }

    private static boolean i() {
        try {
            if (f62460b == null) {
                f62459a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f62460b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f62460b.invoke(null, Long.valueOf(f62459a))).booleanValue();
        } catch (Exception e11) {
            g("isTagEnabled", e11);
            return false;
        }
    }

    private static String j(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
