package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class Futures extends o {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class CallbackListener<V> implements Runnable {
        final m callback;
        final Future<V> future;

        CallbackListener(Future<V> future, m mVar) {
            this.future = future;
            this.callback = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable a11;
            Future<V> future = this.future;
            if ((future instanceof gb.a) && (a11 = gb.b.a((gb.a) future)) != null) {
                this.callback.onFailure(a11);
                return;
            }
            try {
                this.callback.onSuccess(Futures.d(this.future));
            } catch (ExecutionException e11) {
                this.callback.onFailure(e11.getCause());
            } catch (Throwable th2) {
                this.callback.onFailure(th2);
            }
        }

        public String toString() {
            return com.google.common.base.h.b(this).j(this.callback).toString();
        }
    }

    /* loaded from: classes4.dex */
    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.h implements Runnable {
        private r delegate;

        NonCancellationPropagatingFuture(r rVar) {
            this.delegate = rVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.delegate = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            r rVar = this.delegate;
            if (rVar == null) {
                return null;
            }
            return "delegate=[" + rVar + "]";
        }

        @Override // java.lang.Runnable
        public void run() {
            r rVar = this.delegate;
            if (rVar != null) {
                setFuture(rVar);
            }
        }
    }

    public static void a(r rVar, m mVar, Executor executor) {
        com.google.common.base.m.o(mVar);
        rVar.addListener(new CallbackListener(rVar, mVar), executor);
    }

    public static r b(r rVar, Class cls, com.google.common.base.f fVar, Executor executor) {
        return AbstractCatchingFuture.create(rVar, cls, fVar, executor);
    }

    public static r c(r rVar, Class cls, f fVar, Executor executor) {
        return AbstractCatchingFuture.createAsync(rVar, cls, fVar, executor);
    }

    public static Object d(Future future) {
        com.google.common.base.m.x(future.isDone(), "Future was expected to be done: %s", future);
        return z.a(future);
    }

    public static r e(Throwable th2) {
        com.google.common.base.m.o(th2);
        return new p(th2);
    }

    public static r f(r rVar, com.google.common.base.f fVar, Executor executor) {
        return AbstractTransformFuture.create(rVar, fVar, executor);
    }

    public static r g(r rVar, f fVar, Executor executor) {
        return AbstractTransformFuture.createAsync(rVar, fVar, executor);
    }

    public static r h(r rVar, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return rVar.isDone() ? rVar : TimeoutFuture.v(rVar, j11, timeUnit, scheduledExecutorService);
    }
}
