package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class s {

    /* renamed from: c, reason: collision with root package name */
    private static j f15178c = new androidx.transition.a();

    /* renamed from: d, reason: collision with root package name */
    private static ThreadLocal f15179d = new ThreadLocal();

    /* renamed from: e, reason: collision with root package name */
    static ArrayList f15180e = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private androidx.collection.a f15181a = new androidx.collection.a();

    /* renamed from: b, reason: collision with root package name */
    private androidx.collection.a f15182b = new androidx.collection.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        j f15183a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f15184b;

        /* renamed from: androidx.transition.s$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0135a extends r {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ androidx.collection.a f15185a;

            C0135a(androidx.collection.a aVar) {
                this.f15185a = aVar;
            }

            @Override // androidx.transition.r, androidx.transition.j.f
            public void e(j jVar) {
                ((ArrayList) this.f15185a.get(a.this.f15184b)).remove(jVar);
                jVar.S(this);
            }
        }

        a(j jVar, ViewGroup viewGroup) {
            this.f15183a = jVar;
            this.f15184b = viewGroup;
        }

        private void a() {
            this.f15184b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f15184b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!s.f15180e.remove(this.f15184b)) {
                return true;
            }
            androidx.collection.a b11 = s.b();
            ArrayList arrayList = (ArrayList) b11.get(this.f15184b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                b11.put(this.f15184b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f15183a);
            this.f15183a.a(new C0135a(b11));
            this.f15183a.k(this.f15184b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).U(this.f15184b);
                }
            }
            this.f15183a.R(this.f15184b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            s.f15180e.remove(this.f15184b);
            ArrayList arrayList = (ArrayList) s.b().get(this.f15184b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).U(this.f15184b);
                }
            }
            this.f15183a.l(true);
        }
    }

    public static void a(ViewGroup viewGroup, j jVar) {
        if (f15180e.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        f15180e.add(viewGroup);
        if (jVar == null) {
            jVar = f15178c;
        }
        j clone = jVar.clone();
        d(viewGroup, clone);
        i.b(viewGroup, null);
        c(viewGroup, clone);
    }

    static androidx.collection.a b() {
        androidx.collection.a aVar;
        WeakReference weakReference = (WeakReference) f15179d.get();
        if (weakReference != null && (aVar = (androidx.collection.a) weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a aVar2 = new androidx.collection.a();
        f15179d.set(new WeakReference(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, j jVar) {
        if (jVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(jVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, j jVar) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).Q(viewGroup);
            }
        }
        if (jVar != null) {
            jVar.k(viewGroup, true);
        }
        i.a(viewGroup);
    }
}
