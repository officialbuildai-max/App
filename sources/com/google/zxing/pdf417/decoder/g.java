package com.google.zxing.pdf417.decoder;

import com.google.zxing.k;

/* loaded from: classes4.dex */
final class g extends f {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f33032c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, boolean z10) {
        super(cVar);
        this.f33032c = z10;
    }

    private void h(a aVar) {
        c a11 = a();
        k h11 = this.f33032c ? a11.h() : a11.i();
        k b11 = this.f33032c ? a11.b() : a11.c();
        int e11 = e((int) b11.d());
        d[] d11 = d();
        int i11 = -1;
        int i12 = 0;
        int i13 = 1;
        for (int e12 = e((int) h11.d()); e12 < e11; e12++) {
            d dVar = d11[e12];
            if (dVar != null) {
                dVar.j();
                int c11 = dVar.c() - i11;
                if (c11 == 0) {
                    i12++;
                } else {
                    if (c11 == 1) {
                        i13 = Math.max(i13, i12);
                        i11 = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        d11[e12] = null;
                    } else {
                        i11 = dVar.c();
                    }
                    i12 = 1;
                }
            }
        }
    }

    private void l(d[] dVarArr, a aVar) {
        for (int i11 = 0; i11 < dVarArr.length; i11++) {
            d dVar = dVarArr[i11];
            if (dVar != null) {
                int e11 = dVar.e() % 30;
                int c11 = dVar.c();
                if (c11 > aVar.c()) {
                    dVarArr[i11] = null;
                } else {
                    if (!this.f33032c) {
                        c11 += 2;
                    }
                    int i12 = c11 % 3;
                    if (i12 != 0) {
                        if (i12 != 1) {
                            if (i12 == 2 && e11 + 1 != aVar.a()) {
                                dVarArr[i11] = null;
                            }
                        } else if (e11 / 3 != aVar.b() || e11 % 3 != aVar.d()) {
                            dVarArr[i11] = null;
                        }
                    } else if ((e11 * 3) + 1 != aVar.e()) {
                        dVarArr[i11] = null;
                    }
                }
            }
        }
    }

    private void m() {
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(a aVar) {
        d[] d11 = d();
        m();
        l(d11, aVar);
        c a11 = a();
        k h11 = this.f33032c ? a11.h() : a11.i();
        k b11 = this.f33032c ? a11.b() : a11.c();
        int e11 = e((int) h11.d());
        int e12 = e((int) b11.d());
        int i11 = -1;
        int i12 = 0;
        int i13 = 1;
        while (e11 < e12) {
            d dVar = d11[e11];
            if (dVar != null) {
                int c11 = dVar.c() - i11;
                if (c11 == 0) {
                    i12++;
                } else {
                    if (c11 == 1) {
                        i13 = Math.max(i13, i12);
                        i11 = dVar.c();
                    } else if (c11 < 0 || dVar.c() >= aVar.c() || c11 > e11) {
                        d11[e11] = null;
                    } else {
                        if (i13 > 2) {
                            c11 *= i13 - 2;
                        }
                        boolean z10 = c11 >= e11;
                        for (int i14 = 1; i14 <= c11 && !z10; i14++) {
                            z10 = d11[e11 - i14] != null;
                        }
                        if (z10) {
                            d11[e11] = null;
                        } else {
                            i11 = dVar.c();
                        }
                    }
                    i12 = 1;
                }
            }
            e11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a i() {
        d[] d11 = d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : d11) {
            if (dVar != null) {
                dVar.j();
                int e11 = dVar.e() % 30;
                int c11 = dVar.c();
                if (!this.f33032c) {
                    c11 += 2;
                }
                int i11 = c11 % 3;
                if (i11 == 0) {
                    bVar2.b((e11 * 3) + 1);
                } else if (i11 == 1) {
                    bVar4.b(e11 / 3);
                    bVar3.b(e11 % 3);
                } else if (i11 == 2) {
                    bVar.b(e11 + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] < 1 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        l(d11, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] j() {
        int c11;
        a i11 = i();
        if (i11 == null) {
            return null;
        }
        h(i11);
        int c12 = i11.c();
        int[] iArr = new int[c12];
        for (d dVar : d()) {
            if (dVar != null && (c11 = dVar.c()) < c12) {
                iArr[c11] = iArr[c11] + 1;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f33032c;
    }

    @Override // com.google.zxing.pdf417.decoder.f
    public String toString() {
        return "IsLeft: " + this.f33032c + '\n' + super.toString();
    }
}
