package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.t0;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import y.i;
import y.j;
import y.m;
import y.n;
import z.g;

/* loaded from: classes.dex */
public abstract class Painter {

    /* renamed from: a, reason: collision with root package name */
    private m4 f4690a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4691b;

    /* renamed from: c, reason: collision with root package name */
    private v1 f4692c;

    /* renamed from: d, reason: collision with root package name */
    private float f4693d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private LayoutDirection f4694e = LayoutDirection.Ltr;

    /* renamed from: f, reason: collision with root package name */
    private final Function1 f4695f = new Function1<g, Unit>() { // from class: androidx.compose.ui.graphics.painter.Painter$drawLambda$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((g) obj);
            return Unit.f67184a;
        }

        public final void invoke(g gVar) {
            Painter.this.j(gVar);
        }
    };

    private final void d(float f11) {
        if (this.f4693d == f11) {
            return;
        }
        if (!a(f11)) {
            if (f11 == 1.0f) {
                m4 m4Var = this.f4690a;
                if (m4Var != null) {
                    m4Var.setAlpha(f11);
                }
                this.f4691b = false;
            } else {
                i().setAlpha(f11);
                this.f4691b = true;
            }
        }
        this.f4693d = f11;
    }

    private final void e(v1 v1Var) {
        if (Intrinsics.c(this.f4692c, v1Var)) {
            return;
        }
        if (!b(v1Var)) {
            if (v1Var == null) {
                m4 m4Var = this.f4690a;
                if (m4Var != null) {
                    m4Var.z(null);
                }
                this.f4691b = false;
            } else {
                i().z(v1Var);
                this.f4691b = true;
            }
        }
        this.f4692c = v1Var;
    }

    private final void f(LayoutDirection layoutDirection) {
        if (this.f4694e != layoutDirection) {
            c(layoutDirection);
            this.f4694e = layoutDirection;
        }
    }

    private final m4 i() {
        m4 m4Var = this.f4690a;
        if (m4Var != null) {
            return m4Var;
        }
        m4 a11 = t0.a();
        this.f4690a = a11;
        return a11;
    }

    protected boolean a(float f11) {
        return false;
    }

    protected boolean b(v1 v1Var) {
        return false;
    }

    protected boolean c(LayoutDirection layoutDirection) {
        return false;
    }

    public final void g(g gVar, long j11, float f11, v1 v1Var) {
        d(f11);
        e(v1Var);
        f(gVar.getLayoutDirection());
        float i11 = m.i(gVar.i()) - m.i(j11);
        float g11 = m.g(gVar.i()) - m.g(j11);
        gVar.H0().c().f(0.0f, 0.0f, i11, g11);
        if (f11 > 0.0f) {
            try {
                if (m.i(j11) > 0.0f && m.g(j11) > 0.0f) {
                    if (this.f4691b) {
                        i a11 = j.a(y.g.f78593b.c(), n.a(m.i(j11), m.g(j11)));
                        m1 e11 = gVar.H0().e();
                        try {
                            e11.d(a11, i());
                            j(gVar);
                            e11.j();
                        } catch (Throwable th2) {
                            e11.j();
                            throw th2;
                        }
                    } else {
                        j(gVar);
                    }
                }
            } catch (Throwable th3) {
                gVar.H0().c().f(-0.0f, -0.0f, -i11, -g11);
                throw th3;
            }
        }
        gVar.H0().c().f(-0.0f, -0.0f, -i11, -g11);
    }

    public abstract long h();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void j(g gVar);
}
