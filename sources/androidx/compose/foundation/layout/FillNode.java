package androidx.compose.foundation.layout;

import androidx.compose.ui.f;
import androidx.compose.ui.layout.g0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
final class FillNode extends f.c implements androidx.compose.ui.node.x {

    /* renamed from: n, reason: collision with root package name */
    private Direction f2826n;

    /* renamed from: o, reason: collision with root package name */
    private float f2827o;

    public FillNode(Direction direction, float f11) {
        this.f2826n = direction;
        this.f2827o = f11;
    }

    public final void D1(Direction direction) {
        this.f2826n = direction;
    }

    public final void E1(float f11) {
        this.f2827o = f11;
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.v z(androidx.compose.ui.layout.x xVar, androidx.compose.ui.layout.s sVar, long j11) {
        int n11;
        int l11;
        int k11;
        int i11;
        if (!o0.b.h(j11) || this.f2826n == Direction.Vertical) {
            n11 = o0.b.n(j11);
            l11 = o0.b.l(j11);
        } else {
            n11 = RangesKt.m(Math.round(o0.b.l(j11) * this.f2827o), o0.b.n(j11), o0.b.l(j11));
            l11 = n11;
        }
        if (!o0.b.g(j11) || this.f2826n == Direction.Horizontal) {
            int m11 = o0.b.m(j11);
            k11 = o0.b.k(j11);
            i11 = m11;
        } else {
            i11 = RangesKt.m(Math.round(o0.b.k(j11) * this.f2827o), o0.b.m(j11), o0.b.k(j11));
            k11 = i11;
        }
        final androidx.compose.ui.layout.g0 P = sVar.P(o0.c.a(n11, l11, i11, k11));
        return androidx.compose.ui.layout.w.b(xVar, P.u0(), P.l0(), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((g0.a) obj);
                return Unit.f67184a;
            }

            public final void invoke(g0.a aVar) {
                g0.a.l(aVar, androidx.compose.ui.layout.g0.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
