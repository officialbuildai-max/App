package h10;

/* loaded from: classes7.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final int f64273a;

    /* renamed from: b, reason: collision with root package name */
    private final String f64274b;

    /* renamed from: c, reason: collision with root package name */
    private final String f64275c;

    /* renamed from: d, reason: collision with root package name */
    private final String f64276d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f64277e;

    public o(int i11, String str, String str2, String str3, boolean z10) {
        this.f64273a = i11;
        this.f64274b = str;
        this.f64275c = str2;
        this.f64276d = str3;
        this.f64277e = z10;
    }

    public String a() {
        return this.f64276d;
    }

    public String b() {
        return this.f64275c;
    }

    public String c() {
        return this.f64274b;
    }

    public int d() {
        return this.f64273a;
    }

    public boolean e() {
        return this.f64277e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f64273a == oVar.f64273a && this.f64277e == oVar.f64277e && this.f64274b.equals(oVar.f64274b) && this.f64275c.equals(oVar.f64275c) && this.f64276d.equals(oVar.f64276d);
    }

    public int hashCode() {
        return this.f64273a + (this.f64277e ? 64 : 0) + (this.f64274b.hashCode() * this.f64275c.hashCode() * this.f64276d.hashCode());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f64274b);
        sb2.append('.');
        sb2.append(this.f64275c);
        sb2.append(this.f64276d);
        sb2.append(" (");
        sb2.append(this.f64273a);
        sb2.append(this.f64277e ? " itf" : "");
        sb2.append(')');
        return sb2.toString();
    }
}
