package od;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.k;
import id.b;
import id.d;
import java.util.Map;
import pd.c;

/* loaded from: classes5.dex */
public final class a implements i {

    /* renamed from: b, reason: collision with root package name */
    private static final k[] f71086b = new k[0];

    /* renamed from: a, reason: collision with root package name */
    private final c f71087a = new c();

    private static b c(b bVar) {
        int[] j11 = bVar.j();
        if (j11 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = j11[0];
        int i12 = j11[1];
        int i13 = j11[2];
        int i14 = j11[3];
        b bVar2 = new b(30, 33);
        for (int i15 = 0; i15 < 33; i15++) {
            int min = Math.min((((i15 * i14) + (i14 / 2)) / 33) + i12, i14 - 1);
            for (int i16 = 0; i16 < 30; i16++) {
                if (bVar.g(Math.min((((i16 * i13) + (i13 / 2)) + (((i15 & 1) * i13) / 2)) / 30, i13 - 1) + i11, min)) {
                    bVar2.r(i16, i15);
                }
            }
        }
        return bVar2;
    }

    @Override // com.google.zxing.i
    public j a(com.google.zxing.b bVar, Map map) {
        d b11 = this.f71087a.b(c(bVar.a()), map);
        j jVar = new j(b11.k(), b11.g(), f71086b, BarcodeFormat.MAXICODE);
        jVar.h(ResultMetadataType.ERRORS_CORRECTED, b11.d());
        String b12 = b11.b();
        if (b12 != null) {
            jVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b12);
        }
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
