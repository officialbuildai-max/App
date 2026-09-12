package com.google.zxing.aztec.encoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f32893a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] a(id.a aVar, int i11, int i12) {
        int[] iArr = new int[i12];
        int m11 = aVar.m() / i11;
        for (int i13 = 0; i13 < m11; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 |= aVar.i((i13 * i11) + i15) ? 1 << ((i11 - i15) - 1) : 0;
            }
            iArr[i13] = i14;
        }
        return iArr;
    }

    private static void b(id.b bVar, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13 += 2) {
            int i14 = i11 - i13;
            int i15 = i14;
            while (true) {
                int i16 = i11 + i13;
                if (i15 <= i16) {
                    bVar.r(i15, i14);
                    bVar.r(i15, i16);
                    bVar.r(i14, i15);
                    bVar.r(i16, i15);
                    i15++;
                }
            }
        }
        int i17 = i11 - i12;
        bVar.r(i17, i17);
        int i18 = i17 + 1;
        bVar.r(i18, i17);
        bVar.r(i17, i18);
        int i19 = i11 + i12;
        bVar.r(i19, i17);
        bVar.r(i19, i18);
        bVar.r(i19, i19 - 1);
    }

    private static void c(id.b bVar, boolean z10, int i11, id.a aVar) {
        int i12 = i11 / 2;
        int i13 = 0;
        if (z10) {
            while (i13 < 7) {
                int i14 = (i12 - 3) + i13;
                if (aVar.i(i13)) {
                    bVar.r(i14, i12 - 5);
                }
                if (aVar.i(i13 + 7)) {
                    bVar.r(i12 + 5, i14);
                }
                if (aVar.i(20 - i13)) {
                    bVar.r(i14, i12 + 5);
                }
                if (aVar.i(27 - i13)) {
                    bVar.r(i12 - 5, i14);
                }
                i13++;
            }
            return;
        }
        while (i13 < 10) {
            int i15 = (i12 - 5) + i13 + (i13 / 5);
            if (aVar.i(i13)) {
                bVar.r(i15, i12 - 7);
            }
            if (aVar.i(i13 + 10)) {
                bVar.r(i12 + 7, i15);
            }
            if (aVar.i(29 - i13)) {
                bVar.r(i15, i12 + 7);
            }
            if (aVar.i(39 - i13)) {
                bVar.r(i12 - 7, i15);
            }
            i13++;
        }
    }

    public static a d(String str, int i11, int i12, Charset charset) {
        return e(str.getBytes(charset != null ? charset : StandardCharsets.ISO_8859_1), i11, i12, charset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a e(byte[] bArr, int i11, int i12, Charset charset) {
        id.a aVar;
        int i13;
        boolean z10;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = 2;
        id.a a11 = new HighLevelEncoder(bArr, charset).a();
        int m11 = ((a11.m() * i11) / 100) + 11;
        int m12 = a11.m() + m11;
        int i19 = 4;
        int i20 = 0;
        int i21 = 1;
        if (i12 == 0) {
            id.a aVar2 = null;
            int i22 = 0;
            int i23 = 0;
            while (i22 <= r5) {
                boolean z11 = i22 <= 3 ? i21 : i20;
                int i24 = z11 != 0 ? i22 + 1 : i22;
                int j11 = j(i24, z11);
                if (m12 > j11) {
                    i16 = i21;
                } else {
                    if (aVar2 == null || i23 != f32893a[i24]) {
                        int i25 = f32893a[i24];
                        i23 = i25;
                        aVar2 = i(a11, i25);
                    }
                    int i26 = j11 - (j11 % i23);
                    if ((z11 == 0 || aVar2.m() <= i23 * 64) && aVar2.m() + m11 <= i26) {
                        aVar = aVar2;
                        i13 = i23;
                        z10 = z11;
                        i14 = i24;
                        i15 = j11;
                    } else {
                        i16 = 1;
                    }
                }
                i22 += i16;
                i21 = i16;
                r5 = 32;
                i19 = 4;
                i20 = 0;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z10 = i12 < 0;
        i14 = Math.abs(i12);
        if (i14 > (z10 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i12)));
        }
        i15 = j(i14, z10);
        i13 = f32893a[i14];
        int i27 = i15 - (i15 % i13);
        aVar = i(a11, i13);
        if (aVar.m() + m11 > i27) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z10 && aVar.m() > i13 * 64) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        id.a f11 = f(aVar, i15, i13);
        int m13 = aVar.m() / i13;
        id.a g11 = g(z10, i14, m13);
        int i28 = (z10 ? 11 : 14) + (i14 * 4);
        int[] iArr = new int[i28];
        if (z10) {
            for (int i29 = i20; i29 < i28; i29 += i21) {
                iArr[i29] = i29;
            }
            i17 = i28;
        } else {
            int i30 = i28 / 2;
            i17 = i28 + 1 + (((i30 - 1) / 15) * 2);
            int i31 = i17 / 2;
            for (int i32 = i20; i32 < i30; i32 += i21) {
                iArr[(i30 - i32) - 1] = (i31 - r15) - 1;
                iArr[i30 + i32] = (i32 / 15) + i32 + i31 + i21;
            }
        }
        id.b bVar = new id.b(i17);
        int i33 = i20;
        int i34 = i33;
        while (i33 < i14) {
            int i35 = ((i14 - i33) * i19) + (z10 ? 9 : 12);
            while (i20 < i35) {
                int i36 = i20 * 2;
                int i37 = 0;
                while (i37 < i18) {
                    if (f11.i(i34 + i36 + i37)) {
                        int i38 = i33 * 2;
                        bVar.r(iArr[i38 + i37], iArr[i38 + i20]);
                    }
                    if (f11.i((i35 * 2) + i34 + i36 + i37)) {
                        int i39 = i33 * 2;
                        bVar.r(iArr[i39 + i20], iArr[((i28 - 1) - i39) - i37]);
                    }
                    if (f11.i((i35 * 4) + i34 + i36 + i37)) {
                        int i40 = (i28 - 1) - (i33 * 2);
                        bVar.r(iArr[i40 - i37], iArr[i40 - i20]);
                    }
                    if (f11.i((i35 * 6) + i34 + i36 + i37)) {
                        int i41 = i33 * 2;
                        bVar.r(iArr[((i28 - 1) - i41) - i20], iArr[i41 + i37]);
                    }
                    i37++;
                    i21 = 1;
                    i18 = 2;
                }
                i20 += i21;
                i18 = 2;
            }
            i34 += i35 * 8;
            i33 += i21;
            i18 = 2;
            i19 = 4;
            i20 = 0;
        }
        c(bVar, z10, i17, g11);
        if (z10) {
            b(bVar, i17 / 2, 5);
        } else {
            int i42 = i17 / 2;
            b(bVar, i42, 7);
            int i43 = 0;
            int i44 = 0;
            while (i44 < (i28 / 2) - 1) {
                for (int i45 = i42 & 1; i45 < i17; i45 += 2) {
                    int i46 = i42 - i43;
                    bVar.r(i46, i45);
                    int i47 = i42 + i43;
                    bVar.r(i47, i45);
                    bVar.r(i45, i46);
                    bVar.r(i45, i47);
                }
                i44 += 15;
                i43 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.c(z10);
        aVar3.f(i17);
        aVar3.d(i14);
        aVar3.b(m13);
        aVar3.e(bVar);
        return aVar3;
    }

    private static id.a f(id.a aVar, int i11, int i12) {
        int m11 = aVar.m() / i12;
        kd.d dVar = new kd.d(h(i12));
        int i13 = i11 / i12;
        int[] a11 = a(aVar, i12, i13);
        dVar.b(a11, i13 - m11);
        id.a aVar2 = new id.a();
        aVar2.c(0, i11 % i12);
        for (int i14 : a11) {
            aVar2.c(i14, i12);
        }
        return aVar2;
    }

    static id.a g(boolean z10, int i11, int i12) {
        id.a aVar = new id.a();
        if (z10) {
            aVar.c(i11 - 1, 2);
            aVar.c(i12 - 1, 6);
            return f(aVar, 28, 4);
        }
        aVar.c(i11 - 1, 5);
        aVar.c(i12 - 1, 11);
        return f(aVar, 40, 4);
    }

    private static kd.a h(int i11) {
        if (i11 == 4) {
            return kd.a.f66887k;
        }
        if (i11 == 6) {
            return kd.a.f66886j;
        }
        if (i11 == 8) {
            return kd.a.f66890n;
        }
        if (i11 == 10) {
            return kd.a.f66885i;
        }
        if (i11 == 12) {
            return kd.a.f66884h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i11);
    }

    static id.a i(id.a aVar, int i11) {
        id.a aVar2 = new id.a();
        int m11 = aVar.m();
        int i12 = (1 << i11) - 2;
        int i13 = 0;
        while (i13 < m11) {
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                int i16 = i13 + i15;
                if (i16 >= m11 || aVar.i(i16)) {
                    i14 |= 1 << ((i11 - 1) - i15);
                }
            }
            int i17 = i14 & i12;
            if (i17 == i12) {
                aVar2.c(i17, i11);
            } else if (i17 == 0) {
                aVar2.c(i14 | 1, i11);
            } else {
                aVar2.c(i14, i11);
                i13 += i11;
            }
            i13--;
            i13 += i11;
        }
        return aVar2;
    }

    private static int j(int i11, boolean z10) {
        return ((z10 ? 88 : 112) + (i11 * 16)) * i11;
    }
}
