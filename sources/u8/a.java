package u8;

/* loaded from: classes4.dex */
public final class a implements uz.a {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f76807c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private volatile uz.a f76808a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f76809b = f76807c;

    private a(uz.a aVar) {
        this.f76808a = aVar;
    }

    public static uz.a a(uz.a aVar) {
        d.b(aVar);
        return aVar instanceof a ? aVar : new a(aVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f76807c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // uz.a
    public Object get() {
        Object obj = this.f76809b;
        Object obj2 = f76807c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f76809b;
                    if (obj == obj2) {
                        obj = this.f76808a.get();
                        this.f76809b = b(this.f76809b, obj);
                        this.f76808a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
