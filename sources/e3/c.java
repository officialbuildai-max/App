package e3;

import android.util.Pair;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.m0;
import l2.n0;
import z2.l;

/* loaded from: classes2.dex */
final class c implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long[] f61629a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f61630b;

    /* renamed from: c, reason: collision with root package name */
    private final long f61631c;

    private c(long[] jArr, long[] jArr2, long j11) {
        this.f61629a = jArr;
        this.f61630b = jArr2;
        this.f61631c = j11 == C.TIME_UNSET ? a1.R0(jArr2[jArr2.length - 1]) : j11;
    }

    public static c b(long j11, l lVar, long j12) {
        int length = lVar.f79323e.length;
        int i11 = length + 1;
        long[] jArr = new long[i11];
        long[] jArr2 = new long[i11];
        jArr[0] = j11;
        long j13 = 0;
        jArr2[0] = 0;
        for (int i12 = 1; i12 <= length; i12++) {
            int i13 = i12 - 1;
            j11 += lVar.f79321c + lVar.f79323e[i13];
            j13 += lVar.f79322d + lVar.f79324f[i13];
            jArr[i12] = j11;
            jArr2[i12] = j13;
        }
        return new c(jArr, jArr2, j12);
    }

    private static Pair c(long j11, long[] jArr, long[] jArr2) {
        int h11 = a1.h(jArr, j11, true, true);
        long j12 = jArr[h11];
        long j13 = jArr2[h11];
        int i11 = h11 + 1;
        if (i11 == jArr.length) {
            return Pair.create(Long.valueOf(j12), Long.valueOf(j13));
        }
        return Pair.create(Long.valueOf(j11), Long.valueOf(((long) ((jArr[i11] == j12 ? 0.0d : (j11 - j12) / (r6 - j12)) * (jArr2[i11] - j13))) + j13));
    }

    @Override // e3.g
    public long a() {
        return -1L;
    }

    @Override // e3.g
    public int g() {
        return -2147483647;
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f61631c;
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        Pair c11 = c(a1.y1(a1.q(j11, 0L, this.f61631c)), this.f61630b, this.f61629a);
        return new m0.a(new n0(a1.R0(((Long) c11.first).longValue()), ((Long) c11.second).longValue()));
    }

    @Override // e3.g
    public long getTimeUs(long j11) {
        return a1.R0(((Long) c(j11, this.f61629a, this.f61630b).second).longValue());
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return true;
    }
}
