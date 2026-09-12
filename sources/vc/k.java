package vc;

import android.content.Context;
import android.content.pm.PackageManager;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.google.firebase.perf.application.a;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.c;
import com.google.firebase.perf.v1.g;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class k implements a.b {

    /* renamed from: r, reason: collision with root package name */
    private static final sc.a f77366r = sc.a.e();

    /* renamed from: s, reason: collision with root package name */
    private static final k f77367s = new k();

    /* renamed from: a, reason: collision with root package name */
    private final Map f77368a;

    /* renamed from: d, reason: collision with root package name */
    private com.google.firebase.f f77371d;

    /* renamed from: e, reason: collision with root package name */
    private pc.e f77372e;

    /* renamed from: f, reason: collision with root package name */
    private jc.e f77373f;

    /* renamed from: g, reason: collision with root package name */
    private ic.b f77374g;

    /* renamed from: h, reason: collision with root package name */
    private b f77375h;

    /* renamed from: j, reason: collision with root package name */
    private Context f77377j;

    /* renamed from: k, reason: collision with root package name */
    private com.google.firebase.perf.config.a f77378k;

    /* renamed from: l, reason: collision with root package name */
    private d f77379l;

    /* renamed from: m, reason: collision with root package name */
    private com.google.firebase.perf.application.a f77380m;

    /* renamed from: n, reason: collision with root package name */
    private c.b f77381n;

    /* renamed from: o, reason: collision with root package name */
    private String f77382o;

    /* renamed from: p, reason: collision with root package name */
    private String f77383p;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentLinkedQueue f77369b = new ConcurrentLinkedQueue();

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f77370c = new AtomicBoolean(false);

    /* renamed from: q, reason: collision with root package name */
    private boolean f77384q = false;

    /* renamed from: i, reason: collision with root package name */
    private ExecutorService f77376i = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private k() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f77368a = concurrentHashMap;
        concurrentHashMap.put("KEY_AVAILABLE_TRACES_FOR_CACHING", 50);
        concurrentHashMap.put("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING", 50);
        concurrentHashMap.put("KEY_AVAILABLE_GAUGES_FOR_CACHING", 50);
    }

    private com.google.firebase.perf.v1.g D(g.b bVar, ApplicationProcessState applicationProcessState) {
        G();
        c.b m11 = this.f77381n.m(applicationProcessState);
        if (bVar.e() || bVar.b()) {
            m11 = ((c.b) m11.mo842clone()).j(j());
        }
        return (com.google.firebase.perf.v1.g) bVar.d(m11).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Context k11 = this.f77371d.k();
        this.f77377j = k11;
        this.f77382o = k11.getPackageName();
        this.f77378k = com.google.firebase.perf.config.a.g();
        this.f77379l = new d(this.f77377j, new com.google.firebase.perf.util.g(100L, 1L, TimeUnit.MINUTES), 500L);
        this.f77380m = com.google.firebase.perf.application.a.b();
        this.f77375h = new b(this.f77374g, this.f77378k.a());
        h();
    }

    private void F(g.b bVar, ApplicationProcessState applicationProcessState) {
        if (!u()) {
            if (s(bVar)) {
                f77366r.b("Transport is not initialized yet, %s will be queued for to be dispatched later", o(bVar));
                this.f77369b.add(new c(bVar, applicationProcessState));
                return;
            }
            return;
        }
        com.google.firebase.perf.v1.g D = D(bVar, applicationProcessState);
        if (t(D)) {
            g(D);
            SessionManager.getInstance().stopGaugeCollectionIfSessionRunningTooLong();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void G() {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            com.google.firebase.perf.config.a r2 = r6.f77378k
            boolean r2 = r2.K()
            if (r2 == 0) goto L72
            com.google.firebase.perf.v1.c$b r2 = r6.f77381n
            boolean r2 = r2.i()
            if (r2 == 0) goto L17
            boolean r2 = r6.f77384q
            if (r2 != 0) goto L17
            return
        L17:
            jc.e r2 = r6.f77373f     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
            com.google.android.gms.tasks.Task r2 = r2.getId()     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
            r4 = 60000(0xea60, double:2.9644E-319)
            java.lang.Object r2 = com.google.android.gms.tasks.Tasks.await(r2, r4, r3)     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L2b java.util.concurrent.ExecutionException -> L2d
            goto L5f
        L29:
            r2 = move-exception
            goto L2f
        L2b:
            r2 = move-exception
            goto L3f
        L2d:
            r2 = move-exception
            goto L4f
        L2f:
            sc.a r3 = vc.k.f77366r
            java.lang.String r2 = r2.getMessage()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r2
            java.lang.String r0 = "Task to retrieve Installation Id is timed out: %s"
            r3.d(r0, r1)
            goto L5e
        L3f:
            sc.a r3 = vc.k.f77366r
            java.lang.String r2 = r2.getMessage()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r2
            java.lang.String r0 = "Task to retrieve Installation Id is interrupted: %s"
            r3.d(r0, r1)
            goto L5e
        L4f:
            sc.a r3 = vc.k.f77366r
            java.lang.String r2 = r2.getMessage()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r2
            java.lang.String r0 = "Unable to retrieve Installation Id: %s"
            r3.d(r0, r1)
        L5e:
            r2 = 0
        L5f:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L6b
            com.google.firebase.perf.v1.c$b r0 = r6.f77381n
            r0.l(r2)
            goto L72
        L6b:
            sc.a r0 = vc.k.f77366r
            java.lang.String r1 = "Firebase Installation Id is empty, contact Firebase Support for debugging."
            r0.j(r1)
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.k.G():void");
    }

    private void H() {
        if (this.f77372e == null && u()) {
            this.f77372e = pc.e.c();
        }
    }

    private void g(com.google.firebase.perf.v1.g gVar) {
        if (gVar.e()) {
            f77366r.g("Logging %s. In a minute, visit the Firebase console to view your data: %s", o(gVar), i(gVar.f()));
        } else {
            f77366r.g("Logging %s", o(gVar));
        }
        this.f77375h.b(gVar);
    }

    private void h() {
        this.f77380m.k(new WeakReference(f77367s));
        c.b u11 = com.google.firebase.perf.v1.c.u();
        this.f77381n = u11;
        u11.n(this.f77371d.n().c()).k(com.google.firebase.perf.v1.a.n().d(this.f77382o).i(pc.a.f72531b).j(p(this.f77377j)));
        this.f77370c.set(true);
        while (!this.f77369b.isEmpty()) {
            final c cVar = (c) this.f77369b.poll();
            if (cVar != null) {
                this.f77376i.execute(new Runnable() { // from class: vc.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.this.v(cVar);
                    }
                });
            }
        }
    }

    private String i(com.google.firebase.perf.v1.i iVar) {
        String E = iVar.E();
        return E.startsWith("_st_") ? sc.b.c(this.f77383p, this.f77382o, E) : sc.b.a(this.f77383p, this.f77382o, E);
    }

    private Map j() {
        H();
        pc.e eVar = this.f77372e;
        return eVar != null ? eVar.b() : Collections.emptyMap();
    }

    public static k k() {
        return f77367s;
    }

    private static String l(com.google.firebase.perf.v1.f fVar) {
        return String.format(Locale.ENGLISH, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", Boolean.valueOf(fVar.t()), Integer.valueOf(fVar.q()), Integer.valueOf(fVar.p()));
    }

    private static String m(NetworkRequestMetric networkRequestMetric) {
        return String.format(Locale.ENGLISH, "network request trace: %s (responseCode: %s, responseTime: %sms)", networkRequestMetric.I(), networkRequestMetric.L() ? String.valueOf(networkRequestMetric.A()) : NetworkUtil.NETWORK_TYPE_UNKNOWN, new DecimalFormat("#.####").format((networkRequestMetric.P() ? networkRequestMetric.G() : 0L) / 1000.0d));
    }

    private static String n(com.google.firebase.perf.v1.i iVar) {
        return String.format(Locale.ENGLISH, "trace metric: %s (duration: %sms)", iVar.E(), new DecimalFormat("#.####").format(iVar.B() / 1000.0d));
    }

    private static String o(wc.a aVar) {
        return aVar.e() ? n(aVar.f()) : aVar.b() ? m(aVar.c()) : aVar.a() ? l(aVar.g()) : "log";
    }

    private static String p(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str == null ? "" : str;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    private void q(com.google.firebase.perf.v1.g gVar) {
        if (gVar.e()) {
            this.f77380m.d(Constants$CounterNames.TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        } else if (gVar.b()) {
            this.f77380m.d(Constants$CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        }
    }

    private boolean s(wc.a aVar) {
        Integer num = (Integer) this.f77368a.get("KEY_AVAILABLE_TRACES_FOR_CACHING");
        int intValue = num.intValue();
        Integer num2 = (Integer) this.f77368a.get("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING");
        int intValue2 = num2.intValue();
        Integer num3 = (Integer) this.f77368a.get("KEY_AVAILABLE_GAUGES_FOR_CACHING");
        int intValue3 = num3.intValue();
        if (aVar.e() && intValue > 0) {
            this.f77368a.put("KEY_AVAILABLE_TRACES_FOR_CACHING", Integer.valueOf(intValue - 1));
            return true;
        }
        if (aVar.b() && intValue2 > 0) {
            this.f77368a.put("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING", Integer.valueOf(intValue2 - 1));
            return true;
        }
        if (!aVar.a() || intValue3 <= 0) {
            f77366r.b("%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d).", o(aVar), num, num2, num3);
            return false;
        }
        this.f77368a.put("KEY_AVAILABLE_GAUGES_FOR_CACHING", Integer.valueOf(intValue3 - 1));
        return true;
    }

    private boolean t(com.google.firebase.perf.v1.g gVar) {
        if (!this.f77378k.K()) {
            f77366r.g("Performance collection is not enabled, dropping %s", o(gVar));
            return false;
        }
        if (!gVar.l().q()) {
            f77366r.k("App Instance ID is null or empty, dropping %s", o(gVar));
            return false;
        }
        if (!tc.e.b(gVar, this.f77377j)) {
            f77366r.k("Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.", o(gVar));
            return false;
        }
        if (!this.f77379l.h(gVar)) {
            q(gVar);
            f77366r.g("Event dropped due to device sampling - %s", o(gVar));
            return false;
        }
        if (!this.f77379l.g(gVar)) {
            return true;
        }
        q(gVar);
        f77366r.g("Rate limited (per device) - %s", o(gVar));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(c cVar) {
        F(cVar.f77333a, cVar.f77334b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(com.google.firebase.perf.v1.i iVar, ApplicationProcessState applicationProcessState) {
        F(com.google.firebase.perf.v1.g.n().k(iVar), applicationProcessState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        F(com.google.firebase.perf.v1.g.n().j(networkRequestMetric), applicationProcessState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(com.google.firebase.perf.v1.f fVar, ApplicationProcessState applicationProcessState) {
        F(com.google.firebase.perf.v1.g.n().i(fVar), applicationProcessState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        this.f77379l.a(this.f77384q);
    }

    public void A(final com.google.firebase.perf.v1.f fVar, final ApplicationProcessState applicationProcessState) {
        this.f77376i.execute(new Runnable() { // from class: vc.f
            @Override // java.lang.Runnable
            public final void run() {
                k.this.y(fVar, applicationProcessState);
            }
        });
    }

    public void B(final NetworkRequestMetric networkRequestMetric, final ApplicationProcessState applicationProcessState) {
        this.f77376i.execute(new Runnable() { // from class: vc.h
            @Override // java.lang.Runnable
            public final void run() {
                k.this.x(networkRequestMetric, applicationProcessState);
            }
        });
    }

    public void C(final com.google.firebase.perf.v1.i iVar, final ApplicationProcessState applicationProcessState) {
        this.f77376i.execute(new Runnable() { // from class: vc.g
            @Override // java.lang.Runnable
            public final void run() {
                k.this.w(iVar, applicationProcessState);
            }
        });
    }

    @Override // com.google.firebase.perf.application.a.b
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        this.f77384q = applicationProcessState == ApplicationProcessState.FOREGROUND;
        if (u()) {
            this.f77376i.execute(new Runnable() { // from class: vc.e
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.z();
                }
            });
        }
    }

    public void r(com.google.firebase.f fVar, jc.e eVar, ic.b bVar) {
        this.f77371d = fVar;
        this.f77383p = fVar.n().e();
        this.f77373f = eVar;
        this.f77374g = bVar;
        this.f77376i.execute(new Runnable() { // from class: vc.i
            @Override // java.lang.Runnable
            public final void run() {
                k.this.E();
            }
        });
    }

    public boolean u() {
        return this.f77370c.get();
    }
}
