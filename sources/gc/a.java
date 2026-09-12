package gc;

import java.util.List;

/* loaded from: classes5.dex */
final class a extends p {

    /* renamed from: a, reason: collision with root package name */
    private final String f63645a;

    /* renamed from: b, reason: collision with root package name */
    private final List f63646b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f63645a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f63646b = list;
    }

    @Override // gc.p
    public List b() {
        return this.f63646b;
    }

    @Override // gc.p
    public String c() {
        return this.f63645a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f63645a.equals(pVar.c()) && this.f63646b.equals(pVar.b());
    }

    public int hashCode() {
        return ((this.f63645a.hashCode() ^ 1000003) * 1000003) ^ this.f63646b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f63645a + ", usedDates=" + this.f63646b + "}";
    }
}
