package androidx.compose.animation.core;

/* loaded from: classes.dex */
public abstract class l0 {
    public static final long a(double d11, double d12, double d13, double d14, double d15) {
        double d16;
        double d17;
        double d18;
        double d19;
        double d20;
        double d21;
        double d22;
        double d23;
        double sqrt = 2.0d * d12 * Math.sqrt(d11);
        double d24 = (sqrt * sqrt) - (4.0d * d11);
        double d25 = -sqrt;
        s a11 = t.a(d24);
        d16 = a11.f2568a;
        a11.f2568a = d16 + d25;
        d17 = a11.f2568a;
        a11.f2568a = d17 * 0.5d;
        d18 = a11.f2569b;
        a11.f2569b = d18 * 0.5d;
        s a12 = t.a(d24);
        d19 = a12.f2568a;
        double d26 = -1;
        a12.f2568a = d19 * d26;
        d20 = a12.f2569b;
        a12.f2569b = d20 * d26;
        d21 = a12.f2568a;
        a12.f2568a = d21 + d25;
        d22 = a12.f2568a;
        a12.f2568a = d22 * 0.5d;
        d23 = a12.f2569b;
        a12.f2569b = d23 * 0.5d;
        return d(a11, a12, d12, d13, d14, d15);
    }

    public static final long b(float f11, float f12, float f13, float f14, float f15) {
        if (f12 == 0.0f) {
            return 9223372036854L;
        }
        return a(f11, f12, f13, f14, f15);
    }

    private static final double c(s sVar, double d11, double d12, double d13) {
        double d14;
        int i11;
        double d15 = d13;
        double f11 = sVar.f();
        double d16 = f11 * d11;
        double d17 = d12 - d16;
        double log = Math.log(Math.abs(d15 / d11)) / f11;
        double log2 = Math.log(Math.abs(d15 / d17));
        double d18 = log2;
        for (int i12 = 0; i12 < 6; i12++) {
            d18 = log2 - Math.log(Math.abs(d18 / f11));
        }
        double d19 = d18 / f11;
        if (!((Double.isInfinite(log) || Double.isNaN(log)) ? false : true)) {
            log = d19;
        } else if ((Double.isInfinite(d19) || Double.isNaN(d19)) ? false : true) {
            log = Math.max(log, d19);
        }
        double d20 = (-(d16 + d17)) / (f11 * d17);
        double d21 = f11 * d20;
        double exp = (Math.exp(d21) * d11) + (d17 * d20 * Math.exp(d21));
        if (!Double.isNaN(d20) && d20 > 0.0d) {
            if (d20 <= 0.0d || (-exp) >= d15) {
                log = (-(2.0d / f11)) - (d11 / d17);
                d14 = Double.MAX_VALUE;
                i11 = 0;
                while (d14 > 0.001d && i11 < 100) {
                    i11++;
                    double d22 = f11 * log;
                    double d23 = d15;
                    double exp2 = log - ((((d11 + (d17 * log)) * Math.exp(d22)) + d15) / ((((1 + d22) * d17) + d16) * Math.exp(d22)));
                    d14 = Math.abs(log - exp2);
                    log = exp2;
                    d15 = d23;
                }
                return log;
            }
            if (d17 < 0.0d && d11 > 0.0d) {
                log = 0.0d;
            }
        }
        d15 = -d15;
        d14 = Double.MAX_VALUE;
        i11 = 0;
        while (d14 > 0.001d) {
            i11++;
            double d222 = f11 * log;
            double d232 = d15;
            double exp22 = log - ((((d11 + (d17 * log)) * Math.exp(d222)) + d15) / ((((1 + d222) * d17) + d16) * Math.exp(d222)));
            d14 = Math.abs(log - exp22);
            log = exp22;
            d15 = d232;
        }
        return log;
    }

    private static final long d(s sVar, s sVar2, double d11, double d12, double d13, double d14) {
        double d15 = d12;
        if (d13 == 0.0d && d15 == 0.0d) {
            return 0L;
        }
        if (d13 < 0.0d) {
            d15 = -d15;
        }
        double abs = Math.abs(d13);
        return (long) ((d11 > 1.0d ? e(sVar, sVar2, abs, d15, d14) : d11 < 1.0d ? g(sVar, abs, d15, d14) : c(sVar, abs, d15, d14)) * 1000.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final double e(androidx.compose.animation.core.s r29, androidx.compose.animation.core.s r30, double r31, double r33, double r35) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.l0.e(androidx.compose.animation.core.s, androidx.compose.animation.core.s, double, double, double):double");
    }

    private static final double f(double d11, double d12, double d13, double d14, double d15) {
        return (d11 * Math.exp(d12 * d13)) + (d14 * Math.exp(d15 * d13));
    }

    private static final double g(s sVar, double d11, double d12, double d13) {
        double f11 = sVar.f();
        double e11 = (d12 - (f11 * d11)) / sVar.e();
        return Math.log(d13 / Math.sqrt((d11 * d11) + (e11 * e11))) / f11;
    }
}
