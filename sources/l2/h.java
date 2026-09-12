package l2;

import androidx.media3.common.util.a1;
import java.util.Arrays;
import l2.m0;

/* loaded from: classes2.dex */
public final class h implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f68706a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f68707b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f68708c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f68709d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f68710e;

    /* renamed from: f, reason: collision with root package name */
    private final long f68711f;

    public h(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f68707b = iArr;
        this.f68708c = jArr;
        this.f68709d = jArr2;
        this.f68710e = jArr3;
        int length = iArr.length;
        this.f68706a = length;
        if (length > 0) {
            this.f68711f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f68711f = 0L;
        }
    }

    public int b(long j11) {
        return a1.h(this.f68710e, j11, true, true);
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f68711f;
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        int b11 = b(j11);
        n0 n0Var = new n0(this.f68710e[b11], this.f68708c[b11]);
        if (n0Var.f68773a >= j11 || b11 == this.f68706a - 1) {
            return new m0.a(n0Var);
        }
        int i11 = b11 + 1;
        return new m0.a(n0Var, new n0(this.f68710e[i11], this.f68708c[i11]));
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f68706a + ", sizes=" + Arrays.toString(this.f68707b) + ", offsets=" + Arrays.toString(this.f68708c) + ", timeUs=" + Arrays.toString(this.f68710e) + ", durationsUs=" + Arrays.toString(this.f68709d) + ")";
    }
}
