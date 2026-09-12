package com.google.android.exoplayer2.util;

/* loaded from: classes3.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f27622a;

    /* renamed from: b, reason: collision with root package name */
    private int f27623b;

    /* renamed from: c, reason: collision with root package name */
    private int f27624c;

    /* renamed from: d, reason: collision with root package name */
    private int f27625d;

    public e0(byte[] bArr, int i11, int i12) {
        i(bArr, i11, i12);
    }

    private void a() {
        int i11;
        int i12 = this.f27624c;
        a.g(i12 >= 0 && (i12 < (i11 = this.f27623b) || (i12 == i11 && this.f27625d == 0)));
    }

    private int f() {
        int i11 = 0;
        while (!d()) {
            i11++;
        }
        return ((1 << i11) - 1) + (i11 > 0 ? e(i11) : 0);
    }

    private boolean j(int i11) {
        if (2 <= i11 && i11 < this.f27623b) {
            byte[] bArr = this.f27622a;
            if (bArr[i11] == 3 && bArr[i11 - 2] == 0 && bArr[i11 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean b(int i11) {
        int i12 = this.f27624c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        int i15 = (this.f27625d + i11) - (i13 * 8);
        if (i15 > 7) {
            i14++;
            i15 -= 8;
        }
        while (true) {
            i12++;
            if (i12 > i14 || i14 >= this.f27623b) {
                break;
            }
            if (j(i12)) {
                i14++;
                i12 += 2;
            }
        }
        int i16 = this.f27623b;
        if (i14 >= i16) {
            return i14 == i16 && i15 == 0;
        }
        return true;
    }

    public boolean c() {
        int i11 = this.f27624c;
        int i12 = this.f27625d;
        int i13 = 0;
        while (this.f27624c < this.f27623b && !d()) {
            i13++;
        }
        boolean z10 = this.f27624c == this.f27623b;
        this.f27624c = i11;
        this.f27625d = i12;
        return !z10 && b((i13 * 2) + 1);
    }

    public boolean d() {
        boolean z10 = (this.f27622a[this.f27624c] & (128 >> this.f27625d)) != 0;
        k();
        return z10;
    }

    public int e(int i11) {
        int i12;
        this.f27625d += i11;
        int i13 = 0;
        while (true) {
            i12 = this.f27625d;
            if (i12 <= 8) {
                break;
            }
            int i14 = i12 - 8;
            this.f27625d = i14;
            byte[] bArr = this.f27622a;
            int i15 = this.f27624c;
            i13 |= (bArr[i15] & 255) << i14;
            if (!j(i15 + 1)) {
                r3 = 1;
            }
            this.f27624c = i15 + r3;
        }
        byte[] bArr2 = this.f27622a;
        int i16 = this.f27624c;
        int i17 = ((-1) >>> (32 - i11)) & (i13 | ((bArr2[i16] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.f27625d = 0;
            this.f27624c = i16 + (j(i16 + 1) ? 2 : 1);
        }
        a();
        return i17;
    }

    public int g() {
        int f11 = f();
        return (f11 % 2 == 0 ? -1 : 1) * ((f11 + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i11, int i12) {
        this.f27622a = bArr;
        this.f27624c = i11;
        this.f27623b = i12;
        this.f27625d = 0;
        a();
    }

    public void k() {
        int i11 = this.f27625d + 1;
        this.f27625d = i11;
        if (i11 == 8) {
            this.f27625d = 0;
            int i12 = this.f27624c;
            this.f27624c = i12 + (j(i12 + 1) ? 2 : 1);
        }
        a();
    }

    public void l(int i11) {
        int i12 = this.f27624c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        this.f27624c = i14;
        int i15 = this.f27625d + (i11 - (i13 * 8));
        this.f27625d = i15;
        if (i15 > 7) {
            this.f27624c = i14 + 1;
            this.f27625d = i15 - 8;
        }
        while (true) {
            i12++;
            if (i12 > this.f27624c) {
                a();
                return;
            } else if (j(i12)) {
                this.f27624c++;
                i12 += 2;
            }
        }
    }
}
