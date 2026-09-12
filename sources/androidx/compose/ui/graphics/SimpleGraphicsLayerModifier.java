package androidx.compose.ui.graphics;

import androidx.compose.ui.f;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SimpleGraphicsLayerModifier extends f.c implements androidx.compose.ui.node.x {
    private long A;
    private long B;
    private int C;
    private Function1 D;

    /* renamed from: n, reason: collision with root package name */
    private float f4352n;

    /* renamed from: o, reason: collision with root package name */
    private float f4353o;

    /* renamed from: p, reason: collision with root package name */
    private float f4354p;

    /* renamed from: q, reason: collision with root package name */
    private float f4355q;

    /* renamed from: r, reason: collision with root package name */
    private float f4356r;

    /* renamed from: s, reason: collision with root package name */
    private float f4357s;

    /* renamed from: t, reason: collision with root package name */
    private float f4358t;

    /* renamed from: u, reason: collision with root package name */
    private float f4359u;

    /* renamed from: v, reason: collision with root package name */
    private float f4360v;

    /* renamed from: w, reason: collision with root package name */
    private float f4361w;

    /* renamed from: x, reason: collision with root package name */
    private long f4362x;

    /* renamed from: y, reason: collision with root package name */
    private a5 f4363y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f4364z;

    private SimpleGraphicsLayerModifier(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, long j11, a5 a5Var, boolean z10, w4 w4Var, long j12, long j13, int i11) {
        this.f4352n = f11;
        this.f4353o = f12;
        this.f4354p = f13;
        this.f4355q = f14;
        this.f4356r = f15;
        this.f4357s = f16;
        this.f4358t = f17;
        this.f4359u = f18;
        this.f4360v = f19;
        this.f4361w = f20;
        this.f4362x = j11;
        this.f4363y = a5Var;
        this.f4364z = z10;
        this.A = j12;
        this.B = j13;
        this.C = i11;
        this.D = new Function1<c4, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$layerBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((c4) obj);
                return Unit.f67184a;
            }

            public final void invoke(c4 c4Var) {
                c4Var.b(SimpleGraphicsLayerModifier.this.t());
                c4Var.h(SimpleGraphicsLayerModifier.this.A());
                c4Var.setAlpha(SimpleGraphicsLayerModifier.this.E1());
                c4Var.j(SimpleGraphicsLayerModifier.this.x());
                c4Var.a(SimpleGraphicsLayerModifier.this.w());
                c4Var.u(SimpleGraphicsLayerModifier.this.J1());
                c4Var.e(SimpleGraphicsLayerModifier.this.y());
                c4Var.f(SimpleGraphicsLayerModifier.this.m());
                c4Var.g(SimpleGraphicsLayerModifier.this.o());
                c4Var.d(SimpleGraphicsLayerModifier.this.q());
                c4Var.d0(SimpleGraphicsLayerModifier.this.b0());
                c4Var.A0(SimpleGraphicsLayerModifier.this.K1());
                c4Var.r(SimpleGraphicsLayerModifier.this.G1());
                SimpleGraphicsLayerModifier.this.I1();
                c4Var.c(null);
                c4Var.p(SimpleGraphicsLayerModifier.this.F1());
                c4Var.s(SimpleGraphicsLayerModifier.this.L1());
                c4Var.l(SimpleGraphicsLayerModifier.this.H1());
            }
        };
    }

    public /* synthetic */ SimpleGraphicsLayerModifier(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, long j11, a5 a5Var, boolean z10, w4 w4Var, long j12, long j13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, j11, a5Var, z10, w4Var, j12, j13, i11);
    }

    public final float A() {
        return this.f4353o;
    }

    public final void A0(a5 a5Var) {
        this.f4363y = a5Var;
    }

    public final float E1() {
        return this.f4354p;
    }

    public final long F1() {
        return this.A;
    }

    public final boolean G1() {
        return this.f4364z;
    }

    public final int H1() {
        return this.C;
    }

    public final w4 I1() {
        return null;
    }

    public final float J1() {
        return this.f4357s;
    }

    public final a5 K1() {
        return this.f4363y;
    }

    public final long L1() {
        return this.B;
    }

    public final void M1() {
        NodeCoordinator Z1 = androidx.compose.ui.node.g.h(this, androidx.compose.ui.node.s0.a(2)).Z1();
        if (Z1 != null) {
            Z1.L2(this.D, true);
        }
    }

    public final void a(float f11) {
        this.f4356r = f11;
    }

    public final void b(float f11) {
        this.f4352n = f11;
    }

    public final long b0() {
        return this.f4362x;
    }

    public final void c(w4 w4Var) {
    }

    public final void d(float f11) {
        this.f4361w = f11;
    }

    public final void d0(long j11) {
        this.f4362x = j11;
    }

    public final void e(float f11) {
        this.f4358t = f11;
    }

    public final void f(float f11) {
        this.f4359u = f11;
    }

    public final void g(float f11) {
        this.f4360v = f11;
    }

    public final void h(float f11) {
        this.f4353o = f11;
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return false;
    }

    public final void j(float f11) {
        this.f4355q = f11;
    }

    public final void l(int i11) {
        this.C = i11;
    }

    public final float m() {
        return this.f4359u;
    }

    public final float o() {
        return this.f4360v;
    }

    public final void p(long j11) {
        this.A = j11;
    }

    public final float q() {
        return this.f4361w;
    }

    public final void r(boolean z10) {
        this.f4364z = z10;
    }

    public final void s(long j11) {
        this.B = j11;
    }

    public final void setAlpha(float f11) {
        this.f4354p = f11;
    }

    public final float t() {
        return this.f4352n;
    }

    public String toString() {
        return "SimpleGraphicsLayerModifier(scaleX=" + this.f4352n + ", scaleY=" + this.f4353o + ", alpha = " + this.f4354p + ", translationX=" + this.f4355q + ", translationY=" + this.f4356r + ", shadowElevation=" + this.f4357s + ", rotationX=" + this.f4358t + ", rotationY=" + this.f4359u + ", rotationZ=" + this.f4360v + ", cameraDistance=" + this.f4361w + ", transformOrigin=" + ((Object) e5.g(this.f4362x)) + ", shape=" + this.f4363y + ", clip=" + this.f4364z + ", renderEffect=" + ((Object) null) + ", ambientShadowColor=" + ((Object) u1.t(this.A)) + ", spotShadowColor=" + ((Object) u1.t(this.B)) + ", compositingStrategy=" + ((Object) w3.g(this.C)) + ')';
    }

    public final void u(float f11) {
        this.f4357s = f11;
    }

    public final float w() {
        return this.f4356r;
    }

    public final float x() {
        return this.f4355q;
    }

    public final float y() {
        return this.f4358t;
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.v z(androidx.compose.ui.layout.x xVar, androidx.compose.ui.layout.s sVar, long j11) {
        final androidx.compose.ui.layout.g0 P = sVar.P(j11);
        return androidx.compose.ui.layout.w.b(xVar, P.u0(), P.l0(), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$measure$1
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
                Function1 function1;
                androidx.compose.ui.layout.g0 g0Var = androidx.compose.ui.layout.g0.this;
                function1 = this.D;
                g0.a.t(aVar, g0Var, 0, 0, 0.0f, function1, 4, null);
            }
        }, 4, null);
    }
}
