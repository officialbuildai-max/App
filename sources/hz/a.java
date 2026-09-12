package hz;

/* loaded from: classes7.dex */
public final class a implements uz.a {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f64969c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private volatile uz.a f64970a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f64971b = f64969c;

    private a(uz.a aVar) {
        this.f64970a = aVar;
    }

    public static uz.a a(uz.a aVar) {
        b.b(aVar);
        return aVar instanceof a ? aVar : new a(aVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f64969c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // uz.a
    public Object get() {
        Object obj = this.f64971b;
        Object obj2 = f64969c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f64971b;
                    if (obj == obj2) {
                        obj = this.f64970a.get();
                        this.f64971b = b(this.f64971b, obj);
                        this.f64970a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
