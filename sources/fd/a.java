package fd;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.k;
import kd.c;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f62491g = {3808, 476, 2107, 1799};

    /* renamed from: a, reason: collision with root package name */
    private final id.b f62492a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f62493b;

    /* renamed from: c, reason: collision with root package name */
    private int f62494c;

    /* renamed from: d, reason: collision with root package name */
    private int f62495d;

    /* renamed from: e, reason: collision with root package name */
    private int f62496e;

    /* renamed from: f, reason: collision with root package name */
    private int f62497f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: fd.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0780a {

        /* renamed from: a, reason: collision with root package name */
        private final int f62498a;

        /* renamed from: b, reason: collision with root package name */
        private final int f62499b;

        C0780a(int i11, int i12) {
            this.f62498a = i11;
            this.f62499b = i12;
        }

        int a() {
            return this.f62498a;
        }

        int b() {
            return this.f62499b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f62500a;

        /* renamed from: b, reason: collision with root package name */
        private final int f62501b;

        b(int i11, int i12) {
            this.f62500a = i11;
            this.f62501b = i12;
        }

        int a() {
            return this.f62500a;
        }

        int b() {
            return this.f62501b;
        }

        k c() {
            return new k(this.f62500a, this.f62501b);
        }

        public String toString() {
            return "<" + this.f62500a + ' ' + this.f62501b + '>';
        }
    }

    public a(id.b bVar) {
        this.f62492a = bVar;
    }

    private static float b(k kVar, k kVar2) {
        return jd.a.a(kVar.c(), kVar.d(), kVar2.c(), kVar2.d());
    }

    private static float c(b bVar, b bVar2) {
        return jd.a.b(bVar.a(), bVar.b(), bVar2.a(), bVar2.b());
    }

    private static k[] d(k[] kVarArr, int i11, int i12) {
        float f11 = i12 / (i11 * 2.0f);
        float c11 = kVarArr[0].c() - kVarArr[2].c();
        float d11 = kVarArr[0].d() - kVarArr[2].d();
        float c12 = (kVarArr[0].c() + kVarArr[2].c()) / 2.0f;
        float d12 = (kVarArr[0].d() + kVarArr[2].d()) / 2.0f;
        float f12 = c11 * f11;
        float f13 = d11 * f11;
        k kVar = new k(c12 + f12, d12 + f13);
        k kVar2 = new k(c12 - f12, d12 - f13);
        float c13 = kVarArr[1].c() - kVarArr[3].c();
        float d13 = kVarArr[1].d() - kVarArr[3].d();
        float c14 = (kVarArr[1].c() + kVarArr[3].c()) / 2.0f;
        float d14 = (kVarArr[1].d() + kVarArr[3].d()) / 2.0f;
        float f14 = c13 * f11;
        float f15 = f11 * d13;
        return new k[]{kVar, new k(c14 + f14, d14 + f15), kVar2, new k(c14 - f14, d14 - f15)};
    }

    private int e(k[] kVarArr) {
        long j11;
        long j12;
        if (!o(kVarArr[0]) || !o(kVarArr[1]) || !o(kVarArr[2]) || !o(kVarArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = this.f62496e * 2;
        int[] iArr = {r(kVarArr[0], kVarArr[1], i11), r(kVarArr[1], kVarArr[2], i11), r(kVarArr[2], kVarArr[3], i11), r(kVarArr[3], kVarArr[0], i11)};
        this.f62497f = m(iArr, i11);
        long j13 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            int i13 = iArr[(this.f62497f + i12) % 4];
            if (this.f62493b) {
                j11 = j13 << 7;
                j12 = (i13 >> 1) & 127;
            } else {
                j11 = j13 << 10;
                j12 = ((i13 >> 2) & 992) + ((i13 >> 1) & 31);
            }
            j13 = j11 + j12;
        }
        C0780a h11 = h(j13, this.f62493b);
        int a11 = h11.a();
        if (this.f62493b) {
            this.f62494c = (a11 >> 6) + 1;
            this.f62495d = (a11 & 63) + 1;
        } else {
            this.f62494c = (a11 >> 11) + 1;
            this.f62495d = (a11 & 2047) + 1;
        }
        return h11.b();
    }

    private k[] f(b bVar) {
        this.f62496e = 1;
        b bVar2 = bVar;
        b bVar3 = bVar2;
        b bVar4 = bVar3;
        b bVar5 = bVar4;
        boolean z10 = true;
        while (this.f62496e < 9) {
            b j11 = j(bVar2, z10, 1, -1);
            b j12 = j(bVar3, z10, 1, 1);
            b j13 = j(bVar4, z10, -1, 1);
            b j14 = j(bVar5, z10, -1, -1);
            if (this.f62496e > 2) {
                double c11 = (c(j14, j11) * this.f62496e) / (c(bVar5, bVar2) * (this.f62496e + 2));
                if (c11 < 0.75d || c11 > 1.25d || !p(j11, j12, j13, j14)) {
                    break;
                }
            }
            z10 = !z10;
            this.f62496e++;
            bVar5 = j14;
            bVar2 = j11;
            bVar3 = j12;
            bVar4 = j13;
        }
        int i11 = this.f62496e;
        if (i11 != 5 && i11 != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.f62493b = i11 == 5;
        k[] kVarArr = {new k(bVar2.a() + 0.5f, bVar2.b() - 0.5f), new k(bVar3.a() + 0.5f, bVar3.b() + 0.5f), new k(bVar4.a() - 0.5f, bVar4.b() + 0.5f), new k(bVar5.a() - 0.5f, bVar5.b() - 0.5f)};
        int i12 = this.f62496e;
        return d(kVarArr, (i12 * 2) - 3, i12 * 2);
    }

    private int g(b bVar, b bVar2) {
        float c11 = c(bVar, bVar2);
        if (c11 == 0.0f) {
            return 0;
        }
        float a11 = (bVar2.a() - bVar.a()) / c11;
        float b11 = (bVar2.b() - bVar.b()) / c11;
        float a12 = bVar.a();
        float b12 = bVar.b();
        boolean g11 = this.f62492a.g(bVar.a(), bVar.b());
        int floor = (int) Math.floor(c11);
        int i11 = 0;
        for (int i12 = 0; i12 < floor; i12++) {
            if (this.f62492a.g(jd.a.c(a12), jd.a.c(b12)) != g11) {
                i11++;
            }
            a12 += a11;
            b12 += b11;
        }
        float f11 = i11 / c11;
        if (f11 <= 0.1f || f11 >= 0.9f) {
            return (f11 <= 0.1f) == g11 ? 1 : -1;
        }
        return 0;
    }

    private static C0780a h(long j11, boolean z10) {
        int i11;
        int i12;
        if (z10) {
            i11 = 7;
            i12 = 2;
        } else {
            i11 = 10;
            i12 = 4;
        }
        int i13 = i11 - i12;
        int[] iArr = new int[i11];
        for (int i14 = i11 - 1; i14 >= 0; i14--) {
            iArr[i14] = ((int) j11) & 15;
            j11 >>= 4;
        }
        try {
            int a11 = new c(kd.a.f66887k).a(iArr, i13);
            int i15 = 0;
            for (int i16 = 0; i16 < i12; i16++) {
                i15 = (i15 << 4) + iArr[i16];
            }
            return new C0780a(i15, a11);
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int i() {
        if (this.f62493b) {
            return (this.f62494c * 4) + 11;
        }
        int i11 = this.f62494c;
        return (i11 * 4) + ((((i11 * 2) + 6) / 15) * 2) + 15;
    }

    private b j(b bVar, boolean z10, int i11, int i12) {
        int a11 = bVar.a() + i11;
        int b11 = bVar.b();
        while (true) {
            b11 += i12;
            if (!n(a11, b11) || this.f62492a.g(a11, b11) != z10) {
                break;
            }
            a11 += i11;
        }
        int i13 = a11 - i11;
        int i14 = b11 - i12;
        while (n(i13, i14) && this.f62492a.g(i13, i14) == z10) {
            i13 += i11;
        }
        int i15 = i13 - i11;
        while (n(i15, i14) && this.f62492a.g(i15, i14) == z10) {
            i14 += i12;
        }
        return new b(i15, i14 - i12);
    }

    private b k() {
        k c11;
        k kVar;
        k kVar2;
        k kVar3;
        k c12;
        k c13;
        k c14;
        k c15;
        try {
            k[] c16 = new jd.b(this.f62492a).c();
            kVar2 = c16[0];
            kVar3 = c16[1];
            kVar = c16[2];
            c11 = c16[3];
        } catch (NotFoundException unused) {
            int n11 = this.f62492a.n() / 2;
            int k11 = this.f62492a.k() / 2;
            int i11 = n11 + 7;
            int i12 = k11 - 7;
            k c17 = j(new b(i11, i12), false, 1, -1).c();
            int i13 = k11 + 7;
            k c18 = j(new b(i11, i13), false, 1, 1).c();
            int i14 = n11 - 7;
            k c19 = j(new b(i14, i13), false, -1, 1).c();
            c11 = j(new b(i14, i12), false, -1, -1).c();
            kVar = c19;
            kVar2 = c17;
            kVar3 = c18;
        }
        int c20 = jd.a.c((((kVar2.c() + c11.c()) + kVar3.c()) + kVar.c()) / 4.0f);
        int c21 = jd.a.c((((kVar2.d() + c11.d()) + kVar3.d()) + kVar.d()) / 4.0f);
        try {
            k[] c22 = new jd.b(this.f62492a, 15, c20, c21).c();
            c12 = c22[0];
            c13 = c22[1];
            c14 = c22[2];
            c15 = c22[3];
        } catch (NotFoundException unused2) {
            int i15 = c20 + 7;
            int i16 = c21 - 7;
            c12 = j(new b(i15, i16), false, 1, -1).c();
            int i17 = c21 + 7;
            c13 = j(new b(i15, i17), false, 1, 1).c();
            int i18 = c20 - 7;
            c14 = j(new b(i18, i17), false, -1, 1).c();
            c15 = j(new b(i18, i16), false, -1, -1).c();
        }
        return new b(jd.a.c((((c12.c() + c15.c()) + c13.c()) + c14.c()) / 4.0f), jd.a.c((((c12.d() + c15.d()) + c13.d()) + c14.d()) / 4.0f));
    }

    private k[] l(k[] kVarArr) {
        return d(kVarArr, this.f62496e * 2, i());
    }

    private static int m(int[] iArr, int i11) {
        int i12 = 0;
        for (int i13 : iArr) {
            i12 = (i12 << 3) + ((i13 >> (i11 - 2)) << 1) + (i13 & 1);
        }
        int i14 = ((i12 & 1) << 11) + (i12 >> 1);
        for (int i15 = 0; i15 < 4; i15++) {
            if (Integer.bitCount(f62491g[i15] ^ i14) <= 2) {
                return i15;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean n(int i11, int i12) {
        return i11 >= 0 && i11 < this.f62492a.n() && i12 >= 0 && i12 < this.f62492a.k();
    }

    private boolean o(k kVar) {
        return n(jd.a.c(kVar.c()), jd.a.c(kVar.d()));
    }

    private boolean p(b bVar, b bVar2, b bVar3, b bVar4) {
        b bVar5 = new b(Math.max(0, bVar.a() - 3), Math.min(this.f62492a.k() - 1, bVar.b() + 3));
        b bVar6 = new b(Math.max(0, bVar2.a() - 3), Math.max(0, bVar2.b() - 3));
        b bVar7 = new b(Math.min(this.f62492a.n() - 1, bVar3.a() + 3), Math.max(0, Math.min(this.f62492a.k() - 1, bVar3.b() - 3)));
        b bVar8 = new b(Math.min(this.f62492a.n() - 1, bVar4.a() + 3), Math.min(this.f62492a.k() - 1, bVar4.b() + 3));
        int g11 = g(bVar8, bVar5);
        return g11 != 0 && g(bVar5, bVar6) == g11 && g(bVar6, bVar7) == g11 && g(bVar7, bVar8) == g11;
    }

    private id.b q(id.b bVar, k kVar, k kVar2, k kVar3, k kVar4) {
        id.k b11 = id.k.b();
        int i11 = i();
        float f11 = i11 / 2.0f;
        int i12 = this.f62496e;
        float f12 = f11 - i12;
        float f13 = f11 + i12;
        return b11.c(bVar, i11, i11, f12, f12, f13, f12, f13, f13, f12, f13, kVar.c(), kVar.d(), kVar2.c(), kVar2.d(), kVar3.c(), kVar3.d(), kVar4.c(), kVar4.d());
    }

    private int r(k kVar, k kVar2, int i11) {
        float b11 = b(kVar, kVar2);
        float f11 = b11 / i11;
        float c11 = kVar.c();
        float d11 = kVar.d();
        float c12 = ((kVar2.c() - kVar.c()) * f11) / b11;
        float d12 = (f11 * (kVar2.d() - kVar.d())) / b11;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            float f12 = i13;
            if (this.f62492a.g(jd.a.c((f12 * c12) + c11), jd.a.c((f12 * d12) + d11))) {
                i12 |= 1 << ((i11 - i13) - 1);
            }
        }
        return i12;
    }

    public ed.a a(boolean z10) {
        k[] f11 = f(k());
        if (z10) {
            k kVar = f11[0];
            f11[0] = f11[2];
            f11[2] = kVar;
        }
        int e11 = e(f11);
        id.b bVar = this.f62492a;
        int i11 = this.f62497f;
        return new ed.a(q(bVar, f11[i11 % 4], f11[(i11 + 1) % 4], f11[(i11 + 2) % 4], f11[(i11 + 3) % 4]), l(f11), this.f62493b, this.f62495d, this.f62494c, e11);
    }
}
