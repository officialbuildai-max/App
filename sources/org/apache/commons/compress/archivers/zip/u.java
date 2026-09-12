package org.apache.commons.compress.archivers.zip;

import androidx.core.view.InputDeviceCompat;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes7.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f71313a = ZipLong.getBytes(8448);

    public static long a(int i11) {
        return i11 < 0 ? i11 + TmcConstants.TEMP_FILE_RUNTIME_MAX_SIZE : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return bigInteger.longValue();
        }
        throw new NumberFormatException("The BigInteger cannot fit inside a 64 bit java long: [" + bigInteger + "]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(byte[] bArr) {
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger d(long j11) {
        if (j11 >= -2147483648L) {
            if (j11 < 0 && j11 >= -2147483648L) {
                j11 = a((int) j11);
            }
            return BigInteger.valueOf(j11);
        }
        throw new IllegalArgumentException("Negative longs < -2^31 not permitted: [" + j11 + "]");
    }

    public static byte[] e(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i11 = 0; i11 < bArr.length / 2; i11++) {
            byte b11 = bArr[i11];
            int i12 = length - i11;
            bArr[i11] = bArr[i12];
            bArr[i12] = b11;
        }
        return bArr;
    }

    public static int f(byte b11) {
        return b11 >= 0 ? b11 : b11 + 256;
    }

    public static byte g(int i11) {
        if (i11 <= 255 && i11 >= 0) {
            return i11 < 128 ? (byte) i11 : (byte) (i11 + InputDeviceCompat.SOURCE_ANY);
        }
        throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + i11 + "]");
    }
}
