package of;

import com.tencent.tinker.android.utils.SparseBoolArray;

/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: a, reason: collision with root package name */
    private final jf.a f71108a = new jf.a();

    /* renamed from: b, reason: collision with root package name */
    private final jf.a f71109b = new jf.a();

    /* renamed from: c, reason: collision with root package name */
    private final jf.a f71110c = new jf.a();

    /* renamed from: d, reason: collision with root package name */
    private final jf.a f71111d = new jf.a();

    /* renamed from: e, reason: collision with root package name */
    private final jf.a f71112e = new jf.a();

    /* renamed from: f, reason: collision with root package name */
    private final jf.a f71113f = new jf.a();

    /* renamed from: g, reason: collision with root package name */
    public final jf.a f71114g = new jf.a();

    /* renamed from: h, reason: collision with root package name */
    private final jf.a f71115h = new jf.a();

    /* renamed from: i, reason: collision with root package name */
    private final jf.a f71116i = new jf.a();

    /* renamed from: j, reason: collision with root package name */
    private final jf.a f71117j = new jf.a();

    /* renamed from: k, reason: collision with root package name */
    private final jf.a f71118k = new jf.a();

    /* renamed from: l, reason: collision with root package name */
    private final jf.a f71119l = new jf.a();

    /* renamed from: m, reason: collision with root package name */
    private final jf.a f71120m = new jf.a();

    /* renamed from: n, reason: collision with root package name */
    private final jf.a f71121n = new jf.a();

    /* renamed from: o, reason: collision with root package name */
    private final jf.a f71122o = new jf.a();

    /* renamed from: p, reason: collision with root package name */
    private final jf.a f71123p = new jf.a();

    /* renamed from: q, reason: collision with root package name */
    private final SparseBoolArray f71124q = new SparseBoolArray();

    /* renamed from: r, reason: collision with root package name */
    private final SparseBoolArray f71125r = new SparseBoolArray();

    /* renamed from: s, reason: collision with root package name */
    private final SparseBoolArray f71126s = new SparseBoolArray();

    /* renamed from: t, reason: collision with root package name */
    private final SparseBoolArray f71127t = new SparseBoolArray();

    /* renamed from: u, reason: collision with root package name */
    private final SparseBoolArray f71128u = new SparseBoolArray();

    /* renamed from: v, reason: collision with root package name */
    private final SparseBoolArray f71129v = new SparseBoolArray();

    /* renamed from: w, reason: collision with root package name */
    private final SparseBoolArray f71130w = new SparseBoolArray();

    /* renamed from: x, reason: collision with root package name */
    private final SparseBoolArray f71131x = new SparseBoolArray();

    /* renamed from: y, reason: collision with root package name */
    private final SparseBoolArray f71132y = new SparseBoolArray();

    /* renamed from: z, reason: collision with root package name */
    private final SparseBoolArray f71133z = new SparseBoolArray();
    private final SparseBoolArray A = new SparseBoolArray();
    private final SparseBoolArray B = new SparseBoolArray();
    private final SparseBoolArray C = new SparseBoolArray();
    private final SparseBoolArray D = new SparseBoolArray();
    private final SparseBoolArray E = new SparseBoolArray();
    private final SparseBoolArray F = new SparseBoolArray();

    @Override // of.a
    public int C(int i11) {
        int k11 = this.f71114g.k(i11);
        if (k11 >= 0) {
            return this.f71114g.p(k11);
        }
        if (i11 < 0 || !this.f71130w.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int D(int i11) {
        int k11 = this.f71112e.k(i11);
        if (k11 >= 0) {
            return this.f71112e.p(k11);
        }
        if (i11 < 0 || !this.f71128u.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int G(int i11) {
        int k11 = this.f71110c.k(i11);
        if (k11 >= 0) {
            return this.f71110c.p(k11);
        }
        if (i11 < 0 || !this.f71126s.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int H(int i11) {
        int k11 = this.f71120m.k(i11);
        if (k11 >= 0) {
            return this.f71120m.p(k11);
        }
        if (i11 < 0 || !this.C.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int I(int i11) {
        int k11 = this.f71108a.k(i11);
        if (k11 >= 0) {
            return this.f71108a.p(k11);
        }
        if (i11 < 0 || !this.f71124q.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int J(int i11) {
        int k11 = this.f71109b.k(i11);
        if (k11 >= 0) {
            return this.f71109b.p(k11);
        }
        if (i11 < 0 || !this.f71125r.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int K(int i11) {
        int k11 = this.f71115h.k(i11);
        if (k11 >= 0) {
            return this.f71115h.p(k11);
        }
        if (i11 < 0 || !this.f71131x.c(i11)) {
            return i11;
        }
        return -1;
    }

    public void L(int i11, int i12) {
        this.f71116i.n(i11, i12);
    }

    public void M(int i11, int i12) {
        this.f71117j.n(i11, i12);
    }

    public void N(int i11, int i12) {
        this.f71118k.n(i11, i12);
    }

    public void O(int i11, int i12) {
        this.f71119l.n(i11, i12);
    }

    public void P(int i11, int i12) {
        this.f71113f.n(i11, i12);
    }

    public void Q(int i11, int i12) {
        this.f71121n.n(i11, i12);
    }

    public void R(int i11, int i12) {
        this.f71123p.n(i11, i12);
    }

    public void S(int i11, int i12) {
        this.f71122o.n(i11, i12);
    }

    public void T(int i11, int i12) {
        this.f71111d.n(i11, i12);
    }

    public void U(int i11, int i12) {
        this.f71114g.n(i11, i12);
    }

    public void V(int i11, int i12) {
        this.f71112e.n(i11, i12);
    }

    public void W(int i11, int i12) {
        this.f71110c.n(i11, i12);
    }

    public void X(int i11, int i12) {
        this.f71120m.n(i11, i12);
    }

    public void Y(int i11, int i12) {
        this.f71108a.n(i11, i12);
    }

    public void Z(int i11, int i12) {
        this.f71109b.n(i11, i12);
    }

    public void a0(int i11, int i12) {
        this.f71115h.n(i11, i12);
    }

    public void b0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71132y.j(i11, true);
    }

    public void c0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71133z.j(i11, true);
    }

    public void d0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.A.j(i11, true);
    }

    public void e0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.B.j(i11, true);
    }

    public void f0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71129v.j(i11, true);
    }

    public void g0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.D.j(i11, true);
    }

    public void h0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.F.j(i11, true);
    }

    public void i0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.E.j(i11, true);
    }

    public void j0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71127t.j(i11, true);
    }

    public void k0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71130w.j(i11, true);
    }

    public void l0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71128u.j(i11, true);
    }

    public void m0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71126s.j(i11, true);
    }

    public void n0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.C.j(i11, true);
    }

    public void o0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71124q.j(i11, true);
    }

    @Override // of.a
    public int p(int i11) {
        int k11 = this.f71116i.k(i11);
        if (k11 >= 0) {
            return this.f71116i.p(k11);
        }
        if (i11 < 0 || !this.f71132y.c(i11)) {
            return i11;
        }
        return -1;
    }

    public void p0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71125r.j(i11, true);
    }

    @Override // of.a
    public int q(int i11) {
        int k11 = this.f71117j.k(i11);
        if (k11 >= 0) {
            return this.f71117j.p(k11);
        }
        if (i11 < 0 || !this.f71133z.c(i11)) {
            return i11;
        }
        return -1;
    }

    public void q0(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f71131x.j(i11, true);
    }

    @Override // of.a
    public int r(int i11) {
        int k11 = this.f71118k.k(i11);
        if (k11 >= 0) {
            return this.f71118k.p(k11);
        }
        if (i11 < 0 || !this.A.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int s(int i11) {
        int k11 = this.f71119l.k(i11);
        if (k11 >= 0) {
            return this.f71119l.p(k11);
        }
        if (i11 < 0 || !this.B.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int t(int i11) {
        int k11 = this.f71113f.k(i11);
        if (k11 >= 0) {
            return this.f71113f.p(k11);
        }
        if (i11 < 0 || !this.f71129v.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int v(int i11) {
        int k11 = this.f71121n.k(i11);
        if (k11 >= 0) {
            return this.f71121n.p(k11);
        }
        if (i11 < 0 || !this.D.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int w(int i11) {
        int k11 = this.f71123p.k(i11);
        if (k11 >= 0) {
            return this.f71123p.p(k11);
        }
        if (i11 < 0 || !this.F.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int x(int i11) {
        int k11 = this.f71122o.k(i11);
        if (k11 >= 0) {
            return this.f71122o.p(k11);
        }
        if (i11 < 0 || !this.E.c(i11)) {
            return i11;
        }
        return -1;
    }

    @Override // of.a
    public int z(int i11) {
        int k11 = this.f71111d.k(i11);
        if (k11 >= 0) {
            return this.f71111d.p(k11);
        }
        if (i11 < 0 || !this.f71127t.c(i11)) {
            return i11;
        }
        return -1;
    }
}
