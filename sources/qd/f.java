package qd;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public class f extends q {
    private static int i(boolean[] zArr, int i11, int i12) {
        for (int i13 = 0; i13 < 9; i13++) {
            boolean z10 = true;
            int i14 = i11 + i13;
            if (((1 << (8 - i13)) & i12) == 0) {
                z10 = false;
            }
            zArr[i14] = z10;
        }
        return 9;
    }

    private static int j(String str, int i11) {
        int i12 = 0;
        int i13 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i12 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i13;
            i13++;
            if (i13 > i11) {
                i13 = 1;
            }
        }
        return i12 % 47;
    }

    static String k(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length * 2);
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt == 0) {
                sb2.append("bU");
            } else if (charAt <= 26) {
                sb2.append('a');
                sb2.append((char) (charAt + '@'));
            } else if (charAt <= 31) {
                sb2.append('b');
                sb2.append((char) (charAt + '&'));
            } else if (charAt == ' ' || charAt == '$' || charAt == '%' || charAt == '+') {
                sb2.append(charAt);
            } else if (charAt <= ',') {
                sb2.append('c');
                sb2.append((char) (charAt + ' '));
            } else if (charAt <= '9') {
                sb2.append(charAt);
            } else if (charAt == ':') {
                sb2.append("cZ");
            } else if (charAt <= '?') {
                sb2.append('b');
                sb2.append((char) (charAt + 11));
            } else if (charAt == '@') {
                sb2.append("bV");
            } else if (charAt <= 'Z') {
                sb2.append(charAt);
            } else if (charAt <= '_') {
                sb2.append('b');
                sb2.append((char) (charAt - 16));
            } else if (charAt == '`') {
                sb2.append("bW");
            } else if (charAt <= 'z') {
                sb2.append('d');
                sb2.append((char) (charAt - ' '));
            } else {
                if (charAt > 127) {
                    throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + charAt + "'");
                }
                sb2.append('b');
                sb2.append((char) (charAt - '+'));
            }
        }
        return sb2.toString();
    }

    @Override // qd.q
    public boolean[] d(String str) {
        String k11 = k(str);
        int length = k11.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long after converting to extended encoding, but got " + length);
        }
        boolean[] zArr = new boolean[((k11.length() + 4) * 9) + 1];
        int i11 = i(zArr, 0, e.f73690e);
        for (int i12 = 0; i12 < length; i12++) {
            i11 += i(zArr, i11, e.f73689d["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(k11.charAt(i12))]);
        }
        int j11 = j(k11, 20);
        int[] iArr = e.f73689d;
        int i13 = i11 + i(zArr, i11, iArr[j11]);
        int i14 = i13 + i(zArr, i13, iArr[j(k11 + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(j11), 15)]);
        zArr[i14 + i(zArr, i14, e.f73690e)] = true;
        return zArr;
    }

    @Override // qd.q
    protected Collection g() {
        return Collections.singleton(BarcodeFormat.CODE_93);
    }
}
