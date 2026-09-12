package a9;

/* loaded from: classes3.dex */
final class b extends k {

    /* renamed from: a, reason: collision with root package name */
    private final long f472a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.o f473b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.i f474c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(long j11, com.google.android.datatransport.runtime.o oVar, com.google.android.datatransport.runtime.i iVar) {
        this.f472a = j11;
        if (oVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f473b = oVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f474c = iVar;
    }

    @Override // a9.k
    public com.google.android.datatransport.runtime.i b() {
        return this.f474c;
    }

    @Override // a9.k
    public long c() {
        return this.f472a;
    }

    @Override // a9.k
    public com.google.android.datatransport.runtime.o d() {
        return this.f473b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f472a == kVar.c() && this.f473b.equals(kVar.d()) && this.f474c.equals(kVar.b());
    }

    public int hashCode() {
        long j11 = this.f472a;
        return ((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.f473b.hashCode()) * 1000003) ^ this.f474c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f472a + ", transportContext=" + this.f473b + ", event=" + this.f474c + "}";
    }
}
