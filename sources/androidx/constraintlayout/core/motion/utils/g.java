package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    double[] f6864c;

    /* renamed from: d, reason: collision with root package name */
    String f6865d;

    /* renamed from: e, reason: collision with root package name */
    f f6866e;

    /* renamed from: f, reason: collision with root package name */
    int f6867f;

    /* renamed from: a, reason: collision with root package name */
    float[] f6862a = new float[0];

    /* renamed from: b, reason: collision with root package name */
    double[] f6863b = new double[0];

    /* renamed from: g, reason: collision with root package name */
    double f6868g = 6.283185307179586d;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6869h = false;

    public void a(double d11, float f11) {
        int length = this.f6862a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f6863b, d11);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f6863b = Arrays.copyOf(this.f6863b, length);
        this.f6862a = Arrays.copyOf(this.f6862a, length);
        this.f6864c = new double[length];
        double[] dArr = this.f6863b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f6863b[binarySearch] = d11;
        this.f6862a[binarySearch] = f11;
        this.f6869h = false;
    }

    double b(double d11) {
        if (d11 <= 0.0d) {
            d11 = 1.0E-5d;
        } else if (d11 >= 1.0d) {
            d11 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f6863b, d11);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i11 = -binarySearch;
        int i12 = i11 - 1;
        float[] fArr = this.f6862a;
        float f11 = fArr[i12];
        int i13 = i11 - 2;
        float f12 = fArr[i13];
        double[] dArr = this.f6863b;
        double d12 = dArr[i12];
        double d13 = dArr[i13];
        double d14 = (f11 - f12) / (d12 - d13);
        return (d11 * d14) + (f12 - (d14 * d13));
    }

    double c(double d11) {
        if (d11 < 0.0d) {
            d11 = 0.0d;
        } else if (d11 > 1.0d) {
            d11 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f6863b, d11);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i11 = -binarySearch;
        int i12 = i11 - 1;
        float[] fArr = this.f6862a;
        float f11 = fArr[i12];
        int i13 = i11 - 2;
        float f12 = fArr[i13];
        double[] dArr = this.f6863b;
        double d12 = dArr[i12];
        double d13 = dArr[i13];
        double d14 = (f11 - f12) / (d12 - d13);
        return this.f6864c[i13] + ((f12 - (d14 * d13)) * (d11 - d13)) + ((d14 * ((d11 * d11) - (d13 * d13))) / 2.0d);
    }

    public double d(double d11, double d12, double d13) {
        double c11 = d12 + c(d11);
        double b11 = b(d11) + d13;
        switch (this.f6867f) {
            case 1:
                return 0.0d;
            case 2:
                return b11 * 4.0d * Math.signum((((c11 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return b11 * 2.0d;
            case 4:
                return (-b11) * 2.0d;
            case 5:
                double d14 = this.f6868g;
                return (-d14) * b11 * Math.sin(d14 * c11);
            case 6:
                return b11 * 4.0d * ((((c11 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.f6866e.f(c11 % 1.0d, 0);
            default:
                double d15 = this.f6868g;
                return b11 * d15 * Math.cos(d15 * c11);
        }
    }

    public double e(double d11, double d12) {
        double abs;
        double c11 = c(d11) + d12;
        switch (this.f6867f) {
            case 1:
                return Math.signum(0.5d - (c11 % 1.0d));
            case 2:
                abs = Math.abs((((c11 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((c11 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((c11 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f6868g * (d12 + c11));
            case 6:
                double abs2 = 1.0d - Math.abs(((c11 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.f6866e.c(c11 % 1.0d, 0);
            default:
                return Math.sin(this.f6868g * c11);
        }
        return 1.0d - abs;
    }

    public void f() {
        double d11 = 0.0d;
        int i11 = 0;
        while (true) {
            if (i11 >= this.f6862a.length) {
                break;
            }
            d11 += r7[i11];
            i11++;
        }
        double d12 = 0.0d;
        int i12 = 1;
        while (true) {
            float[] fArr = this.f6862a;
            if (i12 >= fArr.length) {
                break;
            }
            int i13 = i12 - 1;
            float f11 = (fArr[i13] + fArr[i12]) / 2.0f;
            double[] dArr = this.f6863b;
            d12 += (dArr[i12] - dArr[i13]) * f11;
            i12++;
        }
        int i14 = 0;
        while (true) {
            float[] fArr2 = this.f6862a;
            if (i14 >= fArr2.length) {
                break;
            }
            fArr2[i14] = (float) (fArr2[i14] * (d11 / d12));
            i14++;
        }
        this.f6864c[0] = 0.0d;
        int i15 = 1;
        while (true) {
            float[] fArr3 = this.f6862a;
            if (i15 >= fArr3.length) {
                this.f6869h = true;
                return;
            }
            int i16 = i15 - 1;
            float f12 = (fArr3[i16] + fArr3[i15]) / 2.0f;
            double[] dArr2 = this.f6863b;
            double d13 = dArr2[i15] - dArr2[i16];
            double[] dArr3 = this.f6864c;
            dArr3[i15] = dArr3[i16] + (d13 * f12);
            i15++;
        }
    }

    public void g(int i11, String str) {
        this.f6867f = i11;
        this.f6865d = str;
        if (str != null) {
            this.f6866e = f.i(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f6863b) + " period=" + Arrays.toString(this.f6862a);
    }
}
