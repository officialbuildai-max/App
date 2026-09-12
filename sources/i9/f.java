package i9;

import com.google.android.exoplayer2.util.d0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r4;

/* loaded from: classes4.dex */
final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f65198a;

    /* renamed from: b, reason: collision with root package name */
    private final int f65199b;

    private f(int i11, ImmutableList immutableList) {
        this.f65199b = i11;
        this.f65198a = immutableList;
    }

    private static a a(int i11, int i12, d0 d0Var) {
        switch (i11) {
            case 1718776947:
                return g.d(i12, d0Var);
            case 1751742049:
                return c.b(d0Var);
            case 1752331379:
                return d.c(d0Var);
            case 1852994675:
                return h.a(d0Var);
            default:
                return null;
        }
    }

    public static f c(int i11, d0 d0Var) {
        ImmutableList.a aVar = new ImmutableList.a();
        int f11 = d0Var.f();
        int i12 = -2;
        while (d0Var.a() > 8) {
            int q11 = d0Var.q();
            int e11 = d0Var.e() + d0Var.q();
            d0Var.O(e11);
            a c11 = q11 == 1414744396 ? c(d0Var.q(), d0Var) : a(q11, i12, d0Var);
            if (c11 != null) {
                if (c11.getType() == 1752331379) {
                    i12 = ((d) c11).b();
                }
                aVar.a(c11);
            }
            d0Var.P(e11);
            d0Var.O(f11);
        }
        return new f(i11, aVar.e());
    }

    public a b(Class cls) {
        r4 it = this.f65198a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }

    @Override // i9.a
    public int getType() {
        return this.f65199b;
    }
}
