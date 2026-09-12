package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends WidgetRun {
    public h(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f6939e.f();
        constraintWidget.f6941f.f();
        this.f7003f = ((androidx.constraintlayout.core.widgets.f) constraintWidget).w1();
    }

    private void q(DependencyNode dependencyNode) {
        this.f7005h.f6996k.add(dependencyNode);
        dependencyNode.f6997l.add(this.f7005h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, u0.a
    public void a(u0.a aVar) {
        DependencyNode dependencyNode = this.f7005h;
        if (dependencyNode.f6988c && !dependencyNode.f6995j) {
            this.f7005h.d((int) ((((DependencyNode) dependencyNode.f6997l.get(0)).f6992g * ((androidx.constraintlayout.core.widgets.f) this.f6999b).z1()) + 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) this.f6999b;
        int x12 = fVar.x1();
        int y12 = fVar.y1();
        fVar.z1();
        if (fVar.w1() == 1) {
            if (x12 != -1) {
                this.f7005h.f6997l.add(this.f6999b.f6936c0.f6939e.f7005h);
                this.f6999b.f6936c0.f6939e.f7005h.f6996k.add(this.f7005h);
                this.f7005h.f6991f = x12;
            } else if (y12 != -1) {
                this.f7005h.f6997l.add(this.f6999b.f6936c0.f6939e.f7006i);
                this.f6999b.f6936c0.f6939e.f7006i.f6996k.add(this.f7005h);
                this.f7005h.f6991f = -y12;
            } else {
                DependencyNode dependencyNode = this.f7005h;
                dependencyNode.f6987b = true;
                dependencyNode.f6997l.add(this.f6999b.f6936c0.f6939e.f7006i);
                this.f6999b.f6936c0.f6939e.f7006i.f6996k.add(this.f7005h);
            }
            q(this.f6999b.f6939e.f7005h);
            q(this.f6999b.f6939e.f7006i);
            return;
        }
        if (x12 != -1) {
            this.f7005h.f6997l.add(this.f6999b.f6936c0.f6941f.f7005h);
            this.f6999b.f6936c0.f6941f.f7005h.f6996k.add(this.f7005h);
            this.f7005h.f6991f = x12;
        } else if (y12 != -1) {
            this.f7005h.f6997l.add(this.f6999b.f6936c0.f6941f.f7006i);
            this.f6999b.f6936c0.f6941f.f7006i.f6996k.add(this.f7005h);
            this.f7005h.f6991f = -y12;
        } else {
            DependencyNode dependencyNode2 = this.f7005h;
            dependencyNode2.f6987b = true;
            dependencyNode2.f6997l.add(this.f6999b.f6936c0.f6941f.f7006i);
            this.f6999b.f6936c0.f6941f.f7006i.f6996k.add(this.f7005h);
        }
        q(this.f6999b.f6941f.f7005h);
        q(this.f6999b.f6941f.f7006i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (((androidx.constraintlayout.core.widgets.f) this.f6999b).w1() == 1) {
            this.f6999b.q1(this.f7005h.f6992g);
        } else {
            this.f6999b.r1(this.f7005h.f6992g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f7005h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }
}
