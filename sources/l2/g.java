package l2;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public abstract class g {
    public static void a(long j11, androidx.media3.common.util.j0 j0Var, s0[] s0VarArr) {
        while (true) {
            if (j0Var.a() <= 1) {
                return;
            }
            int c11 = c(j0Var);
            int c12 = c(j0Var);
            int f11 = j0Var.f() + c12;
            if (c12 == -1 || c12 > j0Var.a()) {
                androidx.media3.common.util.u.h("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                f11 = j0Var.g();
            } else if (c11 == 4 && c12 >= 8) {
                int H = j0Var.H();
                int P = j0Var.P();
                int q11 = P == 49 ? j0Var.q() : 0;
                int H2 = j0Var.H();
                if (P == 47) {
                    j0Var.X(1);
                }
                boolean z10 = H == 181 && (P == 49 || P == 47) && H2 == 3;
                if (P == 49) {
                    z10 &= q11 == 1195456820;
                }
                if (z10) {
                    b(j11, j0Var, s0VarArr);
                }
            }
            j0Var.W(f11);
        }
    }

    public static void b(long j11, androidx.media3.common.util.j0 j0Var, s0[] s0VarArr) {
        int H = j0Var.H();
        if ((H & 64) != 0) {
            j0Var.X(1);
            int i11 = (H & 31) * 3;
            int f11 = j0Var.f();
            for (s0 s0Var : s0VarArr) {
                j0Var.W(f11);
                s0Var.b(j0Var, i11);
                androidx.media3.common.util.a.g(j11 != C.TIME_UNSET);
                s0Var.d(j11, 1, i11, 0, null);
            }
        }
    }

    private static int c(androidx.media3.common.util.j0 j0Var) {
        int i11 = 0;
        while (j0Var.a() != 0) {
            int H = j0Var.H();
            i11 += H;
            if (H != 255) {
                return i11;
            }
        }
        return -1;
    }
}
