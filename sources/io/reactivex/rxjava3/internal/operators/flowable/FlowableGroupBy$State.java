package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.h;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class FlowableGroupBy$State<T, K> extends BasicIntQueueSubscription<T> implements u10.b {
    static final int ABANDONED = 2;
    static final int ABANDONED_HAS_SUBSCRIBER = 3;
    static final int FRESH = 0;
    static final int HAS_SUBSCRIBER = 1;
    private static final long serialVersionUID = -3852313036005250360L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    boolean outputFused;
    final FlowableGroupBy$GroupBySubscriber<?, K, T> parent;
    int produced;
    final h queue;
    final AtomicLong requested = new AtomicLong();
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicReference<u10.c> actual = new AtomicReference<>();
    final AtomicInteger once = new AtomicInteger();
    final AtomicBoolean evictOnce = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowableGroupBy$State(int i11, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, K k11, boolean z10) {
        this.queue = new h(i11);
        this.parent = flowableGroupBy$GroupBySubscriber;
        this.key = k11;
        this.delayError = z10;
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u10.d
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            cancelParent();
            drain();
        }
    }

    void cancelParent() {
        if ((this.once.get() & 2) == 0 && this.evictOnce.compareAndSet(false, true)) {
            this.parent.cancel(this.key);
        }
    }

    boolean checkTerminated(boolean z10, boolean z11, u10.c cVar, boolean z12, long j11, boolean z13) {
        if (this.cancelled.get()) {
            cleanupQueue(j11, z13);
            return true;
        }
        if (!z10) {
            return false;
        }
        if (z12) {
            if (!z11) {
                return false;
            }
            this.cancelled.lazySet(true);
            Throwable th2 = this.error;
            if (th2 != null) {
                cVar.onError(th2);
            } else {
                cVar.onComplete();
                replenishParent(j11, z13);
            }
            return true;
        }
        Throwable th3 = this.error;
        if (th3 != null) {
            this.queue.clear();
            this.cancelled.lazySet(true);
            cVar.onError(th3);
            return true;
        }
        if (!z11) {
            return false;
        }
        this.cancelled.lazySet(true);
        cVar.onComplete();
        replenishParent(j11, z13);
        return true;
    }

    void cleanupQueue(long j11, boolean z10) {
        while (this.queue.poll() != null) {
            j11++;
        }
        replenishParent(j11, z10);
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.rxjava3.operators.g
    public void clear() {
        h hVar = this.queue;
        while (hVar.poll() != null) {
            this.produced++;
        }
        tryReplenish();
    }

    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    void drainFused() {
        Throwable th2;
        h hVar = this.queue;
        u10.c cVar = this.actual.get();
        int i11 = 1;
        while (true) {
            if (cVar != null) {
                if (this.cancelled.get()) {
                    return;
                }
                boolean z10 = this.done;
                if (z10 && !this.delayError && (th2 = this.error) != null) {
                    hVar.clear();
                    cVar.onError(th2);
                    return;
                }
                cVar.onNext(null);
                if (z10) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        cVar.onError(th3);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
            }
            i11 = addAndGet(-i11);
            if (i11 == 0) {
                return;
            }
            if (cVar == null) {
                cVar = this.actual.get();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
    
        if (r3 != r16) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        if (checkTerminated(r25.done, r9.isEmpty(), r13, r10, r21, false) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        if (r21 == r23) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
    
        r3 = r21;
        io.reactivex.rxjava3.internal.util.a.d(r25.requested, r3);
        requestParent(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0012, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0012, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void drainNormal() {
        /*
            r25 = this;
            r8 = r25
            io.reactivex.rxjava3.operators.h r9 = r8.queue
            boolean r10 = r8.delayError
            java.util.concurrent.atomic.AtomicReference<u10.c> r0 = r8.actual
            java.lang.Object r0 = r0.get()
            u10.c r0 = (u10.c) r0
            java.util.concurrent.atomic.AtomicBoolean r11 = r8.cancelled
            r13 = r0
            r14 = 1
        L12:
            boolean r0 = r11.get()
            r15 = 0
            r5 = 0
            if (r0 == 0) goto L20
            r8.cleanupQueue(r5, r15)
            goto L87
        L20:
            if (r13 == 0) goto L87
            java.util.concurrent.atomic.AtomicLong r0 = r8.requested
            long r16 = r0.get()
            r3 = r5
        L29:
            int r18 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r18 == 0) goto L5f
            boolean r1 = r8.done
            java.lang.Object r7 = r9.poll()
            if (r7 != 0) goto L38
            r19 = 1
            goto L3a
        L38:
            r19 = r15
        L3a:
            r20 = r19 ^ 1
            r0 = r25
            r2 = r19
            r21 = r3
            r3 = r13
            r4 = r10
            r23 = r5
            r5 = r21
            r12 = r7
            r7 = r20
            boolean r0 = r0.checkTerminated(r1, r2, r3, r4, r5, r7)
            if (r0 == 0) goto L52
            goto L12
        L52:
            if (r19 == 0) goto L55
            goto L63
        L55:
            r13.onNext(r12)
            r0 = 1
            long r3 = r21 + r0
            r5 = r23
            goto L29
        L5f:
            r21 = r3
            r23 = r5
        L63:
            if (r18 != 0) goto L79
            boolean r1 = r8.done
            boolean r2 = r9.isEmpty()
            r7 = 0
            r0 = r25
            r3 = r13
            r4 = r10
            r5 = r21
            boolean r0 = r0.checkTerminated(r1, r2, r3, r4, r5, r7)
            if (r0 == 0) goto L79
            goto L12
        L79:
            int r0 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r0 == 0) goto L87
            java.util.concurrent.atomic.AtomicLong r0 = r8.requested
            r3 = r21
            io.reactivex.rxjava3.internal.util.a.d(r0, r3)
            r8.requestParent(r3)
        L87:
            int r0 = -r14
            int r14 = r8.addAndGet(r0)
            if (r14 != 0) goto L8f
            return
        L8f:
            if (r13 != 0) goto L12
            java.util.concurrent.atomic.AtomicReference<u10.c> r0 = r8.actual
            java.lang.Object r0 = r0.get()
            r13 = r0
            u10.c r13 = (u10.c) r13
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupBy$State.drainNormal():void");
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.rxjava3.operators.g
    public boolean isEmpty() {
        if (this.queue.isEmpty()) {
            tryReplenish();
            return true;
        }
        tryReplenish();
        return false;
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.rxjava3.operators.g
    public T poll() {
        T t11 = (T) this.queue.poll();
        if (t11 != null) {
            this.produced++;
            return t11;
        }
        tryReplenish();
        return null;
    }

    void replenishParent(long j11, boolean z10) {
        if (z10) {
            j11++;
        }
        if (j11 != 0) {
            requestParent(j11);
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u10.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this.requested, j11);
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.rxjava3.operators.c
    public int requestFusion(int i11) {
        return 0;
    }

    void requestParent(long j11) {
        if ((this.once.get() & 2) == 0) {
            this.parent.requestGroup(j11);
        }
    }

    @Override // u10.b
    public void subscribe(u10.c cVar) {
        int i11;
        do {
            i11 = this.once.get();
            if ((i11 & 1) != 0) {
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), cVar);
                return;
            }
        } while (!this.once.compareAndSet(i11, i11 | 1));
        cVar.onSubscribe(this);
        this.actual.lazySet(cVar);
        if (this.cancelled.get()) {
            this.actual.lazySet(null);
        } else {
            drain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tryAbandon() {
        return this.once.get() == 0 && this.once.compareAndSet(0, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tryComplete() {
        boolean compareAndSet = this.evictOnce.compareAndSet(false, true);
        this.done = true;
        drain();
        return compareAndSet;
    }

    void tryReplenish() {
        int i11 = this.produced;
        if (i11 != 0) {
            this.produced = 0;
            requestParent(i11);
        }
    }
}
