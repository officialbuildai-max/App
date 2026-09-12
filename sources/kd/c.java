package kd;

import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f66901a;

    public c(a aVar) {
        this.f66901a = aVar;
    }

    private int[] b(b bVar) {
        int f11 = bVar.f();
        if (f11 == 1) {
            return new int[]{bVar.d(1)};
        }
        int[] iArr = new int[f11];
        int i11 = 0;
        for (int i12 = 1; i12 < this.f66901a.f() && i11 < f11; i12++) {
            if (bVar.c(i12) == 0) {
                iArr[i11] = this.f66901a.h(i12);
                i11++;
            }
        }
        if (i11 == f11) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            int h11 = this.f66901a.h(iArr[i11]);
            int i12 = 1;
            for (int i13 = 0; i13 < length; i13++) {
                if (i11 != i13) {
                    int j11 = this.f66901a.j(iArr[i13], h11);
                    i12 = this.f66901a.j(i12, (j11 & 1) == 0 ? j11 | 1 : j11 & (-2));
                }
            }
            iArr2[i11] = this.f66901a.j(bVar.c(h11), this.f66901a.h(i12));
            if (this.f66901a.d() != 0) {
                iArr2[i11] = this.f66901a.j(iArr2[i11], h11);
            }
        }
        return iArr2;
    }

    private b[] d(b bVar, b bVar2, int i11) {
        if (bVar.f() < bVar2.f()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b g11 = this.f66901a.g();
        b e11 = this.f66901a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = e11;
            b bVar5 = g11;
            g11 = bVar4;
            if (bVar.f() * 2 < i11) {
                int d11 = g11.d(0);
                if (d11 == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int h11 = this.f66901a.h(d11);
                return new b[]{g11.h(h11), bVar.h(h11)};
            }
            if (bVar.g()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            b g12 = this.f66901a.g();
            int h12 = this.f66901a.h(bVar.d(bVar.f()));
            while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                int f11 = bVar2.f() - bVar.f();
                int j11 = this.f66901a.j(bVar2.d(bVar2.f()), h12);
                g12 = g12.a(this.f66901a.b(f11, j11));
                bVar2 = bVar2.a(bVar.j(f11, j11));
            }
            e11 = g12.i(g11).a(bVar5);
        } while (bVar2.f() < bVar.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial? r: " + bVar2 + ", rLast: " + bVar);
    }

    public int a(int[] iArr, int i11) {
        b bVar = new b(this.f66901a, iArr);
        int[] iArr2 = new int[i11];
        boolean z10 = true;
        for (int i12 = 0; i12 < i11; i12++) {
            a aVar = this.f66901a;
            int c11 = bVar.c(aVar.c(aVar.d() + i12));
            iArr2[(i11 - 1) - i12] = c11;
            if (c11 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            return 0;
        }
        b[] d11 = d(this.f66901a.b(i11, 1), new b(this.f66901a, iArr2), i11);
        b bVar2 = d11[0];
        b bVar3 = d11[1];
        int[] b11 = b(bVar2);
        int[] c12 = c(bVar3, b11);
        for (int i13 = 0; i13 < b11.length; i13++) {
            int length = (iArr.length - 1) - this.f66901a.i(b11[i13]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = a.a(iArr[length], c12[i13]);
        }
        return b11.length;
    }
}
