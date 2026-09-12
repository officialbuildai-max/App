package androidx.compose.foundation.layout;

import androidx.compose.ui.f;
import androidx.compose.ui.layout.g0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
final class WrapContentNode extends f.c implements androidx.compose.ui.node.x {

    /* renamed from: n, reason: collision with root package name */
    private Direction f2903n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2904o;

    /* renamed from: p, reason: collision with root package name */
    private Function2 f2905p;

    public WrapContentNode(Direction direction, boolean z10, Function2 function2) {
        this.f2903n = direction;
        this.f2904o = z10;
        this.f2905p = function2;
    }

    public final Function2 D1() {
        return this.f2905p;
    }

    public final void E1(Function2 function2) {
        this.f2905p = function2;
    }

    public final void F1(Direction direction) {
        this.f2903n = direction;
    }

    public final void G1(boolean z10) {
        this.f2904o = z10;
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.v z(final androidx.compose.ui.layout.x xVar, androidx.compose.ui.layout.s sVar, long j11) {
        Direction direction = this.f2903n;
        Direction direction2 = Direction.Vertical;
        int n11 = direction != direction2 ? 0 : o0.b.n(j11);
        Direction direction3 = this.f2903n;
        Direction direction4 = Direction.Horizontal;
        final androidx.compose.ui.layout.g0 P = sVar.P(o0.c.a(n11, (this.f2903n == direction2 || !this.f2904o) ? o0.b.l(j11) : Integer.MAX_VALUE, direction3 == direction4 ? o0.b.m(j11) : 0, (this.f2903n == direction4 || !this.f2904o) ? o0.b.k(j11) : Integer.MAX_VALUE));
        final int m11 = RangesKt.m(P.u0(), o0.b.n(j11), o0.b.l(j11));
        final int m12 = RangesKt.m(P.l0(), o0.b.m(j11), o0.b.k(j11));
        return androidx.compose.ui.layout.w.b(xVar, m11, m12, null, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.layout.WrapContentNode$measure$1
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
                g0.a.j(aVar, P, ((o0.p) WrapContentNode.this.D1().invoke(o0.t.b(o0.u.a(m11 - P.u0(), m12 - P.l0())), xVar.getLayoutDirection())).n(), 0.0f, 2, null);
            }
        }, 4, null);
    }
}
