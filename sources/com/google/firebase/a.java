package com.google.firebase;

/* loaded from: classes4.dex */
final class a extends n {

    /* renamed from: a, reason: collision with root package name */
    private final long f31096a;

    /* renamed from: b, reason: collision with root package name */
    private final long f31097b;

    /* renamed from: c, reason: collision with root package name */
    private final long f31098c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j11, long j12, long j13) {
        this.f31096a = j11;
        this.f31097b = j12;
        this.f31098c = j13;
    }

    @Override // com.google.firebase.n
    public long b() {
        return this.f31097b;
    }

    @Override // com.google.firebase.n
    public long c() {
        return this.f31096a;
    }

    @Override // com.google.firebase.n
    public long d() {
        return this.f31098c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f31096a == nVar.c() && this.f31097b == nVar.b() && this.f31098c == nVar.d();
    }

    public int hashCode() {
        long j11 = this.f31096a;
        long j12 = this.f31097b;
        int i11 = (((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        long j13 = this.f31098c;
        return i11 ^ ((int) ((j13 >>> 32) ^ j13));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f31096a + ", elapsedRealtime=" + this.f31097b + ", uptimeMillis=" + this.f31098c + "}";
    }
}
