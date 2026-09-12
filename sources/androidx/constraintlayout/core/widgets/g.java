package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    static boolean[] f7154a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(d dVar, androidx.constraintlayout.core.d dVar2, ConstraintWidget constraintWidget) {
        constraintWidget.f6969t = -1;
        constraintWidget.f6971u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.f6934b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.f6934b0[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i11 = constraintWidget.Q.f6927g;
            int Y = dVar.Y() - constraintWidget.S.f6927g;
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            constraintAnchor.f6929i = dVar2.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.S;
            constraintAnchor2.f6929i = dVar2.q(constraintAnchor2);
            dVar2.f(constraintWidget.Q.f6929i, i11);
            dVar2.f(constraintWidget.S.f6929i, Y);
            constraintWidget.f6969t = 2;
            constraintWidget.S0(i11, Y);
        }
        if (dVar.f6934b0[1] == dimensionBehaviour2 || constraintWidget.f6934b0[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i12 = constraintWidget.R.f6927g;
        int z10 = dVar.z() - constraintWidget.T.f6927g;
        ConstraintAnchor constraintAnchor3 = constraintWidget.R;
        constraintAnchor3.f6929i = dVar2.q(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.T;
        constraintAnchor4.f6929i = dVar2.q(constraintAnchor4);
        dVar2.f(constraintWidget.R.f6929i, i12);
        dVar2.f(constraintWidget.T.f6929i, z10);
        if (constraintWidget.f6958n0 > 0 || constraintWidget.X() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.U;
            constraintAnchor5.f6929i = dVar2.q(constraintAnchor5);
            dVar2.f(constraintWidget.U.f6929i, constraintWidget.f6958n0 + i12);
        }
        constraintWidget.f6971u = 2;
        constraintWidget.j1(i12, z10);
    }

    public static final boolean b(int i11, int i12) {
        return (i11 & i12) == i12;
    }
}
