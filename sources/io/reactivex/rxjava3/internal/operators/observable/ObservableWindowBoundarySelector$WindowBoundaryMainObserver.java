package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
final class ObservableWindowBoundarySelector$WindowBoundaryMainObserver<T, B, V> extends AtomicInteger implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c, Runnable {
    private static final long serialVersionUID = 8646217640096099753L;
    final int bufferSize;
    final lz.h closingIndicator;
    final io.reactivex.rxjava3.core.o downstream;
    long emitted;
    final io.reactivex.rxjava3.core.m open;
    volatile boolean openDone;
    io.reactivex.rxjava3.disposables.c upstream;
    volatile boolean upstreamCanceled;
    volatile boolean upstreamDone;
    final io.reactivex.rxjava3.operators.f queue = new MpscLinkedQueue();
    final io.reactivex.rxjava3.disposables.a resources = new io.reactivex.rxjava3.disposables.a();
    final List<UnicastSubject> windows = new ArrayList();
    final AtomicLong windowCount = new AtomicLong(1);
    final AtomicBoolean downstreamDisposed = new AtomicBoolean();
    final AtomicThrowable error = new AtomicThrowable();
    final WindowStartObserver<B> startObserver = new WindowStartObserver<>(this);
    final AtomicLong requested = new AtomicLong();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class WindowStartObserver<B> extends AtomicReference<io.reactivex.rxjava3.disposables.c> implements io.reactivex.rxjava3.core.o {
        private static final long serialVersionUID = -3326496781427702834L;
        final ObservableWindowBoundarySelector$WindowBoundaryMainObserver<?, B, ?> parent;

        WindowStartObserver(ObservableWindowBoundarySelector$WindowBoundaryMainObserver<?, B, ?> observableWindowBoundarySelector$WindowBoundaryMainObserver) {
            this.parent = observableWindowBoundarySelector$WindowBoundaryMainObserver;
        }

        void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.parent.openComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.parent.openError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(B b11) {
            this.parent.open(b11);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            DisposableHelper.setOnce(this, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a extends io.reactivex.rxjava3.core.j implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {

        /* renamed from: a, reason: collision with root package name */
        final ObservableWindowBoundarySelector$WindowBoundaryMainObserver f65530a;

        /* renamed from: b, reason: collision with root package name */
        final UnicastSubject f65531b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference f65532c = new AtomicReference();

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f65533d = new AtomicBoolean();

        a(ObservableWindowBoundarySelector$WindowBoundaryMainObserver observableWindowBoundarySelector$WindowBoundaryMainObserver, UnicastSubject unicastSubject) {
            this.f65530a = observableWindowBoundarySelector$WindowBoundaryMainObserver;
            this.f65531b = unicastSubject;
        }

        @Override // io.reactivex.rxjava3.core.j
        protected void D(io.reactivex.rxjava3.core.o oVar) {
            this.f65531b.subscribe(oVar);
            this.f65533d.set(true);
        }

        boolean J() {
            return !this.f65533d.get() && this.f65533d.compareAndSet(false, true);
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            DisposableHelper.dispose(this.f65532c);
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65532c.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.f65530a.close(this);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (isDisposed()) {
                pz.a.r(th2);
            } else {
                this.f65530a.closeError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this.f65532c)) {
                this.f65530a.close(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            DisposableHelper.setOnce(this.f65532c, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Object f65534a;

        b(Object obj) {
            this.f65534a = obj;
        }
    }

    ObservableWindowBoundarySelector$WindowBoundaryMainObserver(io.reactivex.rxjava3.core.o oVar, io.reactivex.rxjava3.core.m mVar, lz.h hVar, int i11) {
        this.downstream = oVar;
        this.open = mVar;
        this.closingIndicator = hVar;
        this.bufferSize = i11;
    }

    void close(a aVar) {
        this.queue.offer(aVar);
        drain();
    }

    void closeError(Throwable th2) {
        this.upstream.dispose();
        this.startObserver.dispose();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        if (this.downstreamDisposed.compareAndSet(false, true)) {
            if (this.windowCount.decrementAndGet() != 0) {
                this.startObserver.dispose();
                return;
            }
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
        }
    }

    void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.rxjava3.core.o oVar = this.downstream;
        io.reactivex.rxjava3.operators.f fVar = this.queue;
        List<UnicastSubject> list = this.windows;
        int i11 = 1;
        while (true) {
            if (this.upstreamCanceled) {
                fVar.clear();
                list.clear();
            } else {
                boolean z10 = this.upstreamDone;
                Object poll = fVar.poll();
                boolean z11 = poll == null;
                if (z10 && (z11 || this.error.get() != null)) {
                    terminateDownstream(oVar);
                    this.upstreamCanceled = true;
                } else if (z11) {
                    if (this.openDone && list.size() == 0) {
                        this.upstream.dispose();
                        this.startObserver.dispose();
                        this.resources.dispose();
                        terminateDownstream(oVar);
                        this.upstreamCanceled = true;
                    }
                } else if (poll instanceof b) {
                    if (!this.downstreamDisposed.get()) {
                        try {
                            Object apply = this.closingIndicator.apply(((b) poll).f65534a);
                            Objects.requireNonNull(apply, "The closingIndicator returned a null ObservableSource");
                            io.reactivex.rxjava3.core.m mVar = (io.reactivex.rxjava3.core.m) apply;
                            this.windowCount.getAndIncrement();
                            UnicastSubject J = UnicastSubject.J(this.bufferSize, this);
                            a aVar = new a(this, J);
                            oVar.onNext(aVar);
                            if (aVar.J()) {
                                J.onComplete();
                            } else {
                                list.add(J);
                                this.resources.b(aVar);
                                mVar.subscribe(aVar);
                            }
                        } catch (Throwable th2) {
                            io.reactivex.rxjava3.exceptions.a.b(th2);
                            this.upstream.dispose();
                            this.startObserver.dispose();
                            this.resources.dispose();
                            io.reactivex.rxjava3.exceptions.a.b(th2);
                            this.error.tryAddThrowableOrReport(th2);
                            this.upstreamDone = true;
                        }
                    }
                } else if (poll instanceof a) {
                    UnicastSubject unicastSubject = ((a) poll).f65531b;
                    list.remove(unicastSubject);
                    this.resources.c((io.reactivex.rxjava3.disposables.c) poll);
                    unicastSubject.onComplete();
                } else {
                    Iterator<UnicastSubject> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().onNext(poll);
                    }
                }
            }
            i11 = addAndGet(-i11);
            if (i11 == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.downstreamDisposed.get();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        this.startObserver.dispose();
        this.resources.dispose();
        this.upstreamDone = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        this.startObserver.dispose();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
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
        if (DisposableHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
            this.open.subscribe(this.startObserver);
        }
    }

    void open(B b11) {
        this.queue.offer(new b(b11));
        drain();
    }

    void openComplete() {
        this.openDone = true;
        drain();
    }

    void openError(Throwable th2) {
        this.upstream.dispose();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windowCount.decrementAndGet() == 0) {
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
        }
    }

    void terminateDownstream(io.reactivex.rxjava3.core.o oVar) {
        Throwable terminate = this.error.terminate();
        if (terminate == null) {
            Iterator<UnicastSubject> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            oVar.onComplete();
            return;
        }
        if (terminate != ExceptionHelper.f65673a) {
            Iterator<UnicastSubject> it2 = this.windows.iterator();
            while (it2.hasNext()) {
                it2.next().onError(terminate);
            }
            oVar.onError(terminate);
        }
    }
}
