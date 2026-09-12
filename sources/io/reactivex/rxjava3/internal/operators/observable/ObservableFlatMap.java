package io.reactivex.rxjava3.internal.operators.observable;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class ObservableFlatMap extends a {

    /* renamed from: b, reason: collision with root package name */
    final lz.h f65518b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f65519c;

    /* renamed from: d, reason: collision with root package name */
    final int f65520d;

    /* renamed from: e, reason: collision with root package name */
    final int f65521e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class InnerObserver<T, U> extends AtomicReference<io.reactivex.rxjava3.disposables.c> implements io.reactivex.rxjava3.core.o {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;

        /* renamed from: id, reason: collision with root package name */
        final long f65522id;
        final MergeObserver<T, U> parent;
        volatile io.reactivex.rxjava3.operators.g queue;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j11) {
            this.f65522id = j11;
            this.parent = mergeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.parent.errors.tryAddThrowableOrReport(th2)) {
                MergeObserver<T, U> mergeObserver = this.parent;
                if (!mergeObserver.delayErrors) {
                    mergeObserver.disposeAll();
                }
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(U u11) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u11, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            if (DisposableHelper.setOnce(this, cVar) && (cVar instanceof io.reactivex.rxjava3.operators.b)) {
                io.reactivex.rxjava3.operators.b bVar = (io.reactivex.rxjava3.operators.b) cVar;
                int requestFusion = bVar.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class MergeObserver<T, U> extends AtomicInteger implements io.reactivex.rxjava3.disposables.c, io.reactivex.rxjava3.core.o {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        final boolean delayErrors;
        volatile boolean disposed;
        volatile boolean done;
        final io.reactivex.rxjava3.core.o downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        int lastIndex;
        final lz.h mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile io.reactivex.rxjava3.operators.f queue;
        Queue<io.reactivex.rxjava3.core.m> sources;
        long uniqueId;
        io.reactivex.rxjava3.disposables.c upstream;
        int wip;
        static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        MergeObserver(io.reactivex.rxjava3.core.o oVar, lz.h hVar, boolean z10, int i11, int i12) {
            this.downstream = oVar;
            this.mapper = hVar;
            this.delayErrors = z10;
            this.maxConcurrency = i11;
            this.bufferSize = i12;
            if (i11 != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i11);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        boolean addInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!j0.a(this.observers, innerObserverArr, innerObserverArr2));
            return true;
        }

        boolean checkTerminate() {
            if (this.disposed) {
                return true;
            }
            Throwable th2 = this.errors.get();
            if (this.delayErrors || th2 == null) {
                return false;
            }
            disposeAll();
            this.errors.tryTerminateConsumer(this.downstream);
            return true;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.disposed = true;
            if (disposeAll()) {
                this.errors.tryTerminateAndReport();
            }
        }

        boolean disposeAll() {
            this.upstream.dispose();
            AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.observers;
            InnerObserver<?, ?>[] innerObserverArr = CANCELLED;
            InnerObserver<?, ?>[] andSet = atomicReference.getAndSet(innerObserverArr);
            if (andSet == innerObserverArr) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
        
            if (r10 != null) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00ad, code lost:
        
            r10 = r9.done;
            r11 = r9.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
        
            if (r10 == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00b3, code lost:
        
            if (r11 == null) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00b9, code lost:
        
            if (r11.isEmpty() == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
        
            removeInner(r9);
            r4 = r4 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c0, code lost:
        
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
        
            if (r5 != r8) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00c4, code lost:
        
            r5 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00c5, code lost:
        
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x007f, code lost:
        
            r11 = r10.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0083, code lost:
        
            if (r11 != null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0086, code lost:
        
            r0.onNext(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x008d, code lost:
        
            if (checkTerminate() == false) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x008f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0090, code lost:
        
            r10 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0091, code lost:
        
            io.reactivex.rxjava3.exceptions.a.b(r10);
            r9.dispose();
            r12.errors.tryAddThrowableOrReport(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00a0, code lost:
        
            if (checkTerminate() != false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00a3, code lost:
        
            removeInner(r9);
            r4 = r4 + 1;
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00aa, code lost:
        
            if (r5 != r8) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
        
            return;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap.MergeObserver.drainLoop():void");
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.done) {
                pz.a.r(th2);
            } else if (this.errors.tryAddThrowableOrReport(th2)) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            if (this.done) {
                return;
            }
            try {
                Object apply = this.mapper.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                io.reactivex.rxjava3.core.m mVar = (io.reactivex.rxjava3.core.m) apply;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            int i11 = this.wip;
                            if (i11 == this.maxConcurrency) {
                                this.sources.offer(mVar);
                                return;
                            }
                            this.wip = i11 + 1;
                        } finally {
                        }
                    }
                }
                subscribeInner(mVar);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            if (DisposableHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (innerObserverArr[i11] == innerObserver) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = EMPTY;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i11);
                    System.arraycopy(innerObserverArr, i11 + 1, innerObserverArr3, i11, (length - i11) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!j0.a(this.observers, innerObserverArr, innerObserverArr2));
        }

        void subscribeInner(io.reactivex.rxjava3.core.m mVar) {
            boolean z10;
            while (mVar instanceof lz.k) {
                if (!tryEmitScalar((lz.k) mVar) || this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    try {
                        mVar = this.sources.poll();
                        if (mVar == null) {
                            z10 = true;
                            this.wip--;
                        } else {
                            z10 = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (z10) {
                    drain();
                    return;
                }
            }
            long j11 = this.uniqueId;
            this.uniqueId = 1 + j11;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j11);
            if (addInner(innerObserver)) {
                mVar.subscribe(innerObserver);
            }
        }

        void subscribeMore(int i11) {
            while (true) {
                int i12 = i11 - 1;
                if (i11 == 0) {
                    return;
                }
                synchronized (this) {
                    try {
                        io.reactivex.rxjava3.core.m poll = this.sources.poll();
                        if (poll == null) {
                            this.wip--;
                        } else {
                            subscribeInner(poll);
                        }
                    } finally {
                    }
                }
                i11 = i12;
            }
        }

        void tryEmit(U u11, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(u11);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.rxjava3.operators.g gVar = innerObserver.queue;
                if (gVar == null) {
                    gVar = new io.reactivex.rxjava3.operators.h(this.bufferSize);
                    innerObserver.queue = gVar;
                }
                gVar.offer(u11);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        boolean tryEmitScalar(lz.k kVar) {
            try {
                Object obj = kVar.get();
                if (obj == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.downstream.onNext(obj);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    io.reactivex.rxjava3.operators.f fVar = this.queue;
                    if (fVar == null) {
                        fVar = this.maxConcurrency == Integer.MAX_VALUE ? new io.reactivex.rxjava3.operators.h(this.bufferSize) : new SpscArrayQueue(this.maxConcurrency);
                        this.queue = fVar;
                    }
                    fVar.offer(obj);
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                drainLoop();
                return true;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.errors.tryAddThrowableOrReport(th2);
                drain();
                return true;
            }
        }
    }

    public ObservableFlatMap(io.reactivex.rxjava3.core.m mVar, lz.h hVar, boolean z10, int i11, int i12) {
        super(mVar);
        this.f65518b = hVar;
        this.f65519c = z10;
        this.f65520d = i11;
        this.f65521e = i12;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void D(io.reactivex.rxjava3.core.o oVar) {
        if (ObservableScalarXMap.b(this.f65545a, oVar, this.f65518b)) {
            return;
        }
        this.f65545a.subscribe(new MergeObserver(oVar, this.f65518b, this.f65519c, this.f65520d, this.f65521e));
    }
}
