package androidx.compose.ui.semantics;

import androidx.compose.ui.f;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes.dex */
public abstract class l {
    public static final SemanticsNode a(LayoutNode layoutNode, boolean z10) {
        int i11;
        q0 e02 = layoutNode.e0();
        int a11 = s0.a(8);
        i11 = e02.i();
        Object obj = null;
        if ((i11 & a11) != 0) {
            f.c k11 = e02.k();
            loop0: while (true) {
                if (k11 == null) {
                    break;
                }
                if ((k11.f1() & a11) != 0) {
                    f.c cVar = k11;
                    androidx.compose.runtime.collection.b bVar = null;
                    while (cVar != null) {
                        if (cVar instanceof i1) {
                            obj = cVar;
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
                if ((k11.a1() & a11) == 0) {
                    break;
                }
                k11 = k11.b1();
            }
        }
        Intrinsics.e(obj);
        f.c node = ((i1) obj).getNode();
        i F = layoutNode.F();
        Intrinsics.e(F);
        return new SemanticsNode(node, z10, layoutNode, F);
    }

    public static final int e(SemanticsNode semanticsNode) {
        return semanticsNode.o() + 2000000000;
    }

    public static final LayoutNode f(LayoutNode layoutNode, Function1 function1) {
        for (LayoutNode h02 = layoutNode.h0(); h02 != null; h02 = h02.h0()) {
            if (((Boolean) function1.invoke(h02)).booleanValue()) {
                return h02;
            }
        }
        return null;
    }

    public static final i1 g(LayoutNode layoutNode) {
        int i11;
        q0 e02 = layoutNode.e0();
        int a11 = s0.a(8);
        i11 = e02.i();
        Object obj = null;
        if ((i11 & a11) != 0) {
            f.c k11 = e02.k();
            loop0: while (true) {
                if (k11 == null) {
                    break;
                }
                if ((k11.f1() & a11) != 0) {
                    f.c cVar = k11;
                    androidx.compose.runtime.collection.b bVar = null;
                    while (cVar != null) {
                        if (cVar instanceof i1) {
                            if (((i1) cVar).W0()) {
                                obj = cVar;
                                break loop0;
                            }
                        } else if ((cVar.f1() & a11) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
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
                if ((k11.a1() & a11) == 0) {
                    break;
                }
                k11 = k11.b1();
            }
        }
        return (i1) obj;
    }

    public static final f h(SemanticsNode semanticsNode) {
        return (f) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f5994a.x());
    }

    public static final int i(SemanticsNode semanticsNode) {
        return semanticsNode.o() + Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
    }
}
