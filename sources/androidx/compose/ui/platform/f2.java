package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.s4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
public abstract class f2 {
    private static final boolean a(y.k kVar) {
        return y.a.d(kVar.h()) + y.a.d(kVar.i()) <= kVar.j() && y.a.d(kVar.b()) + y.a.d(kVar.c()) <= kVar.j() && y.a.e(kVar.h()) + y.a.e(kVar.b()) <= kVar.d() && y.a.e(kVar.i()) + y.a.e(kVar.c()) <= kVar.d();
    }

    public static final boolean b(k4 k4Var, float f11, float f12, Path path, Path path2) {
        if (k4Var instanceof k4.b) {
            return e(((k4.b) k4Var).b(), f11, f12);
        }
        if (k4Var instanceof k4.c) {
            return f((k4.c) k4Var, f11, f12, path, path2);
        }
        if (k4Var instanceof k4.a) {
            return d(((k4.a) k4Var).b(), f11, f12, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean c(k4 k4Var, float f11, float f12, Path path, Path path2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            path = null;
        }
        if ((i11 & 16) != 0) {
            path2 = null;
        }
        return b(k4Var, f11, f12, path, path2);
    }

    private static final boolean d(Path path, float f11, float f12, Path path2, Path path3) {
        y.i iVar = new y.i(f11 - 0.005f, f12 - 0.005f, f11 + 0.005f, f12 + 0.005f);
        if (path2 == null) {
            path2 = androidx.compose.ui.graphics.x0.a();
        }
        o4.a(path2, iVar, null, 2, null);
        if (path3 == null) {
            path3 = androidx.compose.ui.graphics.x0.a();
        }
        path3.l(path, path2, s4.f4713a.b());
        boolean isEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !isEmpty;
    }

    private static final boolean e(y.i iVar, float f11, float f12) {
        return iVar.f() <= f11 && f11 < iVar.g() && iVar.i() <= f12 && f12 < iVar.c();
    }

    private static final boolean f(k4.c cVar, float f11, float f12, Path path, Path path2) {
        y.k b11 = cVar.b();
        if (f11 < b11.e() || f11 >= b11.f() || f12 < b11.g() || f12 >= b11.a()) {
            return false;
        }
        if (!a(b11)) {
            Path a11 = path2 == null ? androidx.compose.ui.graphics.x0.a() : path2;
            o4.b(a11, b11, null, 2, null);
            return d(a11, f11, f12, path, path2);
        }
        float d11 = y.a.d(b11.h()) + b11.e();
        float e11 = y.a.e(b11.h()) + b11.g();
        float f13 = b11.f() - y.a.d(b11.i());
        float e12 = y.a.e(b11.i()) + b11.g();
        float f14 = b11.f() - y.a.d(b11.c());
        float a12 = b11.a() - y.a.e(b11.c());
        float a13 = b11.a() - y.a.e(b11.b());
        float d12 = y.a.d(b11.b()) + b11.e();
        if (f11 < d11 && f12 < e11) {
            return g(f11, f12, b11.h(), d11, e11);
        }
        if (f11 < d12 && f12 > a13) {
            return g(f11, f12, b11.b(), d12, a13);
        }
        if (f11 > f13 && f12 < e12) {
            return g(f11, f12, b11.i(), f13, e12);
        }
        if (f11 <= f14 || f12 <= a12) {
            return true;
        }
        return g(f11, f12, b11.c(), f14, a12);
    }

    private static final boolean g(float f11, float f12, long j11, float f13, float f14) {
        float f15 = f11 - f13;
        float f16 = f12 - f14;
        float d11 = y.a.d(j11);
        float e11 = y.a.e(j11);
        return ((f15 * f15) / (d11 * d11)) + ((f16 * f16) / (e11 * e11)) <= 1.0f;
    }
}
