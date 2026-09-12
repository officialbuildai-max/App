package com.transsion.core.pool;

import android.os.Process;
import android.os.StrictMode;
import com.cloud.tmc.integration.event.EventConstants;
import com.transsion.core.log.LogUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class TranssionPoolExecutor extends ThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f44117a;

    /* loaded from: classes5.dex */
    protected class ComparableFutureTask<V> extends FutureTask<V> implements Comparable<ComparableFutureTask<V>> {
        private Object object;

        public ComparableFutureTask(Runnable runnable, V v11) {
            super(runnable, v11);
            this.object = runnable;
        }

        public ComparableFutureTask(Callable<V> callable) {
            super(callable);
            this.object = callable;
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableFutureTask<V> comparableFutureTask) {
            if (this == comparableFutureTask) {
                return 0;
            }
            if (comparableFutureTask == null) {
                return -1;
            }
            Object obj = this.object;
            if (obj != null && comparableFutureTask.object != null && obj.getClass().equals(comparableFutureTask.object.getClass())) {
                Object obj2 = this.object;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(comparableFutureTask.object);
                }
            }
            return 0;
        }
    }

    /* loaded from: classes5.dex */
    private static final class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final String f44118a;

        /* renamed from: b, reason: collision with root package name */
        private final UncaughtThrowableStrategy f44119b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f44120c;

        /* renamed from: d, reason: collision with root package name */
        private int f44121d;

        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z10) {
            this.f44118a = str;
            this.f44119b = uncaughtThrowableStrategy;
            this.f44120c = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "zero-" + this.f44118a + "-thread-" + this.f44121d) { // from class: com.transsion.core.pool.TranssionPoolExecutor.DefaultThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    if (DefaultThreadFactory.this.f44120c) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th2) {
                        DefaultThreadFactory.this.f44119b.handle(th2);
                    }
                }
            };
            this.f44121d = this.f44121d + 1;
            return thread;
        }
    }

    /* loaded from: classes5.dex */
    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG { // from class: com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy
            protected void handle(Throwable th2) {
                LogUtils.d("ZeroPoolExecutor", "Request threw uncaught throwable", th2);
            }
        },
        THROW { // from class: com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy.2
            @Override // com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy
            protected void handle(Throwable th2) {
                super.handle(th2);
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        };

        public static final UncaughtThrowableStrategy DEFAULT = LOG;

        /* synthetic */ UncaughtThrowableStrategy(a aVar) {
            this();
        }

        protected void handle(Throwable th2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Pattern f44122a;

        a(Pattern pattern) {
            this.f44122a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f44122a.matcher(str).matches();
        }
    }

    public TranssionPoolExecutor(int i11, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z10, boolean z11) {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, z10));
        this.f44117a = z11;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("size is :");
            sb2.append(getPoolSize());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static int a() {
        File[] fileArr;
        try {
            fileArr = new File("/sys/devices/system/cpu/").listFiles(new a(Pattern.compile("cpu[0-9]+")));
        } catch (Throwable th2) {
            LogUtils.d("ZeroPoolExecutor", "Failed to calculate accurate cpu count", th2);
            fileArr = null;
        }
        return Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), fileArr != null ? fileArr.length : 0));
    }

    private Future b(Future future) {
        if (this.f44117a) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e11) {
                throw new RuntimeException(e11);
            }
        }
        return future;
    }

    public static TranssionPoolExecutor c() {
        return d(a(), EventConstants.KEY_SOURCE, UncaughtThrowableStrategy.DEFAULT);
    }

    public static TranssionPoolExecutor d(int i11, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new TranssionPoolExecutor(i11, str, uncaughtThrowableStrategy, false, false);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.f44117a) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new ComparableFutureTask(runnable, obj);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected RunnableFuture newTaskFor(Callable callable) {
        return new ComparableFutureTask(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return b(super.submit(runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return b(super.submit(runnable, obj));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return b(super.submit(callable));
    }
}
