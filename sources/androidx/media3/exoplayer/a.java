package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.e0;

/* loaded from: classes2.dex */
public abstract class a extends androidx.media3.common.e0 {

    /* renamed from: e, reason: collision with root package name */
    private final int f11069e;

    /* renamed from: f, reason: collision with root package name */
    private final g2.v f11070f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f11071g;

    public a(boolean z10, g2.v vVar) {
        this.f11071g = z10;
        this.f11070f = vVar;
        this.f11069e = vVar.getLength();
    }

    private int B(int i11, boolean z10) {
        if (z10) {
            return this.f11070f.getNextIndex(i11);
        }
        if (i11 < this.f11069e - 1) {
            return i11 + 1;
        }
        return -1;
    }

    private int C(int i11, boolean z10) {
        if (z10) {
            return this.f11070f.getPreviousIndex(i11);
        }
        if (i11 > 0) {
            return i11 - 1;
        }
        return -1;
    }

    public static Object v(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object w(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object y(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    protected abstract int A(int i11);

    protected abstract androidx.media3.common.e0 D(int i11);

    @Override // androidx.media3.common.e0
    public int a(boolean z10) {
        if (this.f11069e == 0) {
            return -1;
        }
        if (this.f11071g) {
            z10 = false;
        }
        int firstIndex = z10 ? this.f11070f.getFirstIndex() : 0;
        while (D(firstIndex).q()) {
            firstIndex = B(firstIndex, z10);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return A(firstIndex) + D(firstIndex).a(z10);
    }

    @Override // androidx.media3.common.e0
    public final int b(Object obj) {
        int b11;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object w11 = w(obj);
        Object v11 = v(obj);
        int s11 = s(w11);
        if (s11 == -1 || (b11 = D(s11).b(v11)) == -1) {
            return -1;
        }
        return z(s11) + b11;
    }

    @Override // androidx.media3.common.e0
    public int c(boolean z10) {
        int i11 = this.f11069e;
        if (i11 == 0) {
            return -1;
        }
        if (this.f11071g) {
            z10 = false;
        }
        int lastIndex = z10 ? this.f11070f.getLastIndex() : i11 - 1;
        while (D(lastIndex).q()) {
            lastIndex = C(lastIndex, z10);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return A(lastIndex) + D(lastIndex).c(z10);
    }

    @Override // androidx.media3.common.e0
    public int e(int i11, int i12, boolean z10) {
        if (this.f11071g) {
            if (i12 == 1) {
                i12 = 2;
            }
            z10 = false;
        }
        int u11 = u(i11);
        int A = A(u11);
        int e11 = D(u11).e(i11 - A, i12 != 2 ? i12 : 0, z10);
        if (e11 != -1) {
            return A + e11;
        }
        int B = B(u11, z10);
        while (B != -1 && D(B).q()) {
            B = B(B, z10);
        }
        if (B != -1) {
            return A(B) + D(B).a(z10);
        }
        if (i12 == 2) {
            return a(z10);
        }
        return -1;
    }

    @Override // androidx.media3.common.e0
    public final e0.b g(int i11, e0.b bVar, boolean z10) {
        int t11 = t(i11);
        int A = A(t11);
        D(t11).g(i11 - z(t11), bVar, z10);
        bVar.f10018c += A;
        if (z10) {
            bVar.f10017b = y(x(t11), androidx.media3.common.util.a.e(bVar.f10017b));
        }
        return bVar;
    }

    @Override // androidx.media3.common.e0
    public final e0.b h(Object obj, e0.b bVar) {
        Object w11 = w(obj);
        Object v11 = v(obj);
        int s11 = s(w11);
        int A = A(s11);
        D(s11).h(v11, bVar);
        bVar.f10018c += A;
        bVar.f10017b = obj;
        return bVar;
    }

    @Override // androidx.media3.common.e0
    public int l(int i11, int i12, boolean z10) {
        if (this.f11071g) {
            if (i12 == 1) {
                i12 = 2;
            }
            z10 = false;
        }
        int u11 = u(i11);
        int A = A(u11);
        int l11 = D(u11).l(i11 - A, i12 != 2 ? i12 : 0, z10);
        if (l11 != -1) {
            return A + l11;
        }
        int C = C(u11, z10);
        while (C != -1 && D(C).q()) {
            C = C(C, z10);
        }
        if (C != -1) {
            return A(C) + D(C).c(z10);
        }
        if (i12 == 2) {
            return c(z10);
        }
        return -1;
    }

    @Override // androidx.media3.common.e0
    public final Object m(int i11) {
        int t11 = t(i11);
        return y(x(t11), D(t11).m(i11 - z(t11)));
    }

    @Override // androidx.media3.common.e0
    public final e0.c o(int i11, e0.c cVar, long j11) {
        int u11 = u(i11);
        int A = A(u11);
        int z10 = z(u11);
        D(u11).o(i11 - A, cVar, j11);
        Object x10 = x(u11);
        if (!e0.c.f10023q.equals(cVar.f10033a)) {
            x10 = y(x10, cVar.f10033a);
        }
        cVar.f10033a = x10;
        cVar.f10046n += z10;
        cVar.f10047o += z10;
        return cVar;
    }

    protected abstract int s(Object obj);

    protected abstract int t(int i11);

    protected abstract int u(int i11);

    protected abstract Object x(int i11);

    protected abstract int z(int i11);
}
