package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ExecutorScheduler extends Scheduler {

    /* renamed from: c, reason: collision with root package name */
    final boolean f65596c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f65597d;

    /* renamed from: e, reason: collision with root package name */
    final Executor f65598e;

    /* loaded from: classes7.dex */
    final class DelayedDispose implements Runnable {

        /* renamed from: dr, reason: collision with root package name */
        private final DelayedRunnable f65599dr;

        DelayedDispose(DelayedRunnable delayedRunnable) {
            this.f65599dr = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayedRunnable delayedRunnable = this.f65599dr;
            delayedRunnable.direct.replace(ExecutorScheduler.this.d(delayedRunnable));
        }
    }

    /* loaded from: classes7.dex */
    static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, io.reactivex.rxjava3.disposables.c {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public Runnable getWrappedRunnable() {
            Runnable runnable = get();
            return runnable != null ? runnable : Functions.f65444b;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    try {
                        runnable.run();
                        lazySet(null);
                        SequentialDisposable sequentialDisposable = this.timed;
                        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                        sequentialDisposable.lazySet(disposableHelper);
                        this.direct.lazySet(disposableHelper);
                    } catch (Throwable th2) {
                        lazySet(null);
                        this.timed.lazySet(DisposableHelper.DISPOSED);
                        this.direct.lazySet(DisposableHelper.DISPOSED);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    pz.a.r(th3);
                    throw th3;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        volatile boolean disposed;
        final Executor executor;
        final boolean fair;
        final boolean interruptibleWorker;
        final AtomicInteger wip = new AtomicInteger();
        final io.reactivex.rxjava3.disposables.a tasks = new io.reactivex.rxjava3.disposables.a();
        final MpscLinkedQueue queue = new MpscLinkedQueue();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, io.reactivex.rxjava3.disposables.c {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // io.reactivex.rxjava3.disposables.c
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.rxjava3.disposables.c
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, io.reactivex.rxjava3.disposables.c {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final io.reactivex.rxjava3.disposables.d tasks;
            volatile Thread thread;

            InterruptibleRunnable(Runnable runnable, io.reactivex.rxjava3.disposables.d dVar) {
                this.run = runnable;
                this.tasks = dVar;
            }

            void cleanup() {
                io.reactivex.rxjava3.disposables.d dVar = this.tasks;
                if (dVar != null) {
                    dVar.c(this);
                }
            }

            @Override // io.reactivex.rxjava3.disposables.c
            public void dispose() {
                while (true) {
                    int i11 = get();
                    if (i11 >= 2) {
                        return;
                    }
                    if (i11 == 0) {
                        if (compareAndSet(0, 4)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.thread;
                        if (thread != null) {
                            thread.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        cleanup();
                        return;
                    }
                }
            }

            @Override // io.reactivex.rxjava3.disposables.c
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.thread = null;
                        return;
                    }
                    try {
                        this.run.run();
                        this.thread = null;
                        if (compareAndSet(1, 2)) {
                            cleanup();
                            return;
                        }
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } catch (Throwable th2) {
                        try {
                            pz.a.r(th2);
                            throw th2;
                        } catch (Throwable th3) {
                            this.thread = null;
                            if (compareAndSet(1, 2)) {
                                cleanup();
                            } else {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            }
                            throw th3;
                        }
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        final class SequentialDispose implements Runnable {
            private final Runnable decoratedRun;
            private final SequentialDisposable mar;

            SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.mar = sequentialDisposable;
                this.decoratedRun = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mar.replace(ExecutorWorker.this.schedule(this.decoratedRun));
            }
        }

        public ExecutorWorker(Executor executor, boolean z10, boolean z11) {
            this.executor = executor;
            this.interruptibleWorker = z10;
            this.fair = z11;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.tasks.dispose();
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fair) {
                runFair();
            } else {
                runEager();
            }
        }

        void runEager() {
            MpscLinkedQueue mpscLinkedQueue = this.queue;
            int i11 = 1;
            while (!this.disposed) {
                do {
                    Runnable runnable = (Runnable) mpscLinkedQueue.poll();
                    if (runnable != null) {
                        runnable.run();
                    } else if (this.disposed) {
                        mpscLinkedQueue.clear();
                        return;
                    } else {
                        i11 = this.wip.addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    }
                } while (!this.disposed);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }

        void runFair() {
            MpscLinkedQueue mpscLinkedQueue = this.queue;
            if (this.disposed) {
                mpscLinkedQueue.clear();
                return;
            }
            ((Runnable) mpscLinkedQueue.poll()).run();
            if (this.disposed) {
                mpscLinkedQueue.clear();
            } else if (this.wip.decrementAndGet() != 0) {
                this.executor.execute(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable) {
            io.reactivex.rxjava3.disposables.c booleanRunnable;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable t11 = pz.a.t(runnable);
            if (this.interruptibleWorker) {
                booleanRunnable = new InterruptibleRunnable(t11, this.tasks);
                this.tasks.b(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(t11);
            }
            this.queue.offer(booleanRunnable);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                } catch (RejectedExecutionException e11) {
                    this.disposed = true;
                    this.queue.clear();
                    pz.a.r(e11);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (j11 <= 0) {
                return schedule(runnable);
            }
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, pz.a.t(runnable)), this.tasks);
            this.tasks.b(scheduledRunnable);
            Executor executor = this.executor;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j11, timeUnit));
                } catch (RejectedExecutionException e11) {
                    this.disposed = true;
                    pz.a.r(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new b(a.f65600a.e(scheduledRunnable, j11, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }

    /* loaded from: classes7.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final Scheduler f65600a = qz.a.d();
    }

    public ExecutorScheduler(Executor executor, boolean z10, boolean z11) {
        this.f65598e = executor;
        this.f65596c = z10;
        this.f65597d = z11;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new ExecutorWorker(this.f65598e, this.f65596c, this.f65597d);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public io.reactivex.rxjava3.disposables.c d(Runnable runnable) {
        Runnable t11 = pz.a.t(runnable);
        try {
            if (this.f65598e instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(t11, this.f65596c);
                scheduledDirectTask.setFuture(((ExecutorService) this.f65598e).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.f65596c) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(t11, null);
                this.f65598e.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(t11);
            this.f65598e.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e11) {
            pz.a.r(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public io.reactivex.rxjava3.disposables.c e(Runnable runnable, long j11, TimeUnit timeUnit) {
        Runnable t11 = pz.a.t(runnable);
        if (!(this.f65598e instanceof ScheduledExecutorService)) {
            DelayedRunnable delayedRunnable = new DelayedRunnable(t11);
            delayedRunnable.timed.replace(a.f65600a.e(new DelayedDispose(delayedRunnable), j11, timeUnit));
            return delayedRunnable;
        }
        try {
            ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(t11, this.f65596c);
            scheduledDirectTask.setFuture(((ScheduledExecutorService) this.f65598e).schedule(scheduledDirectTask, j11, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e11) {
            pz.a.r(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public io.reactivex.rxjava3.disposables.c f(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        if (!(this.f65598e instanceof ScheduledExecutorService)) {
            return super.f(runnable, j11, j12, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(pz.a.t(runnable), this.f65596c);
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.f65598e).scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e11) {
            pz.a.r(e11);
            return EmptyDisposable.INSTANCE;
        }
    }
}
