package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

/* loaded from: classes7.dex */
public final class f extends io.reactivex.rxjava3.core.j {

    /* renamed from: a, reason: collision with root package name */
    final lz.k f65560a;

    public f(lz.k kVar) {
        this.f65560a = kVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void D(io.reactivex.rxjava3.core.o oVar) {
        try {
            th = (Throwable) ExceptionHelper.c(this.f65560a.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th2) {
            th = th2;
            io.reactivex.rxjava3.exceptions.a.b(th);
        }
        EmptyDisposable.error(th, oVar);
    }
}
