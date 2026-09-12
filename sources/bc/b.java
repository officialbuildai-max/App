package bc;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f16410a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f16411b;

    /* renamed from: bc.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0152b {

        /* renamed from: a, reason: collision with root package name */
        private final String f16412a;

        /* renamed from: b, reason: collision with root package name */
        private Map f16413b = null;

        C0152b(String str) {
            this.f16412a = str;
        }

        public b a() {
            return new b(this.f16412a, this.f16413b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f16413b)));
        }

        public C0152b b(Annotation annotation) {
            if (this.f16413b == null) {
                this.f16413b = new HashMap();
            }
            this.f16413b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    private b(String str, Map map) {
        this.f16410a = str;
        this.f16411b = map;
    }

    public static C0152b a(String str) {
        return new C0152b(str);
    }

    public static b d(String str) {
        return new b(str, Collections.emptyMap());
    }

    public String b() {
        return this.f16410a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f16411b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f16410a.equals(bVar.f16410a) && this.f16411b.equals(bVar.f16411b);
    }

    public int hashCode() {
        return (this.f16410a.hashCode() * 31) + this.f16411b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f16410a + ", properties=" + this.f16411b.values() + "}";
    }
}
