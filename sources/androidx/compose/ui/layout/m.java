package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeCoordinator;

/* loaded from: classes.dex */
public abstract class m {
    public static final y.i a(l lVar) {
        y.i a11;
        l R = lVar.R();
        return (R == null || (a11 = k.a(R, lVar, false, 2, null)) == null) ? new y.i(0.0f, 0.0f, o0.t.g(lVar.k()), o0.t.f(lVar.k())) : a11;
    }

    public static final y.i b(l lVar) {
        return k.a(d(lVar), lVar, false, 2, null);
    }

    public static final y.i c(l lVar) {
        l d11 = d(lVar);
        float g11 = o0.t.g(d11.k());
        float f11 = o0.t.f(d11.k());
        y.i b11 = b(lVar);
        float f12 = b11.f();
        if (f12 < 0.0f) {
            f12 = 0.0f;
        }
        if (f12 > g11) {
            f12 = g11;
        }
        float i11 = b11.i();
        if (i11 < 0.0f) {
            i11 = 0.0f;
        }
        if (i11 > f11) {
            i11 = f11;
        }
        float g12 = b11.g();
        if (g12 < 0.0f) {
            g12 = 0.0f;
        }
        if (g12 <= g11) {
            g11 = g12;
        }
        float c11 = b11.c();
        float f13 = c11 >= 0.0f ? c11 : 0.0f;
        if (f13 <= f11) {
            f11 = f13;
        }
        if (f12 == g11 || i11 == f11) {
            return y.i.f78598e.a();
        }
        long L = d11.L(y.h.a(f12, i11));
        long L2 = d11.L(y.h.a(g11, i11));
        long L3 = d11.L(y.h.a(g11, f11));
        long L4 = d11.L(y.h.a(f12, f11));
        float m11 = y.g.m(L);
        float m12 = y.g.m(L2);
        float m13 = y.g.m(L4);
        float m14 = y.g.m(L3);
        float min = Math.min(m11, Math.min(m12, Math.min(m13, m14)));
        float max = Math.max(m11, Math.max(m12, Math.max(m13, m14)));
        float n11 = y.g.n(L);
        float n12 = y.g.n(L2);
        float n13 = y.g.n(L4);
        float n14 = y.g.n(L3);
        return new y.i(min, Math.min(n11, Math.min(n12, Math.min(n13, n14))), max, Math.max(n11, Math.max(n12, Math.max(n13, n14))));
    }

    public static final l d(l lVar) {
        l lVar2;
        l R = lVar.R();
        while (true) {
            l lVar3 = R;
            lVar2 = lVar;
            lVar = lVar3;
            if (lVar == null) {
                break;
            }
            R = lVar.R();
        }
        NodeCoordinator nodeCoordinator = lVar2 instanceof NodeCoordinator ? (NodeCoordinator) lVar2 : null;
        if (nodeCoordinator == null) {
            return lVar2;
        }
        NodeCoordinator a22 = nodeCoordinator.a2();
        while (true) {
            NodeCoordinator nodeCoordinator2 = a22;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            a22 = nodeCoordinator.a2();
        }
    }

    public static final long e(l lVar) {
        return lVar.Y(y.g.f78593b.c());
    }

    public static final long f(l lVar) {
        return lVar.L(y.g.f78593b.c());
    }
}
