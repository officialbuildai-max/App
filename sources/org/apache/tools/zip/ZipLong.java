package org.apache.tools.zip;

/* loaded from: classes7.dex */
public final class ZipLong implements Cloneable {
    private static final int BYTE_1 = 1;
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_2 = 2;
    private static final int BYTE_2_MASK = 16711680;
    private static final int BYTE_2_SHIFT = 16;
    private static final int BYTE_3 = 3;
    private static final long BYTE_3_MASK = 4278190080L;
    private static final int BYTE_3_SHIFT = 24;
    private static final int BYTE_BIT_SIZE = 8;
    private static final int BYTE_MASK = 255;
    private static final int WORD = 4;
    private long value;

    public ZipLong(long j11) {
        this.value = j11;
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i11) {
        this.value = getValue(bArr, i11);
    }

    public static byte[] getBytes(long j11) {
        return new byte[]{(byte) (255 & j11), (byte) ((65280 & j11) >> 8), (byte) ((16711680 & j11) >> 16), (byte) ((j11 & BYTE_3_MASK) >> 24)};
    }

    public static long getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }

    public static long getValue(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] << 24) & BYTE_3_MASK) + ((bArr[i11 + 2] << 16) & BYTE_2_MASK) + ((bArr[i11 + 1] << 8) & 65280) + (bArr[i11] & 255);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipLong) && this.value == ((ZipLong) obj).getValue();
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return (int) this.value;
    }
}
