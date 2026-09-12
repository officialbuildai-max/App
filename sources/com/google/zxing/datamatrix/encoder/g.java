package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* loaded from: classes4.dex */
public abstract class g {
    public static int a(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = i11;
        while (i12 < length && f(charSequence.charAt(i12))) {
            i12++;
        }
        return i12 - i11;
    }

    public static String b(String str, SymbolShapeHint symbolShapeHint, com.google.zxing.c cVar, com.google.zxing.c cVar2, boolean z10) {
        c cVar3 = new c();
        int i11 = 0;
        e[] eVarArr = {new a(), cVar3, new h(), new i(), new d(), new b()};
        f fVar = new f(str);
        fVar.n(symbolShapeHint);
        fVar.l(cVar, cVar2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            fVar.r((char) 236);
            fVar.m(2);
            fVar.f32949d += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            fVar.r((char) 237);
            fVar.m(2);
            fVar.f32949d += 7;
        }
        if (z10) {
            cVar3.d(fVar);
            i11 = fVar.e();
            fVar.j();
        }
        while (fVar.i()) {
            eVarArr[i11].a(fVar);
            if (fVar.e() >= 0) {
                i11 = fVar.e();
                fVar.j();
            }
        }
        int a11 = fVar.a();
        fVar.p();
        int a12 = fVar.g().a();
        if (a11 < a12 && i11 != 0 && i11 != 5 && i11 != 4) {
            fVar.r((char) 254);
        }
        StringBuilder b11 = fVar.b();
        if (b11.length() < a12) {
            b11.append((char) 129);
        }
        while (b11.length() < a12) {
            b11.append(r(b11.length() + 1));
        }
        return fVar.b().toString();
    }

    private static int c(float[] fArr, int[] iArr, int i11, byte[] bArr) {
        for (int i12 = 0; i12 < 6; i12++) {
            int ceil = (int) Math.ceil(fArr[i12]);
            iArr[i12] = ceil;
            if (i11 > ceil) {
                Arrays.fill(bArr, (byte) 0);
                i11 = ceil;
            }
            if (i11 == ceil) {
                bArr[i12] = (byte) (bArr[i12] + 1);
            }
        }
        return i11;
    }

