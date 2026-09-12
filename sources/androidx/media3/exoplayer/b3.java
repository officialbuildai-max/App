package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.e0;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.y2;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b3 {

    /* renamed from: c, reason: collision with root package name */
    private final y1.a f11402c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.common.util.p f11403d;

    /* renamed from: e, reason: collision with root package name */
    private final y2.a f11404e;

    /* renamed from: f, reason: collision with root package name */
    private long f11405f;

    /* renamed from: g, reason: collision with root package name */
    private int f11406g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f11407h;

    /* renamed from: i, reason: collision with root package name */
    private ExoPlayer.c f11408i;

    /* renamed from: j, reason: collision with root package name */
    private y2 f11409j;

    /* renamed from: k, reason: collision with root package name */
    private y2 f11410k;

    /* renamed from: l, reason: collision with root package name */
    private y2 f11411l;

    /* renamed from: m, reason: collision with root package name */
    private y2 f11412m;

    /* renamed from: n, reason: collision with root package name */
    private y2 f11413n;

    /* renamed from: o, reason: collision with root package name */
    private int f11414o;

    /* renamed from: p, reason: collision with root package name */
    private Object f11415p;

    /* renamed from: q, reason: collision with root package name */
    private long f11416q;

    /* renamed from: a, reason: collision with root package name */
    private final e0.b f11400a = new e0.b();

    /* renamed from: b, reason: collision with root package name */
    private final e0.c f11401b = new e0.c();

    /* renamed from: r, reason: collision with root package name */
    private List f11417r = new ArrayList();

    public b3(y1.a aVar, androidx.media3.common.util.p pVar, y2.a aVar2, ExoPlayer.c cVar) {
        this.f11402c = aVar;
        this.f11403d = pVar;
        this.f11404e = aVar2;
        this.f11408i = cVar;
    }

    private boolean A(Object obj, androidx.media3.common.e0 e0Var) {
        int c11 = e0Var.h(obj, this.f11400a).c();
        int p11 = this.f11400a.p();
        return c11 > 0 && this.f11400a.s(p11) && (c11 > 1 || this.f11400a.f(p11) != Long.MIN_VALUE);
    }

    private boolean C(r.b bVar) {
        return !bVar.b() && bVar.f12969e == -1;
    }

    private boolean D(androidx.media3.common.e0 e0Var, r.b bVar, boolean z10) {
        int b11 = e0Var.b(bVar.f12965a);
        return !e0Var.n(e0Var.f(b11, this.f11400a).f10018c, this.f11401b).f10041i && e0Var.r(b11, this.f11400a, this.f11401b, this.f11406g, this.f11407h) && z10;
    }

    private boolean E(androidx.media3.common.e0 e0Var, r.b bVar) {
        if (C(bVar)) {
            return e0Var.n(e0Var.h(bVar.f12965a, this.f11400a).f10018c, this.f11401b).f10047o == e0Var.b(bVar.f12965a);
        }
        return false;
    }

    private static boolean H(e0.b bVar) {
        int c11 = bVar.c();
        if (c11 == 0) {
            return false;
        }
        if ((c11 == 1 && bVar.r(0)) || !bVar.s(bVar.p())) {
            return false;
        }
        long j11 = 0;
        if (bVar.e(0L) != -1) {
            return false;
        }
        if (bVar.f10019d == 0) {
            return true;
        }
        int i11 = c11 - (bVar.r(c11 + (-1)) ? 2 : 1);
        for (int i12 = 0; i12 <= i11; i12++) {
            j11 += bVar.i(i12);
        }
        return bVar.f10019d <= j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ImmutableList.a aVar, r.b bVar) {
        this.f11402c.p(aVar.e(), bVar);
    }

    private void K() {
        final ImmutableList.a builder = ImmutableList.builder();
        for (y2 y2Var = this.f11409j; y2Var != null; y2Var = y2Var.k()) {
            builder.a(y2Var.f13457h.f13470a);
        }
        y2 y2Var2 = this.f11410k;
        final r.b bVar = y2Var2 == null ? null : y2Var2.f13457h.f13470a;
        this.f11403d.post(new Runnable() { // from class: androidx.media3.exoplayer.a3
            @Override // java.lang.Runnable
            public final void run() {
                b3.this.I(builder, bVar);
            }
        });
    }

    private void M(List list) {
        for (int i11 = 0; i11 < this.f11417r.size(); i11++) {
            ((y2) this.f11417r.get(i11)).x();
        }
        this.f11417r = list;
        this.f11413n = null;
        J();
    }

    private y2 P(z2 z2Var) {
        for (int i11 = 0; i11 < this.f11417r.size(); i11++) {
            if (((y2) this.f11417r.get(i11)).d(z2Var)) {
                return (y2) this.f11417r.remove(i11);
            }
        }
        return null;
    }

    private static r.b Q(androidx.media3.common.e0 e0Var, Object obj, long j11, long j12, e0.c cVar, e0.b bVar) {
        e0Var.h(obj, bVar);
        e0Var.n(bVar.f10018c, cVar);
        Object obj2 = obj;
        for (int b11 = e0Var.b(obj); H(bVar) && b11 <= cVar.f10047o; b11++) {
            e0Var.g(b11, bVar, true);
            obj2 = androidx.media3.common.util.a.e(bVar.f10017b);
        }
        e0Var.h(obj2, bVar);
        int e11 = bVar.e(j11);
        return e11 == -1 ? new r.b(obj2, j12, bVar.d(j11)) : new r.b(obj2, e11, bVar.l(e11), j12);
    }

    private long S(androidx.media3.common.e0 e0Var, Object obj) {
        int b11;
        int i11 = e0Var.h(obj, this.f11400a).f10018c;
        Object obj2 = this.f11415p;
        if (obj2 != null && (b11 = e0Var.b(obj2)) != -1 && e0Var.f(b11, this.f11400a).f10018c == i11) {
            return this.f11416q;
        }
        for (y2 y2Var = this.f11409j; y2Var != null; y2Var = y2Var.k()) {
            if (y2Var.f13451b.equals(obj)) {
                return y2Var.f13457h.f13470a.f12968d;
            }
        }
        for (y2 y2Var2 = this.f11409j; y2Var2 != null; y2Var2 = y2Var2.k()) {
            int b12 = e0Var.b(y2Var2.f13451b);
            if (b12 != -1 && e0Var.f(b12, this.f11400a).f10018c == i11) {
                return y2Var2.f13457h.f13470a.f12968d;
            }
        }
        long T = T(obj);
        if (T != -1) {
            return T;
        }
        long j11 = this.f11405f;
        this.f11405f = 1 + j11;
        if (this.f11409j == null) {
            this.f11415p = obj;
            this.f11416q = j11;
        }
        return j11;
    }

    private long T(Object obj) {
        for (int i11 = 0; i11 < this.f11417r.size(); i11++) {
            y2 y2Var = (y2) this.f11417r.get(i11);
            if (y2Var.f13451b.equals(obj)) {
                return y2Var.f13457h.f13470a.f12968d;
            }
        }
        return -1L;
    }

    private int V(androidx.media3.common.e0 e0Var) {
        y2 y2Var = this.f11409j;
        if (y2Var == null) {
            return 0;
        }
        int b11 = e0Var.b(y2Var.f13451b);
        while (true) {
            b11 = e0Var.d(b11, this.f11400a, this.f11401b, this.f11406g, this.f11407h);
            while (((y2) androidx.media3.common.util.a.e(y2Var)).k() != null && !y2Var.f13457h.f13477h) {
                y2Var = y2Var.k();
            }
            y2 k11 = y2Var.k();
            if (b11 == -1 || k11 == null || e0Var.b(k11.f13451b) != b11) {
                break;
            }
            y2Var = k11;
        }
        int O = O(y2Var);
        y2Var.f13457h = z(e0Var, y2Var.f13457h);
        return O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(long j11, long j12) {
        return j11 == C.TIME_UNSET || j11 == j12;
    }

    private boolean f(z2 z2Var, z2 z2Var2) {
        return z2Var.f13471b == z2Var2.f13471b && z2Var.f13470a.equals(z2Var2.f13470a);
    }

    private Pair i(androidx.media3.common.e0 e0Var, Object obj, long j11) {
        int e11 = e0Var.e(e0Var.h(obj, this.f11400a).f10018c, this.f11406g, this.f11407h);
        if (e11 != -1) {
            return e0Var.k(this.f11401b, this.f11400a, e11, C.TIME_UNSET, j11);
        }
        return null;
    }

    private z2 j(r3 r3Var) {
        return o(r3Var.f12625a, r3Var.f12626b, r3Var.f12627c, r3Var.f12643s);
    }

    private z2 k(androidx.media3.common.e0 e0Var, y2 y2Var, long j11) {
        z2 z2Var;
        long j12;
        long j13;
        Object obj;
        long j14;
        long j15;
        long T;
        z2 z2Var2 = y2Var.f13457h;
        int d11 = e0Var.d(e0Var.b(z2Var2.f13470a.f12965a), this.f11400a, this.f11401b, this.f11406g, this.f11407h);
        if (d11 == -1) {
            return null;
        }
        int i11 = e0Var.g(d11, this.f11400a, true).f10018c;
        Object e11 = androidx.media3.common.util.a.e(this.f11400a.f10017b);
        long j16 = z2Var2.f13470a.f12968d;
        if (e0Var.n(i11, this.f11401b).f10046n == d11) {
            z2Var = z2Var2;
            Pair k11 = e0Var.k(this.f11401b, this.f11400a, i11, C.TIME_UNSET, Math.max(0L, j11));
            if (k11 == null) {
                return null;
            }
            Object obj2 = k11.first;
            long longValue = ((Long) k11.second).longValue();
            y2 k12 = y2Var.k();
            if (k12 == null || !k12.f13451b.equals(obj2)) {
                T = T(obj2);
                if (T == -1) {
                    T = this.f11405f;
                    this.f11405f = 1 + T;
                }
            } else {
                T = k12.f13457h.f13470a.f12968d;
            }
            j12 = T;
            j13 = -9223372036854775807L;
            obj = obj2;
            j14 = longValue;
        } else {
            z2Var = z2Var2;
            j12 = j16;
            j13 = 0;
            obj = e11;
            j14 = 0;
        }
        r.b Q = Q(e0Var, obj, j14, j12, this.f11401b, this.f11400a);
        if (j13 != C.TIME_UNSET && z2Var.f13472c != C.TIME_UNSET) {
            boolean A = A(z2Var.f13470a.f12965a, e0Var);
            if (Q.b() && A) {
                j13 = z2Var.f13472c;
            } else if (A) {
                j15 = z2Var.f13472c;
                return o(e0Var, Q, j13, j15);
            }
        }
        j15 = j14;
        return o(e0Var, Q, j13, j15);
    }

    private z2 l(androidx.media3.common.e0 e0Var, y2 y2Var, long j11) {
        z2 z2Var = y2Var.f13457h;
        long m11 = (y2Var.m() + z2Var.f13474e) - j11;
        return z2Var.f13477h ? k(e0Var, y2Var, m11) : m(e0Var, y2Var, m11);
    }

    private z2 m(androidx.media3.common.e0 e0Var, y2 y2Var, long j11) {
        z2 z2Var = y2Var.f13457h;
        r.b bVar = z2Var.f13470a;
        e0Var.h(bVar.f12965a, this.f11400a);
        boolean z10 = z2Var.f13476g;
        if (!bVar.b()) {
            int i11 = bVar.f12969e;
            if (i11 != -1 && this.f11400a.r(i11)) {
                return k(e0Var, y2Var, j11);
            }
            int l11 = this.f11400a.l(bVar.f12969e);
            boolean z11 = this.f11400a.s(bVar.f12969e) && this.f11400a.h(bVar.f12969e, l11) == 3;
            if (l11 == this.f11400a.a(bVar.f12969e) || z11) {
                return q(e0Var, bVar.f12965a, s(e0Var, bVar.f12965a, bVar.f12969e), z2Var.f13474e, bVar.f12968d, false);
            }
            return p(e0Var, bVar.f12965a, bVar.f12969e, l11, z2Var.f13474e, bVar.f12968d, z10);
        }
        int i12 = bVar.f12966b;
        int a11 = this.f11400a.a(i12);
        if (a11 == -1) {
            return null;
        }
        int m11 = this.f11400a.m(i12, bVar.f12967c);
        if (m11 < a11) {
            return p(e0Var, bVar.f12965a, i12, m11, z2Var.f13472c, bVar.f12968d, z10);
        }
        long j12 = z2Var.f13472c;
        if (j12 == C.TIME_UNSET) {
            e0.c cVar = this.f11401b;
            e0.b bVar2 = this.f11400a;
            Pair k11 = e0Var.k(cVar, bVar2, bVar2.f10018c, C.TIME_UNSET, Math.max(0L, j11));
            if (k11 == null) {
                return null;
            }
            j12 = ((Long) k11.second).longValue();
        }
        return q(e0Var, bVar.f12965a, Math.max(s(e0Var, bVar.f12965a, bVar.f12966b), j12), z2Var.f13472c, bVar.f12968d, z10);
    }

    private z2 o(androidx.media3.common.e0 e0Var, r.b bVar, long j11, long j12) {
        e0Var.h(bVar.f12965a, this.f11400a);
        return bVar.b() ? p(e0Var, bVar.f12965a, bVar.f12966b, bVar.f12967c, j11, bVar.f12968d, false) : q(e0Var, bVar.f12965a, j12, j11, bVar.f12968d, false);
    }

    private z2 p(androidx.media3.common.e0 e0Var, Object obj, int i11, int i12, long j11, long j12, boolean z10) {
        r.b bVar = new r.b(obj, i11, i12, j12);
        long b11 = e0Var.h(bVar.f12965a, this.f11400a).b(bVar.f12966b, bVar.f12967c);
        long g11 = i12 == this.f11400a.l(i11) ? this.f11400a.g() : 0L;
        return new z2(bVar, (b11 == C.TIME_UNSET || g11 < b11) ? g11 : Math.max(0L, b11 - 1), j11, C.TIME_UNSET, b11, z10, this.f11400a.s(bVar.f12966b), false, false, false);
    }

    private z2 q(androidx.media3.common.e0 e0Var, Object obj, long j11, long j12, long j13, boolean z10) {
        boolean z11;
        long j14;
        long j15;
        long j16;
        long j17 = j11;
        e0Var.h(obj, this.f11400a);
        int d11 = this.f11400a.d(j17);
        boolean z12 = d11 != -1 && this.f11400a.r(d11);
        if (d11 == -1) {
            if (this.f11400a.c() > 0) {
                e0.b bVar = this.f11400a;
                if (bVar.s(bVar.p())) {
                    z11 = true;
                }
            }
            z11 = false;
        } else {
            if (this.f11400a.s(d11)) {
                long f11 = this.f11400a.f(d11);
                e0.b bVar2 = this.f11400a;
                if (f11 == bVar2.f10019d && bVar2.q(d11)) {
                    z11 = true;
                    d11 = -1;
                }
            }
            z11 = false;
        }
        r.b bVar3 = new r.b(obj, j13, d11);
        boolean C = C(bVar3);
        boolean E = E(e0Var, bVar3);
        boolean D = D(e0Var, bVar3, C);
        boolean z13 = (d11 == -1 || !this.f11400a.s(d11) || z12) ? false : true;
        if (d11 != -1 && !z12) {
            j15 = this.f11400a.f(d11);
        } else {
            if (!z11) {
                j14 = -9223372036854775807L;
                j16 = (j14 != C.TIME_UNSET || j14 == Long.MIN_VALUE) ? this.f11400a.f10019d : j14;
                if (j16 != C.TIME_UNSET && j17 >= j16) {
                    j17 = Math.max(0L, j16 - ((D && z11) ? 0 : 1));
                }
                return new z2(bVar3, j17, j12, j14, j16, z10, z13, C, E, D);
            }
            j15 = this.f11400a.f10019d;
        }
        j14 = j15;
        if (j14 != C.TIME_UNSET) {
        }
        if (j16 != C.TIME_UNSET) {
            j17 = Math.max(0L, j16 - ((D && z11) ? 0 : 1));
        }
        return new z2(bVar3, j17, j12, j14, j16, z10, z13, C, E, D);
    }

    private z2 r(androidx.media3.common.e0 e0Var, Object obj, long j11, long j12) {
        r.b Q = Q(e0Var, obj, j11, j12, this.f11401b, this.f11400a);
        return Q.b() ? p(e0Var, Q.f12965a, Q.f12966b, Q.f12967c, j11, Q.f12968d, false) : q(e0Var, Q.f12965a, j11, C.TIME_UNSET, Q.f12968d, false);
    }

    private long s(androidx.media3.common.e0 e0Var, Object obj, int i11) {
        e0Var.h(obj, this.f11400a);
        long f11 = this.f11400a.f(i11);
        return f11 == Long.MIN_VALUE ? this.f11400a.f10019d : f11 + this.f11400a.i(i11);
    }

    public void B(androidx.media3.common.e0 e0Var) {
        y2 y2Var;
        if (this.f11408i.f11068a == C.TIME_UNSET || (y2Var = this.f11412m) == null) {
            N();
            return;
        }
        ArrayList arrayList = new ArrayList();
        Pair i11 = i(e0Var, y2Var.f13457h.f13470a.f12965a, 0L);
        if (i11 != null && !e0Var.n(e0Var.h(i11.first, this.f11400a).f10018c, this.f11401b).f()) {
            long T = T(i11.first);
            if (T == -1) {
                T = this.f11405f;
                this.f11405f = 1 + T;
            }
            z2 r11 = r(e0Var, i11.first, ((Long) i11.second).longValue(), T);
            y2 P = P(r11);
            if (P == null) {
                P = this.f11404e.a(r11, (y2Var.m() + y2Var.f13457h.f13474e) - r11.f13471b);
            }
            arrayList.add(P);
        }
        M(arrayList);
    }

    public boolean F(androidx.media3.exoplayer.source.q qVar) {
        y2 y2Var = this.f11412m;
        return y2Var != null && y2Var.f13450a == qVar;
    }

    public boolean G(androidx.media3.exoplayer.source.q qVar) {
        y2 y2Var = this.f11413n;
        return y2Var != null && y2Var.f13450a == qVar;
    }

    public void J() {
        y2 y2Var = this.f11413n;
        if (y2Var == null || y2Var.t()) {
            this.f11413n = null;
            for (int i11 = 0; i11 < this.f11417r.size(); i11++) {
                y2 y2Var2 = (y2) this.f11417r.get(i11);
                if (!y2Var2.t()) {
                    this.f11413n = y2Var2;
                    return;
                }
            }
        }
    }

    public void L(long j11) {
        y2 y2Var = this.f11412m;
        if (y2Var != null) {
            y2Var.w(j11);
        }
    }

    public void N() {
        if (this.f11417r.isEmpty()) {
            return;
        }
        M(new ArrayList());
    }

    public int O(y2 y2Var) {
        androidx.media3.common.util.a.i(y2Var);
        int i11 = 0;
        if (y2Var.equals(this.f11412m)) {
            return 0;
        }
        this.f11412m = y2Var;
        while (y2Var.k() != null) {
            y2Var = (y2) androidx.media3.common.util.a.e(y2Var.k());
            if (y2Var == this.f11410k) {
                y2 y2Var2 = this.f11409j;
                this.f11410k = y2Var2;
                this.f11411l = y2Var2;
                i11 = 3;
            }
            if (y2Var == this.f11411l) {
                this.f11411l = this.f11410k;
                i11 |= 2;
            }
            y2Var.x();
            this.f11414o--;
        }
        ((y2) androidx.media3.common.util.a.e(this.f11412m)).A(null);
        K();
        return i11;
    }

    public r.b R(androidx.media3.common.e0 e0Var, Object obj, long j11) {
        long S = S(e0Var, obj);
        e0Var.h(obj, this.f11400a);
        e0Var.n(this.f11400a.f10018c, this.f11401b);
        boolean z10 = false;
        for (int b11 = e0Var.b(obj); b11 >= this.f11401b.f10046n; b11--) {
            e0Var.g(b11, this.f11400a, true);
            boolean z11 = this.f11400a.c() > 0;
            z10 |= z11;
            e0.b bVar = this.f11400a;
            if (bVar.e(bVar.f10019d) != -1) {
                obj = androidx.media3.common.util.a.e(this.f11400a.f10017b);
            }
            if (z10 && (!z11 || this.f11400a.f10019d != 0)) {
                break;
            }
        }
        return Q(e0Var, obj, j11, S, this.f11401b, this.f11400a);
    }

    public boolean U() {
        y2 y2Var = this.f11412m;
        return y2Var == null || (!y2Var.f13457h.f13479j && y2Var.s() && this.f11412m.f13457h.f13474e != C.TIME_UNSET && this.f11414o < 100);
    }

    public void W(androidx.media3.common.e0 e0Var, ExoPlayer.c cVar) {
        this.f11408i = cVar;
        B(e0Var);
    }

    public int X(androidx.media3.common.e0 e0Var, long j11, long j12, long j13) {
        z2 z2Var;
        y2 y2Var = this.f11409j;
        y2 y2Var2 = null;
        while (true) {
            boolean z10 = false;
            if (y2Var == null) {
                return 0;
            }
            z2 z2Var2 = y2Var.f13457h;
            if (y2Var2 == null) {
                z2Var = z(e0Var, z2Var2);
            } else {
                z2 l11 = l(e0Var, y2Var2, j11);
                if (l11 == null || !f(z2Var2, l11)) {
                    break;
                }
                z2Var = l11;
            }
            y2Var.f13457h = z2Var.a(z2Var2.f13472c);
            if (!e(z2Var2.f13474e, z2Var.f13474e)) {
                y2Var.E();
                long j14 = z2Var.f13474e;
                long D = j14 == C.TIME_UNSET ? Long.MAX_VALUE : y2Var.D(j14);
                int i11 = (y2Var != this.f11410k || y2Var.f13457h.f13476g || (j12 != Long.MIN_VALUE && j12 < D)) ? 0 : 1;
                if (y2Var == this.f11411l && (j13 == Long.MIN_VALUE || j13 >= D)) {
                    z10 = true;
                }
                int O = O(y2Var);
                return O != 0 ? O : z10 ? i11 | 2 : i11;
            }
            y2Var2 = y2Var;
            y2Var = y2Var.k();
        }
        return O(y2Var2);
    }

    public int Y(androidx.media3.common.e0 e0Var, int i11) {
        this.f11406g = i11;
        return V(e0Var);
    }

    public int Z(androidx.media3.common.e0 e0Var, boolean z10) {
        this.f11407h = z10;
        return V(e0Var);
    }

    public y2 b() {
        y2 y2Var = this.f11409j;
        if (y2Var == null) {
            return null;
        }
        if (y2Var == this.f11410k) {
            this.f11410k = y2Var.k();
        }
        y2 y2Var2 = this.f11409j;
        if (y2Var2 == this.f11411l) {
            this.f11411l = y2Var2.k();
        }
        this.f11409j.x();
        int i11 = this.f11414o - 1;
        this.f11414o = i11;
        if (i11 == 0) {
            this.f11412m = null;
            y2 y2Var3 = this.f11409j;
            this.f11415p = y2Var3.f13451b;
            this.f11416q = y2Var3.f13457h.f13470a.f12968d;
        }
        this.f11409j = this.f11409j.k();
        K();
        return this.f11409j;
    }

    public y2 c() {
        this.f11411l = ((y2) androidx.media3.common.util.a.i(this.f11411l)).k();
        K();
        return (y2) androidx.media3.common.util.a.i(this.f11411l);
    }

    public y2 d() {
        y2 y2Var = this.f11411l;
        y2 y2Var2 = this.f11410k;
        if (y2Var == y2Var2) {
            this.f11411l = ((y2) androidx.media3.common.util.a.i(y2Var2)).k();
        }
        this.f11410k = ((y2) androidx.media3.common.util.a.i(this.f11410k)).k();
        K();
        return (y2) androidx.media3.common.util.a.i(this.f11410k);
    }

    public void g() {
        if (this.f11414o == 0) {
            return;
        }
        y2 y2Var = (y2) androidx.media3.common.util.a.i(this.f11409j);
        this.f11415p = y2Var.f13451b;
        this.f11416q = y2Var.f13457h.f13470a.f12968d;
        while (y2Var != null) {
            y2Var.x();
            y2Var = y2Var.k();
        }
        this.f11409j = null;
        this.f11412m = null;
        this.f11410k = null;
        this.f11411l = null;
        this.f11414o = 0;
        K();
    }

    public y2 h(z2 z2Var) {
        y2 y2Var = this.f11412m;
        long m11 = y2Var == null ? 1000000000000L : (y2Var.m() + this.f11412m.f13457h.f13474e) - z2Var.f13471b;
        y2 P = P(z2Var);
        if (P == null) {
            P = this.f11404e.a(z2Var, m11);
        } else {
            P.f13457h = z2Var;
            P.B(m11);
        }
        y2 y2Var2 = this.f11412m;
        if (y2Var2 != null) {
            y2Var2.A(P);
        } else {
            this.f11409j = P;
            this.f11410k = P;
            this.f11411l = P;
        }
        this.f11415p = null;
        this.f11412m = P;
        this.f11414o++;
        K();
        return P;
    }

    public y2 n() {
        return this.f11412m;
    }

    public z2 t(long j11, r3 r3Var) {
        y2 y2Var = this.f11412m;
        return y2Var == null ? j(r3Var) : l(r3Var.f12625a, y2Var, j11);
    }

    public y2 u() {
        return this.f11409j;
    }

    public y2 v(androidx.media3.exoplayer.source.q qVar) {
        for (int i11 = 0; i11 < this.f11417r.size(); i11++) {
            y2 y2Var = (y2) this.f11417r.get(i11);
            if (y2Var.f13450a == qVar) {
                return y2Var;
            }
        }
        return null;
    }

    public y2 w() {
        return this.f11413n;
    }

    public y2 x() {
        return this.f11411l;
    }

    public y2 y() {
        return this.f11410k;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.media3.exoplayer.z2 z(androidx.media3.common.e0 r20, androidx.media3.exoplayer.z2 r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            androidx.media3.exoplayer.source.r$b r3 = r2.f13470a
            boolean r13 = r0.C(r3)
            boolean r14 = r0.E(r1, r3)
            boolean r15 = r0.D(r1, r3, r13)
            androidx.media3.exoplayer.source.r$b r4 = r2.f13470a
            java.lang.Object r4 = r4.f12965a
            androidx.media3.common.e0$b r5 = r0.f11400a
            r1.h(r4, r5)
            boolean r1 = r3.b()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = -1
            if (r1 != 0) goto L35
            int r1 = r3.f12969e
            if (r1 != r6) goto L2e
            goto L35
        L2e:
            androidx.media3.common.e0$b r7 = r0.f11400a
            long r7 = r7.f(r1)
            goto L36
        L35:
            r7 = r4
        L36:
            boolean r1 = r3.b()
            if (r1 == 0) goto L48
            androidx.media3.common.e0$b r1 = r0.f11400a
            int r4 = r3.f12966b
            int r5 = r3.f12967c
            long r4 = r1.b(r4, r5)
        L46:
            r9 = r4
            goto L5c
        L48:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 == 0) goto L55
            r4 = -9223372036854775808
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 != 0) goto L53
            goto L55
        L53:
            r9 = r7
            goto L5c
        L55:
            androidx.media3.common.e0$b r1 = r0.f11400a
            long r4 = r1.k()
            goto L46
        L5c:
            boolean r1 = r3.b()
            if (r1 == 0) goto L6c
            androidx.media3.common.e0$b r1 = r0.f11400a
            int r4 = r3.f12966b
            boolean r1 = r1.s(r4)
        L6a:
            r12 = r1
            goto L7c
        L6c:
            int r1 = r3.f12969e
            if (r1 == r6) goto L7a
            androidx.media3.common.e0$b r4 = r0.f11400a
            boolean r1 = r4.s(r1)
            if (r1 == 0) goto L7a
            r1 = 1
            goto L6a
        L7a:
            r1 = 0
            goto L6a
        L7c:
            androidx.media3.exoplayer.z2 r16 = new androidx.media3.exoplayer.z2
            long r4 = r2.f13471b
            r17 = r14
            r18 = r15
            long r14 = r2.f13472c
            boolean r11 = r2.f13475f
            r1 = r16
            r2 = r3
            r3 = r4
            r5 = r14
            r14 = r17
            r15 = r18
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14, r15)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.b3.z(androidx.media3.common.e0, androidx.media3.exoplayer.z2):androidx.media3.exoplayer.z2");
    }
}
