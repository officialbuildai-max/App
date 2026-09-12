package com.google.common.primitives;

import com.google.common.base.m;
import java.util.Comparator;

/* loaded from: classes4.dex */
public abstract class SignedBytes {

    /* loaded from: classes4.dex */
    private enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = Byte.compare(bArr[i11], bArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return bArr.length - bArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    public static byte a(long j11) {
        byte b11 = (byte) j11;
        m.h(((long) b11) == j11, "Out of range: %s", j11);
        return b11;
    }
}
