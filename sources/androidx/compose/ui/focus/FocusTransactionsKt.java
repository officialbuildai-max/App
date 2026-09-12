package androidx.compose.ui.focus;

import androidx.compose.ui.f;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.node.v0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class FocusTransactionsKt {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4308a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f4309b;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f4308a = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f4309b = iArr2;
        }
    }

    private static final boolean a(FocusTargetNode focusTargetNode, boolean z10, boolean z11) {
        FocusTargetNode f11 = w.f(focusTargetNode);
        if (f11 != null) {
            return c(f11, z10, z11);
        }
        return true;
    }

    static /* synthetic */ boolean b(FocusTargetNode focusTargetNode, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return a(focusTargetNode, z10, z11);
    }

    public static final boolean c(FocusTargetNode focusTargetNode, boolean z10, boolean z11) {
        int i11 = a.f4309b[focusTargetNode.K1().ordinal()];
        if (i11 == 1) {
            focusTargetNode.Q1(FocusStateImpl.Inactive);
            if (z11) {
                d.c(focusTargetNode);
            }
        } else {
            if (i11 == 2) {
                if (!z10) {
                    return z10;
                }
                focusTargetNode.Q1(FocusStateImpl.Inactive);
                if (!z11) {
                    return z10;
                }
                d.c(focusTargetNode);
                return z10;
            }
            if (i11 != 3) {
                if (i11 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (!a(focusTargetNode, z10, z11)) {
                    return false;
                }
                focusTargetNode.Q1(FocusStateImpl.Inactive);
                if (z11) {
                    d.c(focusTargetNode);
                }
            }
        }
        return true;
    }

    private static final boolean d(final FocusTargetNode focusTargetNode) {
        v0.a(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m111invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m111invoke() {
                FocusTargetNode.this.I1();
            }
        });
        int i11 = a.f4309b[focusTargetNode.K1().ordinal()];
        if (i11 != 3 && i11 != 4) {
            return true;
        }
        focusTargetNode.Q1(FocusStateImpl.Active);
        return true;
    }

    public static final CustomDestinationResult e(FocusTargetNode focusTargetNode, int i11) {
        int i12 = a.f4309b[focusTargetNode.K1().ordinal()];
        if (i12 != 1) {
            if (i12 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i12 == 3) {
                CustomDestinationResult e11 = e(n(focusTargetNode), i11);
                if (e11 == CustomDestinationResult.None) {
                    e11 = null;
                }
                return e11 == null ? g(focusTargetNode, i11) : e11;
            }
            if (i12 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    private static final CustomDestinationResult f(FocusTargetNode focusTargetNode, int i11) {
        boolean z10;
        z10 = focusTargetNode.f4304o;
        if (!z10) {
            focusTargetNode.f4304o = true;
            try {
                FocusRequester focusRequester = (FocusRequester) focusTargetNode.I1().s().invoke(b.i(i11));
                FocusRequester.a aVar = FocusRequester.f4298b;
                if (focusRequester != aVar.b()) {
                    if (focusRequester == aVar.a()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequester.d() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.f4304o = false;
            }
        }
        return CustomDestinationResult.None;
    }

    private static final CustomDestinationResult g(FocusTargetNode focusTargetNode, int i11) {
        boolean z10;
        z10 = focusTargetNode.f4303n;
        if (!z10) {
            focusTargetNode.f4303n = true;
            try {
                FocusRequester focusRequester = (FocusRequester) focusTargetNode.I1().o().invoke(b.i(i11));
                FocusRequester.a aVar = FocusRequester.f4298b;
                if (focusRequester != aVar.b()) {
                    if (focusRequester == aVar.a()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequester.d() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.f4303n = false;
            }
        }
        return CustomDestinationResult.None;
    }

    public static final CustomDestinationResult h(FocusTargetNode focusTargetNode, int i11) {
        f.c cVar;
        q0 e02;
        int i12 = a.f4309b[focusTargetNode.K1().ordinal()];
        if (i12 == 1 || i12 == 2) {
            return CustomDestinationResult.None;
        }
        if (i12 == 3) {
            return e(n(focusTargetNode), i11);
        }
        if (i12 != 4) {
            throw new NoWhenBranchMatchedException();
        }
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
                                int i13 = 0;
                                for (f.c E1 = ((androidx.compose.ui.node.i) cVar).E1(); E1 != null; E1 = E1.b1()) {
                                    if ((E1.f1() & a11) != 0) {
                                        i13++;
                                        if (i13 == 1) {
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
                                if (i13 == 1) {
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
        if (focusTargetNode2 == null) {
            return CustomDestinationResult.None;
        }
        int i14 = a.f4309b[focusTargetNode2.K1().ordinal()];
        if (i14 == 1) {
            return f(focusTargetNode2, i11);
        }
        if (i14 == 2) {
            return CustomDestinationResult.Cancelled;
        }
        if (i14 == 3) {
            return h(focusTargetNode2, i11);
        }
        if (i14 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        CustomDestinationResult h11 = h(focusTargetNode2, i11);
        CustomDestinationResult customDestinationResult = h11 != CustomDestinationResult.None ? h11 : null;
        return customDestinationResult == null ? f(focusTargetNode2, i11) : customDestinationResult;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d7, code lost:
    
        if (d(r11) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00f4, code lost:
    
        if (d(r11) != false) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean i(androidx.compose.ui.focus.FocusTargetNode r11) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionsKt.i(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    public static final boolean j(FocusTargetNode focusTargetNode) {
        Boolean k11 = k(focusTargetNode, b.f4312b.b());
        if (k11 != null) {
            return k11.booleanValue();
        }
        return false;
    }

    public static final Boolean k(final FocusTargetNode focusTargetNode, int i11) {
        boolean z10;
        androidx.compose.runtime.collection.b bVar;
        Boolean valueOf;
        v d11 = u.d(focusTargetNode);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$requestFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m112invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m112invoke() {
                if (FocusTargetNode.this.getNode().k1()) {
                    d.c(FocusTargetNode.this);
                }
            }
        };
        try {
            z10 = d11.f4330c;
            if (z10) {
                d11.g();
            }
            d11.f();
            bVar = d11.f4329b;
            bVar.b(function0);
            int i12 = a.f4308a[h(focusTargetNode, i11).ordinal()];
            if (i12 == 1) {
                valueOf = Boolean.valueOf(i(focusTargetNode));
            } else if (i12 != 2) {
                if (i12 != 3 && i12 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                valueOf = null;
            } else {
                valueOf = Boolean.TRUE;
            }
            return valueOf;
        } finally {
            d11.h();
        }
    }

    private static final boolean l(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        f.c cVar;
        f.c cVar2;
        q0 e02;
        q0 e03;
        int a11 = s0.a(1024);
        if (!focusTargetNode2.getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c h12 = focusTargetNode2.getNode().h1();
        LayoutNode m11 = androidx.compose.ui.node.g.m(focusTargetNode2);
        loop0: while (true) {
            cVar = null;
            if (m11 == null) {
                cVar2 = null;
                break;
            }
            if ((m11.e0().k().a1() & a11) != 0) {
                while (h12 != null) {
                    if ((h12.f1() & a11) != 0) {
                        cVar2 = h12;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVar2 != null) {
                            if (cVar2 instanceof FocusTargetNode) {
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
            h12 = (m11 == null || (e03 = m11.e0()) == null) ? null : e03.o();
        }
        if (!Intrinsics.c(cVar2, focusTargetNode)) {
            throw new IllegalStateException("Non child node cannot request focus.");
        }
        int i12 = a.f4309b[focusTargetNode.K1().ordinal()];
        if (i12 == 1) {
            boolean d11 = d(focusTargetNode2);
            if (!d11) {
                return d11;
            }
            focusTargetNode.Q1(FocusStateImpl.ActiveParent);
            return d11;
        }
        if (i12 != 2) {
            if (i12 == 3) {
                n(focusTargetNode);
                if (b(focusTargetNode, false, false, 3, null) && d(focusTargetNode2)) {
                    return true;
                }
            } else {
                if (i12 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                int a12 = s0.a(1024);
                if (!focusTargetNode.getNode().k1()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                f.c h13 = focusTargetNode.getNode().h1();
                LayoutNode m12 = androidx.compose.ui.node.g.m(focusTargetNode);
                loop4: while (true) {
                    if (m12 == null) {
                        break;
                    }
                    if ((m12.e0().k().a1() & a12) != 0) {
                        while (h13 != null) {
                            if ((h13.f1() & a12) != 0) {
                                f.c cVar3 = h13;
                                androidx.compose.runtime.collection.b bVar2 = null;
                                while (cVar3 != null) {
                                    if (cVar3 instanceof FocusTargetNode) {
                                        cVar = cVar3;
                                        break loop4;
                                    }
                                    if ((cVar3.f1() & a12) != 0 && (cVar3 instanceof androidx.compose.ui.node.i)) {
                                        int i13 = 0;
                                        for (f.c E12 = ((androidx.compose.ui.node.i) cVar3).E1(); E12 != null; E12 = E12.b1()) {
                                            if ((E12.f1() & a12) != 0) {
                                                i13++;
                                                if (i13 == 1) {
                                                    cVar3 = E12;
                                                } else {
                                                    if (bVar2 == null) {
                                                        bVar2 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                    }
                                                    if (cVar3 != null) {
                                                        bVar2.b(cVar3);
                                                        cVar3 = null;
                                                    }
                                                    bVar2.b(E12);
                                                }
                                            }
                                        }
                                        if (i13 == 1) {
                                        }
                                    }
                                    cVar3 = androidx.compose.ui.node.g.g(bVar2);
                                }
                            }
                            h13 = h13.h1();
                        }
                    }
                    m12 = m12.h0();
                    h13 = (m12 == null || (e02 = m12.e0()) == null) ? null : e02.o();
                }
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) cVar;
                if (focusTargetNode3 == null && m(focusTargetNode)) {
                    boolean d12 = d(focusTargetNode2);
                    if (!d12) {
                        return d12;
                    }
                    focusTargetNode.Q1(FocusStateImpl.ActiveParent);
                    return d12;
                }
                if (focusTargetNode3 != null && l(focusTargetNode3, focusTargetNode)) {
                    boolean l11 = l(focusTargetNode, focusTargetNode2);
                    if (focusTargetNode.K1() != FocusStateImpl.ActiveParent) {
                        throw new IllegalStateException("Deactivated node is focused");
                    }
                    if (!l11) {
                        return l11;
                    }
                    d.c(focusTargetNode3);
                    return l11;
                }
            }
        }
        return false;
    }

    private static final boolean m(FocusTargetNode focusTargetNode) {
        return androidx.compose.ui.node.g.n(focusTargetNode).getFocusOwner().b(null, null);
    }

    private static final FocusTargetNode n(FocusTargetNode focusTargetNode) {
        FocusTargetNode f11 = w.f(focusTargetNode);
        if (f11 != null) {
            return f11;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child");
    }
}
