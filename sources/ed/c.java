package ed;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.m;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes5.dex */
public final class c implements m {
    private static id.b b(String str, BarcodeFormat barcodeFormat, int i11, int i12, Charset charset, int i13, int i14) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return c(com.google.zxing.aztec.encoder.c.d(str, i13, i14, charset), i11, i12);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    private static id.b c(com.google.zxing.aztec.encoder.a aVar, int i11, int i12) {
        id.b a11 = aVar.a();
        if (a11 == null) {
            throw new IllegalStateException();
        }
        int n11 = a11.n();
        int k11 = a11.k();
        int max = Math.max(i11, n11);
        int max2 = Math.max(i12, k11);
        int min = Math.min(max / n11, max2 / k11);
        int i13 = (max - (n11 * min)) / 2;
        int i14 = (max2 - (k11 * min)) / 2;
        id.b bVar = new id.b(max, max2);
        int i15 = 0;
        while (i15 < k11) {
            int i16 = 0;
            int i17 = i13;
            while (i16 < n11) {
                if (a11.g(i16, i15)) {
                    bVar.s(i17, i14, min, min);
                }
                i16++;
                i17 += min;
            }
            i15++;
            i14 += min;
        }
        return bVar;
    }

    @Override // com.google.zxing.m
    public id.b a(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map map) {
        int i13 = 0;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            r0 = map.containsKey(encodeHintType) ? Charset.forName(map.get(encodeHintType).toString()) : null;
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            r1 = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                i13 = Integer.parseInt(map.get(encodeHintType3).toString());
            }
        }
        return b(str, barcodeFormat, i11, i12, r0, r1, i13);
    }
}
