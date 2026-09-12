package g9;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes4.dex */
public abstract class c {
    public static void a(long j11, com.google.android.exoplayer2.util.d0 d0Var, e0[] e0VarArr) {
        while (true) {
            if (d0Var.a() <= 1) {
                return;
            }
            int c11 = c(d0Var);
            int c12 = c(d0Var);
            int e11 = d0Var.e() + c12;
            if (c12 == -1 || c12 > d0Var.a()) {
                com.google.android.exoplayer2.util.s.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                e11 = d0Var.f();
            } else if (c11 == 4 && c12 >= 8) {
                int D = d0Var.D();
                int J = d0Var.J();
                int n11 = J == 49 ? d0Var.n() : 0;
                int D2 = d0Var.D();
                if (J == 47) {
                    d0Var.Q(1);
                }
                boolean z10 = D == 181 && (J == 49 || J == 47) && D2 == 3;
                if (J == 49) {
                    z10 &= n11 == 1195456820;
                }
                if (z10) {
                    b(j11, d0Var, e0VarArr);
                }
            }
            d0Var.P(e11);
        }
    }

    public static void b(long j11, com.google.android.exoplayer2.util.d0 d0Var, e0[] e0VarArr) {
        int D = d0Var.D();
        if ((D & 64) != 0) {
            d0Var.Q(1);
            int i11 = (D & 31) * 3;
            int e11 = d0Var.e();
            for (e0 e0Var : e0VarArr) {
                d0Var.P(e11);
                e0Var.c(d0Var, i11);
                if (j11 != C.TIME_UNSET) {
                    e0Var.d(j11, 1, i11, 0, null);
                }
            }
        }
    }

    private static int c(com.google.android.exoplayer2.util.d0 d0Var) {
        int i11 = 0;
        while (d0Var.a() != 0) {
            int D = d0Var.D();
            i11 += D;
            if (D != 255) {
                return i11;
            }
        }
        return -1;
    }
}
