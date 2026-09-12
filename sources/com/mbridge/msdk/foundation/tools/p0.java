package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* loaded from: classes5.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f35839a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f35840b = new byte[128];

    /* renamed from: c, reason: collision with root package name */
    private static Map<Character, Character> f35841c;

    /* renamed from: d, reason: collision with root package name */
    private static char[] f35842d;

    static {
        HashMap hashMap = new HashMap();
        f35841c = hashMap;
        hashMap.put('A', 'v');
        f35841c.put('B', 'S');
        f35841c.put('C', 'o');
        f35841c.put('D', 'a');
        f35841c.put('E', 'j');
        f35841c.put('F', 'c');
        f35841c.put('G', '7');
        f35841c.put('H', 'd');
        f35841c.put('I', 'R');
        f35841c.put('J', 'z');
        f35841c.put('K', 'p');
        f35841c.put('L', 'W');
        f35841c.put('M', 'i');
        f35841c.put('N', 'f');
        f35841c.put('O', 'G');
        f35841c.put('P', 'y');
        f35841c.put('Q', 'N');
        f35841c.put('R', 'x');
        f35841c.put('S', 'Z');
        f35841c.put('T', 'n');
        f35841c.put('U', 'V');
        f35841c.put('V', '5');
        f35841c.put('W', 'k');
        f35841c.put('X', '+');
        f35841c.put('Y', 'D');
        f35841c.put('Z', 'H');
        f35841c.put('a', 'L');
        f35841c.put('b', 'Y');
        f35841c.put('c', 'h');
        f35841c.put('d', 'J');
        f35841c.put('e', '4');
        f35841c.put('f', '6');
        f35841c.put('g', 'l');
        f35841c.put('h', 't');
        f35841c.put('i', '0');
        f35841c.put('j', 'U');
        f35841c.put('k', '3');
        f35841c.put('l', 'Q');
        f35841c.put('m', 'r');
        f35841c.put('n', 'g');
        f35841c.put('o', 'E');
        f35841c.put('p', 'u');
        f35841c.put('q', 'q');
        f35841c.put('r', '8');
        f35841c.put('s', 's');
        f35841c.put('t', 'w');
        f35841c.put('u', '/');
        f35841c.put('v', 'X');
        f35841c.put('w', 'M');
        f35841c.put('x', 'e');
        f35841c.put('y', 'B');
        f35841c.put('z', 'A');
        f35841c.put('0', 'T');
        f35841c.put('1', '2');
        f35841c.put('2', 'F');
        f35841c.put('3', 'b');
        f35841c.put('4', '9');
        f35841c.put('5', 'P');
        f35841c.put('6', '1');
        f35841c.put('7', 'O');
        f35841c.put('8', 'I');
        f35841c.put('9', 'K');
        f35841c.put('+', 'm');
        f35841c.put('/', 'C');
        f35842d = new char[64];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            char[] cArr = f35839a;
            if (i12 >= cArr.length) {
                break;
            }
            f35842d[i12] = f35841c.get(Character.valueOf(cArr[i12])).charValue();
            i12++;
        }
        int i13 = 0;
        while (true) {
            byte[] bArr = f35840b;
            if (i13 >= bArr.length) {
                break;
            }
            bArr[i13] = Byte.MAX_VALUE;
            i13++;
        }
        while (true) {
            char[] cArr2 = f35842d;
            if (i11 >= cArr2.length) {
                return;
            }
            f35840b[cArr2[i11]] = (byte) i11;
            i11++;
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i11) {
        try {
            char c11 = cArr[3];
            char c12 = c11 == '=' ? (char) 2 : (char) 3;
            char c13 = cArr[2];
            if (c13 == '=') {
                c12 = 1;
            }
            byte[] bArr2 = f35840b;
            byte b11 = bArr2[cArr[0]];
            byte b12 = bArr2[cArr[1]];
            byte b13 = bArr2[c13];
            byte b14 = bArr2[c11];
            if (c12 == 1) {
                bArr[i11] = (byte) (((b12 >> 4) & 3) | ((b11 << 2) & 252));
                return 1;
            }
            if (c12 == 2) {
                bArr[i11] = (byte) ((3 & (b12 >> 4)) | ((b11 << 2) & 252));
                bArr[i11 + 1] = (byte) (((b12 << 4) & 240) | ((b13 >> 2) & 15));
                return 2;
            }
            if (c12 != 3) {
                throw new RuntimeException("Internal Error");
            }
            bArr[i11] = (byte) (((b11 << 2) & 252) | ((b12 >> 4) & 3));
            bArr[i11 + 1] = (byte) (((b12 << 4) & 240) | ((b13 >> 2) & 15));
            bArr[i11 + 2] = (byte) (((b13 << 6) & PsExtractor.AUDIO_STREAM) | (b14 & Utf8.REPLACEMENT_BYTE));
            return 3;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i11, int i12) {
        if (i12 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[((i12 / 3) << 2) + 4];
            int i13 = 0;
            while (i12 >= 3) {
                int i14 = ((bArr[i11] & 255) << 16) + ((bArr[i11 + 1] & 255) << 8) + (bArr[i11 + 2] & 255);
                char[] cArr2 = f35842d;
                cArr[i13] = cArr2[i14 >> 18];
                cArr[i13 + 1] = cArr2[(i14 >> 12) & 63];
                int i15 = i13 + 3;
                cArr[i13 + 2] = cArr2[(i14 >> 6) & 63];
                i13 += 4;
                cArr[i15] = cArr2[i14 & 63];
                i11 += 3;
                i12 -= 3;
            }
            if (i12 == 1) {
                int i16 = bArr[i11] & 255;
                char[] cArr3 = f35842d;
                cArr[i13] = cArr3[i16 >> 2];
                cArr[i13 + 1] = cArr3[(i16 << 4) & 63];
                int i17 = i13 + 3;
                cArr[i13 + 2] = '=';
                i13 += 4;
                cArr[i17] = '=';
            } else if (i12 == 2) {
                int i18 = ((bArr[i11] & 255) << 8) + (bArr[i11 + 1] & 255);
                char[] cArr4 = f35842d;
                cArr[i13] = cArr4[i18 >> 10];
                cArr[i13 + 1] = cArr4[(i18 >> 4) & 63];
                int i19 = i13 + 3;
                cArr[i13 + 2] = cArr4[(i18 << 2) & 63];
                i13 += 4;
                cArr[i19] = '=';
            }
            return new String(cArr, 0, i13);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] a(String str) {
        int i11;
        try {
            int length = str.length();
            char[] cArr = new char[length < 259 ? length : 259];
            int i12 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i12];
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i13 < length) {
                int i16 = i13 + 256;
                if (i16 <= length) {
                    str.getChars(i13, i16, cArr, i15);
                    i11 = i15 + 256;
                } else {
                    str.getChars(i13, length, cArr, i15);
                    i11 = (length - i13) + i15;
                }
                int i17 = i15;
                while (i15 < i11) {
                    char c11 = cArr[i15];
                    if (c11 != '=') {
                        byte[] bArr2 = f35840b;
                        if (c11 < bArr2.length) {
                            if (bArr2[c11] == Byte.MAX_VALUE) {
                            }
                        }
                        i15++;
                    }
                    int i18 = i17 + 1;
                    cArr[i17] = c11;
                    if (i18 == 4) {
                        i14 += a(cArr, bArr, i14);
                        i17 = 0;
                    } else {
                        i17 = i18;
                    }
                    i15++;
                }
                i13 = i16;
                i15 = i17;
            }
            if (i14 == i12) {
                return bArr;
            }
            byte[] bArr3 = new byte[i14];
            System.arraycopy(bArr, 0, bArr3, 0, i14);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        byte[] a11 = a(str);
        if (a11 == null || a11.length <= 0) {
            return null;
        }
        return new String(a11);
    }

    public static String c(String str) {
        return a(str.getBytes());
    }
}
