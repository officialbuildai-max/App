package n2;

import androidx.media3.common.util.j0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r4;

/* loaded from: classes2.dex */
final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f70290a;

    /* renamed from: b, reason: collision with root package name */
    private final int f70291b;

    private f(int i11, ImmutableList immutableList) {
        this.f70291b = i11;
        this.f70290a = immutableList;
    }

    private static a a(int i11, int i12, j0 j0Var) {
        switch (i11) {
            case 1718776947:
                return g.d(i12, j0Var);
            case 1751742049:
                return c.b(j0Var);
            case 1752331379:
                return d.c(j0Var);
            case 1852994675:
                return h.a(j0Var);
            default:
                return null;
        }
    }

    public static f c(int i11, j0 j0Var) {
        ImmutableList.a aVar = new ImmutableList.a();
        int g11 = j0Var.g();
        int i12 = -2;
        while (j0Var.a() > 8) {
            int u11 = j0Var.u();
            int f11 = j0Var.f() + j0Var.u();
            j0Var.V(f11);
            a c11 = u11 == 1414744396 ? c(j0Var.u(), j0Var) : a(u11, i12, j0Var);
            if (c11 != null) {
                if (c11.getType() == 1752331379) {
                    i12 = ((d) c11).b();
                }
                aVar.a(c11);
            }
            j0Var.W(f11);
            j0Var.V(g11);
        }
        return new f(i11, aVar.e());
    }

    public a b(Class cls) {
        r4 it = this.f70290a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }

    @Override // n2.a
    public int getType() {
        return this.f70291b;
    }
}
