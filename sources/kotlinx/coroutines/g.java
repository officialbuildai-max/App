package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class g extends a {

    /* renamed from: a, reason: collision with root package name */
    private final Thread f67953a;

    /* renamed from: b, reason: collision with root package name */
    private final e1 f67954b;

    public g(CoroutineContext coroutineContext, Thread thread, e1 e1Var) {
        super(coroutineContext, true, true);
        this.f67953a = thread;
        this.f67954b = e1Var;
    }

    public final Object X() {
        b bVar;
        b bVar2;
        b bVar3;
        bVar = c.f67766a;
        if (bVar != null) {
            bVar.c();
        }
        try {
            e1 e1Var = this.f67954b;
            if (e1Var != null) {
                e1.incrementUseCount$default(e1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    e1 e1Var2 = this.f67954b;
                    long processNextEvent = e1Var2 != null ? e1Var2.processNextEvent() : Long.MAX_VALUE;
                    if (isCompleted()) {
                        e1 e1Var3 = this.f67954b;
                        if (e1Var3 != null) {
                            e1.decrementUseCount$default(e1Var3, false, 1, null);
                        }
                        Object h11 = x1.h(getState$kotlinx_coroutines_core());
                        b0 b0Var = h11 instanceof b0 ? (b0) h11 : null;
                        if (b0Var == null) {
                            return h11;
                        }
                        throw b0Var.f67764a;
                    }
                    bVar3 = c.f67766a;
                    if (bVar3 != null) {
                        bVar3.b(this, processNextEvent);
                    } else {
                        LockSupport.parkNanos(this, processNextEvent);
                    }
                } catch (Throwable th2) {
                    e1 e1Var4 = this.f67954b;
                    if (e1Var4 != null) {
                        e1.decrementUseCount$default(e1Var4, false, 1, null);
                    }
                    throw th2;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } finally {
            bVar2 = c.f67766a;
            if (bVar2 != null) {
                bVar2.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(Object obj) {
        b bVar;
        if (Intrinsics.c(Thread.currentThread(), this.f67953a)) {
            return;
        }
        Thread thread = this.f67953a;
        bVar = c.f67766a;
        if (bVar != null) {
            bVar.f(thread);
        } else {
            LockSupport.unpark(thread);
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean isScopedCoroutine() {
        return true;
    }
}
