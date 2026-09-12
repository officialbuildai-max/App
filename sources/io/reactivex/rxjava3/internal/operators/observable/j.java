package io.reactivex.rxjava3.internal.operators.observable;

/* loaded from: classes7.dex */
public final class j extends io.reactivex.rxjava3.core.a {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.m f65564a;

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.b f65565a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.rxjava3.disposables.c f65566b;

        a(io.reactivex.rxjava3.core.b bVar) {
            this.f65565a = bVar;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.f65566b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65566b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.f65565a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.f65565a.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            this.f65566b = cVar;
            this.f65565a.onSubscribe(this);
        }
    }

    public j(io.reactivex.rxjava3.core.m mVar) {
        this.f65564a = mVar;
    }

    @Override // io.reactivex.rxjava3.core.a
    public void b(io.reactivex.rxjava3.core.b bVar) {
        this.f65564a.subscribe(new a(bVar));
    }
}
