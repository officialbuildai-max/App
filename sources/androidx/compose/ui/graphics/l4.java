package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.k4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
public abstract class l4 {
    public static final void a(z.g gVar, k4 k4Var, j1 j1Var, float f11, z.h hVar, v1 v1Var, int i11) {
        Path b11;
        if (k4Var instanceof k4.b) {
            y.i b12 = ((k4.b) k4Var).b();
            gVar.N0(j1Var, g(b12), e(b12), f11, hVar, v1Var, i11);
            return;
        }
        if (k4Var instanceof k4.c) {
            k4.c cVar = (k4.c) k4Var;
            b11 = cVar.c();
            if (b11 == null) {
                y.k b13 = cVar.b();
                gVar.V0(j1Var, h(b13), f(b13), y.b.b(y.a.d(b13.b()), 0.0f, 2, null), f11, hVar, v1Var, i11);
                return;
            }
        } else {
            if (!(k4Var instanceof k4.a)) {
                throw new NoWhenBranchMatchedException();
            }
            b11 = ((k4.a) k4Var).b();
        }
        gVar.i0(b11, j1Var, f11, hVar, v1Var, i11);
    }

    public static /* synthetic */ void b(z.g gVar, k4 k4Var, j1 j1Var, float f11, z.h hVar, v1 v1Var, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            f11 = 1.0f;
        }
        float f12 = f11;
        if ((i12 & 8) != 0) {
            hVar = z.l.f79237a;
        }
        z.h hVar2 = hVar;
        if ((i12 & 16) != 0) {
            v1Var = null;
        }
        v1 v1Var2 = v1Var;
        if ((i12 & 32) != 0) {
            i11 = z.g.f79233o1.a();
        }
        a(gVar, k4Var, j1Var, f12, hVar2, v1Var2, i11);
    }

    public static final void c(z.g gVar, k4 k4Var, long j11, float f11, z.h hVar, v1 v1Var, int i11) {
        Path b11;
        if (k4Var instanceof k4.b) {
            y.i b12 = ((k4.b) k4Var).b();
            gVar.L0(j11, g(b12), e(b12), f11, hVar, v1Var, i11);
            return;
        }
        if (k4Var instanceof k4.c) {
            k4.c cVar = (k4.c) k4Var;
            b11 = cVar.c();
            if (b11 == null) {
                y.k b13 = cVar.b();
                gVar.T(j11, h(b13), f(b13), y.b.b(y.a.d(b13.b()), 0.0f, 2, null), hVar, f11, v1Var, i11);
                return;
            }
        } else {
            if (!(k4Var instanceof k4.a)) {
                throw new NoWhenBranchMatchedException();
            }
            b11 = ((k4.a) k4Var).b();
        }
        gVar.D0(b11, j11, f11, hVar, v1Var, i11);
    }

    public static /* synthetic */ void d(z.g gVar, k4 k4Var, long j11, float f11, z.h hVar, v1 v1Var, int i11, int i12, Object obj) {
        c(gVar, k4Var, j11, (i12 & 4) != 0 ? 1.0f : f11, (i12 & 8) != 0 ? z.l.f79237a : hVar, (i12 & 16) != 0 ? null : v1Var, (i12 & 32) != 0 ? z.g.f79233o1.a() : i11);
    }

    private static final long e(y.i iVar) {
        return y.n.a(iVar.k(), iVar.e());
    }

    private static final long f(y.k kVar) {
        return y.n.a(kVar.j(), kVar.d());
    }

    private static final long g(y.i iVar) {
        return y.h.a(iVar.f(), iVar.i());
    }

    private static final long h(y.k kVar) {
        return y.h.a(kVar.e(), kVar.g());
    }
}
