package io.reactivex.rxjava3.internal.operators.observable;

/* loaded from: classes7.dex */
public final class c extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: b, reason: collision with root package name */
    final lz.f f65546b;

    /* loaded from: classes7.dex */
    static final class a extends io.reactivex.rxjava3.internal.observers.a {

        /* renamed from: f, reason: collision with root package name */
        final lz.f f65547f;

        a(io.reactivex.rxjava3.core.o oVar, lz.f fVar) {
            super(oVar);
            this.f65547f = fVar;
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            this.f65457a.onNext(obj);
            if (this.f65461e == 0) {
                try {
                    this.f65547f.accept(obj);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Override // io.reactivex.rxjava3.operators.g
        public Object poll() {
            Object poll = this.f65459c.poll();
            if (poll != null) {
                this.f65547f.accept(poll);
            }
            return poll;
        }

        @Override // io.reactivex.rxjava3.operators.c
        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public c(io.reactivex.rxjava3.core.m mVar, lz.f fVar) {
        super(mVar);
        this.f65546b = fVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(io.reactivex.rxjava3.core.o oVar) {
        this.f65545a.subscribe(new a(oVar, this.f65546b));
    }
}
