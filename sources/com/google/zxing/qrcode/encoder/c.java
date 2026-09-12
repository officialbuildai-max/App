package com.google.zxing.qrcode.encoder;

/* loaded from: classes4.dex */
abstract class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(yd.a aVar) {
        return b(aVar, true) + b(aVar, false);
    }

    private static int b(yd.a aVar, boolean z10) {
        int d11 = z10 ? aVar.d() : aVar.e();
        int e11 = z10 ? aVar.e() : aVar.d();
        byte[][] c11 = aVar.c();
        int i11 = 0;
        for (int i12 = 0; i12 < d11; i12++) {
            byte b11 = -1;
            int i13 = 0;
            for (int i14 = 0; i14 < e11; i14++) {
                byte b12 = z10 ? c11[i12][i14] : c11[i14][i12];
                if (b12 == b11) {
                    i13++;
                } else {
                    if (i13 >= 5) {
                        i11 += i13 - 2;
                    }
                    i13 = 1;
                    b11 = b12;
                }
            }
            if (i13 >= 5) {
                i11 += i13 - 2;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(yd.a aVar) {
        byte[][] c11 = aVar.c();
        int e11 = aVar.e();
        int d11 = aVar.d();
        int i11 = 0;
        for (int i12 = 0; i12 < d11 - 1; i12++) {
            byte[] bArr = c11[i12];
            int i13 = 0;
            while (i13 < e11 - 1) {
                byte b11 = bArr[i13];
                int i14 = i13 + 1;
                if (b11 == bArr[i14]) {
                    byte[] bArr2 = c11[i12 + 1];
                    if (b11 == bArr2[i13] && b11 == bArr2[i14]) {
                        i11++;
                    }
                }
                i13 = i14;
            }
        }
        return i11 * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(yd.a aVar) {
        byte[][] c11 = aVar.c();
        int e11 = aVar.e();
        int d11 = aVar.d();
        int i11 = 0;
        for (int i12 = 0; i12 < d11; i12++) {
            for (int i13 = 0; i13 < e11; i13++) {
                byte[] bArr = c11[i12];
                int i14 = i13 + 6;
                if (i14 < e11 && bArr[i13] == 1 && bArr[i13 + 1] == 0 && bArr[i13 + 2] == 1 && bArr[i13 + 3] == 1 && bArr[i13 + 4] == 1 && bArr[i13 + 5] == 0 && bArr[i14] == 1 && (g(bArr, i13 - 4, i13) || g(bArr, i13 + 7, i13 + 11))) {
                    i11++;
                }
                int i15 = i12 + 6;
                if (i15 < d11 && c11[i12][i13] == 1 && c11[i12 + 1][i13] == 0 && c11[i12 + 2][i13] == 1 && c11[i12 + 3][i13] == 1 && c11[i12 + 4][i13] == 1 && c11[i12 + 5][i13] == 0 && c11[i15][i13] == 1 && (h(c11, i13, i12 - 4, i12) || h(c11, i13, i12 + 7, i12 + 11))) {
                    i11++;
                }
            }
        }
        return i11 * 40;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(yd.a aVar) {
        byte[][] c11 = aVar.c();
        int e11 = aVar.e();
        int d11 = aVar.d();
        int i11 = 0;
        for (int i12 = 0; i12 < d11; i12++) {
            byte[] bArr = c11[i12];
            for (int i13 = 0; i13 < e11; i13++) {
                if (bArr[i13] == 1) {
                    i11++;
                }
            }
        }
        int d12 = aVar.d() * aVar.e();
        return ((Math.abs((i11 * 2) - d12) * 10) / d12) * 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L37;
                case 1: goto L38;
                case 2: goto L3f;
                case 3: goto L3b;
                case 4: goto L33;
                case 5: goto L2c;
                case 6: goto L25;
                case 7: goto L1b;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L1b:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
        L23:
            r1 = r1 & r0
            goto L41
        L25:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L23
        L2c:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L41
        L33:
            int r3 = r3 / 2
            int r2 = r2 / 3
        L37:
            int r3 = r3 + r2
        L38:
            r1 = r3 & 1
            goto L41
        L3b:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L41
        L3f:
            int r1 = r2 % 3
        L41:
            if (r1 != 0) goto L44
            goto L45
        L44:
            r0 = 0
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.c.f(int, int, int):boolean");
    }

    private static boolean g(byte[] bArr, int i11, int i12) {
        if (i11 < 0 || bArr.length < i12) {
            return false;
        }
        while (i11 < i12) {
            if (bArr[i11] == 1) {
                return false;
            }
            i11++;
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i11, int i12, int i13) {
        if (i12 < 0 || bArr.length < i13) {
            return false;
        }
        while (i12 < i13) {
            if (bArr[i12][i11] == 1) {
                return false;
            }
            i12++;
        }
        return true;
    }
}
