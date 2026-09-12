package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* loaded from: classes4.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final a f33026a;

    /* renamed from: b, reason: collision with root package name */
    private final f[] f33027b;

    /* renamed from: c, reason: collision with root package name */
    private c f33028c;

    /* renamed from: d, reason: collision with root package name */
    private final int f33029d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, c cVar) {
        this.f33026a = aVar;
        int a11 = aVar.a();
        this.f33029d = a11;
        this.f33028c = cVar;
        this.f33027b = new f[a11 + 2];
    }

    private void a(f fVar) {
        if (fVar != null) {
            ((g) fVar).g(this.f33026a);
        }
    }

    private static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    private static int c(int i11, int i12, d dVar) {
        if (dVar == null || dVar.g()) {
            return i12;
        }
        if (!dVar.h(i11)) {
            return i12 + 1;
        }
        dVar.i(i11);
        return 0;
    }

    private int d() {
        int f11 = f();
        if (f11 == 0) {
            return 0;
        }
        for (int i11 = 1; i11 < this.f33029d + 1; i11++) {
            d[] d11 = this.f33027b[i11].d();
            for (int i12 = 0; i12 < d11.length; i12++) {
                d dVar = d11[i12];
                if (dVar != null && !dVar.g()) {
                    e(i11, i12, d11);
                }
            }
        }
        return f11;
    }

    private void e(int i11, int i12, d[] dVarArr) {
        d dVar = dVarArr[i12];
        d[] d11 = this.f33027b[i11 - 1].d();
        f fVar = this.f33027b[i11 + 1];
        d[] d12 = fVar != null ? fVar.d() : d11;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = d11[i12];
        dVarArr2[3] = d12[i12];
        if (i12 > 0) {
            int i13 = i12 - 1;
            dVarArr2[0] = dVarArr[i13];
            dVarArr2[4] = d11[i13];
            dVarArr2[5] = d12[i13];
        }
        if (i12 > 1) {
            int i14 = i12 - 2;
            dVarArr2[8] = dVarArr[i14];
            dVarArr2[10] = d11[i14];
            dVarArr2[11] = d12[i14];
        }
        if (i12 < dVarArr.length - 1) {
            int i15 = i12 + 1;
            dVarArr2[1] = dVarArr[i15];
            dVarArr2[6] = d11[i15];
            dVarArr2[7] = d12[i15];
        }
        if (i12 < dVarArr.length - 2) {
            int i16 = i12 + 2;
            dVarArr2[9] = dVarArr[i16];
            dVarArr2[12] = d11[i16];
            dVarArr2[13] = d12[i16];
        }
        for (int i17 = 0; i17 < 14 && !b(dVar, dVarArr2[i17]); i17++) {
        }
    }

    private int f() {
        g();
        return h() + i();
    }

    private void g() {
        f[] fVarArr = this.f33027b;
        f fVar = fVarArr[0];
        if (fVar == null || fVarArr[this.f33029d + 1] == null) {
            return;
        }
        d[] d11 = fVar.d();
        d[] d12 = this.f33027b[this.f33029d + 1].d();
        for (int i11 = 0; i11 < d11.length; i11++) {
            d dVar = d11[i11];
            if (dVar != null && d12[i11] != null && dVar.c() == d12[i11].c()) {
                for (int i12 = 1; i12 <= this.f33029d; i12++) {
                    d dVar2 = this.f33027b[i12].d()[i11];
                    if (dVar2 != null) {
                        dVar2.i(d11[i11].c());
                        if (!dVar2.g()) {
                            this.f33027b[i12].d()[i11] = null;
                        }
                    }
                }
            }
        }
    }

    private int h() {
        f fVar = this.f33027b[0];
        if (fVar == null) {
            return 0;
        }
        d[] d11 = fVar.d();
        int i11 = 0;
        for (int i12 = 0; i12 < d11.length; i12++) {
            d dVar = d11[i12];
            if (dVar != null) {
                int c11 = dVar.c();
                int i13 = 0;
                for (int i14 = 1; i14 < this.f33029d + 1 && i13 < 2; i14++) {
                    d dVar2 = this.f33027b[i14].d()[i12];
                    if (dVar2 != null) {
                        i13 = c(c11, i13, dVar2);
                        if (!dVar2.g()) {
                            i11++;
                        }
                    }
                }
            }
        }
        return i11;
    }

    private int i() {
        f[] fVarArr = this.f33027b;
        int i11 = this.f33029d;
        if (fVarArr[i11 + 1] == null) {
            return 0;
        }
        d[] d11 = fVarArr[i11 + 1].d();
        int i12 = 0;
        for (int i13 = 0; i13 < d11.length; i13++) {
            d dVar = d11[i13];
            if (dVar != null) {
                int c11 = dVar.c();
                int i14 = 0;
                for (int i15 = this.f33029d + 1; i15 > 0 && i14 < 2; i15--) {
                    d dVar2 = this.f33027b[i15].d()[i13];
                    if (dVar2 != null) {
                        i14 = c(c11, i14, dVar2);
                        if (!dVar2.g()) {
                            i12++;
                        }
                    }
                }
            }
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f33029d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f33026a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f33026a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c m() {
        return this.f33028c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f n(int i11) {
        return this.f33027b[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f[] o() {
        a(this.f33027b[0]);
        a(this.f33027b[this.f33029d + 1]);
        int i11 = 928;
        while (true) {
            int d11 = d();
            if (d11 <= 0 || d11 >= i11) {
                break;
            }
            i11 = d11;
        }
        return this.f33027b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(c cVar) {
        this.f33028c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i11, f fVar) {
        this.f33027b[i11] = fVar;
    }

    public String toString() {
        f[] fVarArr = this.f33027b;
        f fVar = fVarArr[0];
        if (fVar == null) {
            fVar = fVarArr[this.f33029d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i11 = 0; i11 < fVar.d().length; i11++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i11));
                for (int i12 = 0; i12 < this.f33029d + 2; i12++) {
                    f fVar2 = this.f33027b[i12];
                    if (fVar2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = fVar2.d()[i11];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
