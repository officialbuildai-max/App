package com.google.firebase.perf.metrics;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.view.Lifecycle;
import androidx.view.d0;
import androidx.view.g0;
import androidx.view.t;
import com.google.firebase.n;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import vc.k;

/* loaded from: classes.dex */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks, t {
    private static volatile AppStartTrace A;
    private static ExecutorService B;

    /* renamed from: y, reason: collision with root package name */
    private static final Timer f32313y = new com.google.firebase.perf.util.a().a();

    /* renamed from: z, reason: collision with root package name */
    private static final long f32314z = TimeUnit.MINUTES.toMicros(1);

    /* renamed from: b, reason: collision with root package name */
    private final k f32316b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.firebase.perf.util.a f32317c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.firebase.perf.config.a f32318d;

    /* renamed from: e, reason: collision with root package name */
    private final i.b f32319e;

    /* renamed from: f, reason: collision with root package name */
    private Context f32320f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference f32321g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference f32322h;

    /* renamed from: j, reason: collision with root package name */
    private final Timer f32324j;

    /* renamed from: k, reason: collision with root package name */
    private final Timer f32325k;

    /* renamed from: t, reason: collision with root package name */
    private PerfSession f32334t;

    /* renamed from: a, reason: collision with root package name */
    private boolean f32315a = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32323i = false;

    /* renamed from: l, reason: collision with root package name */
    private Timer f32326l = null;

    /* renamed from: m, reason: collision with root package name */
    private Timer f32327m = null;

    /* renamed from: n, reason: collision with root package name */
    private Timer f32328n = null;

    /* renamed from: o, reason: collision with root package name */
    private Timer f32329o = null;

    /* renamed from: p, reason: collision with root package name */
    private Timer f32330p = null;

    /* renamed from: q, reason: collision with root package name */
    private Timer f32331q = null;

    /* renamed from: r, reason: collision with root package name */
    private Timer f32332r = null;

    /* renamed from: s, reason: collision with root package name */
    private Timer f32333s = null;

    /* renamed from: u, reason: collision with root package name */
    private boolean f32335u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f32336v = 0;

    /* renamed from: w, reason: collision with root package name */
    private final b f32337w = new b();

    /* renamed from: x, reason: collision with root package name */
    private boolean f32338x = false;

    /* loaded from: classes.dex */
    public static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartTrace trace;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.trace = appStartTrace;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.trace.f32326l == null) {
                this.trace.f32335u = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    private final class b implements ViewTreeObserver.OnDrawListener {
        private b() {
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            AppStartTrace.h(AppStartTrace.this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    AppStartTrace(k kVar, com.google.firebase.perf.util.a aVar, com.google.firebase.perf.config.a aVar2, ExecutorService executorService) {
        Timer timer;
        long startElapsedRealtime;
        this.f32316b = kVar;
        this.f32317c = aVar;
        this.f32318d = aVar2;
        B = executorService;
        this.f32319e = com.google.firebase.perf.v1.i.M().r("_experiment_app_start_ttid");
        if (Build.VERSION.SDK_INT >= 24) {
            startElapsedRealtime = Process.getStartElapsedRealtime();
            timer = Timer.ofElapsedRealtime(startElapsedRealtime);
        } else {
            timer = null;
        }
        this.f32324j = timer;
        n nVar = (n) com.google.firebase.f.l().j(n.class);
        this.f32325k = nVar != null ? Timer.ofElapsedRealtime(nVar.b()) : null;
    }

    static /* synthetic */ int h(AppStartTrace appStartTrace) {
        int i11 = appStartTrace.f32336v;
        appStartTrace.f32336v = i11 + 1;
        return i11;
    }

    private Timer i() {
        Timer timer = this.f32325k;
        return timer != null ? timer : f32313y;
    }

    public static AppStartTrace j() {
        return A != null ? A : k(k.k(), new com.google.firebase.perf.util.a());
    }

    static AppStartTrace k(k kVar, com.google.firebase.perf.util.a aVar) {
        if (A == null) {
            synchronized (AppStartTrace.class) {
                try {
                    if (A == null) {
                        A = new AppStartTrace(kVar, aVar, com.google.firebase.perf.config.a.g(), new ThreadPoolExecutor(0, 1, f32314z + 10, TimeUnit.SECONDS, new LinkedBlockingQueue()));
                    }
                } finally {
                }
            }
        }
        return A;
    }

    private Timer l() {
        Timer timer = this.f32324j;
        return timer != null ? timer : i();
    }

    public static boolean m(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = context.getPackageName();
        String str = packageName + ":";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals(packageName) || runningAppProcessInfo.processName.startsWith(str))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(i.b bVar) {
        this.f32316b.C((com.google.firebase.perf.v1.i) bVar.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        i.b q11 = com.google.firebase.perf.v1.i.M().r(Constants$TraceNames.APP_START_TRACE_NAME.toString()).p(i().getMicros()).q(i().getDurationMicros(this.f32328n));
        ArrayList arrayList = new ArrayList(3);
        arrayList.add((com.google.firebase.perf.v1.i) com.google.firebase.perf.v1.i.M().r(Constants$TraceNames.ON_CREATE_TRACE_NAME.toString()).p(i().getMicros()).q(i().getDurationMicros(this.f32326l)).build());
        if (this.f32327m != null) {
            i.b M = com.google.firebase.perf.v1.i.M();
            M.r(Constants$TraceNames.ON_START_TRACE_NAME.toString()).p(this.f32326l.getMicros()).q(this.f32326l.getDurationMicros(this.f32327m));
            arrayList.add((com.google.firebase.perf.v1.i) M.build());
            i.b M2 = com.google.firebase.perf.v1.i.M();
            M2.r(Constants$TraceNames.ON_RESUME_TRACE_NAME.toString()).p(this.f32327m.getMicros()).q(this.f32327m.getDurationMicros(this.f32328n));
            arrayList.add((com.google.firebase.perf.v1.i) M2.build());
        }
        q11.i(arrayList).j(this.f32334t.build());
        this.f32316b.C((com.google.firebase.perf.v1.i) q11.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    private void p(final i.b bVar) {
        if (this.f32331q == null || this.f32332r == null || this.f32333s == null) {
            return;
        }
        B.execute(new Runnable() { // from class: com.google.firebase.perf.metrics.f
            @Override // java.lang.Runnable
            public final void run() {
                AppStartTrace.this.n(bVar);
            }
        });
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f32333s != null) {
            return;
        }
        this.f32333s = this.f32317c.a();
        this.f32319e.k((com.google.firebase.perf.v1.i) com.google.firebase.perf.v1.i.M().r("_experiment_onDrawFoQ").p(l().getMicros()).q(l().getDurationMicros(this.f32333s)).build());
        if (this.f32324j != null) {
            this.f32319e.k((com.google.firebase.perf.v1.i) com.google.firebase.perf.v1.i.M().r("_experiment_procStart_to_classLoad").p(l().getMicros()).q(l().getDurationMicros(i())).build());
        }
        this.f32319e.o("systemDeterminedForeground", this.f32338x ? "true" : "false");
        this.f32319e.n("onDrawCount", this.f32336v);
        this.f32319e.j(this.f32334t.build());
        p(this.f32319e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f32331q != null) {
            return;
        }
        this.f32331q = this.f32317c.a();
        this.f32319e.p(l().getMicros()).q(l().getDurationMicros(this.f32331q));
        p(this.f32319e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f32332r != null) {
            return;
        }
        this.f32332r = this.f32317c.a();
        this.f32319e.k((com.google.firebase.perf.v1.i) com.google.firebase.perf.v1.i.M().r("_experiment_preDrawFoQ").p(l().getMicros()).q(l().getDurationMicros(this.f32332r)).build());
        p(this.f32319e);
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000a, B:10:0x000f, B:14:0x001d, B:16:0x003e), top: B:2:0x0001 }] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void onActivityCreated(android.app.Activity r4, android.os.Bundle r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r5 = r3.f32335u     // Catch: java.lang.Throwable -> L1a
            if (r5 != 0) goto L42
            com.google.firebase.perf.util.Timer r5 = r3.f32326l     // Catch: java.lang.Throwable -> L1a
            if (r5 == 0) goto La
            goto L42
        La:
            boolean r5 = r3.f32338x     // Catch: java.lang.Throwable -> L1a
            r0 = 1
            if (r5 != 0) goto L1c
            android.content.Context r5 = r3.f32320f     // Catch: java.lang.Throwable -> L1a
            boolean r5 = m(r5)     // Catch: java.lang.Throwable -> L1a
            if (r5 == 0) goto L18
            goto L1c
        L18:
            r5 = 0
            goto L1d
        L1a:
            r4 = move-exception
            goto L44
        L1c:
            r5 = r0
        L1d:
            r3.f32338x = r5     // Catch: java.lang.Throwable -> L1a
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch: java.lang.Throwable -> L1a
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L1a
            r3.f32321g = r5     // Catch: java.lang.Throwable -> L1a
            com.google.firebase.perf.util.a r4 = r3.f32317c     // Catch: java.lang.Throwable -> L1a
            com.google.firebase.perf.util.Timer r4 = r4.a()     // Catch: java.lang.Throwable -> L1a
            r3.f32326l = r4     // Catch: java.lang.Throwable -> L1a
            com.google.firebase.perf.util.Timer r4 = r3.l()     // Catch: java.lang.Throwable -> L1a
            com.google.firebase.perf.util.Timer r5 = r3.f32326l     // Catch: java.lang.Throwable -> L1a
            long r4 = r4.getDurationMicros(r5)     // Catch: java.lang.Throwable -> L1a
            long r1 = com.google.firebase.perf.metrics.AppStartTrace.f32314z     // Catch: java.lang.Throwable -> L1a
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 <= 0) goto L40
            r3.f32323i = r0     // Catch: java.lang.Throwable -> L1a
        L40:
            monitor-exit(r3)
            return
        L42:
            monitor-exit(r3)
            return
        L44:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1a
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        View findViewById;
        if (this.f32335u || this.f32323i || !this.f32318d.h() || (findViewById = activity.findViewById(R.id.content)) == null) {
            return;
        }
        findViewById.getViewTreeObserver().removeOnDrawListener(this.f32337w);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        View findViewById;
        try {
            if (!this.f32335u && !this.f32323i) {
                boolean h11 = this.f32318d.h();
                if (h11 && (findViewById = activity.findViewById(R.id.content)) != null) {
                    findViewById.getViewTreeObserver().addOnDrawListener(this.f32337w);
                    com.google.firebase.perf.util.c.e(findViewById, new Runnable() { // from class: com.google.firebase.perf.metrics.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppStartTrace.this.q();
                        }
                    });
                    com.google.firebase.perf.util.f.a(findViewById, new Runnable() { // from class: com.google.firebase.perf.metrics.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppStartTrace.this.r();
                        }
                    }, new Runnable() { // from class: com.google.firebase.perf.metrics.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppStartTrace.this.s();
                        }
                    });
                }
                if (this.f32328n != null) {
                    return;
                }
                this.f32322h = new WeakReference(activity);
                this.f32328n = this.f32317c.a();
                this.f32334t = SessionManager.getInstance().perfSession();
                sc.a.e().a("onResume(): " + activity.getClass().getName() + ": " + i().getDurationMicros(this.f32328n) + " microseconds");
                B.execute(new Runnable() { // from class: com.google.firebase.perf.metrics.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppStartTrace.this.o();
                    }
                });
                if (!h11) {
                    u();
                }
            }
        } finally {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (!this.f32335u && this.f32327m == null && !this.f32323i) {
            this.f32327m = this.f32317c.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Keep
    @d0(Lifecycle.Event.ON_STOP)
    public void onAppEnteredBackground() {
        if (this.f32335u || this.f32323i || this.f32330p != null) {
            return;
        }
        this.f32330p = this.f32317c.a();
        this.f32319e.k((com.google.firebase.perf.v1.i) com.google.firebase.perf.v1.i.M().r("_experiment_firstBackgrounding").p(l().getMicros()).q(l().getDurationMicros(this.f32330p)).build());
    }

    @Keep
    @d0(Lifecycle.Event.ON_START)
    public void onAppEnteredForeground() {
        if (this.f32335u || this.f32323i || this.f32329o != null) {
            return;
        }
        this.f32329o = this.f32317c.a();
        this.f32319e.k((com.google.firebase.perf.v1.i) com.google.firebase.perf.v1.i.M().r("_experiment_firstForegrounding").p(l().getMicros()).q(l().getDurationMicros(this.f32329o)).build());
    }

    public synchronized void t(Context context) {
        boolean z10;
        try {
            if (this.f32315a) {
                return;
            }
            g0.l().getLifecycle().a(this);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
                if (!this.f32338x && !m(applicationContext)) {
                    z10 = false;
                    this.f32338x = z10;
                    this.f32315a = true;
                    this.f32320f = applicationContext;
                }
                z10 = true;
                this.f32338x = z10;
                this.f32315a = true;
                this.f32320f = applicationContext;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void u() {
        if (this.f32315a) {
            g0.l().getLifecycle().d(this);
            ((Application) this.f32320f).unregisterActivityLifecycleCallbacks(this);
            this.f32315a = false;
        }
    }
}
