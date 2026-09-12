package rb;

/* loaded from: classes5.dex */
final class b extends i {

    /* renamed from: b, reason: collision with root package name */
    private final String f74361b;

    /* renamed from: c, reason: collision with root package name */
    private final String f74362c;

    /* renamed from: d, reason: collision with root package name */
    private final String f74363d;

    /* renamed from: e, reason: collision with root package name */
    private final String f74364e;

    /* renamed from: f, reason: collision with root package name */
    private final long f74365f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, String str3, String str4, long j11) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f74361b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f74362c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f74363d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f74364e = str4;
        this.f74365f = j11;
    }

    @Override // rb.i
    public String c() {
        return this.f74362c;
    }

    @Override // rb.i
    public String d() {
        return this.f74363d;
    }

    @Override // rb.i
    public String e() {
        return this.f74361b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f74361b.equals(iVar.e()) && this.f74362c.equals(iVar.c()) && this.f74363d.equals(iVar.d()) && this.f74364e.equals(iVar.g()) && this.f74365f == iVar.f();
    }

    @Override // rb.i
    public long f() {
        return this.f74365f;
    }

    @Override // rb.i
    public String g() {
        return this.f74364e;
    }

    public int hashCode() {
        int hashCode = (((((((this.f74361b.hashCode() ^ 1000003) * 1000003) ^ this.f74362c.hashCode()) * 1000003) ^ this.f74363d.hashCode()) * 1000003) ^ this.f74364e.hashCode()) * 1000003;
        long j11 = this.f74365f;
        return hashCode ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f74361b + ", parameterKey=" + this.f74362c + ", parameterValue=" + this.f74363d + ", variantId=" + this.f74364e + ", templateVersion=" + this.f74365f + "}";
    }
}
