package com.google.zxing.qrcode.decoder;

/* loaded from: classes4.dex */
final class e {

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f33044c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a, reason: collision with root package name */
    private final ErrorCorrectionLevel f33045a;

    /* renamed from: b, reason: collision with root package name */
    private final byte f33046b;

    private e(int i11) {
        this.f33045a = ErrorCorrectionLevel.forBits((i11 >> 3) & 3);
        this.f33046b = (byte) (i11 & 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(int i11, int i12) {
        e b11 = b(i11, i12);
        return b11 != null ? b11 : b(i11 ^ 21522, i12 ^ 21522);
    }

    private static e b(int i11, int i12) {
        int e11;
        int i13 = Integer.MAX_VALUE;
        int i14 = 0;
        for (int[] iArr : f33044c) {
            int i15 = iArr[0];
            if (i15 == i11 || i15 == i12) {
                return new e(iArr[1]);
            }
            int e12 = e(i11, i15);
            if (e12 < i13) {
                i14 = iArr[1];
                i13 = e12;
            }
            if (i11 != i12 && (e11 = e(i12, i15)) < i13) {
                i14 = iArr[1];
                i13 = e11;
            }
        }
        if (i13 <= 3) {
            return new e(i14);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i11, int i12) {
        return Integer.bitCount(i11 ^ i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte c() {
        return this.f33046b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ErrorCorrectionLevel d() {
        return this.f33045a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f33045a == eVar.f33045a && this.f33046b == eVar.f33046b;
    }

    public int hashCode() {
        return (this.f33045a.ordinal() << 3) | this.f33046b;
    }
}
