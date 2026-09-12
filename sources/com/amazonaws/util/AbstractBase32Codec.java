package com.amazonaws.util;

/* loaded from: classes2.dex */
abstract class AbstractBase32Codec {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f19066a;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractBase32Codec(byte[] bArr) {
        this.f19066a = bArr;
    }

    private final void b(int i11, byte[] bArr, int i12, byte[] bArr2, int i13) {
        int i14 = i13 + 1;
        int j11 = j(bArr[i12]) << 3;
        int i15 = i12 + 2;
        int j12 = j(bArr[i12 + 1]);
        bArr2[i13] = (byte) (j11 | ((j12 >>> 2) & 7));
        if (i11 == 1) {
            CodecUtils.sanityCheckLastPos(j12, 3);
            return;
        }
        int i16 = i13 + 2;
        int j13 = ((j12 & 3) << 6) | (j(bArr[i15]) << 1);
        int i17 = i12 + 4;
        int j14 = j(bArr[i12 + 3]);
        bArr2[i14] = (byte) (j13 | ((j14 >>> 4) & 1));
        if (i11 == 2) {
            CodecUtils.sanityCheckLastPos(j14, 15);
            return;
        }
        int i18 = i13 + 3;
        int i19 = i12 + 5;
        int j15 = j(bArr[i17]);
        bArr2[i16] = (byte) ((15 & (j15 >>> 1)) | ((j14 & 15) << 4));
        if (i11 == 3) {
            CodecUtils.sanityCheckLastPos(j15, 1);
            return;
        }
        int j16 = ((j15 & 1) << 7) | (j(bArr[i19]) << 2);
        int j17 = j(bArr[i12 + 6]);
        bArr2[i18] = (byte) (j16 | ((j17 >>> 3) & 3));
        CodecUtils.sanityCheckLastPos(j17, 7);
    }

    private final void c(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int j11 = j(bArr[i11]) << 3;
        int j12 = j(bArr[i11 + 1]);
        bArr2[i12] = (byte) (j11 | ((j12 >>> 2) & 7));
        int j13 = ((j12 & 3) << 6) | (j(bArr[i11 + 2]) << 1);
        int j14 = j(bArr[i11 + 3]);
        bArr2[i12 + 1] = (byte) (j13 | ((j14 >>> 4) & 1));
        int j15 = j(bArr[i11 + 4]);
        bArr2[i12 + 2] = (byte) (((j14 & 15) << 4) | ((j15 >>> 1) & 15));
        int j16 = ((j15 & 1) << 7) | (j(bArr[i11 + 5]) << 2);
        int j17 = j(bArr[i11 + 6]);
        bArr2[i12 + 3] = (byte) (j16 | ((j17 >>> 3) & 3));
        bArr2[i12 + 4] = (byte) (j(bArr[i11 + 7]) | ((j17 & 7) << 5));
    }

    private final void e(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        byte[] bArr3 = this.f19066a;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        int i14 = i12 + 2;
        bArr2[i13] = bArr3[(b11 & 7) << 2];
        int i15 = 0;
        while (i15 < 6) {
            bArr2[i14] = 61;
            i15++;
            i14++;
        }
    }

    private final void f(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = this.f19066a;
        int i13 = i11 + 1;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        byte b12 = bArr[i13];
        bArr2[i12 + 1] = bArr3[((b11 & 7) << 2) | ((b12 >>> 6) & 3)];
        int i14 = i12 + 3;
        bArr2[i12 + 2] = bArr3[(b12 >>> 1) & 31];
        int i15 = i12 + 4;
        bArr2[i14] = bArr3[(b12 & 1) << 4];
        int i16 = 0;
        while (i16 < 4) {
            bArr2[i15] = 61;
            i16++;
            i15++;
        }
    }

    private final void g(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = this.f19066a;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        byte b12 = bArr[i11 + 1];
        bArr2[i12 + 1] = bArr3[((b11 & 7) << 2) | ((b12 >>> 6) & 3)];
        bArr2[i12 + 2] = bArr3[(b12 >>> 1) & 31];
        int i13 = i12 + 4;
        byte b13 = bArr[i11 + 2];
        bArr2[i12 + 3] = bArr3[((b13 >>> 4) & 15) | ((b12 & 1) << 4)];
        int i14 = i12 + 5;
        bArr2[i13] = bArr3[(b13 & 15) << 1];
        int i15 = 0;
        while (i15 < 3) {
            bArr2[i14] = 61;
            i15++;
            i14++;
        }
    }

