package z8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import b9.a;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final Context f79457a;

    /* renamed from: b, reason: collision with root package name */
    private final t8.d f79458b;

    /* renamed from: c, reason: collision with root package name */
    private final a9.d f79459c;

    /* renamed from: d, reason: collision with root package name */
    private final u f79460d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f79461e;

    /* renamed from: f, reason: collision with root package name */
    private final b9.a f79462f;

    /* renamed from: g, reason: collision with root package name */
    private final c9.a f79463g;

    /* renamed from: h, reason: collision with root package name */
    private final c9.a f79464h;

    /* renamed from: i, reason: collision with root package name */
    private final a9.c f79465i;

    public o(Context context, t8.d dVar, a9.d dVar2, u uVar, Executor executor, b9.a aVar, c9.a aVar2, c9.a aVar3, a9.c cVar) {
        this.f79457a = context;
        this.f79458b = dVar;
        this.f79459c = dVar2;
        this.f79460d = uVar;
        this.f79461e = executor;
        this.f79462f = aVar;
        this.f79463g = aVar2;
        this.f79464h = aVar3;
        this.f79465i = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l(com.google.android.datatransport.runtime.o oVar) {
        return Boolean.valueOf(this.f79459c.P(oVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable m(com.google.android.datatransport.runtime.o oVar) {
        return this.f79459c.X(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, com.google.android.datatransport.runtime.o oVar, long j11) {
        this.f79459c.Q(iterable);
        this.f79459c.G(oVar, this.f79463g.getTime() + j11);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.f79459c.C(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.f79465i.d();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.f79465i.i(((Integer) r0.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(com.google.android.datatransport.runtime.o oVar, long j11) {
        this.f79459c.G(oVar, this.f79463g.getTime() + j11);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(com.google.android.datatransport.runtime.o oVar, int i11) {
        this.f79460d.a(oVar, i11 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final com.google.android.datatransport.runtime.o oVar, final int i11, Runnable runnable) {
        try {
            try {
                b9.a aVar = this.f79462f;
                final a9.d dVar = this.f79459c;
                Objects.requireNonNull(dVar);
                aVar.b(new a.InterfaceC0150a() { // from class: z8.f
                    @Override // b9.a.InterfaceC0150a
                    public final Object execute() {
                        return Integer.valueOf(a9.d.this.B());
                    }
                });
                if (k()) {
                    u(oVar, i11);
                } else {
                    this.f79462f.b(new a.InterfaceC0150a() { // from class: z8.g
                        @Override // b9.a.InterfaceC0150a
                        public final Object execute() {
                            Object s11;
                            s11 = o.this.s(oVar, i11);
                            return s11;
                        }
                    });
                }
            } catch (SynchronizationException unused) {
                this.f79460d.a(oVar, i11 + 1);
            }
            runnable.run();
        } catch (Throwable th2) {
            runnable.run();
            throw th2;
        }
    }

    public com.google.android.datatransport.runtime.i j(t8.k kVar) {
        b9.a aVar = this.f79462f;
        final a9.c cVar = this.f79465i;
        Objects.requireNonNull(cVar);
        return kVar.a(com.google.android.datatransport.runtime.i.a().i(this.f79463g.getTime()).o(this.f79464h.getTime()).n("GDT_CLIENT_METRICS").h(new com.google.android.datatransport.runtime.h(r8.c.b("proto"), ((v8.a) aVar.b(new a.InterfaceC0150a() { // from class: z8.e
            @Override // b9.a.InterfaceC0150a
            public final Object execute() {
                return a9.c.this.h();
            }
        })).f())).d());
    }

    boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f79457a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public BackendResponse u(final com.google.android.datatransport.runtime.o oVar, int i11) {
        BackendResponse b11;
        t8.k a11 = this.f79458b.a(oVar.b());
        long j11 = 0;
        BackendResponse e11 = BackendResponse.e(0L);
        while (true) {
            final long j12 = j11;
            while (((Boolean) this.f79462f.b(new a.InterfaceC0150a() { // from class: z8.h
                @Override // b9.a.InterfaceC0150a
                public final Object execute() {
                    Boolean l11;
                    l11 = o.this.l(oVar);
                    return l11;
                }
            })).booleanValue()) {
                final Iterable iterable = (Iterable) this.f79462f.b(new a.InterfaceC0150a() { // from class: z8.i
                    @Override // b9.a.InterfaceC0150a
                    public final Object execute() {
                        Iterable m11;
                        m11 = o.this.m(oVar);
                        return m11;
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return e11;
                }
                if (a11 == null) {
                    w8.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", oVar);
                    b11 = BackendResponse.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((a9.k) it.next()).b());
                    }
                    if (oVar.e()) {
                        arrayList.add(j(a11));
                    }
                    b11 = a11.b(t8.e.a().b(arrayList).c(oVar.c()).a());
                }
                e11 = b11;
                if (e11.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.f79462f.b(new a.InterfaceC0150a() { // from class: z8.j
                        @Override // b9.a.InterfaceC0150a
                        public final Object execute() {
                            Object n11;
                            n11 = o.this.n(iterable, oVar, j12);
                            return n11;
                        }
                    });
                    this.f79460d.b(oVar, i11 + 1, true);
                    return e11;
                }
                this.f79462f.b(new a.InterfaceC0150a() { // from class: z8.k
                    @Override // b9.a.InterfaceC0150a
                    public final Object execute() {
                        Object o11;
                        o11 = o.this.o(iterable);
                        return o11;
                    }
                });
                if (e11.c() == BackendResponse.Status.OK) {
                    j11 = Math.max(j12, e11.b());
                    if (oVar.e()) {
                        this.f79462f.b(new a.InterfaceC0150a() { // from class: z8.l
                            @Override // b9.a.InterfaceC0150a
                            public final Object execute() {
                                Object p11;
                                p11 = o.this.p();
                                return p11;
                            }
                        });
                    }
                } else if (e11.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                    final HashMap hashMap = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String n11 = ((a9.k) it2.next()).b().n();
                        if (hashMap.containsKey(n11)) {
                            hashMap.put(n11, Integer.valueOf(((Integer) hashMap.get(n11)).intValue() + 1));
                        } else {
                            hashMap.put(n11, 1);
                        }
                    }
                    this.f79462f.b(new a.InterfaceC0150a() { // from class: z8.m
                        @Override // b9.a.InterfaceC0150a
                        public final Object execute() {
                            Object q11;
                            q11 = o.this.q(hashMap);
                            return q11;
                        }
                    });
                }
            }
            this.f79462f.b(new a.InterfaceC0150a() { // from class: z8.n
                @Override // b9.a.InterfaceC0150a
                public final Object execute() {
                    Object r11;
                    r11 = o.this.r(oVar, j12);
                    return r11;
                }
            });
            return e11;
        }
    }

    public void v(final com.google.android.datatransport.runtime.o oVar, final int i11, final Runnable runnable) {
        this.f79461e.execute(new Runnable() { // from class: z8.d
            @Override // java.lang.Runnable
            public final void run() {
                o.this.t(oVar, i11, runnable);
            }
        });
    }
}
