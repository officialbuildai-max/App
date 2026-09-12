package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* loaded from: classes7.dex */
public final class n extends io.reactivex.rxjava3.core.g {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.m f65576a;

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h f65577a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.rxjava3.disposables.c f65578b;

        /* renamed from: c, reason: collision with root package name */
        Object f65579c;

        /* renamed from: d, reason: collision with root package name */
        boolean f65580d;

        a(io.reactivex.rxjava3.core.h hVar) {
            this.f65577a = hVar;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.f65578b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65578b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.f65580d) {
                return;
            }
            this.f65580d = true;
            Object obj = this.f65579c;
            this.f65579c = null;
            if (obj == null) {
                this.f65577a.onComplete();
            } else {
                this.f65577a.onSuccess(obj);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.f65580d) {
                pz.a.r(th2);
            } else {
                this.f65580d = true;
                this.f65577a.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            if (this.f65580d) {
                return;
            }
            if (this.f65579c == null) {
                this.f65579c = obj;
                return;
            }
            this.f65580d = true;
            this.f65578b.dispose();
            this.f65577a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            if (DisposableHelper.validate(this.f65578b, cVar)) {
                this.f65578b = cVar;
                this.f65577a.onSubscribe(this);
            }
        }
    }

    public n(io.reactivex.rxjava3.core.m mVar) {
        this.f65576a = mVar;
    }

    @Override // io.reactivex.rxjava3.core.g
    public void b(io.reactivex.rxjava3.core.h hVar) {
        this.f65576a.subscribe(new a(hVar));
    }
}
