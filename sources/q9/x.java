package q9;

import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class x extends g9.a {

    /* loaded from: classes4.dex */
    private static final class b implements a.f {

        /* renamed from: a, reason: collision with root package name */
        private final l0 f73650a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.d0 f73651b;

        private b(l0 l0Var) {
            this.f73650a = l0Var;
            this.f73651b = new com.google.android.exoplayer2.util.d0();
        }

        private a.e c(com.google.android.exoplayer2.util.d0 d0Var, long j11, long j12) {
            int i11 = -1;
            int i12 = -1;
            long j13 = -9223372036854775807L;
            while (d0Var.a() >= 4) {
                if (x.k(d0Var.d(), d0Var.e()) != 442) {
                    d0Var.Q(1);
                } else {
                    d0Var.Q(4);
                    long l11 = y.l(d0Var);
                    if (l11 != C.TIME_UNSET) {
                        long b11 = this.f73650a.b(l11);
                        if (b11 > j11) {
                            return j13 == C.TIME_UNSET ? a.e.d(b11, j12) : a.e.e(j12 + i12);
                        }
                        if (100000 + b11 > j11) {
                            return a.e.e(j12 + d0Var.e());
                        }
                        i12 = d0Var.e();
                        j13 = b11;
                    }
                    d(d0Var);
                    i11 = d0Var.e();
                }
            }
            return j13 != C.TIME_UNSET ? a.e.f(j13, j12 + i11) : a.e.f63488d;
        }

        private static void d(com.google.android.exoplayer2.util.d0 d0Var) {
            int k11;
            int f11 = d0Var.f();
            if (d0Var.a() < 10) {
                d0Var.P(f11);
                return;
            }
            d0Var.Q(9);
            int D = d0Var.D() & 7;
            if (d0Var.a() < D) {
                d0Var.P(f11);
                return;
            }
            d0Var.Q(D);
            if (d0Var.a() < 4) {
                d0Var.P(f11);
                return;
            }
            if (x.k(d0Var.d(), d0Var.e()) == 443) {
                d0Var.Q(4);
                int J = d0Var.J();
                if (d0Var.a() < J) {
                    d0Var.P(f11);
                    return;
                }
                d0Var.Q(J);
            }
            while (d0Var.a() >= 4 && (k11 = x.k(d0Var.d(), d0Var.e())) != 442 && k11 != 441 && (k11 >>> 8) == 1) {
                d0Var.Q(4);
                if (d0Var.a() < 2) {
                    d0Var.P(f11);
                    return;
                }
                d0Var.P(Math.min(d0Var.f(), d0Var.e() + d0Var.J()));
            }
        }

        @Override // g9.a.f
        public void a() {
            this.f73651b.M(p0.f27685f);
        }

        @Override // g9.a.f
        public a.e b(g9.m mVar, long j11) {
            long position = mVar.getPosition();
            int min = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, mVar.getLength() - position);
            this.f73651b.L(min);
            mVar.peekFully(this.f73651b.d(), 0, min);
            return c(this.f73651b, j11, position);
        }
    }

    public x(l0 l0Var, long j11, long j12) {
        super(new a.b(), new b(l0Var), j11, 0L, j11 + 1, 0L, j12, 188L, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }
}
