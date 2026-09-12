package gg;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f63690a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static String f63691b;

    /* renamed from: c, reason: collision with root package name */
    private static String f63692c;

    /* renamed from: d, reason: collision with root package name */
    private static int f63693d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f63694e;

    private b() {
    }

    private final String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("================");
        stringBuffer.append(f63692c);
        stringBuffer.append("(");
        stringBuffer.append(f63691b);
        stringBuffer.append(":");
        stringBuffer.append(f63693d);
        stringBuffer.append(")================:");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private final void f(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement stackTraceElement;
        StackTraceElement stackTraceElement2;
        f63691b = (stackTraceElementArr == null || (stackTraceElement = stackTraceElementArr[1]) == null) ? null : stackTraceElement.getFileName();
        f63692c = (stackTraceElementArr == null || (stackTraceElement2 = stackTraceElementArr[1]) == null) ? null : stackTraceElement2.getMethodName();
        StackTraceElement stackTraceElement3 = stackTraceElementArr != null ? stackTraceElementArr[1] : null;
        Intrinsics.e(stackTraceElement3);
        f63693d = stackTraceElement3.getLineNumber();
    }

    public final void b(String str) {
        if (f63694e) {
            f(new Throwable().getStackTrace());
            Intrinsics.e(a(str));
        }
    }

    public final void c(String str) {
        f(new Throwable().getStackTrace());
        String str2 = f63691b;
        String a11 = a(str);
        Intrinsics.e(a11);
        Log.e(str2, a11);
    }

    public final void d(String tag, String str) {
        Intrinsics.h(tag, "tag");
        Log.e(tag, String.valueOf(str));
    }

    public final void e(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        if (th2 != null) {
            try {
                th2.printStackTrace(printWriter);
                Unit unit = Unit.f67184a;
            } finally {
            }
        }
        CloseableKt.a(printWriter, null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.g(stringWriter2, "sw.toString()");
        c(stringWriter2);
    }

    public final void g(String str) {
        if (f63694e) {
            f(new Throwable().getStackTrace());
            Intrinsics.e(a(str));
        }
    }

    public final void h(boolean z10) {
        f63694e = z10;
    }

    public final void i(String str) {
        if (f63694e) {
            f(new Throwable().getStackTrace());
            String str2 = f63691b;
            String a11 = a(str);
            Intrinsics.e(a11);
            Log.w(str2, a11);
        }
    }
}
