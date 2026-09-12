package ud;

import com.google.zxing.ChecksumException;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f76851a = b.f76852f;

    private int[] b(c cVar) {
        int d11 = cVar.d();
        int[] iArr = new int[d11];
        int i11 = 0;
        for (int i12 = 1; i12 < this.f76851a.e() && i11 < d11; i12++) {
            if (cVar.b(i12) == 0) {
                iArr[i11] = this.f76851a.g(i12);
                i11++;
            }
        }
        if (i11 == d11) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] c(c cVar, c cVar2, int[] iArr) {
        int d11 = cVar2.d();
        if (d11 < 1) {
            return new int[0];
        }
        int[] iArr2 = new int[d11];
        for (int i11 = 1; i11 <= d11; i11++) {
            iArr2[d11 - i11] = this.f76851a.i(i11, cVar2.c(i11));
        }
        c cVar3 = new c(this.f76851a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            int g11 = this.f76851a.g(iArr[i12]);
            iArr3[i12] = this.f76851a.i(this.f76851a.j(0, cVar.b(g11)), this.f76851a.g(cVar3.b(g11)));
        }
        return iArr3;
    }

    private c[] d(c cVar, c cVar2, int i11) {
        if (cVar.d() < cVar2.d()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c f11 = this.f76851a.f();
        c d11 = this.f76851a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = d11;
            c cVar5 = f11;
            f11 = cVar4;
            if (cVar.d() < i11 / 2) {
                int c11 = f11.c(0);
                if (c11 == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int g11 = this.f76851a.g(c11);
                return new c[]{f11.f(g11), cVar.f(g11)};
            }
            if (cVar.e()) {
                throw ChecksumException.getChecksumInstance();
            }
            c f12 = this.f76851a.f();
            int g12 = this.f76851a.g(cVar.c(cVar.d()));
            while (cVar2.d() >= cVar.d() && !cVar2.e()) {
                int d12 = cVar2.d() - cVar.d();
                int i12 = this.f76851a.i(cVar2.c(cVar2.d()), g12);
                f12 = f12.a(this.f76851a.b(d12, i12));
                cVar2 = cVar2.j(cVar.h(d12, i12));
            }
            d11 = f12.g(f11).j(cVar5).i();
        }
    }

    public int a(int[] iArr, int i11, int[] iArr2) {
        c cVar = new c(this.f76851a, iArr);
        int[] iArr3 = new int[i11];
        boolean z10 = false;
        for (int i12 = i11; i12 > 0; i12--) {
            int b11 = cVar.b(this.f76851a.c(i12));
            iArr3[i11 - i12] = b11;
            if (b11 != 0) {
                z10 = true;
            }
        }
        if (!z10) {
            return 0;
        }
        c d11 = this.f76851a.d();
        if (iArr2 != null) {
            for (int i13 : iArr2) {
                int c11 = this.f76851a.c((iArr.length - 1) - i13);
                b bVar = this.f76851a;
                d11 = d11.g(new c(bVar, new int[]{bVar.j(0, c11), 1}));
            }
        }
        c[] d12 = d(this.f76851a.b(i11, 1), new c(this.f76851a, iArr3), i11);
        c cVar2 = d12[0];
        c cVar3 = d12[1];
        int[] b12 = b(cVar2);
        int[] c12 = c(cVar3, cVar2, b12);
        for (int i14 = 0; i14 < b12.length; i14++) {
            int length = (iArr.length - 1) - this.f76851a.h(b12[i14]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.f76851a.j(iArr[length], c12[i14]);
        }
        return b12.length;
    }
}
