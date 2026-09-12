package e3;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import l2.i0;
import l2.m0;
import l2.n0;

/* loaded from: classes2.dex */
final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long[] f61655a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f61656b;

    /* renamed from: c, reason: collision with root package name */
    private final long f61657c;

    /* renamed from: d, reason: collision with root package name */
    private final long f61658d;

    /* renamed from: e, reason: collision with root package name */
    private final int f61659e;

    private h(long[] jArr, long[] jArr2, long j11, long j12, int i11) {
        this.f61655a = jArr;
        this.f61656b = jArr2;
        this.f61657c = j11;
        this.f61658d = j12;
        this.f61659e = i11;
    }

    public static h b(long j11, long j12, i0.a aVar, j0 j0Var) {
        int H;
        j0Var.X(6);
        long q11 = j12 + aVar.f68731c + j0Var.q();
        int q12 = j0Var.q();
        if (q12 <= 0) {
            return null;
        }
        long d12 = a1.d1((q12 * aVar.f68735g) - 1, aVar.f68732d);
        int P = j0Var.P();
        int P2 = j0Var.P();
        int P3 = j0Var.P();
        j0Var.X(2);
        long j13 = j12 + aVar.f68731c;
        long[] jArr = new long[P];
        long[] jArr2 = new long[P];
        int i11 = 0;
        while (i11 < P) {
            long j14 = d12;
            jArr[i11] = (i11 * d12) / P;
            jArr2[i11] = j13;
            if (P3 == 1) {
                H = j0Var.H();
            } else if (P3 == 2) {
                H = j0Var.P();
            } else if (P3 == 3) {
                H = j0Var.K();
            } else {
                if (P3 != 4) {
                    return null;
                }
                H = j0Var.L();
            }
            j13 += H * P2;
            i11++;
            d12 = j14;
        }
        long j15 = d12;
        if (j11 != -1 && j11 != q11) {
            u.h("VbriSeeker", "VBRI data size mismatch: " + j11 + ", " + q11);
        }
        if (q11 != j13) {
            u.h("VbriSeeker", "VBRI bytes and ToC mismatch (using max): " + q11 + ", " + j13 + "\nSeeking will be inaccurate.");
            q11 = Math.max(q11, j13);
        }
        return new h(jArr, jArr2, j15, q11, aVar.f68734f);
    }

    @Override // e3.g
    public long a() {
        return this.f61658d;
    }

    @Override // e3.g
    public int g() {
        return this.f61659e;
    }

    @Override // l2.m0
    public long getDurationUs() {
        return this.f61657c;
    }

    @Override // l2.m0
    public m0.a getSeekPoints(long j11) {
        int h11 = a1.h(this.f61655a, j11, true, true);
        n0 n0Var = new n0(this.f61655a[h11], this.f61656b[h11]);
        if (n0Var.f68773a >= j11 || h11 == this.f61655a.length - 1) {
            return new m0.a(n0Var);
        }
        int i11 = h11 + 1;
        return new m0.a(n0Var, new n0(this.f61655a[i11], this.f61656b[i11]));
    }

    @Override // e3.g
    public long getTimeUs(long j11) {
        return this.f61655a[a1.h(this.f61656b, j11, true, true)];
    }

    @Override // l2.m0
    public boolean isSeekable() {
        return true;
    }
}
