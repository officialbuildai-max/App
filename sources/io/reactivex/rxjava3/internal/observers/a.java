package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

/* loaded from: classes7.dex */
public abstract class a implements o, io.reactivex.rxjava3.operators.b {

    /* renamed from: a, reason: collision with root package name */
    protected final o f65457a;

    /* renamed from: b, reason: collision with root package name */
    protected io.reactivex.rxjava3.disposables.c f65458b;

    /* renamed from: c, reason: collision with root package name */
    protected io.reactivex.rxjava3.operators.b f65459c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f65460d;

    /* renamed from: e, reason: collision with root package name */
    protected int f65461e;

    public a(o oVar) {
        this.f65457a = oVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Throwable th2) {
        io.reactivex.rxjava3.exceptions.a.b(th2);
        this.f65458b.dispose();
        onError(th2);
    }

    @Override // io.reactivex.rxjava3.operators.g
    public void clear() {
        this.f65459c.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d(int i11) {
        io.reactivex.rxjava3.operators.b bVar = this.f65459c;
        if (bVar == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = bVar.requestFusion(i11);
        if (requestFusion != 0) {
            this.f65461e = requestFusion;
        }
        return requestFusion;
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        this.f65458b.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.f65458b.isDisposed();
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean isEmpty() {
        return this.f65459c.isEmpty();
    }

    @Override // io.reactivex.rxjava3.operators.g
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        if (this.f65460d) {
            return;
        }
        this.f65460d = true;
        this.f65457a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        if (this.f65460d) {
            pz.a.r(th2);
        } else {
            this.f65460d = true;
            this.f65457a.onError(th2);
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
        if (DisposableHelper.validate(this.f65458b, cVar)) {
            this.f65458b = cVar;
            if (cVar instanceof io.reactivex.rxjava3.operators.b) {
                this.f65459c = (io.reactivex.rxjava3.operators.b) cVar;
            }
            if (b()) {
                this.f65457a.onSubscribe(this);
                a();
            }
        }
    }
}
