package com.google.zxing.aztec.decoder;

import be.g;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.gslb.Utils;
import id.d;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kd.c;

/* loaded from: classes4.dex */
public final class Decoder {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f32869b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f32870c = {"CTRL_PS", " ", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "d", "e", "f", g.f16474b, "h", "i", j.f35620b, CampaignEx.JSON_KEY_AD_K, "l", "m", "n", "o", TtmlNode.TAG_P, CampaignEx.JSON_KEY_AD_Q, CampaignEx.JSON_KEY_AD_R, "s", "t", TmcStartParams.KEY_URL_SHORT, "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f32871d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f32872e = {"FLG(n)", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", Utils.SEPARATOR, "$", "%", UrlUtils.AND_MARK, "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", UrlUtils.EQUAL_MARK, ">", UrlUtils.QUESTION_MARK, "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f32873f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: g, reason: collision with root package name */
    private static final Charset f32874g = StandardCharsets.ISO_8859_1;

    /* renamed from: a, reason: collision with root package name */
    private ed.a f32875a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32876a;

        static {
            int[] iArr = new int[Table.values().length];
            f32876a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32876a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32876a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32876a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32876a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final boolean[] f32877a;

        /* renamed from: b, reason: collision with root package name */
        private final int f32878b;

        /* renamed from: c, reason: collision with root package name */
        private final int f32879c;

        b(boolean[] zArr, int i11, int i12) {
            this.f32877a = zArr;
            this.f32878b = i11;
            this.f32879c = i12;
        }
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = h(zArr, i11 * 8);
        }
        return bArr;
    }

    private b b(boolean[] zArr) {
        int i11;
        kd.a aVar;
        if (this.f32875a.e() <= 2) {
            aVar = kd.a.f66886j;
            i11 = 6;
        } else {
            i11 = 8;
            if (this.f32875a.e() <= 8) {
                aVar = kd.a.f66890n;
            } else if (this.f32875a.e() <= 22) {
                aVar = kd.a.f66885i;
                i11 = 10;
            } else {
                aVar = kd.a.f66884h;
                i11 = 12;
            }
        }
        int d11 = this.f32875a.d();
        int length = zArr.length / i11;
        if (length < d11) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i11;
        int[] iArr = new int[length];
        int i12 = 0;
        while (i12 < length) {
            iArr[i12] = i(zArr, length2, i11);
            i12++;
            length2 += i11;
        }
        try {
            c cVar = new c(aVar);
            int i13 = length - d11;
            int a11 = cVar.a(iArr, i13);
            int i14 = 1 << i11;
            int i15 = i14 - 1;
            int i16 = 0;
            for (int i17 = 0; i17 < d11; i17++) {
                int i18 = iArr[i17];
                if (i18 == 0 || i18 == i15) {
                    throw FormatException.getFormatInstance();
                }
                if (i18 == 1 || i18 == i14 - 2) {
                    i16++;
                }
            }
            boolean[] zArr2 = new boolean[(d11 * i11) - i16];
            int i19 = 0;
            for (int i20 = 0; i20 < d11; i20++) {
                int i21 = iArr[i20];
                if (i21 == 1 || i21 == i14 - 2) {
                    Arrays.fill(zArr2, i19, (i19 + i11) - 1, i21 > 1);
                    i19 += i11 - 1;
                } else {
                    int i22 = i11 - 1;
                    while (i22 >= 0) {
                        int i23 = i19 + 1;
                        zArr2[i19] = (i21 & (1 << i22)) != 0;
                        i22--;
                        i19 = i23;
                    }
                }
            }
            return new b(zArr2, a11, (i13 * 100) / length);
        } catch (ReedSolomonException e11) {
            throw FormatException.getFormatInstance(e11);
        }
    }

