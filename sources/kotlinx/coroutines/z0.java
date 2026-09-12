package kotlinx.coroutines;

import java.util.concurrent.Future;

/* loaded from: classes7.dex */
final class z0 implements a1 {

    /* renamed from: a, reason: collision with root package name */
    private final Future f68139a;

    public z0(Future future) {
        this.f68139a = future;
    }

    @Override // kotlinx.coroutines.a1
    public void dispose() {
        this.f68139a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f68139a + ']';
    }
}
