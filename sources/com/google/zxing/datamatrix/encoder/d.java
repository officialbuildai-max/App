package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class d implements e {
    private static void b(char c11, StringBuilder sb2) {
        if (c11 >= ' ' && c11 <= '?') {
            sb2.append(c11);
        } else if (c11 < '@' || c11 > '^') {
            g.e(c11);
        } else {
            sb2.append((char) (c11 - '@'));
        }
    }

    private static String c(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int charAt = (charSequence.charAt(0) << 18) + ((length >= 2 ? charSequence.charAt(1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(3) : (char) 0);
        char c11 = (char) ((charAt >> 16) & 255);
        char c12 = (char) ((charAt >> 8) & 255);
        char c13 = (char) (charAt & 255);
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append(c11);
        if (length >= 2) {
            sb2.append(c12);
        }
        if (length >= 3) {
            sb2.append(c13);
        }
        return sb2.toString();
    }

    private static void e(f fVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z10 = true;
            if (length == 1) {
                fVar.p();
                int a11 = fVar.g().a() - fVar.a();
                int f11 = fVar.f();
                if (f11 > a11) {
                    fVar.q(fVar.a() + 1);
                    a11 = fVar.g().a() - fVar.a();
                }
                if (f11 <= a11 && a11 <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i11 = length - 1;
            String c11 = c(charSequence);
            if (fVar.i() || i11 > 2) {
                z10 = false;
            }
            if (i11 <= 2) {
                fVar.q(fVar.a() + i11);
                if (fVar.g().a() - fVar.a() >= 3) {
                    fVar.q(fVar.a() + c11.length());
                    z10 = false;
                }
            }
            if (z10) {
                fVar.k();
                fVar.f32949d -= i11;
            } else {
                fVar.s(c11);
            }
        } finally {
            fVar.o(0);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.e
    public void a(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!fVar.i()) {
                break;
            }
            b(fVar.c(), sb2);
            fVar.f32949d++;
            if (sb2.length() >= 4) {
                fVar.s(c(sb2));
                sb2.delete(0, 4);
                if (g.n(fVar.d(), fVar.f32949d, d()) != d()) {
                    fVar.o(0);
                    break;
                }
            }
        }
        sb2.append((char) 31);
        e(fVar, sb2);
    }

    public int d() {
        return 4;
    }
}
