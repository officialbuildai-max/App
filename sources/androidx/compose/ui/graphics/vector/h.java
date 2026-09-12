package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.e;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final float[] f4916a = new float[0];

    private static final void a(Path path, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
        double d20 = d13;
        double d21 = 4;
        int ceil = (int) Math.ceil(Math.abs((d19 * d21) / 3.141592653589793d));
        double cos = Math.cos(d17);
        double sin = Math.sin(d17);
        double cos2 = Math.cos(d18);
        double sin2 = Math.sin(d18);
        double d22 = -d20;
        double d23 = d22 * cos;
        double d24 = d14 * sin;
        double d25 = (d23 * sin2) - (d24 * cos2);
        double d26 = d22 * sin;
        double d27 = d14 * cos;
        double d28 = (sin2 * d26) + (cos2 * d27);
        double d29 = d19 / ceil;
        double d30 = d15;
        double d31 = d28;
        double d32 = d25;
        int i11 = 0;
        double d33 = d16;
        double d34 = d18;
        while (i11 < ceil) {
            double d35 = d34 + d29;
            double sin3 = Math.sin(d35);
            double cos3 = Math.cos(d35);
            int i12 = ceil;
            double d36 = (d11 + ((d20 * cos) * cos3)) - (d24 * sin3);
            double d37 = d12 + (d20 * sin * cos3) + (d27 * sin3);
            double d38 = (d23 * sin3) - (d24 * cos3);
            double d39 = (sin3 * d26) + (cos3 * d27);
            double d40 = d35 - d34;
            double tan = Math.tan(d40 / 2);
            double sin4 = (Math.sin(d40) * (Math.sqrt(d21 + ((3.0d * tan) * tan)) - 1)) / 3;
            path.k((float) (d30 + (d32 * sin4)), (float) (d33 + (d31 * sin4)), (float) (d36 - (sin4 * d38)), (float) (d37 - (sin4 * d39)), (float) d36, (float) d37);
            i11++;
            d29 = d29;
            sin = sin;
            d30 = d36;
            d26 = d26;
            d34 = d35;
            d31 = d39;
            d21 = d21;
            d32 = d38;
            cos = cos;
            ceil = i12;
            d33 = d37;
            d20 = d13;
        }
    }

    private static final void b(Path path, double d11, double d12, double d13, double d14, double d15, double d16, double d17, boolean z10, boolean z11) {
        double d18;
        double d19;
        double d20 = (d17 / 180) * 3.141592653589793d;
        double cos = Math.cos(d20);
        double sin = Math.sin(d20);
        double d21 = ((d11 * cos) + (d12 * sin)) / d15;
        double d22 = (((-d11) * sin) + (d12 * cos)) / d16;
        double d23 = ((d13 * cos) + (d14 * sin)) / d15;
        double d24 = (((-d13) * sin) + (d14 * cos)) / d16;
        double d25 = d21 - d23;
        double d26 = d22 - d24;
        double d27 = 2;
        double d28 = (d21 + d23) / d27;
        double d29 = (d22 + d24) / d27;
        double d30 = (d25 * d25) + (d26 * d26);
        if (d30 == 0.0d) {
            return;
        }
        double d31 = (1.0d / d30) - 0.25d;
        if (d31 < 0.0d) {
            double sqrt = (float) (Math.sqrt(d30) / 1.99999d);
            b(path, d11, d12, d13, d14, d15 * sqrt, d16 * sqrt, d17, z10, z11);
            return;
        }
        double sqrt2 = Math.sqrt(d31);
        double d32 = d25 * sqrt2;
        double d33 = sqrt2 * d26;
        if (z10 == z11) {
            d18 = d28 - d33;
            d19 = d29 + d32;
        } else {
            d18 = d28 + d33;
            d19 = d29 - d32;
        }
        double atan2 = Math.atan2(d22 - d19, d21 - d18);
        double atan22 = Math.atan2(d24 - d19, d23 - d18) - atan2;
        if (z11 != (atan22 >= 0.0d)) {
            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d34 = d18 * d15;
        double d35 = d19 * d16;
        a(path, (d34 * cos) - (d35 * sin), (d34 * sin) + (d35 * cos), d15, d16, d11, d12, d20, atan2, atan22);
    }

    public static final Path c(List list, Path path) {
        e eVar;
        float f11;
        int i11;
        int i12;
        float f12;
        float f13;
        float f14;
        float f15;
        float d11;
        float d12;
        float f16;
        float f17;
        float f18;
        float f19;
        float e11;
        float d13;
        float f20;
        float f21;
        float f22;
        List list2 = list;
        Path path2 = path;
        int h11 = path.h();
        path.b();
        path2.e(h11);
        e eVar2 = list.isEmpty() ? e.b.f4863c : (e) list2.get(0);
        int size = list.size();
        float f23 = 0.0f;
        int i13 = 0;
        float f24 = 0.0f;
        float f25 = 0.0f;
        float f26 = 0.0f;
        float f27 = 0.0f;
        float f28 = 0.0f;
        float f29 = 0.0f;
        while (i13 < size) {
            e eVar3 = (e) list2.get(i13);
            if (eVar3 instanceof e.b) {
                path.close();
                eVar = eVar3;
                f11 = f23;
                i11 = i13;
                i12 = size;
                f24 = f28;
                f26 = f24;
                f25 = f29;
                f27 = f25;
            } else {
                if (eVar3 instanceof e.n) {
                    e.n nVar = (e.n) eVar3;
                    f26 += nVar.c();
                    f27 += nVar.d();
                    path2.c(nVar.c(), nVar.d());
                    f28 = f26;
                } else if (eVar3 instanceof e.f) {
                    e.f fVar = (e.f) eVar3;
                    float c11 = fVar.c();
                    float d14 = fVar.d();
                    path2.j(fVar.c(), fVar.d());
                    f26 = c11;
                    f28 = f26;
                    f27 = d14;
                } else {
                    if (eVar3 instanceof e.m) {
                        e.m mVar = (e.m) eVar3;
                        path2.m(mVar.c(), mVar.d());
                        f26 += mVar.c();
                        f17 = mVar.d();
                    } else {
                        if (eVar3 instanceof e.C0049e) {
                            e.C0049e c0049e = (e.C0049e) eVar3;
                            path2.o(c0049e.c(), c0049e.d());
                            d12 = c0049e.c();
                            f16 = c0049e.d();
                        } else {
                            if (eVar3 instanceof e.l) {
                                e.l lVar = (e.l) eVar3;
                                path2.m(lVar.c(), f23);
                                f26 += lVar.c();
                            } else if (eVar3 instanceof e.d) {
                                e.d dVar = (e.d) eVar3;
                                path2.o(dVar.c(), f27);
                                f26 = dVar.c();
                            } else if (eVar3 instanceof e.r) {
                                e.r rVar = (e.r) eVar3;
                                path2.m(f23, rVar.c());
                                f17 = rVar.c();
                            } else if (eVar3 instanceof e.s) {
                                e.s sVar = (e.s) eVar3;
                                path2.o(f26, sVar.c());
                                f27 = sVar.c();
                            } else {
                                if (eVar3 instanceof e.k) {
                                    e.k kVar = (e.k) eVar3;
                                    path.d(kVar.c(), kVar.f(), kVar.d(), kVar.g(), kVar.e(), kVar.h());
                                    f14 = kVar.d() + f26;
                                    f15 = kVar.g() + f27;
                                    f26 += kVar.e();
                                    d11 = kVar.h();
                                } else {
                                    if (eVar3 instanceof e.c) {
                                        e.c cVar = (e.c) eVar3;
                                        path.k(cVar.c(), cVar.f(), cVar.d(), cVar.g(), cVar.e(), cVar.h());
                                        f14 = cVar.d();
                                        e11 = cVar.g();
                                        d13 = cVar.e();
                                        f20 = cVar.h();
                                    } else if (eVar3 instanceof e.p) {
                                        if (eVar2.a()) {
                                            f22 = f27 - f25;
                                            f21 = f26 - f24;
                                        } else {
                                            f21 = f23;
                                            f22 = f21;
                                        }
                                        e.p pVar = (e.p) eVar3;
                                        path.d(f21, f22, pVar.c(), pVar.e(), pVar.d(), pVar.f());
                                        f14 = pVar.c() + f26;
                                        f15 = pVar.e() + f27;
                                        f26 += pVar.d();
                                        d11 = pVar.f();
                                    } else if (eVar3 instanceof e.h) {
                                        if (eVar2.a()) {
                                            float f30 = 2;
                                            f19 = (f30 * f27) - f25;
                                            f18 = (f26 * f30) - f24;
                                        } else {
                                            f18 = f26;
                                            f19 = f27;
                                        }
                                        e.h hVar = (e.h) eVar3;
                                        path.k(f18, f19, hVar.c(), hVar.e(), hVar.d(), hVar.f());
                                        f14 = hVar.c();
                                        e11 = hVar.e();
                                        d13 = hVar.d();
                                        f20 = hVar.f();
                                    } else if (eVar3 instanceof e.o) {
                                        e.o oVar = (e.o) eVar3;
                                        path2.g(oVar.c(), oVar.e(), oVar.d(), oVar.f());
                                        f24 = oVar.c() + f26;
                                        f25 = oVar.e() + f27;
                                        f26 += oVar.d();
                                        f17 = oVar.f();
                                    } else if (eVar3 instanceof e.g) {
                                        e.g gVar = (e.g) eVar3;
                                        path2.f(gVar.c(), gVar.e(), gVar.d(), gVar.f());
                                        f24 = gVar.c();
                                        f25 = gVar.e();
                                        d12 = gVar.d();
                                        f16 = gVar.f();
                                    } else if (eVar3 instanceof e.q) {
                                        if (eVar2.b()) {
                                            f12 = f26 - f24;
                                            f13 = f27 - f25;
                                        } else {
                                            f12 = f23;
                                            f13 = f12;
                                        }
                                        e.q qVar = (e.q) eVar3;
                                        path2.g(f12, f13, qVar.c(), qVar.d());
                                        f14 = f12 + f26;
                                        f15 = f13 + f27;
                                        f26 += qVar.c();
                                        d11 = qVar.d();
                                    } else if (eVar3 instanceof e.i) {
                                        if (eVar2.b()) {
                                            float f31 = 2;
                                            f26 = (f26 * f31) - f24;
                                            f27 = (f31 * f27) - f25;
                                        }
                                        e.i iVar = (e.i) eVar3;
                                        path2.f(f26, f27, iVar.c(), iVar.d());
                                        float c12 = iVar.c();
                                        f25 = f27;
                                        eVar = eVar3;
                                        f11 = f23;
                                        i11 = i13;
                                        i12 = size;
                                        f27 = iVar.d();
                                        float f32 = f26;
                                        f26 = c12;
                                        f24 = f32;
                                    } else if (eVar3 instanceof e.j) {
                                        e.j jVar = (e.j) eVar3;
                                        float c13 = jVar.c() + f26;
                                        float d15 = jVar.d() + f27;
                                        eVar = eVar3;
                                        i11 = i13;
                                        f11 = 0.0f;
                                        i12 = size;
                                        b(path, f26, f27, c13, d15, jVar.e(), jVar.g(), jVar.f(), jVar.h(), jVar.i());
                                        f25 = d15;
                                        f27 = f25;
                                        f24 = c13;
                                        f26 = f24;
                                    } else {
                                        eVar = eVar3;
                                        f11 = f23;
                                        i11 = i13;
                                        i12 = size;
                                        if (eVar instanceof e.a) {
                                            e.a aVar = (e.a) eVar;
                                            b(path, f26, f27, aVar.c(), aVar.d(), aVar.e(), aVar.g(), aVar.f(), aVar.h(), aVar.i());
                                            f26 = aVar.c();
                                            f25 = aVar.d();
                                            f27 = f25;
                                            f24 = f26;
                                        }
                                    }
                                    f26 = d13;
                                    f27 = f20;
                                    eVar = eVar3;
                                    f11 = f23;
                                    i11 = i13;
                                    i12 = size;
                                    f25 = e11;
                                    f24 = f14;
                                }
                                f27 += d11;
                                f25 = f15;
                                eVar = eVar3;
                                f11 = f23;
                                i11 = i13;
                                i12 = size;
                                f24 = f14;
                            }
                            eVar = eVar3;
                            f11 = f23;
                            i11 = i13;
                            i12 = size;
                        }
                        f27 = f16;
                        f26 = d12;
                        eVar = eVar3;
                        f11 = f23;
                        i11 = i13;
                        i12 = size;
                    }
                    f27 += f17;
                    eVar = eVar3;
                    f11 = f23;
                    i11 = i13;
                    i12 = size;
                }
                f29 = f27;
                eVar = eVar3;
                f11 = f23;
                i11 = i13;
                i12 = size;
            }
            i13 = i11 + 1;
            path2 = path;
            eVar2 = eVar;
            f23 = f11;
            size = i12;
            list2 = list;
        }
        return path;
    }
}
