package org.brotli.dec;

/* loaded from: classes7.dex */
final class k {

    /* renamed from: d, reason: collision with root package name */
    static final k[] f71796d = {new k("", 0, ""), new k("", 0, " "), new k(" ", 0, " "), new k("", 12, ""), new k("", 10, " "), new k("", 0, " the "), new k(" ", 0, ""), new k("s ", 0, " "), new k("", 0, " of "), new k("", 10, ""), new k("", 0, " and "), new k("", 13, ""), new k("", 1, ""), new k(", ", 0, " "), new k("", 0, ", "), new k(" ", 10, " "), new k("", 0, " in "), new k("", 0, " to "), new k("e ", 0, " "), new k("", 0, "\""), new k("", 0, "."), new k("", 0, "\">"), new k("", 0, "\n"), new k("", 3, ""), new k("", 0, "]"), new k("", 0, " for "), new k("", 14, ""), new k("", 2, ""), new k("", 0, " a "), new k("", 0, " that "), new k(" ", 10, ""), new k("", 0, ". "), new k(".", 0, ""), new k(" ", 0, ", "), new k("", 15, ""), new k("", 0, " with "), new k("", 0, "'"), new k("", 0, " from "), new k("", 0, " by "), new k("", 16, ""), new k("", 17, ""), new k(" the ", 0, ""), new k("", 4, ""), new k("", 0, ". The "), new k("", 11, ""), new k("", 0, " on "), new k("", 0, " as "), new k("", 0, " is "), new k("", 7, ""), new k("", 1, "ing "), new k("", 0, "\n\t"), new k("", 0, ":"), new k(" ", 0, ". "), new k("", 0, "ed "), new k("", 20, ""), new k("", 18, ""), new k("", 6, ""), new k("", 0, "("), new k("", 10, ", "), new k("", 8, ""), new k("", 0, " at "), new k("", 0, "ly "), new k(" the ", 0, " of "), new k("", 5, ""), new k("", 9, ""), new k(" ", 10, ", "), new k("", 10, "\""), new k(".", 0, "("), new k("", 11, " "), new k("", 10, "\">"), new k("", 0, "=\""), new k(" ", 0, "."), new k(".com/", 0, ""), new k(" the ", 0, " of the "), new k("", 10, "'"), new k("", 0, ". This "), new k("", 0, ","), new k(".", 0, " "), new k("", 10, "("), new k("", 10, "."), new k("", 0, " not "), new k(" ", 0, "=\""), new k("", 0, "er "), new k(" ", 11, " "), new k("", 0, "al "), new k(" ", 11, ""), new k("", 0, "='"), new k("", 11, "\""), new k("", 10, ". "), new k(" ", 0, "("), new k("", 0, "ful "), new k(" ", 10, ". "), new k("", 0, "ive "), new k("", 0, "less "), new k("", 11, "'"), new k("", 0, "est "), new k(" ", 10, "."), new k("", 11, "\">"), new k(" ", 0, "='"), new k("", 10, ","), new k("", 0, "ize "), new k("", 11, "."), new k("Â ", 0, ""), new k(" ", 0, ","), new k("", 10, "=\""), new k("", 11, "=\""), new k("", 0, "ous "), new k("", 11, ", "), new k("", 10, "='"), new k(" ", 10, ","), new k(" ", 11, "=\""), new k(" ", 11, ", "), new k("", 11, ","), new k("", 11, "("), new k("", 11, ". "), new k(" ", 11, "."), new k("", 11, "='"), new k(" ", 11, ". "), new k(" ", 10, "=\""), new k(" ", 11, "='"), new k(" ", 10, "='")};

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f71797a;

    /* renamed from: b, reason: collision with root package name */
    private final int f71798b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f71799c;

    k(String str, int i11, String str2) {
        this.f71797a = a(str);
        this.f71798b = i11;
        this.f71799c = a(str2);
    }

    static byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = (byte) str.charAt(i11);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i11, byte[] bArr2, int i12, int i13, k kVar) {
        int i14 = i11;
        for (byte b11 : kVar.f71797a) {
            bArr[i14] = b11;
            i14++;
        }
        int i15 = kVar.f71798b;
        int a11 = m.a(i15);
        if (a11 > i13) {
            a11 = i13;
        }
        int i16 = i12 + a11;
        int b12 = (i13 - a11) - m.b(i15);
        int i17 = b12;
        while (i17 > 0) {
            bArr[i14] = bArr2[i16];
            i17--;
            i14++;
            i16++;
        }
        if (i15 == 11 || i15 == 10) {
            int i18 = i14 - b12;
            if (i15 == 10) {
                b12 = 1;
            }
            while (b12 > 0) {
                byte b13 = bArr[i18];
                int i19 = b13 & 255;
                if (i19 < 192) {
                    if (i19 >= 97 && i19 <= 122) {
                        bArr[i18] = (byte) (b13 ^ 32);
                    }
                    i18++;
                    b12--;
                } else if (i19 < 224) {
                    int i20 = i18 + 1;
                    bArr[i20] = (byte) (bArr[i20] ^ 32);
                    i18 += 2;
                    b12 -= 2;
                } else {
                    int i21 = i18 + 2;
                    bArr[i21] = (byte) (bArr[i21] ^ 5);
                    i18 += 3;
                    b12 -= 3;
                }
            }
        }
        for (byte b14 : kVar.f71799c) {
            bArr[i14] = b14;
            i14++;
        }
        return i14 - i11;
    }
}
