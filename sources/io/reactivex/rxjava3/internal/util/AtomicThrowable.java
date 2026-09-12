package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.core.q;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean isTerminated() {
        return get() == ExceptionHelper.f65673a;
    }

    public Throwable terminate() {
        return ExceptionHelper.e(this);
    }

    public boolean tryAddThrowable(Throwable th2) {
        return ExceptionHelper.a(this, th2);
    }

    public boolean tryAddThrowableOrReport(Throwable th2) {
        if (tryAddThrowable(th2)) {
            return true;
        }
        pz.a.r(th2);
        return false;
    }

    public void tryTerminateAndReport() {
        Throwable terminate = terminate();
        if (terminate == null || terminate == ExceptionHelper.f65673a) {
            return;
        }
        pz.a.r(terminate);
    }

    public void tryTerminateConsumer(io.reactivex.rxjava3.core.b bVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            bVar.onComplete();
        } else if (terminate != ExceptionHelper.f65673a) {
            bVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(io.reactivex.rxjava3.core.d dVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            dVar.onComplete();
        } else if (terminate != ExceptionHelper.f65673a) {
            dVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(io.reactivex.rxjava3.core.h hVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            hVar.onComplete();
        } else if (terminate != ExceptionHelper.f65673a) {
            hVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(o oVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            oVar.onComplete();
        } else if (terminate != ExceptionHelper.f65673a) {
            oVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(q qVar) {
        Throwable terminate = terminate();
        if (terminate == null || terminate == ExceptionHelper.f65673a) {
            return;
        }
        qVar.onError(terminate);
    }

    public void tryTerminateConsumer(u10.c cVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            cVar.onComplete();
        } else if (terminate != ExceptionHelper.f65673a) {
            cVar.onError(terminate);
        }
    }
}
