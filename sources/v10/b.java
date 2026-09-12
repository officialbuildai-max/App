package v10;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.j0;

/* loaded from: classes7.dex */
final class b extends j {

    /* renamed from: a, reason: collision with root package name */
    private final retrofit2.d f77115a;

    /* loaded from: classes7.dex */
    private static final class a implements io.reactivex.rxjava3.disposables.c, retrofit2.f {

        /* renamed from: a, reason: collision with root package name */
        private final retrofit2.d f77116a;

        /* renamed from: b, reason: collision with root package name */
        private final o f77117b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f77118c;

        /* renamed from: d, reason: collision with root package name */
        boolean f77119d = false;

        a(retrofit2.d dVar, o oVar) {
            this.f77116a = dVar;
            this.f77117b = oVar;
        }

        @Override // retrofit2.f
        public void a(retrofit2.d dVar, Throwable th2) {
            if (dVar.isCanceled()) {
                return;
            }
            try {
                this.f77117b.onError(th2);
            } catch (Throwable th3) {
                io.reactivex.rxjava3.exceptions.a.b(th3);
                pz.a.r(new CompositeException(th2, th3));
            }
        }

        @Override // retrofit2.f
        public void b(retrofit2.d dVar, j0 j0Var) {
            if (this.f77118c) {
                return;
            }
            try {
                this.f77117b.onNext(j0Var);
                if (this.f77118c) {
                    return;
                }
                this.f77119d = true;
                this.f77117b.onComplete();
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                if (this.f77119d) {
                    pz.a.r(th2);
                    return;
                }
                if (this.f77118c) {
                    return;
                }
                try {
                    this.f77117b.onError(th2);
                } catch (Throwable th3) {
                    io.reactivex.rxjava3.exceptions.a.b(th3);
                    pz.a.r(new CompositeException(th2, th3));
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.f77118c = true;
            this.f77116a.cancel();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f77118c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(retrofit2.d dVar) {
        this.f77115a = dVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(o oVar) {
        retrofit2.d clone = this.f77115a.clone();
        a aVar = new a(clone, oVar);
        oVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        clone.h(aVar);
    }
}
