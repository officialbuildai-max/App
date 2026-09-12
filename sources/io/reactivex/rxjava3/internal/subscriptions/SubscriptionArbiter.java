package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.internal.util.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import u10.d;

/* loaded from: classes7.dex */
public class SubscriptionArbiter extends AtomicInteger implements d {
    private static final long serialVersionUID = -2189523197179400958L;
    d actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<d> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public SubscriptionArbiter(boolean z10) {
        this.cancelOnReplace = z10;
    }

    @Override // u10.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    final void drainLoop() {
        int i11 = 1;
        long j11 = 0;
        d dVar = null;
        do {
            d dVar2 = this.missedSubscription.get();
            if (dVar2 != null) {
                dVar2 = this.missedSubscription.getAndSet(null);
            }
            long j12 = this.missedRequested.get();
            if (j12 != 0) {
                j12 = this.missedRequested.getAndSet(0L);
            }
            long j13 = this.missedProduced.get();
            if (j13 != 0) {
                j13 = this.missedProduced.getAndSet(0L);
            }
            d dVar3 = this.actual;
            if (this.cancelled) {
                if (dVar3 != null) {
                    dVar3.cancel();
                    this.actual = null;
                }
                if (dVar2 != null) {
                    dVar2.cancel();
                }
            } else {
                long j14 = this.requested;
                if (j14 != Long.MAX_VALUE) {
                    j14 = a.b(j14, j12);
                    if (j14 != Long.MAX_VALUE) {
                        j14 -= j13;
                        if (j14 < 0) {
                            SubscriptionHelper.reportMoreProduced(j14);
                            j14 = 0;
                        }
                    }
                    this.requested = j14;
                }
                if (dVar2 != null) {
                    if (dVar3 != null && this.cancelOnReplace) {
                        dVar3.cancel();
                    }
                    this.actual = dVar2;
                    if (j14 != 0) {
                        j11 = a.b(j11, j14);
                        dVar = dVar2;
                    }
                } else if (dVar3 != null && j12 != 0) {
                    j11 = a.b(j11, j12);
                    dVar = dVar3;
                }
            }
            i11 = addAndGet(-i11);
        } while (i11 != 0);
        if (j11 != 0) {
            dVar.request(j11);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j11) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            a.a(this.missedProduced, j11);
            drain();
            return;
        }
        long j12 = this.requested;
        if (j12 != Long.MAX_VALUE) {
            long j13 = j12 - j11;
            if (j13 < 0) {
                SubscriptionHelper.reportMoreProduced(j13);
                j13 = 0;
            }
            this.requested = j13;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }

    @Override // u10.d
    public final void request(long j11) {
        if (!SubscriptionHelper.validate(j11) || this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            a.a(this.missedRequested, j11);
            drain();
            return;
        }
        long j12 = this.requested;
        if (j12 != Long.MAX_VALUE) {
            long b11 = a.b(j12, j11);
            this.requested = b11;
            if (b11 == Long.MAX_VALUE) {
                this.unbounded = true;
            }
        }
        d dVar = this.actual;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (dVar != null) {
            dVar.request(j11);
        }
    }

    public final void setSubscription(d dVar) {
        if (this.cancelled) {
            dVar.cancel();
            return;
        }
        Objects.requireNonNull(dVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            d andSet = this.missedSubscription.getAndSet(dVar);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            drain();
            return;
        }
        d dVar2 = this.actual;
        if (dVar2 != null && this.cancelOnReplace) {
            dVar2.cancel();
        }
        this.actual = dVar;
        long j11 = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j11 != 0) {
            dVar.request(j11);
        }
    }
}
