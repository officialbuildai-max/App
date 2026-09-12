package com.mbridge.msdk.foundation.tools;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public class y {
    public static Bitmap a(Bitmap bitmap, int i11) {
        if (i11 <= 0) {
            i11 = 10;
        }
        return a(Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / i11, bitmap.getHeight() / i11, false), 8, true);
    }

    public static Bitmap a(Bitmap bitmap, int i11, boolean z10) {
        int[] iArr;
        int i12 = i11;
        Bitmap copy = z10 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i12 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i13 = width * height;
        int[] iArr2 = new int[i13];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i14 = width - 1;
        int i15 = height - 1;
        int i16 = i12 + i12;
        int i17 = i16 + 1;
        int[] iArr3 = new int[i13];
        int[] iArr4 = new int[i13];
        int[] iArr5 = new int[i13];
        int[] iArr6 = new int[Math.max(width, height)];
        int i18 = (i16 + 2) >> 1;
        int i19 = i18 * i18;
        int i20 = i19 * 256;
        int[] iArr7 = new int[i20];
        for (int i21 = 0; i21 < i20; i21++) {
            iArr7[i21] = i21 / i19;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i17, 3);
        int i22 = i12 + 1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < height) {
            Bitmap bitmap2 = copy;
            int i26 = height;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            int i35 = -i12;
            int i36 = 0;
            while (i35 <= i12) {
                int i37 = i15;
                int[] iArr9 = iArr6;
                int i38 = iArr2[i24 + Math.min(i14, Math.max(i35, 0))];
                int[] iArr10 = iArr8[i35 + i12];
                iArr10[0] = (i38 & 16711680) >> 16;
                iArr10[1] = (i38 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i38 & 255;
                int abs = i22 - Math.abs(i35);
                int i39 = iArr10[0];
                i28 += i39 * abs;
                int i40 = iArr10[1];
                i27 += i40 * abs;
                int i41 = iArr10[2];
                i36 += abs * i41;
                if (i35 > 0) {
                    i32 += i39;
                    i33 += i40;
                    i34 += i41;
                } else {
                    i31 += i39;
                    i30 += i40;
                    i29 += i41;
                }
                i35++;
                i15 = i37;
                iArr6 = iArr9;
            }
            int i42 = i15;
            int[] iArr11 = iArr6;
            int i43 = i12;
            int i44 = i36;
            int i45 = 0;
            while (i45 < width) {
                iArr3[i24] = iArr7[i28];
                iArr4[i24] = iArr7[i27];
                iArr5[i24] = iArr7[i44];
                int i46 = i28 - i31;
                int i47 = i27 - i30;
                int i48 = i44 - i29;
                int[] iArr12 = iArr8[((i43 - i12) + i17) % i17];
                int i49 = i31 - iArr12[0];
                int i50 = i30 - iArr12[1];
                int i51 = i29 - iArr12[2];
                if (i23 == 0) {
                    iArr = iArr7;
                    iArr11[i45] = Math.min(i45 + i12 + 1, i14);
                } else {
                    iArr = iArr7;
                }
                int i52 = iArr2[i25 + iArr11[i45]];
                int i53 = (i52 & 16711680) >> 16;
                iArr12[0] = i53;
                int i54 = (i52 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i54;
                int i55 = i52 & 255;
                iArr12[2] = i55;
                int i56 = i32 + i53;
                int i57 = i33 + i54;
                int i58 = i34 + i55;
                i28 = i46 + i56;
                i27 = i47 + i57;
                i44 = i48 + i58;
                i43 = (i43 + 1) % i17;
                int[] iArr13 = iArr8[i43 % i17];
                int i59 = iArr13[0];
                i31 = i49 + i59;
                int i60 = iArr13[1];
                i30 = i50 + i60;
                int i61 = iArr13[2];
                i29 = i51 + i61;
                i32 = i56 - i59;
                i33 = i57 - i60;
                i34 = i58 - i61;
                i24++;
                i45++;
                iArr7 = iArr;
            }
            i25 += width;
            i23++;
            copy = bitmap2;
            height = i26;
            i15 = i42;
            iArr6 = iArr11;
        }
        int[] iArr14 = iArr7;
        Bitmap bitmap3 = copy;
        int i62 = i15;
        int[] iArr15 = iArr6;
        int i63 = height;
        int i64 = 0;
        while (i64 < width) {
            int i65 = -i12;
            int i66 = i17;
            int[] iArr16 = iArr2;
            int i67 = 0;
            int i68 = 0;
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            int i72 = 0;
            int i73 = 0;
            int i74 = i65;
            int i75 = i65 * width;
            int i76 = 0;
            int i77 = 0;
            while (i74 <= i12) {
                int i78 = width;
                int max = Math.max(0, i75) + i64;
                int[] iArr17 = iArr8[i74 + i12];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i22 - Math.abs(i74);
                i67 += iArr3[max] * abs2;
                i77 += iArr4[max] * abs2;
                i76 += iArr5[max] * abs2;
                if (i74 > 0) {
                    i71 += iArr17[0];
                    i72 += iArr17[1];
                    i73 += iArr17[2];
                } else {
                    i70 += iArr17[0];
                    i69 += iArr17[1];
                    i68 += iArr17[2];
                }
                int i79 = i62;
                if (i74 < i79) {
                    i75 += i78;
                }
                i74++;
                i62 = i79;
                width = i78;
            }
            int i80 = width;
            int i81 = i62;
            int i82 = i12;
            int i83 = i64;
            int i84 = i63;
            int i85 = 0;
            while (i85 < i84) {
                iArr16[i83] = (iArr16[i83] & ViewCompat.MEASURED_STATE_MASK) | (iArr14[i67] << 16) | (iArr14[i77] << 8) | iArr14[i76];
                int i86 = i67 - i70;
                int i87 = i77 - i69;
                int i88 = i76 - i68;
                int[] iArr18 = iArr8[((i82 - i12) + i66) % i66];
                int i89 = i70 - iArr18[0];
                int i90 = i69 - iArr18[1];
                int i91 = i68 - iArr18[2];
                if (i64 == 0) {
                    iArr15[i85] = Math.min(i85 + i22, i81) * i80;
                }
                int i92 = iArr15[i85] + i64;
                int i93 = iArr3[i92];
                iArr18[0] = i93;
                int i94 = iArr4[i92];
                iArr18[1] = i94;
                int i95 = iArr5[i92];
                iArr18[2] = i95;
                int i96 = i71 + i93;
                int i97 = i72 + i94;
                int i98 = i73 + i95;
                i67 = i86 + i96;
                i77 = i87 + i97;
                i76 = i88 + i98;
                i82 = (i82 + 1) % i66;
                int[] iArr19 = iArr8[i82];
                int i99 = iArr19[0];
                i70 = i89 + i99;
                int i100 = iArr19[1];
                i69 = i90 + i100;
                int i101 = iArr19[2];
                i68 = i91 + i101;
                i71 = i96 - i99;
                i72 = i97 - i100;
                i73 = i98 - i101;
                i83 += i80;
                i85++;
                i12 = i11;
            }
            i64++;
            i12 = i11;
            i62 = i81;
            i63 = i84;
            i17 = i66;
            iArr2 = iArr16;
            width = i80;
        }
        int i102 = width;
        bitmap3.setPixels(iArr2, 0, i102, 0, 0, i102, i63);
        return bitmap3;
    }
}
