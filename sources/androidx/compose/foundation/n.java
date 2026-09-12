package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.platform.a1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
final class n extends a1 implements androidx.compose.ui.draw.f {

    /* renamed from: c, reason: collision with root package name */
    private final AndroidEdgeEffectOverscrollEffect f3218c;

    /* renamed from: d, reason: collision with root package name */
    private final p f3219d;

    /* renamed from: e, reason: collision with root package name */
    private RenderNode f3220e;

    public n(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, p pVar, Function1 function1) {
        super(function1);
        this.f3218c = androidEdgeEffectOverscrollEffect;
        this.f3219d = pVar;
    }

    private final boolean a(EdgeEffect edgeEffect, Canvas canvas) {
        return l(180.0f, edgeEffect, canvas);
    }

    private final boolean i(EdgeEffect edgeEffect, Canvas canvas) {
        return l(270.0f, edgeEffect, canvas);
    }

    private final boolean j(EdgeEffect edgeEffect, Canvas canvas) {
        return l(90.0f, edgeEffect, canvas);
    }

    private final boolean k(EdgeEffect edgeEffect, Canvas canvas) {
        return l(0.0f, edgeEffect, canvas);
    }

    private final boolean l(float f11, EdgeEffect edgeEffect, Canvas canvas) {
        if (f11 == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int save = canvas.save();
        canvas.rotate(f11);
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final RenderNode m() {
        RenderNode renderNode = this.f3220e;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode a11 = i.a("AndroidEdgeEffectOverscrollEffect");
        this.f3220e = a11;
        return a11;
    }

    private final boolean o() {
        p pVar = this.f3219d;
        return pVar.r() || pVar.s() || pVar.u() || pVar.v();
    }

    private final boolean p() {
        p pVar = this.f3219d;
        return pVar.y() || pVar.z() || pVar.o() || pVar.p();
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ Object b(Object obj, Function2 function2) {
        return androidx.compose.ui.g.b(this, obj, function2);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ boolean c(Function1 function1) {
        return androidx.compose.ui.g.a(this, function1);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ androidx.compose.ui.f e(androidx.compose.ui.f fVar) {
        return androidx.compose.ui.e.a(this, fVar);
    }

    @Override // androidx.compose.ui.draw.f
    public void n(z.c cVar) {
        RecordingCanvas beginRecording;
        boolean z10;
        float f11;
        float f12;
        this.f3218c.r(cVar.i());
        if (y.m.k(cVar.i())) {
            cVar.Y0();
            return;
        }
        this.f3218c.j().getValue();
        float E0 = cVar.E0(g.b());
        Canvas d11 = androidx.compose.ui.graphics.h0.d(cVar.H0().e());
        p pVar = this.f3219d;
        boolean p11 = p();
        boolean o11 = o();
        if (p11 && o11) {
            m().setPosition(0, 0, d11.getWidth(), d11.getHeight());
        } else if (p11) {
            m().setPosition(0, 0, d11.getWidth() + (MathKt.d(E0) * 2), d11.getHeight());
        } else {
            if (!o11) {
                cVar.Y0();
                return;
            }
            m().setPosition(0, 0, d11.getWidth(), d11.getHeight() + (MathKt.d(E0) * 2));
        }
        beginRecording = m().beginRecording();
        if (pVar.s()) {
            EdgeEffect i11 = pVar.i();
            j(i11, beginRecording);
            i11.finish();
        }
        if (pVar.r()) {
            EdgeEffect h11 = pVar.h();
            z10 = i(h11, beginRecording);
            if (pVar.t()) {
                float n11 = y.g.n(this.f3218c.i());
                o oVar = o.f3221a;
                oVar.d(pVar.i(), oVar.b(h11), 1 - n11);
            }
        } else {
            z10 = false;
        }
        if (pVar.z()) {
            EdgeEffect m11 = pVar.m();
            a(m11, beginRecording);
            m11.finish();
        }
        if (pVar.y()) {
            EdgeEffect l11 = pVar.l();
            z10 = k(l11, beginRecording) || z10;
            if (pVar.A()) {
                float m12 = y.g.m(this.f3218c.i());
                o oVar2 = o.f3221a;
                oVar2.d(pVar.m(), oVar2.b(l11), m12);
            }
        }
        if (pVar.v()) {
            EdgeEffect k11 = pVar.k();
            i(k11, beginRecording);
            k11.finish();
        }
        if (pVar.u()) {
            EdgeEffect j11 = pVar.j();
            z10 = j(j11, beginRecording) || z10;
            if (pVar.w()) {
                float n12 = y.g.n(this.f3218c.i());
                o oVar3 = o.f3221a;
                oVar3.d(pVar.k(), oVar3.b(j11), n12);
            }
        }
        if (pVar.p()) {
            EdgeEffect g11 = pVar.g();
            k(g11, beginRecording);
            g11.finish();
        }
        if (pVar.o()) {
            EdgeEffect f13 = pVar.f();
            boolean z11 = a(f13, beginRecording) || z10;
            if (pVar.q()) {
                float m13 = y.g.m(this.f3218c.i());
                o oVar4 = o.f3221a;
                oVar4.d(pVar.g(), oVar4.b(f13), 1 - m13);
            }
            z10 = z11;
        }
        if (z10) {
            this.f3218c.k();
        }
        float f14 = o11 ? 0.0f : E0;
        if (p11) {
            E0 = 0.0f;
        }
        LayoutDirection layoutDirection = cVar.getLayoutDirection();
        m1 b11 = androidx.compose.ui.graphics.h0.b(beginRecording);
        long i12 = cVar.i();
        o0.e density = cVar.H0().getDensity();
        LayoutDirection layoutDirection2 = cVar.H0().getLayoutDirection();
        m1 e11 = cVar.H0().e();
        long i13 = cVar.H0().i();
        GraphicsLayer g12 = cVar.H0().g();
        z.d H0 = cVar.H0();
        H0.b(cVar);
        H0.a(layoutDirection);
        H0.h(b11);
        H0.f(i12);
        H0.d(null);
        b11.n();
        try {
            cVar.H0().c().c(f14, E0);
            try {
                cVar.Y0();
                b11.j();
                z.d H02 = cVar.H0();
                H02.b(density);
                H02.a(layoutDirection2);
                H02.h(e11);
                H02.f(i13);
                H02.d(g12);
                m().endRecording();
                int save = d11.save();
                d11.translate(f11, f12);
                d11.drawRenderNode(m());
                d11.restoreToCount(save);
            } finally {
                cVar.H0().c().c(-f14, -E0);
            }
        } catch (Throwable th2) {
            b11.j();
            z.d H03 = cVar.H0();
            H03.b(density);
            H03.a(layoutDirection2);
            H03.h(e11);
            H03.f(i13);
            H03.d(g12);
            throw th2;
        }
    }
}
