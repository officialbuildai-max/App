package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import u10.c;
import u10.d;

/* loaded from: classes7.dex */
public final class UnicastProcessor extends a {

    /* renamed from: b, reason: collision with root package name */
    final h f65690b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference f65691c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f65692d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f65693e;

    /* renamed from: f, reason: collision with root package name */
    Throwable f65694f;

    /* renamed from: h, reason: collision with root package name */
    volatile boolean f65696h;

    /* renamed from: l, reason: collision with root package name */
    boolean f65700l;

    /* renamed from: g, reason: collision with root package name */
    final AtomicReference f65695g = new AtomicReference();

    /* renamed from: i, reason: collision with root package name */
    final AtomicBoolean f65697i = new AtomicBoolean();

    /* renamed from: j, reason: collision with root package name */
    final BasicIntQueueSubscription f65698j = new UnicastQueueSubscription();

    /* renamed from: k, reason: collision with root package name */
    final AtomicLong f65699k = new AtomicLong();

    /* loaded from: classes7.dex */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<Object> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u10.d
        public void cancel() {
            if (UnicastProcessor.this.f65696h) {
                return;
            }
            UnicastProcessor.this.f65696h = true;
            UnicastProcessor.this.k();
            UnicastProcessor.this.f65695g.lazySet(null);
            if (UnicastProcessor.this.f65698j.getAndIncrement() == 0) {
                UnicastProcessor.this.f65695g.lazySet(null);
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                if (unicastProcessor.f65700l) {
                    return;
                }
                unicastProcessor.f65690b.clear();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.rxjava3.operators.g
        public void clear() {
            UnicastProcessor.this.f65690b.clear();
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.rxjava3.operators.g
        public boolean isEmpty() {
            return UnicastProcessor.this.f65690b.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.rxjava3.operators.g
        public Object poll() {
            return UnicastProcessor.this.f65690b.poll();
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, u10.d
        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                io.reactivex.rxjava3.internal.util.a.a(UnicastProcessor.this.f65699k, j11);
                UnicastProcessor.this.l();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.rxjava3.operators.c
        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f65700l = true;
            return 2;
        }
    }

    UnicastProcessor(int i11, Runnable runnable, boolean z10) {
        this.f65690b = new h(i11);
        this.f65691c = new AtomicReference(runnable);
        this.f65692d = z10;
    }

    public static UnicastProcessor i(int i11, Runnable runnable) {
        return j(i11, runnable, true);
    }

    public static UnicastProcessor j(int i11, Runnable runnable, boolean z10) {
        Objects.requireNonNull(runnable, "onTerminate");
        io.reactivex.rxjava3.internal.functions.a.a(i11, "capacityHint");
        return new UnicastProcessor(i11, runnable, z10);
    }

    @Override // io.reactivex.rxjava3.core.e
    protected void g(c cVar) {
        if (this.f65697i.get() || !this.f65697i.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
            return;
        }
        cVar.onSubscribe(this.f65698j);
        this.f65695g.set(cVar);
        if (this.f65696h) {
            this.f65695g.lazySet(null);
        } else {
            l();
        }
    }

    boolean h(boolean z10, boolean z11, boolean z12, c cVar, h hVar) {
        if (this.f65696h) {
            hVar.clear();
            this.f65695g.lazySet(null);
            return true;
        }
        if (!z11) {
            return false;
        }
        if (z10 && this.f65694f != null) {
            hVar.clear();
            this.f65695g.lazySet(null);
            cVar.onError(this.f65694f);
            return true;
        }
        if (!z12) {
            return false;
        }
        Throwable th2 = this.f65694f;
        this.f65695g.lazySet(null);
        if (th2 != null) {
            cVar.onError(th2);
        } else {
            cVar.onComplete();
        }
        return true;
    }

    void k() {
        Runnable runnable = (Runnable) this.f65691c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    void l() {
        if (this.f65698j.getAndIncrement() != 0) {
            return;
        }
        c cVar = (c) this.f65695g.get();
        int i11 = 1;
        while (cVar == null) {
            i11 = this.f65698j.addAndGet(-i11);
            if (i11 == 0) {
                return;
            } else {
                cVar = (c) this.f65695g.get();
            }
        }
        if (this.f65700l) {
            m(cVar);
        } else {
            n(cVar);
        }
    }

    void m(c cVar) {
        h hVar = this.f65690b;
        boolean z10 = this.f65692d;
        int i11 = 1;
        while (!this.f65696h) {
            boolean z11 = this.f65693e;
            if (!z10 && z11 && this.f65694f != null) {
                hVar.clear();
                this.f65695g.lazySet(null);
                cVar.onError(this.f65694f);
                return;
            }
            cVar.onNext(null);
            if (z11) {
                this.f65695g.lazySet(null);
                Throwable th2 = this.f65694f;
                if (th2 != null) {
                    cVar.onError(th2);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            i11 = this.f65698j.addAndGet(-i11);
            if (i11 == 0) {
                return;
            }
        }
        this.f65695g.lazySet(null);
    }

    void n(c cVar) {
        long j11;
        h hVar = this.f65690b;
        boolean z10 = true;
        boolean z11 = !this.f65692d;
        int i11 = 1;
        while (true) {
            long j12 = this.f65699k.get();
            long j13 = 0;
            while (true) {
                if (j12 == j13) {
                    j11 = j13;
                    break;
                }
                boolean z12 = this.f65693e;
                Object poll = hVar.poll();
                boolean z13 = poll == null ? z10 : false;
                j11 = j13;
                if (h(z11, z12, z13, cVar, hVar)) {
                    return;
                }
                if (z13) {
                    break;
                }
                cVar.onNext(poll);
                j13 = 1 + j11;
                z10 = true;
            }
            if (j12 == j13 && h(z11, this.f65693e, hVar.isEmpty(), cVar, hVar)) {
                return;
            }
            if (j11 != 0 && j12 != Long.MAX_VALUE) {
                this.f65699k.addAndGet(-j11);
            }
            i11 = this.f65698j.addAndGet(-i11);
            if (i11 == 0) {
                return;
            } else {
                z10 = true;
            }
        }
    }

    @Override // u10.c
    public void onComplete() {
        if (this.f65693e || this.f65696h) {
            return;
        }
        this.f65693e = true;
        k();
        l();
    }

    @Override // u10.c
    public void onError(Throwable th2) {
        ExceptionHelper.c(th2, "onError called with a null Throwable.");
        if (this.f65693e || this.f65696h) {
            pz.a.r(th2);
            return;
        }
        this.f65694f = th2;
        this.f65693e = true;
        k();
        l();
    }

    @Override // u10.c
    public void onNext(Object obj) {
        ExceptionHelper.c(obj, "onNext called with a null value.");
        if (this.f65693e || this.f65696h) {
            return;
        }
        this.f65690b.offer(obj);
        l();
    }

    @Override // u10.c
    public void onSubscribe(d dVar) {
        if (this.f65693e || this.f65696h) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
