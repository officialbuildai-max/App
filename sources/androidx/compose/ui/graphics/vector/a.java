package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.f4;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import o0.t;
import o0.u;
import z.a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private e4 f4812a;

    /* renamed from: b, reason: collision with root package name */
    private m1 f4813b;

    /* renamed from: c, reason: collision with root package name */
    private o0.e f4814c;

    /* renamed from: d, reason: collision with root package name */
    private LayoutDirection f4815d = LayoutDirection.Ltr;

    /* renamed from: e, reason: collision with root package name */
    private long f4816e = t.f70747b.a();

    /* renamed from: f, reason: collision with root package name */
    private int f4817f = f4.f4514b.b();

    /* renamed from: g, reason: collision with root package name */
    private final z.a f4818g = new z.a();

    private final void a(z.g gVar) {
        z.f.j(gVar, u1.f4733b.a(), 0L, 0L, 0.0f, null, null, c1.f4367a.a(), 62, null);
    }

    public final void b(int i11, long j11, o0.e eVar, LayoutDirection layoutDirection, Function1 function1) {
        this.f4814c = eVar;
        this.f4815d = layoutDirection;
        e4 e4Var = this.f4812a;
        m1 m1Var = this.f4813b;
        if (e4Var == null || m1Var == null || t.g(j11) > e4Var.getWidth() || t.f(j11) > e4Var.getHeight() || !f4.i(this.f4817f, i11)) {
            e4Var = g4.b(t.g(j11), t.f(j11), i11, false, null, 24, null);
            m1Var = o1.a(e4Var);
            this.f4812a = e4Var;
            this.f4813b = m1Var;
            this.f4817f = i11;
        }
        this.f4816e = j11;
        z.a aVar = this.f4818g;
        long d11 = u.d(j11);
        a.C1001a F = aVar.F();
        o0.e a11 = F.a();
        LayoutDirection b11 = F.b();
        m1 c11 = F.c();
        long d12 = F.d();
        a.C1001a F2 = aVar.F();
        F2.j(eVar);
        F2.k(layoutDirection);
        F2.i(m1Var);
        F2.l(d11);
        m1Var.n();
        a(aVar);
        function1.invoke(aVar);
        m1Var.j();
        a.C1001a F3 = aVar.F();
        F3.j(a11);
        F3.k(b11);
        F3.i(c11);
        F3.l(d12);
        e4Var.a();
    }

    public final void c(z.g gVar, float f11, v1 v1Var) {
        e4 e4Var = this.f4812a;
        if (!(e4Var != null)) {
            g0.a.b("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        z.f.e(gVar, e4Var, 0L, this.f4816e, 0L, 0L, f11, null, v1Var, 0, 0, 858, null);
    }

    public final e4 d() {
        return this.f4812a;
    }
}
