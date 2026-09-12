package a2;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    final i f184a;

    /* renamed from: b, reason: collision with root package name */
    final long f185b;

    /* renamed from: c, reason: collision with root package name */
    final long f186c;

    /* loaded from: classes.dex */
    public static abstract class a extends k {

        /* renamed from: d, reason: collision with root package name */
        final long f187d;

        /* renamed from: e, reason: collision with root package name */
        final long f188e;

        /* renamed from: f, reason: collision with root package name */
        final List f189f;

        /* renamed from: g, reason: collision with root package name */
        private final long f190g;

        /* renamed from: h, reason: collision with root package name */
        private final long f191h;

        /* renamed from: i, reason: collision with root package name */
        final long f192i;

        public a(i iVar, long j11, long j12, long j13, long j14, List list, long j15, long j16, long j17) {
            super(iVar, j11, j12);
            this.f187d = j13;
            this.f188e = j14;
            this.f189f = list;
            this.f192i = j15;
            this.f190g = j16;
            this.f191h = j17;
        }

        public long c(long j11, long j12) {
            long g11 = g(j11);
            return g11 != -1 ? g11 : (int) (i((j12 - this.f191h) + this.f192i, j11) - d(j11, j12));
        }

        public long d(long j11, long j12) {
            if (g(j11) == -1) {
                long j13 = this.f190g;
                if (j13 != C.TIME_UNSET) {
                    return Math.max(e(), i((j12 - this.f191h) - j13, j11));
                }
            }
            return e();
        }

        public long e() {
            return this.f187d;
        }

        public long f(long j11, long j12) {
            if (this.f189f != null) {
                return C.TIME_UNSET;
            }
            long d11 = d(j11, j12) + c(j11, j12);
            return (j(d11) + h(d11, j11)) - this.f192i;
        }

        public abstract long g(long j11);

        public final long h(long j11, long j12) {
            List list = this.f189f;
            if (list != null) {
                return (((d) list.get((int) (j11 - this.f187d))).f198b * 1000000) / this.f185b;
            }
            long g11 = g(j12);
            return (g11 == -1 || j11 != (e() + g11) - 1) ? (this.f188e * 1000000) / this.f185b : j12 - j(j11);
        }

        public long i(long j11, long j12) {
            long e11 = e();
            long g11 = g(j12);
            if (g11 == 0) {
                return e11;
            }
            if (this.f189f == null) {
                long j13 = this.f187d + (j11 / ((this.f188e * 1000000) / this.f185b));
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
            List list = this.f189f;
            return a1.e1(list != null ? ((d) list.get((int) (j11 - this.f187d))).f197a - this.f186c : (j11 - this.f187d) * this.f188e, 1000000L, this.f185b);
        }

        public abstract i k(j jVar, long j11);

        public boolean l() {
            return this.f189f != null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a {

        /* renamed from: j, reason: collision with root package name */
        final List f193j;

        public b(i iVar, long j11, long j12, long j13, long j14, List list, long j15, List list2, long j16, long j17) {
            super(iVar, j11, j12, j13, j14, list, j15, j16, j17);
            this.f193j = list2;
        }

        @Override // a2.k.a
        public long g(long j11) {
            return this.f193j.size();
        }

        @Override // a2.k.a
        public i k(j jVar, long j11) {
            return (i) this.f193j.get((int) (j11 - this.f187d));
        }

        @Override // a2.k.a
        public boolean l() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends a {

        /* renamed from: j, reason: collision with root package name */
        final n f194j;

        /* renamed from: k, reason: collision with root package name */
        final n f195k;

        /* renamed from: l, reason: collision with root package name */
        final long f196l;

        public c(i iVar, long j11, long j12, long j13, long j14, long j15, List list, long j16, n nVar, n nVar2, long j17, long j18) {
            super(iVar, j11, j12, j13, j15, list, j16, j17, j18);
            this.f194j = nVar;
            this.f195k = nVar2;
            this.f196l = j14;
        }

        @Override // a2.k
        public i a(j jVar) {
            n nVar = this.f194j;
            if (nVar == null) {
                return super.a(jVar);
            }
            r rVar = jVar.f171b;
            return new i(nVar.a(rVar.f10229a, 0L, rVar.f10238j, 0L), 0L, -1L);
        }

        @Override // a2.k.a
        public long g(long j11) {
            if (this.f189f != null) {
                return r0.size();
            }
            long j12 = this.f196l;
            if (j12 != -1) {
                return (j12 - this.f187d) + 1;
            }
            if (j11 != C.TIME_UNSET) {
                return com.google.common.math.a.a(BigInteger.valueOf(j11).multiply(BigInteger.valueOf(this.f185b)), BigInteger.valueOf(this.f188e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        @Override // a2.k.a
        public i k(j jVar, long j11) {
            List list = this.f189f;
            long j12 = list != null ? ((d) list.get((int) (j11 - this.f187d))).f197a : (j11 - this.f187d) * this.f188e;
            n nVar = this.f195k;
            r rVar = jVar.f171b;
            return new i(nVar.a(rVar.f10229a, j11, rVar.f10238j, j12), 0L, -1L);
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        final long f197a;

        /* renamed from: b, reason: collision with root package name */
        final long f198b;

        public d(long j11, long j12) {
            this.f197a = j11;
            this.f198b = j12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f197a == dVar.f197a && this.f198b == dVar.f198b;
        }

        public int hashCode() {
            return (((int) this.f197a) * 31) + ((int) this.f198b);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends k {

        /* renamed from: d, reason: collision with root package name */
        final long f199d;

        /* renamed from: e, reason: collision with root package name */
        final long f200e;

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public e(i iVar, long j11, long j12, long j13, long j14) {
            super(iVar, j11, j12);
            this.f199d = j13;
            this.f200e = j14;
        }

        public i c() {
            long j11 = this.f200e;
            if (j11 <= 0) {
                return null;
            }
            return new i(null, this.f199d, j11);
        }
    }

    public k(i iVar, long j11, long j12) {
        this.f184a = iVar;
        this.f185b = j11;
        this.f186c = j12;
    }

    public i a(j jVar) {
        return this.f184a;
    }

    public long b() {
        return a1.e1(this.f186c, 1000000L, this.f185b);
    }
}
