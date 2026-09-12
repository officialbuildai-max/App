package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class h extends Scheduler {

    /* renamed from: e, reason: collision with root package name */
    static final RxThreadFactory f65646e;

    /* renamed from: f, reason: collision with root package name */
    static final ScheduledExecutorService f65647f;

    /* renamed from: c, reason: collision with root package name */
    final ThreadFactory f65648c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference f65649d;

    /* loaded from: classes7.dex */
    static final class a extends Scheduler.Worker {

        /* renamed from: a, reason: collision with root package name */
        final ScheduledExecutorService f65650a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.rxjava3.disposables.a f65651b = new io.reactivex.rxjava3.disposables.a();

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f65652c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f65650a = scheduledExecutorService;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            if (this.f65652c) {
                return;
            }
            this.f65652c = true;
            this.f65651b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65652c;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (this.f65652c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(pz.a.t(runnable), this.f65651b);
            this.f65651b.b(scheduledRunnable);
            try {
                scheduledRunnable.setFuture(j11 <= 0 ? this.f65650a.submit((Callable) scheduledRunnable) : this.f65650a.schedule((Callable) scheduledRunnable, j11, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e11) {
                dispose();
                pz.a.r(e11);
                return EmptyDisposable.INSTANCE;
            }
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f65647f = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f65646e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);
    }

    public h() {
        this(f65646e);
    }

    public h(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.f65649d = atomicReference;
        this.f65648c = threadFactory;
        atomicReference.lazySet(g(threadFactory));
    }

    static ScheduledExecutorService g(ThreadFactory threadFactory) {
        return g.a(threadFactory);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new a((ScheduledExecutorService) this.f65649d.get());
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public io.reactivex.rxjava3.disposables.c e(Runnable runnable, long j11, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(pz.a.t(runnable), true);
        try {
            scheduledDirectTask.setFuture(j11 <= 0 ? ((ScheduledExecutorService) this.f65649d.get()).submit(scheduledDirectTask) : ((ScheduledExecutorService) this.f65649d.get()).schedule(scheduledDirectTask, j11, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e11) {
            pz.a.r(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public io.reactivex.rxjava3.disposables.c f(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Runnable t11 = pz.a.t(runnable);
        if (j12 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(t11, true);
            try {
                scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.f65649d.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e11) {
                pz.a.r(e11);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f65649d.get();
        c cVar = new c(t11, scheduledExecutorService);
        try {
            cVar.b(j11 <= 0 ? scheduledExecutorService.submit(cVar) : scheduledExecutorService.schedule(cVar, j11, timeUnit));
            return cVar;
        } catch (RejectedExecutionException e12) {
            pz.a.r(e12);
            return EmptyDisposable.INSTANCE;
        }
    }
}
