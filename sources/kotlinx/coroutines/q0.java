package kotlinx.coroutines;

/* loaded from: classes7.dex */
public abstract class q0 {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f68031a = kotlinx.coroutines.internal.a0.f("kotlinx.coroutines.main.delay", false);

    /* renamed from: b, reason: collision with root package name */
    private static final t0 f68032b = b();

    public static final t0 a() {
        return f68032b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final t0 b() {
        if (!f68031a) {
            return DefaultExecutor.INSTANCE;
        }
        a2 c11 = y0.c();
        return (kotlinx.coroutines.internal.p.c(c11) || !(c11 instanceof t0)) ? DefaultExecutor.INSTANCE : (t0) c11;
    }
}
