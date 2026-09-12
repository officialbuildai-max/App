package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: k, reason: collision with root package name */
    protected static float f6904k = 6.2831855f;

    /* renamed from: a, reason: collision with root package name */
    protected b f6905a;

    /* renamed from: e, reason: collision with root package name */
    protected int f6909e;

    /* renamed from: f, reason: collision with root package name */
    protected String f6910f;

    /* renamed from: i, reason: collision with root package name */
    protected long f6913i;

    /* renamed from: b, reason: collision with root package name */
    protected int f6906b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected int[] f6907c = new int[10];

    /* renamed from: d, reason: collision with root package name */
    protected float[][] f6908d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);

    /* renamed from: g, reason: collision with root package name */
    protected float[] f6911g = new float[3];

    /* renamed from: h, reason: collision with root package name */
    protected boolean f6912h = false;

    /* renamed from: j, reason: collision with root package name */
    protected float f6914j = Float.NaN;

    /* loaded from: classes.dex */
    protected static class a {
        static void a(int[] iArr, float[][] fArr, int i11, int i12) {
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

        private static int b(int[] iArr, float[][] fArr, int i11, int i12) {
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

        private static void c(int[] iArr, float[][] fArr, int i11, int i12) {
            int i13 = iArr[i11];
            iArr[i11] = iArr[i12];
            iArr[i12] = i13;
            float[] fArr2 = fArr[i11];
            fArr[i11] = fArr[i12];
            fArr[i12] = fArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float a(float f11) {
        float abs;
        switch (this.f6906b) {
            case 1:
                return Math.signum(f11 * f6904k);
            case 2:
                abs = Math.abs(f11);
                break;
            case 3:
                return (((f11 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f11 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f11 * f6904k);
            case 6:
                float abs2 = 1.0f - Math.abs(((f11 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f11 * f6904k);
        }
        return 1.0f - abs;
    }

    public void b(int i11, float f11, float f12, int i12, float f13) {
        int[] iArr = this.f6907c;
        int i13 = this.f6909e;
        iArr[i13] = i11;
        float[] fArr = this.f6908d[i13];
        fArr[0] = f11;
        fArr[1] = f12;
        fArr[2] = f13;
        this.f6906b = Math.max(this.f6906b, i12);
        this.f6909e++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(long j11) {
        this.f6913i = j11;
    }

    public void d(String str) {
        this.f6910f = str;
    }

    public void e(int i11) {
        int i12;
        int i13 = this.f6909e;
        if (i13 == 0) {
            System.err.println("Error no points added to " + this.f6910f);
            return;
        }
        a.a(this.f6907c, this.f6908d, 0, i13 - 1);
        int i14 = 1;
        int i15 = 0;
        while (true) {
            int[] iArr = this.f6907c;
            if (i14 >= iArr.length) {
                break;
            }
            if (iArr[i14] != iArr[i14 - 1]) {
                i15++;
            }
            i14++;
        }
        if (i15 == 0) {
            i15 = 1;
        }
        double[] dArr = new double[i15];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i15, 3);
        int i16 = 0;
        for (0; i12 < this.f6909e; i12 + 1) {
            if (i12 > 0) {
                int[] iArr2 = this.f6907c;
                i12 = iArr2[i12] == iArr2[i12 - 1] ? i12 + 1 : 0;
            }
            dArr[i16] = this.f6907c[i12] * 0.01d;
            double[] dArr3 = dArr2[i16];
            float[] fArr = this.f6908d[i12];
            dArr3[0] = fArr[0];
            dArr3[1] = fArr[1];
            dArr3[2] = fArr[2];
            i16++;
        }
        this.f6905a = b.a(i11, dArr, dArr2);
    }

    public String toString() {
        String str = this.f6910f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i11 = 0; i11 < this.f6909e; i11++) {
            str = str + "[" + this.f6907c[i11] + " , " + decimalFormat.format(this.f6908d[i11]) + "] ";
        }
        return str;
    }
}
