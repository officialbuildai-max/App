package q7;

import q7.d;

/* loaded from: classes4.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static d f73292a;

    /* renamed from: b, reason: collision with root package name */
    static a f73293b;

    /* renamed from: c, reason: collision with root package name */
    static e8.c f73294c;

    /* renamed from: d, reason: collision with root package name */
    static boolean f73295d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        if (!f73295d) {
            throw new IllegalStateException("Do you forget to initialize XLog?");
        }
    }

    public static void b(String str) {
        a();
        f73292a.a(str);
    }

    public static void c(String str) {
        a();
        f73292a.c(str);
    }

    public static void d(String str) {
        a();
        f73292a.e(str);
    }

    public static void e(a aVar) {
        f(aVar, b8.a.i());
    }

    public static void f(a aVar, e8.c... cVarArr) {
        if (f73295d) {
            b8.b.e().g("XLog is already initialized, do not initialize again");
        }
        f73295d = true;
        if (aVar == null) {
            throw new IllegalArgumentException("Please specify a LogConfiguration");
        }
        f73293b = aVar;
        e8.d dVar = new e8.d(cVarArr);
        f73294c = dVar;
        f73292a = new d(f73293b, dVar);
    }

    public static d.a g(String str) {
        return new d.a().x(str);
    }
}
