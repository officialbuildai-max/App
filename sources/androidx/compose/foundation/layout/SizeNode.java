package androidx.compose.foundation.layout;

import androidx.compose.ui.f;
import androidx.compose.ui.layout.g0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import o0.i;

/* loaded from: classes.dex */
final class SizeNode extends f.c implements androidx.compose.ui.node.x {

    /* renamed from: n, reason: collision with root package name */
    private float f2862n;

    /* renamed from: o, reason: collision with root package name */
    private float f2863o;

    /* renamed from: p, reason: collision with root package name */
    private float f2864p;

    /* renamed from: q, reason: collision with root package name */
    private float f2865q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2866r;

    private SizeNode(float f11, float f12, float f13, float f14, boolean z10) {
        this.f2862n = f11;
        this.f2863o = f12;
        this.f2864p = f13;
        this.f2865q = f14;
        this.f2866r = z10;
    }

    public /* synthetic */ SizeNode(float f11, float f12, float f13, float f14, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, z10);
    }

    private final long D1(o0.e eVar) {
        int i11;
        int f11;
        float f12 = this.f2864p;
        i.a aVar = o0.i.f70726b;
        int i12 = 0;
        int f13 = !o0.i.i(f12, aVar.b()) ? RangesKt.f(eVar.c0(this.f2864p), 0) : Integer.MAX_VALUE;
        int f14 = !o0.i.i(this.f2865q, aVar.b()) ? RangesKt.f(eVar.c0(this.f2865q), 0) : Integer.MAX_VALUE;
        if (o0.i.i(this.f2862n, aVar.b()) || (i11 = RangesKt.f(RangesKt.i(eVar.c0(this.f2862n), f13), 0)) == Integer.MAX_VALUE) {
            i11 = 0;
        }
        if (!o0.i.i(this.f2863o, aVar.b()) && (f11 = RangesKt.f(RangesKt.i(eVar.c0(this.f2863o), f14), 0)) != Integer.MAX_VALUE) {
            i12 = f11;
        }
        return o0.c.a(i11, f13, i12, f14);
    }

    public final void E1(boolean z10) {
        this.f2866r = z10;
    }

    public final void F1(float f11) {
        this.f2865q = f11;
    }

    public final void G1(float f11) {
        this.f2864p = f11;
    }

    public final void H1(float f11) {
        this.f2863o = f11;
    }

    public final void I1(float f11) {
        this.f2862n = f11;
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.v z(androidx.compose.ui.layout.x xVar, androidx.compose.ui.layout.s sVar, long j11) {
        long a11;
        long D1 = D1(xVar);
        if (this.f2866r) {
            a11 = o0.c.g(j11, D1);
        } else {
            float f11 = this.f2862n;
            i.a aVar = o0.i.f70726b;
            a11 = o0.c.a(!o0.i.i(f11, aVar.b()) ? o0.b.n(D1) : RangesKt.i(o0.b.n(j11), o0.b.l(D1)), !o0.i.i(this.f2864p, aVar.b()) ? o0.b.l(D1) : RangesKt.f(o0.b.l(j11), o0.b.n(D1)), !o0.i.i(this.f2863o, aVar.b()) ? o0.b.m(D1) : RangesKt.i(o0.b.m(j11), o0.b.k(D1)), !o0.i.i(this.f2865q, aVar.b()) ? o0.b.k(D1) : RangesKt.f(o0.b.k(j11), o0.b.m(D1)));
        }
        final androidx.compose.ui.layout.g0 P = sVar.P(a11);
        return androidx.compose.ui.layout.w.b(xVar, P.u0(), P.l0(), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((g0.a) obj);
                return Unit.f67184a;
            }

            public final void invoke(g0.a aVar2) {
                g0.a.l(aVar2, androidx.compose.ui.layout.g0.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
