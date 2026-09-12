package kotlinx.coroutines;

import java.util.concurrent.Future;

/* loaded from: classes7.dex */
final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    private final Future f68018a;

    public l(Future future) {
        this.f68018a = future;
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable th2) {
        this.f68018a.cancel(false);
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f68018a + ']';
    }
}
