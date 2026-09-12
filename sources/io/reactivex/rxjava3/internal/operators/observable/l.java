package io.reactivex.rxjava3.internal.operators.observable;

import java.util.Objects;

/* loaded from: classes7.dex */
public final class l extends io.reactivex.rxjava3.internal.operators.observable.a {

    /* renamed from: b, reason: collision with root package name */
    final lz.h f65568b;

    /* loaded from: classes7.dex */
    static final class a extends io.reactivex.rxjava3.internal.observers.a {

        /* renamed from: f, reason: collision with root package name */
        final lz.h f65569f;

        a(io.reactivex.rxjava3.core.o oVar, lz.h hVar) {
            super(oVar);
            this.f65569f = hVar;
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onNext(Object obj) {
            if (this.f65460d) {
                return;
            }
            if (this.f65461e != 0) {
                this.f65457a.onNext(null);
                return;
            }
            try {
                Object apply = this.f65569f.apply(obj);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                this.f65457a.onNext(apply);
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // io.reactivex.rxjava3.operators.g
        public Object poll() {
            Object poll = this.f65459c.poll();
            if (poll == null) {
                return null;
            }
            Object apply = this.f65569f.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        @Override // io.reactivex.rxjava3.operators.c
        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public l(io.reactivex.rxjava3.core.m mVar, lz.h hVar) {
        super(mVar);
        this.f65568b = hVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void D(io.reactivex.rxjava3.core.o oVar) {
        this.f65545a.subscribe(new a(oVar, this.f65568b));
    }
}
