package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static b.a f7037a = new b.a();

    /* renamed from: b, reason: collision with root package name */
    private static int f7038b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f7039c = 0;

    private static boolean a(int i11, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour C = constraintWidget.C();
        ConstraintWidget.DimensionBehaviour V = constraintWidget.V();
        androidx.constraintlayout.core.widgets.d dVar = constraintWidget.M() != null ? (androidx.constraintlayout.core.widgets.d) constraintWidget.M() : null;
        if (dVar != null) {
            dVar.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (dVar != null) {
            dVar.V();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z10 = C == dimensionBehaviour5 || constraintWidget.p0() || C == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (C == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f6975w == 0 && constraintWidget.f6942f0 == 0.0f && constraintWidget.c0(0)) || (C == dimensionBehaviour2 && constraintWidget.f6975w == 1 && constraintWidget.f0(0, constraintWidget.Y()));
        boolean z11 = V == dimensionBehaviour5 || constraintWidget.q0() || V == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (V == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f6977x == 0 && constraintWidget.f6942f0 == 0.0f && constraintWidget.c0(1)) || (V == dimensionBehaviour && constraintWidget.f6977x == 1 && constraintWidget.f0(1, constraintWidget.z()));
        if (constraintWidget.f6942f0 <= 0.0f || !(z10 || z11)) {
            return z10 && z11;
        }
        return true;
    }

    private static void b(int i11, ConstraintWidget constraintWidget, b.InterfaceC0060b interfaceC0060b, boolean z10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.i0()) {
            return;
        }
        boolean z11 = true;
        f7038b++;
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.o0()) {
            int i12 = i11 + 1;
            if (a(i12, constraintWidget)) {
                androidx.constraintlayout.core.widgets.d.X1(i12, constraintWidget, interfaceC0060b, new b.a(), b.a.f7012k);
            }
        }
        ConstraintAnchor q11 = constraintWidget.q(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor q12 = constraintWidget.q(ConstraintAnchor.Type.RIGHT);
        int e11 = q11.e();
        int e12 = q12.e();
        if (q11.d() != null && q11.n()) {
            Iterator it = q11.d().iterator();
            while (it.hasNext()) {
                ConstraintAnchor constraintAnchor5 = (ConstraintAnchor) it.next();
                ConstraintWidget constraintWidget2 = constraintAnchor5.f6924d;
                int i13 = i11 + 1;
                boolean a11 = a(i13, constraintWidget2);
                if (constraintWidget2.o0() && a11) {
                    androidx.constraintlayout.core.widgets.d.X1(i13, constraintWidget2, interfaceC0060b, new b.a(), b.a.f7012k);
                }
                boolean z12 = ((constraintAnchor5 == constraintWidget2.Q && (constraintAnchor4 = constraintWidget2.S.f6926f) != null && constraintAnchor4.n()) || (constraintAnchor5 == constraintWidget2.S && (constraintAnchor3 = constraintWidget2.Q.f6926f) != null && constraintAnchor3.n())) ? z11 : false;
                ConstraintWidget.DimensionBehaviour C = constraintWidget2.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (C != dimensionBehaviour || a11) {
                    if (!constraintWidget2.o0()) {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.Q;
                        if (constraintAnchor5 == constraintAnchor6 && constraintWidget2.S.f6926f == null) {
                            int f11 = constraintAnchor6.f() + e11;
                            constraintWidget2.J0(f11, constraintWidget2.Y() + f11);
                            b(i13, constraintWidget2, interfaceC0060b, z10);
                        } else {
                            ConstraintAnchor constraintAnchor7 = constraintWidget2.S;
                            if (constraintAnchor5 == constraintAnchor7 && constraintAnchor6.f6926f == null) {
                                int f12 = e11 - constraintAnchor7.f();
                                constraintWidget2.J0(f12 - constraintWidget2.Y(), f12);
                                b(i13, constraintWidget2, interfaceC0060b, z10);
                            } else if (z12 && !constraintWidget2.k0()) {
                                d(i13, interfaceC0060b, constraintWidget2, z10);
                            }
                        }
                    }
                } else if (constraintWidget2.C() == dimensionBehaviour && constraintWidget2.A >= 0 && constraintWidget2.f6981z >= 0 && ((constraintWidget2.X() == 8 || (constraintWidget2.f6975w == 0 && constraintWidget2.x() == 0.0f)) && !constraintWidget2.k0() && !constraintWidget2.n0() && z12 && !constraintWidget2.k0())) {
                    e(i13, constraintWidget, interfaceC0060b, constraintWidget2, z10);
                }
                z11 = true;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        if (q12.d() != null && q12.n()) {
            Iterator it2 = q12.d().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor constraintAnchor8 = (ConstraintAnchor) it2.next();
                ConstraintWidget constraintWidget3 = constraintAnchor8.f6924d;
                int i14 = i11 + 1;
                boolean a12 = a(i14, constraintWidget3);
                if (constraintWidget3.o0() && a12) {
                    androidx.constraintlayout.core.widgets.d.X1(i14, constraintWidget3, interfaceC0060b, new b.a(), b.a.f7012k);
                }
                boolean z13 = (constraintAnchor8 == constraintWidget3.Q && (constraintAnchor2 = constraintWidget3.S.f6926f) != null && constraintAnchor2.n()) || (constraintAnchor8 == constraintWidget3.S && (constraintAnchor = constraintWidget3.Q.f6926f) != null && constraintAnchor.n());
                ConstraintWidget.DimensionBehaviour C2 = constraintWidget3.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (C2 != dimensionBehaviour2 || a12) {
                    if (!constraintWidget3.o0()) {
                        ConstraintAnchor constraintAnchor9 = constraintWidget3.Q;
                        if (constraintAnchor8 == constraintAnchor9 && constraintWidget3.S.f6926f == null) {
                            int f13 = constraintAnchor9.f() + e12;
                            constraintWidget3.J0(f13, constraintWidget3.Y() + f13);
                            b(i14, constraintWidget3, interfaceC0060b, z10);
                        } else {
                            ConstraintAnchor constraintAnchor10 = constraintWidget3.S;
                            if (constraintAnchor8 == constraintAnchor10 && constraintAnchor9.f6926f == null) {
                                int f14 = e12 - constraintAnchor10.f();
                                constraintWidget3.J0(f14 - constraintWidget3.Y(), f14);
                                b(i14, constraintWidget3, interfaceC0060b, z10);
                            } else if (z13 && !constraintWidget3.k0()) {
                                d(i14, interfaceC0060b, constraintWidget3, z10);
                            }
                        }
                    }
                } else if (constraintWidget3.C() == dimensionBehaviour2 && constraintWidget3.A >= 0 && constraintWidget3.f6981z >= 0 && (constraintWidget3.X() == 8 || (constraintWidget3.f6975w == 0 && constraintWidget3.x() == 0.0f))) {
                    if (!constraintWidget3.k0() && !constraintWidget3.n0() && z13 && !constraintWidget3.k0()) {
                        e(i14, constraintWidget, interfaceC0060b, constraintWidget3, z10);
                    }
                }
            }
        }
        constraintWidget.s0();
    }

    private static void c(int i11, androidx.constraintlayout.core.widgets.a aVar, b.InterfaceC0060b interfaceC0060b, int i12, boolean z10) {
        if (aVar.x1()) {
            if (i12 == 0) {
                b(i11 + 1, aVar, interfaceC0060b, z10);
            } else {
                i(i11 + 1, aVar, interfaceC0060b);
            }
        }
    }

    private static void d(int i11, b.InterfaceC0060b interfaceC0060b, ConstraintWidget constraintWidget, boolean z10) {
        float A = constraintWidget.A();
        int e11 = constraintWidget.Q.f6926f.e();
        int e12 = constraintWidget.S.f6926f.e();
        int f11 = constraintWidget.Q.f() + e11;
        int f12 = e12 - constraintWidget.S.f();
        if (e11 == e12) {
            A = 0.5f;
        } else {
            e11 = f11;
            e12 = f12;
        }
        int Y = constraintWidget.Y();
        int i12 = (e12 - e11) - Y;
        if (e11 > e12) {
            i12 = (e11 - e12) - Y;
        }
        int i13 = ((int) (i12 > 0 ? (A * i12) + 0.5f : A * i12)) + e11;
        int i14 = i13 + Y;
        if (e11 > e12) {
            i14 = i13 - Y;
        }
        constraintWidget.J0(i13, i14);
        b(i11 + 1, constraintWidget, interfaceC0060b, z10);
    }

    private static void e(int i11, ConstraintWidget constraintWidget, b.InterfaceC0060b interfaceC0060b, ConstraintWidget constraintWidget2, boolean z10) {
        float A = constraintWidget2.A();
        int e11 = constraintWidget2.Q.f6926f.e() + constraintWidget2.Q.f();
        int e12 = constraintWidget2.S.f6926f.e() - constraintWidget2.S.f();
        if (e12 >= e11) {
            int Y = constraintWidget2.Y();
            if (constraintWidget2.X() != 8) {
                int i12 = constraintWidget2.f6975w;
                if (i12 == 2) {
                    Y = (int) (constraintWidget2.A() * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.Y() : constraintWidget.M().Y()));
                } else if (i12 == 0) {
                    Y = e12 - e11;
                }
                Y = Math.max(constraintWidget2.f6981z, Y);
                int i13 = constraintWidget2.A;
                if (i13 > 0) {
                    Y = Math.min(i13, Y);
                }
            }
            int i14 = e11 + ((int) ((A * ((e12 - e11) - Y)) + 0.5f));
            constraintWidget2.J0(i14, Y + i14);
            b(i11 + 1, constraintWidget2, interfaceC0060b, z10);
        }
    }

    private static void f(int i11, b.InterfaceC0060b interfaceC0060b, ConstraintWidget constraintWidget) {
        float T = constraintWidget.T();
        int e11 = constraintWidget.R.f6926f.e();
        int e12 = constraintWidget.T.f6926f.e();
        int f11 = constraintWidget.R.f() + e11;
        int f12 = e12 - constraintWidget.T.f();
        if (e11 == e12) {
            T = 0.5f;
        } else {
            e11 = f11;
            e12 = f12;
        }
        int z10 = constraintWidget.z();
        int i12 = (e12 - e11) - z10;
        if (e11 > e12) {
            i12 = (e11 - e12) - z10;
        }
        int i13 = (int) (i12 > 0 ? (T * i12) + 0.5f : T * i12);
        int i14 = e11 + i13;
        int i15 = i14 + z10;
        if (e11 > e12) {
            i14 = e11 - i13;
            i15 = i14 - z10;
        }
        constraintWidget.M0(i14, i15);
        i(i11 + 1, constraintWidget, interfaceC0060b);
    }

    private static void g(int i11, ConstraintWidget constraintWidget, b.InterfaceC0060b interfaceC0060b, ConstraintWidget constraintWidget2) {
        float T = constraintWidget2.T();
        int e11 = constraintWidget2.R.f6926f.e() + constraintWidget2.R.f();
        int e12 = constraintWidget2.T.f6926f.e() - constraintWidget2.T.f();
        if (e12 >= e11) {
            int z10 = constraintWidget2.z();
            if (constraintWidget2.X() != 8) {
                int i12 = constraintWidget2.f6977x;
                if (i12 == 2) {
                    z10 = (int) (T * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.z() : constraintWidget.M().z()));
                } else if (i12 == 0) {
                    z10 = e12 - e11;
                }
                z10 = Math.max(constraintWidget2.C, z10);
                int i13 = constraintWidget2.D;
                if (i13 > 0) {
                    z10 = Math.min(i13, z10);
                }
            }
            int i14 = e11 + ((int) ((T * ((e12 - e11) - z10)) + 0.5f));
            constraintWidget2.M0(i14, z10 + i14);
            i(i11 + 1, constraintWidget2, interfaceC0060b);
        }
    }

    public static void h(androidx.constraintlayout.core.widgets.d dVar, b.InterfaceC0060b interfaceC0060b) {
        ConstraintWidget.DimensionBehaviour C = dVar.C();
        ConstraintWidget.DimensionBehaviour V = dVar.V();
        f7038b = 0;
        f7039c = 0;
        dVar.y0();
        ArrayList v12 = dVar.v1();
        int size = v12.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((ConstraintWidget) v12.get(i11)).y0();
        }
        boolean U1 = dVar.U1();
        if (C == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.J0(0, dVar.Y());
        } else {
            dVar.K0(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) v12.get(i12);
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                if (fVar.w1() == 1) {
                    if (fVar.x1() != -1) {
                        fVar.A1(fVar.x1());
                    } else if (fVar.y1() != -1 && dVar.p0()) {
                        fVar.A1(dVar.Y() - fVar.y1());
                    } else if (dVar.p0()) {
                        fVar.A1((int) ((fVar.z1() * dVar.Y()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((constraintWidget instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) constraintWidget).B1() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) v12.get(i13);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar2 = (androidx.constraintlayout.core.widgets.f) constraintWidget2;
                    if (fVar2.w1() == 1) {
                        b(0, fVar2, interfaceC0060b, U1);
                    }
                }
            }
        }
        b(0, dVar, interfaceC0060b, U1);
        if (z11) {
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget3 = (ConstraintWidget) v12.get(i14);
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget3;
                    if (aVar.B1() == 0) {
                        c(0, aVar, interfaceC0060b, 0, U1);
                    }
                }
            }
        }
        if (V == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.M0(0, dVar.z());
        } else {
            dVar.L0(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i15 = 0; i15 < size; i15++) {
            ConstraintWidget constraintWidget4 = (ConstraintWidget) v12.get(i15);
            if (constraintWidget4 instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar3 = (androidx.constraintlayout.core.widgets.f) constraintWidget4;
                if (fVar3.w1() == 0) {
                    if (fVar3.x1() != -1) {
                        fVar3.A1(fVar3.x1());
                    } else if (fVar3.y1() != -1 && dVar.q0()) {
                        fVar3.A1(dVar.z() - fVar3.y1());
                    } else if (dVar.q0()) {
                        fVar3.A1((int) ((fVar3.z1() * dVar.z()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((constraintWidget4 instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) constraintWidget4).B1() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) v12.get(i16);
                if (constraintWidget5 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar4 = (androidx.constraintlayout.core.widgets.f) constraintWidget5;
                    if (fVar4.w1() == 0) {
                        i(1, fVar4, interfaceC0060b);
                    }
                }
            }
        }
        i(0, dVar, interfaceC0060b);
        if (z13) {
            for (int i17 = 0; i17 < size; i17++) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) v12.get(i17);
                if (constraintWidget6 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) constraintWidget6;
                    if (aVar2.B1() == 1) {
                        c(0, aVar2, interfaceC0060b, 1, U1);
                    }
                }
            }
        }
        for (int i18 = 0; i18 < size; i18++) {
            ConstraintWidget constraintWidget7 = (ConstraintWidget) v12.get(i18);
            if (constraintWidget7.o0() && a(0, constraintWidget7)) {
                androidx.constraintlayout.core.widgets.d.X1(0, constraintWidget7, interfaceC0060b, f7037a, b.a.f7012k);
                if (!(constraintWidget7 instanceof androidx.constraintlayout.core.widgets.f)) {
                    b(0, constraintWidget7, interfaceC0060b, U1);
                    i(0, constraintWidget7, interfaceC0060b);
                } else if (((androidx.constraintlayout.core.widgets.f) constraintWidget7).w1() == 0) {
                    i(0, constraintWidget7, interfaceC0060b);
                } else {
                    b(0, constraintWidget7, interfaceC0060b, U1);
                }
            }
        }
    }

    private static void i(int i11, ConstraintWidget constraintWidget, b.InterfaceC0060b interfaceC0060b) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.r0()) {
            return;
        }
        f7039c++;
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.o0()) {
            int i12 = i11 + 1;
            if (a(i12, constraintWidget)) {
                androidx.constraintlayout.core.widgets.d.X1(i12, constraintWidget, interfaceC0060b, new b.a(), b.a.f7012k);
            }
        }
        ConstraintAnchor q11 = constraintWidget.q(ConstraintAnchor.Type.TOP);
        ConstraintAnchor q12 = constraintWidget.q(ConstraintAnchor.Type.BOTTOM);
        int e11 = q11.e();
        int e12 = q12.e();
        if (q11.d() != null && q11.n()) {
            Iterator it = q11.d().iterator();
            while (it.hasNext()) {
                ConstraintAnchor constraintAnchor5 = (ConstraintAnchor) it.next();
                ConstraintWidget constraintWidget2 = constraintAnchor5.f6924d;
                int i13 = i11 + 1;
                boolean a11 = a(i13, constraintWidget2);
                if (constraintWidget2.o0() && a11) {
                    androidx.constraintlayout.core.widgets.d.X1(i13, constraintWidget2, interfaceC0060b, new b.a(), b.a.f7012k);
                }
                boolean z10 = (constraintAnchor5 == constraintWidget2.R && (constraintAnchor4 = constraintWidget2.T.f6926f) != null && constraintAnchor4.n()) || (constraintAnchor5 == constraintWidget2.T && (constraintAnchor3 = constraintWidget2.R.f6926f) != null && constraintAnchor3.n());
                ConstraintWidget.DimensionBehaviour V = constraintWidget2.V();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (V != dimensionBehaviour || a11) {
                    if (!constraintWidget2.o0()) {
                        ConstraintAnchor constraintAnchor6 = constraintWidget2.R;
                        if (constraintAnchor5 == constraintAnchor6 && constraintWidget2.T.f6926f == null) {
                            int f11 = constraintAnchor6.f() + e11;
                            constraintWidget2.M0(f11, constraintWidget2.z() + f11);
                            i(i13, constraintWidget2, interfaceC0060b);
                        } else {
                            ConstraintAnchor constraintAnchor7 = constraintWidget2.T;
                            if (constraintAnchor5 == constraintAnchor7 && constraintAnchor6.f6926f == null) {
                                int f12 = e11 - constraintAnchor7.f();
                                constraintWidget2.M0(f12 - constraintWidget2.z(), f12);
                                i(i13, constraintWidget2, interfaceC0060b);
                            } else if (z10 && !constraintWidget2.m0()) {
                                f(i13, interfaceC0060b, constraintWidget2);
                            }
                        }
                    }
                } else if (constraintWidget2.V() == dimensionBehaviour && constraintWidget2.D >= 0 && constraintWidget2.C >= 0 && (constraintWidget2.X() == 8 || (constraintWidget2.f6977x == 0 && constraintWidget2.x() == 0.0f))) {
                    if (!constraintWidget2.m0() && !constraintWidget2.n0() && z10 && !constraintWidget2.m0()) {
                        g(i13, constraintWidget, interfaceC0060b, constraintWidget2);
                    }
                }
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        if (q12.d() != null && q12.n()) {
            Iterator it2 = q12.d().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor constraintAnchor8 = (ConstraintAnchor) it2.next();
                ConstraintWidget constraintWidget3 = constraintAnchor8.f6924d;
                int i14 = i11 + 1;
                boolean a12 = a(i14, constraintWidget3);
                if (constraintWidget3.o0() && a12) {
                    androidx.constraintlayout.core.widgets.d.X1(i14, constraintWidget3, interfaceC0060b, new b.a(), b.a.f7012k);
                }
                boolean z11 = (constraintAnchor8 == constraintWidget3.R && (constraintAnchor2 = constraintWidget3.T.f6926f) != null && constraintAnchor2.n()) || (constraintAnchor8 == constraintWidget3.T && (constraintAnchor = constraintWidget3.R.f6926f) != null && constraintAnchor.n());
                ConstraintWidget.DimensionBehaviour V2 = constraintWidget3.V();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (V2 != dimensionBehaviour2 || a12) {
                    if (!constraintWidget3.o0()) {
                        ConstraintAnchor constraintAnchor9 = constraintWidget3.R;
                        if (constraintAnchor8 == constraintAnchor9 && constraintWidget3.T.f6926f == null) {
                            int f13 = constraintAnchor9.f() + e12;
                            constraintWidget3.M0(f13, constraintWidget3.z() + f13);
                            i(i14, constraintWidget3, interfaceC0060b);
                        } else {
                            ConstraintAnchor constraintAnchor10 = constraintWidget3.T;
                            if (constraintAnchor8 == constraintAnchor10 && constraintAnchor9.f6926f == null) {
                                int f14 = e12 - constraintAnchor10.f();
                                constraintWidget3.M0(f14 - constraintWidget3.z(), f14);
                                i(i14, constraintWidget3, interfaceC0060b);
                            } else if (z11 && !constraintWidget3.m0()) {
                                f(i14, interfaceC0060b, constraintWidget3);
                            }
                        }
                    }
                } else if (constraintWidget3.V() == dimensionBehaviour2 && constraintWidget3.D >= 0 && constraintWidget3.C >= 0 && (constraintWidget3.X() == 8 || (constraintWidget3.f6977x == 0 && constraintWidget3.x() == 0.0f))) {
                    if (!constraintWidget3.m0() && !constraintWidget3.n0() && z11 && !constraintWidget3.m0()) {
                        g(i14, constraintWidget, interfaceC0060b, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor q13 = constraintWidget.q(ConstraintAnchor.Type.BASELINE);
        if (q13.d() != null && q13.n()) {
            int e13 = q13.e();
            Iterator it3 = q13.d().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor constraintAnchor11 = (ConstraintAnchor) it3.next();
                ConstraintWidget constraintWidget4 = constraintAnchor11.f6924d;
                int i15 = i11 + 1;
                boolean a13 = a(i15, constraintWidget4);
                if (constraintWidget4.o0() && a13) {
                    androidx.constraintlayout.core.widgets.d.X1(i15, constraintWidget4, interfaceC0060b, new b.a(), b.a.f7012k);
                }
                if (constraintWidget4.V() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a13) {
                    if (!constraintWidget4.o0() && constraintAnchor11 == constraintWidget4.U) {
                        constraintWidget4.I0(constraintAnchor11.f() + e13);
                        i(i15, constraintWidget4, interfaceC0060b);
                    }
                }
            }
        }
        constraintWidget.t0();
    }
}
