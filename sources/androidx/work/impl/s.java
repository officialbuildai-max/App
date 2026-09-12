package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class s implements androidx.work.impl.foreground.a {

    /* renamed from: l, reason: collision with root package name */
    private static final String f15995l = androidx.work.t.i("Processor");

    /* renamed from: b, reason: collision with root package name */
    private Context f15997b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.work.b f15998c;

    /* renamed from: d, reason: collision with root package name */
    private j4.c f15999d;

    /* renamed from: e, reason: collision with root package name */
    private WorkDatabase f16000e;

    /* renamed from: g, reason: collision with root package name */
    private Map f16002g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private Map f16001f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private Set f16004i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    private final List f16005j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private PowerManager.WakeLock f15996a = null;

    /* renamed from: k, reason: collision with root package name */
    private final Object f16006k = new Object();

    /* renamed from: h, reason: collision with root package name */
    private Map f16003h = new HashMap();

    public s(Context context, androidx.work.b bVar, j4.c cVar, WorkDatabase workDatabase) {
        this.f15997b = context;
        this.f15998c = bVar;
        this.f15999d = cVar;
        this.f16000e = workDatabase;
    }

    private WorkerWrapper f(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.f16001f.remove(str);
        boolean z10 = workerWrapper != null;
        if (!z10) {
            workerWrapper = (WorkerWrapper) this.f16002g.remove(str);
        }
        this.f16003h.remove(str);
        if (z10) {
            t();
        }
        return workerWrapper;
    }

    private WorkerWrapper h(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.f16001f.get(str);
        return workerWrapper == null ? (WorkerWrapper) this.f16002g.get(str) : workerWrapper;
    }

    private static boolean i(String str, WorkerWrapper workerWrapper, int i11) {
        if (workerWrapper == null) {
            androidx.work.t.e().a(f15995l, "WorkerWrapper could not be found for " + str);
            return false;
        }
        workerWrapper.p(i11);
        androidx.work.t.e().a(f15995l, "WorkerWrapper interrupted for " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(androidx.work.impl.model.x xVar, boolean z10) {
        synchronized (this.f16006k) {
            try {
                Iterator it = this.f16005j.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).c(xVar, z10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ androidx.work.impl.model.j0 m(ArrayList arrayList, String str) {
        arrayList.addAll(this.f16000e.m0().a(str));
        return this.f16000e.l0().j(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(com.google.common.util.concurrent.r rVar, WorkerWrapper workerWrapper) {
        boolean z10;
        try {
            z10 = ((Boolean) rVar.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            z10 = true;
        }
        o(workerWrapper, z10);
    }

    private void o(WorkerWrapper workerWrapper, boolean z10) {
        synchronized (this.f16006k) {
            try {
                androidx.work.impl.model.x m11 = workerWrapper.m();
                String b11 = m11.b();
                if (h(b11) == workerWrapper) {
                    f(b11);
                }
                androidx.work.t.e().a(f15995l, getClass().getSimpleName() + " " + b11 + " executed; reschedule = " + z10);
                Iterator it = this.f16005j.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).c(m11, z10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void q(final androidx.work.impl.model.x xVar, final boolean z10) {
        this.f15999d.a().execute(new Runnable() { // from class: androidx.work.impl.r
            @Override // java.lang.Runnable
            public final void run() {
                s.this.l(xVar, z10);
            }
        });
    }

    private void t() {
        synchronized (this.f16006k) {
            try {
                if (this.f16001f.isEmpty()) {
                    try {
                        this.f15997b.startService(SystemForegroundDispatcher.g(this.f15997b));
                    } catch (Throwable th2) {
                        androidx.work.t.e().d(f15995l, "Unable to stop foreground service", th2);
                    }
                    PowerManager.WakeLock wakeLock = this.f15996a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.f15996a = null;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // androidx.work.impl.foreground.a
    public void a(String str, androidx.work.i iVar) {
        synchronized (this.f16006k) {
            try {
                androidx.work.t.e().f(f15995l, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper workerWrapper = (WorkerWrapper) this.f16002g.remove(str);
                if (workerWrapper != null) {
                    if (this.f15996a == null) {
                        PowerManager.WakeLock a11 = androidx.work.impl.utils.b0.a(this.f15997b, "ProcessorForegroundLck");
                        this.f15996a = a11;
                        a11.acquire();
                    }
                    this.f16001f.put(str, workerWrapper);
                    androidx.core.content.b.startForegroundService(this.f15997b, SystemForegroundDispatcher.f(this.f15997b, workerWrapper.m(), iVar));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e(e eVar) {
        synchronized (this.f16006k) {
            this.f16005j.add(eVar);
        }
    }

    public androidx.work.impl.model.j0 g(String str) {
        synchronized (this.f16006k) {
            try {
                WorkerWrapper h11 = h(str);
                if (h11 == null) {
                    return null;
                }
                return h11.n();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean j(String str) {
        boolean contains;
        synchronized (this.f16006k) {
            contains = this.f16004i.contains(str);
        }
        return contains;
    }

    public boolean k(String str) {
        boolean z10;
        synchronized (this.f16006k) {
            z10 = h(str) != null;
        }
        return z10;
    }

    public void p(e eVar) {
        synchronized (this.f16006k) {
            this.f16005j.remove(eVar);
        }
    }

    public boolean r(y yVar, WorkerParameters.a aVar) {
        androidx.work.impl.model.x a11 = yVar.a();
        final String b11 = a11.b();
        final ArrayList arrayList = new ArrayList();
        androidx.work.impl.model.j0 j0Var = (androidx.work.impl.model.j0) this.f16000e.Y(new Callable() { // from class: androidx.work.impl.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                androidx.work.impl.model.j0 m11;
                m11 = s.this.m(arrayList, b11);
                return m11;
            }
        });
        if (j0Var == null) {
            androidx.work.t.e().k(f15995l, "Didn't find WorkSpec for id " + a11);
            q(a11, false);
            return false;
        }
        synchronized (this.f16006k) {
            try {
                if (k(b11)) {
                    Set set = (Set) this.f16003h.get(b11);
                    if (((y) set.iterator().next()).a().a() == a11.a()) {
                        set.add(yVar);
                        androidx.work.t.e().a(f15995l, "Work " + a11 + " is already enqueued for processing");
                    } else {
                        q(a11, false);
                    }
                    return false;
                }
                if (j0Var.g() != a11.a()) {
                    q(a11, false);
                    return false;
                }
                final WorkerWrapper a12 = new WorkerWrapper.a(this.f15997b, this.f15998c, this.f15999d, this, this.f16000e, j0Var, arrayList).k(aVar).a();
                final com.google.common.util.concurrent.r r11 = a12.r();
                r11.addListener(new Runnable() { // from class: androidx.work.impl.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.this.n(r11, a12);
                    }
                }, this.f15999d.a());
                this.f16002g.put(b11, a12);
                HashSet hashSet = new HashSet();
                hashSet.add(yVar);
                this.f16003h.put(b11, hashSet);
                androidx.work.t.e().a(f15995l, getClass().getSimpleName() + ": processing " + a11);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean s(String str, int i11) {
        WorkerWrapper f11;
        synchronized (this.f16006k) {
            androidx.work.t.e().a(f15995l, "Processor cancelling " + str);
            this.f16004i.add(str);
            f11 = f(str);
        }
        return i(str, f11, i11);
    }

    public boolean u(y yVar, int i11) {
        WorkerWrapper f11;
        String b11 = yVar.a().b();
        synchronized (this.f16006k) {
            f11 = f(b11);
        }
        return i(b11, f11, i11);
    }

    public boolean v(y yVar, int i11) {
        String b11 = yVar.a().b();
        synchronized (this.f16006k) {
            try {
                if (this.f16001f.get(b11) == null) {
                    Set set = (Set) this.f16003h.get(b11);
                    if (set != null && set.contains(yVar)) {
                        return i(b11, f(b11), i11);
                    }
                    return false;
                }
                androidx.work.t.e().a(f15995l, "Ignored stopWork. WorkerWrapper " + b11 + " is in foreground");
                return false;
            } finally {
            }
        }
    }
}
