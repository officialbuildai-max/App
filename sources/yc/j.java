package yc;

import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* loaded from: classes5.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final long f79100a;

    /* renamed from: b, reason: collision with root package name */
    private final long f79101b;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private long f79102a = 60;

        /* renamed from: b, reason: collision with root package name */
        private long f79103b = ConfigFetchHandler.f32495j;

        public j c() {
            return new j(this);
        }

        public b d(long j11) {
            if (j11 < 0) {
                throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j11)));
            }
            this.f79102a = j11;
            return this;
        }

        public b e(long j11) {
            if (j11 >= 0) {
                this.f79103b = j11;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j11 + " is an invalid argument");
        }
    }

    private j(b bVar) {
        this.f79100a = bVar.f79102a;
        this.f79101b = bVar.f79103b;
    }

    public long a() {
        return this.f79100a;
    }

    public long b() {
        return this.f79101b;
    }
}
