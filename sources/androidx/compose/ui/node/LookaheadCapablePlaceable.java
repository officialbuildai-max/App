package androidx.compose.ui.node;

import androidx.collection.MutableScatterSet;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.g0;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class LookaheadCapablePlaceable extends androidx.compose.ui.layout.g0 implements androidx.compose.ui.layout.x, m0 {

    /* renamed from: n, reason: collision with root package name */
    public static final a f5409n = new a(null);

    /* renamed from: o, reason: collision with root package name */
    private static final Function1 f5410o = new Function1<c1, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((c1) obj);
            return Unit.f67184a;
        }

        public final void invoke(c1 c1Var) {
            if (c1Var.isValidOwnerScope()) {
                c1Var.a().P0(c1Var);
            }
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private androidx.compose.ui.layout.k0 f5411f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5412g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5413h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5414i;

    /* renamed from: j, reason: collision with root package name */
    private final g0.a f5415j = PlaceableKt.a(this);

    /* renamed from: k, reason: collision with root package name */
    private androidx.collection.j0 f5416k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.collection.j0 f5417l;

    /* renamed from: m, reason: collision with root package name */
    private androidx.collection.n0 f5418m;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements androidx.compose.ui.layout.v {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5419a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5420b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f5421c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f5422d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f5423e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LookaheadCapablePlaceable f5424f;

        b(int i11, int i12, Map map, Function1 function1, Function1 function12, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
            this.f5419a = i11;
            this.f5420b = i12;
            this.f5421c = map;
            this.f5422d = function1;
            this.f5423e = function12;
            this.f5424f = lookaheadCapablePlaceable;
        }

        @Override // androidx.compose.ui.layout.v
        public int getHeight() {
            return this.f5420b;
        }

        @Override // androidx.compose.ui.layout.v
        public int getWidth() {
            return this.f5419a;
        }

        @Override // androidx.compose.ui.layout.v
        public Map v() {
            return this.f5421c;
        }

        @Override // androidx.compose.ui.layout.v
        public void w() {
            this.f5423e.invoke(this.f5424f.d1());
        }

        @Override // androidx.compose.ui.layout.v
        public Function1 x() {
            return this.f5422d;
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements androidx.compose.ui.layout.k0 {
        c() {
        }

        @Override // o0.n
        public float C0() {
            return LookaheadCapablePlaceable.this.C0();
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

        @Override // o0.e
        public /* synthetic */ long Q(float f11) {
            return o0.d.g(this, f11);
        }

        @Override // o0.e
        public /* synthetic */ long Q0(long j11) {
            return o0.d.f(this, j11);
        }

        @Override // o0.e
        public /* synthetic */ int c0(float f11) {
            return o0.d.a(this, f11);
        }

        @Override // o0.e
        public float getDensity() {
            return LookaheadCapablePlaceable.this.getDensity();
        }

        @Override // o0.e
        public /* synthetic */ float h0(long j11) {
            return o0.d.d(this, j11);
        }

        @Override // o0.e
        public /* synthetic */ float x0(int i11) {
            return o0.d.c(this, i11);
        }

        @Override // o0.e
        public /* synthetic */ float y0(float f11) {
            return o0.d.b(this, f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(final c1 c1Var) {
        LookaheadCapablePlaceable c12;
        MutableScatterSet mutableScatterSet;
        OwnerSnapshotObserver snapshotObserver;
        if (this.f5414i) {
            return;
        }
        Function1 x10 = c1Var.b().x();
        androidx.collection.n0 n0Var = this.f5418m;
        char c11 = 7;
        long j11 = -9187201950435737472L;
        int i11 = 0;
        if (x10 == null) {
            if (n0Var != null) {
                Object[] objArr = n0Var.f2421c;
                long[] jArr = n0Var.f2419a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i12 = 0;
                    while (true) {
                        long j12 = jArr[i12];
                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i13 = 8 - ((~(i12 - length)) >>> 31);
                            for (int i14 = 0; i14 < i13; i14++) {
                                if ((j12 & 255) < 128) {
                                    l1((MutableScatterSet) objArr[(i12 << 3) + i14]);
                                }
                                j12 >>= 8;
                            }
                            if (i13 != 8) {
                                break;
                            }
                        }
                        if (i12 == length) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                n0Var.h();
                return;
            }
            return;
        }
        androidx.collection.j0 j0Var = this.f5417l;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i15 = 1;
        if (j0Var == null) {
            j0Var = new androidx.collection.j0(i11, i15, defaultConstructorMarker);
            this.f5417l = j0Var;
        }
        androidx.collection.j0 j0Var2 = this.f5416k;
        if (j0Var2 == null) {
            j0Var2 = new androidx.collection.j0(i11, i15, defaultConstructorMarker);
            this.f5416k = j0Var2;
        }
        j0Var.p(j0Var2);
        j0Var2.i();
        y0 g02 = a1().g0();
        if (g02 != null && (snapshotObserver = g02.getSnapshotObserver()) != null) {
            snapshotObserver.i(c1Var, f5410o, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m131invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m131invoke() {
                    Function1 x11 = c1.this.b().x();
                    if (x11 != null) {
                        x11.invoke(this.f1());
                    }
                }
            });
        }
        if (n0Var != null) {
            Object[] objArr2 = j0Var.f2384b;
            float[] fArr = j0Var.f2385c;
            long[] jArr2 = j0Var.f2383a;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i16 = 0;
                while (true) {
                    long j13 = jArr2[i16];
                    if ((((~j13) << 7) & j13 & j11) != j11) {
                        int i17 = 8 - ((~(i16 - length2)) >>> 31);
                        for (int i18 = 0; i18 < i17; i18++) {
                            if ((j13 & 255) < 128) {
                                int i19 = (i16 << 3) + i18;
                                Object obj = objArr2[i19];
                                float f11 = fArr[i19];
                                android.support.v4.media.session.c.a(obj);
                                if (j0Var2.e(null, Float.NaN) != f11 && (mutableScatterSet = (MutableScatterSet) n0Var.o(null)) != null) {
                                    l1(mutableScatterSet);
                                }
                            }
                            j13 >>= 8;
                        }
                        if (i17 != 8) {
                            break;
                        }
                    }
                    if (i16 == length2) {
                        break;
                    }
                    i16++;
                    j11 = -9187201950435737472L;
                }
            }
        }
        Object[] objArr3 = j0Var2.f2384b;
        long[] jArr3 = j0Var2.f2383a;
        int length3 = jArr3.length - 2;
        if (length3 >= 0) {
            int i20 = 0;
            while (true) {
                long j14 = jArr3[i20];
                if ((((~j14) << c11) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i21 = 8 - ((~(i20 - length3)) >>> 31);
                    for (int i22 = 0; i22 < i21; i22++) {
                        if ((j14 & 255) < 128) {
                            android.support.v4.media.session.c.a(objArr3[(i20 << 3) + i22]);
                            if (!j0Var.a(null) && (c12 = c1()) != null) {
                                c12.h1(null);
                            }
                        }
                        j14 >>= 8;
                    }
                    if (i21 != 8) {
                        break;
                    }
                }
                if (i20 == length3) {
                    break;
                }
                i20++;
                c11 = 7;
            }
        }
        j0Var.i();
    }

    private final LookaheadCapablePlaceable S0(androidx.compose.ui.layout.j0 j0Var) {
        LookaheadCapablePlaceable c12;
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            androidx.collection.j0 j0Var2 = lookaheadCapablePlaceable.f5416k;
            if ((j0Var2 != null && j0Var2.a(j0Var)) || (c12 = lookaheadCapablePlaceable.c1()) == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = c12;
        }
    }

    private final void h1(androidx.compose.ui.layout.j0 j0Var) {
        androidx.collection.n0 n0Var = S0(j0Var).f5418m;
        MutableScatterSet mutableScatterSet = n0Var != null ? (MutableScatterSet) n0Var.o(j0Var) : null;
        if (mutableScatterSet != null) {
            l1(mutableScatterSet);
        }
    }

    private final void l1(MutableScatterSet mutableScatterSet) {
        LayoutNode layoutNode;
        Object[] objArr = mutableScatterSet.f2322b;
        long[] jArr = mutableScatterSet.f2321a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i11 << 3) + i13]).get()) != null) {
                        if (W()) {
                            layoutNode.a1(false);
                        } else {
                            layoutNode.e1(false);
                        }
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
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

    public abstract int J0(androidx.compose.ui.layout.a aVar);

    @Override // androidx.compose.ui.layout.x
    public androidx.compose.ui.layout.v M0(int i11, int i12, Map map, Function1 function1, Function1 function12) {
        if (!((i11 & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & i12) == 0)) {
            g0.a.b("Size(" + i11 + " x " + i12 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new b(i11, i12, map, function1, function12, this);
    }

    @Override // o0.e
    public /* synthetic */ long Q(float f11) {
        return o0.d.g(this, f11);
    }

    @Override // o0.e
    public /* synthetic */ long Q0(long j11) {
        return o0.d.f(this, j11);
    }

    public final void R0(androidx.compose.ui.layout.v vVar) {
        if (vVar != null) {
            P0(new c1(vVar, this));
            return;
        }
        androidx.collection.n0 n0Var = this.f5418m;
        if (n0Var != null) {
            Object[] objArr = n0Var.f2421c;
            long[] jArr = n0Var.f2419a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                l1((MutableScatterSet) objArr[(i11 << 3) + i13]);
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            break;
                        }
                    }
                    if (i11 == length) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        androidx.collection.n0 n0Var2 = this.f5418m;
        if (n0Var2 != null) {
            n0Var2.h();
        }
        androidx.collection.j0 j0Var = this.f5416k;
        if (j0Var != null) {
            j0Var.i();
        }
    }

    public final int T0(androidx.compose.ui.layout.a aVar) {
        int J0;
        if (Z0() && (J0 = J0(aVar)) != Integer.MIN_VALUE) {
            return J0 + o0.p.i(k0());
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.node.m0
    public void V(boolean z10) {
        this.f5412g = z10;
    }

    @Override // androidx.compose.ui.layout.j
    public boolean W() {
        return false;
    }

    public abstract LookaheadCapablePlaceable W0();

    public abstract androidx.compose.ui.layout.l X0();

    public abstract boolean Z0();

    public abstract LayoutNode a1();

    public abstract androidx.compose.ui.layout.v b1();

    @Override // o0.e
    public /* synthetic */ int c0(float f11) {
        return o0.d.a(this, f11);
    }

    public abstract LookaheadCapablePlaceable c1();

    public final g0.a d1() {
        return this.f5415j;
    }

    public abstract long e1();

    public final androidx.compose.ui.layout.k0 f1() {
        androidx.compose.ui.layout.k0 k0Var = this.f5411f;
        return k0Var == null ? new c() : k0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g1(NodeCoordinator nodeCoordinator) {
        AlignmentLines v11;
        NodeCoordinator Z1 = nodeCoordinator.Z1();
        if (!Intrinsics.c(Z1 != null ? Z1.a1() : null, nodeCoordinator.a1())) {
            nodeCoordinator.P1().v().m();
            return;
        }
        androidx.compose.ui.node.a D = nodeCoordinator.P1().D();
        if (D == null || (v11 = D.v()) == null) {
            return;
        }
        v11.m();
    }

    @Override // o0.e
    public /* synthetic */ float h0(long j11) {
        return o0.d.d(this, j11);
    }

    public boolean i1() {
        return this.f5412g;
    }

    public final boolean j1() {
        return this.f5414i;
    }

    public final boolean k1() {
        return this.f5413h;
    }

    public abstract void m1();

    public final void n1(boolean z10) {
        this.f5414i = z10;
    }

    public final void o1(boolean z10) {
        this.f5413h = z10;
    }

    @Override // androidx.compose.ui.layout.x
    public /* synthetic */ androidx.compose.ui.layout.v p0(int i11, int i12, Map map, Function1 function1) {
        return androidx.compose.ui.layout.w.a(this, i11, i12, map, function1);
    }

    @Override // o0.e
    public /* synthetic */ float x0(int i11) {
        return o0.d.c(this, i11);
    }

    @Override // o0.e
    public /* synthetic */ float y0(float f11) {
        return o0.d.b(this, f11);
    }
}
