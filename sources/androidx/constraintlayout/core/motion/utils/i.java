package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    protected b f6872a;

    /* renamed from: b, reason: collision with root package name */
    protected int[] f6873b = new int[10];

    /* renamed from: c, reason: collision with root package name */
    protected float[] f6874c = new float[10];

    /* renamed from: d, reason: collision with root package name */
    private int f6875d;

    /* renamed from: e, reason: collision with root package name */
    private String f6876e;

    /* loaded from: classes.dex */
    private static class a {
        static void a(int[] iArr, float[] fArr, int i11, int i12) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i12;
            iArr2[1] = i11;
            int i13 = 2;
            while (i13 > 0) {
                int i14 = iArr2[i13 - 1];
                int i15 = i13 - 2;
                int i16 = iArr2[i15];
                if (i14 < i16) {
                    int b11 = b(iArr, fArr, i14, i16);
                    iArr2[i15] = b11 - 1;
                    iArr2[i13 - 1] = i14;
                    int i17 = i13 + 1;
                    iArr2[i13] = i16;
                    i13 += 2;
                    iArr2[i17] = b11 + 1;
                } else {
                    i13 = i15;
                }
            }
        }

        private static int b(int[] iArr, float[] fArr, int i11, int i12) {
            int i13 = iArr[i12];
            int i14 = i11;
            while (i11 < i12) {
                if (iArr[i11] <= i13) {
                    c(iArr, fArr, i14, i11);
                    i14++;
                }
                i11++;
            }
            c(iArr, fArr, i14, i12);
            return i14;
        }

        private static void c(int[] iArr, float[] fArr, int i11, int i12) {
            int i13 = iArr[i11];
            iArr[i11] = iArr[i12];
            iArr[i12] = i13;
            float f11 = fArr[i11];
            fArr[i11] = fArr[i12];
            fArr[i12] = f11;
        }
    }

    public float a(float f11) {
        return (float) this.f6872a.c(f11, 0);
    }

    public float b(float f11) {
        return (float) this.f6872a.f(f11, 0);
    }

    public void c(int i11, float f11) {
        int[] iArr = this.f6873b;
        if (iArr.length < this.f6875d + 1) {
            this.f6873b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f6874c;
            this.f6874c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f6873b;
        int i12 = this.f6875d;
        iArr2[i12] = i11;
        this.f6874c[i12] = f11;
        this.f6875d = i12 + 1;
    }

    public void d(String str) {
        this.f6876e = str;
    }

    public void e(int i11) {
        int i12;
        int i13 = this.f6875d;
        if (i13 == 0) {
            return;
        }
        a.a(this.f6873b, this.f6874c, 0, i13 - 1);
        int i14 = 1;
        for (int i15 = 1; i15 < this.f6875d; i15++) {
            int[] iArr = this.f6873b;
            if (iArr[i15 - 1] != iArr[i15]) {
                i14++;
            }
        }
        double[] dArr = new double[i14];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i14, 1);
        int i16 = 0;
        for (0; i12 < this.f6875d; i12 + 1) {
            if (i12 > 0) {
                int[] iArr2 = this.f6873b;
                i12 = iArr2[i12] == iArr2[i12 - 1] ? i12 + 1 : 0;
            }
            dArr[i16] = this.f6873b[i12] * 0.01d;
            dArr2[i16][0] = this.f6874c[i12];
            i16++;
        }
        this.f6872a = b.a(i11, dArr, dArr2);
    }

    public String toString() {
        String str = this.f6876e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i11 = 0; i11 < this.f6875d; i11++) {
            str = str + "[" + this.f6873b[i11] + " , " + decimalFormat.format(this.f6874c[i11]) + "] ";
        }
        return str;
    }
}
