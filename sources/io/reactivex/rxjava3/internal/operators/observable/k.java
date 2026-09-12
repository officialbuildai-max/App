package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;

/* loaded from: classes7.dex */
public final class k extends io.reactivex.rxjava3.core.j implements io.reactivex.rxjava3.operators.e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f65567a;

    public k(Object obj) {
        this.f65567a = obj;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(io.reactivex.rxjava3.core.o oVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(oVar, this.f65567a);
        oVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    @Override // io.reactivex.rxjava3.operators.e, lz.k
    public Object get() {
        return this.f65567a;
    }
}
