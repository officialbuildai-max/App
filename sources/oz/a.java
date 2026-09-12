package oz;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public abstract class a implements o, c {

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference f72335a = new AtomicReference();

    protected void a() {
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final void dispose() {
        DisposableHelper.dispose(this.f72335a);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final boolean isDisposed() {
        return this.f72335a.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onSubscribe(c cVar) {
        if (io.reactivex.rxjava3.internal.util.c.c(this.f72335a, cVar, getClass())) {
            a();
        }
    }
}
