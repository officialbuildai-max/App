package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.y0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a */
    private final LayoutNode f5475a;

    /* renamed from: b */
    private final j f5476b;

    /* renamed from: c */
    private boolean f5477c;

    /* renamed from: d */
    private boolean f5478d;

    /* renamed from: e */
    private final OnPositionedDispatcher f5479e;

    /* renamed from: f */
    private final androidx.compose.runtime.collection.b f5480f;

    /* renamed from: g */
    private long f5481g;

    /* renamed from: h */
    private final androidx.compose.runtime.collection.b f5482h;

    /* renamed from: i */
    private o0.b f5483i;

    /* renamed from: j */
    private final h0 f5484j;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        private final LayoutNode f5485a;

        /* renamed from: b */
        private final boolean f5486b;

        /* renamed from: c */
        private final boolean f5487c;

        public a(LayoutNode layoutNode, boolean z10, boolean z11) {
            this.f5485a = layoutNode;
            this.f5486b = z10;
            this.f5487c = z11;
        }

        public final LayoutNode a() {
            return this.f5485a;
        }

        public final boolean b() {
            return this.f5487c;
        }

        public final boolean c() {
            return this.f5486b;
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f5488a;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f5488a = iArr;
        }
    }

    public k0(LayoutNode layoutNode) {
        this.f5475a = layoutNode;
        y0.a aVar = y0.f5536d1;
        j jVar = new j(aVar.a());
        this.f5476b = jVar;
        this.f5479e = new OnPositionedDispatcher();
        this.f5480f = new androidx.compose.runtime.collection.b(new y0.b[16], 0);
        this.f5481g = 1L;
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new a[16], 0);
        this.f5482h = bVar;
        this.f5484j = aVar.a() ? new h0(layoutNode, jVar, bVar.g()) : null;
    }

    private final void A(LayoutNode layoutNode) {
        androidx.compose.runtime.collection.b p02 = layoutNode.p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                if (o(layoutNode2)) {
                    if (g0.a(layoutNode2)) {
                        B(layoutNode2, true);
                    } else {
                        A(layoutNode2);
                    }
                }
                i11++;
            } while (i11 < n11);
        }
    }

    private final void B(LayoutNode layoutNode, boolean z10) {
        o0.b bVar;
        if (layoutNode.E0()) {
            return;
        }
        if (layoutNode == this.f5475a) {
            bVar = this.f5483i;
            Intrinsics.e(bVar);
        } else {
            bVar = null;
        }
        if (z10) {
            e(layoutNode, bVar);
        } else {
            f(layoutNode, bVar);
        }
    }

    public static /* synthetic */ boolean H(k0 k0Var, LayoutNode layoutNode, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return k0Var.G(layoutNode, z10);
    }

    private final void b() {
        androidx.compose.runtime.collection.b bVar = this.f5480f;
        int n11 = bVar.n();
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            int i11 = 0;
            do {
                ((y0.b) m11[i11]).f();
                i11++;
            } while (i11 < n11);
        }
        this.f5480f.h();
    }

    public static /* synthetic */ void d(k0 k0Var, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        k0Var.c(z10);
    }

    private final boolean e(LayoutNode layoutNode, o0.b bVar) {
        if (layoutNode.V() == null) {
            return false;
        }
        boolean I0 = bVar != null ? layoutNode.I0(bVar) : LayoutNode.J0(layoutNode, null, 1, null);
        LayoutNode h02 = layoutNode.h0();
        if (I0 && h02 != null) {
            if (h02.V() == null) {
                LayoutNode.h1(h02, false, false, false, 3, null);
            } else if (layoutNode.b0() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.d1(h02, false, false, false, 3, null);
            } else if (layoutNode.b0() == LayoutNode.UsageByParent.InLayoutBlock) {
                LayoutNode.b1(h02, false, 1, null);
            }
        }
        return I0;
    }

    private final boolean f(LayoutNode layoutNode, o0.b bVar) {
        boolean V0 = bVar != null ? layoutNode.V0(bVar) : LayoutNode.W0(layoutNode, null, 1, null);
        LayoutNode h02 = layoutNode.h0();
        if (V0 && h02 != null) {
            if (layoutNode.a0() == LayoutNode.UsageByParent.InMeasureBlock) {
                LayoutNode.h1(h02, false, false, false, 3, null);
            } else if (layoutNode.a0() == LayoutNode.UsageByParent.InLayoutBlock) {
                LayoutNode.f1(h02, false, 1, null);
            }
        }
        return V0;
    }

    private final void g() {
        if (this.f5482h.q()) {
            androidx.compose.runtime.collection.b bVar = this.f5482h;
            int n11 = bVar.n();
            if (n11 > 0) {
                Object[] m11 = bVar.m();
                int i11 = 0;
                do {
                    a aVar = (a) m11[i11];
                    if (aVar.a().D0()) {
                        if (aVar.c()) {
                            LayoutNode.d1(aVar.a(), aVar.b(), false, false, 2, null);
                        } else {
                            LayoutNode.h1(aVar.a(), aVar.b(), false, false, 2, null);
                        }
                    }
                    i11++;
                } while (i11 < n11);
            }
            this.f5482h.h();
        }
    }

    private final void h(LayoutNode layoutNode) {
        androidx.compose.runtime.collection.b p02 = layoutNode.p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                if (Intrinsics.c(layoutNode2.G0(), Boolean.TRUE) && !layoutNode2.E0()) {
                    if (this.f5476b.e(layoutNode2, true)) {
                        layoutNode2.K0();
                    }
                    h(layoutNode2);
                }
                i11++;
            } while (i11 < n11);
        }
    }

    private final void j(LayoutNode layoutNode, boolean z10) {
        androidx.compose.runtime.collection.b p02 = layoutNode.p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                if ((!z10 && o(layoutNode2)) || (z10 && p(layoutNode2))) {
                    if (g0.a(layoutNode2) && !z10) {
                        if (layoutNode2.T() && this.f5476b.e(layoutNode2, true)) {
                            y(layoutNode2, true, false);
                        } else {
                            i(layoutNode2, true);
                        }
                    }
                    w(layoutNode2, z10);
                    if (!u(layoutNode2, z10)) {
                        j(layoutNode2, z10);
                    }
                }
                i11++;
            } while (i11 < n11);
        }
        w(layoutNode, z10);
    }

    private final boolean k(LayoutNode layoutNode) {
        return layoutNode.Y() && o(layoutNode);
    }

    private final boolean l(LayoutNode layoutNode) {
        return layoutNode.T() && p(layoutNode);
    }

    private final boolean o(LayoutNode layoutNode) {
        return layoutNode.a0() == LayoutNode.UsageByParent.InMeasureBlock || layoutNode.P().r().v().k();
    }

    private final boolean p(LayoutNode layoutNode) {
        AlignmentLines v11;
        if (layoutNode.b0() == LayoutNode.UsageByParent.InMeasureBlock) {
            return true;
        }
        androidx.compose.ui.node.a C = layoutNode.P().C();
        return (C == null || (v11 = C.v()) == null || !v11.k()) ? false : true;
    }

    private final boolean u(LayoutNode layoutNode, boolean z10) {
        return z10 ? layoutNode.T() : layoutNode.Y();
    }

    private final void w(LayoutNode layoutNode, boolean z10) {
        if (u(layoutNode, z10) && this.f5476b.e(layoutNode, z10)) {
            y(layoutNode, z10, false);
        }
    }

    private final boolean y(LayoutNode layoutNode, boolean z10, boolean z11) {
        o0.b bVar;
        LayoutNode h02;
        if (layoutNode.E0()) {
            return false;
        }
        if (layoutNode.n() || layoutNode.F0() || k(layoutNode) || Intrinsics.c(layoutNode.G0(), Boolean.TRUE) || l(layoutNode) || layoutNode.z()) {
            if (layoutNode == this.f5475a) {
                bVar = this.f5483i;
                Intrinsics.e(bVar);
            } else {
                bVar = null;
            }
            if (z10) {
                r1 = layoutNode.T() ? e(layoutNode, bVar) : false;
                if (z11 && ((r1 || layoutNode.S()) && Intrinsics.c(layoutNode.G0(), Boolean.TRUE))) {
                    layoutNode.K0();
                }
            } else {
                boolean f11 = layoutNode.Y() ? f(layoutNode, bVar) : false;
                if (z11 && layoutNode.Q() && (layoutNode == this.f5475a || ((h02 = layoutNode.h0()) != null && h02.n() && layoutNode.F0()))) {
                    if (layoutNode == this.f5475a) {
                        layoutNode.T0(0, 0);
                    } else {
                        layoutNode.Z0();
                    }
                    this.f5479e.d(layoutNode);
                    h0 h0Var = this.f5484j;
                    if (h0Var != null) {
                        h0Var.a();
                    }
                }
                r1 = f11;
            }
            g();
        }
        return r1;
    }

    static /* synthetic */ boolean z(k0 k0Var, LayoutNode layoutNode, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        return k0Var.y(layoutNode, z10, z11);
    }

    public final boolean C(LayoutNode layoutNode, boolean z10) {
        int i11 = b.f5488a[layoutNode.R().ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4 && i11 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            if ((layoutNode.T() || layoutNode.S()) && !z10) {
                h0 h0Var = this.f5484j;
                if (h0Var == null) {
                    return false;
                }
                h0Var.a();
                return false;
            }
            layoutNode.M0();
            layoutNode.L0();
            if (layoutNode.E0()) {
                return false;
            }
            LayoutNode h02 = layoutNode.h0();
            if (Intrinsics.c(layoutNode.G0(), Boolean.TRUE) && ((h02 == null || !h02.T()) && (h02 == null || !h02.S()))) {
                this.f5476b.c(layoutNode, true);
            } else if (layoutNode.n() && ((h02 == null || !h02.Q()) && (h02 == null || !h02.Y()))) {
                this.f5476b.c(layoutNode, false);
            }
            return !this.f5478d;
        }
        h0 h0Var2 = this.f5484j;
        if (h0Var2 == null) {
            return false;
        }
        h0Var2.a();
        return false;
    }

    public final boolean D(LayoutNode layoutNode, boolean z10) {
        LayoutNode h02;
        LayoutNode h03;
        if (!(layoutNode.V() != null)) {
            g0.a.b("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int i11 = b.f5488a[layoutNode.R().ordinal()];
        if (i11 == 1) {
            return false;
        }
        if (i11 == 2 || i11 == 3 || i11 == 4) {
            this.f5482h.b(new a(layoutNode, true, z10));
            h0 h0Var = this.f5484j;
            if (h0Var == null) {
                return false;
            }
            h0Var.a();
            return false;
        }
        if (i11 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        if (layoutNode.T() && !z10) {
            return false;
        }
        layoutNode.N0();
        layoutNode.O0();
        if (layoutNode.E0()) {
            return false;
        }
        if ((Intrinsics.c(layoutNode.G0(), Boolean.TRUE) || l(layoutNode)) && ((h02 = layoutNode.h0()) == null || !h02.T())) {
            this.f5476b.c(layoutNode, true);
        } else if ((layoutNode.n() || k(layoutNode)) && ((h03 = layoutNode.h0()) == null || !h03.Y())) {
            this.f5476b.c(layoutNode, false);
        }
        return !this.f5478d;
    }

    public final void E(LayoutNode layoutNode) {
        this.f5479e.d(layoutNode);
    }

    public final boolean F(LayoutNode layoutNode, boolean z10) {
        int i11 = b.f5488a[layoutNode.R().ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            h0 h0Var = this.f5484j;
            if (h0Var != null) {
                h0Var.a();
            }
        } else {
            if (i11 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            if (!z10 && layoutNode.n() == layoutNode.F0() && (layoutNode.Y() || layoutNode.Q())) {
                h0 h0Var2 = this.f5484j;
                if (h0Var2 != null) {
                    h0Var2.a();
                }
            } else {
                layoutNode.L0();
                if (!layoutNode.E0() && layoutNode.F0()) {
                    LayoutNode h02 = layoutNode.h0();
                    if ((h02 == null || !h02.Q()) && (h02 == null || !h02.Y())) {
                        this.f5476b.c(layoutNode, false);
                    }
                    if (!this.f5478d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean G(LayoutNode layoutNode, boolean z10) {
        int i11 = b.f5488a[layoutNode.R().ordinal()];
        if (i11 != 1 && i11 != 2) {
            if (i11 == 3 || i11 == 4) {
                this.f5482h.b(new a(layoutNode, false, z10));
                h0 h0Var = this.f5484j;
                if (h0Var != null) {
                    h0Var.a();
                }
            } else {
                if (i11 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!layoutNode.Y() || z10) {
                    layoutNode.O0();
                    if (!layoutNode.E0() && (layoutNode.n() || k(layoutNode))) {
                        LayoutNode h02 = layoutNode.h0();
                        if (h02 == null || !h02.Y()) {
                            this.f5476b.c(layoutNode, false);
                        }
                        if (!this.f5478d) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void I(long j11) {
        o0.b bVar = this.f5483i;
        if (bVar == null ? false : o0.b.f(bVar.r(), j11)) {
            return;
        }
        if (this.f5477c) {
            g0.a.a("updateRootConstraints called while measuring");
        }
        this.f5483i = o0.b.a(j11);
        if (this.f5475a.V() != null) {
            this.f5475a.N0();
        }
        this.f5475a.O0();
        j jVar = this.f5476b;
        LayoutNode layoutNode = this.f5475a;
        jVar.c(layoutNode, layoutNode.V() != null);
    }

    public final void c(boolean z10) {
        if (z10) {
            this.f5479e.e(this.f5475a);
        }
        this.f5479e.a();
    }

    public final void i(LayoutNode layoutNode, boolean z10) {
        if (this.f5476b.g(z10)) {
            return;
        }
        if (!this.f5477c) {
            g0.a.b("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (u(layoutNode, z10)) {
            g0.a.a("node not yet measured");
        }
        j(layoutNode, z10);
    }

    public final boolean m() {
        return this.f5476b.h();
    }

    public final boolean n() {
        return this.f5479e.c();
    }

    public final long q() {
        if (!this.f5477c) {
            g0.a.a("measureIteration should be only used during the measure/layout pass");
        }
        return this.f5481g;
    }

    public final boolean r(Function0 function0) {
        boolean z10;
        DepthSortedSet depthSortedSet;
        if (!this.f5475a.D0()) {
            g0.a.a("performMeasureAndLayout called with unattached root");
        }
        if (!this.f5475a.n()) {
            g0.a.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.f5477c) {
            g0.a.a("performMeasureAndLayout called during measure layout");
        }
        boolean z11 = false;
        if (this.f5483i != null) {
            this.f5477c = true;
            this.f5478d = true;
            try {
                if (this.f5476b.h()) {
                    j jVar = this.f5476b;
                    z10 = false;
                    while (jVar.h()) {
                        depthSortedSet = jVar.f5467a;
                        boolean d11 = depthSortedSet.d();
                        boolean z12 = !d11;
                        LayoutNode e11 = (!d11 ? jVar.f5467a : jVar.f5468b).e();
                        boolean z13 = z(this, e11, z12, false, 4, null);
                        if (e11 == this.f5475a && z13) {
                            z10 = true;
                        }
                    }
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else {
                    z10 = false;
                }
                this.f5477c = false;
                this.f5478d = false;
                h0 h0Var = this.f5484j;
                if (h0Var != null) {
                    h0Var.a();
                }
                z11 = z10;
            } catch (Throwable th2) {
                this.f5477c = false;
                this.f5478d = false;
                throw th2;
            }
        }
        b();
        return z11;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(androidx.compose.ui.node.LayoutNode r4, long r5) {
        /*
            r3 = this;
            boolean r0 = r4.E0()
            if (r0 == 0) goto L7
            return
        L7:
            androidx.compose.ui.node.LayoutNode r0 = r3.f5475a
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r4, r0)
            if (r0 == 0) goto L14
            java.lang.String r0 = "measureAndLayout called on root"
            g0.a.a(r0)
        L14:
            androidx.compose.ui.node.LayoutNode r0 = r3.f5475a
            boolean r0 = r0.D0()
            if (r0 != 0) goto L21
            java.lang.String r0 = "performMeasureAndLayout called with unattached root"
            g0.a.a(r0)
        L21:
            androidx.compose.ui.node.LayoutNode r0 = r3.f5475a
            boolean r0 = r0.n()
            if (r0 != 0) goto L2e
            java.lang.String r0 = "performMeasureAndLayout called with unplaced root"
            g0.a.a(r0)
        L2e:
            boolean r0 = r3.f5477c
            if (r0 == 0) goto L37
            java.lang.String r0 = "performMeasureAndLayout called during measure layout"
            g0.a.a(r0)
        L37:
            o0.b r0 = r3.f5483i
            if (r0 == 0) goto L9a
            r0 = 1
            r3.f5477c = r0
            r0 = 0
            r3.f5478d = r0
            androidx.compose.ui.node.j r1 = r3.f5476b     // Catch: java.lang.Throwable -> L57
            r1.i(r4)     // Catch: java.lang.Throwable -> L57
            o0.b r1 = o0.b.a(r5)     // Catch: java.lang.Throwable -> L57
            boolean r1 = r3.e(r4, r1)     // Catch: java.lang.Throwable -> L57
            if (r1 != 0) goto L59
            boolean r1 = r4.S()     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L68
            goto L59
        L57:
            r4 = move-exception
            goto L95
        L59:
            java.lang.Boolean r1 = r4.G0()     // Catch: java.lang.Throwable -> L57
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L57
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L68
            r4.K0()     // Catch: java.lang.Throwable -> L57
        L68:
            r3.h(r4)     // Catch: java.lang.Throwable -> L57
            o0.b r5 = o0.b.a(r5)     // Catch: java.lang.Throwable -> L57
            r3.f(r4, r5)     // Catch: java.lang.Throwable -> L57
            boolean r5 = r4.Q()     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L86
            boolean r5 = r4.n()     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L86
            r4.Z0()     // Catch: java.lang.Throwable -> L57
            androidx.compose.ui.node.OnPositionedDispatcher r5 = r3.f5479e     // Catch: java.lang.Throwable -> L57
            r5.d(r4)     // Catch: java.lang.Throwable -> L57
        L86:
            r3.g()     // Catch: java.lang.Throwable -> L57
            r3.f5477c = r0
            r3.f5478d = r0
            androidx.compose.ui.node.h0 r4 = r3.f5484j
            if (r4 == 0) goto L9a
            r4.a()
            goto L9a
        L95:
            r3.f5477c = r0
            r3.f5478d = r0
            throw r4
        L9a:
            r3.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.k0.s(androidx.compose.ui.node.LayoutNode, long):void");
    }

    public final void t() {
        if (this.f5476b.h()) {
            if (!this.f5475a.D0()) {
                g0.a.a("performMeasureAndLayout called with unattached root");
            }
            if (!this.f5475a.n()) {
                g0.a.a("performMeasureAndLayout called with unplaced root");
            }
            if (this.f5477c) {
                g0.a.a("performMeasureAndLayout called during measure layout");
            }
            if (this.f5483i != null) {
                this.f5477c = true;
                this.f5478d = false;
                try {
                    if (!this.f5476b.g(true)) {
                        if (this.f5475a.V() != null) {
                            B(this.f5475a, true);
                        } else {
                            A(this.f5475a);
                        }
                    }
                    B(this.f5475a, false);
                    this.f5477c = false;
                    this.f5478d = false;
                    h0 h0Var = this.f5484j;
                    if (h0Var != null) {
                        h0Var.a();
                    }
                } catch (Throwable th2) {
                    this.f5477c = false;
                    this.f5478d = false;
                    throw th2;
                }
            }
        }
    }

    public final void v(LayoutNode layoutNode) {
        this.f5476b.i(layoutNode);
        this.f5479e.f(layoutNode);
    }

    public final void x(y0.b bVar) {
        this.f5480f.b(bVar);
    }
}
