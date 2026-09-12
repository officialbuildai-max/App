package io.reactivex.rxjava3.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
final class r extends io.reactivex.rxjava3.core.j {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.subjects.a f65590a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicBoolean f65591b = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(io.reactivex.rxjava3.subjects.a aVar) {
        this.f65590a = aVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(io.reactivex.rxjava3.core.o oVar) {
        this.f65590a.subscribe(oVar);
        this.f65591b.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J() {
        return !this.f65591b.get() && this.f65591b.compareAndSet(false, true);
    }
}
