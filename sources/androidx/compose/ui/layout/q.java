package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.jvm.internal.Intrinsics;
import y.g;

/* loaded from: classes.dex */
public final class q implements l {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.node.j0 f5272a;

    public q(androidx.compose.ui.node.j0 j0Var) {
        this.f5272a = j0Var;
    }

    private final long b() {
        androidx.compose.ui.node.j0 a11 = r.a(this.f5272a);
        l X0 = a11.X0();
        g.a aVar = y.g.f78593b;
        return y.g.q(C(X0, aVar.c()), a().C(a11.v1(), aVar.c()));
    }

    @Override // androidx.compose.ui.layout.l
    public long B(l lVar, long j11, boolean z10) {
        if (!(lVar instanceof q)) {
            androidx.compose.ui.node.j0 a11 = r.a(this.f5272a);
            return y.g.r(B(a11.w1(), j11, z10), a11.v1().X0().B(lVar, y.g.f78593b.c(), z10));
        }
        androidx.compose.ui.node.j0 j0Var = ((q) lVar).f5272a;
        j0Var.v1().n2();
        androidx.compose.ui.node.j0 U1 = a().L1(j0Var.v1()).U1();
        if (U1 != null) {
            long k11 = o0.p.k(o0.p.l(j0Var.A1(U1, !z10), o0.q.d(j11)), this.f5272a.A1(U1, !z10));
            return y.h.a(o0.p.h(k11), o0.p.i(k11));
        }
        androidx.compose.ui.node.j0 a12 = r.a(j0Var);
        long l11 = o0.p.l(o0.p.l(j0Var.A1(a12, !z10), a12.e1()), o0.q.d(j11));
        androidx.compose.ui.node.j0 a13 = r.a(this.f5272a);
        long k12 = o0.p.k(l11, o0.p.l(this.f5272a.A1(a13, !z10), a13.e1()));
        long a14 = y.h.a(o0.p.h(k12), o0.p.i(k12));
        NodeCoordinator a22 = a13.v1().a2();
        Intrinsics.e(a22);
        NodeCoordinator a23 = a12.v1().a2();
        Intrinsics.e(a23);
        return a22.B(a23, a14, z10);
    }

    @Override // androidx.compose.ui.layout.l
    public long C(l lVar, long j11) {
        return B(lVar, j11, true);
    }

    @Override // androidx.compose.ui.layout.l
    public boolean F() {
        return a().F();
    }

    @Override // androidx.compose.ui.layout.l
    public long L(long j11) {
        return a().L(y.g.r(j11, b()));
    }

    @Override // androidx.compose.ui.layout.l
    public y.i O(l lVar, boolean z10) {
        return a().O(lVar, z10);
    }

    @Override // androidx.compose.ui.layout.l
    public l R() {
        androidx.compose.ui.node.j0 U1;
        if (!F()) {
            g0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator a22 = a().a1().f0().a2();
        if (a22 == null || (U1 = a22.U1()) == null) {
            return null;
        }
        return U1.X0();
    }

    @Override // androidx.compose.ui.layout.l
    public long Y(long j11) {
        return a().Y(y.g.r(j11, b()));
    }

    public final NodeCoordinator a() {
        return this.f5272a.v1();
    }

    @Override // androidx.compose.ui.layout.l
    public long k() {
        androidx.compose.ui.node.j0 j0Var = this.f5272a;
        return o0.u.a(j0Var.u0(), j0Var.l0());
    }
}
