package ld;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.datamatrix.decoder.c;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.k;
import id.d;
import id.f;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class a implements i {

    /* renamed from: b, reason: collision with root package name */
    private static final k[] f68929b = new k[0];

    /* renamed from: a, reason: collision with root package name */
    private final c f68930a = new c();

    private static id.b c(id.b bVar) {
        int[] m11 = bVar.m();
        int[] i11 = bVar.i();
        if (m11 == null || i11 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int d11 = d(m11, bVar);
        int i12 = m11[1];
        int i13 = i11[1];
        int i14 = m11[0];
        int i15 = ((i11[0] - i14) + 1) / d11;
        int i16 = ((i13 - i12) + 1) / d11;
        if (i15 <= 0 || i16 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i17 = d11 / 2;
        int i18 = i12 + i17;
        int i19 = i14 + i17;
        id.b bVar2 = new id.b(i15, i16);
        for (int i20 = 0; i20 < i16; i20++) {
            int i21 = (i20 * d11) + i18;
            for (int i22 = 0; i22 < i15; i22++) {
                if (bVar.g((i22 * d11) + i19, i21)) {
                    bVar2.r(i22, i20);
                }
            }
        }
        return bVar2;
    }

    private static int d(int[] iArr, id.b bVar) {
        int n11 = bVar.n();
        int i11 = iArr[0];
        int i12 = iArr[1];
        while (i11 < n11 && bVar.g(i11, i12)) {
            i11++;
        }
        if (i11 == n11) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i13 = i11 - iArr[0];
        if (i13 != 0) {
            return i13;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.i
    public j a(com.google.zxing.b bVar, Map map) {
        k[] b11;
        d dVar;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f b12 = new md.a(bVar.a()).b();
            d b13 = this.f68930a.b(b12.a());
            b11 = b12.b();
            dVar = b13;
        } else {
            dVar = this.f68930a.b(c(bVar.a()));
            b11 = f68929b;
        }
        j jVar = new j(dVar.k(), dVar.g(), b11, BarcodeFormat.DATA_MATRIX);
        List a11 = dVar.a();
        if (a11 != null) {
            jVar.h(ResultMetadataType.BYTE_SEGMENTS, a11);
        }
        String b14 = dVar.b();
        if (b14 != null) {
            jVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b14);
        }
        jVar.h(ResultMetadataType.ERRORS_CORRECTED, dVar.d());
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]d" + dVar.j());
        return jVar;
    }

    @Override // com.google.zxing.i
    public j b(com.google.zxing.b bVar) {
        return a(bVar, null);
    }

    @Override // com.google.zxing.i
    public void reset() {
    }
}
