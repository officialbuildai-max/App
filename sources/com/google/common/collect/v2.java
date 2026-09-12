package com.google.common.collect;

/* loaded from: classes4.dex */
abstract class v2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i11, double d11) {
        int max = Math.max(i11, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d11 * highestOneBit))) {
            return highestOneBit;
        }
        int i12 = highestOneBit << 1;
        if (i12 > 0) {
            return i12;
        }
        return 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(int i11, int i12, double d11) {
        return ((double) i11) > d11 * ((double) i12) && i12 < 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i11) {
        return (int) (Integer.rotateLeft((int) (i11 * (-862048943)), 15) * 461845907);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
