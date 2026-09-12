package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public final class z extends x {
    @Override // qd.q
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + w.r(y.s(str));
            } catch (FormatException e11) {
                throw new IllegalArgumentException(e11);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
            }
            try {
                if (!w.i(y.s(str))) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        q.c(str);
        int digit = Character.digit(str.charAt(0), 10);
        if (digit != 0 && digit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i11 = y.f73730k[digit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int b11 = q.b(zArr, 0, w.f73721d, true);
        for (int i12 = 1; i12 <= 6; i12++) {
            int digit2 = Character.digit(str.charAt(i12), 10);
            if (((i11 >> (6 - i12)) & 1) == 1) {
                digit2 += 10;
            }
            b11 += q.b(zArr, b11, w.f73725h[digit2], false);
        }
        q.b(zArr, b11, w.f73723f, false);
        return zArr;
    }

    @Override // qd.q
    protected Collection g() {
        return Collections.singleton(BarcodeFormat.UPC_E);
    }
}
