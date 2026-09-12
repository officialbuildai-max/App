package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class i extends nz.a {

    /* renamed from: b, reason: collision with root package name */
    final ObservableGroupBy$State f65563b;

    protected i(Object obj, ObservableGroupBy$State observableGroupBy$State) {
        super(obj);
        this.f65563b = observableGroupBy$State;
    }

    public static i J(Object obj, int i11, ObservableGroupBy$GroupByObserver observableGroupBy$GroupByObserver, boolean z10) {
        return new i(obj, new ObservableGroupBy$State(i11, observableGroupBy$GroupByObserver, obj, z10));
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(io.reactivex.rxjava3.core.o oVar) {
        this.f65563b.subscribe(oVar);
    }

    public void onComplete() {
        this.f65563b.onComplete();
    }

    public void onError(Throwable th2) {
        this.f65563b.onError(th2);
    }

    public void onNext(Object obj) {
        this.f65563b.onNext(obj);
    }
}
