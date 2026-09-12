package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private final Context f31320a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.firebase.f f31321b;

    /* renamed from: c, reason: collision with root package name */
    private final d0 f31322c;

    /* renamed from: f, reason: collision with root package name */
    private y f31325f;

    /* renamed from: g, reason: collision with root package name */
    private y f31326g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f31327h;

    /* renamed from: i, reason: collision with root package name */
    private n f31328i;

    /* renamed from: j, reason: collision with root package name */
    private final g0 f31329j;

    /* renamed from: k, reason: collision with root package name */
    private final vb.g f31330k;

    /* renamed from: l, reason: collision with root package name */
    public final qb.b f31331l;

    /* renamed from: m, reason: collision with root package name */
    private final pb.a f31332m;

    /* renamed from: n, reason: collision with root package name */
    private final k f31333n;

    /* renamed from: o, reason: collision with root package name */
    private final ob.a f31334o;

    /* renamed from: p, reason: collision with root package name */
    private final ob.l f31335p;

    /* renamed from: q, reason: collision with root package name */
    private final CrashlyticsWorkers f31336q;

    /* renamed from: e, reason: collision with root package name */
    private final long f31324e = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    private final l0 f31323d = new l0();

    public x(com.google.firebase.f fVar, g0 g0Var, ob.a aVar, d0 d0Var, qb.b bVar, pb.a aVar2, vb.g gVar, k kVar, ob.l lVar, CrashlyticsWorkers crashlyticsWorkers) {
        this.f31321b = fVar;
        this.f31322c = d0Var;
        this.f31320a = fVar.k();
        this.f31329j = g0Var;
        this.f31334o = aVar;
        this.f31331l = bVar;
        this.f31332m = aVar2;
        this.f31330k = gVar;
        this.f31333n = kVar;
        this.f31335p = lVar;
        this.f31336q = crashlyticsWorkers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(String str) {
        this.f31328i.Y(str);
    }

    private void i() {
        try {
            this.f31327h = Boolean.TRUE.equals((Boolean) this.f31336q.f31351a.c().submit(new Callable() { // from class: com.google.firebase.crashlytics.internal.common.s
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean t11;
                    t11 = x.this.t();
                    return t11;
                }
            }).get(3L, TimeUnit.SECONDS));
        } catch (Exception unused) {
            this.f31327h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void v(wb.b bVar) {
        CrashlyticsWorkers.c();
        E();
        try {
            try {
                this.f31331l.a(new qb.a() { // from class: com.google.firebase.crashlytics.internal.common.v
                    @Override // qb.a
                    public final void a(String str) {
                        x.this.B(str);
                    }
                });
                this.f31328i.U();
            } catch (Exception e11) {
                ob.g.f().e("Crashlytics encountered a problem during asynchronous initialization.", e11);
            }
            if (!bVar.b().f31792b.f31799a) {
                ob.g.f().b("Collection of crash reports disabled in Crashlytics settings.");
                throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
            }
            if (!this.f31328i.A(bVar)) {
                ob.g.f().k("Previous sessions could not be finalized.");
            }
            this.f31328i.Z(bVar.a());
            D();
        } catch (Throwable th2) {
            D();
            throw th2;
        }
    }

    private void p(final wb.b bVar) {
        Future<?> submit = this.f31336q.f31351a.c().submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.u
            @Override // java.lang.Runnable
            public final void run() {
                x.this.v(bVar);
            }
        });
        ob.g.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            ob.g.f().e("Crashlytics was interrupted during initialization.", e11);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e12) {
            ob.g.f().e("Crashlytics encountered a problem during initialization.", e12);
        } catch (TimeoutException e13) {
            ob.g.f().e("Crashlytics timed out during initialization.", e13);
        }
    }

    public static String q() {
        return "19.3.0";
    }

    static boolean r(String str, boolean z10) {
        if (!z10) {
            ob.g.f().i("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean t() {
        return Boolean.valueOf(this.f31328i.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(long j11, String str) {
        this.f31328i.d0(j11, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(final long j11, final String str) {
        this.f31336q.f31352b.f(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.w
            @Override // java.lang.Runnable
            public final void run() {
                x.this.w(j11, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Throwable th2) {
        this.f31328i.c0(Thread.currentThread(), th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(String str, String str2) {
        this.f31328i.W(str, str2);
    }

    public void B(final String str) {
        final long currentTimeMillis = System.currentTimeMillis() - this.f31324e;
        this.f31336q.f31351a.f(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.t
            @Override // java.lang.Runnable
            public final void run() {
                x.this.x(currentTimeMillis, str);
            }
        });
    }

    public void C(final Throwable th2) {
        this.f31336q.f31351a.f(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.p
            @Override // java.lang.Runnable
            public final void run() {
                x.this.y(th2);
            }
        });
    }

    void D() {
        CrashlyticsWorkers.c();
        try {
            if (this.f31325f.d()) {
                return;
            }
            ob.g.f().k("Initialization marker file was not properly removed.");
        } catch (Exception e11) {
            ob.g.f().e("Problem encountered deleting Crashlytics initialization marker.", e11);
        }
    }

    void E() {
        CrashlyticsWorkers.c();
        this.f31325f.a();
        ob.g.f().i("Initialization marker file was created.");
    }

    public boolean F(a aVar, wb.b bVar) {
        if (!r(aVar.f31192b, CommonUtils.i(this.f31320a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
        String c11 = new g().c();
        try {
            this.f31326g = new y("crash_marker", this.f31330k);
            this.f31325f = new y("initialization_marker", this.f31330k);
            rb.o oVar = new rb.o(c11, this.f31330k, this.f31336q);
            rb.e eVar = new rb.e(this.f31330k);
            xb.a aVar2 = new xb.a(1024, new xb.c(10));
            this.f31335p.c(oVar);
            this.f31328i = new n(this.f31320a, this.f31329j, this.f31322c, this.f31330k, this.f31326g, aVar, oVar, eVar, w0.i(this.f31320a, this.f31329j, this.f31330k, aVar, eVar, oVar, aVar2, bVar, this.f31323d, this.f31333n, this.f31336q), this.f31334o, this.f31332m, this.f31333n, this.f31336q);
            boolean m11 = m();
            i();
            this.f31328i.y(c11, Thread.getDefaultUncaughtExceptionHandler(), bVar);
            if (!m11 || !CommonUtils.d(this.f31320a)) {
                ob.g.f().b("Successfully configured exception handler.");
                return true;
            }
            ob.g.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            p(bVar);
            return false;
        } catch (Exception e11) {
            ob.g.f().e("Crashlytics was not started due to an exception during initialization", e11);
            this.f31328i = null;
            return false;
        }
    }

    public Task G() {
        return this.f31328i.V();
    }

    public void H(Boolean bool) {
        this.f31322c.h(bool);
    }

    public void I(final String str, final String str2) {
        this.f31336q.f31351a.f(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.r
            @Override // java.lang.Runnable
            public final void run() {
                x.this.z(str, str2);
            }
        });
    }

    public void J(final String str) {
        this.f31336q.f31351a.f(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.q
            @Override // java.lang.Runnable
            public final void run() {
                x.this.A(str);
            }
        });
    }

    public Task j() {
        return this.f31328i.n();
    }

    public Task k() {
        return this.f31328i.s();
    }

    public boolean l() {
        return this.f31327h;
    }

    boolean m() {
        return this.f31325f.c();
    }

    public Task o(final wb.b bVar) {
        return this.f31336q.f31351a.f(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.o
            @Override // java.lang.Runnable
            public final void run() {
                x.this.u(bVar);
            }
        });
    }

    public boolean s() {
        return this.f31322c.d();
    }
}
