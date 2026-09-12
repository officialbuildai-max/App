package g9;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.b0;

/* loaded from: classes4.dex */
public class e implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final long f63506a;

    /* renamed from: b, reason: collision with root package name */
    private final long f63507b;

    /* renamed from: c, reason: collision with root package name */
    private final int f63508c;

    /* renamed from: d, reason: collision with root package name */
    private final long f63509d;

    /* renamed from: e, reason: collision with root package name */
    private final int f63510e;

    /* renamed from: f, reason: collision with root package name */
    private final long f63511f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f63512g;

    public e(long j11, long j12, int i11, int i12, boolean z10) {
        this.f63506a = j11;
        this.f63507b = j12;
        this.f63508c = i12 == -1 ? 1 : i12;
        this.f63510e = i11;
        this.f63512g = z10;
        if (j11 == -1) {
            this.f63509d = -1L;
            this.f63511f = C.TIME_UNSET;
        } else {
            this.f63509d = j11 - j12;
            this.f63511f = d(j11, j12, i11);
        }
    }

    private long b(long j11) {
        int i11 = this.f63508c;
        long j12 = (((j11 * this.f63510e) / 8000000) / i11) * i11;
        long j13 = this.f63509d;
        if (j13 != -1) {
            j12 = Math.min(j12, j13 - i11);
        }
        return this.f63507b + Math.max(j12, 0L);
    }

    private static long d(long j11, long j12, int i11) {
        return (Math.max(0L, j11 - j12) * 8000000) / i11;
    }

    public long c(long j11) {
        return d(j11, this.f63507b, this.f63510e);
    }

    @Override // g9.b0
    public long getDurationUs() {
        return this.f63511f;
    }

    @Override // g9.b0
    public b0.a getSeekPoints(long j11) {
        if (this.f63509d == -1 && !this.f63512g) {
            return new b0.a(new c0(0L, this.f63507b));
        }
        long b11 = b(j11);
        long c11 = c(b11);
        c0 c0Var = new c0(c11, b11);
        if (this.f63509d != -1 && c11 < j11) {
            int i11 = this.f63508c;
            if (i11 + b11 < this.f63506a) {
                long j12 = b11 + i11;
                return new b0.a(c0Var, new c0(c(j12), j12));
            }
        }
        return new b0.a(c0Var);
    }

    @Override // g9.b0
    public boolean isSeekable() {
        return this.f63509d != -1 || this.f63512g;
    }
}
