package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: classes3.dex */
public final class LogEventDropped {

    /* renamed from: c, reason: collision with root package name */
    private static final LogEventDropped f24458c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final long f24459a;

    /* renamed from: b, reason: collision with root package name */
    private final Reason f24460b;

    /* loaded from: classes3.dex */
    public enum Reason implements ec.a {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int number_;

        Reason(int i11) {
            this.number_ = i11;
        }

        @Override // ec.a
        public int getNumber() {
            return this.number_;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f24461a = 0;

        /* renamed from: b, reason: collision with root package name */
        private Reason f24462b = Reason.REASON_UNKNOWN;

        a() {
        }

        public LogEventDropped a() {
            return new LogEventDropped(this.f24461a, this.f24462b);
        }

        public a b(long j11) {
            this.f24461a = j11;
            return this;
        }

        public a c(Reason reason) {
            this.f24462b = reason;
            return this;
        }
    }

    LogEventDropped(long j11, Reason reason) {
        this.f24459a = j11;
        this.f24460b = reason;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f24459a;
    }

    public Reason b() {
        return this.f24460b;
    }
}
