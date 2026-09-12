package androidx.media3.common.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f9916a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9917b;

    /* renamed from: c, reason: collision with root package name */
    private final float f9918c;

    /* renamed from: d, reason: collision with root package name */
    private final float f9919d;

    /* renamed from: e, reason: collision with root package name */
    private final float f9920e;

    /* renamed from: f, reason: collision with root package name */
    private final int f9921f;

    /* renamed from: g, reason: collision with root package name */
    private final int f9922g;

    /* renamed from: h, reason: collision with root package name */
    private final int f9923h;

    /* renamed from: i, reason: collision with root package name */
    private final short[] f9924i;

    /* renamed from: j, reason: collision with root package name */
    private short[] f9925j;

    /* renamed from: k, reason: collision with root package name */
    private int f9926k;

    /* renamed from: l, reason: collision with root package name */
    private short[] f9927l;

    /* renamed from: m, reason: collision with root package name */
    private int f9928m;

    /* renamed from: n, reason: collision with root package name */
    private short[] f9929n;

    /* renamed from: o, reason: collision with root package name */
    private int f9930o;

    /* renamed from: p, reason: collision with root package name */
    private int f9931p;

    /* renamed from: q, reason: collision with root package name */
    private int f9932q;

    /* renamed from: r, reason: collision with root package name */
    private int f9933r;

    /* renamed from: s, reason: collision with root package name */
    private int f9934s;

    /* renamed from: t, reason: collision with root package name */
    private int f9935t;

    /* renamed from: u, reason: collision with root package name */
    private int f9936u;

    /* renamed from: v, reason: collision with root package name */
    private int f9937v;

    /* renamed from: w, reason: collision with root package name */
    private double f9938w;

    public c(int i11, int i12, float f11, float f12, int i13) {
        this.f9916a = i11;
        this.f9917b = i12;
        this.f9918c = f11;
        this.f9919d = f12;
        this.f9920e = i11 / i13;
        this.f9921f = i11 / 400;
        int i14 = i11 / 65;
        this.f9922g = i14;
        int i15 = i14 * 2;
        this.f9923h = i15;
        this.f9924i = new short[i15];
        this.f9925j = new short[i15 * i12];
        this.f9927l = new short[i15 * i12];
        this.f9929n = new short[i15 * i12];
    }

    private void a(float f11, int i11) {
        int i12;
        int i13;
        if (this.f9928m == i11) {
            return;
        }
        int i14 = this.f9916a;
        long j11 = i14 / f11;
        long j12 = i14;
        while (j11 != 0 && j12 != 0 && j11 % 2 == 0 && j12 % 2 == 0) {
            j11 /= 2;
            j12 /= 2;
        }
        o(i11);
        int i15 = 0;
        while (true) {
            int i16 = this.f9930o;
            if (i15 >= i16 - 1) {
                u(i16 - 1);
                return;
            }
            while (true) {
                i12 = this.f9931p;
                long j13 = (i12 + 1) * j11;
                i13 = this.f9932q;
                if (j13 <= i13 * j12) {
                    break;
                }
                this.f9927l = f(this.f9927l, this.f9928m, 1);
                int i17 = 0;
                while (true) {
                    int i18 = this.f9917b;
                    if (i17 < i18) {
                        this.f9927l[(this.f9928m * i18) + i17] = n(this.f9929n, (i18 * i15) + i17, j12, j11);
                        i17++;
                    }
                }
                this.f9932q++;
                this.f9928m++;
            }
            int i19 = i12 + 1;
            this.f9931p = i19;
            if (i19 == j12) {
                this.f9931p = 0;
                androidx.media3.common.util.a.g(((long) i13) == j11);
                this.f9932q = 0;
            }
            i15++;
        }
    }

    private void b(double d11) {
        int m11;
        int i11 = this.f9926k;
        if (i11 < this.f9923h) {
            return;
        }
        int i12 = 0;
        do {
            if (this.f9933r > 0) {
                m11 = c(i12);
            } else {
                int g11 = g(this.f9925j, i12);
                if (d11 > 1.0d) {
                    i12 += g11 + w(this.f9925j, i12, d11, g11);
                } else {
                    m11 = m(this.f9925j, i12, d11, g11);
                }
            }
            i12 += m11;
        } while (this.f9923h + i12 <= i11);
        v(i12);
    }

    private int c(int i11) {
        int min = Math.min(this.f9923h, this.f9933r);
        d(this.f9925j, i11, min);
        this.f9933r -= min;
        return min;
    }

    private void d(short[] sArr, int i11, int i12) {
        short[] f11 = f(this.f9927l, this.f9928m, i12);
        this.f9927l = f11;
        int i13 = this.f9917b;
        System.arraycopy(sArr, i11 * i13, f11, this.f9928m * i13, i13 * i12);
        this.f9928m += i12;
    }

    private void e(short[] sArr, int i11, int i12) {
        int i13 = this.f9923h / i12;
        int i14 = this.f9917b;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.f9924i[i17] = (short) (i18 / i15);
        }
    }

    private short[] f(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.f9917b;
        int i14 = length / i13;
        return i11 + i12 <= i14 ? sArr : Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    private int g(short[] sArr, int i11) {
        int i12;
        int i13 = this.f9916a;
        int i14 = i13 > 4000 ? i13 / 4000 : 1;
        if (this.f9917b == 1 && i14 == 1) {
            i12 = h(sArr, i11, this.f9921f, this.f9922g);
        } else {
            e(sArr, i11, i14);
            int h11 = h(this.f9924i, 0, this.f9921f / i14, this.f9922g / i14);
            if (i14 != 1) {
                int i15 = h11 * i14;
                int i16 = i14 * 4;
                int i17 = i15 - i16;
                int i18 = i15 + i16;
                int i19 = this.f9921f;
                if (i17 < i19) {
                    i17 = i19;
                }
                int i20 = this.f9922g;
                if (i18 > i20) {
                    i18 = i20;
                }
                if (this.f9917b == 1) {
                    i12 = h(sArr, i11, i17, i18);
                } else {
                    e(sArr, i11, 1);
                    i12 = h(this.f9924i, 0, i17, i18);
                }
            } else {
                i12 = h11;
            }
        }
        int i21 = q(this.f9936u, this.f9937v) ? this.f9934s : i12;
        this.f9935t = this.f9936u;
        this.f9934s = i12;
        return i21;
    }

    private int h(short[] sArr, int i11, int i12, int i13) {
        int i14 = i11 * this.f9917b;
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
        this.f9936u = i16 / i17;
        this.f9937v = i18 / i15;
        return i17;
    }

    private int m(short[] sArr, int i11, double d11, int i12) {
        int i13;
        if (d11 < 0.5d) {
            double d12 = ((i12 * d11) / (1.0d - d11)) + this.f9938w;
            i13 = (int) Math.round(d12);
            this.f9938w = d12 - i13;
        } else {
            double d13 = ((i12 * ((2.0d * d11) - 1.0d)) / (1.0d - d11)) + this.f9938w;
            int round = (int) Math.round(d13);
            this.f9933r = round;
            this.f9938w = d13 - round;
            i13 = i12;
        }
        int i14 = i12 + i13;
        short[] f11 = f(this.f9927l, this.f9928m, i14);
        this.f9927l = f11;
        int i15 = this.f9917b;
        System.arraycopy(sArr, i11 * i15, f11, this.f9928m * i15, i15 * i12);
        p(i13, this.f9917b, this.f9927l, this.f9928m + i12, sArr, i11 + i12, sArr, i11);
        this.f9928m += i14;
        return i13;
    }

    private short n(short[] sArr, int i11, long j11, long j12) {
        short s11 = sArr[i11];
        short s12 = sArr[i11 + this.f9917b];
        long j13 = this.f9932q * j11;
        long j14 = this.f9931p * j12;
        long j15 = (r7 + 1) * j12;
        long j16 = j15 - j13;
        long j17 = j15 - j14;
        return (short) (((s11 * j16) + ((j17 - j16) * s12)) / j17);
    }

    private void o(int i11) {
        int i12 = this.f9928m - i11;
        short[] f11 = f(this.f9929n, this.f9930o, i12);
        this.f9929n = f11;
        short[] sArr = this.f9927l;
        int i13 = this.f9917b;
        System.arraycopy(sArr, i11 * i13, f11, this.f9930o * i13, i13 * i12);
        this.f9928m = i11;
        this.f9930o += i12;
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
        return i11 != 0 && this.f9934s != 0 && i12 <= i11 * 3 && i11 * 2 > this.f9935t * 3;
    }

    private void r() {
        int i11 = this.f9928m;
        float f11 = this.f9918c;
        float f12 = this.f9919d;
        double d11 = f11 / f12;
        float f13 = this.f9920e * f12;
        if (d11 > 1.0000100135803223d || d11 < 0.9999899864196777d) {
            b(d11);
        } else {
            d(this.f9925j, 0, this.f9926k);
            this.f9926k = 0;
        }
        if (f13 != 1.0f) {
            a(f13, i11);
        }
    }

    private void u(int i11) {
        if (i11 == 0) {
            return;
        }
        short[] sArr = this.f9929n;
        int i12 = this.f9917b;
        System.arraycopy(sArr, i11 * i12, sArr, 0, (this.f9930o - i11) * i12);
        this.f9930o -= i11;
    }

    private void v(int i11) {
        int i12 = this.f9926k - i11;
        short[] sArr = this.f9925j;
        int i13 = this.f9917b;
        System.arraycopy(sArr, i11 * i13, sArr, 0, i13 * i12);
        this.f9926k = i12;
    }

    private int w(short[] sArr, int i11, double d11, int i12) {
        int i13;
        if (d11 >= 2.0d) {
            double d12 = (i12 / (d11 - 1.0d)) + this.f9938w;
            i13 = (int) Math.round(d12);
            this.f9938w = d12 - i13;
        } else {
            double d13 = ((i12 * (2.0d - d11)) / (d11 - 1.0d)) + this.f9938w;
            int round = (int) Math.round(d13);
            this.f9933r = round;
            this.f9938w = d13 - round;
            i13 = i12;
        }
        short[] f11 = f(this.f9927l, this.f9928m, i13);
        this.f9927l = f11;
        p(i13, this.f9917b, f11, this.f9928m, sArr, i11, sArr, i11 + i12);
        this.f9928m += i13;
        return i13;
    }

    public void i() {
        this.f9926k = 0;
        this.f9928m = 0;
        this.f9930o = 0;
        this.f9931p = 0;
        this.f9932q = 0;
        this.f9933r = 0;
        this.f9934s = 0;
        this.f9935t = 0;
        this.f9936u = 0;
        this.f9937v = 0;
        this.f9938w = 0.0d;
    }

    public void j(ShortBuffer shortBuffer) {
        androidx.media3.common.util.a.g(this.f9928m >= 0);
        int min = Math.min(shortBuffer.remaining() / this.f9917b, this.f9928m);
        shortBuffer.put(this.f9927l, 0, this.f9917b * min);
        int i11 = this.f9928m - min;
        this.f9928m = i11;
        short[] sArr = this.f9927l;
        int i12 = this.f9917b;
        System.arraycopy(sArr, min * i12, sArr, 0, i11 * i12);
    }

    public int k() {
        androidx.media3.common.util.a.g(this.f9928m >= 0);
        return this.f9928m * this.f9917b * 2;
    }

    public int l() {
        return this.f9926k * this.f9917b * 2;
    }

    public void s() {
        int i11;
        int i12 = this.f9926k;
        float f11 = this.f9918c;
        float f12 = this.f9919d;
        double d11 = f11 / f12;
        int i13 = this.f9928m + ((int) (((((((i12 - r5) / d11) + this.f9933r) + this.f9938w) + this.f9930o) / (this.f9920e * f12)) + 0.5d));
        this.f9938w = 0.0d;
        this.f9925j = f(this.f9925j, i12, (this.f9923h * 2) + i12);
        int i14 = 0;
        while (true) {
            i11 = this.f9923h;
            int i15 = this.f9917b;
            if (i14 >= i11 * 2 * i15) {
                break;
            }
            this.f9925j[(i15 * i12) + i14] = 0;
            i14++;
        }
        this.f9926k += i11 * 2;
        r();
        if (this.f9928m > i13) {
            this.f9928m = Math.max(i13, 0);
        }
        this.f9926k = 0;
        this.f9933r = 0;
        this.f9930o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i11 = this.f9917b;
        int i12 = remaining / i11;
        short[] f11 = f(this.f9925j, this.f9926k, i12);
        this.f9925j = f11;
        shortBuffer.get(f11, this.f9926k * this.f9917b, ((i11 * i12) * 2) / 2);
        this.f9926k += i12;
        r();
    }
}
