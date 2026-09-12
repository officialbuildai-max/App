package io.reactivex.rxjava3.internal.schedulers;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class IoScheduler extends Scheduler {

    /* renamed from: e, reason: collision with root package name */
    static final RxThreadFactory f65601e;

    /* renamed from: f, reason: collision with root package name */
    static final RxThreadFactory f65602f;

    /* renamed from: i, reason: collision with root package name */
    static final a f65605i;

    /* renamed from: j, reason: collision with root package name */
    static boolean f65606j;

    /* renamed from: k, reason: collision with root package name */
    static final CachedWorkerPool f65607k;

    /* renamed from: c, reason: collision with root package name */
    final ThreadFactory f65608c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference f65609d;

    /* renamed from: h, reason: collision with root package name */
    private static final TimeUnit f65604h = TimeUnit.SECONDS;

    /* renamed from: g, reason: collision with root package name */
    private static final long f65603g = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class CachedWorkerPool implements Runnable {
        final io.reactivex.rxjava3.disposables.a allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<a> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        CachedWorkerPool(long j11, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledExecutorService scheduledExecutorService;
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j11) : 0L;
            this.keepAliveTime = nanos;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new io.reactivex.rxjava3.disposables.a();
            this.threadFactory = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f65602f);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        static void evictExpiredWorkers(ConcurrentLinkedQueue<a> concurrentLinkedQueue, io.reactivex.rxjava3.disposables.a aVar) {
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            long now = now();
            Iterator<a> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.e() > now) {
                    return;
                }
                if (concurrentLinkedQueue.remove(next)) {
                    aVar.a(next);
                }
            }
        }

        static long now() {
            return System.nanoTime();
        }

        a get() {
            if (this.allWorkers.isDisposed()) {
                return IoScheduler.f65605i;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                a poll = this.expiringWorkerQueue.poll();
                if (poll != null) {
                    return poll;
                }
            }
            a aVar = new a(this.threadFactory);
            this.allWorkers.b(aVar);
            return aVar;
        }

        void release(a aVar) {
            aVar.f(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            evictExpiredWorkers(this.expiringWorkerQueue, this.allWorkers);
        }

        void shutdown() {
            this.allWorkers.dispose();
            Future<?> future = this.evictorTask;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.evictorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    /* loaded from: classes.dex */
    static final class EventLoopWorker extends Scheduler.Worker implements Runnable {
        private final CachedWorkerPool pool;
        private final a threadWorker;
        final AtomicBoolean once = new AtomicBoolean();
        private final io.reactivex.rxjava3.disposables.a tasks = new io.reactivex.rxjava3.disposables.a();

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.threadWorker = cachedWorkerPool.get();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.tasks.dispose();
                if (IoScheduler.f65606j) {
                    this.threadWorker.a(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.pool.release(this.threadWorker);
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.pool.release(this.threadWorker);
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            return this.tasks.isDisposed() ? EmptyDisposable.INSTANCE : this.threadWorker.a(runnable, j11, timeUnit, this.tasks);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a extends e {

        /* renamed from: c, reason: collision with root package name */
        long f65610c;

        a(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f65610c = 0L;
        }

        public long e() {
            return this.f65610c;
        }

        public void f(long j11) {
            this.f65610c = j11;
        }
    }

    static {
        a aVar = new a(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f65605i = aVar;
        aVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f65601e = rxThreadFactory;
        f65602f = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        f65606j = Boolean.getBoolean("rx3.io-scheduled-release");
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0L, null, rxThreadFactory);
        f65607k = cachedWorkerPool;
        cachedWorkerPool.shutdown();
    }

    public IoScheduler() {
        this(f65601e);
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f65608c = threadFactory;
        this.f65609d = new AtomicReference(f65607k);
        g();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new EventLoopWorker((CachedWorkerPool) this.f65609d.get());
    }

    public void g() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(f65603g, f65604h, this.f65608c);
        if (j0.a(this.f65609d, f65607k, cachedWorkerPool)) {
            return;
        }
        cachedWorkerPool.shutdown();
    }
}
