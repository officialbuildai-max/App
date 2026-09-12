package androidx.compose.ui.node;

import androidx.compose.ui.f;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.p4;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class d0 implements z.g, z.c {

    /* renamed from: a, reason: collision with root package name */
    private final z.a f5459a;

    /* renamed from: b, reason: collision with root package name */
    private n f5460b;

    /* JADX WARN: Multi-variable type inference failed */
    public d0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public d0(z.a aVar) {
        this.f5459a = aVar;
    }

    public /* synthetic */ d0(z.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new z.a() : aVar);
    }

    @Override // o0.n
    public float C0() {
        return this.f5459a.C0();
    }

    @Override // z.g
    public void D0(Path path, long j11, float f11, z.h hVar, v1 v1Var, int i11) {
        this.f5459a.D0(path, j11, f11, hVar, v1Var, i11);
    }

    @Override // o0.e
    public float E0(float f11) {
        return this.f5459a.E0(f11);
    }

    @Override // z.g
    public void G0(List list, int i11, long j11, float f11, int i12, p4 p4Var, float f12, v1 v1Var, int i13) {
        this.f5459a.G0(list, i11, j11, f11, i12, p4Var, f12, v1Var, i13);
    }

    @Override // o0.n
    public long H(float f11) {
        return this.f5459a.H(f11);
    }

    @Override // z.g
    public z.d H0() {
        return this.f5459a.H0();
    }

    @Override // o0.n
    public float J(long j11) {
        return this.f5459a.J(j11);
    }

    @Override // z.g
    public void K0(long j11, float f11, long j12, float f12, z.h hVar, v1 v1Var, int i11) {
        this.f5459a.K0(j11, f11, j12, f12, hVar, v1Var, i11);
    }

    @Override // z.g
    public void L0(long j11, long j12, long j13, float f11, z.h hVar, v1 v1Var, int i11) {
        this.f5459a.L0(j11, j12, j13, f11, hVar, v1Var, i11);
    }

    @Override // z.g
    public void N0(androidx.compose.ui.graphics.j1 j1Var, long j11, long j12, float f11, z.h hVar, v1 v1Var, int i11) {
        this.f5459a.N0(j1Var, j11, j12, f11, hVar, v1Var, i11);
    }

    @Override // z.g
    public long O0() {
        return this.f5459a.O0();
    }

    @Override // o0.e
    public long Q(float f11) {
        return this.f5459a.Q(f11);
    }

    @Override // o0.e
    public long Q0(long j11) {
        return this.f5459a.Q0(j11);
    }

    @Override // z.g
    public void T(long j11, long j12, long j13, long j14, z.h hVar, float f11, v1 v1Var, int i11) {
        this.f5459a.T(j11, j12, j13, j14, hVar, f11, v1Var, i11);
    }

    @Override // z.g
    public void U0(e4 e4Var, long j11, long j12, long j13, long j14, float f11, z.h hVar, v1 v1Var, int i11, int i12) {
        this.f5459a.U0(e4Var, j11, j12, j13, j14, f11, hVar, v1Var, i11, i12);
    }

    @Override // z.g
    public void V0(androidx.compose.ui.graphics.j1 j1Var, long j11, long j12, long j13, float f11, z.h hVar, v1 v1Var, int i11) {
        this.f5459a.V0(j1Var, j11, j12, j13, f11, hVar, v1Var, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // z.c
    public void Y0() {
        i b11;
        androidx.compose.ui.graphics.m1 e11 = H0().e();
        n nVar = this.f5460b;
        Intrinsics.e(nVar);
        b11 = e0.b(nVar);
        if (b11 == 0) {
            NodeCoordinator h11 = g.h(nVar, s0.a(4));
            if (h11.Y1() == nVar.getNode()) {
                h11 = h11.Z1();
                Intrinsics.e(h11);
            }
            h11.u2(e11, H0().g());
            return;
        }
        int a11 = s0.a(4);
        ?? r42 = 0;
        while (b11 != 0) {
            if (b11 instanceof n) {
                z((n) b11, e11, H0().g());
            } else if ((b11.f1() & a11) != 0 && (b11 instanceof i)) {
                f.c E1 = b11.E1();
                int i11 = 0;
                b11 = b11;
                r42 = r42;
                while (E1 != null) {
                    if ((E1.f1() & a11) != 0) {
                        i11++;
                        r42 = r42;
                        if (i11 == 1) {
                            b11 = E1;
                        } else {
                            if (r42 == 0) {
                                r42 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                            }
                            if (b11 != 0) {
                                r42.b(b11);
                                b11 = 0;
                            }
                            r42.b(E1);
                        }
                    }
                    E1 = E1.b1();
                    b11 = b11;
                    r42 = r42;
                }
                if (i11 == 1) {
                }
            }
            b11 = g.g(r42);
        }
    }

    @Override // o0.e
    public int c0(float f11) {
        return this.f5459a.c0(f11);
    }

    @Override // o0.e
    public float getDensity() {
        return this.f5459a.getDensity();
    }

    @Override // z.g
    public LayoutDirection getLayoutDirection() {
        return this.f5459a.getLayoutDirection();
    }

    @Override // o0.e
    public float h0(long j11) {
        return this.f5459a.h0(j11);
    }

    @Override // z.g
    public long i() {
        return this.f5459a.i();
    }

    @Override // z.g
    public void i0(Path path, androidx.compose.ui.graphics.j1 j1Var, float f11, z.h hVar, v1 v1Var, int i11) {
        this.f5459a.i0(path, j1Var, f11, hVar, v1Var, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void n(androidx.compose.ui.graphics.m1 m1Var, long j11, NodeCoordinator nodeCoordinator, f.c cVar, GraphicsLayer graphicsLayer) {
        int a11 = s0.a(4);
        i iVar = cVar;
        ?? r32 = 0;
        while (iVar != 0) {
            if (iVar instanceof n) {
                v(m1Var, j11, nodeCoordinator, iVar, graphicsLayer);
            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                f.c E1 = iVar.E1();
                int i11 = 0;
                iVar = iVar;
                r32 = r32;
                while (E1 != null) {
                    if ((E1.f1() & a11) != 0) {
                        i11++;
                        r32 = r32;
                        if (i11 == 1) {
                            iVar = E1;
                        } else {
                            if (r32 == 0) {
                                r32 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                            }
                            if (iVar != 0) {
                                r32.b(iVar);
                                iVar = 0;
                            }
                            r32.b(E1);
                        }
                    }
                    E1 = E1.b1();
                    iVar = iVar;
                    r32 = r32;
                }
                if (i11 == 1) {
                }
            }
            iVar = g.g(r32);
        }
    }

    @Override // z.g
    public void q0(long j11, long j12, long j13, float f11, int i11, p4 p4Var, float f12, v1 v1Var, int i12) {
        this.f5459a.q0(j11, j12, j13, f11, i11, p4Var, f12, v1Var, i12);
    }

    public final void v(androidx.compose.ui.graphics.m1 m1Var, long j11, NodeCoordinator nodeCoordinator, n nVar, GraphicsLayer graphicsLayer) {
        n nVar2 = this.f5460b;
        this.f5460b = nVar;
        z.a aVar = this.f5459a;
        LayoutDirection layoutDirection = nodeCoordinator.getLayoutDirection();
        o0.e density = aVar.H0().getDensity();
        LayoutDirection layoutDirection2 = aVar.H0().getLayoutDirection();
        androidx.compose.ui.graphics.m1 e11 = aVar.H0().e();
        long i11 = aVar.H0().i();
        GraphicsLayer g11 = aVar.H0().g();
        z.d H0 = aVar.H0();
        H0.b(nodeCoordinator);
        H0.a(layoutDirection);
        H0.h(m1Var);
        H0.f(j11);
        H0.d(graphicsLayer);
        m1Var.n();
        try {
            nVar.n(this);
            m1Var.j();
            z.d H02 = aVar.H0();
            H02.b(density);
            H02.a(layoutDirection2);
            H02.h(e11);
            H02.f(i11);
            H02.d(g11);
            this.f5460b = nVar2;
        } catch (Throwable th2) {
            m1Var.j();
            z.d H03 = aVar.H0();
            H03.b(density);
            H03.a(layoutDirection2);
            H03.h(e11);
            H03.f(i11);
            H03.d(g11);
            throw th2;
        }
    }

    @Override // o0.e
    public float x0(int i11) {
        return this.f5459a.x0(i11);
    }

    @Override // o0.e
    public float y0(float f11) {
        return this.f5459a.y0(f11);
    }

    public final void z(n nVar, androidx.compose.ui.graphics.m1 m1Var, GraphicsLayer graphicsLayer) {
        NodeCoordinator h11 = g.h(nVar, s0.a(4));
        h11.a1().W().v(m1Var, o0.u.d(h11.k()), h11, nVar, graphicsLayer);
    }
}
