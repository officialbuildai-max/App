package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class i extends c {
    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.e
    public void a(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!fVar.i()) {
                break;
            }
            char c11 = fVar.c();
            fVar.f32949d++;
            c(c11, sb2);
            if (sb2.length() % 3 == 0) {
                c.h(fVar, sb2);
                if (g.n(fVar.d(), fVar.f32949d, f()) != f()) {
                    fVar.o(0);
                    break;
                }
            }
        }
        g(fVar, sb2);
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    int c(char c11, StringBuilder sb2) {
        if (c11 == '\r') {
            sb2.append((char) 0);
        } else if (c11 == ' ') {
            sb2.append((char) 3);
        } else if (c11 == '*') {
            sb2.append((char) 1);
        } else if (c11 == '>') {
            sb2.append((char) 2);
        } else if (c11 >= '0' && c11 <= '9') {
            sb2.append((char) (c11 - ','));
        } else if (c11 < 'A' || c11 > 'Z') {
            g.e(c11);
        } else {
            sb2.append((char) (c11 - '3'));
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    public int f() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    void g(f fVar, StringBuilder sb2) {
        fVar.p();
        int a11 = fVar.g().a() - fVar.a();
        fVar.f32949d -= sb2.length();
        if (fVar.f() > 1 || a11 > 1 || fVar.f() != a11) {
            fVar.r((char) 254);
        }
        if (fVar.e() < 0) {
            fVar.o(0);
        }
    }
}
