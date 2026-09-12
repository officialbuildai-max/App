package pd;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import id.d;
import java.util.Map;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final kd.c f72559a = new kd.c(kd.a.f66891o);

    private int a(byte[] bArr, int i11, int i12, int i13, int i14) {
        int i15 = i12 + i13;
        int i16 = i14 == 0 ? 1 : 2;
        int[] iArr = new int[i15 / i16];
        for (int i17 = 0; i17 < i15; i17++) {
            if (i14 == 0 || i17 % 2 == i14 - 1) {
                iArr[i17 / i16] = bArr[i17 + i11] & 255;
            }
        }
        try {
            int a11 = this.f72559a.a(iArr, i13 / i16);
            for (int i18 = 0; i18 < i12; i18++) {
                if (i14 == 0 || i18 % 2 == i14 - 1) {
                    bArr[i18 + i11] = (byte) iArr[i18 / i16];
                }
            }
            return a11;
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public d b(id.b bVar, Map map) {
        int a11;
        byte[] bArr;
        byte[] a12 = new a(bVar).a();
        int a13 = a(a12, 0, 10, 10, 0);
        int i11 = a12[0] & 15;
        if (i11 == 2 || i11 == 3 || i11 == 4) {
            a11 = a13 + a(a12, 20, 84, 40, 1) + a(a12, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i11 != 5) {
                throw FormatException.getFormatInstance();
            }
            a11 = a13 + a(a12, 20, 68, 56, 1) + a(a12, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(a12, 0, bArr, 0, 10);
        System.arraycopy(a12, 20, bArr, 10, bArr.length - 10);
        d a14 = b.a(bArr, i11);
        a14.n(Integer.valueOf(a11));
        return a14;
    }
}
