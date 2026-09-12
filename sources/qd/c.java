package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes5.dex */
public final class c extends p {

    /* renamed from: e, reason: collision with root package name */
    static final int[] f73683e = {52, 289, 97, 352, 49, Sdk$SDKError.Reason.AD_EXPIRED_VALUE, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, Sdk$SDKError.Reason.INVALID_BID_PAYLOAD_VALUE, Sdk$SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 388, 196, 168, 162, 138, 42};

    /* renamed from: a, reason: collision with root package name */
    private final boolean f73684a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f73685b;

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f73686c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f73687d;

    public c() {
        this(false);
    }

    public c(boolean z10) {
        this(z10, false);
    }

    public c(boolean z10, boolean z11) {
        this.f73684a = z10;
        this.f73685b = z11;
        this.f73686c = new StringBuilder(20);
        this.f73687d = new int[9];
    }

    private static String h(CharSequence charSequence) {
        int i11;
        char c11;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i12 = 0;
        while (i12 < length) {
            char charAt = charSequence.charAt(i12);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i12++;
                char charAt2 = charSequence.charAt(i12);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt == '/') {
                                if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i11 = charAt2 - ' ';
                                } else {
                                    if (charAt2 != 'Z') {
                                        throw FormatException.getFormatInstance();
                                    }
                                    c11 = ':';
                                    sb2.append(c11);
                                }
                            }
                            c11 = 0;
                            sb2.append(c11);
                        } else {
                            if (charAt2 < 'A' || charAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i11 = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i11 = charAt2 - '&';
                    } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                        i11 = charAt2 - 11;
                    } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                        i11 = charAt2 + 16;
                    } else if (charAt2 < 'P' || charAt2 > 'T') {
                        if (charAt2 != 'U') {
                            if (charAt2 == 'V') {
                                c11 = '@';
                            } else if (charAt2 == 'W') {
                                c11 = '`';
                            } else {
                                if (charAt2 != 'X' && charAt2 != 'Y' && charAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c11 = 127;
                            }
                            sb2.append(c11);
                        }
                        c11 = 0;
                        sb2.append(c11);
                    } else {
                        i11 = charAt2 + '+';
                    }
                } else {
                    if (charAt2 < 'A' || charAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i11 = charAt2 - '@';
                }
                c11 = (char) i11;
                sb2.append(c11);
            } else {
                sb2.append(charAt);
            }
            i12++;
        }
        return sb2.toString();
    }

    private static int[] i(id.a aVar, int[] iArr) {
        int m11 = aVar.m();
        int k11 = aVar.k(0);
        int length = iArr.length;
        boolean z10 = false;
        int i11 = 0;
        int i12 = k11;
        while (k11 < m11) {
            if (aVar.i(k11) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else {
                    if (k(iArr) == 148 && aVar.o(Math.max(0, i12 - ((k11 - i12) / 2)), i12, false)) {
                        return new int[]{i12, k11};
                    }
                    i12 += iArr[0] + iArr[1];
                    int i13 = i11 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i11] = 0;
                    i11--;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            k11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char j(int i11) {
        int i12 = 0;
        while (true) {
            int[] iArr = f73683e;
            if (i12 >= iArr.length) {
                if (i11 == 148) {
                    return '*';
                }
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i12] == i11) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i12);
            }
            i12++;
        }
    }

    private static int k(int[] iArr) {
        int length = iArr.length;
        int i11 = 0;
        while (true) {
            int i12 = Integer.MAX_VALUE;
            for (int i13 : iArr) {
                if (i13 < i12 && i13 > i11) {
                    i12 = i13;
                }
            }
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                int i18 = iArr[i17];
                if (i18 > i12) {
                    i15 |= 1 << ((length - 1) - i17);
                    i14++;
                    i16 += i18;
                }
            }
            if (i14 == 3) {
                for (int i19 = 0; i19 < length && i14 > 0; i19++) {
                    int i20 = iArr[i19];
                    if (i20 > i12) {
                        i14--;
                        if (i20 * 2 >= i16) {
                            return -1;
                        }
                    }
                }
                return i15;
            }
            if (i14 <= 3) {
                return -1;
            }
            i11 = i12;
        }
    }

    @Override // qd.p
    public com.google.zxing.j c(int i11, id.a aVar, Map map) {
        int[] iArr = this.f73687d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f73686c;
        sb2.setLength(0);
        int k11 = aVar.k(i(aVar, iArr)[1]);
        int m11 = aVar.m();
        while (true) {
            p.f(aVar, k11, iArr);
            int k12 = k(iArr);
            if (k12 < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char j11 = j(k12);
            sb2.append(j11);
            int i12 = k11;
            for (int i13 : iArr) {
                i12 += i13;
            }
            int k13 = aVar.k(i12);
            if (j11 == '*') {
                sb2.setLength(sb2.length() - 1);
                int i14 = 0;
                for (int i15 : iArr) {
                    i14 += i15;
                }
                int i16 = (k13 - k11) - i14;
                if (k13 != m11 && i16 * 2 < i14) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.f73684a) {
                    int length = sb2.length() - 1;
                    int i17 = 0;
                    for (int i18 = 0; i18 < length; i18++) {
                        i17 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f73686c.charAt(i18));
                    }
                    if (sb2.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i17 % 43)) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    sb2.setLength(length);
                }
                if (sb2.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f11 = i11;
                com.google.zxing.j jVar = new com.google.zxing.j(this.f73685b ? h(sb2) : sb2.toString(), null, new com.google.zxing.k[]{new com.google.zxing.k((r3[1] + r3[0]) / 2.0f, f11), new com.google.zxing.k(k11 + (i14 / 2.0f), f11)}, BarcodeFormat.CODE_39);
                jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]A0");
                return jVar;
            }
            k11 = k13;
        }
    }
}
