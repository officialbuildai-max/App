package androidx.media3.container;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f10755a;

    /* renamed from: b, reason: collision with root package name */
    private int f10756b;

    /* renamed from: c, reason: collision with root package name */
    private int f10757c;

    /* renamed from: d, reason: collision with root package name */
    private int f10758d;

    public h(byte[] bArr, int i11, int i12) {
        j(bArr, i11, i12);
    }

    private void a() {
        int i11;
        int i12 = this.f10757c;
        androidx.media3.common.util.a.g(i12 >= 0 && (i12 < (i11 = this.f10756b) || (i12 == i11 && this.f10758d == 0)));
    }

    private int g() {
        int i11 = 0;
        while (!e()) {
            i11++;
        }
        return ((1 << i11) - 1) + (i11 > 0 ? f(i11) : 0);
    }

    private boolean k(int i11) {
        if (2 <= i11 && i11 < this.f10756b) {
            byte[] bArr = this.f10755a;
            if (bArr[i11] == 3 && bArr[i11 - 2] == 0 && bArr[i11 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        int i11 = this.f10758d;
        if (i11 > 0) {
            m(8 - i11);
        }
    }

    public boolean c(int i11) {
        int i12 = this.f10757c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        int i15 = (this.f10758d + i11) - (i13 * 8);
        if (i15 > 7) {
            i14++;
            i15 -= 8;
        }
        while (true) {
            i12++;
            if (i12 > i14 || i14 >= this.f10756b) {
                break;
            }
            if (k(i12)) {
                i14++;
                i12 += 2;
            }
        }
        int i16 = this.f10756b;
        if (i14 >= i16) {
            return i14 == i16 && i15 == 0;
        }
        return true;
    }

    public boolean d() {
        int i11 = this.f10757c;
        int i12 = this.f10758d;
        int i13 = 0;
        while (this.f10757c < this.f10756b && !e()) {
            i13++;
        }
        boolean z10 = this.f10757c == this.f10756b;
        this.f10757c = i11;
        this.f10758d = i12;
        return !z10 && c((i13 * 2) + 1);
    }

    public boolean e() {
        boolean z10 = (this.f10755a[this.f10757c] & (128 >> this.f10758d)) != 0;
        l();
        return z10;
    }

    public int f(int i11) {
        int i12;
        this.f10758d += i11;
        int i13 = 0;
        while (true) {
            i12 = this.f10758d;
            if (i12 <= 8) {
                break;
            }
            int i14 = i12 - 8;
            this.f10758d = i14;
            byte[] bArr = this.f10755a;
            int i15 = this.f10757c;
            i13 |= (bArr[i15] & 255) << i14;
            if (!k(i15 + 1)) {
                r3 = 1;
            }
            this.f10757c = i15 + r3;
        }
        byte[] bArr2 = this.f10755a;
        int i16 = this.f10757c;
        int i17 = ((-1) >>> (32 - i11)) & (i13 | ((bArr2[i16] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.f10758d = 0;
            this.f10757c = i16 + (k(i16 + 1) ? 2 : 1);
        }
        a();
        return i17;
    }

    public int h() {
        int g11 = g();
        return (g11 % 2 == 0 ? -1 : 1) * ((g11 + 1) / 2);
    }

    public int i() {
        return g();
    }

    public void j(byte[] bArr, int i11, int i12) {
        this.f10755a = bArr;
        this.f10757c = i11;
        this.f10756b = i12;
        this.f10758d = 0;
        a();
    }

    public void l() {
        int i11 = this.f10758d + 1;
        this.f10758d = i11;
        if (i11 == 8) {
            this.f10758d = 0;
            int i12 = this.f10757c;
            this.f10757c = i12 + (k(i12 + 1) ? 2 : 1);
        }
        a();
    }

    public void m(int i11) {
        int i12 = this.f10757c;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        this.f10757c = i14;
        int i15 = this.f10758d + (i11 - (i13 * 8));
        this.f10758d = i15;
        if (i15 > 7) {
            this.f10757c = i14 + 1;
            this.f10758d = i15 - 8;
        }
        while (true) {
            i12++;
            if (i12 > this.f10757c) {
                a();
                return;
            } else if (k(i12)) {
                this.f10757c++;
                i12 += 2;
            }
        }
    }
}
