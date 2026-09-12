package androidx.compose.ui.node;

import androidx.compose.ui.f;
import androidx.compose.ui.node.NodeChainKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: a */
    private final LayoutNode f5508a;

    /* renamed from: b */
    private final s f5509b;

    /* renamed from: c */
    private NodeCoordinator f5510c;

    /* renamed from: d */
    private final f.c f5511d;

    /* renamed from: e */
    private f.c f5512e;

    /* renamed from: f */
    private androidx.compose.runtime.collection.b f5513f;

    /* renamed from: g */
    private androidx.compose.runtime.collection.b f5514g;

    /* renamed from: h */
    private a f5515h;

    /* loaded from: classes.dex */
    public final class a implements k {

        /* renamed from: a */
        private f.c f5516a;

        /* renamed from: b */
        private int f5517b;

        /* renamed from: c */
        private androidx.compose.runtime.collection.b f5518c;

        /* renamed from: d */
        private androidx.compose.runtime.collection.b f5519d;

        /* renamed from: e */
        private boolean f5520e;

        public a(f.c cVar, int i11, androidx.compose.runtime.collection.b bVar, androidx.compose.runtime.collection.b bVar2, boolean z10) {
            this.f5516a = cVar;
            this.f5517b = i11;
            this.f5518c = bVar;
            this.f5519d = bVar2;
            this.f5520e = z10;
        }

        @Override // androidx.compose.ui.node.k
        public boolean a(int i11, int i12) {
            return NodeChainKt.d((f.b) this.f5518c.m()[this.f5517b + i11], (f.b) this.f5519d.m()[this.f5517b + i12]) != 0;
        }

        @Override // androidx.compose.ui.node.k
        public void b(int i11) {
            int i12 = this.f5517b + i11;
            this.f5516a = q0.this.g((f.b) this.f5519d.m()[i12], this.f5516a);
            q0.d(q0.this);
            if (!this.f5520e) {
                this.f5516a.w1(true);
                return;
            }
            f.c b12 = this.f5516a.b1();
            Intrinsics.e(b12);
            NodeCoordinator c12 = b12.c1();
            Intrinsics.e(c12);
            x d11 = g.d(this.f5516a);
            if (d11 != null) {
                y yVar = new y(q0.this.m(), d11);
                this.f5516a.C1(yVar);
                q0.this.v(this.f5516a, yVar);
                yVar.E2(c12.a2());
                yVar.D2(c12);
                c12.E2(yVar);
            } else {
                this.f5516a.C1(c12);
            }
            this.f5516a.l1();
            this.f5516a.r1();
            t0.a(this.f5516a);
        }

        @Override // androidx.compose.ui.node.k
        public void c(int i11, int i12) {
            f.c b12 = this.f5516a.b1();
            Intrinsics.e(b12);
            this.f5516a = b12;
            androidx.compose.runtime.collection.b bVar = this.f5518c;
            f.b bVar2 = (f.b) bVar.m()[this.f5517b + i11];
            androidx.compose.runtime.collection.b bVar3 = this.f5519d;
            f.b bVar4 = (f.b) bVar3.m()[this.f5517b + i12];
            if (Intrinsics.c(bVar2, bVar4)) {
                q0.d(q0.this);
            } else {
                q0.this.F(bVar2, bVar4, this.f5516a);
                q0.d(q0.this);
            }
        }

        public final void d(androidx.compose.runtime.collection.b bVar) {
            this.f5519d = bVar;
        }

        @Override // androidx.compose.ui.node.k
        public void e(int i11, int i12) {
            f.c b12 = this.f5516a.b1();
            Intrinsics.e(b12);
            q0.d(q0.this);
            if ((s0.a(2) & b12.f1()) != 0) {
                NodeCoordinator c12 = b12.c1();
                Intrinsics.e(c12);
                NodeCoordinator a22 = c12.a2();
                NodeCoordinator Z1 = c12.Z1();
                Intrinsics.e(Z1);
                if (a22 != null) {
                    a22.D2(Z1);
                }
                Z1.E2(a22);
                q0.this.v(this.f5516a, Z1);
            }
            this.f5516a = q0.this.h(b12);
        }

        public final void f(androidx.compose.runtime.collection.b bVar) {
            this.f5518c = bVar;
        }

        public final void g(f.c cVar) {
            this.f5516a = cVar;
        }

        public final void h(int i11) {
            this.f5517b = i11;
        }

        public final void i(boolean z10) {
            this.f5520e = z10;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public q0(LayoutNode layoutNode) {
        this.f5508a = layoutNode;
        s sVar = new s(layoutNode);
        this.f5509b = sVar;
        this.f5510c = sVar;
        l1 Y1 = sVar.Y1();
        this.f5511d = Y1;
        this.f5512e = Y1;
    }

    private final void A(int i11, androidx.compose.runtime.collection.b bVar, androidx.compose.runtime.collection.b bVar2, f.c cVar, boolean z10) {
        o0.e(bVar.n() - i11, bVar2.n() - i11, j(cVar, i11, bVar, bVar2, z10));
        B();
    }

    private final void B() {
        NodeChainKt.a aVar;
        int i11 = 0;
        for (f.c h12 = this.f5511d.h1(); h12 != null; h12 = h12.h1()) {
            aVar = NodeChainKt.f5426a;
            if (h12 == aVar) {
                return;
            }
            i11 |= h12.f1();
            h12.t1(i11);
        }
    }

    private final f.c D(f.c cVar) {
        NodeChainKt.a aVar;
        NodeChainKt.a aVar2;
        NodeChainKt.a aVar3;
        NodeChainKt.a aVar4;
        NodeChainKt.a aVar5;
        NodeChainKt.a aVar6;
        aVar = NodeChainKt.f5426a;
        if (!(cVar == aVar)) {
            g0.a.b("trimChain called on already trimmed chain");
        }
        aVar2 = NodeChainKt.f5426a;
        f.c b12 = aVar2.b1();
        if (b12 == null) {
            b12 = this.f5511d;
        }
        b12.z1(null);
        aVar3 = NodeChainKt.f5426a;
        aVar3.v1(null);
        aVar4 = NodeChainKt.f5426a;
        aVar4.t1(-1);
        aVar5 = NodeChainKt.f5426a;
        aVar5.C1(null);
        aVar6 = NodeChainKt.f5426a;
        if (!(b12 != aVar6)) {
            g0.a.b("trimChain did not update the head");
        }
        return b12;
    }

    public final void F(f.b bVar, f.b bVar2, f.c cVar) {
        if ((bVar instanceof l0) && (bVar2 instanceof l0)) {
            NodeChainKt.f((l0) bVar2, cVar);
            if (cVar.k1()) {
                t0.e(cVar);
                return;
            } else {
                cVar.A1(true);
                return;
            }
        }
        if (!(cVar instanceof BackwardsCompatNode)) {
            throw new IllegalStateException("Unknown Modifier.Node type");
        }
        ((BackwardsCompatNode) cVar).H1(bVar2);
        if (cVar.k1()) {
            t0.e(cVar);
        } else {
            cVar.A1(true);
        }
    }

    public static final /* synthetic */ b d(q0 q0Var) {
        q0Var.getClass();
        return null;
    }

    public final f.c g(f.b bVar, f.c cVar) {
        f.c backwardsCompatNode;
        if (bVar instanceof l0) {
            backwardsCompatNode = ((l0) bVar).a();
            backwardsCompatNode.x1(t0.h(backwardsCompatNode));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(bVar);
        }
        if (backwardsCompatNode.k1()) {
            g0.a.b("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        backwardsCompatNode.w1(true);
        return r(backwardsCompatNode, cVar);
    }

    public final f.c h(f.c cVar) {
        if (cVar.k1()) {
            t0.d(cVar);
            cVar.s1();
            cVar.m1();
        }
        return w(cVar);
    }

    public final int i() {
        return this.f5512e.a1();
    }

    private final a j(f.c cVar, int i11, androidx.compose.runtime.collection.b bVar, androidx.compose.runtime.collection.b bVar2, boolean z10) {
        a aVar = this.f5515h;
        if (aVar == null) {
            a aVar2 = new a(cVar, i11, bVar, bVar2, z10);
            this.f5515h = aVar2;
            return aVar2;
        }
        aVar.g(cVar);
        aVar.h(i11);
        aVar.f(bVar);
        aVar.d(bVar2);
        aVar.i(z10);
        return aVar;
    }

    private final f.c r(f.c cVar, f.c cVar2) {
        f.c b12 = cVar2.b1();
        if (b12 != null) {
            b12.z1(cVar);
            cVar.v1(b12);
        }
        cVar2.v1(cVar);
        cVar.z1(cVar2);
        return cVar;
    }

    private final f.c u() {
        NodeChainKt.a aVar;
        NodeChainKt.a aVar2;
        NodeChainKt.a aVar3;
        NodeChainKt.a aVar4;
        f.c cVar = this.f5512e;
        aVar = NodeChainKt.f5426a;
        if (!(cVar != aVar)) {
            g0.a.b("padChain called on already padded chain");
        }
        f.c cVar2 = this.f5512e;
        aVar2 = NodeChainKt.f5426a;
        cVar2.z1(aVar2);
        aVar3 = NodeChainKt.f5426a;
        aVar3.v1(cVar2);
        aVar4 = NodeChainKt.f5426a;
        return aVar4;
    }

    public final void v(f.c cVar, NodeCoordinator nodeCoordinator) {
        NodeChainKt.a aVar;
        for (f.c h12 = cVar.h1(); h12 != null; h12 = h12.h1()) {
            aVar = NodeChainKt.f5426a;
            if (h12 == aVar) {
                LayoutNode h02 = this.f5508a.h0();
                nodeCoordinator.E2(h02 != null ? h02.M() : null);
                this.f5510c = nodeCoordinator;
                return;
            } else {
                if ((s0.a(2) & h12.f1()) != 0) {
                    return;
                }
                h12.C1(nodeCoordinator);
            }
        }
    }

    private final f.c w(f.c cVar) {
        f.c b12 = cVar.b1();
        f.c h12 = cVar.h1();
        if (b12 != null) {
            b12.z1(h12);
            cVar.v1(null);
        }
        if (h12 != null) {
            h12.v1(b12);
            cVar.z1(null);
        }
        Intrinsics.e(h12);
        return h12;
    }

    public final void C() {
        NodeCoordinator yVar;
        NodeCoordinator nodeCoordinator = this.f5509b;
        for (f.c h12 = this.f5511d.h1(); h12 != null; h12 = h12.h1()) {
            x d11 = g.d(h12);
            if (d11 != null) {
                if (h12.c1() != null) {
                    NodeCoordinator c12 = h12.c1();
                    Intrinsics.f(c12, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    yVar = (y) c12;
                    x R2 = yVar.R2();
                    yVar.U2(d11);
                    if (R2 != h12) {
                        yVar.o2();
                    }
                } else {
                    yVar = new y(this.f5508a, d11);
                    h12.C1(yVar);
                }
                nodeCoordinator.E2(yVar);
                yVar.D2(nodeCoordinator);
                nodeCoordinator = yVar;
            } else {
                h12.C1(nodeCoordinator);
            }
        }
        LayoutNode h02 = this.f5508a.h0();
        nodeCoordinator.E2(h02 != null ? h02.M() : null);
        this.f5510c = nodeCoordinator;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(androidx.compose.ui.f r13) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.q0.E(androidx.compose.ui.f):void");
    }

    public final f.c k() {
        return this.f5512e;
    }

    public final s l() {
        return this.f5509b;
    }

    public final LayoutNode m() {
        return this.f5508a;
    }

    public final NodeCoordinator n() {
        return this.f5510c;
    }

    public final f.c o() {
        return this.f5511d;
    }

    public final boolean p(int i11) {
        return (i11 & i()) != 0;
    }

    public final boolean q(int i11) {
        return (i11 & i()) != 0;
    }

    public final void s() {
        for (f.c k11 = k(); k11 != null; k11 = k11.b1()) {
            k11.l1();
        }
    }

    public final void t() {
        for (f.c o11 = o(); o11 != null; o11 = o11.h1()) {
            if (o11.k1()) {
                o11.m1();
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        if (this.f5512e != this.f5511d) {
            f.c k11 = k();
            while (true) {
                if (k11 == null || k11 == o()) {
                    break;
                }
                sb2.append(String.valueOf(k11));
                if (k11.b1() == this.f5511d) {
                    sb2.append("]");
                    break;
                }
                sb2.append(",");
                k11 = k11.b1();
            }
        } else {
            sb2.append("]");
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final void x() {
        for (f.c o11 = o(); o11 != null; o11 = o11.h1()) {
            if (o11.k1()) {
                o11.q1();
            }
        }
        z();
        t();
    }

    public final void y() {
        for (f.c k11 = k(); k11 != null; k11 = k11.b1()) {
            k11.r1();
            if (k11.e1()) {
                t0.a(k11);
            }
            if (k11.j1()) {
                t0.e(k11);
            }
            k11.w1(false);
            k11.A1(false);
        }
    }

    public final void z() {
        for (f.c o11 = o(); o11 != null; o11 = o11.h1()) {
            if (o11.k1()) {
                o11.s1();
            }
        }
    }
}
