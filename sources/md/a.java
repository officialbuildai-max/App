package md;

import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import id.b;
import id.f;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f69635a;

    /* renamed from: b, reason: collision with root package name */
    private final jd.b f69636b;

    public a(b bVar) {
        this.f69635a = bVar;
        this.f69636b = new jd.b(bVar);
    }

    private k a(k[] kVarArr) {
        k kVar = kVarArr[0];
        k kVar2 = kVarArr[1];
        k kVar3 = kVarArr[2];
        k kVar4 = kVarArr[3];
        int j11 = j(kVar, kVar4);
        k h11 = h(kVar, kVar2, (j(kVar2, kVar4) + 1) * 4);
        k h12 = h(kVar3, kVar2, (j11 + 1) * 4);
        int j12 = j(h11, kVar4);
        int j13 = j(h12, kVar4);
        float f11 = j12 + 1;
        k kVar5 = new k(kVar4.c() + ((kVar3.c() - kVar2.c()) / f11), kVar4.d() + ((kVar3.d() - kVar2.d()) / f11));
        float f12 = j13 + 1;
        k kVar6 = new k(kVar4.c() + ((kVar.c() - kVar2.c()) / f12), kVar4.d() + ((kVar.d() - kVar2.d()) / f12));
        if (e(kVar5)) {
            return (e(kVar6) && j(h11, kVar5) + j(h12, kVar5) <= j(h11, kVar6) + j(h12, kVar6)) ? kVar6 : kVar5;
        }
        if (e(kVar6)) {
            return kVar6;
        }
        return null;
    }

    private k[] c(k[] kVarArr) {
        k kVar = kVarArr[0];
        k kVar2 = kVarArr[1];
        k kVar3 = kVarArr[3];
        k kVar4 = kVarArr[2];
        int j11 = j(kVar, kVar2);
        int j12 = j(kVar2, kVar3);
        int j13 = j(kVar3, kVar4);
        int j14 = j(kVar4, kVar);
        k[] kVarArr2 = {kVar4, kVar, kVar2, kVar3};
        if (j11 > j12) {
            kVarArr2[0] = kVar;
            kVarArr2[1] = kVar2;
            kVarArr2[2] = kVar3;
            kVarArr2[3] = kVar4;
            j11 = j12;
        }
        if (j11 > j13) {
            kVarArr2[0] = kVar2;
            kVarArr2[1] = kVar3;
            kVarArr2[2] = kVar4;
            kVarArr2[3] = kVar;
        } else {
            j13 = j11;
        }
        if (j13 > j14) {
            kVarArr2[0] = kVar3;
            kVarArr2[1] = kVar4;
            kVarArr2[2] = kVar;
            kVarArr2[3] = kVar2;
        }
        return kVarArr2;
    }

    private k[] d(k[] kVarArr) {
        k kVar = kVarArr[0];
        k kVar2 = kVarArr[1];
        k kVar3 = kVarArr[2];
        k kVar4 = kVarArr[3];
        int j11 = (j(kVar, kVar4) + 1) * 4;
        if (j(h(kVar2, kVar3, j11), kVar) < j(h(kVar3, kVar2, j11), kVar4)) {
            kVarArr[0] = kVar;
            kVarArr[1] = kVar2;
            kVarArr[2] = kVar3;
            kVarArr[3] = kVar4;
        } else {
            kVarArr[0] = kVar2;
            kVarArr[1] = kVar3;
            kVarArr[2] = kVar4;
            kVarArr[3] = kVar;
        }
        return kVarArr;
    }

    private boolean e(k kVar) {
        return kVar.c() >= 0.0f && kVar.c() <= ((float) (this.f69635a.n() - 1)) && kVar.d() > 0.0f && kVar.d() <= ((float) (this.f69635a.k() - 1));
    }

    private static k f(k kVar, float f11, float f12) {
        float c11 = kVar.c();
        float d11 = kVar.d();
        return new k(c11 < f11 ? c11 - 1.0f : c11 + 1.0f, d11 < f12 ? d11 - 1.0f : d11 + 1.0f);
    }

    private static b g(b bVar, k kVar, k kVar2, k kVar3, k kVar4, int i11, int i12) {
        float f11 = i11 - 0.5f;
        float f12 = i12 - 0.5f;
        return id.k.b().c(bVar, i11, i12, 0.5f, 0.5f, f11, 0.5f, f11, f12, 0.5f, f12, kVar.c(), kVar.d(), kVar4.c(), kVar4.d(), kVar3.c(), kVar3.d(), kVar2.c(), kVar2.d());
    }

    private static k h(k kVar, k kVar2, int i11) {
        float f11 = i11 + 1;
        return new k(kVar.c() + ((kVar2.c() - kVar.c()) / f11), kVar.d() + ((kVar2.d() - kVar.d()) / f11));
    }

    private k[] i(k[] kVarArr) {
        k kVar = kVarArr[0];
        k kVar2 = kVarArr[1];
        k kVar3 = kVarArr[2];
        k kVar4 = kVarArr[3];
        int j11 = j(kVar, kVar4) + 1;
        k h11 = h(kVar, kVar2, (j(kVar3, kVar4) + 1) * 4);
        k h12 = h(kVar3, kVar2, j11 * 4);
        int j12 = j(h11, kVar4);
        int i11 = j12 + 1;
        int j13 = j(h12, kVar4);
        int i12 = j13 + 1;
        if ((i11 & 1) == 1) {
            i11 = j12 + 2;
        }
        if ((i12 & 1) == 1) {
            i12 = j13 + 2;
        }
        float c11 = (((kVar.c() + kVar2.c()) + kVar3.c()) + kVar4.c()) / 4.0f;
        float d11 = (((kVar.d() + kVar2.d()) + kVar3.d()) + kVar4.d()) / 4.0f;
        k f11 = f(kVar, c11, d11);
        k f12 = f(kVar2, c11, d11);
        k f13 = f(kVar3, c11, d11);
        k f14 = f(kVar4, c11, d11);
        int i13 = i12 * 4;
        int i14 = i11 * 4;
        return new k[]{h(h(f11, f12, i13), f14, i14), h(h(f12, f11, i13), f13, i14), h(h(f13, f14, i13), f12, i14), h(h(f14, f13, i13), f11, i14)};
    }

    private int j(k kVar, k kVar2) {
        int c11 = (int) kVar.c();
        int d11 = (int) kVar.d();
        int c12 = (int) kVar2.c();
        int min = Math.min(this.f69635a.k() - 1, (int) kVar2.d());
        int i11 = 0;
        boolean z10 = Math.abs(min - d11) > Math.abs(c12 - c11);
        if (z10) {
            d11 = c11;
            c11 = d11;
            min = c12;
            c12 = min;
        }
        int abs = Math.abs(c12 - c11);
        int abs2 = Math.abs(min - d11);
        int i12 = (-abs) / 2;
        int i13 = d11 < min ? 1 : -1;
        int i14 = c11 >= c12 ? -1 : 1;
        boolean g11 = this.f69635a.g(z10 ? d11 : c11, z10 ? c11 : d11);
        while (c11 != c12) {
            boolean g12 = this.f69635a.g(z10 ? d11 : c11, z10 ? c11 : d11);
            if (g12 != g11) {
                i11++;
                g11 = g12;
            }
            i12 += abs2;
            if (i12 > 0) {
                if (d11 == min) {
                    break;
                }
                d11 += i13;
                i12 -= abs;
            }
            c11 += i14;
        }
        return i11;
    }

    public f b() {
        int i11;
        int i12;
        k[] d11 = d(c(this.f69636b.c()));
        k a11 = a(d11);
        d11[3] = a11;
        if (a11 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        k[] i13 = i(d11);
        k kVar = i13[0];
        k kVar2 = i13[1];
        k kVar3 = i13[2];
        k kVar4 = i13[3];
        int j11 = j(kVar, kVar4);
        int i14 = j11 + 1;
        int j12 = j(kVar3, kVar4);
        int i15 = j12 + 1;
        if ((i14 & 1) == 1) {
            i14 = j11 + 2;
        }
        if ((i15 & 1) == 1) {
            i15 = j12 + 2;
        }
        if (i14 * 4 >= i15 * 6 || i15 * 4 >= i14 * 6) {
            i11 = i14;
            i12 = i15;
        } else {
            i11 = Math.max(i14, i15);
            i12 = i11;
        }
        return new f(g(this.f69635a, kVar, kVar2, kVar3, kVar4, i11, i12), new k[]{kVar, kVar2, kVar3, kVar4});
    }
}
