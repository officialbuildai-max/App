package h10;

import androidx.core.view.ViewCompat;
import org.mvel2.ast.ASTNode;

/* loaded from: classes7.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    q f64264a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f64265b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f64266c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f64267d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f64268e;

    /* renamed from: f, reason: collision with root package name */
    private short f64269f;

    /* renamed from: g, reason: collision with root package name */
    private short f64270g;

    /* renamed from: h, reason: collision with root package name */
    private int f64271h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f64272i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(q qVar) {
        this.f64264a = qVar;
    }

    private void b(int i11) {
        if (this.f64272i == null) {
            this.f64272i = new int[2];
        }
        int length = this.f64272i.length;
        int i12 = this.f64271h;
        if (i12 >= length) {
            int[] iArr = new int[Math.max(i12 + 1, length * 2)];
            System.arraycopy(this.f64272i, 0, iArr, 0, length);
            this.f64272i = iArr;
        }
        int[] iArr2 = this.f64272i;
        int i13 = this.f64271h;
        this.f64271h = i13 + 1;
        iArr2[i13] = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(x xVar, Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() | 16777216 : obj instanceof String ? f(xVar, y.k((String) obj).e(), 0) : xVar.K("", ((q) obj).f64288d) | 50331648;
    }

    private static int f(x xVar, String str, int i11) {
        char charAt = str.charAt(i11);
        int i12 = 16777218;
        if (charAt == 'F') {
            return 16777218;
        }
        if (charAt == 'L') {
            return xVar.I(str.substring(i11 + 1, str.length() - 1)) | ASTNode.PCTX_STORED;
        }
        if (charAt != 'S') {
            if (charAt == 'V') {
                return 0;
            }
            if (charAt != 'I') {
                if (charAt == 'J') {
                    return 16777220;
                }
                if (charAt != 'Z') {
                    if (charAt == '[') {
                        int i13 = i11 + 1;
                        while (str.charAt(i13) == '[') {
                            i13++;
                        }
                        char charAt2 = str.charAt(i13);
                        if (charAt2 != 'F') {
                            if (charAt2 == 'L') {
                                i12 = xVar.I(str.substring(i13 + 1, str.length() - 1)) | ASTNode.PCTX_STORED;
                            } else if (charAt2 == 'S') {
                                i12 = 16777228;
                            } else if (charAt2 == 'Z') {
                                i12 = 16777225;
                            } else if (charAt2 == 'I') {
                                i12 = 16777217;
                            } else if (charAt2 != 'J') {
                                switch (charAt2) {
                                    case 'B':
                                        i12 = 16777226;
                                        break;
                                    case 'C':
                                        i12 = 16777227;
                                        break;
                                    case 'D':
                                        i12 = 16777219;
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            } else {
                                i12 = 16777220;
                            }
                        }
                        return ((i13 - i11) << 28) | i12;
                    }
                    switch (charAt) {
                        case 'B':
                        case 'C':
                            break;
                        case 'D':
                            return 16777219;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return 16777217;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(x xVar, String str) {
        return xVar.I(str) | ASTNode.PCTX_STORED;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[LOOP:0: B:8:0x000d->B:15:0x0051, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int h(h10.x r9, int r10) {
        /*
            r8 = this;
            r0 = 16777222(0x1000006, float:2.3509904E-38)
            if (r10 == r0) goto Lc
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r10
            r2 = 50331648(0x3000000, float:3.761582E-37)
            if (r1 != r2) goto L54
        Lc:
            r1 = 0
        Ld:
            int r2 = r8.f64271h
            if (r1 >= r2) goto L54
            int[] r2 = r8.f64272i
            r2 = r2[r1]
            r3 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r3 = r3 & r2
            r4 = 251658240(0xf000000, float:6.3108872E-30)
            r4 = r4 & r2
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r2 & r5
            r7 = 67108864(0x4000000, float:1.5046328E-36)
            if (r4 != r7) goto L2a
            int[] r2 = r8.f64265b
            r2 = r2[r6]
        L28:
            int r2 = r2 + r3
            goto L35
        L2a:
            r7 = 83886080(0x5000000, float:6.018531E-36)
            if (r4 != r7) goto L35
            int[] r2 = r8.f64266c
            int r4 = r2.length
            int r4 = r4 - r6
            r2 = r2[r4]
            goto L28
        L35:
            if (r10 != r2) goto L51
            r1 = 33554432(0x2000000, float:9.403955E-38)
            if (r10 != r0) goto L45
            java.lang.String r10 = r9.O()
            int r9 = r9.I(r10)
        L43:
            r9 = r9 | r1
            return r9
        L45:
            r10 = r10 & r5
            h10.w r10 = r9.T(r10)
            java.lang.String r10 = r10.f64357e
            int r9 = r9.I(r10)
            goto L43
        L51:
            int r1 = r1 + 1
            goto Ld
        L54:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: h10.n.h(h10.x, int):int");
    }

    private int j(int i11) {
        int[] iArr = this.f64267d;
        if (iArr == null || i11 >= iArr.length) {
            return i11 | 67108864;
        }
        int i12 = iArr[i11];
        if (i12 != 0) {
            return i12;
        }
        int i13 = i11 | 67108864;
        iArr[i11] = i13;
        return i13;
    }

    private static boolean k(x xVar, int i11, int[] iArr, int i12) {
        int min;
        int I;
        int i13 = iArr[i12];
        if (i13 == i11) {
            return false;
        }
        if ((268435455 & i11) == 16777221) {
            if (i13 == 16777221) {
                return false;
            }
            i11 = 16777221;
        }
        if (i13 == 0) {
            iArr[i12] = i11;
            return true;
        }
        int i14 = i13 & (-268435456);
        int i15 = 16777216;
        if (i14 != 0 || (i13 & 251658240) == 33554432) {
            if (i11 == 16777221) {
                return false;
            }
            if ((i11 & ViewCompat.MEASURED_STATE_MASK) != ((-16777216) & i13)) {
                int i16 = i11 & (-268435456);
                if (i16 != 0 || (i11 & 251658240) == 33554432) {
                    if (i16 != 0 && (i11 & 251658240) != 33554432) {
                        i16 -= 268435456;
                    }
                    if (i14 != 0 && (i13 & 251658240) != 33554432) {
                        i14 -= 268435456;
                    }
                    min = Math.min(i16, i14) | ASTNode.PCTX_STORED;
                    I = xVar.I("java/lang/Object");
                    i15 = min | I;
                }
            } else if ((i13 & 251658240) == 33554432) {
                i15 = (i11 & (-268435456)) | ASTNode.PCTX_STORED | xVar.H(i11 & 1048575, 1048575 & i13);
            } else {
                min = ((i11 & (-268435456)) - 268435456) | ASTNode.PCTX_STORED;
                I = xVar.I("java/lang/Object");
                i15 = min | I;
            }
        } else if (i13 == 16777221) {
            if ((i11 & (-268435456)) == 0 && (i11 & 251658240) != 33554432) {
                i11 = 16777216;
            }
            i15 = i11;
        }
        if (i15 == i13) {
            return false;
        }
        iArr[i12] = i15;
        return true;
    }

    private int m() {
        short s11 = this.f64270g;
        if (s11 <= 0) {
            short s12 = (short) (this.f64269f - 1);
            this.f64269f = s12;
            return (-s12) | 83886080;
        }
        int[] iArr = this.f64268e;
        short s13 = (short) (s11 - 1);
        this.f64270g = s13;
        return iArr[s13];
    }

    private void n(int i11) {
        short s11 = this.f64270g;
        if (s11 >= i11) {
            this.f64270g = (short) (s11 - i11);
        } else {
            this.f64269f = (short) (this.f64269f - (i11 - s11));
            this.f64270g = (short) 0;
        }
    }

    private void o(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            n((y.c(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            n(2);
        } else {
            n(1);
        }
    }

    private void p(int i11) {
        if (this.f64268e == null) {
            this.f64268e = new int[10];
        }
        int length = this.f64268e.length;
        short s11 = this.f64270g;
        if (s11 >= length) {
            int[] iArr = new int[Math.max(s11 + 1, length * 2)];
            System.arraycopy(this.f64268e, 0, iArr, 0, length);
            this.f64268e = iArr;
        }
        int[] iArr2 = this.f64268e;
        short s12 = this.f64270g;
        short s13 = (short) (s12 + 1);
        this.f64270g = s13;
        iArr2[s12] = i11;
        short s14 = (short) (this.f64269f + s13);
        q qVar = this.f64264a;
        if (s14 > qVar.f64292h) {
            qVar.f64292h = s14;
        }
    }

    private void q(x xVar, String str) {
        int f11 = f(xVar, str, str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0);
        if (f11 != 0) {
            p(f11);
            if (f11 == 16777220 || f11 == 16777219) {
                p(16777216);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:35:0x0084. Please report as an issue. */
    public static void r(x xVar, int i11, d dVar) {
        int i12 = ((-268435456) & i11) >> 28;
        if (i12 == 0) {
            int i13 = i11 & 1048575;
            int i14 = i11 & 251658240;
            if (i14 == 16777216) {
                dVar.g(i13);
                return;
            } else if (i14 == 33554432) {
                dVar.g(7).k(xVar.e(xVar.T(i13).f64357e).f64353a);
                return;
            } else {
                if (i14 != 50331648) {
                    throw new AssertionError();
                }
                dVar.g(8).k((int) xVar.T(i13).f64358f);
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i15 = i12 - 1;
            if (i12 <= 0) {
                break;
            }
            sb2.append('[');
            i12 = i15;
        }
        if ((i11 & 251658240) == 33554432) {
            sb2.append('L');
            sb2.append(xVar.T(i11 & 1048575).f64357e);
            sb2.append(';');
        } else {
            int i16 = i11 & 1048575;
            if (i16 == 1) {
                sb2.append('I');
            } else if (i16 == 2) {
                sb2.append('F');
            } else if (i16 == 3) {
                sb2.append('D');
            } else if (i16 != 4) {
                switch (i16) {
                    case 9:
                        sb2.append('Z');
                        break;
                    case 10:
                        sb2.append('B');
                        break;
                    case 11:
                        sb2.append('C');
                        break;
                    case 12:
                        sb2.append('S');
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                sb2.append('J');
            }
        }
        dVar.g(7).k(xVar.e(sb2.toString()).f64353a);
    }

    private void u(int i11, int i12) {
        if (this.f64267d == null) {
            this.f64267d = new int[10];
        }
        int length = this.f64267d.length;
        if (i11 >= length) {
            int[] iArr = new int[Math.max(i11 + 1, length * 2)];
            System.arraycopy(this.f64267d, 0, iArr, 0, length);
            this.f64267d = iArr;
        }
        this.f64267d[i11] = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(s sVar) {
        int[] iArr = this.f64265b;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = 2;
            if (i12 >= iArr.length) {
                break;
            }
            int i16 = iArr[i12];
            if (i16 != 16777220 && i16 != 16777219) {
                i15 = 1;
            }
            i12 += i15;
            if (i16 == 16777216) {
                i14++;
            } else {
                i13 += i14 + 1;
                i14 = 0;
            }
        }
        int[] iArr2 = this.f64266c;
        int i17 = 0;
        int i18 = 0;
        while (i17 < iArr2.length) {
            int i19 = iArr2[i17];
            i17 += (i19 == 16777220 || i19 == 16777219) ? 2 : 1;
            i18++;
        }
        int V = sVar.V(this.f64264a.f64288d, i13, i18);
        int i20 = 0;
        while (true) {
            int i21 = i13 - 1;
            if (i13 <= 0) {
                break;
            }
            int i22 = iArr[i20];
            i20 += (i22 == 16777220 || i22 == 16777219) ? 2 : 1;
            sVar.T(V, i22);
            i13 = i21;
            V++;
        }
        while (true) {
            int i23 = i18 - 1;
            if (i18 <= 0) {
                sVar.U();
                return;
            }
            int i24 = iArr2[i11];
            i11 += (i24 == 16777220 || i24 == 16777219) ? 2 : 1;
            sVar.T(V, i24);
            V++;
            i18 = i23;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(n nVar) {
        this.f64265b = nVar.f64265b;
        this.f64266c = nVar.f64266c;
        this.f64269f = (short) 0;
        this.f64267d = nVar.f64267d;
        this.f64268e = nVar.f64268e;
        this.f64270g = nVar.f64270g;
        this.f64271h = nVar.f64271h;
        this.f64272i = nVar.f64272i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0027. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0356  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(int r17, int r18, h10.w r19, h10.x r20) {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h10.n.d(int, int, h10.w, h10.x):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int i() {
        return this.f64266c.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        if (r8 == 16777219) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        if (r8 == 16777219) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f6, code lost:
    
        if (r6 == 16777219) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x010e, code lost:
    
        if (r6 == 16777219) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(h10.x r20, h10.n r21, int r22) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h10.n.l(h10.x, h10.n, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(x xVar, int i11, Object[] objArr, int i12, Object[] objArr2) {
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i13 + 1;
            this.f64265b[i13] = e(xVar, objArr[i14]);
            Object obj = objArr[i14];
            if (obj == v.f64350e || obj == v.f64349d) {
                i13 += 2;
                this.f64265b[i15] = 16777216;
            } else {
                i13 = i15;
            }
        }
        while (true) {
            int[] iArr = this.f64265b;
            if (i13 >= iArr.length) {
                break;
            }
            iArr[i13] = 16777216;
            i13++;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < i12; i17++) {
            Object obj2 = objArr2[i17];
            if (obj2 == v.f64350e || obj2 == v.f64349d) {
                i16++;
            }
        }
        this.f64266c = new int[i16 + i12];
        int i18 = 0;
        for (int i19 = 0; i19 < i12; i19++) {
            int i20 = i18 + 1;
            this.f64266c[i18] = e(xVar, objArr2[i19]);
            Object obj3 = objArr2[i19];
            if (obj3 == v.f64350e || obj3 == v.f64349d) {
                i18 += 2;
                this.f64266c[i20] = 16777216;
            } else {
                i18 = i20;
            }
        }
        this.f64270g = (short) 0;
        this.f64271h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(x xVar, int i11, String str, int i12) {
        int i13;
        int[] iArr = new int[i12];
        this.f64265b = iArr;
        this.f64266c = new int[0];
        if ((i11 & 8) == 0) {
            i13 = 1;
            if ((i11 & 262144) == 0) {
                iArr[0] = xVar.I(xVar.O()) | ASTNode.PCTX_STORED;
            } else {
                iArr[0] = 16777222;
            }
        } else {
            i13 = 0;
        }
        for (y yVar : y.b(str)) {
            int f11 = f(xVar, yVar.e(), 0);
            int[] iArr2 = this.f64265b;
            int i14 = i13 + 1;
            iArr2[i13] = f11;
            if (f11 == 16777220 || f11 == 16777219) {
                i13 += 2;
                iArr2[i14] = 16777216;
            } else {
                i13 = i14;
            }
        }
        while (i13 < i12) {
            this.f64265b[i13] = 16777216;
            i13++;
        }
    }
}
