package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.j1;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
class j1 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Context f32157a;

    /* renamed from: b, reason: collision with root package name */
    private final Intent f32158b;

    /* renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f32159c;

    /* renamed from: d, reason: collision with root package name */
    private final Queue f32160d;

    /* renamed from: e, reason: collision with root package name */
    private g1 f32161e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f32162f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Intent f32163a;

        /* renamed from: b, reason: collision with root package name */
        private final TaskCompletionSource f32164b = new TaskCompletionSource();

        a(Intent intent) {
            this.f32163a = intent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + this.f32163a.getAction() + " finishing.");
            d();
        }

        void c(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.messaging.h1
                @Override // java.lang.Runnable
                public final void run() {
                    j1.a.this.f();
                }
            }, 20L, TimeUnit.SECONDS);
            e().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener() { // from class: com.google.firebase.messaging.i1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    schedule.cancel(false);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d() {
            this.f32164b.trySetResult(null);
        }

        Task e() {
            return this.f32164b.getTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j1(Context context, String str) {
        this(context, str, a());
    }

    j1(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f32160d = new ArrayDeque();
        this.f32162f = false;
        Context applicationContext = context.getApplicationContext();
        this.f32157a = applicationContext;
        this.f32158b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f32159c = scheduledExecutorService;
    }

    private static ScheduledThreadPoolExecutor a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    private void b() {
        while (!this.f32160d.isEmpty()) {
            ((a) this.f32160d.poll()).d();
        }
    }

    private synchronized void c() {
        try {
            Log.isLoggable("FirebaseMessaging", 3);
            while (!this.f32160d.isEmpty()) {
                Log.isLoggable("FirebaseMessaging", 3);
                g1 g1Var = this.f32161e;
                if (g1Var == null || !g1Var.isBinderAlive()) {
                    e();
                    return;
                } else {
                    Log.isLoggable("FirebaseMessaging", 3);
                    this.f32161e.c((a) this.f32160d.poll());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void e() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("binder is dead. start connection? ");
            sb2.append(!this.f32162f);
        }
        if (this.f32162f) {
            return;
        }
        this.f32162f = true;
        try {
        } catch (SecurityException e11) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e11);
        }
        if (ConnectionTracker.getInstance().bindService(this.f32157a, this.f32158b, this, 65)) {
            return;
        }
        Log.e("FirebaseMessaging", "binding to the service failed");
        this.f32162f = false;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Task d(Intent intent) {
        a aVar;
        Log.isLoggable("FirebaseMessaging", 3);
        aVar = new a(intent);
        aVar.c(this.f32159c);
        this.f32160d.add(aVar);
        c();
        return aVar.e();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onServiceConnected: ");
                sb2.append(componentName);
            }
            this.f32162f = false;
            if (iBinder instanceof g1) {
                this.f32161e = (g1) iBinder;
                c();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            b();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServiceDisconnected: ");
            sb2.append(componentName);
        }
        c();
    }
}
