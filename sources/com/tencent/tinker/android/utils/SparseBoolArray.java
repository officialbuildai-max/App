package com.tencent.tinker.android.utils;

/* loaded from: classes5.dex */
public class SparseBoolArray implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f40742d = new int[0];

    /* renamed from: e, reason: collision with root package name */
    private static final boolean[] f40743e = new boolean[0];

    /* renamed from: a, reason: collision with root package name */
    private int[] f40744a;

    /* renamed from: b, reason: collision with root package name */
    private boolean[] f40745b;

    /* renamed from: c, reason: collision with root package name */
    private int f40746c;

    /* loaded from: classes5.dex */
    public static class KeyNotFoundException extends Exception {
        public KeyNotFoundException() {
        }

        public KeyNotFoundException(String str) {
            super(str);
        }
    }

    public SparseBoolArray() {
        this(10);
    }

    public SparseBoolArray(int i11) {
        if (i11 == 0) {
            this.f40744a = f40742d;
            this.f40745b = f40743e;
        } else {
            this.f40744a = new int[i11];
            this.f40745b = new boolean[i11];
        }
        this.f40746c = 0;
    }

    private int a(int[] iArr, int i11, int i12) {
        int i13 = i11 - 1;
        int i14 = 0;
        while (i14 <= i13) {
            int i15 = (i14 + i13) >>> 1;
            int i16 = iArr[i15];
            if (i16 < i12) {
                i14 = i15 + 1;
            } else {
                if (i16 <= i12) {
                    return i15;
                }
                i13 = i15 - 1;
            }
        }
        return ~i14;
    }

    private static int d(int i11) {
        if (i11 <= 4) {
            return 8;
        }
        return i11 + (i11 >> 1);
    }

    private boolean[] f(boolean[] zArr, int i11, int i12, boolean z10) {
        if (i11 > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i11);
        }
        if (i11 + 1 <= zArr.length) {
            System.arraycopy(zArr, i12, zArr, i12 + 1, i11 - i12);
            zArr[i12] = z10;
            return zArr;
        }
        boolean[] zArr2 = new boolean[d(i11)];
        System.arraycopy(zArr, 0, zArr2, 0, i12);
        zArr2[i12] = z10;
        System.arraycopy(zArr, i12, zArr2, i12 + 1, zArr.length - i12);
        return zArr2;
    }

    private int[] g(int[] iArr, int i11, int i12, int i13) {
        if (i11 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i11);
        }
        if (i11 + 1 <= iArr.length) {
            System.arraycopy(iArr, i12, iArr, i12 + 1, i11 - i12);
            iArr[i12] = i13;
            return iArr;
        }
        int[] iArr2 = new int[d(i11)];
        System.arraycopy(iArr, 0, iArr2, 0, i12);
        iArr2[i12] = i13;
        System.arraycopy(iArr, i12, iArr2, i12 + 1, iArr.length - i12);
        return iArr2;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SparseBoolArray clone() {
        SparseBoolArray sparseBoolArray = null;
        try {
            SparseBoolArray sparseBoolArray2 = (SparseBoolArray) super.clone();
            try {
                sparseBoolArray2.f40744a = (int[]) this.f40744a.clone();
                sparseBoolArray2.f40745b = (boolean[]) this.f40745b.clone();
                return sparseBoolArray2;
            } catch (CloneNotSupportedException unused) {
                sparseBoolArray = sparseBoolArray2;
                return sparseBoolArray;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public boolean c(int i11) {
        return e(i11) >= 0;
    }

    public int e(int i11) {
        return a(this.f40744a, this.f40746c, i11);
    }

    public int i(int i11) {
        return this.f40744a[i11];
    }

    public void j(int i11, boolean z10) {
        int a11 = a(this.f40744a, this.f40746c, i11);
        if (a11 >= 0) {
            this.f40745b[a11] = z10;
            return;
        }
        int i12 = ~a11;
        this.f40744a = g(this.f40744a, this.f40746c, i12, i11);
        this.f40745b = f(this.f40745b, this.f40746c, i12, z10);
        this.f40746c++;
    }

    public int k() {
        return this.f40746c;
    }

    public boolean l(int i11) {
        return this.f40745b[i11];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f40746c * 28);
        sb2.append('{');
        for (int i11 = 0; i11 < this.f40746c; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(i(i11));
            sb2.append('=');
            sb2.append(l(i11));
        }
        sb2.append('}');
        return sb2.toString();
    }
}
