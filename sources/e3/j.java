package e3;

import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.i0;
import l2.m0;
import l2.n0;

/* loaded from: classes2.dex */
final class j implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long f61666a;

    /* renamed from: b, reason: collision with root package name */
    private final int f61667b;

    /* renamed from: c, reason: collision with root package name */
    private final long f61668c;

    /* renamed from: d, reason: collision with root package name */
    private final int f61669d;

    /* renamed from: e, reason: collision with root package name */
    private final long f61670e;

    /* renamed from: f, reason: collision with root package name */
    private final long f61671f;

    /* renamed from: g, reason: collision with root package name */
    private final long[] f61672g;

    private j(long j11, int i11, long j12, int i12) {
        this(j11, i11, j12, i12, -1L, null);
    }

    private j(long j11, int i11, long j12, int i12, long j13, long[] jArr) {
        this.f61666a = j11;
        this.f61667b = i11;
        this.f61668c = j12;
        this.f61669d = i12;
        this.f61670e = j13;
        this.f61672g = jArr;
        this.f61671f = j13 != -1 ? j11 + j13 : -1L;
    }

    public static j b(i iVar, long j11) {
        long[] jArr;
        long a11 = iVar.a();
        if (a11 == C.TIME_UNSET) {
            return null;
        }
        long j12 = iVar.f61662c;
        if (j12 == -1 || (jArr = iVar.f61665f) == null) {
            i0.a aVar = iVar.f61660a;
            return new j(j11, aVar.f68731c, a11, aVar.f68734f);
        }
        i0.a aVar2 = iVar.f61660a;
        return new j(j11, aVar2.f68731c, a11, aVar2.f68734f, j12, jArr);
    }

    private long c(int i11) {
        return (this.f61668c * i11) / 100;
    }

    @Override // e3.g
    public long a() {
        return this.f61671f;
    }

    @Override // e3.g
    public int g() {
        return this.f61669d;
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f61668c;
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        if (!isSeekable()) {
            return new m0.a(new n0(0L, this.f61666a + this.f61667b));
        }
        long q11 = a1.q(j11, 0L, this.f61668c);
        double d11 = (q11 * 100.0d) / this.f61668c;
        double d12 = 0.0d;
        if (d11 > 0.0d) {
            if (d11 >= 100.0d) {
                d12 = 256.0d;
            } else {
                int i11 = (int) d11;
                double d13 = ((long[]) androidx.media3.common.util.a.i(this.f61672g))[i11];
                d12 = d13 + ((d11 - i11) * ((i11 == 99 ? 256.0d : r3[i11 + 1]) - d13));
            }
        }
        return new m0.a(new n0(q11, this.f61666a + a1.q(Math.round((d12 / 256.0d) * this.f61670e), this.f61667b, this.f61670e - 1)));
    }

    @Override // e3.g
    public long getTimeUs(long j11) {
        long j12 = j11 - this.f61666a;
        if (!isSeekable() || j12 <= this.f61667b) {
            return 0L;
        }
        long[] jArr = (long[]) androidx.media3.common.util.a.i(this.f61672g);
        double d11 = (j12 * 256.0d) / this.f61670e;
        int h11 = a1.h(jArr, (long) d11, true, true);
        long c11 = c(h11);
        long j13 = jArr[h11];
        int i11 = h11 + 1;
        long c12 = c(i11);
        return c11 + Math.round((j13 == (h11 == 99 ? 256L : jArr[i11]) ? 0.0d : (d11 - j13) / (r0 - j13)) * (c12 - c11));
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return this.f61672g != null;
    }
}
