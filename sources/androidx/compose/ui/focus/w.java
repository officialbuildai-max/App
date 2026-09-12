package androidx.compose.ui.focus;

import androidx.compose.ui.f;
import androidx.compose.ui.focus.b;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class w {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4331a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f4332b;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f4331a = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            f4332b = iArr2;
        }
    }

    public static final FocusRequester a(FocusTargetNode focusTargetNode, int i11, LayoutDirection layoutDirection) {
        FocusRequester p11;
        k I1 = focusTargetNode.I1();
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.e())) {
            return I1.k();
        }
        if (b.l(i11, aVar.f())) {
            return I1.u();
        }
        if (b.l(i11, aVar.h())) {
            return I1.n();
        }
        if (b.l(i11, aVar.a())) {
            return I1.q();
        }
        if (b.l(i11, aVar.d())) {
            int i12 = a.f4331a[layoutDirection.ordinal()];
            if (i12 == 1) {
                p11 = I1.j();
            } else {
                if (i12 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                p11 = I1.p();
            }
            if (p11 == FocusRequester.f4298b.b()) {
                p11 = null;
            }
            if (p11 == null) {
                return I1.i();
            }
        } else {
            if (!b.l(i11, aVar.g())) {
                if (b.l(i11, aVar.b())) {
                    return (FocusRequester) I1.s().invoke(b.i(i11));
                }
                if (b.l(i11, aVar.c())) {
                    return (FocusRequester) I1.o().invoke(b.i(i11));
                }
                throw new IllegalStateException("invalid FocusDirection");
            }
            int i13 = a.f4331a[layoutDirection.ordinal()];
            if (i13 == 1) {
                p11 = I1.p();
            } else {
                if (i13 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                p11 = I1.j();
            }
            if (p11 == FocusRequester.f4298b.b()) {
                p11 = null;
            }
            if (p11 == null) {
                return I1.m();
            }
        }
        return p11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x004f, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.focus.FocusTargetNode b(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            androidx.compose.ui.focus.FocusStateImpl r0 = r10.K1()
            int[] r1 = androidx.compose.ui.focus.w.a.f4332b
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto Ld3
            r2 = 2
            r3 = 0
            if (r0 == r2) goto L20
            r1 = 3
            if (r0 == r1) goto Ld3
            r10 = 4
            if (r0 != r10) goto L1a
            return r3
        L1a:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L20:
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.s0.a(r0)
            androidx.compose.ui.f$c r2 = r10.getNode()
            boolean r2 = r2.k1()
            if (r2 == 0) goto Lcb
            androidx.compose.runtime.collection.b r2 = new androidx.compose.runtime.collection.b
            r4 = 16
            androidx.compose.ui.f$c[] r5 = new androidx.compose.ui.f.c[r4]
            r6 = 0
            r2.<init>(r5, r6)
            androidx.compose.ui.f$c r5 = r10.getNode()
            androidx.compose.ui.f$c r5 = r5.b1()
            if (r5 != 0) goto L4c
            androidx.compose.ui.f$c r10 = r10.getNode()
            androidx.compose.ui.node.g.a(r2, r10)
            goto L4f
        L4c:
            r2.b(r5)
        L4f:
            boolean r10 = r2.q()
            if (r10 == 0) goto Lca
            int r10 = r2.n()
            int r10 = r10 - r1
            java.lang.Object r10 = r2.v(r10)
            androidx.compose.ui.f$c r10 = (androidx.compose.ui.f.c) r10
            int r5 = r10.a1()
            r5 = r5 & r0
            if (r5 != 0) goto L6b
            androidx.compose.ui.node.g.a(r2, r10)
            goto L4f
        L6b:
            if (r10 == 0) goto L4f
            int r5 = r10.f1()
            r5 = r5 & r0
            if (r5 == 0) goto Lc5
            r5 = r3
        L75:
            if (r10 == 0) goto L4f
            boolean r7 = r10 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r7 == 0) goto L84
            androidx.compose.ui.focus.FocusTargetNode r10 = (androidx.compose.ui.focus.FocusTargetNode) r10
            androidx.compose.ui.focus.FocusTargetNode r10 = b(r10)
            if (r10 == 0) goto Lc0
            return r10
        L84:
            int r7 = r10.f1()
            r7 = r7 & r0
            if (r7 == 0) goto Lc0
            boolean r7 = r10 instanceof androidx.compose.ui.node.i
            if (r7 == 0) goto Lc0
            r7 = r10
            androidx.compose.ui.node.i r7 = (androidx.compose.ui.node.i) r7
            androidx.compose.ui.f$c r7 = r7.E1()
            r8 = r6
        L97:
            if (r7 == 0) goto Lbd
            int r9 = r7.f1()
            r9 = r9 & r0
            if (r9 == 0) goto Lb8
            int r8 = r8 + 1
            if (r8 != r1) goto La6
            r10 = r7
            goto Lb8
        La6:
            if (r5 != 0) goto Laf
            androidx.compose.runtime.collection.b r5 = new androidx.compose.runtime.collection.b
            androidx.compose.ui.f$c[] r9 = new androidx.compose.ui.f.c[r4]
            r5.<init>(r9, r6)
        Laf:
            if (r10 == 0) goto Lb5
            r5.b(r10)
            r10 = r3
        Lb5:
            r5.b(r7)
        Lb8:
            androidx.compose.ui.f$c r7 = r7.b1()
            goto L97
        Lbd:
            if (r8 != r1) goto Lc0
            goto L75
        Lc0:
            androidx.compose.ui.f$c r10 = androidx.compose.ui.node.g.b(r5)
            goto L75
        Lc5:
            androidx.compose.ui.f$c r10 = r10.b1()
            goto L6b
        Lca:
            return r3
        Lcb:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitChildren called on an unattached node"
            r10.<init>(r0)
            throw r10
        Ld3:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.w.b(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    private static final FocusTargetNode c(FocusTargetNode focusTargetNode) {
        q0 e02;
        int a11 = s0.a(1024);
        if (!focusTargetNode.getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c h12 = focusTargetNode.getNode().h1();
        LayoutNode m11 = androidx.compose.ui.node.g.m(focusTargetNode);
        while (m11 != null) {
            if ((m11.e0().k().a1() & a11) != 0) {
                while (h12 != null) {
                    if ((h12.f1() & a11) != 0) {
                        f.c cVar = h12;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVar != null) {
                            if (cVar instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVar;
                                if (focusTargetNode2.I1().t()) {
                                    return focusTargetNode2;
                                }
                            } else if ((cVar.f1() & a11) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
                                int i11 = 0;
                                for (f.c E1 = ((androidx.compose.ui.node.i) cVar).E1(); E1 != null; E1 = E1.b1()) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        if (i11 == 1) {
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
                                if (i11 == 1) {
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
        return null;
    }

    public static final y.i d(FocusTargetNode focusTargetNode) {
        y.i O;
        NodeCoordinator c12 = focusTargetNode.c1();
        return (c12 == null || (O = androidx.compose.ui.layout.m.d(c12).O(c12, false)) == null) ? y.i.f78598e.a() : O;
    }

    public static final Boolean e(FocusTargetNode focusTargetNode, int i11, LayoutDirection layoutDirection, y.i iVar, Function1 function1) {
        int g11;
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.e()) ? true : b.l(i11, aVar.f())) {
            return Boolean.valueOf(OneDimensionalFocusSearchKt.f(focusTargetNode, i11, function1));
        }
        if (b.l(i11, aVar.d()) ? true : b.l(i11, aVar.g()) ? true : b.l(i11, aVar.h()) ? true : b.l(i11, aVar.a())) {
            return TwoDimensionalFocusSearchKt.t(focusTargetNode, i11, iVar, function1);
        }
        if (!b.l(i11, aVar.b())) {
            if (b.l(i11, aVar.c())) {
                FocusTargetNode b11 = b(focusTargetNode);
                FocusTargetNode c11 = b11 != null ? c(b11) : null;
                return Boolean.valueOf((c11 == null || Intrinsics.c(c11, focusTargetNode)) ? false : ((Boolean) function1.invoke(c11)).booleanValue());
            }
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) b.n(i11))).toString());
        }
        int i12 = a.f4331a[layoutDirection.ordinal()];
        if (i12 == 1) {
            g11 = aVar.g();
        } else {
            if (i12 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            g11 = aVar.d();
        }
        FocusTargetNode b12 = b(focusTargetNode);
        if (b12 != null) {
            return TwoDimensionalFocusSearchKt.t(b12, g11, iVar, function1);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x003b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.focus.FocusTargetNode f(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            androidx.compose.ui.f$c r0 = r10.getNode()
            boolean r0 = r0.k1()
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.s0.a(r0)
            androidx.compose.ui.f$c r2 = r10.getNode()
            boolean r2 = r2.k1()
            if (r2 == 0) goto Ld1
            androidx.compose.runtime.collection.b r2 = new androidx.compose.runtime.collection.b
            r3 = 16
            androidx.compose.ui.f$c[] r4 = new androidx.compose.ui.f.c[r3]
            r5 = 0
            r2.<init>(r4, r5)
            androidx.compose.ui.f$c r4 = r10.getNode()
            androidx.compose.ui.f$c r4 = r4.b1()
            if (r4 != 0) goto L38
            androidx.compose.ui.f$c r10 = r10.getNode()
            androidx.compose.ui.node.g.a(r2, r10)
            goto L3b
        L38:
            r2.b(r4)
        L3b:
            boolean r10 = r2.q()
            if (r10 == 0) goto Ld0
            int r10 = r2.n()
            r4 = 1
            int r10 = r10 - r4
            java.lang.Object r10 = r2.v(r10)
            androidx.compose.ui.f$c r10 = (androidx.compose.ui.f.c) r10
            int r6 = r10.a1()
            r6 = r6 & r0
            if (r6 != 0) goto L58
            androidx.compose.ui.node.g.a(r2, r10)
            goto L3b
        L58:
            if (r10 == 0) goto L3b
            int r6 = r10.f1()
            r6 = r6 & r0
            if (r6 == 0) goto Lcb
            r6 = r1
        L62:
            if (r10 == 0) goto L3b
            boolean r7 = r10 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r7 == 0) goto L8a
            androidx.compose.ui.focus.FocusTargetNode r10 = (androidx.compose.ui.focus.FocusTargetNode) r10
            androidx.compose.ui.f$c r7 = r10.getNode()
            boolean r7 = r7.k1()
            if (r7 == 0) goto Lc6
            androidx.compose.ui.focus.FocusStateImpl r7 = r10.K1()
            int[] r8 = androidx.compose.ui.focus.w.a.f4332b
            int r7 = r7.ordinal()
            r7 = r8[r7]
            if (r7 == r4) goto L89
            r8 = 2
            if (r7 == r8) goto L89
            r8 = 3
            if (r7 == r8) goto L89
            goto Lc6
        L89:
            return r10
        L8a:
            int r7 = r10.f1()
            r7 = r7 & r0
            if (r7 == 0) goto Lc6
            boolean r7 = r10 instanceof androidx.compose.ui.node.i
            if (r7 == 0) goto Lc6
            r7 = r10
            androidx.compose.ui.node.i r7 = (androidx.compose.ui.node.i) r7
            androidx.compose.ui.f$c r7 = r7.E1()
            r8 = r5
        L9d:
            if (r7 == 0) goto Lc3
            int r9 = r7.f1()
            r9 = r9 & r0
            if (r9 == 0) goto Lbe
            int r8 = r8 + 1
            if (r8 != r4) goto Lac
            r10 = r7
            goto Lbe
        Lac:
            if (r6 != 0) goto Lb5
            androidx.compose.runtime.collection.b r6 = new androidx.compose.runtime.collection.b
            androidx.compose.ui.f$c[] r9 = new androidx.compose.ui.f.c[r3]
            r6.<init>(r9, r5)
        Lb5:
            if (r10 == 0) goto Lbb
            r6.b(r10)
            r10 = r1
        Lbb:
            r6.b(r7)
        Lbe:
            androidx.compose.ui.f$c r7 = r7.b1()
            goto L9d
        Lc3:
            if (r8 != r4) goto Lc6
            goto L62
        Lc6:
            androidx.compose.ui.f$c r10 = androidx.compose.ui.node.g.b(r6)
            goto L62
        Lcb:
            androidx.compose.ui.f$c r10 = r10.b1()
            goto L58
        Ld0:
            return r1
        Ld1:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitChildren called on an unattached node"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.w.f(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    public static final boolean g(FocusTargetNode focusTargetNode) {
        LayoutNode a12;
        NodeCoordinator c12;
        LayoutNode a13;
        NodeCoordinator c13 = focusTargetNode.c1();
        return (c13 == null || (a12 = c13.a1()) == null || !a12.n() || (c12 = focusTargetNode.c1()) == null || (a13 = c12.a1()) == null || !a13.D0()) ? false : true;
    }
}
