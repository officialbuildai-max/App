package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private final double[] f6818a;

    /* renamed from: b, reason: collision with root package name */
    C0059a[] f6819b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6820c = true;

    /* renamed from: androidx.constraintlayout.core.motion.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0059a {

        /* renamed from: s, reason: collision with root package name */
        private static double[] f6821s = new double[91];

        /* renamed from: a, reason: collision with root package name */
        double[] f6822a;

        /* renamed from: b, reason: collision with root package name */
        double f6823b;

        /* renamed from: c, reason: collision with root package name */
        double f6824c;

        /* renamed from: d, reason: collision with root package name */
        double f6825d;

        /* renamed from: e, reason: collision with root package name */
        double f6826e;

        /* renamed from: f, reason: collision with root package name */
        double f6827f;

        /* renamed from: g, reason: collision with root package name */
        double f6828g;

        /* renamed from: h, reason: collision with root package name */
        double f6829h;

        /* renamed from: i, reason: collision with root package name */
        double f6830i;

        /* renamed from: j, reason: collision with root package name */
        double f6831j;

        /* renamed from: k, reason: collision with root package name */
        double f6832k;

        /* renamed from: l, reason: collision with root package name */
        double f6833l;

        /* renamed from: m, reason: collision with root package name */
        double f6834m;

        /* renamed from: n, reason: collision with root package name */
        double f6835n;

        /* renamed from: o, reason: collision with root package name */
        double f6836o;

        /* renamed from: p, reason: collision with root package name */
        double f6837p;

        /* renamed from: q, reason: collision with root package name */
        boolean f6838q;

        /* renamed from: r, reason: collision with root package name */
        boolean f6839r;

        C0059a(int i11, double d11, double d12, double d13, double d14, double d15, double d16) {
            this.f6839r = false;
            this.f6838q = i11 == 1;
            this.f6824c = d11;
            this.f6825d = d12;
            this.f6830i = 1.0d / (d12 - d11);
            if (3 == i11) {
                this.f6839r = true;
            }
            double d17 = d15 - d13;
            double d18 = d16 - d14;
            if (!this.f6839r && Math.abs(d17) >= 0.001d && Math.abs(d18) >= 0.001d) {
                this.f6822a = new double[101];
                boolean z10 = this.f6838q;
                this.f6831j = d17 * (z10 ? -1 : 1);
                this.f6832k = d18 * (z10 ? 1 : -1);
                this.f6833l = z10 ? d15 : d13;
                this.f6834m = z10 ? d14 : d16;
                a(d13, d14, d15, d16);
                this.f6835n = this.f6823b * this.f6830i;
                return;
            }
            this.f6839r = true;
            this.f6826e = d13;
            this.f6827f = d15;
            this.f6828g = d14;
            this.f6829h = d16;
            double hypot = Math.hypot(d18, d17);
            this.f6823b = hypot;
            this.f6835n = hypot * this.f6830i;
            double d19 = this.f6825d;
            double d20 = this.f6824c;
            this.f6833l = d17 / (d19 - d20);
            this.f6834m = d18 / (d19 - d20);
        }

        private void a(double d11, double d12, double d13, double d14) {
            double d15;
            double d16 = d13 - d11;
            double d17 = d12 - d14;
            int i11 = 0;
            double d18 = 0.0d;
            double d19 = 0.0d;
            double d20 = 0.0d;
            while (true) {
                if (i11 >= f6821s.length) {
                    break;
                }
                double d21 = d18;
                double radians = Math.toRadians((i11 * 90.0d) / (r15.length - 1));
                double sin = Math.sin(radians) * d16;
                double cos = Math.cos(radians) * d17;
                if (i11 > 0) {
                    d15 = Math.hypot(sin - d19, cos - d20) + d21;
                    f6821s[i11] = d15;
                } else {
                    d15 = d21;
                }
                i11++;
                d20 = cos;
                d18 = d15;
                d19 = sin;
            }
            double d22 = d18;
            this.f6823b = d22;
            int i12 = 0;
            while (true) {
                double[] dArr = f6821s;
                if (i12 >= dArr.length) {
                    break;
                }
                dArr[i12] = dArr[i12] / d22;
                i12++;
            }
            int i13 = 0;
            while (true) {
                if (i13 >= this.f6822a.length) {
                    return;
                }
                double length = i13 / (r1.length - 1);
                int binarySearch = Arrays.binarySearch(f6821s, length);
                if (binarySearch >= 0) {
                    this.f6822a[i13] = binarySearch / (f6821s.length - 1);
                } else if (binarySearch == -1) {
                    this.f6822a[i13] = 0.0d;
                } else {
                    int i14 = -binarySearch;
                    int i15 = i14 - 2;
                    double[] dArr2 = f6821s;
                    double d23 = dArr2[i15];
                    this.f6822a[i13] = (i15 + ((length - d23) / (dArr2[i14 - 1] - d23))) / (dArr2.length - 1);
                }
                i13++;
            }
        }

        double b() {
            double d11 = this.f6831j * this.f6837p;
            double hypot = this.f6835n / Math.hypot(d11, (-this.f6832k) * this.f6836o);
            if (this.f6838q) {
                d11 = -d11;
            }
            return d11 * hypot;
        }

        double c() {
            double d11 = this.f6831j * this.f6837p;
            double d12 = (-this.f6832k) * this.f6836o;
            double hypot = this.f6835n / Math.hypot(d11, d12);
            return this.f6838q ? (-d12) * hypot : d12 * hypot;
        }

        public double d(double d11) {
            return this.f6833l;
        }

        public double e(double d11) {
            return this.f6834m;
        }

        public double f(double d11) {
            double d12 = (d11 - this.f6824c) * this.f6830i;
            double d13 = this.f6826e;
            return d13 + (d12 * (this.f6827f - d13));
        }

        public double g(double d11) {
            double d12 = (d11 - this.f6824c) * this.f6830i;
            double d13 = this.f6828g;
            return d13 + (d12 * (this.f6829h - d13));
        }

        double h() {
            return this.f6833l + (this.f6831j * this.f6836o);
        }

        double i() {
            return this.f6834m + (this.f6832k * this.f6837p);
        }

        double j(double d11) {
            if (d11 <= 0.0d) {
                return 0.0d;
            }
            if (d11 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f6822a;
            double length = d11 * (dArr.length - 1);
            int i11 = (int) length;
            double d12 = length - i11;
            double d13 = dArr[i11];
            return d13 + (d12 * (dArr[i11 + 1] - d13));
        }

        void k(double d11) {
            double j11 = j((this.f6838q ? this.f6825d - d11 : d11 - this.f6824c) * this.f6830i) * 1.5707963267948966d;
            this.f6836o = Math.sin(j11);
            this.f6837p = Math.cos(j11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (r5 == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r2 = 1
            r0.f6820c = r2
            r0.f6818a = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.a$a[] r3 = new androidx.constraintlayout.core.motion.utils.a.C0059a[r3]
            r0.f6819b = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L16:
            androidx.constraintlayout.core.motion.utils.a$a[] r7 = r0.f6819b
            int r8 = r7.length
            if (r4 >= r8) goto L51
            r8 = r25[r4]
            r9 = 3
            if (r8 == 0) goto L31
            if (r8 == r2) goto L2f
            r10 = 2
            if (r8 == r10) goto L2d
            if (r8 == r9) goto L28
            goto L32
        L28:
            if (r5 != r2) goto L2f
            goto L2d
        L2b:
            r6 = r5
            goto L32
        L2d:
            r5 = r10
            goto L2b
        L2f:
            r5 = r2
            goto L2b
        L31:
            r6 = r9
        L32:
            androidx.constraintlayout.core.motion.utils.a$a r22 = new androidx.constraintlayout.core.motion.utils.a$a
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r3]
            r16 = r8[r2]
            r8 = r27[r23]
            r18 = r8[r3]
            r20 = r8[r2]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L16
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.a.<init>(int[], double[], double[][]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double c(double d11, int i11) {
        double g11;
        double e11;
        double i12;
        double c11;
        double g12;
        double e12;
        int i13 = 0;
        if (this.f6820c) {
            C0059a[] c0059aArr = this.f6819b;
            C0059a c0059a = c0059aArr[0];
            double d12 = c0059a.f6824c;
            if (d11 < d12) {
                double d13 = d11 - d12;
                if (c0059a.f6839r) {
                    if (i11 == 0) {
                        g12 = c0059a.f(d12);
                        e12 = this.f6819b[0].d(d12);
                    } else {
                        g12 = c0059a.g(d12);
                        e12 = this.f6819b[0].e(d12);
                    }
                    return g12 + (d13 * e12);
                }
                c0059a.k(d12);
                if (i11 == 0) {
                    i12 = this.f6819b[0].h();
                    c11 = this.f6819b[0].b();
                } else {
                    i12 = this.f6819b[0].i();
                    c11 = this.f6819b[0].c();
                }
                return i12 + (d13 * c11);
            }
            if (d11 > c0059aArr[c0059aArr.length - 1].f6825d) {
                double d14 = c0059aArr[c0059aArr.length - 1].f6825d;
                double d15 = d11 - d14;
                int length = c0059aArr.length - 1;
                if (i11 == 0) {
                    g11 = c0059aArr[length].f(d14);
                    e11 = this.f6819b[length].d(d14);
                } else {
                    g11 = c0059aArr[length].g(d14);
                    e11 = this.f6819b[length].e(d14);
                }
                return g11 + (d15 * e11);
            }
        } else {
            C0059a[] c0059aArr2 = this.f6819b;
            double d16 = c0059aArr2[0].f6824c;
            if (d11 < d16) {
                d11 = d16;
            } else if (d11 > c0059aArr2[c0059aArr2.length - 1].f6825d) {
                d11 = c0059aArr2[c0059aArr2.length - 1].f6825d;
            }
        }
        while (true) {
            C0059a[] c0059aArr3 = this.f6819b;
            if (i13 >= c0059aArr3.length) {
                return Double.NaN;
            }
            C0059a c0059a2 = c0059aArr3[i13];
            if (d11 <= c0059a2.f6825d) {
                if (c0059a2.f6839r) {
                    return i11 == 0 ? c0059a2.f(d11) : c0059a2.g(d11);
                }
                c0059a2.k(d11);
                return i11 == 0 ? this.f6819b[i13].h() : this.f6819b[i13].i();
            }
            i13++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void d(double d11, double[] dArr) {
        if (this.f6820c) {
            C0059a[] c0059aArr = this.f6819b;
            C0059a c0059a = c0059aArr[0];
            double d12 = c0059a.f6824c;
            if (d11 < d12) {
                double d13 = d11 - d12;
                if (c0059a.f6839r) {
                    dArr[0] = c0059a.f(d12) + (this.f6819b[0].d(d12) * d13);
                    dArr[1] = this.f6819b[0].g(d12) + (d13 * this.f6819b[0].e(d12));
                    return;
                } else {
                    c0059a.k(d12);
                    dArr[0] = this.f6819b[0].h() + (this.f6819b[0].b() * d13);
                    dArr[1] = this.f6819b[0].i() + (d13 * this.f6819b[0].c());
                    return;
                }
            }
            if (d11 > c0059aArr[c0059aArr.length - 1].f6825d) {
                double d14 = c0059aArr[c0059aArr.length - 1].f6825d;
                double d15 = d11 - d14;
                int length = c0059aArr.length - 1;
                C0059a c0059a2 = c0059aArr[length];
                if (c0059a2.f6839r) {
                    dArr[0] = c0059a2.f(d14) + (this.f6819b[length].d(d14) * d15);
                    dArr[1] = this.f6819b[length].g(d14) + (d15 * this.f6819b[length].e(d14));
                    return;
                } else {
                    c0059a2.k(d11);
                    dArr[0] = this.f6819b[length].h() + (this.f6819b[length].b() * d15);
                    dArr[1] = this.f6819b[length].i() + (d15 * this.f6819b[length].c());
                    return;
                }
            }
        } else {
            C0059a[] c0059aArr2 = this.f6819b;
            double d16 = c0059aArr2[0].f6824c;
            if (d11 < d16) {
                d11 = d16;
            }
            if (d11 > c0059aArr2[c0059aArr2.length - 1].f6825d) {
                d11 = c0059aArr2[c0059aArr2.length - 1].f6825d;
            }
        }
        int i11 = 0;
        while (true) {
            C0059a[] c0059aArr3 = this.f6819b;
            if (i11 >= c0059aArr3.length) {
                return;
            }
            C0059a c0059a3 = c0059aArr3[i11];
            if (d11 <= c0059a3.f6825d) {
                if (c0059a3.f6839r) {
                    dArr[0] = c0059a3.f(d11);
                    dArr[1] = this.f6819b[i11].g(d11);
                    return;
                } else {
                    c0059a3.k(d11);
                    dArr[0] = this.f6819b[i11].h();
                    dArr[1] = this.f6819b[i11].i();
                    return;
                }
            }
            i11++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void e(double d11, float[] fArr) {
        if (this.f6820c) {
            C0059a[] c0059aArr = this.f6819b;
            C0059a c0059a = c0059aArr[0];
            double d12 = c0059a.f6824c;
            if (d11 < d12) {
                double d13 = d11 - d12;
                if (c0059a.f6839r) {
                    fArr[0] = (float) (c0059a.f(d12) + (this.f6819b[0].d(d12) * d13));
                    fArr[1] = (float) (this.f6819b[0].g(d12) + (d13 * this.f6819b[0].e(d12)));
                    return;
                } else {
                    c0059a.k(d12);
                    fArr[0] = (float) (this.f6819b[0].h() + (this.f6819b[0].b() * d13));
                    fArr[1] = (float) (this.f6819b[0].i() + (d13 * this.f6819b[0].c()));
                    return;
                }
            }
            if (d11 > c0059aArr[c0059aArr.length - 1].f6825d) {
                double d14 = c0059aArr[c0059aArr.length - 1].f6825d;
                double d15 = d11 - d14;
                int length = c0059aArr.length - 1;
                C0059a c0059a2 = c0059aArr[length];
                if (c0059a2.f6839r) {
                    fArr[0] = (float) (c0059a2.f(d14) + (this.f6819b[length].d(d14) * d15));
                    fArr[1] = (float) (this.f6819b[length].g(d14) + (d15 * this.f6819b[length].e(d14)));
                    return;
                } else {
                    c0059a2.k(d11);
                    fArr[0] = (float) this.f6819b[length].h();
                    fArr[1] = (float) this.f6819b[length].i();
                    return;
                }
            }
        } else {
            C0059a[] c0059aArr2 = this.f6819b;
            double d16 = c0059aArr2[0].f6824c;
            if (d11 < d16) {
                d11 = d16;
            } else if (d11 > c0059aArr2[c0059aArr2.length - 1].f6825d) {
                d11 = c0059aArr2[c0059aArr2.length - 1].f6825d;
            }
        }
        int i11 = 0;
        while (true) {
            C0059a[] c0059aArr3 = this.f6819b;
            if (i11 >= c0059aArr3.length) {
                return;
            }
            C0059a c0059a3 = c0059aArr3[i11];
            if (d11 <= c0059a3.f6825d) {
                if (c0059a3.f6839r) {
                    fArr[0] = (float) c0059a3.f(d11);
                    fArr[1] = (float) this.f6819b[i11].g(d11);
                    return;
                } else {
                    c0059a3.k(d11);
                    fArr[0] = (float) this.f6819b[i11].h();
                    fArr[1] = (float) this.f6819b[i11].i();
                    return;
                }
            }
            i11++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double f(double d11, int i11) {
        C0059a[] c0059aArr = this.f6819b;
        int i12 = 0;
        double d12 = c0059aArr[0].f6824c;
        if (d11 < d12) {
            d11 = d12;
        }
        if (d11 > c0059aArr[c0059aArr.length - 1].f6825d) {
            d11 = c0059aArr[c0059aArr.length - 1].f6825d;
        }
        while (true) {
            C0059a[] c0059aArr2 = this.f6819b;
            if (i12 >= c0059aArr2.length) {
                return Double.NaN;
            }
            C0059a c0059a = c0059aArr2[i12];
            if (d11 <= c0059a.f6825d) {
                if (c0059a.f6839r) {
                    return i11 == 0 ? c0059a.d(d11) : c0059a.e(d11);
                }
                c0059a.k(d11);
                return i11 == 0 ? this.f6819b[i12].b() : this.f6819b[i12].c();
            }
            i12++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public void g(double d11, double[] dArr) {
        C0059a[] c0059aArr = this.f6819b;
        double d12 = c0059aArr[0].f6824c;
        if (d11 < d12) {
            d11 = d12;
        } else if (d11 > c0059aArr[c0059aArr.length - 1].f6825d) {
            d11 = c0059aArr[c0059aArr.length - 1].f6825d;
        }
        int i11 = 0;
        while (true) {
            C0059a[] c0059aArr2 = this.f6819b;
            if (i11 >= c0059aArr2.length) {
                return;
            }
            C0059a c0059a = c0059aArr2[i11];
            if (d11 <= c0059a.f6825d) {
                if (c0059a.f6839r) {
                    dArr[0] = c0059a.d(d11);
                    dArr[1] = this.f6819b[i11].e(d11);
                    return;
                } else {
                    c0059a.k(d11);
                    dArr[0] = this.f6819b[i11].b();
                    dArr[1] = this.f6819b[i11].c();
                    return;
                }
            }
            i11++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.b
    public double[] h() {
        return this.f6818a;
    }
}
