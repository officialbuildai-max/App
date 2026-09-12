package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.qrcode.decoder.g;
import id.f;
import id.n;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final id.b f33074a;

    /* renamed from: b, reason: collision with root package name */
    private l f33075b;

    public c(id.b bVar) {
        this.f33074a = bVar;
    }

    private float b(k kVar, k kVar2) {
        float j11 = j((int) kVar.c(), (int) kVar.d(), (int) kVar2.c(), (int) kVar2.d());
        float j12 = j((int) kVar2.c(), (int) kVar2.d(), (int) kVar.c(), (int) kVar.d());
        return Float.isNaN(j11) ? j12 / 7.0f : Float.isNaN(j12) ? j11 / 7.0f : (j11 + j12) / 14.0f;
    }

    private static int c(k kVar, k kVar2, k kVar3, float f11) {
        int c11 = (jd.a.c(k.b(kVar, kVar2) / f11) + jd.a.c(k.b(kVar, kVar3) / f11)) / 2;
        int i11 = c11 + 7;
        int i12 = i11 & 3;
        if (i12 == 0) {
            return c11 + 8;
        }
        if (i12 == 2) {
            return c11 + 6;
        }
        if (i12 != 3) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static n d(k kVar, k kVar2, k kVar3, k kVar4, int i11) {
        float c11;
        float d11;
        float f11;
        float f12 = i11 - 3.5f;
        if (kVar4 != null) {
            c11 = kVar4.c();
            d11 = kVar4.d();
            f11 = f12 - 3.0f;
        } else {
            c11 = (kVar2.c() - kVar.c()) + kVar3.c();
            d11 = (kVar2.d() - kVar.d()) + kVar3.d();
            f11 = f12;
        }
        return n.b(3.5f, 3.5f, f12, 3.5f, f11, f11, 3.5f, f12, kVar.c(), kVar.d(), kVar2.c(), kVar2.d(), c11, d11, kVar3.c(), kVar3.d());
    }

    private static id.b h(id.b bVar, n nVar, int i11) {
        return id.k.b().d(bVar, i11, i11, nVar);
    }

    private float i(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        c cVar;
        boolean z10;
        int i21;
        int i22 = 1;
        boolean z11 = Math.abs(i14 - i12) > Math.abs(i13 - i11);
        if (z11) {
            i16 = i11;
            i15 = i12;
            i18 = i13;
            i17 = i14;
        } else {
            i15 = i11;
            i16 = i12;
            i17 = i13;
            i18 = i14;
        }
        int abs = Math.abs(i17 - i15);
        int abs2 = Math.abs(i18 - i16);
        int i23 = 2;
        int i24 = (-abs) / 2;
        int i25 = i15 < i17 ? 1 : -1;
        int i26 = i16 < i18 ? 1 : -1;
        int i27 = i17 + i25;
        int i28 = i15;
        int i29 = i16;
        int i30 = 0;
        while (true) {
            if (i28 == i27) {
                i19 = i27;
                i20 = i23;
                break;
            }
            int i31 = z11 ? i29 : i28;
            int i32 = z11 ? i28 : i29;
            if (i30 == i22) {
                z10 = z11;
                i21 = i22;
                i19 = i27;
                cVar = this;
            } else {
                cVar = this;
                z10 = z11;
                i19 = i27;
                i21 = 0;
            }
            if (i21 == cVar.f33074a.g(i31, i32)) {
                if (i30 == 2) {
                    return jd.a.b(i28, i29, i15, i16);
                }
                i30++;
            }
            i24 += abs2;
            if (i24 > 0) {
                if (i29 == i18) {
                    i20 = 2;
                    break;
                }
                i29 += i26;
                i24 -= abs;
            }
            i28 += i25;
            i27 = i19;
            z11 = z10;
            i22 = 1;
            i23 = 2;
        }
        if (i30 == i20) {
            return jd.a.b(i19, i18, i15, i16);
        }
        return Float.NaN;
    }

    private float j(int i11, int i12, int i13, int i14) {
        float f11;
        float f12;
        float i15 = i(i11, i12, i13, i14);
        int i16 = i11 - (i13 - i11);
        int i17 = 0;
        if (i16 < 0) {
            f11 = i11 / (i11 - i16);
            i16 = 0;
        } else if (i16 >= this.f33074a.n()) {
            f11 = ((this.f33074a.n() - 1) - i11) / (i16 - i11);
            i16 = this.f33074a.n() - 1;
        } else {
            f11 = 1.0f;
        }
        float f13 = i12;
        int i18 = (int) (f13 - ((i14 - i12) * f11));
        if (i18 < 0) {
            f12 = f13 / (i12 - i18);
        } else if (i18 >= this.f33074a.k()) {
            f12 = ((this.f33074a.k() - 1) - i12) / (i18 - i12);
            i17 = this.f33074a.k() - 1;
        } else {
            i17 = i18;
            f12 = 1.0f;
        }
        return (i15 + i(i11, i12, (int) (i11 + ((i16 - i11) * f12)), i17)) - 1.0f;
    }

    protected final float a(k kVar, k kVar2, k kVar3) {
        return (b(kVar, kVar2) + b(kVar, kVar3)) / 2.0f;
    }

    public final f e(Map map) {
        this.f33075b = map == null ? null : (l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return g(new FinderPatternFinder(this.f33074a, this.f33075b).g(map));
    }

    protected final a f(float f11, int i11, int i12, float f12) {
        int i13 = (int) (f12 * f11);
        int max = Math.max(0, i11 - i13);
        int min = Math.min(this.f33074a.n() - 1, i11 + i13) - max;
        float f13 = 3.0f * f11;
        if (min < f13) {
            throw NotFoundException.getNotFoundInstance();
        }
        int max2 = Math.max(0, i12 - i13);
        int min2 = Math.min(this.f33074a.k() - 1, i12 + i13) - max2;
        if (min2 >= f13) {
            return new b(this.f33074a, max, max2, min, min2, f11, this.f33075b).c();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected final f g(e eVar) {
        a aVar;
        d b11 = eVar.b();
        d c11 = eVar.c();
        d a11 = eVar.a();
        float a12 = a(b11, c11, a11);
        if (a12 < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int c12 = c(b11, c11, a11, a12);
        g g11 = g.g(c12);
        int e11 = g11.e() - 7;
        if (g11.d().length > 0) {
            float c13 = (c11.c() - b11.c()) + a11.c();
            float d11 = (c11.d() - b11.d()) + a11.d();
            float f11 = 1.0f - (3.0f / e11);
            int c14 = (int) (b11.c() + ((c13 - b11.c()) * f11));
            int d12 = (int) (b11.d() + (f11 * (d11 - b11.d())));
            for (int i11 = 4; i11 <= 16; i11 <<= 1) {
                try {
                    aVar = f(a12, c14, d12, i11);
                    break;
                } catch (NotFoundException unused) {
                }
            }
        }
        aVar = null;
        return new f(h(this.f33074a, d(b11, c11, a11, aVar, c12), c12), aVar == null ? new k[]{a11, b11, c11} : new k[]{a11, b11, c11, aVar});
    }
}
