package z;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.n4;
import androidx.compose.ui.graphics.p4;
import androidx.compose.ui.graphics.t0;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.x3;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a implements g {

    /* renamed from: a, reason: collision with root package name */
    private final C1001a f79220a = new C1001a(null, null, null, 0, 15, null);

    /* renamed from: b, reason: collision with root package name */
    private final d f79221b = new b();

    /* renamed from: c, reason: collision with root package name */
    private m4 f79222c;

    /* renamed from: d, reason: collision with root package name */
    private m4 f79223d;

    /* renamed from: z.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C1001a {

        /* renamed from: a, reason: collision with root package name */
        private o0.e f79224a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutDirection f79225b;

        /* renamed from: c, reason: collision with root package name */
        private m1 f79226c;

        /* renamed from: d, reason: collision with root package name */
        private long f79227d;

        private C1001a(o0.e eVar, LayoutDirection layoutDirection, m1 m1Var, long j11) {
            this.f79224a = eVar;
            this.f79225b = layoutDirection;
            this.f79226c = m1Var;
            this.f79227d = j11;
        }

        public /* synthetic */ C1001a(o0.e eVar, LayoutDirection layoutDirection, m1 m1Var, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? e.a() : eVar, (i11 & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i11 & 4) != 0 ? new k() : m1Var, (i11 & 8) != 0 ? y.m.f78614b.b() : j11, null);
        }

        public /* synthetic */ C1001a(o0.e eVar, LayoutDirection layoutDirection, m1 m1Var, long j11, DefaultConstructorMarker defaultConstructorMarker) {
            this(eVar, layoutDirection, m1Var, j11);
        }

        public final o0.e a() {
            return this.f79224a;
        }

        public final LayoutDirection b() {
            return this.f79225b;
        }

        public final m1 c() {
            return this.f79226c;
        }

        public final long d() {
            return this.f79227d;
        }

        public final m1 e() {
            return this.f79226c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1001a)) {
                return false;
            }
            C1001a c1001a = (C1001a) obj;
            return Intrinsics.c(this.f79224a, c1001a.f79224a) && this.f79225b == c1001a.f79225b && Intrinsics.c(this.f79226c, c1001a.f79226c) && y.m.f(this.f79227d, c1001a.f79227d);
        }

        public final o0.e f() {
            return this.f79224a;
        }

        public final LayoutDirection g() {
            return this.f79225b;
        }

        public final long h() {
            return this.f79227d;
        }

        public int hashCode() {
            return (((((this.f79224a.hashCode() * 31) + this.f79225b.hashCode()) * 31) + this.f79226c.hashCode()) * 31) + y.m.j(this.f79227d);
        }

        public final void i(m1 m1Var) {
            this.f79226c = m1Var;
        }

        public final void j(o0.e eVar) {
            this.f79224a = eVar;
        }

        public final void k(LayoutDirection layoutDirection) {
            this.f79225b = layoutDirection;
        }

        public final void l(long j11) {
            this.f79227d = j11;
        }

        public String toString() {
            return "DrawParams(density=" + this.f79224a + ", layoutDirection=" + this.f79225b + ", canvas=" + this.f79226c + ", size=" + ((Object) y.m.l(this.f79227d)) + ')';
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private final j f79228a = z.b.a(this);

        /* renamed from: b, reason: collision with root package name */
        private GraphicsLayer f79229b;

        b() {
        }

        @Override // z.d
        public void a(LayoutDirection layoutDirection) {
            a.this.F().k(layoutDirection);
        }

        @Override // z.d
        public void b(o0.e eVar) {
            a.this.F().j(eVar);
        }

        @Override // z.d
        public j c() {
            return this.f79228a;
        }

        @Override // z.d
        public void d(GraphicsLayer graphicsLayer) {
            this.f79229b = graphicsLayer;
        }

        @Override // z.d
        public m1 e() {
            return a.this.F().e();
        }

        @Override // z.d
        public void f(long j11) {
            a.this.F().l(j11);
        }

        @Override // z.d
        public GraphicsLayer g() {
            return this.f79229b;
        }

        @Override // z.d
        public o0.e getDensity() {
            return a.this.F().f();
        }

        @Override // z.d
        public LayoutDirection getLayoutDirection() {
            return a.this.F().g();
        }

        @Override // z.d
        public void h(m1 m1Var) {
            a.this.F().i(m1Var);
        }

        @Override // z.d
        public long i() {
            return a.this.F().h();
        }
    }

    static /* synthetic */ m4 B(a aVar, j1 j1Var, h hVar, float f11, v1 v1Var, int i11, int i12, int i13, Object obj) {
        if ((i13 & 32) != 0) {
            i12 = g.f79233o1.b();
        }
        return aVar.z(j1Var, hVar, f11, v1Var, i11, i12);
    }

    private final m4 C(long j11, float f11, float f12, int i11, int i12, p4 p4Var, float f13, v1 v1Var, int i13, int i14) {
        m4 L = L();
        long G = G(j11, f13);
        if (!u1.m(L.a(), G)) {
            L.s(G);
        }
        if (L.y() != null) {
            L.x(null);
        }
        if (!Intrinsics.c(L.i(), v1Var)) {
            L.z(v1Var);
        }
        if (!c1.E(L.l(), i13)) {
            L.n(i13);
        }
        if (L.getStrokeWidth() != f11) {
            L.setStrokeWidth(f11);
        }
        if (L.v() != f12) {
            L.A(f12);
        }
        if (!c5.e(L.p(), i11)) {
            L.m(i11);
        }
        if (!d5.e(L.u(), i12)) {
            L.r(i12);
        }
        L.t();
        if (!Intrinsics.c(null, p4Var)) {
            L.q(p4Var);
        }
        if (!x3.d(L.B(), i14)) {
            L.o(i14);
        }
        return L;
    }

    static /* synthetic */ m4 D(a aVar, long j11, float f11, float f12, int i11, int i12, p4 p4Var, float f13, v1 v1Var, int i13, int i14, int i15, Object obj) {
        return aVar.C(j11, f11, f12, i11, i12, p4Var, f13, v1Var, i13, (i15 & 512) != 0 ? g.f79233o1.b() : i14);
    }

    private final long G(long j11, float f11) {
        return f11 == 1.0f ? j11 : u1.k(j11, u1.n(j11) * f11, 0.0f, 0.0f, 0.0f, 14, null);
    }

    private final m4 I() {
        m4 m4Var = this.f79222c;
        if (m4Var != null) {
            return m4Var;
        }
        m4 a11 = t0.a();
        a11.C(n4.f4683a.a());
        this.f79222c = a11;
        return a11;
    }

    private final m4 L() {
        m4 m4Var = this.f79223d;
        if (m4Var != null) {
            return m4Var;
        }
        m4 a11 = t0.a();
        a11.C(n4.f4683a.b());
        this.f79223d = a11;
        return a11;
    }

    private final m4 M(h hVar) {
        if (Intrinsics.c(hVar, l.f79237a)) {
            return I();
        }
        if (!(hVar instanceof m)) {
            throw new NoWhenBranchMatchedException();
        }
        m4 L = L();
        m mVar = (m) hVar;
        if (L.getStrokeWidth() != mVar.f()) {
            L.setStrokeWidth(mVar.f());
        }
        if (!c5.e(L.p(), mVar.b())) {
            L.m(mVar.b());
        }
        if (L.v() != mVar.d()) {
            L.A(mVar.d());
        }
        if (!d5.e(L.u(), mVar.c())) {
            L.r(mVar.c());
        }
        L.t();
        mVar.e();
        if (!Intrinsics.c(null, null)) {
            mVar.e();
            L.q(null);
        }
        return L;
    }

    private final m4 n(long j11, h hVar, float f11, v1 v1Var, int i11, int i12) {
        m4 M = M(hVar);
        long G = G(j11, f11);
        if (!u1.m(M.a(), G)) {
            M.s(G);
        }
        if (M.y() != null) {
            M.x(null);
        }
        if (!Intrinsics.c(M.i(), v1Var)) {
            M.z(v1Var);
        }
        if (!c1.E(M.l(), i11)) {
            M.n(i11);
        }
        if (!x3.d(M.B(), i12)) {
            M.o(i12);
        }
        return M;
    }

    static /* synthetic */ m4 v(a aVar, long j11, h hVar, float f11, v1 v1Var, int i11, int i12, int i13, Object obj) {
        return aVar.n(j11, hVar, f11, v1Var, i11, (i13 & 32) != 0 ? g.f79233o1.b() : i12);
    }

    private final m4 z(j1 j1Var, h hVar, float f11, v1 v1Var, int i11, int i12) {
        m4 M = M(hVar);
        if (j1Var != null) {
            j1Var.a(i(), M, f11);
        } else {
            if (M.y() != null) {
                M.x(null);
            }
            long a11 = M.a();
            u1.a aVar = u1.f4733b;
            if (!u1.m(a11, aVar.a())) {
                M.s(aVar.a());
            }
            if (M.getAlpha() != f11) {
                M.setAlpha(f11);
            }
        }
        if (!Intrinsics.c(M.i(), v1Var)) {
            M.z(v1Var);
        }
        if (!c1.E(M.l(), i11)) {
            M.n(i11);
        }
        if (!x3.d(M.B(), i12)) {
            M.o(i12);
        }
        return M;
    }

    @Override // o0.n
    public float C0() {
        return this.f79220a.f().C0();
    }

    @Override // z.g
    public void D0(Path path, long j11, float f11, h hVar, v1 v1Var, int i11) {
        this.f79220a.e().q(path, v(this, j11, hVar, f11, v1Var, i11, 0, 32, null));
    }

    @Override // o0.e
    public /* synthetic */ float E0(float f11) {
        return o0.d.e(this, f11);
    }

    public final C1001a F() {
        return this.f79220a;
    }

    @Override // z.g
    public void G0(List list, int i11, long j11, float f11, int i12, p4 p4Var, float f12, v1 v1Var, int i13) {
        this.f79220a.e().g(i11, list, D(this, j11, f11, 4.0f, i12, d5.f4505a.b(), p4Var, f12, v1Var, i13, 0, 512, null));
    }

    @Override // o0.n
    public /* synthetic */ long H(float f11) {
        return o0.m.b(this, f11);
    }

    @Override // z.g
    public d H0() {
        return this.f79221b;
    }

    @Override // o0.n
    public /* synthetic */ float J(long j11) {
        return o0.m.a(this, j11);
    }

    @Override // z.g
    public void K0(long j11, float f11, long j12, float f12, h hVar, v1 v1Var, int i11) {
        this.f79220a.e().r(j12, f11, v(this, j11, hVar, f12, v1Var, i11, 0, 32, null));
    }

    @Override // z.g
    public void L0(long j11, long j12, long j13, float f11, h hVar, v1 v1Var, int i11) {
        this.f79220a.e().f(y.g.m(j12), y.g.n(j12), y.g.m(j12) + y.m.i(j13), y.g.n(j12) + y.m.g(j13), v(this, j11, hVar, f11, v1Var, i11, 0, 32, null));
    }

    @Override // z.g
    public void N0(j1 j1Var, long j11, long j12, float f11, h hVar, v1 v1Var, int i11) {
        this.f79220a.e().f(y.g.m(j11), y.g.n(j11), y.g.m(j11) + y.m.i(j12), y.g.n(j11) + y.m.g(j12), B(this, j1Var, hVar, f11, v1Var, i11, 0, 32, null));
    }

    @Override // z.g
    public /* synthetic */ long O0() {
        return f.a(this);
    }

    @Override // o0.e
    public /* synthetic */ long Q(float f11) {
        return o0.d.g(this, f11);
    }

    @Override // o0.e
    public /* synthetic */ long Q0(long j11) {
        return o0.d.f(this, j11);
    }

    @Override // z.g
    public void T(long j11, long j12, long j13, long j14, h hVar, float f11, v1 v1Var, int i11) {
        this.f79220a.e().s(y.g.m(j12), y.g.n(j12), y.g.m(j12) + y.m.i(j13), y.g.n(j12) + y.m.g(j13), y.a.d(j14), y.a.e(j14), v(this, j11, hVar, f11, v1Var, i11, 0, 32, null));
    }

    @Override // z.g
    public void U0(e4 e4Var, long j11, long j12, long j13, long j14, float f11, h hVar, v1 v1Var, int i11, int i12) {
        this.f79220a.e().h(e4Var, j11, j12, j13, j14, z(null, hVar, f11, v1Var, i11, i12));
    }

    @Override // z.g
    public void V0(j1 j1Var, long j11, long j12, long j13, float f11, h hVar, v1 v1Var, int i11) {
        this.f79220a.e().s(y.g.m(j11), y.g.n(j11), y.g.m(j11) + y.m.i(j12), y.g.n(j11) + y.m.g(j12), y.a.d(j13), y.a.e(j13), B(this, j1Var, hVar, f11, v1Var, i11, 0, 32, null));
    }

    @Override // o0.e
    public /* synthetic */ int c0(float f11) {
        return o0.d.a(this, f11);
    }

    @Override // o0.e
    public float getDensity() {
        return this.f79220a.f().getDensity();
    }

    @Override // z.g
    public LayoutDirection getLayoutDirection() {
        return this.f79220a.g();
    }

    @Override // o0.e
    public /* synthetic */ float h0(long j11) {
        return o0.d.d(this, j11);
    }

    @Override // z.g
    public /* synthetic */ long i() {
        return f.b(this);
    }

    @Override // z.g
    public void i0(Path path, j1 j1Var, float f11, h hVar, v1 v1Var, int i11) {
        this.f79220a.e().q(path, B(this, j1Var, hVar, f11, v1Var, i11, 0, 32, null));
    }

    @Override // z.g
    public void q0(long j11, long j12, long j13, float f11, int i11, p4 p4Var, float f12, v1 v1Var, int i12) {
        this.f79220a.e().m(j12, j13, D(this, j11, f11, 4.0f, i11, d5.f4505a.b(), p4Var, f12, v1Var, i12, 0, 512, null));
    }

    @Override // o0.e
    public /* synthetic */ float x0(int i11) {
        return o0.d.c(this, i11);
    }

    @Override // o0.e
    public /* synthetic */ float y0(float f11) {
        return o0.d.b(this, f11);
    }
}
