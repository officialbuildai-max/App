package f3;

import androidx.media3.common.util.j0;

/* loaded from: classes2.dex */
public abstract class r {
    private static int a(int i11, j0 j0Var, int i12) {
        if (i11 == 12) {
            return 240;
        }
        if (i11 == 13) {
            return 120;
        }
        if (i11 == 21 && j0Var.a() >= 8 && j0Var.f() + 8 <= i12) {
            int q11 = j0Var.q();
            int q12 = j0Var.q();
            if (q11 >= 12 && q12 == 1936877170) {
                return j0Var.I();
            }
        }
        return -2147483647;
    }

    public static androidx.media3.common.x b(j0 j0Var, int i11) {
        j0Var.X(12);
        while (j0Var.f() < i11) {
            int f11 = j0Var.f();
            int q11 = j0Var.q();
            if (j0Var.q() == 1935766900) {
                if (q11 < 16) {
                    return null;
                }
                j0Var.X(4);
                int i12 = -1;
                int i13 = 0;
                for (int i14 = 0; i14 < 2; i14++) {
                    int H = j0Var.H();
                    int H2 = j0Var.H();
                    if (H == 0) {
                        i12 = H2;
                    } else if (H == 1) {
                        i13 = H2;
                    }
                }
                int a11 = a(i12, j0Var, i11);
                if (a11 == -2147483647) {
                    return null;
                }
                return new androidx.media3.common.x(new a3.d(a11, i13));
            }
            j0Var.W(f11 + q11);
        }
        return null;
    }
}
