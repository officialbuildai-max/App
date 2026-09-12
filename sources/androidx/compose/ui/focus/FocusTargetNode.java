package androidx.compose.ui.focus;

import androidx.compose.ui.f;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class FocusTargetNode extends f.c implements androidx.compose.ui.node.d, s, u0, androidx.compose.ui.modifier.h {

    /* renamed from: n, reason: collision with root package name */
    private boolean f4303n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4304o;

    /* renamed from: p, reason: collision with root package name */
    private FocusStateImpl f4305p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f4306q;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4307a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f4307a = iArr;
        }
    }

    private final void L1() {
        if (O1(this)) {
            throw new IllegalStateException("Re-initializing focus target node.");
        }
        v d11 = u.d(this);
        try {
            if (v.e(d11)) {
                v.b(d11);
            }
            v.a(d11);
            Q1((N1(this) && M1(this)) ? FocusStateImpl.ActiveParent : FocusStateImpl.Inactive);
            Unit unit = Unit.f67184a;
            v.c(d11);
        } catch (Throwable th2) {
            v.c(d11);
            throw th2;
        }
    }

    private static final boolean M1(FocusTargetNode focusTargetNode) {
        int a11 = s0.a(1024);
        if (!focusTargetNode.getNode().k1()) {
            g0.a.b("visitSubtreeIf called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new f.c[16], 0);
        f.c b12 = focusTargetNode.getNode().b1();
        if (b12 == null) {
            androidx.compose.ui.node.g.c(bVar, focusTargetNode.getNode());
        } else {
            bVar.b(b12);
        }
        while (bVar.q()) {
            f.c cVar = (f.c) bVar.v(bVar.n() - 1);
            if ((cVar.a1() & a11) != 0) {
                for (f.c cVar2 = cVar; cVar2 != null; cVar2 = cVar2.b1()) {
                    if ((cVar2.f1() & a11) != 0) {
                        f.c cVar3 = cVar2;
                        androidx.compose.runtime.collection.b bVar2 = null;
                        while (cVar3 != null) {
                            if (cVar3 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVar3;
                                if (O1(focusTargetNode2)) {
                                    int i11 = a.f4307a[focusTargetNode2.K1().ordinal()];
                                    if (i11 == 1 || i11 == 2 || i11 == 3) {
                                        return true;
                                    }
                                    if (i11 == 4) {
                                        return false;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else if ((cVar3.f1() & a11) != 0 && (cVar3 instanceof androidx.compose.ui.node.i)) {
                                int i12 = 0;
                                for (f.c E1 = ((androidx.compose.ui.node.i) cVar3).E1(); E1 != null; E1 = E1.b1()) {
                                    if ((E1.f1() & a11) != 0) {
                                        i12++;
                                        if (i12 == 1) {
                                            cVar3 = E1;
                                        } else {
                                            if (bVar2 == null) {
                                                bVar2 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (cVar3 != null) {
                                                bVar2.b(cVar3);
                                                cVar3 = null;
                                            }
                                            bVar2.b(E1);
                                        }
                                    }
                                }
                                if (i12 == 1) {
                                }
                            }
                            cVar3 = androidx.compose.ui.node.g.g(bVar2);
                        }
                    }
                }
            }
            androidx.compose.ui.node.g.c(bVar, cVar);
        }
        return false;
    }

    private static final boolean N1(FocusTargetNode focusTargetNode) {
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
                                if (O1(focusTargetNode2)) {
                                    int i11 = a.f4307a[focusTargetNode2.K1().ordinal()];
                                    if (i11 == 1 || i11 == 2) {
                                        return false;
                                    }
                                    if (i11 == 3) {
                                        return true;
                                    }
                                    if (i11 == 4) {
                                        return false;
                                    }
                                    throw new NoWhenBranchMatchedException();
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
                    h12 = h12.h1();
                }
            }
            m11 = m11.h0();
            h12 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
        return false;
    }

    private static final boolean O1(FocusTargetNode focusTargetNode) {
        return focusTargetNode.f4305p != null;
    }

    public final void H1() {
        FocusStateImpl i11 = u.d(this).i(this);
        if (i11 != null) {
            this.f4305p = i11;
        } else {
            g0.a.c("committing a node that was not updated in the current transaction");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [androidx.compose.ui.f$c] */
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
    public final k I1() {
        q0 e02;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        int a11 = s0.a(2048);
        int a12 = s0.a(1024);
        f.c node = getNode();
        int i11 = a11 | a12;
        if (!getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c node2 = getNode();
        LayoutNode m11 = androidx.compose.ui.node.g.m(this);
        loop0: while (m11 != null) {
            if ((m11.e0().k().a1() & i11) != 0) {
                while (node2 != null) {
                    if ((node2.f1() & i11) != 0) {
                        if (node2 != node && (node2.f1() & a12) != 0) {
                            break loop0;
                        }
                        if ((node2.f1() & a11) != 0) {
                            androidx.compose.ui.node.i iVar = node2;
                            ?? r92 = 0;
                            while (iVar != 0) {
                                if (iVar instanceof m) {
                                    ((m) iVar).r0(focusPropertiesImpl);
                                } else if ((iVar.f1() & a11) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                                    f.c E1 = iVar.E1();
                                    int i12 = 0;
                                    iVar = iVar;
                                    r92 = r92;
                                    while (E1 != null) {
                                        if ((E1.f1() & a11) != 0) {
                                            i12++;
                                            r92 = r92;
                                            if (i12 == 1) {
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
                                    if (i12 == 1) {
                                    }
                                }
                                iVar = androidx.compose.ui.node.g.g(r92);
                            }
                        }
                    }
                    node2 = node2.h1();
                }
            }
            m11 = m11.h0();
            node2 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
        return focusPropertiesImpl;
    }

    public final androidx.compose.ui.layout.d J1() {
        return (androidx.compose.ui.layout.d) P(BeyondBoundsLayoutKt.a());
    }

    public FocusStateImpl K1() {
        FocusStateImpl i11;
        v a11 = u.a(this);
        if (a11 != null && (i11 = a11.i(this)) != null) {
            return i11;
        }
        FocusStateImpl focusStateImpl = this.f4305p;
        return focusStateImpl == null ? FocusStateImpl.Inactive : focusStateImpl;
    }

    @Override // androidx.compose.ui.modifier.k
    public /* synthetic */ Object P(androidx.compose.ui.modifier.c cVar) {
        return androidx.compose.ui.modifier.g.a(this, cVar);
    }

    public final void P1() {
        k kVar;
        if (this.f4305p == null) {
            L1();
        }
        int i11 = a.f4307a[K1().ordinal()];
        if (i11 == 1 || i11 == 2) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            v0.a(this, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$invalidateFocus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m110invoke();
                    return Unit.f67184a;
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [T, androidx.compose.ui.focus.k] */
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m110invoke() {
                    objectRef.element = this.I1();
                }
            });
            T t11 = objectRef.element;
            if (t11 == 0) {
                Intrinsics.z("focusProperties");
                kVar = null;
            } else {
                kVar = (k) t11;
            }
            if (kVar.t()) {
                return;
            }
            androidx.compose.ui.node.g.n(this).getFocusOwner().o(true);
        }
    }

    public void Q1(FocusStateImpl focusStateImpl) {
        u.d(this).j(this, focusStateImpl);
    }

    @Override // androidx.compose.ui.modifier.h
    public /* synthetic */ androidx.compose.ui.modifier.f V() {
        return androidx.compose.ui.modifier.g.b(this);
    }

    @Override // androidx.compose.ui.node.u0
    public void Z() {
        FocusStateImpl K1 = K1();
        P1();
        if (K1 != K1()) {
            d.c(this);
        }
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return this.f4306q;
    }

    @Override // androidx.compose.ui.f.c
    public void o1() {
        int i11 = a.f4307a[K1().ordinal()];
        if (i11 == 1 || i11 == 2) {
            androidx.compose.ui.node.g.n(this).getFocusOwner().j(true, true, false, b.f4312b.c());
            u.c(this);
        } else if (i11 == 3) {
            v d11 = u.d(this);
            try {
                if (v.e(d11)) {
                    v.b(d11);
                }
                v.a(d11);
                Q1(FocusStateImpl.Inactive);
                Unit unit = Unit.f67184a;
                v.c(d11);
            } catch (Throwable th2) {
                v.c(d11);
                throw th2;
            }
        }
        this.f4305p = null;
    }
}
