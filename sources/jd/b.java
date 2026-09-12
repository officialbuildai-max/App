package jd;

import com.google.zxing.NotFoundException;
import com.google.zxing.k;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final id.b f66115a;

    /* renamed from: b, reason: collision with root package name */
    private final int f66116b;

    /* renamed from: c, reason: collision with root package name */
    private final int f66117c;

    /* renamed from: d, reason: collision with root package name */
    private final int f66118d;

    /* renamed from: e, reason: collision with root package name */
    private final int f66119e;

    /* renamed from: f, reason: collision with root package name */
    private final int f66120f;

    /* renamed from: g, reason: collision with root package name */
    private final int f66121g;

    public b(id.b bVar) {
        this(bVar, 10, bVar.n() / 2, bVar.k() / 2);
    }

    public b(id.b bVar, int i11, int i12, int i13) {
        this.f66115a = bVar;
        int k11 = bVar.k();
        this.f66116b = k11;
        int n11 = bVar.n();
        this.f66117c = n11;
        int i14 = i11 / 2;
        int i15 = i12 - i14;
        this.f66118d = i15;
        int i16 = i12 + i14;
        this.f66119e = i16;
        int i17 = i13 - i14;
        this.f66121g = i17;
        int i18 = i13 + i14;
        this.f66120f = i18;
        if (i17 < 0 || i15 < 0 || i18 >= k11 || i16 >= n11) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private k[] a(k kVar, k kVar2, k kVar3, k kVar4) {
        float c11 = kVar.c();
        float d11 = kVar.d();
        float c12 = kVar2.c();
        float d12 = kVar2.d();
        float c13 = kVar3.c();
        float d13 = kVar3.d();
        float c14 = kVar4.c();
        float d14 = kVar4.d();
        return c11 < ((float) this.f66117c) / 2.0f ? new k[]{new k(c14 - 1.0f, d14 + 1.0f), new k(c12 + 1.0f, d12 + 1.0f), new k(c13 - 1.0f, d13 - 1.0f), new k(c11 + 1.0f, d11 - 1.0f)} : new k[]{new k(c14 + 1.0f, d14 + 1.0f), new k(c12 + 1.0f, d12 - 1.0f), new k(c13 - 1.0f, d13 + 1.0f), new k(c11 - 1.0f, d11 - 1.0f)};
    }

    private boolean b(int i11, int i12, int i13, boolean z10) {
        if (z10) {
            while (i11 <= i12) {
                if (this.f66115a.g(i11, i13)) {
                    return true;
                }
                i11++;
            }
            return false;
        }
        while (i11 <= i12) {
            if (this.f66115a.g(i13, i11)) {
                return true;
            }
            i11++;
        }
        return false;
    }

    private k d(float f11, float f12, float f13, float f14) {
        int c11 = a.c(a.a(f11, f12, f13, f14));
        float f15 = c11;
        float f16 = (f13 - f11) / f15;
        float f17 = (f14 - f12) / f15;
        for (int i11 = 0; i11 < c11; i11++) {
            float f18 = i11;
            int c12 = a.c((f18 * f16) + f11);
            int c13 = a.c((f18 * f17) + f12);
            if (this.f66115a.g(c12, c13)) {
                return new k(c12, c13);
            }
        }
        return null;
    }

    public k[] c() {
        int i11 = this.f66118d;
        int i12 = this.f66119e;
        int i13 = this.f66121g;
        int i14 = this.f66120f;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = true;
        while (z15) {
            boolean z16 = false;
            boolean z17 = true;
            while (true) {
                if ((z17 || !z11) && i12 < this.f66117c) {
                    z17 = b(i13, i14, i12, false);
                    if (z17) {
                        i12++;
                        z11 = true;
                        z16 = true;
                    } else if (!z11) {
                        i12++;
                    }
                }
            }
            if (i12 < this.f66117c) {
                boolean z18 = true;
                while (true) {
                    if ((z18 || !z12) && i14 < this.f66116b) {
                        z18 = b(i11, i12, i14, true);
                        if (z18) {
                            i14++;
                            z12 = true;
                            z16 = true;
                        } else if (!z12) {
                            i14++;
                        }
                    }
                }
                if (i14 < this.f66116b) {
                    boolean z19 = true;
                    while (true) {
                        if ((z19 || !z13) && i11 >= 0) {
                            z19 = b(i13, i14, i11, false);
                            if (z19) {
                                i11--;
                                z13 = true;
                                z16 = true;
                            } else if (!z13) {
                                i11--;
                            }
                        }
                    }
                    if (i11 >= 0) {
                        z15 = z16;
                        boolean z20 = true;
                        while (true) {
                            if ((z20 || !z14) && i13 >= 0) {
                                z20 = b(i11, i12, i13, true);
                                if (z20) {
                                    i13--;
                                    z15 = true;
                                    z14 = true;
                                } else if (!z14) {
                                    i13--;
                                }
                            }
                        }
                        if (i13 < 0) {
                        }
                    }
                }
            }
            z10 = true;
            break;
        }
        if (z10) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = i12 - i11;
        k kVar = null;
        k kVar2 = null;
        for (int i16 = 1; kVar2 == null && i16 < i15; i16++) {
            kVar2 = d(i11, i14 - i16, i11 + i16, i14);
        }
        if (kVar2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        k kVar3 = null;
        for (int i17 = 1; kVar3 == null && i17 < i15; i17++) {
            kVar3 = d(i11, i13 + i17, i11 + i17, i13);
        }
        if (kVar3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        k kVar4 = null;
        for (int i18 = 1; kVar4 == null && i18 < i15; i18++) {
            kVar4 = d(i12, i13 + i18, i12 - i18, i13);
        }
        if (kVar4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i19 = 1; kVar == null && i19 < i15; i19++) {
            kVar = d(i12, i14 - i19, i12 - i19, i14);
        }
        if (kVar != null) {
            return a(kVar, kVar2, kVar4, kVar3);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
