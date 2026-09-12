package co;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes5.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private final int f17683a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17684b;

    /* renamed from: c, reason: collision with root package name */
    private final float f17685c;

    /* renamed from: d, reason: collision with root package name */
    private final float f17686d;

    /* renamed from: e, reason: collision with root package name */
    private float f17687e;

    /* renamed from: f, reason: collision with root package name */
    private final float f17688f;

    /* renamed from: g, reason: collision with root package name */
    private final int f17689g;

    /* renamed from: h, reason: collision with root package name */
    private final int f17690h;

    /* renamed from: i, reason: collision with root package name */
    private final int f17691i;

    /* renamed from: j, reason: collision with root package name */
    private final short[] f17692j;

    /* renamed from: k, reason: collision with root package name */
    private short[] f17693k;

    /* renamed from: l, reason: collision with root package name */
    private int f17694l;

    /* renamed from: m, reason: collision with root package name */
    private short[] f17695m;

    /* renamed from: n, reason: collision with root package name */
    private int f17696n;

    /* renamed from: o, reason: collision with root package name */
    private short[] f17697o;

    /* renamed from: p, reason: collision with root package name */
    private int f17698p;

    /* renamed from: q, reason: collision with root package name */
    private int f17699q;

    /* renamed from: r, reason: collision with root package name */
    private int f17700r;

    /* renamed from: s, reason: collision with root package name */
    private int f17701s;

    /* renamed from: t, reason: collision with root package name */
    private int f17702t;

    /* renamed from: u, reason: collision with root package name */
    private int f17703u;

    /* renamed from: v, reason: collision with root package name */
    private int f17704v;

    /* renamed from: w, reason: collision with root package name */
    private int f17705w;

    public k(int i11, int i12, float f11, float f12, float f13, int i13) {
        this.f17683a = i11;
        this.f17684b = i12;
        this.f17685c = f11;
        this.f17686d = f12;
        this.f17687e = f13;
        this.f17688f = i11 / i13;
        this.f17689g = i11 / 400;
        int i14 = i11 / 65;
        this.f17690h = i14;
        int i15 = i14 * 2;
        this.f17691i = i15;
        this.f17692j = new short[i15];
        this.f17693k = new short[i15 * i12];
        this.f17695m = new short[i15 * i12];
        this.f17697o = new short[i15 * i12];
    }

    private void a(float f11, int i11) {
        int i12;
        int i13;
        if (this.f17696n == i11) {
            return;
        }
        int i14 = this.f17683a;
        int i15 = (int) (i14 / f11);
        while (true) {
            if (i15 <= 16384 && i14 <= 16384) {
                break;
            }
            i15 /= 2;
            i14 /= 2;
        }
        n(i11);
        int i16 = 0;
        while (true) {
            int i17 = this.f17698p;
            if (i16 >= i17 - 1) {
                t(i17 - 1);
                return;
            }
            while (true) {
                i12 = this.f17699q;
                int i18 = (i12 + 1) * i15;
                i13 = this.f17700r;
                if (i18 <= i13 * i14) {
                    break;
                }
                this.f17695m = f(this.f17695m, this.f17696n, 1);
                int i19 = 0;
                while (true) {
                    int i20 = this.f17684b;
                    if (i19 < i20) {
                        this.f17695m[(this.f17696n * i20) + i19] = m(this.f17697o, (i20 * i16) + i19, i14, i15);
                        i19++;
                    }
                }
                this.f17700r++;
                this.f17696n++;
            }
            int i21 = i12 + 1;
            this.f17699q = i21;
            if (i21 == i14) {
                this.f17699q = 0;
                androidx.media3.common.util.a.g(i13 == i15);
                this.f17700r = 0;
            }
            i16++;
        }
    }

    private void b(float f11) {
        int x10;
        int i11 = this.f17694l;
        if (i11 < this.f17691i) {
            return;
        }
        int i12 = 0;
        do {
            if (this.f17701s > 0) {
                x10 = c(i12);
            } else {
                int g11 = g(this.f17693k, i12);
                x10 = ((double) f11) > 1.0d ? g11 + x(this.f17693k, i12, f11, g11) : l(this.f17693k, i12, f11, g11);
            }
            i12 += x10;
        } while (this.f17691i + i12 <= i11);
        u(i12);
    }

    private int c(int i11) {
        int min = Math.min(this.f17691i, this.f17701s);
        d(this.f17693k, i11, min);
        this.f17701s -= min;
        return min;
    }

    private void d(short[] sArr, int i11, int i12) {
        short[] f11 = f(this.f17695m, this.f17696n, i12);
        this.f17695m = f11;
        int i13 = this.f17684b;
        System.arraycopy(sArr, i11 * i13, f11, this.f17696n * i13, i13 * i12);
        this.f17696n += i12;
    }

    private void e(short[] sArr, int i11, int i12) {
        int i13 = this.f17691i / i12;
        int i14 = this.f17684b;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.f17692j[i17] = (short) (i18 / i15);
        }
    }

    private short[] f(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.f17684b;
        int i14 = length / i13;
        return i11 + i12 <= i14 ? sArr : Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    private int g(short[] sArr, int i11) {
        int i12;
        int i13 = this.f17683a;
        int i14 = i13 > 4000 ? i13 / 4000 : 1;
        if (this.f17684b == 1 && i14 == 1) {
            i12 = h(sArr, i11, this.f17689g, this.f17690h);
        } else {
            e(sArr, i11, i14);
            int h11 = h(this.f17692j, 0, this.f17689g / i14, this.f17690h / i14);
            if (i14 != 1) {
                int i15 = h11 * i14;
                int i16 = i14 * 4;
                int i17 = i15 - i16;
                int i18 = i15 + i16;
                int i19 = this.f17689g;
                if (i17 < i19) {
                    i17 = i19;
                }
                int i20 = this.f17690h;
                if (i18 > i20) {
                    i18 = i20;
                }
                if (this.f17684b == 1) {
                    i12 = h(sArr, i11, i17, i18);
                } else {
                    e(sArr, i11, 1);
                    i12 = h(this.f17692j, 0, i17, i18);
                }
            } else {
                i12 = h11;
            }
        }
        int i21 = p(this.f17704v, this.f17705w) ? this.f17702t : i12;
        this.f17703u = this.f17704v;
        this.f17702t = i12;
        return i21;
    }

    private int h(short[] sArr, int i11, int i12, int i13) {
        int i14 = i11 * this.f17684b;
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
        this.f17704v = i16 / i17;
        this.f17705w = i18 / i15;
        return i17;
    }

    private int l(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 < 0.5f) {
            i13 = (int) ((i12 * f11) / (1.0f - f11));
        } else {
            this.f17701s = (int) ((i12 * ((2.0f * f11) - 1.0f)) / (1.0f - f11));
            i13 = i12;
        }
        int i14 = i12 + i13;
        short[] f12 = f(this.f17695m, this.f17696n, i14);
        this.f17695m = f12;
        int i15 = this.f17684b;
        System.arraycopy(sArr, i11 * i15, f12, this.f17696n * i15, i15 * i12);
        o(i13, this.f17684b, this.f17695m, this.f17696n + i12, sArr, i11 + i12, sArr, i11);
        this.f17696n += i14;
        return i13;
    }

    private short m(short[] sArr, int i11, int i12, int i13) {
        short s11 = sArr[i11];
        short s12 = sArr[i11 + this.f17684b];
        int i14 = this.f17700r * i12;
        int i15 = this.f17699q;
        int i16 = i15 * i13;
        int i17 = (i15 + 1) * i13;
        int i18 = i17 - i14;
        int i19 = i17 - i16;
        return (short) (((s11 * i18) + ((i19 - i18) * s12)) / i19);
    }

    private void n(int i11) {
        int i12 = this.f17696n - i11;
        short[] f11 = f(this.f17697o, this.f17698p, i12);
        this.f17697o = f11;
        short[] sArr = this.f17695m;
        int i13 = this.f17684b;
        System.arraycopy(sArr, i11 * i13, f11, this.f17698p * i13, i13 * i12);
        this.f17696n = i11;
        this.f17698p += i12;
    }

    private static void o(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
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

    private boolean p(int i11, int i12) {
        return i11 != 0 && this.f17702t != 0 && i12 <= i11 * 3 && i11 * 2 > this.f17703u * 3;
    }

    private void q() {
        int i11 = this.f17696n;
        float f11 = this.f17685c;
        float f12 = this.f17686d;
        float f13 = f11 / f12;
        float f14 = this.f17688f * f12;
        double d11 = f13;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            b(f13);
        } else {
            d(this.f17693k, 0, this.f17694l);
            this.f17694l = 0;
        }
        if (f14 != 1.0f) {
            a(f14, i11);
        }
        float f15 = this.f17687e;
        if (f15 != 1.0f) {
            v(this.f17695m, i11, this.f17696n - i11, f15);
        }
    }

    private void t(int i11) {
        if (i11 == 0) {
            return;
        }
        short[] sArr = this.f17697o;
        int i12 = this.f17684b;
        System.arraycopy(sArr, i11 * i12, sArr, 0, (this.f17698p - i11) * i12);
        this.f17698p -= i11;
    }

    private void u(int i11) {
        int i12 = this.f17694l - i11;
        short[] sArr = this.f17693k;
        int i13 = this.f17684b;
        System.arraycopy(sArr, i11 * i13, sArr, 0, i13 * i12);
        this.f17694l = i12;
    }

    private void v(short[] sArr, int i11, int i12, float f11) {
        int i13 = (int) (f11 * 4096.0f);
        int i14 = this.f17684b;
        int i15 = i11 * i14;
        int i16 = (i12 * i14) + i15;
        while (i15 < i16) {
            int i17 = (sArr[i15] * i13) >> 12;
            int i18 = 32767;
            if (i17 <= 32767) {
                i18 = -32767;
                if (i17 >= -32767) {
                    sArr[i15] = (short) i17;
                    i15++;
                }
            }
            i17 = i18;
            sArr[i15] = (short) i17;
            i15++;
        }
    }

    private int x(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 >= 2.0f) {
            i13 = (int) (i12 / (f11 - 1.0f));
        } else {
            this.f17701s = (int) ((i12 * (2.0f - f11)) / (f11 - 1.0f));
            i13 = i12;
        }
        short[] f12 = f(this.f17695m, this.f17696n, i13);
        this.f17695m = f12;
        o(i13, this.f17684b, f12, this.f17696n, sArr, i11, sArr, i11 + i12);
        this.f17696n += i13;
        return i13;
    }

    public void i() {
        this.f17694l = 0;
        this.f17696n = 0;
        this.f17698p = 0;
        this.f17699q = 0;
        this.f17700r = 0;
        this.f17701s = 0;
        this.f17702t = 0;
        this.f17703u = 0;
        this.f17704v = 0;
        this.f17705w = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f17684b, this.f17696n);
        shortBuffer.put(this.f17695m, 0, this.f17684b * min);
        int i11 = this.f17696n - min;
        this.f17696n = i11;
        short[] sArr = this.f17695m;
        int i12 = this.f17684b;
        System.arraycopy(sArr, min * i12, sArr, 0, i11 * i12);
    }

    public int k() {
        return this.f17696n * this.f17684b * 2;
    }

    public void r() {
        int i11;
        int i12 = this.f17694l;
        float f11 = this.f17685c;
        float f12 = this.f17686d;
        int i13 = this.f17696n + ((int) ((((i12 / (f11 / f12)) + this.f17698p) / (this.f17688f * f12)) + 0.5f));
        this.f17693k = f(this.f17693k, i12, (this.f17691i * 2) + i12);
        int i14 = 0;
        while (true) {
            i11 = this.f17691i;
            int i15 = this.f17684b;
            if (i14 >= i11 * 2 * i15) {
                break;
            }
            this.f17693k[(i15 * i12) + i14] = 0;
            i14++;
        }
        this.f17694l += i11 * 2;
        q();
        if (this.f17696n > i13) {
            this.f17696n = i13;
        }
        this.f17694l = 0;
        this.f17701s = 0;
        this.f17698p = 0;
    }

    public void s(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i11 = this.f17684b;
        int i12 = remaining / i11;
        short[] f11 = f(this.f17693k, this.f17694l, i12);
        this.f17693k = f11;
        shortBuffer.get(f11, this.f17694l * this.f17684b, ((i11 * i12) * 2) / 2);
        this.f17694l += i12;
        q();
    }

    public void w(float f11) {
        this.f17687e = f11;
    }
}
