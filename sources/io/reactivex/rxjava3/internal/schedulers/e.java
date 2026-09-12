package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class e extends Scheduler.Worker {

    /* renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f65643a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f65644b;

    public e(ThreadFactory threadFactory) {
        this.f65643a = g.a(threadFactory);
    }

    public ScheduledRunnable a(Runnable runnable, long j11, TimeUnit timeUnit, io.reactivex.rxjava3.disposables.d dVar) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(pz.a.t(runnable), dVar);
        if (dVar != null && !dVar.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            scheduledRunnable.setFuture(j11 <= 0 ? this.f65643a.submit((Callable) scheduledRunnable) : this.f65643a.schedule((Callable) scheduledRunnable, j11, timeUnit));
        } catch (RejectedExecutionException e11) {
            if (dVar != null) {
                dVar.a(scheduledRunnable);
            }
            pz.a.r(e11);
        }
        return scheduledRunnable;
    }

    public io.reactivex.rxjava3.disposables.c b(Runnable runnable, long j11, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(pz.a.t(runnable), true);
        try {
            scheduledDirectTask.setFuture(j11 <= 0 ? this.f65643a.submit(scheduledDirectTask) : this.f65643a.schedule(scheduledDirectTask, j11, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e11) {
            pz.a.r(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    public io.reactivex.rxjava3.disposables.c c(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Runnable t11 = pz.a.t(runnable);
        if (j12 <= 0) {
            c cVar = new c(t11, this.f65643a);
            try {
                cVar.b(j11 <= 0 ? this.f65643a.submit(cVar) : this.f65643a.schedule(cVar, j11, timeUnit));
                return cVar;
            } catch (RejectedExecutionException e11) {
                pz.a.r(e11);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(t11, true);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f65643a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e12) {
            pz.a.r(e12);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void d() {
        if (this.f65644b) {
            return;
        }
        this.f65644b = true;
        this.f65643a.shutdown();
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        if (this.f65644b) {
            return;
        }
        this.f65644b = true;
        this.f65643a.shutdownNow();
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.f65644b;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
        return this.f65644b ? EmptyDisposable.INSTANCE : a(runnable, j11, timeUnit, null);
    }
}
