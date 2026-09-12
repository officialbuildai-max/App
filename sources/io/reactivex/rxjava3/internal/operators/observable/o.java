package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
public final class o extends io.reactivex.rxjava3.core.p {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.m f65581a;

    /* renamed from: b, reason: collision with root package name */
    final Object f65582b;

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.q f65583a;

        /* renamed from: b, reason: collision with root package name */
        final Object f65584b;

        /* renamed from: c, reason: collision with root package name */
        io.reactivex.rxjava3.disposables.c f65585c;

        /* renamed from: d, reason: collision with root package name */
        Object f65586d;

        /* renamed from: e, reason: collision with root package name */
        boolean f65587e;

        a(io.reactivex.rxjava3.core.q qVar, Object obj) {
            this.f65583a = qVar;
            this.f65584b = obj;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.f65585c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65585c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.f65587e) {
                return;
            }
            this.f65587e = true;
            Object obj = this.f65586d;
            this.f65586d = null;
            if (obj == null) {
                obj = this.f65584b;
            }
            if (obj != null) {
                this.f65583a.onSuccess(obj);
            } else {
                this.f65583a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.f65587e) {
                pz.a.r(th2);
            } else {
                this.f65587e = true;
                this.f65583a.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            if (this.f65587e) {
                return;
            }
            if (this.f65586d == null) {
                this.f65586d = obj;
                return;
            }
            this.f65587e = true;
            this.f65585c.dispose();
            this.f65583a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            if (DisposableHelper.validate(this.f65585c, cVar)) {
                this.f65585c = cVar;
                this.f65583a.onSubscribe(this);
            }
        }
    }

    public o(io.reactivex.rxjava3.core.m mVar, Object obj) {
        this.f65581a = mVar;
        this.f65582b = obj;
    }

    @Override // io.reactivex.rxjava3.core.p
    public void b(io.reactivex.rxjava3.core.q qVar) {
        this.f65581a.subscribe(new a(qVar, this.f65582b));
    }
}
