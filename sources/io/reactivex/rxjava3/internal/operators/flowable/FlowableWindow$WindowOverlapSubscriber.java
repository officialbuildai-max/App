package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.h;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes7.dex */
final class FlowableWindow$WindowOverlapSubscriber<T> extends AtomicInteger implements io.reactivex.rxjava3.core.f, u10.d, Runnable {
    private static final long serialVersionUID = 2428527070996323976L;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final u10.c downstream;
    Throwable error;
    final AtomicBoolean firstRequest;
    long index;
    final AtomicBoolean once;
    long produced;
    final h queue;
    final AtomicLong requested;
    final long size;
    final long skip;
    u10.d upstream;
    final ArrayDeque<UnicastProcessor> windows;
    final AtomicInteger wip;

    FlowableWindow$WindowOverlapSubscriber(u10.c cVar, long j11, long j12, int i11) {
        super(1);
        this.downstream = cVar;
        this.size = j11;
        this.skip = j12;
        this.queue = new h(i11);
        this.windows = new ArrayDeque<>();
        this.once = new AtomicBoolean();
        this.firstRequest = new AtomicBoolean();
        this.requested = new AtomicLong();
        this.wip = new AtomicInteger();
        this.bufferSize = i11;
    }

    @Override // u10.d
    public void cancel() {
        this.cancelled = true;
        if (this.once.compareAndSet(false, true)) {
            run();
        }
        drain();
    }

    boolean checkTerminated(boolean z10, boolean z11, u10.c cVar, h hVar) {
        if (!z10) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            hVar.clear();
            cVar.onError(th2);
            return true;
        }
        if (!z11) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x000f, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void drain() {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r15.wip
            int r0 = r0.getAndIncrement()
            if (r0 == 0) goto L9
            return
        L9:
            u10.c r0 = r15.downstream
            io.reactivex.rxjava3.operators.h r1 = r15.queue
            r2 = 1
            r3 = r2
        Lf:
            boolean r4 = r15.cancelled
            if (r4 == 0) goto L1f
        L13:
            java.lang.Object r4 = r1.poll()
            io.reactivex.rxjava3.processors.UnicastProcessor r4 = (io.reactivex.rxjava3.processors.UnicastProcessor) r4
            if (r4 == 0) goto L84
            r4.onComplete()
            goto L13
        L1f:
            java.util.concurrent.atomic.AtomicLong r4 = r15.requested
            long r4 = r4.get()
            r6 = 0
            r8 = r6
        L28:
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 == 0) goto L5d
            boolean r11 = r15.done
            java.lang.Object r12 = r1.poll()
            io.reactivex.rxjava3.processors.UnicastProcessor r12 = (io.reactivex.rxjava3.processors.UnicastProcessor) r12
            if (r12 != 0) goto L38
            r13 = r2
            goto L39
        L38:
            r13 = 0
        L39:
            boolean r14 = r15.cancelled
            if (r14 == 0) goto L3e
            goto Lf
        L3e:
            boolean r11 = r15.checkTerminated(r11, r13, r0, r1)
            if (r11 == 0) goto L45
            return
        L45:
            if (r13 == 0) goto L48
            goto L5d
        L48:
            io.reactivex.rxjava3.internal.operators.flowable.g r10 = new io.reactivex.rxjava3.internal.operators.flowable.g
            r10.<init>(r12)
            r0.onNext(r10)
            boolean r10 = r10.h()
            if (r10 == 0) goto L59
            r12.onComplete()
        L59:
            r10 = 1
            long r8 = r8 + r10
            goto L28
        L5d:
            if (r10 != 0) goto L71
            boolean r10 = r15.cancelled
            if (r10 == 0) goto L64
            goto Lf
        L64:
            boolean r10 = r15.done
            boolean r11 = r1.isEmpty()
            boolean r10 = r15.checkTerminated(r10, r11, r0, r1)
            if (r10 == 0) goto L71
            return
        L71:
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 == 0) goto L84
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L84
            java.util.concurrent.atomic.AtomicLong r4 = r15.requested
            long r5 = -r8
            r4.addAndGet(r5)
        L84:
            java.util.concurrent.atomic.AtomicInteger r4 = r15.wip
            int r3 = -r3
            int r3 = r4.addAndGet(r3)
            if (r3 != 0) goto Lf
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow$WindowOverlapSubscriber.drain():void");
    }

    @Override // u10.c
    public void onComplete() {
        Iterator<UnicastProcessor> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.windows.clear();
        this.done = true;
        drain();
    }

    @Override // u10.c
    public void onError(Throwable th2) {
        Iterator<UnicastProcessor> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onError(th2);
        }
        this.windows.clear();
        this.error = th2;
        this.done = true;
        drain();
    }

    @Override // u10.c
    public void onNext(T t11) {
        UnicastProcessor unicastProcessor;
        long j11 = this.index;
        if (j11 != 0 || this.cancelled) {
            unicastProcessor = null;
        } else {
            getAndIncrement();
            unicastProcessor = UnicastProcessor.i(this.bufferSize, this);
            this.windows.offer(unicastProcessor);
        }
        long j12 = j11 + 1;
        Iterator<UnicastProcessor> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onNext(t11);
        }
        if (unicastProcessor != null) {
            this.queue.offer(unicastProcessor);
            drain();
        }
        long j13 = this.produced + 1;
        if (j13 == this.size) {
            this.produced = j13 - this.skip;
            UnicastProcessor poll = this.windows.poll();
            if (poll != null) {
                poll.onComplete();
            }
        } else {
            this.produced = j13;
        }
        if (j12 == this.skip) {
            this.index = 0L;
        } else {
            this.index = j12;
        }
    }

    @Override // u10.c
    public void onSubscribe(u10.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // u10.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
            if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                this.upstream.request(io.reactivex.rxjava3.internal.util.a.c(this.skip, j11));
            } else {
                this.upstream.request(io.reactivex.rxjava3.internal.util.a.b(this.size, io.reactivex.rxjava3.internal.util.a.c(this.skip, j11 - 1)));
            }
            drain();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() == 0) {
            this.upstream.cancel();
        }
    }
}
