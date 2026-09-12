package s;

import androidx.compose.runtime.k;
import androidx.compose.runtime.m2;

/* loaded from: classes2.dex */
public abstract class f {
    private static final int c(m2 m2Var) {
        int a02 = m2Var.a0();
        int c02 = m2Var.c0();
        while (c02 >= 0 && !m2Var.r0(c02)) {
            c02 = m2Var.E0(c02);
        }
        int i11 = c02 + 1;
        int i12 = 0;
        while (i11 < a02) {
            if (m2Var.m0(a02, i11)) {
                if (m2Var.r0(i11)) {
                    i12 = 0;
                }
                i11++;
            } else {
                i12 += m2Var.r0(i11) ? 1 : m2Var.C0(i11);
                i11 += m2Var.k0(i11);
            }
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(m2 m2Var, androidx.compose.runtime.c cVar, androidx.compose.runtime.f fVar) {
        int F = m2Var.F(cVar);
        k.O(m2Var.a0() < F);
        e(m2Var, fVar, F);
        int c11 = c(m2Var);
        while (m2Var.a0() < F) {
            if (m2Var.l0(F)) {
                if (m2Var.q0()) {
                    fVar.j(m2Var.A0(m2Var.a0()));
                    c11 = 0;
                }
                m2Var.g1();
            } else {
                c11 += m2Var.V0();
            }
        }
        k.O(m2Var.a0() == F);
        return c11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(m2 m2Var, androidx.compose.runtime.f fVar, int i11) {
        while (!m2Var.n0(i11)) {
            m2Var.W0();
            if (m2Var.r0(m2Var.c0())) {
                fVar.l();
            }
            m2Var.T();
        }
    }
}
