package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.t0;

/* loaded from: classes7.dex */
public final class r extends kotlinx.coroutines.i0 implements t0 {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ t0 f68005a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.i0 f68006b;

    /* renamed from: c, reason: collision with root package name */
    private final String f68007c;

    /* JADX WARN: Multi-variable type inference failed */
    public r(kotlinx.coroutines.i0 i0Var, String str) {
        t0 t0Var = i0Var instanceof t0 ? (t0) i0Var : null;
        this.f68005a = t0Var == null ? q0.a() : t0Var;
        this.f68006b = i0Var;
        this.f68007c = str;
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.f68006b.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.i0
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        this.f68006b.dispatchYield(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.t0
    public a1 invokeOnTimeout(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f68005a.invokeOnTimeout(j11, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.i0
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return this.f68006b.isDispatchNeeded(coroutineContext);
    }

    @Override // kotlinx.coroutines.t0
    public void scheduleResumeAfterDelay(long j11, kotlinx.coroutines.n nVar) {
        this.f68005a.scheduleResumeAfterDelay(j11, nVar);
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        return this.f68007c;
    }
}
