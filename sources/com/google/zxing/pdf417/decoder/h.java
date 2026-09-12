package com.google.zxing.pdf417.decoder;

import java.lang.reflect.Array;

/* loaded from: classes4.dex */
abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final float[][] f33033a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, td.a.f76307b.length, 8);

    static {
        int i11;
        int i12 = 0;
        while (true) {
            int[] iArr = td.a.f76307b;
            if (i12 >= iArr.length) {
                return;
            }
            int i13 = iArr[i12];
            int i14 = i13 & 1;
            int i15 = 0;
            while (i15 < 8) {
                float f11 = 0.0f;
                while (true) {
                    i11 = i13 & 1;
                    if (i11 == i14) {
                        f11 += 1.0f;
                        i13 >>= 1;
                    }
                }
                f33033a[i12][7 - i15] = f11 / 17.0f;
                i15++;
                i14 = i11;
            }
            i12++;
        }
    }

    private static int a(int[] iArr) {
        long j11 = 0;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            for (int i12 = 0; i12 < iArr[i11]; i12++) {
                int i13 = 1;
                long j12 = j11 << 1;
                if (i11 % 2 != 0) {
                    i13 = 0;
                }
                j11 = j12 | i13;
            }
        }
        return (int) j11;
    }

    private static int b(int[] iArr) {
        int d11 = jd.a.d(iArr);
        float[] fArr = new float[8];
        if (d11 > 1) {
            for (int i11 = 0; i11 < 8; i11++) {
                fArr[i11] = iArr[i11] / d11;
            }
        }
        float f11 = Float.MAX_VALUE;
        int i12 = -1;
        int i13 = 0;
        while (true) {
            float[][] fArr2 = f33033a;
            if (i13 >= fArr2.length) {
                return i12;
            }
            float[] fArr3 = fArr2[i13];
            float f12 = 0.0f;
            for (int i14 = 0; i14 < 8; i14++) {
                float f13 = fArr3[i14] - fArr[i14];
                f12 += f13 * f13;
                if (f12 >= f11) {
                    break;
                }
            }
            if (f12 < f11) {
                i12 = td.a.f76307b[i13];
                f11 = f12;
            }
            i13++;
        }
    }

    private static int c(int[] iArr) {
        int a11 = a(iArr);
        if (td.a.a(a11) == -1) {
            return -1;
        }
        return a11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int[] iArr) {
        int c11 = c(e(iArr));
        return c11 != -1 ? c11 : b(iArr);
    }

    private static int[] e(int[] iArr) {
        float d11 = jd.a.d(iArr);
        int[] iArr2 = new int[8];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 17; i13++) {
            float f11 = (d11 / 34.0f) + ((i13 * d11) / 17.0f);
            int i14 = iArr[i12];
            if (i11 + i14 <= f11) {
                i11 += i14;
                i12++;
            }
            iArr2[i12] = iArr2[i12] + 1;
        }
        return iArr2;
    }
}
