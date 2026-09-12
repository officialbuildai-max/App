package com.google.common.math;

import java.math.RoundingMode;

/* loaded from: classes4.dex */
abstract class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z10, double d11, RoundingMode roundingMode) {
        if (z10) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d11 + " and rounding mode " + roundingMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z10, String str, int i11, int i12) {
        if (z10) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i11 + ", " + i12 + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z10, String str, long j11, long j12) {
        if (z10) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j11 + ", " + j12 + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double d(String str, double d11) {
        if (d11 >= 0.0d) {
            return d11;
        }
        throw new IllegalArgumentException(str + " (" + d11 + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long e(String str, long j11) {
        if (j11 >= 0) {
            return j11;
        }
        throw new IllegalArgumentException(str + " (" + j11 + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(String str, int i11) {
        if (i11 > 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " (" + i11 + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(boolean z10) {
        if (!z10) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
