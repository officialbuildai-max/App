package q9;

import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.a;

/* loaded from: classes4.dex */
final class e0 extends g9.a {

    /* loaded from: classes4.dex */
    private static final class a implements a.f {

        /* renamed from: a, reason: collision with root package name */
        private final l0 f73346a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.d0 f73347b = new com.google.android.exoplayer2.util.d0();

        /* renamed from: c, reason: collision with root package name */
        private final int f73348c;

        /* renamed from: d, reason: collision with root package name */
        private final int f73349d;

        public a(int i11, l0 l0Var, int i12) {
            this.f73348c = i11;
            this.f73346a = l0Var;
            this.f73349d = i12;
        }

        private a.e c(com.google.android.exoplayer2.util.d0 d0Var, long j11, long j12) {
            int a11;
            int a12;
            int f11 = d0Var.f();
            long j13 = -1;
            long j14 = -1;
            long j15 = -9223372036854775807L;
            while (d0Var.a() >= 188 && (a12 = (a11 = j0.a(d0Var.d(), d0Var.e(), f11)) + 188) <= f11) {
                long c11 = j0.c(d0Var, a11, this.f73348c);
                if (c11 != C.TIME_UNSET) {
                    long b11 = this.f73346a.b(c11);
                    if (b11 > j11) {
                        return j15 == C.TIME_UNSET ? a.e.d(b11, j12) : a.e.e(j12 + j14);
                    }
                    if (100000 + b11 > j11) {
                        return a.e.e(j12 + a11);
                    }
                    j14 = a11;
                    j15 = b11;
                }
                d0Var.P(a12);
                j13 = a12;
            }
            return j15 != C.TIME_UNSET ? a.e.f(j15, j12 + j13) : a.e.f63488d;
        }

        @Override // g9.a.f
        public void a() {
            this.f73347b.M(p0.f27685f);
        }

        @Override // g9.a.f
        public a.e b(g9.m mVar, long j11) {
            long position = mVar.getPosition();
            int min = (int) Math.min(this.f73349d, mVar.getLength() - position);
            this.f73347b.L(min);
            mVar.peekFully(this.f73347b.d(), 0, min);
            return c(this.f73347b, j11, position);
        }
    }

    public e0(l0 l0Var, long j11, long j12, int i11, int i12) {
        super(new a.b(), new a(i11, l0Var, i12), j11, 0L, j11 + 1, 0L, j12, 188L, 940);
    }
}
