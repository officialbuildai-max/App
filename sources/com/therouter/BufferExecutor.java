package com.therouter;

import android.os.Looper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class BufferExecutor implements ExecutorService, Executor {

    /* renamed from: b, reason: collision with root package name */
    private Task f40755b;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayDeque f40754a = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap f40756c = new ConcurrentHashMap();

    private final void b() {
        Collection<b> values = this.f40756c.values();
        Intrinsics.g(values, "<get-values>(...)");
        for (b bVar : values) {
            boolean z10 = System.currentTimeMillis() - bVar.a() < TheRouterThreadPool.h() * 1000;
            TheRouterKt.h(z10, "ThreadPool", "执行该任务耗时过久，有可能是此任务耗时，或者当前线程池中其他任务都很耗时，请优化逻辑\n当前任务被创建时间为" + bVar.a() + "此时时间为" + System.currentTimeMillis() + "\n" + bVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void d() {
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        int i11;
        ThreadPoolExecutor threadPoolExecutor4;
        int i12;
        ThreadPoolExecutor threadPoolExecutor5;
        ThreadPoolExecutor threadPoolExecutor6;
        int i13;
        try {
            if (Intrinsics.c(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                e(this);
            } else {
                threadPoolExecutor = TheRouterThreadPool.f40774i;
                int activeCount = threadPoolExecutor.getActiveCount();
                threadPoolExecutor2 = TheRouterThreadPool.f40774i;
                int size = threadPoolExecutor2.getQueue().size();
                if (this.f40754a.size() > TheRouterThreadPool.i() * 100) {
                    threadPoolExecutor6 = TheRouterThreadPool.f40774i;
                    i13 = TheRouterThreadPool.f40769d;
                    threadPoolExecutor6.setCorePoolSize(i13);
                } else if (this.f40754a.size() > TheRouterThreadPool.i() * 10) {
                    threadPoolExecutor4 = TheRouterThreadPool.f40774i;
                    i12 = TheRouterThreadPool.f40768c;
                    threadPoolExecutor4.setCorePoolSize(i12);
                } else {
                    threadPoolExecutor3 = TheRouterThreadPool.f40774i;
                    i11 = TheRouterThreadPool.f40767b;
                    threadPoolExecutor3.setCorePoolSize(i11);
                }
                if (size <= TheRouterThreadPool.i()) {
                    threadPoolExecutor5 = TheRouterThreadPool.f40774i;
                    if (activeCount < threadPoolExecutor5.getCorePoolSize()) {
                        e(this);
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static final void e(BufferExecutor bufferExecutor) {
        ThreadPoolExecutor threadPoolExecutor;
        Object poll = bufferExecutor.f40754a.poll();
        Task task = (Task) poll;
        bufferExecutor.f40755b = task;
        if (poll != null) {
            if (task != null && TheRouter.m()) {
                bufferExecutor.f40756c.put(Integer.valueOf(task.getR().hashCode()), new b(task.getTrace()));
            }
            threadPoolExecutor = TheRouterThreadPool.f40774i;
            threadPoolExecutor.execute(bufferExecutor.f40755b);
            bufferExecutor.f40755b = null;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean awaitTermination(long j11, TimeUnit unit) {
        ThreadPoolExecutor threadPoolExecutor;
        Intrinsics.h(unit, "unit");
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        return threadPoolExecutor.awaitTermination(j11, unit);
    }

    public final ConcurrentHashMap c() {
        return this.f40756c;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable r11) {
        String str;
        try {
            Intrinsics.h(r11, "r");
            ArrayDeque arrayDeque = this.f40754a;
            if (TheRouter.m()) {
                b();
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                Intrinsics.g(stackTrace, "getStackTrace(...)");
                str = TheRouterThreadPool.j(stackTrace);
            } else {
                str = "";
            }
            arrayDeque.offer(new Task(r11, str, new Function0<Unit>() { // from class: com.therouter.BufferExecutor$execute$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m845invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m845invoke() {
                    if (TheRouter.m()) {
                        BufferExecutor.this.c().remove(Integer.valueOf(r11.hashCode()));
                    }
                    BufferExecutor.this.d();
                }
            }));
            if (this.f40755b == null) {
                d();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized List invokeAll(Collection tasks) {
        ThreadPoolExecutor threadPoolExecutor;
        List invokeAll;
        Intrinsics.h(tasks, "tasks");
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        invokeAll = threadPoolExecutor.invokeAll(tasks);
        Intrinsics.g(invokeAll, "invokeAll(...)");
        return invokeAll;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized List invokeAll(Collection tasks, long j11, TimeUnit unit) {
        ThreadPoolExecutor threadPoolExecutor;
        List invokeAll;
        Intrinsics.h(tasks, "tasks");
        Intrinsics.h(unit, "unit");
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        invokeAll = threadPoolExecutor.invokeAll(tasks, j11, unit);
        Intrinsics.g(invokeAll, "invokeAll(...)");
        return invokeAll;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized Object invokeAny(Collection tasks) {
        ThreadPoolExecutor threadPoolExecutor;
        Intrinsics.h(tasks, "tasks");
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        return threadPoolExecutor.invokeAny(tasks);
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized Object invokeAny(Collection tasks, long j11, TimeUnit unit) {
        ThreadPoolExecutor threadPoolExecutor;
        Intrinsics.h(tasks, "tasks");
        Intrinsics.h(unit, "unit");
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        return threadPoolExecutor.invokeAny(tasks, j11, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean isShutdown() {
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        return threadPoolExecutor.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean isTerminated() {
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        return threadPoolExecutor.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized void shutdown() {
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        threadPoolExecutor.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized List shutdownNow() {
        ThreadPoolExecutor threadPoolExecutor;
        List<Runnable> shutdownNow;
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        shutdownNow = threadPoolExecutor.shutdownNow();
        Intrinsics.g(shutdownNow, "shutdownNow(...)");
        return shutdownNow;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized Future submit(Runnable task) {
        ThreadPoolExecutor threadPoolExecutor;
        Future<?> submit;
        Intrinsics.h(task, "task");
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        submit = threadPoolExecutor.submit(task);
        Intrinsics.g(submit, "submit(...)");
        return submit;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized Future submit(Runnable task, Object obj) {
        ThreadPoolExecutor threadPoolExecutor;
        Future submit;
        Intrinsics.h(task, "task");
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        submit = threadPoolExecutor.submit(task, obj);
        Intrinsics.g(submit, "submit(...)");
        return submit;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized Future submit(Callable task) {
        ThreadPoolExecutor threadPoolExecutor;
        Future submit;
        Intrinsics.h(task, "task");
        threadPoolExecutor = TheRouterThreadPool.f40774i;
        submit = threadPoolExecutor.submit(task);
        Intrinsics.g(submit, "submit(...)");
        return submit;
    }
}
