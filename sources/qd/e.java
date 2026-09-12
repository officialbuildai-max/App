package qd;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Arrays;
import java.util.Map;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes5.dex */
public final class e extends p {

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f73688c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    static final int[] f73689d;

    /* renamed from: e, reason: collision with root package name */
    static final int f73690e;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f73691a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final int[] f73692b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, MiniAppConfigHelper.DEFAULT_MINIAPP_ALL_DATA_MAX_SIZE, 336, 274, 266, 424, UnixStat.DEFAULT_FILE_PERM, 418, TTAdConstant.DEEPLINK_FALLBACK_CODE, TTAdConstant.AD_ID_IS_NULL_CODE, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, TTAdConstant.LANDING_PAGE_TYPE_CODE, TTAdConstant.IMAGE_LIST_SIZE_CODE, 364, 358, Sdk$SDKError.Reason.AD_HTML_FAILED_TO_LOAD_VALUE, Sdk$SDKError.Reason.LINK_COMMAND_OPEN_FAILED_VALUE, Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f73689d = iArr;
        f73690e = iArr[47];
    }

    private static void h(CharSequence charSequence) {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    private static void i(CharSequence charSequence, int i11, int i12) {
        int i13 = 0;
        int i14 = 1;
        for (int i15 = i11 - 1; i15 >= 0; i15--) {
            i13 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i15)) * i14;
            i14++;
            if (i14 > i12) {
                i14 = 1;
            }
        }
        if (charSequence.charAt(i11) != f73688c[i13 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0029. Please report as an issue. */
    private static String j(CharSequence charSequence) {
        int i11;
        char c11;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i12 = 0;
        while (i12 < length) {
            char charAt = charSequence.charAt(i12);
            if (charAt < 'a' || charAt > 'd') {
                sb2.append(charAt);
            } else {
                if (i12 >= length - 1) {
                    throw FormatException.getFormatInstance();
                }
                i12++;
                char charAt2 = charSequence.charAt(i12);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i11 = charAt2 - '@';
                            c11 = (char) i11;
                            sb2.append(c11);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
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
                                    if (charAt2 < 'X' || charAt2 > 'Z') {
                                        throw FormatException.getFormatInstance();
                                    }
                                    c11 = 127;
                                }
                                sb2.append(c11);
                                break;
                            }
                            c11 = 0;
                            sb2.append(c11);
                        } else {
                            i11 = charAt2 + '+';
                        }
                        c11 = (char) i11;
                        sb2.append(c11);
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i11 = charAt2 - ' ';
                            c11 = (char) i11;
                            sb2.append(c11);
                        } else {
                            if (charAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            c11 = ':';
                            sb2.append(c11);
                            break;
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i11 = charAt2 + ' ';
                            c11 = (char) i11;
                            sb2.append(c11);
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    default:
                        c11 = 0;
                        sb2.append(c11);
                        break;
                }
            }
            i12++;
        }
        return sb2.toString();
    }

    private int[] k(id.a aVar) {
        int m11 = aVar.m();
        int k11 = aVar.k(0);
        Arrays.fill(this.f73692b, 0);
        int[] iArr = this.f73692b;
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
                    if (m(iArr) == f73690e) {
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

    private static char l(int i11) {
        int i12 = 0;
        while (true) {
            int[] iArr = f73689d;
            if (i12 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i12] == i11) {
                return f73688c[i12];
            }
            i12++;
        }
    }

    private static int m(int[] iArr) {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 += i12;
        }
        int length = iArr.length;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            int round = Math.round((iArr[i14] * 9.0f) / i11);
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i14 & 1) == 0) {
                for (int i15 = 0; i15 < round; i15++) {
                    i13 = (i13 << 1) | 1;
                }
            } else {
                i13 <<= round;
            }
        }
        return i13;
    }

    @Override // qd.p
    public com.google.zxing.j c(int i11, id.a aVar, Map map) {
        int k11 = aVar.k(k(aVar)[1]);
        int m11 = aVar.m();
        int[] iArr = this.f73692b;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f73691a;
        sb2.setLength(0);
        while (true) {
            p.f(aVar, k11, iArr);
            int m12 = m(iArr);
            if (m12 < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char l11 = l(m12);
            sb2.append(l11);
            int i12 = k11;
            for (int i13 : iArr) {
                i12 += i13;
            }
            int k12 = aVar.k(i12);
            if (l11 == '*') {
                sb2.deleteCharAt(sb2.length() - 1);
                int i14 = 0;
                for (int i15 : iArr) {
                    i14 += i15;
                }
                if (k12 == m11 || !aVar.i(k12)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sb2.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                h(sb2);
                sb2.setLength(sb2.length() - 2);
                float f11 = i11;
                com.google.zxing.j jVar = new com.google.zxing.j(j(sb2), null, new com.google.zxing.k[]{new com.google.zxing.k((r0[1] + r0[0]) / 2.0f, f11), new com.google.zxing.k(k11 + (i14 / 2.0f), f11)}, BarcodeFormat.CODE_93);
                jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]G0");
                return jVar;
            }
            k11 = k12;
        }
    }
}
