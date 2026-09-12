package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: classes.dex */
public class f extends ConstraintWidget {
    protected float V0 = -1.0f;
    protected int W0 = -1;
    protected int X0 = -1;
    protected boolean Y0 = true;
    private ConstraintAnchor Z0 = this.R;

    /* renamed from: a1, reason: collision with root package name */
    private int f7150a1 = 0;

    /* renamed from: b1, reason: collision with root package name */
    private int f7151b1 = 0;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f7152c1;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7153a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f7153a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7153a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7153a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7153a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7153a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7153a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7153a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7153a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7153a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public f() {
        this.Z.clear();
        this.Z.add(this.Z0);
        int length = this.Y.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.Y[i11] = this.Z0;
        }
    }

    public void A1(int i11) {
        this.Z0.t(i11);
        this.f7152c1 = true;
    }

    public void B1(int i11) {
        if (i11 > -1) {
            this.V0 = -1.0f;
            this.W0 = i11;
            this.X0 = -1;
        }
    }

    public void C1(int i11) {
        if (i11 > -1) {
            this.V0 = -1.0f;
            this.W0 = -1;
            this.X0 = i11;
        }
    }

    public void D1(float f11) {
        if (f11 > -1.0f) {
            this.V0 = f11;
            this.W0 = -1;
            this.X0 = -1;
        }
    }

    public void E1(int i11) {
        if (this.f7150a1 == i11) {
            return;
        }
        this.f7150a1 = i11;
        this.Z.clear();
        if (this.f7150a1 == 1) {
            this.Z0 = this.Q;
        } else {
            this.Z0 = this.R;
        }
        this.Z.add(this.Z0);
        int length = this.Y.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.Y[i12] = this.Z0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.d dVar, boolean z10) {
        d dVar2 = (d) M();
        if (dVar2 == null) {
            return;
        }
        ConstraintAnchor q11 = dVar2.q(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor q12 = dVar2.q(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.f6936c0;
        boolean z11 = constraintWidget != null && constraintWidget.f6934b0[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.f7150a1 == 0) {
            q11 = dVar2.q(ConstraintAnchor.Type.TOP);
            q12 = dVar2.q(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.f6936c0;
            z11 = constraintWidget2 != null && constraintWidget2.f6934b0[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.f7152c1 && this.Z0.n()) {
            SolverVariable q13 = dVar.q(this.Z0);
            dVar.f(q13, this.Z0.e());
            if (this.W0 != -1) {
                if (z11) {
                    dVar.h(dVar.q(q12), q13, 0, 5);
                }
            } else if (this.X0 != -1 && z11) {
                SolverVariable q14 = dVar.q(q12);
                dVar.h(q13, dVar.q(q11), 0, 5);
                dVar.h(q14, q13, 0, 5);
            }
            this.f7152c1 = false;
            return;
        }
        if (this.W0 != -1) {
            SolverVariable q15 = dVar.q(this.Z0);
            dVar.e(q15, dVar.q(q11), this.W0, 8);
            if (z11) {
                dVar.h(dVar.q(q12), q15, 0, 5);
                return;
            }
            return;
        }
        if (this.X0 == -1) {
            if (this.V0 != -1.0f) {
                dVar.d(androidx.constraintlayout.core.d.s(dVar, dVar.q(this.Z0), dVar.q(q12), this.V0));
                return;
            }
            return;
        }
        SolverVariable q16 = dVar.q(this.Z0);
        SolverVariable q17 = dVar.q(q12);
        dVar.e(q16, q17, -this.X0, 8);
        if (z11) {
            dVar.h(q16, dVar.q(q11), 0, 5);
            dVar.h(q17, q16, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap hashMap) {
        super.n(constraintWidget, hashMap);
        f fVar = (f) constraintWidget;
        this.V0 = fVar.V0;
        this.W0 = fVar.W0;
        this.X0 = fVar.X0;
        this.Y0 = fVar.Y0;
        E1(fVar.f7150a1);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean p0() {
        return this.f7152c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        int i11 = a.f7153a[type.ordinal()];
        if (i11 == 1 || i11 == 2) {
            if (this.f7150a1 == 1) {
                return this.Z0;
            }
            return null;
        }
        if ((i11 == 3 || i11 == 4) && this.f7150a1 == 0) {
            return this.Z0;
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean q0() {
        return this.f7152c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void u1(androidx.constraintlayout.core.d dVar, boolean z10) {
        if (M() == null) {
            return;
        }
        int y10 = dVar.y(this.Z0);
        if (this.f7150a1 == 1) {
            q1(y10);
            r1(0);
            P0(M().z());
            o1(0);
            return;
        }
        q1(0);
        r1(y10);
        o1(M().Y());
        P0(0);
    }

    public ConstraintAnchor v1() {
        return this.Z0;
    }

    public int w1() {
        return this.f7150a1;
    }

    public int x1() {
        return this.W0;
    }

    public int y1() {
        return this.X0;
    }

    public float z1() {
        return this.V0;
    }
}
