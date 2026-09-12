package id;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f65281a;

    /* renamed from: b, reason: collision with root package name */
    private int f65282b;

    /* renamed from: c, reason: collision with root package name */
    private int f65283c;

    public c(byte[] bArr) {
        this.f65281a = bArr;
    }

    public int a() {
        return ((this.f65281a.length - this.f65282b) * 8) - this.f65283c;
    }

    public int b() {
        return this.f65283c;
    }

    public int c() {
        return this.f65282b;
    }

    public int d(int i11) {
        if (i11 < 1 || i11 > 32 || i11 > a()) {
            throw new IllegalArgumentException(String.valueOf(i11));
        }
        int i12 = this.f65283c;
        int i13 = 0;
        if (i12 > 0) {
            int i14 = 8 - i12;
            int min = Math.min(i11, i14);
            int i15 = i14 - min;
            byte[] bArr = this.f65281a;
            int i16 = this.f65282b;
            int i17 = (((255 >> (8 - min)) << i15) & bArr[i16]) >> i15;
            i11 -= min;
            int i18 = this.f65283c + min;
            this.f65283c = i18;
            if (i18 == 8) {
                this.f65283c = 0;
                this.f65282b = i16 + 1;
            }
            i13 = i17;
        }
        if (i11 <= 0) {
            return i13;
        }
        while (i11 >= 8) {
            int i19 = i13 << 8;
            byte[] bArr2 = this.f65281a;
            int i20 = this.f65282b;
            i13 = (bArr2[i20] & 255) | i19;
            this.f65282b = i20 + 1;
            i11 -= 8;
        }
        if (i11 <= 0) {
            return i13;
        }
        int i21 = 8 - i11;
        int i22 = (i13 << i11) | ((((255 >> i21) << i21) & this.f65281a[this.f65282b]) >> i21);
        this.f65283c += i11;
        return i22;
    }
}
