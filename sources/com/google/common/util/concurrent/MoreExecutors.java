package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.l;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class MoreExecutors {

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ r val$future;
        final /* synthetic */ BlockingQueue val$queue;

        AnonymousClass1(BlockingQueue blockingQueue, r rVar) {
            this.val$queue = blockingQueue;
            this.val$future = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$queue.add(this.val$future);
        }
    }

    /* loaded from: classes4.dex */
    private static final class ScheduledListeningDecorator extends c implements ScheduledExecutorService, t {

        /* renamed from: b, reason: collision with root package name */
        final ScheduledExecutorService f31056b;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.h implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                this.delegate = (Runnable) com.google.common.base.m.o(runnable);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.util.concurrent.AbstractFuture
            public String pendingToString() {
                return "task=[" + this.delegate + "]";
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.delegate.run();
                } catch (Throwable th2) {
                    setException(th2);
                    throw th2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class a extends l.a implements s {

            /* renamed from: b, reason: collision with root package name */
            private final ScheduledFuture f31057b;

            public a(r rVar, ScheduledFuture scheduledFuture) {
                super(rVar);
                this.f31057b = scheduledFuture;
            }

            @Override // com.google.common.util.concurrent.k, java.util.concurrent.Future
            public boolean cancel(boolean z10) {
                boolean cancel = super.cancel(z10);
                if (cancel) {
                    this.f31057b.cancel(z10);
                }
                return cancel;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.f31057b.getDelay(timeUnit);
            }

            @Override // java.lang.Comparable
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compareTo(Delayed delayed) {
                return this.f31057b.compareTo(delayed);
            }
        }

        ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f31056b = (ScheduledExecutorService) com.google.common.base.m.o(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public s schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(runnable, null);
            return new a(create, this.f31056b.schedule(create, j11, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public s schedule(Callable callable, long j11, TimeUnit timeUnit) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(callable);
            return new a(create, this.f31056b.schedule(create, j11, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public s scheduleAtFixedRate(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new a(neverSuccessfulListenableFutureTask, this.f31056b.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j11, j12, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public s scheduleWithFixedDelay(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new a(neverSuccessfulListenableFutureTask, this.f31056b.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j11, j12, timeUnit));
        }
    }

    /* loaded from: classes4.dex */
    class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f31058a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractFuture f31059b;

        a(Executor executor, AbstractFuture abstractFuture) {
            this.f31058a = executor;
            this.f31059b = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f31058a.execute(runnable);
            } catch (RejectedExecutionException e11) {
                this.f31059b.setException(e11);
            }
        }
    }

    /* loaded from: classes4.dex */
    static class b {
    }

    /* loaded from: classes4.dex */
    private static class c extends com.google.common.util.concurrent.a {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f31060a;

        c(ExecutorService executorService) {
            this.f31060a = (ExecutorService) com.google.common.base.m.o(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j11, TimeUnit timeUnit) {
            return this.f31060a.awaitTermination(j11, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f31060a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f31060a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f31060a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f31060a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List shutdownNow() {
            return this.f31060a.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.f31060a + "]";
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    public static t b(ExecutorService executorService) {
        if (executorService instanceof t) {
            return (t) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new c(executorService);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor c(Executor executor, AbstractFuture abstractFuture) {
        com.google.common.base.m.o(executor);
        com.google.common.base.m.o(abstractFuture);
        return executor == a() ? executor : new a(executor, abstractFuture);
    }
}
