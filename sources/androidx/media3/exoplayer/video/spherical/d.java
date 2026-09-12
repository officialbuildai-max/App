package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.i0;
import androidx.media3.common.util.j0;
import androidx.media3.exoplayer.video.spherical.c;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
abstract class d {
    public static c a(byte[] bArr, int i11) {
        ArrayList arrayList;
        j0 j0Var = new j0(bArr);
        try {
            arrayList = c(j0Var) ? f(j0Var) : e(j0Var);
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

    private static boolean c(j0 j0Var) {
        j0Var.X(4);
        int q11 = j0Var.q();
        j0Var.W(0);
        return q11 == 1886547818;
    }

    private static c.a d(j0 j0Var) {
        int q11 = j0Var.q();
        if (q11 > 10000) {
            return null;
        }
        float[] fArr = new float[q11];
        for (int i11 = 0; i11 < q11; i11++) {
            fArr[i11] = j0Var.p();
        }
        int q12 = j0Var.q();
        if (q12 > 32000) {
            return null;
        }
        double d11 = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(q11 * 2.0d) / log);
        i0 i0Var = new i0(j0Var.e());
        int i12 = 8;
        i0Var.p(j0Var.f() * 8);
        float[] fArr2 = new float[q12 * 5];
        int i13 = 5;
        int[] iArr = new int[5];
        int i14 = 0;
        int i15 = 0;
        while (i14 < q12) {
            int i16 = 0;
            while (i16 < i13) {
                int b11 = iArr[i16] + b(i0Var.h(ceil));
                if (b11 >= q11 || b11 < 0) {
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
        i0Var.p((i0Var.e() + 7) & (-8));
        int i17 = 32;
        int h11 = i0Var.h(32);
        c.b[] bVarArr = new c.b[h11];
        int i18 = 0;
        while (i18 < h11) {
            int h12 = i0Var.h(i12);
            int h13 = i0Var.h(i12);
            int h14 = i0Var.h(i17);
            if (h14 > 128000) {
                return null;
            }
            int ceil2 = (int) Math.ceil(Math.log(q12 * d11) / log);
            float[] fArr3 = new float[h14 * 3];
            float[] fArr4 = new float[h14 * 2];
            int i19 = 0;
            for (int i20 = 0; i20 < h14; i20++) {
                i19 += b(i0Var.h(ceil2));
                if (i19 < 0 || i19 >= q12) {
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

    private static ArrayList e(j0 j0Var) {
        if (j0Var.H() != 0) {
            return null;
        }
        j0Var.X(7);
        int q11 = j0Var.q();
        if (q11 == 1684433976) {
            j0 j0Var2 = new j0();
            Inflater inflater = new Inflater(true);
            try {
                if (!a1.B0(j0Var, j0Var2, inflater)) {
                    return null;
                }
                inflater.end();
                j0Var = j0Var2;
            } finally {
                inflater.end();
            }
        } else if (q11 != 1918990112) {
            return null;
        }
        return g(j0Var);
    }

    private static ArrayList f(j0 j0Var) {
        int q11;
        j0Var.X(8);
        int f11 = j0Var.f();
        int g11 = j0Var.g();
        while (f11 < g11 && (q11 = j0Var.q() + f11) > f11 && q11 <= g11) {
            int q12 = j0Var.q();
            if (q12 == 2037673328 || q12 == 1836279920) {
                j0Var.V(q11);
                return e(j0Var);
            }
            j0Var.W(q11);
            f11 = q11;
        }
        return null;
    }

    private static ArrayList g(j0 j0Var) {
        ArrayList arrayList = new ArrayList();
        int f11 = j0Var.f();
        int g11 = j0Var.g();
        while (f11 < g11) {
            int q11 = j0Var.q() + f11;
            if (q11 <= f11 || q11 > g11) {
                return null;
            }
            if (j0Var.q() == 1835365224) {
                c.a d11 = d(j0Var);
                if (d11 == null) {
                    return null;
                }
                arrayList.add(d11);
            }
            j0Var.W(q11);
            f11 = q11;
        }
        return arrayList;
    }
}
