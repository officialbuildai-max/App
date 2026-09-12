package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* loaded from: classes7.dex */
public final class d extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: b, reason: collision with root package name */
    final lz.f f65548b;

    /* renamed from: c, reason: collision with root package name */
    final lz.f f65549c;

    /* renamed from: d, reason: collision with root package name */
    final lz.a f65550d;

    /* renamed from: e, reason: collision with root package name */
    final lz.a f65551e;

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.rxjava3.core.o, io.reactivex.rxjava3.disposables.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.o f65552a;

        /* renamed from: b, reason: collision with root package name */
        final lz.f f65553b;

        /* renamed from: c, reason: collision with root package name */
        final lz.f f65554c;

        /* renamed from: d, reason: collision with root package name */
        final lz.a f65555d;

        /* renamed from: e, reason: collision with root package name */
        final lz.a f65556e;

        /* renamed from: f, reason: collision with root package name */
        io.reactivex.rxjava3.disposables.c f65557f;

        /* renamed from: g, reason: collision with root package name */
        boolean f65558g;

        a(io.reactivex.rxjava3.core.o oVar, lz.f fVar, lz.f fVar2, lz.a aVar, lz.a aVar2) {
            this.f65552a = oVar;
            this.f65553b = fVar;
            this.f65554c = fVar2;
            this.f65555d = aVar;
            this.f65556e = aVar2;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.f65557f.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65557f.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.f65558g) {
                return;
            }
            try {
                this.f65555d.run();
                this.f65558g = true;
                this.f65552a.onComplete();
                try {
                    this.f65556e.run();
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    pz.a.r(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.rxjava3.exceptions.a.b(th3);
                onError(th3);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.f65558g) {
                pz.a.r(th2);
                return;
            }
            this.f65558g = true;
            try {
                this.f65554c.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.rxjava3.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f65552a.onError(th2);
            try {
                this.f65556e.run();
            } catch (Throwable th4) {
                io.reactivex.rxjava3.exceptions.a.b(th4);
                pz.a.r(th4);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            if (this.f65558g) {
                return;
            }
            try {
                this.f65553b.accept(obj);
                this.f65552a.onNext(obj);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                this.f65557f.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            if (DisposableHelper.validate(this.f65557f, cVar)) {
                this.f65557f = cVar;
                this.f65552a.onSubscribe(this);
            }
        }
    }

    public d(io.reactivex.rxjava3.core.m mVar, lz.f fVar, lz.f fVar2, lz.a aVar, lz.a aVar2) {
        super(mVar);
        this.f65548b = fVar;
        this.f65549c = fVar2;
        this.f65550d = aVar;
        this.f65551e = aVar2;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void D(io.reactivex.rxjava3.core.o oVar) {
        this.f65545a.subscribe(new a(oVar, this.f65548b, this.f65549c, this.f65550d, this.f65551e));
    }
}
