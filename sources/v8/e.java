package v8;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    private static final e f77223c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final long f77224a;

    /* renamed from: b, reason: collision with root package name */
    private final long f77225b;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f77226a = 0;

        /* renamed from: b, reason: collision with root package name */
        private long f77227b = 0;

        a() {
        }

        public e a() {
            return new e(this.f77226a, this.f77227b);
        }

        public a b(long j11) {
            this.f77227b = j11;
            return this;
        }

        public a c(long j11) {
            this.f77226a = j11;
            return this;
        }
    }

    e(long j11, long j12) {
        this.f77224a = j11;
        this.f77225b = j12;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f77225b;
    }

    public long b() {
        return this.f77224a;
    }
}
