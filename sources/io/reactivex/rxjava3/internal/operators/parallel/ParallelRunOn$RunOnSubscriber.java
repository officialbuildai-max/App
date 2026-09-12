package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import u10.c;
import u10.d;

/* loaded from: classes7.dex */
final class ParallelRunOn$RunOnSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final c downstream;

    ParallelRunOn$RunOnSubscriber(c cVar, int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        super(i11, spscArrayQueue, worker);
        this.downstream = cVar;
    }

    @Override // io.reactivex.rxjava3.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber, u10.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(this.prefetch);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th2;
        int i11 = this.consumed;
        SpscArrayQueue<T> spscArrayQueue = this.queue;
        c cVar = this.downstream;
        int i12 = this.limit;
        int i13 = 1;
        while (true) {
            long j11 = this.requested.get();
            long j12 = 0;
            while (j12 != j11) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                boolean z10 = this.done;
                if (z10 && (th2 = this.error) != null) {
                    spscArrayQueue.clear();
                    cVar.onError(th2);
                    this.worker.dispose();
                    return;
                }
                T poll = spscArrayQueue.poll();
                boolean z11 = poll == null;
                if (z10 && z11) {
                    cVar.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    if (z11) {
                        break;
                    }
                    cVar.onNext(poll);
                    j12++;
                    i11++;
                    if (i11 == i12) {
                        this.upstream.request(i11);
                        i11 = 0;
                    }
                }
            }
            if (j12 == j11) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                if (this.done) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        spscArrayQueue.clear();
                        cVar.onError(th3);
                        this.worker.dispose();
                        return;
                    } else if (spscArrayQueue.isEmpty()) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (j12 != 0 && j11 != Long.MAX_VALUE) {
                this.requested.addAndGet(-j12);
            }
            int i14 = get();
            if (i14 == i13) {
                this.consumed = i11;
                i13 = addAndGet(-i13);
                if (i13 == 0) {
                    return;
                }
            } else {
                i13 = i14;
            }
        }
    }
}
