package x9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    final i f78247a;

    /* renamed from: b, reason: collision with root package name */
    final long f78248b;

    /* renamed from: c, reason: collision with root package name */
    final long f78249c;

    /* loaded from: classes4.dex */
    public static abstract class a extends k {

        /* renamed from: d, reason: collision with root package name */
        final long f78250d;

        /* renamed from: e, reason: collision with root package name */
        final long f78251e;

        /* renamed from: f, reason: collision with root package name */
        final List f78252f;

        /* renamed from: g, reason: collision with root package name */
        private final long f78253g;

        /* renamed from: h, reason: collision with root package name */
        private final long f78254h;

        /* renamed from: i, reason: collision with root package name */
        final long f78255i;

        public a(i iVar, long j11, long j12, long j13, long j14, List list, long j15, long j16, long j17) {
            super(iVar, j11, j12);
            this.f78250d = j13;
            this.f78251e = j14;
            this.f78252f = list;
            this.f78255i = j15;
            this.f78253g = j16;
            this.f78254h = j17;
        }

        public long c(long j11, long j12) {
            long g11 = g(j11);
            return g11 != -1 ? g11 : (int) (i((j12 - this.f78254h) + this.f78255i, j11) - d(j11, j12));
        }

        public long d(long j11, long j12) {
            if (g(j11) == -1) {
                long j13 = this.f78253g;
                if (j13 != C.TIME_UNSET) {
                    return Math.max(e(), i((j12 - this.f78254h) - j13, j11));
                }
            }
            return e();
        }

        public long e() {
            return this.f78250d;
        }

        public long f(long j11, long j12) {
            if (this.f78252f != null) {
                return C.TIME_UNSET;
            }
            long d11 = d(j11, j12) + c(j11, j12);
            return (j(d11) + h(d11, j11)) - this.f78255i;
        }

        public abstract long g(long j11);

        public final long h(long j11, long j12) {
            List list = this.f78252f;
            if (list != null) {
                return (((d) list.get((int) (j11 - this.f78250d))).f78261b * 1000000) / this.f78248b;
            }
            long g11 = g(j12);
            return (g11 == -1 || j11 != (e() + g11) - 1) ? (this.f78251e * 1000000) / this.f78248b : j12 - j(j11);
        }

        public long i(long j11, long j12) {
            long e11 = e();
            long g11 = g(j12);
            if (g11 == 0) {
                return e11;
            }
            if (this.f78252f == null) {
                long j13 = this.f78250d + (j11 / ((this.f78251e * 1000000) / this.f78248b));
                return j13 < e11 ? e11 : g11 == -1 ? j13 : Math.min(j13, (e11 + g11) - 1);
            }
            long j14 = (g11 + e11) - 1;
            long j15 = e11;
            while (j15 <= j14) {
                long j16 = ((j14 - j15) / 2) + j15;
                long j17 = j(j16);
                if (j17 < j11) {
                    j15 = j16 + 1;
                } else {
                    if (j17 <= j11) {
                        return j16;
                    }
                    j14 = j16 - 1;
                }
            }
            return j15 == e11 ? j15 : j14;
        }

        public final long j(long j11) {
            List list = this.f78252f;
            return p0.N0(list != null ? ((d) list.get((int) (j11 - this.f78250d))).f78260a - this.f78249c : (j11 - this.f78250d) * this.f78251e, 1000000L, this.f78248b);
        }

        public abstract i k(j jVar, long j11);

        public boolean l() {
            return this.f78252f != null;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends a {

        /* renamed from: j, reason: collision with root package name */
        final List f78256j;

        public b(i iVar, long j11, long j12, long j13, long j14, List list, long j15, List list2, long j16, long j17) {
            super(iVar, j11, j12, j13, j14, list, j15, j16, j17);
            this.f78256j = list2;
        }

        @Override // x9.k.a
        public long g(long j11) {
            return this.f78256j.size();
        }

        @Override // x9.k.a
        public i k(j jVar, long j11) {
            return (i) this.f78256j.get((int) (j11 - this.f78250d));
        }

        @Override // x9.k.a
        public boolean l() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends a {

        /* renamed from: j, reason: collision with root package name */
        final n f78257j;

        /* renamed from: k, reason: collision with root package name */
        final n f78258k;

        /* renamed from: l, reason: collision with root package name */
        final long f78259l;

        public c(i iVar, long j11, long j12, long j13, long j14, long j15, List list, long j16, n nVar, n nVar2, long j17, long j18) {
            super(iVar, j11, j12, j13, j15, list, j16, j17, j18);
            this.f78257j = nVar;
            this.f78258k = nVar2;
            this.f78259l = j14;
        }

        @Override // x9.k
        public i a(j jVar) {
            n nVar = this.f78257j;
            if (nVar == null) {
                return super.a(jVar);
            }
            o1 o1Var = jVar.f78234b;
            return new i(nVar.a(o1Var.f25539a, 0L, o1Var.f25546h, 0L), 0L, -1L);
        }

        @Override // x9.k.a
        public long g(long j11) {
            if (this.f78252f != null) {
                return r0.size();
            }
            long j12 = this.f78259l;
            if (j12 != -1) {
                return (j12 - this.f78250d) + 1;
            }
            if (j11 != C.TIME_UNSET) {
                return com.google.common.math.a.a(BigInteger.valueOf(j11).multiply(BigInteger.valueOf(this.f78248b)), BigInteger.valueOf(this.f78251e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        @Override // x9.k.a
        public i k(j jVar, long j11) {
            List list = this.f78252f;
            long j12 = list != null ? ((d) list.get((int) (j11 - this.f78250d))).f78260a : (j11 - this.f78250d) * this.f78251e;
            n nVar = this.f78258k;
            o1 o1Var = jVar.f78234b;
            return new i(nVar.a(o1Var.f25539a, j11, o1Var.f25546h, j12), 0L, -1L);
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        final long f78260a;

        /* renamed from: b, reason: collision with root package name */
        final long f78261b;

        public d(long j11, long j12) {
            this.f78260a = j11;
            this.f78261b = j12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f78260a == dVar.f78260a && this.f78261b == dVar.f78261b;
        }

        public int hashCode() {
            return (((int) this.f78260a) * 31) + ((int) this.f78261b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends k {

        /* renamed from: d, reason: collision with root package name */
        final long f78262d;

        /* renamed from: e, reason: collision with root package name */
        final long f78263e;

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public e(i iVar, long j11, long j12, long j13, long j14) {
            super(iVar, j11, j12);
            this.f78262d = j13;
            this.f78263e = j14;
        }

        public i c() {
            long j11 = this.f78263e;
            if (j11 <= 0) {
                return null;
            }
            return new i(null, this.f78262d, j11);
        }
    }

    public k(i iVar, long j11, long j12) {
        this.f78247a = iVar;
        this.f78248b = j11;
        this.f78249c = j12;
    }

    public i a(j jVar) {
        return this.f78247a;
    }

    public long b() {
        return p0.N0(this.f78249c, 1000000L, this.f78248b);
    }
}
