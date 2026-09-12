package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes7.dex */
public final class l1 extends k1 implements t0 {

    /* renamed from: b, reason: collision with root package name */
    private final Executor f68020b;

    public l1(Executor executor) {
        this.f68020b = executor;
        if (d() instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) d()).setRemoveOnCancelPolicy(true);
        }
    }

    private final void p(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        v1.c(coroutineContext, i1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture q(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j11) {
        try {
            return scheduledExecutorService.schedule(runnable, j11, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e11) {
            p(coroutineContext, e11);
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor d11 = d();
        ExecutorService executorService = d11 instanceof ExecutorService ? (ExecutorService) d11 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.k1
    public Executor d() {
        return this.f68020b;
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b bVar;
        b bVar2;
        Runnable runnable2;
        try {
            Executor d11 = d();
            bVar2 = c.f67766a;
            if (bVar2 != null) {
                runnable2 = bVar2.h(runnable);
                if (runnable2 == null) {
                }
                d11.execute(runnable2);
            }
            runnable2 = runnable;
            d11.execute(runnable2);
        } catch (RejectedExecutionException e11) {
            bVar = c.f67766a;
            if (bVar != null) {
                bVar.e();
            }
            p(coroutineContext, e11);
            y0.b().dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof l1) && ((l1) obj).d() == d();
    }

    public int hashCode() {
        return System.identityHashCode(d());
    }

    @Override // kotlinx.coroutines.t0
    public a1 invokeOnTimeout(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        Executor d11 = d();
        ScheduledExecutorService scheduledExecutorService = d11 instanceof ScheduledExecutorService ? (ScheduledExecutorService) d11 : null;
        ScheduledFuture q11 = scheduledExecutorService != null ? q(scheduledExecutorService, runnable, coroutineContext, j11) : null;
        return q11 != null ? new z0(q11) : DefaultExecutor.INSTANCE.invokeOnTimeout(j11, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.t0
    public void scheduleResumeAfterDelay(long j11, n nVar) {
        Executor d11 = d();
        ScheduledExecutorService scheduledExecutorService = d11 instanceof ScheduledExecutorService ? (ScheduledExecutorService) d11 : null;
        ScheduledFuture q11 = scheduledExecutorService != null ? q(scheduledExecutorService, new ResumeUndispatchedRunnable(this, nVar), nVar.getContext(), j11) : null;
        if (q11 != null) {
            q.c(nVar, new l(q11));
        } else {
            DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(j11, nVar);
        }
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        return d().toString();
    }
}
