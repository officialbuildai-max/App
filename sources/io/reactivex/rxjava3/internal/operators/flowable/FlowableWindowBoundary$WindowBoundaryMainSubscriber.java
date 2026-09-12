package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class FlowableWindowBoundary$WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements io.reactivex.rxjava3.core.f, u10.d, Runnable {
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final int capacityHint;
    volatile boolean done;
    final u10.c downstream;
    long emitted;
    UnicastProcessor window;
    final f boundarySubscriber = new f(this);
    final AtomicReference<u10.d> upstream = new AtomicReference<>();
    final AtomicInteger windows = new AtomicInteger(1);
    final MpscLinkedQueue queue = new MpscLinkedQueue();
    final AtomicThrowable errors = new AtomicThrowable();
    final AtomicBoolean stopWindows = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();

    FlowableWindowBoundary$WindowBoundaryMainSubscriber(u10.c cVar, int i11) {
        this.downstream = cVar;
        this.capacityHint = i11;
    }

    @Override // u10.d
    public void cancel() {
        if (this.stopWindows.compareAndSet(false, true)) {
            this.boundarySubscriber.dispose();
            if (this.windows.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.upstream);
            }
        }
    }

    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        u10.c cVar = this.downstream;
        MpscLinkedQueue mpscLinkedQueue = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        long j11 = this.emitted;
        int i11 = 1;
        while (this.windows.get() != 0) {
            UnicastProcessor unicastProcessor = this.window;
            boolean z10 = this.done;
            if (z10 && atomicThrowable.get() != null) {
                mpscLinkedQueue.clear();
                Throwable terminate = atomicThrowable.terminate();
                if (unicastProcessor != null) {
                    this.window = null;
                    unicastProcessor.onError(terminate);
                }
                cVar.onError(terminate);
                return;
            }
            Object poll = mpscLinkedQueue.poll();
            boolean z11 = poll == null;
            if (z10 && z11) {
                Throwable terminate2 = atomicThrowable.terminate();
                if (terminate2 == null) {
                    if (unicastProcessor != null) {
                        this.window = null;
                        unicastProcessor.onComplete();
                    }
                    cVar.onComplete();
                    return;
                }
                if (unicastProcessor != null) {
                    this.window = null;
                    unicastProcessor.onError(terminate2);
                }
                cVar.onError(terminate2);
                return;
            }
            if (z11) {
                this.emitted = j11;
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else if (poll != NEXT_WINDOW) {
                unicastProcessor.onNext(poll);
            } else {
                if (unicastProcessor != null) {
                    this.window = null;
                    unicastProcessor.onComplete();
                }
                if (!this.stopWindows.get()) {
                    UnicastProcessor i12 = UnicastProcessor.i(this.capacityHint, this);
                    this.window = i12;
                    this.windows.getAndIncrement();
                    if (j11 != this.requested.get()) {
                        j11++;
                        g gVar = new g(i12);
                        cVar.onNext(gVar);
                        if (gVar.h()) {
                            i12.onComplete();
                        }
                    } else {
                        SubscriptionHelper.cancel(this.upstream);
                        this.boundarySubscriber.dispose();
                        atomicThrowable.tryAddThrowableOrReport(MissingBackpressureException.createDefault());
                        this.done = true;
                    }
                }
            }
        }
        mpscLinkedQueue.clear();
        this.window = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void innerComplete() {
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        drain();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void innerError(Throwable th2) {
        SubscriptionHelper.cancel(this.upstream);
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

    @Override // u10.c
    public void onComplete() {
        this.boundarySubscriber.dispose();
        this.done = true;
        drain();
    }

    @Override // u10.c
    public void onError(Throwable th2) {
        this.boundarySubscriber.dispose();
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.done = true;
            drain();
        }
    }

    @Override // u10.c
    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    @Override // u10.c
    public void onSubscribe(u10.d dVar) {
        SubscriptionHelper.setOnce(this.upstream, dVar, Long.MAX_VALUE);
    }

    @Override // u10.d
    public void request(long j11) {
        io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windows.decrementAndGet() == 0) {
            SubscriptionHelper.cancel(this.upstream);
        }
    }
}
