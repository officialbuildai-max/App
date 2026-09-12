package androidx.compose.ui.semantics;

import androidx.compose.ui.f;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.node.s0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import o0.t;

/* loaded from: classes.dex */
public final class SemanticsNode {

    /* renamed from: a, reason: collision with root package name */
    private final f.c f5986a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5987b;

    /* renamed from: c, reason: collision with root package name */
    private final LayoutNode f5988c;

    /* renamed from: d, reason: collision with root package name */
    private final i f5989d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5990e;

    /* renamed from: f, reason: collision with root package name */
    private SemanticsNode f5991f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5992g;

    /* loaded from: classes.dex */
    public static final class a extends f.c implements i1 {

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ Function1 f5993n;

        a(Function1 function1) {
            this.f5993n = function1;
        }

        @Override // androidx.compose.ui.node.i1
        public /* synthetic */ boolean O() {
            return h1.a(this);
        }

        @Override // androidx.compose.ui.node.i1
        public void R0(n nVar) {
            this.f5993n.invoke(nVar);
        }

        @Override // androidx.compose.ui.node.i1
        public /* synthetic */ boolean W0() {
            return h1.b(this);
        }
    }

    public SemanticsNode(f.c cVar, boolean z10, LayoutNode layoutNode, i iVar) {
        this.f5986a = cVar;
        this.f5987b = z10;
        this.f5988c = layoutNode;
        this.f5989d = iVar;
        this.f5992g = layoutNode.j0();
    }

