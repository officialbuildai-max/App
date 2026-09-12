package com.google.common.collect;

import java.util.Arrays;

/* loaded from: classes4.dex */
abstract class g2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(int i11) {
        if (i11 >= 2 && i11 <= 1073741824 && Integer.highestOneBit(i11) == i11) {
            return i11 <= 256 ? new byte[i11] : i11 <= 65536 ? new short[i11] : new int[i11];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i11, int i12) {
        return i11 & (~i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i11, int i12) {
        return i11 & i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i11, int i12, int i13) {
        return (i11 & (~i13)) | (i12 & i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i11) {
        return (i11 < 32 ? 4 : 2) * (i11 + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(Object obj, Object obj2, int i11, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i12;
        int i13;
        int d11 = v2.d(obj);
        int i14 = d11 & i11;
        int h11 = h(obj3, i14);
        if (h11 == 0) {
            return -1;
        }
        int b11 = b(d11, i11);
        int i15 = -1;
        while (true) {
            i12 = h11 - 1;
            i13 = iArr[i12];
            if (b(i13, i11) != b11 || !com.google.common.base.j.a(obj, objArr[i12]) || (objArr2 != null && !com.google.common.base.j.a(obj2, objArr2[i12]))) {
                int c11 = c(i13, i11);
                if (c11 == 0) {
                    return -1;
                }
                i15 = i12;
                h11 = c11;
            }
        }
        int c12 = c(i13, i11);
        if (i15 == -1) {
            i(obj3, i14, c12);
        } else {
            iArr[i15] = d(iArr[i15], c12, i11);
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(Object obj, int i11) {
        return obj instanceof byte[] ? ((byte[]) obj)[i11] & 255 : obj instanceof short[] ? ((short[]) obj)[i11] & 65535 : ((int[]) obj)[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Object obj, int i11, int i12) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i11] = (byte) i12;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i11] = (short) i12;
        } else {
            ((int[]) obj)[i11] = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i11) {
        return Math.max(4, v2.a(i11 + 1, 1.0d));
    }
}
