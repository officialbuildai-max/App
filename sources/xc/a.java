package xc;

/* loaded from: classes5.dex */
final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final String f78312a;

    /* renamed from: b, reason: collision with root package name */
    private final String f78313b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f78312a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f78313b = str2;
    }

    @Override // xc.f
    public String b() {
        return this.f78312a;
    }

    @Override // xc.f
    public String c() {
        return this.f78313b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f78312a.equals(fVar.b()) && this.f78313b.equals(fVar.c());
    }

    public int hashCode() {
        return ((this.f78312a.hashCode() ^ 1000003) * 1000003) ^ this.f78313b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f78312a + ", version=" + this.f78313b + "}";
    }
}
