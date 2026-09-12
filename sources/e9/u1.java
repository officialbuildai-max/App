package e9;

import android.media.metrics.LogSessionId;

/* loaded from: classes4.dex */
public final class u1 {

    /* renamed from: b, reason: collision with root package name */
    public static final u1 f61924b;

    /* renamed from: a, reason: collision with root package name */
    private final a f61925a;

    /* loaded from: classes4.dex */
    private static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f61926b;

        /* renamed from: a, reason: collision with root package name */
        public final LogSessionId f61927a;

        static {
            LogSessionId logSessionId;
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            f61926b = new a(logSessionId);
        }

        public a(LogSessionId logSessionId) {
            this.f61927a = logSessionId;
        }
    }

    static {
        f61924b = com.google.android.exoplayer2.util.p0.f27680a < 31 ? new u1() : new u1(a.f61926b);
    }

    public u1() {
        this((a) null);
        com.google.android.exoplayer2.util.a.g(com.google.android.exoplayer2.util.p0.f27680a < 31);
    }

    public u1(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    private u1(a aVar) {
        this.f61925a = aVar;
    }

    public LogSessionId a() {
        return ((a) com.google.android.exoplayer2.util.a.e(this.f61925a)).f61927a;
    }
}
