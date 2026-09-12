package s8;

/* loaded from: classes4.dex */
final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private final long f75416a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j11) {
        this.f75416a = j11;
    }

    @Override // s8.b
    public long c() {
        return this.f75416a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof b) && this.f75416a == ((b) obj).c();
    }

    public int hashCode() {
        long j11 = this.f75416a;
        return ((int) (j11 ^ (j11 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f75416a + "}";
    }
}
