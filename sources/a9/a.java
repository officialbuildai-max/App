package a9;

import a9.e;

/* loaded from: classes3.dex */
final class a extends e {

    /* renamed from: b, reason: collision with root package name */
    private final long f459b;

    /* renamed from: c, reason: collision with root package name */
    private final int f460c;

    /* renamed from: d, reason: collision with root package name */
    private final int f461d;

    /* renamed from: e, reason: collision with root package name */
    private final long f462e;

    /* renamed from: f, reason: collision with root package name */
    private final int f463f;

    /* loaded from: classes3.dex */
    static final class b extends e.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f464a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f465b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f466c;

        /* renamed from: d, reason: collision with root package name */
        private Long f467d;

        /* renamed from: e, reason: collision with root package name */
        private Integer f468e;

        @Override // a9.e.a
        e a() {
            String str = "";
            if (this.f464a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f465b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f466c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f467d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f468e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f464a.longValue(), this.f465b.intValue(), this.f466c.intValue(), this.f467d.longValue(), this.f468e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // a9.e.a
        e.a b(int i11) {
            this.f466c = Integer.valueOf(i11);
            return this;
        }

        @Override // a9.e.a
        e.a c(long j11) {
            this.f467d = Long.valueOf(j11);
            return this;
        }

        @Override // a9.e.a
        e.a d(int i11) {
            this.f465b = Integer.valueOf(i11);
            return this;
        }

        @Override // a9.e.a
        e.a e(int i11) {
            this.f468e = Integer.valueOf(i11);
            return this;
        }

        @Override // a9.e.a
        e.a f(long j11) {
            this.f464a = Long.valueOf(j11);
            return this;
        }
    }

    private a(long j11, int i11, int i12, long j12, int i13) {
        this.f459b = j11;
        this.f460c = i11;
        this.f461d = i12;
        this.f462e = j12;
        this.f463f = i13;
    }

    @Override // a9.e
    int b() {
        return this.f461d;
    }

    @Override // a9.e
    long c() {
        return this.f462e;
    }

    @Override // a9.e
    int d() {
        return this.f460c;
    }

    @Override // a9.e
    int e() {
        return this.f463f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f459b == eVar.f() && this.f460c == eVar.d() && this.f461d == eVar.b() && this.f462e == eVar.c() && this.f463f == eVar.e();
    }

    @Override // a9.e
    long f() {
        return this.f459b;
    }

    public int hashCode() {
        long j11 = this.f459b;
        int i11 = (((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.f460c) * 1000003) ^ this.f461d) * 1000003;
        long j12 = this.f462e;
        return ((i11 ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.f463f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f459b + ", loadBatchSize=" + this.f460c + ", criticalSectionEnterTimeoutMs=" + this.f461d + ", eventCleanUpAge=" + this.f462e + ", maxBlobByteSizePerRow=" + this.f463f + "}";
    }
}
