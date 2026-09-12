package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class a implements e {
    private static char b(char c11, char c12) {
        if (g.f(c11) && g.f(c12)) {
            return (char) (((c11 - '0') * 10) + (c12 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c11 + c12);
    }

    @Override // com.google.zxing.datamatrix.encoder.e
    public void a(f fVar) {
        if (g.a(fVar.d(), fVar.f32949d) >= 2) {
            fVar.r(b(fVar.d().charAt(fVar.f32949d), fVar.d().charAt(fVar.f32949d + 1)));
            fVar.f32949d += 2;
            return;
        }
        char c11 = fVar.c();
        int n11 = g.n(fVar.d(), fVar.f32949d, c());
        if (n11 == c()) {
            if (!g.g(c11)) {
                fVar.r((char) (c11 + 1));
                fVar.f32949d++;
                return;
            } else {
                fVar.r((char) 235);
                fVar.r((char) (c11 - 127));
                fVar.f32949d++;
                return;
            }
        }
        if (n11 == 1) {
            fVar.r((char) 230);
            fVar.o(1);
            return;
        }
        if (n11 == 2) {
            fVar.r((char) 239);
            fVar.o(2);
            return;
        }
        if (n11 == 3) {
            fVar.r((char) 238);
            fVar.o(3);
            return;
        }
        if (n11 == 4) {
            fVar.r((char) 240);
            fVar.o(4);
        } else if (n11 == 5) {
            fVar.r((char) 231);
            fVar.o(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + n11);
        }
    }

    public int c() {
        return 0;
    }
}
