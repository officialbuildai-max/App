package t3;

import androidx.media3.common.util.a1;
import l2.m0;
import l2.n0;

/* loaded from: classes2.dex */
final class e implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final c f76177a;

    /* renamed from: b, reason: collision with root package name */
    private final int f76178b;

    /* renamed from: c, reason: collision with root package name */
    private final long f76179c;

    /* renamed from: d, reason: collision with root package name */
    private final long f76180d;

    /* renamed from: e, reason: collision with root package name */
    private final long f76181e;

    public e(c cVar, int i11, long j11, long j12) {
        this.f76177a = cVar;
        this.f76178b = i11;
        this.f76179c = j11;
        long j13 = (j12 - j11) / cVar.f76172e;
        this.f76180d = j13;
        this.f76181e = b(j13);
    }

    private long b(long j11) {
        return a1.e1(j11 * this.f76178b, 1000000L, this.f76177a.f76170c);
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f76181e;
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        long q11 = a1.q((this.f76177a.f76170c * j11) / (this.f76178b * 1000000), 0L, this.f76180d - 1);
        long j12 = this.f76179c + (this.f76177a.f76172e * q11);
        long b11 = b(q11);
        n0 n0Var = new n0(b11, j12);
        if (b11 >= j11 || q11 == this.f76180d - 1) {
            return new m0.a(n0Var);
        }
        long j13 = q11 + 1;
        return new m0.a(n0Var, new n0(b(j13), this.f76179c + (this.f76177a.f76172e * j13)));
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return true;
    }
}
