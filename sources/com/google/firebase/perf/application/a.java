package com.google.firebase.perf.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.metrics.g;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.e;
import com.google.firebase.perf.util.h;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import vc.k;

/* loaded from: classes4.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: r, reason: collision with root package name */
    private static final sc.a f32249r = sc.a.e();

    /* renamed from: s, reason: collision with root package name */
    private static volatile a f32250s;

    /* renamed from: a, reason: collision with root package name */
    private final WeakHashMap f32251a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakHashMap f32252b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakHashMap f32253c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakHashMap f32254d;

    /* renamed from: e, reason: collision with root package name */
    private final Map f32255e;

    /* renamed from: f, reason: collision with root package name */
    private final Set f32256f;

    /* renamed from: g, reason: collision with root package name */
    private Set f32257g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicInteger f32258h;

    /* renamed from: i, reason: collision with root package name */
    private final k f32259i;

    /* renamed from: j, reason: collision with root package name */
    private final com.google.firebase.perf.config.a f32260j;

    /* renamed from: k, reason: collision with root package name */
    private final com.google.firebase.perf.util.a f32261k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f32262l;

    /* renamed from: m, reason: collision with root package name */
    private Timer f32263m;

    /* renamed from: n, reason: collision with root package name */
    private Timer f32264n;

    /* renamed from: o, reason: collision with root package name */
    private ApplicationProcessState f32265o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f32266p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f32267q;

    /* renamed from: com.google.firebase.perf.application.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0447a {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onUpdateAppState(ApplicationProcessState applicationProcessState);
    }

    a(k kVar, com.google.firebase.perf.util.a aVar) {
        this(kVar, aVar, com.google.firebase.perf.config.a.g(), g());
    }

    a(k kVar, com.google.firebase.perf.util.a aVar, com.google.firebase.perf.config.a aVar2, boolean z10) {
        this.f32251a = new WeakHashMap();
        this.f32252b = new WeakHashMap();
        this.f32253c = new WeakHashMap();
        this.f32254d = new WeakHashMap();
        this.f32255e = new HashMap();
        this.f32256f = new HashSet();
        this.f32257g = new HashSet();
        this.f32258h = new AtomicInteger(0);
        this.f32265o = ApplicationProcessState.BACKGROUND;
        this.f32266p = false;
        this.f32267q = true;
        this.f32259i = kVar;
        this.f32261k = aVar;
        this.f32260j = aVar2;
        this.f32262l = z10;
    }

    public static a b() {
        if (f32250s == null) {
            synchronized (a.class) {
                try {
                    if (f32250s == null) {
                        f32250s = new a(k.k(), new com.google.firebase.perf.util.a());
                    }
                } finally {
                }
            }
        }
        return f32250s;
    }

    public static String c(Activity activity) {
        return "_st_" + activity.getClass().getSimpleName();
    }

    private static boolean g() {
        return d.a();
    }

    private void l() {
        synchronized (this.f32257g) {
            try {
                for (InterfaceC0447a interfaceC0447a : this.f32257g) {
                    if (interfaceC0447a != null) {
                        interfaceC0447a.a();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void m(Activity activity) {
        Trace trace = (Trace) this.f32254d.get(activity);
        if (trace == null) {
            return;
        }
        this.f32254d.remove(activity);
        e e11 = ((d) this.f32252b.get(activity)).e();
        if (!e11.d()) {
            f32249r.k("Failed to record frame data for %s.", activity.getClass().getSimpleName());
        } else {
            h.a(trace, (g.a) e11.c());
            trace.stop();
        }
    }

    private void n(String str, Timer timer, Timer timer2) {
        if (this.f32260j.K()) {
            i.b j11 = i.M().r(str).p(timer.getMicros()).q(timer.getDurationMicros(timer2)).j(SessionManager.getInstance().perfSession().build());
            int andSet = this.f32258h.getAndSet(0);
            synchronized (this.f32255e) {
                try {
                    j11.l(this.f32255e);
                    if (andSet != 0) {
                        j11.n(Constants$CounterNames.TRACE_STARTED_NOT_STOPPED.toString(), andSet);
                    }
                    this.f32255e.clear();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f32259i.C((i) j11.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
        }
    }

    private void o(Activity activity) {
        if (h() && this.f32260j.K()) {
            d dVar = new d(activity);
            this.f32252b.put(activity, dVar);
            if (activity instanceof FragmentActivity) {
                c cVar = new c(this.f32261k, this.f32259i, this, dVar);
                this.f32253c.put(activity, cVar);
                ((FragmentActivity) activity).getSupportFragmentManager().p1(cVar, true);
            }
        }
    }

    private void q(ApplicationProcessState applicationProcessState) {
        this.f32265o = applicationProcessState;
        synchronized (this.f32256f) {
            try {
                Iterator it = this.f32256f.iterator();
                while (it.hasNext()) {
                    b bVar = (b) ((WeakReference) it.next()).get();
                    if (bVar != null) {
                        bVar.onUpdateAppState(this.f32265o);
                    } else {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public ApplicationProcessState a() {
        return this.f32265o;
    }

    public void d(String str, long j11) {
        synchronized (this.f32255e) {
            try {
                Long l11 = (Long) this.f32255e.get(str);
                if (l11 == null) {
                    this.f32255e.put(str, Long.valueOf(j11));
                } else {
                    this.f32255e.put(str, Long.valueOf(l11.longValue() + j11));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e(int i11) {
        this.f32258h.addAndGet(i11);
    }

    public boolean f() {
        return this.f32267q;
    }

    protected boolean h() {
        return this.f32262l;
    }

    public synchronized void i(Context context) {
        if (this.f32266p) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            this.f32266p = true;
        }
    }

    public void j(InterfaceC0447a interfaceC0447a) {
        synchronized (this.f32257g) {
            this.f32257g.add(interfaceC0447a);
        }
    }

    public void k(WeakReference weakReference) {
        synchronized (this.f32256f) {
            this.f32256f.add(weakReference);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        o(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.f32252b.remove(activity);
        if (this.f32253c.containsKey(activity)) {
            ((FragmentActivity) activity).getSupportFragmentManager().N1((FragmentManager.k) this.f32253c.remove(activity));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        try {
            if (this.f32251a.isEmpty()) {
                this.f32263m = this.f32261k.a();
                this.f32251a.put(activity, Boolean.TRUE);
                if (this.f32267q) {
                    q(ApplicationProcessState.FOREGROUND);
                    l();
                    this.f32267q = false;
                } else {
                    n(Constants$TraceNames.BACKGROUND_TRACE_NAME.toString(), this.f32264n, this.f32263m);
                    q(ApplicationProcessState.FOREGROUND);
                }
            } else {
                this.f32251a.put(activity, Boolean.TRUE);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        try {
            if (h() && this.f32260j.K()) {
                if (!this.f32252b.containsKey(activity)) {
                    o(activity);
                }
                ((d) this.f32252b.get(activity)).c();
                Trace trace = new Trace(c(activity), this.f32259i, this.f32261k, this);
                trace.start();
                this.f32254d.put(activity, trace);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
        try {
            if (h()) {
                m(activity);
            }
            if (this.f32251a.containsKey(activity)) {
                this.f32251a.remove(activity);
                if (this.f32251a.isEmpty()) {
                    this.f32264n = this.f32261k.a();
                    n(Constants$TraceNames.FOREGROUND_TRACE_NAME.toString(), this.f32263m, this.f32264n);
                    q(ApplicationProcessState.BACKGROUND);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void p(WeakReference weakReference) {
        synchronized (this.f32256f) {
            this.f32256f.remove(weakReference);
        }
    }
}
