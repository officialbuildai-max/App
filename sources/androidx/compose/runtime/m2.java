package androidx.compose.runtime;

import androidx.compose.runtime.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class m2 {

    /* renamed from: y, reason: collision with root package name */
    public static final a f3881y = new a(null);

    /* renamed from: z, reason: collision with root package name */
    public static final int f3882z = 8;

    /* renamed from: a, reason: collision with root package name */
    private final j2 f3883a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f3884b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f3885c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList f3886d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap f3887e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.collection.e0 f3888f;

    /* renamed from: g, reason: collision with root package name */
    private int f3889g;

    /* renamed from: h, reason: collision with root package name */
    private int f3890h;

    /* renamed from: i, reason: collision with root package name */
    private int f3891i;

    /* renamed from: j, reason: collision with root package name */
    private int f3892j;

    /* renamed from: k, reason: collision with root package name */
    private int f3893k;

    /* renamed from: l, reason: collision with root package name */
    private int f3894l;

    /* renamed from: m, reason: collision with root package name */
    private int f3895m;

    /* renamed from: n, reason: collision with root package name */
    private int f3896n;

    /* renamed from: o, reason: collision with root package name */
    private int f3897o;

    /* renamed from: s, reason: collision with root package name */
    private androidx.collection.e0 f3901s;

    /* renamed from: t, reason: collision with root package name */
    private int f3902t;

    /* renamed from: u, reason: collision with root package name */
    private int f3903u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3905w;

    /* renamed from: x, reason: collision with root package name */
    private r1 f3906x;

    /* renamed from: p, reason: collision with root package name */
    private final m0 f3898p = new m0();

    /* renamed from: q, reason: collision with root package name */
    private final m0 f3899q = new m0();

    /* renamed from: r, reason: collision with root package name */
    private final m0 f3900r = new m0();

    /* renamed from: v, reason: collision with root package name */
    private int f3904v = -1;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List b(m2 m2Var, int i11, m2 m2Var2, boolean z10, boolean z11, boolean z12) {
            boolean z13;
            List list;
            int i12;
            int k02 = m2Var.k0(i11);
            int i13 = i11 + k02;
            int P = m2Var.P(i11);
            int P2 = m2Var.P(i13);
            int i14 = P2 - P;
            boolean M = m2Var.M(i11);
            m2Var2.o0(k02);
            m2Var2.p0(i14, m2Var2.a0());
            if (m2Var.f3889g < i13) {
                m2Var.x0(i13);
            }
            if (m2Var.f3893k < P2) {
                m2Var.z0(P2, i13);
            }
            int[] iArr = m2Var2.f3884b;
            int a02 = m2Var2.a0();
            ArraysKt.l(m2Var.f3884b, iArr, a02 * 5, i11 * 5, i13 * 5);
            Object[] objArr = m2Var2.f3885c;
            int i15 = m2Var2.f3891i;
            ArraysKt.n(m2Var.f3885c, objArr, i15, P, P2);
            int c02 = m2Var2.c0();
            l2.A(iArr, a02, c02);
            int i16 = a02 - i11;
            int i17 = a02 + k02;
            int Q = i15 - m2Var2.Q(iArr, a02);
            int i18 = m2Var2.f3895m;
            int i19 = m2Var2.f3894l;
            int length = objArr.length;
            int i20 = i18;
            int i21 = a02;
            while (true) {
                z13 = false;
                if (i21 >= i17) {
                    break;
                }
                if (i21 != a02) {
                    i12 = i17;
                    l2.A(iArr, i21, l2.s(iArr, i21) + i16);
                } else {
                    i12 = i17;
                }
                int i22 = Q;
                l2.w(iArr, i21, m2Var2.S(m2Var2.Q(iArr, i21) + Q, i20 >= i21 ? m2Var2.f3893k : 0, i19, length));
                if (i21 == i20) {
                    i20++;
                }
                i21++;
                Q = i22;
                i17 = i12;
            }
            int i23 = i17;
            m2Var2.f3895m = i20;
            int o11 = l2.o(m2Var.f3886d, i11, m2Var.d0());
            int o12 = l2.o(m2Var.f3886d, i13, m2Var.d0());
            if (o11 < o12) {
                ArrayList arrayList = m2Var.f3886d;
                ArrayList arrayList2 = new ArrayList(o12 - o11);
                for (int i24 = o11; i24 < o12; i24++) {
                    c cVar = (c) arrayList.get(i24);
                    cVar.c(cVar.a() + i16);
                    arrayList2.add(cVar);
                }
                m2Var2.f3886d.addAll(l2.o(m2Var2.f3886d, m2Var2.a0(), m2Var2.d0()), arrayList2);
                arrayList.subList(o11, o12).clear();
                list = arrayList2;
            } else {
                list = CollectionsKt.l();
            }
            if (!list.isEmpty()) {
                HashMap hashMap = m2Var.f3887e;
                HashMap hashMap2 = m2Var2.f3887e;
                if (hashMap != null && hashMap2 != null) {
                    int size = list.size();
                    for (int i25 = 0; i25 < size; i25++) {
                    }
                }
            }
            m2Var2.c0();
            m2Var2.e1(c02);
            int E0 = m2Var.E0(i11);
            if (z12) {
                if (z10) {
                    boolean z14 = E0 >= 0;
                    if (z14) {
                        m2Var.g1();
                        m2Var.D(E0 - m2Var.a0());
                        m2Var.g1();
                    }
                    m2Var.D(i11 - m2Var.a0());
                    boolean L0 = m2Var.L0();
                    if (z14) {
                        m2Var.W0();
                        m2Var.T();
                        m2Var.W0();
                        m2Var.T();
                    }
                    z13 = L0;
                } else {
                    z13 = m2Var.M0(i11, k02);
                    m2Var.N0(P, i14, i11 - 1);
                }
            }
            if (z13) {
                k.r("Unexpectedly removed anchors");
            }
            m2Var2.f3897o += l2.m(iArr, a02) ? 1 : l2.p(iArr, a02);
            if (z11) {
                m2Var2.f3902t = i23;
                m2Var2.f3891i = i15 + i14;
            }
            if (M) {
                m2Var2.p1(c02);
            }
            return list;
        }

        static /* synthetic */ List c(a aVar, m2 m2Var, int i11, m2 m2Var2, boolean z10, boolean z11, boolean z12, int i12, Object obj) {
            if ((i12 & 32) != 0) {
                z12 = true;
            }
            return aVar.b(m2Var, i11, m2Var2, z10, z11, z12);
        }
    }

    public m2(j2 j2Var) {
        this.f3883a = j2Var;
        this.f3884b = j2Var.o();
        this.f3885c = j2Var.q();
        this.f3886d = j2Var.m();
        this.f3887e = j2Var.s();
        this.f3888f = j2Var.n();
        this.f3889g = j2Var.p();
        this.f3890h = (this.f3884b.length / 5) - j2Var.p();
        this.f3893k = j2Var.r();
        this.f3894l = this.f3885c.length - j2Var.r();
        this.f3895m = j2Var.p();
        this.f3903u = j2Var.p();
    }

    private final int D0(int[] iArr, int i11) {
        return Q(iArr, i11);
    }

    private final int F0(int[] iArr, int i11) {
        return G0(l2.s(iArr, h0(i11)));
    }

    private final int G0(int i11) {
        return i11 > -2 ? i11 : d0() + i11 + 2;
    }

    private final int H(int[] iArr, int i11) {
        return Q(iArr, i11) + l2.d(l2.g(iArr, i11) >> 29);
    }

    private final int H0(int i11, int i12) {
        return i11 < i12 ? i11 : -((d0() - i11) + 2);
    }

    private final Object I0(Object obj) {
        Object U0 = U0();
        T0(obj);
        return U0;
    }

    private final boolean J(int i11) {
        int i12 = i11 + 1;
        int k02 = i11 + k0(i11);
        while (i12 < k02) {
            if (l2.b(this.f3884b, h0(i12))) {
                return true;
            }
            i12 += k0(i12);
        }
        return false;
    }

    private final void J0() {
        r1 r1Var = this.f3906x;
        if (r1Var != null) {
            while (r1Var.b()) {
                q1(r1Var.d(), r1Var);
            }
        }
    }

    private final void K() {
        int i11 = this.f3893k;
        ArraysKt.w(this.f3885c, null, i11, this.f3894l + i11);
    }

    private final boolean K0(int i11, int i12, HashMap hashMap) {
        int i13 = i12 + i11;
        int o11 = l2.o(this.f3886d, i13, Y() - this.f3890h);
        if (o11 >= this.f3886d.size()) {
            o11--;
        }
        int i14 = o11 + 1;
        int i15 = 0;
        while (o11 >= 0) {
            c cVar = (c) this.f3886d.get(o11);
            int F = F(cVar);
            if (F < i11) {
                break;
            }
            if (F < i13) {
                cVar.c(Integer.MIN_VALUE);
                if (hashMap != null) {
                }
                if (i15 == 0) {
                    i15 = o11 + 1;
                }
                i14 = o11;
            }
            o11--;
        }
        boolean z10 = i14 < i15;
        if (z10) {
            this.f3886d.subList(i14, i15).clear();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M(int i11) {
        return i11 >= 0 && l2.b(this.f3884b, h0(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M0(int i11, int i12) {
        if (i12 > 0) {
            ArrayList arrayList = this.f3886d;
            x0(i11);
            r0 = arrayList.isEmpty() ? false : K0(i11, i12, this.f3887e);
            this.f3889g = i11;
            this.f3890h += i12;
            int i13 = this.f3895m;
            if (i13 > i11) {
                this.f3895m = Math.max(i11, i13 - i12);
            }
            int i14 = this.f3903u;
            if (i14 >= this.f3889g) {
                this.f3903u = i14 - i12;
            }
            int i15 = this.f3904v;
            if (N(i15)) {
                p1(i15);
            }
        }
        return r0;
    }

    private final boolean N(int i11) {
        return i11 >= 0 && l2.c(this.f3884b, h0(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(int i11, int i12, int i13) {
        if (i12 > 0) {
            int i14 = this.f3894l;
            int i15 = i11 + i12;
            z0(i15, i13);
            this.f3893k = i11;
            this.f3894l = i14 + i12;
            ArraysKt.w(this.f3885c, null, i11, i15);
            int i16 = this.f3892j;
            if (i16 >= i11) {
                this.f3892j = i16 - i12;
            }
        }
    }

    private final int O(int i11, int i12, int i13) {
        return i11 < 0 ? (i13 - i12) + i11 + 1 : i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P(int i11) {
        return Q(this.f3884b, h0(i11));
    }

    private final int P0() {
        int Y = (Y() - this.f3890h) - this.f3899q.i();
        this.f3903u = Y;
        return Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Q(int[] iArr, int i11) {
        return i11 >= Y() ? this.f3885c.length - this.f3894l : O(l2.e(iArr, i11), this.f3894l, this.f3885c.length);
    }

    private final void Q0() {
        this.f3899q.j((Y() - this.f3890h) - this.f3903u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R(int i11) {
        return i11 < this.f3893k ? i11 : i11 + this.f3894l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S(int i11, int i12, int i13, int i14) {
        return i11 > i12 ? -(((i14 - i13) - i11) + 1) : i11;
    }

    private final void X(int i11, int i12, int i13) {
        int H0 = H0(i11, this.f3889g);
        while (i13 < i12) {
            l2.A(this.f3884b, h0(i13), H0);
            int h11 = l2.h(this.f3884b, h0(i13)) + i13;
            X(i13, h11, i13 + 1);
            i13 = h11;
        }
    }

    private final int Y() {
        return this.f3884b.length / 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Z0(int[] iArr, int i11) {
        return i11 >= Y() ? this.f3885c.length - this.f3894l : O(l2.u(iArr, i11), this.f3894l, this.f3885c.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l0 e1(int i11) {
        c l12;
        HashMap hashMap = this.f3887e;
        if (hashMap == null || (l12 = l1(i11)) == null) {
            return null;
        }
        return (l0) hashMap.get(l12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h0(int i11) {
        return i11 < this.f3889g ? i11 : i11 + this.f3890h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i1(int i11, Object obj, boolean z10, Object obj2) {
        int h11;
        int i12 = this.f3904v;
        Object[] objArr = this.f3896n > 0;
        this.f3900r.j(this.f3897o);
        if (objArr == true) {
            int i13 = this.f3902t;
            int Q = Q(this.f3884b, h0(i13));
            o0(1);
            this.f3891i = Q;
            this.f3892j = Q;
            int h02 = h0(i13);
            i.a aVar = i.f3811a;
            int i14 = obj != aVar.a() ? 1 : 0;
            int i15 = (z10 || obj2 == aVar.a()) ? 0 : 1;
            int S = S(Q, this.f3893k, this.f3894l, this.f3885c.length);
            l2.l(this.f3884b, h02, i11, z10, i14, i15, this.f3904v, (S < 0 || this.f3895m >= i13) ? S : -(((this.f3885c.length - this.f3894l) - S) + 1));
            int i16 = (z10 ? 1 : 0) + i14 + i15;
            if (i16 > 0) {
                p0(i16, i13);
                Object[] objArr2 = this.f3885c;
                int i17 = this.f3891i;
                if (z10) {
                    objArr2[i17] = obj2;
                    i17++;
                }
                if (i14 != 0) {
                    objArr2[i17] = obj;
                    i17++;
                }
                if (i15 != 0) {
                    objArr2[i17] = obj2;
                    i17++;
                }
                this.f3891i = i17;
            }
            this.f3897o = 0;
            h11 = i13 + 1;
            this.f3904v = i13;
            this.f3902t = h11;
            if (i12 >= 0) {
                e1(i12);
            }
        } else {
            this.f3898p.j(i12);
            Q0();
            int i18 = this.f3902t;
            int h03 = h0(i18);
            if (!Intrinsics.c(obj2, i.f3811a.a())) {
                if (z10) {
                    t1(obj2);
                } else {
                    o1(obj2);
                }
            }
            this.f3891i = Z0(this.f3884b, h03);
            this.f3892j = Q(this.f3884b, h0(this.f3902t + 1));
            this.f3897o = l2.p(this.f3884b, h03);
            this.f3904v = i18;
            this.f3902t = i18 + 1;
            h11 = i18 + l2.h(this.f3884b, h03);
        }
        this.f3903u = h11;
    }

    private final void n1(int i11, int i12) {
        c cVar;
        int a11;
        c cVar2;
        int a12;
        int i13;
        int Y = Y() - this.f3890h;
        if (i11 >= i12) {
            for (int o11 = l2.o(this.f3886d, i12, Y); o11 < this.f3886d.size() && (a11 = (cVar = (c) this.f3886d.get(o11)).a()) >= 0; o11++) {
                cVar.c(-(Y - a11));
            }
            return;
        }
        for (int o12 = l2.o(this.f3886d, i11, Y); o12 < this.f3886d.size() && (a12 = (cVar2 = (c) this.f3886d.get(o12)).a()) < 0 && (i13 = a12 + Y) < i12; o12++) {
            cVar2.c(i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(int i11) {
        if (i11 > 0) {
            int i12 = this.f3902t;
            x0(i12);
            int i13 = this.f3889g;
            int i14 = this.f3890h;
            int[] iArr = this.f3884b;
            int length = iArr.length / 5;
            int i15 = length - i14;
            if (i14 < i11) {
                int max = Math.max(Math.max(length * 2, i15 + i11), 32);
                int[] iArr2 = new int[max * 5];
                int i16 = max - i15;
                ArraysKt.l(iArr, iArr2, 0, 0, i13 * 5);
                ArraysKt.l(iArr, iArr2, (i13 + i16) * 5, (i14 + i13) * 5, length * 5);
                this.f3884b = iArr2;
                i14 = i16;
            }
            int i17 = this.f3903u;
            if (i17 >= i13) {
                this.f3903u = i17 + i11;
            }
            int i18 = i13 + i11;
            this.f3889g = i18;
            this.f3890h = i14 - i11;
            int S = S(i15 > 0 ? P(i12 + i11) : 0, this.f3895m >= i13 ? this.f3893k : 0, this.f3894l, this.f3885c.length);
            for (int i19 = i13; i19 < i18; i19++) {
                l2.w(this.f3884b, i19, S);
            }
            int i20 = this.f3895m;
            if (i20 >= i13) {
                this.f3895m = i20 + i11;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(int i11, int i12) {
        if (i11 > 0) {
            z0(this.f3891i, i12);
            int i13 = this.f3893k;
            int i14 = this.f3894l;
            if (i14 < i11) {
                Object[] objArr = this.f3885c;
                int length = objArr.length;
                int i15 = length - i14;
                int max = Math.max(Math.max(length * 2, i15 + i11), 32);
                Object[] objArr2 = new Object[max];
                for (int i16 = 0; i16 < max; i16++) {
                    objArr2[i16] = null;
                }
                int i17 = max - i15;
                ArraysKt.n(objArr, objArr2, 0, 0, i13);
                ArraysKt.n(objArr, objArr2, i13 + i17, i14 + i13, length);
                this.f3885c = objArr2;
                i14 = i17;
            }
            int i18 = this.f3892j;
            if (i18 >= i13) {
                this.f3892j = i18 + i11;
            }
            this.f3893k = i13 + i11;
            this.f3894l = i14 - i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void p1(int i11) {
        if (i11 >= 0) {
            r1 r1Var = this.f3906x;
            if (r1Var == null) {
                r1Var = new r1(null, 1, 0 == true ? 1 : 0);
                this.f3906x = r1Var;
            }
            r1Var.a(i11);
        }
    }

    private final void q1(int i11, r1 r1Var) {
        int h02 = h0(i11);
        boolean J = J(i11);
        if (l2.c(this.f3884b, h02) != J) {
            l2.v(this.f3884b, h02, J);
            int E0 = E0(i11);
            if (E0 >= 0) {
                r1Var.a(E0);
            }
        }
    }

    private final void r1(int[] iArr, int i11, int i12) {
        l2.w(iArr, i11, S(i12, this.f3893k, this.f3894l, this.f3885c.length));
    }

    public static /* synthetic */ void t0(m2 m2Var, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = m2Var.f3904v;
        }
        m2Var.s0(i11);
    }

    private final void u0(int i11, int i12, int i13) {
        c cVar;
        int F;
        int i14 = i13 + i11;
        int d02 = d0();
        int o11 = l2.o(this.f3886d, i11, d02);
        ArrayList arrayList = new ArrayList();
        if (o11 >= 0) {
            while (o11 < this.f3886d.size() && (F = F((cVar = (c) this.f3886d.get(o11)))) >= i11 && F < i14) {
                arrayList.add(cVar);
                this.f3886d.remove(o11);
            }
        }
        int i15 = i12 - i11;
        int size = arrayList.size();
        for (int i16 = 0; i16 < size; i16++) {
            c cVar2 = (c) arrayList.get(i16);
            int F2 = F(cVar2) + i15;
            if (F2 >= this.f3889g) {
                cVar2.c(-(d02 - F2));
            } else {
                cVar2.c(F2);
            }
            this.f3886d.add(l2.o(this.f3886d, F2, d02), cVar2);
        }
    }

    private final void u1(int i11, Object obj) {
        int h02 = h0(i11);
        int[] iArr = this.f3884b;
        if (!(h02 < iArr.length && l2.m(iArr, h02))) {
            k.r("Updating the node of a group at " + i11 + " that was not created with as a node group");
        }
        this.f3885c[R(D0(this.f3884b, h02))] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(int i11) {
        int i12 = this.f3890h;
        int i13 = this.f3889g;
        if (i13 != i11) {
            if (!this.f3886d.isEmpty()) {
                n1(i13, i11);
            }
            if (i12 > 0) {
                int[] iArr = this.f3884b;
                int i14 = i11 * 5;
                int i15 = i12 * 5;
                int i16 = i13 * 5;
                if (i11 < i13) {
                    ArraysKt.l(iArr, iArr, i15 + i14, i14, i16);
                } else {
                    ArraysKt.l(iArr, iArr, i16, i16 + i15, i14 + i15);
                }
            }
            if (i11 < i13) {
                i13 = i11 + i12;
            }
            int Y = Y();
            k.O(i13 < Y);
            while (i13 < Y) {
                int s11 = l2.s(this.f3884b, i13);
                int H0 = H0(G0(s11), i11);
                if (H0 != s11) {
                    l2.A(this.f3884b, i13, H0);
                }
                i13++;
                if (i13 == i11) {
                    i13 += i12;
                }
            }
        }
        this.f3889g = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(int i11, int i12) {
        int i13 = this.f3894l;
        int i14 = this.f3893k;
        int i15 = this.f3895m;
        if (i14 != i11) {
            Object[] objArr = this.f3885c;
            if (i11 < i14) {
                ArraysKt.n(objArr, objArr, i11 + i13, i11, i14);
            } else {
                ArraysKt.n(objArr, objArr, i14, i14 + i13, i11 + i13);
            }
        }
        int min = Math.min(i12 + 1, d0());
        if (i15 != min) {
            int length = this.f3885c.length - i13;
            if (min < i15) {
                int h02 = h0(min);
                int h03 = h0(i15);
                int i16 = this.f3889g;
                while (h02 < h03) {
                    int e11 = l2.e(this.f3884b, h02);
                    if (!(e11 >= 0)) {
                        k.r("Unexpected anchor value, expected a positive anchor");
                    }
                    l2.w(this.f3884b, h02, -((length - e11) + 1));
                    h02++;
                    if (h02 == i16) {
                        h02 += this.f3890h;
                    }
                }
            } else {
                int h04 = h0(i15);
                int h05 = h0(min);
                while (h04 < h05) {
                    int e12 = l2.e(this.f3884b, h04);
                    if (!(e12 < 0)) {
                        k.r("Unexpected anchor value, expected a negative anchor");
                    }
                    l2.w(this.f3884b, h04, e12 + length + 1);
                    h04++;
                    if (h04 == this.f3889g) {
                        h04 += this.f3890h;
                    }
                }
            }
            this.f3895m = min;
        }
        this.f3893k = i11;
    }

    public final Object A0(int i11) {
        int h02 = h0(i11);
        if (l2.m(this.f3884b, h02)) {
            return this.f3885c[R(D0(this.f3884b, h02))];
        }
        return null;
    }

    public final Object B0(c cVar) {
        return A0(cVar.e(this));
    }

    public final int C0(int i11) {
        return l2.p(this.f3884b, h0(i11));
    }

    public final void D(int i11) {
        boolean z10 = false;
        if (!(i11 >= 0)) {
            k.r("Cannot seek backwards");
        }
        if (!(this.f3896n <= 0)) {
            o1.b("Cannot call seek() while inserting");
        }
        if (i11 == 0) {
            return;
        }
        int i12 = this.f3902t + i11;
        if (i12 >= this.f3904v && i12 <= this.f3903u) {
            z10 = true;
        }
        if (!z10) {
            k.r("Cannot seek outside the current group (" + this.f3904v + '-' + this.f3903u + ')');
        }
        this.f3902t = i12;
        int Q = Q(this.f3884b, h0(i12));
        this.f3891i = Q;
        this.f3892j = Q;
    }

    public final c E(int i11) {
        ArrayList arrayList = this.f3886d;
        int t11 = l2.t(arrayList, i11, d0());
        if (t11 >= 0) {
            return (c) arrayList.get(t11);
        }
        if (i11 > this.f3889g) {
            i11 = -(d0() - i11);
        }
        c cVar = new c(i11);
        arrayList.add(-(t11 + 1), cVar);
        return cVar;
    }

    public final int E0(int i11) {
        return F0(this.f3884b, i11);
    }

    public final int F(c cVar) {
        int a11 = cVar.a();
        return a11 < 0 ? a11 + d0() : a11;
    }

    public final void G(c cVar, Object obj) {
        if (!(this.f3896n == 0)) {
            k.r("Can only append a slot if not current inserting");
        }
        int i11 = this.f3891i;
        int i12 = this.f3892j;
        int F = F(cVar);
        int Q = Q(this.f3884b, h0(F + 1));
        this.f3891i = Q;
        this.f3892j = Q;
        p0(1, F);
        if (i11 >= Q) {
            i11++;
            i12++;
        }
        this.f3885c[Q] = obj;
        this.f3891i = i11;
        this.f3892j = i12;
    }

    public final void I() {
        int i11 = this.f3896n;
        this.f3896n = i11 + 1;
        if (i11 == 0) {
            Q0();
        }
    }

    public final void L(boolean z10) {
        this.f3905w = true;
        if (z10 && this.f3898p.d()) {
            x0(d0());
            z0(this.f3885c.length - this.f3894l, this.f3889g);
            K();
            J0();
        }
        this.f3883a.f(this, this.f3884b, this.f3889g, this.f3885c, this.f3893k, this.f3886d, this.f3887e, this.f3888f);
    }

    public final boolean L0() {
        if (!(this.f3896n == 0)) {
            k.r("Cannot remove group while inserting");
        }
        int i11 = this.f3902t;
        int i12 = this.f3891i;
        int Q = Q(this.f3884b, h0(i11));
        int V0 = V0();
        e1(this.f3904v);
        r1 r1Var = this.f3906x;
        if (r1Var != null) {
            while (r1Var.b() && r1Var.c() >= i11) {
                r1Var.d();
            }
        }
        boolean M0 = M0(i11, this.f3902t - i11);
        N0(Q, this.f3891i - Q, i11 - 1);
        this.f3902t = i11;
        this.f3891i = i12;
        this.f3897o -= V0;
        return M0;
    }

    public final void O0() {
        if (!(this.f3896n == 0)) {
            k.r("Cannot reset when inserting");
        }
        J0();
        this.f3902t = 0;
        this.f3903u = Y() - this.f3890h;
        this.f3891i = 0;
        this.f3892j = 0;
        this.f3897o = 0;
    }

    public final Object R0(int i11, int i12, Object obj) {
        int R = R(a1(i11, i12));
        Object[] objArr = this.f3885c;
        Object obj2 = objArr[R];
        objArr[R] = obj;
        return obj2;
    }

    public final Object S0(int i11, Object obj) {
        return R0(this.f3902t, i11, obj);
    }

    public final int T() {
        androidx.collection.l0 l0Var;
        boolean z10 = this.f3896n > 0;
        int i11 = this.f3902t;
        int i12 = this.f3903u;
        int i13 = this.f3904v;
        int h02 = h0(i13);
        int i14 = this.f3897o;
        int i15 = i11 - i13;
        boolean m11 = l2.m(this.f3884b, h02);
        if (z10) {
            androidx.collection.e0 e0Var = this.f3901s;
            if (e0Var != null && (l0Var = (androidx.collection.l0) e0Var.c(i13)) != null) {
                Object[] objArr = l0Var.f2319a;
                int i16 = l0Var.f2320b;
                for (int i17 = 0; i17 < i16; i17++) {
                    I0(objArr[i17]);
                }
            }
            l2.x(this.f3884b, h02, i15);
            l2.z(this.f3884b, h02, i14);
            this.f3897o = this.f3900r.i() + (m11 ? 1 : i14);
            int F0 = F0(this.f3884b, i13);
            this.f3904v = F0;
            int d02 = F0 < 0 ? d0() : h0(F0 + 1);
            int Q = d02 >= 0 ? Q(this.f3884b, d02) : 0;
            this.f3891i = Q;
            this.f3892j = Q;
        } else {
            if (!(i11 == i12)) {
                k.r("Expected to be at the end of a group");
            }
            int h11 = l2.h(this.f3884b, h02);
            int p11 = l2.p(this.f3884b, h02);
            l2.x(this.f3884b, h02, i15);
            l2.z(this.f3884b, h02, i14);
            int i18 = this.f3898p.i();
            P0();
            this.f3904v = i18;
            int F02 = F0(this.f3884b, i13);
            int i19 = this.f3900r.i();
            this.f3897o = i19;
            if (F02 == i18) {
                this.f3897o = i19 + (m11 ? 0 : i14 - p11);
            } else {
                int i20 = i15 - h11;
                int i21 = m11 ? 0 : i14 - p11;
                if (i20 != 0 || i21 != 0) {
                    while (F02 != 0 && F02 != i18 && (i21 != 0 || i20 != 0)) {
                        int h03 = h0(F02);
                        if (i20 != 0) {
                            l2.x(this.f3884b, h03, l2.h(this.f3884b, h03) + i20);
                        }
                        if (i21 != 0) {
                            int[] iArr = this.f3884b;
                            l2.z(iArr, h03, l2.p(iArr, h03) + i21);
                        }
                        if (l2.m(this.f3884b, h03)) {
                            i21 = 0;
                        }
                        F02 = F0(this.f3884b, F02);
                    }
                }
                this.f3897o += i21;
            }
        }
        return i14;
    }

    public final void T0(Object obj) {
        if (!(this.f3891i <= this.f3892j)) {
            k.r("Writing to an invalid slot");
        }
        this.f3885c[R(this.f3891i - 1)] = obj;
    }

    public final void U() {
        if (!(this.f3896n > 0)) {
            o1.b("Unbalanced begin/end insert");
        }
        int i11 = this.f3896n - 1;
        this.f3896n = i11;
        if (i11 == 0) {
            if (!(this.f3900r.b() == this.f3898p.b())) {
                k.r("startGroup/endGroup mismatch while inserting");
            }
            P0();
        }
    }

    public final Object U0() {
        if (this.f3896n > 0) {
            p0(1, this.f3904v);
        }
        Object[] objArr = this.f3885c;
        int i11 = this.f3891i;
        this.f3891i = i11 + 1;
        return objArr[R(i11)];
    }

    public final void V(int i11) {
        boolean z10 = false;
        if (!(this.f3896n <= 0)) {
            k.r("Cannot call ensureStarted() while inserting");
        }
        int i12 = this.f3904v;
        if (i12 != i11) {
            if (i11 >= i12 && i11 < this.f3903u) {
                z10 = true;
            }
            if (!z10) {
                k.r("Started group at " + i11 + " must be a subgroup of the group at " + i12);
            }
            int i13 = this.f3902t;
            int i14 = this.f3891i;
            int i15 = this.f3892j;
            this.f3902t = i11;
            g1();
            this.f3902t = i13;
            this.f3891i = i14;
            this.f3892j = i15;
        }
    }

    public final int V0() {
        int h02 = h0(this.f3902t);
        int h11 = this.f3902t + l2.h(this.f3884b, h02);
        this.f3902t = h11;
        this.f3891i = Q(this.f3884b, h0(h11));
        if (l2.m(this.f3884b, h02)) {
            return 1;
        }
        return l2.p(this.f3884b, h02);
    }

    public final void W(c cVar) {
        V(cVar.e(this));
    }

    public final void W0() {
        int i11 = this.f3903u;
        this.f3902t = i11;
        this.f3891i = Q(this.f3884b, h0(i11));
    }

    public final Object X0(int i11, int i12) {
        int Z0 = Z0(this.f3884b, h0(i11));
        int Q = Q(this.f3884b, h0(i11 + 1));
        int i13 = i12 + Z0;
        if (Z0 > i13 || i13 >= Q) {
            return i.f3811a.a();
        }
        return this.f3885c[R(i13)];
    }

    public final Object Y0(c cVar, int i11) {
        return X0(F(cVar), i11);
    }

    public final boolean Z() {
        return this.f3905w;
    }

    public final int a0() {
        return this.f3902t;
    }

    public final int a1(int i11, int i12) {
        int Z0 = Z0(this.f3884b, h0(i11));
        int i13 = Z0 + i12;
        if (!(i13 >= Z0 && i13 < Q(this.f3884b, h0(i11 + 1)))) {
            k.r("Write to an invalid slot index " + i12 + " for group " + i11);
        }
        return i13;
    }

    public final int b0() {
        return this.f3903u;
    }

    public final int b1(int i11) {
        return Q(this.f3884b, h0(i11 + k0(i11)));
    }

    public final int c0() {
        return this.f3904v;
    }

    public final int c1(int i11) {
        return Q(this.f3884b, h0(i11 + 1));
    }

    public final int d0() {
        return Y() - this.f3890h;
    }

    public final int d1(int i11) {
        return Z0(this.f3884b, h0(i11));
    }

    public final int e0() {
        return this.f3885c.length - this.f3894l;
    }

    public final j2 f0() {
        return this.f3883a;
    }

    public final void f1(int i11, Object obj, Object obj2) {
        i1(i11, obj, false, obj2);
    }

    public final Object g0(int i11) {
        int h02 = h0(i11);
        return l2.i(this.f3884b, h02) ? this.f3885c[H(this.f3884b, h02)] : i.f3811a.a();
    }

    public final void g1() {
        if (!(this.f3896n == 0)) {
            k.r("Key must be supplied when inserting");
        }
        i.a aVar = i.f3811a;
        i1(0, aVar.a(), false, aVar.a());
    }

    public final void h1(int i11, Object obj) {
        i1(i11, obj, false, i.f3811a.a());
    }

    public final int i0(int i11) {
        return l2.n(this.f3884b, h0(i11));
    }

    public final Object j0(int i11) {
        int h02 = h0(i11);
        if (l2.k(this.f3884b, h02)) {
            return this.f3885c[l2.r(this.f3884b, h02)];
        }
        return null;
    }

    public final void j1(int i11, Object obj) {
        i1(i11, obj, true, i.f3811a.a());
    }

    public final int k0(int i11) {
        return l2.h(this.f3884b, h0(i11));
    }

    public final void k1(int i11) {
        k.O(i11 > 0);
        int i12 = this.f3904v;
        int Z0 = Z0(this.f3884b, h0(i12));
        int Q = Q(this.f3884b, h0(i12 + 1)) - i11;
        k.O(Q >= Z0);
        N0(Q, i11, i12);
        int i13 = this.f3891i;
        if (i13 >= Z0) {
            this.f3891i = i13 - i11;
        }
    }

    public final boolean l0(int i11) {
        return m0(i11, this.f3902t);
    }

    public final c l1(int i11) {
        if (i11 < 0 || i11 >= d0()) {
            return null;
        }
        return l2.f(this.f3886d, i11, d0());
    }

    public final boolean m0(int i11, int i12) {
        int Y;
        int k02;
        if (i12 == this.f3904v) {
            Y = this.f3903u;
        } else {
            if (i12 > this.f3898p.h(0)) {
                k02 = k0(i12);
            } else {
                int c11 = this.f3898p.c(i12);
                if (c11 < 0) {
                    k02 = k0(i12);
                } else {
                    Y = (Y() - this.f3890h) - this.f3899q.f(c11);
                }
            }
            Y = k02 + i12;
        }
        return i11 > i12 && i11 < Y;
    }

    public final Object m1(Object obj) {
        if (this.f3896n <= 0 || this.f3891i == this.f3893k) {
            return I0(obj);
        }
        androidx.collection.e0 e0Var = this.f3901s;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i11 = 1;
        int i12 = 0;
        if (e0Var == null) {
            e0Var = new androidx.collection.e0(i12, i11, defaultConstructorMarker);
        }
        this.f3901s = e0Var;
        int i13 = this.f3904v;
        Object c11 = e0Var.c(i13);
        if (c11 == null) {
            c11 = new androidx.collection.l0(i12, i11, defaultConstructorMarker);
            e0Var.t(i13, c11);
        }
        ((androidx.collection.l0) c11).e(obj);
        return i.f3811a.a();
    }

    public final boolean n0(int i11) {
        int i12 = this.f3904v;
        return (i11 > i12 && i11 < this.f3903u) || (i12 == 0 && i11 == 0);
    }

    public final void o1(Object obj) {
        int h02 = h0(this.f3902t);
        if (!l2.i(this.f3884b, h02)) {
            k.r("Updating the data of a group that was not created with a data slot");
        }
        this.f3885c[R(H(this.f3884b, h02))] = obj;
    }

    public final boolean q0() {
        int i11 = this.f3902t;
        return i11 < this.f3903u && l2.m(this.f3884b, h0(i11));
    }

    public final boolean r0(int i11) {
        return l2.m(this.f3884b, h0(i11));
    }

    public final void s0(int i11) {
        int h02 = h0(i11);
        if (l2.j(this.f3884b, h02)) {
            return;
        }
        l2.y(this.f3884b, h02, true);
        if (l2.c(this.f3884b, h02)) {
            return;
        }
        p1(E0(i11));
    }

    public final void s1(c cVar, Object obj) {
        u1(cVar.e(this), obj);
    }

    public final void t1(Object obj) {
        u1(this.f3902t, obj);
    }

    public String toString() {
        return "SlotWriter(current = " + this.f3902t + " end=" + this.f3903u + " size = " + d0() + " gap=" + this.f3889g + '-' + (this.f3889g + this.f3890h) + ')';
    }

    public final List v0(j2 j2Var, int i11, boolean z10) {
        k.O(this.f3896n > 0);
        if (i11 != 0 || this.f3902t != 0 || this.f3883a.p() != 0 || l2.h(j2Var.o(), i11) != j2Var.p()) {
            m2 x10 = j2Var.x();
            try {
                List b11 = f3881y.b(x10, i11, this, true, true, z10);
                x10.L(true);
                return b11;
            } catch (Throwable th2) {
                x10.L(false);
                throw th2;
            }
        }
        int[] iArr = this.f3884b;
        Object[] objArr = this.f3885c;
        ArrayList arrayList = this.f3886d;
        HashMap hashMap = this.f3887e;
        androidx.collection.e0 e0Var = this.f3888f;
        int[] o11 = j2Var.o();
        int p11 = j2Var.p();
        Object[] q11 = j2Var.q();
        int r11 = j2Var.r();
        HashMap s11 = j2Var.s();
        androidx.collection.e0 n11 = j2Var.n();
        this.f3884b = o11;
        this.f3885c = q11;
        this.f3886d = j2Var.m();
        this.f3889g = p11;
        this.f3890h = (o11.length / 5) - p11;
        this.f3893k = r11;
        this.f3894l = q11.length - r11;
        this.f3895m = p11;
        this.f3887e = s11;
        this.f3888f = n11;
        j2Var.z(iArr, 0, objArr, 0, arrayList, hashMap, e0Var);
        return this.f3886d;
    }

    public final void v1() {
        this.f3887e = this.f3883a.s();
        this.f3888f = this.f3883a.n();
    }

    public final void w0(int i11) {
        if (!(this.f3896n == 0)) {
            k.r("Cannot move a group while inserting");
        }
        if (!(i11 >= 0)) {
            k.r("Parameter offset is out of bounds");
        }
        if (i11 == 0) {
            return;
        }
        int i12 = this.f3902t;
        int i13 = this.f3904v;
        int i14 = this.f3903u;
        int i15 = i12;
        for (int i16 = i11; i16 > 0; i16--) {
            i15 += l2.h(this.f3884b, h0(i15));
            if (!(i15 <= i14)) {
                k.r("Parameter offset is out of bounds");
            }
        }
        int h11 = l2.h(this.f3884b, h0(i15));
        int Q = Q(this.f3884b, h0(this.f3902t));
        int Q2 = Q(this.f3884b, h0(i15));
        int i17 = i15 + h11;
        int Q3 = Q(this.f3884b, h0(i17));
        int i18 = Q3 - Q2;
        p0(i18, Math.max(this.f3902t - 1, 0));
        o0(h11);
        int[] iArr = this.f3884b;
        int h02 = h0(i17) * 5;
        ArraysKt.l(iArr, iArr, h0(i12) * 5, h02, (h11 * 5) + h02);
        if (i18 > 0) {
            Object[] objArr = this.f3885c;
            ArraysKt.n(objArr, objArr, Q, R(Q2 + i18), R(Q3 + i18));
        }
        int i19 = Q2 + i18;
        int i20 = i19 - Q;
        int i21 = this.f3893k;
        int i22 = this.f3894l;
        int length = this.f3885c.length;
        int i23 = this.f3895m;
        int i24 = i12 + h11;
        int i25 = i12;
        while (i25 < i24) {
            int h03 = h0(i25);
            int i26 = i21;
            int i27 = i20;
            r1(iArr, h03, S(Q(iArr, h03) - i20, i23 < h03 ? 0 : i26, i22, length));
            i25++;
            i21 = i26;
            i20 = i27;
        }
        u0(i17, i12, h11);
        if (M0(i17, h11)) {
            k.r("Unexpectedly removed anchors");
        }
        X(i13, this.f3903u, i12);
        if (i18 > 0) {
            N0(i19, i18, i17 - 1);
        }
    }

    public final List y0(int i11, j2 j2Var, int i12) {
        k.O(this.f3896n <= 0 && k0(this.f3902t + i11) == 1);
        int i13 = this.f3902t;
        int i14 = this.f3891i;
        int i15 = this.f3892j;
        D(i11);
        g1();
        I();
        m2 x10 = j2Var.x();
        try {
            List c11 = a.c(f3881y, x10, i12, this, false, true, false, 32, null);
            x10.L(true);
            U();
            T();
            this.f3902t = i13;
            this.f3891i = i14;
            this.f3892j = i15;
            return c11;
        } catch (Throwable th2) {
            x10.L(false);
            throw th2;
        }
    }
}
