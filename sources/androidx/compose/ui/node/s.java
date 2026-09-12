package androidx.compose.ui.node;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.n4;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class s extends NodeCoordinator {
    public static final a V = new a(null);
    private static final m4 W;
    private final l1 T;
    private j0 U;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private final class b extends j0 {
        public b() {
            super(s.this);
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public int J0(androidx.compose.ui.layout.a aVar) {
            Integer num = (Integer) r1().z().get(aVar);
            int intValue = num != null ? num.intValue() : Integer.MIN_VALUE;
            t1().put(aVar, Integer.valueOf(intValue));
            return intValue;
        }

        @Override // androidx.compose.ui.layout.s
        public androidx.compose.ui.layout.g0 P(long j11) {
            j0.p1(this, j11);
            androidx.compose.runtime.collection.b p02 = a1().p0();
            int n11 = p02.n();
            if (n11 > 0) {
                Object[] m11 = p02.m();
                int i11 = 0;
                do {
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate U = ((LayoutNode) m11[i11]).U();
                    Intrinsics.e(U);
                    U.n1(LayoutNode.UsageByParent.NotUsed);
                    i11++;
                } while (i11 < n11);
            }
            j0.q1(this, a1().Z().c(this, a1().C(), j11));
            return this;
        }

        @Override // androidx.compose.ui.node.j0
        protected void x1() {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate U = a1().U();
            Intrinsics.e(U);
            U.i1();
        }
    }

    static {
        m4 a11 = androidx.compose.ui.graphics.t0.a();
        a11.s(u1.f4733b.c());
        a11.setStrokeWidth(1.0f);
        a11.C(n4.f4683a.b());
        W = a11;
    }

    public s(LayoutNode layoutNode) {
        super(layoutNode);
        this.T = new l1();
        Y1().C1(this);
        this.U = layoutNode.V() != null ? new b() : null;
    }

    private final void R2() {
        if (k1()) {
            return;
        }
        s2();
        a1().X().o1();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int J0(androidx.compose.ui.layout.a aVar) {
        j0 U1 = U1();
        if (U1 != null) {
            return U1.J0(aVar);
        }
        Integer num = (Integer) P1().z().get(aVar);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void K1() {
        if (U1() == null) {
            S2(new b());
        }
    }

    @Override // androidx.compose.ui.layout.s
    public androidx.compose.ui.layout.g0 P(long j11) {
        if (Q1()) {
            j0 U1 = U1();
            Intrinsics.e(U1);
            j11 = U1.u1();
        }
        F0(j11);
        androidx.compose.runtime.collection.b p02 = a1().p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                ((LayoutNode) m11[i11]).X().u1(LayoutNode.UsageByParent.NotUsed);
                i11++;
            } while (i11 < n11);
        }
        B2(a1().Z().c(this, a1().D(), j11));
        r2();
        return this;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    /* renamed from: Q2, reason: merged with bridge method [inline-methods] */
    public l1 Y1() {
        return this.T;
    }

    protected void S2(j0 j0Var) {
        this.U = j0Var;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public j0 U1() {
        return this.U;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
    @Override // androidx.compose.ui.node.NodeCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i2(androidx.compose.ui.node.NodeCoordinator.d r16, long r17, androidx.compose.ui.node.q r19, boolean r20, boolean r21) {
        /*
            r15 = this;
            r0 = r15
            r8 = r17
            androidx.compose.ui.node.LayoutNode r1 = r15.a1()
            r10 = r16
            boolean r1 = r10.d(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L33
            boolean r1 = r15.P2(r8)
            if (r1 == 0) goto L1b
            r11 = r21
        L19:
            r3 = r2
            goto L35
        L1b:
            if (r20 == 0) goto L33
            long r4 = r15.V1()
            float r1 = r15.G1(r8, r4)
            boolean r4 = java.lang.Float.isInfinite(r1)
            if (r4 != 0) goto L33
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L33
            r11 = r3
            goto L19
        L33:
            r11 = r21
        L35:
            if (r3 == 0) goto L82
            int r12 = androidx.compose.ui.node.q.c(r19)
            androidx.compose.ui.node.LayoutNode r1 = r15.a1()
            androidx.compose.runtime.collection.b r1 = r1.o0()
            int r3 = r1.n()
            if (r3 <= 0) goto L77
            int r3 = r3 - r2
            java.lang.Object[] r13 = r1.m()
            r14 = r3
        L4f:
            r1 = r13[r14]
            r2 = r1
            androidx.compose.ui.node.LayoutNode r2 = (androidx.compose.ui.node.LayoutNode) r2
            boolean r1 = r2.n()
            if (r1 == 0) goto L7a
            r1 = r16
            r3 = r17
            r5 = r19
            r6 = r20
            r7 = r11
            r1.c(r2, r3, r5, r6, r7)
            boolean r1 = r19.p()
            if (r1 != 0) goto L6d
            goto L7a
        L6d:
            boolean r1 = r19.n()
            if (r1 == 0) goto L77
            r19.a()
            goto L7a
        L77:
            r1 = r19
            goto L7f
        L7a:
            int r14 = r14 + (-1)
            if (r14 >= 0) goto L4f
            goto L77
        L7f:
            androidx.compose.ui.node.q.f(r1, r12)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.s.i2(androidx.compose.ui.node.NodeCoordinator$d, long, androidx.compose.ui.node.q, boolean, boolean):void");
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void u2(androidx.compose.ui.graphics.m1 m1Var, GraphicsLayer graphicsLayer) {
        y0 b11 = f0.b(a1());
        androidx.compose.runtime.collection.b o02 = a1().o0();
        int n11 = o02.n();
        if (n11 > 0) {
            Object[] m11 = o02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) m11[i11];
                if (layoutNode.n()) {
                    layoutNode.y(m1Var, graphicsLayer);
                }
                i11++;
            } while (i11 < n11);
        }
        if (b11.getShowLayoutBounds()) {
            I1(m1Var, W);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.g0
    public void w0(long j11, float f11, GraphicsLayer graphicsLayer) {
        super.w0(j11, f11, graphicsLayer);
        R2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.g0
    public void z0(long j11, float f11, Function1 function1) {
        super.z0(j11, f11, function1);
        R2();
    }
}