    private final void h(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = this.f19066a;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        byte b12 = bArr[i11 + 1];
        bArr2[i12 + 1] = bArr3[((b11 & 7) << 2) | ((b12 >>> 6) & 3)];
        bArr2[i12 + 2] = bArr3[(b12 >>> 1) & 31];
        byte b13 = bArr[i11 + 2];
        bArr2[i12 + 3] = bArr3[((b12 & 1) << 4) | ((b13 >>> 4) & 15)];
        byte b14 = bArr[i11 + 3];
        bArr2[i12 + 4] = bArr3[((b14 >>> 7) & 1) | ((b13 & 15) << 1)];
        bArr2[i12 + 5] = bArr3[(b14 >>> 2) & 31];
        bArr2[i12 + 6] = bArr3[(b14 & 3) << 3];
        bArr2[i12 + 7] = 61;
    }

    private final void i(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = this.f19066a;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        byte b12 = bArr[i11 + 1];
        bArr2[i12 + 1] = bArr3[((b11 & 7) << 2) | ((b12 >>> 6) & 3)];
        bArr2[i12 + 2] = bArr3[(b12 >>> 1) & 31];
        byte b13 = bArr[i11 + 2];
        bArr2[i12 + 3] = bArr3[((b12 & 1) << 4) | ((b13 >>> 4) & 15)];
        byte b14 = bArr[i11 + 3];
        bArr2[i12 + 4] = bArr3[((b13 & 15) << 1) | ((b14 >>> 7) & 1)];
        bArr2[i12 + 5] = bArr3[(b14 >>> 2) & 31];
        byte b15 = bArr[i11 + 4];
        bArr2[i12 + 6] = bArr3[((b15 >>> 5) & 7) | ((b14 & 3) << 3)];
        bArr2[i12 + 7] = bArr3[b15 & 31];
    }

    public final byte[] a(byte[] bArr, int i11) {
        int i12;
        if (i11 % 8 != 0) {
            throw new IllegalArgumentException("Input is expected to be encoded in multiple of 8 bytes but found: " + i11);
        }
        int i13 = i11 - 1;
        int i14 = 0;
        while (i14 < 6 && i13 > -1 && bArr[i13] == 61) {
            i13--;
            i14++;
        }
        if (i14 != 0) {
            int i15 = 4;
            if (i14 != 1) {
                i12 = 3;
                if (i14 != 3) {
                    if (i14 == 4) {
                        i15 = 2;
                    } else {
                        if (i14 != 6) {
                            throw new IllegalArgumentException("Invalid number of paddings " + i14);
                        }
                        i12 = 1;
                    }
                }
            }
            i12 = i15;
        } else {
            i12 = 5;
        }
        int i16 = ((i11 / 8) * 5) - (5 - i12);
        byte[] bArr2 = new byte[i16];
        int i17 = 0;
        int i18 = 0;
        while (i18 < i16 - (i12 % 5)) {
            c(bArr, i17, bArr2, i18);
            i17 += 8;
            i18 += 5;
        }
        if (i12 < 5) {
            b(i12, bArr, i17, bArr2, i18);
        }
        return bArr2;
    }

    public final byte[] d(byte[] bArr) {
        int length = bArr.length / 5;
        int length2 = bArr.length % 5;
        int i11 = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 8];
            int i12 = 0;
            while (i11 < bArr.length) {
                i(bArr, i11, bArr2, i12);
                i11 += 5;
                i12 += 8;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 8];
        int i13 = 0;
        while (i11 < bArr.length - length2) {
            i(bArr, i11, bArr3, i13);
            i11 += 5;
            i13 += 8;
        }
        if (length2 == 1) {
            e(bArr, i11, bArr3, i13);
        } else if (length2 == 2) {
            f(bArr, i11, bArr3, i13);
        } else if (length2 == 3) {
            g(bArr, i11, bArr3, i13);
        } else if (length2 == 4) {
            h(bArr, i11, bArr3, i13);
        }
        return bArr3;
    }

    protected abstract int j(byte b11);
}
