package androidx.compose.ui.focus;

import androidx.compose.ui.f;
import androidx.compose.ui.focus.b;
import androidx.compose.ui.layout.d;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
public abstract class OneDimensionalFocusSearchKt {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4310a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
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
            f4310a = iArr;
        }
    }

    private static final boolean b(FocusTargetNode focusTargetNode, Function1 function1) {
        FocusStateImpl K1 = focusTargetNode.K1();
        int[] iArr = a.f4310a;
        int i11 = iArr[K1.ordinal()];
        if (i11 == 1) {
            FocusTargetNode f11 = w.f(focusTargetNode);
            if (f11 == null) {
                throw new IllegalStateException("ActiveParent must have a focusedChild");
            }
            int i12 = iArr[f11.K1().ordinal()];
            if (i12 != 1) {
                if (i12 == 2 || i12 == 3) {
                    return d(focusTargetNode, f11, b.f4312b.f(), function1);
                }
                if (i12 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException("ActiveParent must have a focusedChild");
            }
            if (!b(f11, function1) && !d(focusTargetNode, f11, b.f4312b.f(), function1) && (!f11.I1().t() || !((Boolean) function1.invoke(f11)).booleanValue())) {
                return false;
            }
        } else {
            if (i11 == 2 || i11 == 3) {
                return g(focusTargetNode, function1);
            }
            if (i11 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!g(focusTargetNode, function1)) {
                if (!(focusTargetNode.I1().t() ? ((Boolean) function1.invoke(focusTargetNode)).booleanValue() : false)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final boolean c(FocusTargetNode focusTargetNode, Function1 function1) {
        int i11 = a.f4310a[focusTargetNode.K1().ordinal()];
        if (i11 == 1) {
            FocusTargetNode f11 = w.f(focusTargetNode);
            if (f11 != null) {
                return c(f11, function1) || d(focusTargetNode, f11, b.f4312b.e(), function1);
            }
            throw new IllegalStateException("ActiveParent must have a focusedChild");
        }
        if (i11 == 2 || i11 == 3) {
            return h(focusTargetNode, function1);
        }
        if (i11 == 4) {
            return focusTargetNode.I1().t() ? ((Boolean) function1.invoke(focusTargetNode)).booleanValue() : h(focusTargetNode, function1);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean d(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int i11, final Function1 function1) {
        if (i(focusTargetNode, focusTargetNode2, i11, function1)) {
            return true;
        }
        Boolean bool = (Boolean) androidx.compose.ui.focus.a.a(focusTargetNode, i11, new Function1<d.a, Boolean>() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(d.a aVar) {
                boolean i12;
                i12 = OneDimensionalFocusSearchKt.i(FocusTargetNode.this, focusTargetNode2, i11, function1);
                Boolean valueOf = Boolean.valueOf(i12);
                if (i12 || !aVar.a()) {
                    return valueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final boolean e(FocusTargetNode focusTargetNode) {
        f.c cVar;
        q0 e02;
        int a11 = s0.a(1024);
        if (!focusTargetNode.getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c h12 = focusTargetNode.getNode().h1();
        LayoutNode m11 = androidx.compose.ui.node.g.m(focusTargetNode);
        loop0: while (true) {
            cVar = null;
            if (m11 == null) {
                break;
            }
            if ((m11.e0().k().a1() & a11) != 0) {
                while (h12 != null) {
                    if ((h12.f1() & a11) != 0) {
                        f.c cVar2 = h12;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVar2 != null) {
                            if (cVar2 instanceof FocusTargetNode) {
                                cVar = cVar2;
                                break loop0;
                            }
                            if ((cVar2.f1() & a11) != 0 && (cVar2 instanceof androidx.compose.ui.node.i)) {
                                int i11 = 0;
                                for (f.c E1 = ((androidx.compose.ui.node.i) cVar2).E1(); E1 != null; E1 = E1.b1()) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            cVar2 = E1;
                                        } else {
                                            if (bVar == null) {
                                                bVar = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (cVar2 != null) {
                                                bVar.b(cVar2);
                                                cVar2 = null;
                                            }
                                            bVar.b(E1);
                                        }
                                    }
                                }
                                if (i11 == 1) {
                                }
                            }
                            cVar2 = androidx.compose.ui.node.g.g(bVar);
                        }
                    }
                    h12 = h12.h1();
                }
            }
            m11 = m11.h0();
            h12 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
        return cVar == null;
    }

    public static final boolean f(FocusTargetNode focusTargetNode, int i11, Function1 function1) {
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.e())) {
            return c(focusTargetNode, function1);
        }
        if (b.l(i11, aVar.f())) {
            return b(focusTargetNode, function1);
        }
        throw new IllegalStateException("This function should only be used for 1-D focus search");
    }

    private static final boolean g(FocusTargetNode focusTargetNode, Function1 function1) {
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new FocusTargetNode[16], 0);
        int a11 = s0.a(1024);
        if (!focusTargetNode.getNode().k1()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
        f.c b12 = focusTargetNode.getNode().b1();
        if (b12 == null) {
            androidx.compose.ui.node.g.c(bVar2, focusTargetNode.getNode());
        } else {
            bVar2.b(b12);
        }
        while (bVar2.q()) {
            f.c cVar = (f.c) bVar2.v(bVar2.n() - 1);
            if ((cVar.a1() & a11) == 0) {
                androidx.compose.ui.node.g.c(bVar2, cVar);
            } else {
                while (true) {
                    if (cVar == null) {
                        break;
                    }
                    if ((cVar.f1() & a11) != 0) {
                        androidx.compose.runtime.collection.b bVar3 = null;
                        while (cVar != null) {
                            if (cVar instanceof FocusTargetNode) {
                                bVar.b((FocusTargetNode) cVar);
                            } else if ((cVar.f1() & a11) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
                                int i11 = 0;
                                for (f.c E1 = ((androidx.compose.ui.node.i) cVar).E1(); E1 != null; E1 = E1.b1()) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            cVar = E1;
                                        } else {
                                            if (bVar3 == null) {
                                                bVar3 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (cVar != null) {
                                                bVar3.b(cVar);
                                                cVar = null;
                                            }
                                            bVar3.b(E1);
                                        }
                                    }
                                }
                                if (i11 == 1) {
                                }
                            }
                            cVar = androidx.compose.ui.node.g.g(bVar3);
                        }
                    } else {
                        cVar = cVar.b1();
                    }
                }
            }
        }
        bVar.A(FocusableChildrenComparator.INSTANCE);
        int n11 = bVar.n();
        if (n11 > 0) {
            int i12 = n11 - 1;
            Object[] m11 = bVar.m();
            do {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) m11[i12];
                if (w.g(focusTargetNode2) && b(focusTargetNode2, function1)) {
                    return true;
                }
                i12--;
            } while (i12 >= 0);
        }
        return false;
    }

    private static final boolean h(FocusTargetNode focusTargetNode, Function1 function1) {
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new FocusTargetNode[16], 0);
        int a11 = s0.a(1024);
        if (!focusTargetNode.getNode().k1()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
        f.c b12 = focusTargetNode.getNode().b1();
        if (b12 == null) {
            androidx.compose.ui.node.g.c(bVar2, focusTargetNode.getNode());
        } else {
            bVar2.b(b12);
        }
        while (bVar2.q()) {
            f.c cVar = (f.c) bVar2.v(bVar2.n() - 1);
            if ((cVar.a1() & a11) == 0) {
                androidx.compose.ui.node.g.c(bVar2, cVar);
            } else {
                while (true) {
                    if (cVar == null) {
                        break;
                    }
                    if ((cVar.f1() & a11) != 0) {
                        androidx.compose.runtime.collection.b bVar3 = null;
                        while (cVar != null) {
                            if (cVar instanceof FocusTargetNode) {
                                bVar.b((FocusTargetNode) cVar);
                            } else if ((cVar.f1() & a11) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
                                int i11 = 0;
                                for (f.c E1 = ((androidx.compose.ui.node.i) cVar).E1(); E1 != null; E1 = E1.b1()) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            cVar = E1;
                                        } else {
                                            if (bVar3 == null) {
                                                bVar3 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (cVar != null) {
                                                bVar3.b(cVar);
                                                cVar = null;
                                            }
                                            bVar3.b(E1);
                                        }
                                    }
                                }
                                if (i11 == 1) {
                                }
                            }
                            cVar = androidx.compose.ui.node.g.g(bVar3);
                        }
                    } else {
                        cVar = cVar.b1();
                    }
                }
            }
        }
        bVar.A(FocusableChildrenComparator.INSTANCE);
        int n11 = bVar.n();
        if (n11 <= 0) {
            return false;
        }
        Object[] m11 = bVar.m();
        int i12 = 0;
        do {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) m11[i12];
            if (w.g(focusTargetNode2) && c(focusTargetNode2, function1)) {
                return true;
            }
            i12++;
        } while (i12 < n11);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i11, Function1 function1) {
        if (focusTargetNode.K1() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.");
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new FocusTargetNode[16], 0);
        int a11 = s0.a(1024);
        if (!focusTargetNode.getNode().k1()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
        f.c b12 = focusTargetNode.getNode().b1();
        if (b12 == null) {
            androidx.compose.ui.node.g.c(bVar2, focusTargetNode.getNode());
        } else {
            bVar2.b(b12);
        }
        while (bVar2.q()) {
            f.c cVar = (f.c) bVar2.v(bVar2.n() - 1);
            if ((cVar.a1() & a11) == 0) {
                androidx.compose.ui.node.g.c(bVar2, cVar);
            } else {
                while (true) {
                    if (cVar == null) {
                        break;
                    }
                    if ((cVar.f1() & a11) != 0) {
                        androidx.compose.runtime.collection.b bVar3 = null;
                        while (cVar != null) {
                            if (cVar instanceof FocusTargetNode) {
                                bVar.b((FocusTargetNode) cVar);
                            } else if ((cVar.f1() & a11) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
                                int i12 = 0;
                                for (f.c E1 = ((androidx.compose.ui.node.i) cVar).E1(); E1 != null; E1 = E1.b1()) {
                                    if ((E1.f1() & a11) != 0) {
                                        i12++;
                                        if (i12 == 1) {
                                            cVar = E1;
                                        } else {
                                            if (bVar3 == null) {
                                                bVar3 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (cVar != null) {
                                                bVar3.b(cVar);
                                                cVar = null;
                                            }
                                            bVar3.b(E1);
                                        }
                                    }
                                }
                                if (i12 == 1) {
                                }
                            }
                            cVar = androidx.compose.ui.node.g.g(bVar3);
                        }
                    } else {
                        cVar = cVar.b1();
                    }
                }
            }
        }
        bVar.A(FocusableChildrenComparator.INSTANCE);
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.e())) {
            IntRange intRange = new IntRange(0, bVar.n() - 1);
            int first = intRange.getFirst();
            int last = intRange.getLast();
            if (first <= last) {
                boolean z10 = false;
                while (true) {
                    if (z10) {
                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) bVar.m()[first];
                        if (w.g(focusTargetNode3) && c(focusTargetNode3, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.c(bVar.m()[first], focusTargetNode2)) {
                        z10 = true;
                    }
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
        } else {
            if (!b.l(i11, aVar.f())) {
                throw new IllegalStateException("This function should only be used for 1-D focus search");
            }
            IntRange intRange2 = new IntRange(0, bVar.n() - 1);
            int first2 = intRange2.getFirst();
            int last2 = intRange2.getLast();
            if (first2 <= last2) {
                boolean z11 = false;
                while (true) {
                    if (z11) {
                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) bVar.m()[last2];
                        if (w.g(focusTargetNode4) && b(focusTargetNode4, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.c(bVar.m()[last2], focusTargetNode2)) {
                        z11 = true;
                    }
                    if (last2 == first2) {
                        break;
                    }
                    last2--;
                }
            }
        }
        if (b.l(i11, b.f4312b.e()) || !focusTargetNode.I1().t() || e(focusTargetNode)) {
            return false;
        }
        return ((Boolean) function1.invoke(focusTargetNode)).booleanValue();
    }
}
