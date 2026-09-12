package androidx.compose.ui.layout;

import androidx.compose.runtime.d2;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.snapshots.j;
import androidx.compose.runtime.u2;
import androidx.compose.ui.f;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.n1;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.platform.b3;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class LayoutNodeSubcompositionsState implements androidx.compose.runtime.h {

    /* renamed from: a, reason: collision with root package name */
    private final LayoutNode f5174a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.compose.runtime.m f5175b;

    /* renamed from: c, reason: collision with root package name */
    private p0 f5176c;

    /* renamed from: d, reason: collision with root package name */
    private int f5177d;

    /* renamed from: e, reason: collision with root package name */
    private int f5178e;

    /* renamed from: n, reason: collision with root package name */
    private int f5187n;

    /* renamed from: o, reason: collision with root package name */
    private int f5188o;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap f5179f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap f5180g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final c f5181h = new c();

    /* renamed from: i, reason: collision with root package name */
    private final b f5182i = new b();

    /* renamed from: j, reason: collision with root package name */
    private final HashMap f5183j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private final p0.a f5184k = new p0.a(null, 1, null);

    /* renamed from: l, reason: collision with root package name */
    private final Map f5185l = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5186m = new androidx.compose.runtime.collection.b(new Object[16], 0);

    /* renamed from: p, reason: collision with root package name */
    private final String f5189p = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Object f5190a;

        /* renamed from: b, reason: collision with root package name */
        private Function2 f5191b;

        /* renamed from: c, reason: collision with root package name */
        private d2 f5192c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5193d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f5194e;

        /* renamed from: f, reason: collision with root package name */
        private i1 f5195f;

        public a(Object obj, Function2 function2, d2 d2Var) {
            i1 c11;
            this.f5190a = obj;
            this.f5191b = function2;
            this.f5192c = d2Var;
            c11 = u2.c(Boolean.TRUE, null, 2, null);
            this.f5195f = c11;
        }

        public /* synthetic */ a(Object obj, Function2 function2, d2 d2Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i11 & 4) != 0 ? null : d2Var);
        }

        public final boolean a() {
            return ((Boolean) this.f5195f.getValue()).booleanValue();
        }

        public final d2 b() {
            return this.f5192c;
        }

        public final Function2 c() {
            return this.f5191b;
        }

        public final boolean d() {
            return this.f5193d;
        }

        public final boolean e() {
            return this.f5194e;
        }

        public final Object f() {
            return this.f5190a;
        }

        public final void g(boolean z10) {
            this.f5195f.setValue(Boolean.valueOf(z10));
        }

        public final void h(i1 i1Var) {
            this.f5195f = i1Var;
        }

        public final void i(d2 d2Var) {
            this.f5192c = d2Var;
        }

        public final void j(Function2 function2) {
            this.f5191b = function2;
        }

        public final void k(boolean z10) {
            this.f5193d = z10;
        }

        public final void l(boolean z10) {
            this.f5194e = z10;
        }

        public final void m(Object obj) {
            this.f5190a = obj;
        }
    }

    /* loaded from: classes.dex */
    private final class b implements o0, x {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ c f5196a;

        public b() {
            this.f5196a = LayoutNodeSubcompositionsState.this.f5181h;
        }

        @Override // o0.n
        public float C0() {
            return this.f5196a.C0();
        }

        @Override // androidx.compose.ui.layout.o0
        public List E(Object obj, Function2 function2) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f5180g.get(obj);
            List D = layoutNode != null ? layoutNode.D() : null;
            return D != null ? D : LayoutNodeSubcompositionsState.this.C(obj, function2);
        }

        @Override // o0.e
        public float E0(float f11) {
            return this.f5196a.E0(f11);
        }

        @Override // o0.n
        public long H(float f11) {
            return this.f5196a.H(f11);
        }

        @Override // o0.n
        public float J(long j11) {
            return this.f5196a.J(j11);
        }

        @Override // androidx.compose.ui.layout.x
        public v M0(int i11, int i12, Map map, Function1 function1, Function1 function12) {
            return this.f5196a.M0(i11, i12, map, function1, function12);
        }

        @Override // o0.e
        public long Q(float f11) {
            return this.f5196a.Q(f11);
        }

        @Override // o0.e
        public long Q0(long j11) {
            return this.f5196a.Q0(j11);
        }

        @Override // androidx.compose.ui.layout.j
        public boolean W() {
            return this.f5196a.W();
        }

        @Override // o0.e
        public int c0(float f11) {
            return this.f5196a.c0(f11);
        }

        @Override // o0.e
        public float getDensity() {
            return this.f5196a.getDensity();
        }

        @Override // androidx.compose.ui.layout.j
        public LayoutDirection getLayoutDirection() {
            return this.f5196a.getLayoutDirection();
        }

        @Override // o0.e
        public float h0(long j11) {
            return this.f5196a.h0(j11);
        }

        @Override // androidx.compose.ui.layout.x
        public v p0(int i11, int i12, Map map, Function1 function1) {
            return this.f5196a.p0(i11, i12, map, function1);
        }

        @Override // o0.e
        public float x0(int i11) {
            return this.f5196a.x0(i11);
        }

        @Override // o0.e
        public float y0(float f11) {
            return this.f5196a.y0(f11);
        }
    }

    /* loaded from: classes.dex */
    private final class c implements o0 {

        /* renamed from: a, reason: collision with root package name */
        private LayoutDirection f5198a = LayoutDirection.Rtl;

        /* renamed from: b, reason: collision with root package name */
        private float f5199b;

        /* renamed from: c, reason: collision with root package name */
        private float f5200c;

        /* loaded from: classes.dex */
        public static final class a implements v {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f5202a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f5203b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Map f5204c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function1 f5205d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f5206e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ LayoutNodeSubcompositionsState f5207f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Function1 f5208g;

            a(int i11, int i12, Map map, Function1 function1, c cVar, LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, Function1 function12) {
                this.f5202a = i11;
                this.f5203b = i12;
                this.f5204c = map;
                this.f5205d = function1;
                this.f5206e = cVar;
                this.f5207f = layoutNodeSubcompositionsState;
                this.f5208g = function12;
            }

            @Override // androidx.compose.ui.layout.v
            public int getHeight() {
                return this.f5203b;
            }

            @Override // androidx.compose.ui.layout.v
            public int getWidth() {
                return this.f5202a;
            }

            @Override // androidx.compose.ui.layout.v
            public Map v() {
                return this.f5204c;
            }

            @Override // androidx.compose.ui.layout.v
            public void w() {
                androidx.compose.ui.node.j0 U1;
                if (!this.f5206e.W() || (U1 = this.f5207f.f5174a.M().U1()) == null) {
                    this.f5208g.invoke(this.f5207f.f5174a.M().d1());
                } else {
                    this.f5208g.invoke(U1.d1());
                }
            }

            @Override // androidx.compose.ui.layout.v
            public Function1 x() {
                return this.f5205d;
            }
        }

        public c() {
        }

        @Override // o0.n
        public float C0() {
            return this.f5200c;
        }

        @Override // androidx.compose.ui.layout.o0
        public List E(Object obj, Function2 function2) {
            return LayoutNodeSubcompositionsState.this.H(obj, function2);
        }

        @Override // o0.e
        public /* synthetic */ float E0(float f11) {
            return o0.d.e(this, f11);
        }

        @Override // o0.n
        public /* synthetic */ long H(float f11) {
            return o0.m.b(this, f11);
        }

        @Override // o0.n
        public /* synthetic */ float J(long j11) {
            return o0.m.a(this, j11);
        }

        @Override // androidx.compose.ui.layout.x
        public v M0(int i11, int i12, Map map, Function1 function1, Function1 function12) {
            if (!((i11 & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & i12) == 0)) {
                g0.a.b("Size(" + i11 + " x " + i12 + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            return new a(i11, i12, map, function1, this, LayoutNodeSubcompositionsState.this, function12);
        }

        @Override // o0.e
        public /* synthetic */ long Q(float f11) {
            return o0.d.g(this, f11);
        }

        @Override // o0.e
        public /* synthetic */ long Q0(long j11) {
            return o0.d.f(this, j11);
        }

        @Override // androidx.compose.ui.layout.j
        public boolean W() {
            return LayoutNodeSubcompositionsState.this.f5174a.R() == LayoutNode.LayoutState.LookaheadLayingOut || LayoutNodeSubcompositionsState.this.f5174a.R() == LayoutNode.LayoutState.LookaheadMeasuring;
        }

        @Override // o0.e
        public /* synthetic */ int c0(float f11) {
            return o0.d.a(this, f11);
        }

        @Override // o0.e
        public float getDensity() {
            return this.f5199b;
        }

        @Override // androidx.compose.ui.layout.j
        public LayoutDirection getLayoutDirection() {
            return this.f5198a;
        }

        @Override // o0.e
        public /* synthetic */ float h0(long j11) {
            return o0.d.d(this, j11);
        }

        public void n(float f11) {
            this.f5199b = f11;
        }

        @Override // androidx.compose.ui.layout.x
        public /* synthetic */ v p0(int i11, int i12, Map map, Function1 function1) {
            return w.a(this, i11, i12, map, function1);
        }

        public void v(float f11) {
            this.f5200c = f11;
        }

        @Override // o0.e
        public /* synthetic */ float x0(int i11) {
            return o0.d.c(this, i11);
        }

        @Override // o0.e
        public /* synthetic */ float y0(float f11) {
            return o0.d.b(this, f11);
        }

        public void z(LayoutDirection layoutDirection) {
            this.f5198a = layoutDirection;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends LayoutNode.d {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f5210c;

        /* loaded from: classes.dex */
        public static final class a implements v {

            /* renamed from: a, reason: collision with root package name */
            private final /* synthetic */ v f5211a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ LayoutNodeSubcompositionsState f5212b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f5213c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ v f5214d;

            public a(v vVar, LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i11, v vVar2) {
                this.f5212b = layoutNodeSubcompositionsState;
                this.f5213c = i11;
                this.f5214d = vVar2;
                this.f5211a = vVar;
            }

            @Override // androidx.compose.ui.layout.v
            public int getHeight() {
                return this.f5211a.getHeight();
            }

            @Override // androidx.compose.ui.layout.v
            public int getWidth() {
                return this.f5211a.getWidth();
            }

            @Override // androidx.compose.ui.layout.v
            public Map v() {
                return this.f5211a.v();
            }

            @Override // androidx.compose.ui.layout.v
            public void w() {
                this.f5212b.f5178e = this.f5213c;
                this.f5214d.w();
                this.f5212b.v();
            }

            @Override // androidx.compose.ui.layout.v
            public Function1 x() {
                return this.f5211a.x();
            }
        }

        /* loaded from: classes.dex */
        public static final class b implements v {

            /* renamed from: a, reason: collision with root package name */
            private final /* synthetic */ v f5215a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ LayoutNodeSubcompositionsState f5216b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f5217c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ v f5218d;

            public b(v vVar, LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i11, v vVar2) {
                this.f5216b = layoutNodeSubcompositionsState;
                this.f5217c = i11;
                this.f5218d = vVar2;
                this.f5215a = vVar;
            }

            @Override // androidx.compose.ui.layout.v
            public int getHeight() {
                return this.f5215a.getHeight();
            }

            @Override // androidx.compose.ui.layout.v
            public int getWidth() {
                return this.f5215a.getWidth();
            }

            @Override // androidx.compose.ui.layout.v
            public Map v() {
                return this.f5215a.v();
            }

            @Override // androidx.compose.ui.layout.v
            public void w() {
                this.f5216b.f5177d = this.f5217c;
                this.f5218d.w();
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.f5216b;
                layoutNodeSubcompositionsState.u(layoutNodeSubcompositionsState.f5177d);
            }

            @Override // androidx.compose.ui.layout.v
            public Function1 x() {
                return this.f5215a.x();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Function2 function2, String str) {
            super(str);
            this.f5210c = function2;
        }

        @Override // androidx.compose.ui.layout.t
        public v c(x xVar, List list, long j11) {
            LayoutNodeSubcompositionsState.this.f5181h.z(xVar.getLayoutDirection());
            LayoutNodeSubcompositionsState.this.f5181h.n(xVar.getDensity());
            LayoutNodeSubcompositionsState.this.f5181h.v(xVar.C0());
            if (xVar.W() || LayoutNodeSubcompositionsState.this.f5174a.V() == null) {
                LayoutNodeSubcompositionsState.this.f5177d = 0;
                v vVar = (v) this.f5210c.invoke(LayoutNodeSubcompositionsState.this.f5181h, o0.b.a(j11));
                return new b(vVar, LayoutNodeSubcompositionsState.this, LayoutNodeSubcompositionsState.this.f5177d, vVar);
            }
            LayoutNodeSubcompositionsState.this.f5178e = 0;
            v vVar2 = (v) this.f5210c.invoke(LayoutNodeSubcompositionsState.this.f5182i, o0.b.a(j11));
            return new a(vVar2, LayoutNodeSubcompositionsState.this, LayoutNodeSubcompositionsState.this.f5178e, vVar2);
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements SubcomposeLayoutState.a {
        e() {
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public /* synthetic */ void a(Object obj, Function1 function1) {
            n0.c(this, obj, function1);
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public /* synthetic */ int b() {
            return n0.a(this);
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public /* synthetic */ void c(int i11, long j11) {
            n0.b(this, i11, j11);
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public void dispose() {
        }
    }

    /* loaded from: classes.dex */
    public static final class f implements SubcomposeLayoutState.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f5220b;

        f(Object obj) {
            this.f5220b = obj;
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public void a(Object obj, Function1 function1) {
            q0 e02;
            f.c k11;
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f5183j.get(this.f5220b);
            if (layoutNode == null || (e02 = layoutNode.e0()) == null || (k11 = e02.k()) == null) {
                return;
            }
            n1.d(k11, obj, function1);
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public int b() {
            List E;
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f5183j.get(this.f5220b);
            if (layoutNode == null || (E = layoutNode.E()) == null) {
                return 0;
            }
            return E.size();
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public void c(int i11, long j11) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f5183j.get(this.f5220b);
            if (layoutNode == null || !layoutNode.D0()) {
                return;
            }
            int size = layoutNode.E().size();
            if (i11 < 0 || i11 >= size) {
                throw new IndexOutOfBoundsException("Index (" + i11 + ") is out of bound of [0, " + size + ')');
            }
            if (layoutNode.n()) {
                throw new IllegalArgumentException("Pre-measure called on node that is not placed");
            }
            LayoutNode layoutNode2 = LayoutNodeSubcompositionsState.this.f5174a;
            LayoutNode.p(layoutNode2, true);
            androidx.compose.ui.node.f0.b(layoutNode).mo143measureAndLayout0kLqBqw((LayoutNode) layoutNode.E().get(i11), j11);
            LayoutNode.p(layoutNode2, false);
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public void dispose() {
            LayoutNodeSubcompositionsState.this.y();
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f5183j.remove(this.f5220b);
            if (layoutNode != null) {
                if (LayoutNodeSubcompositionsState.this.f5188o <= 0) {
                    throw new IllegalStateException("No pre-composed items to dispose");
                }
                int indexOf = LayoutNodeSubcompositionsState.this.f5174a.J().indexOf(layoutNode);
                if (indexOf < LayoutNodeSubcompositionsState.this.f5174a.J().size() - LayoutNodeSubcompositionsState.this.f5188o) {
                    throw new IllegalStateException("Item is not in pre-composed item range");
                }
                LayoutNodeSubcompositionsState.this.f5187n++;
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                layoutNodeSubcompositionsState.f5188o--;
                int size = (LayoutNodeSubcompositionsState.this.f5174a.J().size() - LayoutNodeSubcompositionsState.this.f5188o) - LayoutNodeSubcompositionsState.this.f5187n;
                LayoutNodeSubcompositionsState.this.A(indexOf, size, 1);
                LayoutNodeSubcompositionsState.this.u(size);
            }
        }
    }

    public LayoutNodeSubcompositionsState(LayoutNode layoutNode, p0 p0Var) {
        this.f5174a = layoutNode;
        this.f5176c = p0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int i11, int i12, int i13) {
        LayoutNode layoutNode = this.f5174a;
        LayoutNode.p(layoutNode, true);
        this.f5174a.P0(i11, i12, i13);
        LayoutNode.p(layoutNode, false);
    }

    static /* synthetic */ void B(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i13 = 1;
        }
        layoutNodeSubcompositionsState.A(i11, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List C(Object obj, Function2 function2) {
        if (this.f5186m.n() < this.f5178e) {
            throw new IllegalArgumentException("Error: currentPostLookaheadIndex cannot be greater than the size of thepostLookaheadComposedSlotIds list.");
        }
        int n11 = this.f5186m.n();
        int i11 = this.f5178e;
        if (n11 == i11) {
            this.f5186m.b(obj);
        } else {
            this.f5186m.y(i11, obj);
        }
        this.f5178e++;
        if (!this.f5183j.containsKey(obj)) {
            this.f5185l.put(obj, D(obj, function2));
            if (this.f5174a.R() == LayoutNode.LayoutState.LayingOut) {
                this.f5174a.a1(true);
            } else {
                LayoutNode.d1(this.f5174a, true, false, false, 6, null);
            }
        }
        LayoutNode layoutNode = (LayoutNode) this.f5183j.get(obj);
        if (layoutNode == null) {
            return CollectionsKt.l();
        }
        List Z0 = layoutNode.X().Z0();
        int size = Z0.size();
        for (int i12 = 0; i12 < size; i12++) {
            ((LayoutNodeLayoutDelegate.MeasurePassDelegate) Z0.get(i12)).i1();
        }
        return Z0;
    }

    private final void E(LayoutNode layoutNode) {
        LayoutNodeLayoutDelegate.MeasurePassDelegate X = layoutNode.X();
        LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
        X.u1(usageByParent);
        LayoutNodeLayoutDelegate.LookaheadPassDelegate U = layoutNode.U();
        if (U != null) {
            U.n1(usageByParent);
        }
    }

    private final void I(LayoutNode layoutNode, final a aVar) {
        j.a aVar2 = androidx.compose.runtime.snapshots.j.f4079e;
        androidx.compose.runtime.snapshots.j d11 = aVar2.d();
        Function1 h11 = d11 != null ? d11.h() : null;
        androidx.compose.runtime.snapshots.j f11 = aVar2.f(d11);
        try {
            LayoutNode layoutNode2 = this.f5174a;
            LayoutNode.p(layoutNode2, true);
            final Function2 c11 = aVar.c();
            d2 b11 = aVar.b();
            androidx.compose.runtime.m mVar = this.f5175b;
            if (mVar == null) {
                throw new IllegalStateException("parent composition reference not set");
            }
            aVar.i(K(b11, layoutNode, aVar.e(), mVar, androidx.compose.runtime.internal.b.b(-1750409193, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar, int i11) {
                    if ((i11 & 3) == 2 && iVar.h()) {
                        iVar.G();
                        return;
                    }
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.Q(-1750409193, i11, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:493)");
                    }
                    boolean a11 = LayoutNodeSubcompositionsState.a.this.a();
                    Function2<androidx.compose.runtime.i, Integer, Unit> function2 = c11;
                    iVar.E(Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE, Boolean.valueOf(a11));
                    boolean a12 = iVar.a(a11);
                    iVar.P(-869707859);
                    if (a11) {
                        function2.invoke(iVar, 0);
                    } else {
                        iVar.f(a12);
                    }
                    iVar.K();
                    iVar.w();
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.P();
                    }
                }
            })));
            aVar.l(false);
            LayoutNode.p(layoutNode2, false);
            Unit unit = Unit.f67184a;
        } finally {
            aVar2.m(d11, f11, h11);
        }
    }

    private final void J(LayoutNode layoutNode, Object obj, Function2 function2) {
        HashMap hashMap = this.f5179f;
        Object obj2 = hashMap.get(layoutNode);
        if (obj2 == null) {
            obj2 = new a(obj, ComposableSingletons$SubcomposeLayoutKt.f5172a.a(), null, 4, null);
            hashMap.put(layoutNode, obj2);
        }
        a aVar = (a) obj2;
        d2 b11 = aVar.b();
        boolean r11 = b11 != null ? b11.r() : true;
        if (aVar.c() != function2 || r11 || aVar.d()) {
            aVar.j(function2);
            I(layoutNode, aVar);
            aVar.k(false);
        }
    }

    private final d2 K(d2 d2Var, LayoutNode layoutNode, boolean z10, androidx.compose.runtime.m mVar, Function2 function2) {
        if (d2Var == null || d2Var.isDisposed()) {
            d2Var = b3.a(layoutNode, mVar);
        }
        if (z10) {
            d2Var.p(function2);
        } else {
            d2Var.d(function2);
        }
        return d2Var;
    }

    private final LayoutNode L(Object obj) {
        int i11;
        i1 c11;
        if (this.f5187n == 0) {
            return null;
        }
        int size = this.f5174a.J().size() - this.f5188o;
        int i12 = size - this.f5187n;
        int i13 = size - 1;
        int i14 = i13;
        while (true) {
            if (i14 < i12) {
                i11 = -1;
                break;
            }
            if (Intrinsics.c(x(i14), obj)) {
                i11 = i14;
                break;
            }
            i14--;
        }
        if (i11 == -1) {
            while (i13 >= i12) {
                Object obj2 = this.f5179f.get((LayoutNode) this.f5174a.J().get(i13));
                Intrinsics.e(obj2);
                a aVar = (a) obj2;
                if (aVar.f() == SubcomposeLayoutKt.c() || this.f5176c.b(obj, aVar.f())) {
                    aVar.m(obj);
                    i14 = i13;
                    i11 = i14;
                    break;
                }
                i13--;
            }
            i14 = i13;
        }
        if (i11 == -1) {
            return null;
        }
        if (i14 != i12) {
            A(i14, i12, 1);
        }
        this.f5187n--;
        LayoutNode layoutNode = (LayoutNode) this.f5174a.J().get(i12);
        Object obj3 = this.f5179f.get(layoutNode);
        Intrinsics.e(obj3);
        a aVar2 = (a) obj3;
        c11 = u2.c(Boolean.TRUE, null, 2, null);
        aVar2.h(c11);
        aVar2.l(true);
        aVar2.k(true);
        return layoutNode;
    }

    private final LayoutNode s(int i11) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, null);
        LayoutNode layoutNode2 = this.f5174a;
        LayoutNode.p(layoutNode2, true);
        this.f5174a.u0(i11, layoutNode);
        LayoutNode.p(layoutNode2, false);
        return layoutNode;
    }

    private final void t() {
        LayoutNode layoutNode = this.f5174a;
        LayoutNode.p(layoutNode, true);
        Iterator it = this.f5179f.values().iterator();
        while (it.hasNext()) {
            d2 b11 = ((a) it.next()).b();
            if (b11 != null) {
                b11.dispose();
            }
        }
        this.f5174a.X0();
        LayoutNode.p(layoutNode, false);
        this.f5179f.clear();
        this.f5180g.clear();
        this.f5188o = 0;
        this.f5187n = 0;
        this.f5183j.clear();
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        CollectionsKt.G(this.f5185l.entrySet(), new Function1<Map.Entry<Object, SubcomposeLayoutState.a>, Boolean>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$disposeUnusedSlotsInPostLookahead$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Map.Entry<Object, SubcomposeLayoutState.a> entry) {
                androidx.compose.runtime.collection.b bVar;
                boolean z10;
                Object key = entry.getKey();
                SubcomposeLayoutState.a value = entry.getValue();
                bVar = LayoutNodeSubcompositionsState.this.f5186m;
                int o11 = bVar.o(key);
                if (o11 < 0 || o11 >= LayoutNodeSubcompositionsState.this.f5178e) {
                    value.dispose();
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        });
    }

    private final Object x(int i11) {
        Object obj = this.f5179f.get((LayoutNode) this.f5174a.J().get(i11));
        Intrinsics.e(obj);
        return ((a) obj).f();
    }

    private final void z(boolean z10) {
        i1 c11;
        this.f5188o = 0;
        this.f5183j.clear();
        int size = this.f5174a.J().size();
        if (this.f5187n != size) {
            this.f5187n = size;
            j.a aVar = androidx.compose.runtime.snapshots.j.f4079e;
            androidx.compose.runtime.snapshots.j d11 = aVar.d();
            Function1 h11 = d11 != null ? d11.h() : null;
            androidx.compose.runtime.snapshots.j f11 = aVar.f(d11);
            for (int i11 = 0; i11 < size; i11++) {
                try {
                    LayoutNode layoutNode = (LayoutNode) this.f5174a.J().get(i11);
                    a aVar2 = (a) this.f5179f.get(layoutNode);
                    if (aVar2 != null && aVar2.a()) {
                        E(layoutNode);
                        if (z10) {
                            d2 b11 = aVar2.b();
                            if (b11 != null) {
                                b11.deactivate();
                            }
                            c11 = u2.c(Boolean.FALSE, null, 2, null);
                            aVar2.h(c11);
                        } else {
                            aVar2.g(false);
                        }
                        aVar2.m(SubcomposeLayoutKt.c());
                    }
                } catch (Throwable th2) {
                    aVar.m(d11, f11, h11);
                    throw th2;
                }
            }
            Unit unit = Unit.f67184a;
            aVar.m(d11, f11, h11);
            this.f5180g.clear();
        }
        y();
    }

    public final SubcomposeLayoutState.a D(Object obj, Function2 function2) {
        if (!this.f5174a.D0()) {
            return new e();
        }
        y();
        if (!this.f5180g.containsKey(obj)) {
            this.f5185l.remove(obj);
            HashMap hashMap = this.f5183j;
            Object obj2 = hashMap.get(obj);
            if (obj2 == null) {
                obj2 = L(obj);
                if (obj2 != null) {
                    A(this.f5174a.J().indexOf(obj2), this.f5174a.J().size(), 1);
                    this.f5188o++;
                } else {
                    obj2 = s(this.f5174a.J().size());
                    this.f5188o++;
                }
                hashMap.put(obj, obj2);
            }
            J((LayoutNode) obj2, obj, function2);
        }
        return new f(obj);
    }

    public final void F(androidx.compose.runtime.m mVar) {
        this.f5175b = mVar;
    }

    public final void G(p0 p0Var) {
        if (this.f5176c != p0Var) {
            this.f5176c = p0Var;
            z(false);
            LayoutNode.h1(this.f5174a, false, false, false, 7, null);
        }
    }

    public final List H(Object obj, Function2 function2) {
        y();
        LayoutNode.LayoutState R = this.f5174a.R();
        LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.Measuring;
        if (!(R == layoutState || R == LayoutNode.LayoutState.LayingOut || R == LayoutNode.LayoutState.LookaheadMeasuring || R == LayoutNode.LayoutState.LookaheadLayingOut)) {
            g0.a.b("subcompose can only be used inside the measure or layout blocks");
        }
        HashMap hashMap = this.f5180g;
        Object obj2 = hashMap.get(obj);
        if (obj2 == null) {
            obj2 = (LayoutNode) this.f5183j.remove(obj);
            if (obj2 != null) {
                if (!(this.f5188o > 0)) {
                    g0.a.b("Check failed.");
                }
                this.f5188o--;
            } else {
                LayoutNode L = L(obj);
                if (L == null) {
                    L = s(this.f5177d);
                }
                obj2 = L;
            }
            hashMap.put(obj, obj2);
        }
        LayoutNode layoutNode = (LayoutNode) obj2;
        if (CollectionsKt.l0(this.f5174a.J(), this.f5177d) != layoutNode) {
            int indexOf = this.f5174a.J().indexOf(layoutNode);
            int i11 = this.f5177d;
            if (indexOf < i11) {
                throw new IllegalArgumentException(("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString());
            }
            if (i11 != indexOf) {
                B(this, indexOf, i11, 0, 4, null);
            }
        }
        this.f5177d++;
        J(layoutNode, obj, function2);
        return (R == layoutState || R == LayoutNode.LayoutState.LayingOut) ? layoutNode.D() : layoutNode.C();
    }

    @Override // androidx.compose.runtime.h
    public void onDeactivate() {
        z(true);
    }

    @Override // androidx.compose.runtime.h
    public void onRelease() {
        t();
    }

    @Override // androidx.compose.runtime.h
    public void onReuse() {
        z(false);
    }

    public final t r(Function2 function2) {
        return new d(function2, this.f5189p);
    }

    public final void u(int i11) {
        boolean z10 = false;
        this.f5187n = 0;
        int size = (this.f5174a.J().size() - this.f5188o) - 1;
        if (i11 <= size) {
            this.f5184k.clear();
            if (i11 <= size) {
                int i12 = i11;
                while (true) {
                    this.f5184k.add(x(i12));
                    if (i12 == size) {
                        break;
                    } else {
                        i12++;
                    }
                }
            }
            this.f5176c.a(this.f5184k);
            j.a aVar = androidx.compose.runtime.snapshots.j.f4079e;
            androidx.compose.runtime.snapshots.j d11 = aVar.d();
            Function1 h11 = d11 != null ? d11.h() : null;
            androidx.compose.runtime.snapshots.j f11 = aVar.f(d11);
            boolean z11 = false;
            while (size >= i11) {
                try {
                    LayoutNode layoutNode = (LayoutNode) this.f5174a.J().get(size);
                    Object obj = this.f5179f.get(layoutNode);
                    Intrinsics.e(obj);
                    a aVar2 = (a) obj;
                    Object f12 = aVar2.f();
                    if (this.f5184k.contains(f12)) {
                        this.f5187n++;
                        if (aVar2.a()) {
                            E(layoutNode);
                            aVar2.g(false);
                            z11 = true;
                        }
                    } else {
                        LayoutNode layoutNode2 = this.f5174a;
                        LayoutNode.p(layoutNode2, true);
                        this.f5179f.remove(layoutNode);
                        d2 b11 = aVar2.b();
                        if (b11 != null) {
                            b11.dispose();
                        }
                        this.f5174a.Y0(size, 1);
                        LayoutNode.p(layoutNode2, false);
                    }
                    this.f5180g.remove(f12);
                    size--;
                } catch (Throwable th2) {
                    aVar.m(d11, f11, h11);
                    throw th2;
                }
            }
            Unit unit = Unit.f67184a;
            aVar.m(d11, f11, h11);
            z10 = z11;
        }
        if (z10) {
            androidx.compose.runtime.snapshots.j.f4079e.n();
        }
        y();
    }

    public final void w() {
        if (this.f5187n != this.f5174a.J().size()) {
            Iterator it = this.f5179f.entrySet().iterator();
            while (it.hasNext()) {
                ((a) ((Map.Entry) it.next()).getValue()).k(true);
            }
            if (this.f5174a.Y()) {
                return;
            }
            LayoutNode.h1(this.f5174a, false, false, false, 7, null);
        }
    }

    public final void y() {
        int size = this.f5174a.J().size();
        if (this.f5179f.size() != size) {
            throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.f5179f.size() + ") and the children count on the SubcomposeLayout (" + size + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
        }
        if ((size - this.f5187n) - this.f5188o >= 0) {
            if (this.f5183j.size() == this.f5188o) {
                return;
            }
            throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.f5188o + ". Map size " + this.f5183j.size()).toString());
        }
        throw new IllegalArgumentException(("Incorrect state. Total children " + size + ". Reusable children " + this.f5187n + ". Precomposed children " + this.f5188o).toString());
    }
}
