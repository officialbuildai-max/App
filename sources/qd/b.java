package qd;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public final class b extends q {

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f73679b;

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f73680c = {'T', 'N', '*', 'E'};

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f73681d = {'/', ':', '+', '.'};

    /* renamed from: e, reason: collision with root package name */
    private static final char f73682e;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f73679b = cArr;
        f73682e = cArr[0];
    }

    @Override // qd.q
    public boolean[] d(String str) {
        int i11;
        if (str.length() < 2) {
            StringBuilder sb2 = new StringBuilder();
            char c11 = f73682e;
            sb2.append(c11);
            sb2.append(str);
            sb2.append(c11);
            str = sb2.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f73679b;
            boolean h11 = a.h(cArr, upperCase);
            boolean h12 = a.h(cArr, upperCase2);
            char[] cArr2 = f73680c;
            boolean h13 = a.h(cArr2, upperCase);
            boolean h14 = a.h(cArr2, upperCase2);
            if (h11) {
                if (!h12) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!h13) {
                if (h12 || h14) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                StringBuilder sb3 = new StringBuilder();
                char c12 = f73682e;
                sb3.append(c12);
                sb3.append(str);
                sb3.append(c12);
                str = sb3.toString();
            } else if (!h14) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            }
        }
        int i12 = 20;
        for (int i13 = 1; i13 < str.length() - 1; i13++) {
            if (Character.isDigit(str.charAt(i13)) || str.charAt(i13) == '-' || str.charAt(i13) == '$') {
                i12 += 9;
            } else {
                if (!a.h(f73681d, str.charAt(i13))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i13) + '\'');
                }
                i12 += 10;
            }
        }
        boolean[] zArr = new boolean[i12 + (str.length() - 1)];
        int i14 = 0;
        for (int i15 = 0; i15 < str.length(); i15++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i15));
            if (i15 == 0 || i15 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i16 = 0;
            while (true) {
                char[] cArr3 = a.f73673d;
                if (i16 >= cArr3.length) {
                    i11 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i16]) {
                    i11 = a.f73674e[i16];
                    break;
                }
                i16++;
            }
            int i17 = 0;
            int i18 = 0;
            boolean z10 = true;
            while (i17 < 7) {
                zArr[i14] = z10;
                i14++;
                if (((i11 >> (6 - i17)) & 1) == 0 || i18 == 1) {
                    z10 = !z10;
                    i17++;
                    i18 = 0;
                } else {
                    i18++;
                }
            }
            if (i15 < str.length() - 1) {
                zArr[i14] = false;
                i14++;
            }
        }
        return zArr;
    }

    @Override // qd.q
    protected Collection g() {
        return Collections.singleton(BarcodeFormat.CODABAR);
    }
}
