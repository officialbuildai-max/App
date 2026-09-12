package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static long f8254a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f8255b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f8256c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f8257d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f8258e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f8254a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f8255b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f8256c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f8257d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f8258e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
