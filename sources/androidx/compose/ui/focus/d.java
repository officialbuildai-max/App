package androidx.compose.ui.focus;

import androidx.compose.ui.f;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;

/* loaded from: classes.dex */
public abstract class d {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4322a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f4322a = iArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0095, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.focus.r a(androidx.compose.ui.focus.c r12) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.d.a(androidx.compose.ui.focus.c):androidx.compose.ui.focus.r");
    }

    public static final void b(c cVar) {
        androidx.compose.ui.node.g.n(cVar).getFocusOwner().a(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static final void c(FocusTargetNode focusTargetNode) {
        q0 e02;
        int a11 = s0.a(4096);
        int a12 = s0.a(1024);
        f.c node = focusTargetNode.getNode();
        int i11 = a11 | a12;
        if (!focusTargetNode.getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c node2 = focusTargetNode.getNode();
        LayoutNode m11 = androidx.compose.ui.node.g.m(focusTargetNode);
        while (m11 != null) {
            if ((m11.e0().k().a1() & i11) != 0) {
                while (node2 != null) {
                    if ((node2.f1() & i11) != 0) {
                        if (node2 != node && (node2.f1() & a12) != 0) {
                            return;
                        }
                        if ((node2.f1() & a11) != 0) {
                            androidx.compose.ui.node.i iVar = node2;
                            ?? r72 = 0;
                            while (iVar != 0) {
                                if (iVar instanceof c) {
                                    c cVar = (c) iVar;
                                    cVar.S0(a(cVar));
                                } else if ((iVar.f1() & a11) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                                    f.c E1 = iVar.E1();
                                    int i12 = 0;
                                    iVar = iVar;
                                    r72 = r72;
                                    while (E1 != null) {
                                        if ((E1.f1() & a11) != 0) {
                                            i12++;
                                            r72 = r72;
                                            if (i12 == 1) {
                                                iVar = E1;
                                            } else {
                                                if (r72 == 0) {
                                                    r72 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                }
                                                if (iVar != 0) {
                                                    r72.b(iVar);
                                                    iVar = 0;
                                                }
                                                r72.b(E1);
                                            }
                                        }
                                        E1 = E1.b1();
                                        iVar = iVar;
                                        r72 = r72;
                                    }
                                    if (i12 == 1) {
                                    }
                                }
                                iVar = androidx.compose.ui.node.g.g(r72);
                            }
                        }
                    }
                    node2 = node2.h1();
                }
            }
            m11 = m11.h0();
            node2 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
    }
}
