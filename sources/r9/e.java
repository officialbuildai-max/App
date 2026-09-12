package r9;

import com.google.android.exoplayer2.util.p0;
import g9.b0;
import g9.c0;

/* loaded from: classes4.dex */
final class e implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final c f74348a;

    /* renamed from: b, reason: collision with root package name */
    private final int f74349b;

    /* renamed from: c, reason: collision with root package name */
    private final long f74350c;

    /* renamed from: d, reason: collision with root package name */
    private final long f74351d;

    /* renamed from: e, reason: collision with root package name */
    private final long f74352e;

    public e(c cVar, int i11, long j11, long j12) {
        this.f74348a = cVar;
        this.f74349b = i11;
        this.f74350c = j11;
        long j13 = (j12 - j11) / cVar.f74343e;
        this.f74351d = j13;
        this.f74352e = b(j13);
    }

    private long b(long j11) {
        return p0.N0(j11 * this.f74349b, 1000000L, this.f74348a.f74341c);
    }

    @Override // g9.b0
    public long getDurationUs() {
        return this.f74352e;
    }

    @Override // g9.b0
    public b0.a getSeekPoints(long j11) {
        long r11 = p0.r((this.f74348a.f74341c * j11) / (this.f74349b * 1000000), 0L, this.f74351d - 1);
        long j12 = this.f74350c + (this.f74348a.f74343e * r11);
        long b11 = b(r11);
        c0 c0Var = new c0(b11, j12);
        if (b11 >= j11 || r11 == this.f74351d - 1) {
            return new b0.a(c0Var);
        }
        long j13 = r11 + 1;
        return new b0.a(c0Var, new c0(b(j13), this.f74350c + (this.f74348a.f74343e * j13)));
    }

    @Override // g9.b0
    public boolean isSeekable() {
        return true;
    }
}
