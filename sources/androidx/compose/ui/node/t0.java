package androidx.compose.ui.node;

import androidx.compose.ui.f;
import androidx.compose.ui.focus.FocusTargetNode;

/* loaded from: classes.dex */
public abstract class t0 {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.collection.k0 f5525a = androidx.collection.q0.b();

    public static final void a(f.c cVar) {
        if (!cVar.k1()) {
            g0.a.b("autoInvalidateInsertedNode called on unattached node");
        }
        b(cVar, -1, 1);
    }

    public static final void b(f.c cVar, int i11, int i12) {
        if (!(cVar instanceof i)) {
            c(cVar, i11 & cVar.f1(), i12);
            return;
        }
        i iVar = (i) cVar;
        c(cVar, iVar.F1() & i11, i12);
        int i13 = (~iVar.F1()) & i11;
        for (f.c E1 = iVar.E1(); E1 != null; E1 = E1.b1()) {
            b(E1, i13, i12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void c(f.c cVar, int i11, int i12) {
        if (i12 != 0 || cVar.i1()) {
            if ((s0.a(2) & i11) != 0 && (cVar instanceof x)) {
                a0.b((x) cVar);
                if (i12 == 2) {
                    g.h(cVar, s0.a(2)).t2();
                }
            }
            if ((s0.a(128) & i11) != 0 && (cVar instanceof w) && i12 != 2) {
                g.m(cVar).y0();
            }
            if ((s0.a(256) & i11) != 0 && (cVar instanceof p) && i12 != 2) {
                g.m(cVar).z0();
            }
            if ((s0.a(4) & i11) != 0 && (cVar instanceof n)) {
                o.a((n) cVar);
            }
            if ((s0.a(8) & i11) != 0 && (cVar instanceof i1)) {
                j1.b((i1) cVar);
            }
            if ((s0.a(64) & i11) != 0 && (cVar instanceof a1)) {
                b1.a((a1) cVar);
            }
            if ((s0.a(1024) & i11) != 0 && (cVar instanceof FocusTargetNode) && i12 != 2) {
                androidx.compose.ui.focus.u.c((FocusTargetNode) cVar);
            }
            if ((s0.a(2048) & i11) != 0 && (cVar instanceof androidx.compose.ui.focus.m)) {
                androidx.compose.ui.focus.m mVar = (androidx.compose.ui.focus.m) cVar;
                if (k(mVar)) {
                    if (i12 == 2) {
                        j(mVar);
                    } else {
                        androidx.compose.ui.focus.n.a(mVar);
                    }
                }
            }
            if ((i11 & s0.a(4096)) == 0 || !(cVar instanceof androidx.compose.ui.focus.c)) {
                return;
            }
            androidx.compose.ui.focus.d.b((androidx.compose.ui.focus.c) cVar);
        }
    }

    public static final void d(f.c cVar) {
        if (!cVar.k1()) {
            g0.a.b("autoInvalidateRemovedNode called on unattached node");
        }
        b(cVar, -1, 2);
    }

    public static final void e(f.c cVar) {
        if (!cVar.k1()) {
            g0.a.b("autoInvalidateUpdatedNode called on unattached node");
        }
        b(cVar, -1, 0);
    }

    public static final int f(f.b bVar) {
        int a11 = s0.a(1);
        if (bVar instanceof androidx.compose.ui.layout.o) {
            a11 |= s0.a(2);
        }
        if (bVar instanceof androidx.compose.ui.draw.f) {
            a11 |= s0.a(4);
        }
        if (bVar instanceof androidx.compose.ui.semantics.j) {
            a11 |= s0.a(8);
        }
        if (bVar instanceof androidx.compose.ui.input.pointer.d0) {
            a11 |= s0.a(16);
        }
        if ((bVar instanceof androidx.compose.ui.modifier.d) || (bVar instanceof androidx.compose.ui.modifier.j)) {
            a11 |= s0.a(32);
        }
        return bVar instanceof androidx.compose.ui.layout.b0 ? a11 | s0.a(256) : a11;
    }

    public static final int g(f.c cVar) {
        if (cVar.f1() != 0) {
            return cVar.f1();
        }
        androidx.collection.k0 k0Var = f5525a;
        Object b11 = androidx.compose.ui.a.b(cVar);
        int a11 = k0Var.a(b11);
        if (a11 >= 0) {
            return k0Var.f2391c[a11];
        }
        int a12 = s0.a(1);
        if (cVar instanceof x) {
            a12 |= s0.a(2);
        }
        if (cVar instanceof n) {
            a12 |= s0.a(4);
        }
        if (cVar instanceof i1) {
            a12 |= s0.a(8);
        }
        if (cVar instanceof e1) {
            a12 |= s0.a(16);
        }
        if (cVar instanceof androidx.compose.ui.modifier.h) {
            a12 |= s0.a(32);
        }
        if (cVar instanceof a1) {
            a12 |= s0.a(64);
        }
        if (cVar instanceof w) {
            a12 |= s0.a(128);
        }
        if (cVar instanceof p) {
            a12 |= s0.a(256);
        }
        if (cVar instanceof FocusTargetNode) {
            a12 |= s0.a(1024);
        }
        if (cVar instanceof androidx.compose.ui.focus.m) {
            a12 |= s0.a(2048);
        }
        if (cVar instanceof androidx.compose.ui.focus.c) {
            a12 |= s0.a(4096);
        }
        if (cVar instanceof d0.e) {
            a12 |= s0.a(8192);
        }
        if (cVar instanceof f0.a) {
            a12 |= s0.a(16384);
        }
        if (cVar instanceof d) {
            a12 |= s0.a(32768);
        }
        int a13 = cVar instanceof m1 ? s0.a(262144) | a12 : a12;
        k0Var.r(b11, a13);
        return a13;
    }

    public static final int h(f.c cVar) {
        if (!(cVar instanceof i)) {
            return g(cVar);
        }
        i iVar = (i) cVar;
        int F1 = iVar.F1();
        for (f.c E1 = iVar.E1(); E1 != null; E1 = E1.b1()) {
            F1 |= h(E1);
        }
        return F1;
    }

    public static final boolean i(int i11) {
        return (i11 & s0.a(128)) != 0;
    }

    private static final void j(androidx.compose.ui.focus.m mVar) {
        int a11 = s0.a(1024);
        if (!mVar.getNode().k1()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new f.c[16], 0);
        f.c b12 = mVar.getNode().b1();
        if (b12 == null) {
            g.c(bVar, mVar.getNode());
        } else {
            bVar.b(b12);
        }
        while (bVar.q()) {
            f.c cVar = (f.c) bVar.v(bVar.n() - 1);
            if ((cVar.a1() & a11) == 0) {
                g.c(bVar, cVar);
            } else {
                while (true) {
                    if (cVar == null) {
                        break;
                    }
                    if ((cVar.f1() & a11) != 0) {
                        androidx.compose.runtime.collection.b bVar2 = null;
                        while (cVar != null) {
                            if (cVar instanceof FocusTargetNode) {
                                androidx.compose.ui.focus.u.c((FocusTargetNode) cVar);
                            } else if ((cVar.f1() & a11) != 0 && (cVar instanceof i)) {
                                int i11 = 0;
                                for (f.c E1 = ((i) cVar).E1(); E1 != null; E1 = E1.b1()) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            cVar = E1;
                                        } else {
                                            if (bVar2 == null) {
                                                bVar2 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (cVar != null) {
                                                bVar2.b(cVar);
                                                cVar = null;
                                            }
                                            bVar2.b(E1);
                                        }
                                    }
                                }
                                if (i11 == 1) {
                                }
                            }
                            cVar = g.g(bVar2);
                        }
                    } else {
                        cVar = cVar.b1();
                    }
                }
            }
        }
    }

    private static final boolean k(androidx.compose.ui.focus.m mVar) {
        b bVar = b.f5455a;
        bVar.b();
        mVar.r0(bVar);
        return bVar.a();
    }
}
