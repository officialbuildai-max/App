package s3;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.p0;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z extends l2.e {

    /* loaded from: classes2.dex */
    private static final class b implements e.f {

        /* renamed from: a, reason: collision with root package name */
        private final p0 f75402a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.media3.common.util.j0 f75403b;

        private b(p0 p0Var) {
            this.f75402a = p0Var;
            this.f75403b = new androidx.media3.common.util.j0();
        }

        private e.C0853e c(androidx.media3.common.util.j0 j0Var, long j11, long j12) {
            int i11 = -1;
            int i12 = -1;
            long j13 = -9223372036854775807L;
            while (j0Var.a() >= 4) {
                if (z.k(j0Var.e(), j0Var.f()) != 442) {
                    j0Var.X(1);
                } else {
                    j0Var.X(4);
                    long l11 = a0.l(j0Var);
                    if (l11 != C.TIME_UNSET) {
                        long b11 = this.f75402a.b(l11);
                        if (b11 > j11) {
                            return j13 == C.TIME_UNSET ? e.C0853e.d(b11, j12) : e.C0853e.e(j12 + i12);
                        }
                        if (100000 + b11 > j11) {
                            return e.C0853e.e(j12 + j0Var.f());
                        }
                        i12 = j0Var.f();
                        j13 = b11;
                    }
                    d(j0Var);
                    i11 = j0Var.f();
                }
            }
            return j13 != C.TIME_UNSET ? e.C0853e.f(j13, j12 + i11) : e.C0853e.f68683d;
        }

        private static void d(androidx.media3.common.util.j0 j0Var) {
            int k11;
            int g11 = j0Var.g();
            if (j0Var.a() < 10) {
                j0Var.W(g11);
                return;
            }
            j0Var.X(9);
            int H = j0Var.H() & 7;
            if (j0Var.a() < H) {
                j0Var.W(g11);
                return;
            }
            j0Var.X(H);
            if (j0Var.a() < 4) {
                j0Var.W(g11);
                return;
            }
            if (z.k(j0Var.e(), j0Var.f()) == 443) {
                j0Var.X(4);
                int P = j0Var.P();
                if (j0Var.a() < P) {
                    j0Var.W(g11);
                    return;
                }
                j0Var.X(P);
            }
            while (j0Var.a() >= 4 && (k11 = z.k(j0Var.e(), j0Var.f())) != 442 && k11 != 441 && (k11 >>> 8) == 1) {
                j0Var.X(4);
                if (j0Var.a() < 2) {
                    j0Var.W(g11);
                    return;
                }
                j0Var.W(Math.min(j0Var.g(), j0Var.f() + j0Var.P()));
            }
        }

        @Override // l2.e.f
        public void a() {
            this.f75403b.T(a1.f10437f);
        }

        @Override // l2.e.f
        public e.C0853e b(l2.s sVar, long j11) {
            long position = sVar.getPosition();
            int min = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, sVar.getLength() - position);
            this.f75403b.S(min);
            sVar.peekFully(this.f75403b.e(), 0, min);
            return c(this.f75403b, j11, position);
        }
    }

    public z(p0 p0Var, long j11, long j12) {
        super(new e.b(), new b(p0Var), j11, 0L, j11 + 1, 0L, j12, 188L, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }
}
