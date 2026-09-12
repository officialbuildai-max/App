package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes7.dex */
public abstract class b extends CountDownLatch implements o, io.reactivex.rxjava3.disposables.c {

    /* renamed from: a, reason: collision with root package name */
    Object f65462a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f65463b;

    /* renamed from: c, reason: collision with root package name */
    io.reactivex.rxjava3.disposables.c f65464c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f65465d;

    public b() {
        super(1);
    }

    public final Object a() {
        if (getCount() != 0) {
            try {
                io.reactivex.rxjava3.internal.util.b.a();
                await();
            } catch (InterruptedException e11) {
                dispose();
                throw ExceptionHelper.g(e11);
            }
        }
        Throwable th2 = this.f65463b;
        if (th2 == null) {
            return this.f65462a;
        }
        throw ExceptionHelper.g(th2);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final void dispose() {
        this.f65465d = true;
        io.reactivex.rxjava3.disposables.c cVar = this.f65464c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final boolean isDisposed() {
        return this.f65465d;
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
        this.f65464c = cVar;
        if (this.f65465d) {
            cVar.dispose();
        }
    }
}
