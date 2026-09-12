package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;

/* loaded from: classes7.dex */
public final class m extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: b, reason: collision with root package name */
    final lz.h f65570b;

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.rxjava3.core.o {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.o f65571a;

        /* renamed from: b, reason: collision with root package name */
        final lz.h f65572b;

        /* renamed from: c, reason: collision with root package name */
        final SequentialDisposable f65573c = new SequentialDisposable();

        /* renamed from: d, reason: collision with root package name */
        boolean f65574d;

        /* renamed from: e, reason: collision with root package name */
        boolean f65575e;

        a(io.reactivex.rxjava3.core.o oVar, lz.h hVar) {
            this.f65571a = oVar;
            this.f65572b = hVar;
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.f65575e) {
                return;
            }
            this.f65575e = true;
            this.f65574d = true;
            this.f65571a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (this.f65574d) {
                if (this.f65575e) {
                    pz.a.r(th2);
                    return;
                } else {
                    this.f65571a.onError(th2);
                    return;
                }
            }
            this.f65574d = true;
            try {
                io.reactivex.rxjava3.core.m mVar = (io.reactivex.rxjava3.core.m) this.f65572b.apply(th2);
                if (mVar != null) {
                    mVar.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th2);
                this.f65571a.onError(nullPointerException);
            } catch (Throwable th3) {
                io.reactivex.rxjava3.exceptions.a.b(th3);
                this.f65571a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            if (this.f65575e) {
                return;
            }
            this.f65571a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            this.f65573c.replace(cVar);
        }
    }

    public m(io.reactivex.rxjava3.core.m mVar, lz.h hVar) {
        super(mVar);
        this.f65570b = hVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void D(io.reactivex.rxjava3.core.o oVar) {
        a aVar = new a(oVar, this.f65570b);
        oVar.onSubscribe(aVar.f65573c);
        this.f65545a.subscribe(aVar);
    }
}
