package kotlinx.coroutines;

/* loaded from: classes7.dex */
public final class o2 {

    /* renamed from: a, reason: collision with root package name */
    public static final o2 f68027a = new o2();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f68028b = kotlinx.coroutines.internal.j0.a(new kotlinx.coroutines.internal.z("ThreadLocalEventLoop"));

    private o2() {
    }

    public final e1 a() {
        return (e1) f68028b.get();
    }

    public final e1 b() {
        ThreadLocal threadLocal = f68028b;
        e1 e1Var = (e1) threadLocal.get();
        if (e1Var != null) {
            return e1Var;
        }
        e1 a11 = g1.a();
        threadLocal.set(a11);
        return a11;
    }

    public final void c() {
        f68028b.set(null);
    }

    public final void d(e1 e1Var) {
        f68028b.set(e1Var);
    }
}
