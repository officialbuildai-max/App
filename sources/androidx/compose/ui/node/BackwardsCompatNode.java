package androidx.compose.ui.node;

import androidx.compose.ui.f;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class BackwardsCompatNode extends f.c implements x, n, i1, e1, androidx.compose.ui.modifier.h, androidx.compose.ui.modifier.k, a1, w, p, androidx.compose.ui.focus.c, androidx.compose.ui.focus.m, androidx.compose.ui.focus.q, z0, androidx.compose.ui.draw.a {

    /* renamed from: n, reason: collision with root package name */
    private f.b f5291n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5292o;

    /* renamed from: p, reason: collision with root package name */
    private androidx.compose.ui.modifier.a f5293p;

    /* renamed from: q, reason: collision with root package name */
    private HashSet f5294q;

    /* renamed from: r, reason: collision with root package name */
    private androidx.compose.ui.layout.l f5295r;

    public BackwardsCompatNode(f.b bVar) {
        x1(t0.f(bVar));
        this.f5291n = bVar;
        this.f5292o = true;
        this.f5294q = new HashSet();
    }

    private final void F1(boolean z10) {
        if (!k1()) {
            g0.a.b("initializeModifier called on unattached node");
        }
        f.b bVar = this.f5291n;
        if ((s0.a(32) & f1()) != 0) {
            if (bVar instanceof androidx.compose.ui.modifier.d) {
                B1(new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m121invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m121invoke() {
                        BackwardsCompatNode.this.J1();
                    }
                });
            }
            if (bVar instanceof androidx.compose.ui.modifier.j) {
                K1((androidx.compose.ui.modifier.j) bVar);
            }
        }
        if ((s0.a(4) & f1()) != 0 && !z10) {
            a0.a(this);
        }
        if ((s0.a(2) & f1()) != 0) {
            if (BackwardsCompatNodeKt.c(this)) {
                NodeCoordinator c12 = c1();
                Intrinsics.e(c12);
                ((y) c12).U2(this);
                c12.o2();
            }
            if (!z10) {
                a0.a(this);
                g.m(this).y0();
            }
        }
        if (bVar instanceof androidx.compose.ui.layout.i0) {
            ((androidx.compose.ui.layout.i0) bVar).d(g.m(this));
        }
        s0.a(128);
        f1();
        if ((s0.a(256) & f1()) != 0 && (bVar instanceof androidx.compose.ui.layout.b0) && BackwardsCompatNodeKt.c(this)) {
            g.m(this).y0();
        }
        if ((s0.a(16) & f1()) != 0 && (bVar instanceof androidx.compose.ui.input.pointer.d0)) {
            ((androidx.compose.ui.input.pointer.d0) bVar).g().f(c1());
        }
        if ((s0.a(8) & f1()) != 0) {
            g.n(this).onSemanticsChange();
        }
    }

    private final void I1() {
        if (!k1()) {
            g0.a.b("unInitializeModifier called on unattached node");
        }
        f.b bVar = this.f5291n;
        if ((s0.a(32) & f1()) != 0) {
            if (bVar instanceof androidx.compose.ui.modifier.j) {
                g.n(this).getModifierLocalManager().d(this, ((androidx.compose.ui.modifier.j) bVar).getKey());
            }
            if (bVar instanceof androidx.compose.ui.modifier.d) {
                ((androidx.compose.ui.modifier.d) bVar).f(BackwardsCompatNodeKt.a());
            }
        }
        if ((s0.a(8) & f1()) != 0) {
            g.n(this).onSemanticsChange();
        }
    }

    private final void K1(androidx.compose.ui.modifier.j jVar) {
        androidx.compose.ui.modifier.a aVar = this.f5293p;
        if (aVar != null && aVar.a(jVar.getKey())) {
            aVar.c(jVar);
            g.n(this).getModifierLocalManager().f(this, jVar.getKey());
        } else {
            this.f5293p = new androidx.compose.ui.modifier.a(jVar);
            if (BackwardsCompatNodeKt.c(this)) {
                g.n(this).getModifierLocalManager().a(this, jVar.getKey());
            }
        }
    }

    public final f.b D1() {
        return this.f5291n;
    }

    public final HashSet E1() {
        return this.f5294q;
    }

    @Override // androidx.compose.ui.node.w
    public void F(long j11) {
    }

    public final void G1() {
        this.f5292o = true;
        o.a(this);
    }

    public final void H1(f.b bVar) {
        if (k1()) {
            I1();
        }
        this.f5291n = bVar;
        x1(t0.f(bVar));
        if (k1()) {
            F1(false);
        }
    }

    @Override // androidx.compose.ui.node.w
    public void I(androidx.compose.ui.layout.l lVar) {
        this.f5295r = lVar;
    }

    public final void J1() {
        if (k1()) {
            this.f5294q.clear();
            g.n(this).getSnapshotObserver().i(this, BackwardsCompatNodeKt.b(), new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateModifierLocalConsumer$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m122invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m122invoke() {
                    f.b D1 = BackwardsCompatNode.this.D1();
                    Intrinsics.f(D1, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
                    ((androidx.compose.ui.modifier.d) D1).f(BackwardsCompatNode.this);
                }
            });
        }
    }

    @Override // androidx.compose.ui.node.e1
    public void M(androidx.compose.ui.input.pointer.o oVar, PointerEventPass pointerEventPass, long j11) {
        f.b bVar = this.f5291n;
        Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((androidx.compose.ui.input.pointer.d0) bVar).g().e(oVar, pointerEventPass, j11);
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean O() {
        return h1.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r3v9 */
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
    @Override // androidx.compose.ui.modifier.k
    public Object P(androidx.compose.ui.modifier.c cVar) {
        q0 e02;
        this.f5294q.add(cVar);
        int a11 = s0.a(32);
        if (!getNode().k1()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        f.c h12 = getNode().h1();
        LayoutNode m11 = g.m(this);
        while (m11 != null) {
            if ((m11.e0().k().a1() & a11) != 0) {
                while (h12 != null) {
                    if ((h12.f1() & a11) != 0) {
                        i iVar = h12;
                        ?? r52 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof androidx.compose.ui.modifier.h) {
                                androidx.compose.ui.modifier.h hVar = (androidx.compose.ui.modifier.h) iVar;
                                if (hVar.V().a(cVar)) {
                                    return hVar.V().b(cVar);
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof i)) {
                                f.c E1 = iVar.E1();
                                int i11 = 0;
                                iVar = iVar;
                                r52 = r52;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        r52 = r52;
                                        if (i11 == 1) {
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
                                if (i11 == 1) {
                                }
                            }
                            iVar = g.g(r52);
                        }
                    }
                    h12 = h12.h1();
                }
            }
            m11 = m11.h0();
            h12 = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
        }
        return cVar.a().invoke();
    }

    @Override // androidx.compose.ui.node.e1
    public boolean P0() {
        f.b bVar = this.f5291n;
        Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((androidx.compose.ui.input.pointer.d0) bVar).g().c();
    }

    @Override // androidx.compose.ui.node.e1
    public boolean R() {
        f.b bVar = this.f5291n;
        Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((androidx.compose.ui.input.pointer.d0) bVar).g().a();
    }

    @Override // androidx.compose.ui.node.i1
    public void R0(androidx.compose.ui.semantics.n nVar) {
        f.b bVar = this.f5291n;
        Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        androidx.compose.ui.semantics.i h11 = ((androidx.compose.ui.semantics.j) bVar).h();
        Intrinsics.f(nVar, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsConfiguration");
        ((androidx.compose.ui.semantics.i) nVar).c(h11);
    }

    @Override // androidx.compose.ui.focus.c
    public void S0(androidx.compose.ui.focus.r rVar) {
        f.b bVar = this.f5291n;
        g0.a.b("onFocusEvent called on wrong node");
        android.support.v4.media.session.c.a(bVar);
        throw null;
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void T0() {
        d1.c(this);
    }

    @Override // androidx.compose.ui.modifier.h
    public androidx.compose.ui.modifier.f V() {
        androidx.compose.ui.modifier.a aVar = this.f5293p;
        return aVar != null ? aVar : androidx.compose.ui.modifier.i.a();
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean W0() {
        return h1.b(this);
    }

    @Override // androidx.compose.ui.draw.a
    public o0.e getDensity() {
        return g.m(this).H();
    }

    @Override // androidx.compose.ui.draw.a
    public LayoutDirection getLayoutDirection() {
        return g.m(this).getLayoutDirection();
    }

    @Override // androidx.compose.ui.draw.a
    public long i() {
        return o0.u.d(g.h(this, s0.a(128)).k());
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return k1();
    }

    @Override // androidx.compose.ui.node.n
    public void n(z.c cVar) {
        f.b bVar = this.f5291n;
        Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        ((androidx.compose.ui.draw.f) bVar).n(cVar);
    }

    @Override // androidx.compose.ui.f.c
    public void n1() {
        F1(true);
    }

    @Override // androidx.compose.ui.f.c
    public void o1() {
        I1();
    }

    @Override // androidx.compose.ui.focus.m
    public void r0(androidx.compose.ui.focus.k kVar) {
        f.b bVar = this.f5291n;
        g0.a.b("applyFocusProperties called on wrong node");
        android.support.v4.media.session.c.a(bVar);
        new androidx.compose.ui.focus.h(kVar);
        throw null;
    }

    @Override // androidx.compose.ui.node.e1
    public void t0() {
        f.b bVar = this.f5291n;
        Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((androidx.compose.ui.input.pointer.d0) bVar).g().d();
    }

    public String toString() {
        return this.f5291n.toString();
    }

    @Override // androidx.compose.ui.node.p
    public void v(androidx.compose.ui.layout.l lVar) {
        f.b bVar = this.f5291n;
        Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((androidx.compose.ui.layout.b0) bVar).v(lVar);
    }

    @Override // androidx.compose.ui.node.a1
    public Object v0(o0.e eVar, Object obj) {
        f.b bVar = this.f5291n;
        Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        android.support.v4.media.session.c.a(bVar);
        throw null;
    }

    @Override // androidx.compose.ui.node.n
    public void w0() {
        this.f5292o = true;
        o.a(this);
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.v z(androidx.compose.ui.layout.x xVar, androidx.compose.ui.layout.s sVar, long j11) {
        f.b bVar = this.f5291n;
        Intrinsics.f(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((androidx.compose.ui.layout.o) bVar).z(xVar, sVar, j11);
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void z0() {
        d1.b(this);
    }
}
