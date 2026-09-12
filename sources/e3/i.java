package e3;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.i0;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes2.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    public final i0.a f61660a;

    /* renamed from: b, reason: collision with root package name */
    public final long f61661b;

    /* renamed from: c, reason: collision with root package name */
    public final long f61662c;

    /* renamed from: d, reason: collision with root package name */
    public final int f61663d;

    /* renamed from: e, reason: collision with root package name */
    public final int f61664e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f61665f;

    private i(i0.a aVar, long j11, long j12, long[] jArr, int i11, int i12) {
        this.f61660a = new i0.a(aVar);
        this.f61661b = j11;
        this.f61662c = j12;
        this.f61665f = jArr;
        this.f61663d = i11;
        this.f61664e = i12;
    }

    public static i b(i0.a aVar, j0 j0Var) {
        long[] jArr;
        int i11;
        int i12;
        int q11 = j0Var.q();
        int L = (q11 & 1) != 0 ? j0Var.L() : -1;
        long J = (q11 & 2) != 0 ? j0Var.J() : -1L;
        if ((q11 & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i13 = 0; i13 < 100; i13++) {
                jArr2[i13] = j0Var.H();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((q11 & 8) != 0) {
            j0Var.X(4);
        }
        if (j0Var.a() >= 24) {
            j0Var.X(21);
            int K = j0Var.K();
            i12 = K & UnixStat.PERM_MASK;
            i11 = (16773120 & K) >> 12;
        } else {
            i11 = -1;
            i12 = -1;
        }
        return new i(aVar, L, J, jArr, i11, i12);
    }

    public long a() {
        long j11 = this.f61661b;
        if (j11 == -1 || j11 == 0) {
            return C.TIME_UNSET;
        }
        return a1.d1((j11 * r2.f68735g) - 1, this.f61660a.f68732d);
    }
}
