package androidx.compose.ui.focus;

import androidx.compose.ui.f;
import androidx.compose.ui.focus.b;
import androidx.compose.ui.layout.d;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class a {
    public static final Object a(FocusTargetNode focusTargetNode, int i11, Function1 function1) {
        f.c cVar;
        androidx.compose.ui.layout.d J1;
        int c11;
        q0 e02;
        int a11 = s0.a(1024);
        if (!focusTargetNode.getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c h12 = focusTargetNode.getNode().h1();
        LayoutNode m11 = androidx.compose.ui.node.g.m(focusTargetNode);
        loop0: while (true) {
            if (m11 == null) {
                cVar = null;
                break;
            }
            if ((m11.e0().k().a1() & a11) != 0) {
                while (h12 != null) {
                    if ((h12.f1() & a11) != 0) {
                        cVar = h12;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVar != null) {
                            if (cVar instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((cVar.f1() & a11) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
                                int i12 = 0;
                                for (f.c E1 = ((androidx.compose.ui.node.i) cVar).E1(); E1 != null; E1 = E1.b1()) {
                                    if ((E1.f1() & a11) != 0) {
                                        i12++;
                                        if (i12 == 1) {
                                            cVar = E1;
                                        } else {
                                            if (bVar == null) {
                                                bVar = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (cVar != null) {
                                                bVar.b(cVar);
                                                cVar = null;
                                            }
                                            bVar.b(E1);
                                        }
                                    }
                                }
                                if (i12 == 1) {
                                }
                            }
                            cVar = androidx.compose.ui.node.g.g(bVar);
                        }
                    }
                    h12 = h12.h1();
                }
            }
            m11 = m11.h0();
            h12 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVar;
        if ((focusTargetNode2 != null && Intrinsics.c(focusTargetNode2.J1(), focusTargetNode.J1())) || (J1 = focusTargetNode.J1()) == null) {
            return null;
        }
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.h())) {
            c11 = d.b.f5243a.a();
        } else if (b.l(i11, aVar.a())) {
            c11 = d.b.f5243a.d();
        } else if (b.l(i11, aVar.d())) {
            c11 = d.b.f5243a.e();
        } else if (b.l(i11, aVar.g())) {
            c11 = d.b.f5243a.f();
        } else if (b.l(i11, aVar.e())) {
            c11 = d.b.f5243a.b();
        } else {
            if (!b.l(i11, aVar.f())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout");
            }
            c11 = d.b.f5243a.c();
        }
        return J1.a(c11, function1);
    }
}
