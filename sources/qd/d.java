package qd;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public final class d extends q {
    private static void i(int i11, int[] iArr) {
        for (int i12 = 0; i12 < 9; i12++) {
            int i13 = 1;
            if (((1 << (8 - i12)) & i11) != 0) {
                i13 = 2;
            }
            iArr[i12] = i13;
        }
    }

    private static String j(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt != 0) {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        sb2.append("%V");
                    } else if (charAt == '`') {
                        sb2.append("%W");
                    } else if (charAt != '-' && charAt != '.') {
                        if (charAt <= 26) {
                            sb2.append('$');
                            sb2.append((char) (charAt + '@'));
                        } else if (charAt < ' ') {
                            sb2.append('%');
                            sb2.append((char) (charAt + '&'));
                        } else if (charAt <= ',' || charAt == '/' || charAt == ':') {
                            sb2.append('/');
                            sb2.append((char) (charAt + ' '));
                        } else if (charAt <= '9') {
                            sb2.append(charAt);
                        } else if (charAt <= '?') {
                            sb2.append('%');
                            sb2.append((char) (charAt + 11));
                        } else if (charAt <= 'Z') {
                            sb2.append(charAt);
                        } else if (charAt <= '_') {
                            sb2.append('%');
                            sb2.append((char) (charAt - 16));
                        } else if (charAt <= 'z') {
                            sb2.append('+');
                            sb2.append((char) (charAt - ' '));
                        } else {
                            if (charAt > 127) {
                                throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i11) + "'");
                            }
                            sb2.append('%');
                            sb2.append((char) (charAt - '+'));
                        }
                    }
                }
                sb2.append(charAt);
            } else {
                sb2.append("%U");
            }
        }
        return sb2.toString();
    }

    @Override // qd.q
    public boolean[] d(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i11)) < 0) {
                str = j(str);
                length = str.length();
                if (length > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            } else {
                i11++;
            }
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[(length * 13) + 25];
        i(148, iArr);
        int b11 = q.b(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int b12 = b11 + q.b(zArr, b11, iArr2, false);
        for (int i12 = 0; i12 < length; i12++) {
            i(c.f73683e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i12))], iArr);
            int b13 = b12 + q.b(zArr, b12, iArr, true);
            b12 = b13 + q.b(zArr, b13, iArr2, false);
        }
        i(148, iArr);
        q.b(zArr, b12, iArr, true);
        return zArr;
    }

    @Override // qd.q
    protected Collection g() {
        return Collections.singleton(BarcodeFormat.CODE_39);
    }
}
