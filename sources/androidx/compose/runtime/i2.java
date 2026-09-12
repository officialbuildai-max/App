package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class i2 {

    /* renamed from: a, reason: collision with root package name */
    private final j2 f3817a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f3818b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3819c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f3820d;

    /* renamed from: e, reason: collision with root package name */
    private final int f3821e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap f3822f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3823g;

    /* renamed from: h, reason: collision with root package name */
    private int f3824h;

    /* renamed from: i, reason: collision with root package name */
    private int f3825i;

    /* renamed from: j, reason: collision with root package name */
    private int f3826j;

    /* renamed from: k, reason: collision with root package name */
    private final m0 f3827k;

    /* renamed from: l, reason: collision with root package name */
    private int f3828l;

    /* renamed from: m, reason: collision with root package name */
    private int f3829m;

    /* renamed from: n, reason: collision with root package name */
    private int f3830n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3831o;

    public i2(j2 j2Var) {
        this.f3817a = j2Var;
        this.f3818b = j2Var.o();
        int p11 = j2Var.p();
        this.f3819c = p11;
        this.f3820d = j2Var.q();
        this.f3821e = j2Var.r();
        this.f3825i = p11;
        this.f3826j = -1;
        this.f3827k = new m0();
    }

    private final Object M(int[] iArr, int i11) {
        return l2.m(iArr, i11) ? this.f3820d[l2.q(iArr, i11)] : i.f3811a.a();
    }

    private final Object O(int[] iArr, int i11) {
        if (l2.k(iArr, i11)) {
            return this.f3820d[l2.r(iArr, i11)];
        }
        return null;
    }

    private final Object b(int[] iArr, int i11) {
        return l2.i(iArr, i11) ? this.f3820d[l2.a(iArr, i11)] : i.f3811a.a();
    }

    public final Object A(int i11) {
        return B(this.f3824h, i11);
    }

    public final Object B(int i11, int i12) {
        int u11 = l2.u(this.f3818b, i11);
        int i13 = i11 + 1;
        int i14 = u11 + i12;
        return i14 < (i13 < this.f3819c ? l2.e(this.f3818b, i13) : this.f3821e) ? this.f3820d[i14] : i.f3811a.a();
    }

    public final int C(int i11) {
        return l2.n(this.f3818b, i11);
    }

    public final Object D(int i11) {
        return O(this.f3818b, i11);
    }

    public final int E(int i11) {
        return l2.h(this.f3818b, i11);
    }

    public final boolean F(int i11) {
        return l2.j(this.f3818b, i11);
    }

    public final boolean G(int i11) {
        return l2.k(this.f3818b, i11);
    }

    public final boolean H() {
        return t() || this.f3824h == this.f3825i;
    }

    public final boolean I() {
        return l2.m(this.f3818b, this.f3824h);
    }

    public final boolean J(int i11) {
        return l2.m(this.f3818b, i11);
    }

    public final Object K() {
        int i11;
        if (this.f3828l > 0 || (i11 = this.f3829m) >= this.f3830n) {
            this.f3831o = false;
            return i.f3811a.a();
        }
        this.f3831o = true;
        Object[] objArr = this.f3820d;
        this.f3829m = i11 + 1;
        return objArr[i11];
    }

    public final Object L(int i11) {
        if (l2.m(this.f3818b, i11)) {
            return M(this.f3818b, i11);
        }
        return null;
    }

    public final int N(int i11) {
        return l2.p(this.f3818b, i11);
    }

    public final int P(int i11) {
        return l2.s(this.f3818b, i11);
    }

    public final void Q(int i11) {
        if (!(this.f3828l == 0)) {
            k.r("Cannot reposition while in an empty region");
        }
        this.f3824h = i11;
        int s11 = i11 < this.f3819c ? l2.s(this.f3818b, i11) : -1;
        this.f3826j = s11;
        if (s11 < 0) {
            this.f3825i = this.f3819c;
        } else {
            this.f3825i = s11 + l2.h(this.f3818b, s11);
        }
        this.f3829m = 0;
        this.f3830n = 0;
    }

    public final void R(int i11) {
        int h11 = l2.h(this.f3818b, i11) + i11;
        int i12 = this.f3824h;
        if (!(i12 >= i11 && i12 <= h11)) {
            k.r("Index " + i11 + " is not a parent of " + i12);
        }
        this.f3826j = i11;
        this.f3825i = h11;
        this.f3829m = 0;
        this.f3830n = 0;
    }

    public final int S() {
        if (!(this.f3828l == 0)) {
            k.r("Cannot skip while in an empty region");
        }
        int p11 = l2.m(this.f3818b, this.f3824h) ? 1 : l2.p(this.f3818b, this.f3824h);
        int i11 = this.f3824h;
        this.f3824h = i11 + l2.h(this.f3818b, i11);
        return p11;
    }

    public final void T() {
        if (!(this.f3828l == 0)) {
            k.r("Cannot skip the enclosing group while in an empty region");
        }
        this.f3824h = this.f3825i;
        this.f3829m = 0;
        this.f3830n = 0;
    }

    public final void U() {
        if (this.f3828l <= 0) {
            int i11 = this.f3826j;
            int i12 = this.f3824h;
            if (!(l2.s(this.f3818b, i12) == i11)) {
                o1.a("Invalid slot table detected");
            }
            HashMap hashMap = this.f3822f;
            if (hashMap != null) {
            }
            m0 m0Var = this.f3827k;
            int i13 = this.f3829m;
            int i14 = this.f3830n;
            if (i13 == 0 && i14 == 0) {
                m0Var.j(-1);
            } else {
                m0Var.j(i13);
            }
            this.f3826j = i12;
            this.f3825i = l2.h(this.f3818b, i12) + i12;
            int i15 = i12 + 1;
            this.f3824h = i15;
            this.f3829m = l2.u(this.f3818b, i12);
            this.f3830n = i12 >= this.f3819c - 1 ? this.f3821e : l2.e(this.f3818b, i15);
        }
    }

    public final void V() {
        if (this.f3828l <= 0) {
            if (!l2.m(this.f3818b, this.f3824h)) {
                o1.a("Expected a node group");
            }
            U();
        }
    }

    public final c a(int i11) {
        ArrayList m11 = this.f3817a.m();
        int t11 = l2.t(m11, i11, this.f3819c);
        if (t11 >= 0) {
            return (c) m11.get(t11);
        }
        c cVar = new c(i11);
        m11.add(-(t11 + 1), cVar);
        return cVar;
    }

    public final void c() {
        this.f3828l++;
    }

    public final void d() {
        this.f3823g = true;
        this.f3817a.e(this, this.f3822f);
    }

    public final boolean e(int i11) {
        return l2.c(this.f3818b, i11);
    }

    public final void f() {
        if (!(this.f3828l > 0)) {
            o1.a("Unbalanced begin/end empty");
        }
        this.f3828l--;
    }

    public final void g() {
        if (this.f3828l == 0) {
            if (!(this.f3824h == this.f3825i)) {
                k.r("endGroup() not called at the end of a group");
            }
            int s11 = l2.s(this.f3818b, this.f3826j);
            this.f3826j = s11;
            this.f3825i = s11 < 0 ? this.f3819c : l2.h(this.f3818b, s11) + s11;
            int i11 = this.f3827k.i();
            if (i11 < 0) {
                this.f3829m = 0;
                this.f3830n = 0;
            } else {
                this.f3829m = i11;
                this.f3830n = s11 >= this.f3819c - 1 ? this.f3821e : l2.e(this.f3818b, s11 + 1);
            }
        }
    }

    public final List h() {
        ArrayList arrayList = new ArrayList();
        if (this.f3828l > 0) {
            return arrayList;
        }
        int i11 = this.f3824h;
        int i12 = 0;
        while (i11 < this.f3825i) {
            arrayList.add(new q0(l2.n(this.f3818b, i11), O(this.f3818b, i11), i11, l2.m(this.f3818b, i11) ? 1 : l2.p(this.f3818b, i11), i12));
            i11 += l2.h(this.f3818b, i11);
            i12++;
        }
        return arrayList;
    }

    public final boolean i() {
        return this.f3823g;
    }

    public final int j() {
        return this.f3825i;
    }

    public final int k() {
        return this.f3824h;
    }

    public final Object l() {
        int i11 = this.f3824h;
        if (i11 < this.f3825i) {
            return b(this.f3818b, i11);
        }
        return 0;
    }

    public final int m() {
        return this.f3825i;
    }

    public final int n() {
        int i11 = this.f3824h;
        if (i11 < this.f3825i) {
            return l2.n(this.f3818b, i11);
        }
        return 0;
    }

    public final Object o() {
        int i11 = this.f3824h;
        if (i11 < this.f3825i) {
            return O(this.f3818b, i11);
        }
        return null;
    }

    public final int p() {
        return l2.h(this.f3818b, this.f3824h);
    }

    public final int q() {
        return this.f3829m - l2.u(this.f3818b, this.f3826j);
    }

    public final boolean r() {
        return this.f3831o;
    }

    public final boolean s() {
        int i11 = this.f3824h;
        return i11 < this.f3825i && l2.k(this.f3818b, i11);
    }

    public final boolean t() {
        return this.f3828l > 0;
    }

    public String toString() {
        return "SlotReader(current=" + this.f3824h + ", key=" + n() + ", parent=" + this.f3826j + ", end=" + this.f3825i + ')';
    }

    public final int u() {
        return this.f3826j;
    }

    public final int v() {
        int i11 = this.f3826j;
        if (i11 >= 0) {
            return l2.p(this.f3818b, i11);
        }
        return 0;
    }

    public final int w() {
        return this.f3830n - this.f3829m;
    }

    public final int x() {
        return this.f3819c;
    }

    public final j2 y() {
        return this.f3817a;
    }

    public final Object z(int i11) {
        return b(this.f3818b, i11);
    }
}
