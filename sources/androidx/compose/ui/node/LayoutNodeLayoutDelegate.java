package androidx.compose.ui.node;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o0.p;

/* loaded from: classes.dex */
public final class LayoutNodeLayoutDelegate {

    /* renamed from: a, reason: collision with root package name */
    private final LayoutNode f5342a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5343b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5345d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5346e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5347f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5348g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5349h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5350i;

    /* renamed from: j, reason: collision with root package name */
    private int f5351j;

    /* renamed from: k, reason: collision with root package name */
    private int f5352k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5353l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5354m;

    /* renamed from: n, reason: collision with root package name */
    private int f5355n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5356o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5357p;

    /* renamed from: q, reason: collision with root package name */
    private int f5358q;

    /* renamed from: s, reason: collision with root package name */
    private LookaheadPassDelegate f5360s;

    /* renamed from: c, reason: collision with root package name */
    private LayoutNode.LayoutState f5344c = LayoutNode.LayoutState.Idle;

    /* renamed from: r, reason: collision with root package name */
    private final MeasurePassDelegate f5359r = new MeasurePassDelegate();

    /* renamed from: t, reason: collision with root package name */
    private long f5361t = o0.c.b(0, 0, 0, 0, 15, null);

    /* renamed from: u, reason: collision with root package name */
    private final Function0 f5362u = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m130invoke();
            return Unit.f67184a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m130invoke() {
            long j11;
            NodeCoordinator K = LayoutNodeLayoutDelegate.this.K();
            j11 = LayoutNodeLayoutDelegate.this.f5361t;
            K.P(j11);
        }
    };

    /* loaded from: classes.dex */
    public final class LookaheadPassDelegate extends androidx.compose.ui.layout.g0 implements androidx.compose.ui.layout.s, androidx.compose.ui.node.a, m0 {

        /* renamed from: f, reason: collision with root package name */
        private boolean f5363f;

        /* renamed from: j, reason: collision with root package name */
        private boolean f5367j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f5368k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f5369l;

        /* renamed from: m, reason: collision with root package name */
        private o0.b f5370m;

        /* renamed from: o, reason: collision with root package name */
        private float f5372o;

        /* renamed from: p, reason: collision with root package name */
        private Function1 f5373p;

        /* renamed from: q, reason: collision with root package name */
        private GraphicsLayer f5374q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f5375r;

        /* renamed from: v, reason: collision with root package name */
        private boolean f5379v;

        /* renamed from: y, reason: collision with root package name */
        private boolean f5382y;

        /* renamed from: z, reason: collision with root package name */
        private boolean f5383z;

        /* renamed from: g, reason: collision with root package name */
        private int f5364g = Integer.MAX_VALUE;

        /* renamed from: h, reason: collision with root package name */
        private int f5365h = Integer.MAX_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private LayoutNode.UsageByParent f5366i = LayoutNode.UsageByParent.NotUsed;

        /* renamed from: n, reason: collision with root package name */
        private long f5371n = o0.p.f70738b.a();

        /* renamed from: s, reason: collision with root package name */
        private final AlignmentLines f5376s = new i0(this);

        /* renamed from: t, reason: collision with root package name */
        private final androidx.compose.runtime.collection.b f5377t = new androidx.compose.runtime.collection.b(new LookaheadPassDelegate[16], 0);

        /* renamed from: u, reason: collision with root package name */
        private boolean f5378u = true;

        /* renamed from: w, reason: collision with root package name */
        private boolean f5380w = true;

        /* renamed from: x, reason: collision with root package name */
        private Object f5381x = X0().G();

        /* loaded from: classes.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5384a;

            /* renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f5385b;

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
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f5384a = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                f5385b = iArr2;
            }
        }

        public LookaheadPassDelegate() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void P0() {
            androidx.compose.runtime.collection.b p02 = LayoutNodeLayoutDelegate.this.f5342a.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    LookaheadPassDelegate H = ((LayoutNode) m11[i11]).P().H();
                    Intrinsics.e(H);
                    int i12 = H.f5364g;
                    int i13 = H.f5365h;
                    if (i12 != i13 && i13 == Integer.MAX_VALUE) {
                        H.e1();
                    }
                    i11++;
                } while (i11 < n11);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void R0() {
            int i11 = 0;
            LayoutNodeLayoutDelegate.this.f5351j = 0;
            androidx.compose.runtime.collection.b p02 = LayoutNodeLayoutDelegate.this.f5342a.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                do {
                    LookaheadPassDelegate H = ((LayoutNode) m11[i11]).P().H();
                    Intrinsics.e(H);
                    H.f5364g = H.f5365h;
                    H.f5365h = Integer.MAX_VALUE;
                    if (H.f5366i == LayoutNode.UsageByParent.InLayoutBlock) {
                        H.f5366i = LayoutNode.UsageByParent.NotUsed;
                    }
                    i11++;
                } while (i11 < n11);
            }
        }

        private final void d1() {
            boolean n11 = n();
            p1(true);
            if (!n11 && LayoutNodeLayoutDelegate.this.G()) {
                LayoutNode.d1(LayoutNodeLayoutDelegate.this.f5342a, true, false, false, 6, null);
            }
            androidx.compose.runtime.collection.b p02 = LayoutNodeLayoutDelegate.this.f5342a.p0();
            int n12 = p02.n();
            if (n12 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) m11[i11];
                    LookaheadPassDelegate U = layoutNode.U();
                    if (U == null) {
                        throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
                    }
                    if (U.f5365h != Integer.MAX_VALUE) {
                        U.d1();
                        layoutNode.i1(layoutNode);
                    }
                    i11++;
                } while (i11 < n12);
            }
        }

        private final void e1() {
            if (n()) {
                int i11 = 0;
                p1(false);
                androidx.compose.runtime.collection.b p02 = LayoutNodeLayoutDelegate.this.f5342a.p0();
                int n11 = p02.n();
                if (n11 > 0) {
                    Object[] m11 = p02.m();
                    do {
                        LookaheadPassDelegate H = ((LayoutNode) m11[i11]).P().H();
                        Intrinsics.e(H);
                        H.e1();
                        i11++;
                    } while (i11 < n11);
                }
            }
        }

        private final void g1() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            androidx.compose.runtime.collection.b p02 = layoutNode.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                    if (layoutNode2.T() && layoutNode2.b0() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LookaheadPassDelegate H = layoutNode2.P().H();
                        Intrinsics.e(H);
                        o0.b z10 = layoutNode2.P().z();
                        Intrinsics.e(z10);
                        if (H.k1(z10.r())) {
                            LayoutNode.d1(layoutNodeLayoutDelegate.f5342a, false, false, false, 7, null);
                        }
                    }
                    i11++;
                } while (i11 < n11);
            }
        }

        private final void j1(final long j11, float f11, Function1 function1, GraphicsLayer graphicsLayer) {
            if (LayoutNodeLayoutDelegate.this.f5342a.E0()) {
                g0.a.a("place is called on a deactivated node");
            }
            LayoutNodeLayoutDelegate.this.f5344c = LayoutNode.LayoutState.LookaheadLayingOut;
            this.f5368k = true;
            this.f5383z = false;
            if (!o0.p.g(j11, this.f5371n)) {
                if (LayoutNodeLayoutDelegate.this.D() || LayoutNodeLayoutDelegate.this.E()) {
                    LayoutNodeLayoutDelegate.this.f5349h = true;
                }
                f1();
            }
            final y0 b11 = f0.b(LayoutNodeLayoutDelegate.this.f5342a);
            if (LayoutNodeLayoutDelegate.this.F() || !n()) {
                LayoutNodeLayoutDelegate.this.a0(false);
                v().r(false);
                OwnerSnapshotObserver snapshotObserver = b11.getSnapshotObserver();
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
                final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                OwnerSnapshotObserver.d(snapshotObserver, layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeSelf$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m126invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m126invoke() {
                        j0 U1;
                        g0.a aVar = null;
                        if (g0.a(LayoutNodeLayoutDelegate.this.f5342a)) {
                            NodeCoordinator a22 = LayoutNodeLayoutDelegate.this.K().a2();
                            if (a22 != null) {
                                aVar = a22.d1();
                            }
                        } else {
                            NodeCoordinator a23 = LayoutNodeLayoutDelegate.this.K().a2();
                            if (a23 != null && (U1 = a23.U1()) != null) {
                                aVar = U1.d1();
                            }
                        }
                        if (aVar == null) {
                            aVar = b11.getPlacementScope();
                        }
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = LayoutNodeLayoutDelegate.this;
                        long j12 = j11;
                        j0 U12 = layoutNodeLayoutDelegate2.K().U1();
                        Intrinsics.e(U12);
                        g0.a.j(aVar, U12, j12, 0.0f, 2, null);
                    }
                }, 2, null);
            } else {
                j0 U1 = LayoutNodeLayoutDelegate.this.K().U1();
                Intrinsics.e(U1);
                U1.z1(j11);
                i1();
            }
            this.f5371n = j11;
            this.f5372o = f11;
            this.f5373p = function1;
            this.f5374q = graphicsLayer;
            LayoutNodeLayoutDelegate.this.f5344c = LayoutNode.LayoutState.Idle;
        }

        private final void q1(LayoutNode layoutNode) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode h02 = layoutNode.h0();
            if (h02 == null) {
                this.f5366i = LayoutNode.UsageByParent.NotUsed;
                return;
            }
            if (!(this.f5366i == LayoutNode.UsageByParent.NotUsed || layoutNode.B())) {
                g0.a.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int i11 = a.f5384a[h02.R().ordinal()];
            if (i11 == 1 || i11 == 2) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i11 != 3 && i11 != 4) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + h02.R());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            this.f5366i = usageByParent;
        }

        @Override // androidx.compose.ui.node.a
        public androidx.compose.ui.node.a D() {
            LayoutNodeLayoutDelegate P;
            LayoutNode h02 = LayoutNodeLayoutDelegate.this.f5342a.h0();
            if (h02 == null || (P = h02.P()) == null) {
                return null;
            }
            return P.C();
        }

        @Override // androidx.compose.ui.layout.g0, androidx.compose.ui.layout.i
        public Object G() {
            return this.f5381x;
        }

        @Override // androidx.compose.ui.node.a
        public void I() {
            this.f5379v = true;
            v().o();
            if (LayoutNodeLayoutDelegate.this.F()) {
                g1();
            }
            final j0 U1 = M().U1();
            Intrinsics.e(U1);
            if (LayoutNodeLayoutDelegate.this.f5350i || (!this.f5367j && !U1.j1() && LayoutNodeLayoutDelegate.this.F())) {
                LayoutNodeLayoutDelegate.this.f5349h = false;
                LayoutNode.LayoutState B = LayoutNodeLayoutDelegate.this.B();
                LayoutNodeLayoutDelegate.this.f5344c = LayoutNode.LayoutState.LookaheadLayingOut;
                y0 b11 = f0.b(LayoutNodeLayoutDelegate.this.f5342a);
                LayoutNodeLayoutDelegate.this.b0(false);
                OwnerSnapshotObserver snapshotObserver = b11.getSnapshotObserver();
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
                final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                OwnerSnapshotObserver.f(snapshotObserver, layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m125invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m125invoke() {
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.R0();
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.U(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((a) obj);
                                return Unit.f67184a;
                            }

                            public final void invoke(a aVar) {
                                aVar.v().t(false);
                            }
                        });
                        j0 U12 = LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.M().U1();
                        if (U12 != null) {
                            boolean j12 = U12.j1();
                            List E = layoutNodeLayoutDelegate.f5342a.E();
                            int size = E.size();
                            for (int i11 = 0; i11 < size; i11++) {
                                j0 U13 = ((LayoutNode) E.get(i11)).f0().U1();
                                if (U13 != null) {
                                    U13.n1(j12);
                                }
                            }
                        }
                        U1.b1().w();
                        j0 U14 = LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.M().U1();
                        if (U14 != null) {
                            U14.j1();
                            List E2 = layoutNodeLayoutDelegate.f5342a.E();
                            int size2 = E2.size();
                            for (int i12 = 0; i12 < size2; i12++) {
                                j0 U15 = ((LayoutNode) E2.get(i12)).f0().U1();
                                if (U15 != null) {
                                    U15.n1(false);
                                }
                            }
                        }
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.P0();
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.U(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((a) obj);
                                return Unit.f67184a;
                            }

                            public final void invoke(a aVar) {
                                aVar.v().q(aVar.v().l());
                            }
                        });
                    }
                }, 2, null);
                LayoutNodeLayoutDelegate.this.f5344c = B;
                if (LayoutNodeLayoutDelegate.this.E() && U1.j1()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.f5350i = false;
            }
            if (v().l()) {
                v().q(true);
            }
            if (v().g() && v().k()) {
                v().n();
            }
            this.f5379v = false;
        }

        @Override // androidx.compose.ui.node.a
        public NodeCoordinator M() {
            return LayoutNodeLayoutDelegate.this.f5342a.M();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        
            if ((r0 != null ? r0.R() : null) == androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut) goto L13;
         */
        @Override // androidx.compose.ui.layout.s
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.compose.ui.layout.g0 P(long r4) {
            /*
                r3 = this;
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.a(r0)
                androidx.compose.ui.node.LayoutNode r0 = r0.h0()
                r1 = 0
                if (r0 == 0) goto L12
                androidx.compose.ui.node.LayoutNode$LayoutState r0 = r0.R()
                goto L13
            L12:
                r0 = r1
            L13:
                androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
                if (r0 == r2) goto L2b
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.a(r0)
                androidx.compose.ui.node.LayoutNode r0 = r0.h0()
                if (r0 == 0) goto L27
                androidx.compose.ui.node.LayoutNode$LayoutState r1 = r0.R()
            L27:
                androidx.compose.ui.node.LayoutNode$LayoutState r0 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut
                if (r1 != r0) goto L31
            L2b:
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                r1 = 0
                androidx.compose.ui.node.LayoutNodeLayoutDelegate.i(r0, r1)
            L31:
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.a(r0)
                r3.q1(r0)
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.a(r0)
                androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r0.O()
                androidx.compose.ui.node.LayoutNode$UsageByParent r1 = androidx.compose.ui.node.LayoutNode.UsageByParent.NotUsed
                if (r0 != r1) goto L51
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.a(r0)
                r0.s()
            L51:
                r3.k1(r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate.P(long):androidx.compose.ui.layout.g0");
        }

        public final List S0() {
            LayoutNodeLayoutDelegate.this.f5342a.E();
            if (!this.f5378u) {
                return this.f5377t.g();
            }
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
            androidx.compose.runtime.collection.b bVar = this.f5377t;
            androidx.compose.runtime.collection.b p02 = layoutNode.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                    if (bVar.n() <= i11) {
                        LookaheadPassDelegate H = layoutNode2.P().H();
                        Intrinsics.e(H);
                        bVar.b(H);
                    } else {
                        LookaheadPassDelegate H2 = layoutNode2.P().H();
                        Intrinsics.e(H2);
                        bVar.y(i11, H2);
                    }
                    i11++;
                } while (i11 < n11);
            }
            bVar.w(layoutNode.E().size(), bVar.n());
            this.f5378u = false;
            return this.f5377t.g();
        }

        public final o0.b T0() {
            return this.f5370m;
        }

        @Override // androidx.compose.ui.node.a
        public void U(Function1 function1) {
            androidx.compose.runtime.collection.b p02 = LayoutNodeLayoutDelegate.this.f5342a.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    androidx.compose.ui.node.a C = ((LayoutNode) m11[i11]).P().C();
                    Intrinsics.e(C);
                    function1.invoke(C);
                    i11++;
                } while (i11 < n11);
            }
        }

        @Override // androidx.compose.ui.node.m0
        public void V(boolean z10) {
            j0 U1;
            j0 U12 = LayoutNodeLayoutDelegate.this.K().U1();
            if (!Intrinsics.c(Boolean.valueOf(z10), U12 != null ? Boolean.valueOf(U12.i1()) : null) && (U1 = LayoutNodeLayoutDelegate.this.K().U1()) != null) {
                U1.V(z10);
            }
            this.f5382y = z10;
        }

        public final boolean W0() {
            return this.f5379v;
        }

        public final MeasurePassDelegate X0() {
            return LayoutNodeLayoutDelegate.this.I();
        }

        @Override // androidx.compose.ui.node.a
        public void Z() {
            LayoutNode.d1(LayoutNodeLayoutDelegate.this.f5342a, false, false, false, 7, null);
        }

        public final LayoutNode.UsageByParent Z0() {
            return this.f5366i;
        }

        public final boolean a1() {
            return this.f5368k;
        }

        public final void b1(boolean z10) {
            LayoutNode layoutNode;
            LayoutNode h02 = LayoutNodeLayoutDelegate.this.f5342a.h0();
            LayoutNode.UsageByParent O = LayoutNodeLayoutDelegate.this.f5342a.O();
            if (h02 == null || O == LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            do {
                layoutNode = h02;
                if (layoutNode.O() != O) {
                    break;
                } else {
                    h02 = layoutNode.h0();
                }
            } while (h02 != null);
            int i11 = a.f5385b[O.ordinal()];
            if (i11 == 1) {
                if (layoutNode.V() != null) {
                    LayoutNode.d1(layoutNode, z10, false, false, 6, null);
                    return;
                } else {
                    LayoutNode.h1(layoutNode, z10, false, false, 6, null);
                    return;
                }
            }
            if (i11 != 2) {
                throw new IllegalStateException("Intrinsics isn't used by the parent");
            }
            if (layoutNode.V() != null) {
                layoutNode.a1(z10);
            } else {
                layoutNode.e1(z10);
            }
        }

        public final void c1() {
            this.f5380w = true;
        }

        public final void f1() {
            androidx.compose.runtime.collection.b p02;
            int n11;
            if (LayoutNodeLayoutDelegate.this.t() <= 0 || (n11 = (p02 = LayoutNodeLayoutDelegate.this.f5342a.p0()).n()) <= 0) {
                return;
            }
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) m11[i11];
                LayoutNodeLayoutDelegate P = layoutNode.P();
                if ((P.E() || P.D()) && !P.F()) {
                    LayoutNode.b1(layoutNode, false, 1, null);
                }
                LookaheadPassDelegate H = P.H();
                if (H != null) {
                    H.f1();
                }
                i11++;
            } while (i11 < n11);
        }

        public final void h1() {
            this.f5365h = Integer.MAX_VALUE;
            this.f5364g = Integer.MAX_VALUE;
            p1(false);
        }

        public final void i1() {
            this.f5383z = true;
            LayoutNode h02 = LayoutNodeLayoutDelegate.this.f5342a.h0();
            if (!n()) {
                d1();
                if (this.f5363f && h02 != null) {
                    LayoutNode.b1(h02, false, 1, null);
                }
            }
            if (h02 == null) {
                this.f5365h = 0;
            } else if (!this.f5363f && (h02.R() == LayoutNode.LayoutState.LayingOut || h02.R() == LayoutNode.LayoutState.LookaheadLayingOut)) {
                if (!(this.f5365h == Integer.MAX_VALUE)) {
                    g0.a.b("Place was called on a node which was placed already");
                }
                this.f5365h = h02.P().f5351j;
                h02.P().f5351j++;
            }
            I();
        }

        public final boolean k1(long j11) {
            if (LayoutNodeLayoutDelegate.this.f5342a.E0()) {
                g0.a.a("measure is called on a deactivated node");
            }
            LayoutNode h02 = LayoutNodeLayoutDelegate.this.f5342a.h0();
            LayoutNodeLayoutDelegate.this.f5342a.l1(LayoutNodeLayoutDelegate.this.f5342a.B() || (h02 != null && h02.B()));
            if (!LayoutNodeLayoutDelegate.this.f5342a.T()) {
                o0.b bVar = this.f5370m;
                if (bVar == null ? false : o0.b.f(bVar.r(), j11)) {
                    y0 g02 = LayoutNodeLayoutDelegate.this.f5342a.g0();
                    if (g02 != null) {
                        g02.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.this.f5342a, true);
                    }
                    LayoutNodeLayoutDelegate.this.f5342a.k1();
                    return false;
                }
            }
            this.f5370m = o0.b.a(j11);
            F0(j11);
            v().s(false);
            U(new Function1<androidx.compose.ui.node.a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((a) obj);
                    return Unit.f67184a;
                }

                public final void invoke(a aVar) {
                    aVar.v().u(false);
                }
            });
            long r02 = this.f5369l ? r0() : o0.u.a(Integer.MIN_VALUE, Integer.MIN_VALUE);
            this.f5369l = true;
            j0 U1 = LayoutNodeLayoutDelegate.this.K().U1();
            if (!(U1 != null)) {
                g0.a.b("Lookahead result from lookaheadRemeasure cannot be null");
            }
            LayoutNodeLayoutDelegate.this.T(j11);
            B0(o0.u.a(U1.u0(), U1.l0()));
            return (o0.t.g(r02) == U1.u0() && o0.t.f(r02) == U1.l0()) ? false : true;
        }

        public final void l1() {
            LayoutNode h02;
            try {
                this.f5363f = true;
                if (!this.f5368k) {
                    g0.a.b("replace() called on item that was not placed");
                }
                this.f5383z = false;
                boolean n11 = n();
                j1(this.f5371n, 0.0f, this.f5373p, this.f5374q);
                if (n11 && !this.f5383z && (h02 = LayoutNodeLayoutDelegate.this.f5342a.h0()) != null) {
                    LayoutNode.b1(h02, false, 1, null);
                }
                this.f5363f = false;
            } catch (Throwable th2) {
                this.f5363f = false;
                throw th2;
            }
        }

        public final void m1(boolean z10) {
            this.f5378u = z10;
        }

        @Override // androidx.compose.ui.node.a
        public boolean n() {
            return this.f5375r;
        }

        public final void n1(LayoutNode.UsageByParent usageByParent) {
            this.f5366i = usageByParent;
        }

        public final void o1(int i11) {
            this.f5365h = i11;
        }

        public void p1(boolean z10) {
            this.f5375r = z10;
        }

        public final boolean r1() {
            if (G() == null) {
                j0 U1 = LayoutNodeLayoutDelegate.this.K().U1();
                Intrinsics.e(U1);
                if (U1.G() == null) {
                    return false;
                }
            }
            if (!this.f5380w) {
                return false;
            }
            this.f5380w = false;
            j0 U12 = LayoutNodeLayoutDelegate.this.K().U1();
            Intrinsics.e(U12);
            this.f5381x = U12.G();
            return true;
        }

        @Override // androidx.compose.ui.node.a
        public void requestLayout() {
            LayoutNode.b1(LayoutNodeLayoutDelegate.this.f5342a, false, 1, null);
        }

        @Override // androidx.compose.ui.node.a
        public AlignmentLines v() {
            return this.f5376s;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.g0
        public void w0(long j11, float f11, GraphicsLayer graphicsLayer) {
            j1(j11, f11, null, graphicsLayer);
        }

        @Override // androidx.compose.ui.node.a
        public Map z() {
            if (!this.f5367j) {
                if (LayoutNodeLayoutDelegate.this.B() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    v().s(true);
                    if (v().g()) {
                        LayoutNodeLayoutDelegate.this.P();
                    }
                } else {
                    v().r(true);
                }
            }
            j0 U1 = M().U1();
            if (U1 != null) {
                U1.n1(true);
            }
            I();
            j0 U12 = M().U1();
            if (U12 != null) {
                U12.n1(false);
            }
            return v().h();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.g0
        public void z0(long j11, float f11, Function1 function1) {
            j1(j11, f11, function1, null);
        }
    }

    /* loaded from: classes.dex */
    public final class MeasurePassDelegate extends androidx.compose.ui.layout.g0 implements androidx.compose.ui.layout.s, androidx.compose.ui.node.a, m0 {
        private boolean A;
        private Function1 B;
        private GraphicsLayer C;
        private long D;
        private float E;
        private final Function0 F;
        private boolean G;
        private boolean H;

        /* renamed from: f, reason: collision with root package name */
        private boolean f5386f;

        /* renamed from: i, reason: collision with root package name */
        private boolean f5389i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f5390j;

        /* renamed from: l, reason: collision with root package name */
        private boolean f5392l;

        /* renamed from: m, reason: collision with root package name */
        private long f5393m;

        /* renamed from: n, reason: collision with root package name */
        private Function1 f5394n;

        /* renamed from: o, reason: collision with root package name */
        private GraphicsLayer f5395o;

        /* renamed from: p, reason: collision with root package name */
        private float f5396p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f5397q;

        /* renamed from: r, reason: collision with root package name */
        private Object f5398r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f5399s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f5400t;

        /* renamed from: u, reason: collision with root package name */
        private final AlignmentLines f5401u;

        /* renamed from: v, reason: collision with root package name */
        private final androidx.compose.runtime.collection.b f5402v;

        /* renamed from: w, reason: collision with root package name */
        private boolean f5403w;

        /* renamed from: x, reason: collision with root package name */
        private boolean f5404x;

        /* renamed from: y, reason: collision with root package name */
        private final Function0 f5405y;

        /* renamed from: z, reason: collision with root package name */
        private float f5406z;

        /* renamed from: g, reason: collision with root package name */
        private int f5387g = Integer.MAX_VALUE;

        /* renamed from: h, reason: collision with root package name */
        private int f5388h = Integer.MAX_VALUE;

        /* renamed from: k, reason: collision with root package name */
        private LayoutNode.UsageByParent f5391k = LayoutNode.UsageByParent.NotUsed;

        /* loaded from: classes.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5407a;

            /* renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f5408b;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                try {
                    iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f5407a = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                f5408b = iArr2;
            }
        }

        public MeasurePassDelegate() {
            p.a aVar = o0.p.f70738b;
            this.f5393m = aVar.a();
            this.f5397q = true;
            this.f5401u = new c0(this);
            this.f5402v = new androidx.compose.runtime.collection.b(new MeasurePassDelegate[16], 0);
            this.f5403w = true;
            this.f5405y = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m127invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m127invoke() {
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.X0();
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.U(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((a) obj);
                            return Unit.f67184a;
                        }

                        public final void invoke(a aVar2) {
                            aVar2.v().t(false);
                        }
                    });
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.M().b1().w();
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.W0();
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.U(new Function1<a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((a) obj);
                            return Unit.f67184a;
                        }

                        public final void invoke(a aVar2) {
                            aVar2.v().q(aVar2.v().l());
                        }
                    });
                }
            };
            this.D = aVar.a();
            this.F = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinatorBlock$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m128invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m128invoke() {
                    g0.a placementScope;
                    Function1 function1;
                    GraphicsLayer graphicsLayer;
                    long j11;
                    float f11;
                    long j12;
                    float f12;
                    long j13;
                    float f13;
                    NodeCoordinator a22 = LayoutNodeLayoutDelegate.this.K().a2();
                    if (a22 == null || (placementScope = a22.d1()) == null) {
                        placementScope = f0.b(LayoutNodeLayoutDelegate.this.f5342a).getPlacementScope();
                    }
                    g0.a aVar2 = placementScope;
                    LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = this;
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                    function1 = measurePassDelegate.B;
                    graphicsLayer = measurePassDelegate.C;
                    if (graphicsLayer != null) {
                        NodeCoordinator K = layoutNodeLayoutDelegate.K();
                        j13 = measurePassDelegate.D;
                        f13 = measurePassDelegate.E;
                        aVar2.v(K, j13, graphicsLayer, f13);
                        return;
                    }
                    if (function1 == null) {
                        NodeCoordinator K2 = layoutNodeLayoutDelegate.K();
                        j12 = measurePassDelegate.D;
                        f12 = measurePassDelegate.E;
                        aVar2.i(K2, j12, f12);
                        return;
                    }
                    NodeCoordinator K3 = layoutNodeLayoutDelegate.K();
                    j11 = measurePassDelegate.D;
                    f11 = measurePassDelegate.E;
                    aVar2.u(K3, j11, f11, function1);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void W0() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
            androidx.compose.runtime.collection.b p02 = layoutNode.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                    if (layoutNode2.X().f5387g != layoutNode2.i0()) {
                        layoutNode.S0();
                        layoutNode.w0();
                        if (layoutNode2.i0() == Integer.MAX_VALUE) {
                            layoutNode2.X().k1();
                        }
                    }
                    i11++;
                } while (i11 < n11);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void X0() {
            LayoutNodeLayoutDelegate.this.f5352k = 0;
            androidx.compose.runtime.collection.b p02 = LayoutNodeLayoutDelegate.this.f5342a.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    MeasurePassDelegate X = ((LayoutNode) m11[i11]).X();
                    X.f5387g = X.f5388h;
                    X.f5388h = Integer.MAX_VALUE;
                    X.f5400t = false;
                    if (X.f5391k == LayoutNode.UsageByParent.InLayoutBlock) {
                        X.f5391k = LayoutNode.UsageByParent.NotUsed;
                    }
                    i11++;
                } while (i11 < n11);
            }
        }

        private final void j1() {
            boolean n11 = n();
            v1(true);
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
            if (!n11) {
                if (layoutNode.Y()) {
                    LayoutNode.h1(layoutNode, true, false, false, 6, null);
                } else if (layoutNode.T()) {
                    LayoutNode.d1(layoutNode, true, false, false, 6, null);
                }
            }
            NodeCoordinator Z1 = layoutNode.M().Z1();
            for (NodeCoordinator f02 = layoutNode.f0(); !Intrinsics.c(f02, Z1) && f02 != null; f02 = f02.Z1()) {
                if (f02.R1()) {
                    f02.j2();
                }
            }
            androidx.compose.runtime.collection.b p02 = layoutNode.p0();
            int n12 = p02.n();
            if (n12 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                    if (layoutNode2.i0() != Integer.MAX_VALUE) {
                        layoutNode2.X().j1();
                        layoutNode.i1(layoutNode2);
                    }
                    i11++;
                } while (i11 < n12);
            }
        }

        private final void k1() {
            if (n()) {
                int i11 = 0;
                v1(false);
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
                NodeCoordinator Z1 = layoutNode.M().Z1();
                for (NodeCoordinator f02 = layoutNode.f0(); !Intrinsics.c(f02, Z1) && f02 != null; f02 = f02.Z1()) {
                    f02.z2();
                }
                androidx.compose.runtime.collection.b p02 = LayoutNodeLayoutDelegate.this.f5342a.p0();
                int n11 = p02.n();
                if (n11 > 0) {
                    Object[] m11 = p02.m();
                    do {
                        ((LayoutNode) m11[i11]).X().k1();
                        i11++;
                    } while (i11 < n11);
                }
            }
        }

        private final void m1() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            androidx.compose.runtime.collection.b p02 = layoutNode.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                    if (layoutNode2.Y() && layoutNode2.a0() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.W0(layoutNode2, null, 1, null)) {
                        LayoutNode.h1(layoutNodeLayoutDelegate.f5342a, false, false, false, 7, null);
                    }
                    i11++;
                } while (i11 < n11);
            }
        }

        private final void p1(long j11, float f11, Function1 function1, GraphicsLayer graphicsLayer) {
            if (LayoutNodeLayoutDelegate.this.f5342a.E0()) {
                g0.a.a("place is called on a deactivated node");
            }
            LayoutNodeLayoutDelegate.this.f5344c = LayoutNode.LayoutState.LayingOut;
            this.f5393m = j11;
            this.f5396p = f11;
            this.f5394n = function1;
            this.f5395o = graphicsLayer;
            this.f5390j = true;
            this.A = false;
            y0 b11 = f0.b(LayoutNodeLayoutDelegate.this.f5342a);
            if (LayoutNodeLayoutDelegate.this.A() || !n()) {
                v().r(false);
                LayoutNodeLayoutDelegate.this.Y(false);
                this.B = function1;
                this.D = j11;
                this.E = f11;
                this.C = graphicsLayer;
                b11.getSnapshotObserver().c(LayoutNodeLayoutDelegate.this.f5342a, false, this.F);
            } else {
                LayoutNodeLayoutDelegate.this.K().w2(j11, f11, function1, graphicsLayer);
                o1();
            }
            LayoutNodeLayoutDelegate.this.f5344c = LayoutNode.LayoutState.Idle;
        }

        private final void q1(long j11, float f11, Function1 function1, GraphicsLayer graphicsLayer) {
            g0.a placementScope;
            this.f5400t = true;
            if (!o0.p.g(j11, this.f5393m) || this.G) {
                if (LayoutNodeLayoutDelegate.this.u() || LayoutNodeLayoutDelegate.this.v() || this.G) {
                    LayoutNodeLayoutDelegate.this.f5346e = true;
                    this.G = false;
                }
                l1();
            }
            if (g0.a(LayoutNodeLayoutDelegate.this.f5342a)) {
                NodeCoordinator a22 = LayoutNodeLayoutDelegate.this.K().a2();
                if (a22 == null || (placementScope = a22.d1()) == null) {
                    placementScope = f0.b(LayoutNodeLayoutDelegate.this.f5342a).getPlacementScope();
                }
                g0.a aVar = placementScope;
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                LookaheadPassDelegate H = layoutNodeLayoutDelegate.H();
                Intrinsics.e(H);
                LayoutNode h02 = layoutNodeLayoutDelegate.f5342a.h0();
                if (h02 != null) {
                    h02.P().f5351j = 0;
                }
                H.o1(Integer.MAX_VALUE);
                g0.a.h(aVar, H, o0.p.h(j11), o0.p.i(j11), 0.0f, 4, null);
            }
            LookaheadPassDelegate H2 = LayoutNodeLayoutDelegate.this.H();
            if ((H2 == null || H2.a1()) ? false : true) {
                g0.a.b("Error: Placement happened before lookahead.");
            }
            p1(j11, f11, function1, graphicsLayer);
        }

        private final void w1(LayoutNode layoutNode) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode h02 = layoutNode.h0();
            if (h02 == null) {
                this.f5391k = LayoutNode.UsageByParent.NotUsed;
                return;
            }
            if (!(this.f5391k == LayoutNode.UsageByParent.NotUsed || layoutNode.B())) {
                g0.a.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int i11 = a.f5407a[h02.R().ordinal()];
            if (i11 == 1) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + h02.R());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            this.f5391k = usageByParent;
        }

        @Override // androidx.compose.ui.node.a
        public androidx.compose.ui.node.a D() {
            LayoutNodeLayoutDelegate P;
            LayoutNode h02 = LayoutNodeLayoutDelegate.this.f5342a.h0();
            if (h02 == null || (P = h02.P()) == null) {
                return null;
            }
            return P.r();
        }

        @Override // androidx.compose.ui.layout.g0, androidx.compose.ui.layout.i
        public Object G() {
            return this.f5398r;
        }

        @Override // androidx.compose.ui.node.a
        public void I() {
            this.f5404x = true;
            v().o();
            if (LayoutNodeLayoutDelegate.this.A()) {
                m1();
            }
            if (LayoutNodeLayoutDelegate.this.f5347f || (!this.f5392l && !M().j1() && LayoutNodeLayoutDelegate.this.A())) {
                LayoutNodeLayoutDelegate.this.f5346e = false;
                LayoutNode.LayoutState B = LayoutNodeLayoutDelegate.this.B();
                LayoutNodeLayoutDelegate.this.f5344c = LayoutNode.LayoutState.LayingOut;
                LayoutNodeLayoutDelegate.this.Z(false);
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
                f0.b(layoutNode).getSnapshotObserver().e(layoutNode, false, this.f5405y);
                LayoutNodeLayoutDelegate.this.f5344c = B;
                if (M().j1() && LayoutNodeLayoutDelegate.this.v()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.f5347f = false;
            }
            if (v().l()) {
                v().q(true);
            }
            if (v().g() && v().k()) {
                v().n();
            }
            this.f5404x = false;
        }

        @Override // androidx.compose.ui.node.a
        public NodeCoordinator M() {
            return LayoutNodeLayoutDelegate.this.f5342a.M();
        }

        @Override // androidx.compose.ui.layout.s
        public androidx.compose.ui.layout.g0 P(long j11) {
            LayoutNode.UsageByParent O = LayoutNodeLayoutDelegate.this.f5342a.O();
            LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
            if (O == usageByParent) {
                LayoutNodeLayoutDelegate.this.f5342a.s();
            }
            if (g0.a(LayoutNodeLayoutDelegate.this.f5342a)) {
                LookaheadPassDelegate H = LayoutNodeLayoutDelegate.this.H();
                Intrinsics.e(H);
                H.n1(usageByParent);
                H.P(j11);
            }
            w1(LayoutNodeLayoutDelegate.this.f5342a);
            r1(j11);
            return this;
        }

        @Override // androidx.compose.ui.node.a
        public void U(Function1 function1) {
            androidx.compose.runtime.collection.b p02 = LayoutNodeLayoutDelegate.this.f5342a.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    function1.invoke(((LayoutNode) m11[i11]).P().r());
                    i11++;
                } while (i11 < n11);
            }
        }

        @Override // androidx.compose.ui.node.m0
        public void V(boolean z10) {
            boolean i12 = LayoutNodeLayoutDelegate.this.K().i1();
            if (z10 != i12) {
                LayoutNodeLayoutDelegate.this.K().V(i12);
                this.G = true;
            }
            this.H = z10;
        }

        @Override // androidx.compose.ui.node.a
        public void Z() {
            LayoutNode.h1(LayoutNodeLayoutDelegate.this.f5342a, false, false, false, 7, null);
        }

        public final List Z0() {
            LayoutNodeLayoutDelegate.this.f5342a.u1();
            if (!this.f5403w) {
                return this.f5402v.g();
            }
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
            androidx.compose.runtime.collection.b bVar = this.f5402v;
            androidx.compose.runtime.collection.b p02 = layoutNode.p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                    if (bVar.n() <= i11) {
                        bVar.b(layoutNode2.P().I());
                    } else {
                        bVar.y(i11, layoutNode2.P().I());
                    }
                    i11++;
                } while (i11 < n11);
            }
            bVar.w(layoutNode.E().size(), bVar.n());
            this.f5403w = false;
            return this.f5402v.g();
        }

        public final o0.b a1() {
            if (this.f5389i) {
                return o0.b.a(t0());
            }
            return null;
        }

        public final boolean b1() {
            return this.f5404x;
        }

        public final LayoutNode.UsageByParent c1() {
            return this.f5391k;
        }

        public final int d1() {
            return this.f5388h;
        }

        public final float e1() {
            return this.f5406z;
        }

        public final void f1(boolean z10) {
            LayoutNode layoutNode;
            LayoutNode h02 = LayoutNodeLayoutDelegate.this.f5342a.h0();
            LayoutNode.UsageByParent O = LayoutNodeLayoutDelegate.this.f5342a.O();
            if (h02 == null || O == LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            do {
                layoutNode = h02;
                if (layoutNode.O() != O) {
                    break;
                } else {
                    h02 = layoutNode.h0();
                }
            } while (h02 != null);
            int i11 = a.f5408b[O.ordinal()];
            if (i11 == 1) {
                LayoutNode.h1(layoutNode, z10, false, false, 6, null);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("Intrinsics isn't used by the parent");
                }
                layoutNode.e1(z10);
            }
        }

        public final void g1() {
            this.f5397q = true;
        }

        public final boolean h1() {
            return this.f5400t;
        }

        public final void i1() {
            LayoutNodeLayoutDelegate.this.f5343b = true;
        }

        public final void l1() {
            androidx.compose.runtime.collection.b p02;
            int n11;
            if (LayoutNodeLayoutDelegate.this.s() <= 0 || (n11 = (p02 = LayoutNodeLayoutDelegate.this.f5342a.p0()).n()) <= 0) {
                return;
            }
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) m11[i11];
                LayoutNodeLayoutDelegate P = layoutNode.P();
                if ((P.v() || P.u()) && !P.A()) {
                    LayoutNode.f1(layoutNode, false, 1, null);
                }
                P.I().l1();
                i11++;
            } while (i11 < n11);
        }

        @Override // androidx.compose.ui.node.a
        public boolean n() {
            return this.f5399s;
        }

        public final void n1() {
            this.f5388h = Integer.MAX_VALUE;
            this.f5387g = Integer.MAX_VALUE;
            v1(false);
        }

        public final void o1() {
            this.A = true;
            LayoutNode h02 = LayoutNodeLayoutDelegate.this.f5342a.h0();
            float b22 = M().b2();
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.f5342a;
            NodeCoordinator f02 = layoutNode.f0();
            NodeCoordinator M = layoutNode.M();
            while (f02 != M) {
                Intrinsics.f(f02, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                y yVar = (y) f02;
                b22 += yVar.b2();
                f02 = yVar.Z1();
            }
            if (b22 != this.f5406z) {
                this.f5406z = b22;
                if (h02 != null) {
                    h02.S0();
                }
                if (h02 != null) {
                    h02.w0();
                }
            }
            if (!n()) {
                if (h02 != null) {
                    h02.w0();
                }
                j1();
                if (this.f5386f && h02 != null) {
                    LayoutNode.f1(h02, false, 1, null);
                }
            }
            if (h02 == null) {
                this.f5388h = 0;
            } else if (!this.f5386f && h02.R() == LayoutNode.LayoutState.LayingOut) {
                if (!(this.f5388h == Integer.MAX_VALUE)) {
                    g0.a.b("Place was called on a node which was placed already");
                }
                this.f5388h = h02.P().f5352k;
                h02.P().f5352k++;
            }
            I();
        }

        public final boolean r1(long j11) {
            if (LayoutNodeLayoutDelegate.this.f5342a.E0()) {
                g0.a.a("measure is called on a deactivated node");
            }
            y0 b11 = f0.b(LayoutNodeLayoutDelegate.this.f5342a);
            LayoutNode h02 = LayoutNodeLayoutDelegate.this.f5342a.h0();
            boolean z10 = true;
            LayoutNodeLayoutDelegate.this.f5342a.l1(LayoutNodeLayoutDelegate.this.f5342a.B() || (h02 != null && h02.B()));
            if (!LayoutNodeLayoutDelegate.this.f5342a.Y() && o0.b.f(t0(), j11)) {
                x0.b(b11, LayoutNodeLayoutDelegate.this.f5342a, false, 2, null);
                LayoutNodeLayoutDelegate.this.f5342a.k1();
                return false;
            }
            v().s(false);
            U(new Function1<androidx.compose.ui.node.a, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((a) obj);
                    return Unit.f67184a;
                }

                public final void invoke(a aVar) {
                    aVar.v().u(false);
                }
            });
            this.f5389i = true;
            long k11 = LayoutNodeLayoutDelegate.this.K().k();
            F0(j11);
            LayoutNodeLayoutDelegate.this.U(j11);
            if (o0.t.e(LayoutNodeLayoutDelegate.this.K().k(), k11) && LayoutNodeLayoutDelegate.this.K().u0() == u0() && LayoutNodeLayoutDelegate.this.K().l0() == l0()) {
                z10 = false;
            }
            B0(o0.u.a(LayoutNodeLayoutDelegate.this.K().u0(), LayoutNodeLayoutDelegate.this.K().l0()));
            return z10;
        }

        @Override // androidx.compose.ui.node.a
        public void requestLayout() {
            LayoutNode.f1(LayoutNodeLayoutDelegate.this.f5342a, false, 1, null);
        }

        public final void s1() {
            LayoutNode h02;
            try {
                this.f5386f = true;
                if (!this.f5390j) {
                    g0.a.b("replace called on unplaced item");
                }
                boolean n11 = n();
                p1(this.f5393m, this.f5396p, this.f5394n, this.f5395o);
                if (n11 && !this.A && (h02 = LayoutNodeLayoutDelegate.this.f5342a.h0()) != null) {
                    LayoutNode.f1(h02, false, 1, null);
                }
                this.f5386f = false;
            } catch (Throwable th2) {
                this.f5386f = false;
                throw th2;
            }
        }

        public final void t1(boolean z10) {
            this.f5403w = z10;
        }

        public final void u1(LayoutNode.UsageByParent usageByParent) {
            this.f5391k = usageByParent;
        }

        @Override // androidx.compose.ui.node.a
        public AlignmentLines v() {
            return this.f5401u;
        }

        public void v1(boolean z10) {
            this.f5399s = z10;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.g0
        public void w0(long j11, float f11, GraphicsLayer graphicsLayer) {
            q1(j11, f11, null, graphicsLayer);
        }

        public final boolean x1() {
            if ((G() == null && LayoutNodeLayoutDelegate.this.K().G() == null) || !this.f5397q) {
                return false;
            }
            this.f5397q = false;
            this.f5398r = LayoutNodeLayoutDelegate.this.K().G();
            return true;
        }

        @Override // androidx.compose.ui.node.a
        public Map z() {
            if (!this.f5392l) {
                if (LayoutNodeLayoutDelegate.this.B() == LayoutNode.LayoutState.Measuring) {
                    v().s(true);
                    if (v().g()) {
                        LayoutNodeLayoutDelegate.this.O();
                    }
                } else {
                    v().r(true);
                }
            }
            M().n1(true);
            I();
            M().n1(false);
            return v().h();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.g0
        public void z0(long j11, float f11, Function1 function1) {
            q1(j11, f11, function1, null);
        }
    }

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode) {
        this.f5342a = layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(final long j11) {
        this.f5344c = LayoutNode.LayoutState.LookaheadMeasuring;
        this.f5348g = false;
        OwnerSnapshotObserver.h(f0.b(this.f5342a).getSnapshotObserver(), this.f5342a, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performLookaheadMeasure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m129invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m129invoke() {
                j0 U1 = LayoutNodeLayoutDelegate.this.K().U1();
                Intrinsics.e(U1);
                U1.P(j11);
            }
        }, 2, null);
        P();
        if (g0.a(this.f5342a)) {
            O();
        } else {
            R();
        }
        this.f5344c = LayoutNode.LayoutState.Idle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(long j11) {
        LayoutNode.LayoutState layoutState = this.f5344c;
        LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.Idle;
        if (!(layoutState == layoutState2)) {
            g0.a.b("layout state is not idle before measure starts");
        }
        LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.Measuring;
        this.f5344c = layoutState3;
        this.f5345d = false;
        this.f5361t = j11;
        f0.b(this.f5342a).getSnapshotObserver().g(this.f5342a, false, this.f5362u);
        if (this.f5344c == layoutState3) {
            O();
            this.f5344c = layoutState2;
        }
    }

    public final boolean A() {
        return this.f5346e;
    }

    public final LayoutNode.LayoutState B() {
        return this.f5344c;
    }

    public final a C() {
        return this.f5360s;
    }

    public final boolean D() {
        return this.f5357p;
    }

    public final boolean E() {
        return this.f5356o;
    }

    public final boolean F() {
        return this.f5349h;
    }

    public final boolean G() {
        return this.f5348g;
    }

    public final LookaheadPassDelegate H() {
        return this.f5360s;
    }

    public final MeasurePassDelegate I() {
        return this.f5359r;
    }

    public final boolean J() {
        return this.f5345d;
    }

    public final NodeCoordinator K() {
        return this.f5342a.e0().n();
    }

    public final int L() {
        return this.f5359r.u0();
    }

    public final void M() {
        this.f5359r.g1();
        LookaheadPassDelegate lookaheadPassDelegate = this.f5360s;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.c1();
        }
    }

    public final void N() {
        this.f5359r.t1(true);
        LookaheadPassDelegate lookaheadPassDelegate = this.f5360s;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.m1(true);
        }
    }

    public final void O() {
        this.f5346e = true;
        this.f5347f = true;
    }

    public final void P() {
        this.f5349h = true;
        this.f5350i = true;
    }

    public final void Q() {
        this.f5348g = true;
    }

    public final void R() {
        this.f5345d = true;
    }

    public final void S() {
        LayoutNode.LayoutState R = this.f5342a.R();
        if (R == LayoutNode.LayoutState.LayingOut || R == LayoutNode.LayoutState.LookaheadLayingOut) {
            if (this.f5359r.b1()) {
                Z(true);
            } else {
                Y(true);
            }
        }
        if (R == LayoutNode.LayoutState.LookaheadLayingOut) {
            LookaheadPassDelegate lookaheadPassDelegate = this.f5360s;
            if (lookaheadPassDelegate == null || !lookaheadPassDelegate.W0()) {
                a0(true);
            } else {
                b0(true);
            }
        }
    }

    public final void V() {
        AlignmentLines v11;
        this.f5359r.v().p();
        LookaheadPassDelegate lookaheadPassDelegate = this.f5360s;
        if (lookaheadPassDelegate == null || (v11 = lookaheadPassDelegate.v()) == null) {
            return;
        }
        v11.p();
    }

    public final void W(int i11) {
        int i12 = this.f5355n;
        this.f5355n = i11;
        if ((i12 == 0) != (i11 == 0)) {
            LayoutNode h02 = this.f5342a.h0();
            LayoutNodeLayoutDelegate P = h02 != null ? h02.P() : null;
            if (P != null) {
                if (i11 == 0) {
                    P.W(P.f5355n - 1);
                } else {
                    P.W(P.f5355n + 1);
                }
            }
        }
    }

    public final void X(int i11) {
        int i12 = this.f5358q;
        this.f5358q = i11;
        if ((i12 == 0) != (i11 == 0)) {
            LayoutNode h02 = this.f5342a.h0();
            LayoutNodeLayoutDelegate P = h02 != null ? h02.P() : null;
            if (P != null) {
                if (i11 == 0) {
                    P.X(P.f5358q - 1);
                } else {
                    P.X(P.f5358q + 1);
                }
            }
        }
    }

    public final void Y(boolean z10) {
        if (this.f5354m != z10) {
            this.f5354m = z10;
            if (z10 && !this.f5353l) {
                W(this.f5355n + 1);
            } else {
                if (z10 || this.f5353l) {
                    return;
                }
                W(this.f5355n - 1);
            }
        }
    }

    public final void Z(boolean z10) {
        if (this.f5353l != z10) {
            this.f5353l = z10;
            if (z10 && !this.f5354m) {
                W(this.f5355n + 1);
            } else {
                if (z10 || this.f5354m) {
                    return;
                }
                W(this.f5355n - 1);
            }
        }
    }

    public final void a0(boolean z10) {
        if (this.f5357p != z10) {
            this.f5357p = z10;
            if (z10 && !this.f5356o) {
                X(this.f5358q + 1);
            } else {
                if (z10 || this.f5356o) {
                    return;
                }
                X(this.f5358q - 1);
            }
        }
    }

    public final void b0(boolean z10) {
        if (this.f5356o != z10) {
            this.f5356o = z10;
            if (z10 && !this.f5357p) {
                X(this.f5358q + 1);
            } else {
                if (z10 || this.f5357p) {
                    return;
                }
                X(this.f5358q - 1);
            }
        }
    }

    public final void c0() {
        LayoutNode h02;
        if (this.f5359r.x1() && (h02 = this.f5342a.h0()) != null) {
            LayoutNode.h1(h02, false, false, false, 7, null);
        }
        LookaheadPassDelegate lookaheadPassDelegate = this.f5360s;
        if (lookaheadPassDelegate == null || !lookaheadPassDelegate.r1()) {
            return;
        }
        if (g0.a(this.f5342a)) {
            LayoutNode h03 = this.f5342a.h0();
            if (h03 != null) {
                LayoutNode.h1(h03, false, false, false, 7, null);
                return;
            }
            return;
        }
        LayoutNode h04 = this.f5342a.h0();
        if (h04 != null) {
            LayoutNode.d1(h04, false, false, false, 7, null);
        }
    }

    public final void q() {
        if (this.f5360s == null) {
            this.f5360s = new LookaheadPassDelegate();
        }
    }

    public final a r() {
        return this.f5359r;
    }

    public final int s() {
        return this.f5355n;
    }

    public final int t() {
        return this.f5358q;
    }

    public final boolean u() {
        return this.f5354m;
    }

    public final boolean v() {
        return this.f5353l;
    }

    public final boolean w() {
        return this.f5343b;
    }

    public final int x() {
        return this.f5359r.l0();
    }

    public final o0.b y() {
        return this.f5359r.a1();
    }

    public final o0.b z() {
        LookaheadPassDelegate lookaheadPassDelegate = this.f5360s;
        if (lookaheadPassDelegate != null) {
            return lookaheadPassDelegate.T0();
        }
        return null;
    }
}
