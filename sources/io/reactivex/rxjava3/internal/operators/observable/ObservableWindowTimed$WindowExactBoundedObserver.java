package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
final class ObservableWindowTimed$WindowExactBoundedObserver<T> extends ObservableWindowTimed$AbstractWindowObserver<T> implements Runnable {
    private static final long serialVersionUID = -6130475889925953722L;
    long count;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final SequentialDisposable timer;
    UnicastSubject window;
    final Scheduler.Worker worker;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class WindowBoundaryRunnable implements Runnable {
        final long index;
        final ObservableWindowTimed$WindowExactBoundedObserver<?> parent;

        WindowBoundaryRunnable(ObservableWindowTimed$WindowExactBoundedObserver<?> observableWindowTimed$WindowExactBoundedObserver, long j11) {
            this.parent = observableWindowTimed$WindowExactBoundedObserver;
            this.index = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.boundary(this);
        }
    }

    ObservableWindowTimed$WindowExactBoundedObserver(io.reactivex.rxjava3.core.o oVar, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, long j12, boolean z10) {
        super(oVar, j11, timeUnit, i11);
        this.scheduler = scheduler;
        this.maxSize = j12;
        this.restartTimerOnMaxSize = z10;
        if (z10) {
            this.worker = scheduler.c();
        } else {
            this.worker = null;
        }
        this.timer = new SequentialDisposable();
    }

    void boundary(WindowBoundaryRunnable windowBoundaryRunnable) {
        this.queue.offer(windowBoundaryRunnable);
        drain();
    }

    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed$AbstractWindowObserver
    void cleanupResources() {
        this.timer.dispose();
        Scheduler.Worker worker = this.worker;
        if (worker != null) {
            worker.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed$AbstractWindowObserver
    void createFirstWindow() {
        if (this.downstreamCancelled.get()) {
            return;
        }
        this.emitted = 1L;
        this.windowCount.getAndIncrement();
        UnicastSubject J = UnicastSubject.J(this.bufferSize, this);
        this.window = J;
        r rVar = new r(J);
        this.downstream.onNext(rVar);
        WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1L);
        if (this.restartTimerOnMaxSize) {
            SequentialDisposable sequentialDisposable = this.timer;
            Scheduler.Worker worker = this.worker;
            long j11 = this.timespan;
            sequentialDisposable.replace(worker.schedulePeriodically(windowBoundaryRunnable, j11, j11, this.unit));
        } else {
            SequentialDisposable sequentialDisposable2 = this.timer;
            Scheduler scheduler = this.scheduler;
            long j12 = this.timespan;
            sequentialDisposable2.replace(scheduler.f(windowBoundaryRunnable, j12, j12, this.unit));
        }
        if (rVar.J()) {
            this.window.onComplete();
        }
    }

    UnicastSubject createNewWindow(UnicastSubject unicastSubject) {
        if (unicastSubject != null) {
            unicastSubject.onComplete();
            unicastSubject = null;
        }
        if (this.downstreamCancelled.get()) {
            cleanupResources();
        } else {
            long j11 = this.emitted + 1;
            this.emitted = j11;
            this.windowCount.getAndIncrement();
            unicastSubject = UnicastSubject.J(this.bufferSize, this);
            this.window = unicastSubject;
            r rVar = new r(unicastSubject);
            this.downstream.onNext(rVar);
            if (this.restartTimerOnMaxSize) {
                SequentialDisposable sequentialDisposable = this.timer;
                Scheduler.Worker worker = this.worker;
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, j11);
                long j12 = this.timespan;
                sequentialDisposable.update(worker.schedulePeriodically(windowBoundaryRunnable, j12, j12, this.unit));
            }
            if (rVar.J()) {
                unicastSubject.onComplete();
            }
        }
        return unicastSubject;
    }

    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed$AbstractWindowObserver
    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.rxjava3.operators.f fVar = this.queue;
        io.reactivex.rxjava3.core.o oVar = this.downstream;
        UnicastSubject unicastSubject = this.window;
        int i11 = 1;
        while (true) {
            if (this.upstreamCancelled) {
                fVar.clear();
                unicastSubject = null;
                this.window = null;
            } else {
                boolean z10 = this.done;
                Object poll = fVar.poll();
                boolean z11 = poll == null;
                if (z10 && z11) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        if (unicastSubject != null) {
                            unicastSubject.onError(th2);
                        }
                        oVar.onError(th2);
                    } else {
                        if (unicastSubject != null) {
                            unicastSubject.onComplete();
                        }
                        oVar.onComplete();
                    }
                    cleanupResources();
                    this.upstreamCancelled = true;
                } else if (!z11) {
                    if (poll instanceof WindowBoundaryRunnable) {
                        if (((WindowBoundaryRunnable) poll).index == this.emitted || !this.restartTimerOnMaxSize) {
                            this.count = 0L;
                            unicastSubject = createNewWindow(unicastSubject);
                        }
                    } else if (unicastSubject != null) {
                        unicastSubject.onNext(poll);
                        long j11 = this.count + 1;
                        if (j11 == this.maxSize) {
                            this.count = 0L;
                            unicastSubject = createNewWindow(unicastSubject);
                        } else {
                            this.count = j11;
                        }
                    }
                }
            }
            i11 = addAndGet(-i11);
            if (i11 == 0) {
                return;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        windowDone();
    }
}
