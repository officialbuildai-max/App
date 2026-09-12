package io.reactivex.rxjava3.internal.schedulers;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class c implements Callable, io.reactivex.rxjava3.disposables.c {

    /* renamed from: f, reason: collision with root package name */
    static final FutureTask f65635f = new FutureTask(Functions.f65444b, null);

    /* renamed from: a, reason: collision with root package name */
    final Runnable f65636a;

    /* renamed from: d, reason: collision with root package name */
    final ExecutorService f65639d;

    /* renamed from: e, reason: collision with root package name */
    Thread f65640e;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference f65638c = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f65637b = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.f65636a = runnable;
        this.f65639d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f65640e = Thread.currentThread();
        try {
            this.f65636a.run();
            this.f65640e = null;
            c(this.f65639d.submit(this));
            return null;
        } catch (Throwable th2) {
            this.f65640e = null;
            pz.a.r(th2);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future future) {
        Future future2;
        do {
            future2 = (Future) this.f65638c.get();
            if (future2 == f65635f) {
                future.cancel(this.f65640e != Thread.currentThread());
                return;
            }
        } while (!j0.a(this.f65638c, future2, future));
    }

    void c(Future future) {
        Future future2;
        do {
            future2 = (Future) this.f65637b.get();
            if (future2 == f65635f) {
                future.cancel(this.f65640e != Thread.currentThread());
                return;
            }
        } while (!j0.a(this.f65637b, future2, future));
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        AtomicReference atomicReference = this.f65638c;
        FutureTask futureTask = f65635f;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        if (future != null && future != futureTask) {
            future.cancel(this.f65640e != Thread.currentThread());
        }
        Future future2 = (Future) this.f65637b.getAndSet(futureTask);
        if (future2 == null || future2 == futureTask) {
            return;
        }
        future2.cancel(this.f65640e != Thread.currentThread());
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.f65638c.get() == f65635f;
    }
}
