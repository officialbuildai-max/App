package v8;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    private static final d f77218c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final long f77219a;

    /* renamed from: b, reason: collision with root package name */
    private final long f77220b;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f77221a = 0;

        /* renamed from: b, reason: collision with root package name */
        private long f77222b = 0;

        a() {
        }

        public d a() {
            return new d(this.f77221a, this.f77222b);
        }

        public a b(long j11) {
            this.f77221a = j11;
            return this;
        }

        public a c(long j11) {
            this.f77222b = j11;
            return this;
        }
    }

    d(long j11, long j12) {
        this.f77219a = j11;
        this.f77220b = j12;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f77219a;
    }

    public long b() {
        return this.f77220b;
    }
}
