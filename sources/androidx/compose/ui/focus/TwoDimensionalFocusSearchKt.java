package androidx.compose.ui.focus;

import androidx.compose.ui.f;
import androidx.compose.ui.focus.b;
import androidx.compose.ui.layout.d;
import androidx.compose.ui.node.s0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class TwoDimensionalFocusSearchKt {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4311a;

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
            f4311a = iArr;
        }
    }

    private static final FocusTargetNode b(FocusTargetNode focusTargetNode) {
        if (focusTargetNode.K1() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("Searching for active node in inactive hierarchy");
        }
        FocusTargetNode b11 = w.b(focusTargetNode);
        if (b11 != null) {
            return b11;
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild");
    }

    private static final boolean c(y.i iVar, y.i iVar2, y.i iVar3, int i11) {
        if (d(iVar3, i11, iVar) || !d(iVar2, i11, iVar)) {
            return false;
        }
        if (e(iVar3, i11, iVar)) {
            b.a aVar = b.f4312b;
            if (!b.l(i11, aVar.d()) && !b.l(i11, aVar.g()) && f(iVar2, i11, iVar) >= g(iVar3, i11, iVar)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean d(y.i iVar, int i11, y.i iVar2) {
        b.a aVar = b.f4312b;
        if (!(b.l(i11, aVar.d()) ? true : b.l(i11, aVar.g()))) {
            if (!(b.l(i11, aVar.h()) ? true : b.l(i11, aVar.a()))) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            if (iVar.g() > iVar2.f() && iVar.f() < iVar2.g()) {
                return true;
            }
        } else if (iVar.c() > iVar2.i() && iVar.i() < iVar2.c()) {
            return true;
        }
        return false;
    }

    private static final boolean e(y.i iVar, int i11, y.i iVar2) {
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.d())) {
            if (iVar2.f() < iVar.g()) {
                return false;
            }
        } else if (b.l(i11, aVar.g())) {
            if (iVar2.g() > iVar.f()) {
                return false;
            }
        } else if (b.l(i11, aVar.h())) {
            if (iVar2.i() < iVar.c()) {
                return false;
            }
        } else {
            if (!b.l(i11, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            if (iVar2.c() > iVar.i()) {
                return false;
            }
        }
        return true;
    }

    private static final float f(y.i iVar, int i11, y.i iVar2) {
        float i12;
        float c11;
        float i13;
        float c12;
        float f11;
        b.a aVar = b.f4312b;
        if (!b.l(i11, aVar.d())) {
            if (b.l(i11, aVar.g())) {
                i12 = iVar.f();
                c11 = iVar2.g();
            } else if (b.l(i11, aVar.h())) {
                i13 = iVar2.i();
                c12 = iVar.c();
            } else {
                if (!b.l(i11, aVar.a())) {
                    throw new IllegalStateException("This function should only be used for 2-D focus search");
                }
                i12 = iVar.i();
                c11 = iVar2.c();
            }
            f11 = i12 - c11;
            return Math.max(0.0f, f11);
        }
        i13 = iVar2.f();
        c12 = iVar.g();
        f11 = i13 - c12;
        return Math.max(0.0f, f11);
    }

    private static final float g(y.i iVar, int i11, y.i iVar2) {
        float c11;
        float c12;
        float i12;
        float i13;
        float f11;
        b.a aVar = b.f4312b;
        if (!b.l(i11, aVar.d())) {
            if (b.l(i11, aVar.g())) {
                c11 = iVar.g();
                c12 = iVar2.g();
            } else if (b.l(i11, aVar.h())) {
                i12 = iVar2.i();
                i13 = iVar.i();
            } else {
                if (!b.l(i11, aVar.a())) {
                    throw new IllegalStateException("This function should only be used for 2-D focus search");
                }
                c11 = iVar.c();
                c12 = iVar2.c();
            }
            f11 = c11 - c12;
            return Math.max(1.0f, f11);
        }
        i12 = iVar2.f();
        i13 = iVar.f();
        f11 = i12 - i13;
        return Math.max(1.0f, f11);
    }

    private static final y.i h(y.i iVar) {
        return new y.i(iVar.g(), iVar.c(), iVar.g(), iVar.c());
    }

    private static final void i(androidx.compose.ui.node.f fVar, androidx.compose.runtime.collection.b bVar) {
        int a11 = s0.a(1024);
        if (!fVar.getNode().k1()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar2 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
        f.c b12 = fVar.getNode().b1();
        if (b12 == null) {
            androidx.compose.ui.node.g.c(bVar2, fVar.getNode());
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
                                FocusTargetNode focusTargetNode = (FocusTargetNode) cVar;
                                if (focusTargetNode.k1() && !androidx.compose.ui.node.g.m(focusTargetNode).E0()) {
                                    if (focusTargetNode.I1().t()) {
                                        bVar.b(focusTargetNode);
                                    } else {
                                        i(focusTargetNode, bVar);
                                    }
                                }
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
    }

    private static final FocusTargetNode j(androidx.compose.runtime.collection.b bVar, y.i iVar, int i11) {
        y.i p11;
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.d())) {
            p11 = iVar.p(iVar.k() + 1, 0.0f);
        } else if (b.l(i11, aVar.g())) {
            p11 = iVar.p(-(iVar.k() + 1), 0.0f);
        } else if (b.l(i11, aVar.h())) {
            p11 = iVar.p(0.0f, iVar.e() + 1);
        } else {
            if (!b.l(i11, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            p11 = iVar.p(0.0f, -(iVar.e() + 1));
        }
        int n11 = bVar.n();
        FocusTargetNode focusTargetNode = null;
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            int i12 = 0;
            do {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) m11[i12];
                if (w.g(focusTargetNode2)) {
                    y.i d11 = w.d(focusTargetNode2);
                    if (m(d11, p11, iVar, i11)) {
                        focusTargetNode = focusTargetNode2;
                        p11 = d11;
                    }
                }
                i12++;
            } while (i12 < n11);
        }
        return focusTargetNode;
    }

    public static final boolean k(FocusTargetNode focusTargetNode, int i11, Function1 function1) {
        y.i h11;
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new FocusTargetNode[16], 0);
        i(focusTargetNode, bVar);
        if (bVar.n() <= 1) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) (bVar.p() ? null : bVar.m()[0]);
            if (focusTargetNode2 != null) {
                return ((Boolean) function1.invoke(focusTargetNode2)).booleanValue();
            }
            return false;
        }
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.b())) {
            i11 = aVar.g();
        }
        if (b.l(i11, aVar.g()) ? true : b.l(i11, aVar.a())) {
            h11 = s(w.d(focusTargetNode));
        } else {
            if (!(b.l(i11, aVar.d()) ? true : b.l(i11, aVar.h()))) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            h11 = h(w.d(focusTargetNode));
        }
        FocusTargetNode j11 = j(bVar, h11, i11);
        if (j11 != null) {
            return ((Boolean) function1.invoke(j11)).booleanValue();
        }
        return false;
    }

    private static final boolean l(final FocusTargetNode focusTargetNode, final y.i iVar, final int i11, final Function1 function1) {
        if (r(focusTargetNode, iVar, i11, function1)) {
            return true;
        }
        Boolean bool = (Boolean) androidx.compose.ui.focus.a.a(focusTargetNode, i11, new Function1<d.a, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(d.a aVar) {
                boolean r11;
                r11 = TwoDimensionalFocusSearchKt.r(FocusTargetNode.this, iVar, i11, function1);
                Boolean valueOf = Boolean.valueOf(r11);
                if (r11 || !aVar.a()) {
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

    private static final boolean m(y.i iVar, y.i iVar2, y.i iVar3, int i11) {
        if (n(iVar, i11, iVar3)) {
            return !n(iVar2, i11, iVar3) || c(iVar3, iVar, iVar2, i11) || (!c(iVar3, iVar2, iVar, i11) && q(i11, iVar3, iVar) < q(i11, iVar3, iVar2));
        }
        return false;
    }

    private static final boolean n(y.i iVar, int i11, y.i iVar2) {
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.d())) {
            if ((iVar2.g() <= iVar.g() && iVar2.f() < iVar.g()) || iVar2.f() <= iVar.f()) {
                return false;
            }
        } else if (b.l(i11, aVar.g())) {
            if ((iVar2.f() >= iVar.f() && iVar2.g() > iVar.f()) || iVar2.g() >= iVar.g()) {
                return false;
            }
        } else if (b.l(i11, aVar.h())) {
            if ((iVar2.c() <= iVar.c() && iVar2.i() < iVar.c()) || iVar2.i() <= iVar.i()) {
                return false;
            }
        } else {
            if (!b.l(i11, aVar.a())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            if ((iVar2.i() >= iVar.i() && iVar2.c() > iVar.i()) || iVar2.c() >= iVar.c()) {
                return false;
            }
        }
        return true;
    }

    private static final float o(y.i iVar, int i11, y.i iVar2) {
        float i12;
        float c11;
        float i13;
        float c12;
        float f11;
        b.a aVar = b.f4312b;
        if (!b.l(i11, aVar.d())) {
            if (b.l(i11, aVar.g())) {
                i12 = iVar.f();
                c11 = iVar2.g();
            } else if (b.l(i11, aVar.h())) {
                i13 = iVar2.i();
                c12 = iVar.c();
            } else {
                if (!b.l(i11, aVar.a())) {
                    throw new IllegalStateException("This function should only be used for 2-D focus search");
                }
                i12 = iVar.i();
                c11 = iVar2.c();
            }
            f11 = i12 - c11;
            return Math.max(0.0f, f11);
        }
        i13 = iVar2.f();
        c12 = iVar.g();
        f11 = i13 - c12;
        return Math.max(0.0f, f11);
    }

    private static final float p(y.i iVar, int i11, y.i iVar2) {
        float f11;
        float f12;
        float f13;
        float k11;
        b.a aVar = b.f4312b;
        if (b.l(i11, aVar.d()) ? true : b.l(i11, aVar.g())) {
            f11 = 2;
            f12 = iVar2.i() + (iVar2.e() / f11);
            f13 = iVar.i();
            k11 = iVar.e();
        } else {
            if (!(b.l(i11, aVar.h()) ? true : b.l(i11, aVar.a()))) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            f11 = 2;
            f12 = iVar2.f() + (iVar2.k() / f11);
            f13 = iVar.f();
            k11 = iVar.k();
        }
        return f12 - (f13 + (k11 / f11));
    }

    private static final long q(int i11, y.i iVar, y.i iVar2) {
        long abs = Math.abs(o(iVar2, i11, iVar));
        long abs2 = Math.abs(p(iVar2, i11, iVar));
        return (13 * abs * abs) + (abs2 * abs2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(FocusTargetNode focusTargetNode, y.i iVar, int i11, Function1 function1) {
        FocusTargetNode j11;
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
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVar;
                                if (focusTargetNode2.k1()) {
                                    bVar.b(focusTargetNode2);
                                }
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
        while (bVar.q() && (j11 = j(bVar, iVar, i11)) != null) {
            if (j11.I1().t()) {
                return ((Boolean) function1.invoke(j11)).booleanValue();
            }
            if (l(j11, iVar, i11, function1)) {
                return true;
            }
            bVar.t(j11);
        }
        return false;
    }

    private static final y.i s(y.i iVar) {
        return new y.i(iVar.f(), iVar.i(), iVar.f(), iVar.i());
    }

    public static final Boolean t(FocusTargetNode focusTargetNode, int i11, y.i iVar, Function1 function1) {
        FocusStateImpl K1 = focusTargetNode.K1();
        int[] iArr = a.f4311a;
        int i12 = iArr[K1.ordinal()];
        if (i12 != 1) {
            if (i12 == 2 || i12 == 3) {
                return Boolean.valueOf(k(focusTargetNode, i11, function1));
            }
            if (i12 == 4) {
                return focusTargetNode.I1().t() ? (Boolean) function1.invoke(focusTargetNode) : iVar == null ? Boolean.valueOf(k(focusTargetNode, i11, function1)) : Boolean.valueOf(r(focusTargetNode, iVar, i11, function1));
            }
            throw new NoWhenBranchMatchedException();
        }
        FocusTargetNode f11 = w.f(focusTargetNode);
        if (f11 == null) {
            throw new IllegalStateException("ActiveParent must have a focusedChild");
        }
        int i13 = iArr[f11.K1().ordinal()];
        if (i13 == 1) {
            Boolean t11 = t(f11, i11, iVar, function1);
            if (!Intrinsics.c(t11, Boolean.FALSE)) {
                return t11;
            }
            if (iVar == null) {
                iVar = w.d(b(f11));
            }
            return Boolean.valueOf(l(focusTargetNode, iVar, i11, function1));
        }
        if (i13 == 2 || i13 == 3) {
            if (iVar == null) {
                iVar = w.d(f11);
            }
            return Boolean.valueOf(l(focusTargetNode, iVar, i11, function1));
        }
        if (i13 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild");
    }
}
