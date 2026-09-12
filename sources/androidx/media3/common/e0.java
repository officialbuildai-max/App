package androidx.media3.common;

import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.b;
import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f10007a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10008b = a1.C0(0);

    /* renamed from: c, reason: collision with root package name */
    private static final String f10009c = a1.C0(1);

    /* renamed from: d, reason: collision with root package name */
    private static final String f10010d = a1.C0(2);

    /* loaded from: classes2.dex */
    class a extends e0 {
        a() {
        }

        @Override // androidx.media3.common.e0
        public int b(Object obj) {
            return -1;
        }

        @Override // androidx.media3.common.e0
        public b g(int i11, b bVar, boolean z10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.e0
        public int i() {
            return 0;
        }

        @Override // androidx.media3.common.e0
        public Object m(int i11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.e0
        public c o(int i11, c cVar, long j11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.e0
        public int p() {
            return 0;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: h, reason: collision with root package name */
        private static final String f10011h = a1.C0(0);

        /* renamed from: i, reason: collision with root package name */
        private static final String f10012i = a1.C0(1);

        /* renamed from: j, reason: collision with root package name */
        private static final String f10013j = a1.C0(2);

        /* renamed from: k, reason: collision with root package name */
        private static final String f10014k = a1.C0(3);

        /* renamed from: l, reason: collision with root package name */
        private static final String f10015l = a1.C0(4);

        /* renamed from: a, reason: collision with root package name */
        public Object f10016a;

        /* renamed from: b, reason: collision with root package name */
        public Object f10017b;

        /* renamed from: c, reason: collision with root package name */
        public int f10018c;

        /* renamed from: d, reason: collision with root package name */
        public long f10019d;

        /* renamed from: e, reason: collision with root package name */
        public long f10020e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f10021f;

        /* renamed from: g, reason: collision with root package name */
        public androidx.media3.common.b f10022g = androidx.media3.common.b.f9955g;

        public int a(int i11) {
            return this.f10022g.a(i11).f9979b;
        }

        public long b(int i11, int i12) {
            b.a a11 = this.f10022g.a(i11);
            return a11.f9979b != -1 ? a11.f9984g[i12] : C.TIME_UNSET;
        }

        public int c() {
            return this.f10022g.f9962b;
        }

        public int d(long j11) {
            return this.f10022g.b(j11, this.f10019d);
        }

        public int e(long j11) {
            return this.f10022g.c(j11, this.f10019d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return Objects.equals(this.f10016a, bVar.f10016a) && Objects.equals(this.f10017b, bVar.f10017b) && this.f10018c == bVar.f10018c && this.f10019d == bVar.f10019d && this.f10020e == bVar.f10020e && this.f10021f == bVar.f10021f && Objects.equals(this.f10022g, bVar.f10022g);
        }

        public long f(int i11) {
            return this.f10022g.a(i11).f9978a;
        }

        public long g() {
            return this.f10022g.f9963c;
        }

        public int h(int i11, int i12) {
            b.a a11 = this.f10022g.a(i11);
            if (a11.f9979b != -1) {
                return a11.f9983f[i12];
            }
            return 0;
        }

        public int hashCode() {
            Object obj = this.f10016a;
            int hashCode = (Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f10017b;
            int hashCode2 = (((hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f10018c) * 31;
            long j11 = this.f10019d;
            int i11 = (hashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f10020e;
            return ((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f10021f ? 1 : 0)) * 31) + this.f10022g.hashCode();
        }

        public long i(int i11) {
            return this.f10022g.a(i11).f9986i;
        }

        public long j() {
            return a1.y1(this.f10019d);
        }

        public long k() {
            return this.f10019d;
        }

        public int l(int i11) {
            return this.f10022g.a(i11).c();
        }

        public int m(int i11, int i12) {
            return this.f10022g.a(i11).d(i12);
        }

        public long n() {
            return a1.y1(this.f10020e);
        }

        public long o() {
            return this.f10020e;
        }

        public int p() {
            return this.f10022g.f9965e;
        }

        public boolean q(int i11) {
            return !this.f10022g.a(i11).e();
        }

        public boolean r(int i11) {
            return i11 == c() - 1 && this.f10022g.d(i11);
        }

        public boolean s(int i11) {
            return this.f10022g.a(i11).f9987j;
        }

        public b t(Object obj, Object obj2, int i11, long j11, long j12) {
            return u(obj, obj2, i11, j11, j12, androidx.media3.common.b.f9955g, false);
        }

        public b u(Object obj, Object obj2, int i11, long j11, long j12, androidx.media3.common.b bVar, boolean z10) {
            this.f10016a = obj;
            this.f10017b = obj2;
            this.f10018c = i11;
            this.f10019d = j11;
            this.f10020e = j12;
            this.f10022g = bVar;
            this.f10021f = z10;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: b, reason: collision with root package name */
        public Object f10034b;

        /* renamed from: d, reason: collision with root package name */
        public Object f10036d;

        /* renamed from: e, reason: collision with root package name */
        public long f10037e;

        /* renamed from: f, reason: collision with root package name */
        public long f10038f;

        /* renamed from: g, reason: collision with root package name */
        public long f10039g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f10040h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f10041i;

        /* renamed from: j, reason: collision with root package name */
        public t.g f10042j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f10043k;

        /* renamed from: l, reason: collision with root package name */
        public long f10044l;

        /* renamed from: m, reason: collision with root package name */
        public long f10045m;

        /* renamed from: n, reason: collision with root package name */
        public int f10046n;

        /* renamed from: o, reason: collision with root package name */
        public int f10047o;

        /* renamed from: p, reason: collision with root package name */
        public long f10048p;

        /* renamed from: q, reason: collision with root package name */
        public static final Object f10023q = new Object();

        /* renamed from: r, reason: collision with root package name */
        private static final Object f10024r = new Object();

        /* renamed from: s, reason: collision with root package name */
        private static final t f10025s = new t.c().d("androidx.media3.common.Timeline").i(Uri.EMPTY).a();

        /* renamed from: t, reason: collision with root package name */
        private static final String f10026t = a1.C0(1);

        /* renamed from: u, reason: collision with root package name */
        private static final String f10027u = a1.C0(2);

        /* renamed from: v, reason: collision with root package name */
        private static final String f10028v = a1.C0(3);

        /* renamed from: w, reason: collision with root package name */
        private static final String f10029w = a1.C0(4);

        /* renamed from: x, reason: collision with root package name */
        private static final String f10030x = a1.C0(5);

        /* renamed from: y, reason: collision with root package name */
        private static final String f10031y = a1.C0(6);

        /* renamed from: z, reason: collision with root package name */
        private static final String f10032z = a1.C0(7);
        private static final String A = a1.C0(8);
        private static final String B = a1.C0(9);
        private static final String C = a1.C0(10);
        private static final String D = a1.C0(11);
        private static final String E = a1.C0(12);
        private static final String F = a1.C0(13);

        /* renamed from: a, reason: collision with root package name */
        public Object f10033a = f10023q;

        /* renamed from: c, reason: collision with root package name */
        public t f10035c = f10025s;

        public long a() {
            return a1.h0(this.f10039g);
        }

        public long b() {
            return a1.y1(this.f10044l);
        }

        public long c() {
            return this.f10044l;
        }

        public long d() {
            return a1.y1(this.f10045m);
        }

        public long e() {
            return this.f10048p;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !c.class.equals(obj.getClass())) {
                return false;
            }
            c cVar = (c) obj;
            return Objects.equals(this.f10033a, cVar.f10033a) && Objects.equals(this.f10035c, cVar.f10035c) && Objects.equals(this.f10036d, cVar.f10036d) && Objects.equals(this.f10042j, cVar.f10042j) && this.f10037e == cVar.f10037e && this.f10038f == cVar.f10038f && this.f10039g == cVar.f10039g && this.f10040h == cVar.f10040h && this.f10041i == cVar.f10041i && this.f10043k == cVar.f10043k && this.f10044l == cVar.f10044l && this.f10045m == cVar.f10045m && this.f10046n == cVar.f10046n && this.f10047o == cVar.f10047o && this.f10048p == cVar.f10048p;
        }

        public boolean f() {
            return this.f10042j != null;
        }

        public c g(Object obj, t tVar, Object obj2, long j11, long j12, long j13, boolean z10, boolean z11, t.g gVar, long j14, long j15, int i11, int i12, long j16) {
            t.h hVar;
            this.f10033a = obj;
            this.f10035c = tVar != null ? tVar : f10025s;
            this.f10034b = (tVar == null || (hVar = tVar.f10293b) == null) ? null : hVar.f10392h;
            this.f10036d = obj2;
            this.f10037e = j11;
            this.f10038f = j12;
            this.f10039g = j13;
            this.f10040h = z10;
            this.f10041i = z11;
            this.f10042j = gVar;
            this.f10044l = j14;
            this.f10045m = j15;
            this.f10046n = i11;
            this.f10047o = i12;
            this.f10048p = j16;
            this.f10043k = false;
            return this;
        }

        public int hashCode() {
            int hashCode = (((Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.f10033a.hashCode()) * 31) + this.f10035c.hashCode()) * 31;
            Object obj = this.f10036d;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            t.g gVar = this.f10042j;
            int hashCode3 = (hashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j11 = this.f10037e;
            int i11 = (hashCode3 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f10038f;
            int i12 = (i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f10039g;
            int i13 = (((((((i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31) + (this.f10040h ? 1 : 0)) * 31) + (this.f10041i ? 1 : 0)) * 31) + (this.f10043k ? 1 : 0)) * 31;
            long j14 = this.f10044l;
            int i14 = (i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
            long j15 = this.f10045m;
            int i15 = (((((i14 + ((int) (j15 ^ (j15 >>> 32)))) * 31) + this.f10046n) * 31) + this.f10047o) * 31;
            long j16 = this.f10048p;
            return i15 + ((int) (j16 ^ (j16 >>> 32)));
        }
    }

    public int a(boolean z10) {
        return q() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z10) {
        if (q()) {
            return -1;
        }
        return p() - 1;
    }

    public final int d(int i11, b bVar, c cVar, int i12, boolean z10) {
        int i13 = f(i11, bVar).f10018c;
        if (n(i13, cVar).f10047o != i11) {
            return i11 + 1;
        }
        int e11 = e(i13, i12, z10);
        if (e11 == -1) {
            return -1;
        }
        return n(e11, cVar).f10046n;
    }

    public int e(int i11, int i12, boolean z10) {
        if (i12 == 0) {
            if (i11 == c(z10)) {
                return -1;
            }
            return i11 + 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == c(z10) ? a(z10) : i11 + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        int c11;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (e0Var.p() != p() || e0Var.i() != i()) {
            return false;
        }
        c cVar = new c();
        b bVar = new b();
        c cVar2 = new c();
        b bVar2 = new b();
        for (int i11 = 0; i11 < p(); i11++) {
            if (!n(i11, cVar).equals(e0Var.n(i11, cVar2))) {
                return false;
            }
        }
        for (int i12 = 0; i12 < i(); i12++) {
            if (!g(i12, bVar, true).equals(e0Var.g(i12, bVar2, true))) {
                return false;
            }
        }
        int a11 = a(true);
        if (a11 != e0Var.a(true) || (c11 = c(true)) != e0Var.c(true)) {
            return false;
        }
        while (a11 != c11) {
            int e11 = e(a11, 0, true);
            if (e11 != e0Var.e(a11, 0, true)) {
                return false;
            }
            a11 = e11;
        }
        return true;
    }

    public final b f(int i11, b bVar) {
        return g(i11, bVar, false);
    }

    public abstract b g(int i11, b bVar, boolean z10);

    public b h(Object obj, b bVar) {
        return g(b(obj), bVar, true);
    }

    public int hashCode() {
        c cVar = new c();
        b bVar = new b();
        int p11 = Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + p();
        for (int i11 = 0; i11 < p(); i11++) {
            p11 = (p11 * 31) + n(i11, cVar).hashCode();
        }
        int i12 = (p11 * 31) + i();
        for (int i13 = 0; i13 < i(); i13++) {
            i12 = (i12 * 31) + g(i13, bVar, true).hashCode();
        }
        int a11 = a(true);
        while (a11 != -1) {
            i12 = (i12 * 31) + a11;
            a11 = e(a11, 0, true);
        }
        return i12;
    }

    public abstract int i();

    public final Pair j(c cVar, b bVar, int i11, long j11) {
        return (Pair) androidx.media3.common.util.a.e(k(cVar, bVar, i11, j11, 0L));
    }

    public final Pair k(c cVar, b bVar, int i11, long j11, long j12) {
        androidx.media3.common.util.a.c(i11, 0, p());
        o(i11, cVar, j12);
        if (j11 == C.TIME_UNSET) {
            j11 = cVar.c();
            if (j11 == C.TIME_UNSET) {
                return null;
            }
        }
        int i12 = cVar.f10046n;
        f(i12, bVar);
        while (i12 < cVar.f10047o && bVar.f10020e != j11) {
            int i13 = i12 + 1;
            if (f(i13, bVar).f10020e > j11) {
                break;
            }
            i12 = i13;
        }
        g(i12, bVar, true);
        long j13 = j11 - bVar.f10020e;
        long j14 = bVar.f10019d;
        if (j14 != C.TIME_UNSET) {
            j13 = Math.min(j13, j14 - 1);
        }
        return Pair.create(androidx.media3.common.util.a.e(bVar.f10017b), Long.valueOf(Math.max(0L, j13)));
    }

    public int l(int i11, int i12, boolean z10) {
        if (i12 == 0) {
            if (i11 == a(z10)) {
                return -1;
            }
            return i11 - 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == a(z10) ? c(z10) : i11 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object m(int i11);

    public final c n(int i11, c cVar) {
        return o(i11, cVar, 0L);
    }

    public abstract c o(int i11, c cVar, long j11);

    public abstract int p();

    public final boolean q() {
        return p() == 0;
    }

    public final boolean r(int i11, b bVar, c cVar, int i12, boolean z10) {
        return d(i11, bVar, cVar, i12, z10) == -1;
    }
}
