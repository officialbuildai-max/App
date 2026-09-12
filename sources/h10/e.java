package h10;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import okio.Utf8;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f64192a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f64193b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f64194c;

    /* renamed from: d, reason: collision with root package name */
    private final h[] f64195d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f64196e;

    /* renamed from: f, reason: collision with root package name */
    private final int f64197f;

    /* renamed from: g, reason: collision with root package name */
    public final int f64198g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0050. Please report as an issue. */
    public e(byte[] bArr, int i11, boolean z10) {
        this.f64192a = bArr;
        if (z10) {
            int i12 = i11 + 6;
            if (B(i12) > 56) {
                throw new IllegalArgumentException("Unsupported class file major version " + ((int) B(i12)));
            }
        }
        int H = H(i11 + 8);
        this.f64193b = new int[H];
        this.f64194c = new String[H];
        int i13 = i11 + 10;
        int i14 = 0;
        boolean z11 = false;
        boolean z12 = false;
        int i15 = 1;
        while (i15 < H) {
            int i16 = i15 + 1;
            int i17 = i13 + 1;
            this.f64193b[i15] = i17;
            int i18 = 3;
            switch (bArr[i13]) {
                case 1:
                    i18 = 3 + H(i17);
                    if (i18 > i14) {
                        i15 = i16;
                        i14 = i18;
                        i13 += i18;
                    }
                    i15 = i16;
                    i13 += i18;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    i15 = i16;
                    i18 = 5;
                    i13 += i18;
                case 5:
                case 6:
                    i15 += 2;
                    i18 = 9;
                    i13 += i18;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    i15 = i16;
                    i13 += i18;
                case 15:
                    i18 = 4;
                    i15 = i16;
                    i13 += i18;
                case 17:
                    z11 = true;
                    i15 = i16;
                    i18 = 5;
                    i13 += i18;
                case 18:
                    z12 = true;
                    i15 = i16;
                    i18 = 5;
                    i13 += i18;
            }
        }
        this.f64197f = i14;
        this.f64198g = i13;
        this.f64195d = z11 ? new h[H] : null;
        this.f64196e = (z11 || z12) ? k(i14) : null;
    }

    private void A(r rVar, i iVar, int i11, boolean z10) {
        int i12 = i11 + 1;
        int i13 = this.f64192a[i11] & 255;
        rVar.a(i13, z10);
        char[] cArr = iVar.f64231c;
        for (int i14 = 0; i14 < i13; i14++) {
            int H = H(i12);
            i12 += 2;
            while (true) {
                int i15 = H - 1;
                if (H > 0) {
                    i12 = r(rVar.z(i14, G(i12, cArr), z10), i12 + 2, true, cArr);
                    H = i15;
                }
            }
        }
    }

    private int C(int i11, boolean z10, boolean z11, i iVar) {
        int i12;
        int i13;
        char[] cArr = iVar.f64231c;
        q[] qVarArr = iVar.f64235g;
        if (z10) {
            i12 = i11 + 1;
            i13 = this.f64192a[i11] & 255;
        } else {
            iVar.f64241m = -1;
            i12 = i11;
            i13 = 255;
        }
        iVar.f64244p = 0;
        if (i13 < 64) {
            iVar.f64242n = 3;
            iVar.f64246r = 0;
        } else if (i13 < 128) {
            i13 -= 64;
            i12 = K(i12, iVar.f64247s, 0, cArr, qVarArr);
            iVar.f64242n = 4;
            iVar.f64246r = 1;
        } else {
            if (i13 < 247) {
                throw new IllegalArgumentException();
            }
            int H = H(i12);
            int i14 = i12 + 2;
            if (i13 == 247) {
                i12 = K(i14, iVar.f64247s, 0, cArr, qVarArr);
                iVar.f64242n = 4;
                iVar.f64246r = 1;
            } else {
                if (i13 >= 248 && i13 < 251) {
                    iVar.f64242n = 2;
                    int i15 = 251 - i13;
                    iVar.f64244p = i15;
                    iVar.f64243o -= i15;
                    iVar.f64246r = 0;
                } else if (i13 == 251) {
                    iVar.f64242n = 3;
                    iVar.f64246r = 0;
                } else if (i13 < 255) {
                    int i16 = i13 - 251;
                    int i17 = z11 ? iVar.f64243o : 0;
                    i12 = i14;
                    int i18 = i16;
                    while (i18 > 0) {
                        i12 = K(i12, iVar.f64245q, i17, cArr, qVarArr);
                        i18--;
                        i17++;
                    }
                    iVar.f64242n = 1;
                    iVar.f64244p = i16;
                    iVar.f64243o += i16;
                    iVar.f64246r = 0;
                } else {
                    int H2 = H(i14);
                    int i19 = i12 + 4;
                    iVar.f64242n = 0;
                    iVar.f64244p = H2;
                    iVar.f64243o = H2;
                    for (int i20 = 0; i20 < H2; i20++) {
                        i19 = K(i19, iVar.f64245q, i20, cArr, qVarArr);
                    }
                    int H3 = H(i19);
                    i12 = i19 + 2;
                    iVar.f64246r = H3;
                    for (int i21 = 0; i21 < H3; i21++) {
                        i12 = K(i12, iVar.f64247s, i21, cArr, qVarArr);
                    }
                }
                i12 = i14;
            }
            i13 = H;
        }
        int i22 = iVar.f64241m + i13 + 1;
        iVar.f64241m = i22;
        d(i22, qVarArr);
        return i12;
    }

    private String D(int i11, char[] cArr) {
        return G(this.f64193b[H(i11)], cArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0010. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int E(h10.i r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.t(r11)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L70
            if (r1 == r2) goto L70
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            switch(r1) {
                case 16: goto L6d;
                case 17: goto L6d;
                case 18: goto L6d;
                case 19: goto L6a;
                case 20: goto L6a;
                case 21: goto L6a;
                case 22: goto L70;
                case 23: goto L6d;
                default: goto L10;
            }
        L10:
            switch(r1) {
                case 64: goto L24;
                case 65: goto L24;
                case 66: goto L6d;
                case 67: goto L20;
                case 68: goto L20;
                case 69: goto L20;
                case 70: goto L20;
                case 71: goto L19;
                case 72: goto L19;
                case 73: goto L19;
                case 74: goto L19;
                case 75: goto L19;
                default: goto L13;
            }
        L13:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L19:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r11 = r11 + 4
            goto L75
        L20:
            r0 = r0 & r3
        L21:
            int r11 = r11 + 3
            goto L75
        L24:
            r0 = r0 & r3
            int r1 = r11 + 1
            int r1 = r9.H(r1)
            int r11 = r11 + 3
            h10.q[] r3 = new h10.q[r1]
            r10.f64238j = r3
            h10.q[] r3 = new h10.q[r1]
            r10.f64239k = r3
            int[] r3 = new int[r1]
            r10.f64240l = r3
            r3 = 0
        L3a:
            if (r3 >= r1) goto L75
            int r4 = r9.H(r11)
            int r5 = r11 + 2
            int r5 = r9.H(r5)
            int r6 = r11 + 4
            int r6 = r9.H(r6)
            int r11 = r11 + 6
            h10.q[] r7 = r10.f64238j
            h10.q[] r8 = r10.f64235g
            h10.q r8 = r9.d(r4, r8)
            r7[r3] = r8
            h10.q[] r7 = r10.f64239k
            int r4 = r4 + r5
            h10.q[] r5 = r10.f64235g
            h10.q r4 = r9.d(r4, r5)
            r7[r3] = r4
            int[] r4 = r10.f64240l
            r4[r3] = r6
            int r3 = r3 + 1
            goto L3a
        L6a:
            r0 = r0 & r3
            int r11 = r11 + r2
            goto L75
        L6d:
            r0 = r0 & (-256(0xffffffffffffff00, float:NaN))
            goto L21
        L70:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r11 = r11 + 2
        L75:
            r10.f64236h = r0
            int r0 = r9.l(r11)
            if (r0 != 0) goto L7f
            r1 = 0
            goto L86
        L7f:
            h10.z r1 = new h10.z
            byte[] r3 = r9.f64192a
            r1.<init>(r3, r11)
        L86:
            r10.f64237i = r1
            int r11 = r11 + r2
            int r0 = r0 * 2
            int r11 = r11 + r0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: h10.e.E(h10.i, int):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] F(h10.r r11, h10.i r12, int r13, boolean r14) {
        /*
            r10 = this;
            char[] r0 = r12.f64231c
            int r1 = r10.H(r13)
            int[] r2 = new int[r1]
            int r13 = r13 + 2
            r3 = 0
        Lb:
            if (r3 >= r1) goto L84
            r2[r3] = r13
            int r4 = r10.t(r13)
            int r5 = r4 >>> 24
            r6 = 23
            if (r5 == r6) goto L4d
            switch(r5) {
                case 16: goto L4d;
                case 17: goto L4d;
                case 18: goto L4d;
                default: goto L1c;
            }
        L1c:
            switch(r5) {
                case 64: goto L28;
                case 65: goto L28;
                case 66: goto L4d;
                case 67: goto L4d;
                case 68: goto L4d;
                case 69: goto L4d;
                case 70: goto L4d;
                case 71: goto L25;
                case 72: goto L25;
                case 73: goto L25;
                case 74: goto L25;
                case 75: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>()
            throw r11
        L25:
            int r13 = r13 + 4
            goto L4f
        L28:
            int r6 = r13 + 1
            int r6 = r10.H(r6)
            int r13 = r13 + 3
        L30:
            int r7 = r6 + (-1)
            if (r6 <= 0) goto L4f
            int r6 = r10.H(r13)
            int r8 = r13 + 2
            int r8 = r10.H(r8)
            int r13 = r13 + 6
            h10.q[] r9 = r12.f64235g
            r10.d(r6, r9)
            int r6 = r6 + r8
            h10.q[] r8 = r12.f64235g
            r10.d(r6, r8)
            r6 = r7
            goto L30
        L4d:
            int r13 = r13 + 3
        L4f:
            int r6 = r10.l(r13)
            r7 = 66
            r8 = 0
            r9 = 1
            if (r5 != r7) goto L78
            if (r6 != 0) goto L5c
            goto L63
        L5c:
            h10.z r8 = new h10.z
            byte[] r5 = r10.f64192a
            r8.<init>(r5, r13)
        L63:
            int r6 = r6 * 2
            int r6 = r6 + r9
            int r13 = r13 + r6
            java.lang.String r5 = r10.G(r13, r0)
            int r13 = r13 + 2
            r4 = r4 & (-256(0xffffffffffffff00, float:NaN))
            h10.a r4 = r11.B(r4, r8, r5, r14)
            int r13 = r10.r(r4, r13, r9, r0)
            goto L81
        L78:
            int r6 = r6 * 2
            int r6 = r6 + 3
            int r13 = r13 + r6
            int r13 = r10.r(r8, r13, r9, r0)
        L81:
            int r3 = r3 + 1
            goto Lb
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h10.e.F(h10.r, h10.i, int, boolean):int[]");
    }

    private String I(int i11, int i12, char[] cArr) {
        int i13;
        int i14 = i12 + i11;
        byte[] bArr = this.f64192a;
        int i15 = 0;
        while (i11 < i14) {
            int i16 = i11 + 1;
            byte b11 = bArr[i11];
            if ((b11 & 128) == 0) {
                cArr[i15] = (char) (b11 & Byte.MAX_VALUE);
                i15++;
                i11 = i16;
            } else {
                if ((b11 & 224) == 192) {
                    i13 = i15 + 1;
                    i11 += 2;
                    cArr[i15] = (char) (((b11 & 31) << 6) + (bArr[i16] & Utf8.REPLACEMENT_BYTE));
                } else {
                    i13 = i15 + 1;
                    int i17 = i11 + 2;
                    i11 += 3;
                    cArr[i15] = (char) (((b11 & 15) << 12) + ((bArr[i16] & Utf8.REPLACEMENT_BYTE) << 6) + (bArr[i17] & Utf8.REPLACEMENT_BYTE));
                }
                i15 = i13;
            }
        }
        return new String(cArr, 0, i15);
    }

    private int K(int i11, Object[] objArr, int i12, char[] cArr, q[] qVarArr) {
        int i13 = i11 + 1;
        switch (this.f64192a[i11] & 255) {
            case 0:
                objArr[i12] = v.f64346a;
                return i13;
            case 1:
                objArr[i12] = v.f64347b;
                return i13;
            case 2:
                objArr[i12] = v.f64348c;
                return i13;
            case 3:
                objArr[i12] = v.f64349d;
                return i13;
            case 4:
                objArr[i12] = v.f64350e;
                return i13;
            case 5:
                objArr[i12] = v.f64351f;
                return i13;
            case 6:
                objArr[i12] = v.f64352g;
                return i13;
            case 7:
                objArr[i12] = m(i13, cArr);
                break;
            case 8:
                objArr[i12] = d(H(i13), qVarArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i11 + 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x006a, code lost:
    
        if (r0.charAt(r5) == 'L') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006c, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0072, code lost:
    
        if (r0.charAt(r5) == ';') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0075, code lost:
    
        r5 = r5 + 1;
        r1[r4] = r0.substring(r2, r5);
        r2 = r5;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0051, code lost:
    
        r11.f64243o = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0053, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(h10.i r11) {
        /*
            r10 = this;
            java.lang.String r0 = r11.f64234f
            java.lang.Object[] r1 = r11.f64245q
            int r2 = r11.f64232d
            r2 = r2 & 8
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L29
            java.lang.String r2 = "<init>"
            java.lang.String r5 = r11.f64233e
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L1c
            java.lang.Integer r2 = h10.v.f64352g
            r1[r4] = r2
        L1a:
            r4 = r3
            goto L29
        L1c:
            int r2 = r10.f64198g
            int r2 = r2 + 2
            char[] r5 = r11.f64231c
            java.lang.String r2 = r10.m(r2, r5)
            r1[r4] = r2
            goto L1a
        L29:
            r2 = r3
        L2a:
            int r5 = r2 + 1
            char r6 = r0.charAt(r2)
            r7 = 70
            if (r6 == r7) goto La6
            r7 = 59
            r8 = 76
            if (r6 == r8) goto L8f
            r9 = 83
            if (r6 == r9) goto L88
            r9 = 73
            if (r6 == r9) goto L88
            r9 = 74
            if (r6 == r9) goto L81
            r9 = 90
            if (r6 == r9) goto L88
            r9 = 91
            if (r6 == r9) goto L5d
            switch(r6) {
                case 66: goto L88;
                case 67: goto L88;
                case 68: goto L54;
                default: goto L51;
            }
        L51:
            r11.f64243o = r4
            return
        L54:
            int r2 = r4 + 1
            java.lang.Integer r6 = h10.v.f64349d
            r1[r4] = r6
        L5a:
            r4 = r2
            r2 = r5
            goto L2a
        L5d:
            char r6 = r0.charAt(r5)
            if (r6 != r9) goto L66
            int r5 = r5 + 1
            goto L5d
        L66:
            char r6 = r0.charAt(r5)
            if (r6 != r8) goto L75
        L6c:
            int r5 = r5 + 1
            char r6 = r0.charAt(r5)
            if (r6 == r7) goto L75
            goto L6c
        L75:
            int r6 = r4 + 1
            int r5 = r5 + r3
            java.lang.String r2 = r0.substring(r2, r5)
            r1[r4] = r2
            r2 = r5
            r4 = r6
            goto L2a
        L81:
            int r2 = r4 + 1
            java.lang.Integer r6 = h10.v.f64350e
            r1[r4] = r6
            goto L5a
        L88:
            int r2 = r4 + 1
            java.lang.Integer r6 = h10.v.f64347b
            r1[r4] = r6
            goto L5a
        L8f:
            r2 = r5
        L90:
            char r6 = r0.charAt(r2)
            if (r6 == r7) goto L99
            int r2 = r2 + 1
            goto L90
        L99:
            int r6 = r4 + 1
            int r7 = r2 + 1
            java.lang.String r2 = r0.substring(r5, r2)
            r1[r4] = r2
            r4 = r6
            r2 = r7
            goto L2a
        La6:
            int r2 = r4 + 1
            java.lang.Integer r6 = h10.v.f64348c
            r1[r4] = r6
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: h10.e.b(h10.i):void");
    }

    private void c(int i11, q[] qVarArr) {
        if (qVarArr[i11] == null) {
            q u11 = u(i11, qVarArr);
            u11.f64285a = (short) (u11.f64285a | 1);
        }
    }

    private q d(int i11, q[] qVarArr) {
        q u11 = u(i11, qVarArr);
        u11.f64285a = (short) (u11.f64285a & (-2));
        return u11;
    }

    private int i(int[] iArr, int i11) {
        if (iArr == null || i11 >= iArr.length || l(iArr[i11]) < 67) {
            return -1;
        }
        return H(iArr[i11] + 1);
    }

    private c j(c[] cVarArr, String str, int i11, int i12, char[] cArr, int i13, q[] qVarArr) {
        for (c cVar : cVarArr) {
            if (cVar.f64185a.equals(str)) {
                return cVar.g(this, i11, i12, cArr, i13, qVarArr);
            }
        }
        return new c(str).g(this, i11, i12, null, -1, null);
    }

    private int[] k(int i11) {
        char[] cArr = new char[i11];
        int e11 = e();
        for (int H = H(e11 - 2); H > 0; H--) {
            String G = G(e11, cArr);
            int t11 = t(e11 + 2);
            int i12 = e11 + 6;
            if ("BootstrapMethods".equals(G)) {
                int H2 = H(i12);
                int[] iArr = new int[H2];
                int i13 = e11 + 8;
                for (int i14 = 0; i14 < H2; i14++) {
                    iArr[i14] = i13;
                    i13 += (H(i13 + 2) * 2) + 4;
                }
                return iArr;
            }
            e11 = i12 + t11;
        }
        return null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private void n(h10.r r39, h10.i r40, int r41) {
        /*
            Method dump skipped, instructions count: 3348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h10.e.n(h10.r, h10.i, int):void");
    }

    private h p(int i11, char[] cArr) {
        h hVar = this.f64195d[i11];
        if (hVar != null) {
            return hVar;
        }
        int[] iArr = this.f64193b;
        int i12 = iArr[i11];
        int i13 = iArr[H(i12 + 2)];
        String G = G(i13, cArr);
        String G2 = G(i13 + 2, cArr);
        int i14 = this.f64196e[H(i12)];
        o oVar = (o) o(H(i14), cArr);
        int H = H(i14 + 2);
        Object[] objArr = new Object[H];
        int i15 = i14 + 4;
        for (int i16 = 0; i16 < H; i16++) {
            objArr[i16] = o(H(i15), cArr);
            i15 += 2;
        }
        h[] hVarArr = this.f64195d;
        h hVar2 = new h(G, G2, oVar, objArr);
        hVarArr[i11] = hVar2;
        return hVar2;
    }

    private int q(a aVar, int i11, String str, char[] cArr) {
        int i12 = 0;
        if (aVar == null) {
            int i13 = this.f64192a[i11] & 255;
            return i13 != 64 ? i13 != 91 ? i13 != 101 ? i11 + 3 : i11 + 5 : r(null, i11 + 1, false, cArr) : r(null, i11 + 3, true, cArr);
        }
        int i14 = i11 + 1;
        int i15 = this.f64192a[i11] & 255;
        if (i15 == 64) {
            return r(aVar.b(str, G(i14, cArr)), i11 + 3, true, cArr);
        }
        if (i15 != 70) {
            if (i15 == 83) {
                aVar.a(str, Short.valueOf((short) t(this.f64193b[H(i14)])));
            } else if (i15 == 99) {
                aVar.a(str, y.n(G(i14, cArr)));
            } else {
                if (i15 == 101) {
                    aVar.e(str, G(i14, cArr), G(i11 + 3, cArr));
                    return i11 + 5;
                }
                if (i15 == 115) {
                    aVar.a(str, G(i14, cArr));
                } else if (i15 != 73 && i15 != 74) {
                    if (i15 == 90) {
                        aVar.a(str, t(this.f64193b[H(i14)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                    } else {
                        if (i15 == 91) {
                            int H = H(i14);
                            int i16 = i11 + 3;
                            if (H == 0) {
                                return r(aVar.c(str), i11 + 1, false, cArr);
                            }
                            int i17 = this.f64192a[i16] & 255;
                            if (i17 == 70) {
                                float[] fArr = new float[H];
                                while (i12 < H) {
                                    fArr[i12] = Float.intBitsToFloat(t(this.f64193b[H(i16 + 1)]));
                                    i16 += 3;
                                    i12++;
                                }
                                aVar.a(str, fArr);
                            } else if (i17 == 83) {
                                short[] sArr = new short[H];
                                while (i12 < H) {
                                    sArr[i12] = (short) t(this.f64193b[H(i16 + 1)]);
                                    i16 += 3;
                                    i12++;
                                }
                                aVar.a(str, sArr);
                            } else if (i17 == 90) {
                                boolean[] zArr = new boolean[H];
                                for (int i18 = 0; i18 < H; i18++) {
                                    zArr[i18] = t(this.f64193b[H(i16 + 1)]) != 0;
                                    i16 += 3;
                                }
                                aVar.a(str, zArr);
                            } else if (i17 == 73) {
                                int[] iArr = new int[H];
                                while (i12 < H) {
                                    iArr[i12] = t(this.f64193b[H(i16 + 1)]);
                                    i16 += 3;
                                    i12++;
                                }
                                aVar.a(str, iArr);
                            } else if (i17 != 74) {
                                switch (i17) {
                                    case 66:
                                        byte[] bArr = new byte[H];
                                        while (i12 < H) {
                                            bArr[i12] = (byte) t(this.f64193b[H(i16 + 1)]);
                                            i16 += 3;
                                            i12++;
                                        }
                                        aVar.a(str, bArr);
                                        break;
                                    case 67:
                                        char[] cArr2 = new char[H];
                                        while (i12 < H) {
                                            cArr2[i12] = (char) t(this.f64193b[H(i16 + 1)]);
                                            i16 += 3;
                                            i12++;
                                        }
                                        aVar.a(str, cArr2);
                                        break;
                                    case 68:
                                        double[] dArr = new double[H];
                                        while (i12 < H) {
                                            dArr[i12] = Double.longBitsToDouble(v(this.f64193b[H(i16 + 1)]));
                                            i16 += 3;
                                            i12++;
                                        }
                                        aVar.a(str, dArr);
                                        break;
                                    default:
                                        return r(aVar.c(str), i11 + 1, false, cArr);
                                }
                            } else {
                                long[] jArr = new long[H];
                                while (i12 < H) {
                                    jArr[i12] = v(this.f64193b[H(i16 + 1)]);
                                    i16 += 3;
                                    i12++;
                                }
                                aVar.a(str, jArr);
                            }
                            return i16;
                        }
                        switch (i15) {
                            case 66:
                                aVar.a(str, Byte.valueOf((byte) t(this.f64193b[H(i14)])));
                                break;
                            case 67:
                                aVar.a(str, Character.valueOf((char) t(this.f64193b[H(i14)])));
                                break;
                            case 68:
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    }
                }
            }
            return i11 + 3;
        }
        aVar.a(str, o(H(i14), cArr));
        return i11 + 3;
    }

    private int r(a aVar, int i11, boolean z10, char[] cArr) {
        int H = H(i11);
        int i12 = i11 + 2;
        if (!z10) {
            while (true) {
                int i13 = H - 1;
                if (H <= 0) {
                    break;
                }
                i12 = q(aVar, i12, null, cArr);
                H = i13;
            }
        } else {
            while (true) {
                int i14 = H - 1;
                if (H <= 0) {
                    break;
                }
                i12 = q(aVar, i12 + 2, G(i12, cArr), cArr);
                H = i14;
            }
        }
        if (aVar != null) {
            aVar.d();
        }
        return i12;
    }

    private int s(f fVar, i iVar, int i11) {
        int i12;
        int i13;
        i iVar2 = iVar;
        char[] cArr = iVar2.f64231c;
        int H = H(i11);
        String G = G(i11 + 2, cArr);
        String G2 = G(i11 + 4, cArr);
        int H2 = H(i11 + 6);
        int i14 = i11 + 8;
        int i15 = H;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        c cVar = null;
        String str = null;
        Object obj = null;
        while (true) {
            int i20 = H2 - 1;
            if (H2 <= 0) {
                break;
            }
            String G3 = G(i14, cArr);
            int t11 = t(i14 + 2);
            int i21 = i14 + 6;
            if ("ConstantValue".equals(G3)) {
                int H3 = H(i21);
                obj = H3 == 0 ? null : o(H3, cArr);
            } else if (RequestParameters.SIGNATURE.equals(G3)) {
                str = G(i21, cArr);
            } else {
                if ("Deprecated".equals(G3)) {
                    i13 = 131072 | i15;
                } else if ("Synthetic".equals(G3)) {
                    i13 = i15 | 4096;
                } else {
                    if ("RuntimeVisibleAnnotations".equals(G3)) {
                        i19 = i21;
                        i12 = i19;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(G3)) {
                        i17 = i21;
                        i12 = i17;
                    } else if ("RuntimeInvisibleAnnotations".equals(G3)) {
                        i18 = i21;
                        i12 = i18;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(G3)) {
                        i16 = i21;
                        i12 = i16;
                    } else {
                        i12 = i21;
                        c cVar2 = cVar;
                        cVar = j(iVar2.f64229a, G3, i12, t11, cArr, -1, null);
                        cVar.f64187c = cVar2;
                        i18 = i18;
                        i19 = i19;
                        i16 = i16;
                        i17 = i17;
                    }
                    i14 = i12 + t11;
                    iVar2 = iVar;
                    H2 = i20;
                }
                i15 = i13;
            }
            i12 = i21;
            i14 = i12 + t11;
            iVar2 = iVar;
            H2 = i20;
        }
        c cVar3 = cVar;
        int i22 = i16;
        int i23 = i17;
        int i24 = i18;
        int i25 = i19;
        l e11 = fVar.e(i15, G, G2, str, obj);
        if (e11 == null) {
            return i14;
        }
        if (i25 != 0) {
            int H4 = H(i25);
            int i26 = i25 + 2;
            while (true) {
                int i27 = H4 - 1;
                if (H4 <= 0) {
                    break;
                }
                i26 = r(e11.a(G(i26, cArr), true), i26 + 2, true, cArr);
                H4 = i27;
            }
        }
        if (i24 != 0) {
            int H5 = H(i24);
            int i28 = i24 + 2;
            while (true) {
                int i29 = H5 - 1;
                if (H5 <= 0) {
                    break;
                }
                i28 = r(e11.a(G(i28, cArr), false), i28 + 2, true, cArr);
                H5 = i29;
            }
        }
        if (i23 != 0) {
            int H6 = H(i23);
            int i30 = i23 + 2;
            while (true) {
                int i31 = H6 - 1;
                if (H6 <= 0) {
                    break;
                }
                int E = E(iVar, i30);
                i30 = r(e11.d(iVar.f64236h, iVar.f64237i, G(E, cArr), true), E + 2, true, cArr);
                H6 = i31;
            }
        }
        if (i22 != 0) {
            int H7 = H(i22);
            int i32 = i22 + 2;
            while (true) {
                int i33 = H7 - 1;
                if (H7 <= 0) {
                    break;
                }
                int E2 = E(iVar, i32);
                i32 = r(e11.d(iVar.f64236h, iVar.f64237i, G(E2, cArr), false), E2 + 2, true, cArr);
                H7 = i33;
            }
        }
        while (true) {
            c cVar4 = cVar3;
            if (cVar4 == null) {
                e11.c();
                return i14;
            }
            cVar3 = cVar4.f64187c;
            cVar4.f64187c = null;
            e11.b(cVar4);
        }
    }

    private int w(f fVar, i iVar, int i11) {
        int i12;
        int i13;
        char[] cArr = iVar.f64231c;
        iVar.f64232d = H(i11);
        iVar.f64233e = G(i11 + 2, cArr);
        int i14 = i11 + 4;
        iVar.f64234f = G(i14, cArr);
        int H = H(i11 + 6);
        int i15 = i11 + 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        c cVar = null;
        boolean z10 = false;
        int i23 = 0;
        String[] strArr = null;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (true) {
            int i27 = H - 1;
            if (H <= 0) {
                break;
            }
            String G = G(i15, cArr);
            int t11 = t(i15 + 2);
            int i28 = i22;
            int i29 = i15 + 6;
            int i30 = i16;
            if (!"Code".equals(G)) {
                if ("Exceptions".equals(G)) {
                    int H2 = H(i29);
                    String[] strArr2 = new String[H2];
                    int i31 = i15 + 8;
                    i12 = i17;
                    for (int i32 = 0; i32 < H2; i32++) {
                        strArr2[i32] = m(i31, cArr);
                        i31 += 2;
                    }
                    strArr = strArr2;
                    i23 = i29;
                    i13 = i23;
                } else {
                    i12 = i17;
                    if (RequestParameters.SIGNATURE.equals(G)) {
                        i13 = i29;
                        i16 = i30;
                        i17 = i12;
                        i22 = H(i29);
                    } else if ("Deprecated".equals(G)) {
                        iVar.f64232d |= 131072;
                        i13 = i29;
                    } else if ("RuntimeVisibleAnnotations".equals(G)) {
                        i19 = i29;
                        i13 = i19;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(G)) {
                        i17 = i29;
                        i13 = i17;
                        i22 = i28;
                        i16 = i30;
                    } else if ("AnnotationDefault".equals(G)) {
                        i21 = i29;
                        i13 = i21;
                    } else if ("Synthetic".equals(G)) {
                        iVar.f64232d |= 4096;
                        i13 = i29;
                        i22 = i28;
                        i16 = i30;
                        i17 = i12;
                        z10 = true;
                    } else if ("RuntimeInvisibleAnnotations".equals(G)) {
                        i18 = i29;
                        i13 = i18;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(G)) {
                        i16 = i29;
                        i13 = i16;
                        i22 = i28;
                    } else if ("RuntimeVisibleParameterAnnotations".equals(G)) {
                        i24 = i29;
                        i13 = i24;
                    } else if ("RuntimeInvisibleParameterAnnotations".equals(G)) {
                        i25 = i29;
                        i13 = i25;
                    } else if ("MethodParameters".equals(G)) {
                        i20 = i29;
                        i13 = i20;
                    } else {
                        i13 = i29;
                        c j11 = j(iVar.f64229a, G, i29, t11, cArr, -1, null);
                        j11.f64187c = cVar;
                        cVar = j11;
                        i22 = i28;
                        i16 = i30;
                        i17 = i12;
                        i18 = i18;
                        i19 = i19;
                        i20 = i20;
                        i21 = i21;
                    }
                    i15 = i13 + t11;
                    H = i27;
                }
                i22 = i28;
                i16 = i30;
            } else if ((iVar.f64230b & 1) == 0) {
                i26 = i29;
                i13 = i26;
                i22 = i28;
                i16 = i30;
                i15 = i13 + t11;
                H = i27;
            } else {
                i12 = i17;
                i13 = i29;
                i22 = i28;
                i16 = i30;
            }
            i17 = i12;
            i15 = i13 + t11;
            H = i27;
        }
        int i33 = i16;
        int i34 = i17;
        int i35 = i18;
        int i36 = i19;
        int i37 = i20;
        int i38 = i21;
        r g11 = fVar.g(iVar.f64232d, iVar.f64233e, iVar.f64234f, i22 == 0 ? null : J(i22, cArr), strArr);
        if (g11 == null) {
            return i15;
        }
        if (g11 instanceof s) {
            if (((s) g11).H(this, i11, i15 - i11, z10, (iVar.f64232d & 131072) != 0, H(i14), i22, i23)) {
                return i15;
            }
        }
        if (i37 != 0) {
            int l11 = l(i37);
            int i39 = i37 + 1;
            while (true) {
                int i40 = l11 - 1;
                if (l11 <= 0) {
                    break;
                }
                g11.y(G(i39, cArr), H(i39 + 2));
                i39 += 4;
                l11 = i40;
            }
        }
        if (i38 != 0) {
            a c11 = g11.c();
            q(c11, i38, null, cArr);
            if (c11 != null) {
                c11.d();
            }
        }
        if (i36 != 0) {
            int H3 = H(i36);
            int i41 = i36 + 2;
            while (true) {
                int i42 = H3 - 1;
                if (H3 <= 0) {
                    break;
                }
                i41 = r(g11.b(G(i41, cArr), true), i41 + 2, true, cArr);
                H3 = i42;
            }
        }
        if (i35 != 0) {
            int H4 = H(i35);
            int i43 = i35 + 2;
            while (true) {
                int i44 = H4 - 1;
                if (H4 <= 0) {
                    break;
                }
                i43 = r(g11.b(G(i43, cArr), false), i43 + 2, true, cArr);
                H4 = i44;
            }
        }
        if (i34 != 0) {
            int H5 = H(i34);
            int i45 = i34 + 2;
            while (true) {
                int i46 = H5 - 1;
                if (H5 <= 0) {
                    break;
                }
                int E = E(iVar, i45);
                i45 = r(g11.D(iVar.f64236h, iVar.f64237i, G(E, cArr), true), E + 2, true, cArr);
                H5 = i46;
            }
        }
        if (i33 != 0) {
            int H6 = H(i33);
            int i47 = i33 + 2;
            while (true) {
                int i48 = H6 - 1;
                if (H6 <= 0) {
                    break;
                }
                int E2 = E(iVar, i47);
                i47 = r(g11.D(iVar.f64236h, iVar.f64237i, G(E2, cArr), false), E2 + 2, true, cArr);
                H6 = i48;
            }
        }
        int i49 = i24;
        if (i49 != 0) {
            A(g11, iVar, i49, true);
        }
        int i50 = i25;
        if (i50 != 0) {
            A(g11, iVar, i50, false);
        }
        while (cVar != null) {
            c cVar2 = cVar.f64187c;
            cVar.f64187c = null;
            g11.d(cVar);
            cVar = cVar2;
        }
        int i51 = i26;
        if (i51 != 0) {
            g11.e();
            n(g11, iVar, i51);
        }
        g11.f();
        return i15;
    }

    private void y(f fVar, i iVar, int i11, int i12, String str) {
        String[] strArr;
        char[] cArr = iVar.f64231c;
        int i13 = i11 + 6;
        t h11 = fVar.h(x(i11, cArr), H(i11 + 2), G(i11 + 4, cArr));
        if (h11 == null) {
            return;
        }
        if (str != null) {
            h11.c(str);
        }
        if (i12 != 0) {
            int H = H(i12);
            int i14 = i12 + 2;
            while (true) {
                int i15 = H - 1;
                if (H <= 0) {
                    break;
                }
                h11.e(z(i14, cArr));
                i14 += 2;
                H = i15;
            }
        }
        int H2 = H(i13);
        int i16 = i11 + 8;
        while (true) {
            int i17 = H2 - 1;
            if (H2 <= 0) {
                break;
            }
            String x10 = x(i16, cArr);
            int H3 = H(i16 + 2);
            String G = G(i16 + 4, cArr);
            i16 += 6;
            h11.g(x10, H3, G);
            H2 = i17;
        }
        int H4 = H(i16);
        int i18 = i16 + 2;
        while (true) {
            int i19 = H4 - 1;
            String[] strArr2 = null;
            if (H4 <= 0) {
                break;
            }
            String z10 = z(i18, cArr);
            int H5 = H(i18 + 2);
            int H6 = H(i18 + 4);
            i18 += 6;
            if (H6 != 0) {
                strArr2 = new String[H6];
                for (int i20 = 0; i20 < H6; i20++) {
                    strArr2[i20] = x(i18, cArr);
                    i18 += 2;
                }
            }
            h11.b(z10, H5, strArr2);
            H4 = i19;
        }
        int H7 = H(i18);
        int i21 = i18 + 2;
        while (true) {
            int i22 = H7 - 1;
            if (H7 <= 0) {
                break;
            }
            String z11 = z(i21, cArr);
            int H8 = H(i21 + 2);
            int H9 = H(i21 + 4);
            i21 += 6;
            if (H9 != 0) {
                strArr = new String[H9];
                for (int i23 = 0; i23 < H9; i23++) {
                    strArr[i23] = x(i21, cArr);
                    i21 += 2;
                }
            } else {
                strArr = null;
            }
            h11.d(z11, H8, strArr);
            H7 = i22;
        }
        int H10 = H(i21);
        int i24 = i21 + 2;
        while (true) {
            int i25 = H10 - 1;
            if (H10 <= 0) {
                break;
            }
            h11.h(m(i24, cArr));
            i24 += 2;
            H10 = i25;
        }
        int H11 = H(i24);
        int i26 = i24 + 2;
        while (true) {
            int i27 = H11 - 1;
            if (H11 <= 0) {
                h11.a();
                return;
            }
            String m11 = m(i26, cArr);
            int H12 = H(i26 + 2);
            i26 += 4;
            String[] strArr3 = new String[H12];
            for (int i28 = 0; i28 < H12; i28++) {
                strArr3[i28] = m(i26, cArr);
                i26 += 2;
            }
            h11.f(m11, strArr3);
            H11 = i27;
        }
    }

    public short B(int i11) {
        byte[] bArr = this.f64192a;
        return (short) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    public String G(int i11, char[] cArr) {
        int H = H(i11);
        if (i11 == 0 || H == 0) {
            return null;
        }
        return J(H, cArr);
    }

    public int H(int i11) {
        byte[] bArr = this.f64192a;
        return (bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String J(int i11, char[] cArr) {
        String[] strArr = this.f64194c;
        String str = strArr[i11];
        if (str != null) {
            return str;
        }
        int i12 = this.f64193b[i11];
        String I = I(i12 + 2, H(i12), cArr);
        strArr[i11] = I;
        return I;
    }

    public void a(f fVar, c[] cVarArr, int i11) {
        int i12;
        int i13;
        int i14;
        String[] strArr;
        i iVar = new i();
        iVar.f64229a = cVarArr;
        iVar.f64230b = i11;
        char[] cArr = new char[this.f64197f];
        iVar.f64231c = cArr;
        int i15 = this.f64198g;
        int H = H(i15);
        String m11 = m(i15 + 2, cArr);
        String m12 = m(i15 + 4, cArr);
        int H2 = H(i15 + 6);
        String[] strArr2 = new String[H2];
        int i16 = i15 + 8;
        for (int i17 = 0; i17 < H2; i17++) {
            strArr2[i17] = m(i16, cArr);
            i16 += 2;
        }
        int e11 = e();
        int i18 = H;
        int H3 = H(e11 - 2);
        String str = null;
        String str2 = null;
        int i19 = 0;
        String str3 = null;
        int i20 = 0;
        String str4 = null;
        String str5 = null;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        c cVar = null;
        int i27 = 0;
        while (H3 > 0) {
            String G = G(e11, cArr);
            int t11 = t(e11 + 2);
            int i28 = e11 + 6;
            String str6 = str;
            if ("SourceFile".equals(G)) {
                i12 = i28;
                str2 = G(i28, cArr);
            } else if ("InnerClasses".equals(G)) {
                i27 = i28;
                i12 = i27;
            } else if ("EnclosingMethod".equals(G)) {
                i21 = i28;
                i12 = i21;
            } else if ("NestHost".equals(G)) {
                i12 = i28;
                str5 = m(i28, cArr);
            } else if ("NestMembers".equals(G)) {
                i26 = i28;
                i12 = i26;
            } else {
                if (RequestParameters.SIGNATURE.equals(G)) {
                    str3 = G(i28, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(G)) {
                    i22 = i28;
                    i12 = i22;
                } else if ("RuntimeVisibleTypeAnnotations".equals(G)) {
                    i24 = i28;
                    i12 = i24;
                } else if ("Deprecated".equals(G)) {
                    i18 |= 131072;
                } else if ("Synthetic".equals(G)) {
                    i18 |= 4096;
                } else if ("SourceDebugExtension".equals(G)) {
                    str = I(i28, t11, new char[t11]);
                    i12 = i28;
                    i13 = i16;
                    i14 = t11;
                    strArr = strArr2;
                    e11 = i12 + i14;
                    H3--;
                    strArr2 = strArr;
                    i16 = i13;
                } else if ("RuntimeInvisibleAnnotations".equals(G)) {
                    i23 = i28;
                    i12 = i23;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(G)) {
                    i25 = i28;
                    i12 = i25;
                } else if ("Module".equals(G)) {
                    i19 = i28;
                    i12 = i19;
                } else if ("ModuleMainClass".equals(G)) {
                    str4 = m(i28, cArr);
                } else if ("ModulePackages".equals(G)) {
                    i20 = i28;
                    i12 = i20;
                } else {
                    if ("BootstrapMethods".equals(G)) {
                        i12 = i28;
                        i13 = i16;
                        i14 = t11;
                        strArr = strArr2;
                        str = str6;
                    } else {
                        i12 = i28;
                        i13 = i16;
                        i14 = t11;
                        strArr = strArr2;
                        c j11 = j(cVarArr, G, i12, t11, cArr, -1, null);
                        j11.f64187c = cVar;
                        cVar = j11;
                        i18 = i18;
                        str = str6;
                        str2 = str2;
                    }
                    e11 = i12 + i14;
                    H3--;
                    strArr2 = strArr;
                    i16 = i13;
                }
                i12 = i28;
            }
            i13 = i16;
            i14 = t11;
            strArr = strArr2;
            str = str6;
            e11 = i12 + i14;
            H3--;
            strArr2 = strArr;
            i16 = i13;
        }
        String str7 = str;
        String str8 = str2;
        int i29 = i16;
        String[] strArr3 = strArr2;
        c cVar2 = cVar;
        fVar.a(t(this.f64193b[1] - 7), i18, m11, str3, m12, strArr3);
        if ((i11 & 2) == 0 && (str8 != null || str7 != null)) {
            fVar.l(str8, str7);
        }
        if (i19 != 0) {
            y(fVar, iVar, i19, i20, str4);
        }
        String str9 = str5;
        if (str9 != null) {
            fVar.i(str9);
        }
        int i30 = i21;
        if (i30 != 0) {
            String m13 = m(i30, cArr);
            int H4 = H(i30 + 2);
            fVar.k(m13, H4 == 0 ? null : G(this.f64193b[H4], cArr), H4 == 0 ? null : G(this.f64193b[H4] + 2, cArr));
        }
        int i31 = i22;
        if (i31 != 0) {
            int H5 = H(i31);
            int i32 = i31 + 2;
            while (true) {
                int i33 = H5 - 1;
                if (H5 <= 0) {
                    break;
                }
                i32 = r(fVar.b(G(i32, cArr), true), i32 + 2, true, cArr);
                H5 = i33;
            }
        }
        int i34 = i23;
        if (i34 != 0) {
            int H6 = H(i34);
            int i35 = i34 + 2;
            while (true) {
                int i36 = H6 - 1;
                if (H6 <= 0) {
                    break;
                }
                i35 = r(fVar.b(G(i35, cArr), false), i35 + 2, true, cArr);
                H6 = i36;
            }
        }
        int i37 = i24;
        if (i37 != 0) {
            int H7 = H(i37);
            int i38 = i37 + 2;
            while (true) {
                int i39 = H7 - 1;
                if (H7 <= 0) {
                    break;
                }
                int E = E(iVar, i38);
                i38 = r(fVar.m(iVar.f64236h, iVar.f64237i, G(E, cArr), true), E + 2, true, cArr);
                H7 = i39;
            }
        }
        int i40 = i25;
        if (i40 != 0) {
            int H8 = H(i40);
            int i41 = i40 + 2;
            while (true) {
                int i42 = H8 - 1;
                if (H8 <= 0) {
                    break;
                }
                int E2 = E(iVar, i41);
                i41 = r(fVar.m(iVar.f64236h, iVar.f64237i, G(E2, cArr), false), E2 + 2, true, cArr);
                H8 = i42;
            }
        }
        while (cVar2 != null) {
            c cVar3 = cVar2.f64187c;
            cVar2.f64187c = null;
            fVar.c(cVar2);
            cVar2 = cVar3;
        }
        int i43 = i26;
        if (i43 != 0) {
            int H9 = H(i43);
            int i44 = i43 + 2;
            while (true) {
                int i45 = H9 - 1;
                if (H9 <= 0) {
                    break;
                }
                fVar.j(m(i44, cArr));
                i44 += 2;
                H9 = i45;
            }
        }
        int i46 = i27;
        if (i46 != 0) {
            int H10 = H(i46);
            int i47 = i46 + 2;
            while (true) {
                int i48 = H10 - 1;
                if (H10 <= 0) {
                    break;
                }
                fVar.f(m(i47, cArr), m(i47 + 2, cArr), G(i47 + 4, cArr), H(i47 + 6));
                i47 += 8;
                H10 = i48;
            }
        }
        int H11 = H(i29);
        int i49 = i29 + 2;
        while (true) {
            int i50 = H11 - 1;
            if (H11 <= 0) {
                break;
            }
            i49 = s(fVar, iVar, i49);
            H11 = i50;
        }
        int H12 = H(i49);
        int i51 = i49 + 2;
        while (true) {
            int i52 = H12 - 1;
            if (H12 <= 0) {
                fVar.d();
                return;
            } else {
                i51 = w(fVar, iVar, i51);
                H12 = i52;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e() {
        int i11 = this.f64198g;
        int H = i11 + 8 + (H(i11 + 6) * 2);
        int H2 = H(H);
        int i12 = H + 2;
        while (true) {
            int i13 = H2 - 1;
            if (H2 <= 0) {
                break;
            }
            int H3 = H(i12 + 6);
            i12 += 8;
            while (true) {
                int i14 = H3 - 1;
                if (H3 > 0) {
                    i12 += t(i12 + 2) + 6;
                    H3 = i14;
                }
            }
            H2 = i13;
        }
        int H4 = H(i12);
        int i15 = i12 + 2;
        while (true) {
            int i16 = H4 - 1;
            if (H4 <= 0) {
                return i15 + 2;
            }
            int H5 = H(i15 + 6);
            i15 += 8;
            while (true) {
                int i17 = H5 - 1;
                if (H5 > 0) {
                    i15 += t(i15 + 2) + 6;
                    H5 = i17;
                }
            }
            H4 = i16;
        }
    }

    public int f(int i11) {
        return this.f64193b[i11];
    }

    public int g() {
        return this.f64193b.length;
    }

    public int h() {
        return this.f64197f;
    }

    public int l(int i11) {
        return this.f64192a[i11] & 255;
    }

    public String m(int i11, char[] cArr) {
        return D(i11, cArr);
    }

    public Object o(int i11, char[] cArr) {
        int i12 = this.f64193b[i11];
        byte b11 = this.f64192a[i12 - 1];
        switch (b11) {
            case 3:
                return Integer.valueOf(t(i12));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(t(i12)));
            case 5:
                return Long.valueOf(v(i12));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(v(i12)));
            case 7:
                return y.k(G(i12, cArr));
            case 8:
                return G(i12, cArr);
            default:
                switch (b11) {
                    case 15:
                        int l11 = l(i12);
                        int i13 = this.f64193b[H(i12 + 1)];
                        int i14 = this.f64193b[H(i13 + 2)];
                        return new o(l11, m(i13, cArr), G(i14, cArr), G(i14 + 2, cArr), this.f64192a[i13 - 1] == 11);
                    case 16:
                        return y.j(G(i12, cArr));
                    case 17:
                        return p(i11, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    public int t(int i11) {
        byte[] bArr = this.f64192a;
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    protected q u(int i11, q[] qVarArr) {
        if (qVarArr[i11] == null) {
            qVarArr[i11] = new q();
        }
        return qVarArr[i11];
    }

    public long v(int i11) {
        return (t(i11) << 32) | (t(i11 + 4) & 4294967295L);
    }

    public String x(int i11, char[] cArr) {
        return D(i11, cArr);
    }

    public String z(int i11, char[] cArr) {
        return D(i11, cArr);
    }
}
