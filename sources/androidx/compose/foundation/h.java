package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.ui.platform.a1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
final class h extends a1 implements androidx.compose.ui.draw.f {

    /* renamed from: c, reason: collision with root package name */
    private final AndroidEdgeEffectOverscrollEffect f2806c;

    /* renamed from: d, reason: collision with root package name */
    private final p f2807d;

    /* renamed from: e, reason: collision with root package name */
    private final e0 f2808e;

    public h(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, p pVar, e0 e0Var, Function1 function1) {
        super(function1);
        this.f2806c = androidEdgeEffectOverscrollEffect;
        this.f2807d = pVar;
        this.f2808e = e0Var;
    }

    private final boolean a(z.g gVar, EdgeEffect edgeEffect, Canvas canvas) {
        return l(180.0f, y.h.a(-y.m.i(gVar.i()), (-y.m.g(gVar.i())) + gVar.E0(this.f2808e.a().a())), edgeEffect, canvas);
    }

    private final boolean i(z.g gVar, EdgeEffect edgeEffect, Canvas canvas) {
        return l(270.0f, y.h.a(-y.m.g(gVar.i()), gVar.E0(this.f2808e.a().b(gVar.getLayoutDirection()))), edgeEffect, canvas);
    }

    private final boolean j(z.g gVar, EdgeEffect edgeEffect, Canvas canvas) {
        return l(90.0f, y.h.a(0.0f, (-MathKt.d(y.m.i(gVar.i()))) + gVar.E0(this.f2808e.a().c(gVar.getLayoutDirection()))), edgeEffect, canvas);
    }

    private final boolean k(z.g gVar, EdgeEffect edgeEffect, Canvas canvas) {
        return l(0.0f, y.h.a(0.0f, gVar.E0(this.f2808e.a().d())), edgeEffect, canvas);
    }

    private final boolean l(float f11, long j11, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(f11);
        canvas.translate(y.g.m(j11), y.g.n(j11));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
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
        this.f2806c.r(cVar.i());
        if (y.m.k(cVar.i())) {
            cVar.Y0();
            return;
        }
        cVar.Y0();
        this.f2806c.j().getValue();
        Canvas d11 = androidx.compose.ui.graphics.h0.d(cVar.H0().e());
        p pVar = this.f2807d;
        boolean i11 = pVar.r() ? i(cVar, pVar.h(), d11) : false;
        if (pVar.y()) {
            i11 = k(cVar, pVar.l(), d11) || i11;
        }
        if (pVar.u()) {
            i11 = j(cVar, pVar.j(), d11) || i11;
        }
        if (pVar.o()) {
            i11 = a(cVar, pVar.f(), d11) || i11;
        }
        if (i11) {
            this.f2806c.k();
        }
    }
}
