package x9;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f78180a;

    /* renamed from: b, reason: collision with root package name */
    public final String f78181b;

    /* renamed from: c, reason: collision with root package name */
    public final int f78182c;

    /* renamed from: d, reason: collision with root package name */
    public final int f78183d;

    public b(String str, String str2, int i11, int i12) {
        this.f78180a = str;
        this.f78181b = str2;
        this.f78182c = i11;
        this.f78183d = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f78182c == bVar.f78182c && this.f78183d == bVar.f78183d && com.google.common.base.j.a(this.f78180a, bVar.f78180a) && com.google.common.base.j.a(this.f78181b, bVar.f78181b);
    }

    public int hashCode() {
        return com.google.common.base.j.b(this.f78180a, this.f78181b, Integer.valueOf(this.f78182c), Integer.valueOf(this.f78183d));
    }
}