    private final void B(i iVar) {
        if (this.f5989d.n()) {
            return;
        }
        List D = D(this, false, false, 3, null);
        int size = D.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode = (SemanticsNode) D.get(i11);
            if (!semanticsNode.y()) {
                iVar.p(semanticsNode.f5989d);
                semanticsNode.B(iVar);
            }
        }
    }

    public static /* synthetic */ List D(SemanticsNode semanticsNode, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return semanticsNode.C(z10, z11);
    }

    private final void b(List list) {
        final f c11 = l.c(this);
        if (c11 != null && this.f5989d.o() && !list.isEmpty()) {
            list.add(c(c11, new Function1<n, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((n) obj);
                    return Unit.f67184a;
                }

                public final void invoke(n nVar) {
                    SemanticsPropertiesKt.B(nVar, f.this.n());
                }
            }));
        }
        i iVar = this.f5989d;
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        if (iVar.e(semanticsProperties.d()) && !list.isEmpty() && this.f5989d.o()) {
            List list2 = (List) SemanticsConfigurationKt.a(this.f5989d, semanticsProperties.d());
            final String str = list2 != null ? (String) CollectionsKt.k0(list2) : null;
            if (str != null) {
                list.add(0, c(null, new Function1<n, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((n) obj);
                        return Unit.f67184a;
                    }

                    public final void invoke(n nVar) {
                        SemanticsPropertiesKt.v(nVar, str);
                    }
                }));
            }
        }
    }

    private final SemanticsNode c(f fVar, Function1 function1) {
        i iVar = new i();
        iVar.r(false);
        iVar.q(false);
        function1.invoke(iVar);
        SemanticsNode semanticsNode = new SemanticsNode(new a(function1), false, new LayoutNode(true, fVar != null ? l.d(this) : l.b(this)), iVar);
        semanticsNode.f5990e = true;
        semanticsNode.f5991f = this;
        return semanticsNode;
    }

    private final void d(LayoutNode layoutNode, List list, boolean z10) {
        androidx.compose.runtime.collection.b o02 = layoutNode.o0();
        int n11 = o02.n();
        if (n11 > 0) {
            Object[] m11 = o02.m();
            int i11 = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) m11[i11];
                if (layoutNode2.D0() && (z10 || !layoutNode2.E0())) {
                    if (layoutNode2.e0().q(s0.a(8))) {
                        list.add(l.a(layoutNode2, this.f5987b));
                    } else {
                        d(layoutNode2, list, z10);
                    }
                }
                i11++;
            } while (i11 < n11);
        }
    }

    private final List f(List list) {
        List D = D(this, false, false, 3, null);
        int size = D.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode = (SemanticsNode) D.get(i11);
            if (semanticsNode.y()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.f5989d.n()) {
                semanticsNode.f(list);
            }
        }
        return list;
    }

    static /* synthetic */ List g(SemanticsNode semanticsNode, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = new ArrayList();
        }
        return semanticsNode.f(list);
    }

    public static /* synthetic */ List m(SemanticsNode semanticsNode, boolean z10, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = !semanticsNode.f5987b;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            z12 = false;
        }
        return semanticsNode.l(z10, z11, z12);
    }

    private final boolean y() {
        return this.f5987b && this.f5989d.o();
    }

    public final boolean A() {
        return !this.f5990e && t().isEmpty() && l.f(this.f5988c, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$isUnmergedLeafNode$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode layoutNode) {
                i F = layoutNode.F();
                boolean z10 = false;
                if (F != null && F.o()) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }) == null;
    }

    public final List C(boolean z10, boolean z11) {
        if (this.f5990e) {
            return CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        d(this.f5988c, arrayList, z11);
        if (z10) {
            b(arrayList);
        }
        return arrayList;
    }

    public final SemanticsNode a() {
        return new SemanticsNode(this.f5986a, true, this.f5988c, this.f5989d);
    }

    public final NodeCoordinator e() {
        if (this.f5990e) {
            SemanticsNode r11 = r();
            if (r11 != null) {
                return r11.e();
            }
            return null;
        }
        androidx.compose.ui.node.f g11 = l.g(this.f5988c);
        if (g11 == null) {
            g11 = this.f5986a;
        }
        return androidx.compose.ui.node.g.h(g11, s0.a(8));
    }

    public final y.i h() {
        androidx.compose.ui.layout.l X0;
        SemanticsNode r11 = r();
        if (r11 == null) {
            return y.i.f78598e.a();
        }
        NodeCoordinator e11 = e();
        if (e11 != null) {
            if (!e11.F()) {
                e11 = null;
            }
            if (e11 != null && (X0 = e11.X0()) != null) {
                return androidx.compose.ui.layout.k.a(androidx.compose.ui.node.g.h(r11.f5986a, s0.a(8)), X0, false, 2, null);
            }
        }
        return y.i.f78598e.a();
    }

    public final y.i i() {
        y.i b11;
        NodeCoordinator e11 = e();
        if (e11 != null) {
            if (!e11.F()) {
                e11 = null;
            }
            if (e11 != null && (b11 = androidx.compose.ui.layout.m.b(e11)) != null) {
                return b11;
            }
        }
        return y.i.f78598e.a();
    }

    public final y.i j() {
        y.i c11;
        NodeCoordinator e11 = e();
        if (e11 != null) {
            if (!e11.F()) {
                e11 = null;
            }
            if (e11 != null && (c11 = androidx.compose.ui.layout.m.c(e11)) != null) {
                return c11;
            }
        }
        return y.i.f78598e.a();
    }

    public final List k() {
        return m(this, false, false, false, 7, null);
    }

    public final List l(boolean z10, boolean z11, boolean z12) {
        return (z10 || !this.f5989d.n()) ? y() ? g(this, null, 1, null) : C(z11, z12) : CollectionsKt.l();
    }

    public final i n() {
        if (!y()) {
            return this.f5989d;
        }
        i h11 = this.f5989d.h();
        B(h11);
        return h11;
    }

    public final int o() {
        return this.f5992g;
    }

    public final androidx.compose.ui.layout.n p() {
        return this.f5988c;
    }

    public final LayoutNode q() {
        return this.f5988c;
    }

    public final SemanticsNode r() {
        SemanticsNode semanticsNode = this.f5991f;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode f11 = this.f5987b ? l.f(this.f5988c, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode layoutNode) {
                i F = layoutNode.F();
                boolean z10 = false;
                if (F != null && F.o()) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }) : null;
        if (f11 == null) {
            f11 = l.f(this.f5988c, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode layoutNode) {
                    return Boolean.valueOf(layoutNode.e0().q(s0.a(8)));
                }
            });
        }
        if (f11 == null) {
            return null;
        }
        return l.a(f11, this.f5987b);
    }

    public final long s() {
        NodeCoordinator e11 = e();
        if (e11 != null) {
            if (!e11.F()) {
                e11 = null;
            }
            if (e11 != null) {
                return androidx.compose.ui.layout.m.e(e11);
            }
        }
        return y.g.f78593b.c();
    }

    public final List t() {
        return m(this, false, true, false, 4, null);
    }

    public final long u() {
        NodeCoordinator e11 = e();
        return e11 != null ? e11.k() : t.f70747b.a();
    }

    public final y.i v() {
        androidx.compose.ui.node.f fVar;
        if (this.f5989d.o()) {
            fVar = l.g(this.f5988c);
            if (fVar == null) {
                fVar = this.f5986a;
            }
        } else {
            fVar = this.f5986a;
        }
        return j1.c(fVar.getNode(), j1.a(this.f5989d));
    }

    public final i w() {
        return this.f5989d;
    }

    public final boolean x() {
        return this.f5990e;
    }

    public final boolean z() {
        NodeCoordinator e11 = e();
        if (e11 != null) {
            return e11.l2();
        }
        return false;
    }
}
