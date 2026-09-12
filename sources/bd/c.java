package bd;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class c extends e {

    /* renamed from: a, reason: collision with root package name */
    private final Set f16432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Set set) {
        if (set == null) {
            throw new NullPointerException("Null rolloutAssignments");
        }
        this.f16432a = set;
    }

    @Override // bd.e
    public Set b() {
        return this.f16432a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return this.f16432a.equals(((e) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f16432a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f16432a + "}";
    }
}
