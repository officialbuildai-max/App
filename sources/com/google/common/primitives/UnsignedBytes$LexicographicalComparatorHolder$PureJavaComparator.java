package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: classes4.dex */
enum UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator implements Comparator<byte[]> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i11 = 0; i11 < min; i11++) {
            int b11 = e.b(bArr[i11], bArr2[i11]);
            if (b11 != 0) {
                return b11;
            }
        }
        return bArr.length - bArr2.length;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }
}
