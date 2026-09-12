package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.e1;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.n2;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class VectorPainter extends Painter {

    /* renamed from: g, reason: collision with root package name */
    private final i1 f4805g;

    /* renamed from: h, reason: collision with root package name */
    private final i1 f4806h;

    /* renamed from: i, reason: collision with root package name */
    private final VectorComponent f4807i;

    /* renamed from: j, reason: collision with root package name */
    private final e1 f4808j;

    /* renamed from: k, reason: collision with root package name */
    private float f4809k;

    /* renamed from: l, reason: collision with root package name */
    private v1 f4810l;

    /* renamed from: m, reason: collision with root package name */
    private int f4811m;

    /* JADX WARN: Multi-variable type inference failed */
    public VectorPainter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public VectorPainter(GroupComponent groupComponent) {
        i1 c11;
        i1 c12;
        c11 = u2.c(y.m.c(y.m.f78614b.b()), null, 2, null);
        this.f4805g = c11;
        c12 = u2.c(Boolean.FALSE, null, 2, null);
        this.f4806h = c12;
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.o(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$vector$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m114invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m114invoke() {
                int i11;
                int o11;
                int o12;
                i11 = VectorPainter.this.f4811m;
                o11 = VectorPainter.this.o();
                if (i11 == o11) {
                    VectorPainter vectorPainter = VectorPainter.this;
                    o12 = vectorPainter.o();
                    vectorPainter.s(o12 + 1);
                }
            }
        });
        this.f4807i = vectorComponent;
        this.f4808j = n2.a(0);
        this.f4809k = 1.0f;
        this.f4811m = -1;
    }

    public /* synthetic */ VectorPainter(GroupComponent groupComponent, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new GroupComponent() : groupComponent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int o() {
        return this.f4808j.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(int i11) {
        this.f4808j.setIntValue(i11);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean a(float f11) {
        this.f4809k = f11;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean b(v1 v1Var) {
        this.f4810l = v1Var;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long h() {
        return p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void j(z.g gVar) {
        VectorComponent vectorComponent = this.f4807i;
        v1 v1Var = this.f4810l;
        if (v1Var == null) {
            v1Var = vectorComponent.k();
        }
        if (n() && gVar.getLayoutDirection() == LayoutDirection.Rtl) {
            long O0 = gVar.O0();
            z.d H0 = gVar.H0();
            long i11 = H0.i();
            H0.e().n();
            try {
                H0.c().e(-1.0f, 1.0f, O0);
                vectorComponent.i(gVar, this.f4809k, v1Var);
            } finally {
                H0.e().j();
                H0.f(i11);
            }
        } else {
            vectorComponent.i(gVar, this.f4809k, v1Var);
        }
        this.f4811m = o();
    }

    public final boolean n() {
        return ((Boolean) this.f4806h.getValue()).booleanValue();
    }

    public final long p() {
        return ((y.m) this.f4805g.getValue()).m();
    }

    public final void q(boolean z10) {
        this.f4806h.setValue(Boolean.valueOf(z10));
    }

    public final void r(v1 v1Var) {
        this.f4807i.n(v1Var);
    }

    public final void t(String str) {
        this.f4807i.p(str);
    }

    public final void u(long j11) {
        this.f4805g.setValue(y.m.c(j11));
    }

    public final void v(long j11) {
        this.f4807i.q(j11);
    }
}
