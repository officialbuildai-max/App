package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
final class g extends io.reactivex.rxjava3.core.e {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.processors.a f65500b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicBoolean f65501c = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(io.reactivex.rxjava3.processors.a aVar) {
        this.f65500b = aVar;
    }

    @Override // io.reactivex.rxjava3.core.e
    protected void g(u10.c cVar) {
        this.f65500b.subscribe(cVar);
        this.f65501c.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return !this.f65501c.get() && this.f65501c.compareAndSet(false, true);
    }
}
