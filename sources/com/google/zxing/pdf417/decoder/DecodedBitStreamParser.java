package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes4.dex */
abstract class DecodedBitStreamParser {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f33002a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f33003b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    private static final BigInteger[] f33004c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33005a;

        static {
            int[] iArr = new int[Mode.values().length];
            f33005a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33005a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33005a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33005a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33005a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33005a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f33004c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i11 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f33004c;
            if (i11 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i11] = bigIntegerArr2[i11 - 1].multiply(valueOf);
            i11++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
    
        if (r11 == 924) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004a, code lost:
    
        if (r8 >= r12[0]) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004e, code lost:
    
        if (r12[r8] >= 900) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0050, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0052, code lost:
    
        if (r13 >= 6) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0054, code lost:
    
        r14.a((byte) (r6 >> ((5 - r13) * 8)));
        r13 = r13 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(int r11, int[] r12, int r13, id.i r14) {
        /*
            r0 = 0
            r1 = r0
        L2:
            r2 = r12[r0]
            if (r13 >= r2) goto L86
            if (r1 != 0) goto L86
        L8:
            r2 = r12[r0]
            r3 = 927(0x39f, float:1.299E-42)
            if (r13 >= r2) goto L1c
            r4 = r12[r13]
            if (r4 != r3) goto L1c
            int r2 = r13 + 1
            r2 = r12[r2]
            r14.f(r2)
            int r13 = r13 + 2
            goto L8
        L1c:
            r4 = 1
            if (r13 >= r2) goto L83
            r2 = r12[r13]
            r5 = 900(0x384, float:1.261E-42)
            if (r2 < r5) goto L27
            goto L83
        L27:
            r6 = 0
            r2 = r0
        L2a:
            r8 = 900(0x384, double:4.447E-321)
            long r6 = r6 * r8
            int r8 = r13 + 1
            r13 = r12[r13]
            long r9 = (long) r13
            long r6 = r6 + r9
            int r2 = r2 + r4
            r13 = 5
            if (r2 >= r13) goto L42
            r9 = r12[r0]
            if (r8 >= r9) goto L42
            r9 = r12[r8]
            if (r9 < r5) goto L40
            goto L42
        L40:
            r13 = r8
            goto L2a
        L42:
            if (r2 != r13) goto L64
            r13 = 924(0x39c, float:1.295E-42)
            if (r11 == r13) goto L50
            r13 = r12[r0]
            if (r8 >= r13) goto L64
            r13 = r12[r8]
            if (r13 >= r5) goto L64
        L50:
            r13 = r0
        L51:
            r2 = 6
            if (r13 >= r2) goto L62
            int r2 = 5 - r13
            int r2 = r2 * 8
            long r2 = r6 >> r2
            int r2 = (int) r2
            byte r2 = (byte) r2
            r14.a(r2)
            int r13 = r13 + 1
            goto L51
        L62:
            r13 = r8
            goto L2
        L64:
            int r8 = r8 - r2
        L65:
            r13 = r12[r0]
            if (r8 >= r13) goto L62
            if (r1 != 0) goto L62
            int r13 = r8 + 1
            r2 = r12[r8]
            if (r2 >= r5) goto L77
            byte r2 = (byte) r2
            r14.a(r2)
            r8 = r13
            goto L65
        L77:
            if (r2 != r3) goto L81
            int r8 = r8 + 2
            r13 = r12[r13]
            r14.f(r13)
            goto L65
        L81:
            r1 = r4
            goto L65
        L83:
            r1 = r4
            goto L2
        L86:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.a(int, int[], int, id.i):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x001f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0022. Please report as an issue. */
    public static id.d b(int[] iArr, String str) {
        id.i iVar = new id.i(iArr.length * 2);
        int g11 = g(iArr, 1, iVar);
        td.c cVar = new td.c();
        while (g11 < iArr[0]) {
            int i11 = g11 + 1;
            int i12 = iArr[g11];
            if (i12 != 913) {
                switch (i12) {
                    case EDITION_LEGACY_VALUE:
                        g11 = g(iArr, i11, iVar);
                        break;
                    case 901:
                        g11 = a(i12, iArr, i11, iVar);
                        break;
                    case 902:
                        g11 = f(iArr, i11, iVar);
                        break;
                    default:
                        switch (i12) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                g11 = a(i12, iArr, i11, iVar);
                                break;
                            case 925:
                                g11 += 2;
                                break;
                            case 926:
                                g11 += 3;
                                break;
                            case 927:
                                g11 += 2;
                                iVar.f(iArr[i11]);
                                break;
                            case 928:
                                g11 = d(iArr, i11, cVar);
                                break;
                            default:
                                g11 = g(iArr, g11, iVar);
                                break;
                        }
                }
            } else {
                g11 += 2;
                iVar.b((char) iArr[i11]);
            }
        }
        if (iVar.h() && cVar.a() == null) {
            throw FormatException.getFormatInstance();
        }
        id.d dVar = new id.d(null, iVar.toString(), null, str);
        dVar.p(cVar);
        return dVar;
    }

    private static String c(int[] iArr, int i11) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i12 = 0; i12 < i11; i12++) {
            bigInteger = bigInteger.add(f33004c[(i11 - i12) - 1].multiply(BigInteger.valueOf(iArr[i12])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    static int d(int[] iArr, int i11, td.c cVar) {
        int i12;
        if (i11 + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i13 = 0;
        while (i13 < 2) {
            iArr2[i13] = iArr[i11];
            i13++;
            i11++;
        }
        String c11 = c(iArr2, 2);
        if (c11.isEmpty()) {
            cVar.k(0);
        } else {
            try {
                cVar.k(Integer.parseInt(c11));
            } catch (NumberFormatException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (i11 < iArr[0] && i11 < iArr.length && (i12 = iArr[i11]) != 922 && i12 != 923) {
            sb2.append(String.format("%03d", Integer.valueOf(i12)));
            i11++;
        }
        if (sb2.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        cVar.e(sb2.toString());
        int i14 = iArr[i11] == 923 ? i11 + 1 : -1;
        while (i11 < iArr[0]) {
            int i15 = iArr[i11];
            if (i15 == 922) {
                i11++;
                cVar.h(true);
            } else {
                if (i15 != 923) {
                    throw FormatException.getFormatInstance();
                }
                switch (iArr[i11 + 1]) {
                    case 0:
                        id.i iVar = new id.i();
                        i11 = g(iArr, i11 + 2, iVar);
                        cVar.f(iVar.toString());
                        break;
                    case 1:
                        id.i iVar2 = new id.i();
                        i11 = f(iArr, i11 + 2, iVar2);
                        try {
                            cVar.j(Integer.parseInt(iVar2.toString()));
                            break;
                        } catch (NumberFormatException unused2) {
                            throw FormatException.getFormatInstance();
                        }
                    case 2:
                        id.i iVar3 = new id.i();
                        i11 = f(iArr, i11 + 2, iVar3);
                        try {
                            cVar.m(Long.parseLong(iVar3.toString()));
                            break;
                        } catch (NumberFormatException unused3) {
                            throw FormatException.getFormatInstance();
                        }
                    case 3:
                        id.i iVar4 = new id.i();
                        i11 = g(iArr, i11 + 2, iVar4);
                        cVar.l(iVar4.toString());
                        break;
                    case 4:
                        id.i iVar5 = new id.i();
                        i11 = g(iArr, i11 + 2, iVar5);
                        cVar.c(iVar5.toString());
                        break;
                    case 5:
                        id.i iVar6 = new id.i();
                        i11 = f(iArr, i11 + 2, iVar6);
                        try {
                            cVar.g(Long.parseLong(iVar6.toString()));
                            break;
                        } catch (NumberFormatException unused4) {
                            throw FormatException.getFormatInstance();
                        }
                    case 6:
                        id.i iVar7 = new id.i();
                        i11 = f(iArr, i11 + 2, iVar7);
                        try {
                            cVar.d(Integer.parseInt(iVar7.toString()));
                            break;
                        } catch (NumberFormatException unused5) {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
        }
        if (i14 != -1) {
            int i16 = i11 - i14;
            if (cVar.b()) {
                i16--;
            }
            if (i16 > 0) {
                cVar.i(Arrays.copyOfRange(iArr, i14, i16 + i14));
            }
        }
        return i11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:42:0x0083. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0020. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:55:0x00aa. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:65:0x00ca. Please report as an issue. */
    private static Mode e(int[] iArr, int[] iArr2, int i11, id.i iVar, Mode mode) {
        Mode mode2;
        int i12;
        char c11;
        char c12;
        Mode mode3;
        Mode mode4 = mode;
        Mode mode5 = mode4;
        Mode mode6 = mode5;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = iArr[i13];
            char c13 = ' ';
            switch (a.f33005a[mode5.ordinal()]) {
                case 1:
                    if (i14 < 26) {
                        i12 = i14 + 65;
                        c11 = (char) i12;
                        Mode mode7 = mode6;
                        mode6 = mode5;
                        c12 = c11;
                        mode3 = mode7;
                        break;
                    } else {
                        if (i14 != 900) {
                            if (i14 != 913) {
                                switch (i14) {
                                    case 27:
                                        mode4 = Mode.LOWER;
                                        break;
                                    case 28:
                                        mode4 = Mode.MIXED;
                                        break;
                                    case NOTIFICATION_REDIRECT_VALUE:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c13 = 0;
                                        Mode mode8 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode8;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c12 = c13;
                                break;
                            } else {
                                iVar.b((char) iArr2[i13]);
                            }
                            c13 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c12 = c13;
                        } else {
                            mode4 = Mode.ALPHA;
                        }
                        c13 = 0;
                        mode5 = mode4;
                        mode3 = mode6;
                        mode6 = mode5;
                        c12 = c13;
                    }
                case 2:
                    if (i14 < 26) {
                        i12 = i14 + 97;
                        c11 = (char) i12;
                        Mode mode72 = mode6;
                        mode6 = mode5;
                        c12 = c11;
                        mode3 = mode72;
                        break;
                    } else {
                        if (i14 != 900) {
                            if (i14 != 913) {
                                switch (i14) {
                                    case 27:
                                        mode2 = Mode.ALPHA_SHIFT;
                                        c13 = 0;
                                        Mode mode82 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode82;
                                        break;
                                    case 28:
                                        mode4 = Mode.MIXED;
                                        break;
                                    case NOTIFICATION_REDIRECT_VALUE:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c13 = 0;
                                        Mode mode822 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode822;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c12 = c13;
                                break;
                            } else {
                                iVar.b((char) iArr2[i13]);
                            }
                            c13 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c12 = c13;
                        } else {
                            mode4 = Mode.ALPHA;
                        }
                        c13 = 0;
                        mode5 = mode4;
                        mode3 = mode6;
                        mode6 = mode5;
                        c12 = c13;
                    }
                case 3:
                    if (i14 < 25) {
                        c11 = f33003b[i14];
                        Mode mode722 = mode6;
                        mode6 = mode5;
                        c12 = c11;
                        mode3 = mode722;
                        break;
                    } else {
                        if (i14 != 900) {
                            if (i14 != 913) {
                                switch (i14) {
                                    case 25:
                                        mode4 = Mode.PUNCT;
                                        c13 = 0;
                                        mode5 = mode4;
                                        break;
                                    case 27:
                                        mode4 = Mode.LOWER;
                                        c13 = 0;
                                        mode5 = mode4;
                                        break;
                                    case NOTIFICATION_REDIRECT_VALUE:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c13 = 0;
                                        Mode mode8222 = mode2;
                                        mode6 = mode5;
                                        mode5 = mode8222;
                                        break;
                                }
                                mode3 = mode6;
                                mode6 = mode5;
                                c12 = c13;
                                break;
                            } else {
                                iVar.b((char) iArr2[i13]);
                            }
                            c13 = 0;
                            mode3 = mode6;
                            mode6 = mode5;
                            c12 = c13;
                        }
                        mode4 = Mode.ALPHA;
                        c13 = 0;
                        mode5 = mode4;
                        mode3 = mode6;
                        mode6 = mode5;
                        c12 = c13;
                    }
                case 4:
                    if (i14 >= 29) {
                        if (i14 == 29 || i14 == 900) {
                            mode4 = Mode.ALPHA;
                            mode5 = mode4;
                        } else if (i14 == 913) {
                            iVar.b((char) iArr2[i13]);
                        }
                        mode3 = mode6;
                        mode6 = mode5;
                        c12 = 0;
                        break;
                    } else {
                        c11 = f33002a[i14];
                        Mode mode7222 = mode6;
                        mode6 = mode5;
                        c12 = c11;
                        mode3 = mode7222;
                        break;
                    }
                case 5:
                    if (i14 < 26) {
                        c12 = (char) (i14 + 65);
                        mode3 = mode6;
                        break;
                    } else {
                        if (i14 != 26) {
                            if (i14 == 900) {
                                mode5 = Mode.ALPHA;
                                c13 = 0;
                                mode3 = mode6;
                                mode6 = mode5;
                                c12 = c13;
                                break;
                            } else {
                                c13 = 0;
                            }
                        }
                        mode5 = mode6;
                        mode3 = mode6;
                        mode6 = mode5;
                        c12 = c13;
                    }
                case 6:
                    if (i14 < 29) {
                        c12 = f33002a[i14];
                    } else if (i14 == 29 || i14 == 900) {
                        mode5 = Mode.ALPHA;
                        mode3 = mode6;
                        mode6 = mode5;
                        c12 = 0;
                        break;
                    } else {
                        if (i14 == 913) {
                            iVar.b((char) iArr2[i13]);
                        }
                        c12 = 0;
                    }
                    mode3 = mode6;
                    break;
                default:
                    mode3 = mode6;
                    mode6 = mode5;
                    c12 = 0;
                    break;
            }
            if (c12 != 0) {
                iVar.b(c12);
            }
            i13++;
            mode5 = mode6;
            mode6 = mode3;
        }
        return mode4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        r10.d(c(r0, r3));
        r3 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int f(int[] r8, int r9, id.i r10) {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            r4 = r8[r1]
            if (r9 >= r4) goto L47
            if (r2 != 0) goto L47
            int r5 = r9 + 1
            r6 = r8[r9]
            r7 = 1
            if (r5 != r4) goto L15
            r2 = r7
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r6 >= r4) goto L1f
            r0[r3] = r6
            int r3 = r3 + 1
        L1d:
            r9 = r5
            goto L32
        L1f:
            if (r6 == r4) goto L31
            r4 = 901(0x385, float:1.263E-42)
            if (r6 == r4) goto L31
            r4 = 927(0x39f, float:1.299E-42)
            if (r6 == r4) goto L31
            r4 = 928(0x3a0, float:1.3E-42)
            if (r6 == r4) goto L31
            switch(r6) {
                case 922: goto L31;
                case 923: goto L31;
                case 924: goto L31;
                default: goto L30;
            }
        L30:
            goto L1d
        L31:
            r2 = r7
        L32:
            int r4 = r3 % 15
            if (r4 == 0) goto L3c
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L3c
            if (r2 == 0) goto L7
        L3c:
            if (r3 <= 0) goto L7
            java.lang.String r3 = c(r0, r3)
            r10.d(r3)
            r3 = r1
            goto L7
        L47:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.f(int[], int, id.i):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x003a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x003d. Please report as an issue. */
    private static int g(int[] iArr, int i11, id.i iVar) {
        int i12 = iArr[0];
        int[] iArr2 = new int[(i12 - i11) * 2];
        int[] iArr3 = new int[(i12 - i11) * 2];
        Mode mode = Mode.ALPHA;
        boolean z10 = false;
        int i13 = 0;
        while (i11 < iArr[0] && !z10) {
            int i14 = i11 + 1;
            int i15 = iArr[i11];
            if (i15 < 900) {
                iArr2[i13] = i15 / 30;
                iArr2[i13 + 1] = i15 % 30;
                i13 += 2;
            } else if (i15 == 913) {
                iArr2[i13] = 913;
                i11 += 2;
                iArr3[i13] = iArr[i14];
                i13++;
            } else if (i15 != 927) {
                if (i15 != 928) {
                    switch (i15) {
                        case EDITION_LEGACY_VALUE:
                            iArr2[i13] = 900;
                            i13++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i15) {
                            }
                    }
                }
                z10 = true;
            } else {
                Mode e11 = e(iArr2, iArr3, i13, iVar, mode);
                i11 += 2;
                iVar.f(iArr[i14]);
                int i16 = iArr[0];
                if (i11 > i16) {
                    throw FormatException.getFormatInstance();
                }
                i13 = 0;
                mode = e11;
                iArr3 = new int[(i16 - i11) * 2];
                iArr2 = new int[(i16 - i11) * 2];
            }
            i11 = i14;
        }
        e(iArr2, iArr3, i13, iVar, mode);
        return i11;
    }
}
