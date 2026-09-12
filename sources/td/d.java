package td;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.m;
import com.google.zxing.pdf417.encoder.Compaction;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes5.dex */
public final class d implements m {
    private static id.b b(byte[][] bArr, int i11) {
        int i12 = i11 * 2;
        id.b bVar = new id.b(bArr[0].length + i12, bArr.length + i12);
        bVar.b();
        int k11 = (bVar.k() - i11) - 1;
        int i13 = 0;
        while (i13 < bArr.length) {
            byte[] bArr2 = bArr[i13];
            for (int i14 = 0; i14 < bArr[0].length; i14++) {
                if (bArr2[i14] == 1) {
                    bVar.r(i14 + i11, k11);
                }
            }
            i13++;
            k11--;
        }
        return bVar;
    }

    private static id.b c(wd.c cVar, String str, int i11, int i12, int i13, int i14, boolean z10) {
        boolean z11;
        cVar.e(str, i11, z10);
        byte[][] b11 = cVar.f().b(1, 4);
        if ((i13 > i12) != (b11[0].length < b11.length)) {
            b11 = d(b11);
            z11 = true;
        } else {
            z11 = false;
        }
        int min = Math.min(i12 / b11[0].length, i13 / b11.length);
        if (min <= 1) {
            return b(b11, i14);
        }
        byte[][] b12 = cVar.f().b(min, min * 4);
        if (z11) {
            b12 = d(b12);
        }
        return b(b12, i14);
    }

    private static byte[][] d(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            int length = (bArr.length - i11) - 1;
            for (int i12 = 0; i12 < bArr[0].length; i12++) {
                bArr2[i12][length] = bArr[i11][i12];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.m
    public id.b a(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map map) {
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        wd.c cVar = new wd.c();
        boolean z10 = false;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
            if (map.containsKey(encodeHintType)) {
                cVar.h(Boolean.parseBoolean(map.get(encodeHintType).toString()));
            }
            EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
            if (map.containsKey(encodeHintType2)) {
                cVar.i(Compaction.valueOf(map.get(encodeHintType2).toString()));
            }
            EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
            if (map.containsKey(encodeHintType3)) {
                android.support.v4.media.session.c.a(map.get(encodeHintType3));
                throw null;
            }
            EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
            r0 = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
            EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
            r2 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
            EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType6)) {
                cVar.j(Charset.forName(map.get(encodeHintType6).toString()));
            }
            EncodeHintType encodeHintType7 = EncodeHintType.PDF417_AUTO_ECI;
            if (map.containsKey(encodeHintType7) && Boolean.parseBoolean(map.get(encodeHintType7).toString())) {
                z10 = true;
            }
        }
        return c(cVar, str, r2, i11, i12, r0, z10);
    }
}
