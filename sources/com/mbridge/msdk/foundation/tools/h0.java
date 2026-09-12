package com.mbridge.msdk.foundation.tools;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f35793a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f35794b;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f35793a = charArray;
        int[] iArr = new int[256];
        f35794b = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i11 = 0; i11 < length; i11++) {
            f35794b[f35793a[i11]] = i11;
        }
        f35794b[61] = 0;
    }

    public static String a(String str) {
        byte[] b11 = b(str);
        return (b11 == null || b11.length == 0) ? "" : new String(b11, StandardCharsets.UTF_8);
    }

    public static byte[] b(String str) {
        int i11;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i12 = length - 1;
        int i13 = 0;
        while (i13 < i12 && f35794b[str.charAt(i13) & 255] < 0) {
            i13++;
        }
        while (i12 > 0 && f35794b[str.charAt(i12) & 255] < 0) {
            i12--;
        }
        int i14 = str.charAt(i12) == '=' ? str.charAt(i12 + (-1)) == '=' ? 2 : 1 : 0;
        int i15 = (i12 - i13) + 1;
        if (length > 76) {
            i11 = (str.charAt(76) == '\r' ? i15 / 78 : 0) << 1;
        } else {
            i11 = 0;
        }
        int i16 = (((i15 - i11) * 6) >> 3) - i14;
        byte[] bArr = new byte[i16];
        int i17 = (i16 / 3) * 3;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i17) {
            int[] iArr = f35794b;
            int i20 = i13 + 4;
            int i21 = iArr[str.charAt(i13 + 3)] | (iArr[str.charAt(i13 + 1)] << 12) | (iArr[str.charAt(i13)] << 18) | (iArr[str.charAt(i13 + 2)] << 6);
            bArr[i18] = (byte) (i21 >> 16);
            int i22 = i18 + 2;
            bArr[i18 + 1] = (byte) (i21 >> 8);
            i18 += 3;
            bArr[i22] = (byte) i21;
            if (i11 <= 0 || (i19 = i19 + 1) != 19) {
                i13 = i20;
            } else {
                i13 += 6;
                i19 = 0;
            }
        }
        if (i18 < i16) {
            int i23 = 0;
            int i24 = 0;
            while (i13 <= i12 - i14) {
                i23 |= f35794b[str.charAt(i13)] << (18 - (i24 * 6));
                i24++;
                i13++;
            }
            int i25 = 16;
            while (i18 < i16) {
                bArr[i18] = (byte) (i23 >> i25);
                i25 -= 8;
                i18++;
            }
        }
        return bArr;
    }
}
