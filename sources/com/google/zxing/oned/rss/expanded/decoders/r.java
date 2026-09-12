package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final id.a f32999a;

    /* renamed from: b, reason: collision with root package name */
    private final CurrentParsingState f33000b = new CurrentParsingState();

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f33001c = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(id.a aVar) {
        this.f32999a = aVar;
    }

    private m b(int i11) {
        char c11;
        int f11 = f(i11, 5);
        if (f11 == 15) {
            return new m(i11 + 5, '$');
        }
        if (f11 >= 5 && f11 < 15) {
            return new m(i11 + 5, (char) (f11 + 43));
        }
        int f12 = f(i11, 6);
        if (f12 >= 32 && f12 < 58) {
            return new m(i11 + 6, (char) (f12 + 33));
        }
        switch (f12) {
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                c11 = '*';
                break;
            case 59:
                c11 = ',';
                break;
            case 60:
                c11 = '-';
                break;
            case 61:
                c11 = '.';
                break;
            case 62:
                c11 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + f12);
        }
        return new m(i11 + 6, c11);
    }

    private m d(int i11) {
        int f11 = f(i11, 5);
        if (f11 == 15) {
            return new m(i11 + 5, '$');
        }
        char c11 = '+';
        if (f11 >= 5 && f11 < 15) {
            return new m(i11 + 5, (char) (f11 + 43));
        }
        int f12 = f(i11, 7);
        if (f12 >= 64 && f12 < 90) {
            return new m(i11 + 7, (char) (f12 + 1));
        }
        if (f12 >= 90 && f12 < 116) {
            return new m(i11 + 7, (char) (f12 + 7));
        }
        switch (f(i11, 8)) {
            case 232:
                c11 = '!';
                break;
            case 233:
                c11 = '\"';
                break;
            case 234:
                c11 = '%';
                break;
            case 235:
                c11 = '&';
                break;
            case 236:
                c11 = '\'';
                break;
            case 237:
                c11 = '(';
                break;
            case 238:
                c11 = ')';
                break;
            case 239:
                c11 = '*';
                break;
            case 240:
                break;
            case 241:
                c11 = ',';
                break;
            case 242:
                c11 = '-';
                break;
            case 243:
                c11 = '.';
                break;
            case 244:
                c11 = '/';
                break;
            case 245:
                c11 = ':';
                break;
            case 246:
                c11 = ';';
                break;
            case 247:
                c11 = '<';
                break;
            case 248:
                c11 = '=';
                break;
            case 249:
                c11 = '>';
                break;
            case 250:
                c11 = '?';
                break;
            case 251:
                c11 = '_';
                break;
            case 252:
                c11 = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new m(i11 + 8, c11);
    }

    private o e(int i11) {
        int i12 = i11 + 7;
        if (i12 > this.f32999a.m()) {
            int f11 = f(i11, 4);
            return f11 == 0 ? new o(this.f32999a.m(), 10, 10) : new o(this.f32999a.m(), f11 - 1, 10);
        }
        int f12 = f(i11, 7) - 8;
        return new o(i12, f12 / 11, f12 % 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(id.a aVar, int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            if (aVar.i(i11 + i14)) {
                i13 |= 1 << ((i12 - i14) - 1);
            }
        }
        return i13;
    }

    private boolean h(int i11) {
        int i12 = i11 + 3;
        if (i12 > this.f32999a.m()) {
            return false;
        }
        while (i11 < i12) {
            if (this.f32999a.i(i11)) {
                return false;
            }
            i11++;
        }
        return true;
    }

    private boolean i(int i11) {
        int i12;
        if (i11 + 1 > this.f32999a.m()) {
            return false;
        }
        for (int i13 = 0; i13 < 5 && (i12 = i13 + i11) < this.f32999a.m(); i13++) {
            if (i13 == 2) {
                if (!this.f32999a.i(i11 + 2)) {
                    return false;
                }
            } else if (this.f32999a.i(i12)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i11) {
        int i12;
        if (i11 + 1 > this.f32999a.m()) {
            return false;
        }
        for (int i13 = 0; i13 < 4 && (i12 = i13 + i11) < this.f32999a.m(); i13++) {
            if (this.f32999a.i(i12)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i11) {
        int f11;
        if (i11 + 5 > this.f32999a.m()) {
            return false;
        }
        int f12 = f(i11, 5);
        if (f12 < 5 || f12 >= 16) {
            return i11 + 6 <= this.f32999a.m() && (f11 = f(i11, 6)) >= 16 && f11 < 63;
        }
        return true;
    }

    private boolean l(int i11) {
        int f11;
        if (i11 + 5 > this.f32999a.m()) {
            return false;
        }
        int f12 = f(i11, 5);
        if (f12 >= 5 && f12 < 16) {
            return true;
        }
        if (i11 + 7 > this.f32999a.m()) {
            return false;
        }
        int f13 = f(i11, 7);
        if (f13 < 64 || f13 >= 116) {
            return i11 + 8 <= this.f32999a.m() && (f11 = f(i11, 8)) >= 232 && f11 < 253;
        }
        return true;
    }

    private boolean m(int i11) {
        if (i11 + 7 > this.f32999a.m()) {
            return i11 + 4 <= this.f32999a.m();
        }
        int i12 = i11;
        while (true) {
            int i13 = i11 + 3;
            if (i12 >= i13) {
                return this.f32999a.i(i13);
            }
            if (this.f32999a.i(i12)) {
                return true;
            }
            i12++;
        }
    }

    private l n() {
        while (k(this.f33000b.a())) {
            m b11 = b(this.f33000b.a());
            this.f33000b.h(b11.a());
            if (b11.c()) {
                return new l(new n(this.f33000b.a(), this.f33001c.toString()), true);
            }
            this.f33001c.append(b11.b());
        }
        if (h(this.f33000b.a())) {
            this.f33000b.b(3);
            this.f33000b.g();
        } else if (i(this.f33000b.a())) {
            if (this.f33000b.a() + 5 < this.f32999a.m()) {
                this.f33000b.b(5);
            } else {
                this.f33000b.h(this.f32999a.m());
            }
            this.f33000b.f();
        }
        return new l();
    }

    private n o() {
        l q11;
        boolean b11;
        do {
            int a11 = this.f33000b.a();
            if (this.f33000b.c()) {
                q11 = n();
                b11 = q11.b();
            } else if (this.f33000b.d()) {
                q11 = p();
                b11 = q11.b();
            } else {
                q11 = q();
                b11 = q11.b();
            }
            if (a11 == this.f33000b.a() && !b11) {
                break;
            }
        } while (!b11);
        return q11.a();
    }

    private l p() {
        while (l(this.f33000b.a())) {
            m d11 = d(this.f33000b.a());
            this.f33000b.h(d11.a());
            if (d11.c()) {
                return new l(new n(this.f33000b.a(), this.f33001c.toString()), true);
            }
            this.f33001c.append(d11.b());
        }
        if (h(this.f33000b.a())) {
            this.f33000b.b(3);
            this.f33000b.g();
        } else if (i(this.f33000b.a())) {
            if (this.f33000b.a() + 5 < this.f32999a.m()) {
                this.f33000b.b(5);
            } else {
                this.f33000b.h(this.f32999a.m());
            }
            this.f33000b.e();
        }
        return new l();
    }

    private l q() {
        while (m(this.f33000b.a())) {
            o e11 = e(this.f33000b.a());
            this.f33000b.h(e11.a());
            if (e11.d()) {
                return new l(e11.e() ? new n(this.f33000b.a(), this.f33001c.toString()) : new n(this.f33000b.a(), this.f33001c.toString(), e11.c()), true);
            }
            this.f33001c.append(e11.b());
            if (e11.e()) {
                return new l(new n(this.f33000b.a(), this.f33001c.toString()), true);
            }
            this.f33001c.append(e11.c());
        }
        if (j(this.f33000b.a())) {
            this.f33000b.e();
            this.f33000b.b(4);
        }
        return new l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(StringBuilder sb2, int i11) {
        String str = null;
        while (true) {
            n c11 = c(i11, str);
            String a11 = q.a(c11.b());
            if (a11 != null) {
                sb2.append(a11);
            }
            String valueOf = c11.d() ? String.valueOf(c11.c()) : null;
            if (i11 == c11.a()) {
                return sb2.toString();
            }
            i11 = c11.a();
            str = valueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n c(int i11, String str) {
        this.f33001c.setLength(0);
        if (str != null) {
            this.f33001c.append(str);
        }
        this.f33000b.h(i11);
        n o11 = o();
        return (o11 == null || !o11.d()) ? new n(this.f33000b.a(), this.f33001c.toString()) : new n(this.f33000b.a(), this.f33001c.toString(), o11.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i11, int i12) {
        return g(this.f32999a, i11, i12);
    }
}
