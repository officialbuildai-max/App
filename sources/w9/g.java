package w9;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import x9.i;

/* loaded from: classes4.dex */
public final class g implements e {

    /* renamed from: a, reason: collision with root package name */
    private final g9.d f77728a;

    /* renamed from: b, reason: collision with root package name */
    private final long f77729b;

    public g(g9.d dVar, long j11) {
        this.f77728a = dVar;
        this.f77729b = j11;
    }

    @Override // w9.e
    public long a(long j11, long j12) {
        return this.f77728a.f63503d[(int) j11];
    }

    @Override // w9.e
    public long b(long j11, long j12) {
        return 0L;
    }

    @Override // w9.e
    public long c(long j11, long j12) {
        return C.TIME_UNSET;
    }

    @Override // w9.e
    public i d(long j11) {
        return new i(null, this.f77728a.f63502c[(int) j11], r0.f63501b[r8]);
    }

    @Override // w9.e
    public long e(long j11, long j12) {
        return this.f77728a.b(j11 + this.f77729b);
    }

    @Override // w9.e
    public long f(long j11) {
        return this.f77728a.f63500a;
    }

    @Override // w9.e
    public boolean g() {
        return true;
    }

    @Override // w9.e
    public long getTimeUs(long j11) {
        return this.f77728a.f63504e[(int) j11] - this.f77729b;
    }

    @Override // w9.e
    public long h() {
        return 0L;
    }

    @Override // w9.e
    public long i(long j11, long j12) {
        return this.f77728a.f63500a;
    }
}
