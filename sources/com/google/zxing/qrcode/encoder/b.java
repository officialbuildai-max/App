package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.g;
import id.o;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f33104a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b, reason: collision with root package name */
    static final Charset f33105b = StandardCharsets.ISO_8859_1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33106a;

        static {
            int[] iArr = new int[Mode.values().length];
            f33106a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33106a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33106a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33106a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void a(String str, id.a aVar, Charset charset) {
        for (byte b11 : str.getBytes(charset)) {
            aVar.c(b11, 8);
        }
    }

    static void b(CharSequence charSequence, id.a aVar) {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length) {
            int p11 = p(charSequence.charAt(i11));
            if (p11 == -1) {
                throw new WriterException();
            }
            int i12 = i11 + 1;
            if (i12 < length) {
                int p12 = p(charSequence.charAt(i12));
                if (p12 == -1) {
                    throw new WriterException();
                }
                aVar.c((p11 * 45) + p12, 11);
                i11 += 2;
            } else {
                aVar.c(p11, 6);
                i11 = i12;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(String str, Mode mode, id.a aVar, Charset charset) {
        int i11 = a.f33106a[mode.ordinal()];
        if (i11 == 1) {
            h(str, aVar);
            return;
        }
        if (i11 == 2) {
            b(str, aVar);
            return;
        }
        if (i11 == 3) {
            a(str, aVar, charset);
        } else {
            if (i11 == 4) {
                e(str, aVar);
                return;
            }
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void d(CharacterSetECI characterSetECI, id.a aVar) {
        aVar.c(Mode.ECI.getBits(), 4);
        aVar.c(characterSetECI.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[LOOP:0: B:4:0x000f->B:11:0x003c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void e(java.lang.String r6, id.a r7) {
        /*
            java.nio.charset.Charset r0 = id.o.f65324b
            byte[] r6 = r6.getBytes(r0)
            int r0 = r6.length
            int r0 = r0 % 2
            if (r0 != 0) goto L54
            int r0 = r6.length
            int r0 = r0 + (-1)
            r1 = 0
        Lf:
            if (r1 >= r0) goto L53
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L2b
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L2b
        L29:
            int r2 = r2 - r3
            goto L3a
        L2b:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L39
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L39
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L29
        L39:
            r2 = r4
        L3a:
            if (r2 == r4) goto L4b
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.c(r3, r2)
            int r1 = r1 + 2
            goto Lf
        L4b:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L53:
            return
        L54:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Kanji byte size not even"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.b.e(java.lang.String, id.a):void");
    }

    static void f(int i11, g gVar, Mode mode, id.a aVar) {
        int characterCountBits = mode.getCharacterCountBits(gVar);
        int i12 = 1 << characterCountBits;
        if (i11 < i12) {
            aVar.c(i11, characterCountBits);
            return;
        }
        throw new WriterException(i11 + " is bigger than " + (i12 - 1));
    }

    static void g(Mode mode, id.a aVar) {
        aVar.c(mode.getBits(), 4);
    }

    static void h(CharSequence charSequence, id.a aVar) {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length) {
            int charAt = charSequence.charAt(i11) - '0';
            int i12 = i11 + 2;
            if (i12 < length) {
                aVar.c((charAt * 100) + ((charSequence.charAt(i11 + 1) - '0') * 10) + (charSequence.charAt(i12) - '0'), 10);
                i11 += 3;
            } else {
                i11++;
                if (i11 < length) {
                    aVar.c((charAt * 10) + (charSequence.charAt(i11) - '0'), 7);
                    i11 = i12;
                } else {
                    aVar.c(charAt, 4);
                }
            }
        }
    }

    private static int i(Mode mode, id.a aVar, id.a aVar2, g gVar) {
        return aVar.m() + mode.getCharacterCountBits(gVar) + aVar2.m();
    }

    private static int j(yd.a aVar) {
        return c.a(aVar) + c.c(aVar) + c.d(aVar) + c.e(aVar);
    }

    private static int k(id.a aVar, ErrorCorrectionLevel errorCorrectionLevel, g gVar, yd.a aVar2) {
        int i11 = Integer.MAX_VALUE;
        int i12 = -1;
        for (int i13 = 0; i13 < 8; i13++) {
            d.a(aVar, errorCorrectionLevel, gVar, i13, aVar2);
            int j11 = j(aVar2);
            if (j11 < i11) {
                i12 = i13;
                i11 = j11;
            }
        }
        return i12;
    }

    private static Mode l(String str, Charset charset) {
        if (o.f65324b.equals(charset) && s(str)) {
            return Mode.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt >= '0' && charAt <= '9') {
                z11 = true;
            } else {
                if (p(charAt) == -1) {
                    return Mode.BYTE;
                }
                z10 = true;
            }
        }
        return z10 ? Mode.ALPHANUMERIC : z11 ? Mode.NUMERIC : Mode.BYTE;
    }

    private static g m(int i11, ErrorCorrectionLevel errorCorrectionLevel) {
        for (int i12 = 1; i12 <= 40; i12++) {
            g i13 = g.i(i12);
            if (v(i11, i13, errorCorrectionLevel)) {
                return i13;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x013a, code lost:
    
        if (yd.b.b(r8) != false) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static yd.b n(java.lang.String r6, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r7, java.util.Map r8) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.b.n(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):yd.b");
    }

    static byte[] o(byte[] bArr, int i11) {
        int length = bArr.length;
        int[] iArr = new int[length + i11];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = bArr[i12] & 255;
        }
        new kd.d(kd.a.f66888l).b(iArr, i11);
        byte[] bArr2 = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr2[i13] = (byte) iArr[length + i13];
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i11) {
        int[] iArr = f33104a;
        if (i11 < iArr.length) {
            return iArr[i11];
        }
        return -1;
    }

    static void q(int i11, int i12, int i13, int i14, int[] iArr, int[] iArr2) {
        if (i14 >= i13) {
            throw new WriterException("Block ID too large");
        }
        int i15 = i11 % i13;
        int i16 = i13 - i15;
        int i17 = i11 / i13;
        int i18 = i17 + 1;
        int i19 = i12 / i13;
        int i20 = i19 + 1;
        int i21 = i17 - i19;
        int i22 = i18 - i20;
        if (i21 != i22) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i13 != i16 + i15) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i11 != ((i19 + i21) * i16) + ((i20 + i22) * i15)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i14 < i16) {
            iArr[0] = i19;
            iArr2[0] = i21;
        } else {
            iArr[0] = i20;
            iArr2[0] = i22;
        }
    }

    static id.a r(id.a aVar, int i11, int i12, int i13) {
        if (aVar.n() != i12) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i13);
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < i13; i17++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            q(i11, i12, i13, i17, iArr, iArr2);
            int i18 = iArr[0];
            byte[] bArr = new byte[i18];
            aVar.t(i14 * 8, bArr, 0, i18);
            byte[] o11 = o(bArr, iArr2[0]);
            arrayList.add(new com.google.zxing.qrcode.encoder.a(bArr, o11));
            i15 = Math.max(i15, i18);
            i16 = Math.max(i16, o11.length);
            i14 += iArr[0];
        }
        if (i12 != i14) {
            throw new WriterException("Data bytes does not match offset");
        }
        id.a aVar2 = new id.a();
        for (int i19 = 0; i19 < i15; i19++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] a11 = ((com.google.zxing.qrcode.encoder.a) it.next()).a();
                if (i19 < a11.length) {
                    aVar2.c(a11[i19], 8);
                }
            }
        }
        for (int i20 = 0; i20 < i16; i20++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] b11 = ((com.google.zxing.qrcode.encoder.a) it2.next()).b();
                if (i20 < b11.length) {
                    aVar2.c(b11[i20], 8);
                }
            }
        }
        if (i11 == aVar2.n()) {
            return aVar2;
        }
        throw new WriterException("Interleaving error: " + i11 + " and " + aVar2.n() + " differ.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s(String str) {
        byte[] bytes = str.getBytes(o.f65324b);
        int length = bytes.length;
        if (length % 2 != 0) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11 += 2) {
            int i12 = bytes[i11] & 255;
            if ((i12 < 129 || i12 > 159) && (i12 < 224 || i12 > 235)) {
                return false;
            }
        }
        return true;
    }

    private static g t(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, id.a aVar, id.a aVar2) {
        return m(i(mode, aVar, aVar2, m(i(mode, aVar, aVar2, g.i(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    static void u(int i11, id.a aVar) {
        int i12 = i11 * 8;
        if (aVar.m() > i12) {
            throw new WriterException("data bits cannot fit in the QR Code" + aVar.m() + " > " + i12);
        }
        for (int i13 = 0; i13 < 4 && aVar.m() < i12; i13++) {
            aVar.a(false);
        }
        int m11 = aVar.m() & 7;
        if (m11 > 0) {
            while (m11 < 8) {
                aVar.a(false);
                m11++;
            }
        }
        int n11 = i11 - aVar.n();
        for (int i14 = 0; i14 < n11; i14++) {
            aVar.c((i14 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.m() != i12) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v(int i11, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return gVar.h() - gVar.f(errorCorrectionLevel).d() >= (i11 + 7) / 8;
    }
}
