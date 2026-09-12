package androidx.compose.ui.draw;

import androidx.compose.ui.f;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.layout.m0;
import androidx.compose.ui.layout.s;
import androidx.compose.ui.layout.v;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.node.n;
import androidx.compose.ui.node.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import o0.p;
import o0.u;
import y.m;

/* loaded from: classes.dex */
final class PainterNode extends f.c implements x, n {

    /* renamed from: n, reason: collision with root package name */
    private Painter f4230n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4231o;

    /* renamed from: p, reason: collision with root package name */
    private androidx.compose.ui.b f4232p;

    /* renamed from: q, reason: collision with root package name */
    private androidx.compose.ui.layout.e f4233q;

    /* renamed from: r, reason: collision with root package name */
    private float f4234r;

    /* renamed from: s, reason: collision with root package name */
    private v1 f4235s;

    public PainterNode(Painter painter, boolean z10, androidx.compose.ui.b bVar, androidx.compose.ui.layout.e eVar, float f11, v1 v1Var) {
        this.f4230n = painter;
        this.f4231o = z10;
        this.f4232p = bVar;
        this.f4233q = eVar;
        this.f4234r = f11;
        this.f4235s = v1Var;
    }

    private final long D1(long j11) {
        if (!G1()) {
            return j11;
        }
        long a11 = y.n.a(!I1(this.f4230n.h()) ? m.i(j11) : m.i(this.f4230n.h()), !H1(this.f4230n.h()) ? m.g(j11) : m.g(this.f4230n.h()));
        return (m.i(j11) == 0.0f || m.g(j11) == 0.0f) ? m.f78614b.b() : m0.b(a11, this.f4233q.a(a11, j11));
    }

    private final boolean G1() {
        return this.f4231o && this.f4230n.h() != 9205357640488583168L;
    }

    private final boolean H1(long j11) {
        if (!m.f(j11, m.f78614b.a())) {
            float g11 = m.g(j11);
            if (!Float.isInfinite(g11) && !Float.isNaN(g11)) {
                return true;
            }
        }
        return false;
    }

    private final boolean I1(long j11) {
        if (!m.f(j11, m.f78614b.a())) {
            float i11 = m.i(j11);
            if (!Float.isInfinite(i11) && !Float.isNaN(i11)) {
                return true;
            }
        }
        return false;
    }

    private final long J1(long j11) {
        boolean z10 = false;
        boolean z11 = o0.b.h(j11) && o0.b.g(j11);
        if (o0.b.j(j11) && o0.b.i(j11)) {
            z10 = true;
        }
        if ((!G1() && z11) || z10) {
            return o0.b.d(j11, o0.b.l(j11), 0, o0.b.k(j11), 0, 10, null);
        }
        long h11 = this.f4230n.h();
        long D1 = D1(y.n.a(o0.c.i(j11, I1(h11) ? Math.round(m.i(h11)) : o0.b.n(j11)), o0.c.h(j11, H1(h11) ? Math.round(m.g(h11)) : o0.b.m(j11))));
        return o0.b.d(j11, o0.c.i(j11, Math.round(m.i(D1))), 0, o0.c.h(j11, Math.round(m.g(D1))), 0, 10, null);
    }

    public final Painter E1() {
        return this.f4230n;
    }

    public final boolean F1() {
        return this.f4231o;
    }

    public final void K1(androidx.compose.ui.b bVar) {
        this.f4232p = bVar;
    }

    public final void L1(v1 v1Var) {
        this.f4235s = v1Var;
    }

    public final void M1(androidx.compose.ui.layout.e eVar) {
        this.f4233q = eVar;
    }

    public final void N1(Painter painter) {
        this.f4230n = painter;
    }

    public final void O1(boolean z10) {
        this.f4231o = z10;
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return false;
    }

    @Override // androidx.compose.ui.node.n
    public void n(z.c cVar) {
        long h11 = this.f4230n.h();
        long a11 = y.n.a(I1(h11) ? m.i(h11) : m.i(cVar.i()), H1(h11) ? m.g(h11) : m.g(cVar.i()));
        long b11 = (m.i(cVar.i()) == 0.0f || m.g(cVar.i()) == 0.0f) ? m.f78614b.b() : m0.b(a11, this.f4233q.a(a11, cVar.i()));
        long a12 = this.f4232p.a(u.a(Math.round(m.i(b11)), Math.round(m.g(b11))), u.a(Math.round(m.i(cVar.i())), Math.round(m.g(cVar.i()))), cVar.getLayoutDirection());
        float h12 = p.h(a12);
        float i11 = p.i(a12);
        cVar.H0().c().c(h12, i11);
        try {
            this.f4230n.g(cVar, b11, this.f4234r, this.f4235s);
            cVar.H0().c().c(-h12, -i11);
            cVar.Y0();
        } catch (Throwable th2) {
            cVar.H0().c().c(-h12, -i11);
            throw th2;
        }
    }

    public final void setAlpha(float f11) {
        this.f4234r = f11;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.f4230n + ", sizeToIntrinsics=" + this.f4231o + ", alignment=" + this.f4232p + ", alpha=" + this.f4234r + ", colorFilter=" + this.f4235s + ')';
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void w0() {
        androidx.compose.ui.node.m.a(this);
    }

    @Override // androidx.compose.ui.node.x
    public v z(androidx.compose.ui.layout.x xVar, s sVar, long j11) {
        final g0 P = sVar.P(J1(j11));
        return w.b(xVar, P.u0(), P.l0(), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
                g0.a.l(aVar, g0.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
