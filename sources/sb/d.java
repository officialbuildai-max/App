package sb;

import sb.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class d extends e.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f75439a;

    /* renamed from: b, reason: collision with root package name */
    private final String f75440b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f75441c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, boolean z10) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f75439a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f75440b = str2;
        this.f75441c = z10;
    }

    @Override // sb.e.c
    public boolean b() {
        return this.f75441c;
    }

    @Override // sb.e.c
    public String c() {
        return this.f75440b;
    }

    @Override // sb.e.c
    public String d() {
        return this.f75439a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e.c)) {
            return false;
        }
        e.c cVar = (e.c) obj;
        return this.f75439a.equals(cVar.d()) && this.f75440b.equals(cVar.c()) && this.f75441c == cVar.b();
    }

    public int hashCode() {
        return ((((this.f75439a.hashCode() ^ 1000003) * 1000003) ^ this.f75440b.hashCode()) * 1000003) ^ (this.f75441c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.f75439a + ", osCodeName=" + this.f75440b + ", isRooted=" + this.f75441c + "}";
    }
}
