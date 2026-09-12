package qd;

import com.google.zxing.BarcodeFormat;

/* loaded from: classes5.dex */
public final class i extends w {

    /* renamed from: i, reason: collision with root package name */
    private final int[] f73695i = new int[4];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // qd.w
    public int l(id.a aVar, int[] iArr, StringBuilder sb2) {
        int[] iArr2 = this.f73695i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int m11 = aVar.m();
        int i11 = iArr[1];
        for (int i12 = 0; i12 < 4 && i11 < m11; i12++) {
            sb2.append((char) (w.j(aVar, iArr2, i11, w.f73724g) + 48));
            for (int i13 : iArr2) {
                i11 += i13;
            }
        }
        int i14 = w.n(aVar, i11, true, w.f73722e)[1];
        for (int i15 = 0; i15 < 4 && i14 < m11; i15++) {
            sb2.append((char) (w.j(aVar, iArr2, i14, w.f73724g) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        return i14;
    }

    @Override // qd.w
    BarcodeFormat q() {
        return BarcodeFormat.EAN_8;
    }
}
