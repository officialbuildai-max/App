package a5;

/* loaded from: classes2.dex */
public abstract class i implements h1 {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f317a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f318b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    private static final Character f319c = ',';

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char a(o0 o0Var, Object obj, char c11) {
        ThreadLocal threadLocal = f317a;
        o0 o0Var2 = (o0) threadLocal.get();
        threadLocal.set(o0Var);
        ThreadLocal threadLocal2 = f318b;
        threadLocal2.set(Character.valueOf(c11));
        b(obj);
        threadLocal.set(o0Var2);
        return ((Character) threadLocal2.get()).charValue();
    }

    public abstract void b(Object obj);
}
