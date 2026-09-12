package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class j0 extends LookaheadCapablePlaceable implements androidx.compose.ui.layout.s {

    /* renamed from: p */
    private final NodeCoordinator f5469p;

    /* renamed from: r */
    private Map f5471r;

    /* renamed from: t */
    private androidx.compose.ui.layout.v f5473t;

    /* renamed from: q */
    private long f5470q = o0.p.f70738b.a();

    /* renamed from: s */
    private final androidx.compose.ui.layout.q f5472s = new androidx.compose.ui.layout.q(this);

    /* renamed from: u */
    private final Map f5474u = new LinkedHashMap();

    public j0(NodeCoordinator nodeCoordinator) {
        this.f5469p = nodeCoordinator;
    }

    public final void C1(androidx.compose.ui.layout.v vVar) {
        Unit unit;
        Map map;
        if (vVar != null) {
            B0(o0.u.a(vVar.getWidth(), vVar.getHeight()));
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        if (unit == null) {
            B0(o0.t.f70747b.a());
        }
        if (!Intrinsics.c(this.f5473t, vVar) && vVar != null && ((((map = this.f5471r) != null && !map.isEmpty()) || !vVar.v().isEmpty()) && !Intrinsics.c(vVar.v(), this.f5471r))) {
            r1().v().m();
            Map map2 = this.f5471r;
            if (map2 == null) {
                map2 = new LinkedHashMap();
                this.f5471r = map2;
            }
            map2.clear();
            map2.putAll(vVar.v());
        }
        this.f5473t = vVar;
    }

    public static final /* synthetic */ void p1(j0 j0Var, long j11) {
        j0Var.F0(j11);
    }

    public static final /* synthetic */ void q1(j0 j0Var, androidx.compose.ui.layout.v vVar) {
        j0Var.C1(vVar);
    }

    private final void y1(long j11) {
        if (!o0.p.g(e1(), j11)) {
            B1(j11);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate H = a1().P().H();
            if (H != null) {
                H.f1();
            }
            g1(this.f5469p);
        }
        if (j1()) {
            return;
        }
        R0(b1());
    }

    public final long A1(j0 j0Var, boolean z10) {
        long a11 = o0.p.f70738b.a();
        j0 j0Var2 = this;
        while (!Intrinsics.c(j0Var2, j0Var)) {
            if (!j0Var2.i1() || !z10) {
                a11 = o0.p.l(a11, j0Var2.e1());
            }
            NodeCoordinator a22 = j0Var2.f5469p.a2();
            Intrinsics.e(a22);
            j0Var2 = a22.U1();
            Intrinsics.e(j0Var2);
        }
        return a11;
    }

    public void B1(long j11) {
        this.f5470q = j11;
    }

    @Override // o0.n
    public float C0() {
        return this.f5469p.C0();
    }

    @Override // androidx.compose.ui.layout.g0, androidx.compose.ui.layout.i
    public Object G() {
        return this.f5469p.G();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.layout.j
    public boolean W() {
        return true;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable W0() {
        NodeCoordinator Z1 = this.f5469p.Z1();
        if (Z1 != null) {
            return Z1.U1();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.layout.l X0() {
        return this.f5472s;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean Z0() {
        return this.f5473t != null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutNode a1() {
        return this.f5469p.a1();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.layout.v b1() {
        androidx.compose.ui.layout.v vVar = this.f5473t;
        if (vVar != null) {
            return vVar;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.");
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable c1() {
        NodeCoordinator a22 = this.f5469p.a2();
        if (a22 != null) {
            return a22.U1();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long e1() {
        return this.f5470q;
    }

    @Override // o0.e
    public float getDensity() {
        return this.f5469p.getDensity();
    }

    @Override // androidx.compose.ui.layout.j
    public LayoutDirection getLayoutDirection() {
        return this.f5469p.getLayoutDirection();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void m1() {
        z0(e1(), 0.0f, null);
    }

    public a r1() {
        a C = this.f5469p.a1().P().C();
        Intrinsics.e(C);
        return C;
    }

    public final int s1(androidx.compose.ui.layout.a aVar) {
        Integer num = (Integer) this.f5474u.get(aVar);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    public final Map t1() {
        return this.f5474u;
    }

    public final long u1() {
        return t0();
    }

    public final NodeCoordinator v1() {
        return this.f5469p;
    }

    public final androidx.compose.ui.layout.q w1() {
        return this.f5472s;
    }

    protected void x1() {
        b1().w();
    }

    @Override // androidx.compose.ui.layout.g0
    public final void z0(long j11, float f11, Function1 function1) {
        y1(j11);
        if (k1()) {
            return;
        }
        x1();
    }

    public final void z1(long j11) {
        y1(o0.p.l(j11, k0()));
    }
}
