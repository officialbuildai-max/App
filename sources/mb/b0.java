package mb;

/* loaded from: classes5.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    private final Class f69558a;

    /* renamed from: b, reason: collision with root package name */
    private final Class f69559b;

    /* loaded from: classes5.dex */
    private @interface a {
    }

    public b0(Class cls, Class cls2) {
        this.f69558a = cls;
        this.f69559b = cls2;
    }

    public static b0 a(Class cls, Class cls2) {
        return new b0(cls, cls2);
    }

    public static b0 b(Class cls) {
        return new b0(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (this.f69559b.equals(b0Var.f69559b)) {
            return this.f69558a.equals(b0Var.f69558a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f69559b.hashCode() * 31) + this.f69558a.hashCode();
    }

    public String toString() {
        if (this.f69558a == a.class) {
            return this.f69559b.getName();
        }
        return "@" + this.f69558a.getName() + " " + this.f69559b.getName();
    }
}
