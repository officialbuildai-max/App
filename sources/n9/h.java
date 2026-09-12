package n9;

import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import g9.b0;
import g9.c0;

/* loaded from: classes4.dex */
final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    private final long[] f70404a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f70405b;

    /* renamed from: c, reason: collision with root package name */
    private final long f70406c;

    /* renamed from: d, reason: collision with root package name */
    private final long f70407d;

    private h(long[] jArr, long[] jArr2, long j11, long j12) {
        this.f70404a = jArr;
        this.f70405b = jArr2;
        this.f70406c = j11;
        this.f70407d = j12;
    }

    public static h b(long j11, long j12, b0.a aVar, d0 d0Var) {
        int D;
        d0Var.Q(10);
        int n11 = d0Var.n();
        if (n11 <= 0) {
            return null;
        }
        int i11 = aVar.f24678d;
        long N0 = p0.N0(n11, (i11 >= 32000 ? 1152 : 576) * 1000000, i11);
        int J = d0Var.J();
        int J2 = d0Var.J();
        int J3 = d0Var.J();
        d0Var.Q(2);
        long j13 = j12 + aVar.f24677c;
        long[] jArr = new long[J];
        long[] jArr2 = new long[J];
        int i12 = 0;
        long j14 = j12;
        while (i12 < J) {
            int i13 = J2;
            long j15 = j13;
            jArr[i12] = (i12 * N0) / J;
            jArr2[i12] = Math.max(j14, j15);
            if (J3 == 1) {
                D = d0Var.D();
            } else if (J3 == 2) {
                D = d0Var.J();
            } else if (J3 == 3) {
                D = d0Var.G();
            } else {
                if (J3 != 4) {
                    return null;
                }
                D = d0Var.H();
            }
            j14 += D * i13;
            i12++;
            jArr = jArr;
            J2 = i13;
            j13 = j15;
        }
        long[] jArr3 = jArr;
        if (j11 != -1 && j11 != j14) {
            s.i("VbriSeeker", "VBRI data size mismatch: " + j11 + ", " + j14);
        }
        return new h(jArr3, jArr2, N0, j14);
    }

    @Override // n9.g
    public long a() {
        return this.f70407d;
    }

    @Override // g9.b0
    public long getDurationUs() {
        return this.f70406c;
    }

    @Override // g9.b0
    public b0.a getSeekPoints(long j11) {
        int i11 = p0.i(this.f70404a, j11, true, true);
        c0 c0Var = new c0(this.f70404a[i11], this.f70405b[i11]);
        if (c0Var.f63498a >= j11 || i11 == this.f70404a.length - 1) {
            return new b0.a(c0Var);
        }
        int i12 = i11 + 1;
        return new b0.a(c0Var, new c0(this.f70404a[i12], this.f70405b[i12]));
    }

    @Override // n9.g
    public long getTimeUs(long j11) {
        return this.f70404a[p0.i(this.f70405b, j11, true, true)];
    }

    @Override // g9.b0
    public boolean isSeekable() {
        return true;
    }
}
