package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class ObservableZip extends io.reactivex.rxjava3.core.j {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.m[] f65535a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable f65536b;

    /* renamed from: c, reason: collision with root package name */
    final lz.h f65537c;

    /* renamed from: d, reason: collision with root package name */
    final int f65538d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f65539e;

    /* loaded from: classes7.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.rxjava3.disposables.c {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final io.reactivex.rxjava3.core.o downstream;
        final a[] observers;
        final T[] row;
        final lz.h zipper;

        ZipCoordinator(io.reactivex.rxjava3.core.o oVar, lz.h hVar, int i11, boolean z10) {
            this.downstream = oVar;
            this.zipper = hVar;
            this.observers = new a[i11];
            this.row = (T[]) new Object[i11];
            this.delayError = z10;
        }

        void cancel() {
            clear();
            cancelSources();
        }

        void cancelSources() {
            for (a aVar : this.observers) {
                aVar.a();
            }
        }

        boolean checkTerminated(boolean z10, boolean z11, io.reactivex.rxjava3.core.o oVar, boolean z12, a aVar) {
            if (this.cancelled) {
                cancel();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (z12) {
                if (!z11) {
                    return false;
                }
                Throwable th2 = aVar.f65543d;
                this.cancelled = true;
                cancel();
                if (th2 != null) {
                    oVar.onError(th2);
                } else {
                    oVar.onComplete();
                }
                return true;
            }
            Throwable th3 = aVar.f65543d;
            if (th3 != null) {
                this.cancelled = true;
                cancel();
                oVar.onError(th3);
                return true;
            }
            if (!z11) {
                return false;
            }
            this.cancelled = true;
            cancel();
            oVar.onComplete();
            return true;
        }

        void clear() {
            for (a aVar : this.observers) {
                aVar.f65541b.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            a[] aVarArr = this.observers;
            io.reactivex.rxjava3.core.o oVar = this.downstream;
            T[] tArr = this.row;
            boolean z10 = this.delayError;
            int i11 = 1;
            while (true) {
                int i12 = 0;
                int i13 = 0;
                for (a aVar : aVarArr) {
                    if (tArr[i13] == null) {
                        boolean z11 = aVar.f65542c;
                        Object poll = aVar.f65541b.poll();
                        boolean z12 = poll == null;
                        if (checkTerminated(z11, z12, oVar, z10, aVar)) {
                            return;
                        }
                        if (z12) {
                            i12++;
                        } else {
                            tArr[i13] = poll;
                        }
                    } else if (aVar.f65542c && !z10 && (th2 = aVar.f65543d) != null) {
                        this.cancelled = true;
                        cancel();
                        oVar.onError(th2);
                        return;
                    }
                    i13++;
                }
                if (i12 != 0) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    try {
                        Object apply = this.zipper.apply(tArr.clone());
                        Objects.requireNonNull(apply, "The zipper returned a null value");
                        oVar.onNext(apply);
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th3) {
                        io.reactivex.rxjava3.exceptions.a.b(th3);
                        cancel();
                        oVar.onError(th3);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(io.reactivex.rxjava3.core.m[] mVarArr, int i11) {
            a[] aVarArr = this.observers;
            int length = aVarArr.length;
            for (int i12 = 0; i12 < length; i12++) {
                aVarArr[i12] = new a(this, i11);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i13 = 0; i13 < length && !this.cancelled; i13++) {
                mVarArr[i13].subscribe(aVarArr[i13]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements io.reactivex.rxjava3.core.o {

        /* renamed from: a, reason: collision with root package name */
        final ZipCoordinator f65540a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.rxjava3.operators.h f65541b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f65542c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f65543d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference f65544e = new AtomicReference();

        a(ZipCoordinator zipCoordinator, int i11) {
            this.f65540a = zipCoordinator;
            this.f65541b = new io.reactivex.rxjava3.operators.h(i11);
        }

        public void a() {
            DisposableHelper.dispose(this.f65544e);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.f65542c = true;
            this.f65540a.drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.f65543d = th2;
            this.f65542c = true;
            this.f65540a.drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            this.f65541b.offer(obj);
            this.f65540a.drain();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            DisposableHelper.setOnce(this.f65544e, cVar);
        }
    }

    public ObservableZip(io.reactivex.rxjava3.core.m[] mVarArr, Iterable iterable, lz.h hVar, int i11, boolean z10) {
        this.f65535a = mVarArr;
        this.f65536b = iterable;
        this.f65537c = hVar;
        this.f65538d = i11;
        this.f65539e = z10;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void D(io.reactivex.rxjava3.core.o oVar) {
        int length;
        io.reactivex.rxjava3.core.m[] mVarArr = this.f65535a;
        if (mVarArr == null) {
            mVarArr = new io.reactivex.rxjava3.core.m[8];
            length = 0;
            for (io.reactivex.rxjava3.core.m mVar : this.f65536b) {
                if (length == mVarArr.length) {
                    io.reactivex.rxjava3.core.m[] mVarArr2 = new io.reactivex.rxjava3.core.m[(length >> 2) + length];
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
                    mVarArr = mVarArr2;
                }
                mVarArr[length] = mVar;
                length++;
            }
        } else {
            length = mVarArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(oVar);
        } else {
            new ZipCoordinator(oVar, this.f65537c, length, this.f65539e).subscribe(mVarArr, this.f65538d);
        }
    }
}
