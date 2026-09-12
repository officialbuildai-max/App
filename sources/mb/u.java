package mb;

/* loaded from: classes5.dex */
public class u implements ic.b {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f69620c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private volatile Object f69621a = f69620c;

    /* renamed from: b, reason: collision with root package name */
    private volatile ic.b f69622b;

    public u(ic.b bVar) {
        this.f69622b = bVar;
    }

    @Override // ic.b
    public Object get() {
        Object obj = this.f69621a;
        Object obj2 = f69620c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f69621a;
                    if (obj == obj2) {
                        obj = this.f69622b.get();
                        this.f69621a = obj;
                        this.f69622b = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
