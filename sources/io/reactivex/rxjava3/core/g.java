package io.reactivex.rxjava3.core;

import java.util.Objects;

/* loaded from: classes7.dex */
public abstract class g implements i {
    @Override // io.reactivex.rxjava3.core.i
    public final void a(h hVar) {
        Objects.requireNonNull(hVar, "observer is null");
        h w11 = pz.a.w(this, hVar);
        Objects.requireNonNull(w11, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(w11);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    protected abstract void b(h hVar);
}
