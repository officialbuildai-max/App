package com.google.firebase.crashlytics.internal.send;

import android.os.SystemClock;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.l;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.a0;
import com.google.firebase.crashlytics.internal.common.l0;
import com.google.firebase.crashlytics.internal.common.z0;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ob.g;
import r8.h;
import r8.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ReportQueue {

    /* renamed from: a, reason: collision with root package name */
    private final double f31765a;

    /* renamed from: b, reason: collision with root package name */
    private final double f31766b;

    /* renamed from: c, reason: collision with root package name */
    private final long f31767c;

    /* renamed from: d, reason: collision with root package name */
    private final long f31768d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31769e;

    /* renamed from: f, reason: collision with root package name */
    private final BlockingQueue f31770f;

    /* renamed from: g, reason: collision with root package name */
    private final ThreadPoolExecutor f31771g;

    /* renamed from: h, reason: collision with root package name */
    private final h f31772h;

    /* renamed from: i, reason: collision with root package name */
    private final l0 f31773i;

    /* renamed from: j, reason: collision with root package name */
    private int f31774j;

    /* renamed from: k, reason: collision with root package name */
    private long f31775k;

    /* loaded from: classes4.dex */
    private final class ReportRunnable implements Runnable {
        private final a0 reportWithSessionId;
        private final TaskCompletionSource<a0> tcs;

        private ReportRunnable(a0 a0Var, TaskCompletionSource<a0> taskCompletionSource) {
            this.reportWithSessionId = a0Var;
            this.tcs = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            ReportQueue.this.p(this.reportWithSessionId, this.tcs);
            ReportQueue.this.f31773i.c();
            double g11 = ReportQueue.this.g();
            g.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(g11 / 1000.0d)) + " s for report: " + this.reportWithSessionId.d());
            ReportQueue.q(g11);
        }
    }

    ReportQueue(double d11, double d12, long j11, h hVar, l0 l0Var) {
        this.f31765a = d11;
        this.f31766b = d12;
        this.f31767c = j11;
        this.f31772h = hVar;
        this.f31773i = l0Var;
        this.f31768d = SystemClock.elapsedRealtime();
        int i11 = (int) d11;
        this.f31769e = i11;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i11);
        this.f31770f = arrayBlockingQueue;
        this.f31771g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f31774j = 0;
        this.f31775k = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReportQueue(h hVar, com.google.firebase.crashlytics.internal.settings.c cVar, l0 l0Var) {
        this(cVar.f31796f, cVar.f31797g, cVar.f31798h * 1000, hVar, l0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double g() {
        return Math.min(3600000.0d, (60000.0d / this.f31765a) * Math.pow(this.f31766b, h()));
    }

    private int h() {
        if (this.f31775k == 0) {
            this.f31775k = o();
        }
        int o11 = (int) ((o() - this.f31775k) / this.f31767c);
        int min = l() ? Math.min(100, this.f31774j + o11) : Math.max(0, this.f31774j - o11);
        if (this.f31774j != min) {
            this.f31774j = min;
            this.f31775k = o();
        }
        return min;
    }

    private boolean k() {
        return this.f31770f.size() < this.f31769e;
    }

    private boolean l() {
        return this.f31770f.size() == this.f31769e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(CountDownLatch countDownLatch) {
        try {
            l.a(this.f31772h, Priority.HIGHEST);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(TaskCompletionSource taskCompletionSource, boolean z10, a0 a0Var, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
            return;
        }
        if (z10) {
            j();
        }
        taskCompletionSource.trySetResult(a0Var);
    }

    private long o() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final a0 a0Var, final TaskCompletionSource taskCompletionSource) {
        g.f().b("Sending report through Google DataTransport: " + a0Var.d());
        final boolean z10 = SystemClock.elapsedRealtime() - this.f31768d < 2000;
        this.f31772h.a(r8.d.h(a0Var.b()), new j() { // from class: com.google.firebase.crashlytics.internal.send.c
            @Override // r8.j
            public final void a(Exception exc) {
                ReportQueue.this.n(taskCompletionSource, z10, a0Var, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(double d11) {
        try {
            Thread.sleep((long) d11);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskCompletionSource i(a0 a0Var, boolean z10) {
        synchronized (this.f31770f) {
            try {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                if (!z10) {
                    p(a0Var, taskCompletionSource);
                    return taskCompletionSource;
                }
                this.f31773i.b();
                if (!k()) {
                    h();
                    g.f().b("Dropping report due to queue being full: " + a0Var.d());
                    this.f31773i.a();
                    taskCompletionSource.trySetResult(a0Var);
                    return taskCompletionSource;
                }
                g.f().b("Enqueueing report: " + a0Var.d());
                g.f().b("Queue size: " + this.f31770f.size());
                this.f31771g.execute(new ReportRunnable(a0Var, taskCompletionSource));
                g.f().b("Closing task for report: " + a0Var.d());
                taskCompletionSource.trySetResult(a0Var);
                return taskCompletionSource;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void j() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.google.firebase.crashlytics.internal.send.d
            @Override // java.lang.Runnable
            public final void run() {
                ReportQueue.this.m(countDownLatch);
            }
        }).start();
        z0.c(countDownLatch, 2L, TimeUnit.SECONDS);
    }
}
