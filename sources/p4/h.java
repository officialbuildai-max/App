package p4;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    Object f72427a;

    /* renamed from: b, reason: collision with root package name */
    Object f72428b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(Object obj, Object obj2) {
        this.f72427a = obj;
        this.f72428b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof androidx.core.util.e)) {
            return false;
        }
        androidx.core.util.e eVar = (androidx.core.util.e) obj;
        return a(eVar.f8347a, this.f72427a) && a(eVar.f8348b, this.f72428b);
    }

    public int hashCode() {
        Object obj = this.f72427a;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f72428b;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f72427a + " " + this.f72428b + "}";
    }
}
