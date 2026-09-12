package s3;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.e;

/* loaded from: classes2.dex */
final class h0 extends l2.e {

    /* loaded from: classes2.dex */
    private static final class a implements e.f {

        /* renamed from: a, reason: collision with root package name */
        private final p0 f75072a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.media3.common.util.j0 f75073b = new androidx.media3.common.util.j0();

        /* renamed from: c, reason: collision with root package name */
        private final int f75074c;

        /* renamed from: d, reason: collision with root package name */
        private final int f75075d;

        public a(int i11, p0 p0Var, int i12) {
            this.f75074c = i11;
            this.f75072a = p0Var;
            this.f75075d = i12;
        }

        private e.C0853e c(androidx.media3.common.util.j0 j0Var, long j11, long j12) {
            int a11;
            int a12;
            int g11 = j0Var.g();
            long j13 = -1;
            long j14 = -1;
            long j15 = -9223372036854775807L;
            while (j0Var.a() >= 188 && (a12 = (a11 = m0.a(j0Var.e(), j0Var.f(), g11)) + 188) <= g11) {
                long c11 = m0.c(j0Var, a11, this.f75074c);
                if (c11 != C.TIME_UNSET) {
                    long b11 = this.f75072a.b(c11);
                    if (b11 > j11) {
                        return j15 == C.TIME_UNSET ? e.C0853e.d(b11, j12) : e.C0853e.e(j12 + j14);
                    }
                    if (100000 + b11 > j11) {
                        return e.C0853e.e(j12 + a11);
                    }
                    j14 = a11;
                    j15 = b11;
                }
                j0Var.W(a12);
                j13 = a12;
            }
            return j15 != C.TIME_UNSET ? e.C0853e.f(j15, j12 + j13) : e.C0853e.f68683d;
        }

        @Override // l2.e.f
        public void a() {
            this.f75073b.T(a1.f10437f);
        }

        @Override // l2.e.f
        public e.C0853e b(l2.s sVar, long j11) {
            long position = sVar.getPosition();
            int min = (int) Math.min(this.f75075d, sVar.getLength() - position);
            this.f75073b.S(min);
            sVar.peekFully(this.f75073b.e(), 0, min);
            return c(this.f75073b, j11, position);
        }
    }

    public h0(p0 p0Var, long j11, long j12, int i11, int i12) {
        super(new e.b(), new a(i11, p0Var, i12), j11, 0L, j11 + 1, 0L, j12, 188L, 940);
    }
}
