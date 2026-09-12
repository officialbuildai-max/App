package v10;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.adapter.rxjava3.HttpException;
import retrofit2.j0;

/* loaded from: classes7.dex */
final class a extends j {

    /* renamed from: a, reason: collision with root package name */
    private final j f77112a;

    /* renamed from: v10.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0971a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final o f77113a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f77114b;

        C0971a(o oVar) {
            this.f77113a = oVar;
        }

        @Override // io.reactivex.rxjava3.core.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(j0 j0Var) {
            if (j0Var.e()) {
                this.f77113a.onNext(j0Var.a());
                return;
            }
            this.f77114b = true;
            HttpException httpException = new HttpException(j0Var);
            try {
                this.f77113a.onError(httpException);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                pz.a.r(new CompositeException(httpException, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            if (this.f77114b) {
                return;
            }
            this.f77113a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable th2) {
            if (!this.f77114b) {
                this.f77113a.onError(th2);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th2);
            pz.a.r(assertionError);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            this.f77113a.onSubscribe(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar) {
        this.f77112a = jVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void D(o oVar) {
        this.f77112a.subscribe(new C0971a(oVar));
    }
}
