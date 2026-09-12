package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class e extends b {

    /* renamed from: a, reason: collision with root package name */
    private double[] f6852a;

    /* renamed from: b, reason: collision with root package name */
    private double[][] f6853b;

    /* renamed from: c, reason: collision with root package name */
    private double f6854c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6855d = true;

    /* renamed from: e, reason: collision with root package name */
    double[] f6856e;

    public e(double[] dArr, double[][] dArr2) {
        this.f6854c = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f6856e = new double[length2];
        this.f6852a = dArr;
        this.f6853b = dArr2;
        if (length2 <= 2) {
            return;
        }
        int i11 = 0;
        double d11 = 0.0d;
        while (true) {
            double d12 = d11;
            if (i11 >= dArr.length) {
                this.f6854c = 0.0d;
                return;
            }
            double d13 = dArr2[i11][0];
            if (i11 > 0) {
                Math.hypot(d13 - d11, d13 - d12);
            }
            i11++;
            d11 = d13;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double c(double d11, int i11) {
        double d12;
        double d13;
        double f11;
        double[] dArr = this.f6852a;
        int length = dArr.length;
        int i12 = 0;
        if (this.f6855d) {
            double d14 = dArr[0];
            if (d11 <= d14) {
                d12 = this.f6853b[0][i11];
                d13 = d11 - d14;
                f11 = f(d14, i11);
            } else {
                int i13 = length - 1;
                double d15 = dArr[i13];
                if (d11 >= d15) {
                    d12 = this.f6853b[i13][i11];
                    d13 = d11 - d15;
                    f11 = f(d15, i11);
                }
            }
            return d12 + (d13 * f11);
        }
        if (d11 <= dArr[0]) {
            return this.f6853b[0][i11];
        }
        int i14 = length - 1;
        if (d11 >= dArr[i14]) {
            return this.f6853b[i14][i11];
        }
        while (i12 < length - 1) {
            double[] dArr2 = this.f6852a;
            double d16 = dArr2[i12];
            if (d11 == d16) {
                return this.f6853b[i12][i11];
            }
            int i15 = i12 + 1;
            double d17 = dArr2[i15];
            if (d11 < d17) {
                double d18 = (d11 - d16) / (d17 - d16);
                double[][] dArr3 = this.f6853b;
                return (dArr3[i12][i11] * (1.0d - d18)) + (dArr3[i15][i11] * d18);
            }
            i12 = i15;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void d(double d11, double[] dArr) {
        double[] dArr2 = this.f6852a;
        int length = dArr2.length;
        int i11 = 0;
        int length2 = this.f6853b[0].length;
        if (this.f6855d) {
            double d12 = dArr2[0];
            if (d11 <= d12) {
                g(d12, this.f6856e);
                for (int i12 = 0; i12 < length2; i12++) {
                    dArr[i12] = this.f6853b[0][i12] + ((d11 - this.f6852a[0]) * this.f6856e[i12]);
                }
                return;
            }
            int i13 = length - 1;
            double d13 = dArr2[i13];
            if (d11 >= d13) {
                g(d13, this.f6856e);
                while (i11 < length2) {
                    dArr[i11] = this.f6853b[i13][i11] + ((d11 - this.f6852a[i13]) * this.f6856e[i11]);
                    i11++;
                }
                return;
            }
        } else {
            if (d11 <= dArr2[0]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    dArr[i14] = this.f6853b[0][i14];
                }
                return;
            }
            int i15 = length - 1;
            if (d11 >= dArr2[i15]) {
                while (i11 < length2) {
                    dArr[i11] = this.f6853b[i15][i11];
                    i11++;
                }
                return;
            }
        }
        int i16 = 0;
        while (i16 < length - 1) {
            if (d11 == this.f6852a[i16]) {
                for (int i17 = 0; i17 < length2; i17++) {
                    dArr[i17] = this.f6853b[i16][i17];
                }
            }
            double[] dArr3 = this.f6852a;
            int i18 = i16 + 1;
            double d14 = dArr3[i18];
            if (d11 < d14) {
                double d15 = dArr3[i16];
                double d16 = (d11 - d15) / (d14 - d15);
                while (i11 < length2) {
                    double[][] dArr4 = this.f6853b;
                    dArr[i11] = (dArr4[i16][i11] * (1.0d - d16)) + (dArr4[i18][i11] * d16);
                    i11++;
                }
                return;
            }
            i16 = i18;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void e(double d11, float[] fArr) {
        double[] dArr = this.f6852a;
        int length = dArr.length;
        int i11 = 0;
        int length2 = this.f6853b[0].length;
        if (this.f6855d) {
            double d12 = dArr[0];
            if (d11 <= d12) {
                g(d12, this.f6856e);
                for (int i12 = 0; i12 < length2; i12++) {
                    fArr[i12] = (float) (this.f6853b[0][i12] + ((d11 - this.f6852a[0]) * this.f6856e[i12]));
                }
                return;
            }
            int i13 = length - 1;
            double d13 = dArr[i13];
            if (d11 >= d13) {
                g(d13, this.f6856e);
                while (i11 < length2) {
                    fArr[i11] = (float) (this.f6853b[i13][i11] + ((d11 - this.f6852a[i13]) * this.f6856e[i11]));
                    i11++;
                }
                return;
            }
        } else {
            if (d11 <= dArr[0]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    fArr[i14] = (float) this.f6853b[0][i14];
                }
                return;
            }
            int i15 = length - 1;
            if (d11 >= dArr[i15]) {
                while (i11 < length2) {
                    fArr[i11] = (float) this.f6853b[i15][i11];
                    i11++;
                }
                return;
            }
        }
        int i16 = 0;
        while (i16 < length - 1) {
            if (d11 == this.f6852a[i16]) {
                for (int i17 = 0; i17 < length2; i17++) {
                    fArr[i17] = (float) this.f6853b[i16][i17];
                }
            }
            double[] dArr2 = this.f6852a;
            int i18 = i16 + 1;
            double d14 = dArr2[i18];
            if (d11 < d14) {
                double d15 = dArr2[i16];
                double d16 = (d11 - d15) / (d14 - d15);
                while (i11 < length2) {
                    double[][] dArr3 = this.f6853b;
                    fArr[i11] = (float) ((dArr3[i16][i11] * (1.0d - d16)) + (dArr3[i18][i11] * d16));
                    i11++;
                }
                return;
            }
            i16 = i18;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0012, code lost:
    
        if (r8 >= r3) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double f(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.f6852a
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r8 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            int r0 = r1 + (-1)
            if (r2 >= r0) goto L35
            double[] r0 = r7.f6852a
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L33
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.f6853b
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r9 = r8[r10]
            double r9 = r9 - r0
            double r9 = r9 / r4
            return r9
        L33:
            r2 = r3
            goto L15
        L35:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.e.f(double, int):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
    
        if (r13 >= r4) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.f6852a
            int r1 = r0.length
            double[][] r2 = r12.f6853b
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r13 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = r3
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L41
            double[] r4 = r12.f6852a
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L3f
            r13 = r4[r0]
            double r6 = r6 - r13
        L2c:
            if (r3 >= r2) goto L41
            double[][] r13 = r12.f6853b
            r14 = r13[r0]
            r8 = r14[r3]
            r13 = r13[r5]
            r10 = r13[r3]
            double r10 = r10 - r8
            double r10 = r10 / r6
            r15[r3] = r10
            int r3 = r3 + 1
            goto L2c
        L3f:
            r0 = r5
            goto L1b
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.e.g(double, double[]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double[] h() {
        return this.f6852a;
    }
}
