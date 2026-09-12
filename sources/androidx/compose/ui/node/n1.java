package androidx.compose.ui.node;

import androidx.compose.ui.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class n1 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r3v9 */
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
    public static final m1 a(f fVar, Object obj) {
        q0 e02;
        int a11 = s0.a(262144);
        if (!fVar.getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c h12 = fVar.getNode().h1();
        LayoutNode m11 = g.m(fVar);
        while (m11 != null) {
            if ((m11.e0().k().a1() & a11) != 0) {
                while (h12 != null) {
                    if ((h12.f1() & a11) != 0) {
                        i iVar = h12;
                        ?? r42 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof m1) {
                                m1 m1Var = (m1) iVar;
                                if (Intrinsics.c(obj, m1Var.D())) {
                                    return m1Var;
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
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
                            iVar = g.g(r42);
                        }
                    }
                    h12 = h12.h1();
                }
            }
            m11 = m11.h0();
            h12 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static final m1 b(m1 m1Var) {
        q0 e02;
        int a11 = s0.a(262144);
        if (!m1Var.getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c h12 = m1Var.getNode().h1();
        LayoutNode m11 = g.m(m1Var);
        while (m11 != null) {
            if ((m11.e0().k().a1() & a11) != 0) {
                while (h12 != null) {
                    if ((h12.f1() & a11) != 0) {
                        i iVar = h12;
                        ?? r52 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof m1) {
                                m1 m1Var2 = (m1) iVar;
                                if (Intrinsics.c(m1Var.D(), m1Var2.D()) && androidx.compose.ui.a.a(m1Var, m1Var2)) {
                                    return m1Var2;
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                                f.c E1 = iVar.E1();
                                int i11 = 0;
                                iVar = iVar;
                                r52 = r52;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        r52 = r52;
                                        if (i11 == 1) {
                                            iVar = E1;
                                        } else {
                                            if (r52 == 0) {
                                                r52 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (iVar != 0) {
                                                r52.b(iVar);
                                                iVar = 0;
                                            }
                                            r52.b(E1);
                                        }
                                    }
                                    E1 = E1.b1();
                                    iVar = iVar;
                                    r52 = r52;
                                }
                                if (i11 == 1) {
                                }
                            }
                            iVar = g.g(r52);
                        }
                    }
                    h12 = h12.h1();
                }
            }
            m11 = m11.h0();
            h12 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.f$c] */
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
    public static final void c(f fVar, Object obj, Function1 function1) {
        q0 e02;
        int a11 = s0.a(262144);
        if (!fVar.getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c h12 = fVar.getNode().h1();
        LayoutNode m11 = g.m(fVar);
        while (m11 != null) {
            if ((m11.e0().k().a1() & a11) != 0) {
                while (h12 != null) {
                    if ((h12.f1() & a11) != 0) {
                        i iVar = h12;
                        ?? r42 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof m1) {
                                m1 m1Var = (m1) iVar;
                                if (!(Intrinsics.c(obj, m1Var.D()) ? ((Boolean) function1.invoke(m1Var)).booleanValue() : true)) {
                                    return;
                                }
                            } else {
                                if (((iVar.f1() & a11) != 0) && (iVar instanceof i)) {
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
                            }
                            iVar = g.g(r42);
                        }
                    }
                    h12 = h12.h1();
                }
            }
            m11 = m11.h0();
            h12 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static final void d(f fVar, Object obj, Function1 function1) {
        int a11 = s0.a(262144);
        if (!fVar.getNode().k1()) {
            g0.a.b("visitSubtreeIf called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new f.c[16], 0);
        f.c b12 = fVar.getNode().b1();
        if (b12 == null) {
            g.c(bVar, fVar.getNode());
        } else {
            bVar.b(b12);
        }
        while (bVar.q()) {
            f.c cVar = (f.c) bVar.v(bVar.n() - 1);
            if ((cVar.a1() & a11) != 0) {
                for (f.c cVar2 = cVar; cVar2 != null; cVar2 = cVar2.b1()) {
                    if ((cVar2.f1() & a11) != 0) {
                        i iVar = cVar2;
                        ?? r82 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof m1) {
                                m1 m1Var = (m1) iVar;
                                TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = Intrinsics.c(obj, m1Var.D()) ? (TraversableNode$Companion$TraverseDescendantsAction) function1.invoke(m1Var) : TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                                if (traversableNode$Companion$TraverseDescendantsAction == TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traversableNode$Companion$TraverseDescendantsAction == TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                    break;
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                                f.c E1 = iVar.E1();
                                int i11 = 0;
                                iVar = iVar;
                                r82 = r82;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        r82 = r82;
                                        if (i11 == 1) {
                                            iVar = E1;
                                        } else {
                                            if (r82 == 0) {
                                                r82 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (iVar != 0) {
                                                r82.b(iVar);
                                                iVar = 0;
                                            }
                                            r82.b(E1);
                                        }
                                    }
                                    E1 = E1.b1();
                                    iVar = iVar;
                                    r82 = r82;
                                }
                                if (i11 == 1) {
                                }
                            }
                            iVar = g.g(r82);
                        }
                    }
                }
            }
            g.c(bVar, cVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static final void e(m1 m1Var, Function1 function1) {
        int a11 = s0.a(262144);
        if (!m1Var.getNode().k1()) {
            g0.a.b("visitSubtreeIf called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new f.c[16], 0);
        f.c b12 = m1Var.getNode().b1();
        if (b12 == null) {
            g.c(bVar, m1Var.getNode());
        } else {
            bVar.b(b12);
        }
        while (bVar.q()) {
            f.c cVar = (f.c) bVar.v(bVar.n() - 1);
            if ((cVar.a1() & a11) != 0) {
                for (f.c cVar2 = cVar; cVar2 != null; cVar2 = cVar2.b1()) {
                    if ((cVar2.f1() & a11) != 0) {
                        i iVar = cVar2;
                        ?? r92 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof m1) {
                                m1 m1Var2 = (m1) iVar;
                                TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = (Intrinsics.c(m1Var.D(), m1Var2.D()) && androidx.compose.ui.a.a(m1Var, m1Var2)) ? (TraversableNode$Companion$TraverseDescendantsAction) function1.invoke(m1Var2) : TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                                if (traversableNode$Companion$TraverseDescendantsAction == TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traversableNode$Companion$TraverseDescendantsAction == TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                    break;
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                                f.c E1 = iVar.E1();
                                int i11 = 0;
                                iVar = iVar;
                                r92 = r92;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        r92 = r92;
                                        if (i11 == 1) {
                                            iVar = E1;
                                        } else {
                                            if (r92 == 0) {
                                                r92 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (iVar != 0) {
                                                r92.b(iVar);
                                                iVar = 0;
                                            }
                                            r92.b(E1);
                                        }
                                    }
                                    E1 = E1.b1();
                                    iVar = iVar;
                                    r92 = r92;
                                }
                                if (i11 == 1) {
                                }
                            }
                            iVar = g.g(r92);
                        }
                    }
                }
            }
            g.c(bVar, cVar);
        }
    }
}