    private static int d(byte[] bArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 6; i12++) {
            i11 += bArr[i12];
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(char c11) {
        String hexString = Integer.toHexString(c11);
        throw new IllegalArgumentException("Illegal character: " + c11 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(char c11) {
        return c11 >= '0' && c11 <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(char c11) {
        return c11 >= 128 && c11 <= 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(char c11) {
        return c11 == ' ' || (c11 >= '0' && c11 <= '9') || (c11 >= 'A' && c11 <= 'Z');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(char c11) {
        return c11 >= ' ' && c11 <= '^';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(char c11) {
        return c11 == ' ' || (c11 >= '0' && c11 <= '9') || (c11 >= 'a' && c11 <= 'z');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(char c11) {
        return m(c11) || c11 == ' ' || (c11 >= '0' && c11 <= '9') || (c11 >= 'A' && c11 <= 'Z');
    }

    private static boolean l(char c11) {
        return false;
    }

    private static boolean m(char c11) {
        return c11 == '\r' || c11 == '*' || c11 == '>';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(CharSequence charSequence, int i11, int i12) {
        int o11 = o(charSequence, i11, i12);
        if (i12 == 3 && o11 == 3) {
            int min = Math.min(i11 + 3, charSequence.length());
            while (i11 < min) {
                if (!k(charSequence.charAt(i11))) {
                    return 0;
                }
                i11++;
            }
        } else if (i12 == 4 && o11 == 4) {
            int min2 = Math.min(i11 + 4, charSequence.length());
            while (i11 < min2) {
                if (!i(charSequence.charAt(i11))) {
                    return 0;
                }
                i11++;
            }
        }
        return o11;
    }

    static int o(CharSequence charSequence, int i11, int i12) {
        float[] fArr;
        int i13;
        int i14;
        int i15;
        int i16;
        if (i11 >= charSequence.length()) {
            return i12;
        }
        float f11 = 2.0f;
        int i17 = 5;
        int i18 = 2;
        int i19 = 4;
        int i20 = 3;
        if (i12 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[6];
            fArr[0] = 1.0f;
            fArr[1] = 2.0f;
            fArr[2] = 2.0f;
            fArr[3] = 2.0f;
            fArr[4] = 2.0f;
            fArr[5] = 2.25f;
            fArr[i12] = 0.0f;
        }
        byte[] bArr = new byte[6];
        int[] iArr = new int[6];
        int i21 = 0;
        while (true) {
            int i22 = i11 + i21;
            if (i22 == charSequence.length()) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                int c11 = c(fArr, iArr, Integer.MAX_VALUE, bArr);
                int d11 = d(bArr);
                if (iArr[0] == c11) {
                    return 0;
                }
                if (d11 == 1) {
                    if (bArr[i17] > 0) {
                        return i17;
                    }
                    if (bArr[i19] > 0) {
                        return i19;
                    }
                    if (bArr[i18] > 0) {
                        return i18;
                    }
                    if (bArr[i20] > 0) {
                        return i20;
                    }
                }
                return 1;
            }
            char charAt = charSequence.charAt(i22);
            i21++;
            if (f(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (g(charAt)) {
                float ceil = (float) Math.ceil(fArr[0]);
                fArr[0] = ceil;
                fArr[0] = ceil + f11;
            } else {
                float ceil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = ceil2;
                fArr[0] = ceil2 + 1.0f;
            }
            if (h(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (j(charAt)) {
                fArr[i18] = fArr[i18] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[i18] = fArr[i18] + 2.6666667f;
            } else {
                fArr[i18] = fArr[i18] + 1.3333334f;
            }
            if (k(charAt)) {
                fArr[i20] = fArr[i20] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[i20] = fArr[i20] + 4.3333335f;
            } else {
                fArr[i20] = fArr[i20] + 3.3333333f;
            }
            if (i(charAt)) {
                fArr[i19] = fArr[i19] + 0.75f;
            } else if (g(charAt)) {
                fArr[i19] = fArr[i19] + 4.25f;
            } else {
                fArr[i19] = fArr[i19] + 3.25f;
            }
            if (l(charAt)) {
                i13 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                i13 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i21 >= i19) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                c(fArr, iArr, Integer.MAX_VALUE, bArr);
                if (iArr[0] < q(iArr[i13], iArr[1], iArr[i18], iArr[i20], iArr[i19])) {
                    return 0;
                }
                int i23 = iArr[i13];
                if (i23 < iArr[0] || i23 + 1 < p(iArr[1], iArr[2], iArr[3], iArr[i19])) {
                    return 5;
                }
                if (iArr[i19] + 1 < q(iArr[5], iArr[1], iArr[2], iArr[3], iArr[0])) {
                    return i19;
                }
                if (iArr[2] + 1 < q(iArr[5], iArr[1], iArr[i19], iArr[3], iArr[0])) {
                    return 2;
                }
                if (iArr[3] + 1 < q(iArr[5], iArr[1], iArr[4], iArr[2], iArr[0])) {
                    return 3;
                }
                i14 = 4;
                i16 = 2;
                if (iArr[1] + 1 < p(iArr[0], iArr[5], iArr[4], iArr[2])) {
                    int i24 = iArr[1];
                    int i25 = iArr[3];
                    if (i24 < i25) {
                        return 1;
                    }
                    if (i24 == i25) {
                        for (int i26 = i11 + i21 + 1; i26 < charSequence.length(); i26++) {
                            char charAt2 = charSequence.charAt(i26);
                            if (m(charAt2)) {
                                return 3;
                            }
                            if (!k(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                    i15 = 3;
                } else {
                    i15 = 3;
                }
                i17 = 5;
            } else {
                i17 = i13;
                i14 = i19;
                i15 = i20;
                i16 = i18;
            }
            i19 = i14;
            i18 = i16;
            i20 = i15;
            f11 = 2.0f;
        }
    }

    private static int p(int i11, int i12, int i13, int i14) {
        return Math.min(i11, Math.min(i12, Math.min(i13, i14)));
    }

    private static int q(int i11, int i12, int i13, int i14, int i15) {
        return Math.min(p(i11, i12, i13, i14), i15);
    }

    private static char r(int i11) {
        int i12 = (i11 * 149) % 253;
        int i13 = i12 + 130;
        if (i13 > 254) {
            i13 = i12 - 124;
        }
        return (char) i13;
    }
}
