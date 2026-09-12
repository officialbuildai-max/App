package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.m;
import io.reactivex.rxjava3.core.o;

/* loaded from: classes7.dex */
public final class c extends io.reactivex.rxjava3.core.e {

    /* renamed from: b, reason: collision with root package name */
    private final m f65494b;

    /* loaded from: classes7.dex */
    static final class a implements o, u10.d {

        /* renamed from: a, reason: collision with root package name */
        final u10.c f65495a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.rxjava3.disposables.c f65496b;

        a(u10.c cVar) {
            this.f65495a = cVar;
        }

        @Override // u10.d
        public void cancel() {
            this.f65496b.dispose();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            this.f65495a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            this.f65495a.onError(th2);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            this.f65495a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            this.f65496b = cVar;
            this.f65495a.onSubscribe(this);
        }

        @Override // u10.d
        public void request(long j11) {
        }
    }

    public c(m mVar) {
        this.f65494b = mVar;
    }

    @Override // io.reactivex.rxjava3.core.e
    protected void g(u10.c cVar) {
        this.f65494b.subscribe(new a(cVar));
    }
}
