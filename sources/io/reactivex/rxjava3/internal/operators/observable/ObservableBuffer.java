package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public final class ObservableBuffer extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: b, reason: collision with root package name */
    final int f65504b;

    /* renamed from: c, reason: collision with root package name */
    final int f65505c;

    /* renamed from: d, reason: collision with root package name */
    final lz.k f65506d;

    /* loaded from: classes7.dex */
    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {
        private static final long serialVersionUID = -8223395059921494546L;
        final lz.k bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        final io.reactivex.rxjava3.core.o downstream;
        long index;
        final int skip;
        io.reactivex.rxjava3.disposables.c upstream;

        BufferSkipObserver(io.reactivex.rxjava3.core.o oVar, int i11, int i12, lz.k kVar) {
            this.downstream = oVar;
            this.count = i11;
            this.skip = i12;
            this.bufferSupplier = kVar;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.buffers.clear();
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(T t11) {
            long j11 = this.index;
            this.index = 1 + j11;
            if (j11 % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) ExceptionHelper.c(this.bufferSupplier.get(), "The bufferSupplier returned a null Collection."));
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th2);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t11);
                if (this.count <= next.size()) {
                    it.remove();
                    this.downstream.onNext(next);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            if (DisposableHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.o f65507a;

        /* renamed from: b, reason: collision with root package name */
        final int f65508b;

        /* renamed from: c, reason: collision with root package name */
        final lz.k f65509c;

        /* renamed from: d, reason: collision with root package name */
        Collection f65510d;

        /* renamed from: e, reason: collision with root package name */
        int f65511e;

        /* renamed from: f, reason: collision with root package name */
        io.reactivex.rxjava3.disposables.c f65512f;

        a(io.reactivex.rxjava3.core.o oVar, int i11, lz.k kVar) {
            this.f65507a = oVar;
            this.f65508b = i11;
            this.f65509c = kVar;
        }

        boolean a() {
            try {
                Object obj = this.f65509c.get();
                Objects.requireNonNull(obj, "Empty buffer supplied");
                this.f65510d = (Collection) obj;
                return true;
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.f65510d = null;
                io.reactivex.rxjava3.disposables.c cVar = this.f65512f;
                if (cVar == null) {
                    EmptyDisposable.error(th2, this.f65507a);
                    return false;
                }
                cVar.dispose();
                this.f65507a.onError(th2);
                return false;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.f65512f.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65512f.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            Collection collection = this.f65510d;
            if (collection != null) {
                this.f65510d = null;
                if (!collection.isEmpty()) {
                    this.f65507a.onNext(collection);
                }
                this.f65507a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.f65510d = null;
            this.f65507a.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            Collection collection = this.f65510d;
            if (collection != null) {
                collection.add(obj);
                int i11 = this.f65511e + 1;
                this.f65511e = i11;
                if (i11 >= this.f65508b) {
                    this.f65507a.onNext(collection);
                    this.f65511e = 0;
                    a();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            if (DisposableHelper.validate(this.f65512f, cVar)) {
                this.f65512f = cVar;
                this.f65507a.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(io.reactivex.rxjava3.core.m mVar, int i11, int i12, lz.k kVar) {
        super(mVar);
        this.f65504b = i11;
        this.f65505c = i12;
        this.f65506d = kVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(io.reactivex.rxjava3.core.o oVar) {
        int i11 = this.f65505c;
        int i12 = this.f65504b;
        if (i11 != i12) {
            this.f65545a.subscribe(new BufferSkipObserver(oVar, this.f65504b, this.f65505c, this.f65506d));
            return;
        }
        a aVar = new a(oVar, i12, this.f65506d);
        if (aVar.a()) {
            this.f65545a.subscribe(aVar);
        }
    }
}
