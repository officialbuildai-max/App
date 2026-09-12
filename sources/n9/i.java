package n9;

import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import g9.b0;
import g9.c0;

/* loaded from: classes4.dex */
final class i implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long f70408a;

    /* renamed from: b, reason: collision with root package name */
    private final int f70409b;

    /* renamed from: c, reason: collision with root package name */
    private final long f70410c;

    /* renamed from: d, reason: collision with root package name */
    private final long f70411d;

    /* renamed from: e, reason: collision with root package name */
    private final long f70412e;

    /* renamed from: f, reason: collision with root package name */
    private final long[] f70413f;

    private i(long j11, int i11, long j12) {
        this(j11, i11, j12, -1L, null);
    }

    private i(long j11, int i11, long j12, long j13, long[] jArr) {
        this.f70408a = j11;
        this.f70409b = i11;
        this.f70410c = j12;
        this.f70413f = jArr;
        this.f70411d = j13;
        this.f70412e = j13 != -1 ? j11 + j13 : -1L;
    }

    public static i b(long j11, long j12, b0.a aVar, d0 d0Var) {
        int H;
        int i11 = aVar.f24681g;
        int i12 = aVar.f24678d;
        int n11 = d0Var.n();
        if ((n11 & 1) != 1 || (H = d0Var.H()) == 0) {
            return null;
        }
        long N0 = p0.N0(H, i11 * 1000000, i12);
        if ((n11 & 6) != 6) {
            return new i(j12, aVar.f24677c, N0);
        }
        long F = d0Var.F();
        long[] jArr = new long[100];
        for (int i13 = 0; i13 < 100; i13++) {
            jArr[i13] = d0Var.D();
        }
        if (j11 != -1) {
            long j13 = j12 + F;
            if (j11 != j13) {
                s.i("XingSeeker", "XING data size mismatch: " + j11 + ", " + j13);
            }
        }
        return new i(j12, aVar.f24677c, N0, F, jArr);
    }

    private long c(int i11) {
        return (this.f70410c * i11) / 100;
    }

    @Override // n9.g
    public long a() {
        return this.f70412e;
    }

    @Override // g9.b0
    public long getDurationUs() {
        return this.f70410c;
    }

    @Override // g9.b0
    public b0.a getSeekPoints(long j11) {
        if (!isSeekable()) {
            return new b0.a(new c0(0L, this.f70408a + this.f70409b));
        }
        long r11 = p0.r(j11, 0L, this.f70410c);
        double d11 = (r11 * 100.0d) / this.f70410c;
        double d12 = 0.0d;
        if (d11 > 0.0d) {
            if (d11 >= 100.0d) {
                d12 = 256.0d;
            } else {
                int i11 = (int) d11;
                double d13 = ((long[]) com.google.android.exoplayer2.util.a.i(this.f70413f))[i11];
                d12 = d13 + ((d11 - i11) * ((i11 == 99 ? 256.0d : r3[i11 + 1]) - d13));
            }
        }
        return new b0.a(new c0(r11, this.f70408a + p0.r(Math.round((d12 / 256.0d) * this.f70411d), this.f70409b, this.f70411d - 1)));
    }

    @Override // n9.g
    public long getTimeUs(long j11) {
        long j12 = j11 - this.f70408a;
        if (!isSeekable() || j12 <= this.f70409b) {
            return 0L;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.a.i(this.f70413f);
        double d11 = (j12 * 256.0d) / this.f70411d;
        int i11 = p0.i(jArr, (long) d11, true, true);
        long c11 = c(i11);
        long j13 = jArr[i11];
        int i12 = i11 + 1;
        long c12 = c(i12);
        return c11 + Math.round((j13 == (i11 == 99 ? 256L : jArr[i12]) ? 0.0d : (d11 - j13) / (r0 - j13)) * (c12 - c11));
    }

    @Override // g9.b0
    public boolean isSeekable() {
        return this.f70413f != null;
    }
}
