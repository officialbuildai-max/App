package androidx.compose.ui.node;

import androidx.compose.ui.f;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.y0;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.n2;
import androidx.compose.ui.platform.o2;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class LayoutNode implements androidx.compose.runtime.h, androidx.compose.ui.layout.h0, z0, androidx.compose.ui.layout.n, ComposeUiNode, y0.b {
    public static final c K = new c(null);
    public static final int L = 8;
    private static final d M = new b();
    private static final Function0 N = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutNode invoke() {
            return new LayoutNode(false, 0 == true ? 1 : 0, 3, null);
        }
    };
    private static final o2 O = new a();
    private static final Comparator P = new Comparator() { // from class: androidx.compose.ui.node.b0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int k11;
            k11 = LayoutNode.k((LayoutNode) obj, (LayoutNode) obj2);
            return k11;
        }
    };
    private final LayoutNodeLayoutDelegate A;
    private LayoutNodeSubcompositionsState B;
    private NodeCoordinator C;
    private boolean D;
    private androidx.compose.ui.f E;
    private androidx.compose.ui.f F;
    private Function1 G;
    private Function1 H;
    private boolean I;
    private boolean J;

    /* renamed from: a */
    private final boolean f5314a;

    /* renamed from: b */
    private int f5315b;

    /* renamed from: c */
    private int f5316c;

    /* renamed from: d */
    private boolean f5317d;

    /* renamed from: e */
    private LayoutNode f5318e;

    /* renamed from: f */
    private int f5319f;

    /* renamed from: g */
    private final n0 f5320g;

    /* renamed from: h */
    private androidx.compose.runtime.collection.b f5321h;

    /* renamed from: i */
    private boolean f5322i;

    /* renamed from: j */
    private LayoutNode f5323j;

    /* renamed from: k */
    private y0 f5324k;

    /* renamed from: l */
    private AndroidViewHolder f5325l;

    /* renamed from: m */
    private int f5326m;

    /* renamed from: n */
    private boolean f5327n;

    /* renamed from: o */
    private androidx.compose.ui.semantics.i f5328o;

    /* renamed from: p */
    private final androidx.compose.runtime.collection.b f5329p;

    /* renamed from: q */
    private boolean f5330q;

    /* renamed from: r */
    private androidx.compose.ui.layout.t f5331r;

    /* renamed from: s */
    private o0.e f5332s;

    /* renamed from: t */
    private LayoutDirection f5333t;

    /* renamed from: u */
    private o2 f5334u;

    /* renamed from: v */
    private androidx.compose.runtime.s f5335v;

    /* renamed from: w */
    private UsageByParent f5336w;

    /* renamed from: x */
    private UsageByParent f5337x;

    /* renamed from: y */
    private boolean f5338y;

    /* renamed from: z */
    private final q0 f5339z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* loaded from: classes.dex */
    public static final class a implements o2 {
        a() {
        }

        @Override // androidx.compose.ui.platform.o2
        public long a() {
            return 300L;
        }

        @Override // androidx.compose.ui.platform.o2
        public long b() {
            return 40L;
        }

        @Override // androidx.compose.ui.platform.o2
        public long c() {
            return 400L;
        }

        @Override // androidx.compose.ui.platform.o2
        public long d() {
            return o0.l.f70735a.a();
        }

        @Override // androidx.compose.ui.platform.o2
        public /* synthetic */ float e() {
            return n2.a(this);
        }

        @Override // androidx.compose.ui.platform.o2
        public float f() {
            return 16.0f;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends d {
        b() {
            super("Undefined intrinsics block and it is required");
        }

        public Void a(androidx.compose.ui.layout.x xVar, List list, long j11) {
            throw new IllegalStateException("Undefined measure and it is required");
        }

        @Override // androidx.compose.ui.layout.t
        public /* bridge */ /* synthetic */ androidx.compose.ui.layout.v c(androidx.compose.ui.layout.x xVar, List list, long j11) {
            return (androidx.compose.ui.layout.v) a(xVar, list, j11);
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function0 a() {
            return LayoutNode.N;
        }

        public final Comparator b() {
            return LayoutNode.P;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d implements androidx.compose.ui.layout.t {

        /* renamed from: a */
        private final String f5340a;

        public d(String str) {
            this.f5340a = str;
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class e {

        /* renamed from: a */
        public static final /* synthetic */ int[] f5341a;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f5341a = iArr;
        }
    }

    public LayoutNode() {
        this(false, 0, 3, null);
    }

    public LayoutNode(boolean z10, int i11) {
        o0.e eVar;
        this.f5314a = z10;
        this.f5315b = i11;
        this.f5320g = new n0(new androidx.compose.runtime.collection.b(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m123invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m123invoke() {
                LayoutNode.this.P().N();
            }
        });
        this.f5329p = new androidx.compose.runtime.collection.b(new LayoutNode[16], 0);
        this.f5330q = true;
        this.f5331r = M;
        eVar = f0.f5461a;
        this.f5332s = eVar;
        this.f5333t = LayoutDirection.Ltr;
        this.f5334u = O;
        this.f5335v = androidx.compose.runtime.s.Y0.a();
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.f5336w = usageByParent;
        this.f5337x = usageByParent;
        this.f5339z = new q0(this);
        this.A = new LayoutNodeLayoutDelegate(this);
        this.D = true;
        this.E = androidx.compose.ui.f.f4253a;
    }

    public /* synthetic */ LayoutNode(boolean z10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z10, (i12 & 2) != 0 ? androidx.compose.ui.semantics.k.a() : i11);
    }

    private final void C0() {
        LayoutNode layoutNode;
        if (this.f5319f > 0) {
            this.f5322i = true;
        }
        if (!this.f5314a || (layoutNode = this.f5323j) == null) {
            return;
        }
        layoutNode.C0();
    }

    public static /* synthetic */ boolean J0(LayoutNode layoutNode, o0.b bVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bVar = layoutNode.A.z();
        }
        return layoutNode.I0(bVar);
    }

    private final NodeCoordinator N() {
        if (this.D) {
            NodeCoordinator M2 = M();
            NodeCoordinator a22 = f0().a2();
            this.C = null;
            while (true) {
                if (Intrinsics.c(M2, a22)) {
                    break;
                }
                if ((M2 != null ? M2.T1() : null) != null) {
                    this.C = M2;
                    break;
                }
                M2 = M2 != null ? M2.a2() : null;
            }
        }
        NodeCoordinator nodeCoordinator = this.C;
        if (nodeCoordinator == null || nodeCoordinator.T1() != null) {
            return nodeCoordinator;
        }
        g0.a.c("layer was not set");
        throw new KotlinNothingValueException();
    }

    private final void Q0(LayoutNode layoutNode) {
        if (layoutNode.A.s() > 0) {
            this.A.W(r0.s() - 1);
        }
        if (this.f5324k != null) {
            layoutNode.w();
        }
        layoutNode.f5323j = null;
        layoutNode.f0().E2(null);
        if (layoutNode.f5314a) {
            this.f5319f--;
            androidx.compose.runtime.collection.b f11 = layoutNode.f5320g.f();
            int n11 = f11.n();
            if (n11 > 0) {
                Object[] m11 = f11.m();
                int i11 = 0;
                do {
                    ((LayoutNode) m11[i11]).f0().E2(null);
                    i11++;
                } while (i11 < n11);
            }
        }
        C0();
        S0();
    }

    private final void R0() {
        y0();
        LayoutNode h02 = h0();
        if (h02 != null) {
            h02.w0();
        }
        x0();
    }

    private final void U0() {
        if (this.f5322i) {
            int i11 = 0;
            this.f5322i = false;
            androidx.compose.runtime.collection.b bVar = this.f5321h;
            if (bVar == null) {
                bVar = new androidx.compose.runtime.collection.b(new LayoutNode[16], 0);
                this.f5321h = bVar;
            }
            bVar.h();
            androidx.compose.runtime.collection.b f11 = this.f5320g.f();
            int n11 = f11.n();
            if (n11 > 0) {
                Object[] m11 = f11.m();
                do {
                    LayoutNode layoutNode = (LayoutNode) m11[i11];
                    if (layoutNode.f5314a) {
                        bVar.c(bVar.n(), layoutNode.p0());
                    } else {
                        bVar.b(layoutNode);
                    }
                    i11++;
                } while (i11 < n11);
            }
            this.A.N();
        }
    }

    public static /* synthetic */ boolean W0(LayoutNode layoutNode, o0.b bVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bVar = layoutNode.A.y();
        }
        return layoutNode.V0(bVar);
    }

    public static /* synthetic */ void b1(LayoutNode layoutNode, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        layoutNode.a1(z10);
    }

    public static /* synthetic */ void d1(LayoutNode layoutNode, boolean z10, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            z12 = true;
        }
        layoutNode.c1(z10, z11, z12);
    }

    public static /* synthetic */ void f1(LayoutNode layoutNode, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        layoutNode.e1(z10);
    }

    public static /* synthetic */ void h1(LayoutNode layoutNode, boolean z10, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            z12 = true;
        }
        layoutNode.g1(z10, z11, z12);
    }

    private final void j1() {
        this.f5339z.x();
    }

    public static final int k(LayoutNode layoutNode, LayoutNode layoutNode2) {
        return layoutNode.n0() == layoutNode2.n0() ? Intrinsics.j(layoutNode.i0(), layoutNode2.i0()) : Float.compare(layoutNode.n0(), layoutNode2.n0());
    }

    private final float n0() {
        return X().e1();
    }

    private final void o1(LayoutNode layoutNode) {
        if (Intrinsics.c(layoutNode, this.f5318e)) {
            return;
        }
        this.f5318e = layoutNode;
        if (layoutNode != null) {
            this.A.q();
            NodeCoordinator Z1 = M().Z1();
            for (NodeCoordinator f02 = f0(); !Intrinsics.c(f02, Z1) && f02 != null; f02 = f02.Z1()) {
                f02.K1();
            }
        }
        y0();
    }

    public static final /* synthetic */ void p(LayoutNode layoutNode, boolean z10) {
        layoutNode.f5327n = z10;
    }

    private final void q(androidx.compose.ui.f fVar) {
        this.E = fVar;
        this.f5339z.E(fVar);
        this.A.c0();
        if (this.f5318e == null && this.f5339z.q(s0.a(512))) {
            o1(this);
        }
    }

    public static /* synthetic */ void r0(LayoutNode layoutNode, long j11, q qVar, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        boolean z12 = z10;
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        layoutNode.q0(j11, qVar, z12, z11);
    }

    private final void t() {
        this.f5337x = this.f5336w;
        this.f5336w = UsageByParent.NotUsed;
        androidx.compose.runtime.collection.b p02 = p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) m11[i11];
                if (layoutNode.f5336w == UsageByParent.InLayoutBlock) {
                    layoutNode.t();
                }
                i11++;
            } while (i11 < n11);
        }
    }

    private final String u(int i11) {
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append("  ");
        }
        sb2.append("|-");
        sb2.append(toString());
        sb2.append('\n');
        androidx.compose.runtime.collection.b p02 = p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            int i13 = 0;
            do {
                sb2.append(((LayoutNode) m11[i13]).u(i11 + 1));
                i13++;
            } while (i13 < n11);
        }
        String sb3 = sb2.toString();
        if (i11 != 0) {
            return sb3;
        }
        String substring = sb3.substring(0, sb3.length() - 1);
        Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    static /* synthetic */ String v(LayoutNode layoutNode, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return layoutNode.u(i11);
    }

    private final void v0() {
        if (this.f5339z.p(s0.a(1024) | s0.a(2048) | s0.a(4096))) {
            for (f.c k11 = this.f5339z.k(); k11 != null; k11 = k11.b1()) {
                if (((s0.a(1024) & k11.f1()) != 0) | ((s0.a(2048) & k11.f1()) != 0) | ((s0.a(4096) & k11.f1()) != 0)) {
                    t0.a(k11);
                }
            }
        }
    }

    public final boolean A() {
        return this.F != null;
    }

    public final void A0() {
        this.A.M();
    }

    public final boolean B() {
        return this.f5338y;
    }

    public final void B0() {
        this.f5328o = null;
        f0.b(this).onSemanticsChange();
    }

    public final List C() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate U = U();
        Intrinsics.e(U);
        return U.S0();
    }

    public final List D() {
        return X().Z0();
    }

    public boolean D0() {
        return this.f5324k != null;
    }

    public final List E() {
        return p0().g();
    }

    public boolean E0() {
        return this.J;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.compose.ui.semantics.i] */
    public final androidx.compose.ui.semantics.i F() {
        if (!D0() || E0()) {
            return null;
        }
        if (!this.f5339z.q(s0.a(8)) || this.f5328o != null) {
            return this.f5328o;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new androidx.compose.ui.semantics.i();
        f0.b(this).getSnapshotObserver().j(this, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m124invoke();
                return Unit.f67184a;
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
            /* JADX WARN: Type inference failed for: r6v7, types: [T, androidx.compose.ui.semantics.i] */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m124invoke() {
                int i11;
                q0 e02 = LayoutNode.this.e0();
                int a11 = s0.a(8);
                Ref.ObjectRef<androidx.compose.ui.semantics.i> objectRef2 = objectRef;
                i11 = e02.i();
                if ((i11 & a11) != 0) {
                    for (f.c o11 = e02.o(); o11 != null; o11 = o11.h1()) {
                        if ((o11.f1() & a11) != 0) {
                            i iVar = o11;
                            ?? r52 = 0;
                            while (iVar != 0) {
                                if (iVar instanceof i1) {
                                    i1 i1Var = (i1) iVar;
                                    if (i1Var.O()) {
                                        ?? iVar2 = new androidx.compose.ui.semantics.i();
                                        objectRef2.element = iVar2;
                                        iVar2.q(true);
                                    }
                                    if (i1Var.W0()) {
                                        objectRef2.element.r(true);
                                    }
                                    i1Var.R0(objectRef2.element);
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
                    }
                }
            }
        });
        T t11 = objectRef.element;
        this.f5328o = (androidx.compose.ui.semantics.i) t11;
        return (androidx.compose.ui.semantics.i) t11;
    }

    public final boolean F0() {
        return X().h1();
    }

    public androidx.compose.runtime.s G() {
        return this.f5335v;
    }

    public final Boolean G0() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate U = U();
        if (U != null) {
            return Boolean.valueOf(U.n());
        }
        return null;
    }

    public o0.e H() {
        return this.f5332s;
    }

    public final boolean H0() {
        return this.f5317d;
    }

    public final int I() {
        return this.f5326m;
    }

    public final boolean I0(o0.b bVar) {
        if (bVar == null || this.f5318e == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate U = U();
        Intrinsics.e(U);
        return U.k1(bVar.r());
    }

    public final List J() {
        return this.f5320g.b();
    }

    public final boolean K() {
        long S1 = M().S1();
        return o0.b.j(S1) && o0.b.i(S1);
    }

    public final void K0() {
        if (this.f5336w == UsageByParent.NotUsed) {
            t();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate U = U();
        Intrinsics.e(U);
        U.l1();
    }

    public int L() {
        return this.A.x();
    }

    public final void L0() {
        this.A.O();
    }

    public final NodeCoordinator M() {
        return this.f5339z.l();
    }

    public final void M0() {
        this.A.P();
    }

    public final void N0() {
        this.A.Q();
    }

    public final UsageByParent O() {
        return this.f5336w;
    }

    public final void O0() {
        this.A.R();
    }

    public final LayoutNodeLayoutDelegate P() {
        return this.A;
    }

    public final void P0(int i11, int i12, int i13) {
        if (i11 == i12) {
            return;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            this.f5320g.a(i11 > i12 ? i12 + i14 : (i12 + i13) - 2, (LayoutNode) this.f5320g.g(i11 > i12 ? i11 + i14 : i11));
        }
        S0();
        C0();
        y0();
    }

    public final boolean Q() {
        return this.A.A();
    }

    public final LayoutState R() {
        return this.A.B();
    }

    public final boolean S() {
        return this.A.F();
    }

    public final void S0() {
        if (!this.f5314a) {
            this.f5330q = true;
            return;
        }
        LayoutNode h02 = h0();
        if (h02 != null) {
            h02.S0();
        }
    }

    public final boolean T() {
        return this.A.G();
    }

    public final void T0(int i11, int i12) {
        g0.a placementScope;
        NodeCoordinator M2;
        if (this.f5336w == UsageByParent.NotUsed) {
            t();
        }
        LayoutNode h02 = h0();
        if (h02 == null || (M2 = h02.M()) == null || (placementScope = M2.d1()) == null) {
            placementScope = f0.b(this).getPlacementScope();
        }
        g0.a.l(placementScope, X(), i11, i12, 0.0f, 4, null);
    }

    public final LayoutNodeLayoutDelegate.LookaheadPassDelegate U() {
        return this.A.H();
    }

    public final LayoutNode V() {
        return this.f5318e;
    }

    public final boolean V0(o0.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (this.f5336w == UsageByParent.NotUsed) {
            s();
        }
        return X().r1(bVar.r());
    }

    public final d0 W() {
        return f0.b(this).getSharedDrawScope();
    }

    public final LayoutNodeLayoutDelegate.MeasurePassDelegate X() {
        return this.A.I();
    }

    public final void X0() {
        int e11 = this.f5320g.e();
        while (true) {
            e11--;
            if (-1 >= e11) {
                this.f5320g.c();
                return;
            }
            Q0((LayoutNode) this.f5320g.d(e11));
        }
    }

    public final boolean Y() {
        return this.A.J();
    }

    public final void Y0(int i11, int i12) {
        if (!(i12 >= 0)) {
            g0.a.a("count (" + i12 + ") must be greater than 0");
        }
        int i13 = (i12 + i11) - 1;
        if (i11 > i13) {
            return;
        }
        while (true) {
            Q0((LayoutNode) this.f5320g.d(i13));
            if (i13 == i11) {
                return;
            } else {
                i13--;
            }
        }
    }

    public androidx.compose.ui.layout.t Z() {
        return this.f5331r;
    }

    public final void Z0() {
        if (this.f5336w == UsageByParent.NotUsed) {
            t();
        }
        X().s1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
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
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void a(LayoutDirection layoutDirection) {
        int i11;
        if (this.f5333t != layoutDirection) {
            this.f5333t = layoutDirection;
            R0();
            q0 q0Var = this.f5339z;
            int a11 = s0.a(4);
            i11 = q0Var.i();
            if ((i11 & a11) != 0) {
                for (f.c k11 = q0Var.k(); k11 != null; k11 = k11.b1()) {
                    if ((k11.f1() & a11) != 0) {
                        i iVar = k11;
                        ?? r32 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof n) {
                                n nVar = (n) iVar;
                                if (nVar instanceof androidx.compose.ui.draw.b) {
                                    ((androidx.compose.ui.draw.b) nVar).o0();
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                                f.c E1 = iVar.E1();
                                int i12 = 0;
                                iVar = iVar;
                                r32 = r32;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i12++;
                                        r32 = r32;
                                        if (i12 == 1) {
                                            iVar = E1;
                                        } else {
                                            if (r32 == 0) {
                                                r32 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (iVar != 0) {
                                                r32.b(iVar);
                                                iVar = 0;
                                            }
                                            r32.b(E1);
                                        }
                                    }
                                    E1 = E1.b1();
                                    iVar = iVar;
                                    r32 = r32;
                                }
                                if (i12 == 1) {
                                }
                            }
                            iVar = g.g(r32);
                        }
                    }
                    if ((k11.a1() & a11) == 0) {
                        return;
                    }
                }
            }
        }
    }

    public final UsageByParent a0() {
        return X().c1();
    }

    public final void a1(boolean z10) {
        y0 y0Var;
        if (this.f5314a || (y0Var = this.f5324k) == null) {
            return;
        }
        y0Var.onRequestRelayout(this, true, z10);
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void b(o0.e eVar) {
        if (Intrinsics.c(this.f5332s, eVar)) {
            return;
        }
        this.f5332s = eVar;
        R0();
        for (f.c k11 = this.f5339z.k(); k11 != null; k11 = k11.b1()) {
            if ((s0.a(16) & k11.f1()) != 0) {
                ((e1) k11).z0();
            } else if (k11 instanceof androidx.compose.ui.draw.b) {
                ((androidx.compose.ui.draw.b) k11).o0();
            }
        }
    }

    public final UsageByParent b0() {
        UsageByParent Z0;
        LayoutNodeLayoutDelegate.LookaheadPassDelegate U = U();
        return (U == null || (Z0 = U.Z0()) == null) ? UsageByParent.NotUsed : Z0;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void c(int i11) {
        this.f5316c = i11;
    }

    public androidx.compose.ui.f c0() {
        return this.E;
    }

    public final void c1(boolean z10, boolean z11, boolean z12) {
        if (!(this.f5318e != null)) {
            g0.a.b("Lookahead measure cannot be requested on a node that is not a part of theLookaheadScope");
        }
        y0 y0Var = this.f5324k;
        if (y0Var == null || this.f5327n || this.f5314a) {
            return;
        }
        y0Var.onRequestMeasure(this, true, z10, z11);
        if (z12) {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate U = U();
            Intrinsics.e(U);
            U.b1(z10);
        }
    }

    @Override // androidx.compose.ui.layout.h0
    public void d() {
        if (this.f5318e != null) {
            d1(this, false, false, false, 5, null);
        } else {
            h1(this, false, false, false, 5, null);
        }
        o0.b y10 = this.A.y();
        if (y10 != null) {
            y0 y0Var = this.f5324k;
            if (y0Var != null) {
                y0Var.mo143measureAndLayout0kLqBqw(this, y10.r());
                return;
            }
            return;
        }
        y0 y0Var2 = this.f5324k;
        if (y0Var2 != null) {
            x0.c(y0Var2, false, 1, null);
        }
    }

    public final boolean d0() {
        return this.I;
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
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void e(o2 o2Var) {
        int i11;
        if (Intrinsics.c(this.f5334u, o2Var)) {
            return;
        }
        this.f5334u = o2Var;
        q0 q0Var = this.f5339z;
        int a11 = s0.a(16);
        i11 = q0Var.i();
        if ((i11 & a11) != 0) {
            for (f.c k11 = q0Var.k(); k11 != null; k11 = k11.b1()) {
                if ((k11.f1() & a11) != 0) {
                    i iVar = k11;
                    ?? r42 = 0;
                    while (iVar != 0) {
                        if (iVar instanceof e1) {
                            ((e1) iVar).T0();
                        } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                            f.c E1 = iVar.E1();
                            int i12 = 0;
                            iVar = iVar;
                            r42 = r42;
                            while (E1 != null) {
                                if ((E1.f1() & a11) != 0) {
                                    i12++;
                                    r42 = r42;
                                    if (i12 == 1) {
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
                            if (i12 == 1) {
                            }
                        }
                        iVar = g.g(r42);
                    }
                }
                if ((k11.a1() & a11) == 0) {
                    return;
                }
            }
        }
    }

    public final q0 e0() {
        return this.f5339z;
    }

    public final void e1(boolean z10) {
        y0 y0Var;
        if (this.f5314a || (y0Var = this.f5324k) == null) {
            return;
        }
        x0.e(y0Var, this, false, z10, 2, null);
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
    @Override // androidx.compose.ui.node.y0.b
    public void f() {
        NodeCoordinator M2 = M();
        int a11 = s0.a(128);
        boolean i11 = t0.i(a11);
        f.c Y1 = M2.Y1();
        if (!i11 && (Y1 = Y1.h1()) == null) {
            return;
        }
        for (f.c e22 = M2.e2(i11); e22 != null && (e22.a1() & a11) != 0; e22 = e22.b1()) {
            if ((e22.f1() & a11) != 0) {
                i iVar = e22;
                ?? r52 = 0;
                while (iVar != 0) {
                    if (iVar instanceof w) {
                        ((w) iVar).I(M());
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

    public final NodeCoordinator f0() {
        return this.f5339z.n();
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void g(androidx.compose.ui.layout.t tVar) {
        if (Intrinsics.c(this.f5331r, tVar)) {
            return;
        }
        this.f5331r = tVar;
        y0();
    }

    public final y0 g0() {
        return this.f5324k;
    }

    public final void g1(boolean z10, boolean z11, boolean z12) {
        y0 y0Var;
        if (this.f5327n || this.f5314a || (y0Var = this.f5324k) == null) {
            return;
        }
        x0.d(y0Var, this, false, z10, z11, 2, null);
        if (z12) {
            X().f1(z10);
        }
    }

    @Override // androidx.compose.ui.layout.n
    public LayoutDirection getLayoutDirection() {
        return this.f5333t;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void h(androidx.compose.ui.f fVar) {
        if (!(!this.f5314a || c0() == androidx.compose.ui.f.f4253a)) {
            g0.a.a("Modifiers are not supported on virtual LayoutNodes");
        }
        if (E0()) {
            g0.a.a("modifier is updated when deactivated");
        }
        if (D0()) {
            q(fVar);
        } else {
            this.F = fVar;
        }
    }

    public final LayoutNode h0() {
        LayoutNode layoutNode = this.f5323j;
        while (layoutNode != null && layoutNode.f5314a) {
            layoutNode = layoutNode.f5323j;
        }
        return layoutNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
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
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void i(androidx.compose.runtime.s sVar) {
        int i11;
        this.f5335v = sVar;
        b((o0.e) sVar.a(CompositionLocalsKt.c()));
        a((LayoutDirection) sVar.a(CompositionLocalsKt.g()));
        e((o2) sVar.a(CompositionLocalsKt.j()));
        q0 q0Var = this.f5339z;
        int a11 = s0.a(32768);
        i11 = q0Var.i();
        if ((i11 & a11) != 0) {
            for (f.c k11 = q0Var.k(); k11 != null; k11 = k11.b1()) {
                if ((k11.f1() & a11) != 0) {
                    i iVar = k11;
                    ?? r32 = 0;
                    while (iVar != 0) {
                        if (iVar instanceof androidx.compose.ui.node.d) {
                            f.c node = ((androidx.compose.ui.node.d) iVar).getNode();
                            if (node.k1()) {
                                t0.e(node);
                            } else {
                                node.A1(true);
                            }
                        } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                            f.c E1 = iVar.E1();
                            int i12 = 0;
                            iVar = iVar;
                            r32 = r32;
                            while (E1 != null) {
                                if ((E1.f1() & a11) != 0) {
                                    i12++;
                                    r32 = r32;
                                    if (i12 == 1) {
                                        iVar = E1;
                                    } else {
                                        if (r32 == 0) {
                                            r32 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                        }
                                        if (iVar != 0) {
                                            r32.b(iVar);
                                            iVar = 0;
                                        }
                                        r32.b(E1);
                                    }
                                }
                                E1 = E1.b1();
                                iVar = iVar;
                                r32 = r32;
                            }
                            if (i12 == 1) {
                            }
                        }
                        iVar = g.g(r32);
                    }
                }
                if ((k11.a1() & a11) == 0) {
                    return;
                }
            }
        }
    }

    public final int i0() {
        return X().d1();
    }

    public final void i1(LayoutNode layoutNode) {
        if (e.f5341a[layoutNode.R().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + layoutNode.R());
        }
        if (layoutNode.T()) {
            d1(layoutNode, true, false, false, 6, null);
            return;
        }
        if (layoutNode.S()) {
            layoutNode.a1(true);
        }
        if (layoutNode.Y()) {
            h1(layoutNode, true, false, false, 6, null);
        } else if (layoutNode.Q()) {
            layoutNode.e1(true);
        }
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return D0();
    }

    public int j0() {
        return this.f5315b;
    }

    public final LayoutNodeSubcompositionsState k0() {
        return this.B;
    }

    public final void k1() {
        androidx.compose.runtime.collection.b p02 = p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) m11[i11];
                UsageByParent usageByParent = layoutNode.f5337x;
                layoutNode.f5336w = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.k1();
                }
                i11++;
            } while (i11 < n11);
        }
    }

    public o2 l0() {
        return this.f5334u;
    }

    public final void l1(boolean z10) {
        this.f5338y = z10;
    }

    public int m0() {
        return this.A.L();
    }

    public final void m1(boolean z10) {
        this.D = z10;
    }

    @Override // androidx.compose.ui.layout.n
    public boolean n() {
        return X().n();
    }

    public final void n1(AndroidViewHolder androidViewHolder) {
        this.f5325l = androidViewHolder;
    }

    @Override // androidx.compose.ui.layout.n
    public androidx.compose.ui.layout.l o() {
        return M();
    }

    public final androidx.compose.runtime.collection.b o0() {
        if (this.f5330q) {
            this.f5329p.h();
            androidx.compose.runtime.collection.b bVar = this.f5329p;
            bVar.c(bVar.n(), p0());
            this.f5329p.A(P);
            this.f5330q = false;
        }
        return this.f5329p;
    }

    @Override // androidx.compose.runtime.h
    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.f5325l;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.B;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onDeactivate();
        }
        this.J = true;
        j1();
        if (D0()) {
            B0();
        }
    }

    @Override // androidx.compose.runtime.h
    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.f5325l;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.B;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onRelease();
        }
        NodeCoordinator Z1 = M().Z1();
        for (NodeCoordinator f02 = f0(); !Intrinsics.c(f02, Z1) && f02 != null; f02 = f02.Z1()) {
            f02.t2();
        }
    }

    @Override // androidx.compose.runtime.h
    public void onReuse() {
        if (!D0()) {
            g0.a.a("onReuse is only expected on attached node");
        }
        AndroidViewHolder androidViewHolder = this.f5325l;
        if (androidViewHolder != null) {
            androidViewHolder.onReuse();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.B;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onReuse();
        }
        if (E0()) {
            this.J = false;
            B0();
        } else {
            j1();
        }
        s1(androidx.compose.ui.semantics.k.a());
        this.f5339z.s();
        this.f5339z.y();
        i1(this);
    }

    public final androidx.compose.runtime.collection.b p0() {
        u1();
        if (this.f5319f == 0) {
            return this.f5320g.f();
        }
        androidx.compose.runtime.collection.b bVar = this.f5321h;
        Intrinsics.e(bVar);
        return bVar;
    }

    public final void p1(boolean z10) {
        this.I = z10;
    }

    public final void q0(long j11, q qVar, boolean z10, boolean z11) {
        f0().h2(NodeCoordinator.L.a(), NodeCoordinator.N1(f0(), j11, false, 2, null), qVar, z10, z11);
    }

    public final void q1(Function1 function1) {
        this.G = function1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(androidx.compose.ui.node.y0 r7) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.r(androidx.compose.ui.node.y0):void");
    }

    public final void r1(Function1 function1) {
        this.H = function1;
    }

    public final void s() {
        this.f5337x = this.f5336w;
        this.f5336w = UsageByParent.NotUsed;
        androidx.compose.runtime.collection.b p02 = p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) m11[i11];
                if (layoutNode.f5336w != UsageByParent.NotUsed) {
                    layoutNode.s();
                }
                i11++;
            } while (i11 < n11);
        }
    }

    public final void s0(long j11, q qVar, boolean z10, boolean z11) {
        f0().h2(NodeCoordinator.L.b(), NodeCoordinator.N1(f0(), j11, false, 2, null), qVar, true, z11);
    }

    public void s1(int i11) {
        this.f5315b = i11;
    }

    public final void t1(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.B = layoutNodeSubcompositionsState;
    }

    public String toString() {
        return androidx.compose.ui.platform.c1.a(this, null) + " children: " + E().size() + " measurePolicy: " + Z();
    }

    public final void u0(int i11, LayoutNode layoutNode) {
        if (!(layoutNode.f5323j == null)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot insert ");
            sb2.append(layoutNode);
            sb2.append(" because it already has a parent. This tree: ");
            sb2.append(v(this, 0, 1, null));
            sb2.append(" Other tree: ");
            LayoutNode layoutNode2 = layoutNode.f5323j;
            sb2.append(layoutNode2 != null ? v(layoutNode2, 0, 1, null) : null);
            g0.a.b(sb2.toString());
        }
        if (!(layoutNode.f5324k == null)) {
            g0.a.b("Cannot insert " + layoutNode + " because it already has an owner. This tree: " + v(this, 0, 1, null) + " Other tree: " + v(layoutNode, 0, 1, null));
        }
        layoutNode.f5323j = this;
        this.f5320g.a(i11, layoutNode);
        S0();
        if (layoutNode.f5314a) {
            this.f5319f++;
        }
        C0();
        y0 y0Var = this.f5324k;
        if (y0Var != null) {
            layoutNode.r(y0Var);
        }
        if (layoutNode.A.s() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.A;
            layoutNodeLayoutDelegate.W(layoutNodeLayoutDelegate.s() + 1);
        }
    }

    public final void u1() {
        if (this.f5319f > 0) {
            U0();
        }
    }

    public final void w() {
        y0 y0Var = this.f5324k;
        if (y0Var == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode h02 = h0();
            sb2.append(h02 != null ? v(h02, 0, 1, null) : null);
            g0.a.c(sb2.toString());
            throw new KotlinNothingValueException();
        }
        LayoutNode h03 = h0();
        if (h03 != null) {
            h03.w0();
            h03.y0();
            LayoutNodeLayoutDelegate.MeasurePassDelegate X = X();
            UsageByParent usageByParent = UsageByParent.NotUsed;
            X.u1(usageByParent);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate U = U();
            if (U != null) {
                U.n1(usageByParent);
            }
        }
        this.A.V();
        Function1 function1 = this.H;
        if (function1 != null) {
            function1.invoke(y0Var);
        }
        if (this.f5339z.q(s0.a(8))) {
            B0();
        }
        this.f5339z.z();
        this.f5327n = true;
        androidx.compose.runtime.collection.b f11 = this.f5320g.f();
        int n11 = f11.n();
        if (n11 > 0) {
            Object[] m11 = f11.m();
            int i11 = 0;
            do {
                ((LayoutNode) m11[i11]).w();
                i11++;
            } while (i11 < n11);
        }
        this.f5327n = false;
        this.f5339z.t();
        y0Var.onDetach(this);
        this.f5324k = null;
        o1(null);
        this.f5326m = 0;
        X().n1();
        LayoutNodeLayoutDelegate.LookaheadPassDelegate U2 = U();
        if (U2 != null) {
            U2.h1();
        }
    }

    public final void w0() {
        NodeCoordinator N2 = N();
        if (N2 != null) {
            N2.j2();
            return;
        }
        LayoutNode h02 = h0();
        if (h02 != null) {
            h02.w0();
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
    public final void x() {
        int i11;
        if (R() != LayoutState.Idle || Q() || Y() || E0() || !n()) {
            return;
        }
        q0 q0Var = this.f5339z;
        int a11 = s0.a(256);
        i11 = q0Var.i();
        if ((i11 & a11) != 0) {
            for (f.c k11 = q0Var.k(); k11 != null; k11 = k11.b1()) {
                if ((k11.f1() & a11) != 0) {
                    i iVar = k11;
                    ?? r52 = 0;
                    while (iVar != 0) {
                        if (iVar instanceof p) {
                            p pVar = (p) iVar;
                            pVar.v(g.h(pVar, s0.a(256)));
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
                if ((k11.a1() & a11) == 0) {
                    return;
                }
            }
        }
    }

    public final void x0() {
        NodeCoordinator f02 = f0();
        NodeCoordinator M2 = M();
        while (f02 != M2) {
            Intrinsics.f(f02, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            y yVar = (y) f02;
            w0 T1 = yVar.T1();
            if (T1 != null) {
                T1.invalidate();
            }
            f02 = yVar.Z1();
        }
        w0 T12 = M().T1();
        if (T12 != null) {
            T12.invalidate();
        }
    }

    public final void y(androidx.compose.ui.graphics.m1 m1Var, GraphicsLayer graphicsLayer) {
        f0().H1(m1Var, graphicsLayer);
    }

    public final void y0() {
        if (this.f5318e != null) {
            d1(this, false, false, false, 7, null);
        } else {
            h1(this, false, false, false, 7, null);
        }
    }

    public final boolean z() {
        AlignmentLines v11;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.A;
        if (layoutNodeLayoutDelegate.r().v().k()) {
            return true;
        }
        androidx.compose.ui.node.a C = layoutNodeLayoutDelegate.C();
        return (C == null || (v11 = C.v()) == null || !v11.k()) ? false : true;
    }

    public final void z0() {
        if (Q() || Y() || this.I) {
            return;
        }
        f0.b(this).requestOnPositionedCallback(this);
    }
}
