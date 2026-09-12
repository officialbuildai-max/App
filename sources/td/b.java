package td;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.k;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes5.dex */
public final class b implements i {

    /* renamed from: a, reason: collision with root package name */
    private static final j[] f76309a = new j[0];

    private static j[] c(com.google.zxing.b bVar, Map map, boolean z10) {
        ArrayList arrayList = new ArrayList();
        vd.b d11 = vd.a.d(bVar, map, z10);
        for (k[] kVarArr : d11.b()) {
            id.d i11 = com.google.zxing.pdf417.decoder.i.i(d11.a(), kVarArr[4], kVarArr[5], kVarArr[6], kVarArr[7], f(kVarArr), d(kVarArr));
            j jVar = new j(i11.k(), i11.g(), kVarArr, BarcodeFormat.PDF_417);
            jVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, i11.b());
            jVar.h(ResultMetadataType.ERRORS_CORRECTED, i11.d());
            jVar.h(ResultMetadataType.ERASURES_CORRECTED, i11.c());
            c cVar = (c) i11.f();
            if (cVar != null) {
                jVar.h(ResultMetadataType.PDF417_EXTRA_METADATA, cVar);
            }
            jVar.h(ResultMetadataType.ORIENTATION, Integer.valueOf(d11.c()));
            jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]L" + i11.j());
            arrayList.add(jVar);
        }
        return (j[]) arrayList.toArray(f76309a);
    }

    private static int d(k[] kVarArr) {
        return Math.max(Math.max(e(kVarArr[0], kVarArr[4]), (e(kVarArr[6], kVarArr[2]) * 17) / 18), Math.max(e(kVarArr[1], kVarArr[5]), (e(kVarArr[7], kVarArr[3]) * 17) / 18));
    }

    private static int e(k kVar, k kVar2) {
        if (kVar == null || kVar2 == null) {
            return 0;
        }
        return (int) Math.abs(kVar.c() - kVar2.c());
    }

    private static int f(k[] kVarArr) {
        return Math.min(Math.min(g(kVarArr[0], kVarArr[4]), (g(kVarArr[6], kVarArr[2]) * 17) / 18), Math.min(g(kVarArr[1], kVarArr[5]), (g(kVarArr[7], kVarArr[3]) * 17) / 18));
    }

    private static int g(k kVar, k kVar2) {
        if (kVar == null || kVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(kVar.c() - kVar2.c());
    }

    @Override // com.google.zxing.i
    public j a(com.google.zxing.b bVar, Map map) {
        j jVar;
        j[] c11 = c(bVar, map, false);
        if (c11.length == 0 || (jVar = c11[0]) == null) {
            throw NotFoundException.getNotFoundInstance();
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
