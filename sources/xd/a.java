package xd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.qrcode.decoder.d;
import com.google.zxing.qrcode.detector.c;
import id.f;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class a implements i {

    /* renamed from: b, reason: collision with root package name */
    private static final k[] f78320b = new k[0];

    /* renamed from: a, reason: collision with root package name */
    private final d f78321a = new d();

    private static id.b c(id.b bVar) {
        int[] m11 = bVar.m();
        int[] i11 = bVar.i();
        if (m11 == null || i11 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float d11 = d(m11, bVar);
        int i12 = m11[1];
        int i13 = i11[1];
        int i14 = m11[0];
        int i15 = i11[0];
        if (i14 >= i15 || i12 >= i13) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i16 = i13 - i12;
        if (i16 != i15 - i14 && (i15 = i14 + i16) >= bVar.n()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int round = Math.round(((i15 - i14) + 1) / d11);
        int round2 = Math.round((i16 + 1) / d11);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (round2 != round) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i17 = (int) (d11 / 2.0f);
        int i18 = i12 + i17;
        int i19 = i14 + i17;
        int i20 = (((int) ((round - 1) * d11)) + i19) - i15;
        if (i20 > 0) {
            if (i20 > i17) {
                throw NotFoundException.getNotFoundInstance();
            }
            i19 -= i20;
        }
        int i21 = (((int) ((round2 - 1) * d11)) + i18) - i13;
        if (i21 > 0) {
            if (i21 > i17) {
                throw NotFoundException.getNotFoundInstance();
            }
            i18 -= i21;
        }
        id.b bVar2 = new id.b(round, round2);
        for (int i22 = 0; i22 < round2; i22++) {
            int i23 = ((int) (i22 * d11)) + i18;
            for (int i24 = 0; i24 < round; i24++) {
                if (bVar.g(((int) (i24 * d11)) + i19, i23)) {
                    bVar2.r(i24, i22);
                }
            }
        }
        return bVar2;
    }

    private static float d(int[] iArr, id.b bVar) {
        int k11 = bVar.k();
        int n11 = bVar.n();
        int i11 = iArr[0];
        boolean z10 = true;
        int i12 = iArr[1];
        int i13 = 0;
        while (i11 < n11 && i12 < k11) {
            if (z10 != bVar.g(i11, i12)) {
                i13++;
                if (i13 == 5) {
                    break;
                }
                z10 = !z10;
            }
            i11++;
            i12++;
        }
        if (i11 == n11 || i12 == k11) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i11 - iArr[0]) / 7.0f;
    }

    @Override // com.google.zxing.i
    public final j a(com.google.zxing.b bVar, Map map) {
        k[] b11;
        id.d dVar;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f e11 = new c(bVar.a()).e(map);
            id.d c11 = this.f78321a.c(e11.a(), map);
            b11 = e11.b();
            dVar = c11;
        } else {
            dVar = this.f78321a.c(c(bVar.a()), map);
            b11 = f78320b;
        }
        if (dVar.f() instanceof com.google.zxing.qrcode.decoder.f) {
            ((com.google.zxing.qrcode.decoder.f) dVar.f()).a(b11);
        }
        j jVar = new j(dVar.k(), dVar.g(), b11, BarcodeFormat.QR_CODE);
        List a11 = dVar.a();
        if (a11 != null) {
            jVar.h(ResultMetadataType.BYTE_SEGMENTS, a11);
        }
        String b12 = dVar.b();
        if (b12 != null) {
            jVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b12);
        }
        if (dVar.l()) {
            jVar.h(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVar.i()));
            jVar.h(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVar.h()));
        }
        jVar.h(ResultMetadataType.ERRORS_CORRECTED, dVar.d());
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]Q" + dVar.j());
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
