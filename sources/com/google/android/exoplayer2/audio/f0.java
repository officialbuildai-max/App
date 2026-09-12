package com.google.android.exoplayer2.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f24720a;

    /* renamed from: b, reason: collision with root package name */
    private final int f24721b;

    /* renamed from: c, reason: collision with root package name */
    private final float f24722c;

    /* renamed from: d, reason: collision with root package name */
    private final float f24723d;

    /* renamed from: e, reason: collision with root package name */
    private final float f24724e;

    /* renamed from: f, reason: collision with root package name */
    private final int f24725f;

    /* renamed from: g, reason: collision with root package name */
    private final int f24726g;

    /* renamed from: h, reason: collision with root package name */
    private final int f24727h;

    /* renamed from: i, reason: collision with root package name */
    private final short[] f24728i;

    /* renamed from: j, reason: collision with root package name */
    private short[] f24729j;

    /* renamed from: k, reason: collision with root package name */
    private int f24730k;

    /* renamed from: l, reason: collision with root package name */
    private short[] f24731l;

    /* renamed from: m, reason: collision with root package name */
    private int f24732m;

    /* renamed from: n, reason: collision with root package name */
    private short[] f24733n;

    /* renamed from: o, reason: collision with root package name */
    private int f24734o;

    /* renamed from: p, reason: collision with root package name */
    private int f24735p;

    /* renamed from: q, reason: collision with root package name */
    private int f24736q;

    /* renamed from: r, reason: collision with root package name */
    private int f24737r;

    /* renamed from: s, reason: collision with root package name */
    private int f24738s;

    /* renamed from: t, reason: collision with root package name */
    private int f24739t;

    /* renamed from: u, reason: collision with root package name */
    private int f24740u;

    /* renamed from: v, reason: collision with root package name */
    private int f24741v;

    public f0(int i11, int i12, float f11, float f12, int i13) {
        this.f24720a = i11;
        this.f24721b = i12;
        this.f24722c = f11;
        this.f24723d = f12;
        this.f24724e = i11 / i13;
        this.f24725f = i11 / 400;
        int i14 = i11 / 65;
        this.f24726g = i14;
        int i15 = i14 * 2;
        this.f24727h = i15;
        this.f24728i = new short[i15];
        this.f24729j = new short[i15 * i12];
        this.f24731l = new short[i15 * i12];
        this.f24733n = new short[i15 * i12];
    }

    private void a(float f11, int i11) {
        int i12;
        int i13;
        if (this.f24732m == i11) {
            return;
        }
        int i14 = this.f24720a;
        int i15 = (int) (i14 / f11);
        while (true) {
            if (i15 <= 16384 && i14 <= 16384) {
                break;
            }
            i15 /= 2;
            i14 /= 2;
        }
        o(i11);
        int i16 = 0;
        while (true) {
            int i17 = this.f24734o;
            if (i16 >= i17 - 1) {
                u(i17 - 1);
                return;
            }
            while (true) {
                i12 = this.f24735p;
                int i18 = (i12 + 1) * i15;
                i13 = this.f24736q;
                if (i18 <= i13 * i14) {
                    break;
                }
                this.f24731l = f(this.f24731l, this.f24732m, 1);
                int i19 = 0;
                while (true) {
                    int i20 = this.f24721b;
                    if (i19 < i20) {
                        this.f24731l[(this.f24732m * i20) + i19] = n(this.f24733n, (i20 * i16) + i19, i14, i15);
                        i19++;
                    }
                }
                this.f24736q++;
                this.f24732m++;
            }
            int i21 = i12 + 1;
            this.f24735p = i21;
            if (i21 == i14) {
                this.f24735p = 0;
                com.google.android.exoplayer2.util.a.g(i13 == i15);
                this.f24736q = 0;
            }
            i16++;
        }
    }

    private void b(float f11) {
        int w11;
        int i11 = this.f24730k;
        if (i11 < this.f24727h) {
            return;
        }
        int i12 = 0;
        do {
            if (this.f24737r > 0) {
                w11 = c(i12);
            } else {
                int g11 = g(this.f24729j, i12);
                w11 = ((double) f11) > 1.0d ? g11 + w(this.f24729j, i12, f11, g11) : m(this.f24729j, i12, f11, g11);
            }
            i12 += w11;
        } while (this.f24727h + i12 <= i11);
        v(i12);
    }

    private int c(int i11) {
        int min = Math.min(this.f24727h, this.f24737r);
        d(this.f24729j, i11, min);
        this.f24737r -= min;
        return min;
    }

    private void d(short[] sArr, int i11, int i12) {
        short[] f11 = f(this.f24731l, this.f24732m, i12);
        this.f24731l = f11;
        int i13 = this.f24721b;
        System.arraycopy(sArr, i11 * i13, f11, this.f24732m * i13, i13 * i12);
        this.f24732m += i12;
    }

    private void e(short[] sArr, int i11, int i12) {
        int i13 = this.f24727h / i12;
        int i14 = this.f24721b;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.f24728i[i17] = (short) (i18 / i15);
        }
    }

    private short[] f(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.f24721b;
        int i14 = length / i13;
        return i11 + i12 <= i14 ? sArr : Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    private int g(short[] sArr, int i11) {
        int i12;
        int i13 = this.f24720a;
        int i14 = i13 > 4000 ? i13 / 4000 : 1;
        if (this.f24721b == 1 && i14 == 1) {
            i12 = h(sArr, i11, this.f24725f, this.f24726g);
        } else {
            e(sArr, i11, i14);
            int h11 = h(this.f24728i, 0, this.f24725f / i14, this.f24726g / i14);
            if (i14 != 1) {
                int i15 = h11 * i14;
                int i16 = i14 * 4;
                int i17 = i15 - i16;
                int i18 = i15 + i16;
                int i19 = this.f24725f;
                if (i17 < i19) {
                    i17 = i19;
                }
                int i20 = this.f24726g;
                if (i18 > i20) {
                    i18 = i20;
                }
                if (this.f24721b == 1) {
                    i12 = h(sArr, i11, i17, i18);
                } else {
                    e(sArr, i11, 1);
                    i12 = h(this.f24728i, 0, i17, i18);
                }
            } else {
                i12 = h11;
            }
        }
        int i21 = q(this.f24740u, this.f24741v) ? this.f24738s : i12;
        this.f24739t = this.f24740u;
        this.f24738s = i12;
        return i21;
    }

    private int h(short[] sArr, int i11, int i12, int i13) {
        int i14 = i11 * this.f24721b;
        int i15 = 255;
        int i16 = 1;
        int i17 = 0;
        int i18 = 0;
        while (i12 <= i13) {
            int i19 = 0;
            for (int i20 = 0; i20 < i12; i20++) {
                i19 += Math.abs(sArr[i14 + i20] - sArr[(i14 + i12) + i20]);
            }
            if (i19 * i17 < i16 * i12) {
                i17 = i12;
                i16 = i19;
            }
            if (i19 * i15 > i18 * i12) {
                i15 = i12;
                i18 = i19;
            }
            i12++;
        }
        this.f24740u = i16 / i17;
        this.f24741v = i18 / i15;
        return i17;
    }

    private int m(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 < 0.5f) {
            i13 = (int) ((i12 * f11) / (1.0f - f11));
        } else {
            this.f24737r = (int) ((i12 * ((2.0f * f11) - 1.0f)) / (1.0f - f11));
            i13 = i12;
        }
        int i14 = i12 + i13;
        short[] f12 = f(this.f24731l, this.f24732m, i14);
        this.f24731l = f12;
        int i15 = this.f24721b;
        System.arraycopy(sArr, i11 * i15, f12, this.f24732m * i15, i15 * i12);
        p(i13, this.f24721b, this.f24731l, this.f24732m + i12, sArr, i11 + i12, sArr, i11);
        this.f24732m += i14;
        return i13;
    }

    private short n(short[] sArr, int i11, int i12, int i13) {
        short s11 = sArr[i11];
        short s12 = sArr[i11 + this.f24721b];
        int i14 = this.f24736q * i12;
        int i15 = this.f24735p;
        int i16 = i15 * i13;
        int i17 = (i15 + 1) * i13;
        int i18 = i17 - i14;
        int i19 = i17 - i16;
        return (short) (((s11 * i18) + ((i19 - i18) * s12)) / i19);
    }

    private void o(int i11) {
        int i12 = this.f24732m - i11;
        short[] f11 = f(this.f24733n, this.f24734o, i12);
        this.f24733n = f11;
        short[] sArr = this.f24731l;
        int i13 = this.f24721b;
        System.arraycopy(sArr, i11 * i13, f11, this.f24734o * i13, i13 * i12);
        this.f24732m = i11;
        this.f24734o += i12;
    }

    private static void p(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = (i13 * i12) + i16;
            int i18 = (i15 * i12) + i16;
            int i19 = (i14 * i12) + i16;
            for (int i20 = 0; i20 < i11; i20++) {
                sArr[i17] = (short) (((sArr2[i19] * (i11 - i20)) + (sArr3[i18] * i20)) / i11);
                i17 += i12;
                i19 += i12;
                i18 += i12;
            }
        }
    }

    private boolean q(int i11, int i12) {
        return i11 != 0 && this.f24738s != 0 && i12 <= i11 * 3 && i11 * 2 > this.f24739t * 3;
    }

    private void r() {
        int i11 = this.f24732m;
        float f11 = this.f24722c;
        float f12 = this.f24723d;
        float f13 = f11 / f12;
        float f14 = this.f24724e * f12;
        double d11 = f13;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            b(f13);
        } else {
            d(this.f24729j, 0, this.f24730k);
            this.f24730k = 0;
        }
        if (f14 != 1.0f) {
            a(f14, i11);
        }
    }

    private void u(int i11) {
        if (i11 == 0) {
            return;
        }
        short[] sArr = this.f24733n;
        int i12 = this.f24721b;
        System.arraycopy(sArr, i11 * i12, sArr, 0, (this.f24734o - i11) * i12);
        this.f24734o -= i11;
    }

    private void v(int i11) {
        int i12 = this.f24730k - i11;
        short[] sArr = this.f24729j;
        int i13 = this.f24721b;
        System.arraycopy(sArr, i11 * i13, sArr, 0, i13 * i12);
        this.f24730k = i12;
    }

    private int w(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 >= 2.0f) {
            i13 = (int) (i12 / (f11 - 1.0f));
        } else {
            this.f24737r = (int) ((i12 * (2.0f - f11)) / (f11 - 1.0f));
            i13 = i12;
        }
        short[] f12 = f(this.f24731l, this.f24732m, i13);
        this.f24731l = f12;
        p(i13, this.f24721b, f12, this.f24732m, sArr, i11, sArr, i11 + i12);
        this.f24732m += i13;
        return i13;
    }

    public void i() {
        this.f24730k = 0;
        this.f24732m = 0;
        this.f24734o = 0;
        this.f24735p = 0;
        this.f24736q = 0;
        this.f24737r = 0;
        this.f24738s = 0;
        this.f24739t = 0;
        this.f24740u = 0;
        this.f24741v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f24721b, this.f24732m);
        shortBuffer.put(this.f24731l, 0, this.f24721b * min);
        int i11 = this.f24732m - min;
        this.f24732m = i11;
        short[] sArr = this.f24731l;
        int i12 = this.f24721b;
        System.arraycopy(sArr, min * i12, sArr, 0, i11 * i12);
    }

    public int k() {
        return this.f24732m * this.f24721b * 2;
    }

    public int l() {
        return this.f24730k * this.f24721b * 2;
    }

    public void s() {
        int i11;
        int i12 = this.f24730k;
        float f11 = this.f24722c;
        float f12 = this.f24723d;
        int i13 = this.f24732m + ((int) ((((i12 / (f11 / f12)) + this.f24734o) / (this.f24724e * f12)) + 0.5f));
        this.f24729j = f(this.f24729j, i12, (this.f24727h * 2) + i12);
        int i14 = 0;
        while (true) {
            i11 = this.f24727h;
            int i15 = this.f24721b;
            if (i14 >= i11 * 2 * i15) {
                break;
            }
            this.f24729j[(i15 * i12) + i14] = 0;
            i14++;
        }
        this.f24730k += i11 * 2;
        r();
        if (this.f24732m > i13) {
            this.f24732m = i13;
        }
        this.f24730k = 0;
        this.f24737r = 0;
        this.f24734o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i11 = this.f24721b;
        int i12 = remaining / i11;
        short[] f11 = f(this.f24729j, this.f24730k, i12);
        this.f24729j = f11;
        shortBuffer.get(f11, this.f24730k * this.f24721b, ((i11 * i12) * 2) / 2);
        this.f24730k += i12;
        r();
    }
}
