package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes5.dex */
public final class o extends p {

    /* renamed from: b, reason: collision with root package name */
    private static final w[] f73708b = new w[0];

    /* renamed from: a, reason: collision with root package name */
    private final w[] f73709a;

    public o(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new g());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new r());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new i());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new y());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new g());
            arrayList.add(new i());
            arrayList.add(new y());
        }
        this.f73709a = (w[]) arrayList.toArray(f73708b);
    }

    @Override // qd.p
    public com.google.zxing.j c(int i11, id.a aVar, Map map) {
        boolean z10;
        int[] p11 = w.p(aVar);
        for (w wVar : this.f73709a) {
            try {
                com.google.zxing.j m11 = wVar.m(i11, aVar, p11, map);
                boolean z11 = m11.b() == BarcodeFormat.EAN_13 && m11.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                if (collection != null && !collection.contains(BarcodeFormat.UPC_A)) {
                    z10 = false;
                    if (z11 || !z10) {
                        return m11;
                    }
                    com.google.zxing.j jVar = new com.google.zxing.j(m11.f().substring(1), m11.c(), m11.e(), BarcodeFormat.UPC_A);
                    jVar.g(m11.d());
                    return jVar;
                }
                z10 = true;
                if (z11) {
                }
                return m11;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // qd.p, com.google.zxing.i
    public void reset() {
        for (w wVar : this.f73709a) {
            wVar.reset();
        }
    }
}
