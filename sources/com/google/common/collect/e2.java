package com.google.common.collect;

/* loaded from: classes4.dex */
abstract class e2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i11, String str) {
        if (i11 >= 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long c(long j11, String str) {
        if (j11 >= 0) {
            return j11;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(int i11, String str) {
        if (i11 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(boolean z10) {
        com.google.common.base.m.v(z10, "no calls to next() since the last call to remove()");
    }
}
