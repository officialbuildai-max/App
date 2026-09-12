package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes.dex */
public class l extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public DependencyNode f7050k;

    /* renamed from: l, reason: collision with root package name */
    e f7051l;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7052a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f7052a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7052a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7052a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f7050k = dependencyNode;
        this.f7051l = null;
        this.f7005h.f6990e = DependencyNode.Type.TOP;
        this.f7006i.f6990e = DependencyNode.Type.BOTTOM;
        dependencyNode.f6990e = DependencyNode.Type.BASELINE;
        this.f7003f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, u0.a
    public void a(u0.a aVar) {
        float f11;
        float x10;
        float f12;
        int i11;
        int i12 = a.f7052a[this.f7007j.ordinal()];
        if (i12 == 1) {
            p(aVar);
        } else if (i12 == 2) {
            o(aVar);
        } else if (i12 == 3) {
            ConstraintWidget constraintWidget = this.f6999b;
            n(aVar, constraintWidget.R, constraintWidget.T, 1);
            return;
        }
        e eVar = this.f7002e;
        if (eVar.f6988c && !eVar.f6995j && this.f7001d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f6999b;
            int i13 = constraintWidget2.f6977x;
            if (i13 == 2) {
                ConstraintWidget M = constraintWidget2.M();
                if (M != null) {
                    if (M.f6941f.f7002e.f6995j) {
                        this.f7002e.d((int) ((r7.f6992g * this.f6999b.E) + 0.5f));
                    }
                }
            } else if (i13 == 3 && constraintWidget2.f6939e.f7002e.f6995j) {
                int y10 = constraintWidget2.y();
                if (y10 == -1) {
                    ConstraintWidget constraintWidget3 = this.f6999b;
                    f11 = constraintWidget3.f6939e.f7002e.f6992g;
                    x10 = constraintWidget3.x();
                } else if (y10 == 0) {
                    f12 = r7.f6939e.f7002e.f6992g * this.f6999b.x();
                    i11 = (int) (f12 + 0.5f);
                    this.f7002e.d(i11);
                } else if (y10 != 1) {
                    i11 = 0;
                    this.f7002e.d(i11);
                } else {
                    ConstraintWidget constraintWidget4 = this.f6999b;
                    f11 = constraintWidget4.f6939e.f7002e.f6992g;
                    x10 = constraintWidget4.x();
                }
                f12 = f11 / x10;
                i11 = (int) (f12 + 0.5f);
                this.f7002e.d(i11);
            }
        }
        DependencyNode dependencyNode = this.f7005h;
        if (dependencyNode.f6988c) {
            DependencyNode dependencyNode2 = this.f7006i;
            if (dependencyNode2.f6988c) {
                if (dependencyNode.f6995j && dependencyNode2.f6995j && this.f7002e.f6995j) {
                    return;
                }
                if (!this.f7002e.f6995j && this.f7001d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget5 = this.f6999b;
                    if (constraintWidget5.f6975w == 0 && !constraintWidget5.m0()) {
                        DependencyNode dependencyNode3 = (DependencyNode) this.f7005h.f6997l.get(0);
                        DependencyNode dependencyNode4 = (DependencyNode) this.f7006i.f6997l.get(0);
                        int i14 = dependencyNode3.f6992g;
                        DependencyNode dependencyNode5 = this.f7005h;
                        int i15 = i14 + dependencyNode5.f6991f;
                        int i16 = dependencyNode4.f6992g + this.f7006i.f6991f;
                        dependencyNode5.d(i15);
                        this.f7006i.d(i16);
                        this.f7002e.d(i16 - i15);
                        return;
                    }
                }
                if (!this.f7002e.f6995j && this.f7001d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f6998a == 1 && this.f7005h.f6997l.size() > 0 && this.f7006i.f6997l.size() > 0) {
                    DependencyNode dependencyNode6 = (DependencyNode) this.f7005h.f6997l.get(0);
                    int i17 = (((DependencyNode) this.f7006i.f6997l.get(0)).f6992g + this.f7006i.f6991f) - (dependencyNode6.f6992g + this.f7005h.f6991f);
                    e eVar2 = this.f7002e;
                    int i18 = eVar2.f7036m;
                    if (i17 < i18) {
                        eVar2.d(i17);
                    } else {
                        eVar2.d(i18);
                    }
                }
                if (this.f7002e.f6995j && this.f7005h.f6997l.size() > 0 && this.f7006i.f6997l.size() > 0) {
                    DependencyNode dependencyNode7 = (DependencyNode) this.f7005h.f6997l.get(0);
                    DependencyNode dependencyNode8 = (DependencyNode) this.f7006i.f6997l.get(0);
                    int i19 = dependencyNode7.f6992g + this.f7005h.f6991f;
                    int i20 = dependencyNode8.f6992g + this.f7006i.f6991f;
                    float T = this.f6999b.T();
                    if (dependencyNode7 == dependencyNode8) {
                        i19 = dependencyNode7.f6992g;
                        i20 = dependencyNode8.f6992g;
                        T = 0.5f;
                    }
                    this.f7005h.d((int) (i19 + 0.5f + (((i20 - i19) - this.f7002e.f6992g) * T)));
                    this.f7006i.d(this.f7005h.f6992g + this.f7002e.f6992g);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget M;
        ConstraintWidget M2;
        ConstraintWidget constraintWidget = this.f6999b;
        if (constraintWidget.f6931a) {
            this.f7002e.d(constraintWidget.z());
        }
        if (!this.f7002e.f6995j) {
            this.f7001d = this.f6999b.V();
            if (this.f6999b.b0()) {
                this.f7051l = new androidx.constraintlayout.core.widgets.analyzer.a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f7001d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (M2 = this.f6999b.M()) != null && M2.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int z10 = (M2.z() - this.f6999b.R.f()) - this.f6999b.T.f();
                    b(this.f7005h, M2.f6941f.f7005h, this.f6999b.R.f());
                    b(this.f7006i, M2.f6941f.f7006i, -this.f6999b.T.f());
                    this.f7002e.d(z10);
                    return;
                }
                if (this.f7001d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f7002e.d(this.f6999b.z());
                }
            }
        } else if (this.f7001d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (M = this.f6999b.M()) != null && M.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f7005h, M.f6941f.f7005h, this.f6999b.R.f());
            b(this.f7006i, M.f6941f.f7006i, -this.f6999b.T.f());
            return;
        }
        e eVar = this.f7002e;
        boolean z11 = eVar.f6995j;
        if (z11) {
            ConstraintWidget constraintWidget2 = this.f6999b;
            if (constraintWidget2.f6931a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f6926f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f6926f != null) {
                    if (constraintWidget2.m0()) {
                        this.f7005h.f6991f = this.f6999b.Y[2].f();
                        this.f7006i.f6991f = -this.f6999b.Y[3].f();
                    } else {
                        DependencyNode h11 = h(this.f6999b.Y[2]);
                        if (h11 != null) {
                            b(this.f7005h, h11, this.f6999b.Y[2].f());
                        }
                        DependencyNode h12 = h(this.f6999b.Y[3]);
                        if (h12 != null) {
                            b(this.f7006i, h12, -this.f6999b.Y[3].f());
                        }
                        this.f7005h.f6987b = true;
                        this.f7006i.f6987b = true;
                    }
                    if (this.f6999b.b0()) {
                        b(this.f7050k, this.f7005h, this.f6999b.r());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode h13 = h(constraintAnchor);
                    if (h13 != null) {
                        b(this.f7005h, h13, this.f6999b.Y[2].f());
                        b(this.f7006i, this.f7005h, this.f7002e.f6992g);
                        if (this.f6999b.b0()) {
                            b(this.f7050k, this.f7005h, this.f6999b.r());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.f6926f != null) {
                    DependencyNode h14 = h(constraintAnchor3);
                    if (h14 != null) {
                        b(this.f7006i, h14, -this.f6999b.Y[3].f());
                        b(this.f7005h, this.f7006i, -this.f7002e.f6992g);
                    }
                    if (this.f6999b.b0()) {
                        b(this.f7050k, this.f7005h, this.f6999b.r());
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.f6926f != null) {
                    DependencyNode h15 = h(constraintAnchor4);
                    if (h15 != null) {
                        b(this.f7050k, h15, 0);
                        b(this.f7005h, this.f7050k, -this.f6999b.r());
                        b(this.f7006i, this.f7005h, this.f7002e.f6992g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof t0.a) || constraintWidget2.M() == null || this.f6999b.q(ConstraintAnchor.Type.CENTER).f6926f != null) {
                    return;
                }
                b(this.f7005h, this.f6999b.M().f6941f.f7005h, this.f6999b.a0());
                b(this.f7006i, this.f7005h, this.f7002e.f6992g);
                if (this.f6999b.b0()) {
                    b(this.f7050k, this.f7005h, this.f6999b.r());
                    return;
                }
                return;
            }
        }
        if (z11 || this.f7001d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            eVar.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f6999b;
            int i11 = constraintWidget3.f6977x;
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
            } else if (i11 == 3 && !constraintWidget3.m0()) {
                ConstraintWidget constraintWidget4 = this.f6999b;
                if (constraintWidget4.f6975w != 3) {
                    e eVar4 = constraintWidget4.f6939e.f7002e;
                    this.f7002e.f6997l.add(eVar4);
                    eVar4.f6996k.add(this.f7002e);
                    e eVar5 = this.f7002e;
                    eVar5.f6987b = true;
                    eVar5.f6996k.add(this.f7005h);
                    this.f7002e.f6996k.add(this.f7006i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f6999b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.Y;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f6926f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f6926f != null) {
            if (constraintWidget5.m0()) {
                this.f7005h.f6991f = this.f6999b.Y[2].f();
                this.f7006i.f6991f = -this.f6999b.Y[3].f();
            } else {
                DependencyNode h16 = h(this.f6999b.Y[2]);
                DependencyNode h17 = h(this.f6999b.Y[3]);
                if (h16 != null) {
                    h16.b(this);
                }
                if (h17 != null) {
                    h17.b(this);
                }
                this.f7007j = WidgetRun.RunType.CENTER;
            }
            if (this.f6999b.b0()) {
                c(this.f7050k, this.f7005h, 1, this.f7051l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode h18 = h(constraintAnchor5);
            if (h18 != null) {
                b(this.f7005h, h18, this.f6999b.Y[2].f());
                c(this.f7006i, this.f7005h, 1, this.f7002e);
                if (this.f6999b.b0()) {
                    c(this.f7050k, this.f7005h, 1, this.f7051l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f7001d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f6999b.x() > 0.0f) {
                    j jVar = this.f6999b.f6939e;
                    if (jVar.f7001d == dimensionBehaviour3) {
                        jVar.f7002e.f6996k.add(this.f7002e);
                        this.f7002e.f6997l.add(this.f6999b.f6939e.f7002e);
                        this.f7002e.f6986a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f6926f != null) {
                DependencyNode h19 = h(constraintAnchor7);
                if (h19 != null) {
                    b(this.f7006i, h19, -this.f6999b.Y[3].f());
                    c(this.f7005h, this.f7006i, -1, this.f7002e);
                    if (this.f6999b.b0()) {
                        c(this.f7050k, this.f7005h, 1, this.f7051l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f6926f != null) {
                    DependencyNode h20 = h(constraintAnchor8);
                    if (h20 != null) {
                        b(this.f7050k, h20, 0);
                        c(this.f7005h, this.f7050k, -1, this.f7051l);
                        c(this.f7006i, this.f7005h, 1, this.f7002e);
                    }
                } else if (!(constraintWidget5 instanceof t0.a) && constraintWidget5.M() != null) {
                    b(this.f7005h, this.f6999b.M().f6941f.f7005h, this.f6999b.a0());
                    c(this.f7006i, this.f7005h, 1, this.f7002e);
                    if (this.f6999b.b0()) {
                        c(this.f7050k, this.f7005h, 1, this.f7051l);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f7001d;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.f6999b.x() > 0.0f) {
                        j jVar2 = this.f6999b.f6939e;
                        if (jVar2.f7001d == dimensionBehaviour5) {
                            jVar2.f7002e.f6996k.add(this.f7002e);
                            this.f7002e.f6997l.add(this.f6999b.f6939e.f7002e);
                            this.f7002e.f6986a = this;
                        }
                    }
                }
            }
        }
        if (this.f7002e.f6997l.size() == 0) {
            this.f7002e.f6988c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f7005h;
        if (dependencyNode.f6995j) {
            this.f6999b.r1(dependencyNode.f6992g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f7000c = null;
        this.f7005h.c();
        this.f7006i.c();
        this.f7050k.c();
        this.f7002e.c();
        this.f7004g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return this.f7001d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f6999b.f6977x == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f7004g = false;
        this.f7005h.c();
        this.f7005h.f6995j = false;
        this.f7006i.c();
        this.f7006i.f6995j = false;
        this.f7050k.c();
        this.f7050k.f6995j = false;
        this.f7002e.f6995j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f6999b.v();
    }
}
