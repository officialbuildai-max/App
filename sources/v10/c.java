package v10;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.j0;

/* loaded from: classes7.dex */
final class c extends j {

    /* renamed from: a, reason: collision with root package name */
    private final retrofit2.d f77120a;

    /* loaded from: classes7.dex */
    private static final class a implements io.reactivex.rxjava3.disposables.c {

        /* renamed from: a, reason: collision with root package name */
        private final retrofit2.d f77121a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f77122b;

        a(retrofit2.d dVar) {
            this.f77121a = dVar;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.f77122b = true;
            this.f77121a.cancel();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f77122b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(retrofit2.d dVar) {
        this.f77120a = dVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(o oVar) {
        boolean z10;
        retrofit2.d clone = this.f77120a.clone();
        a aVar = new a(clone);
        oVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        try {
            j0 execute = clone.execute();
            if (!aVar.isDisposed()) {
                oVar.onNext(execute);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                oVar.onComplete();
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                io.reactivex.rxjava3.exceptions.a.b(th);
                if (z10) {
                    pz.a.r(th);
                    return;
                }
                if (aVar.isDisposed()) {
                    return;
                }
                try {
                    oVar.onError(th);
                } catch (Throwable th3) {
                    io.reactivex.rxjava3.exceptions.a.b(th3);
                    pz.a.r(new CompositeException(th, th3));
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z10 = false;
        }
    }
}
