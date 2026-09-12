package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.s;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private final MotionLayout f7608a;

    /* renamed from: c, reason: collision with root package name */
    private HashSet f7610c;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f7612e;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList f7609b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private String f7611d = "ViewTransitionController";

    /* renamed from: f, reason: collision with root package name */
    ArrayList f7613f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f7614a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7615b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f7616c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f7617d;

        a(s sVar, int i11, boolean z10, int i12) {
            this.f7614a = sVar;
            this.f7615b = i11;
            this.f7616c = z10;
            this.f7617d = i12;
        }
    }

    public t(MotionLayout motionLayout) {
        this.f7608a = motionLayout;
    }

    private void h(s sVar, boolean z10) {
        ConstraintLayout.getSharedValues().a(sVar.h(), new a(sVar, sVar.h(), z10, sVar.g()));
    }

    private void l(s sVar, View... viewArr) {
        int currentState = this.f7608a.getCurrentState();
        if (sVar.f7574e == 2) {
            sVar.c(this, this.f7608a, currentState, null, viewArr);
            return;
        }
        if (currentState != -1) {
            androidx.constraintlayout.widget.b constraintSet = this.f7608a.getConstraintSet(currentState);
            if (constraintSet == null) {
                return;
            }
            sVar.c(this, this.f7608a, currentState, constraintSet, viewArr);
            return;
        }
        Log.w(this.f7611d, "No support for ViewTransition within transition yet. Currently: " + this.f7608a.toString());
    }

    public void a(s sVar) {
        this.f7609b.add(sVar);
        this.f7610c = null;
        if (sVar.i() == 4) {
            h(sVar, true);
        } else if (sVar.i() == 5) {
            h(sVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(s.b bVar) {
        if (this.f7612e == null) {
            this.f7612e = new ArrayList();
        }
        this.f7612e.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        ArrayList arrayList = this.f7612e;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((s.b) it.next()).a();
        }
        this.f7612e.removeAll(this.f7613f);
        this.f7613f.clear();
        if (this.f7612e.isEmpty()) {
            this.f7612e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(int i11, m mVar) {
        Iterator it = this.f7609b.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar.e() == i11) {
                sVar.f7575f.a(mVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i11, boolean z10) {
        Iterator it = this.f7609b.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar.e() == i11) {
                sVar.n(z10);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f7608a.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i11) {
        Iterator it = this.f7609b.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar.e() == i11) {
                return sVar.j();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(s.b bVar) {
        this.f7613f.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(MotionEvent motionEvent) {
        s sVar;
        int currentState = this.f7608a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.f7610c == null) {
            this.f7610c = new HashSet();
            Iterator it = this.f7609b.iterator();
            while (it.hasNext()) {
                s sVar2 = (s) it.next();
                int childCount = this.f7608a.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = this.f7608a.getChildAt(i11);
                    if (sVar2.l(childAt)) {
                        childAt.getId();
                        this.f7610c.add(childAt);
                    }
                }
            }
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList arrayList = this.f7612e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it2 = this.f7612e.iterator();
            while (it2.hasNext()) {
                ((s.b) it2.next()).d(action, x10, y10);
            }
        }
        if (action == 0 || action == 1) {
            androidx.constraintlayout.widget.b constraintSet = this.f7608a.getConstraintSet(currentState);
            Iterator it3 = this.f7609b.iterator();
            while (it3.hasNext()) {
                s sVar3 = (s) it3.next();
                if (sVar3.o(action)) {
                    Iterator it4 = this.f7610c.iterator();
                    while (it4.hasNext()) {
                        View view = (View) it4.next();
                        if (sVar3.l(view)) {
                            view.getHitRect(rect);
                            if (rect.contains((int) x10, (int) y10)) {
                                sVar = sVar3;
                                sVar3.c(this, this.f7608a, currentState, constraintSet, view);
                            } else {
                                sVar = sVar3;
                            }
                            sVar3 = sVar;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i11, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f7609b.iterator();
        s sVar = null;
        while (it.hasNext()) {
            s sVar2 = (s) it.next();
            if (sVar2.e() == i11) {
                for (View view : viewArr) {
                    if (sVar2.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    l(sVar2, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                sVar = sVar2;
            }
        }
        if (sVar == null) {
            Log.e(this.f7611d, " Could not find ViewTransition");
        }
    }
}
