package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.k3;

/* loaded from: classes3.dex */
public abstract class a extends k3 {

    /* renamed from: c, reason: collision with root package name */
    private final int f24524c;

    /* renamed from: d, reason: collision with root package name */
    private final t9.t f24525d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f24526e;

    public a(boolean z10, t9.t tVar) {
        this.f24526e = z10;
        this.f24525d = tVar;
        this.f24524c = tVar.getLength();
    }

    public static Object B(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object C(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object E(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    private int H(int i11, boolean z10) {
        if (z10) {
            return this.f24525d.getNextIndex(i11);
        }
        if (i11 < this.f24524c - 1) {
            return i11 + 1;
        }
        return -1;
    }

    private int I(int i11, boolean z10) {
        if (z10) {
            return this.f24525d.getPreviousIndex(i11);
        }
        if (i11 > 0) {
            return i11 - 1;
        }
        return -1;
    }

    protected abstract int A(int i11);

    protected abstract Object D(int i11);

    protected abstract int F(int i11);

    protected abstract int G(int i11);

    protected abstract k3 J(int i11);

    @Override // com.google.android.exoplayer2.k3
    public int e(boolean z10) {
        if (this.f24524c == 0) {
            return -1;
        }
        if (this.f24526e) {
            z10 = false;
        }
        int firstIndex = z10 ? this.f24525d.getFirstIndex() : 0;
        while (J(firstIndex).u()) {
            firstIndex = H(firstIndex, z10);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return G(firstIndex) + J(firstIndex).e(z10);
    }

    @Override // com.google.android.exoplayer2.k3
    public final int f(Object obj) {
        int f11;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object C = C(obj);
        Object B = B(obj);
        int y10 = y(C);
        if (y10 == -1 || (f11 = J(y10).f(B)) == -1) {
            return -1;
        }
        return F(y10) + f11;
    }

    @Override // com.google.android.exoplayer2.k3
    public int g(boolean z10) {
        int i11 = this.f24524c;
        if (i11 == 0) {
            return -1;
        }
        if (this.f24526e) {
            z10 = false;
        }
        int lastIndex = z10 ? this.f24525d.getLastIndex() : i11 - 1;
        while (J(lastIndex).u()) {
            lastIndex = I(lastIndex, z10);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return G(lastIndex) + J(lastIndex).g(z10);
    }

    @Override // com.google.android.exoplayer2.k3
    public int i(int i11, int i12, boolean z10) {
        if (this.f24526e) {
            if (i12 == 1) {
                i12 = 2;
            }
            z10 = false;
        }
        int A = A(i11);
        int G = G(A);
        int i13 = J(A).i(i11 - G, i12 != 2 ? i12 : 0, z10);
        if (i13 != -1) {
            return G + i13;
        }
        int H = H(A, z10);
        while (H != -1 && J(H).u()) {
            H = H(H, z10);
        }
        if (H != -1) {
            return G(H) + J(H).e(z10);
        }
        if (i12 == 2) {
            return e(z10);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.k3
    public final k3.b k(int i11, k3.b bVar, boolean z10) {
        int z11 = z(i11);
        int G = G(z11);
        J(z11).k(i11 - F(z11), bVar, z10);
        bVar.f25210c += G;
        if (z10) {
            bVar.f25209b = E(D(z11), com.google.android.exoplayer2.util.a.e(bVar.f25209b));
        }
        return bVar;
    }

    @Override // com.google.android.exoplayer2.k3
    public final k3.b l(Object obj, k3.b bVar) {
        Object C = C(obj);
        Object B = B(obj);
        int y10 = y(C);
        int G = G(y10);
        J(y10).l(B, bVar);
        bVar.f25210c += G;
        bVar.f25209b = obj;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.k3
    public int p(int i11, int i12, boolean z10) {
        if (this.f24526e) {
            if (i12 == 1) {
                i12 = 2;
            }
            z10 = false;
        }
        int A = A(i11);
        int G = G(A);
        int p11 = J(A).p(i11 - G, i12 != 2 ? i12 : 0, z10);
        if (p11 != -1) {
            return G + p11;
        }
        int I = I(A, z10);
        while (I != -1 && J(I).u()) {
            I = I(I, z10);
        }
        if (I != -1) {
            return G(I) + J(I).g(z10);
        }
        if (i12 == 2) {
            return g(z10);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.k3
    public final Object q(int i11) {
        int z10 = z(i11);
        return E(D(z10), J(z10).q(i11 - F(z10)));
    }

    @Override // com.google.android.exoplayer2.k3
    public final k3.d s(int i11, k3.d dVar, long j11) {
        int A = A(i11);
        int G = G(A);
        int F = F(A);
        J(A).s(i11 - G, dVar, j11);
        Object D = D(A);
        if (!k3.d.f25219r.equals(dVar.f25223a)) {
            D = E(D, dVar.f25223a);
        }
        dVar.f25223a = D;
        dVar.f25237o += F;
        dVar.f25238p += F;
        return dVar;
    }

    protected abstract int y(Object obj);

    protected abstract int z(int i11);
}
