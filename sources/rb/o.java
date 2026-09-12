package rb;

import androidx.compose.animation.core.j0;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import rb.o;

/* loaded from: classes5.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final f f74411a;

    /* renamed from: b, reason: collision with root package name */
    private final CrashlyticsWorkers f74412b;

    /* renamed from: c, reason: collision with root package name */
    private String f74413c;

    /* renamed from: d, reason: collision with root package name */
    private final a f74414d = new a(false);

    /* renamed from: e, reason: collision with root package name */
    private final a f74415e = new a(true);

    /* renamed from: f, reason: collision with root package name */
    private final j f74416f = new j(128);

    /* renamed from: g, reason: collision with root package name */
    private final AtomicMarkableReference f74417g = new AtomicMarkableReference(null, false);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final AtomicMarkableReference f74418a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicReference f74419b = new AtomicReference(null);

        /* renamed from: c, reason: collision with root package name */
        private final boolean f74420c;

        public a(boolean z10) {
            this.f74420c = z10;
            this.f74418a = new AtomicMarkableReference(new d(64, z10 ? 8192 : 1024), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f74419b.set(null);
            e();
        }

        private void d() {
            Runnable runnable = new Runnable() { // from class: rb.n
                @Override // java.lang.Runnable
                public final void run() {
                    o.a.this.c();
                }
            };
            if (j0.a(this.f74419b, null, runnable)) {
                o.this.f74412b.f31352b.f(runnable);
            }
        }

        private void e() {
            Map map;
            synchronized (this) {
                try {
                    if (this.f74418a.isMarked()) {
                        map = ((d) this.f74418a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.f74418a;
                        atomicMarkableReference.set((d) atomicMarkableReference.getReference(), false);
                    } else {
                        map = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (map != null) {
                o.this.f74411a.r(o.this.f74413c, map, this.f74420c);
            }
        }

        public Map b() {
            return ((d) this.f74418a.getReference()).a();
        }

        public boolean f(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((d) this.f74418a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f74418a;
                    atomicMarkableReference.set((d) atomicMarkableReference.getReference(), true);
                    d();
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public o(String str, vb.g gVar, CrashlyticsWorkers crashlyticsWorkers) {
        this.f74413c = str;
        this.f74411a = new f(gVar);
        this.f74412b = crashlyticsWorkers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(String str, Map map, List list) {
        if (j() != null) {
            this.f74411a.t(str, j());
        }
        if (!map.isEmpty()) {
            this.f74411a.q(str, map);
        }
        if (list.isEmpty()) {
            return;
        }
        this.f74411a.s(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(List list) {
        this.f74411a.s(this.f74413c, list);
    }

    public static o m(String str, vb.g gVar, CrashlyticsWorkers crashlyticsWorkers) {
        f fVar = new f(gVar);
        o oVar = new o(str, gVar, crashlyticsWorkers);
        ((d) oVar.f74414d.f74418a.getReference()).e(fVar.i(str, false));
        ((d) oVar.f74415e.f74418a.getReference()).e(fVar.i(str, true));
        oVar.f74417g.set(fVar.k(str), false);
        oVar.f74416f.c(fVar.j(str));
        return oVar;
    }

    public static String n(String str, vb.g gVar) {
        return new f(gVar).k(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        boolean z10;
        String str;
        synchronized (this.f74417g) {
            try {
                z10 = false;
                if (this.f74417g.isMarked()) {
                    str = j();
                    this.f74417g.set(str, false);
                    z10 = true;
                } else {
                    str = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            this.f74411a.t(this.f74413c, str);
        }
    }

    public Map g() {
        return this.f74414d.b();
    }

    public Map h() {
        return this.f74415e.b();
    }

    public List i() {
        return this.f74416f.a();
    }

    public String j() {
        return (String) this.f74417g.getReference();
    }

    public boolean p(String str, String str2) {
        return this.f74414d.f(str, str2);
    }

    public boolean q(String str, String str2) {
        return this.f74415e.f(str, str2);
    }

    public void r(final String str) {
        synchronized (this.f74413c) {
            this.f74413c = str;
            final Map b11 = this.f74414d.b();
            final List b12 = this.f74416f.b();
            this.f74412b.f31352b.f(new Runnable() { // from class: rb.k
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.k(str, b11, b12);
                }
            });
        }
    }

    public void s(String str) {
        String c11 = d.c(str, 1024);
        synchronized (this.f74417g) {
            try {
                if (CommonUtils.y(c11, (String) this.f74417g.getReference())) {
                    return;
                }
                this.f74417g.set(c11, true);
                this.f74412b.f31352b.f(new Runnable() { // from class: rb.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.this.o();
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean t(List list) {
        synchronized (this.f74416f) {
            try {
                if (!this.f74416f.c(list)) {
                    return false;
                }
                final List b11 = this.f74416f.b();
                this.f74412b.f31352b.f(new Runnable() { // from class: rb.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.this.l(b11);
                    }
                });
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
