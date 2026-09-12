package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.d f7027a;

    /* renamed from: d, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.d f7030d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7028b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7029c = true;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f7031e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList f7032f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private b.InterfaceC0060b f7033g = null;

    /* renamed from: h, reason: collision with root package name */
    private b.a f7034h = new b.a();

    /* renamed from: i, reason: collision with root package name */
    ArrayList f7035i = new ArrayList();

    public d(androidx.constraintlayout.core.widgets.d dVar) {
        this.f7027a = dVar;
        this.f7030d = dVar;
    }

    private void a(DependencyNode dependencyNode, int i11, int i12, DependencyNode dependencyNode2, ArrayList arrayList, k kVar) {
        WidgetRun widgetRun = dependencyNode.f6989d;
        if (widgetRun.f7000c == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.f7027a;
            if (widgetRun == dVar.f6939e || widgetRun == dVar.f6941f) {
                return;
            }
            if (kVar == null) {
                kVar = new k(widgetRun, i12);
                arrayList.add(kVar);
            }
            widgetRun.f7000c = kVar;
            kVar.a(widgetRun);
            for (u0.a aVar : widgetRun.f7005h.f6996k) {
                if (aVar instanceof DependencyNode) {
                    a((DependencyNode) aVar, i11, 0, dependencyNode2, arrayList, kVar);
                }
            }
            for (u0.a aVar2 : widgetRun.f7006i.f6996k) {
                if (aVar2 instanceof DependencyNode) {
                    a((DependencyNode) aVar2, i11, 1, dependencyNode2, arrayList, kVar);
                }
            }
            if (i11 == 1 && (widgetRun instanceof l)) {
                for (u0.a aVar3 : ((l) widgetRun).f7050k.f6996k) {
                    if (aVar3 instanceof DependencyNode) {
                        a((DependencyNode) aVar3, i11, 2, dependencyNode2, arrayList, kVar);
                    }
                }
            }
            for (DependencyNode dependencyNode3 : widgetRun.f7005h.f6997l) {
                if (dependencyNode3 == dependencyNode2) {
                    kVar.f7044b = true;
                }
                a(dependencyNode3, i11, 0, dependencyNode2, arrayList, kVar);
            }
            for (DependencyNode dependencyNode4 : widgetRun.f7006i.f6997l) {
                if (dependencyNode4 == dependencyNode2) {
                    kVar.f7044b = true;
                }
                a(dependencyNode4, i11, 1, dependencyNode2, arrayList, kVar);
            }
            if (i11 == 1 && (widgetRun instanceof l)) {
                Iterator it = ((l) widgetRun).f7050k.f6997l.iterator();
                while (it.hasNext()) {
                    a((DependencyNode) it.next(), i11, 2, dependencyNode2, arrayList, kVar);
                }
            }
        }
    }

    private boolean b(androidx.constraintlayout.core.widgets.d dVar) {
        int i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i12;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        Iterator it = dVar.V0.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f6934b0;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[1];
            if (constraintWidget.X() == 8) {
                constraintWidget.f6931a = true;
            } else {
                if (constraintWidget.B < 1.0f && dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.f6975w = 2;
                }
                if (constraintWidget.E < 1.0f && dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.f6977x = 2;
                }
                if (constraintWidget.x() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour5 == dimensionBehaviour7 && (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.f6975w = 3;
                    } else if (dimensionBehaviour6 == dimensionBehaviour7 && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.f6977x = 3;
                    } else if (dimensionBehaviour5 == dimensionBehaviour7 && dimensionBehaviour6 == dimensionBehaviour7) {
                        if (constraintWidget.f6975w == 0) {
                            constraintWidget.f6975w = 3;
                        }
                        if (constraintWidget.f6977x == 0) {
                            constraintWidget.f6977x = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour5 == dimensionBehaviour8 && constraintWidget.f6975w == 1 && (constraintWidget.Q.f6926f == null || constraintWidget.S.f6926f == null)) {
                    dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = dimensionBehaviour5;
                if (dimensionBehaviour6 == dimensionBehaviour8 && constraintWidget.f6977x == 1 && (constraintWidget.R.f6926f == null || constraintWidget.T.f6926f == null)) {
                    dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = dimensionBehaviour6;
                j jVar = constraintWidget.f6939e;
                jVar.f7001d = dimensionBehaviour9;
                int i13 = constraintWidget.f6975w;
                jVar.f6998a = i13;
                l lVar = constraintWidget.f6941f;
                lVar.f7001d = dimensionBehaviour10;
                int i14 = constraintWidget.f6977x;
                lVar.f6998a = i14;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour9 == dimensionBehaviour11 || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour10 == dimensionBehaviour11 || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int Y = constraintWidget.Y();
                    if (dimensionBehaviour9 == dimensionBehaviour11) {
                        i11 = (dVar.Y() - constraintWidget.Q.f6927g) - constraintWidget.S.f6927g;
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i11 = Y;
                        dimensionBehaviour = dimensionBehaviour9;
                    }
                    int z10 = constraintWidget.z();
                    if (dimensionBehaviour10 == dimensionBehaviour11) {
                        i12 = (dVar.z() - constraintWidget.R.f6927g) - constraintWidget.T.f6927g;
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i12 = z10;
                        dimensionBehaviour2 = dimensionBehaviour10;
                    }
                    l(constraintWidget, dimensionBehaviour, i11, dimensionBehaviour2, i12);
                    constraintWidget.f6939e.f7002e.d(constraintWidget.Y());
                    constraintWidget.f6941f.f7002e.d(constraintWidget.z());
                    constraintWidget.f6931a = true;
                } else {
                    if (dimensionBehaviour9 == dimensionBehaviour8 && (dimensionBehaviour10 == (dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i13 == 3) {
                            if (dimensionBehaviour10 == dimensionBehaviour4) {
                                l(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour4, 0);
                            }
                            int z11 = constraintWidget.z();
                            int i15 = (int) ((z11 * constraintWidget.f6942f0) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(constraintWidget, dimensionBehaviour12, i15, dimensionBehaviour12, z11);
                            constraintWidget.f6939e.f7002e.d(constraintWidget.Y());
                            constraintWidget.f6941f.f7002e.d(constraintWidget.z());
                            constraintWidget.f6931a = true;
                        } else if (i13 == 1) {
                            l(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour10, 0);
                            constraintWidget.f6939e.f7002e.f7036m = constraintWidget.Y();
                        } else if (i13 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = dVar.f6934b0[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour13 == dimensionBehaviour14 || dimensionBehaviour13 == dimensionBehaviour11) {
                                l(constraintWidget, dimensionBehaviour14, (int) ((constraintWidget.B * dVar.Y()) + 0.5f), dimensionBehaviour10, constraintWidget.z());
                                constraintWidget.f6939e.f7002e.d(constraintWidget.Y());
                                constraintWidget.f6941f.f7002e.d(constraintWidget.z());
                                constraintWidget.f6931a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = constraintWidget.Y;
                            if (constraintAnchorArr[0].f6926f == null || constraintAnchorArr[1].f6926f == null) {
                                l(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour10, 0);
                                constraintWidget.f6939e.f7002e.d(constraintWidget.Y());
                                constraintWidget.f6941f.f7002e.d(constraintWidget.z());
                                constraintWidget.f6931a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour10 == dimensionBehaviour8 && (dimensionBehaviour9 == (dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i14 == 3) {
                            if (dimensionBehaviour9 == dimensionBehaviour3) {
                                l(constraintWidget, dimensionBehaviour3, 0, dimensionBehaviour3, 0);
                            }
                            int Y2 = constraintWidget.Y();
                            float f11 = constraintWidget.f6942f0;
                            if (constraintWidget.y() == -1) {
                                f11 = 1.0f / f11;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(constraintWidget, dimensionBehaviour15, Y2, dimensionBehaviour15, (int) ((Y2 * f11) + 0.5f));
                            constraintWidget.f6939e.f7002e.d(constraintWidget.Y());
                            constraintWidget.f6941f.f7002e.d(constraintWidget.z());
                            constraintWidget.f6931a = true;
                        } else if (i14 == 1) {
                            l(constraintWidget, dimensionBehaviour9, 0, dimensionBehaviour3, 0);
                            constraintWidget.f6941f.f7002e.f7036m = constraintWidget.z();
                        } else if (i14 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = dVar.f6934b0[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour16 == dimensionBehaviour17 || dimensionBehaviour16 == dimensionBehaviour11) {
                                l(constraintWidget, dimensionBehaviour9, constraintWidget.Y(), dimensionBehaviour17, (int) ((constraintWidget.E * dVar.z()) + 0.5f));
                                constraintWidget.f6939e.f7002e.d(constraintWidget.Y());
                                constraintWidget.f6941f.f7002e.d(constraintWidget.z());
                                constraintWidget.f6931a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.Y;
                            if (constraintAnchorArr2[2].f6926f == null || constraintAnchorArr2[3].f6926f == null) {
                                l(constraintWidget, dimensionBehaviour3, 0, dimensionBehaviour10, 0);
                                constraintWidget.f6939e.f7002e.d(constraintWidget.Y());
                                constraintWidget.f6941f.f7002e.d(constraintWidget.z());
                                constraintWidget.f6931a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour9 == dimensionBehaviour8 && dimensionBehaviour10 == dimensionBehaviour8) {
                        if (i13 == 1 || i14 == 1) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            l(constraintWidget, dimensionBehaviour18, 0, dimensionBehaviour18, 0);
                            constraintWidget.f6939e.f7002e.f7036m = constraintWidget.Y();
                            constraintWidget.f6941f.f7002e.f7036m = constraintWidget.z();
                        } else if (i14 == 2 && i13 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dVar.f6934b0;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = dimensionBehaviourArr2[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour19 == dimensionBehaviour20 && dimensionBehaviourArr2[1] == dimensionBehaviour20) {
                                l(constraintWidget, dimensionBehaviour20, (int) ((constraintWidget.B * dVar.Y()) + 0.5f), dimensionBehaviour20, (int) ((constraintWidget.E * dVar.z()) + 0.5f));
                                constraintWidget.f6939e.f7002e.d(constraintWidget.Y());
                                constraintWidget.f6941f.f7002e.d(constraintWidget.z());
                                constraintWidget.f6931a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(androidx.constraintlayout.core.widgets.d dVar, int i11) {
        int size = this.f7035i.size();
        long j11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            j11 = Math.max(j11, ((k) this.f7035i.get(i12)).b(dVar, i11));
        }
        return (int) j11;
    }

    private void i(WidgetRun widgetRun, int i11, ArrayList arrayList) {
        for (u0.a aVar : widgetRun.f7005h.f6996k) {
            if (aVar instanceof DependencyNode) {
                a((DependencyNode) aVar, i11, 0, widgetRun.f7006i, arrayList, null);
            } else if (aVar instanceof WidgetRun) {
                a(((WidgetRun) aVar).f7005h, i11, 0, widgetRun.f7006i, arrayList, null);
            }
        }
        for (u0.a aVar2 : widgetRun.f7006i.f6996k) {
            if (aVar2 instanceof DependencyNode) {
                a((DependencyNode) aVar2, i11, 1, widgetRun.f7005h, arrayList, null);
            } else if (aVar2 instanceof WidgetRun) {
                a(((WidgetRun) aVar2).f7006i, i11, 1, widgetRun.f7005h, arrayList, null);
            }
        }
        if (i11 == 1) {
            for (u0.a aVar3 : ((l) widgetRun).f7050k.f6996k) {
                if (aVar3 instanceof DependencyNode) {
                    a((DependencyNode) aVar3, i11, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i11, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i12) {
        b.a aVar = this.f7034h;
        aVar.f7015a = dimensionBehaviour;
        aVar.f7016b = dimensionBehaviour2;
        aVar.f7017c = i11;
        aVar.f7018d = i12;
        this.f7033g.b(constraintWidget, aVar);
        constraintWidget.o1(this.f7034h.f7019e);
        constraintWidget.P0(this.f7034h.f7020f);
        constraintWidget.O0(this.f7034h.f7022h);
        constraintWidget.E0(this.f7034h.f7021g);
    }

    public void c() {
        d(this.f7031e);
        this.f7035i.clear();
        k.f7042h = 0;
        i(this.f7027a.f6939e, 0, this.f7035i);
        i(this.f7027a.f6941f, 1, this.f7035i);
        this.f7028b = false;
    }

    public void d(ArrayList arrayList) {
        arrayList.clear();
        this.f7030d.f6939e.f();
        this.f7030d.f6941f.f();
        arrayList.add(this.f7030d.f6939e);
        arrayList.add(this.f7030d.f6941f);
        Iterator it = this.f7030d.V0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                arrayList.add(new h(constraintWidget));
            } else {
                if (constraintWidget.k0()) {
                    if (constraintWidget.f6935c == null) {
                        constraintWidget.f6935c = new c(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f6935c);
                } else {
                    arrayList.add(constraintWidget.f6939e);
                }
                if (constraintWidget.m0()) {
                    if (constraintWidget.f6937d == null) {
                        constraintWidget.f6937d = new c(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f6937d);
                } else {
                    arrayList.add(constraintWidget.f6941f);
                }
                if (constraintWidget instanceof t0.b) {
                    arrayList.add(new i(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((WidgetRun) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it3.next();
            if (widgetRun.f6999b != this.f7030d) {
                widgetRun.d();
            }
        }
    }

    public boolean f(boolean z10) {
        boolean z11;
        boolean z12 = false;
        if (this.f7028b || this.f7029c) {
            Iterator it = this.f7027a.V0.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                constraintWidget.p();
                constraintWidget.f6931a = false;
                constraintWidget.f6939e.r();
                constraintWidget.f6941f.q();
            }
            this.f7027a.p();
            androidx.constraintlayout.core.widgets.d dVar = this.f7027a;
            dVar.f6931a = false;
            dVar.f6939e.r();
            this.f7027a.f6941f.q();
            this.f7029c = false;
        }
        if (b(this.f7030d)) {
            return false;
        }
        this.f7027a.q1(0);
        this.f7027a.r1(0);
        ConstraintWidget.DimensionBehaviour w11 = this.f7027a.w(0);
        ConstraintWidget.DimensionBehaviour w12 = this.f7027a.w(1);
        if (this.f7028b) {
            c();
        }
        int Z = this.f7027a.Z();
        int a02 = this.f7027a.a0();
        this.f7027a.f6939e.f7005h.d(Z);
        this.f7027a.f6941f.f7005h.d(a02);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (w11 == dimensionBehaviour || w12 == dimensionBehaviour) {
            if (z10) {
                Iterator it2 = this.f7031e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!((WidgetRun) it2.next()).m()) {
                        z10 = false;
                        break;
                    }
                }
            }
            if (z10 && w11 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f7027a.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar2 = this.f7027a;
                dVar2.o1(e(dVar2, 0));
                androidx.constraintlayout.core.widgets.d dVar3 = this.f7027a;
                dVar3.f6939e.f7002e.d(dVar3.Y());
            }
            if (z10 && w12 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f7027a.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar4 = this.f7027a;
                dVar4.P0(e(dVar4, 1));
                androidx.constraintlayout.core.widgets.d dVar5 = this.f7027a;
                dVar5.f6941f.f7002e.d(dVar5.z());
            }
        }
        androidx.constraintlayout.core.widgets.d dVar6 = this.f7027a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar6.f6934b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int Y = dVar6.Y() + Z;
            this.f7027a.f6939e.f7006i.d(Y);
            this.f7027a.f6939e.f7002e.d(Y - Z);
            m();
            androidx.constraintlayout.core.widgets.d dVar7 = this.f7027a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dVar7.f6934b0[1];
            if (dimensionBehaviour4 == dimensionBehaviour3 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int z13 = dVar7.z() + a02;
                this.f7027a.f6941f.f7006i.d(z13);
                this.f7027a.f6941f.f7002e.d(z13 - a02);
            }
            m();
            z11 = true;
        } else {
            z11 = false;
        }
        Iterator it3 = this.f7031e.iterator();
        while (it3.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it3.next();
            if (widgetRun.f6999b != this.f7027a || widgetRun.f7004g) {
                widgetRun.e();
            }
        }
        Iterator it4 = this.f7031e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z12 = true;
                break;
            }
            WidgetRun widgetRun2 = (WidgetRun) it4.next();
            if (z11 || widgetRun2.f6999b != this.f7027a) {
                if (!widgetRun2.f7005h.f6995j) {
                    break;
                }
                if (!widgetRun2.f7006i.f6995j) {
                    if (!(widgetRun2 instanceof h)) {
                        break;
                    }
                }
                if (!widgetRun2.f7002e.f6995j && !(widgetRun2 instanceof c) && !(widgetRun2 instanceof h)) {
                    break;
                }
            }
        }
        this.f7027a.T0(w11);
        this.f7027a.k1(w12);
        return z12;
    }

    public boolean g(boolean z10) {
        if (this.f7028b) {
            Iterator it = this.f7027a.V0.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                constraintWidget.p();
                constraintWidget.f6931a = false;
                j jVar = constraintWidget.f6939e;
                jVar.f7002e.f6995j = false;
                jVar.f7004g = false;
                jVar.r();
                l lVar = constraintWidget.f6941f;
                lVar.f7002e.f6995j = false;
                lVar.f7004g = false;
                lVar.q();
            }
            this.f7027a.p();
            androidx.constraintlayout.core.widgets.d dVar = this.f7027a;
            dVar.f6931a = false;
            j jVar2 = dVar.f6939e;
            jVar2.f7002e.f6995j = false;
            jVar2.f7004g = false;
            jVar2.r();
            l lVar2 = this.f7027a.f6941f;
            lVar2.f7002e.f6995j = false;
            lVar2.f7004g = false;
            lVar2.q();
            c();
        }
        if (b(this.f7030d)) {
            return false;
        }
        this.f7027a.q1(0);
        this.f7027a.r1(0);
        this.f7027a.f6939e.f7005h.d(0);
        this.f7027a.f6941f.f7005h.d(0);
        return true;
    }

    public boolean h(boolean z10, int i11) {
        boolean z11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z12 = false;
        ConstraintWidget.DimensionBehaviour w11 = this.f7027a.w(0);
        ConstraintWidget.DimensionBehaviour w12 = this.f7027a.w(1);
        int Z = this.f7027a.Z();
        int a02 = this.f7027a.a0();
        if (z10 && (w11 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || w12 == dimensionBehaviour)) {
            Iterator it = this.f7031e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun widgetRun = (WidgetRun) it.next();
                if (widgetRun.f7003f == i11 && !widgetRun.m()) {
                    z10 = false;
                    break;
                }
            }
            if (i11 == 0) {
                if (z10 && w11 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.f7027a.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                    androidx.constraintlayout.core.widgets.d dVar = this.f7027a;
                    dVar.o1(e(dVar, 0));
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f7027a;
                    dVar2.f6939e.f7002e.d(dVar2.Y());
                }
            } else if (z10 && w12 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f7027a.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar3 = this.f7027a;
                dVar3.P0(e(dVar3, 1));
                androidx.constraintlayout.core.widgets.d dVar4 = this.f7027a;
                dVar4.f6941f.f7002e.d(dVar4.z());
            }
        }
        if (i11 == 0) {
            androidx.constraintlayout.core.widgets.d dVar5 = this.f7027a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar5.f6934b0[0];
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int Y = dVar5.Y() + Z;
                this.f7027a.f6939e.f7006i.d(Y);
                this.f7027a.f6939e.f7002e.d(Y - Z);
                z11 = true;
            }
            z11 = false;
        } else {
            androidx.constraintlayout.core.widgets.d dVar6 = this.f7027a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dVar6.f6934b0[1];
            if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int z13 = dVar6.z() + a02;
                this.f7027a.f6941f.f7006i.d(z13);
                this.f7027a.f6941f.f7002e.d(z13 - a02);
                z11 = true;
            }
            z11 = false;
        }
        m();
        Iterator it2 = this.f7031e.iterator();
        while (it2.hasNext()) {
            WidgetRun widgetRun2 = (WidgetRun) it2.next();
            if (widgetRun2.f7003f == i11 && (widgetRun2.f6999b != this.f7027a || widgetRun2.f7004g)) {
                widgetRun2.e();
            }
        }
        Iterator it3 = this.f7031e.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z12 = true;
                break;
            }
            WidgetRun widgetRun3 = (WidgetRun) it3.next();
            if (widgetRun3.f7003f == i11 && (z11 || widgetRun3.f6999b != this.f7027a)) {
                if (!widgetRun3.f7005h.f6995j) {
                    break;
                }
                if (!widgetRun3.f7006i.f6995j) {
                    break;
                }
                if (!(widgetRun3 instanceof c) && !widgetRun3.f7002e.f6995j) {
                    break;
                }
            }
        }
        this.f7027a.T0(w11);
        this.f7027a.k1(w12);
        return z12;
    }

    public void j() {
        this.f7028b = true;
    }

    public void k() {
        this.f7029c = true;
    }

    public void m() {
        e eVar;
        Iterator it = this.f7027a.V0.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            if (!constraintWidget.f6931a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f6934b0;
                boolean z10 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i11 = constraintWidget.f6975w;
                int i12 = constraintWidget.f6977x;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z11 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i11 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i12 == 1)) {
                    z10 = true;
                }
                e eVar2 = constraintWidget.f6939e.f7002e;
                boolean z12 = eVar2.f6995j;
                e eVar3 = constraintWidget.f6941f.f7002e;
                boolean z13 = eVar3.f6995j;
                if (z12 && z13) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    l(constraintWidget, dimensionBehaviour4, eVar2.f6992g, dimensionBehaviour4, eVar3.f6992g);
                    constraintWidget.f6931a = true;
                } else if (z12 && z10) {
                    l(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, eVar2.f6992g, dimensionBehaviour3, eVar3.f6992g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.f6941f.f7002e.f7036m = constraintWidget.z();
                    } else {
                        constraintWidget.f6941f.f7002e.d(constraintWidget.z());
                        constraintWidget.f6931a = true;
                    }
                } else if (z13 && z11) {
                    l(constraintWidget, dimensionBehaviour3, eVar2.f6992g, ConstraintWidget.DimensionBehaviour.FIXED, eVar3.f6992g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.f6939e.f7002e.f7036m = constraintWidget.Y();
                    } else {
                        constraintWidget.f6939e.f7002e.d(constraintWidget.Y());
                        constraintWidget.f6931a = true;
                    }
                }
                if (constraintWidget.f6931a && (eVar = constraintWidget.f6941f.f7051l) != null) {
                    eVar.d(constraintWidget.r());
                }
            }
        }
    }

    public void n(b.InterfaceC0060b interfaceC0060b) {
        this.f7033g = interfaceC0060b;
    }
}
