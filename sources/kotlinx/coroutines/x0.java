package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class x0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final i0 f68127a;

    public x0(i0 i0Var) {
        this.f68127a = i0Var;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        i0 i0Var = this.f68127a;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (i0Var.isDispatchNeeded(emptyCoroutineContext)) {
            this.f68127a.dispatch(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f68127a.toString();
    }
}
