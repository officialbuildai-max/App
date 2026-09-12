package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public final class h extends x {
    @Override // qd.q
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + w.r(str);
            } catch (FormatException e11) {
                throw new IllegalArgumentException(e11);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
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
        int i11 = g.f73693j[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int b11 = q.b(zArr, 0, w.f73721d, true);
        for (int i12 = 1; i12 <= 6; i12++) {
            int digit = Character.digit(str.charAt(i12), 10);
            if (((i11 >> (6 - i12)) & 1) == 1) {
                digit += 10;
            }
            b11 += q.b(zArr, b11, w.f73725h[digit], false);
        }
        int b12 = b11 + q.b(zArr, b11, w.f73722e, false);
        for (int i13 = 7; i13 <= 12; i13++) {
            b12 += q.b(zArr, b12, w.f73724g[Character.digit(str.charAt(i13), 10)], true);
        }
        q.b(zArr, b12, w.f73721d, true);
        return zArr;
    }

    @Override // qd.q
    protected Collection g() {
        return Collections.singleton(BarcodeFormat.EAN_13);
    }
}
