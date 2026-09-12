package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class l {

    /* renamed from: f, reason: collision with root package name */
    private static final sc.a f32409f = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f32410a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f32411b;

    /* renamed from: c, reason: collision with root package name */
    private final Runtime f32412c;

    /* renamed from: d, reason: collision with root package name */
    private ScheduledFuture f32413d;

    /* renamed from: e, reason: collision with root package name */
    private long f32414e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    l(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.f32413d = null;
        this.f32414e = -1L;
        this.f32410a = scheduledExecutorService;
        this.f32411b = new ConcurrentLinkedQueue();
        this.f32412c = runtime;
    }

    private int d() {
        return com.google.firebase.perf.util.k.c(StorageUnit.BYTES.toKilobytes(this.f32412c.totalMemory() - this.f32412c.freeMemory()));
    }

    public static boolean e(long j11) {
        return j11 <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Timer timer) {
        com.google.firebase.perf.v1.b l11 = l(timer);
        if (l11 != null) {
            this.f32411b.add(l11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Timer timer) {
        com.google.firebase.perf.v1.b l11 = l(timer);
        if (l11 != null) {
            this.f32411b.add(l11);
        }
    }

    private synchronized void h(final Timer timer) {
        try {
            this.f32410a.schedule(new Runnable() { // from class: com.google.firebase.perf.session.gauges.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.f(timer);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            f32409f.j("Unable to collect Memory Metric: " + e11.getMessage());
        }
    }

    private synchronized void i(long j11, final Timer timer) {
        this.f32414e = j11;
        try {
            this.f32413d = this.f32410a.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.perf.session.gauges.j
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.g(timer);
                }
            }, 0L, j11, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            f32409f.j("Unable to start collecting Memory Metrics: " + e11.getMessage());
        }
    }

    private com.google.firebase.perf.v1.b l(Timer timer) {
        if (timer == null) {
            return null;
        }
        return (com.google.firebase.perf.v1.b) com.google.firebase.perf.v1.b.j().d(timer.getCurrentTimestampMicros()).i(d()).build();
    }

    public void c(Timer timer) {
        h(timer);
    }

    public void j(long j11, Timer timer) {
        if (e(j11)) {
            return;
        }
        if (this.f32413d == null) {
            i(j11, timer);
        } else if (this.f32414e != j11) {
            k();
            i(j11, timer);
        }
    }

    public void k() {
        ScheduledFuture scheduledFuture = this.f32413d;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f32413d = null;
        this.f32414e = -1L;
    }
}
