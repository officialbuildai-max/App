package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import java.util.HashSet;

/* loaded from: classes.dex */
public class i extends t0.b {
    private int X0 = 0;
    private int Y0 = 0;
    private int Z0 = 0;

    /* renamed from: a1, reason: collision with root package name */
    private int f7155a1 = 0;

    /* renamed from: b1, reason: collision with root package name */
    private int f7156b1 = 0;

    /* renamed from: c1, reason: collision with root package name */
    private int f7157c1 = 0;

    /* renamed from: d1, reason: collision with root package name */
    private int f7158d1 = 0;

    /* renamed from: e1, reason: collision with root package name */
    private int f7159e1 = 0;

    /* renamed from: f1, reason: collision with root package name */
    private boolean f7160f1 = false;

    /* renamed from: g1, reason: collision with root package name */
    private int f7161g1 = 0;

    /* renamed from: h1, reason: collision with root package name */
    private int f7162h1 = 0;

    /* renamed from: i1, reason: collision with root package name */
    protected b.a f7163i1 = new b.a();

    /* renamed from: j1, reason: collision with root package name */
    b.InterfaceC0060b f7164j1 = null;

    public int A1() {
        return this.f7162h1;
    }

    public int B1() {
        return this.f7161g1;
    }

    public int C1() {
        return this.Y0;
    }

    public int D1() {
        return this.f7158d1;
    }

    public int E1() {
        return this.f7159e1;
    }

    public int F1() {
        return this.X0;
    }

    public void G1(int i11, int i12, int i13, int i14) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H1(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i11, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i12) {
        while (this.f7164j1 == null && M() != null) {
            this.f7164j1 = ((d) M()).N1();
        }
        b.a aVar = this.f7163i1;
        aVar.f7015a = dimensionBehaviour;
        aVar.f7016b = dimensionBehaviour2;
        aVar.f7017c = i11;
        aVar.f7018d = i12;
        this.f7164j1.b(constraintWidget, aVar);
        constraintWidget.o1(this.f7163i1.f7019e);
        constraintWidget.P0(this.f7163i1.f7020f);
        constraintWidget.O0(this.f7163i1.f7022h);
        constraintWidget.E0(this.f7163i1.f7021g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I1() {
        ConstraintWidget constraintWidget = this.f6936c0;
        b.InterfaceC0060b N1 = constraintWidget != null ? ((d) constraintWidget).N1() : null;
        if (N1 == null) {
            return false;
        }
        for (int i11 = 0; i11 < this.W0; i11++) {
            ConstraintWidget constraintWidget2 = this.V0[i11];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof f)) {
                ConstraintWidget.DimensionBehaviour w11 = constraintWidget2.w(0);
                ConstraintWidget.DimensionBehaviour w12 = constraintWidget2.w(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (w11 != dimensionBehaviour || constraintWidget2.f6975w == 1 || w12 != dimensionBehaviour || constraintWidget2.f6977x == 1) {
                    if (w11 == dimensionBehaviour) {
                        w11 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (w12 == dimensionBehaviour) {
                        w12 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    b.a aVar = this.f7163i1;
                    aVar.f7015a = w11;
                    aVar.f7016b = w12;
                    aVar.f7017c = constraintWidget2.Y();
                    this.f7163i1.f7018d = constraintWidget2.z();
                    N1.b(constraintWidget2, this.f7163i1);
                    constraintWidget2.o1(this.f7163i1.f7019e);
                    constraintWidget2.P0(this.f7163i1.f7020f);
                    constraintWidget2.E0(this.f7163i1.f7021g);
                }
            }
        }
        return true;
    }

    public boolean J1() {
        return this.f7160f1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K1(boolean z10) {
        this.f7160f1 = z10;
    }

    public void L1(int i11, int i12) {
        this.f7161g1 = i11;
        this.f7162h1 = i12;
    }

    public void M1(int i11) {
        this.Z0 = i11;
        this.X0 = i11;
        this.f7155a1 = i11;
        this.Y0 = i11;
        this.f7156b1 = i11;
        this.f7157c1 = i11;
    }

    public void N1(int i11) {
        this.Y0 = i11;
    }

    public void O1(int i11) {
        this.f7157c1 = i11;
    }

    public void P1(int i11) {
        this.Z0 = i11;
        this.f7158d1 = i11;
    }

    public void Q1(int i11) {
        this.f7155a1 = i11;
        this.f7159e1 = i11;
    }

    public void R1(int i11) {
        this.f7156b1 = i11;
        this.f7158d1 = i11;
        this.f7159e1 = i11;
    }

    public void S1(int i11) {
        this.X0 = i11;
    }

    @Override // t0.b, t0.a
    public void c(d dVar) {
        y1();
    }

    public void x1(boolean z10) {
        int i11 = this.f7156b1;
        if (i11 > 0 || this.f7157c1 > 0) {
            if (z10) {
                this.f7158d1 = this.f7157c1;
                this.f7159e1 = i11;
            } else {
                this.f7158d1 = i11;
                this.f7159e1 = this.f7157c1;
            }
        }
    }

    public void y1() {
        for (int i11 = 0; i11 < this.W0; i11++) {
            ConstraintWidget constraintWidget = this.V0[i11];
            if (constraintWidget != null) {
                constraintWidget.Y0(true);
            }
        }
    }

    public boolean z1(HashSet hashSet) {
        for (int i11 = 0; i11 < this.W0; i11++) {
            if (hashSet.contains(this.V0[i11])) {
                return true;
            }
        }
        return false;
    }
}
