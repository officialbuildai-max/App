package com.bytedance.sdk.component.utils;

import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class Ym {
    private static final byte[] Sj = Sj("VP8X");

    public static boolean Sj(byte[] bArr, int i11) {
        boolean Sj2;
        int i12;
        try {
            Sj2 = Sj(bArr, i11 + 12, Sj);
            i12 = i11 + 20;
        } catch (Throwable unused) {
        }
        if (bArr.length <= i12) {
            return false;
        }
        return Sj2 && ((bArr[i12] & 2) == 2);
    }

    private static boolean Sj(byte[] bArr, int i11, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i11 > bArr.length) {
            return false;
        }
        for (int i12 = 0; i12 < bArr2.length; i12++) {
            if (bArr[i12 + i11] != bArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] Sj(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }
}
