package com.transsion.push.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ThreadManager {

    /* loaded from: classes6.dex */
    private static class SerialExecutor implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final Queue f50973a;

        /* renamed from: b, reason: collision with root package name */
        Runnable f50974b;

        private SerialExecutor() {
            this.f50973a = new LinkedList();
        }

        protected synchronized void a() {
            Runnable runnable = (Runnable) this.f50973a.poll();
            this.f50974b = runnable;
            if (runnable != null) {
                ThreadManager.a().execute(this.f50974b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f50973a.offer(new Runnable() { // from class: com.transsion.push.utils.ThreadManager.SerialExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.a();
                    }
                }
            });
            if (this.f50974b == null) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static HandlerThread f50975a;

        /* renamed from: b, reason: collision with root package name */
        private static Handler f50976b;

        static {
            HandlerThread handlerThread = new HandlerThread("event-thread");
            f50975a = handlerThread;
            handlerThread.start();
            f50976b = new Handler(f50975a.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static ExecutorService f50977a = new ThreadPoolExecutor(2, 20, 1, TimeUnit.SECONDS, new SynchronousQueue(), new f(), new ThreadPoolExecutor.DiscardPolicy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static ScheduledExecutorService f50978a = Executors.newSingleThreadScheduledExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static ExecutorService f50979a = Executors.newSingleThreadExecutor();
    }

    /* loaded from: classes6.dex */
    private static class f implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f50980d = new AtomicInteger(1);

        /* renamed from: a, reason: collision with root package name */
        private final ThreadGroup f50981a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f50982b = new AtomicInteger(1);

        /* renamed from: c, reason: collision with root package name */
        private final String f50983c;

        f() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f50981a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f50983c = "tpush-pool-" + f50980d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f50981a, runnable, this.f50983c + this.f50982b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private static HandlerThread f50984a;

        /* renamed from: b, reason: collision with root package name */
        private static Handler f50985b;

        static {
            HandlerThread handlerThread = new HandlerThread("globle_timer");
            f50984a = handlerThread;
            handlerThread.start();
            f50985b = new Handler(f50984a.getLooper());
        }
    }

    static /* synthetic */ ExecutorService a() {
        return c();
    }

    private static Handler b() {
        return b.f50976b;
    }

    private static ExecutorService c() {
        return c.f50977a;
    }

    private static ScheduledExecutorService d() {
        return d.f50978a;
    }

    private static ExecutorService e() {
        return e.f50979a;
    }

    public static final void execute(Runnable runnable) {
        c().execute(runnable);
    }

    public static void executeInBackground(Runnable runnable) {
        execute(runnable);
    }

    public static void executeInDbWriteThread(Runnable runnable) {
        executeInSingle(runnable);
    }

    public static void executeInSingle(Runnable runnable) {
        e().execute(runnable);
    }

    private static Handler f() {
        return g.f50985b;
    }

    public static Executor newSerialExecutor() {
        return new SerialExecutor();
    }

    public static void postAtTime(Runnable runnable, long j11) {
        f().postAtTime(runnable, j11);
    }

    public static void postDelayed(Runnable runnable, long j11) {
        f().postDelayed(runnable, j11);
    }

    public static void postDelayedAndRemoveBefore(Runnable runnable, long j11) {
        f().removeCallbacks(runnable);
        f().postDelayed(runnable, j11);
    }

    public static void runInEventThread(Runnable runnable) {
        b().post(runnable);
    }

    public static final ScheduledFuture<?> schedule(Runnable runnable, long j11) {
        return d().schedule(runnable, j11, TimeUnit.MILLISECONDS);
    }

    public static final <T> ScheduledFuture<T> schedule(Callable<T> callable, long j11) {
        return d().schedule(callable, j11, TimeUnit.MILLISECONDS);
    }

    public static final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j11, long j12) {
        return d().scheduleAtFixedRate(runnable, j11, j12, TimeUnit.MILLISECONDS);
    }

    public static ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j11, long j12) {
        return d().scheduleWithFixedDelay(runnable, j11, j12, TimeUnit.MILLISECONDS);
    }

    public static final Future<?> submit(Runnable runnable) {
        return c().submit(runnable);
    }

    public static final <T> Future<T> submit(Runnable runnable, T t11) {
        return c().submit(runnable, t11);
    }

    public static final <T> Future<T> submit(Callable<T> callable) {
        return c().submit(callable);
    }

    public static Future<?> submitInSingle(Runnable runnable) {
        return e().submit(runnable);
    }

    public static <T> Future<T> submitInSingle(Runnable runnable, T t11) {
        return e().submit(runnable, t11);
    }

    public static <T> Future<T> submitInSingle(Callable<T> callable) {
        return e().submit(callable);
    }
}
