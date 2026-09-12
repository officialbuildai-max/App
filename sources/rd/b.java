package rd;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f74439a;

    /* renamed from: b, reason: collision with root package name */
    private final int f74440b;

    public b(int i11, int i12) {
        this.f74439a = i11;
        this.f74440b = i12;
    }

    public final int a() {
        return this.f74440b;
    }

    public final int b() {
        return this.f74439a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f74439a == bVar.f74439a && this.f74440b == bVar.f74440b;
    }

    public final int hashCode() {
        return this.f74439a ^ this.f74440b;
    }

    public final String toString() {
        return this.f74439a + "(" + this.f74440b + ')';
    }
}
