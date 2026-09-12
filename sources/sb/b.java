package sb;

import ob.f;
import sb.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b extends e.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f75424a;

    /* renamed from: b, reason: collision with root package name */
    private final String f75425b;

    /* renamed from: c, reason: collision with root package name */
    private final String f75426c;

    /* renamed from: d, reason: collision with root package name */
    private final String f75427d;

    /* renamed from: e, reason: collision with root package name */
    private final int f75428e;

    /* renamed from: f, reason: collision with root package name */
    private final f f75429f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, String str3, String str4, int i11, f fVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f75424a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f75425b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f75426c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f75427d = str4;
        this.f75428e = i11;
        if (fVar == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f75429f = fVar;
    }

    @Override // sb.e.a
    public String a() {
        return this.f75424a;
    }

    @Override // sb.e.a
    public int c() {
        return this.f75428e;
    }

    @Override // sb.e.a
    public f d() {
        return this.f75429f;
    }

    @Override // sb.e.a
    public String e() {
        return this.f75427d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e.a)) {
            return false;
        }
        e.a aVar = (e.a) obj;
        return this.f75424a.equals(aVar.a()) && this.f75425b.equals(aVar.f()) && this.f75426c.equals(aVar.g()) && this.f75427d.equals(aVar.e()) && this.f75428e == aVar.c() && this.f75429f.equals(aVar.d());
    }

    @Override // sb.e.a
    public String f() {
        return this.f75425b;
    }

    @Override // sb.e.a
    public String g() {
        return this.f75426c;
    }

    public int hashCode() {
        return ((((((((((this.f75424a.hashCode() ^ 1000003) * 1000003) ^ this.f75425b.hashCode()) * 1000003) ^ this.f75426c.hashCode()) * 1000003) ^ this.f75427d.hashCode()) * 1000003) ^ this.f75428e) * 1000003) ^ this.f75429f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f75424a + ", versionCode=" + this.f75425b + ", versionName=" + this.f75426c + ", installUuid=" + this.f75427d + ", deliveryMechanism=" + this.f75428e + ", developmentPlatformProvider=" + this.f75429f + "}";
    }
}
