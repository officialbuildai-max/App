package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    ArrayList f7025k;

    /* renamed from: l, reason: collision with root package name */
    private int f7026l;

    public c(ConstraintWidget constraintWidget, int i11) {
        super(constraintWidget);
        this.f7025k = new ArrayList();
        this.f7003f = i11;
        q();
    }

    private void q() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.f6999b;
        ConstraintWidget N = constraintWidget2.N(this.f7003f);
        while (true) {
            ConstraintWidget constraintWidget3 = N;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                N = constraintWidget2.N(this.f7003f);
            }
        }
        this.f6999b = constraintWidget;
        this.f7025k.add(constraintWidget.P(this.f7003f));
        ConstraintWidget L = constraintWidget.L(this.f7003f);
        while (L != null) {
            this.f7025k.add(L.P(this.f7003f));
            L = L.L(this.f7003f);
        }
        Iterator it = this.f7025k.iterator();
        while (it.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it.next();
            int i11 = this.f7003f;
            if (i11 == 0) {
                widgetRun.f6999b.f6935c = this;
            } else if (i11 == 1) {
                widgetRun.f6999b.f6937d = this;
            }
        }
        if (this.f7003f == 0 && ((androidx.constraintlayout.core.widgets.d) this.f6999b.M()).U1() && this.f7025k.size() > 1) {
            ArrayList arrayList = this.f7025k;
            this.f6999b = ((WidgetRun) arrayList.get(arrayList.size() - 1)).f6999b;
        }
        this.f7026l = this.f7003f == 0 ? this.f6999b.B() : this.f6999b.U();
    }

    private ConstraintWidget r() {
        for (int i11 = 0; i11 < this.f7025k.size(); i11++) {
            WidgetRun widgetRun = (WidgetRun) this.f7025k.get(i11);
            if (widgetRun.f6999b.X() != 8) {
                return widgetRun.f6999b;
            }
        }
        return null;
    }

    private ConstraintWidget s() {
        for (int size = this.f7025k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = (WidgetRun) this.f7025k.get(size);
            if (widgetRun.f6999b.X() != 8) {
                return widgetRun.f6999b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:288:0x03fe, code lost:
    
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e9  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, u0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(u0.a r27) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.c.a(u0.a):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        Iterator it = this.f7025k.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).d();
        }
        int size = this.f7025k.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = ((WidgetRun) this.f7025k.get(0)).f6999b;
        ConstraintWidget constraintWidget2 = ((WidgetRun) this.f7025k.get(size - 1)).f6999b;
        if (this.f7003f == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.S;
            DependencyNode i11 = i(constraintAnchor, 0);
            int f11 = constraintAnchor.f();
            ConstraintWidget r11 = r();
            if (r11 != null) {
                f11 = r11.Q.f();
            }
            if (i11 != null) {
                b(this.f7005h, i11, f11);
            }
            DependencyNode i12 = i(constraintAnchor2, 0);
            int f12 = constraintAnchor2.f();
            ConstraintWidget s11 = s();
            if (s11 != null) {
                f12 = s11.S.f();
            }
            if (i12 != null) {
                b(this.f7006i, i12, -f12);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.R;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.T;
            DependencyNode i13 = i(constraintAnchor3, 1);
            int f13 = constraintAnchor3.f();
            ConstraintWidget r12 = r();
            if (r12 != null) {
                f13 = r12.R.f();
            }
            if (i13 != null) {
                b(this.f7005h, i13, f13);
            }
            DependencyNode i14 = i(constraintAnchor4, 1);
            int f14 = constraintAnchor4.f();
            ConstraintWidget s12 = s();
            if (s12 != null) {
                f14 = s12.T.f();
            }
            if (i14 != null) {
                b(this.f7006i, i14, -f14);
            }
        }
        this.f7005h.f6986a = this;
        this.f7006i.f6986a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        for (int i11 = 0; i11 < this.f7025k.size(); i11++) {
            ((WidgetRun) this.f7025k.get(i11)).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f7000c = null;
        Iterator it = this.f7025k.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long j() {
        int size = this.f7025k.size();
        long j11 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            j11 = j11 + r4.f7005h.f6991f + ((WidgetRun) this.f7025k.get(i11)).j() + r4.f7006i.f6991f;
        }
        return j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        int size = this.f7025k.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!((WidgetRun) this.f7025k.get(i11)).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f7003f == 0 ? "horizontal : " : "vertical : ");
        Iterator it = this.f7025k.iterator();
        while (it.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it.next();
            sb2.append("<");
            sb2.append(widgetRun);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
