package com.google.common.math;

import java.math.RoundingMode;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final double f30939a = Math.log(2.0d);

    /* renamed from: b, reason: collision with root package name */
    static final double[] f30940b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30941a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f30941a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30941a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30941a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30941a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30941a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30941a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30941a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30941a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(double d11, double d12, double d13) {
        g.d("tolerance", d13);
        return Math.copySign(d11 - d12, 1.0d) <= d13 || d11 == d12 || (Double.isNaN(d11) && Double.isNaN(d12));
    }

    public static boolean b(double d11) {
        return c.c(d11) && (d11 == 0.0d || 52 - Long.numberOfTrailingZeros(c.b(d11)) <= Math.getExponent(d11));
    }

    public static boolean c(double d11) {
        if (d11 <= 0.0d || !c.c(d11)) {
            return false;
        }
        long b11 = c.b(d11);
        return (b11 & (b11 - 1)) == 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0032. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(double r5, java.math.RoundingMode r7) {
        /*
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L10
            boolean r0 = com.google.common.math.c.c(r5)
            if (r0 == 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            java.lang.String r3 = "x must be positive and finite"
            com.google.common.base.m.e(r0, r3)
            int r0 = java.lang.Math.getExponent(r5)
            boolean r3 = com.google.common.math.c.d(r5)
            if (r3 != 0) goto L2a
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r5 = r5 * r0
            int r5 = d(r5, r7)
            int r5 = r5 + (-52)
            return r5
        L2a:
            int[] r3 = com.google.common.math.b.a.f30941a
            int r7 = r7.ordinal()
            r7 = r3[r7]
            switch(r7) {
                case 1: goto L61;
                case 2: goto L68;
                case 3: goto L5a;
                case 4: goto L52;
                case 5: goto L48;
                case 6: goto L3b;
                case 7: goto L3b;
                case 8: goto L3b;
                default: goto L35;
            }
        L35:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L3b:
            double r5 = com.google.common.math.c.e(r5)
            double r5 = r5 * r5
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 <= 0) goto L68
            r1 = r2
            goto L68
        L48:
            if (r0 < 0) goto L4b
            r1 = r2
        L4b:
            boolean r5 = c(r5)
        L4f:
            r5 = r5 ^ r2
            r1 = r1 & r5
            goto L68
        L52:
            if (r0 >= 0) goto L55
            r1 = r2
        L55:
            boolean r5 = c(r5)
            goto L4f
        L5a:
            boolean r5 = c(r5)
            r1 = r5 ^ 1
            goto L68
        L61:
            boolean r5 = c(r5)
            com.google.common.math.g.g(r5)
        L68:
            if (r1 == 0) goto L6c
            int r0 = r0 + 1
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.b.d(double, java.math.RoundingMode):int");
    }

    static double e(double d11, RoundingMode roundingMode) {
        if (!c.c(d11)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.f30941a[roundingMode.ordinal()]) {
            case 1:
                g.g(b(d11));
                return d11;
            case 2:
                return (d11 >= 0.0d || b(d11)) ? d11 : ((long) d11) - 1;
            case 3:
                return (d11 <= 0.0d || b(d11)) ? d11 : ((long) d11) + 1;
            case 4:
                return d11;
            case 5:
                if (b(d11)) {
                    return d11;
                }
                return ((long) d11) + (d11 > 0.0d ? 1 : -1);
            case 6:
                return Math.rint(d11);
            case 7:
                double rint = Math.rint(d11);
                return Math.abs(d11 - rint) == 0.5d ? d11 + Math.copySign(0.5d, d11) : rint;
            case 8:
                double rint2 = Math.rint(d11);
                return Math.abs(d11 - rint2) == 0.5d ? d11 : rint2;
            default:
                throw new AssertionError();
        }
    }

    public static long f(double d11, RoundingMode roundingMode) {
        double e11 = e(d11, roundingMode);
        g.a(((-9.223372036854776E18d) - e11 < 1.0d) & (e11 < 9.223372036854776E18d), d11, roundingMode);
        return (long) e11;
    }
}
