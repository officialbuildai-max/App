package yc;

import java.util.Set;

/* loaded from: classes5.dex */
final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private final Set f79092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Set set) {
        if (set == null) {
            throw new NullPointerException("Null updatedKeys");
        }
        this.f79092a = set;
    }

    @Override // yc.b
    public Set b() {
        return this.f79092a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return this.f79092a.equals(((b) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f79092a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ConfigUpdate{updatedKeys=" + this.f79092a + "}";
    }
}
