package wd;

import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.pdf417.encoder.Compaction;
import id.h;
import id.m;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import okio.Utf8;

/* loaded from: classes5.dex */
abstract class e {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f77780c;

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f77778a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f77779b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f77781d = new byte[128];

    /* renamed from: e, reason: collision with root package name */
    private static final Charset f77782e = StandardCharsets.ISO_8859_1;

    /* loaded from: classes5.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f77783a;

        static {
            int[] iArr = new int[Compaction.values().length];
            f77783a = iArr;
            try {
                iArr[Compaction.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f77783a[Compaction.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f77783a[Compaction.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements h {

        /* renamed from: a, reason: collision with root package name */
        String f77784a;

        private b(String str) {
            this.f77784a = str;
        }

        /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        @Override // id.h
        public boolean a(int i11) {
            return false;
        }

        @Override // id.h
        public int b(int i11) {
            return -1;
        }

        @Override // id.h
        public char charAt(int i11) {
            return this.f77784a.charAt(i11);
        }

        @Override // id.h
        public int length() {
            return this.f77784a.length();
        }

        @Override // id.h
        public CharSequence subSequence(int i11, int i12) {
            return this.f77784a.subSequence(i11, i12);
        }

        public String toString() {
            return this.f77784a;
        }
    }

    static {
        int i11 = 0;
        byte[] bArr = new byte[128];
        f77780c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i12 = 0;
        while (true) {
            byte[] bArr2 = f77778a;
            if (i12 >= bArr2.length) {
                break;
            }
            byte b11 = bArr2[i12];
            if (b11 > 0) {
                f77780c[b11] = (byte) i12;
            }
            i12++;
        }
        Arrays.fill(f77781d, (byte) -1);
        while (true) {
            byte[] bArr3 = f77779b;
            if (i11 >= bArr3.length) {
                return;
            }
            byte b12 = bArr3[i11];
            if (b12 > 0) {
                f77781d[b12] = (byte) i11;
            }
            i11++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x002e, code lost:
    
        return r1 - r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(id.h r6, int r7, java.nio.charset.Charset r8) {
        /*
            if (r8 != 0) goto L4
            r8 = 0
            goto L8
        L4:
            java.nio.charset.CharsetEncoder r8 = r8.newEncoder()
        L8:
            int r0 = r6.length()
            r1 = r7
        Ld:
            if (r1 >= r0) goto L67
            r2 = 0
            r3 = r1
        L11:
            r4 = 13
            if (r2 >= r4) goto L2b
            boolean r5 = r6.a(r3)
            if (r5 != 0) goto L2b
            char r3 = r6.charAt(r3)
            boolean r3 = l(r3)
            if (r3 == 0) goto L2b
            int r2 = r2 + 1
            int r3 = r1 + r2
            if (r3 < r0) goto L11
        L2b:
            if (r2 < r4) goto L2f
            int r1 = r1 - r7
            return r1
        L2f:
            if (r8 == 0) goto L64
            char r2 = r6.charAt(r1)
            boolean r2 = r8.canEncode(r2)
            if (r2 == 0) goto L3c
            goto L64
        L3c:
            char r6 = r6.charAt(r1)
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Non-encodable character detected: "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r0 = " (Unicode: "
            r8.append(r0)
            r8.append(r6)
            r6 = 41
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L64:
            int r1 = r1 + 1
            goto Ld
        L67:
            int r1 = r1 - r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: wd.e.a(id.h, int, java.nio.charset.Charset):int");
    }

    private static int b(h hVar, int i11) {
        int length = hVar.length();
        int i12 = 0;
        if (i11 < length) {
            while (i11 < length && !hVar.a(i11) && l(hVar.charAt(i11))) {
                i12++;
                i11++;
            }
        }
        return i12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0027, code lost:
    
        return (r1 - r6) - r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int c(id.h r5, int r6) {
        /*
            int r0 = r5.length()
            r1 = r6
        L5:
            if (r1 >= r0) goto L3f
            r2 = 0
        L8:
            r3 = 13
            if (r2 >= r3) goto L23
            if (r1 >= r0) goto L23
            boolean r4 = r5.a(r1)
            if (r4 != 0) goto L23
            char r4 = r5.charAt(r1)
            boolean r4 = l(r4)
            if (r4 == 0) goto L23
            int r2 = r2 + 1
            int r1 = r1 + 1
            goto L8
        L23:
            if (r2 < r3) goto L28
            int r1 = r1 - r6
            int r1 = r1 - r2
            return r1
        L28:
            if (r2 <= 0) goto L2b
            goto L5
        L2b:
            boolean r2 = r5.a(r1)
            if (r2 != 0) goto L3f
            char r2 = r5.charAt(r1)
            boolean r2 = o(r2)
            if (r2 != 0) goto L3c
            goto L3f
        L3c:
            int r1 = r1 + 1
            goto L5
        L3f:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: wd.e.c(id.h, int):int");
    }

    private static void d(byte[] bArr, int i11, int i12, int i13, StringBuilder sb2) {
        int i14;
        if (i12 == 1 && i13 == 0) {
            sb2.append((char) 913);
        } else if (i12 % 6 == 0) {
            sb2.append((char) 924);
        } else {
            sb2.append((char) 901);
        }
        if (i12 >= 6) {
            char[] cArr = new char[5];
            i14 = i11;
            while ((i11 + i12) - i14 >= 6) {
                long j11 = 0;
                for (int i15 = 0; i15 < 6; i15++) {
                    j11 = (j11 << 8) + (bArr[i14 + i15] & 255);
                }
                for (int i16 = 0; i16 < 5; i16++) {
                    cArr[i16] = (char) (j11 % 900);
                    j11 /= 900;
                }
                for (int i17 = 4; i17 >= 0; i17--) {
                    sb2.append(cArr[i17]);
                }
                i14 += 6;
            }
        } else {
            i14 = i11;
        }
        while (i14 < i11 + i12) {
            sb2.append((char) (bArr[i14] & 255));
            i14++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str, Compaction compaction, Charset charset, boolean z10) {
        h bVar;
        CharacterSetECI characterSetECI;
        if (str.isEmpty()) {
            throw new WriterException("Empty message not allowed");
        }
        if (charset == null && !z10) {
            for (int i11 = 0; i11 < str.length(); i11++) {
                if (str.charAt(i11) > 255) {
                    throw new WriterException("Non-encodable character detected: " + str.charAt(i11) + " (Unicode: " + ((int) str.charAt(i11)) + "). Consider specifying EncodeHintType.PDF417_AUTO_ECI and/or EncodeTypeHint.CHARACTER_SET.");
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        a aVar = null;
        if (z10) {
            bVar = new m(str, charset, -1);
        } else {
            bVar = new b(str, aVar);
            if (charset == null) {
                charset = f77782e;
            } else if (!f77782e.equals(charset) && (characterSetECI = CharacterSetECI.getCharacterSetECI(charset)) != null) {
                i(characterSetECI.getValue(), sb2);
            }
        }
        int length = bVar.length();
        int i12 = a.f77783a[compaction.ordinal()];
        if (i12 == 1) {
            h(bVar, 0, length, sb2, 0);
        } else if (i12 != 2) {
            if (i12 != 3) {
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                while (i13 < length) {
                    while (i13 < length && bVar.a(i13)) {
                        i(bVar.b(i13), sb2);
                        i13++;
                    }
                    if (i13 >= length) {
                        break;
                    }
                    int b11 = b(bVar, i13);
                    if (b11 >= 13) {
                        sb2.append((char) 902);
                        g(bVar, i13, b11, sb2);
                        i13 += b11;
                        i14 = 0;
                        i15 = 2;
                    } else {
                        int c11 = c(bVar, i13);
                        if (c11 >= 5 || b11 == length) {
                            if (i15 != 0) {
                                sb2.append((char) 900);
                                i14 = 0;
                                i15 = 0;
                            }
                            i14 = h(bVar, i13, c11, sb2, i14);
                            i13 += c11;
                        } else {
                            int a11 = a(bVar, i13, z10 ? null : charset);
                            if (a11 == 0) {
                                a11 = 1;
                            }
                            byte[] bytes = z10 ? null : bVar.subSequence(i13, i13 + a11).toString().getBytes(charset);
                            if ((!(bytes == null && a11 == 1) && (bytes == null || bytes.length != 1)) || i15 != 0) {
                                if (z10) {
                                    f(bVar, i13, i13 + a11, i15, sb2);
                                } else {
                                    d(bytes, 0, bytes.length, i15, sb2);
                                }
                                i14 = 0;
                                i15 = 1;
                            } else if (z10) {
                                f(bVar, i13, 1, 0, sb2);
                            } else {
                                d(bytes, 0, 1, 0, sb2);
                            }
                            i13 += a11;
                        }
                    }
                }
            } else {
                sb2.append((char) 902);
                g(bVar, 0, length, sb2);
            }
        } else if (z10) {
            f(bVar, 0, bVar.length(), 0, sb2);
        } else {
            byte[] bytes2 = bVar.toString().getBytes(charset);
            d(bytes2, 0, bytes2.length, 1, sb2);
        }
        return sb2.toString();
    }

    private static void f(h hVar, int i11, int i12, int i13, StringBuilder sb2) {
        int min = Math.min(i12 + i11, hVar.length());
        int i14 = i11;
        while (true) {
            if (i14 >= min || !hVar.a(i14)) {
                int i15 = i14;
                while (i15 < min && !hVar.a(i15)) {
                    i15++;
                }
                int i16 = i15 - i14;
                if (i16 <= 0) {
                    return;
                }
                d(p(hVar, i14, i15), 0, i16, i14 == i11 ? i13 : 1, sb2);
                i14 = i15;
            } else {
                i(hVar.b(i14), sb2);
                i14++;
            }
        }
    }

    private static void g(h hVar, int i11, int i12, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder((i12 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i13 = 0;
        while (i13 < i12) {
            sb3.setLength(0);
            int min = Math.min(44, i12 - i13);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("1");
            int i14 = i11 + i13;
            sb4.append((Object) hVar.subSequence(i14, i14 + min));
            BigInteger bigInteger = new BigInteger(sb4.toString());
            do {
                sb3.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb3.length() - 1; length >= 0; length--) {
                sb2.append(sb3.charAt(length));
            }
            i13 += min;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x010b A[EDGE_INSN: B:24:0x010b->B:25:0x010b BREAK  A[LOOP:0: B:2:0x000f->B:19:0x000f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int h(id.h r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: wd.e.h(id.h, int, int, java.lang.StringBuilder, int):int");
    }

    private static void i(int i11, StringBuilder sb2) {
        if (i11 >= 0 && i11 < 900) {
            sb2.append((char) 927);
            sb2.append((char) i11);
            return;
        }
        if (i11 < 810900) {
            sb2.append((char) 926);
            sb2.append((char) ((i11 / DescriptorProtos$Edition.EDITION_LEGACY_VALUE) - 1));
            sb2.append((char) (i11 % DescriptorProtos$Edition.EDITION_LEGACY_VALUE));
        } else if (i11 < 811800) {
            sb2.append((char) 925);
            sb2.append((char) (810900 - i11));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i11);
        }
    }

    private static boolean j(char c11) {
        return c11 == ' ' || (c11 >= 'a' && c11 <= 'z');
    }

    private static boolean k(char c11) {
        return c11 == ' ' || (c11 >= 'A' && c11 <= 'Z');
    }

    private static boolean l(char c11) {
        return c11 >= '0' && c11 <= '9';
    }

    private static boolean m(char c11) {
        return f77780c[c11] != -1;
    }

    private static boolean n(char c11) {
        return f77781d[c11] != -1;
    }

    private static boolean o(char c11) {
        return c11 == '\t' || c11 == '\n' || c11 == '\r' || (c11 >= ' ' && c11 <= '~');
    }

    static byte[] p(h hVar, int i11, int i12) {
        byte[] bArr = new byte[i12 - i11];
        for (int i13 = i11; i13 < i12; i13++) {
            bArr[i13 - i11] = (byte) (hVar.charAt(i13) & 255);
        }
        return bArr;
    }
}
