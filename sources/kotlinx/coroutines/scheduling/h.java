package kotlinx.coroutines.scheduling;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.i0;

/* loaded from: classes7.dex */
final class h extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final h f68069a = new h();

    private h() {
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b.f68056g.q(runnable, true, false);
    }

    @Override // kotlinx.coroutines.i0
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        b.f68056g.q(runnable, true, true);
    }

    @Override // kotlinx.coroutines.i0
    public i0 limitedParallelism(int i11, String str) {
        kotlinx.coroutines.internal.i.a(i11);
        return i11 >= g.f68066d ? kotlinx.coroutines.internal.i.b(this, str) : super.limitedParallelism(i11, str);
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        return "Dispatchers.IO";
    }
}
