package io.reactivex.rxjava3.internal.operators.observable;

/* loaded from: classes7.dex */
final class q extends oz.a {

    /* renamed from: b, reason: collision with root package name */
    final ObservableWindowBoundary$WindowBoundaryMainObserver f65588b;

    /* renamed from: c, reason: collision with root package name */
    boolean f65589c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ObservableWindowBoundary$WindowBoundaryMainObserver observableWindowBoundary$WindowBoundaryMainObserver) {
        this.f65588b = observableWindowBoundary$WindowBoundaryMainObserver;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (this.f65589c) {
            return;
        }
        this.f65589c = true;
        this.f65588b.innerComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        if (this.f65589c) {
            pz.a.r(th2);
        } else {
            this.f65589c = true;
            this.f65588b.innerError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(Object obj) {
        if (this.f65589c) {
            return;
        }
        this.f65588b.innerNext();
    }
}
