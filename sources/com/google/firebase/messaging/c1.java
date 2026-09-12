package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c1 {

    /* renamed from: i, reason: collision with root package name */
    private static final long f32105i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a, reason: collision with root package name */
    private final Context f32106a;

    /* renamed from: b, reason: collision with root package name */
    private final j0 f32107b;

    /* renamed from: c, reason: collision with root package name */
    private final e0 f32108c;

    /* renamed from: d, reason: collision with root package name */
    private final FirebaseMessaging f32109d;

    /* renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f32111f;

    /* renamed from: h, reason: collision with root package name */
    private final a1 f32113h;

    /* renamed from: e, reason: collision with root package name */
    private final Map f32110e = new androidx.collection.a();

    /* renamed from: g, reason: collision with root package name */
    private boolean f32112g = false;

    private c1(FirebaseMessaging firebaseMessaging, j0 j0Var, a1 a1Var, e0 e0Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f32109d = firebaseMessaging;
        this.f32107b = j0Var;
        this.f32113h = a1Var;
        this.f32108c = e0Var;
        this.f32106a = context;
        this.f32111f = scheduledExecutorService;
    }

    private void b(z0 z0Var, TaskCompletionSource taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.f32110e) {
            try {
                String e11 = z0Var.e();
                if (this.f32110e.containsKey(e11)) {
                    arrayDeque = (ArrayDeque) this.f32110e.get(e11);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f32110e.put(e11, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void c(Task task) {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            e = e11;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e12);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e13) {
            e = e13;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    private void d(String str) {
        c(this.f32108c.m(this.f32109d.m(), str));
    }

    private void e(String str) {
        c(this.f32108c.n(this.f32109d.m(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Task f(final FirebaseMessaging firebaseMessaging, final j0 j0Var, final e0 e0Var, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.b1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                c1 j11;
                j11 = c1.j(context, scheduledExecutorService, firebaseMessaging, j0Var, e0Var);
                return j11;
            }
        });
    }

    static boolean h() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c1 j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, j0 j0Var, e0 e0Var) {
        return new c1(firebaseMessaging, j0Var, a1.b(context, scheduledExecutorService), e0Var, context, scheduledExecutorService);
    }

    private void k(z0 z0Var) {
        synchronized (this.f32110e) {
            try {
                String e11 = z0Var.e();
                if (this.f32110e.containsKey(e11)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f32110e.get(e11);
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) arrayDeque.poll();
                    if (taskCompletionSource != null) {
                        taskCompletionSource.setResult(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.f32110e.remove(e11);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void p() {
        if (i()) {
            return;
        }
        t(0L);
    }

    boolean g() {
        return this.f32113h.c() != null;
    }

    synchronized boolean i() {
        return this.f32112g;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[Catch: IOException -> 0x001d, TryCatch #0 {IOException -> 0x001d, blocks: (B:3:0x0001, B:12:0x0030, B:14:0x0036, B:17:0x0049, B:19:0x0056, B:20:0x006b, B:22:0x0078, B:23:0x0013, B:26:0x001f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean l(com.google.firebase.messaging.z0 r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r6.b()     // Catch: java.io.IOException -> L1d
            int r2 = r1.hashCode()     // Catch: java.io.IOException -> L1d
            r3 = 83
            r4 = 1
            if (r2 == r3) goto L1f
            r3 = 85
            if (r2 == r3) goto L13
            goto L29
        L13:
            java.lang.String r2 = "U"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L1d
            if (r1 == 0) goto L29
            r1 = r4
            goto L2a
        L1d:
            r6 = move-exception
            goto L8d
        L1f:
            java.lang.String r2 = "S"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L1d
            if (r1 == 0) goto L29
            r1 = r0
            goto L2a
        L29:
            r1 = -1
        L2a:
            java.lang.String r2 = " succeeded."
            if (r1 == 0) goto L6b
            if (r1 == r4) goto L49
            boolean r1 = h()     // Catch: java.io.IOException -> L1d
            if (r1 == 0) goto L8c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L1d
            r1.<init>()     // Catch: java.io.IOException -> L1d
            java.lang.String r2 = "Unknown topic operation"
            r1.append(r2)     // Catch: java.io.IOException -> L1d
            r1.append(r6)     // Catch: java.io.IOException -> L1d
            java.lang.String r6 = "."
            r1.append(r6)     // Catch: java.io.IOException -> L1d
            goto L8c
        L49:
            java.lang.String r1 = r6.c()     // Catch: java.io.IOException -> L1d
            r5.e(r1)     // Catch: java.io.IOException -> L1d
            boolean r1 = h()     // Catch: java.io.IOException -> L1d
            if (r1 == 0) goto L8c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L1d
            r1.<init>()     // Catch: java.io.IOException -> L1d
            java.lang.String r3 = "Unsubscribe from topic: "
            r1.append(r3)     // Catch: java.io.IOException -> L1d
            java.lang.String r6 = r6.c()     // Catch: java.io.IOException -> L1d
            r1.append(r6)     // Catch: java.io.IOException -> L1d
            r1.append(r2)     // Catch: java.io.IOException -> L1d
            goto L8c
        L6b:
            java.lang.String r1 = r6.c()     // Catch: java.io.IOException -> L1d
            r5.d(r1)     // Catch: java.io.IOException -> L1d
            boolean r1 = h()     // Catch: java.io.IOException -> L1d
            if (r1 == 0) goto L8c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L1d
            r1.<init>()     // Catch: java.io.IOException -> L1d
            java.lang.String r3 = "Subscribe to topic: "
            r1.append(r3)     // Catch: java.io.IOException -> L1d
            java.lang.String r6 = r6.c()     // Catch: java.io.IOException -> L1d
            r1.append(r6)     // Catch: java.io.IOException -> L1d
            r1.append(r2)     // Catch: java.io.IOException -> L1d
        L8c:
            return r4
        L8d:
            java.lang.String r1 = "SERVICE_NOT_AVAILABLE"
            java.lang.String r2 = r6.getMessage()
            boolean r1 = r1.equals(r2)
            java.lang.String r2 = "FirebaseMessaging"
            if (r1 != 0) goto Lc1
            java.lang.String r1 = "INTERNAL_SERVER_ERROR"
            java.lang.String r3 = r6.getMessage()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto Lc1
            java.lang.String r1 = "TOO_MANY_SUBSCRIBERS"
            java.lang.String r3 = r6.getMessage()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto Lb4
            goto Lc1
        Lb4:
            java.lang.String r1 = r6.getMessage()
            if (r1 != 0) goto Lc0
            java.lang.String r6 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r2, r6)
            return r0
        Lc0:
            throw r6
        Lc1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Topic operation failed: "
            r1.append(r3)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = ". Will retry Topic operation."
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            android.util.Log.e(r2, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.c1.l(com.google.firebase.messaging.z0):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable, long j11) {
        this.f32111f.schedule(runnable, j11, TimeUnit.SECONDS);
    }

    Task n(z0 z0Var) {
        this.f32113h.a(z0Var);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        b(z0Var, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void o(boolean z10) {
        this.f32112g = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        if (g()) {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task r(String str) {
        Task n11 = n(z0.f(str));
        q();
        return n11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        while (true) {
            synchronized (this) {
                try {
                    z0 c11 = this.f32113h.c();
                    if (c11 == null) {
                        h();
                        return true;
                    }
                    if (!l(c11)) {
                        return false;
                    }
                    this.f32113h.e(c11);
                    k(c11);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(long j11) {
        m(new TopicsSyncTask(this, this.f32106a, this.f32107b, Math.min(Math.max(30L, 2 * j11), f32105i)), j11);
        o(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task u(String str) {
        Task n11 = n(z0.g(str));
        q();
        return n11;
    }
}
