package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class Scheduler {

    /* renamed from: a, reason: collision with root package name */
    static boolean f65433a = Boolean.getBoolean("rx3.scheduler.use-nanotime");

    /* renamed from: b, reason: collision with root package name */
    static final long f65434b = a(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class DisposeTask implements io.reactivex.rxjava3.disposables.c, Runnable {
        final Runnable decoratedRun;
        Thread runner;

        /* renamed from: w, reason: collision with root package name */
        final Worker f65435w;

        DisposeTask(Runnable runnable, Worker worker) {
            this.decoratedRun = runnable;
            this.f65435w = worker;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            if (this.runner == Thread.currentThread()) {
                Worker worker = this.f65435w;
                if (worker instanceof io.reactivex.rxjava3.internal.schedulers.e) {
                    ((io.reactivex.rxjava3.internal.schedulers.e) worker).d();
                    return;
                }
            }
            this.f65435w.dispose();
        }

        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65435w.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class PeriodicDirectTask implements io.reactivex.rxjava3.disposables.c, Runnable {
        volatile boolean disposed;
        final Runnable run;
        final Worker worker;

        PeriodicDirectTask(Runnable runnable, Worker worker) {
            this.run = runnable;
            this.worker = worker;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        public Runnable getWrappedRunnable() {
            return this.run;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.disposed) {
                return;
            }
            try {
                this.run.run();
            } catch (Throwable th2) {
                dispose();
                pz.a.r(th2);
                throw th2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Worker implements io.reactivex.rxjava3.disposables.c {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public final class PeriodicTask implements Runnable {
            long count;
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;

            /* renamed from: sd, reason: collision with root package name */
            final SequentialDisposable f65436sd;
            long startInNanoseconds;

            PeriodicTask(long j11, Runnable runnable, long j12, SequentialDisposable sequentialDisposable, long j13) {
                this.decoratedRun = runnable;
                this.f65436sd = sequentialDisposable;
                this.periodInNanoseconds = j13;
                this.lastNowNanoseconds = j12;
                this.startInNanoseconds = j11;
            }

            public Runnable getWrappedRunnable() {
                return this.decoratedRun;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j11;
                this.decoratedRun.run();
                if (this.f65436sd.isDisposed()) {
                    return;
                }
                Worker worker = Worker.this;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long now = worker.now(timeUnit);
                long j12 = Scheduler.f65434b;
                long j13 = now + j12;
                long j14 = this.lastNowNanoseconds;
                if (j13 >= j14) {
                    long j15 = this.periodInNanoseconds;
                    if (now < j14 + j15 + j12) {
                        long j16 = this.startInNanoseconds;
                        long j17 = this.count + 1;
                        this.count = j17;
                        j11 = j16 + (j17 * j15);
                        this.lastNowNanoseconds = now;
                        this.f65436sd.replace(Worker.this.schedule(this, j11 - now, timeUnit));
                    }
                }
                long j18 = this.periodInNanoseconds;
                long j19 = now + j18;
                long j20 = this.count + 1;
                this.count = j20;
                this.startInNanoseconds = j19 - (j18 * j20);
                j11 = j19;
                this.lastNowNanoseconds = now;
                this.f65436sd.replace(Worker.this.schedule(this, j11 - now, timeUnit));
            }
        }

        public long now(TimeUnit timeUnit) {
            return Scheduler.b(timeUnit);
        }

        public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract io.reactivex.rxjava3.disposables.c schedule(Runnable runnable, long j11, TimeUnit timeUnit);

        public io.reactivex.rxjava3.disposables.c schedulePeriodically(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable t11 = pz.a.t(runnable);
            long nanos = timeUnit.toNanos(j12);
            long now = now(TimeUnit.NANOSECONDS);
            io.reactivex.rxjava3.disposables.c schedule = schedule(new PeriodicTask(now + timeUnit.toNanos(j11), t11, now, sequentialDisposable2, nanos), j11, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }
    }

    static long a(long j11, String str) {
        return "seconds".equalsIgnoreCase(str) ? TimeUnit.SECONDS.toNanos(j11) : "milliseconds".equalsIgnoreCase(str) ? TimeUnit.MILLISECONDS.toNanos(j11) : TimeUnit.MINUTES.toNanos(j11);
    }

    static long b(TimeUnit timeUnit) {
        return !f65433a ? timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public abstract Worker c();

    public io.reactivex.rxjava3.disposables.c d(Runnable runnable) {
        return e(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.rxjava3.disposables.c e(Runnable runnable, long j11, TimeUnit timeUnit) {
        Worker c11 = c();
        DisposeTask disposeTask = new DisposeTask(pz.a.t(runnable), c11);
        c11.schedule(disposeTask, j11, timeUnit);
        return disposeTask;
    }

    public io.reactivex.rxjava3.disposables.c f(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Worker c11 = c();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(pz.a.t(runnable), c11);
        io.reactivex.rxjava3.disposables.c schedulePeriodically = c11.schedulePeriodically(periodicDirectTask, j11, j12, timeUnit);
        return schedulePeriodically == EmptyDisposable.INSTANCE ? schedulePeriodically : periodicDirectTask;
    }
}
