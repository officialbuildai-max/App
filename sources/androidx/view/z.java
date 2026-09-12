package androidx.view;

import java.util.Iterator;
import java.util.Map;
import k.b;

/* loaded from: classes.dex */
public class z extends b0 {

    /* renamed from: l, reason: collision with root package name */
    private b f9757l;

    /* loaded from: classes.dex */
    private static class a implements c0 {

        /* renamed from: a, reason: collision with root package name */
        final LiveData f9758a;

        /* renamed from: b, reason: collision with root package name */
        final c0 f9759b;

        /* renamed from: c, reason: collision with root package name */
        int f9760c = -1;

        a(LiveData liveData, c0 c0Var) {
            this.f9758a = liveData;
            this.f9759b = c0Var;
        }

        void a() {
            this.f9758a.k(this);
        }

        void b() {
            this.f9758a.o(this);
        }

        @Override // androidx.view.c0
        public void onChanged(Object obj) {
            if (this.f9760c != this.f9758a.g()) {
                this.f9760c = this.f9758a.g();
                this.f9759b.onChanged(obj);
            }
        }
    }

    public z() {
        this.f9757l = new b();
    }

    public z(Object obj) {
        super(obj);
        this.f9757l = new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.LiveData
    public void l() {
        Iterator it = this.f9757l.iterator();
        while (it.hasNext()) {
            ((a) ((Map.Entry) it.next()).getValue()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.LiveData
    public void m() {
        Iterator it = this.f9757l.iterator();
        while (it.hasNext()) {
            ((a) ((Map.Entry) it.next()).getValue()).b();
        }
    }

    public void r(LiveData liveData, c0 c0Var) {
        if (liveData == null) {
            throw new NullPointerException("source cannot be null");
        }
        a aVar = new a(liveData, c0Var);
        a aVar2 = (a) this.f9757l.g(liveData, aVar);
        if (aVar2 != null && aVar2.f9759b != c0Var) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (aVar2 == null && h()) {
            aVar.a();
        }
    }
}
