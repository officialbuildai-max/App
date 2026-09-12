package androidx.compose.ui.node;

import androidx.compose.ui.f;
import androidx.compose.ui.graphics.a4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class g {
    public static final /* synthetic */ f.c b(androidx.compose.runtime.collection.b bVar) {
        return g(bVar);
    }

    public static final void c(androidx.compose.runtime.collection.b bVar, f.c cVar) {
        androidx.compose.runtime.collection.b p02 = m(cVar).p0();
        int n11 = p02.n();
        if (n11 > 0) {
            int i11 = n11 - 1;
            Object[] m11 = p02.m();
            do {
                bVar.b(((LayoutNode) m11[i11]).e0().k());
                i11--;
            } while (i11 >= 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final x d(f.c cVar) {
        if ((s0.a(2) & cVar.f1()) != 0) {
            if (cVar instanceof x) {
                return (x) cVar;
            }
            if (cVar instanceof i) {
                f.c E1 = ((i) cVar).E1();
                while (E1 != 0) {
                    if (E1 instanceof x) {
                        return (x) E1;
                    }
                    E1 = (!(E1 instanceof i) || (s0.a(2) & E1.f1()) == 0) ? E1.b1() : ((i) E1).E1();
                }
            }
        }
        return null;
    }

    public static final boolean e(f fVar, int i11) {
        return (fVar.getNode().a1() & i11) != 0;
    }

    public static final boolean f(f fVar) {
        return fVar.getNode() == fVar;
    }

    public static final f.c g(androidx.compose.runtime.collection.b bVar) {
        if (bVar == null || bVar.p()) {
            return null;
        }
        return (f.c) bVar.v(bVar.n() - 1);
    }

    public static final NodeCoordinator h(f fVar, int i11) {
        NodeCoordinator c12 = fVar.getNode().c1();
        Intrinsics.e(c12);
        if (c12.Y1() != fVar || !t0.i(i11)) {
            return c12;
        }
        NodeCoordinator Z1 = c12.Z1();
        Intrinsics.e(Z1);
        return Z1;
    }

    public static final o0.e i(f fVar) {
        return m(fVar).H();
    }

    public static final a4 j(f fVar) {
        return n(fVar).getGraphicsContext();
    }

    public static final androidx.compose.ui.layout.l k(f fVar) {
        if (!fVar.getNode().k1()) {
            g0.a.b("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        androidx.compose.ui.layout.l X0 = h(fVar, s0.a(2)).X0();
        if (!X0.F()) {
            g0.a.b("LayoutCoordinates is not attached.");
        }
        return X0;
    }

    public static final LayoutDirection l(f fVar) {
        return m(fVar).getLayoutDirection();
    }

    public static final LayoutNode m(f fVar) {
        NodeCoordinator c12 = fVar.getNode().c1();
        if (c12 != null) {
            return c12.a1();
        }
        g0.a.c("Cannot obtain node coordinator. Is the Modifier.Node attached?");
        throw new KotlinNothingValueException();
    }

    public static final y0 n(f fVar) {
        y0 g02 = m(fVar).g0();
        if (g02 != null) {
            return g02;
        }
        g0.a.c("This node does not have an owner.");
        throw new KotlinNothingValueException();
    }
}
