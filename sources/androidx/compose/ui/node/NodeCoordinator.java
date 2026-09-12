package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.j;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.graphics.i4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.x4;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements androidx.compose.ui.layout.s, androidx.compose.ui.layout.l, z0 {
    public static final c L = new c(null);
    private static final Function1 M = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((NodeCoordinator) obj);
            return Unit.f67184a;
        }

        public final void invoke(NodeCoordinator nodeCoordinator) {
            u uVar;
            u uVar2;
            u uVar3;
            if (nodeCoordinator.isValidOwnerScope()) {
                uVar = nodeCoordinator.F;
                if (uVar == null) {
                    NodeCoordinator.O2(nodeCoordinator, false, 1, null);
                    return;
                }
                uVar2 = NodeCoordinator.P;
                uVar2.b(uVar);
                NodeCoordinator.O2(nodeCoordinator, false, 1, null);
                uVar3 = NodeCoordinator.P;
                if (uVar3.c(uVar)) {
                    return;
                }
                LayoutNode a12 = nodeCoordinator.a1();
                LayoutNodeLayoutDelegate P2 = a12.P();
                if (P2.s() > 0) {
                    if (P2.u() || P2.v()) {
                        LayoutNode.f1(a12, false, 1, null);
                    }
                    P2.I().l1();
                }
                y0 g02 = a12.g0();
                if (g02 != null) {
                    g02.requestOnPositionedCallback(a12);
                }
            }
        }
    };
    private static final Function1 N = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((NodeCoordinator) obj);
            return Unit.f67184a;
        }

        public final void invoke(NodeCoordinator nodeCoordinator) {
            w0 T1 = nodeCoordinator.T1();
            if (T1 != null) {
                T1.invalidate();
            }
        }
    };
    private static final x4 O = new x4();
    private static final u P = new u();
    private static final float[] Q = i4.c(null, 1, null);
    private static final d R = new a();
    private static final d S = new b();
    private androidx.compose.ui.layout.v A;
    private Map B;
    private float D;
    private y.e E;
    private u F;
    private boolean I;
    private w0 J;
    private GraphicsLayer K;

    /* renamed from: p */
    private final LayoutNode f5427p;

    /* renamed from: q */
    private boolean f5428q;

    /* renamed from: r */
    private boolean f5429r;

    /* renamed from: s */
    private NodeCoordinator f5430s;

    /* renamed from: t */
    private NodeCoordinator f5431t;

    /* renamed from: u */
    private boolean f5432u;

    /* renamed from: v */
    private boolean f5433v;

    /* renamed from: w */
    private Function1 f5434w;

    /* renamed from: x */
    private o0.e f5435x = a1().H();

    /* renamed from: y */
    private LayoutDirection f5436y = a1().getLayoutDirection();

    /* renamed from: z */
    private float f5437z = 0.8f;
    private long C = o0.p.f70738b.a();
    private final Function2 G = new Function2<androidx.compose.ui.graphics.m1, GraphicsLayer, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((androidx.compose.ui.graphics.m1) obj, (GraphicsLayer) obj2);
            return Unit.f67184a;
        }

        public final void invoke(final androidx.compose.ui.graphics.m1 m1Var, final GraphicsLayer graphicsLayer) {
            OwnerSnapshotObserver X1;
            Function1 function1;
            if (!NodeCoordinator.this.a1().n()) {
                NodeCoordinator.this.I = true;
                return;
            }
            X1 = NodeCoordinator.this.X1();
            NodeCoordinator nodeCoordinator = NodeCoordinator.this;
            function1 = NodeCoordinator.N;
            final NodeCoordinator nodeCoordinator2 = NodeCoordinator.this;
            X1.i(nodeCoordinator, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$drawBlock$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m132invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m132invoke() {
                    NodeCoordinator.this.J1(m1Var, graphicsLayer);
                }
            });
            NodeCoordinator.this.I = false;
        }
    };
    private final Function0 H = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m135invoke();
            return Unit.f67184a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m135invoke() {
            NodeCoordinator a22 = NodeCoordinator.this.a2();
            if (a22 != null) {
                a22.j2();
            }
        }
    };

    /* loaded from: classes.dex */
    public static final class a implements d {
        a() {
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public int a() {
            return s0.a(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.ui.f$c] */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.compose.ui.f$c] */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [androidx.compose.ui.f$c] */
        /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.b] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.b] */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public boolean b(f.c cVar) {
            int a11 = s0.a(16);
            ?? r32 = 0;
            while (cVar != 0) {
                if (cVar instanceof e1) {
                    if (((e1) cVar).R()) {
                        return true;
                    }
                } else if ((cVar.f1() & a11) != 0 && (cVar instanceof i)) {
                    f.c E1 = cVar.E1();
                    int i11 = 0;
                    r32 = r32;
                    cVar = cVar;
                    while (E1 != null) {
                        if ((E1.f1() & a11) != 0) {
                            i11++;
                            r32 = r32;
                            if (i11 == 1) {
                                cVar = E1;
                            } else {
                                if (r32 == 0) {
                                    r32 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                }
                                if (cVar != 0) {
                                    r32.b(cVar);
                                    cVar = 0;
                                }
                                r32.b(E1);
                            }
                        }
                        E1 = E1.b1();
                        r32 = r32;
                        cVar = cVar;
                    }
                    if (i11 == 1) {
                    }
                }
                cVar = g.g(r32);
            }
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public void c(LayoutNode layoutNode, long j11, q qVar, boolean z10, boolean z11) {
            layoutNode.q0(j11, qVar, z10, z11);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public boolean d(LayoutNode layoutNode) {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements d {
        b() {
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public int a() {
            return s0.a(8);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public boolean b(f.c cVar) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public void c(LayoutNode layoutNode, long j11, q qVar, boolean z10, boolean z11) {
            layoutNode.s0(j11, qVar, z10, z11);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.d
        public boolean d(LayoutNode layoutNode) {
            androidx.compose.ui.semantics.i F = layoutNode.F();
            boolean z10 = false;
            if (F != null && F.n()) {
                z10 = true;
            }
            return !z10;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return NodeCoordinator.R;
        }

        public final d b() {
            return NodeCoordinator.S;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        int a();

        boolean b(f.c cVar);

        void c(LayoutNode layoutNode, long j11, q qVar, boolean z10, boolean z11);

        boolean d(LayoutNode layoutNode);
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.f5427p = layoutNode;
    }

    private final void D1(NodeCoordinator nodeCoordinator, y.e eVar, boolean z10) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.f5431t;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.D1(nodeCoordinator, eVar, z10);
        }
        O1(eVar, z10);
    }

    private final long E1(NodeCoordinator nodeCoordinator, long j11, boolean z10) {
        if (nodeCoordinator == this) {
            return j11;
        }
        NodeCoordinator nodeCoordinator2 = this.f5431t;
        return (nodeCoordinator2 == null || Intrinsics.c(nodeCoordinator, nodeCoordinator2)) ? M1(j11, z10) : M1(nodeCoordinator2.E1(nodeCoordinator, j11, z10), z10);
    }

    public final void G2(final f.c cVar, final d dVar, final long j11, final q qVar, final boolean z10, final boolean z11, final float f11) {
        f.c b11;
        if (cVar == null) {
            i2(dVar, j11, qVar, z10, z11);
        } else if (dVar.b(cVar)) {
            qVar.w(cVar, f11, z11, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m136invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m136invoke() {
                    f.c b12;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    b12 = r0.b(cVar, dVar.a(), s0.a(2));
                    nodeCoordinator.G2(b12, dVar, j11, qVar, z10, z11, f11);
                }
            });
        } else {
            b11 = r0.b(cVar, dVar.a(), s0.a(2));
            G2(b11, dVar, j11, qVar, z10, z11, f11);
        }
    }

    private final NodeCoordinator H2(androidx.compose.ui.layout.l lVar) {
        NodeCoordinator a11;
        androidx.compose.ui.layout.q qVar = lVar instanceof androidx.compose.ui.layout.q ? (androidx.compose.ui.layout.q) lVar : null;
        if (qVar != null && (a11 = qVar.a()) != null) {
            return a11;
        }
        Intrinsics.f(lVar, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) lVar;
    }

    public final void J1(androidx.compose.ui.graphics.m1 m1Var, GraphicsLayer graphicsLayer) {
        f.c d22 = d2(s0.a(4));
        if (d22 == null) {
            u2(m1Var, graphicsLayer);
        } else {
            a1().W().n(m1Var, o0.u.d(k()), this, d22, graphicsLayer);
        }
    }

    public static /* synthetic */ long J2(NodeCoordinator nodeCoordinator, long j11, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        return nodeCoordinator.I2(j11, z10);
    }

    public static /* synthetic */ void M2(NodeCoordinator nodeCoordinator, Function1 function1, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        nodeCoordinator.L2(function1, z10);
    }

    public static /* synthetic */ long N1(NodeCoordinator nodeCoordinator, long j11, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        return nodeCoordinator.M1(j11, z10);
    }

    private final void N2(boolean z10) {
        y0 g02;
        if (this.K != null) {
            return;
        }
        w0 w0Var = this.J;
        if (w0Var == null) {
            if (this.f5434w == null) {
                return;
            }
            g0.a.b("null layer with a non-null layerBlock");
            return;
        }
        final Function1 function1 = this.f5434w;
        if (function1 == null) {
            g0.a.c("updateLayerParameters requires a non-null layerBlock");
            throw new KotlinNothingValueException();
        }
        x4 x4Var = O;
        x4Var.P();
        x4Var.R(a1().H());
        x4Var.U(a1().getLayoutDirection());
        x4Var.V(o0.u.d(k()));
        X1().i(this, M, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m137invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m137invoke() {
                x4 x4Var2;
                x4 x4Var3;
                Function1<c4, Unit> function12 = function1;
                x4Var2 = NodeCoordinator.O;
                function12.invoke(x4Var2);
                x4Var3 = NodeCoordinator.O;
                x4Var3.Y();
            }
        });
        u uVar = this.F;
        if (uVar == null) {
            uVar = new u();
            this.F = uVar;
        }
        uVar.a(x4Var);
        w0Var.updateLayerProperties(x4Var);
        this.f5433v = x4Var.z();
        this.f5437z = x4Var.n();
        if (!z10 || (g02 = a1().g0()) == null) {
            return;
        }
        g02.onLayoutChange(a1());
    }

    private final void O1(y.e eVar, boolean z10) {
        float h11 = o0.p.h(e1());
        eVar.i(eVar.b() - h11);
        eVar.j(eVar.c() - h11);
        float i11 = o0.p.i(e1());
        eVar.k(eVar.d() - i11);
        eVar.h(eVar.a() - i11);
        w0 w0Var = this.J;
        if (w0Var != null) {
            w0Var.mapBounds(eVar, true);
            if (this.f5433v && z10) {
                eVar.e(0.0f, 0.0f, o0.t.g(k()), o0.t.f(k()));
                eVar.f();
            }
        }
    }

    public static /* synthetic */ void O2(NodeCoordinator nodeCoordinator, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        nodeCoordinator.N2(z10);
    }

    public final OwnerSnapshotObserver X1() {
        return f0.b(a1()).getSnapshotObserver();
    }

    private final boolean c2(int i11) {
        f.c e22 = e2(t0.i(i11));
        return e22 != null && g.e(e22, i11);
    }

    public final f.c e2(boolean z10) {
        f.c Y1;
        if (a1().f0() == this) {
            return a1().e0().k();
        }
        if (z10) {
            NodeCoordinator nodeCoordinator = this.f5431t;
            if (nodeCoordinator != null && (Y1 = nodeCoordinator.Y1()) != null) {
                return Y1.b1();
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.f5431t;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.Y1();
            }
        }
        return null;
    }

    public final void f2(final f.c cVar, final d dVar, final long j11, final q qVar, final boolean z10, final boolean z11) {
        if (cVar == null) {
            i2(dVar, j11, qVar, z10, z11);
        } else {
            qVar.q(cVar, z11, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m133invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m133invoke() {
                    f.c b11;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    b11 = r0.b(cVar, dVar.a(), s0.a(2));
                    nodeCoordinator.f2(b11, dVar, j11, qVar, z10, z11);
                }
            });
        }
    }

    public final void g2(final f.c cVar, final d dVar, final long j11, final q qVar, final boolean z10, final boolean z11, final float f11) {
        if (cVar == null) {
            i2(dVar, j11, qVar, z10, z11);
        } else {
            qVar.r(cVar, f11, z11, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m134invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m134invoke() {
                    f.c b11;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    b11 = r0.b(cVar, dVar.a(), s0.a(2));
                    nodeCoordinator.g2(b11, dVar, j11, qVar, z10, z11, f11);
                }
            });
        }
    }

    private final long m2(long j11) {
        float m11 = y.g.m(j11);
        float max = Math.max(0.0f, m11 < 0.0f ? -m11 : m11 - s0());
        float n11 = y.g.n(j11);
        return y.h.a(max, Math.max(0.0f, n11 < 0.0f ? -n11 : n11 - o0()));
    }

    private final void v2(long j11, float f11, Function1 function1, GraphicsLayer graphicsLayer) {
        if (graphicsLayer != null) {
            if (!(function1 == null)) {
                g0.a.a("both ways to create layers shouldn't be used together");
            }
            if (this.K != graphicsLayer) {
                this.K = null;
                M2(this, null, false, 2, null);
                this.K = graphicsLayer;
            }
            if (this.J == null) {
                w0 createLayer = f0.b(a1()).createLayer(this.G, this.H, graphicsLayer);
                createLayer.mo141resizeozmzZPI(r0());
                createLayer.mo140movegyyYBs(j11);
                this.J = createLayer;
                a1().m1(true);
                this.H.invoke();
            }
        } else {
            if (this.K != null) {
                this.K = null;
                M2(this, null, false, 2, null);
            }
            M2(this, function1, false, 2, null);
        }
        if (!o0.p.g(e1(), j11)) {
            C2(j11);
            a1().P().I().l1();
            w0 w0Var = this.J;
            if (w0Var != null) {
                w0Var.mo140movegyyYBs(j11);
            } else {
                NodeCoordinator nodeCoordinator = this.f5431t;
                if (nodeCoordinator != null) {
                    nodeCoordinator.j2();
                }
            }
            g1(this);
            y0 g02 = a1().g0();
            if (g02 != null) {
                g02.onLayoutChange(a1());
            }
        }
        this.D = f11;
        if (j1()) {
            return;
        }
        R0(b1());
    }

    public static /* synthetic */ void y2(NodeCoordinator nodeCoordinator, y.e eVar, boolean z10, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        nodeCoordinator.x2(eVar, z10, z11);
    }

    public final void A2(boolean z10) {
        this.f5428q = z10;
    }

    @Override // androidx.compose.ui.layout.l
    public long B(androidx.compose.ui.layout.l lVar, long j11, boolean z10) {
        if (lVar instanceof androidx.compose.ui.layout.q) {
            ((androidx.compose.ui.layout.q) lVar).a().n2();
            return y.g.u(lVar.B(this, y.g.u(j11), z10));
        }
        NodeCoordinator H2 = H2(lVar);
        H2.n2();
        NodeCoordinator L1 = L1(H2);
        while (H2 != L1) {
            j11 = H2.I2(j11, z10);
            H2 = H2.f5431t;
            Intrinsics.e(H2);
        }
        return E1(L1, j11, z10);
    }

    public void B2(androidx.compose.ui.layout.v vVar) {
        androidx.compose.ui.layout.v vVar2 = this.A;
        if (vVar != vVar2) {
            this.A = vVar;
            if (vVar2 == null || vVar.getWidth() != vVar2.getWidth() || vVar.getHeight() != vVar2.getHeight()) {
                q2(vVar.getWidth(), vVar.getHeight());
            }
            Map map = this.B;
            if (((map == null || map.isEmpty()) && vVar.v().isEmpty()) || Intrinsics.c(vVar.v(), this.B)) {
                return;
            }
            P1().v().m();
            Map map2 = this.B;
            if (map2 == null) {
                map2 = new LinkedHashMap();
                this.B = map2;
            }
            map2.clear();
            map2.putAll(vVar.v());
        }
    }

    @Override // androidx.compose.ui.layout.l
    public long C(androidx.compose.ui.layout.l lVar, long j11) {
        return B(lVar, j11, true);
    }

    @Override // o0.n
    public float C0() {
        return a1().H().C0();
    }

    protected void C2(long j11) {
        this.C = j11;
    }

    public final void D2(NodeCoordinator nodeCoordinator) {
        this.f5430s = nodeCoordinator;
    }

    public final void E2(NodeCoordinator nodeCoordinator) {
        this.f5431t = nodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.l
    public boolean F() {
        return Y1().k1();
    }

    protected final long F1(long j11) {
        return y.n.a(Math.max(0.0f, (y.m.i(j11) - s0()) / 2.0f), Math.max(0.0f, (y.m.g(j11) - o0()) / 2.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final boolean F2() {
        f.c e22 = e2(t0.i(s0.a(16)));
        if (e22 != null && e22.k1()) {
            int a11 = s0.a(16);
            if (!e22.getNode().k1()) {
                g0.a.b("visitLocalDescendants called on an unattached node");
            }
            f.c node = e22.getNode();
            if ((node.a1() & a11) != 0) {
                while (node != null) {
                    if ((node.f1() & a11) != 0) {
                        i iVar = node;
                        ?? r62 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof e1) {
                                if (((e1) iVar).P0()) {
                                    return true;
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                                f.c E1 = iVar.E1();
                                int i11 = 0;
                                iVar = iVar;
                                r62 = r62;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        r62 = r62;
                                        if (i11 == 1) {
                                            iVar = E1;
                                        } else {
                                            if (r62 == 0) {
                                                r62 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (iVar != 0) {
                                                r62.b(iVar);
                                                iVar = 0;
                                            }
                                            r62.b(E1);
                                        }
                                    }
                                    E1 = E1.b1();
                                    iVar = iVar;
                                    r62 = r62;
                                }
                                if (i11 == 1) {
                                }
                            }
                            iVar = g.g(r62);
                        }
                    }
                    node = node.b1();
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // androidx.compose.ui.layout.g0, androidx.compose.ui.layout.i
    public Object G() {
        if (!a1().e0().q(s0.a(64))) {
            return null;
        }
        Y1();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (f.c o11 = a1().e0().o(); o11 != null; o11 = o11.h1()) {
            if ((s0.a(64) & o11.f1()) != 0) {
                int a11 = s0.a(64);
                ?? r62 = 0;
                i iVar = o11;
                while (iVar != 0) {
                    if (iVar instanceof a1) {
                        objectRef.element = ((a1) iVar).v0(a1().H(), objectRef.element);
                    } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                        f.c E1 = iVar.E1();
                        int i11 = 0;
                        iVar = iVar;
                        r62 = r62;
                        while (E1 != null) {
                            if ((E1.f1() & a11) != 0) {
                                i11++;
                                r62 = r62;
                                if (i11 == 1) {
                                    iVar = E1;
                                } else {
                                    if (r62 == 0) {
                                        r62 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                    }
                                    if (iVar != 0) {
                                        r62.b(iVar);
                                        iVar = 0;
                                    }
                                    r62.b(E1);
                                }
                            }
                            E1 = E1.b1();
                            iVar = iVar;
                            r62 = r62;
                        }
                        if (i11 == 1) {
                        }
                    }
                    iVar = g.g(r62);
                }
            }
        }
        return objectRef.element;
    }

    public final float G1(long j11, long j12) {
        if (s0() >= y.m.i(j12) && o0() >= y.m.g(j12)) {
            return Float.POSITIVE_INFINITY;
        }
        long F1 = F1(j12);
        float i11 = y.m.i(F1);
        float g11 = y.m.g(F1);
        long m22 = m2(j11);
        if ((i11 > 0.0f || g11 > 0.0f) && y.g.m(m22) <= i11 && y.g.n(m22) <= g11) {
            return y.g.l(m22);
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void H1(androidx.compose.ui.graphics.m1 m1Var, GraphicsLayer graphicsLayer) {
        w0 w0Var = this.J;
        if (w0Var != null) {
            w0Var.drawLayer(m1Var, graphicsLayer);
            return;
        }
        float h11 = o0.p.h(e1());
        float i11 = o0.p.i(e1());
        m1Var.c(h11, i11);
        J1(m1Var, graphicsLayer);
        m1Var.c(-h11, -i11);
    }

    public final void I1(androidx.compose.ui.graphics.m1 m1Var, m4 m4Var) {
        m1Var.i(new y.i(0.5f, 0.5f, o0.t.g(r0()) - 0.5f, o0.t.f(r0()) - 0.5f), m4Var);
    }

    public long I2(long j11, boolean z10) {
        w0 w0Var = this.J;
        if (w0Var != null) {
            j11 = w0Var.mo139mapOffset8S9VItk(j11, false);
        }
        return (z10 || !i1()) ? o0.q.c(j11, e1()) : j11;
    }

    public abstract void K1();

    public final y.i K2() {
        if (!F()) {
            return y.i.f78598e.a();
        }
        androidx.compose.ui.layout.l d11 = androidx.compose.ui.layout.m.d(this);
        y.e W1 = W1();
        long F1 = F1(V1());
        W1.i(-y.m.i(F1));
        W1.k(-y.m.g(F1));
        W1.j(s0() + y.m.i(F1));
        W1.h(o0() + y.m.g(F1));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != d11) {
            nodeCoordinator.x2(W1, false, true);
            if (W1.f()) {
                return y.i.f78598e.a();
            }
            nodeCoordinator = nodeCoordinator.f5431t;
            Intrinsics.e(nodeCoordinator);
        }
        return y.f.a(W1);
    }

    @Override // androidx.compose.ui.layout.l
    public long L(long j11) {
        return f0.b(a1()).mo142calculatePositionInWindowMKHz9U(Y(j11));
    }

    public final NodeCoordinator L1(NodeCoordinator nodeCoordinator) {
        LayoutNode a12 = nodeCoordinator.a1();
        LayoutNode a13 = a1();
        if (a12 == a13) {
            f.c Y1 = nodeCoordinator.Y1();
            f.c Y12 = Y1();
            int a11 = s0.a(2);
            if (!Y12.getNode().k1()) {
                g0.a.b("visitLocalAncestors called on an unattached node");
            }
            for (f.c h12 = Y12.getNode().h1(); h12 != null; h12 = h12.h1()) {
                if ((h12.f1() & a11) != 0 && h12 == Y1) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (a12.I() > a13.I()) {
            a12 = a12.h0();
            Intrinsics.e(a12);
        }
        while (a13.I() > a12.I()) {
            a13 = a13.h0();
            Intrinsics.e(a13);
        }
        while (a12 != a13) {
            a12 = a12.h0();
            a13 = a13.h0();
            if (a12 == null || a13 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        return a13 == a1() ? this : a12 == nodeCoordinator.a1() ? nodeCoordinator : a12.M();
    }

    public final void L2(Function1 function1, boolean z10) {
        y0 g02;
        if (!(function1 == null || this.K == null)) {
            g0.a.a("layerBlock can't be provided when explicitLayer is provided");
        }
        LayoutNode a12 = a1();
        boolean z11 = (!z10 && this.f5434w == function1 && Intrinsics.c(this.f5435x, a12.H()) && this.f5436y == a12.getLayoutDirection()) ? false : true;
        this.f5435x = a12.H();
        this.f5436y = a12.getLayoutDirection();
        if (!a12.D0() || function1 == null) {
            this.f5434w = null;
            w0 w0Var = this.J;
            if (w0Var != null) {
                w0Var.destroy();
                a12.m1(true);
                this.H.invoke();
                if (F() && (g02 = a12.g0()) != null) {
                    g02.onLayoutChange(a12);
                }
            }
            this.J = null;
            this.I = false;
            return;
        }
        this.f5434w = function1;
        if (this.J != null) {
            if (z11) {
                O2(this, false, 1, null);
                return;
            }
            return;
        }
        w0 a11 = x0.a(f0.b(a12), this.G, this.H, null, 4, null);
        a11.mo141resizeozmzZPI(r0());
        a11.mo140movegyyYBs(e1());
        this.J = a11;
        O2(this, false, 1, null);
        a12.m1(true);
        this.H.invoke();
    }

    public long M1(long j11, boolean z10) {
        if (z10 || !i1()) {
            j11 = o0.q.b(j11, e1());
        }
        w0 w0Var = this.J;
        return w0Var != null ? w0Var.mo139mapOffset8S9VItk(j11, true) : j11;
    }

    @Override // androidx.compose.ui.layout.l
    public y.i O(androidx.compose.ui.layout.l lVar, boolean z10) {
        if (!F()) {
            g0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!lVar.F()) {
            g0.a.b("LayoutCoordinates " + lVar + " is not attached!");
        }
        NodeCoordinator H2 = H2(lVar);
        H2.n2();
        NodeCoordinator L1 = L1(H2);
        y.e W1 = W1();
        W1.i(0.0f);
        W1.k(0.0f);
        W1.j(o0.t.g(lVar.k()));
        W1.h(o0.t.f(lVar.k()));
        while (H2 != L1) {
            y2(H2, W1, z10, false, 4, null);
            if (W1.f()) {
                return y.i.f78598e.a();
            }
            H2 = H2.f5431t;
            Intrinsics.e(H2);
        }
        D1(L1, W1, z10);
        return y.f.a(W1);
    }

    public androidx.compose.ui.node.a P1() {
        return a1().P().r();
    }

    public final boolean P2(long j11) {
        if (!y.h.b(j11)) {
            return false;
        }
        w0 w0Var = this.J;
        return w0Var == null || !this.f5433v || w0Var.mo138isInLayerk4lQ0M(j11);
    }

    public final boolean Q1() {
        return this.f5429r;
    }

    @Override // androidx.compose.ui.layout.l
    public final androidx.compose.ui.layout.l R() {
        if (!F()) {
            g0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        n2();
        return a1().f0().f5431t;
    }

    public final boolean R1() {
        return this.I;
    }

    public final long S1() {
        return t0();
    }

    public final w0 T1() {
        return this.J;
    }

    public abstract j0 U1();

    public final long V1() {
        return this.f5435x.Q0(a1().l0().d());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable W0() {
        return this.f5430s;
    }

    protected final y.e W1() {
        y.e eVar = this.E;
        if (eVar != null) {
            return eVar;
        }
        y.e eVar2 = new y.e(0.0f, 0.0f, 0.0f, 0.0f);
        this.E = eVar2;
        return eVar2;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.layout.l X0() {
        return this;
    }

    @Override // androidx.compose.ui.layout.l
    public long Y(long j11) {
        if (!F()) {
            g0.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        n2();
        long j12 = j11;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.f5431t) {
            j12 = J2(nodeCoordinator, j12, false, 2, null);
        }
        return j12;
    }

    public abstract f.c Y1();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean Z0() {
        return this.A != null;
    }

    public final NodeCoordinator Z1() {
        return this.f5430s;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutNode a1() {
        return this.f5427p;
    }

    public final NodeCoordinator a2() {
        return this.f5431t;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.layout.v b1() {
        androidx.compose.ui.layout.v vVar = this.A;
        if (vVar != null) {
            return vVar;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier");
    }

    public final float b2() {
        return this.D;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable c1() {
        return this.f5431t;
    }

    public final f.c d2(int i11) {
        boolean i12 = t0.i(i11);
        f.c Y1 = Y1();
        if (!i12 && (Y1 = Y1.h1()) == null) {
            return null;
        }
        for (f.c e22 = e2(i12); e22 != null && (e22.a1() & i11) != 0; e22 = e22.b1()) {
            if ((e22.f1() & i11) != 0) {
                return e22;
            }
            if (e22 == Y1) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long e1() {
        return this.C;
    }

    @Override // o0.e
    public float getDensity() {
        return a1().H().getDensity();
    }

    @Override // androidx.compose.ui.layout.j
    public LayoutDirection getLayoutDirection() {
        return a1().getLayoutDirection();
    }

    public final void h2(d dVar, long j11, q qVar, boolean z10, boolean z11) {
        f.c d22 = d2(dVar.a());
        if (!P2(j11)) {
            if (z10) {
                float G1 = G1(j11, V1());
                if (Float.isInfinite(G1) || Float.isNaN(G1) || !qVar.t(G1, false)) {
                    return;
                }
                g2(d22, dVar, j11, qVar, z10, false, G1);
                return;
            }
            return;
        }
        if (d22 == null) {
            i2(dVar, j11, qVar, z10, z11);
            return;
        }
        if (k2(j11)) {
            f2(d22, dVar, j11, qVar, z10, z11);
            return;
        }
        float G12 = !z10 ? Float.POSITIVE_INFINITY : G1(j11, V1());
        if (!Float.isInfinite(G12) && !Float.isNaN(G12)) {
            if (qVar.t(G12, z11)) {
                g2(d22, dVar, j11, qVar, z10, z11, G12);
                return;
            }
        }
        G2(d22, dVar, j11, qVar, z10, z11, G12);
    }

    public void i2(d dVar, long j11, q qVar, boolean z10, boolean z11) {
        NodeCoordinator nodeCoordinator = this.f5430s;
        if (nodeCoordinator != null) {
            nodeCoordinator.h2(dVar, N1(nodeCoordinator, j11, false, 2, null), qVar, z10, z11);
        }
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return (this.J == null || this.f5432u || !a1().D0()) ? false : true;
    }

    public void j2() {
        w0 w0Var = this.J;
        if (w0Var != null) {
            w0Var.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.f5431t;
        if (nodeCoordinator != null) {
            nodeCoordinator.j2();
        }
    }

    @Override // androidx.compose.ui.layout.l
    public final long k() {
        return r0();
    }

    protected final boolean k2(long j11) {
        float m11 = y.g.m(j11);
        float n11 = y.g.n(j11);
        return m11 >= 0.0f && n11 >= 0.0f && m11 < ((float) s0()) && n11 < ((float) o0());
    }

    public final boolean l2() {
        if (this.J != null && this.f5437z <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.f5431t;
        if (nodeCoordinator != null) {
            return nodeCoordinator.l2();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void m1() {
        GraphicsLayer graphicsLayer = this.K;
        if (graphicsLayer != null) {
            w0(e1(), this.D, graphicsLayer);
        } else {
            z0(e1(), this.D, this.f5434w);
        }
    }

    public final void n2() {
        a1().P().S();
    }

    public void o2() {
        w0 w0Var = this.J;
        if (w0Var != null) {
            w0Var.invalidate();
        }
    }

    public final void p2() {
        L2(this.f5434w, true);
        w0 w0Var = this.J;
        if (w0Var != null) {
            w0Var.invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    protected void q2(int i11, int i12) {
        NodeCoordinator nodeCoordinator;
        w0 w0Var = this.J;
        if (w0Var != null) {
            w0Var.mo141resizeozmzZPI(o0.u.a(i11, i12));
        } else if (a1().n() && (nodeCoordinator = this.f5431t) != null) {
            nodeCoordinator.j2();
        }
        B0(o0.u.a(i11, i12));
        if (this.f5434w != null) {
            N2(false);
        }
        int a11 = s0.a(4);
        boolean i13 = t0.i(a11);
        f.c Y1 = Y1();
        if (i13 || (Y1 = Y1.h1()) != null) {
            for (f.c e22 = e2(i13); e22 != null && (e22.a1() & a11) != 0; e22 = e22.b1()) {
                if ((e22.f1() & a11) != 0) {
                    i iVar = e22;
                    ?? r42 = 0;
                    while (iVar != 0) {
                        if (iVar instanceof n) {
                            ((n) iVar).w0();
                        } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                            f.c E1 = iVar.E1();
                            int i14 = 0;
                            iVar = iVar;
                            r42 = r42;
                            while (E1 != null) {
                                if ((E1.f1() & a11) != 0) {
                                    i14++;
                                    r42 = r42;
                                    if (i14 == 1) {
                                        iVar = E1;
                                    } else {
                                        if (r42 == 0) {
                                            r42 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                        }
                                        if (iVar != 0) {
                                            r42.b(iVar);
                                            iVar = 0;
                                        }
                                        r42.b(E1);
                                    }
                                }
                                E1 = E1.b1();
                                iVar = iVar;
                                r42 = r42;
                            }
                            if (i14 == 1) {
                            }
                        }
                        iVar = g.g(r42);
                    }
                }
                if (e22 == Y1) {
                    break;
                }
            }
        }
        y0 g02 = a1().g0();
        if (g02 != null) {
            g02.onLayoutChange(a1());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r9v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
    public final void r2() {
        f.c h12;
        if (c2(s0.a(128))) {
            j.a aVar = androidx.compose.runtime.snapshots.j.f4079e;
            androidx.compose.runtime.snapshots.j d11 = aVar.d();
            Function1 h11 = d11 != null ? d11.h() : null;
            androidx.compose.runtime.snapshots.j f11 = aVar.f(d11);
            try {
                int a11 = s0.a(128);
                boolean i11 = t0.i(a11);
                if (i11) {
                    h12 = Y1();
                } else {
                    h12 = Y1().h1();
                    if (h12 == null) {
                        Unit unit = Unit.f67184a;
                        aVar.m(d11, f11, h11);
                    }
                }
                for (f.c e22 = e2(i11); e22 != null && (e22.a1() & a11) != 0; e22 = e22.b1()) {
                    if ((e22.f1() & a11) != 0) {
                        ?? r102 = 0;
                        i iVar = e22;
                        while (iVar != 0) {
                            if (iVar instanceof w) {
                                ((w) iVar).F(r0());
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                                f.c E1 = iVar.E1();
                                int i12 = 0;
                                iVar = iVar;
                                r102 = r102;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i12++;
                                        r102 = r102;
                                        if (i12 == 1) {
                                            iVar = E1;
                                        } else {
                                            if (r102 == 0) {
                                                r102 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (iVar != 0) {
                                                r102.b(iVar);
                                                iVar = 0;
                                            }
                                            r102.b(E1);
                                        }
                                    }
                                    E1 = E1.b1();
                                    iVar = iVar;
                                    r102 = r102;
                                }
                                if (i12 == 1) {
                                }
                            }
                            iVar = g.g(r102);
                        }
                    }
                    if (e22 == h12) {
                        break;
                    }
                }
                Unit unit2 = Unit.f67184a;
                aVar.m(d11, f11, h11);
            } catch (Throwable th2) {
                aVar.m(d11, f11, h11);
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final void s2() {
        int a11 = s0.a(128);
        boolean i11 = t0.i(a11);
        f.c Y1 = Y1();
        if (!i11 && (Y1 = Y1.h1()) == null) {
            return;
        }
        for (f.c e22 = e2(i11); e22 != null && (e22.a1() & a11) != 0; e22 = e22.b1()) {
            if ((e22.f1() & a11) != 0) {
                i iVar = e22;
                ?? r52 = 0;
                while (iVar != 0) {
                    if (iVar instanceof w) {
                        ((w) iVar).I(this);
                    } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                        f.c E1 = iVar.E1();
                        int i12 = 0;
                        iVar = iVar;
                        r52 = r52;
                        while (E1 != null) {
                            if ((E1.f1() & a11) != 0) {
                                i12++;
                                r52 = r52;
                                if (i12 == 1) {
                                    iVar = E1;
                                } else {
                                    if (r52 == 0) {
                                        r52 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                    }
                                    if (iVar != 0) {
                                        r52.b(iVar);
                                        iVar = 0;
                                    }
                                    r52.b(E1);
                                }
                            }
                            E1 = E1.b1();
                            iVar = iVar;
                            r52 = r52;
                        }
                        if (i12 == 1) {
                        }
                    }
                    iVar = g.g(r52);
                }
            }
            if (e22 == Y1) {
                return;
            }
        }
    }

    public final void t2() {
        this.f5432u = true;
        this.H.invoke();
        z2();
    }

    public abstract void u2(androidx.compose.ui.graphics.m1 m1Var, GraphicsLayer graphicsLayer);

    @Override // androidx.compose.ui.layout.g0
    public void w0(long j11, float f11, GraphicsLayer graphicsLayer) {
        if (!this.f5428q) {
            v2(j11, f11, null, graphicsLayer);
            return;
        }
        j0 U1 = U1();
        Intrinsics.e(U1);
        v2(U1.e1(), f11, null, graphicsLayer);
    }

    public final void w2(long j11, float f11, Function1 function1, GraphicsLayer graphicsLayer) {
        v2(o0.p.l(j11, k0()), f11, function1, graphicsLayer);
    }

    public final void x2(y.e eVar, boolean z10, boolean z11) {
        w0 w0Var = this.J;
        if (w0Var != null) {
            if (this.f5433v) {
                if (z11) {
                    long V1 = V1();
                    float i11 = y.m.i(V1) / 2.0f;
                    float g11 = y.m.g(V1) / 2.0f;
                    eVar.e(-i11, -g11, o0.t.g(k()) + i11, o0.t.f(k()) + g11);
                } else if (z10) {
                    eVar.e(0.0f, 0.0f, o0.t.g(k()), o0.t.f(k()));
                }
                if (eVar.f()) {
                    return;
                }
            }
            w0Var.mapBounds(eVar, false);
        }
        float h11 = o0.p.h(e1());
        eVar.i(eVar.b() + h11);
        eVar.j(eVar.c() + h11);
        float i12 = o0.p.i(e1());
        eVar.k(eVar.d() + i12);
        eVar.h(eVar.a() + i12);
    }

    @Override // androidx.compose.ui.layout.g0
    public void z0(long j11, float f11, Function1 function1) {
        if (!this.f5428q) {
            v2(j11, f11, function1, null);
            return;
        }
        j0 U1 = U1();
        Intrinsics.e(U1);
        v2(U1.e1(), f11, function1, null);
    }

    public final void z2() {
        if (this.J != null) {
            if (this.K != null) {
                this.K = null;
            }
            M2(this, null, false, 2, null);
            LayoutNode.f1(a1(), false, 1, null);
        }
    }
}
