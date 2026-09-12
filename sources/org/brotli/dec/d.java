package org.brotli.dec;

import okhttp3.internal.http2.Settings;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f71750a = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f71751b = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f71752c = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f71753d = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

    private static void a(j jVar) {
        a aVar = jVar.f71772c;
        byte[] bArr = jVar.f71773d;
        int i11 = jVar.f71776g;
        if (i11 <= 0) {
            a.k(aVar);
            jVar.f71770a = 1;
            return;
        }
        int min = Math.min(jVar.Q - jVar.f71787r, i11);
        a.c(aVar, bArr, jVar.f71787r, min);
        jVar.f71776g -= min;
        int i12 = jVar.f71787r + min;
        jVar.f71787r = i12;
        int i13 = jVar.Q;
        if (i12 != i13) {
            a.k(aVar);
            jVar.f71770a = 1;
        } else {
            jVar.f71771b = 5;
            jVar.Y = i13;
            jVar.X = 0;
            jVar.f71770a = 12;
        }
    }

    private static void b(j jVar, int i11) {
        a aVar = jVar.f71772c;
        int[] iArr = jVar.f71785p;
        int i12 = i11 * 2;
        a.d(aVar);
        int i13 = i11 * 1080;
        int r11 = r(jVar.f71774e, i13, aVar);
        jVar.f71783n[i11] = m(jVar.f71775f, i13, aVar);
        int i14 = r11 == 1 ? iArr[i12 + 1] + 1 : r11 == 0 ? iArr[i12] : r11 - 2;
        int i15 = jVar.f71784o[i11];
        if (i14 >= i15) {
            i14 -= i15;
        }
        int i16 = i12 + 1;
        iArr[i12] = iArr[i16];
        iArr[i16] = i14;
    }

    private static void c(j jVar) {
        b(jVar, 1);
        jVar.F = jVar.f71781l.f71759c[jVar.f71785p[3]];
    }

    private static int d(int i11, byte[] bArr, a aVar) {
        a.j(aVar);
        int h11 = h(aVar) + 1;
        if (h11 == 1) {
            l.a(bArr, 0, i11);
            return h11;
        }
        int i12 = a.i(aVar, 1) == 1 ? a.i(aVar, 4) + 1 : 0;
        int[] iArr = new int[1080];
        n(h11 + i12, iArr, 0, aVar);
        int i13 = 0;
        while (i13 < i11) {
            a.j(aVar);
            a.d(aVar);
            int r11 = r(iArr, 0, aVar);
            if (r11 == 0) {
                bArr[i13] = 0;
            } else if (r11 <= i12) {
                for (int i14 = (1 << r11) + a.i(aVar, r11); i14 != 0; i14--) {
                    if (i13 >= i11) {
                        throw new BrotliRuntimeException("Corrupted context map");
                    }
                    bArr[i13] = 0;
                    i13++;
                }
            } else {
                bArr[i13] = (byte) (r11 - i12);
            }
            i13++;
        }
        if (a.i(aVar, 1) == 1) {
            j(bArr, i11);
        }
        return h11;
    }

    private static void e(j jVar) {
        b(jVar, 2);
        jVar.C = jVar.f71785p[5] << 2;
    }

    private static void f(j jVar) {
        b(jVar, 0);
        int i11 = jVar.f71785p[1];
        int i12 = i11 << 6;
        jVar.B = i12;
        int i13 = jVar.A[i12] & 255;
        jVar.f71791v = i13;
        jVar.f71792w = jVar.f71780k.f71759c[i13];
        byte b11 = jVar.f71795z[i11];
        int[] iArr = c.f71749b;
        jVar.D = iArr[b11];
        jVar.E = iArr[b11 + 1];
    }

    private static void g(a aVar, j jVar) {
        boolean z10 = a.i(aVar, 1) == 1;
        jVar.f71777h = z10;
        jVar.f71776g = 0;
        jVar.f71778i = false;
        jVar.f71779j = false;
        if (!z10 || a.i(aVar, 1) == 0) {
            int i11 = a.i(aVar, 2) + 4;
            if (i11 == 7) {
                jVar.f71779j = true;
                if (a.i(aVar, 1) != 0) {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
                int i12 = a.i(aVar, 2);
                if (i12 == 0) {
                    return;
                }
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = a.i(aVar, 8);
                    if (i14 == 0 && i13 + 1 == i12 && i12 > 1) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    jVar.f71776g = (i14 << (i13 * 8)) | jVar.f71776g;
                }
            } else {
                for (int i15 = 0; i15 < i11; i15++) {
                    int i16 = a.i(aVar, 4);
                    if (i16 == 0 && i15 + 1 == i11 && i11 > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    jVar.f71776g = (i16 << (i15 * 4)) | jVar.f71776g;
                }
            }
            jVar.f71776g++;
            if (jVar.f71777h) {
                return;
            }
            jVar.f71778i = a.i(aVar, 1) == 1;
        }
    }

    private static int h(a aVar) {
        if (a.i(aVar, 1) == 0) {
            return 0;
        }
        int i11 = a.i(aVar, 3);
        if (i11 == 0) {
            return 1;
        }
        return a.i(aVar, i11) + (1 << i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x00a6, code lost:
    
        throw new org.brotli.dec.BrotliRuntimeException("Invalid backward reference");
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0029. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(org.brotli.dec.j r19) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.d.i(org.brotli.dec.j):void");
    }

    private static void j(byte[] bArr, int i11) {
        int[] iArr = new int[256];
        for (int i12 = 0; i12 < 256; i12++) {
            iArr[i12] = i12;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = bArr[i13] & 255;
            bArr[i13] = (byte) iArr[i14];
            if (i14 != 0) {
                l(iArr, i14);
            }
        }
    }

    private static void k(j jVar) {
        int i11;
        int i12 = jVar.P;
        long j11 = i12;
        long j12 = jVar.R;
        if (j11 > j12) {
            while (true) {
                int i13 = i12 >> 1;
                if (i13 <= ((int) j12) + jVar.S.length) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            if (!jVar.f71777h && i12 < 16384 && jVar.P >= 16384) {
                i12 = 16384;
            }
        }
        int i14 = jVar.Q;
        if (i12 <= i14) {
            return;
        }
        byte[] bArr = new byte[i12 + 37];
        byte[] bArr2 = jVar.f71773d;
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr, 0, i14);
        } else {
            byte[] bArr3 = jVar.S;
            if (bArr3.length != 0) {
                int length = bArr3.length;
                int i15 = jVar.O;
                if (length > i15) {
                    i11 = length - i15;
                } else {
                    i15 = length;
                    i11 = 0;
                }
                System.arraycopy(bArr3, i11, bArr, 0, i15);
                jVar.f71787r = i15;
                jVar.T = i15;
            }
        }
        jVar.f71773d = bArr;
        jVar.Q = i12;
    }

    private static void l(int[] iArr, int i11) {
        int i12 = iArr[i11];
        while (i11 > 0) {
            iArr[i11] = iArr[i11 - 1];
            i11--;
        }
        iArr[0] = i12;
    }

    private static int m(int[] iArr, int i11, a aVar) {
        a.d(aVar);
        int r11 = r(iArr, i11, aVar);
        return i.f71762a[r11] + a.i(aVar, i.f71763b[r11]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void n(int r15, int[] r16, int r17, org.brotli.dec.a r18) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.d.n(int, int[], int, org.brotli.dec.a):void");
    }

    private static void o(int[] iArr, int i11, int[] iArr2, a aVar) {
        int[] iArr3 = new int[32];
        f.a(iArr3, 0, 5, iArr, 18);
        int i12 = 8;
        int i13 = 32768;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < i11 && i13 > 0) {
            a.j(aVar);
            a.d(aVar);
            long j11 = aVar.f71740f;
            int i17 = aVar.f71741g;
            int i18 = iArr3[((int) (j11 >>> i17)) & 31];
            aVar.f71741g = i17 + (i18 >> 16);
            int i19 = i18 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            if (i19 < 16) {
                int i20 = i14 + 1;
                iArr2[i14] = i19;
                if (i19 != 0) {
                    i13 -= 32768 >> i19;
                    i14 = i20;
                    i12 = i19;
                } else {
                    i14 = i20;
                }
                i16 = 0;
            } else {
                int i21 = i19 - 14;
                int i22 = i19 == 16 ? i12 : 0;
                if (i15 != i22) {
                    i16 = 0;
                    i15 = i22;
                }
                int i23 = (i16 > 0 ? (i16 - 2) << i21 : i16) + a.i(aVar, i21) + 3;
                int i24 = i23 - i16;
                if (i14 + i24 > i11) {
                    throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                }
                int i25 = 0;
                while (i25 < i24) {
                    iArr2[i14] = i15;
                    i25++;
                    i14++;
                }
                if (i15 != 0) {
                    i13 -= i24 << (15 - i15);
                }
                i16 = i23;
            }
        }
        if (i13 != 0) {
            throw new BrotliRuntimeException("Unused space");
        }
        l.b(iArr2, i14, i11 - i14);
    }

    private static void p(j jVar) {
        int i11;
        int[] iArr;
        a aVar = jVar.f71772c;
        for (int i12 = 0; i12 < 3; i12++) {
            jVar.f71784o[i12] = h(aVar) + 1;
            jVar.f71783n[i12] = 268435456;
            int i13 = jVar.f71784o[i12];
            if (i13 > 1) {
                int i14 = i12 * 1080;
                n(i13 + 2, jVar.f71774e, i14, aVar);
                n(26, jVar.f71775f, i14, aVar);
                jVar.f71783n[i12] = m(jVar.f71775f, i14, aVar);
            }
        }
        a.j(aVar);
        jVar.K = a.i(aVar, 2);
        int i15 = a.i(aVar, 4);
        int i16 = jVar.K;
        int i17 = (i15 << i16) + 16;
        jVar.I = i17;
        jVar.J = (1 << i16) - 1;
        int i18 = i17 + (48 << i16);
        jVar.f71795z = new byte[jVar.f71784o[0]];
        int i19 = 0;
        while (true) {
            i11 = jVar.f71784o[0];
            if (i19 >= i11) {
                break;
            }
            int min = Math.min(i19 + 96, i11);
            while (i19 < min) {
                jVar.f71795z[i19] = (byte) (a.i(aVar, 2) << 1);
                i19++;
            }
            a.j(aVar);
        }
        byte[] bArr = new byte[i11 << 6];
        jVar.A = bArr;
        int d11 = d(i11 << 6, bArr, aVar);
        jVar.f71790u = true;
        int i20 = 0;
        while (true) {
            iArr = jVar.f71784o;
            if (i20 >= (iArr[0] << 6)) {
                break;
            }
            if (jVar.A[i20] != (i20 >> 6)) {
                jVar.f71790u = false;
                break;
            }
            i20++;
        }
        int i21 = iArr[2];
        byte[] bArr2 = new byte[i21 << 2];
        jVar.H = bArr2;
        int d12 = d(i21 << 2, bArr2, aVar);
        g.b(jVar.f71780k, 256, d11);
        g.b(jVar.f71781l, 704, jVar.f71784o[1]);
        g.b(jVar.f71782m, i18, d12);
        g.a(jVar.f71780k, aVar);
        g.a(jVar.f71781l, aVar);
        g.a(jVar.f71782m, aVar);
        jVar.B = 0;
        jVar.C = 0;
        int[] iArr2 = c.f71749b;
        byte b11 = jVar.f71795z[0];
        jVar.D = iArr2[b11];
        jVar.E = iArr2[b11 + 1];
        jVar.f71791v = 0;
        jVar.f71792w = jVar.f71780k.f71759c[0];
        jVar.F = jVar.f71781l.f71759c[0];
        int[] iArr3 = jVar.f71785p;
        iArr3[4] = 1;
        iArr3[2] = 1;
        iArr3[0] = 1;
        iArr3[5] = 0;
        iArr3[3] = 0;
        iArr3[1] = 0;
    }

    private static void q(j jVar) {
        a aVar = jVar.f71772c;
        if (jVar.f71777h) {
            jVar.f71771b = 10;
            jVar.Y = jVar.f71787r;
            jVar.X = 0;
            jVar.f71770a = 12;
            return;
        }
        g gVar = jVar.f71780k;
        gVar.f71758b = null;
        gVar.f71759c = null;
        g gVar2 = jVar.f71781l;
        gVar2.f71758b = null;
        gVar2.f71759c = null;
        g gVar3 = jVar.f71782m;
        gVar3.f71758b = null;
        gVar3.f71759c = null;
        a.j(aVar);
        g(aVar, jVar);
        if (jVar.f71776g != 0 || jVar.f71779j) {
            if (jVar.f71778i || jVar.f71779j) {
                a.g(aVar);
                jVar.f71770a = jVar.f71779j ? 4 : 5;
            } else {
                jVar.f71770a = 2;
            }
            if (jVar.f71779j) {
                return;
            }
            jVar.R += jVar.f71776g;
            if (jVar.Q < jVar.P) {
                k(jVar);
            }
        }
    }

    private static int r(int[] iArr, int i11, a aVar) {
        long j11 = aVar.f71740f;
        int i12 = aVar.f71741g;
        int i13 = (int) (j11 >>> i12);
        int i14 = i11 + (i13 & 255);
        int i15 = iArr[i14];
        int i16 = i15 >> 16;
        int i17 = i15 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (i16 <= 8) {
            aVar.f71741g = i12 + i16;
            return i17;
        }
        int i18 = iArr[i14 + i17 + ((i13 & ((1 << i16) - 1)) >>> 8)];
        aVar.f71741g = i12 + (i18 >> 16) + 8;
        return i18 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void s(j jVar, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        jVar.S = bArr;
    }

    private static int t(int i11, int[] iArr, int i12) {
        return i11 < 16 ? iArr[(i12 + f71751b[i11]) & 3] + f71752c[i11] : i11 - 15;
    }

    private static boolean u(j jVar) {
        int i11 = jVar.T;
        if (i11 != 0) {
            jVar.X += i11;
            jVar.T = 0;
        }
        int min = Math.min(jVar.V - jVar.W, jVar.Y - jVar.X);
        if (min != 0) {
            System.arraycopy(jVar.f71773d, jVar.X, jVar.Z, jVar.U + jVar.W, min);
            jVar.W += min;
            jVar.X += min;
        }
        return jVar.W < jVar.V;
    }
}
