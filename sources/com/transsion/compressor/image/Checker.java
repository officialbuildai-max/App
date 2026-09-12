package com.transsion.compressor.image;

import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes5.dex */
public enum Checker {
    SINGLE;

    private static final int IS_JPG_TAG = 3;
    private static final byte[] JPEG_SIGNATURE = {-1, -40, -1};
    private static final String JPG = ".jpg";

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        if (r8 <= 8) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
    
        r2 = pack(r11, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:
    
        if (r2 == 1229531648) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
    
        if (r2 == 1296891946) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
    
        com.transsion.compressor.image.j.f("Invalid byte order");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0079, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007a, code lost:
    
        if (r2 != 1229531648) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
    
        r3 = pack(r11, r1 + 4, 4, r2) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        if (r3 < 10) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008a, code lost:
    
        if (r3 <= r8) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008d, code lost:
    
        r1 = r1 + r3;
        r8 = r8 - r3;
        r3 = pack(r11, r1 - 2, 2, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
    
        r5 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
    
        if (r3 <= 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009b, code lost:
    
        if (r8 < 12) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (pack(r11, r1, 2, r2) != 274) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c4, code lost:
    
        r1 = r1 + 12;
        r8 = r8 - 12;
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
    
        r11 = pack(r11, r1 + 8, 2, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
    
        if (r11 == 1) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ad, code lost:
    
        if (r11 == 3) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b0, code lost:
    
        if (r11 == 6) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b2, code lost:
    
        if (r11 == 8) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b4, code lost:
    
        com.transsion.compressor.image.j.f("Unsupported orientation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b9, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ba, code lost:
    
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bd, code lost:
    
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c0, code lost:
    
        return 180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c3, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ca, code lost:
    
        com.transsion.compressor.image.j.f("Invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x007e, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cf, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0060, code lost:
    
        r8 = 0;
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getOrientation(byte[] r11) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.compressor.image.Checker.getOrientation(byte[]):int");
    }

    private boolean isJpg(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }

    private int pack(byte[] bArr, int i11, int i12, boolean z10) {
        int i13;
        if (z10) {
            i11 += i12 - 1;
            i13 = -1;
        } else {
            i13 = 1;
        }
        int i14 = 0;
        while (true) {
            int i15 = i12 - 1;
            if (i12 <= 0) {
                return i14;
            }
            i14 = (bArr[i11] & 255) | (i14 << 8);
            i11 += i13;
            i12 = i15;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String extSuffix(d dVar) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(dVar.open(), null, options);
            return options.outMimeType.replace("image/", ".");
        } catch (Exception unused) {
            return JPG;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getOrientation(InputStream inputStream) {
        return getOrientation(j.g(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isJpg(InputStream inputStream) {
        return isJpg(j.g(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needCompress(int i11, String str) {
        if (i11 > 0) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    if (file.length() > (i11 << 10)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e11) {
                j.f(Log.getStackTraceString(e11));
            }
        }
        return true;
    }
}
