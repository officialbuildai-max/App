package xb;

import java.util.Stack;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f78308a;

    /* renamed from: b, reason: collision with root package name */
    public final String f78309b;

    /* renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f78310c;

    /* renamed from: d, reason: collision with root package name */
    public final e f78311d;

    private e(String str, String str2, StackTraceElement[] stackTraceElementArr, e eVar) {
        this.f78308a = str;
        this.f78309b = str2;
        this.f78310c = stackTraceElementArr;
        this.f78311d = eVar;
    }

    public static e a(Throwable th2, d dVar) {
        Stack stack = new Stack();
        while (th2 != null) {
            stack.push(th2);
            th2 = th2.getCause();
        }
        e eVar = null;
        while (!stack.isEmpty()) {
            Throwable th3 = (Throwable) stack.pop();
            eVar = new e(th3.getLocalizedMessage(), th3.getClass().getName(), dVar.a(th3.getStackTrace()), eVar);
        }
        return eVar;
    }
}
