package l2;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.m0;

/* loaded from: classes2.dex */
public class i implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final long f68715a;

    /* renamed from: b, reason: collision with root package name */
    private final long f68716b;

    /* renamed from: c, reason: collision with root package name */
    private final int f68717c;

    /* renamed from: d, reason: collision with root package name */
    private final long f68718d;

    /* renamed from: e, reason: collision with root package name */
    private final int f68719e;

    /* renamed from: f, reason: collision with root package name */
    private final long f68720f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f68721g;

    public i(long j11, long j12, int i11, int i12, boolean z10) {
        this.f68715a = j11;
        this.f68716b = j12;
        this.f68717c = i12 == -1 ? 1 : i12;
        this.f68719e = i11;
        this.f68721g = z10;
        if (j11 == -1) {
            this.f68718d = -1L;
            this.f68720f = C.TIME_UNSET;
        } else {
            this.f68718d = j11 - j12;
            this.f68720f = d(j11, j12, i11);
        }
    }

    private long b(long j11) {
        int i11 = this.f68717c;
        long j12 = (((j11 * this.f68719e) / 8000000) / i11) * i11;
        long j13 = this.f68718d;
        if (j13 != -1) {
            j12 = Math.min(j12, j13 - i11);
        }
        return this.f68716b + Math.max(j12, 0L);
    }

    private static long d(long j11, long j12, int i11) {
        return (Math.max(0L, j11 - j12) * 8000000) / i11;
    }

    public long c(long j11) {
        return d(j11, this.f68716b, this.f68719e);
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f68720f;
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        if (this.f68718d == -1 && !this.f68721g) {
            return new m0.a(new n0(0L, this.f68716b));
        }
        long b11 = b(j11);
        long c11 = c(b11);
        n0 n0Var = new n0(c11, b11);
        if (this.f68718d != -1 && c11 < j11) {
            int i11 = this.f68717c;
            if (i11 + b11 < this.f68715a) {
                long j12 = b11 + i11;
                return new m0.a(n0Var, new n0(c(j12), j12));
            }
        }
        return new m0.a(n0Var);
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return this.f68718d != -1 || this.f68721g;
    }
}
