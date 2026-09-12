package com.google.firebase.messaging;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.u0;
import com.google.firebase.messaging.y0;
import hc.a;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class FirebaseMessaging {

    /* renamed from: m, reason: collision with root package name */
    private static y0 f32019m;

    /* renamed from: o, reason: collision with root package name */
    static ScheduledExecutorService f32021o;

    /* renamed from: a, reason: collision with root package name */
    private final com.google.firebase.f f32022a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f32023b;

    /* renamed from: c, reason: collision with root package name */
    private final e0 f32024c;

    /* renamed from: d, reason: collision with root package name */
    private final u0 f32025d;

    /* renamed from: e, reason: collision with root package name */
    private final a f32026e;

    /* renamed from: f, reason: collision with root package name */
    private final Executor f32027f;

    /* renamed from: g, reason: collision with root package name */
    private final Executor f32028g;

    /* renamed from: h, reason: collision with root package name */
    private final Task f32029h;

    /* renamed from: i, reason: collision with root package name */
    private final j0 f32030i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f32031j;

    /* renamed from: k, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f32032k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f32018l = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: n, reason: collision with root package name */
    static ic.b f32020n = new ic.b() { // from class: com.google.firebase.messaging.q
        @Override // ic.b
        public final Object get() {
            r8.i H;
            H = FirebaseMessaging.H();
            return H;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private final fc.d f32033a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f32034b;

        /* renamed from: c, reason: collision with root package name */
        private fc.b f32035c;

        /* renamed from: d, reason: collision with root package name */
        private Boolean f32036d;

        a(fc.d dVar) {
            this.f32033a = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(fc.a aVar) {
            if (c()) {
                FirebaseMessaging.this.N();
            }
        }

        private Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context k11 = FirebaseMessaging.this.f32022a.k();
            SharedPreferences sharedPreferences = k11.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = k11.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(k11.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void b() {
            try {
                if (this.f32034b) {
                    return;
                }
                Boolean e11 = e();
                this.f32036d = e11;
                if (e11 == null) {
                    fc.b bVar = new fc.b() { // from class: com.google.firebase.messaging.b0
                        @Override // fc.b
                        public final void a(fc.a aVar) {
                            FirebaseMessaging.a.this.d(aVar);
                        }
                    };
                    this.f32035c = bVar;
                    this.f32033a.b(com.google.firebase.b.class, bVar);
                }
                this.f32034b = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }

        synchronized boolean c() {
            Boolean bool;
            try {
                b();
                bool = this.f32036d;
            } catch (Throwable th2) {
                throw th2;
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f32022a.t();
        }
    }

    FirebaseMessaging(com.google.firebase.f fVar, hc.a aVar, ic.b bVar, fc.d dVar, j0 j0Var, e0 e0Var, Executor executor, Executor executor2, Executor executor3) {
        this.f32031j = false;
        f32020n = bVar;
        this.f32022a = fVar;
        this.f32026e = new a(dVar);
        Context k11 = fVar.k();
        this.f32023b = k11;
        p pVar = new p();
        this.f32032k = pVar;
        this.f32030i = j0Var;
        this.f32024c = e0Var;
        this.f32025d = new u0(executor);
        this.f32027f = executor2;
        this.f32028g = executor3;
        Context k12 = fVar.k();
        if (k12 instanceof Application) {
            ((Application) k12).registerActivityLifecycleCallbacks(pVar);
        } else {
            Log.w("FirebaseMessaging", "Context " + k12 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.a(new a.InterfaceC0804a() { // from class: com.google.firebase.messaging.u
            });
        }
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.v
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.E();
            }
        });
        Task f11 = c1.f(this, j0Var, e0Var, k11, n.g());
        this.f32029h = f11;
        f11.addOnSuccessListener(executor2, new OnSuccessListener() { // from class: com.google.firebase.messaging.w
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseMessaging.this.F((c1) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.x
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.G();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(com.google.firebase.f fVar, hc.a aVar, ic.b bVar, ic.b bVar2, jc.e eVar, ic.b bVar3, fc.d dVar) {
        this(fVar, aVar, bVar, bVar2, eVar, bVar3, dVar, new j0(fVar.k()));
    }

    FirebaseMessaging(com.google.firebase.f fVar, hc.a aVar, ic.b bVar, ic.b bVar2, jc.e eVar, ic.b bVar3, fc.d dVar, j0 j0Var) {
        this(fVar, aVar, bVar3, dVar, j0Var, new e0(fVar, j0Var, bVar, bVar2, eVar), n.f(), n.c(), n.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task A(String str, y0.a aVar, String str2) {
        q(this.f32023b).f(r(), str, str2, this.f32030i.a());
        if (aVar == null || !str2.equals(aVar.f32239a)) {
            x(str2);
        }
        return Tasks.forResult(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task B(final String str, final y0.a aVar) {
        return this.f32024c.f().onSuccessTask(this.f32028g, new SuccessContinuation() { // from class: com.google.firebase.messaging.z
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task A;
                A = FirebaseMessaging.this.A(str, aVar, (String) obj);
                return A;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(m());
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(CloudMessage cloudMessage) {
        if (cloudMessage != null) {
            i0.y(cloudMessage.getIntent());
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        if (y()) {
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(c1 c1Var) {
        if (y()) {
            c1Var.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r8.i H() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task I(String str, c1 c1Var) {
        return c1Var.r(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task J(String str, c1 c1Var) {
        return c1Var.u(str);
    }

    private boolean L() {
        p0.c(this.f32023b);
        if (!p0.d(this.f32023b)) {
            return false;
        }
        if (this.f32022a.j(kb.a.class) != null) {
            return true;
        }
        return i0.a() && f32020n != null;
    }

    private synchronized void M() {
        if (!this.f32031j) {
            P(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (Q(t())) {
            M();
        }
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull com.google.firebase.f fVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) fVar.j(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public static synchronized FirebaseMessaging p() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(com.google.firebase.f.l());
        }
        return firebaseMessaging;
    }

    private static synchronized y0 q(Context context) {
        y0 y0Var;
        synchronized (FirebaseMessaging.class) {
            try {
                if (f32019m == null) {
                    f32019m = new y0(context);
                }
                y0Var = f32019m;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return y0Var;
    }

    private String r() {
        return "[DEFAULT]".equals(this.f32022a.m()) ? "" : this.f32022a.o();
    }

    public static r8.i u() {
        return (r8.i) f32020n.get();
    }

    private void v() {
        this.f32024c.e().addOnSuccessListener(this.f32027f, new OnSuccessListener() { // from class: com.google.firebase.messaging.y
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseMessaging.this.D((CloudMessage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void G() {
        p0.c(this.f32023b);
        r0.g(this.f32023b, this.f32024c, L());
        if (L()) {
            v();
        }
    }

    private void x(String str) {
        if ("[DEFAULT]".equals(this.f32022a.m())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invoking onNewToken for app: ");
                sb2.append(this.f32022a.m());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new m(this.f32023b).k(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void K(boolean z10) {
        this.f32031j = z10;
    }

    public Task O(final String str) {
        return this.f32029h.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.a0
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task I;
                I = FirebaseMessaging.I(str, (c1) obj);
                return I;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void P(long j11) {
        n(new SyncTask(this, Math.min(Math.max(30L, 2 * j11), f32018l)), j11);
        this.f32031j = true;
    }

    boolean Q(y0.a aVar) {
        return aVar == null || aVar.b(this.f32030i.a());
    }

    public Task R(final String str) {
        return this.f32029h.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.r
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task J;
                J = FirebaseMessaging.J(str, (c1) obj);
                return J;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        final y0.a t11 = t();
        if (!Q(t11)) {
            return t11.f32239a;
        }
        final String c11 = j0.c(this.f32022a);
        try {
            return (String) Tasks.await(this.f32025d.b(c11, new u0.a() { // from class: com.google.firebase.messaging.t
                @Override // com.google.firebase.messaging.u0.a
                public final Task start() {
                    Task B;
                    B = FirebaseMessaging.this.B(c11, t11);
                    return B;
                }
            }));
        } catch (InterruptedException | ExecutionException e11) {
            throw new IOException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Runnable runnable, long j11) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f32021o == null) {
                    f32021o = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
                }
                f32021o.schedule(runnable, j11, TimeUnit.SECONDS);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context o() {
        return this.f32023b;
    }

    public Task s() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f32027f.execute(new Runnable() { // from class: com.google.firebase.messaging.s
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.C(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    y0.a t() {
        return q(this.f32023b).d(r(), j0.c(this.f32022a));
    }

    public boolean y() {
        return this.f32026e.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        return this.f32030i.g();
    }
}
