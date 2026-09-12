package s;

import androidx.compose.runtime.a2;
import androidx.compose.runtime.k;
import androidx.compose.runtime.m2;
import androidx.compose.runtime.o1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import s.d;
import s.g;

/* loaded from: classes2.dex */
public final class c extends h {

    /* renamed from: a, reason: collision with root package name */
    private final g f74905a = new g();

    /* renamed from: b, reason: collision with root package name */
    private final g f74906b = new g();

    public final void a() {
        this.f74906b.m();
        this.f74905a.m();
    }

    public final void b(Function0 function0, int i11, androidx.compose.runtime.c cVar) {
        g gVar;
        g gVar2;
        g gVar3 = this.f74905a;
        d.n nVar = d.n.f74930c;
        gVar3.y(nVar);
        g a11 = g.c.a(gVar3);
        g.c.d(a11, d.t.a(0), function0);
        g.c.c(a11, d.q.a(0), i11);
        int i12 = 1;
        g.c.d(a11, d.t.a(1), cVar);
        if (!(g.f(gVar3) == g.a(gVar3, nVar.b()) && g.g(gVar3) == g.a(gVar3, nVar.d()))) {
            StringBuilder sb2 = new StringBuilder();
            int b11 = nVar.b();
            int i13 = 0;
            int i14 = 0;
            while (i14 < b11) {
                if (((i12 << i14) & g.f(gVar3)) != 0) {
                    if (i13 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(nVar.e(d.q.a(i14)));
                    i13++;
                }
                i14++;
                i12 = 1;
            }
            String sb3 = sb2.toString();
            Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb4 = new StringBuilder();
            int d11 = nVar.d();
            int i15 = 0;
            int i16 = 0;
            while (i16 < d11) {
                if (((1 << i16) & g.g(gVar3)) != 0) {
                    if (i13 > 0) {
                        sb4.append(", ");
                    }
                    gVar2 = gVar3;
                    sb4.append(nVar.f(d.t.a(i16)));
                    i15++;
                } else {
                    gVar2 = gVar3;
                }
                i16++;
                gVar3 = gVar2;
            }
            String sb5 = sb4.toString();
            Intrinsics.g(sb5, "StringBuilder().apply(builderAction).toString()");
            o1.b("Error while pushing " + nVar + ". Not all arguments were provided. Missing " + i13 + " int arguments (" + sb3 + ") and " + i15 + " object arguments (" + sb5 + ").");
        }
        g gVar4 = this.f74906b;
        d.u uVar = d.u.f74935c;
        gVar4.y(uVar);
        g a12 = g.c.a(gVar4);
        g.c.c(a12, d.q.a(0), i11);
        g.c.d(a12, d.t.a(0), cVar);
        if (g.f(gVar4) == g.a(gVar4, uVar.b()) && g.g(gVar4) == g.a(gVar4, uVar.d())) {
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        int b12 = uVar.b();
        int i17 = 0;
        for (int i18 = 0; i18 < b12; i18++) {
            if (((1 << i18) & g.f(gVar4)) != 0) {
                if (i17 > 0) {
                    sb6.append(", ");
                }
                sb6.append(uVar.e(d.q.a(i18)));
                i17++;
            }
        }
        String sb7 = sb6.toString();
        Intrinsics.g(sb7, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb8 = new StringBuilder();
        int d12 = uVar.d();
        int i19 = 0;
        int i20 = 0;
        while (i20 < d12) {
            if (((1 << i20) & g.g(gVar4)) != 0) {
                if (i17 > 0) {
                    sb8.append(", ");
                }
                gVar = gVar4;
                sb8.append(uVar.f(d.t.a(i20)));
                i19++;
            } else {
                gVar = gVar4;
            }
            i20++;
            gVar4 = gVar;
        }
        String sb9 = sb8.toString();
        Intrinsics.g(sb9, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + uVar + ". Not all arguments were provided. Missing " + i17 + " int arguments (" + sb7 + ") and " + i19 + " object arguments (" + sb9 + ").");
    }

    public final void c() {
        if (!this.f74906b.u()) {
            k.r("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.f74906b.w(this.f74905a);
    }

    public final void d(androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
        if (!this.f74906b.t()) {
            k.r("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.f74905a.r(fVar, m2Var, a2Var);
    }

    public final boolean e() {
        return this.f74905a.t();
    }

    public final void f(Object obj, Function2 function2) {
        g gVar = this.f74905a;
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
}
