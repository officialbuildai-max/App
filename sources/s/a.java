package s;

import androidx.compose.runtime.a2;
import androidx.compose.runtime.b2;
import androidx.compose.runtime.j2;
import androidx.compose.runtime.l;
import androidx.compose.runtime.m;
import androidx.compose.runtime.m2;
import androidx.compose.runtime.o1;
import androidx.compose.runtime.x0;
import androidx.compose.runtime.y0;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import s.d;
import s.g;

/* loaded from: classes2.dex */
public final class a extends h {

    /* renamed from: a, reason: collision with root package name */
    private final g f74890a = new g();

    public final void A() {
        this.f74890a.x(d.a0.f74910c);
    }

    public final void B(int i11) {
        g gVar = this.f74890a;
        d.b0 b0Var = d.b0.f74912c;
        gVar.y(b0Var);
        g.c.c(g.c.a(gVar), d.q.a(0), i11);
        if (g.f(gVar) == g.a(gVar, b0Var.b()) && g.g(gVar) == g.a(gVar, b0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = b0Var.b();
        int i12 = 0;
        for (int i13 = 0; i13 < b11; i13++) {
            if (((1 << i13) & g.f(gVar)) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(b0Var.e(d.q.a(i13)));
                i12++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = b0Var.d();
        int i14 = 0;
        for (int i15 = 0; i15 < d11; i15++) {
            if (((1 << i15) & g.g(gVar)) != 0) {
                if (i12 > 0) {
                    sb4.append(", ");
                }
                sb4.append(b0Var.f(d.t.a(i15)));
                i14++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + b0Var + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + sb3 + ") and " + i14 + " object arguments (" + sb5 + ").");
    }

    public final void C(Object obj, androidx.compose.runtime.c cVar, int i11) {
        g gVar = this.f74890a;
        d.c0 c0Var = d.c0.f74914c;
        gVar.y(c0Var);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(0), obj);
        g.c.d(a11, d.t.a(1), cVar);
        g.c.c(a11, d.q.a(0), i11);
        if (g.f(gVar) == g.a(gVar, c0Var.b()) && g.g(gVar) == g.a(gVar, c0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = c0Var.b();
        int i12 = 0;
        for (int i13 = 0; i13 < b11; i13++) {
            if (((1 << i13) & g.f(gVar)) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(c0Var.e(d.q.a(i13)));
                i12++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = c0Var.d();
        int i14 = 0;
        for (int i15 = 0; i15 < d11; i15++) {
            if (((1 << i15) & g.g(gVar)) != 0) {
                if (i12 > 0) {
                    sb4.append(", ");
                }
                sb4.append(c0Var.f(d.t.a(i15)));
                i14++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + c0Var + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + sb3 + ") and " + i14 + " object arguments (" + sb5 + ").");
    }

    public final void D(Object obj) {
        g gVar = this.f74890a;
        d.d0 d0Var = d.d0.f74916c;
        gVar.y(d0Var);
        g.c.d(g.c.a(gVar), d.t.a(0), obj);
        if (g.f(gVar) == g.a(gVar, d0Var.b()) && g.g(gVar) == g.a(gVar, d0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = d0Var.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(d0Var.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = d0Var.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(d0Var.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + d0Var + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void E(Object obj, Function2 function2) {
        g gVar = this.f74890a;
        d.e0 e0Var = d.e0.f74918c;
        gVar.y(e0Var);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(0), obj);
        int a12 = d.t.a(1);
        Intrinsics.f(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        g.c.d(a11, a12, (Function2) TypeIntrinsics.e(function2, 2));
        if (g.f(gVar) == g.a(gVar, e0Var.b()) && g.g(gVar) == g.a(gVar, e0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = e0Var.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(e0Var.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = e0Var.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(e0Var.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + e0Var + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void F(Object obj, int i11) {
        g gVar = this.f74890a;
        d.f0 f0Var = d.f0.f74920c;
        gVar.y(f0Var);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(0), obj);
        g.c.c(a11, d.q.a(0), i11);
        if (g.f(gVar) == g.a(gVar, f0Var.b()) && g.g(gVar) == g.a(gVar, f0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = f0Var.b();
        int i12 = 0;
        for (int i13 = 0; i13 < b11; i13++) {
            if (((1 << i13) & g.f(gVar)) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(f0Var.e(d.q.a(i13)));
                i12++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = f0Var.d();
        int i14 = 0;
        for (int i15 = 0; i15 < d11; i15++) {
            if (((1 << i15) & g.g(gVar)) != 0) {
                if (i12 > 0) {
                    sb4.append(", ");
                }
                sb4.append(f0Var.f(d.t.a(i15)));
                i14++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + f0Var + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + sb3 + ") and " + i14 + " object arguments (" + sb5 + ").");
    }

    public final void G(int i11) {
        g gVar = this.f74890a;
        d.g0 g0Var = d.g0.f74922c;
        gVar.y(g0Var);
        g.c.c(g.c.a(gVar), d.q.a(0), i11);
        if (g.f(gVar) == g.a(gVar, g0Var.b()) && g.g(gVar) == g.a(gVar, g0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = g0Var.b();
        int i12 = 0;
        for (int i13 = 0; i13 < b11; i13++) {
            if (((1 << i13) & g.f(gVar)) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(g0Var.e(d.q.a(i13)));
                i12++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = g0Var.d();
        int i14 = 0;
        for (int i15 = 0; i15 < d11; i15++) {
            if (((1 << i15) & g.g(gVar)) != 0) {
                if (i12 > 0) {
                    sb4.append(", ");
                }
                sb4.append(g0Var.f(d.t.a(i15)));
                i14++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + g0Var + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + sb3 + ") and " + i14 + " object arguments (" + sb5 + ").");
    }

    public final void H(Object obj) {
        if (obj instanceof androidx.compose.runtime.h) {
            this.f74890a.x(d.h0.f74924c);
        }
    }

    public final void a() {
        this.f74890a.m();
    }

    public final void b(androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
        this.f74890a.r(fVar, m2Var, a2Var);
    }

    public final boolean c() {
        return this.f74890a.t();
    }

    public final boolean d() {
        return this.f74890a.u();
    }

    public final void e(int i11) {
        g gVar = this.f74890a;
        d.a aVar = d.a.f74909c;
        gVar.y(aVar);
        g.c.c(g.c.a(gVar), d.q.a(0), i11);
        if (g.f(gVar) == g.a(gVar, aVar.b()) && g.g(gVar) == g.a(gVar, aVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = aVar.b();
        int i12 = 0;
        for (int i13 = 0; i13 < b11; i13++) {
            if (((1 << i13) & g.f(gVar)) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.e(d.q.a(i13)));
                i12++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = aVar.d();
        int i14 = 0;
        for (int i15 = 0; i15 < d11; i15++) {
            if (((1 << i15) & g.g(gVar)) != 0) {
                if (i12 > 0) {
                    sb4.append(", ");
                }
                sb4.append(aVar.f(d.t.a(i15)));
                i14++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + aVar + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + sb3 + ") and " + i14 + " object arguments (" + sb5 + ").");
    }

    public final void f(androidx.compose.runtime.c cVar, Object obj) {
        g gVar = this.f74890a;
        d.b bVar = d.b.f74911c;
        gVar.y(bVar);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(0), cVar);
        g.c.d(a11, d.t.a(1), obj);
        if (g.f(gVar) == g.a(gVar, bVar.b()) && g.g(gVar) == g.a(gVar, bVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = bVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(bVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = bVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(bVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + bVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void g(List list, androidx.compose.runtime.internal.c cVar) {
        if (list.isEmpty()) {
            return;
        }
        g gVar = this.f74890a;
        d.C0941d c0941d = d.C0941d.f74915c;
        gVar.y(c0941d);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(1), list);
        g.c.d(a11, d.t.a(0), cVar);
        if (g.f(gVar) == g.a(gVar, c0941d.b()) && g.g(gVar) == g.a(gVar, c0941d.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = c0941d.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(c0941d.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = c0941d.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(c0941d.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + c0941d + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void h(x0 x0Var, m mVar, y0 y0Var, y0 y0Var2) {
        g gVar = this.f74890a;
        d.e eVar = d.e.f74917c;
        gVar.y(eVar);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(0), x0Var);
        g.c.d(a11, d.t.a(1), mVar);
        g.c.d(a11, d.t.a(3), y0Var2);
        g.c.d(a11, d.t.a(2), y0Var);
        if (g.f(gVar) == g.a(gVar, eVar.b()) && g.g(gVar) == g.a(gVar, eVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = eVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(eVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = eVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(eVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + eVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void i() {
        this.f74890a.x(d.f.f74919c);
    }

    public final void j(androidx.compose.runtime.internal.c cVar, androidx.compose.runtime.c cVar2) {
        g gVar = this.f74890a;
        d.g gVar2 = d.g.f74921c;
        gVar.y(gVar2);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(0), cVar);
        g.c.d(a11, d.t.a(1), cVar2);
        if (g.f(gVar) == g.a(gVar, gVar2.b()) && g.g(gVar) == g.a(gVar, gVar2.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = gVar2.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(gVar2.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = gVar2.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(gVar2.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + gVar2 + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void k(Object[] objArr) {
        if (objArr.length == 0) {
            return;
        }
        g gVar = this.f74890a;
        d.h hVar = d.h.f74923c;
        gVar.y(hVar);
        g.c.d(g.c.a(gVar), d.t.a(0), objArr);
        if (g.f(gVar) == g.a(gVar, hVar.b()) && g.g(gVar) == g.a(gVar, hVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = hVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(hVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = hVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(hVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + hVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void l(Function1 function1, l lVar) {
        g gVar = this.f74890a;
        d.i iVar = d.i.f74925c;
        gVar.y(iVar);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(0), function1);
        g.c.d(a11, d.t.a(1), lVar);
        if (g.f(gVar) == g.a(gVar, iVar.b()) && g.g(gVar) == g.a(gVar, iVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = iVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(iVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = iVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(iVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + iVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void m() {
        this.f74890a.x(d.j.f74926c);
    }

    public final void n() {
        this.f74890a.x(d.k.f74927c);
    }

    public final void o(androidx.compose.runtime.c cVar) {
        g gVar = this.f74890a;
        d.l lVar = d.l.f74928c;
        gVar.y(lVar);
        g.c.d(g.c.a(gVar), d.t.a(0), cVar);
        if (g.f(gVar) == g.a(gVar, lVar.b()) && g.g(gVar) == g.a(gVar, lVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = lVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(lVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = lVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(lVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + lVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void p() {
        this.f74890a.x(d.m.f74929c);
    }

    public final void q(a aVar, androidx.compose.runtime.internal.c cVar) {
        if (aVar.d()) {
            g gVar = this.f74890a;
            d.c cVar2 = d.c.f74913c;
            gVar.y(cVar2);
            g a11 = g.c.a(gVar);
            g.c.d(a11, d.t.a(0), aVar);
            g.c.d(a11, d.t.a(1), cVar);
            if (g.f(gVar) == g.a(gVar, cVar2.b()) && g.g(gVar) == g.a(gVar, cVar2.d())) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            int b11 = cVar2.b();
            int i11 = 0;
            for (int i12 = 0; i12 < b11; i12++) {
                if (((1 << i12) & g.f(gVar)) != 0) {
                    if (i11 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(cVar2.e(d.q.a(i12)));
                    i11++;
                }
            }
            String sb3 = sb2.toString();
            Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb4 = new StringBuilder();
            int d11 = cVar2.d();
            int i13 = 0;
            for (int i14 = 0; i14 < d11; i14++) {
                if (((1 << i14) & g.g(gVar)) != 0) {
                    if (i11 > 0) {
                        sb4.append(", ");
                    }
                    sb4.append(cVar2.f(d.t.a(i14)));
                    i13++;
                }
            }
            String sb5 = sb4.toString();
            Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
            o1.b("Error while pushing " + cVar2 + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
        }
    }

    public final void r(androidx.compose.runtime.c cVar, j2 j2Var) {
        g gVar = this.f74890a;
        d.o oVar = d.o.f74931c;
        gVar.y(oVar);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(0), cVar);
        g.c.d(a11, d.t.a(1), j2Var);
        if (g.f(gVar) == g.a(gVar, oVar.b()) && g.g(gVar) == g.a(gVar, oVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = oVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(oVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = oVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(oVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + oVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void s(androidx.compose.runtime.c cVar, j2 j2Var, c cVar2) {
        g gVar = this.f74890a;
        d.p pVar = d.p.f74932c;
        gVar.y(pVar);
        g a11 = g.c.a(gVar);
        g.c.d(a11, d.t.a(0), cVar);
        g.c.d(a11, d.t.a(1), j2Var);
        g.c.d(a11, d.t.a(2), cVar2);
        if (g.f(gVar) == g.a(gVar, pVar.b()) && g.g(gVar) == g.a(gVar, pVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = pVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(pVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = pVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(pVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + pVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void t(int i11) {
        g gVar = this.f74890a;
        d.r rVar = d.r.f74933c;
        gVar.y(rVar);
        g.c.c(g.c.a(gVar), d.q.a(0), i11);
        if (g.f(gVar) == g.a(gVar, rVar.b()) && g.g(gVar) == g.a(gVar, rVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = rVar.b();
        int i12 = 0;
        for (int i13 = 0; i13 < b11; i13++) {
            if (((1 << i13) & g.f(gVar)) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(rVar.e(d.q.a(i13)));
                i12++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = rVar.d();
        int i14 = 0;
        for (int i15 = 0; i15 < d11; i15++) {
            if (((1 << i15) & g.g(gVar)) != 0) {
                if (i12 > 0) {
                    sb4.append(", ");
                }
                sb4.append(rVar.f(d.t.a(i15)));
                i14++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + rVar + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + sb3 + ") and " + i14 + " object arguments (" + sb5 + ").");
    }

    public final void u(int i11, int i12, int i13) {
        g gVar = this.f74890a;
        d.s sVar = d.s.f74934c;
        gVar.y(sVar);
        g a11 = g.c.a(gVar);
        g.c.c(a11, d.q.a(1), i11);
        g.c.c(a11, d.q.a(0), i12);
        g.c.c(a11, d.q.a(2), i13);
        if (g.f(gVar) == g.a(gVar, sVar.b()) && g.g(gVar) == g.a(gVar, sVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = sVar.b();
        int i14 = 0;
        for (int i15 = 0; i15 < b11; i15++) {
            if (((1 << i15) & g.f(gVar)) != 0) {
                if (i14 > 0) {
                    sb2.append(", ");
                }
                sb2.append(sVar.e(d.q.a(i15)));
                i14++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = sVar.d();
        int i16 = 0;
        for (int i17 = 0; i17 < d11; i17++) {
            if (((1 << i17) & g.g(gVar)) != 0) {
                if (i14 > 0) {
                    sb4.append(", ");
                }
                sb4.append(sVar.f(d.t.a(i17)));
                i16++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + sVar + ". Not all arguments were provided. Missing " + i14 + " int arguments (" + sb3 + ") and " + i16 + " object arguments (" + sb5 + ").");
    }

    public final void v(b2 b2Var) {
        g gVar = this.f74890a;
        d.v vVar = d.v.f74936c;
        gVar.y(vVar);
        g.c.d(g.c.a(gVar), d.t.a(0), b2Var);
        if (g.f(gVar) == g.a(gVar, vVar.b()) && g.g(gVar) == g.a(gVar, vVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = vVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(vVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = vVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(vVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + vVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }

    public final void w() {
        this.f74890a.x(d.w.f74937c);
    }

    public final void x(int i11, int i12) {
        g gVar = this.f74890a;
        d.x xVar = d.x.f74938c;
        gVar.y(xVar);
        g a11 = g.c.a(gVar);
        g.c.c(a11, d.q.a(0), i11);
        g.c.c(a11, d.q.a(1), i12);
        if (g.f(gVar) == g.a(gVar, xVar.b()) && g.g(gVar) == g.a(gVar, xVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = xVar.b();
        int i13 = 0;
        for (int i14 = 0; i14 < b11; i14++) {
            if (((1 << i14) & g.f(gVar)) != 0) {
                if (i13 > 0) {
                    sb2.append(", ");
                }
                sb2.append(xVar.e(d.q.a(i14)));
                i13++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = xVar.d();
        int i15 = 0;
        for (int i16 = 0; i16 < d11; i16++) {
            if (((1 << i16) & g.g(gVar)) != 0) {
                if (i13 > 0) {
                    sb4.append(", ");
                }
                sb4.append(xVar.f(d.t.a(i16)));
                i15++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + xVar + ". Not all arguments were provided. Missing " + i13 + " int arguments (" + sb3 + ") and " + i15 + " object arguments (" + sb5 + ").");
    }

    public final void y() {
        this.f74890a.x(d.y.f74939c);
    }

    public final void z(Function0 function0) {
        g gVar = this.f74890a;
        d.z zVar = d.z.f74940c;
        gVar.y(zVar);
        g.c.d(g.c.a(gVar), d.t.a(0), function0);
        if (g.f(gVar) == g.a(gVar, zVar.b()) && g.g(gVar) == g.a(gVar, zVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int b11 = zVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < b11; i12++) {
            if (((1 << i12) & g.f(gVar)) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(zVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int d11 = zVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < d11; i14++) {
            if (((1 << i14) & g.g(gVar)) != 0) {
                if (i11 > 0) {
                    sb4.append(", ");
                }
                sb4.append(zVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String sb5 = sb4.toString();
        Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + zVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + sb3 + ") and " + i13 + " object arguments (" + sb5 + ").");
    }
}
