package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a extends t0.b {
    private int X0 = 0;
    private boolean Y0 = true;
    private int Z0 = 0;

    /* renamed from: a1, reason: collision with root package name */
    boolean f6985a1 = false;

    public int A1() {
        return this.Z0;
    }

    public int B1() {
        int i11 = this.X0;
        if (i11 == 0 || i11 == 1) {
            return 0;
        }
        return (i11 == 2 || i11 == 3) ? 1 : -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C1() {
        for (int i11 = 0; i11 < this.W0; i11++) {
            ConstraintWidget constraintWidget = this.V0[i11];
            if (this.Y0 || constraintWidget.h()) {
                int i12 = this.X0;
                if (i12 == 0 || i12 == 1) {
                    constraintWidget.W0(0, true);
                } else if (i12 == 2 || i12 == 3) {
                    constraintWidget.W0(1, true);
                }
            }
        }
    }

    public void D1(boolean z10) {
        this.Y0 = z10;
    }

    public void E1(int i11) {
        this.X0 = i11;
    }

    public void F1(int i11) {
        this.Z0 = i11;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.d dVar, boolean z10) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z11;
        int i11;
        int i12;
        int i13;
        ConstraintAnchor[] constraintAnchorArr2 = this.Y;
        constraintAnchorArr2[0] = this.Q;
        constraintAnchorArr2[2] = this.R;
        constraintAnchorArr2[1] = this.S;
        constraintAnchorArr2[3] = this.T;
        int i14 = 0;
        while (true) {
            constraintAnchorArr = this.Y;
            if (i14 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i14];
            constraintAnchor.f6929i = dVar.q(constraintAnchor);
            i14++;
        }
        int i15 = this.X0;
        if (i15 < 0 || i15 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i15];
        if (!this.f6985a1) {
            x1();
        }
        if (this.f6985a1) {
            this.f6985a1 = false;
            int i16 = this.X0;
            if (i16 == 0 || i16 == 1) {
                dVar.f(this.Q.f6929i, this.f6946h0);
                dVar.f(this.S.f6929i, this.f6946h0);
                return;
            } else {
                if (i16 == 2 || i16 == 3) {
                    dVar.f(this.R.f6929i, this.f6948i0);
                    dVar.f(this.T.f6929i, this.f6948i0);
                    return;
                }
                return;
            }
        }
        for (int i17 = 0; i17 < this.W0; i17++) {
            ConstraintWidget constraintWidget = this.V0[i17];
            if ((this.Y0 || constraintWidget.h()) && ((((i12 = this.X0) == 0 || i12 == 1) && constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.Q.f6926f != null && constraintWidget.S.f6926f != null) || (((i13 = this.X0) == 2 || i13 == 3) && constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.R.f6926f != null && constraintWidget.T.f6926f != null))) {
                z11 = true;
                break;
            }
        }
        z11 = false;
        boolean z12 = this.Q.l() || this.S.l();
        boolean z13 = this.R.l() || this.T.l();
        int i18 = !(!z11 && (((i11 = this.X0) == 0 && z12) || ((i11 == 2 && z13) || ((i11 == 1 && z12) || (i11 == 3 && z13))))) ? 4 : 5;
        for (int i19 = 0; i19 < this.W0; i19++) {
            ConstraintWidget constraintWidget2 = this.V0[i19];
            if (this.Y0 || constraintWidget2.h()) {
                SolverVariable q11 = dVar.q(constraintWidget2.Y[this.X0]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.Y;
                int i20 = this.X0;
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i20];
                constraintAnchor3.f6929i = q11;
                ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6926f;
                int i21 = (constraintAnchor4 == null || constraintAnchor4.f6924d != this) ? 0 : constraintAnchor3.f6927g;
                if (i20 == 0 || i20 == 2) {
                    dVar.i(constraintAnchor2.f6929i, q11, this.Z0 - i21, z11);
                } else {
                    dVar.g(constraintAnchor2.f6929i, q11, this.Z0 + i21, z11);
                }
                dVar.e(constraintAnchor2.f6929i, q11, this.Z0 + i21, i18);
            }
        }
        int i22 = this.X0;
        if (i22 == 0) {
            dVar.e(this.S.f6929i, this.Q.f6929i, 0, 8);
            dVar.e(this.Q.f6929i, this.f6936c0.S.f6929i, 0, 4);
            dVar.e(this.Q.f6929i, this.f6936c0.Q.f6929i, 0, 0);
            return;
        }
        if (i22 == 1) {
            dVar.e(this.Q.f6929i, this.S.f6929i, 0, 8);
            dVar.e(this.Q.f6929i, this.f6936c0.Q.f6929i, 0, 4);
            dVar.e(this.Q.f6929i, this.f6936c0.S.f6929i, 0, 0);
        } else if (i22 == 2) {
            dVar.e(this.T.f6929i, this.R.f6929i, 0, 8);
            dVar.e(this.R.f6929i, this.f6936c0.T.f6929i, 0, 4);
            dVar.e(this.R.f6929i, this.f6936c0.R.f6929i, 0, 0);
        } else if (i22 == 3) {
            dVar.e(this.R.f6929i, this.T.f6929i, 0, 8);
            dVar.e(this.R.f6929i, this.f6936c0.R.f6929i, 0, 4);
            dVar.e(this.R.f6929i, this.f6936c0.T.f6929i, 0, 0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // t0.b, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap hashMap) {
        super.n(constraintWidget, hashMap);
        a aVar = (a) constraintWidget;
        this.X0 = aVar.X0;
        this.Y0 = aVar.Y0;
        this.Z0 = aVar.Z0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean p0() {
        return this.f6985a1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean q0() {
        return this.f6985a1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + v() + " {";
        for (int i11 = 0; i11 < this.W0; i11++) {
            ConstraintWidget constraintWidget = this.V0[i11];
            if (i11 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.v();
        }
        return str + "}";
    }

    public boolean x1() {
        int i11;
        int i12;
        int i13;
        boolean z10 = true;
        int i14 = 0;
        while (true) {
            i11 = this.W0;
            if (i14 >= i11) {
                break;
            }
            ConstraintWidget constraintWidget = this.V0[i14];
            if ((this.Y0 || constraintWidget.h()) && ((((i12 = this.X0) == 0 || i12 == 1) && !constraintWidget.p0()) || (((i13 = this.X0) == 2 || i13 == 3) && !constraintWidget.q0()))) {
                z10 = false;
            }
            i14++;
        }
        if (!z10 || i11 <= 0) {
            return false;
        }
        int i15 = 0;
        boolean z11 = false;
        for (int i16 = 0; i16 < this.W0; i16++) {
            ConstraintWidget constraintWidget2 = this.V0[i16];
            if (this.Y0 || constraintWidget2.h()) {
                if (!z11) {
                    int i17 = this.X0;
                    if (i17 == 0) {
                        i15 = constraintWidget2.q(ConstraintAnchor.Type.LEFT).e();
                    } else if (i17 == 1) {
                        i15 = constraintWidget2.q(ConstraintAnchor.Type.RIGHT).e();
                    } else if (i17 == 2) {
                        i15 = constraintWidget2.q(ConstraintAnchor.Type.TOP).e();
                    } else if (i17 == 3) {
                        i15 = constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).e();
                    }
                    z11 = true;
                }
                int i18 = this.X0;
                if (i18 == 0) {
                    i15 = Math.min(i15, constraintWidget2.q(ConstraintAnchor.Type.LEFT).e());
                } else if (i18 == 1) {
                    i15 = Math.max(i15, constraintWidget2.q(ConstraintAnchor.Type.RIGHT).e());
                } else if (i18 == 2) {
                    i15 = Math.min(i15, constraintWidget2.q(ConstraintAnchor.Type.TOP).e());
                } else if (i18 == 3) {
                    i15 = Math.max(i15, constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).e());
                }
            }
        }
        int i19 = i15 + this.Z0;
        int i20 = this.X0;
        if (i20 == 0 || i20 == 1) {
            J0(i19, i19);
        } else {
            M0(i19, i19);
        }
        this.f6985a1 = true;
        return true;
    }

    public boolean y1() {
        return this.Y0;
    }

    public int z1() {
        return this.X0;
    }
}
