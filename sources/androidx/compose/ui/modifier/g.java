package androidx.compose.ui.modifier;

import androidx.compose.ui.f;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;

/* loaded from: classes.dex */
public abstract /* synthetic */ class g {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v9 */
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
    public static Object a(h hVar, c cVar) {
        q0 e02;
        if (!hVar.getNode().k1()) {
            g0.a.a("ModifierLocal accessed from an unattached node");
        }
        int a11 = s0.a(32);
        if (!hVar.getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c h12 = hVar.getNode().h1();
        LayoutNode m11 = androidx.compose.ui.node.g.m(hVar);
        while (m11 != null) {
            if ((m11.e0().k().a1() & a11) != 0) {
                while (h12 != null) {
                    if ((h12.f1() & a11) != 0) {
                        androidx.compose.ui.node.i iVar = h12;
                        ?? r42 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof h) {
                                h hVar2 = (h) iVar;
                                if (hVar2.V().a(cVar)) {
                                    return hVar2.V().b(cVar);
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                                f.c E1 = iVar.E1();
                                int i11 = 0;
                                iVar = iVar;
                                r42 = r42;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        r42 = r42;
                                        if (i11 == 1) {
                                            iVar = E1;
                                        } else {
                                            if (r42 == 0) {
                                                r42 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (iVar != 0) {
                                                r42.b(iVar);
                                                iVar = 0;
                                            }
                                            r42.b(E1);
                                        }
                                    }
                                    E1 = E1.b1();
                                    iVar = iVar;
                                    r42 = r42;
                                }
                                if (i11 == 1) {
                                }
                            }
                            iVar = androidx.compose.ui.node.g.g(r42);
                        }
                    }
                    h12 = h12.h1();
                }
            }
            m11 = m11.h0();
            h12 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
        return cVar.a().invoke();
    }

    public static f b(h hVar) {
        return b.f5280a;
    }
}
