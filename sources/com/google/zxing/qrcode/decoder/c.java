package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import id.o;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes4.dex */
abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f33041a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* loaded from: classes4.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33042a;

        static {
            int[] iArr = new int[Mode.values().length];
            f33042a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33042a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33042a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33042a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33042a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33042a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33042a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33042a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33042a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33042a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x003f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013d A[LOOP:0: B:2:0x0021->B:23:0x013d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [int] */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static id.d a(byte[] r21, com.google.zxing.qrcode.decoder.g r22, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r23, java.util.Map r24) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.c.a(byte[], com.google.zxing.qrcode.decoder.g, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):id.d");
    }

    private static void b(id.c cVar, StringBuilder sb2, int i11, boolean z10) {
        while (i11 > 1) {
            if (cVar.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int d11 = cVar.d(11);
            sb2.append(h(d11 / 45));
            sb2.append(h(d11 % 45));
            i11 -= 2;
        }
        if (i11 == 1) {
            if (cVar.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(cVar.d(6)));
        }
        if (z10) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i12 = length + 1;
                        if (sb2.charAt(i12) == '%') {
                            sb2.deleteCharAt(i12);
                        }
                    }
                    sb2.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void c(id.c cVar, StringBuilder sb2, int i11, CharacterSetECI characterSetECI, Collection collection, Map map) {
        if (i11 * 8 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i12] = (byte) cVar.d(8);
        }
        sb2.append(new String(bArr, characterSetECI == null ? o.a(bArr, map) : characterSetECI.getCharset()));
        collection.add(bArr);
    }

    private static void d(id.c cVar, StringBuilder sb2, int i11) {
        if (o.f65325c == null) {
            throw FormatException.getFormatInstance();
        }
        if (i11 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i11 * 2];
        int i12 = 0;
        while (i11 > 0) {
            int d11 = cVar.d(13);
            int i13 = (d11 % 96) | ((d11 / 96) << 8);
            int i14 = i13 + (i13 < 2560 ? 41377 : 42657);
            bArr[i12] = (byte) ((i14 >> 8) & 255);
            bArr[i12 + 1] = (byte) (i14 & 255);
            i12 += 2;
            i11--;
        }
        sb2.append(new String(bArr, o.f65325c));
    }

    private static void e(id.c cVar, StringBuilder sb2, int i11) {
        if (i11 * 13 > cVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i11 * 2];
        int i12 = 0;
        while (i11 > 0) {
            int d11 = cVar.d(13);
            int i13 = (d11 % PsExtractor.AUDIO_STREAM) | ((d11 / PsExtractor.AUDIO_STREAM) << 8);
            int i14 = i13 + (i13 < 7936 ? 33088 : 49472);
            bArr[i12] = (byte) (i14 >> 8);
            bArr[i12 + 1] = (byte) i14;
            i12 += 2;
            i11--;
        }
        sb2.append(new String(bArr, o.f65324b));
    }

    private static void f(id.c cVar, StringBuilder sb2, int i11) {
        while (i11 >= 3) {
            if (cVar.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int d11 = cVar.d(10);
            if (d11 >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(d11 / 100));
            sb2.append(h((d11 / 10) % 10));
            sb2.append(h(d11 % 10));
            i11 -= 3;
        }
        if (i11 == 2) {
            if (cVar.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int d12 = cVar.d(7);
            if (d12 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(d12 / 10));
            sb2.append(h(d12 % 10));
            return;
        }
        if (i11 == 1) {
            if (cVar.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int d13 = cVar.d(4);
            if (d13 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb2.append(h(d13));
        }
    }

    private static int g(id.c cVar) {
        int d11 = cVar.d(8);
        if ((d11 & 128) == 0) {
            return d11 & 127;
        }
        if ((d11 & PsExtractor.AUDIO_STREAM) == 128) {
            return cVar.d(8) | ((d11 & 63) << 8);
        }
        if ((d11 & 224) == 192) {
            return cVar.d(16) | ((d11 & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char h(int i11) {
        char[] cArr = f33041a;
        if (i11 < cArr.length) {
            return cArr[i11];
        }
        throw FormatException.getFormatInstance();
    }
}
