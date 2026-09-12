package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.video.spherical.c;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* loaded from: classes3.dex */
abstract class d {
    public static c a(byte[] bArr, int i11) {
        ArrayList arrayList;
        d0 d0Var = new d0(bArr);
        try {
            arrayList = c(d0Var) ? f(d0Var) : e(d0Var);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 1) {
            return new c((c.a) arrayList.get(0), i11);
        }
        if (size != 2) {
            return null;
        }
        return new c((c.a) arrayList.get(0), (c.a) arrayList.get(1), i11);
    }

    private static int b(int i11) {
        return (-(i11 & 1)) ^ (i11 >> 1);
    }

    private static boolean c(d0 d0Var) {
        d0Var.Q(4);
        int n11 = d0Var.n();
        d0Var.P(0);
        return n11 == 1886547818;
    }

    private static c.a d(d0 d0Var) {
        int n11 = d0Var.n();
        if (n11 > 10000) {
            return null;
        }
        float[] fArr = new float[n11];
        for (int i11 = 0; i11 < n11; i11++) {
            fArr[i11] = d0Var.m();
        }
        int n12 = d0Var.n();
        if (n12 > 32000) {
            return null;
        }
        double d11 = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(n11 * 2.0d) / log);
        c0 c0Var = new c0(d0Var.d());
        int i12 = 8;
        c0Var.p(d0Var.e() * 8);
        float[] fArr2 = new float[n12 * 5];
        int i13 = 5;
        int[] iArr = new int[5];
        int i14 = 0;
        int i15 = 0;
        while (i14 < n12) {
            int i16 = 0;
            while (i16 < i13) {
                int b11 = iArr[i16] + b(c0Var.h(ceil));
                if (b11 >= n11 || b11 < 0) {
                    return null;
                }
                fArr2[i15] = fArr[b11];
                iArr[i16] = b11;
                i16++;
                i15++;
                i13 = 5;
            }
            i14++;
            i13 = 5;
        }
        c0Var.p((c0Var.e() + 7) & (-8));
        int i17 = 32;
        int h11 = c0Var.h(32);
        c.b[] bVarArr = new c.b[h11];
        int i18 = 0;
        while (i18 < h11) {
            int h12 = c0Var.h(i12);
            int h13 = c0Var.h(i12);
            int h14 = c0Var.h(i17);
            if (h14 > 128000) {
                return null;
            }
            int ceil2 = (int) Math.ceil(Math.log(n12 * d11) / log);
            float[] fArr3 = new float[h14 * 3];
            float[] fArr4 = new float[h14 * 2];
            int i19 = 0;
            for (int i20 = 0; i20 < h14; i20++) {
                i19 += b(c0Var.h(ceil2));
                if (i19 < 0 || i19 >= n12) {
                    return null;
                }
                int i21 = i20 * 3;
                int i22 = i19 * 5;
                fArr3[i21] = fArr2[i22];
                fArr3[i21 + 1] = fArr2[i22 + 1];
                fArr3[i21 + 2] = fArr2[i22 + 2];
                int i23 = i20 * 2;
                fArr4[i23] = fArr2[i22 + 3];
                fArr4[i23 + 1] = fArr2[i22 + 4];
            }
            bVarArr[i18] = new c.b(h12, fArr3, fArr4, h13);
            i18++;
            i17 = 32;
            d11 = 2.0d;
            i12 = 8;
        }
        return new c.a(bVarArr);
    }

    private static ArrayList e(d0 d0Var) {
        if (d0Var.D() != 0) {
            return null;
        }
        d0Var.Q(7);
        int n11 = d0Var.n();
        if (n11 == 1684433976) {
            d0 d0Var2 = new d0();
            Inflater inflater = new Inflater(true);
            try {
                if (!p0.r0(d0Var, d0Var2, inflater)) {
                    return null;
                }
                inflater.end();
                d0Var = d0Var2;
            } finally {
                inflater.end();
            }
        } else if (n11 != 1918990112) {
            return null;
        }
        return g(d0Var);
    }

    private static ArrayList f(d0 d0Var) {
        int n11;
        d0Var.Q(8);
        int e11 = d0Var.e();
        int f11 = d0Var.f();
        while (e11 < f11 && (n11 = d0Var.n() + e11) > e11 && n11 <= f11) {
            int n12 = d0Var.n();
            if (n12 == 2037673328 || n12 == 1836279920) {
                d0Var.O(n11);
                return e(d0Var);
            }
            d0Var.P(n11);
            e11 = n11;
        }
        return null;
    }

    private static ArrayList g(d0 d0Var) {
        ArrayList arrayList = new ArrayList();
        int e11 = d0Var.e();
        int f11 = d0Var.f();
        while (e11 < f11) {
            int n11 = d0Var.n() + e11;
            if (n11 <= e11 || n11 > f11) {
                return null;
            }
            if (d0Var.n() == 1835365224) {
                c.a d11 = d(d0Var);
                if (d11 == null) {
                    return null;
                }
                arrayList.add(d11);
            }
            d0Var.P(n11);
            e11 = n11;
        }
        return arrayList;
    }
}
