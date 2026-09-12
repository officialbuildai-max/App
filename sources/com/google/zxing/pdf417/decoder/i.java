package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static final ud.a f33034a = new ud.a();

    private static c a(g gVar) {
        int[] j11;
        if (gVar == null || (j11 = gVar.j()) == null) {
            return null;
        }
        int p11 = p(j11);
        int i11 = 0;
        int i12 = 0;
        for (int i13 : j11) {
            i12 += p11 - i13;
            if (i13 > 0) {
                break;
            }
        }
        d[] d11 = gVar.d();
        for (int i14 = 0; i12 > 0 && d11[i14] == null; i14++) {
            i12--;
        }
        for (int length = j11.length - 1; length >= 0; length--) {
            int i15 = j11[length];
            i11 += p11 - i15;
            if (i15 > 0) {
                break;
            }
        }
        for (int length2 = d11.length - 1; i11 > 0 && d11[length2] == null; length2--) {
            i11--;
        }
        return gVar.a().a(i12, i11, gVar.k());
    }

    private static void b(e eVar, b[][] bVarArr) {
        b bVar = bVarArr[0][1];
        int[] a11 = bVar.a();
        int j11 = (eVar.j() * eVar.l()) - r(eVar.k());
        if (a11.length == 0) {
            if (j11 < 1 || j11 > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            bVar.b(j11);
            return;
        }
        if (a11[0] == j11 || j11 < 1 || j11 > 928) {
            return;
        }
        bVar.b(j11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int c(id.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.g(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.i.c(id.b, int, int, boolean, int, int):int");
    }

    private static boolean d(int i11, int i12, int i13) {
        return i12 + (-2) <= i11 && i11 <= i13 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i11) {
        if ((iArr2 == null || iArr2.length <= (i11 / 2) + 3) && i11 >= 0 && i11 <= 512) {
            return f33034a.a(iArr, i11, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static b[][] f(e eVar) {
        int c11;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, eVar.l(), eVar.j() + 2);
        for (b[] bVarArr2 : bVarArr) {
            int i11 = 0;
            while (true) {
                if (i11 < bVarArr2.length) {
                    bVarArr2[i11] = new b();
                    i11++;
                }
            }
        }
        int i12 = 0;
        for (f fVar : eVar.o()) {
            if (fVar != null) {
                for (d dVar : fVar.d()) {
                    if (dVar != null && (c11 = dVar.c()) >= 0 && c11 < bVarArr.length) {
                        bVarArr[c11][i12].b(dVar.e());
                    }
                }
            }
            i12++;
        }
        return bVarArr;
    }

    private static id.d g(e eVar) {
        b[][] f11 = f(eVar);
        b(eVar, f11);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[eVar.l() * eVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i11 = 0; i11 < eVar.l(); i11++) {
            int i12 = 0;
            while (i12 < eVar.j()) {
                int i13 = i12 + 1;
                int[] a11 = f11[i11][i13].a();
                int j11 = (eVar.j() * i11) + i12;
                if (a11.length == 0) {
                    arrayList.add(Integer.valueOf(j11));
                } else if (a11.length == 1) {
                    iArr[j11] = a11[0];
                } else {
                    arrayList3.add(Integer.valueOf(j11));
                    arrayList2.add(a11);
                }
                i12 = i13;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i14 = 0; i14 < size; i14++) {
            iArr2[i14] = (int[]) arrayList2.get(i14);
        }
        return h(eVar.k(), iArr, td.a.b(arrayList), td.a.b(arrayList3), iArr2);
    }

    private static id.d h(int i11, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i12 = 100;
        while (true) {
            int i13 = i12 - 1;
            if (i12 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i14 = 0; i14 < length; i14++) {
                iArr[iArr3[i14]] = iArr4[i14][iArr5[i14]];
            }
            try {
                return j(iArr, i11, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int i15 = 0;
                while (true) {
                    if (i15 >= length) {
                        break;
                    }
                    int i16 = iArr5[i15];
                    if (i16 < iArr4[i15].length - 1) {
                        iArr5[i15] = i16 + 1;
                        break;
                    }
                    iArr5[i15] = 0;
                    if (i15 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    i15++;
                }
                i12 = i13;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        r2 = r26;
        r6 = r27;
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        if (r7 > r5) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        if (r3.n(r8) == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
    
        if (r8 == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
    
        if (r8 != r5) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0087, code lost:
    
        r10 = new com.google.zxing.pdf417.decoder.f(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008c, code lost:
    
        r15 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
    
        r3.q(r8, r15);
        r14 = -1;
        r13 = r9.g();
        r12 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a7, code lost:
    
        if (r13 > r9.e()) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
    
        r10 = t(r3, r8, r13, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ad, code lost:
    
        if (r10 < 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b3, code lost:
    
        if (r10 <= r9.d()) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b6, code lost:
    
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c4, code lost:
    
        r19 = r12;
        r22 = r13;
        r20 = r14;
        r1 = r15;
        r10 = k(r21, r9.f(), r9.d(), r0, r18, r22, r2, r6);
        r11 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e6, code lost:
    
        if (r10 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
    
        r1.f(r11, r10);
        r2 = java.lang.Math.min(r2, r10.f());
        r6 = java.lang.Math.max(r6, r10.f());
        r12 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0100, code lost:
    
        r13 = r11 + 1;
        r15 = r1;
        r14 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fe, code lost:
    
        r12 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b9, code lost:
    
        if (r12 != r14) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
    
        r19 = r12;
        r11 = r13;
        r20 = r14;
        r1 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
    
        r18 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0107, code lost:
    
        r7 = r7 + 1;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0090, code lost:
    
        if (r8 != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0092, code lost:
    
        r11 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
    
        r10 = new com.google.zxing.pdf417.decoder.g(r9, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0094, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0078, code lost:
    
        r8 = r5 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0110, code lost:
    
        return g(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x006c, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static id.d i(id.b r21, com.google.zxing.k r22, com.google.zxing.k r23, com.google.zxing.k r24, com.google.zxing.k r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.i.i(id.b, com.google.zxing.k, com.google.zxing.k, com.google.zxing.k, com.google.zxing.k, int, int):id.d");
    }

    private static id.d j(int[] iArr, int i11, int[] iArr2) {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i12 = 1 << (i11 + 1);
        int e11 = e(iArr, iArr2, i12);
        w(iArr, i12);
        id.d b11 = DecodedBitStreamParser.b(iArr, String.valueOf(i11));
        b11.n(Integer.valueOf(e11));
        b11.m(Integer.valueOf(iArr2.length));
        return b11;
    }

    private static d k(id.b bVar, int i11, int i12, boolean z10, int i13, int i14, int i15, int i16) {
        int i17;
        int d11;
        int a11;
        int c11 = c(bVar, i11, i12, z10, i13, i14);
        int[] q11 = q(bVar, i11, i12, z10, c11, i14);
        if (q11 == null) {
            return null;
        }
        int d12 = jd.a.d(q11);
        if (z10) {
            i17 = c11 + d12;
        } else {
            for (int i18 = 0; i18 < q11.length / 2; i18++) {
                int i19 = q11[i18];
                q11[i18] = q11[(q11.length - 1) - i18];
                q11[(q11.length - 1) - i18] = i19;
            }
            c11 -= d12;
            i17 = c11;
        }
        if (d(d12, i15, i16) && (a11 = td.a.a((d11 = h.d(q11)))) != -1) {
            return new d(c11, i17, n(d11), a11);
        }
        return null;
    }

    private static a l(g gVar, g gVar2) {
        a i11;
        a i12;
        if (gVar == null || (i11 = gVar.i()) == null) {
            if (gVar2 == null) {
                return null;
            }
            return gVar2.i();
        }
        if (gVar2 == null || (i12 = gVar2.i()) == null || i11.a() == i12.a() || i11.b() == i12.b() || i11.c() == i12.c()) {
            return i11;
        }
        return null;
    }

    private static int[] m(int i11) {
        int[] iArr = new int[8];
        int i12 = 0;
        int i13 = 7;
        while (true) {
            int i14 = i11 & 1;
            if (i14 != i12) {
                i13--;
                if (i13 < 0) {
                    return iArr;
                }
                i12 = i14;
            }
            iArr[i13] = iArr[i13] + 1;
            i11 >>= 1;
        }
    }

    private static int n(int i11) {
        return o(m(i11));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int i11 = -1;
        for (int i12 : iArr) {
            i11 = Math.max(i11, i12);
        }
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[EDGE_INSN: B:17:0x0027->B:18:0x0027 BREAK  A[LOOP:0: B:5:0x000c->B:13:0x000c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[] q(id.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = r2
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.g(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.i.q(id.b, int, int, boolean, int, int):int[]");
    }

    private static int r(int i11) {
        return 2 << i11;
    }

    private static g s(id.b bVar, c cVar, k kVar, boolean z10, int i11, int i12) {
        g gVar = new g(cVar, z10);
        int i13 = 0;
        while (i13 < 2) {
            int i14 = i13 == 0 ? 1 : -1;
            int c11 = (int) kVar.c();
            for (int d11 = (int) kVar.d(); d11 <= cVar.e() && d11 >= cVar.g(); d11 += i14) {
                d k11 = k(bVar, 0, bVar.n(), z10, c11, d11, i11, i12);
                if (k11 != null) {
                    gVar.f(d11, k11);
                    c11 = z10 ? k11.d() : k11.b();
                }
            }
            i13++;
        }
        return gVar;
    }

    private static int t(e eVar, int i11, int i12, boolean z10) {
        int i13 = z10 ? 1 : -1;
        int i14 = i11 - i13;
        d b11 = u(eVar, i14) ? eVar.n(i14).b(i12) : null;
        if (b11 != null) {
            return z10 ? b11.b() : b11.d();
        }
        d c11 = eVar.n(i11).c(i12);
        if (c11 != null) {
            return z10 ? c11.d() : c11.b();
        }
        if (u(eVar, i14)) {
            c11 = eVar.n(i14).c(i12);
        }
        if (c11 != null) {
            return z10 ? c11.b() : c11.d();
        }
        int i15 = 0;
        while (true) {
            i11 -= i13;
            if (!u(eVar, i11)) {
                c m11 = eVar.m();
                return z10 ? m11.f() : m11.d();
            }
            for (d dVar : eVar.n(i11).d()) {
                if (dVar != null) {
                    return (z10 ? dVar.b() : dVar.d()) + (i13 * i15 * (dVar.b() - dVar.d()));
                }
            }
            i15++;
        }
    }

    private static boolean u(e eVar, int i11) {
        return i11 >= 0 && i11 <= eVar.j() + 1;
    }

    private static e v(g gVar, g gVar2) {
        a l11;
        if ((gVar == null && gVar2 == null) || (l11 = l(gVar, gVar2)) == null) {
            return null;
        }
        return new e(l11, c.j(a(gVar), a(gVar2)));
    }

    private static void w(int[] iArr, int i11) {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i12 = iArr[0];
        if (i12 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i12 == 0) {
            if (i11 >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i11;
        }
    }
}
