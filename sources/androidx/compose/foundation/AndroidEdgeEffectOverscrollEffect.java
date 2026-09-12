package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.input.pointer.l0;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.z0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements f0 {

    /* renamed from: a, reason: collision with root package name */
    private y.g f2610a;

    /* renamed from: b, reason: collision with root package name */
    private final p f2611b;

    /* renamed from: c, reason: collision with root package name */
    private final i1 f2612c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2613d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2614e;

    /* renamed from: f, reason: collision with root package name */
    private long f2615f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.compose.ui.input.pointer.v f2616g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.compose.ui.f f2617h;

    public AndroidEdgeEffectOverscrollEffect(Context context, e0 e0Var) {
        androidx.compose.ui.f hVar;
        p pVar = new p(context, w1.j(e0Var.b()));
        this.f2611b = pVar;
        Unit unit = Unit.f67184a;
        this.f2612c = r2.e(unit, r2.g());
        this.f2613d = true;
        this.f2615f = y.m.f78614b.b();
        androidx.compose.ui.f c11 = l0.c(androidx.compose.ui.f.f4253a, unit, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null));
        if (Build.VERSION.SDK_INT >= 31) {
            hVar = new n(this, pVar, InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((z0) obj);
                    return Unit.f67184a;
                }

                public final void invoke(z0 z0Var) {
                    z0Var.b("overscroll");
                    z0Var.c(AndroidEdgeEffectOverscrollEffect.this);
                }
            } : InspectableValueKt.a());
        } else {
            hVar = new h(this, pVar, e0Var, InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((z0) obj);
                    return Unit.f67184a;
                }

                public final void invoke(z0 z0Var) {
                    z0Var.b("overscroll");
                    z0Var.c(AndroidEdgeEffectOverscrollEffect.this);
                }
            } : InspectableValueKt.a());
        }
        this.f2617h = c11.e(hVar);
    }

    private final void h() {
        EdgeEffect edgeEffect;
        boolean z10;
        EdgeEffect edgeEffect2;
        EdgeEffect edgeEffect3;
        EdgeEffect edgeEffect4;
        p pVar = this.f2611b;
        edgeEffect = pVar.f3225d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z10 = edgeEffect.isFinished();
        } else {
            z10 = false;
        }
        edgeEffect2 = pVar.f3226e;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z10 = edgeEffect2.isFinished() || z10;
        }
        edgeEffect3 = pVar.f3227f;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z10 = edgeEffect3.isFinished() || z10;
        }
        edgeEffect4 = pVar.f3228g;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z10 = edgeEffect4.isFinished() || z10;
        }
        if (z10) {
            k();
        }
    }

    private final float l(long j11) {
        float m11 = y.g.m(i());
        float n11 = y.g.n(j11) / y.m.g(this.f2615f);
        EdgeEffect f11 = this.f2611b.f();
        o oVar = o.f3221a;
        return oVar.b(f11) == 0.0f ? (-oVar.d(f11, -n11, 1 - m11)) * y.m.g(this.f2615f) : y.g.n(j11);
    }

    private final float m(long j11) {
        float n11 = y.g.n(i());
        float m11 = y.g.m(j11) / y.m.i(this.f2615f);
        EdgeEffect h11 = this.f2611b.h();
        o oVar = o.f3221a;
        return oVar.b(h11) == 0.0f ? oVar.d(h11, m11, 1 - n11) * y.m.i(this.f2615f) : y.g.m(j11);
    }

    private final float n(long j11) {
        float n11 = y.g.n(i());
        float m11 = y.g.m(j11) / y.m.i(this.f2615f);
        EdgeEffect j12 = this.f2611b.j();
        o oVar = o.f3221a;
        return oVar.b(j12) == 0.0f ? (-oVar.d(j12, -m11, n11)) * y.m.i(this.f2615f) : y.g.m(j11);
    }

    private final float o(long j11) {
        float m11 = y.g.m(i());
        float n11 = y.g.n(j11) / y.m.g(this.f2615f);
        EdgeEffect l11 = this.f2611b.l();
        o oVar = o.f3221a;
        return oVar.b(l11) == 0.0f ? oVar.d(l11, n11, m11) * y.m.g(this.f2615f) : y.g.n(j11);
    }

    private final boolean p(long j11) {
        boolean z10;
        boolean z11 = true;
        if (!this.f2611b.r() || y.g.m(j11) >= 0.0f) {
            z10 = false;
        } else {
            o.f3221a.e(this.f2611b.h(), y.g.m(j11));
            z10 = !this.f2611b.r();
        }
        if (this.f2611b.u() && y.g.m(j11) > 0.0f) {
            o.f3221a.e(this.f2611b.j(), y.g.m(j11));
            z10 = z10 || !this.f2611b.u();
        }
        if (this.f2611b.y() && y.g.n(j11) < 0.0f) {
            o.f3221a.e(this.f2611b.l(), y.g.n(j11));
            z10 = z10 || !this.f2611b.y();
        }
        if (!this.f2611b.o() || y.g.n(j11) <= 0.0f) {
            return z10;
        }
        o.f3221a.e(this.f2611b.f(), y.g.n(j11));
        if (!z10 && this.f2611b.o()) {
            z11 = false;
        }
        return z11;
    }

    private final boolean q() {
        boolean z10;
        if (this.f2611b.t()) {
            m(y.g.f78593b.c());
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f2611b.w()) {
            n(y.g.f78593b.c());
            z10 = true;
        }
        if (this.f2611b.A()) {
            o(y.g.f78593b.c());
            z10 = true;
        }
        if (!this.f2611b.q()) {
            return z10;
        }
        l(y.g.f78593b.c());
        return true;
    }

    @Override // androidx.compose.foundation.f0
    public boolean a() {
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        EdgeEffect edgeEffect3;
        EdgeEffect edgeEffect4;
        p pVar = this.f2611b;
        edgeEffect = pVar.f3225d;
        if (edgeEffect != null && o.f3221a.b(edgeEffect) != 0.0f) {
            return true;
        }
        edgeEffect2 = pVar.f3226e;
        if (edgeEffect2 != null && o.f3221a.b(edgeEffect2) != 0.0f) {
            return true;
        }
        edgeEffect3 = pVar.f3227f;
        if (edgeEffect3 != null && o.f3221a.b(edgeEffect3) != 0.0f) {
            return true;
        }
        edgeEffect4 = pVar.f3228g;
        return (edgeEffect4 == null || o.f3221a.b(edgeEffect4) == 0.0f) ? false : true;
    }

    @Override // androidx.compose.foundation.f0
    public androidx.compose.ui.f b() {
        return this.f2617h;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010c  */
    @Override // androidx.compose.foundation.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long c(long r11, int r13, kotlin.jvm.functions.Function1 r14) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.c(long, int, kotlin.jvm.functions.Function1):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.foundation.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(long r11, kotlin.jvm.functions.Function2 r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.d(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long i() {
        y.g gVar = this.f2610a;
        long v11 = gVar != null ? gVar.v() : y.n.b(this.f2615f);
        return y.h.a(y.g.m(v11) / y.m.i(this.f2615f), y.g.n(v11) / y.m.g(this.f2615f));
    }

    public final i1 j() {
        return this.f2612c;
    }

    public final void k() {
        if (this.f2613d) {
            this.f2612c.setValue(Unit.f67184a);
        }
    }

    public final void r(long j11) {
        boolean f11 = y.m.f(this.f2615f, y.m.f78614b.b());
        boolean f12 = y.m.f(j11, this.f2615f);
        this.f2615f = j11;
        if (!f12) {
            this.f2611b.B(o0.u.a(MathKt.d(y.m.i(j11)), MathKt.d(y.m.g(j11))));
        }
        if (f11 || f12) {
            return;
        }
        k();
        h();
    }
}
