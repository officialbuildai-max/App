package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class m {

    /* renamed from: g, reason: collision with root package name */
    static int f7053g;

    /* renamed from: b, reason: collision with root package name */
    int f7055b;

    /* renamed from: d, reason: collision with root package name */
    int f7057d;

    /* renamed from: a, reason: collision with root package name */
    ArrayList f7054a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    boolean f7056c = false;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f7058e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f7059f = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        WeakReference f7060a;

        /* renamed from: b, reason: collision with root package name */
        int f7061b;

        /* renamed from: c, reason: collision with root package name */
        int f7062c;

        /* renamed from: d, reason: collision with root package name */
        int f7063d;

        /* renamed from: e, reason: collision with root package name */
        int f7064e;

        /* renamed from: f, reason: collision with root package name */
        int f7065f;

        /* renamed from: g, reason: collision with root package name */
        int f7066g;

        public a(ConstraintWidget constraintWidget, androidx.constraintlayout.core.d dVar, int i11) {
            this.f7060a = new WeakReference(constraintWidget);
            this.f7061b = dVar.y(constraintWidget.Q);
            this.f7062c = dVar.y(constraintWidget.R);
            this.f7063d = dVar.y(constraintWidget.S);
            this.f7064e = dVar.y(constraintWidget.T);
            this.f7065f = dVar.y(constraintWidget.U);
            this.f7066g = i11;
        }
    }

    public m(int i11) {
        int i12 = f7053g;
        f7053g = i12 + 1;
        this.f7055b = i12;
        this.f7057d = i11;
    }

    private String e() {
        int i11 = this.f7057d;
        return i11 == 0 ? "Horizontal" : i11 == 1 ? "Vertical" : i11 == 2 ? "Both" : "Unknown";
    }

    private int j(androidx.constraintlayout.core.d dVar, ArrayList arrayList, int i11) {
        int y10;
        int y11;
        androidx.constraintlayout.core.widgets.d dVar2 = (androidx.constraintlayout.core.widgets.d) ((ConstraintWidget) arrayList.get(0)).M();
        dVar.E();
        dVar2.g(dVar, false);
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            ((ConstraintWidget) arrayList.get(i12)).g(dVar, false);
        }
        if (i11 == 0 && dVar2.f7097h1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar2, dVar, arrayList, 0);
        }
        if (i11 == 1 && dVar2.f7098i1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar2, dVar, arrayList, 1);
        }
        try {
            dVar.A();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f7058e = new ArrayList();
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            this.f7058e.add(new a((ConstraintWidget) arrayList.get(i13), dVar, i11));
        }
        if (i11 == 0) {
            y10 = dVar.y(dVar2.Q);
            y11 = dVar.y(dVar2.S);
            dVar.E();
        } else {
            y10 = dVar.y(dVar2.R);
            y11 = dVar.y(dVar2.T);
            dVar.E();
        }
        return y11 - y10;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f7054a.contains(constraintWidget)) {
            return false;
        }
        this.f7054a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.f7054a.size();
        if (this.f7059f != -1 && size > 0) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                m mVar = (m) arrayList.get(i11);
                if (this.f7059f == mVar.f7055b) {
                    g(this.f7057d, mVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f7055b;
    }

    public int d() {
        return this.f7057d;
    }

    public int f(androidx.constraintlayout.core.d dVar, int i11) {
        if (this.f7054a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f7054a, i11);
    }

    public void g(int i11, m mVar) {
        Iterator it = this.f7054a.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            mVar.a(constraintWidget);
            if (i11 == 0) {
                constraintWidget.S0 = mVar.c();
            } else {
                constraintWidget.T0 = mVar.c();
            }
        }
        this.f7059f = mVar.f7055b;
    }

    public void h(boolean z10) {
        this.f7056c = z10;
    }

    public void i(int i11) {
        this.f7057d = i11;
    }

    public String toString() {
        String str = e() + " [" + this.f7055b + "] <";
        Iterator it = this.f7054a.iterator();
        while (it.hasNext()) {
            str = str + " " + ((ConstraintWidget) it.next()).v();
        }
        return str + " >";
    }
}
