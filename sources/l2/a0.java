package l2;

import androidx.media3.common.util.a1;
import l2.b0;
import l2.m0;

/* loaded from: classes2.dex */
public final class a0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f68609a;

    /* renamed from: b, reason: collision with root package name */
    private final long f68610b;

    public a0(b0 b0Var, long j11) {
        this.f68609a = b0Var;
        this.f68610b = j11;
    }

    private n0 b(long j11, long j12) {
        return new n0((j11 * 1000000) / this.f68609a.f68628e, this.f68610b + j12);
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f68609a.f();
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        androidx.media3.common.util.a.i(this.f68609a.f68634k);
        b0 b0Var = this.f68609a;
        b0.a aVar = b0Var.f68634k;
        long[] jArr = aVar.f68636a;
        long[] jArr2 = aVar.f68637b;
        int h11 = a1.h(jArr, b0Var.i(j11), true, false);
        n0 b11 = b(h11 == -1 ? 0L : jArr[h11], h11 != -1 ? jArr2[h11] : 0L);
        if (b11.f68773a == j11 || h11 == jArr.length - 1) {
            return new m0.a(b11);
        }
        int i11 = h11 + 1;
        return new m0.a(b11, b(jArr[i11], jArr2[i11]));
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return true;
    }
}
