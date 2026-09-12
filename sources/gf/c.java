package gf;

/* loaded from: classes5.dex */
public abstract class c {
    public static int a(Comparable[] comparableArr, Comparable[] comparableArr2) {
        int length = comparableArr.length;
        int length2 = comparableArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i11 = 0; i11 < length; i11++) {
            int compareTo = comparableArr[i11].compareTo(comparableArr2[i11]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public static int b(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i11 = 0; i11 < length; i11++) {
            int c11 = c(iArr[i11], iArr2[i11]);
            if (c11 != 0) {
                return c11;
            }
        }
        return 0;
    }

    public static int c(int i11, int i12) {
        if (i11 == i12) {
            return 0;
        }
        return i11 < i12 ? -1 : 1;
    }

    public static int d(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i11 = 0; i11 < length; i11++) {
            int g11 = g(bArr[i11], bArr2[i11]);
            if (g11 != 0) {
                return g11;
            }
        }
        return 0;
    }

    public static int e(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i11 = 0; i11 < length; i11++) {
            int h11 = h(iArr[i11], iArr2[i11]);
            if (h11 != 0) {
                return h11;
            }
        }
        return 0;
    }

    public static int f(short[] sArr, short[] sArr2) {
        int length = sArr.length;
        int length2 = sArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i(sArr[i11], sArr2[i11]);
            if (i12 != 0) {
                return i12;
            }
        }
        return 0;
    }

    public static int g(byte b11, byte b12) {
        if (b11 == b12) {
            return 0;
        }
        return (b11 & 255) < (b12 & 255) ? -1 : 1;
    }

    public static int h(int i11, int i12) {
        if (i11 == i12) {
            return 0;
        }
        return (((long) i11) & 4294967295L) < (((long) i12) & 4294967295L) ? -1 : 1;
    }

    public static int i(short s11, short s12) {
        if (s11 == s12) {
            return 0;
        }
        return (s11 & 65535) < (s12 & 65535) ? -1 : 1;
    }
}
