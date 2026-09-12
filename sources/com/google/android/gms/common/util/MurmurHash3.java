package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes3.dex */
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int murmurhash3_x86_32(@NonNull byte[] bArr, int i11, int i12, int i13) {
        int i14;
        int i15 = i11;
        while (true) {
            i14 = (i12 & (-4)) + i11;
            if (i15 >= i14) {
                break;
            }
            int i16 = ((bArr[i15] & 255) | ((bArr[i15 + 1] & 255) << 8) | ((bArr[i15 + 2] & 255) << 16) | (bArr[i15 + 3] << 24)) * (-862048943);
            int i17 = i13 ^ (((i16 >>> 17) | (i16 << 15)) * 461845907);
            i13 = (((i17 >>> 19) | (i17 << 13)) * 5) - 430675100;
            i15 += 4;
        }
        int i18 = i12 & 3;
        if (i18 != 1) {
            if (i18 != 2) {
                r0 = i18 == 3 ? (bArr[i14 + 2] & 255) << 16 : 0;
                int i19 = i13 ^ i12;
                int i20 = (i19 ^ (i19 >>> 16)) * (-2048144789);
                int i21 = (i20 ^ (i20 >>> 13)) * (-1028477387);
                return i21 ^ (i21 >>> 16);
            }
            r0 |= (bArr[i14 + 1] & 255) << 8;
        }
        int i22 = ((bArr[i14] & 255) | r0) * (-862048943);
        i13 ^= ((i22 >>> 17) | (i22 << 15)) * 461845907;
        int i192 = i13 ^ i12;
        int i202 = (i192 ^ (i192 >>> 16)) * (-2048144789);
        int i212 = (i202 ^ (i202 >>> 13)) * (-1028477387);
        return i212 ^ (i212 >>> 16);
    }
}
