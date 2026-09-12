package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes.dex */
public class j extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    private static int[] f7040k = new int[2];

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7041a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f7041a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7041a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7041a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f7005h.f6990e = DependencyNode.Type.LEFT;
        this.f7006i.f6990e = DependencyNode.Type.RIGHT;
        this.f7003f = 0;
    }

    private void q(int[] iArr, int i11, int i12, int i13, int i14, float f11, int i15) {
        int i16 = i12 - i11;
        int i17 = i14 - i13;
        if (i15 != -1) {
            if (i15 == 0) {
                iArr[0] = (int) ((i17 * f11) + 0.5f);
                iArr[1] = i17;
                return;
            } else {
                if (i15 != 1) {
                    return;
                }
                iArr[0] = i16;
                iArr[1] = (int) ((i16 * f11) + 0.5f);
                return;
            }
        }
        int i18 = (int) ((i17 * f11) + 0.5f);
        int i19 = (int) ((i16 / f11) + 0.5f);
        if (i18 <= i16) {
            iArr[0] = i18;
            iArr[1] = i17;
        } else if (i19 <= i17) {
            iArr[0] = i16;
            iArr[1] = i19;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x02ba, code lost:
    
        if (r14 != 1) goto L135;
     */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, u0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(u0.a r17) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.j.a(u0.a):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget M;
        ConstraintWidget M2;
        ConstraintWidget constraintWidget = this.f6999b;
        if (constraintWidget.f6931a) {
            this.f7002e.d(constraintWidget.Y());
        }
        if (this.f7002e.f6995j) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f7001d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour == dimensionBehaviour2 && (M = this.f6999b.M()) != null && (M.C() == ConstraintWidget.DimensionBehaviour.FIXED || M.C() == dimensionBehaviour2)) {
                b(this.f7005h, M.f6939e.f7005h, this.f6999b.Q.f());
                b(this.f7006i, M.f6939e.f7006i, -this.f6999b.S.f());
                return;
            }
        } else {
            ConstraintWidget.DimensionBehaviour C = this.f6999b.C();
            this.f7001d = C;
            if (C != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (C == dimensionBehaviour3 && (M2 = this.f6999b.M()) != null && (M2.C() == ConstraintWidget.DimensionBehaviour.FIXED || M2.C() == dimensionBehaviour3)) {
                    int Y = (M2.Y() - this.f6999b.Q.f()) - this.f6999b.S.f();
                    b(this.f7005h, M2.f6939e.f7005h, this.f6999b.Q.f());
                    b(this.f7006i, M2.f6939e.f7006i, -this.f6999b.S.f());
                    this.f7002e.d(Y);
                    return;
                }
                if (this.f7001d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f7002e.d(this.f6999b.Y());
                }
            }
        }
        e eVar = this.f7002e;
        if (eVar.f6995j) {
            ConstraintWidget constraintWidget2 = this.f6999b;
            if (constraintWidget2.f6931a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f6926f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f6926f != null) {
                    if (constraintWidget2.k0()) {
                        this.f7005h.f6991f = this.f6999b.Y[0].f();
                        this.f7006i.f6991f = -this.f6999b.Y[1].f();
                        return;
                    }
                    DependencyNode h11 = h(this.f6999b.Y[0]);
                    if (h11 != null) {
                        b(this.f7005h, h11, this.f6999b.Y[0].f());
                    }
                    DependencyNode h12 = h(this.f6999b.Y[1]);
                    if (h12 != null) {
                        b(this.f7006i, h12, -this.f6999b.Y[1].f());
                    }
                    this.f7005h.f6987b = true;
                    this.f7006i.f6987b = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode h13 = h(constraintAnchor);
                    if (h13 != null) {
                        b(this.f7005h, h13, this.f6999b.Y[0].f());
                        b(this.f7006i, this.f7005h, this.f7002e.f6992g);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.f6926f != null) {
                    DependencyNode h14 = h(constraintAnchor3);
                    if (h14 != null) {
                        b(this.f7006i, h14, -this.f6999b.Y[1].f());
                        b(this.f7005h, this.f7006i, -this.f7002e.f6992g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof t0.a) || constraintWidget2.M() == null || this.f6999b.q(ConstraintAnchor.Type.CENTER).f6926f != null) {
                    return;
                }
                b(this.f7005h, this.f6999b.M().f6939e.f7005h, this.f6999b.Z());
                b(this.f7006i, this.f7005h, this.f7002e.f6992g);
                return;
            }
        }
        if (this.f7001d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f6999b;
            int i11 = constraintWidget3.f6975w;
            if (i11 == 2) {
                ConstraintWidget M3 = constraintWidget3.M();
                if (M3 != null) {
                    e eVar2 = M3.f6941f.f7002e;
                    this.f7002e.f6997l.add(eVar2);
                    eVar2.f6996k.add(this.f7002e);
                    e eVar3 = this.f7002e;
                    eVar3.f6987b = true;
                    eVar3.f6996k.add(this.f7005h);
                    this.f7002e.f6996k.add(this.f7006i);
                }
            } else if (i11 == 3) {
                if (constraintWidget3.f6977x == 3) {
                    this.f7005h.f6986a = this;
                    this.f7006i.f6986a = this;
                    l lVar = constraintWidget3.f6941f;
                    lVar.f7005h.f6986a = this;
                    lVar.f7006i.f6986a = this;
                    eVar.f6986a = this;
                    if (constraintWidget3.m0()) {
                        this.f7002e.f6997l.add(this.f6999b.f6941f.f7002e);
                        this.f6999b.f6941f.f7002e.f6996k.add(this.f7002e);
                        l lVar2 = this.f6999b.f6941f;
                        lVar2.f7002e.f6986a = this;
                        this.f7002e.f6997l.add(lVar2.f7005h);
                        this.f7002e.f6997l.add(this.f6999b.f6941f.f7006i);
                        this.f6999b.f6941f.f7005h.f6996k.add(this.f7002e);
                        this.f6999b.f6941f.f7006i.f6996k.add(this.f7002e);
                    } else if (this.f6999b.k0()) {
                        this.f6999b.f6941f.f7002e.f6997l.add(this.f7002e);
                        this.f7002e.f6996k.add(this.f6999b.f6941f.f7002e);
                    } else {
                        this.f6999b.f6941f.f7002e.f6997l.add(this.f7002e);
                    }
                } else {
                    e eVar4 = constraintWidget3.f6941f.f7002e;
                    eVar.f6997l.add(eVar4);
                    eVar4.f6996k.add(this.f7002e);
                    this.f6999b.f6941f.f7005h.f6996k.add(this.f7002e);
                    this.f6999b.f6941f.f7006i.f6996k.add(this.f7002e);
                    e eVar5 = this.f7002e;
                    eVar5.f6987b = true;
                    eVar5.f6996k.add(this.f7005h);
                    this.f7002e.f6996k.add(this.f7006i);
                    this.f7005h.f6997l.add(this.f7002e);
                    this.f7006i.f6997l.add(this.f7002e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f6999b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.Y;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f6926f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f6926f != null) {
            if (constraintWidget4.k0()) {
                this.f7005h.f6991f = this.f6999b.Y[0].f();
                this.f7006i.f6991f = -this.f6999b.Y[1].f();
                return;
            }
            DependencyNode h15 = h(this.f6999b.Y[0]);
            DependencyNode h16 = h(this.f6999b.Y[1]);
            if (h15 != null) {
                h15.b(this);
            }
            if (h16 != null) {
                h16.b(this);
            }
            this.f7007j = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode h17 = h(constraintAnchor4);
            if (h17 != null) {
                b(this.f7005h, h17, this.f6999b.Y[0].f());
                c(this.f7006i, this.f7005h, 1, this.f7002e);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.f6926f != null) {
            DependencyNode h18 = h(constraintAnchor6);
            if (h18 != null) {
                b(this.f7006i, h18, -this.f6999b.Y[1].f());
                c(this.f7005h, this.f7006i, -1, this.f7002e);
                return;
            }
            return;
        }
        if ((constraintWidget4 instanceof t0.a) || constraintWidget4.M() == null) {
            return;
        }
        b(this.f7005h, this.f6999b.M().f6939e.f7005h, this.f6999b.Z());
        c(this.f7006i, this.f7005h, 1, this.f7002e);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f7005h;
        if (dependencyNode.f6995j) {
            this.f6999b.q1(dependencyNode.f6992g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f7000c = null;
        this.f7005h.c();
        this.f7006i.c();
        this.f7002e.c();
        this.f7004g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return this.f7001d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f6999b.f6975w == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f7004g = false;
        this.f7005h.c();
        this.f7005h.f6995j = false;
        this.f7006i.c();
        this.f7006i.f6995j = false;
        this.f7002e.f6995j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f6999b.v();
    }
}
