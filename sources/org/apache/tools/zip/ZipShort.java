package org.apache.tools.zip;

/* loaded from: classes7.dex */
public final class ZipShort implements Cloneable {
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_MASK = 255;
    private int value;

    public ZipShort(int i11) {
        this.value = i11;
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i11) {
        this.value = getValue(bArr, i11);
    }

    public static byte[] getBytes(int i11) {
        return new byte[]{(byte) (i11 & 255), (byte) ((i11 & 65280) >> 8)};
    }

    public static int getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }

    public static int getValue(byte[] bArr, int i11) {
        return ((bArr[i11 + 1] << 8) & 65280) + (bArr[i11] & 255);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipShort) && this.value == ((ZipShort) obj).getValue();
    }

    public byte[] getBytes() {
        int i11 = this.value;
        return new byte[]{(byte) (i11 & 255), (byte) ((i11 & 65280) >> 8)};
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
