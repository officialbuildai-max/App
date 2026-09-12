package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class e extends FragmentTransitionImpl {

    /* loaded from: classes2.dex */
    class a extends j.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f15100a;

        a(Rect rect) {
            this.f15100a = rect;
        }
    }

    /* loaded from: classes2.dex */
    class b implements j.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f15102a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f15103b;

        b(View view, ArrayList arrayList) {
            this.f15102a = view;
            this.f15103b = arrayList;
        }

        @Override // androidx.transition.j.f
        public void a(j jVar) {
        }

        @Override // androidx.transition.j.f
        public void b(j jVar) {
            jVar.S(this);
            jVar.a(this);
        }

        @Override // androidx.transition.j.f
        public void c(j jVar) {
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void d(j jVar, boolean z10) {
            k.a(this, jVar, z10);
        }

        @Override // androidx.transition.j.f
        public void e(j jVar) {
            jVar.S(this);
            this.f15102a.setVisibility(8);
            int size = this.f15103b.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((View) this.f15103b.get(i11)).setVisibility(0);
            }
        }

        @Override // androidx.transition.j.f
        public void f(j jVar) {
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void g(j jVar, boolean z10) {
            k.b(this, jVar, z10);
        }
    }

    /* loaded from: classes2.dex */
    class c extends r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f15105a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f15106b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f15107c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f15108d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f15109e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f15110f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f15105a = obj;
            this.f15106b = arrayList;
            this.f15107c = obj2;
            this.f15108d = arrayList2;
            this.f15109e = obj3;
            this.f15110f = arrayList3;
        }

        @Override // androidx.transition.r, androidx.transition.j.f
        public void b(j jVar) {
            Object obj = this.f15105a;
            if (obj != null) {
                e.this.y(obj, this.f15106b, null);
            }
            Object obj2 = this.f15107c;
            if (obj2 != null) {
                e.this.y(obj2, this.f15108d, null);
            }
            Object obj3 = this.f15109e;
            if (obj3 != null) {
                e.this.y(obj3, this.f15110f, null);
            }
        }

        @Override // androidx.transition.r, androidx.transition.j.f
        public void e(j jVar) {
            jVar.S(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements j.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f15112a;

        d(Runnable runnable) {
            this.f15112a = runnable;
        }

        @Override // androidx.transition.j.f
        public void a(j jVar) {
        }

        @Override // androidx.transition.j.f
        public void b(j jVar) {
        }

        @Override // androidx.transition.j.f
        public void c(j jVar) {
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void d(j jVar, boolean z10) {
            k.a(this, jVar, z10);
        }

        @Override // androidx.transition.j.f
        public void e(j jVar) {
            this.f15112a.run();
        }

        @Override // androidx.transition.j.f
        public void f(j jVar) {
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void g(j jVar, boolean z10) {
            k.b(this, jVar, z10);
        }
    }

    /* renamed from: androidx.transition.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0134e extends j.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f15114a;

        C0134e(Rect rect) {
            this.f15114a = rect;
        }
    }

    private static boolean w(j jVar) {
        return (FragmentTransitionImpl.i(jVar.A()) && FragmentTransitionImpl.i(jVar.B()) && FragmentTransitionImpl.i(jVar.C())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(Runnable runnable, j jVar, Runnable runnable2) {
        if (runnable != null) {
            runnable.run();
        } else {
            jVar.cancel();
            runnable2.run();
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void a(Object obj, View view) {
        if (obj != null) {
            ((j) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void b(Object obj, ArrayList arrayList) {
        j jVar = (j) obj;
        if (jVar == null) {
            return;
        }
        int i11 = 0;
        if (jVar instanceof u) {
            u uVar = (u) jVar;
            int k02 = uVar.k0();
            while (i11 < k02) {
                b(uVar.j0(i11), arrayList);
                i11++;
            }
            return;
        }
        if (w(jVar) || !FragmentTransitionImpl.i(jVar.D())) {
            return;
        }
        int size = arrayList.size();
        while (i11 < size) {
            jVar.b((View) arrayList.get(i11));
            i11++;
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void c(ViewGroup viewGroup, Object obj) {
        s.a(viewGroup, (j) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean e(Object obj) {
        return obj instanceof j;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object f(Object obj) {
        if (obj != null) {
            return ((j) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object j(Object obj, Object obj2, Object obj3) {
        j jVar = (j) obj;
        j jVar2 = (j) obj2;
        j jVar3 = (j) obj3;
        if (jVar != null && jVar2 != null) {
            jVar = new u().h0(jVar).h0(jVar2).p0(1);
        } else if (jVar == null) {
            jVar = jVar2 != null ? jVar2 : null;
        }
        if (jVar3 == null) {
            return jVar;
        }
        u uVar = new u();
        if (jVar != null) {
            uVar.h0(jVar);
        }
        uVar.h0(jVar3);
        return uVar;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object k(Object obj, Object obj2, Object obj3) {
        u uVar = new u();
        if (obj != null) {
            uVar.h0((j) obj);
        }
        if (obj2 != null) {
            uVar.h0((j) obj2);
        }
        if (obj3 != null) {
            uVar.h0((j) obj3);
        }
        return uVar;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void m(Object obj, View view, ArrayList arrayList) {
        ((j) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void n(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((j) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((j) obj).Y(new C0134e(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((j) obj).Y(new a(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void q(Fragment fragment, Object obj, androidx.core.os.e eVar, Runnable runnable) {
        z(fragment, obj, eVar, null, runnable);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void s(Object obj, View view, ArrayList arrayList) {
        u uVar = (u) obj;
        List D = uVar.D();
        D.clear();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            FragmentTransitionImpl.d(D, (View) arrayList.get(i11));
        }
        D.add(view);
        arrayList.add(view);
        b(uVar, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void t(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        u uVar = (u) obj;
        if (uVar != null) {
            uVar.D().clear();
            uVar.D().addAll(arrayList2);
            y(uVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        u uVar = new u();
        uVar.h0((j) obj);
        return uVar;
    }

    public void y(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        j jVar = (j) obj;
        int i11 = 0;
        if (jVar instanceof u) {
            u uVar = (u) jVar;
            int k02 = uVar.k0();
            while (i11 < k02) {
                y(uVar.j0(i11), arrayList, arrayList2);
                i11++;
            }
            return;
        }
        if (w(jVar)) {
            return;
        }
        List D = jVar.D();
        if (D.size() == arrayList.size() && D.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i11 < size) {
                jVar.b((View) arrayList2.get(i11));
                i11++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                jVar.T((View) arrayList.get(size2));
            }
        }
    }

    public void z(Fragment fragment, Object obj, androidx.core.os.e eVar, final Runnable runnable, final Runnable runnable2) {
        final j jVar = (j) obj;
        eVar.b(new e.a() { // from class: androidx.transition.d
            @Override // androidx.core.os.e.a
            public final void onCancel() {
                e.x(runnable, jVar, runnable2);
            }
        });
        jVar.a(new d(runnable2));
    }
}
