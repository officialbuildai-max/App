package androidx.compose.ui.graphics;

import androidx.compose.ui.f;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class BlockGraphicsLayerModifier extends f.c implements androidx.compose.ui.node.x {

    /* renamed from: n, reason: collision with root package name */
    private Function1 f4333n;

    public BlockGraphicsLayerModifier(Function1 function1) {
        this.f4333n = function1;
    }

    public final Function1 D1() {
        return this.f4333n;
    }

    public final void E1() {
        NodeCoordinator Z1 = androidx.compose.ui.node.g.h(this, androidx.compose.ui.node.s0.a(2)).Z1();
        if (Z1 != null) {
            Z1.L2(this.f4333n, true);
        }
    }

    public final void F1(Function1 function1) {
        this.f4333n = function1;
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return false;
    }

    public String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.f4333n + ')';
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.v z(androidx.compose.ui.layout.x xVar, androidx.compose.ui.layout.s sVar, long j11) {
        final androidx.compose.ui.layout.g0 P = sVar.P(j11);
        return androidx.compose.ui.layout.w.b(xVar, P.u0(), P.l0(), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.ui.graphics.BlockGraphicsLayerModifier$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((g0.a) obj);
                return Unit.f67184a;
            }

            public final void invoke(g0.a aVar) {
                g0.a.t(aVar, androidx.compose.ui.layout.g0.this, 0, 0, 0.0f, this.D1(), 4, null);
            }
        }, 4, null);
    }
}
