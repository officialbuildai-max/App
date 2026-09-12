package androidx.compose.foundation.layout;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.layout.g0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class InsetsPaddingModifier implements androidx.compose.ui.layout.o, androidx.compose.ui.modifier.d, androidx.compose.ui.modifier.j {

    /* renamed from: b, reason: collision with root package name */
    private final h0 f2829b;

    /* renamed from: c, reason: collision with root package name */
    private final i1 f2830c;

    /* renamed from: d, reason: collision with root package name */
    private final i1 f2831d;

    public InsetsPaddingModifier(h0 h0Var) {
        i1 c11;
        i1 c12;
        this.f2829b = h0Var;
        c11 = u2.c(h0Var, null, 2, null);
        this.f2830c = c11;
        c12 = u2.c(h0Var, null, 2, null);
        this.f2831d = c12;
    }

    private final h0 a() {
        return (h0) this.f2831d.getValue();
    }

    private final h0 i() {
        return (h0) this.f2830c.getValue();
    }

    private final void k(h0 h0Var) {
        this.f2831d.setValue(h0Var);
    }

    private final void l(h0 h0Var) {
        this.f2830c.setValue(h0Var);
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InsetsPaddingModifier) {
            return Intrinsics.c(((InsetsPaddingModifier) obj).f2829b, this.f2829b);
        }
        return false;
    }

    @Override // androidx.compose.ui.modifier.d
    public void f(androidx.compose.ui.modifier.k kVar) {
        h0 h0Var = (h0) kVar.P(WindowInsetsPaddingKt.a());
        l(i0.b(this.f2829b, h0Var));
        k(i0.c(h0Var, this.f2829b));
    }

    @Override // androidx.compose.ui.modifier.j
    public androidx.compose.ui.modifier.l getKey() {
        return WindowInsetsPaddingKt.a();
    }

    public int hashCode() {
        return this.f2829b.hashCode();
    }

    @Override // androidx.compose.ui.modifier.j
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public h0 getValue() {
        return a();
    }

    @Override // androidx.compose.ui.layout.o
    public androidx.compose.ui.layout.v z(androidx.compose.ui.layout.x xVar, androidx.compose.ui.layout.s sVar, long j11) {
        final int c11 = i().c(xVar, xVar.getLayoutDirection());
        final int a11 = i().a(xVar);
        int d11 = i().d(xVar, xVar.getLayoutDirection()) + c11;
        int b11 = i().b(xVar) + a11;
        final androidx.compose.ui.layout.g0 P = sVar.P(o0.c.n(j11, -d11, -b11));
        return androidx.compose.ui.layout.w.b(xVar, o0.c.i(j11, P.u0() + d11), o0.c.h(j11, P.l0() + b11), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.layout.InsetsPaddingModifier$measure$1
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
                g0.a.h(aVar, androidx.compose.ui.layout.g0.this, c11, a11, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
