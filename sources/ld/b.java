package ld;

import android.support.v4.media.session.c;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.datamatrix.encoder.MinimalEncoder;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.g;
import com.google.zxing.m;
import java.nio.charset.Charset;
import java.util.Map;
import nd.d;

/* loaded from: classes5.dex */
public final class b implements m {
    private static id.b b(yd.a aVar, int i11, int i12) {
        id.b bVar;
        int e11 = aVar.e();
        int d11 = aVar.d();
        int max = Math.max(i11, e11);
        int max2 = Math.max(i12, d11);
        int min = Math.min(max / e11, max2 / d11);
        int i13 = (max - (e11 * min)) / 2;
        int i14 = (max2 - (d11 * min)) / 2;
        if (i12 < d11 || i11 < e11) {
            bVar = new id.b(e11, d11);
            i13 = 0;
            i14 = 0;
        } else {
            bVar = new id.b(i11, i12);
        }
        bVar.b();
        int i15 = 0;
        while (i15 < d11) {
            int i16 = i13;
            int i17 = 0;
            while (i17 < e11) {
                if (aVar.b(i17, i15) == 1) {
                    bVar.s(i16, i14, min, min);
                }
                i17++;
                i16 += min;
            }
            i15++;
            i14 += min;
        }
        return bVar;
    }

    private static id.b c(nd.b bVar, d dVar, int i11, int i12) {
        int h11 = dVar.h();
        int g11 = dVar.g();
        yd.a aVar = new yd.a(dVar.j(), dVar.i());
        int i13 = 0;
        for (int i14 = 0; i14 < g11; i14++) {
            if (i14 % dVar.f70441e == 0) {
                int i15 = 0;
                for (int i16 = 0; i16 < dVar.j(); i16++) {
                    aVar.g(i15, i13, i16 % 2 == 0);
                    i15++;
                }
                i13++;
            }
            int i17 = 0;
            for (int i18 = 0; i18 < h11; i18++) {
                if (i18 % dVar.f70440d == 0) {
                    aVar.g(i17, i13, true);
                    i17++;
                }
                aVar.g(i17, i13, bVar.e(i18, i14));
                int i19 = i17 + 1;
                int i20 = dVar.f70440d;
                if (i18 % i20 == i20 - 1) {
                    aVar.g(i19, i13, i14 % 2 == 0);
                    i17 += 2;
                } else {
                    i17 = i19;
                }
            }
            int i21 = i13 + 1;
            int i22 = dVar.f70441e;
            if (i14 % i22 == i22 - 1) {
                int i23 = 0;
                for (int i24 = 0; i24 < dVar.j(); i24++) {
                    aVar.g(i23, i21, true);
                    i23++;
                }
                i13 += 2;
            } else {
                i13 = i21;
            }
        }
        return b(aVar, i11, i12);
    }

    @Override // com.google.zxing.m
    public id.b a(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map map) {
        String b11;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        }
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i11 + 'x' + i12);
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        if (map != null) {
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            c.a(map.get(EncodeHintType.MIN_SIZE));
            c.a(map.get(EncodeHintType.MAX_SIZE));
        }
        boolean z10 = false;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.DATA_MATRIX_COMPACT;
            if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                EncodeHintType encodeHintType2 = EncodeHintType.GS1_FORMAT;
                if (map.containsKey(encodeHintType2) && Boolean.parseBoolean(map.get(encodeHintType2).toString())) {
                    z10 = true;
                }
                EncodeHintType encodeHintType3 = EncodeHintType.CHARACTER_SET;
                b11 = MinimalEncoder.h(str, map.containsKey(encodeHintType3) ? Charset.forName(map.get(encodeHintType3).toString()) : null, z10 ? 29 : -1, symbolShapeHint);
                d l11 = d.l(b11.length(), symbolShapeHint, null, null, true);
                nd.b bVar = new nd.b(nd.c.b(b11, l11), l11.h(), l11.g());
                bVar.h();
                return c(bVar, l11, i11, i12);
            }
        }
        if (map != null) {
            EncodeHintType encodeHintType4 = EncodeHintType.FORCE_C40;
            if (map.containsKey(encodeHintType4) && Boolean.parseBoolean(map.get(encodeHintType4).toString())) {
                z10 = true;
            }
        }
        b11 = g.b(str, symbolShapeHint, null, null, z10);
        d l112 = d.l(b11.length(), symbolShapeHint, null, null, true);
        nd.b bVar2 = new nd.b(nd.c.b(b11, l112), l112.h(), l112.g());
        bVar2.h();
        return c(bVar2, l112, i11, i12);
    }
}
