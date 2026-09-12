package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements e {
    private int b(f fVar, StringBuilder sb2, StringBuilder sb3, int i11) {
        int length = sb2.length();
        sb2.delete(length - i11, length);
        fVar.f32949d--;
        int c11 = c(fVar.c(), sb3);
        fVar.k();
        return c11;
    }

    private static String e(CharSequence charSequence) {
        int charAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * '(') + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(f fVar, StringBuilder sb2) {
        fVar.s(e(sb2));
        sb2.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.e
    public void a(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!fVar.i()) {
                break;
            }
            char c11 = fVar.c();
            fVar.f32949d++;
            int c12 = c(c11, sb2);
            int a11 = fVar.a() + ((sb2.length() / 3) * 2);
            fVar.q(a11);
            int a12 = fVar.g().a() - a11;
            if (!fVar.i()) {
                StringBuilder sb3 = new StringBuilder();
                if (sb2.length() % 3 == 2 && a12 != 2) {
                    c12 = b(fVar, sb2, sb3, c12);
                }
                while (sb2.length() % 3 == 1 && (c12 > 3 || a12 != 1)) {
                    c12 = b(fVar, sb2, sb3, c12);
                }
            } else if (sb2.length() % 3 == 0 && g.n(fVar.d(), fVar.f32949d, f()) != f()) {
                fVar.o(0);
                break;
            }
        }
        g(fVar, sb2);
    }

    int c(char c11, StringBuilder sb2) {
        if (c11 == ' ') {
            sb2.append((char) 3);
            return 1;
        }
        if (c11 >= '0' && c11 <= '9') {
            sb2.append((char) (c11 - ','));
            return 1;
        }
        if (c11 >= 'A' && c11 <= 'Z') {
            sb2.append((char) (c11 - '3'));
            return 1;
        }
        if (c11 < ' ') {
            sb2.append((char) 0);
            sb2.append(c11);
            return 2;
        }
        if (c11 <= '/') {
            sb2.append((char) 1);
            sb2.append((char) (c11 - '!'));
            return 2;
        }
        if (c11 <= '@') {
            sb2.append((char) 1);
            sb2.append((char) (c11 - '+'));
            return 2;
        }
        if (c11 <= '_') {
            sb2.append((char) 1);
            sb2.append((char) (c11 - 'E'));
            return 2;
        }
        if (c11 > 127) {
            sb2.append("\u0001\u001e");
            return c((char) (c11 - 128), sb2) + 2;
        }
        sb2.append((char) 2);
        sb2.append((char) (c11 - '`'));
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = fVar.f32949d;
        int i12 = 0;
        int i13 = 0;
        while (fVar.i()) {
            char c11 = fVar.c();
            fVar.f32949d++;
            i13 = c(c11, sb2);
            if (sb2.length() % 3 == 0) {
                i11 = fVar.f32949d;
                i12 = sb2.length();
            }
        }
        if (i12 != sb2.length()) {
            int a11 = fVar.a() + ((sb2.length() / 3) * 2) + 1;
            fVar.q(a11);
            int a12 = fVar.g().a() - a11;
            int length = sb2.length() % 3;
            if ((length == 2 && a12 != 2) || (length == 1 && (i13 > 3 || a12 != 1))) {
                sb2.setLength(i12);
                fVar.f32949d = i11;
            }
        }
        if (sb2.length() > 0) {
            fVar.r((char) 230);
        }
        g(fVar, sb2);
    }

    public int f() {
        return 1;
    }

    void g(f fVar, StringBuilder sb2) {
        int length = (sb2.length() / 3) * 2;
        int length2 = sb2.length() % 3;
        int a11 = fVar.a() + length;
        fVar.q(a11);
        int a12 = fVar.g().a() - a11;
        if (length2 == 2) {
            sb2.append((char) 0);
            while (sb2.length() >= 3) {
                h(fVar, sb2);
            }
            if (fVar.i()) {
                fVar.r((char) 254);
            }
        } else if (a12 == 1 && length2 == 1) {
            while (sb2.length() >= 3) {
                h(fVar, sb2);
            }
            if (fVar.i()) {
                fVar.r((char) 254);
            }
            fVar.f32949d--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb2.length() >= 3) {
                h(fVar, sb2);
            }
            if (a12 > 0 || fVar.i()) {
                fVar.r((char) 254);
            }
        }
        fVar.o(0);
    }
}
