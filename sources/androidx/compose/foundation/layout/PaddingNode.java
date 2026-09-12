package androidx.compose.foundation.layout;

import androidx.compose.ui.f;
import androidx.compose.ui.layout.g0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
final class PaddingNode extends f.c implements androidx.compose.ui.node.x {

    /* renamed from: n, reason: collision with root package name */
    private float f2840n;

    /* renamed from: o, reason: collision with root package name */
    private float f2841o;

    /* renamed from: p, reason: collision with root package name */
    private float f2842p;

    /* renamed from: q, reason: collision with root package name */
    private float f2843q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2844r;

    private PaddingNode(float f11, float f12, float f13, float f14, boolean z10) {
        this.f2840n = f11;
        this.f2841o = f12;
        this.f2842p = f13;
        this.f2843q = f14;
        this.f2844r = z10;
    }

    public /* synthetic */ PaddingNode(float f11, float f12, float f13, float f14, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, z10);
    }

    public final boolean D1() {
        return this.f2844r;
    }

    public final float E1() {
        return this.f2840n;
    }

    public final float F1() {
        return this.f2841o;
    }

    public final void G1(float f11) {
        this.f2843q = f11;
    }

    public final void H1(float f11) {
        this.f2842p = f11;
    }

    public final void I1(boolean z10) {
        this.f2844r = z10;
    }

    public final void J1(float f11) {
        this.f2840n = f11;
    }

    public final void K1(float f11) {
        this.f2841o = f11;
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.v z(final androidx.compose.ui.layout.x xVar, androidx.compose.ui.layout.s sVar, long j11) {
        int c02 = xVar.c0(this.f2840n) + xVar.c0(this.f2842p);
        int c03 = xVar.c0(this.f2841o) + xVar.c0(this.f2843q);
        final androidx.compose.ui.layout.g0 P = sVar.P(o0.c.n(j11, -c02, -c03));
        return androidx.compose.ui.layout.w.b(xVar, o0.c.i(j11, P.u0() + c02), o0.c.h(j11, P.l0() + c03), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.layout.PaddingNode$measure$1
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
                if (PaddingNode.this.D1()) {
                    g0.a.l(aVar, P, xVar.c0(PaddingNode.this.E1()), xVar.c0(PaddingNode.this.F1()), 0.0f, 4, null);
                } else {
                    g0.a.h(aVar, P, xVar.c0(PaddingNode.this.E1()), xVar.c0(PaddingNode.this.F1()), 0.0f, 4, null);
                }
            }
        }, 4, null);
    }
}
