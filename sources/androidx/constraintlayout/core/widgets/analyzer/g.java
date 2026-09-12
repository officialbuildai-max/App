package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class g {
    public static m a(ConstraintWidget constraintWidget, int i11, ArrayList arrayList, m mVar) {
        int w12;
        int i12 = i11 == 0 ? constraintWidget.S0 : constraintWidget.T0;
        if (i12 != -1 && (mVar == null || i12 != mVar.f7055b)) {
            int i13 = 0;
            while (true) {
                if (i13 >= arrayList.size()) {
                    break;
                }
                m mVar2 = (m) arrayList.get(i13);
                if (mVar2.c() == i12) {
                    if (mVar != null) {
                        mVar.g(i11, mVar2);
                        arrayList.remove(mVar);
                    }
                    mVar = mVar2;
                } else {
                    i13++;
                }
            }
        } else if (i12 != -1) {
            return mVar;
        }
        if (mVar == null) {
            if ((constraintWidget instanceof t0.b) && (w12 = ((t0.b) constraintWidget).w1(i11)) != -1) {
                int i14 = 0;
                while (true) {
                    if (i14 >= arrayList.size()) {
                        break;
                    }
                    m mVar3 = (m) arrayList.get(i14);
                    if (mVar3.c() == w12) {
                        mVar = mVar3;
                        break;
                    }
                    i14++;
                }
            }
            if (mVar == null) {
                mVar = new m(i11);
            }
            arrayList.add(mVar);
        }
        if (mVar.a(constraintWidget)) {
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                fVar.v1().c(fVar.w1() == 0 ? 1 : 0, arrayList, mVar);
            }
            if (i11 == 0) {
                constraintWidget.S0 = mVar.c();
                constraintWidget.Q.c(i11, arrayList, mVar);
                constraintWidget.S.c(i11, arrayList, mVar);
            } else {
                constraintWidget.T0 = mVar.c();
                constraintWidget.R.c(i11, arrayList, mVar);
                constraintWidget.U.c(i11, arrayList, mVar);
                constraintWidget.T.c(i11, arrayList, mVar);
            }
            constraintWidget.X.c(i11, arrayList, mVar);
        }
        return mVar;
    }

    private static m b(ArrayList arrayList, int i11) {
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            m mVar = (m) arrayList.get(i12);
            if (i11 == mVar.f7055b) {
                return mVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x039d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0398  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(androidx.constraintlayout.core.widgets.d r16, androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0060b r17) {
        /*
            Method dump skipped, instructions count: 932
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.g.c(androidx.constraintlayout.core.widgets.d, androidx.constraintlayout.core.widgets.analyzer.b$b):boolean");
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5));
    }
}
