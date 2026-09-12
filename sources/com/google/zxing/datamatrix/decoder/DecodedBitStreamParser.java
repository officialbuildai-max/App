package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import id.i;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class DecodedBitStreamParser {

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f32908b;

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f32910d;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f32907a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f32909c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f32911e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        ECI_ENCODE
    }

    /* loaded from: classes4.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32912a;

        static {
            int[] iArr = new int[Mode.values().length];
            f32912a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32912a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32912a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32912a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32912a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32912a[Mode.ECI_ENCODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f32908b = cArr;
        f32910d = cArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static id.d a(byte[] r13) {
        /*
            id.c r0 = new id.c
            r0.<init>(r13)
            id.i r1 = new id.i
            r2 = 100
            r1.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.<init>(r3)
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r5.<init>(r6)
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r8 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
        L27:
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r10 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE
            if (r8 != r10) goto L30
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r8 = c(r0, r1, r2, r9)
            goto L59
        L30:
            int[] r11 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.a.f32912a
            int r8 = r8.ordinal()
            r8 = r11[r8]
            switch(r8) {
                case 1: goto L55;
                case 2: goto L51;
                case 3: goto L4d;
                case 4: goto L49;
                case 5: goto L45;
                case 6: goto L40;
                default: goto L3b;
            }
        L3b:
            com.google.zxing.FormatException r13 = com.google.zxing.FormatException.getFormatInstance()
            throw r13
        L40:
            f(r0, r1)
            r3 = r6
            goto L58
        L45:
            d(r0, r1, r5)
            goto L58
        L49:
            g(r0, r1)
            goto L58
        L4d:
            b(r0, r1)
            goto L58
        L51:
            h(r0, r1, r9)
            goto L58
        L55:
            e(r0, r1, r9)
        L58:
            r8 = r10
        L59:
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r10 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.PAD_ENCODE
            if (r8 == r10) goto L63
            int r10 = r0.a()
            if (r10 > 0) goto L27
        L63:
            int r0 = r2.length()
            if (r0 <= 0) goto L6c
            r1.e(r2)
        L6c:
            r0 = 5
            r2 = 4
            if (r3 == 0) goto L99
            boolean r3 = r9.contains(r4)
            if (r3 != 0) goto L97
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            boolean r3 = r9.contains(r3)
            if (r3 == 0) goto L81
            goto L97
        L81:
            boolean r3 = r9.contains(r7)
            if (r3 != 0) goto L94
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r0 = r9.contains(r0)
            if (r0 == 0) goto L92
            goto L94
        L92:
            r12 = r2
            goto Lbe
        L94:
            r6 = 6
        L95:
            r12 = r6
            goto Lbe
        L97:
            r12 = r0
            goto Lbe
        L99:
            boolean r3 = r9.contains(r4)
            if (r3 != 0) goto Lbc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r9.contains(r2)
            if (r2 == 0) goto Laa
            goto Lbc
        Laa:
            boolean r2 = r9.contains(r7)
            if (r2 != 0) goto Lba
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r0 = r9.contains(r0)
            if (r0 == 0) goto L95
        Lba:
            r6 = 3
            goto L95
        Lbc:
            r6 = 2
            goto L95
        Lbe:
            id.d r0 = new id.d
            java.lang.String r9 = r1.toString()
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto Lcb
            r5 = 0
        Lcb:
            r10 = r5
            r11 = 0
            r7 = r0
            r8 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.a(byte[]):id.d");
    }

    private static void b(id.c cVar, i iVar) {
        int d11;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (d11 = cVar.d(8)) != 254) {
            i(d11, cVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i12 == 0) {
                    iVar.b('\r');
                } else if (i12 == 1) {
                    iVar.b('*');
                } else if (i12 == 2) {
                    iVar.b('>');
                } else if (i12 == 3) {
                    iVar.b(' ');
                } else if (i12 < 14) {
                    iVar.b((char) (i12 + 44));
                } else {
                    if (i12 >= 40) {
                        throw FormatException.getFormatInstance();
                    }
                    iVar.b((char) (i12 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0037. Please report as an issue. */
    private static Mode c(id.c cVar, i iVar, StringBuilder sb2, Set set) {
        boolean z10 = false;
        do {
            int d11 = cVar.d(8);
            if (d11 == 0) {
                throw FormatException.getFormatInstance();
            }
            if (d11 > 128) {
                if (d11 != 129) {
                    if (d11 > 229) {
                        switch (d11) {
                            case 230:
                                return Mode.C40_ENCODE;
                            case 231:
                                return Mode.BASE256_ENCODE;
                            case 232:
                                set.add(Integer.valueOf(iVar.i()));
                                iVar.b((char) 29);
                                break;
                            case 233:
                            case 234:
                                break;
                            case 235:
                                z10 = true;
                                break;
                            case 236:
                                iVar.d("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                iVar.d("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return Mode.ANSIX12_ENCODE;
                            case 239:
                                return Mode.TEXT_ENCODE;
                            case 240:
                                return Mode.EDIFACT_ENCODE;
                            case 241:
                                return Mode.ECI_ENCODE;
                            default:
                                if (d11 != 254 || cVar.a() != 0) {
                                    throw FormatException.getFormatInstance();
                                }
                                break;
                        }
                    } else {
                        int i11 = d11 - 130;
                        if (i11 < 10) {
                            iVar.b('0');
                        }
                        iVar.c(i11);
                    }
                } else {
                    return Mode.PAD_ENCODE;
                }
            } else {
                if (z10) {
                    d11 += 128;
                }
                iVar.b((char) (d11 - 1));
                return Mode.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void d(id.c cVar, i iVar, Collection collection) {
        int c11 = cVar.c();
        int i11 = c11 + 2;
        int j11 = j(cVar.d(8), c11 + 1);
        if (j11 == 0) {
            j11 = cVar.a() / 8;
        } else if (j11 >= 250) {
            j11 = ((j11 - 249) * 250) + j(cVar.d(8), i11);
            i11 = c11 + 3;
        }
        if (j11 < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[j11];
        int i12 = 0;
        while (i12 < j11) {
            if (cVar.a() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i12] = (byte) j(cVar.d(8), i11);
            i12++;
            i11++;
        }
        collection.add(bArr);
        iVar.d(new String(bArr, StandardCharsets.ISO_8859_1));
    }

    private static void e(id.c cVar, i iVar, Set set) {
        int d11;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i11 = 0;
        while (cVar.a() != 8 && (d11 = cVar.d(8)) != 254) {
            i(d11, cVar.d(8), iArr);
            for (int i12 = 0; i12 < 3; i12++) {
                int i13 = iArr[i12];
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 == 2) {
                            char[] cArr = f32908b;
                            if (i13 < cArr.length) {
                                char c11 = cArr[i13];
                                if (z10) {
                                    iVar.b((char) (c11 + 128));
                                    z10 = false;
                                } else {
                                    iVar.b(c11);
                                }
                            } else if (i13 == 27) {
                                set.add(Integer.valueOf(iVar.i()));
                                iVar.b((char) 29);
                            } else {
                                if (i13 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z10 = true;
                            }
                            i11 = 0;
                        } else {
                            if (i11 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            if (z10) {
                                iVar.b((char) (i13 + 224));
                                z10 = false;
                                i11 = 0;
                            } else {
                                iVar.b((char) (i13 + 96));
                                i11 = 0;
                            }
                        }
                    } else if (z10) {
                        iVar.b((char) (i13 + 128));
                        z10 = false;
                        i11 = 0;
                    } else {
                        iVar.b((char) i13);
                        i11 = 0;
                    }
                } else if (i13 < 3) {
                    i11 = i13 + 1;
                } else {
                    char[] cArr2 = f32907a;
                    if (i13 >= cArr2.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c12 = cArr2[i13];
                    if (z10) {
                        iVar.b((char) (c12 + 128));
                        z10 = false;
                    } else {
                        iVar.b(c12);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(id.c cVar, i iVar) {
        if (cVar.a() < 8) {
            throw FormatException.getFormatInstance();
        }
        int d11 = cVar.d(8);
        if (d11 <= 127) {
            iVar.f(d11 - 1);
        }
    }

    private static void g(id.c cVar, i iVar) {
        while (cVar.a() > 16) {
            for (int i11 = 0; i11 < 4; i11++) {
                int d11 = cVar.d(6);
                if (d11 == 31) {
                    int b11 = 8 - cVar.b();
                    if (b11 != 8) {
                        cVar.d(b11);
                        return;
                    }
                    return;
                }
                if ((d11 & 32) == 0) {
                    d11 |= 64;
                }
                iVar.b((char) d11);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(id.c cVar, i iVar, Set set) {
        int d11;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i11 = 0;
        while (cVar.a() != 8 && (d11 = cVar.d(8)) != 254) {
            i(d11, cVar.d(8), iArr);
            for (int i12 = 0; i12 < 3; i12++) {
                int i13 = iArr[i12];
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 == 2) {
                            char[] cArr = f32910d;
                            if (i13 < cArr.length) {
                                char c11 = cArr[i13];
                                if (z10) {
                                    iVar.b((char) (c11 + 128));
                                    z10 = false;
                                } else {
                                    iVar.b(c11);
                                }
                            } else if (i13 == 27) {
                                set.add(Integer.valueOf(iVar.i()));
                                iVar.b((char) 29);
                            } else {
                                if (i13 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z10 = true;
                            }
                            i11 = 0;
                        } else {
                            if (i11 != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            char[] cArr2 = f32911e;
                            if (i13 >= cArr2.length) {
                                throw FormatException.getFormatInstance();
                            }
                            char c12 = cArr2[i13];
                            if (z10) {
                                iVar.b((char) (c12 + 128));
                                z10 = false;
                                i11 = 0;
                            } else {
                                iVar.b(c12);
                                i11 = 0;
                            }
                        }
                    } else if (z10) {
                        iVar.b((char) (i13 + 128));
                        z10 = false;
                        i11 = 0;
                    } else {
                        iVar.b((char) i13);
                        i11 = 0;
                    }
                } else if (i13 < 3) {
                    i11 = i13 + 1;
                } else {
                    char[] cArr3 = f32909c;
                    if (i13 >= cArr3.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c13 = cArr3[i13];
                    if (z10) {
                        iVar.b((char) (c13 + 128));
                        z10 = false;
                    } else {
                        iVar.b(c13);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void i(int i11, int i12, int[] iArr) {
        int i13 = ((i11 << 8) + i12) - 1;
        int i14 = i13 / 1600;
        iArr[0] = i14;
        int i15 = i13 - (i14 * 1600);
        int i16 = i15 / 40;
        iArr[1] = i16;
        iArr[2] = i15 - (i16 * 40);
    }

    private static int j(int i11, int i12) {
        int i13 = i11 - (((i12 * 149) % 255) + 1);
        return i13 >= 0 ? i13 : i13 + 256;
    }
}
