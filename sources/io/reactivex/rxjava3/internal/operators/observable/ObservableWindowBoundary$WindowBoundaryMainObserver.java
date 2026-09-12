package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> extends AtomicInteger implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c, Runnable {
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final int capacityHint;
    volatile boolean done;
    final io.reactivex.rxjava3.core.o downstream;
    UnicastSubject window;
    final q boundaryObserver = new q(this);
    final AtomicReference<io.reactivex.rxjava3.disposables.c> upstream = new AtomicReference<>();
    final AtomicInteger windows = new AtomicInteger(1);
    final MpscLinkedQueue queue = new MpscLinkedQueue();
    final AtomicThrowable errors = new AtomicThrowable();
    final AtomicBoolean stopWindows = new AtomicBoolean();

    ObservableWindowBoundary$WindowBoundaryMainObserver(io.reactivex.rxjava3.core.o oVar, int i11) {
        this.downstream = oVar;
        this.capacityHint = i11;
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        if (this.stopWindows.compareAndSet(false, true)) {
            this.boundaryObserver.dispose();
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.rxjava3.core.o oVar = this.downstream;
        MpscLinkedQueue mpscLinkedQueue = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        int i11 = 1;
        while (this.windows.get() != 0) {
            UnicastSubject unicastSubject = this.window;
            boolean z10 = this.done;
            if (z10 && atomicThrowable.get() != null) {
                mpscLinkedQueue.clear();
                Throwable terminate = atomicThrowable.terminate();
                if (unicastSubject != null) {
                    this.window = null;
                    unicastSubject.onError(terminate);
                }
                oVar.onError(terminate);
                return;
            }
            Object poll = mpscLinkedQueue.poll();
            boolean z11 = poll == null;
            if (z10 && z11) {
                Throwable terminate2 = atomicThrowable.terminate();
                if (terminate2 == null) {
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onComplete();
                    }
                    oVar.onComplete();
                    return;
                }
                if (unicastSubject != null) {
                    this.window = null;
                    unicastSubject.onError(terminate2);
                }
                oVar.onError(terminate2);
                return;
            }
            if (z11) {
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else if (poll != NEXT_WINDOW) {
                unicastSubject.onNext(poll);
            } else {
                if (unicastSubject != null) {
                    this.window = null;
                    unicastSubject.onComplete();
                }
                if (!this.stopWindows.get()) {
                    UnicastSubject J = UnicastSubject.J(this.capacityHint, this);
                    this.window = J;
                    this.windows.getAndIncrement();
                    r rVar = new r(J);
                    oVar.onNext(rVar);
                    if (rVar.J()) {
                        J.onComplete();
                    }
                }
            }
        }
        mpscLinkedQueue.clear();
        this.window = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        drain();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void innerError(Throwable th2) {
        DisposableHelper.dispose(this.upstream);
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            drain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        this.boundaryObserver.dispose();
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        this.boundaryObserver.dispose();
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
        if (DisposableHelper.setOnce(this.upstream, cVar)) {
            innerNext();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windows.decrementAndGet() == 0) {
            DisposableHelper.dispose(this.upstream);
        }
    }
}
