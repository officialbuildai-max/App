package kotlin;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b {
    public static void a(Throwable th2, Throwable exception) {
        Intrinsics.h(th2, "<this>");
        Intrinsics.h(exception, "exception");
        if (th2 != exception) {
            PlatformImplementationsKt.f67318a.a(th2, exception);
        }
    }

    public static String b(Throwable th2) {
        Intrinsics.h(th2, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.g(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
