package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public final class j extends x {
    @Override // qd.q
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + w.r(str);
            } catch (FormatException e11) {
                throw new IllegalArgumentException(e11);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
            }
            try {
                if (!w.i(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        q.c(str);
        boolean[] zArr = new boolean[67];
        int b11 = q.b(zArr, 0, w.f73721d, true);
        for (int i11 = 0; i11 <= 3; i11++) {
            b11 += q.b(zArr, b11, w.f73724g[Character.digit(str.charAt(i11), 10)], false);
        }
        int b12 = b11 + q.b(zArr, b11, w.f73722e, false);
        for (int i12 = 4; i12 <= 7; i12++) {
            b12 += q.b(zArr, b12, w.f73724g[Character.digit(str.charAt(i12), 10)], true);
        }
        q.b(zArr, b12, w.f73721d, true);
        return zArr;
    }

    @Override // qd.q
    protected Collection g() {
        return Collections.singleton(BarcodeFormat.EAN_8);
    }
}
