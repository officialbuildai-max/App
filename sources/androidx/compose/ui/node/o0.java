package androidx.compose.ui.node;

/* loaded from: classes.dex */
public abstract class o0 {
    public static final /* synthetic */ void a(int[] iArr, int i11, int i12) {
        i(iArr, i11, i12);
    }

    private static final void b(t tVar, k kVar) {
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < tVar.c()) {
            int i14 = i11 + 2;
            int b11 = tVar.b(i11) - tVar.b(i14);
            int b12 = tVar.b(i11 + 1) - tVar.b(i14);
            int b13 = tVar.b(i14);
            i11 += 3;
            while (i12 < b11) {
                kVar.e(i13, i12);
                i12++;
            }
            while (i13 < b12) {
                kVar.b(i13);
                i13++;
            }
            while (true) {
                int i15 = b13 - 1;
                if (b13 > 0) {
                    kVar.c(i12, i13);
                    i12++;
                    i13++;
                    b13 = i15;
                }
            }
        }
    }

    private static final boolean c(int i11, int i12, int i13, int i14, k kVar, int[] iArr, int[] iArr2, int i15, int[] iArr3) {
        int b11;
        int i16;
        int i17;
        int i18 = (i12 - i11) - (i14 - i13);
        boolean z10 = i18 % 2 == 0;
        int i19 = -i15;
        for (int i20 = i19; i20 <= i15; i20 += 2) {
            if (i20 == i19 || (i20 != i15 && c.b(iArr2, i20 + 1) < c.b(iArr2, i20 - 1))) {
                b11 = c.b(iArr2, i20 + 1);
                i16 = b11;
            } else {
                b11 = c.b(iArr2, i20 - 1);
                i16 = b11 - 1;
            }
            int i21 = i14 - ((i12 - i16) - i20);
            int i22 = (i15 == 0 || i16 != b11) ? i21 : i21 + 1;
            while (i16 > i11 && i21 > i13) {
                if (!kVar.a(i16 - 1, i21 - 1)) {
                    break;
                }
                i16--;
                i21--;
            }
            c.d(iArr2, i20, i16);
            if (z10 && (i17 = i18 - i20) >= i19 && i17 <= i15) {
                if (c.b(iArr, i17) >= i16) {
                    f(i16, i21, b11, i22, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final t d(int i11, int i12, k kVar) {
        int i13 = ((i11 + i12) + 1) / 2;
        t tVar = new t(i13 * 3);
        t tVar2 = new t(i13 * 4);
        tVar2.h(0, i11, 0, i12);
        int i14 = (i13 * 2) + 1;
        int[] a11 = c.a(new int[i14]);
        int[] a12 = c.a(new int[i14]);
        int[] b11 = k1.b(new int[5]);
        while (tVar2.d()) {
            int f11 = tVar2.f();
            int f12 = tVar2.f();
            int f13 = tVar2.f();
            int f14 = tVar2.f();
            int[] iArr = a11;
            int[] iArr2 = a12;
            if (h(f14, f13, f12, f11, kVar, a11, a12, b11)) {
                if (k1.c(b11) > 0) {
                    k1.a(b11, tVar);
                }
                tVar2.h(f14, k1.h(b11), f12, k1.i(b11));
                tVar2.h(k1.d(b11), f13, k1.e(b11), f11);
            }
            a11 = iArr;
            a12 = iArr2;
        }
        tVar.j();
        tVar.g(i11, i12, 0);
        return tVar;
    }

    public static final void e(int i11, int i12, k kVar) {
        b(d(i11, i12, kVar), kVar);
    }

    public static final void f(int i11, int i12, int i13, int i14, boolean z10, int[] iArr) {
        iArr[0] = i11;
        iArr[1] = i12;
        iArr[2] = i13;
        iArr[3] = i14;
        iArr[4] = z10 ? 1 : 0;
    }

    private static final boolean g(int i11, int i12, int i13, int i14, k kVar, int[] iArr, int[] iArr2, int i15, int[] iArr3) {
        int b11;
        int i16;
        int i17;
        int i18 = (i12 - i11) - (i14 - i13);
        boolean z10 = Math.abs(i18) % 2 == 1;
        int i19 = -i15;
        for (int i20 = i19; i20 <= i15; i20 += 2) {
            if (i20 == i19 || (i20 != i15 && c.b(iArr, i20 + 1) > c.b(iArr, i20 - 1))) {
                b11 = c.b(iArr, i20 + 1);
                i16 = b11;
            } else {
                b11 = c.b(iArr, i20 - 1);
                i16 = b11 + 1;
            }
            int i21 = (i13 + (i16 - i11)) - i20;
            int i22 = (i15 == 0 || i16 != b11) ? i21 : i21 - 1;
            while (i16 < i12 && i21 < i14) {
                if (!kVar.a(i16, i21)) {
                    break;
                }
                i16++;
                i21++;
            }
            c.d(iArr, i20, i16);
            if (z10 && (i17 = i18 - i20) >= i19 + 1 && i17 <= i15 - 1) {
                if (c.b(iArr2, i17) <= i16) {
                    f(b11, i22, i16, i21, false, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final boolean h(int i11, int i12, int i13, int i14, k kVar, int[] iArr, int[] iArr2, int[] iArr3) {
        int i15 = i12 - i11;
        int i16 = i14 - i13;
        if (i15 >= 1 && i16 >= 1) {
            int i17 = ((i15 + i16) + 1) / 2;
            c.d(iArr, 1, i11);
            c.d(iArr2, 1, i12);
            int i18 = 0;
            while (i18 < i17) {
                int i19 = i18;
                if (g(i11, i12, i13, i14, kVar, iArr, iArr2, i18, iArr3) || c(i11, i12, i13, i14, kVar, iArr, iArr2, i19, iArr3)) {
                    return true;
                }
                i18 = i19 + 1;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int[] iArr, int i11, int i12) {
        int i13 = iArr[i11];
        iArr[i11] = iArr[i12];
        iArr[i12] = i13;
    }
}
