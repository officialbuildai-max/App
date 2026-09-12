package io.reactivex.rxjava3.subjects;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.g;
import io.reactivex.rxjava3.operators.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class UnicastSubject extends a {

    /* renamed from: a, reason: collision with root package name */
    final h f65701a;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference f65703c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f65704d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f65705e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f65706f;

    /* renamed from: g, reason: collision with root package name */
    Throwable f65707g;

    /* renamed from: j, reason: collision with root package name */
    boolean f65710j;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f65702b = new AtomicReference();

    /* renamed from: h, reason: collision with root package name */
    final AtomicBoolean f65708h = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    final BasicIntQueueDisposable f65709i = new UnicastQueueDisposable();

    /* loaded from: classes7.dex */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<Object> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, io.reactivex.rxjava3.operators.g
        public void clear() {
            UnicastSubject.this.f65701a.clear();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, io.reactivex.rxjava3.disposables.c
        public void dispose() {
            if (UnicastSubject.this.f65705e) {
                return;
            }
            UnicastSubject.this.f65705e = true;
            UnicastSubject.this.K();
            UnicastSubject.this.f65702b.lazySet(null);
            if (UnicastSubject.this.f65709i.getAndIncrement() == 0) {
                UnicastSubject.this.f65702b.lazySet(null);
                UnicastSubject unicastSubject = UnicastSubject.this;
                if (unicastSubject.f65710j) {
                    return;
                }
                unicastSubject.f65701a.clear();
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return UnicastSubject.this.f65705e;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, io.reactivex.rxjava3.operators.g
        public boolean isEmpty() {
            return UnicastSubject.this.f65701a.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, io.reactivex.rxjava3.operators.g
        public Object poll() {
            return UnicastSubject.this.f65701a.poll();
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable, io.reactivex.rxjava3.operators.c
        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f65710j = true;
            return 2;
        }
    }

    UnicastSubject(int i11, Runnable runnable, boolean z10) {
        this.f65701a = new h(i11);
        this.f65703c = new AtomicReference(runnable);
        this.f65704d = z10;
    }

    public static UnicastSubject J(int i11, Runnable runnable) {
        io.reactivex.rxjava3.internal.functions.a.a(i11, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject(i11, runnable, true);
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(o oVar) {
        if (this.f65708h.get() || !this.f65708h.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), oVar);
            return;
        }
        oVar.onSubscribe(this.f65709i);
        this.f65702b.lazySet(oVar);
        if (this.f65705e) {
            this.f65702b.lazySet(null);
        } else {
            L();
        }
    }

    void K() {
        Runnable runnable = (Runnable) this.f65703c.get();
        if (runnable == null || !j0.a(this.f65703c, runnable, null)) {
            return;
        }
        runnable.run();
    }

    void L() {
        if (this.f65709i.getAndIncrement() != 0) {
            return;
        }
        o oVar = (o) this.f65702b.get();
        int i11 = 1;
        while (oVar == null) {
            i11 = this.f65709i.addAndGet(-i11);
            if (i11 == 0) {
                return;
            } else {
                oVar = (o) this.f65702b.get();
            }
        }
        if (this.f65710j) {
            M(oVar);
        } else {
            N(oVar);
        }
    }

    void M(o oVar) {
        h hVar = this.f65701a;
        boolean z10 = this.f65704d;
        int i11 = 1;
        while (!this.f65705e) {
            boolean z11 = this.f65706f;
            if (!z10 && z11 && P(hVar, oVar)) {
                return;
            }
            oVar.onNext(null);
            if (z11) {
                O(oVar);
                return;
            } else {
                i11 = this.f65709i.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }
        this.f65702b.lazySet(null);
    }

    void N(o oVar) {
        h hVar = this.f65701a;
        boolean z10 = this.f65704d;
        boolean z11 = true;
        int i11 = 1;
        while (!this.f65705e) {
            boolean z12 = this.f65706f;
            Object poll = this.f65701a.poll();
            boolean z13 = poll == null;
            if (z12) {
                if (!z10 && z11) {
                    if (P(hVar, oVar)) {
                        return;
                    } else {
                        z11 = false;
                    }
                }
                if (z13) {
                    O(oVar);
                    return;
                }
            }
            if (z13) {
                i11 = this.f65709i.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                oVar.onNext(poll);
            }
        }
        this.f65702b.lazySet(null);
        hVar.clear();
    }

    void O(o oVar) {
        this.f65702b.lazySet(null);
        Throwable th2 = this.f65707g;
        if (th2 != null) {
            oVar.onError(th2);
        } else {
            oVar.onComplete();
        }
    }

    boolean P(g gVar, o oVar) {
        Throwable th2 = this.f65707g;
        if (th2 == null) {
            return false;
        }
        this.f65702b.lazySet(null);
        gVar.clear();
        oVar.onError(th2);
        return true;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (this.f65706f || this.f65705e) {
            return;
        }
        this.f65706f = true;
        K();
        L();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        ExceptionHelper.c(th2, "onError called with a null Throwable.");
        if (this.f65706f || this.f65705e) {
            pz.a.r(th2);
            return;
        }
        this.f65707g = th2;
        this.f65706f = true;
        K();
        L();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(Object obj) {
        ExceptionHelper.c(obj, "onNext called with a null value.");
        if (this.f65706f || this.f65705e) {
            return;
        }
        this.f65701a.offer(obj);
        L();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(c cVar) {
        if (this.f65706f || this.f65705e) {
            cVar.dispose();
        }
    }
}
