package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected ConstraintWidget f7068a;

    /* renamed from: b, reason: collision with root package name */
    protected ConstraintWidget f7069b;

    /* renamed from: c, reason: collision with root package name */
    protected ConstraintWidget f7070c;

    /* renamed from: d, reason: collision with root package name */
    protected ConstraintWidget f7071d;

    /* renamed from: e, reason: collision with root package name */
    protected ConstraintWidget f7072e;

    /* renamed from: f, reason: collision with root package name */
    protected ConstraintWidget f7073f;

    /* renamed from: g, reason: collision with root package name */
    protected ConstraintWidget f7074g;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList f7075h;

    /* renamed from: i, reason: collision with root package name */
    protected int f7076i;

    /* renamed from: j, reason: collision with root package name */
    protected int f7077j;

    /* renamed from: k, reason: collision with root package name */
    protected float f7078k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    int f7079l;

    /* renamed from: m, reason: collision with root package name */
    int f7080m;

    /* renamed from: n, reason: collision with root package name */
    int f7081n;

    /* renamed from: o, reason: collision with root package name */
    boolean f7082o;

    /* renamed from: p, reason: collision with root package name */
    private int f7083p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7084q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f7085r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f7086s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f7087t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f7088u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f7089v;

    public c(ConstraintWidget constraintWidget, int i11, boolean z10) {
        this.f7068a = constraintWidget;
        this.f7083p = i11;
        this.f7084q = z10;
    }

    private void b() {
        int i11 = this.f7083p * 2;
        ConstraintWidget constraintWidget = this.f7068a;
        this.f7082o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z10 = false;
        while (!z10) {
            this.f7076i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.P0;
            int i12 = this.f7083p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i12] = null;
            constraintWidget.O0[i12] = null;
            if (constraintWidget.X() != 8) {
                this.f7079l++;
                ConstraintWidget.DimensionBehaviour w11 = constraintWidget.w(this.f7083p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (w11 != dimensionBehaviour) {
                    this.f7080m += constraintWidget.G(this.f7083p);
                }
                int f11 = this.f7080m + constraintWidget.Y[i11].f();
                this.f7080m = f11;
                int i13 = i11 + 1;
                this.f7080m = f11 + constraintWidget.Y[i13].f();
                int f12 = this.f7081n + constraintWidget.Y[i11].f();
                this.f7081n = f12;
                this.f7081n = f12 + constraintWidget.Y[i13].f();
                if (this.f7069b == null) {
                    this.f7069b = constraintWidget;
                }
                this.f7071d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f6934b0;
                int i14 = this.f7083p;
                if (dimensionBehaviourArr[i14] == dimensionBehaviour) {
                    int i15 = constraintWidget.f6979y[i14];
                    if (i15 == 0 || i15 == 3 || i15 == 2) {
                        this.f7077j++;
                        float f13 = constraintWidget.N0[i14];
                        if (f13 > 0.0f) {
                            this.f7078k += f13;
                        }
                        if (c(constraintWidget, i14)) {
                            if (f13 < 0.0f) {
                                this.f7085r = true;
                            } else {
                                this.f7086s = true;
                            }
                            if (this.f7075h == null) {
                                this.f7075h = new ArrayList();
                            }
                            this.f7075h.add(constraintWidget);
                        }
                        if (this.f7073f == null) {
                            this.f7073f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f7074g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.O0[this.f7083p] = constraintWidget;
                        }
                        this.f7074g = constraintWidget;
                    }
                    if (this.f7083p == 0) {
                        if (constraintWidget.f6975w != 0) {
                            this.f7082o = false;
                        } else if (constraintWidget.f6981z != 0 || constraintWidget.A != 0) {
                            this.f7082o = false;
                        }
                    } else if (constraintWidget.f6977x != 0) {
                        this.f7082o = false;
                    } else if (constraintWidget.C != 0 || constraintWidget.D != 0) {
                        this.f7082o = false;
                    }
                    if (constraintWidget.f6942f0 != 0.0f) {
                        this.f7082o = false;
                        this.f7088u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.P0[this.f7083p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.Y[i11 + 1].f6926f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f6924d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.Y[i11].f6926f;
                if (constraintAnchor2 != null && constraintAnchor2.f6924d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z10 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f7069b;
        if (constraintWidget6 != null) {
            this.f7080m -= constraintWidget6.Y[i11].f();
        }
        ConstraintWidget constraintWidget7 = this.f7071d;
        if (constraintWidget7 != null) {
            this.f7080m -= constraintWidget7.Y[i11 + 1].f();
        }
        this.f7070c = constraintWidget;
        if (this.f7083p == 0 && this.f7084q) {
            this.f7072e = constraintWidget;
        } else {
            this.f7072e = this.f7068a;
        }
        this.f7087t = this.f7086s && this.f7085r;
    }

    private static boolean c(ConstraintWidget constraintWidget, int i11) {
        int i12;
        return constraintWidget.X() != 8 && constraintWidget.f6934b0[i11] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((i12 = constraintWidget.f6979y[i11]) == 0 || i12 == 3);
    }

    public void a() {
        if (!this.f7089v) {
            b();
        }
        this.f7089v = true;
    }
}
