package io.reactivex.rxjava3.internal.operators.flowable;

/* loaded from: classes7.dex */
final class f extends rz.a {

    /* renamed from: b, reason: collision with root package name */
    final FlowableWindowBoundary$WindowBoundaryMainSubscriber f65498b;

    /* renamed from: c, reason: collision with root package name */
    boolean f65499c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FlowableWindowBoundary$WindowBoundaryMainSubscriber flowableWindowBoundary$WindowBoundaryMainSubscriber) {
        this.f65498b = flowableWindowBoundary$WindowBoundaryMainSubscriber;
    }

    @Override // u10.c
    public void onComplete() {
        if (this.f65499c) {
            return;
        }
        this.f65499c = true;
        this.f65498b.innerComplete();
    }

    @Override // u10.c
    public void onError(Throwable th2) {
        if (this.f65499c) {
            pz.a.r(th2);
        } else {
            this.f65499c = true;
            this.f65498b.innerError(th2);
        }
    }

    @Override // u10.c
    public void onNext(Object obj) {
        if (this.f65499c) {
            return;
        }
        this.f65498b.innerNext();
    }
}
