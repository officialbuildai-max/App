package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import lz.h;

/* loaded from: classes7.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends AtomicLong implements io.reactivex.rxjava3.core.f, u10.d {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final boolean delayError;
    boolean done;
    final u10.c downstream;
    long emittedGroups;
    final Queue<d> evictedGroups;
    final Map<Object, d> groups;
    final h keySelector;
    final int limit;
    u10.d upstream;
    final h valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicInteger groupCount = new AtomicInteger(1);
    final AtomicLong groupConsumed = new AtomicLong();

    public FlowableGroupBy$GroupBySubscriber(u10.c cVar, h hVar, h hVar2, int i11, boolean z10, Map<Object, d> map, Queue<d> queue) {
        this.downstream = cVar;
        this.keySelector = hVar;
        this.valueSelector = hVar2;
        this.bufferSize = i11;
        this.limit = i11 - (i11 >> 2);
        this.delayError = z10;
        this.groups = map;
        this.evictedGroups = queue;
    }

    private void completeEvictions() {
        if (this.evictedGroups != null) {
            int i11 = 0;
            while (true) {
                d poll = this.evictedGroups.poll();
                if (poll == null) {
                    break;
                } else if (poll.f65497c.tryComplete()) {
                    i11++;
                }
            }
            if (i11 != 0) {
                this.groupCount.addAndGet(-i11);
            }
        }
    }

    static MissingBackpressureException groupHangWarning(long j11) {
        return new MissingBackpressureException("Unable to emit a new group (#" + j11 + ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed.");
    }

    @Override // u10.d
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            completeEvictions();
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public void cancel(K k11) {
        if (k11 == null) {
            k11 = (K) NULL_KEY;
        }
        if (this.groups.remove(k11) == null || this.groupCount.decrementAndGet() != 0) {
            return;
        }
        this.upstream.cancel();
    }

    @Override // u10.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        Iterator<d> it = this.groups.values().iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.groups.clear();
        completeEvictions();
        this.done = true;
        this.downstream.onComplete();
    }

    @Override // u10.c
    public void onError(Throwable th2) {
        if (this.done) {
            pz.a.r(th2);
            return;
        }
        this.done = true;
        Iterator<d> it = this.groups.values().iterator();
        while (it.hasNext()) {
            it.next().onError(th2);
        }
        this.groups.clear();
        completeEvictions();
        this.downstream.onError(th2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u10.c
    public void onNext(T t11) {
        boolean z10;
        if (this.done) {
            return;
        }
        try {
            Object apply = this.keySelector.apply(t11);
            Object obj = apply != null ? apply : NULL_KEY;
            d dVar = this.groups.get(obj);
            if (dVar != null) {
                z10 = false;
            } else {
                if (this.cancelled.get()) {
                    return;
                }
                dVar = d.h(apply, this.bufferSize, this, this.delayError);
                this.groups.put(obj, dVar);
                this.groupCount.getAndIncrement();
                z10 = true;
            }
            try {
                dVar.onNext(ExceptionHelper.c(this.valueSelector.apply(t11), "The valueSelector returned a null value."));
                completeEvictions();
                if (z10) {
                    if (this.emittedGroups == get()) {
                        this.upstream.cancel();
                        onError(groupHangWarning(this.emittedGroups));
                        return;
                    }
                    this.emittedGroups++;
                    this.downstream.onNext(dVar);
                    if (dVar.f65497c.tryAbandon()) {
                        cancel(apply);
                        dVar.onComplete();
                        requestGroup(1L);
                    }
                }
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.upstream.cancel();
                if (z10) {
                    if (this.emittedGroups == get()) {
                        MissingBackpressureException groupHangWarning = groupHangWarning(this.emittedGroups);
                        groupHangWarning.initCause(th2);
                        onError(groupHangWarning);
                        return;
                    }
                    this.downstream.onNext(dVar);
                }
                onError(th2);
            }
        } catch (Throwable th3) {
            io.reactivex.rxjava3.exceptions.a.b(th3);
            this.upstream.cancel();
            onError(th3);
        }
    }

    @Override // u10.c
    public void onSubscribe(u10.d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(this.bufferSize);
        }
    }

    @Override // u10.d
    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.a.a(this, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestGroup(long j11) {
        long j12;
        long b11;
        AtomicLong atomicLong = this.groupConsumed;
        int i11 = this.limit;
        do {
            j12 = atomicLong.get();
            b11 = io.reactivex.rxjava3.internal.util.a.b(j12, j11);
        } while (!atomicLong.compareAndSet(j12, b11));
        while (true) {
            long j13 = i11;
            if (b11 < j13) {
                return;
            }
            if (atomicLong.compareAndSet(b11, b11 - j13)) {
                this.upstream.request(j13);
            }
            b11 = atomicLong.get();
        }
    }
}
