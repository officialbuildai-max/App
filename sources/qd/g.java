package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* loaded from: classes5.dex */
public final class g extends w {

    /* renamed from: j, reason: collision with root package name */
    static final int[] f73693j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: i, reason: collision with root package name */
    private final int[] f73694i = new int[4];

    private static void s(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < 10; i12++) {
            if (i11 == f73693j[i12]) {
                sb2.insert(0, (char) (i12 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // qd.w
    public int l(id.a aVar, int[] iArr, StringBuilder sb2) {
        int[] iArr2 = this.f73694i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int m11 = aVar.m();
        int i11 = iArr[1];
        int i12 = 0;
        for (int i13 = 0; i13 < 6 && i11 < m11; i13++) {
            int j11 = w.j(aVar, iArr2, i11, w.f73725h);
            sb2.append((char) ((j11 % 10) + 48));
            for (int i14 : iArr2) {
                i11 += i14;
            }
            if (j11 >= 10) {
                i12 |= 1 << (5 - i13);
            }
        }
        s(sb2, i12);
        int i15 = w.n(aVar, i11, true, w.f73722e)[1];
        for (int i16 = 0; i16 < 6 && i15 < m11; i16++) {
            sb2.append((char) (w.j(aVar, iArr2, i15, w.f73724g) + 48));
            for (int i17 : iArr2) {
                i15 += i17;
            }
        }
        return i15;
    }

    @Override // qd.w
    BarcodeFormat q() {
        return BarcodeFormat.EAN_13;
    }
}
