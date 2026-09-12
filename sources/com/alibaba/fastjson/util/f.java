package com.alibaba.fastjson.util;

import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.alibaba.fastjson.JSONException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;
import okio.Utf8;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Properties f18301a = new Properties();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f18302b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f18303c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: d, reason: collision with root package name */
    public static final boolean[] f18304d = new boolean[256];

    /* renamed from: e, reason: collision with root package name */
    public static final boolean[] f18305e = new boolean[256];

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f18306f;

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f18307g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean[] f18308h;

    /* renamed from: i, reason: collision with root package name */
    public static final boolean[] f18309i;

    /* renamed from: j, reason: collision with root package name */
    public static final char[] f18310j;

    /* renamed from: k, reason: collision with root package name */
    public static final char[] f18311k;

    /* renamed from: l, reason: collision with root package name */
    static final char[] f18312l;

    /* renamed from: m, reason: collision with root package name */
    static final char[] f18313m;

    /* renamed from: n, reason: collision with root package name */
    static final char[] f18314n;

    /* renamed from: o, reason: collision with root package name */
    static final int[] f18315o;

    /* renamed from: p, reason: collision with root package name */
    public static final char[] f18316p;

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f18317q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements PrivilegedAction {
        a() {
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.getResourceAsStream("fastjson.properties") : ClassLoader.getSystemResourceAsStream("fastjson.properties");
        }
    }

    static {
        char c11 = 0;
        while (true) {
            boolean[] zArr = f18304d;
            if (c11 >= zArr.length) {
                break;
            }
            if (c11 >= 'A' && c11 <= 'Z') {
                zArr[c11] = true;
            } else if (c11 >= 'a' && c11 <= 'z') {
                zArr[c11] = true;
            } else if (c11 == '_' || c11 == '$') {
                zArr[c11] = true;
            }
            c11 = (char) (c11 + 1);
        }
        char c12 = 0;
        while (true) {
            boolean[] zArr2 = f18305e;
            if (c12 < zArr2.length) {
                if (c12 >= 'A' && c12 <= 'Z') {
                    zArr2[c12] = true;
                } else if (c12 >= 'a' && c12 <= 'z') {
                    zArr2[c12] = true;
                } else if (c12 == '_') {
                    zArr2[c12] = true;
                } else if (c12 >= '0' && c12 <= '9') {
                    zArr2[c12] = true;
                }
                c12 = (char) (c12 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        l();
        byte[] bArr = new byte[161];
        f18306f = bArr;
        byte[] bArr2 = new byte[161];
        f18307g = bArr2;
        f18308h = new boolean[161];
        f18309i = new boolean[161];
        f18310j = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i11 = 14; i11 <= 31; i11++) {
            f18306f[i11] = 4;
            f18307g[i11] = 4;
        }
        for (int i12 = 127; i12 < 160; i12++) {
            f18306f[i12] = 4;
            f18307g[i12] = 4;
        }
        for (int i13 = 0; i13 < 161; i13++) {
            f18308h[i13] = f18306f[i13] != 0;
            f18309i[i13] = f18307g[i13] != 0;
        }
        char[] cArr = f18310j;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        f18311k = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        f18312l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f18313m = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        f18314n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        f18315o = new int[]{9, 99, DescriptorProtos$Edition.EDITION_PROTO3_VALUE, 9999, DescriptorProtos$Edition.EDITION_99999_TEST_ONLY_VALUE, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f18316p = charArray;
        int[] iArr = new int[256];
        f18317q = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i14 = 0; i14 < length; i14++) {
            f18317q[f18316p[i14]] = i14;
        }
        f18317q[61] = 0;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void b(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (flush.isUnderflow()) {
                return;
            }
            flush.throwException();
        } catch (CharacterCodingException e11) {
            throw new JSONException("utf8 decode error, " + e11.getMessage(), e11);
        }
    }

    public static byte[] c(String str) {
        int i11;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i12 = length - 1;
        int i13 = 0;
        while (i13 < i12 && f18317q[str.charAt(i13) & 255] < 0) {
            i13++;
        }
        while (i12 > 0 && f18317q[str.charAt(i12) & 255] < 0) {
            i12--;
        }
        int i14 = str.charAt(i12) == '=' ? str.charAt(i12 + (-1)) == '=' ? 2 : 1 : 0;
        int i15 = (i12 - i13) + 1;
        if (length > 76) {
            i11 = (str.charAt(76) == '\r' ? i15 / 78 : 0) << 1;
        } else {
            i11 = 0;
        }
        int i16 = (((i15 - i11) * 6) >> 3) - i14;
        byte[] bArr = new byte[i16];
        int i17 = (i16 / 3) * 3;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i17) {
            int[] iArr = f18317q;
            int i20 = i13 + 4;
            int i21 = iArr[str.charAt(i13 + 3)] | (iArr[str.charAt(i13 + 1)] << 12) | (iArr[str.charAt(i13)] << 18) | (iArr[str.charAt(i13 + 2)] << 6);
            bArr[i18] = (byte) (i21 >> 16);
            int i22 = i18 + 2;
            bArr[i18 + 1] = (byte) (i21 >> 8);
            i18 += 3;
            bArr[i22] = (byte) i21;
            if (i11 <= 0 || (i19 = i19 + 1) != 19) {
                i13 = i20;
            } else {
                i13 += 6;
                i19 = 0;
            }
        }
        if (i18 < i16) {
            int i23 = 0;
            int i24 = 0;
            while (i13 <= i12 - i14) {
                i23 |= f18317q[str.charAt(i13)] << (18 - (i24 * 6));
                i24++;
                i13++;
            }
            int i25 = 16;
            while (i18 < i16) {
                bArr[i18] = (byte) (i23 >> i25);
                i25 -= 8;
                i18++;
            }
        }
        return bArr;
    }

    public static byte[] d(String str, int i11, int i12) {
        int i13;
        if (i12 == 0) {
            return new byte[0];
        }
        int i14 = (i11 + i12) - 1;
        int i15 = i11;
        while (i15 < i14 && f18317q[str.charAt(i15)] < 0) {
            i15++;
        }
        while (i14 > 0 && f18317q[str.charAt(i14)] < 0) {
            i14--;
        }
        int i16 = str.charAt(i14) == '=' ? str.charAt(i14 + (-1)) == '=' ? 2 : 1 : 0;
        int i17 = (i14 - i15) + 1;
        if (i12 > 76) {
            i13 = (str.charAt(76) == '\r' ? i17 / 78 : 0) << 1;
        } else {
            i13 = 0;
        }
        int i18 = (((i17 - i13) * 6) >> 3) - i16;
        byte[] bArr = new byte[i18];
        int i19 = (i18 / 3) * 3;
        int i20 = 0;
        int i21 = 0;
        while (i20 < i19) {
            int[] iArr = f18317q;
            int i22 = i15 + 4;
            int i23 = iArr[str.charAt(i15 + 3)] | (iArr[str.charAt(i15 + 1)] << 12) | (iArr[str.charAt(i15)] << 18) | (iArr[str.charAt(i15 + 2)] << 6);
            bArr[i20] = (byte) (i23 >> 16);
            int i24 = i20 + 2;
            bArr[i20 + 1] = (byte) (i23 >> 8);
            i20 += 3;
            bArr[i24] = (byte) i23;
            if (i13 <= 0 || (i21 = i21 + 1) != 19) {
                i15 = i22;
            } else {
                i15 += 6;
                i21 = 0;
            }
        }
        if (i20 < i18) {
            int i25 = 0;
            int i26 = 0;
            while (i15 <= i14 - i16) {
                i25 |= f18317q[str.charAt(i15)] << (18 - (i26 * 6));
                i26++;
                i15++;
            }
            int i27 = 16;
            while (i20 < i18) {
                bArr[i20] = (byte) (i25 >> i27);
                i27 -= 8;
                i20++;
            }
        }
        return bArr;
    }

    public static int e(byte[] bArr, int i11, int i12, char[] cArr) {
        int i13 = i11 + i12;
        int min = Math.min(i12, cArr.length);
        int i14 = 0;
        while (i14 < min) {
            byte b11 = bArr[i11];
            if (b11 < 0) {
                break;
            }
            i11++;
            cArr[i14] = (char) b11;
            i14++;
        }
        while (i11 < i13) {
            int i15 = i11 + 1;
            byte b12 = bArr[i11];
            if (b12 >= 0) {
                cArr[i14] = (char) b12;
                i14++;
                i11 = i15;
            } else {
                if ((b12 >> 5) != -2 || (b12 & 30) == 0) {
                    if ((b12 >> 4) == -2) {
                        int i16 = i11 + 2;
                        if (i16 < i13) {
                            byte b13 = bArr[i15];
                            i11 += 3;
                            byte b14 = bArr[i16];
                            if ((b12 != -32 || (b13 & 224) != 128) && (b13 & 192) == 128 && (b14 & 192) == 128) {
                                char c11 = (char) (((b13 << 6) ^ (b12 << 12)) ^ ((-123008) ^ b14));
                                if (c11 >= 55296 && c11 < 57344) {
                                    return -1;
                                }
                                cArr[i14] = c11;
                                i14++;
                            }
                        }
                        return -1;
                    }
                    if ((b12 >> 3) == -2 && i11 + 3 < i13) {
                        byte b15 = bArr[i15];
                        int i17 = i11 + 3;
                        byte b16 = bArr[i11 + 2];
                        i11 += 4;
                        byte b17 = bArr[i17];
                        int i18 = (((b12 << 18) ^ (b15 << 12)) ^ (b16 << 6)) ^ (3678080 ^ b17);
                        if ((b15 & 192) == 128 && (b16 & 192) == 128 && (b17 & 192) == 128 && i18 >= 65536 && i18 < 1114112) {
                            int i19 = i14 + 1;
                            cArr[i14] = (char) ((i18 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                            i14 += 2;
                            cArr[i19] = (char) ((i18 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                        }
                    }
                    return -1;
                }
                if (i15 >= i13) {
                    return -1;
                }
                i11 += 2;
                byte b18 = bArr[i15];
                if ((b18 & 192) != 128) {
                    return -1;
                }
                cArr[i14] = (char) ((b18 ^ (b12 << 6)) ^ Utf8.MASK_2BYTES);
                i14++;
            }
        }
        return i14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int, char] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int f(char[] r9, int r10, int r11, byte[] r12) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.f.f(char[], int, int, byte[]):int");
    }

    public static boolean g(char c11) {
        boolean[] zArr = f18304d;
        return c11 < zArr.length && zArr[c11];
    }

    public static void h(int i11, int i12, char[] cArr) {
        char c11;
        if (i11 < 0) {
            i11 = -i11;
            c11 = '-';
        } else {
            c11 = 0;
        }
        while (i11 >= 65536) {
            int i13 = i11 / 100;
            int i14 = i11 - (((i13 << 6) + (i13 << 5)) + (i13 << 2));
            cArr[i12 - 1] = f18314n[i14];
            i12 -= 2;
            cArr[i12] = f18313m[i14];
            i11 = i13;
        }
        while (true) {
            int i15 = (52429 * i11) >>> 19;
            int i16 = i12 - 1;
            cArr[i16] = f18312l[i11 - ((i15 << 3) + (i15 << 1))];
            if (i15 == 0) {
                break;
            }
            i11 = i15;
            i12 = i16;
        }
        if (c11 != 0) {
            cArr[i12 - 2] = c11;
        }
    }

    public static void i(long j11, int i11, char[] cArr) {
        char c11;
        if (j11 < 0) {
            j11 = -j11;
            c11 = '-';
        } else {
            c11 = 0;
        }
        while (j11 > 2147483647L) {
            long j12 = j11 / 100;
            int i12 = (int) (j11 - (((j12 << 6) + (j12 << 5)) + (j12 << 2)));
            cArr[i11 - 1] = f18314n[i12];
            i11 -= 2;
            cArr[i11] = f18313m[i12];
            j11 = j12;
        }
        int i13 = (int) j11;
        while (i13 >= 65536) {
            int i14 = i13 / 100;
            int i15 = i13 - (((i14 << 6) + (i14 << 5)) + (i14 << 2));
            cArr[i11 - 1] = f18314n[i15];
            i11 -= 2;
            cArr[i11] = f18313m[i15];
            i13 = i14;
        }
        while (true) {
            int i16 = (52429 * i13) >>> 19;
            int i17 = i11 - 1;
            cArr[i17] = f18312l[i13 - ((i16 << 3) + (i16 << 1))];
            if (i16 == 0) {
                break;
            }
            i13 = i16;
            i11 = i17;
        }
        if (c11 != 0) {
            cArr[i11 - 2] = c11;
        }
    }

    public static String j(String str) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        return str2 == null ? f18301a.getProperty(str) : str2;
    }

    public static boolean k(char c11) {
        boolean[] zArr = f18305e;
        return c11 < zArr.length && zArr[c11];
    }

    public static void l() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new a());
        if (inputStream != null) {
            try {
                f18301a.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String m(Reader reader) {
        StringBuilder sb2 = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb2.toString();
                }
                sb2.append(cArr, 0, read);
            }
        } catch (Exception e11) {
            throw new JSONException("read string from reader error", e11);
        }
    }

    public static int n(int i11) {
        int i12 = 0;
        while (i11 > f18315o[i12]) {
            i12++;
        }
        return i12 + 1;
    }

    public static int o(long j11) {
        long j12 = 10;
        for (int i11 = 1; i11 < 19; i11++) {
            if (j11 < j12) {
                return i11;
            }
            j12 *= 10;
        }
        return 19;
    }
}
