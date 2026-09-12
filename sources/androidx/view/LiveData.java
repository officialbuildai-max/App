package androidx.view;

import androidx.view.Lifecycle;
import java.util.Iterator;
import java.util.Map;
import k.b;

/* loaded from: classes.dex */
public abstract class LiveData {

    /* renamed from: k, reason: collision with root package name */
    static final Object f9617k = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f9618a;

    /* renamed from: b, reason: collision with root package name */
    private k.b f9619b;

    /* renamed from: c, reason: collision with root package name */
    int f9620c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9621d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f9622e;

    /* renamed from: f, reason: collision with root package name */
    volatile Object f9623f;

    /* renamed from: g, reason: collision with root package name */
    private int f9624g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9625h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f9626i;

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f9627j;

    /* loaded from: classes.dex */
    private class a extends c {
        a(c0 c0Var) {
            super(c0Var);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean d() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b extends c implements r {

        /* renamed from: e, reason: collision with root package name */
        final u f9629e;

        b(u uVar, c0 c0Var) {
            super(c0Var);
            this.f9629e = uVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        void b() {
            this.f9629e.getLifecycle().d(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean c(u uVar) {
            return this.f9629e == uVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean d() {
            return this.f9629e.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.view.r
        public void onStateChanged(u uVar, Lifecycle.Event event) {
            Lifecycle.State b11 = this.f9629e.getLifecycle().b();
            if (b11 == Lifecycle.State.DESTROYED) {
                LiveData.this.o(this.f9631a);
                return;
            }
            Lifecycle.State state = null;
            while (state != b11) {
                a(d());
                state = b11;
                b11 = this.f9629e.getLifecycle().b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final c0 f9631a;

        /* renamed from: b, reason: collision with root package name */
        boolean f9632b;

        /* renamed from: c, reason: collision with root package name */
        int f9633c = -1;

        c(c0 c0Var) {
            this.f9631a = c0Var;
        }

        void a(boolean z10) {
            if (z10 == this.f9632b) {
                return;
            }
            this.f9632b = z10;
            LiveData.this.c(z10 ? 1 : -1);
            if (this.f9632b) {
                LiveData.this.e(this);
            }
        }

        void b() {
        }

        boolean c(u uVar) {
            return false;
        }

        abstract boolean d();
    }

    public LiveData() {
        this.f9618a = new Object();
        this.f9619b = new k.b();
        this.f9620c = 0;
        Object obj = f9617k;
        this.f9623f = obj;
        this.f9627j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.f9618a) {
                    obj2 = LiveData.this.f9623f;
                    LiveData.this.f9623f = LiveData.f9617k;
                }
                LiveData.this.q(obj2);
            }
        };
        this.f9622e = obj;
        this.f9624g = -1;
    }

    public LiveData(Object obj) {
        this.f9618a = new Object();
        this.f9619b = new k.b();
        this.f9620c = 0;
        this.f9623f = f9617k;
        this.f9627j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.f9618a) {
                    obj2 = LiveData.this.f9623f;
                    LiveData.this.f9623f = LiveData.f9617k;
                }
                LiveData.this.q(obj2);
            }
        };
        this.f9622e = obj;
        this.f9624g = 0;
    }

    static void b(String str) {
        if (j.c.h().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void d(c cVar) {
        if (cVar.f9632b) {
            if (!cVar.d()) {
                cVar.a(false);
                return;
            }
            int i11 = cVar.f9633c;
            int i12 = this.f9624g;
            if (i11 >= i12) {
                return;
            }
            cVar.f9633c = i12;
            cVar.f9631a.onChanged(this.f9622e);
        }
    }

    void c(int i11) {
        int i12 = this.f9620c;
        this.f9620c = i11 + i12;
        if (this.f9621d) {
            return;
        }
        this.f9621d = true;
        while (true) {
            try {
                int i13 = this.f9620c;
                if (i12 == i13) {
                    this.f9621d = false;
                    return;
                }
                boolean z10 = i12 == 0 && i13 > 0;
                boolean z11 = i12 > 0 && i13 == 0;
                if (z10) {
                    l();
                } else if (z11) {
                    m();
                }
                i12 = i13;
            } catch (Throwable th2) {
                this.f9621d = false;
                throw th2;
            }
        }
    }

    void e(c cVar) {
        if (this.f9625h) {
            this.f9626i = true;
            return;
        }
        this.f9625h = true;
        do {
            this.f9626i = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                b.d c11 = this.f9619b.c();
                while (c11.hasNext()) {
                    d((c) ((Map.Entry) c11.next()).getValue());
                    if (this.f9626i) {
                        break;
                    }
                }
            }
        } while (this.f9626i);
        this.f9625h = false;
    }

    public Object f() {
        Object obj = this.f9622e;
        if (obj != f9617k) {
            return obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f9624g;
    }

    public boolean h() {
        return this.f9620c > 0;
    }

    public boolean i() {
        return this.f9622e != f9617k;
    }

    public void j(u uVar, c0 c0Var) {
        b("observe");
        if (uVar.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        b bVar = new b(uVar, c0Var);
        c cVar = (c) this.f9619b.g(c0Var, bVar);
        if (cVar != null && !cVar.c(uVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        uVar.getLifecycle().a(bVar);
    }

    public void k(c0 c0Var) {
        b("observeForever");
        a aVar = new a(c0Var);
        c cVar = (c) this.f9619b.g(c0Var, aVar);
        if (cVar instanceof b) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        aVar.a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(Object obj) {
        boolean z10;
        synchronized (this.f9618a) {
            z10 = this.f9623f == f9617k;
            this.f9623f = obj;
        }
        if (z10) {
            j.c.h().d(this.f9627j);
        }
    }

    public void o(c0 c0Var) {
        b("removeObserver");
        c cVar = (c) this.f9619b.h(c0Var);
        if (cVar == null) {
            return;
        }
        cVar.b();
        cVar.a(false);
    }

    public void p(u uVar) {
        b("removeObservers");
        Iterator it = this.f9619b.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (((c) entry.getValue()).c(uVar)) {
                o((c0) entry.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(Object obj) {
        b("setValue");
        this.f9624g++;
        this.f9622e = obj;
        e(null);
    }
}