    private boolean[] d(id.b bVar) {
        boolean f11 = this.f32875a.f();
        int e11 = this.f32875a.e();
        int i11 = (f11 ? 11 : 14) + (e11 * 4);
        int[] iArr = new int[i11];
        boolean[] zArr = new boolean[j(e11, f11)];
        int i12 = 2;
        if (f11) {
            for (int i13 = 0; i13 < i11; i13++) {
                iArr[i13] = i13;
            }
        } else {
            int i14 = i11 / 2;
            int i15 = ((i11 + 1) + (((i14 - 1) / 15) * 2)) / 2;
            for (int i16 = 0; i16 < i14; i16++) {
                iArr[(i14 - i16) - 1] = (i15 - r12) - 1;
                iArr[i14 + i16] = (i16 / 15) + i16 + i15 + 1;
            }
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < e11) {
            int i19 = ((e11 - i17) * 4) + (f11 ? 9 : 12);
            int i20 = i17 * 2;
            int i21 = (i11 - 1) - i20;
            int i22 = 0;
            while (i22 < i19) {
                int i23 = i22 * 2;
                int i24 = 0;
                while (i24 < i12) {
                    int i25 = i20 + i24;
                    int i26 = i20 + i22;
                    zArr[i18 + i23 + i24] = bVar.g(iArr[i25], iArr[i26]);
                    int i27 = iArr[i26];
                    int i28 = i21 - i24;
                    zArr[(i19 * 2) + i18 + i23 + i24] = bVar.g(i27, iArr[i28]);
                    int i29 = i21 - i22;
                    zArr[(i19 * 4) + i18 + i23 + i24] = bVar.g(iArr[i28], iArr[i29]);
                    zArr[(i19 * 6) + i18 + i23 + i24] = bVar.g(iArr[i29], iArr[i25]);
                    i24++;
                    e11 = e11;
                    f11 = f11;
                    i12 = 2;
                }
                i22++;
                i12 = 2;
            }
            i18 += i19 * 8;
            i17++;
            i12 = 2;
        }
        return zArr;
    }

    private static String e(Table table, int i11) {
        int i12 = a.f32876a[table.ordinal()];
        if (i12 == 1) {
            return f32869b[i11];
        }
        if (i12 == 2) {
            return f32870c[i11];
        }
        if (i12 == 3) {
            return f32871d[i11];
        }
        if (i12 == 4) {
            return f32872e[i11];
        }
        if (i12 == 5) {
            return f32873f[i11];
        }
        throw new IllegalStateException("Bad table");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b7, code lost:
    
        throw com.google.zxing.FormatException.getFormatInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String f(boolean[] r14) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.f(boolean[]):java.lang.String");
    }

    private static Table g(char c11) {
        return c11 != 'B' ? c11 != 'D' ? c11 != 'P' ? c11 != 'L' ? c11 != 'M' ? Table.UPPER : Table.MIXED : Table.LOWER : Table.PUNCT : Table.DIGIT : Table.BINARY;
    }

    private static byte h(boolean[] zArr, int i11) {
        int length = zArr.length - i11;
        return (byte) (length >= 8 ? i(zArr, i11, 8) : i(zArr, i11, length) << (8 - length));
    }

    private static int i(boolean[] zArr, int i11, int i12) {
        int i13 = 0;
        for (int i14 = i11; i14 < i11 + i12; i14++) {
            i13 <<= 1;
            if (zArr[i14]) {
                i13 |= 1;
            }
        }
        return i13;
    }

    private static int j(int i11, boolean z10) {
        return ((z10 ? 88 : 112) + (i11 * 16)) * i11;
    }

    public d c(ed.a aVar) {
        this.f32875a = aVar;
        b b11 = b(d(aVar.a()));
        d dVar = new d(a(b11.f32877a), f(b11.f32877a), null, String.format("%d%%", Integer.valueOf(b11.f32879c)));
        dVar.o(b11.f32877a.length);
        dVar.n(Integer.valueOf(b11.f32878b));
        return dVar;
    }
}
