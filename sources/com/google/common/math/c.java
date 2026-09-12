package com.google.common.math;

import com.google.common.base.m;

/* loaded from: classes4.dex */
abstract class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static double a(double d11) {
        m.d(!Double.isNaN(d11));
        return Math.max(d11, 0.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(double d11) {
        m.e(c(d11), "not a normal value");
        int exponent = Math.getExponent(d11);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d11) & 4503599627370495L;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(double d11) {
        return Math.getExponent(d11) <= 1023;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(double d11) {
        return Math.getExponent(d11) >= -1022;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double e(double d11) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d11) & 4503599627370495L) | 4607182418800017408L);
    }
}
