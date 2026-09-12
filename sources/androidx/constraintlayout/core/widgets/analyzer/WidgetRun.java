package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public abstract class WidgetRun implements u0.a {

    /* renamed from: a, reason: collision with root package name */
    public int f6998a;

    /* renamed from: b, reason: collision with root package name */
    ConstraintWidget f6999b;

    /* renamed from: c, reason: collision with root package name */
    k f7000c;

    /* renamed from: d, reason: collision with root package name */
    protected ConstraintWidget.DimensionBehaviour f7001d;

    /* renamed from: e, reason: collision with root package name */
    e f7002e = new e(this);

    /* renamed from: f, reason: collision with root package name */
    public int f7003f = 0;

    /* renamed from: g, reason: collision with root package name */
    boolean f7004g = false;

    /* renamed from: h, reason: collision with root package name */
    public DependencyNode f7005h = new DependencyNode(this);

    /* renamed from: i, reason: collision with root package name */
    public DependencyNode f7006i = new DependencyNode(this);

    /* renamed from: j, reason: collision with root package name */
    protected RunType f7007j = RunType.NONE;

    /* loaded from: classes.dex */
    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7008a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f7008a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7008a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7008a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7008a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7008a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f6999b = constraintWidget;
    }

    private void l(int i11, int i12) {
        int i13 = this.f6998a;
        if (i13 == 0) {
            this.f7002e.d(g(i12, i11));
            return;
        }
        if (i13 == 1) {
            this.f7002e.d(Math.min(g(this.f7002e.f7036m, i11), i12));
            return;
        }
        if (i13 == 2) {
            ConstraintWidget M = this.f6999b.M();
            if (M != null) {
                if ((i11 == 0 ? M.f6939e : M.f6941f).f7002e.f6995j) {
                    ConstraintWidget constraintWidget = this.f6999b;
                    this.f7002e.d(g((int) ((r9.f6992g * (i11 == 0 ? constraintWidget.B : constraintWidget.E)) + 0.5f), i11));
                    return;
                }
                return;
            }
            return;
        }
        if (i13 != 3) {
            return;
        }
        ConstraintWidget constraintWidget2 = this.f6999b;
        WidgetRun widgetRun = constraintWidget2.f6939e;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.f7001d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.f6998a == 3) {
            l lVar = constraintWidget2.f6941f;
            if (lVar.f7001d == dimensionBehaviour2 && lVar.f6998a == 3) {
                return;
            }
        }
        if (i11 == 0) {
            widgetRun = constraintWidget2.f6941f;
        }
        if (widgetRun.f7002e.f6995j) {
            float x10 = constraintWidget2.x();
            this.f7002e.d(i11 == 1 ? (int) ((widgetRun.f7002e.f6992g / x10) + 0.5f) : (int) ((x10 * widgetRun.f7002e.f6992g) + 0.5f));
        }
    }

    @Override // u0.a
    public abstract void a(u0.a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i11) {
        dependencyNode.f6997l.add(dependencyNode2);
        dependencyNode.f6991f = i11;
        dependencyNode2.f6996k.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i11, e eVar) {
        dependencyNode.f6997l.add(dependencyNode2);
        dependencyNode.f6997l.add(this.f7002e);
        dependencyNode.f6993h = i11;
        dependencyNode.f6994i = eVar;
        dependencyNode2.f6996k.add(dependencyNode);
        eVar.f6996k.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g(int i11, int i12) {
        int max;
        if (i12 == 0) {
            ConstraintWidget constraintWidget = this.f6999b;
            int i13 = constraintWidget.A;
            max = Math.max(constraintWidget.f6981z, i11);
            if (i13 > 0) {
                max = Math.min(i13, i11);
            }
            if (max == i11) {
                return i11;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f6999b;
            int i14 = constraintWidget2.D;
            max = Math.max(constraintWidget2.C, i11);
            if (i14 > 0) {
                max = Math.min(i14, i11);
            }
            if (max == i11) {
                return i11;
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f6926f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f6924d;
        int i11 = a.f7008a[constraintAnchor2.f6925e.ordinal()];
        if (i11 == 1) {
            return constraintWidget.f6939e.f7005h;
        }
        if (i11 == 2) {
            return constraintWidget.f6939e.f7006i;
        }
        if (i11 == 3) {
            return constraintWidget.f6941f.f7005h;
        }
        if (i11 == 4) {
            return constraintWidget.f6941f.f7050k;
        }
        if (i11 != 5) {
            return null;
        }
        return constraintWidget.f6941f.f7006i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i11) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f6926f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f6924d;
        WidgetRun widgetRun = i11 == 0 ? constraintWidget.f6939e : constraintWidget.f6941f;
        int i12 = a.f7008a[constraintAnchor2.f6925e.ordinal()];
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 != 3) {
                    if (i12 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f7006i;
        }
        return widgetRun.f7005h;
    }

    public long j() {
        if (this.f7002e.f6995j) {
            return r0.f6992g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f7004g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(u0.a aVar, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i11) {
        DependencyNode h11 = h(constraintAnchor);
        DependencyNode h12 = h(constraintAnchor2);
        if (h11.f6995j && h12.f6995j) {
            int f11 = h11.f6992g + constraintAnchor.f();
            int f12 = h12.f6992g - constraintAnchor2.f();
            int i12 = f12 - f11;
            if (!this.f7002e.f6995j && this.f7001d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i11, i12);
            }
            e eVar = this.f7002e;
            if (eVar.f6995j) {
                if (eVar.f6992g == i12) {
                    this.f7005h.d(f11);
                    this.f7006i.d(f12);
                    return;
                }
                ConstraintWidget constraintWidget = this.f6999b;
                float A = i11 == 0 ? constraintWidget.A() : constraintWidget.T();
                if (h11 == h12) {
                    f11 = h11.f6992g;
                    f12 = h12.f6992g;
                    A = 0.5f;
                }
                this.f7005h.d((int) (f11 + 0.5f + (((f12 - f11) - this.f7002e.f6992g) * A)));
                this.f7006i.d(this.f7005h.f6992g + this.f7002e.f6992g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(u0.a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(u0.a aVar) {
    }
}
