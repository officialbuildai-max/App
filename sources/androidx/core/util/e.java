package androidx.core.util;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8347a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8348b;

    public e(Object obj, Object obj2) {
        this.f8347a = obj;
        this.f8348b = obj2;
    }

    public static e a(Object obj, Object obj2) {
        return new e(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return d.a(eVar.f8347a, this.f8347a) && d.a(eVar.f8348b, this.f8348b);
    }

    public int hashCode() {
        Object obj = this.f8347a;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f8348b;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f8347a + " " + this.f8348b + "}";
    }
}
