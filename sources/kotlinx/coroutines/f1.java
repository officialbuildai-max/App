package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.EventLoopImplBase;

/* loaded from: classes7.dex */
public abstract class f1 extends e1 {
    protected abstract Thread getThread();

    /* JADX INFO: Access modifiers changed from: protected */
    public void reschedule(long j11, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(j11, delayedTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void unpark() {
        b bVar;
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            bVar = c.f67766a;
            if (bVar != null) {
                bVar.f(thread);
            } else {
                LockSupport.unpark(thread);
            }
        }
    }
}
