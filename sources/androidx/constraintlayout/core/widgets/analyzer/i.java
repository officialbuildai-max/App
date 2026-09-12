package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends WidgetRun {
    public i(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(DependencyNode dependencyNode) {
        this.f7005h.f6996k.add(dependencyNode);
        dependencyNode.f6997l.add(this.f7005h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, u0.a
    public void a(u0.a aVar) {
        androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) this.f6999b;
        int z12 = aVar2.z1();
        Iterator it = this.f7005h.f6997l.iterator();
        int i11 = 0;
        int i12 = -1;
        while (it.hasNext()) {
            int i13 = ((DependencyNode) it.next()).f6992g;
            if (i12 == -1 || i13 < i12) {
                i12 = i13;
            }
            if (i11 < i13) {
                i11 = i13;
            }
        }
        if (z12 == 0 || z12 == 2) {
            this.f7005h.d(i12 + aVar2.A1());
        } else {
            this.f7005h.d(i11 + aVar2.A1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidget = this.f6999b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            this.f7005h.f6987b = true;
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget;
            int z12 = aVar.z1();
            boolean y12 = aVar.y1();
            int i11 = 0;
            if (z12 == 0) {
                this.f7005h.f6990e = DependencyNode.Type.LEFT;
                while (i11 < aVar.W0) {
                    ConstraintWidget constraintWidget2 = aVar.V0[i11];
                    if (y12 || constraintWidget2.X() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.f6939e.f7005h;
                        dependencyNode.f6996k.add(this.f7005h);
                        this.f7005h.f6997l.add(dependencyNode);
                    }
                    i11++;
                }
                q(this.f6999b.f6939e.f7005h);
                q(this.f6999b.f6939e.f7006i);
                return;
            }
            if (z12 == 1) {
                this.f7005h.f6990e = DependencyNode.Type.RIGHT;
                while (i11 < aVar.W0) {
                    ConstraintWidget constraintWidget3 = aVar.V0[i11];
                    if (y12 || constraintWidget3.X() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.f6939e.f7006i;
                        dependencyNode2.f6996k.add(this.f7005h);
                        this.f7005h.f6997l.add(dependencyNode2);
                    }
                    i11++;
                }
                q(this.f6999b.f6939e.f7005h);
                q(this.f6999b.f6939e.f7006i);
                return;
            }
            if (z12 == 2) {
                this.f7005h.f6990e = DependencyNode.Type.TOP;
                while (i11 < aVar.W0) {
                    ConstraintWidget constraintWidget4 = aVar.V0[i11];
                    if (y12 || constraintWidget4.X() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f6941f.f7005h;
                        dependencyNode3.f6996k.add(this.f7005h);
                        this.f7005h.f6997l.add(dependencyNode3);
                    }
                    i11++;
                }
                q(this.f6999b.f6941f.f7005h);
                q(this.f6999b.f6941f.f7006i);
                return;
            }
            if (z12 != 3) {
                return;
            }
            this.f7005h.f6990e = DependencyNode.Type.BOTTOM;
            while (i11 < aVar.W0) {
                ConstraintWidget constraintWidget5 = aVar.V0[i11];
                if (y12 || constraintWidget5.X() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget5.f6941f.f7006i;
                    dependencyNode4.f6996k.add(this.f7005h);
                    this.f7005h.f6997l.add(dependencyNode4);
                }
                i11++;
            }
            q(this.f6999b.f6941f.f7005h);
            q(this.f6999b.f6941f.f7006i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        ConstraintWidget constraintWidget = this.f6999b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            int z12 = ((androidx.constraintlayout.core.widgets.a) constraintWidget).z1();
            if (z12 == 0 || z12 == 1) {
                this.f6999b.q1(this.f7005h.f6992g);
            } else {
                this.f6999b.r1(this.f7005h.f6992g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f7000c = null;
        this.f7005h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }
}
