package androidx.compose.ui.node;

import androidx.compose.ui.f;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class i extends f.c {

    /* renamed from: n, reason: collision with root package name */
    private final int f5465n = t0.g(this);

    /* renamed from: o, reason: collision with root package name */
    private f.c f5466o;

    private final void H1(int i11, boolean z10) {
        f.c b12;
        int f12 = f1();
        x1(i11);
        if (f12 != i11) {
            if (g.f(this)) {
                t1(i11);
            }
            if (k1()) {
                f.c node = getNode();
                f.c cVar = this;
                while (cVar != null) {
                    i11 |= cVar.f1();
                    cVar.x1(i11);
                    if (cVar == node) {
                        break;
                    } else {
                        cVar = cVar.h1();
                    }
                }
                if (z10 && cVar == node) {
                    i11 = t0.h(node);
                    node.x1(i11);
                }
                int a12 = i11 | ((cVar == null || (b12 = cVar.b1()) == null) ? 0 : b12.a1());
                while (cVar != null) {
                    a12 |= cVar.f1();
                    cVar.t1(a12);
                    cVar = cVar.h1();
                }
            }
        }
    }

    private final void I1(int i11, f.c cVar) {
        int f12 = f1();
        if ((i11 & s0.a(2)) == 0 || (s0.a(2) & f12) == 0 || (this instanceof x)) {
            return;
        }
        g0.a.b("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + cVar);
    }

    @Override // androidx.compose.ui.f.c
    public void C1(NodeCoordinator nodeCoordinator) {
        super.C1(nodeCoordinator);
        for (f.c E1 = E1(); E1 != null; E1 = E1.b1()) {
            E1.C1(nodeCoordinator);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f D1(f fVar) {
        f.c node = fVar.getNode();
        if (node != fVar) {
            f.c cVar = fVar instanceof f.c ? (f.c) fVar : null;
            f.c h12 = cVar != null ? cVar.h1() : null;
            if (node == getNode() && Intrinsics.c(h12, this)) {
                return fVar;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node");
        }
        if (node.k1()) {
            g0.a.b("Cannot delegate to an already attached node");
        }
        node.u1(getNode());
        int f12 = f1();
        int h11 = t0.h(node);
        node.x1(h11);
        I1(h11, node);
        node.v1(this.f5466o);
        this.f5466o = node;
        node.z1(this);
        H1(f1() | h11, false);
        if (k1()) {
            if ((h11 & s0.a(2)) == 0 || (f12 & s0.a(2)) != 0) {
                C1(c1());
            } else {
                q0 e02 = g.m(this).e0();
                getNode().C1(null);
                e02.C();
            }
            node.l1();
            node.r1();
            t0.a(node);
        }
        return fVar;
    }

    public final f.c E1() {
        return this.f5466o;
    }

    public final int F1() {
        return this.f5465n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G1(f fVar) {
        f.c cVar = null;
        for (f.c cVar2 = this.f5466o; cVar2 != null; cVar2 = cVar2.b1()) {
            if (cVar2 == fVar) {
                if (cVar2.k1()) {
                    t0.d(cVar2);
                    cVar2.s1();
                    cVar2.m1();
                }
                cVar2.u1(cVar2);
                cVar2.t1(0);
                if (cVar == null) {
                    this.f5466o = cVar2.b1();
                } else {
                    cVar.v1(cVar2.b1());
                }
                cVar2.v1(null);
                cVar2.z1(null);
                int f12 = f1();
                int h11 = t0.h(this);
                H1(h11, true);
                if (k1() && (f12 & s0.a(2)) != 0 && (s0.a(2) & h11) == 0) {
                    q0 e02 = g.m(this).e0();
                    getNode().C1(null);
                    e02.C();
                    return;
                }
                return;
            }
            cVar = cVar2;
        }
        throw new IllegalStateException(("Could not find delegate: " + fVar).toString());
    }

    @Override // androidx.compose.ui.f.c
    public void l1() {
        super.l1();
        for (f.c E1 = E1(); E1 != null; E1 = E1.b1()) {
            E1.C1(c1());
            if (!E1.k1()) {
                E1.l1();
            }
        }
    }

    @Override // androidx.compose.ui.f.c
    public void m1() {
        for (f.c E1 = E1(); E1 != null; E1 = E1.b1()) {
            E1.m1();
        }
        super.m1();
    }

    @Override // androidx.compose.ui.f.c
    public void q1() {
        super.q1();
        for (f.c E1 = E1(); E1 != null; E1 = E1.b1()) {
            E1.q1();
        }
    }

    @Override // androidx.compose.ui.f.c
    public void r1() {
        for (f.c E1 = E1(); E1 != null; E1 = E1.b1()) {
            E1.r1();
        }
        super.r1();
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        super.s1();
        for (f.c E1 = E1(); E1 != null; E1 = E1.b1()) {
            E1.s1();
        }
    }

    @Override // androidx.compose.ui.f.c
    public void u1(f.c cVar) {
        super.u1(cVar);
        for (f.c E1 = E1(); E1 != null; E1 = E1.b1()) {
            E1.u1(cVar);
        }
    }
}
